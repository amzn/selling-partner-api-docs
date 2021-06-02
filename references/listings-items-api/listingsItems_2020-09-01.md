# Selling Partner API for Listings Items


<a name="overview"></a>
## Overview
The Selling Partner API for Listings Items (Listings Items API) provides programmatic access to selling partner listings on Amazon. Use this API in collaboration with the Selling Partner API for Product Type Definitions, which you use to retrieve the information about Amazon product types needed to use the Listings Items API.


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
[putListingsItem](#putlistingsitem)<br>[deleteListingsItem](#deletelistingsitem)<br>[patchListingsItem](#patchlistingsitem)<br>
<a name="paths"></a>
## Paths

<a name="putlistingsitem"></a>
### PUT /listings/2020-09-01/items/{sellerId}/{sku}
**Operation: putListingsItem**

#### Description
Creates a new or fully-updates an existing listings item for a selling partner.

**Usage Plans:**

| Plan type | Rate (requests per second) | Burst |
| ---- | ---- | ---- |
|Default| 5 | 10 |
|Selling partner specific| Variable | Variable |

The x-amzn-RateLimit-Limit response header returns the usage plan rate limits that were applied to the requested operation. Rate limits for some selling partners will vary from the default rate and burst shown in the table above. For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**sellerId**  <br>*required*|A selling partner identifier, such as a merchant account or vendor code.|string|
|**Path**|**sku**  <br>*required*|A selling partner provided identifier for an Amazon listing.|string|
|**Query**|**marketplaceIds**  <br>*required*|A comma-delimited list of Amazon marketplace identifiers for the request.|< string > array(csv)|
|**Query**|**issueLocale**  <br>*optional*|A locale for localization of issues. When not provided, the default language code of the first marketplace is used. Examples: "en_US", "fr_CA", "fr_FR". Localized messages default to "en_US" when a localization is not available in the specified locale.|string|
|**Body**|**body**  <br>*required*|The request body schema for the putListingsItem operation.|[ListingsItemPutRequest](#listingsitemputrequest)|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Successfully understood the request to create or fully-update a listings item. See the response to determine if the submission has been accepted.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[ListingsItemSubmissionResponse](#listingsitemsubmissionresponse)|

For error status codes, descriptions and schemas, see [Error responses and schemas](#error-responses-and-schemas).
#### Consumes

* `application/json`


#### Produces

* `application/json`


<a name="deletelistingsitem"></a>
### DELETE /listings/2020-09-01/items/{sellerId}/{sku}
**Operation: deleteListingsItem**

#### Description
Delete a listings item for a selling partner.

**Usage Plans:**

| Plan type | Rate (requests per second) | Burst |
| ---- | ---- | ---- |
|Default| 5 | 10 |
|Selling partner specific| Variable | Variable |

The x-amzn-RateLimit-Limit response header returns the usage plan rate limits that were applied to the requested operation. Rate limits for some selling partners will vary from the default rate and burst shown in the table above. For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**sellerId**  <br>*required*|A selling partner identifier, such as a merchant account or vendor code.|string|
|**Path**|**sku**  <br>*required*|A selling partner provided identifier for an Amazon listing.|string|
|**Query**|**marketplaceIds**  <br>*required*|A comma-delimited list of Amazon marketplace identifiers for the request.|< string > array(csv)|
|**Query**|**issueLocale**  <br>*optional*|A locale for localization of issues. When not provided, the default language code of the first marketplace is used. Examples: "en_US", "fr_CA", "fr_FR". Localized messages default to "en_US" when a localization is not available in the specified locale.|string|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Successfully understood the listings item delete request. See the response to determine whether the submission has been accepted.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[ListingsItemSubmissionResponse](#listingsitemsubmissionresponse)|

For error status codes, descriptions and schemas, see [Error responses and schemas](#error-responses-and-schemas).
#### Consumes

* `application/json`


#### Produces

* `application/json`


<a name="patchlistingsitem"></a>
### PATCH /listings/2020-09-01/items/{sellerId}/{sku}
**Operation: patchListingsItem**

#### Description
Partially update (patch) a listings item for a selling partner. Only top-level listings item attributes can be patched. Patching nested attributes is not supported.

**Usage Plans:**

| Plan type | Rate (requests per second) | Burst |
| ---- | ---- | ---- |
|Default| 5 | 10 |
|Selling partner specific| Variable | Variable |

The x-amzn-RateLimit-Limit response header returns the usage plan rate limits that were applied to the requested operation. Rate limits for some selling partners will vary from the default rate and burst shown in the table above. For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**sellerId**  <br>*required*|A selling partner identifier, such as a merchant account or vendor code.|string|
|**Path**|**sku**  <br>*required*|A selling partner provided identifier for an Amazon listing.|string|
|**Query**|**marketplaceIds**  <br>*required*|A comma-delimited list of Amazon marketplace identifiers for the request.|< string > array(csv)|
|**Query**|**issueLocale**  <br>*optional*|A locale for localization of issues. When not provided, the default language code of the first marketplace is used. Examples: "en_US", "fr_CA", "fr_FR". Localized messages default to "en_US" when a localization is not available in the specified locale.|string|
|**Body**|**body**  <br>*required*|The request body schema for the patchListingsItem operation.|[ListingsItemPatchRequest](#listingsitempatchrequest)|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Successfully understood the listings item patch request. See the response to determine if the submission was accepted.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[ListingsItemSubmissionResponse](#listingsitemsubmissionresponse)|

For error status codes, descriptions and schemas, see [Error responses and schemas](#error-responses-and-schemas).
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
|**413**|The request size exceeded the maximum accepted size.  <br>**Headers**:  <br>`x-amzn-RateLimit-Limit` (string):Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string):Unique request reference identifier.|[ErrorList](#errorlist)|
|**415**|The request payload is in an unsupported format.  <br>**Headers**:  <br>`x-amzn-RateLimit-Limit` (string):Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string):Unique request reference identifier.|[ErrorList](#errorlist)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers**:  <br>`x-amzn-RateLimit-Limit` (string):Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string):Unique request reference identifier.|[ErrorList](#errorlist)|
|**500**|An unexpected condition occurred that prevented the server from fulfilling the request.  <br>**Headers**:  <br>`x-amzn-RateLimit-Limit` (string):Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string):Unique request reference identifier.|[ErrorList](#errorlist)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers**:  <br>`x-amzn-RateLimit-Limit` (string):Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string):Unique request reference identifier.|[ErrorList](#errorlist)|


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


<a name="issue"></a>
### Issue
An issue with a listings item.


|Name|Description|Schema|
|---|---|---|
|**code**  <br>*required*|An issue code that identifies the type of issue.|string|
|**message**  <br>*required*|A message that describes the issue.|string|
|**severity**  <br>*required*|The severity of the issue.|enum ([Severity](#severity))|
|**attributeName**  <br>*optional*|Name of the attribute associated with the issue, if applicable.|string|


<a name="patchoperation"></a>
### PatchOperation
Individual JSON Patch operation for an HTTP PATCH request.


|Name|Description|Schema|
|---|---|---|
|**op**  <br>*required*|Type of JSON Patch operation. Supported JSON Patch operations include add, replace, and delete. See <https://tools.ietf.org/html/rfc6902>.|enum ([Op](#op))|
|**path**  <br>*required*|JSON Pointer path of the element to patch. See <https://tools.ietf.org/html/rfc6902>.|string|
|**value**  <br>*optional*|JSON value to add, replace, or delete.|< object > array|


<a name="listingsitempatchrequest"></a>
### ListingsItemPatchRequest
The request body schema for the patchListingsItem operation.


|Name|Description|Schema|
|---|---|---|
|**productType**  <br>*required*|The Amazon product type of the listings item.|string|
|**patches**  <br>*required*|One or more JSON Patch operations to perform on the listings item.|< [PatchOperation](#patchoperation) > array|


<a name="listingsitemputrequest"></a>
### ListingsItemPutRequest
The request body schema for the putListingsItem operation.


|Name|Description|Schema|
|---|---|---|
|**productType**  <br>*required*|The Amazon product type of the listings item.|string|
|**requirements**  <br>*optional*|The name of the requirements set for the provided data.|enum ([Requirements](#requirements))|
|**attributes**  <br>*required*|JSON object containing structured listings item attribute data keyed by attribute name.|object|


<a name="listingsitemsubmissionresponse"></a>
### ListingsItemSubmissionResponse
Response containing the results of a submission to the Selling Partner API for Listings Items.


|Name|Description|Schema|
|---|---|---|
|**sku**  <br>*required*|A selling partner provided identifier for an Amazon listing.|string|
|**status**  <br>*required*|The status of the listings item submission.|enum ([Status](#status))|
|**submissionId**  <br>*required*|The unique identifier of the listings item submission.|string|
|**issues**  <br>*optional*|Listings item issues related to the listings item submission.|< [Issue](#issue) > array|


<a name="status"></a>
### Status
The status of the listings item submission.

*Type* : enum


|Value|Description|
|---|---|
|**ACCEPTED**|The listings submission was accepted for processing.|
|**INVALID**|The listings submission was not valid and was not accepted for processing.|


<a name="op"></a>
### Op
Type of JSON Patch operation. Supported JSON Patch operations include add, replace, and delete. See <https://tools.ietf.org/html/rfc6902>.

*Type* : enum


|Value|Description|
|---|---|
|**add**|The "add" operation adds or replaces the target property.|
|**replace**|The "replace" operation adds or replaces the target property.|
|**delete**|The "delete" operation removes the target property.|


<a name="severity"></a>
### Severity
The severity of the issue.

*Type* : enum


|Value|Description|
|---|---|
|**ERROR**|Indicates an issue has occurred preventing the submission from processing, such as a validation error.|
|**WARNING**|Indicates an issue has occurred that should be reviewed, but has not prevented the submission from processing.|
|**INFO**|Indicates additional information has been provided that should be reviewed.|


<a name="requirements"></a>
### Requirements
The name of the requirements set for the provided data.

*Type* : enum


|Value|Description|
|---|---|
|**LISTING**|Indicates the submitted data contains product facts and sales terms.|
|**LISTING_PRODUCT_ONLY**|Indicates the submitted data contains product facts only.|
|**LISTING_OFFER_ONLY**|Indicates the submitted data contains sales terms only.|

