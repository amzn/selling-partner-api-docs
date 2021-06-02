# Example Validator Implementation for Javascript

For JavaScript applications, the [Hyperjump - JSON Schema Validator](https://github.com/hyperjump-io/json-schema-validator) library supports JSON Schema Draft 2019-09 and custom vocabularies. The following example uses Node.js to demonstrate how to utilize the [Hyperjump - JSON Schema Validator](https://github.com/hyperjump-io/json-schema-validator) library to validate payloads with instances of the *Amazon Product Type Definition Meta-Schema*. The following example code will not work in a web browser, however, the library does not have dependencies on Node.js and can be used in a web browser. There is no requirement to use this specific library or the example implementation. Amazon does not provide technical support for third-party JSON Schema libraries and this is provided as an example only.

## Schema Configuration

When using the [Hyperjump - JSON Schema Validator](https://github.com/hyperjump-io/json-schema-validator) to validate instances of the *Amazon Product Type Definition Meta-Schema* with custom vocabulary, the meta-schema is configured as a `JsonSchema` instance with custom vocabulary keyword validation registered in the [Hyperjump - JSON Schema Core](https://github.com/hyperjump-io/json-schema-core).

**Constants**:

```JavaScript
// $id of the Amazon Product Type Definition Meta-Schema.
const schemaId = "https://schemas.amazon.com/selling-partners/definitions/product-types/meta-schema/v1";
// $id of the Amazon Product Type Definition Luggage-Schema.
const luggageSchemaId = "https://schemas.amazon.com/selling-partners/definitions/product-types/schema/v1/LUGGAGE";

// Local copy of the Amazon Product Type Definition Meta-Schema.
const metaSchemaPath = "./amazon-product-type-definition-meta-schema-v1.json";

// Local copy of an instance of the Amazon Product Type Definition Meta-Schema.
const luggageSchemaPath = "./luggage.json";
```

**Configure Meta-Schema**:

```JavaScript
// Add custom vocabulary and keywords
const { Core, Schema } = require("@hyperjump/json-schema-core");
const maxUniqueItemsKeyword = require("./keywords/MaxUniqueItemsKeyword.js");
const maxUtf8ByteLengthKeyword = require("./keywords/MaxUtf8ByteLengthKeyword.js");
const minUtf8ByteLengthKeyword = require("./keywords/MinUtf8ByteLengthKeyword.js");
const customVocabularyId = "https://schemas.amazon.com/selling-partners/definitions/product-types/vocabulary/v1";

// Configure $vocabulary defined in the schema JSON as vocabularyToken
Schema.setConfig(schemaId, "vocabularyToken", "$vocabulary");

// Add custom vocabulary and keywords
Core.defineVocabulary(customVocabularyId, {
    maxUniqueItems : maxUniqueItemsKeyword,
    minUtf8ByteLength : minUtf8ByteLengthKeyword,
    maxUtf8ByteLength : maxUtf8ByteLengthKeyword
});

// Add local schema JSON in JsonSchema.add() to use local copies of schemas rather than retrieving them from the web.
const JsonSchema = require("@hyperjump/json-schema");

// Add meta schema
const metaSchemaJSON = JSON.parse(fs.readFileSync(metaSchemaPath), "utf8");
JsonSchema.add(metaSchemaJSON, schemaId);

// Add luggage schema
const luggageSchemaJSON = JSON.parse(fs.readFileSync(luggageSchemaPath), "utf8");
JsonSchema.add(luggageSchemaJSON, luggageSchemaId, schemaId);
```

**Load Meta-Schema Instance**:

```JavaScript
// Retrieve previously added luggage schema from JsonSchema instance
var luggageSchema = await JsonSchema.get(luggageSchemaId);
```

## Payload Validation

With an instance of the *Amazon Product Type Definition Meta-Schema* loaded as a `JsonSchema` instance, payloads can be validated using the instance.

```JavaScript
// Load JSON for the payload (this can be constructed in code, read from a file, etc.).
const payload = JSON.parse(fs.readFileSync("./payload.json"), "utf8");

// Validate the payload and get validation result.
const result = await JsonSchema.validate(luggageSchema, payload, JsonSchema.BASIC);
const isValid = result.valid;
```

If the payload is valid, `isValid` will return `true` with an empty list of error keywords. Otherwise `isValid` will return `false` with a list of error keywords.

**Example Validation Message**:
```JavaScript

{
    keyword: 'https://schemas.amazon.com/selling-partners/definitions/product-types/meta-schema/v1#minUtf8ByteLength',
    absoluteKeywordLocation: 'https://schemas.amazon.com/selling-partners/definitions/product-types/schema/v1/LUGGAGE#/properties/contribution_sku/items/properties/value/minUtf8ByteLength',
    instanceLocation: '#/contribution_sku/0/value',
    valid: false
}
```

## Keyword Validation

The [Hyperjump - JSON Schema Core](https://github.com/hyperjump-io/json-schema-core) provides a framework that can be used to validate custom vocabulary, keywords, and other tools.

The following examples illustrate implementations of the `JsonSchema` that validate the custom vocabulary in instances of the *Amazon Product Type Definition Meta-Schema*.

### `MaxUniqueItemsKeyword` script

```JavaScript
const { Schema, Instance} = require("@hyperjump/json-schema-core");

const compile = (schema, ast, parentSchema) =>
{
    const maxUniqueItems = Schema.value(schema);
    // Retrieve the selectors defined in meta-schema
    const selectors = parentSchema.value.selectors;
    return [maxUniqueItems, selectors];
}

const interpret = ([maxUniqueItems, selectors], instance, ast) => {
    if (!Instance.typeOf(instance, "array")) {
        return false;
    }

    let uniqueItems = new Array();
    // For each instance in the example schema retrieve selectors combinations
    instance.value.forEach(inst => {
        let selectorCombination = {};
        Object.entries(inst).forEach(([key,value]) => {
            if(selectors != undefined && selectors.includes(key)) {
                selectorCombination[key] = value;
            }});
        uniqueItems.push(JSON.stringify(selectorCombination));
    });

    let countMap = new Map();
    // Add count of each unique selector combination in countMap
    uniqueItems.forEach(item => {
        countMap.get(item) != undefined ? countMap.set(item, countMap.get(item)+ 1): countMap.set(item, 1);
    });
    // Filter the countMap for values greater than maxUniqueItems
    let filteredItems = Array.from(countMap.entries()).filter(item => {
        return item[1] > maxUniqueItems;
    });
    // If filteredItems found then validation fails, else succeeds
    return filteredItems.length > 0 ? false : true;
};

module.exports = { compile, interpret };
```

### `MaxUtf8ByteLengthKeyword` script

```JavaScript
const { Schema, Instance} = require("@hyperjump/json-schema-core");

const compile = (schema, ast) => Schema.value(schema);

const interpret = (maxUtf8ByteLength, instance, ast) =>  Instance.typeOf(instance, "string") &&
    Buffer.byteLength(Instance.value(instance)) <= maxUtf8ByteLength;

module.exports = { compile, interpret };
```

### `MinUtf8ByteLengthKeyword` script

```JavaScript
const { Schema, Instance} = require("@hyperjump/json-schema-core");

const compile = (schema, ast) => Schema.value(schema);

const interpret = (minUtf8ByteLength, instance, ast) =>
    Instance.typeOf(instance, "string") && Buffer.byteLength(Instance.value(instance)) >= minUtf8ByteLength;

module.exports = { compile, interpret };
```