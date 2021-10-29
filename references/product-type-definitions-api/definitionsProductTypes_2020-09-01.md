# Selling Partner API for Product Type Definitions


<a name="overview"></a>
## Overview
The Selling Partner API for Product Type Definitions provides programmatic access to attribute and data requirements for product types in the Amazon catalog. Use this API to return the JSON Schema for a product type that you can then use with other Selling Partner APIs, such as the Selling Partner API for Listings Items, the Selling Partner API for Catalog Items, and the Selling Partner API for Feeds (for JSON-based listing feeds).

For more information, see the [Product Type Definitions API Use Case Guide](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/use-case-guides/product-type-definitions-api-use-case-guide/definitions-product-types-api-use-case-guide_2020-09-01.md).


### Version information
*Version* : 2020-09-01


### Contact information
*Contact* : Selling Partner API Developer Support  
*Contact URL* : https://sellercentral.amazon.com/gp/mws/contactus.html  


### License information
*License* : Apache License 2.0  
*License URL* : http://www.apache.org/licenses/LICENSE-2.0  


### URI scheme
*Host* : sellingpartnerapi-na.amazon.com  
*Schemes* : HTTPS


### Consumes

* `application/json`


### Produces

* `application/json`


### Operations
[searchDefinitionsProductTypes](#searchdefinitionsproducttypes)<br>[getDefinitionsProductType](#getdefinitionsproducttype)<br>
<a name="paths"></a>
## Paths

<a name="searchdefinitionsproducttypes"></a>
### GET /definitions/2020-09-01/productTypes
**Operation: searchDefinitionsProductTypes**

#### Description
Search for and return a list of Amazon product types that have definitions available.

**Usage Plans:**

| Plan type | Rate (requests per second) | Burst |
| ---- | ---- | ---- |
|Default| 5 | 10 |
|Selling partner specific| Variable | Variable |

The x-amzn-RateLimit-Limit response header returns the usage plan rate limits that were applied to the requested operation. Rate limits for some selling partners will vary from the default rate and burst shown in the table above. For more information, see [Usage Plans and Rate Limits in the Selling Partner API](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/usage-plans-rate-limits/Usage-Plans-and-Rate-Limits.md).


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Query**|**keywords**  <br>*optional*|A comma-delimited list of keywords to search product types by.|< string > array(csv)|
|**Query**|**marketplaceIds**  <br>*required*|A comma-delimited list of Amazon marketplace identifiers for the request.|< string > array(csv)|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Successfully retrieved a list of Amazon product types that have definitions available.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[ProductTypeList](#producttypelist)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[ErrorList](#errorlist)|

For additional error status codes, descriptions and schemas, see [Error responses and schemas](#error-responses-and-schemas).
#### Consumes

* `application/json`


#### Produces

* `application/json`


<a name="getdefinitionsproducttype"></a>
### GET /definitions/2020-09-01/productTypes/{productType}
**Operation: getDefinitionsProductType**

#### Description
Retrieve an Amazon product type definition.

**Usage Plans:**

| Plan type | Rate (requests per second) | Burst |
| ---- | ---- | ---- |
|Default| 5 | 10 |
|Selling partner specific| Variable | Variable |

The x-amzn-RateLimit-Limit response header returns the usage plan rate limits that were applied to the requested operation. Rate limits for some selling partners will vary from the default rate and burst shown in the table above. For more information, see [Usage Plans and Rate Limits in the Selling Partner API](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/usage-plans-rate-limits/Usage-Plans-and-Rate-Limits.md).


#### Parameters

|Type|Name|Description|Schema|Default|
|---|---|---|---|---|
|**Path**|**productType**  <br>*required*|The Amazon product type name.|string|-|
|**Query**|**sellerId**  <br>*optional*|A selling partner identifier. When provided, seller-specific requirements and values are populated within the product type definition schema, such as brand names associated with the selling partner.|string|-|
|**Query**|**marketplaceIds**  <br>*required*|A comma-delimited list of Amazon marketplace identifiers for the request.<br>Note: This parameter is limited to one marketplaceId at this time.|< string > array(csv)|-|
|**Query**|**productTypeVersion**  <br>*optional*|The version of the Amazon product type to retrieve. Defaults to "LATEST",. Prerelease versions of product type definitions may be retrieved with "RELEASE_CANDIDATE". If no prerelease version is currently available, the "LATEST" live version will be provided.|string|`"LATEST"`|
|**Query**|**requirements**  <br>*optional*|The name of the requirements set to retrieve requirements for.|enum ([Requirements](#requirements-subgroup-2))|`"LISTING"`|
|**Query**|**requirementsEnforced**  <br>*optional*|Identifies if the required attributes for a requirements set are enforced by the product type definition schema. Non-enforced requirements enable structural validation of individual attributes without all the required attributes being present (such as for partial updates).|enum ([RequirementsEnforced](#requirementsenforced-subgroup-2))|`"ENFORCED"`|
|**Query**|**locale**  <br>*optional*|Locale for retrieving display labels and other presentation details. Defaults to the default language of the first marketplace in the request.|enum ([Locale](#locale))|`"DEFAULT"`|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Successfully retrieved an Amazon product type definition.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[ProductTypeDefinition](#producttypedefinition)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[ErrorList](#errorlist)|

For additional error status codes, descriptions and schemas, see [Error responses and schemas](#error-responses-and-schemas).
#### Consumes

* `application/json`


#### Produces

* `application/json`





<a name="error-responses-and-schemas"></a>
### Error Responses and Schemas
This table contains HTTP status codes and associated information for error responses.

|HTTP Code|Description|Schema|
|---|---|---|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers**:  <br>`x-amzn-RateLimit-Limit` (string):Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string):Unique request reference identifier.|[ErrorList](#errorlist)|
|**403**|Indicates that access to the resource is forbidden. Possible reasons include Access Denied, Unauthorized, Expired Token, or Invalid Signature.  <br>**Headers**:  <br>`x-amzn-RequestId` (string):Unique request reference identifier.|[ErrorList](#errorlist)|
|**404**|The resource specified does not exist.  <br>**Headers**:  <br>`x-amzn-RateLimit-Limit` (string):Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string):Unique request reference identifier.|[ErrorList](#errorlist)|
|**413**|The request size exceeded the maximum accepted size.  <br>**Headers**:  <br>`x-amzn-RateLimit-Limit` (string):Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string):Unique request reference identifier.|[ErrorList](#errorlist)|
|**415**|The request payload is in an unsupported format.  <br>**Headers**:  <br>`x-amzn-RateLimit-Limit` (string):Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string):Unique request reference identifier.|[ErrorList](#errorlist)|
|**500**|An unexpected condition occurred that prevented the server from fulfilling the request.  <br>**Headers**:  <br>`x-amzn-RateLimit-Limit` (string):Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string):Unique request reference identifier.|[ErrorList](#errorlist)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers**:  <br>`x-amzn-RateLimit-Limit` (string):Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string):Unique request reference identifier.|[ErrorList](#errorlist)|


<a name="definitions"></a>
## Definitions

<a name="error"></a>
### Error
Error response returned when the request is unsuccessful.


|Name|Description|Schema|
|---|---|---|
|**code**  <br>*required*|An error code that identifies the type of error that occurred.|string|
|**message**  <br>*required*|A message that describes the error condition.|string|
|**details**  <br>*optional*|Additional details that can help the caller understand or fix the issue.|string|


<a name="errorlist"></a>
### ErrorList
A list of error responses returned when a request is unsuccessful.


|Name|Schema|
|---|---|
|**errors**  <br>*required*|< [Error](#error) > array|


<a name="schemalink"></a>
### SchemaLink

|Name|Description|Schema|
|---|---|---|
|**link**  <br>*required*|Link to retrieve the schema.|[link](#schemalink-link)|
|**checksum**  <br>*required*|Checksum hash of the schema (Base64 MD5). Can be used to verify schema contents, identify changes between schema versions, and for caching.|string|

<a name="schemalink-link"></a>
**link**

|Name|Description|Schema|
|---|---|---|
|**resource**  <br>*required*|URI resource for the link.|string|
|**verb**  <br>*required*|HTTP method for the link operation.|enum ([Verb](#verb))|


<a name="producttypedefinition"></a>
### ProductTypeDefinition
A product type definition represents the attributes and data requirements for a product type in the Amazon catalog. Product type definitions are used interchangeably between the Selling Partner API for Listings Items, Selling Partner API for Catalog Items, and JSON-based listings feeds in the Selling Partner API for Feeds.


|Name|Description|Schema|
|---|---|---|
|**metaSchema**  <br>*optional*|Link to meta-schema describing the vocabulary used by the product type schema.|[SchemaLink](#schemalink)|
|**schema**  <br>*required*|Link to schema describing the attributes and requirements for the product type.|[SchemaLink](#schemalink)|
|**requirements**  <br>*required*|Name of the requirements set represented in this product type definition.|enum ([Requirements](#requirements-subgroup-1))|
|**requirementsEnforced**  <br>*required*|Identifies if the required attributes for a requirements set are enforced by the product type definition schema. Non-enforced requirements enable structural validation of individual attributes without all of the required attributes being present (such as for partial updates).|enum ([RequirementsEnforced](#requirementsenforced-subgroup-1))|
|**propertyGroups**  <br>*required*|Mapping of property group names to property groups. Property groups represent logical groupings of schema properties that can be used for display or informational purposes.|< string, [PropertyGroup](#propertygroup) > map|
|**locale**  <br>*required*|Locale of the display elements contained in the product type definition.|string|
|**marketplaceIds**  <br>*required*|Amazon marketplace identifiers for which the product type definition is applicable.|< string > array|
|**productType**  <br>*required*|The name of the Amazon product type that this product type definition applies to.|string|
|**productTypeVersion**  <br>*required*|The version details for the Amazon product type.|[ProductTypeVersion](#producttypeversion)|


<a name="propertygroup"></a>
### PropertyGroup
A property group represents a logical grouping of schema properties that can be used for display or informational purposes.


|Name|Description|Schema|
|---|---|---|
|**title**  <br>*optional*|The display label of the property group.|string|
|**description**  <br>*optional*|The description of the property group.|string|
|**propertyNames**  <br>*optional*|The names of the schema properties for the property group.|< string > array|


<a name="producttypeversion"></a>
### ProductTypeVersion
The version details for an Amazon product type.


|Name|Description|Schema|
|---|---|---|
|**version**  <br>*required*|Version identifier.|string|
|**latest**  <br>*required*|When true, the version indicated by the version identifier is the latest available for the Amazon product type.|boolean|
|**releaseCandidate**  <br>*optional*|When true, the version indicated by the version identifier is the prerelease (release candidate) for the Amazon product type.|boolean|


<a name="producttype"></a>
### ProductType
An Amazon product type with a definition available.


|Name|Description|Schema|
|---|---|---|
|**name**  <br>*required*|The name of the Amazon product type.|string|
|**marketplaceIds**  <br>*required*|The Amazon marketplace identifiers for which the product type definition is available.|< string > array|


<a name="producttypelist"></a>
### ProductTypeList
A list of Amazon product types with definitions available.


|Name|Schema|
|---|---|
|**productTypes**  <br>*required*|< [ProductType](#producttype) > array|


<a name="locale"></a>
### Locale
Locale for retrieving display labels and other presentation details. Defaults to the default language of the first marketplace in the request.

*Type* : enum


|Value|Description|
|---|---|
|**DEFAULT**|Default locale of the requested Amazon marketplace.|
|**ar**|Arabic|
|**ar_AE**|Arabic (U.A.E.)|
|**de**|German|
|**de_DE**|German (Germany)|
|**en**|English|
|**en_AE**|English (U.A.E.)|
|**en_AU**|English (Australia)|
|**en_CA**|English (Canada)|
|**en_GB**|English (United Kingdom)|
|**en_IN**|English (India)|
|**en_SG**|English (Singapore)|
|**en_US**|English (United States)|
|**es**|Spanish|
|**es_ES**|Spanish (Spain)|
|**es_MX**|Spanish (Mexico)|
|**es_US**|Spanish (United States)|
|**fr**|French|
|**fr_CA**|French (Canada)|
|**fr_FR**|French (France)|
|**it**|Italian|
|**it_IT**|Italian (Italy)|
|**ja**|Japanese|
|**ja_JP**|Japanese (Japan)|
|**nl**|Dutch|
|**nl_NL**|Dutch (Netherlands)|
|**pl**|Polish|
|**pl_PL**|Polish (Poland)|
|**pt**|Portuguese|
|**pt_BR**|Portuguese (Brazil)|
|**pt_PT**|Portuguese (Portugal)|
|**sv**|Swedish|
|**sv_SE**|Swedish (Sweden)|
|**tr**|Turkish|
|**tr_TR**|Turkish (Turkey)|
|**zh**|Chinese|
|**zh_CN**|Chinese (Simplified)|
|**zh_TW**|Chinese (Traditional)|


<a name="verb"></a>
### Verb
HTTP method for the link operation.

*Type* : enum


|Value|Description|
|---|---|
|**GET**|The provided resource is accessed with the HTTP GET method.|


<a name="requirementsenforced"></a>
### RequirementsEnforced
*Type* : enum

<a id="requirementsenforced-subgroup-1"></a>**For use with the definition(s): [ProductTypeDefinition](#producttypedefinition)**
Identifies if the required attributes for a requirements set are enforced by the product type definition schema. Non-enforced requirements enable structural validation of individual attributes without all of the required attributes being present (such as for partial updates).

|Value|Description|
|---|---|
|**ENFORCED**|Schema enforces required and conditionally required attributes (used for full payload validation).|
|**NOT_ENFORCED**|Schema does not enforce required and conditionally required attributes (used for partial payload validation, such as for single attributes).|

<a id="requirementsenforced-subgroup-2"></a>**For use with the operation(s): [getDefinitionsProductType](#getdefinitionsproducttype)**
Identifies if the required attributes for a requirements set are enforced by the product type definition schema. Non-enforced requirements enable structural validation of individual attributes without all the required attributes being present (such as for partial updates).

|Value|Description|
|---|---|
|**ENFORCED**|Request schema with required and conditionally required attributes enforced (used for full payload validation).|
|**NOT_ENFORCED**|Request schema with required and conditionally required attributes not enforced (used for partial payload validation, such as for single attributes).|


<a name="requirements"></a>
### Requirements
*Type* : enum

<a id="requirements-subgroup-1"></a>**For use with the definition(s): [ProductTypeDefinition](#producttypedefinition)**
Name of the requirements set represented in this product type definition.

|Value|Description|
|---|---|
|**LISTING**|Indicates the schema contains product facts and sales terms.|
|**LISTING_PRODUCT_ONLY**|Indicates the schema data contains product facts only.|
|**LISTING_OFFER_ONLY**|Indicates the schema data contains sales terms only.|

<a id="requirements-subgroup-2"></a>**For use with the operation(s): [getDefinitionsProductType](#getdefinitionsproducttype)**
The name of the requirements set to retrieve requirements for.

|Value|Description|
|---|---|
|**LISTING**|Request schema containing product facts and sales terms.|
|**LISTING_PRODUCT_ONLY**|Request schema containing product facts only.|
|**LISTING_OFFER_ONLY**|Request schema containing sales terms only.|

