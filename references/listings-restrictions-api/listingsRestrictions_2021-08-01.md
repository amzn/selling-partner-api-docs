# Selling Partner API for Listings Restrictions


<a name="overview"></a>
## Overview
The Selling Partner API for Listings Restrictions provides programmatic access to restrictions on Amazon catalog listings.

For more information, see the [Listings Restrictions API Use Case Guide](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/use-case-guides/listings-items-api-use-case-guide/listings-items-api-use-case-guide_2021-08-01.md).


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
[getListingsRestrictions](#getlistingsrestrictions)<br>
<a name="paths"></a>
## Paths

<a name="getlistingsrestrictions"></a>
### GET /listings/2021-08-01/restrictions
**Operation: getListingsRestrictions**

#### Description
Returns listing restrictions for an item in the Amazon Catalog. 

**Usage Plan:**

| Rate (requests per second) | Burst |
| ---- | ---- |
| 5 | 10 |

The `x-amzn-RateLimit-Limit` response header returns the usage plan rate limits that were applied to the requested operation, when available. The table above indicates the default rate and burst values for this operation. Selling partners whose business demands require higher throughput may see higher rate and burst values then those shown here. For more information, see [Usage Plans and Rate Limits in the Selling Partner API](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/usage-plans-rate-limits/Usage-Plans-and-Rate-Limits.md).


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Query**|**asin**  <br>*required*|The Amazon Standard Identification Number (ASIN) of the item.|string|
|**Query**|**conditionType**  <br>*optional*|The condition used to filter restrictions.|enum ([ConditionType](#conditiontype-subgroup-2))|
|**Query**|**sellerId**  <br>*required*|A selling partner identifier, such as a merchant account.|string|
|**Query**|**marketplaceIds**  <br>*required*|A comma-delimited list of Amazon marketplace identifiers for the request.|< string > array(csv)|
|**Query**|**reasonLocale**  <br>*optional*|A locale for reason text localization. When not provided, the default language code of the first marketplace is used. Examples: "en_US", "fr_CA", "fr_FR". Localized messages default to "en_US" when a localization is not available in the specified locale.|string|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Successfully retrieved the listings restrictions.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[RestrictionList](#restrictionlist)|

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

<a name="restrictionlist"></a>
### RestrictionList
A list of restrictions for the specified Amazon catalog item.


|Name|Schema|
|---|---|
|**restrictions**  <br>*required*|< [Restriction](#restriction) > array|


<a name="restriction"></a>
### Restriction
A listing restriction, optionally qualified by a condition, with a list of reasons for the restriction.


|Name|Description|Schema|
|---|---|---|
|**marketplaceId**  <br>*required*|A marketplace identifier. Identifies the Amazon marketplace where the restriction is enforced.|string|
|**conditionType**  <br>*optional*|The condition that applies to the restriction.|enum ([ConditionType](#conditiontype-subgroup-1))|
|**reasons**  <br>*optional*|A list of reasons for the restriction.|< [Reason](#reason) > array|


<a name="reason"></a>
### Reason
A reason for the restriction, including path forward links that may allow Selling Partners to remove the restriction, if available.


|Name|Description|Schema|
|---|---|---|
|**message**  <br>*required*|A message describing the reason for the restriction.|string|
|**reasonCode**  <br>*optional*|A code indicating why the listing is restricted.|enum ([ReasonCode](#reasoncode))|
|**links**  <br>*optional*|A list of path forward links that may allow Selling Partners to remove the restriction.|< [Link](#link) > array|


<a name="link"></a>
### Link
A link to resources related to a listing restriction.


|Name|Description|Schema|
|---|---|---|
|**resource**  <br>*required*|The URI of the related resource.|string (uri)|
|**verb**  <br>*required*|The HTTP verb used to interact with the related resource.|enum ([Verb](#verb))|
|**title**  <br>*optional*|The title of the related resource.|string|
|**type**  <br>*optional*|The media type of the related resource.|string|


<a name="errorlist"></a>
### ErrorList
A list of error responses returned when a request is unsuccessful.

*Type* : < [Error](#error) > array


<a name="error"></a>
### Error
Error response returned when the request is unsuccessful.


|Name|Description|Schema|
|---|---|---|
|**code**  <br>*required*|An error code that identifies the type of error that occurred.|string|
|**message**  <br>*required*|A message that describes the error condition.|string|
|**details**  <br>*optional*|Additional details that can help the caller understand or fix the issue.|string|


<a name="verb"></a>
### Verb
The HTTP verb used to interact with the related resource.

*Type* : enum


|Value|Description|
|---|---|
|**GET**|The provided resource is accessed with the HTTP GET method.|


<a name="reasoncode"></a>
### ReasonCode
A code indicating why the listing is restricted.

*Type* : enum


|Value|Description|
|---|---|
|**APPROVAL_REQUIRED**|Approval is required to create a listing for the specified ASIN. A path forward link will be provided that may allow Selling Partners to remove the restriction.|
|**ASIN_NOT_FOUND**|The specified ASIN does not exist in the requested marketplace.|
|**NOT_ELIGIBLE**|Not eligible to create a listing for the specified ASIN. No path forward link will be provided to remove the restriction.|


<a name="conditiontype"></a>
### ConditionType
*Type* : enum

<a id="conditiontype-subgroup-1"></a>**For use with the definition(s): [Restriction](#restriction)**
The condition that applies to the restriction.

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

<a id="conditiontype-subgroup-2"></a>**For use with the operation(s): [getListingsRestrictions](#getlistingsrestrictions)**
The condition used to filter restrictions.

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

