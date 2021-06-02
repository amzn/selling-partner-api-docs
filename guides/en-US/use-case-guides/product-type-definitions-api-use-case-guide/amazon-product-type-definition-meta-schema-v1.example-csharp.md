# Example Validator Implementation for .NET

For C# .NET applications, the [Newtonsoft Json.NET Schema](https://www.newtonsoft.com/jsonschema) library supports JSON Schema Draft 2019-09 and custom vocabularies. The following example demonstrates how to utilize the [Newtonsoft Json.NET Schema](https://www.newtonsoft.com/jsonschema) library to validate payloads with instances of the *Amazon Product Type Definition Meta-Schema*. There is no requirement to use this specific library or the example implementation. Amazon does not provide technical support for third-party JSON Schema libraries and this is provided as an example only.

## Schema Configuration

When using the [Newtonsoft Json.NET Schema](https://www.newtonsoft.com/jsonschema) to validate instances of the *Amazon Product Type Definition Meta-Schema* with custom vocabulary, the meta-schema is configured with a `JSchemaResolver` and custom keyword validation is configured with `JSchemaReaderSettings` when parsing instances of the *Amazon Product Type Definition Meta-Schema*.

**Constants**:

```csharp
// $id of the Amazon Product Type Definition Meta-Schema.
var schemaId = "https://schemas.amazon.com/selling-partners/definitions/product-types/meta-schema/v1";

// Local copy of the Amazon Product Type Definition Meta-Schema.
var metaSchemaPath = "./amazon-product-type-definition-meta-schema-v1.json";

// Local copy of an instance of the Amazon Product Type Definition Meta-Schema.
var luggageSchemaPath = "./luggage.json";
```

**Configure Meta-Schema**:

```csharp
// Schema resolver that uses local copies of schemas rather than retrieving them from the web.
var resolver = new JSchemaPreloadedResolver();

// Add the meta-schema to the resolver.
resolver.Add(new Uri(schemaId), File.ReadAllText(metaSchemaPath));

// Configure reader settings with resolver and keyword validators to use when parsing instances of the meta-schema.
var readerSettings = new JSchemaReaderSettings
    {
        Resolver = resolver,
        Validators = new List<JsonValidator>
        {
            new MaxUniqueItemsKeywordValidator(),
            new MaxUtf8ByteLengthKeywordValidator(),
            new MinUtf8ByteLengthKeywordValidator()
        }
    };
```

**Load Meta-Schema Instance**:

```csharp
var luggageSchema = JSchema.Parse(File.ReadAllText(luggageSchemaPath), readerSettings);
```

## Payload Validation

With an instance of the *Amazon Product Type Definition Meta-Schema* loaded as a `JSchema` instance, payloads can be validated using the instance.

```csharp
// Create a JObject for the payload (this can be constructed in code, read from a file, etc.).
var payload = JObject.Parse(File.ReadAllText("./payload.json"));

// Validate the payload and get any resulting validation messages.
var valid = payload.IsValid(luggageSchema, out IList<string> errorMessages);
```

If the payload is valid, `IsValid` will return `true` with an empty list of error messages. Otherwise `IsValid` will return `false` with a list of error messages.

## Keyword Validation

The [Newtonsoft Json.NET Schema](https://www.newtonsoft.com/jsonschema) supports validating custom vocabulary by using classes that implementing the `JsonValidator` interface and provide the validation logic.

See [https://www.newtonsoft.com/jsonschema/help/html/CustomJsonValidators.htm](https://www.newtonsoft.com/jsonschema/help/html/CustomJsonValidators.htm).

The following examples illustrate implementations of the `JsonValidator ` interface that validate the custom vocabulary in instances of the *Amazon Product Type Definition Meta-Schema*.

### `MaxUniqueItemsKeyword` Class

```csharp
using System.Collections.Generic;
using System.Linq;
using Newtonsoft.Json.Linq;
using Newtonsoft.Json.Schema;

namespace AmazonProductTypeSchemaValidator
{
    /**
     * Example validator for the "maxUniqueItems" keyword.
     */
    public class MaxUniqueItemsKeywordValidator : JsonValidator
    {
        public override void Validate(JToken value, JsonValidatorContext context)
        {
            var maxUniqueItems = GetMaxUniqueItems(context.Schema);
            
            // Get the selector properties configured on the scheme element, if they exist. Otherwise, this validator
            // defaults to using all properties.
            var selectors = GetSelectors(context.Schema);

            // Only process if the value is an array with values.
            if (value.Type != JTokenType.Array) return;
            
            // Create a property-value dictionary of each items properties (selectors) and count the number of
            // occurrences for each combination.
            var uniqueItemCounts = new Dictionary<IDictionary<string, string>, int>(new UniqueKeyComparer());
            foreach (var instance in value)
            {
                // Only process instances in the array that are objects.
                if (instance.Type != JTokenType.Object) continue;

                var instanceObject = JObject.FromObject(instance);
                var uniqueKeys = instanceObject.Properties()
                    .Where(property => selectors.Count == 0 || selectors.Contains(property.Name))
                    .ToDictionary(property => property.Name, property => property.Value.ToString());

                var count = uniqueItemCounts.GetValueOrDefault(uniqueKeys, 0) + 1;
                uniqueItemCounts[uniqueKeys] = count;
            }
            
            // Find first selector combination with too many instances.
            var (uniqueKey, itemCount) = uniqueItemCounts.FirstOrDefault(entry => entry.Value > maxUniqueItems);
            if (itemCount > 0)
            {
                var selectorValues = string.Join(", ", uniqueKey.Select(keyValuePair => $"{keyValuePair.Key}={keyValuePair.Value}").ToList());
                context.RaiseError($"Each combination of selector values may only occur {maxUniqueItems} times. " +
                                   $"The following selector value combination occurs too many times: {{{selectorValues}}}");
            }
        }

        public override bool CanValidate(JSchema schema)
        {
            return GetMaxUniqueItems(schema) >= 0;
        }

        private static IList<string> GetSelectors(JSchema schema)
        {
            var selectors = new List<string>();
            
            var schemaObject = JObject.FromObject(schema);
            var selectorsProperty = schemaObject["selectors"];

            if (selectorsProperty.HasValues)
                selectors.AddRange(selectorsProperty.Select(selector => selector.ToString()));

            return selectors;
        }

        private static int GetMaxUniqueItems(JSchema schema)
        {
            var schemaObject = JObject.FromObject(schema);
            var maxUniqueItemsProperty = schemaObject["maxUniqueItems"];

            if (maxUniqueItemsProperty != null && int.TryParse(maxUniqueItemsProperty.ToString(), out var maxUniqueItems))
                return maxUniqueItems;

            return -1;
        }

        /**
         * "Deep" comparator for unique keys dictionary to enable use as a dictionary key.
         */
        private class UniqueKeyComparer : IEqualityComparer<IDictionary<string, string>>
        {
            public bool Equals(IDictionary<string, string> x, IDictionary<string, string> y)
            {
                return x.Count == y.Count 
                       && x.Aggregate(true, (current, keyValuePair) => current && keyValuePair.Value == y[keyValuePair.Key]);
            }

            public int GetHashCode(IDictionary<string, string> obj)
            {
                return ("Keys_" + string.Join(",", obj.Select(o => o.Key))
                        + "_Values_" + string.Join(",", obj.Select(o => o.Value))).GetHashCode();
            }
        }
    }
}
```

### `MaxUtf8ByteLengthKeyword` Class

```csharp
using System.Text;
using Newtonsoft.Json.Linq;
using Newtonsoft.Json.Schema;

namespace AmazonProductTypeSchemaValidator
{
    /**
     * Example validator for the "maxUtf8ByteLength" keyword.
     */
    public class MaxUtf8ByteLengthKeywordValidator : JsonValidator
    {
        public override void Validate(JToken value, JsonValidatorContext context)
        {
            var maxUtf8ByteLength = GetMaxUtf8ByteLength(context.Schema);
            if (Encoding.UTF8.GetBytes(value.ToString()).Length > maxUtf8ByteLength)
                context.RaiseError($"Value must be less than or equal {maxUtf8ByteLength} bytes in length.");
        }

        public override bool CanValidate(JSchema schema)
        {
            return GetMaxUtf8ByteLength(schema) >= 0;
        }

        private static int GetMaxUtf8ByteLength(JSchema schema)
        {
            var schemaObject = JObject.FromObject(schema);
            var byteLengthProperty = schemaObject["maxUtf8ByteLength"];

            if (byteLengthProperty != null && int.TryParse(byteLengthProperty.ToString(), out var maxUtf8ByteLength))
                return maxUtf8ByteLength;

            return -1;
        }
    }
}
```

### `MinUtf8ByteLengthKeyword` Class

```csharp
using System.Text;
using Newtonsoft.Json.Linq;
using Newtonsoft.Json.Schema;

namespace AmazonProductTypeSchemaValidator
{
    /**
     * Example validator for the "minUtf8ByteLength" keyword.
     */
    public class MinUtf8ByteLengthKeywordValidator : JsonValidator
    {
        public override void Validate(JToken value, JsonValidatorContext context)
        {
            var minUtf8ByteLength = GetMinUtf8ByteLength(context.Schema);
            if (Encoding.UTF8.GetBytes(value.ToString()).Length < minUtf8ByteLength)
                context.RaiseError($"Value must be greater than or equal {minUtf8ByteLength} bytes in length.");
        }

        public override bool CanValidate(JSchema schema)
        {
            return GetMinUtf8ByteLength(schema) >= 0;
        }

        private static int GetMinUtf8ByteLength(JSchema schema)
        {
            var schemaObject = JObject.FromObject(schema);
            var byteLengthProperty = schemaObject["minUtf8ByteLength"];

            if (byteLengthProperty != null && int.TryParse(byteLengthProperty.ToString(), out var minUtf8ByteLength))
                return minUtf8ByteLength;

            return -1;
        }
    }
}
```
