# Example Validator Implementation for Java

For Java applications, the [networknt/json-schema-validator](https://github.com/networknt/json-schema-validator) library supports JSON Schema Draft 2019-09 and custom vocabularies. The following example demonstrates how to utilize the [networknt/json-schema-validator](https://github.com/networknt/json-schema-validator) library to validate payloads with instances of the *Amazon Product Type Definition Meta-Schema*. There is no requirement to use this specific library or the example implementation. Amazon does not provide technical support for third-party JSON Schema libraries and this is provided as an example only.

## Schema Configuration

When using the [networknt/json-schema-validator](https://github.com/networknt/json-schema-validator) to validate instances of the *Amazon Product Type Definition Meta-Schema* with custom vocabulary, the meta-schema is configured as part of the `JsonSchemaFactory`.

**Constants**:

```java
// $id of the Amazon Product Type Definition Meta-Schema.
String schemaId = "https://schemas.amazon.com/selling-partners/definitions/product-types/meta-schema/v1";

// Local copy of the Amazon Product Type Definition Meta-Schema.
String metaSchemaPath = "./amazon-product-type-definition-meta-schema-v1.json";

// Local copy of an instance of the Amazon Product Type Definition Meta-Schema.
String luggageSchemaPath = "./luggage.json";

// Keywords that are informational only and do not require validation.
List<String> nonValidatingKeywords = ImmutableList.of("editable", "enumNames");
```

**Configure Meta-Schema**:

```java
// Standard JSON Schema 2019-09 that Amazon Product Type Definition Meta-Schema extends from.
JsonMetaSchema standardMetaSchema = JsonMetaSchema.getV201909();

// Build Amazon Product Type Definition Meta Schema with the standard JSON Schema 2019-09 as the blueprint.
// Register custom keyword validation classes (see below).
JsonMetaSchema metaSchema = JsonMetaSchema.builder(SCHEMA_ID, standardMetaSchema)
    .addKeywords(NON_VALIDATING_KEYWORDS.stream().map(NonValidationKeyword::new)
        .collect(Collectors.toSet()))
    .addKeyword(new MaxUniqueItemsKeyword())
    .addKeyword(new MaxUtf8ByteLengthKeyword())
    .addKeyword(new MinUtf8ByteLengthKeyword())
    .build();
```

**Build JsonSchemaFactory**:

```java
// URIFetcher to route meta-schema references to local copy.
URIFetcher uriFetcher = uri -> {
    // Use the local copy of the meta-schema instead of retrieving from the web.
    if (schemaId.equalsIgnoreCase(uri.toString())) {
        return Files.newInputStream(Paths.get(metaSchemaPath));
    }

    // Default to the existing fetcher for other schemas.
    return new URLFetcher().fetch(uri);
};

// Build the JsonSchemaFactory.
JsonSchemaFactory schemaFactory = new JsonSchemaFactory.Builder()
    .defaultMetaSchemaURI(schemaId)
    .addMetaSchema(standardMetaSchema)
    .addMetaSchema(metaSchema)
    .uriFetcher(uriFetcher, "https")
    .build();
    
// Create the JsonSchema instance.
JsonSchema luggageSchema = schemaFactory.getSchema(new String(Files.readAllBytes(Paths.get(luggageSchemaPath))));
```

## Payload Validation

With an instance of the *Amazon Product Type Definition Meta-Schema* loaded as a `JsonSchema` instance, payloads can be validated using the instance.

```java
// Create a JsonNode for the payload (this can be constructed in code, read from a file, etc.).
JsonNode payload = new ObjectMapper().readValue(new File("./payload.json"), JsonNode.class);

// Validate the payload and get any resulting validation messages.
Set<ValidationMessage> messages = luggageSchema.validate(payload);
```

If no validation messages are returned, validation passed. Otherwise, inspect the validation messages to identify errors with the payload.

## Keyword Validation

The [networknt/json-schema-validator](https://github.com/networknt/json-schema-validator) supports validating custom vocabulary by using classes that extend the `AbstractKeyword` class and provide the validation logic.

See [https://github.com/networknt/json-schema-validator/blob/master/doc/validators.md](https://github.com/networknt/json-schema-validator/blob/master/doc/validators.md).

The following examples illustrate extensions of the `AbstractKeyword` class that validate the custom vocabulary in instances of the *Amazon Product Type Definition Meta-Schema*.

### `MaxUniqueItemsKeyword` Class

```java
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.collect.Streams;
import com.networknt.schema.AbstractJsonValidator;
import com.networknt.schema.AbstractKeyword;
import com.networknt.schema.CustomErrorMessageType;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonValidator;
import com.networknt.schema.ValidationContext;
import com.networknt.schema.ValidationMessage;
import org.apache.commons.lang3.StringUtils;

import java.text.MessageFormat;
import java.util.Iterator;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Example validator for the "maxUniqueItems" keyword.
 */
public class MaxUniqueItemsKeyword extends AbstractKeyword {

    private static final MessageFormat ERROR_MESSAGE_FORMAT = new MessageFormat("Each combination of selector "
            + "values may only occur {1} times. The following selector value combination occurs too many times: {2}");

    private static final String KEYWORD = "maxUniqueItems";
    private static final String SELECTORS = "selectors";

    public MaxUniqueItemsKeyword() {
        super(KEYWORD);
    }

    @Override
    public JsonValidator newValidator(String schemaPath, JsonNode schemaNode, JsonSchema parentSchema,
            ValidationContext validationContext) {
            
        // Only process if the provided schema value is a number.
        if (!JsonNodeType.NUMBER.equals(schemaNode.getNodeType())) {
            return null;
        }

        int maxUniqueItems = schemaNode.asInt();

        // Get the selector properties configured on the scheme element, if they exist. Otherwise, this validator
        // defaults to using all properties.
        Set<String> selectors = getSelectorProperties(parentSchema);

        return new AbstractJsonValidator(this.getValue()) {
        
            @Override
            public Set<ValidationMessage> validate(JsonNode node, JsonNode rootNode, String at) {
            
                // Only process if the node is an array, as selectors and unique items do not apply to other data
                // types.
                if (node.isArray()) {
                
                    // Create a property-value map of each items properties (selectors) and count the number of
                    // occurrences for each combination.
                    Map<Map<String, String>, Integer> uniqueItemCounts = Maps.newHashMap();
                    
                    node.forEach(instance -> {
                    
                        // Only process instances that are objects.
                        if (instance.isObject()) {
                            Map<String, String> uniqueKeys = Maps.newHashMap();

                            Iterator<Map.Entry<String, JsonNode>> fieldIterator = instance.fields();
                            while (fieldIterator.hasNext()) {
                                Map.Entry<String, JsonNode> entry = fieldIterator.next();
                                // If no selectors are configured, always add. Otherwise only add if the property is
                                // a selector.
                                if (selectors.isEmpty() || selectors.contains(entry.getKey())) {
                                    uniqueKeys.put(entry.getKey(), entry.getValue().asText());
                                }
                            }

                            // Iterate count and put in counts map.
                            int count = uniqueItemCounts.getOrDefault(uniqueKeys, 0) + 1;
                            uniqueItemCounts.put(uniqueKeys, count);
                        }
                    });

                    // Find first selector combination with too many instances.
                    Optional<Map<String, String>> uniqueKeysWithTooManyItems = uniqueItemCounts.entrySet()
                            .stream().filter(entry -> entry.getValue() > maxUniqueItems).map(Map.Entry::getKey)
                            .findFirst();

                    // Return a failed validation if a selector combination has too many instances.
                    if (uniqueKeysWithTooManyItems.isPresent()) {
                        return fail(CustomErrorMessageType.of(KEYWORD, ERROR_MESSAGE_FORMAT), at,
                                Integer.toString(maxUniqueItems), uniqueKeysWithTooManyItems.get().toString());
                    }
                }

                return pass();
            }
        };
    }

    private Set<String> getSelectorProperties(JsonSchema parentSchema) {
        if (parentSchema.getSchemaNode().has(SELECTORS) && parentSchema.getSchemaNode().get(SELECTORS).isArray()) {
            return Streams.stream(parentSchema.getSchemaNode().get(SELECTORS)).map(JsonNode::asText)
                    .filter(StringUtils::isNotBlank).collect(Collectors.toSet());
        }
        return Sets.newHashSet();
    }
}
```

### `MaxUtf8ByteLengthKeyword` Class

```java
package com.amazon.spucs.tests.keywords;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.networknt.schema.AbstractJsonValidator;
import com.networknt.schema.AbstractKeyword;
import com.networknt.schema.CustomErrorMessageType;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonValidator;
import com.networknt.schema.ValidationContext;
import com.networknt.schema.ValidationMessage;

import java.nio.charset.StandardCharsets;
import java.text.MessageFormat;
import java.util.Set;

/**
 * Example validator for the "maxUtf8ByteLength" keyword.
 */
public class MaxUtf8ByteLengthKeyword  extends AbstractKeyword {

    private static final MessageFormat ERROR_MESSAGE_FORMAT =
            new MessageFormat("Value must be less than or equal {1} bytes in length.");

    private static final String KEYWORD = "maxUtf8ByteLength";

    public MaxUtf8ByteLengthKeyword() {
        super(KEYWORD);
    }

    @Override
    public JsonValidator newValidator(String schemaPath, JsonNode schemaNode, JsonSchema parentSchema,
            ValidationContext validationContext) {
            
        // Only process if the provided schema value is a number.
        if (!JsonNodeType.NUMBER.equals(schemaNode.getNodeType())) {
            return null;
        }

        int maxUtf8ByteLength = schemaNode.asInt();

        return new AbstractJsonValidator(this.getValue()) {
        
            @Override
            public Set<ValidationMessage> validate(JsonNode node, JsonNode rootNode, String at) {
            
                // Get the value as a string and evaluate its length in bytes.
                String value = node.asText();
                if (value.getBytes(StandardCharsets.UTF_8).length > maxUtf8ByteLength) {
                    return fail(CustomErrorMessageType.of(KEYWORD, ERROR_MESSAGE_FORMAT), at,
                            Integer.toString(maxUtf8ByteLength));
                }
                return pass();
            }
        };
    }
}

```

### `MinUtf8ByteLengthKeyword` Class

```java
package com.amazon.spucs.tests.keywords;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.networknt.schema.AbstractJsonValidator;
import com.networknt.schema.AbstractKeyword;
import com.networknt.schema.CustomErrorMessageType;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonValidator;
import com.networknt.schema.ValidationContext;
import com.networknt.schema.ValidationMessage;

import java.nio.charset.StandardCharsets;
import java.text.MessageFormat;
import java.util.Set;

/**
 * Example validator for the "minUtf8ByteLength" keyword.
 */
public class MinUtf8ByteLengthKeyword extends AbstractKeyword {

    private static final MessageFormat ERROR_MESSAGE_FORMAT =
            new MessageFormat("Value must be greater than or equal {1} bytes in length.");

    private static final String KEYWORD = "minUtf8ByteLength";

    public MinUtf8ByteLengthKeyword() {
        super(KEYWORD);
    }

    @Override
    public JsonValidator newValidator(String schemaPath, JsonNode schemaNode, JsonSchema parentSchema,
            ValidationContext validationContext) {
        // Only process if the provided schema value is a number.
        if (!JsonNodeType.NUMBER.equals(schemaNode.getNodeType())) {
            return null;
        }

        int minUtf8ByteLength = schemaNode.asInt();

        return new AbstractJsonValidator(this.getValue()) {
        
            @Override
            public Set<ValidationMessage> validate(JsonNode node, JsonNode rootNode, String at) {
            
                // Get the value as a string and evaluate its length in bytes.
                String value = node.asText();
                if (value.getBytes(StandardCharsets.UTF_8).length < minUtf8ByteLength) {
                    return fail(CustomErrorMessageType.of(KEYWORD, ERROR_MESSAGE_FORMAT), at,
                            Integer.toString(minUtf8ByteLength));
                }
                return pass();
            }
        };
    }
}
```