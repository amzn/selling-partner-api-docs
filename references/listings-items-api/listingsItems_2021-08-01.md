# Selling Partner API for Listings Items


<a name="overview"></a>
## Overview
The Selling Partner API for Listings Items (Listings Items API) provides programmatic access to selling partner listings on Amazon. Use this API in collaboration with the Selling Partner API for Product Type Definitions, which you use to retrieve the information about Amazon product types needed to use the Listings Items API.

For more information, see the [Listings Items API Use Case Guide](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/use-case-guides/listings-items-api-use-case-guide/listings-items-api-use-case-guide_2021-08-01.md).


### Version information
*Version* : 2021-08-01


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
[getListingsItem](#getlistingsitem)<br>[putListingsItem](#putlistingsitem)<br>[deleteListingsItem](#deletelistingsitem)<br>[patchListingsItem](#patchlistingsitem)<br>
<a name="paths"></a>
## Paths

<a name="getlistingsitem"></a>
### GET /listings/2021-08-01/items/{sellerId}/{sku}
**Operation: getListingsItem**

#### Description
Returns details about a listings item for a selling partner.

**Usage Plan:**

| Rate (requests per second) | Burst |
| ---- | ---- |
| 5 | 10 |

The `x-amzn-RateLimit-Limit` response header returns the usage plan rate limits that were applied to the requested operation, when available. The table above indicates the default rate and burst values for this operation. Selling partners whose business demands require higher throughput may see higher rate and burst values then those shown here. For more information, see [Usage Plans and Rate Limits in the Selling Partner API](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/usage-plans-rate-limits/Usage-Plans-and-Rate-Limits.md).


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**sellerId**  <br>*required*|A selling partner identifier, such as a merchant account or vendor code.|string|
|**Path**|**sku**  <br>*required*|A selling partner provided identifier for an Amazon listing.|string|
|**Query**|**marketplaceIds**  <br>*required*|A comma-delimited list of Amazon marketplace identifiers for the request.|< string > array(csv)|
|**Query**|**issueLocale**  <br>*optional*|A locale for localization of issues. When not provided, the default language code of the first marketplace is used. Examples: "en_US", "fr_CA", "fr_FR". Localized messages default to "en_US" when a localization is not available in the specified locale.|string|
|**Query**|**includedData**  <br>*optional*|A comma-delimited list of data sets to include in the response. Default: summaries.|< enum ([IncludedData](#includeddata)) > array(csv)|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Success.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[Item](#item)|

For error status codes, descriptions and schemas, see [Error responses and schemas](#error-responses-and-schemas).
#### Consumes

* `application/json`


#### Produces

* `application/json`


<a name="putlistingsitem"></a>
### PUT /listings/2021-08-01/items/{sellerId}/{sku}
**Operation: putListingsItem**

#### Description
Creates a new or fully-updates an existing listings item for a selling partner.

**Usage Plan:**

| Rate (requests per second) | Burst |
| ---- | ---- |
| 5 | 10 |

The `x-amzn-RateLimit-Limit` response header returns the usage plan rate limits that were applied to the requested operation, when available. The table above indicates the default rate and burst values for this operation. Selling partners whose business demands require higher throughput may see higher rate and burst values then those shown here. For more information, see [Usage Plans and Rate Limits in the Selling Partner API](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/usage-plans-rate-limits/Usage-Plans-and-Rate-Limits.md).


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
### DELETE /listings/2021-08-01/items/{sellerId}/{sku}
**Operation: deleteListingsItem**

#### Description
Delete a listings item for a selling partner.

**Usage Plan:**

| Rate (requests per second) | Burst |
| ---- | ---- |
| 5 | 10 |

The `x-amzn-RateLimit-Limit` response header returns the usage plan rate limits that were applied to the requested operation, when available. The table above indicates the default rate and burst values for this operation. Selling partners whose business demands require higher throughput may see higher rate and burst values then those shown here. For more information, see [Usage Plans and Rate Limits in the Selling Partner API](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/usage-plans-rate-limits/Usage-Plans-and-Rate-Limits.md).


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
### PATCH /listings/2021-08-01/items/{sellerId}/{sku}
**Operation: patchListingsItem**

#### Description
Partially update (patch) a listings item for a selling partner. Only top-level listings item attributes can be patched. Patching nested attributes is not supported.

**Usage Plan:**

| Rate (requests per second) | Burst |
| ---- | ---- |
| 5 | 10 |

The `x-amzn-RateLimit-Limit` response header returns the usage plan rate limits that were applied to the requested operation, when available. The table above indicates the default rate and burst values for this operation. Selling partners whose business demands require higher throughput may see higher rate and burst values then those shown here. For more information, see [Usage Plans and Rate Limits in the Selling Partner API](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/usage-plans-rate-limits/Usage-Plans-and-Rate-Limits.md).


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
|**404**|The resource specified does not exist.  <br>**Headers**:  <br>`x-amzn-RateLimit-Limit` (string):Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string):Unique request reference identifier.|[ErrorList](#errorlist)|
|**413**|The request size exceeded the maximum accepted size.  <br>**Headers**:  <br>`x-amzn-RequestId` (string):Unique request reference identifier.|[ErrorList](#errorlist)|
|**415**|The request payload is in an unsupported format.  <br>**Headers**:  <br>`x-amzn-RequestId` (string):Unique request reference identifier.|[ErrorList](#errorlist)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers**:  <br>`x-amzn-RequestId` (string):Unique request reference identifier.|[ErrorList](#errorlist)|
|**500**|An unexpected condition occurred that prevented the server from fulfilling the request.  <br>**Headers**:  <br>`x-amzn-RequestId` (string):Unique request reference identifier.|[ErrorList](#errorlist)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers**:  <br>`x-amzn-RequestId` (string):Unique request reference identifier.|[ErrorList](#errorlist)|


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


<a name="item"></a>
### Item
A listings item.


|Name|Description|Schema|
|---|---|---|
|**sku**  <br>*required*|A selling partner provided identifier for an Amazon listing.|string|
|**summaries**  <br>*optional*|Summary details of a listings item.|[ItemSummaries](#itemsummaries)|
|**attributes**  <br>*optional*|JSON object containing structured listings item attribute data keyed by attribute name.|[ItemAttributes](#itemattributes)|
|**issues**  <br>*optional*|Issues associated with the listings item.|[ItemIssues](#itemissues)|
|**offers**  <br>*optional*|Offer details for the listings item.|[ItemOffers](#itemoffers)|
|**fulfillmentAvailability**  <br>*optional*|Fulfillment availability for the listings item.|< [FulfillmentAvailability](#fulfillmentavailability) > array|
|**procurement**  <br>*optional*|Vendor procurement information for the listings item.|[ItemProcurement](#itemprocurement)|


<a name="itemsummaries"></a>
### ItemSummaries
Summary details of a listings item.

*Type* : < [ItemSummaryByMarketplace](#itemsummarybymarketplace) > array


<a name="itemsummarybymarketplace"></a>
### ItemSummaryByMarketplace
Summary details of a listings item for an Amazon marketplace.


|Name|Description|Schema|
|---|---|---|
|**marketplaceId**  <br>*required*|A marketplace identifier. Identifies the Amazon marketplace for the listings item.|string|
|**asin**  <br>*required*|Amazon Standard Identification Number (ASIN) of the listings item.|string|
|**productType**  <br>*required*|The Amazon product type of the listings item.|string|
|**conditionType**  <br>*optional*|Identifies the condition of the listings item.|enum ([ConditionType](#conditiontype))|
|**status**  <br>*required*|Statuses that apply to the listings item.|< enum ([Status](#status-subgroup-1)) > array|
|**fnSku**  <br>*optional*|Fulfillment network stock keeping unit is an identifier used by Amazon fulfillment centers to identify each unique item.|string|
|**itemName**  <br>*required*|Name, or title, associated with an Amazon catalog item.|string|
|**createdDate**  <br>*required*|Date the listings item was created, in ISO 8601 format.|string (date-time)|
|**lastUpdatedDate**  <br>*required*|Date the listings item was last updated, in ISO 8601 format.|string (date-time)|
|**mainImage**  <br>*optional*|Main image for the listings item.|[ItemImage](#itemimage)|


<a name="itemimage"></a>
### ItemImage
Image for the listings item.


|Name|Description|Schema|
|---|---|---|
|**link**  <br>*required*|Link, or URL, for the image.|string|
|**height**  <br>*required*|Height of the image in pixels.|integer|
|**width**  <br>*required*|Width of the image in pixels.|integer|


<a name="itemattributes"></a>
### ItemAttributes
JSON object containing structured listings item attribute data keyed by attribute name.

*Type* : object


<a name="itemissues"></a>
### ItemIssues
Issues associated with the listings item.

*Type* : < [Issue](#issue) > array


<a name="issue"></a>
### Issue
An issue with a listings item.


|Name|Description|Schema|
|---|---|---|
|**code**  <br>*required*|An issue code that identifies the type of issue.|string|
|**message**  <br>*required*|A message that describes the issue.|string|
|**severity**  <br>*required*|The severity of the issue.|enum ([Severity](#severity))|
|**attributeNames**  <br>*optional*|Names of the attributes associated with the issue, if applicable.|< string > array|


<a name="itemoffers"></a>
### ItemOffers
Offer details for the listings item.

*Type* : < [ItemOfferByMarketplace](#itemofferbymarketplace) > array


<a name="itemofferbymarketplace"></a>
### ItemOfferByMarketplace
Offer details of a listings item for an Amazon marketplace.


|Name|Description|Schema|
|---|---|---|
|**marketplaceId**  <br>*required*|Amazon marketplace identifier.|string|
|**offerType**  <br>*required*|Type of offer for the listings item.|enum ([OfferType](#offertype))|
|**price**  <br>*required*|Purchase price of the listings item|[Money](#money)|
|**points**  <br>*optional*|The number of Amazon Points offered with the purchase of an item, and their monetary value. Note that the Points element is only returned in Japan (JP).|[Points](#points)|


<a name="itemprocurement"></a>
### ItemProcurement
Vendor procurement information for the listings item.


|Name|Description|Schema|
|---|---|---|
|**costPrice**  <br>*required*|The price (numeric value) that you want Amazon to pay you for this product.|[Money](#money)|


<a name="fulfillmentavailability"></a>
### FulfillmentAvailability
Fulfillment availability details for the listings item.


|Name|Description|Schema|
|---|---|---|
|**fulfillmentChannelCode**  <br>*required*|Designates which fulfillment network will be used.|string|
|**quantity**  <br>*optional*|The quantity of the item you are making available for sale.  <br>**Minimum value** : `0`|integer|


<a name="money"></a>
### Money
The currency type and the amount.


|Name|Description|Schema|
|---|---|---|
|**currencyCode**  <br>*required*|Three-digit currency code. In ISO 4217 format.|string|
|**amount**  <br>*required*|The currency amount.|[Decimal](#decimal)|


<a name="decimal"></a>
### Decimal
A decimal number with no loss of precision. Useful when precision loss is unnaceptable, as with currencies. Follows RFC7159 for number representation.

*Type* : string


<a name="points"></a>
### Points
The number of Amazon Points offered with the purchase of an item, and their monetary value. Note that the Points element is only returned in Japan (JP).


|Name|Schema|
|---|---|
|**pointsNumber**  <br>*required*|integer|


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
|**status**  <br>*required*|The status of the listings item submission.|enum ([Status](#status-subgroup-2))|
|**submissionId**  <br>*required*|The unique identifier of the listings item submission.|string|
|**issues**  <br>*optional*|Listings item issues related to the listings item submission.|< [Issue](#issue) > array|


<a name="includeddata"></a>
### IncludedData
*Type* : enum


|Value|Description|
|---|---|
|**summaries**|Summary details of the listing item.|
|**attributes**|JSON object containing structured listing item attribute data keyed by attribute name.|
|**issues**|Issues associated with the listing item.|
|**offers**|Current offers for the listing item.|
|**fulfillmentAvailability**|Fulfillment availability details for the listing item.|
|**procurement**|Vendor procurement details for the listing item.|


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


<a name="conditiontype"></a>
### ConditionType
Identifies the condition of the listings item.

*Type* : enum


|Value|Description|
|---|---|
|**new_new**|New|
|**new_open_box**|New - Open Box.|
|**new_oem**|New - OEM.|
|**refurbished_refurbished**|Refurbished|
|**used_like_new**|Used - Like New.|
|**used_very_good**|Used - Very Good.|
|**used_good**|Used - Good.|
|**used_acceptable**|Used - Acceptable.|
|**collectible_like_new**|Collectible - Like New.|
|**collectible_very_good**|Collectible - Very Good.|
|**collectible_good**|Collectible - Good.|
|**collectible_acceptable**|Collectible - Acceptable.|
|**club_club**|Club|


<a name="requirements"></a>
### Requirements
The name of the requirements set for the provided data.

*Type* : enum


|Value|Description|
|---|---|
|**LISTING**|Indicates the submitted data contains product facts and sales terms.|
|**LISTING_PRODUCT_ONLY**|Indicates the submitted data contains product facts only.|
|**LISTING_OFFER_ONLY**|Indicates the submitted data contains sales terms only.|


<a name="offertype"></a>
### OfferType
Type of offer for the listings item.

*Type* : enum


|Value|Description|
|---|---|
|**B2C**|The offer on this listings item is available for Business to Consumer purchase, meaning that it is available to shoppers on Amazon retail sites.|
|**B2B**|The offer on this listings item is available for Business to Business purchase.|


<a name="status"></a>
### Status
*Type* : enum

<a id="status-subgroup-1"></a>**For use with the definition(s): [ItemSummaryByMarketplace](#itemsummarybymarketplace)**

|Value|Description|
|---|---|
|**BUYABLE**|The listings item can be purchased by shoppers. This status does not apply to vendor listings.|
|**DISCOVERABLE**|The listings item is visible to shoppers.|

<a id="status-subgroup-2"></a>**For use with the definition(s): [ListingsItemSubmissionResponse](#listingsitemsubmissionresponse)**
The status of the listings item submission.

|Value|Description|
|---|---|
|**ACCEPTED**|The listings submission was accepted for processing.|
|**INVALID**|The listings submission was not valid and was not accepted for processing.|

