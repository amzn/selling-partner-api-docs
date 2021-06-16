# Amazon Product Type Definition Meta-Schema (v1)

The *Amazon Product Type Definition Meta-Schema* is an extension of [JSON Schema Draft 2019-09](https://json-schema.org/draft/2019-09/json-schema-core.html) that describes the properties and requirements for an Amazon Product Type, such as `LUGGAGE`.

**Schema URI**: **`https://schemas.amazon.com/selling-partners/definitions/product-types/meta-schema/v1`**

**Vocabulary URI**: **`https://schemas.amazon.com/selling-partners/definitions/product-types/vocabulary/v1`**

Instances of the *Amazon Product Type Definition Meta-Schema* can utilize any of the keywords and vocabularies supported by [JSON Schema Draft 2019-09](https://json-schema.org/draft/2019-09/json-schema-core.html). See [https://json-schema.org/specification.html](https://json-schema.org/specification.html) for more details.

In addition to standard [JSON Schema Draft 2019-09](https://json-schema.org/draft/2019-09/json-schema-core.html) vocabularies, instances of the *Amazon Product Type Definition Meta-Schema* utilize keywords defined as custom vocabulary in the meta-schema. This documentation outlines the custom vocabulary for the `https://schemas.amazon.com/selling-partners/definitions/product-types/vocabulary/v1` URI.

Consumers of *Amazon Product Type Definition Meta-Schema* instances may choose to ignore custom vocabulary and use only the standard [JSON Schema Draft 2019-09](https://json-schema.org/draft/2019-09/json-schema-core.html) vocabularies. Doing so will validate most requirements of an Amazon Product Type, but may result is some validation errors upon submission.

## Vocabulary

### `editable`

* **Type**: `boolean`
* **Purpose**: Informational
* **Description**: The `editable` keyword indicates whether or not a property value can be changed for an existing item. Properties that are non-editable may still be required for a valid submission but cannot change from their original value.

### `enumNames`

* **Type**: `array`
* **Purpose**: Informational
* **Description**: The `enumNames` keyword contains an array of display labels for a corresponding array of `enum` values. The display labels in the `enumNames` array are in the same order as the values in the `enum` array.

### `hidden`

* **Type**: `boolean`
* **Purpose**: Informational
* **Description**: The `hidden` keyword suggests whether or not a property should be hidden in Amazon user interfaces. Hiding or displaying these properties is at the discretion of the application consuming the *Amazon Product Type Definition Meta-Schema*.

### `maxUniqueItems`

* **Type**: `integer`
* **Purpose**: Validation
* **Description**: In conjunction with the `selectors` keyword, the `maxUniqueItems` keyword value defines the maximum number of unique items in an array.

### `minUniqueItems`

* **Type**: `integer`
* **Purpose**: Validation
* **Description**: In conjunction with the `selectors` keyword, the `minUniqueItems` keyword value defines the minimum number of unique items in an array.

### `maxUtf8ByteLength`

* **Type**: `integer`
* **Purpose**: Validation
* **Description**: The `maxUtf8ByteLength` keyword value defines the maximum length of a `string` value measured in UTF-8 bytes.

### `minUtf8ByteLength`

* **Type**: `integer`
* **Purpose**: Validation
* **Description**: The `minUtf8ByteLength` keyword value defines the minimum length of a `string` value measured in UTF-8 bytes.

### `selectors`

* **Type**: `array`
* **Purpose**: Validation
* **Description**: The `selectors` keyword contains an array of property names that define the combination of properties that make an object unique. By default, JSON Schema determines uniqueness of objects in an array based an all properties of the object. When `selectors` are defined, only the specified properties are used to determine uniqueness.

## Example Validator Implementations

[JSON Schema](https://json-schema.org) is a vocabulary that allows you to annotate and validate JSON documents. The authors of JSON Schema do not vend specific tooling for validating documents with JSON Schema, rather JSON Schema defines how tooling should validate documents with JSON Schema.

There are multiple paid and open-source applications and libraries that support JSON Schema, see [https://json-schema.org/implementations.html](https://json-schema.org/implementations.html) for a list of known implementation.

The following reference validator implementations provide examples of how to validate custom vocabulary for instances of *Amazon Product Type Definition Meta-Schema* using language-specific open-source libraries. There is no requirement to use these specific libraries or the example implementations. Amazon does not provide technical support for third-party JSON Schema libraries and these are provided as examples only.

### .NET

For C# .NET applications, the [Newtonsoft Json.NET Schema](https://www.newtonsoft.com/jsonschema) library supports JSON Schema Draft 2019-09 and custom vocabularies. The following example demonstrates how to utilize the [Newtonsoft Json.NET Schema](https://www.newtonsoft.com/jsonschema) library to validate payloads with instances of the *Amazon Product Type Definition Meta-Schema*.

[Example Validator Implementation for .NET](amazon-product-type-definition-meta-schema-v1.example-csharp.md)

### Java

For Java applications, the [networknt/json-schema-validator](https://github.com/networknt/json-schema-validator) library supports JSON Schema Draft 2019-09 and custom vocabularies. The following example demonstrates how to utilize the [networknt/json-schema-validator](https://github.com/networknt/json-schema-validator) library to validate payloads with instances of the *Amazon Product Type Definition Meta-Schema*.

[Example Validator Implementation for Java](amazon-product-type-definition-meta-schema-v1.example-java.md)

### JavaScript

For JavaScript applications (including Node.js), the [hyperjump-io/json-schema-validator](https://github.com/hyperjump-io/json-schema-validator) library supports JSON Schema Draft 2019-09 and custom vocabularies. The following example demonstrates how to utilize the [hyperjump-io/json-schema-validator](https://github.com/hyperjump-io/json-schema-validator) library to validate payloads with instances of the *Amazon Product Type Definition Meta-Schema*.

[Example Validator Implementation for JavaScript](amazon-product-type-definition-meta-schema-v1.example-javascript.md)