# Selling Partner API for FBA Small And Light


<a name="overview"></a>
## Overview
The Selling Partner API for FBA Small and Light lets you help sellers manage their listings in the Small and Light program. The program reduces the cost of fulfilling orders for small and lightweight FBA inventory. You can enroll or remove items from the program and check item eligibility and enrollment status. You can also preview the estimated program fees charged to a seller for items sold while enrolled in the program.


### Version information
*Version* : v1


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
[getSmallAndLightEnrollmentBySellerSKU](#getsmallandlightenrollmentbysellersku)<br>[putSmallAndLightEnrollmentBySellerSKU](#putsmallandlightenrollmentbysellersku)<br>[deleteSmallAndLightEnrollmentBySellerSKU](#deletesmallandlightenrollmentbysellersku)<br>[getSmallAndLightEligibilityBySellerSKU](#getsmallandlighteligibilitybysellersku)<br>[getSmallAndLightFeePreview](#getsmallandlightfeepreview)<br>
<a name="paths"></a>
## Paths

<a name="getsmallandlightenrollmentbysellersku"></a>
### GET /fba/smallAndLight/v1/enrollments/{sellerSKU}
**Operation: getSmallAndLightEnrollmentBySellerSKU**

#### Description
Returns the Small and Light enrollment status for the item indicated by the specified seller SKU in the specified marketplace.

**Usage Plan:**

| Rate (requests per second) | Burst |
| ---- | ---- |
| 2 | 10 |

For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**sellerSKU**  <br>*required*|The seller SKU that identifies the item.|string|
|**Query**|**marketplaceIds**  <br>*required*|The marketplace for which the enrollment status is retrieved. Note: Accepts a single marketplace only.<br>**Max count** : 1|< string > array|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Success.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[SmallAndLightEnrollment](#smallandlightenrollment)|

For error status codes, descriptions and schemas, see [Error responses and schemas](#error-responses-and-schemas).
<a name="putsmallandlightenrollmentbysellersku"></a>
### PUT /fba/smallAndLight/v1/enrollments/{sellerSKU}
**Operation: putSmallAndLightEnrollmentBySellerSKU**

#### Description
Enrolls the item indicated by the specified seller SKU in the Small and Light program in the specified marketplace. If the item is not eligible, the ineligibility reasons are returned.

**Usage Plan:**

| Rate (requests per second) | Burst |
| ---- | ---- |
| 2 | 5 |

For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**sellerSKU**  <br>*required*|The seller SKU that identifies the item.|string|
|**Query**|**marketplaceIds**  <br>*required*|The marketplace in which to enroll the item. Note: Accepts a single marketplace only.<br>**Max count** : 1|< string > array|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Success.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[SmallAndLightEnrollment](#smallandlightenrollment)|

For error status codes, descriptions and schemas, see [Error responses and schemas](#error-responses-and-schemas).
<a name="deletesmallandlightenrollmentbysellersku"></a>
### DELETE /fba/smallAndLight/v1/enrollments/{sellerSKU}
**Operation: deleteSmallAndLightEnrollmentBySellerSKU**

#### Description
Removes the item indicated by the specified seller SKU from the Small and Light program in the specified marketplace. If the item is not eligible for disenrollment, the ineligibility reasons are returned.

**Usage Plan:**

| Rate (requests per second) | Burst |
| ---- | ---- |
| 2 | 5 |

For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**sellerSKU**  <br>*required*|The seller SKU that identifies the item.|string|
|**Query**|**marketplaceIds**  <br>*required*|The marketplace in which to remove the item from the Small and Light program. Note: Accepts a single marketplace only.<br>**Max count** : 1|< string > array|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**204**|Success.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|No Content|

For error status codes, descriptions and schemas, see [Error responses and schemas](#error-responses-and-schemas).
<a name="getsmallandlighteligibilitybysellersku"></a>
### GET /fba/smallAndLight/v1/eligibilities/{sellerSKU}
**Operation: getSmallAndLightEligibilityBySellerSKU**

#### Description
Returns the Small and Light program eligibility status of the item indicated by the specified seller SKU in the specified marketplace. If the item is not eligible, the ineligibility reasons are returned.

**Usage Plan:**

| Rate (requests per second) | Burst |
| ---- | ---- |
| 2 | 10 |

For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**sellerSKU**  <br>*required*|The seller SKU that identifies the item.|string|
|**Query**|**marketplaceIds**  <br>*required*|The marketplace for which the eligibility status is retrieved. NOTE: Accepts a single marketplace only.<br>**Max count** : 1|< string > array|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Success.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[SmallAndLightEligibility](#smallandlighteligibility)|

For error status codes, descriptions and schemas, see [Error responses and schemas](#error-responses-and-schemas).
<a name="getsmallandlightfeepreview"></a>
### POST /fba/smallAndLight/v1/feePreviews
**Operation: getSmallAndLightFeePreview**

#### Description
Returns the Small and Light fee estimates for the specified items. You must include a marketplaceId parameter to retrieve the proper fee estimates for items to be sold in that marketplace. The ordering of items in the response will mirror the order of the items in the request. Duplicate ASIN/price combinations are removed.

**Usage Plan:**

| Rate (requests per second) | Burst |
| ---- | ---- |
| 1 | 3 |

For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Body**|**body**  <br>*required*|Request schema for submitting items for which to retrieve fee estimates.|[SmallAndLightFeePreviewRequest](#smallandlightfeepreviewrequest)|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Success.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[SmallAndLightFeePreviews](#smallandlightfeepreviews)|

For error status codes, descriptions and schemas, see [Error responses and schemas](#error-responses-and-schemas).



<a name="error-responses-and-schemas"></a>
### Error Responses and Schemas
This table contains HTTP status codes and associated information for error responses.

|HTTP Code|Description|Schema|
|---|---|---|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers**:  <br>`x-amzn-RateLimit-Limit` (string):Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string):Unique request reference identifier.|[ErrorList](#errorlist)|
|**401**|The request's Authorization header is not formatted correctly or does not contain a valid token.  <br>**Headers**:  <br>`x-amzn-RateLimit-Limit` (string):Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string):Unique request reference identifier.|[ErrorList](#errorlist)|
|**403**|Indicates that access to the resource is forbidden. Possible reasons include Access Denied, Unauthorized, Expired Token, or Invalid Signature.  <br>**Headers**:  <br>`x-amzn-RequestId` (string):Unique request reference identifier.|[ErrorList](#errorlist)|
|**404**|The resource specified does not exist.  <br>**Headers**:  <br>`x-amzn-RateLimit-Limit` (string):Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string):Unique request reference identifier.|[ErrorList](#errorlist)|
|**413**|The request size exceeded the maximum accepted size.  <br>**Headers**:  <br>`x-amzn-RateLimit-Limit` (string):Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string):Unique request reference identifier.|[ErrorList](#errorlist)|
|**415**|The request payload is in an unsupported format.  <br>**Headers**:  <br>`x-amzn-RateLimit-Limit` (string):Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string):Unique request reference identifier.|[ErrorList](#errorlist)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers**:  <br>`x-amzn-RateLimit-Limit` (string):Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string):Unique request reference identifier.|[ErrorList](#errorlist)|
|**500**|An unexpected condition occurred that prevented the server from fulfilling the request.  <br>**Headers**:  <br>`x-amzn-RateLimit-Limit` (string):Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string):Unique request reference identifier.|[ErrorList](#errorlist)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers**:  <br>`x-amzn-RateLimit-Limit` (string):Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string):Unique request reference identifier.|[ErrorList](#errorlist)|


<a name="definitions"></a>
## Definitions

<a name="marketplaceid"></a>
### MarketplaceId
A marketplace identifier.

*Type* : string


<a name="sellersku"></a>
### SellerSKU
Identifies an item in the given marketplace. SellerSKU is qualified by the seller's SellerId, which is included with every operation that you submit.

*Type* : string


<a name="error"></a>
### Error
Error response returned when the request is unsuccessful.


|Name|Description|Schema|
|---|---|---|
|**code**  <br>*required*|An error code that identifies the type of error that occurred.|string|
|**message**  <br>*required*|A message that describes the error condition in a human-readable form.|string|
|**details**  <br>*optional*|Additional information that can help the caller understand or fix the issue.|string|


<a name="errorlist"></a>
### ErrorList
A list of error responses returned when a request is unsuccessful.


|Name|Schema|
|---|---|
|**errors**  <br>*optional*|< [Error](#error) > array|


<a name="smallandlightenrollmentstatus"></a>
### SmallAndLightEnrollmentStatus
The Small and Light enrollment status of the item.

*Type* : enum


|Value|Description|
|---|---|
|**ENROLLED**|The Small and Light enrollment status is enrolled.|
|**NOT_ENROLLED**|The Small and Light enrollment status is not enrolled.|


<a name="smallandlighteligibilitystatus"></a>
### SmallAndLightEligibilityStatus
The Small and Light eligibility status of the item.

*Type* : enum


|Value|Description|
|---|---|
|**ELIGIBLE**|The Small and Light eligibility status is eligible.|
|**NOT_ELIGIBLE**|The Small and Light eligibility status is not eligible.|


<a name="smallandlightenrollment"></a>
### SmallAndLightEnrollment
The Small and Light enrollment status of the item indicated by the specified seller SKU.


|Name|Description|Schema|
|---|---|---|
|**marketplaceId**  <br>*required*|A marketplace identifier.|[MarketplaceId](#marketplaceid)|
|**sellerSKU**  <br>*required*|Identifies an item in the given marketplace. SellerSKU is qualified by the seller's SellerId, which is included with every operation that you submit.|[SellerSKU](#sellersku)|
|**status**  <br>*required*|The Small and Light enrollment status of the item.|[SmallAndLightEnrollmentStatus](#smallandlightenrollmentstatus)|


<a name="smallandlighteligibility"></a>
### SmallAndLightEligibility
The Small and Light eligibility status of the item indicated by the specified seller SKU.


|Name|Description|Schema|
|---|---|---|
|**marketplaceId**  <br>*required*|A marketplace identifier.|[MarketplaceId](#marketplaceid)|
|**sellerSKU**  <br>*required*|Identifies an item in the given marketplace. SellerSKU is qualified by the seller's SellerId, which is included with every operation that you submit.|[SellerSKU](#sellersku)|
|**status**  <br>*required*|The Small and Light eligibility status of the item.|[SmallAndLightEligibilityStatus](#smallandlighteligibilitystatus)|


<a name="smallandlightfeepreviewrequest"></a>
### SmallAndLightFeePreviewRequest
Request schema for submitting items for which to retrieve fee estimates.


|Name|Description|Schema|
|---|---|---|
|**marketplaceId**  <br>*required*|A marketplace identifier.|[MarketplaceId](#marketplaceid)|
|**items**  <br>*required*|A list of items for which to retrieve fee estimates (limit: 25).|< [Item](#item) > array|


<a name="smallandlightfeepreviews"></a>
### SmallAndLightFeePreviews

|Name|Description|Schema|
|---|---|---|
|**data**  <br>*optional*|A list of fee estimates for the requested items. The order of the fee estimates will follow the same order as the items in the request, with duplicates removed.|< [FeePreview](#feepreview) > array|


<a name="item"></a>
### Item
An item to be sold.


|Name|Description|Schema|
|---|---|---|
|**asin**  <br>*required*|The Amazon Standard Identification Number (ASIN) value used to identify the item.|string|
|**price**  <br>*required*|The price that the seller plans to charge for the item.|[MoneyType](#moneytype)|


<a name="feepreview"></a>
### FeePreview
The fee estimate for a specific item.


|Name|Description|Schema|
|---|---|---|
|**asin**  <br>*optional*|The Amazon Standard Identification Number (ASIN) value used to identify the item.|string|
|**price**  <br>*optional*|The price that the seller plans to charge for the item.|[MoneyType](#moneytype)|
|**feeBreakdown**  <br>*optional*|A list of the Small and Light fees for the item.|< [FeeLineItem](#feelineitem) > array|
|**totalFees**  <br>*optional*|The total fees charged if the item participated in the Small and Light program.|[MoneyType](#moneytype)|
|**errors**  <br>*optional*|One or more unexpected errors occurred during the getSmallAndLightFeePreview operation.|< [Error](#error) > array|


<a name="feelineitem"></a>
### FeeLineItem
Fee details for a specific fee.


|Name|Description|Schema|
|---|---|---|
|**feeType**  <br>*required*|The type of fee charged to the seller.|enum ([FeeType](#feetype))|
|**feeCharge**  <br>*required*|Amount charged to the seller for the specific fee type.|[MoneyType](#moneytype)|


<a name="moneytype"></a>
### MoneyType

|Name|Description|Schema|
|---|---|---|
|**currencyCode**  <br>*optional*|The currency code in ISO 4217 format.|string|
|**amount**  <br>*optional*|The monetary value.|number|


<a name="feetype"></a>
### FeeType
The type of fee charged to the seller.

*Type* : enum


|Value|Description|
|---|---|
|**FBAWeightBasedFee**|The FBA weight-based fee (weight handling).|
|**FBAPerOrderFulfillmentFee**|The FBA per-order fulfillment fee (order handling).|
|**FBAPerUnitFulfillmentFee**|The FBA fulfillment fee (Pick & Pack).|
|**Commission**|The commission - referral fee.|

