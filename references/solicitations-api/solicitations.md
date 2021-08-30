# Selling Partner API for Solicitations


<a name="overview"></a>
## Overview
With the Solicitations API you can build applications that send non-critical solicitations to buyers. You can get a list of solicitation types that are available for an order that you specify, then call an operation that sends a solicitation to the buyer for that order. Buyers cannot respond to solicitations sent by this API, and these solicitations do not appear in the Messaging section of Seller Central or in the recipient's Message Center. The Solicitations API returns responses that are formed according to the <a href=https://tools.ietf.org/html/draft-kelly-json-hal-08>JSON Hypertext Application Language</a> (HAL) standard.


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

* `application/hal+json`


### Operations
[getSolicitationActionsForOrder](#getsolicitationactionsfororder)<br>[createProductReviewAndSellerFeedbackSolicitation](#createproductreviewandsellerfeedbacksolicitation)<br>
<a name="paths"></a>
## Paths

<a name="getsolicitationactionsfororder"></a>
### GET /solicitations/v1/orders/{amazonOrderId}
**Operation: getSolicitationActionsForOrder**

#### Description
Returns a list of solicitation types that are available for an order that you specify. A solicitation type is represented by an actions object, which contains a path and query parameter(s). You can use the path and parameter(s) to call an operation that sends a solicitation. Currently only the productReviewAndSellerFeedbackSolicitation solicitation type is available.

**Usage Plan:**

| Rate (requests per second) | Burst |
| ---- | ---- |
| 1 | 5 |

For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**amazonOrderId**  <br>*required*|An Amazon order identifier. This specifies the order for which you want a list of available solicitation types.|string|
|**Query**|**marketplaceIds**  <br>*required*|A marketplace identifier. This specifies the marketplace in which the order was placed. Only one marketplace can be specified.<br>**Max count** : 1|< string > array|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Returns hypermedia links under the _links.actions key that specify which solicitation actions are allowed for the order.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetSolicitationActionsForOrderResponse](#getsolicitationactionsfororderresponse)|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetSolicitationActionsForOrderResponse](#getsolicitationactionsfororderresponse)|
|**403**|Indicates that access to the resource is forbidden. Possible reasons include Access Denied, Unauthorized, Expired Token, or Invalid Signature.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetSolicitationActionsForOrderResponse](#getsolicitationactionsfororderresponse)|
|**404**|The resource specified does not exist.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetSolicitationActionsForOrderResponse](#getsolicitationactionsfororderresponse)|
|**413**|The request size exceeded the maximum accepted size.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetSolicitationActionsForOrderResponse](#getsolicitationactionsfororderresponse)|
|**415**|The request payload is in an unsupported format.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetSolicitationActionsForOrderResponse](#getsolicitationactionsfororderresponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetSolicitationActionsForOrderResponse](#getsolicitationactionsfororderresponse)|
|**500**|An unexpected condition occurred that prevented the server from fulfilling the request.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetSolicitationActionsForOrderResponse](#getsolicitationactionsfororderresponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetSolicitationActionsForOrderResponse](#getsolicitationactionsfororderresponse)|


<a name="createproductreviewandsellerfeedbacksolicitation"></a>
### POST /solicitations/v1/orders/{amazonOrderId}/solicitations/productReviewAndSellerFeedback
**Operation: createProductReviewAndSellerFeedbackSolicitation**

#### Description
Sends a solicitation to a buyer asking for seller feedback and a product review for the specified order. Send only one productReviewAndSellerFeedback or free form proactive message per order.

**Usage Plan:**

| Rate (requests per second) | Burst |
| ---- | ---- |
| 1 | 5 |

For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**amazonOrderId**  <br>*required*|An Amazon order identifier. This specifies the order for which a solicitation is sent.|string|
|**Query**|**marketplaceIds**  <br>*required*|A marketplace identifier. This specifies the marketplace in which the order was placed. Only one marketplace can be specified.<br>**Max count** : 1|< string > array|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**201**|The message was created for the order.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[CreateProductReviewAndSellerFeedbackSolicitationResponse](#createproductreviewandsellerfeedbacksolicitationresponse)|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[CreateProductReviewAndSellerFeedbackSolicitationResponse](#createproductreviewandsellerfeedbacksolicitationresponse)|
|**403**|Indicates that access to the resource is forbidden. Possible reasons include Access Denied, Unauthorized, Expired Token, or Invalid Signature.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[CreateProductReviewAndSellerFeedbackSolicitationResponse](#createproductreviewandsellerfeedbacksolicitationresponse)|
|**404**|The resource specified does not exist.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[CreateProductReviewAndSellerFeedbackSolicitationResponse](#createproductreviewandsellerfeedbacksolicitationresponse)|
|**413**|The request size exceeded the maximum accepted size.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[CreateProductReviewAndSellerFeedbackSolicitationResponse](#createproductreviewandsellerfeedbacksolicitationresponse)|
|**415**|The request payload is in an unsupported format.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[CreateProductReviewAndSellerFeedbackSolicitationResponse](#createproductreviewandsellerfeedbacksolicitationresponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[CreateProductReviewAndSellerFeedbackSolicitationResponse](#createproductreviewandsellerfeedbacksolicitationresponse)|
|**500**|An unexpected condition occurred that prevented the server from fulfilling the request.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[CreateProductReviewAndSellerFeedbackSolicitationResponse](#createproductreviewandsellerfeedbacksolicitationresponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[CreateProductReviewAndSellerFeedbackSolicitationResponse](#createproductreviewandsellerfeedbacksolicitationresponse)|


<a name="definitions"></a>
## Definitions

<a name="linkobject"></a>
### LinkObject
A Link object.


|Name|Description|Schema|
|---|---|---|
|**href**  <br>*required*|A URI for this object.|string|
|**name**  <br>*optional*|An identifier for this object.|string|


<a name="solicitationsaction"></a>
### SolicitationsAction
A simple object containing the name of the template.


|Name|Schema|
|---|---|
|**name**  <br>*required*|string|


<a name="schema"></a>
### Schema
A JSON schema document describing the expected payload of the action. This object can be validated against <a href=http://json-schema.org/draft-04/schema>http://json-schema.org/draft-04/schema</a>.

*Type* : object


<a name="getsolicitationactionsfororderresponse"></a>
### GetSolicitationActionsForOrderResponse
The response schema for the getSolicitationActionsForOrder operation.


|Name|Description|Schema|
|---|---|---|
|**_links**  <br>*optional*|-|[_links](#getsolicitationactionsfororderresponse-links)|
|**_embedded**  <br>*optional*|-|[_embedded](#getsolicitationactionsfororderresponse-embedded)|
|**errors**  <br>*optional*|A list of error responses returned when a request is unsuccessful.|[ErrorList](#errorlist)|

<a name="getsolicitationactionsfororderresponse-links"></a>
**_links**

|Name|Description|Schema|
|---|---|---|
|**self**  <br>*required*|-|[LinkObject](#linkobject)|
|**actions**  <br>*required*|Eligible actions for the specified amazonOrderId.|< [LinkObject](#linkobject) > array|

<a name="getsolicitationactionsfororderresponse-embedded"></a>
**_embedded**

|Name|Schema|
|---|---|
|**actions**  <br>*required*|< [GetSolicitationActionResponse](#getsolicitationactionresponse) > array|


<a name="getsolicitationactionresponse"></a>
### GetSolicitationActionResponse
Describes a solicitation action that can be taken for an order. Provides a JSON Hypertext Application Language (HAL) link to the JSON schema document that describes the expected input.


|Name|Description|Schema|
|---|---|---|
|**_links**  <br>*optional*|-|[_links](#getsolicitationactionresponse-links)|
|**_embedded**  <br>*optional*|-|[_embedded](#getsolicitationactionresponse-embedded)|
|**payload**  <br>*optional*|A simple object containing the name of the template.|[SolicitationsAction](#solicitationsaction)|
|**errors**  <br>*optional*|A list of error responses returned when a request is unsuccessful.|[ErrorList](#errorlist)|

<a name="getsolicitationactionresponse-links"></a>
**_links**

|Name|Schema|
|---|---|
|**self**  <br>*required*|[LinkObject](#linkobject)|
|**schema**  <br>*required*|[LinkObject](#linkobject)|

<a name="getsolicitationactionresponse-embedded"></a>
**_embedded**

|Name|Schema|
|---|---|
|**schema**  <br>*optional*|[GetSchemaResponse](#getschemaresponse)|


<a name="getschemaresponse"></a>
### GetSchemaResponse

|Name|Description|Schema|
|---|---|---|
|**_links**  <br>*optional*|-|[_links](#getschemaresponse-links)|
|**payload**  <br>*optional*|A JSON schema document describing the expected payload of the action. This object can be validated against <a href=http://json-schema.org/draft-04/schema>http://json-schema.org/draft-04/schema</a>.|[Schema](#schema)|
|**errors**  <br>*optional*|A list of error responses returned when a request is unsuccessful.|[ErrorList](#errorlist)|

<a name="getschemaresponse-links"></a>
**_links**

|Name|Schema|
|---|---|
|**self**  <br>*required*|[LinkObject](#linkobject)|


<a name="createproductreviewandsellerfeedbacksolicitationresponse"></a>
### CreateProductReviewAndSellerFeedbackSolicitationResponse
The response schema for the createProductReviewAndSellerFeedbackSolicitation operation.


|Name|Description|Schema|
|---|---|---|
|**errors**  <br>*optional*|A list of error responses returned when a request is unsuccessful.|[ErrorList](#errorlist)|


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
|**message**  <br>*required*|A message that describes the error condition in a human-readable form.|string|
|**details**  <br>*optional*|Additional details that can help the caller understand or fix the issue.|string|

