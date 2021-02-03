# Selling Partner API for Product Fees


<a name="overview"></a>
## Overview
The Selling Partner API for Product Fees lets you programmatically retrieve estimated fees for a product. You can then account for those fees in your pricing.


### Version information
*Version* : v0


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
[getMyFeesEstimateForSKU](#getmyfeesestimateforsku)<br>[getMyFeesEstimateForASIN](#getmyfeesestimateforasin)<br>
<a name="paths"></a>
## Paths

<a name="getmyfeesestimateforsku"></a>
### POST /products/fees/v0/listings/{SellerSKU}/feesEstimate
**Operation: getMyFeesEstimateForSKU**

#### Description
Returns the estimated fees for the item indicated by the specified seller SKU in the marketplace specified in the request body.

You can call getMyFeesEstimateForSKU for an item on behalf of a seller before the seller sets the item's price. They can then take estimated fees into account. With each fees estimate request, you must include an original identifier. This identifier is included in the fees estimate so you can correlate a fees estimate with the original request.

**Usage Plans:**

| Plan type | Rate (requests per second) | Burst |
| ---- | ---- | ---- |
|Default| 1 | 1 |
|Selling partner specific| Variable | Variable |

The x-amzn-RateLimit-Limit response header returns the usage plan rate limits that were applied to the requested operation. Rate limits for some selling partners will vary from the default rate and burst shown in the table above. For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Body**|**body**  <br>*required*|Request schema.|[GetMyFeesEstimateRequest](#getmyfeesestimaterequest)|
|**Path**|**SellerSKU**  <br>*required*|Used to identify an item in the given marketplace. SellerSKU is qualified by the seller's SellerId, which is included with every operation that you submit.|string|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Success.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetMyFeesEstimateResponse](#getmyfeesestimateresponse)|

For error status codes, descriptions and schemas, see [Error responses and schemas](#error-responses-and-schemas).
<a name="getmyfeesestimateforasin"></a>
### POST /products/fees/v0/items/{Asin}/feesEstimate
**Operation: getMyFeesEstimateForASIN**

#### Description
Returns the estimated fees for the item indicated by the specified Asin in the marketplace specified in the request body.

You can call getMyFeesEstimateForASIN for an item on behalf of a seller before the seller sets the item's price. They can then take estimated fees into account. With each product fees request, you must include an original identifier. This identifier is included in the fees estimate so you can correlate a fees estimate with the original request.

**Usage Plans:**

| Plan type | Rate (requests per second) | Burst |
| ---- | ---- | ---- |
|Default| 1 | 1 |
|Selling partner specific| Variable | Variable |

The x-amzn-RateLimit-Limit response header returns the usage plan rate limits that were applied to the requested operation. Rate limits for some selling partners will vary from the default rate and burst shown in the table above. For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Body**|**body**  <br>*required*|Request schema.|[GetMyFeesEstimateRequest](#getmyfeesestimaterequest)|
|**Path**|**Asin**  <br>*required*|The Amazon Standard Identification Number (ASIN) of the item.|string|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Success.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetMyFeesEstimateResponse](#getmyfeesestimateresponse)|

For error status codes, descriptions and schemas, see [Error responses and schemas](#error-responses-and-schemas).



<a name="error-responses-and-schemas"></a>
### Error Responses and Schemas
This table contains HTTP status codes and associated information for error responses.

|HTTP Code|Description|Schema|
|---|---|---|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers**:  <br>`x-amzn-RateLimit-Limit` (string):Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string):Unique request reference identifier.|[GetMyFeesEstimateResponse](#getmyfeesestimateresponse)|
|**401**|The request's Authorization header is not formatted correctly or does not contain a valid token.  <br>**Headers**:  <br>`x-amzn-RateLimit-Limit` (string):Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string):Unique request reference identifier.|[GetMyFeesEstimateResponse](#getmyfeesestimateresponse)|
|**403**|Indicates access to the resource is forbidden. Possible reasons include Access Denied, Unauthorized, Expired Token, or Invalid Signature.  <br>**Headers**:  <br>`x-amzn-RequestId` (string):Unique request reference identifier.|[GetMyFeesEstimateResponse](#getmyfeesestimateresponse)|
|**404**|The specified resource does not exist.  <br>**Headers**:  <br>`x-amzn-RequestId` (string):Unique request reference identifier.|[GetMyFeesEstimateResponse](#getmyfeesestimateresponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers**:  <br>`x-amzn-RateLimit-Limit` (string):Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string):Unique request reference identifier.|[GetMyFeesEstimateResponse](#getmyfeesestimateresponse)|
|**500**|An unexpected condition occurred that prevented the server from fulfilling the request.  <br>**Headers**:  <br>`x-amzn-RateLimit-Limit` (string):Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string):Unique request reference identifier.|[GetMyFeesEstimateResponse](#getmyfeesestimateresponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers**:  <br>`x-amzn-RateLimit-Limit` (string):Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string):Unique request reference identifier.|[GetMyFeesEstimateResponse](#getmyfeesestimateresponse)|


<a name="definitions"></a>
## Definitions

<a name="getmyfeesestimaterequest"></a>
### GetMyFeesEstimateRequest
Request schema.


|Name|Schema|
|---|---|
|**FeesEstimateRequest**  <br>*optional*|[FeesEstimateRequest](#feesestimaterequest)|


<a name="feesestimaterequest"></a>
### FeesEstimateRequest

|Name|Description|Schema|
|---|---|---|
|**MarketplaceId**  <br>*required*|A marketplace identifier.|string|
|**IsAmazonFulfilled**  <br>*optional*|When true, the offer is fulfilled by Amazon.|boolean|
|**PriceToEstimateFees**  <br>*required*|The product price that the fee estimate is based on.|[PriceToEstimateFees](#pricetoestimatefees)|
|**Identifier**  <br>*required*|A unique identifier provided by the caller to track this request.|string|
|**OptionalFulfillmentProgram**  <br>*optional*|An optional enrollment program for which to return the estimated fees when the offer is fulfilled by Amazon (IsAmazonFulfilled is set to true).|[OptionalFulfillmentProgram](#optionalfulfillmentprogram)|


<a name="getmyfeesestimateresponse"></a>
### GetMyFeesEstimateResponse

|Name|Description|Schema|
|---|---|---|
|**payload**  <br>*optional*|The payload for the operation.|[GetMyFeesEstimateResult](#getmyfeesestimateresult)|
|**errors**  <br>*optional*|A list of error responses returned when a request is unsuccessful.|[ErrorList](#errorlist)|


<a name="getmyfeesestimateresult"></a>
### GetMyFeesEstimateResult
Response schema.


|Name|Description|Schema|
|---|---|---|
|**FeesEstimateResult**  <br>*optional*|The item's estimated fees.|[FeesEstimateResult](#feesestimateresult)|


<a name="points"></a>
### Points

|Name|Schema|
|---|---|
|**PointsNumber**  <br>*optional*|integer (int32)|
|**PointsMonetaryValue**  <br>*optional*|[MoneyType](#moneytype)|


<a name="errorlist"></a>
### ErrorList
A list of error responses returned when a request is unsuccessful.

*Type* : < [Error](#error) > array


<a name="error"></a>
### Error

|Name|Description|Schema|
|---|---|---|
|**code**  <br>*required*|An error code that identifies the type of error that occurred.|string|
|**message**  <br>*required*|A message that describes the error condition.|string|
|**details**  <br>*optional*|Additional information that can help the caller understand or fix the issue.|string|


<a name="feesestimateresult"></a>
### FeesEstimateResult
An item identifier and the estimated fees for the item.


|Name|Description|Schema|
|---|---|---|
|**Status**  <br>*optional*|The status of the fee request. Possible values: Success, ClientError, ServiceError.|string|
|**FeesEstimateIdentifier**  <br>*optional*|Information used to identify a fees estimate request.|[FeesEstimateIdentifier](#feesestimateidentifier)|
|**FeesEstimate**  <br>*optional*|The total estimated fees for an item and a list of details.|[FeesEstimate](#feesestimate)|
|**Error**  <br>*optional*|An error object with a type, code, and message.|[FeesEstimateError](#feesestimateerror)|


<a name="feesestimateidentifier"></a>
### FeesEstimateIdentifier
An item identifier, marketplace, time of request, and other details that identify an estimate.


|Name|Description|Schema|
|---|---|---|
|**MarketplaceId**  <br>*optional*|A marketplace identifier.|string|
|**SellerId**  <br>*optional*|The seller identifier.|string|
|**IdType**  <br>*optional*|The type of item identifier specified.|string|
|**IdValue**  <br>*optional*|The item identifier.|string|
|**IsAmazonFulfilled**  <br>*optional*|When true, the offer is fulfilled by Amazon.|boolean|
|**PriceToEstimateFees**  <br>*optional*|The item price on which the fee estimate is based.|[PriceToEstimateFees](#pricetoestimatefees)|
|**SellerInputIdentifier**  <br>*optional*|A unique identifier provided by the caller to track this request.|string|
|**OptionalFulfillmentProgram**  <br>*optional*|An optional enrollment program for which to return the estimated fees when the offer is fulfilled by Amazon (IsAmazonFulfilled is set to true).|[OptionalFulfillmentProgram](#optionalfulfillmentprogram)|


<a name="pricetoestimatefees"></a>
### PriceToEstimateFees
Price information for an item, used to estimate fees.


|Name|Description|Schema|
|---|---|---|
|**ListingPrice**  <br>*required*|The price of the item.|[MoneyType](#moneytype)|
|**Shipping**  <br>*optional*|The shipping cost.|[MoneyType](#moneytype)|
|**Points**  <br>*optional*|The number of Amazon Points offered with the purchase of an item.|[Points](#points)|


<a name="feesestimate"></a>
### FeesEstimate
The total estimated fees for an item and a list of details.


|Name|Description|Schema|
|---|---|---|
|**TimeOfFeesEstimation**  <br>*required*|The time at which the fees were estimated. This defaults to the time the request is made.|string (date-time)|
|**TotalFeesEstimate**  <br>*optional*|Total estimated fees for a given item, price, and fulfillment channel.|[MoneyType](#moneytype)|
|**FeeDetailList**  <br>*optional*|A list of other fees that contribute to a given fee.|[FeeDetailList](#feedetaillist)|


<a name="feedetaillist"></a>
### FeeDetailList
A list of other fees that contribute to a given fee.

*Type* : < [FeeDetail](#feedetail) > array


<a name="feesestimateerror"></a>
### FeesEstimateError
An unexpected error occurred during this operation.


|Name|Description|Schema|
|---|---|---|
|**Type**  <br>*required*|An error type, identifying either the receiver or the sender as the originator of the error.|string|
|**Code**  <br>*required*|An error code that identifies the type of error that occurred.|string|
|**Message**  <br>*required*|A message that describes the error condition.|string|
|**Detail**  <br>*required*|Additional information that can help the caller understand or fix the issue.|[FeesEstimateErrorDetail](#feesestimateerrordetail)|


<a name="feesestimateerrordetail"></a>
### FeesEstimateErrorDetail
Additional information that can help the caller understand or fix the issue.

*Type* : < object > array


<a name="feedetail"></a>
### FeeDetail
The type of fee, fee amount, and other details.


|Name|Description|Schema|
|---|---|---|
|**FeeType**  <br>*required*|The type of fee charged to a seller.|string|
|**FeeAmount**  <br>*required*|The amount charged for a given fee.|[MoneyType](#moneytype)|
|**FeePromotion**  <br>*optional*|The promotion amount for a given fee.|[MoneyType](#moneytype)|
|**TaxAmount**  <br>*optional*|The tax amount for a given fee.|[MoneyType](#moneytype)|
|**FinalFee**  <br>*required*|The final fee amount for a given fee.|[MoneyType](#moneytype)|
|**IncludedFeeDetailList**  <br>*optional*|A list of other fees that contribute to a given fee.|[IncludedFeeDetailList](#includedfeedetaillist)|


<a name="includedfeedetaillist"></a>
### IncludedFeeDetailList
A list of other fees that contribute to a given fee.

*Type* : < [IncludedFeeDetail](#includedfeedetail) > array


<a name="includedfeedetail"></a>
### IncludedFeeDetail
The type of fee, fee amount, and other details.


|Name|Description|Schema|
|---|---|---|
|**FeeType**  <br>*required*|The type of fee charged to a seller.|string|
|**FeeAmount**  <br>*required*|The amount charged for a given fee.|[MoneyType](#moneytype)|
|**FeePromotion**  <br>*optional*|The promotion amount for a given fee.|[MoneyType](#moneytype)|
|**TaxAmount**  <br>*optional*|The tax amount for a given fee.|[MoneyType](#moneytype)|
|**FinalFee**  <br>*required*|The final fee amount for a given fee.|[MoneyType](#moneytype)|


<a name="moneytype"></a>
### MoneyType

|Name|Description|Schema|
|---|---|---|
|**CurrencyCode**  <br>*optional*|The currency code in ISO 4217 format.|string|
|**Amount**  <br>*optional*|The monetary value.|number|


<a name="optionalfulfillmentprogram"></a>
### OptionalFulfillmentProgram
An optional enrollment program for which to return the estimated fees when the offer is fulfilled by Amazon (IsAmazonFulfilled is set to true).

*Type* : enum


|Value|Description|
|---|---|
|**FBA_CORE**|Returns the standard Amazon fulfillment fees for the offer. This is the default.|
|**FBA_SNL**|Returns the Small and Light fees for the offer. The FBA Small and Light program offers reduced fulfillment costs on qualified items.|
|**FBA_EFN**|Returns the cross-border European Fulfillment Network fees across EU countries for the offer.|

