# Selling Partner API for Shipping


<a name="overview"></a>
## Overview
Provides programmatic access to Amazon Shipping APIs.

 **Note:** If you are new to the Amazon Shipping API, refer to the latest version of <a href="https://developer-docs.amazon.com/amazon-shipping/docs/shipping-api-v2-reference">Amazon Shipping API (v2)</a> on the <a href="https://developer-docs.amazon.com/amazon-shipping/">Amazon Shipping Developer Documentation</a> site.


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
[createShipment](#createshipment)<br>[getShipment](#getshipment)<br>[cancelShipment](#cancelshipment)<br>[purchaseLabels](#purchaselabels)<br>[retrieveShippingLabel](#retrieveshippinglabel)<br>[purchaseShipment](#purchaseshipment)<br>[getRates](#getrates)<br>[getAccount](#getaccount)<br>[getTrackingInformation](#gettrackinginformation)<br>
<a name="paths"></a>
## Paths

<a name="createshipment"></a>
### POST /shipping/v1/shipments
**Operation: createShipment**

#### Description
Create a new shipment.

**Usage Plan:**

| Rate (requests per second) | Burst |
| ---- | ---- |
| 5 | 15 |

The `x-amzn-RateLimit-Limit` response header returns the usage plan rate limits that were applied to the requested operation, when available. The table above indicates the default rate and burst values for this operation. Selling partners whose business demands require higher throughput may see higher rate and burst values than those shown here. For more information, see [Usage Plans and Rate Limits in the Selling Partner API](doc:usage-plans-and-rate-limits-in-the-sp-api).


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Body**|**body**  <br>*required*|The request schema for the createShipment operation.|[CreateShipmentRequest](#createshipmentrequest)|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Success.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference id.|[CreateShipmentResponse](#createshipmentresponse)|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference id.|[CreateShipmentResponse](#createshipmentresponse)|
|**401**|The request's Authorization header is not formatted correctly or does not contain a valid token.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference id.|[CreateShipmentResponse](#createshipmentresponse)|
|**403**|403 can be caused for reasons like Access Denied, Unauthorized, Expired Token, Invalid Signature or Resource Not Found.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference id.|[CreateShipmentResponse](#createshipmentresponse)|
|**404**|The resource specified does not exist.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference id.|[CreateShipmentResponse](#createshipmentresponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference id.|[CreateShipmentResponse](#createshipmentresponse)|
|**500**|Encountered an unexpected condition which prevented the server from fulfilling the request.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference id.|[CreateShipmentResponse](#createshipmentresponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference id.|[CreateShipmentResponse](#createshipmentresponse)|


<a name="getshipment"></a>
### GET /shipping/v1/shipments/{shipmentId}
**Operation: getShipment**

#### Description
Return the entire shipment object for the shipmentId.

**Usage Plan:**

| Rate (requests per second) | Burst |
| ---- | ---- |
| 5 | 15 |

For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Schema|
|---|---|---|
|**Path**|**shipmentId**  <br>*required*|string|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Success.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference id.|[GetShipmentResponse](#getshipmentresponse)|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference id.|[GetShipmentResponse](#getshipmentresponse)|
|**401**|The request's Authorization header is not formatted correctly or does not contain a valid token.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference id.|[GetShipmentResponse](#getshipmentresponse)|
|**403**|403 can be caused for reasons like Access Denied, Unauthorized, Expired Token, Invalid Signature or Resource Not Found.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference id.|[GetShipmentResponse](#getshipmentresponse)|
|**404**|The resource specified does not exist.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference id.|[GetShipmentResponse](#getshipmentresponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference id.|[GetShipmentResponse](#getshipmentresponse)|
|**500**|Encountered an unexpected condition which prevented the server from fulfilling the request.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference id.|[GetShipmentResponse](#getshipmentresponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference id.|[GetShipmentResponse](#getshipmentresponse)|


<a name="cancelshipment"></a>
### POST /shipping/v1/shipments/{shipmentId}/cancel
**Operation: cancelShipment**

#### Description
Cancel a shipment by the given shipmentId.

**Usage Plan:**

| Rate (requests per second) | Burst |
| ---- | ---- |
| 5 | 15 |

For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Schema|
|---|---|---|
|**Path**|**shipmentId**  <br>*required*|string|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Success.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference id.|[CancelShipmentResponse](#cancelshipmentresponse)|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference id.|[CancelShipmentResponse](#cancelshipmentresponse)|
|**401**|The request's Authorization header is not formatted correctly or does not contain a valid token.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference id.|[CancelShipmentResponse](#cancelshipmentresponse)|
|**403**|403 can be caused for reasons like Access Denied, Unauthorized, Expired Token, Invalid Signature or Resource Not Found.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference id.|[CancelShipmentResponse](#cancelshipmentresponse)|
|**404**|The resource specified does not exist.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference id.|[CancelShipmentResponse](#cancelshipmentresponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference id.|[CancelShipmentResponse](#cancelshipmentresponse)|
|**500**|Encountered an unexpected condition which prevented the server from fulfilling the request.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference id.|[CancelShipmentResponse](#cancelshipmentresponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference id.|[CancelShipmentResponse](#cancelshipmentresponse)|


<a name="purchaselabels"></a>
### POST /shipping/v1/shipments/{shipmentId}/purchaseLabels
**Operation: purchaseLabels**

#### Description
Purchase shipping labels based on a given rate.

**Usage Plan:**

| Rate (requests per second) | Burst |
| ---- | ---- |
| 5 | 15 |

For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**shipmentId**  <br>*required*|-|string|
|**Body**|**body**  <br>*required*|The request schema for the purchaseLabels operation.|[PurchaseLabelsRequest](#purchaselabelsrequest)|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Success.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference id.|[PurchaseLabelsResponse](#purchaselabelsresponse)|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference id.|[PurchaseLabelsResponse](#purchaselabelsresponse)|
|**401**|The request's Authorization header is not formatted correctly or does not contain a valid token.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference id.|[PurchaseLabelsResponse](#purchaselabelsresponse)|
|**403**|403 can be caused for reasons like Access Denied, Unauthorized, Expired Token, Invalid Signature or Resource Not Found.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference id.|[PurchaseLabelsResponse](#purchaselabelsresponse)|
|**404**|The resource specified does not exist.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference id.|[PurchaseLabelsResponse](#purchaselabelsresponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference id.|[PurchaseLabelsResponse](#purchaselabelsresponse)|
|**500**|Encountered an unexpected condition which prevented the server from fulfilling the request.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference id.|[PurchaseLabelsResponse](#purchaselabelsresponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference id.|[PurchaseLabelsResponse](#purchaselabelsresponse)|


<a name="retrieveshippinglabel"></a>
### POST /shipping/v1/shipments/{shipmentId}/containers/{trackingId}/label
**Operation: retrieveShippingLabel**

#### Description
Retrieve shipping label based on the shipment id and tracking id.

**Usage Plan:**

| Rate (requests per second) | Burst |
| ---- | ---- |
| 5 | 15 |

For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**shipmentId**  <br>*required*|-|string|
|**Path**|**trackingId**  <br>*required*|-|string|
|**Body**|**body**  <br>*required*|The request schema for the retrieveShippingLabel operation.|[RetrieveShippingLabelRequest](#retrieveshippinglabelrequest)|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Success.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference id.|[RetrieveShippingLabelResponse](#retrieveshippinglabelresponse)|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference id.|[RetrieveShippingLabelResponse](#retrieveshippinglabelresponse)|
|**401**|The request's Authorization header is not formatted correctly or does not contain a valid token.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference id.|[RetrieveShippingLabelResponse](#retrieveshippinglabelresponse)|
|**403**|403 can be caused for reasons like Access Denied, Unauthorized, Expired Token, Invalid Signature or Resource Not Found.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference id.|[RetrieveShippingLabelResponse](#retrieveshippinglabelresponse)|
|**404**|The resource specified does not exist.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference id.|[RetrieveShippingLabelResponse](#retrieveshippinglabelresponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference id.|[RetrieveShippingLabelResponse](#retrieveshippinglabelresponse)|
|**500**|Encountered an unexpected condition which prevented the server from fulfilling the request.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference id.|[RetrieveShippingLabelResponse](#retrieveshippinglabelresponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference id.|[RetrieveShippingLabelResponse](#retrieveshippinglabelresponse)|


<a name="purchaseshipment"></a>
### POST /shipping/v1/purchaseShipment
**Operation: purchaseShipment**

#### Description
Purchase shipping labels.

**Usage Plan:**

| Rate (requests per second) | Burst |
| ---- | ---- |
| 5 | 15 |

For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Body**|**body**  <br>*required*|The payload schema for the purchaseShipment operation.|[PurchaseShipmentRequest](#purchaseshipmentrequest)|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Success.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference id.|[PurchaseShipmentResponse](#purchaseshipmentresponse)|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference id.|[PurchaseShipmentResponse](#purchaseshipmentresponse)|
|**401**|The request's Authorization header is not formatted correctly or does not contain a valid token.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference id.|[PurchaseShipmentResponse](#purchaseshipmentresponse)|
|**403**|403 can be caused for reasons like Access Denied, Unauthorized, Expired Token, Invalid Signature or Resource Not Found.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference id.|[PurchaseShipmentResponse](#purchaseshipmentresponse)|
|**404**|The resource specified does not exist.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference id.|[PurchaseShipmentResponse](#purchaseshipmentresponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference id.|[PurchaseShipmentResponse](#purchaseshipmentresponse)|
|**500**|Encountered an unexpected condition which prevented the server from fulfilling the request.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference id.|[PurchaseShipmentResponse](#purchaseshipmentresponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference id.|[PurchaseShipmentResponse](#purchaseshipmentresponse)|


<a name="getrates"></a>
### POST /shipping/v1/rates
**Operation: getRates**

#### Description
Get service rates.

**Usage Plan:**

| Rate (requests per second) | Burst |
| ---- | ---- |
| 5 | 15 |

For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Body**|**body**  <br>*required*|The payload schema for the getRates operation.|[GetRatesRequest](#getratesrequest)|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Success.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference id.|[GetRatesResponse](#getratesresponse)|
|**400**|Request is missing or has invalid parameters and cannot be parsed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference id.|[GetRatesResponse](#getratesresponse)|
|**401**|The request's Authorization header is not formatted correctly or does not contain a valid token.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference id.|[GetRatesResponse](#getratesresponse)|
|**403**|403 can be caused for reasons like Access Denied, Unauthorized, Expired Token, Invalid Signature or Resource Not Found.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference id.|[GetRatesResponse](#getratesresponse)|
|**404**|The resource specified does not exist.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference id.|[GetRatesResponse](#getratesresponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference id.|[GetRatesResponse](#getratesresponse)|
|**500**|Encountered an unexpected condition which prevented the server from fulfilling the request.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference id.|[GetRatesResponse](#getratesresponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference id.|[GetRatesResponse](#getratesresponse)|


<a name="getaccount"></a>
### GET /shipping/v1/account
**Operation: getAccount**

#### Description
Verify if the current account is valid.

**Usage Plan:**

| Rate (requests per second) | Burst |
| ---- | ---- |
| 5 | 15 |

For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|The account was valid.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference id.|[GetAccountResponse](#getaccountresponse)|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference id.|[GetAccountResponse](#getaccountresponse)|
|**401**|The request's Authorization header is not formatted correctly or does not contain a valid token.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference id.|[GetAccountResponse](#getaccountresponse)|
|**403**|403 can be caused for reasons like Access Denied, Unauthorized, Expired Token, Invalid Signature or Resource Not Found.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference id.|[GetAccountResponse](#getaccountresponse)|
|**404**|The resource specified does not exist.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference id.|[GetAccountResponse](#getaccountresponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference id.|[GetAccountResponse](#getaccountresponse)|
|**500**|Encountered an unexpected condition which prevented the server from fulfilling the request.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference id.|[GetAccountResponse](#getaccountresponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference id.|[GetAccountResponse](#getaccountresponse)|


<a name="gettrackinginformation"></a>
### GET /shipping/v1/tracking/{trackingId}
**Operation: getTrackingInformation**

#### Description
Return the tracking information of a shipment.

**Usage Plan:**

| Rate (requests per second) | Burst |
| ---- | ---- |
| 1 | 1 |

For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Schema|
|---|---|---|
|**Path**|**trackingId**  <br>*required*|string|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Success.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference id.|[GetTrackingInformationResponse](#gettrackinginformationresponse)|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference id.|[GetTrackingInformationResponse](#gettrackinginformationresponse)|
|**401**|The request's Authorization header is not formatted correctly or does not contain a valid token.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference id.|[GetTrackingInformationResponse](#gettrackinginformationresponse)|
|**403**|403 can be caused for reasons like Access Denied, Unauthorized, Expired Token, Invalid Signature or Resource Not Found.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference id.|[GetTrackingInformationResponse](#gettrackinginformationresponse)|
|**404**|The resource specified does not exist.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference id.|[GetTrackingInformationResponse](#gettrackinginformationresponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference id.|[GetTrackingInformationResponse](#gettrackinginformationresponse)|
|**500**|Encountered an unexpected condition which prevented the server from fulfilling the request.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference id.|[GetTrackingInformationResponse](#gettrackinginformationresponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference id.|[GetTrackingInformationResponse](#gettrackinginformationresponse)|


<a name="definitions"></a>
## Definitions

<a name="error"></a>
### Error
Error response returned when the request is unsuccessful.


|Name|Description|Schema|
|---|---|---|
|**code**  <br>*required*|An error code that identifies the type of error that occured.|string|
|**message**  <br>*required*|A message that describes the error condition in a human-readable form.|string|
|**details**  <br>*optional*|Additional details that can help the caller understand or fix the issue.|string|


<a name="errorlist"></a>
### ErrorList
A list of error responses returned when a request is unsuccessful.

*Type* : < [Error](#error) > array


<a name="accountid"></a>
### AccountId
This is the Amazon Shipping account id generated during the Amazon Shipping onboarding process.

*Type* : string

**maxLength** : 10  

<a name="shipmentid"></a>
### ShipmentId
The unique shipment identifier.

*Type* : string


<a name="clientreferenceid"></a>
### ClientReferenceId
Client reference id.

*Type* : string

**maxLength** : 40  

<a name="containerreferenceid"></a>
### ContainerReferenceId
An identifier for the container. This must be unique within all the containers in the same shipment.

*Type* : string

**maxLength** : 40  

<a name="eventcode"></a>
### EventCode
The event code of a shipment, such as Departed, Received, and ReadyForReceive.

*Type* : string

**minLength** : 1  
**maxLength** : 60  

<a name="stateorregion"></a>
### StateOrRegion
The state or region where the person, business or institution is located.

*Type* : string


<a name="city"></a>
### City
The city where the person, business or institution is located.

*Type* : string

**minLength** : 1  
**maxLength** : 50  

<a name="countrycode"></a>
### CountryCode
The two digit country code. In ISO 3166-1 alpha-2 format.

*Type* : string

**minLength** : 2  
**maxLength** : 2  

<a name="postalcode"></a>
### PostalCode
The postal code of that address. It contains a series of letters or digits or both, sometimes including spaces or punctuation.

*Type* : string

**minLength** : 1  
**maxLength** : 20  

<a name="location"></a>
### Location
The location where the person, business or institution is located.


|Name|Description|Schema|
|---|---|---|
|**stateOrRegion**  <br>*optional*|The state or region where the person, business or institution is located.|[StateOrRegion](#stateorregion)|
|**city**  <br>*optional*|The city where the person, business or institution is located.|[City](#city)|
|**countryCode**  <br>*optional*|The two digit country code. In ISO 3166-1 alpha-2 format.|[CountryCode](#countrycode)|
|**postalCode**  <br>*optional*|The postal code of that address. It contains a series of letters or digits or both, sometimes including spaces or punctuation.|[PostalCode](#postalcode)|


<a name="event"></a>
### Event
An event of a shipment


|Name|Description|Schema|
|---|---|---|
|**eventCode**  <br>*required*|The event code of a shipment, such as Departed, Received, and ReadyForReceive.|[EventCode](#eventcode)|
|**eventTime**  <br>*required*|The date and time of an event for a shipment.|string (date-time)|
|**location**  <br>*optional*|The location where the person, business or institution is located.|[Location](#location)|


<a name="eventlist"></a>
### EventList
A list of events of a shipment.

*Type* : < [Event](#event) > array


<a name="trackingid"></a>
### TrackingId
The tracking id generated to each shipment. It contains a series of letters or digits or both.

*Type* : string

**minLength** : 1  
**maxLength** : 60  

<a name="trackingsummary"></a>
### TrackingSummary
The tracking summary.


|Name|Description|Schema|
|---|---|---|
|**status**  <br>*optional*|The derived status based on the events in the eventHistory.<br>**minLength** : 1<br>**maxLength** : 60|string|


<a name="promiseddeliverydate"></a>
### PromisedDeliveryDate
The promised delivery date and time of a shipment.

*Type* : string (date-time)


<a name="address"></a>
### Address
The address.


|Name|Description|Schema|
|---|---|---|
|**name**  <br>*required*|The name of the person, business or institution at that address.<br>**minLength** : 1<br>**maxLength** : 50|string|
|**addressLine1**  <br>*required*|First line of that address.<br>**minLength** : 1<br>**maxLength** : 60|string|
|**addressLine2**  <br>*optional*|Additional address information, if required.<br>**minLength** : 1<br>**maxLength** : 60|string|
|**addressLine3**  <br>*optional*|Additional address information, if required.<br>**minLength** : 1<br>**maxLength** : 60|string|
|**stateOrRegion**  <br>*required*|The state or region where the person, business or institution is located.|[StateOrRegion](#stateorregion)|
|**city**  <br>*required*|The city where the person, business or institution is located.|[City](#city)|
|**countryCode**  <br>*required*|The two digit country code. In ISO 3166-1 alpha-2 format.|[CountryCode](#countrycode)|
|**postalCode**  <br>*required*|The postal code of that address. It contains a series of letters or digits or both, sometimes including spaces or punctuation.|[PostalCode](#postalcode)|
|**email**  <br>*optional*|The email address of the contact associated with the address.<br>**maxLength** : 64|string|
|**copyEmails**  <br>*optional*|The email cc addresses of the contact associated with the address.|< string > array|
|**phoneNumber**  <br>*optional*|The phone number of the person, business or institution located at that address.<br>**minLength** : 1<br>**maxLength** : 20|string|


<a name="timerange"></a>
### TimeRange
The time range.


|Name|Description|Schema|
|---|---|---|
|**start**  <br>*optional*|The start date and time. This defaults to the current date and time.|string (date-time)|
|**end**  <br>*optional*|The end date and time. This must come after the value of start. This defaults to the next business day from the start.|string (date-time)|


<a name="shippingpromiseset"></a>
### ShippingPromiseSet
The promised delivery time and pickup time.


|Name|Description|Schema|
|---|---|---|
|**deliveryWindow**  <br>*optional*|The time window in which the shipment will be delivered.|[TimeRange](#timerange)|
|**receiveWindow**  <br>*optional*|The time window in which Amazon Shipping will pick up the shipment.|[TimeRange](#timerange)|


<a name="servicetype"></a>
### ServiceType
The type of shipping service that will be used for the service offering.

*Type* : enum


|Value|Description|
|---|---|
|**Amazon Shipping Ground**|Amazon Shipping Ground.|
|**Amazon Shipping Standard**|Amazon Shipping Standard.|
|**Amazon Shipping Premium**|Amazon Shipping Premium.|


<a name="servicetypelist"></a>
### ServiceTypeList
A list of service types that can be used to send the shipment.

*Type* : < [ServiceType](#servicetype) > array


<a name="rate"></a>
### Rate
The available rate that can be used to send the shipment


|Name|Description|Schema|
|---|---|---|
|**rateId**  <br>*optional*|An identifier for the rate.|string|
|**totalCharge**  <br>*optional*|The total charge that will be billed for the rate.|[Currency](#currency)|
|**billedWeight**  <br>*optional*|The weight that was used to calculate the totalCharge.|[Weight](#weight)|
|**expirationTime**  <br>*optional*|The time after which the offering will expire.|string (date-time)|
|**serviceType**  <br>*optional*|The type of shipping service that will be used for the service offering.|[ServiceType](#servicetype)|
|**promise**  <br>*optional*|The promised delivery time and pickup time.|[ShippingPromiseSet](#shippingpromiseset)|


<a name="ratelist"></a>
### RateList
A list of all the available rates that can be used to send the shipment.

*Type* : < [Rate](#rate) > array


<a name="rateid"></a>
### RateId
An identifier for the rating.

*Type* : string


<a name="acceptedrate"></a>
### AcceptedRate
The specific rate purchased for the shipment, or null if unpurchased.


|Name|Description|Schema|
|---|---|---|
|**totalCharge**  <br>*optional*|The total charge that will be billed for the rate.|[Currency](#currency)|
|**billedWeight**  <br>*optional*|The weight that was used to calculate the totalCharge.|[Weight](#weight)|
|**serviceType**  <br>*optional*|The type of shipping service that will be used for the service offering.|[ServiceType](#servicetype)|
|**promise**  <br>*optional*|The promised delivery time and pickup time.|[ShippingPromiseSet](#shippingpromiseset)|


<a name="servicerate"></a>
### ServiceRate
The specific rate for a shipping service, or null if no service available.


|Name|Description|Schema|
|---|---|---|
|**totalCharge**  <br>*required*|The total charge that will be billed for the rate.|[Currency](#currency)|
|**billableWeight**  <br>*required*|The weight that was used to calculate the totalCharge.|[Weight](#weight)|
|**serviceType**  <br>*required*|The type of shipping service that will be used for the service offering.|[ServiceType](#servicetype)|
|**promise**  <br>*required*|The promised delivery time and pickup time.|[ShippingPromiseSet](#shippingpromiseset)|


<a name="serviceratelist"></a>
### ServiceRateList
A list of service rates.

*Type* : < [ServiceRate](#servicerate) > array


<a name="party"></a>
### Party
The account related with the shipment.


|Name|Description|Schema|
|---|---|---|
|**accountId**  <br>*optional*|This is the Amazon Shipping account id generated during the Amazon Shipping onboarding process.|[AccountId](#accountid)|


<a name="currency"></a>
### Currency
The total value of all items in the container.


|Name|Description|Schema|
|---|---|---|
|**value**  <br>*required*|The amount of currency.|number|
|**unit**  <br>*required*|A 3-character currency code.<br>**minLength** : 3<br>**maxLength** : 3|string|


<a name="dimensions"></a>
### Dimensions
A set of measurements for a three-dimensional object.


|Name|Description|Schema|
|---|---|---|
|**length**  <br>*required*|The length of the container.|number|
|**width**  <br>*required*|The width of the container.|number|
|**height**  <br>*required*|The height of the container.|number|
|**unit**  <br>*required*|The unit of these measurements.|enum ([Unit](#unit-subgroup-2))|


<a name="weight"></a>
### Weight
The weight.


|Name|Description|Schema|
|---|---|---|
|**unit**  <br>*required*|The unit of measurement.|enum ([Unit](#unit-subgroup-1))|
|**value**  <br>*required*|The measurement value.|number|


<a name="containeritem"></a>
### ContainerItem
Item in the container.


|Name|Description|Schema|
|---|---|---|
|**quantity**  <br>*required*|The quantity of the items of this type in the container.|number|
|**unitPrice**  <br>*required*|The unit price of an item of this type (the total value of this item type in the container is unitPrice <li> quantity).</li>|[Currency](#currency)|
|**unitWeight**  <br>*required*|The unit weight of an item of this type (the total weight of this item type in the container is unitWeight <li> quantity).</li>|[Weight](#weight)|
|**title**  <br>*required*|A descriptive title of the item.<br>**maxLength** : 30|string|


<a name="container"></a>
### Container
Container in the shipment.


|Name|Description|Schema|
|---|---|---|
|**containerType**  <br>*optional*|The type of physical container being used. (always 'PACKAGE')|enum ([ContainerType](#containertype))|
|**containerReferenceId**  <br>*required*|An identifier for the container. This must be unique within all the containers in the same shipment.|[ContainerReferenceId](#containerreferenceid)|
|**value**  <br>*required*|The total value of all items in the container.|[Currency](#currency)|
|**dimensions**  <br>*required*|The length, width, height, and weight of the container.|[Dimensions](#dimensions)|
|**items**  <br>*required*|A list of the items in the container.|< [ContainerItem](#containeritem) > array|
|**weight**  <br>*required*|The weight of the container.|[Weight](#weight)|


<a name="containerlist"></a>
### ContainerList
A list of container.

*Type* : < [Container](#container) > array


<a name="containerspecification"></a>
### ContainerSpecification
Container specification for checking the service rate.


|Name|Description|Schema|
|---|---|---|
|**dimensions**  <br>*required*|The length, width, and height of the container.|[Dimensions](#dimensions)|
|**weight**  <br>*required*|The weight of the container.|[Weight](#weight)|


<a name="containerspecificationlist"></a>
### ContainerSpecificationList
A list of container specifications.

*Type* : < [ContainerSpecification](#containerspecification) > array


<a name="label"></a>
### Label
The label details of the container.


|Name|Description|Schema|
|---|---|---|
|**labelStream**  <br>*optional*|Contains binary image data encoded as a base-64 string.|[LabelStream](#labelstream)|
|**labelSpecification**  <br>*optional*|The label specification info.|[LabelSpecification](#labelspecification)|


<a name="labelresult"></a>
### LabelResult
Label details including label stream, format, size.


|Name|Description|Schema|
|---|---|---|
|**containerReferenceId**  <br>*optional*|An identifier for the container. This must be unique within all the containers in the same shipment.|[ContainerReferenceId](#containerreferenceid)|
|**trackingId**  <br>*optional*|The tracking identifier assigned to the container.|string|
|**label**  <br>*optional*|The label details of the container.|[Label](#label)|


<a name="labelresultlist"></a>
### LabelResultList
A list of label results

*Type* : < [LabelResult](#labelresult) > array


<a name="labelstream"></a>
### LabelStream
Contains binary image data encoded as a base-64 string.

*Type* : string


<a name="labelspecification"></a>
### LabelSpecification
The label specification info.


|Name|Description|Schema|
|---|---|---|
|**labelFormat**  <br>*required*|The format of the label. Enum of PNG only for now.|enum ([LabelFormat](#labelformat))|
|**labelStockSize**  <br>*required*|The label stock size specification in length and height. Enum of 4x6 only for now.|enum ([LabelStockSize](#labelstocksize))|


<a name="createshipmentrequest"></a>
### CreateShipmentRequest
The request schema for the createShipment operation.


|Name|Description|Schema|
|---|---|---|
|**clientReferenceId**  <br>*required*|Client reference id.|[ClientReferenceId](#clientreferenceid)|
|**shipTo**  <br>*required*|The address.|[Address](#address)|
|**shipFrom**  <br>*required*|The address.|[Address](#address)|
|**containers**  <br>*required*|A list of container.|[ContainerList](#containerlist)|


<a name="purchaselabelsrequest"></a>
### PurchaseLabelsRequest
The request schema for the purchaseLabels operation.


|Name|Description|Schema|
|---|---|---|
|**rateId**  <br>*required*|An identifier for the rating.|[RateId](#rateid)|
|**labelSpecification**  <br>*required*|The label specification info.|[LabelSpecification](#labelspecification)|


<a name="retrieveshippinglabelrequest"></a>
### RetrieveShippingLabelRequest
The request schema for the retrieveShippingLabel operation.


|Name|Description|Schema|
|---|---|---|
|**labelSpecification**  <br>*required*|The label specification info.|[LabelSpecification](#labelspecification)|


<a name="getratesrequest"></a>
### GetRatesRequest
The payload schema for the getRates operation.


|Name|Description|Schema|
|---|---|---|
|**shipTo**  <br>*required*|The address.|[Address](#address)|
|**shipFrom**  <br>*required*|The address.|[Address](#address)|
|**serviceTypes**  <br>*required*|A list of service types that can be used to send the shipment.|[ServiceTypeList](#servicetypelist)|
|**shipDate**  <br>*optional*|The start date and time. This defaults to the current date and time.|string (date-time)|
|**containerSpecifications**  <br>*required*|A list of container specifications.|[ContainerSpecificationList](#containerspecificationlist)|


<a name="purchaseshipmentrequest"></a>
### PurchaseShipmentRequest
The payload schema for the purchaseShipment operation.


|Name|Description|Schema|
|---|---|---|
|**clientReferenceId**  <br>*required*|Client reference id.|[ClientReferenceId](#clientreferenceid)|
|**shipTo**  <br>*required*|The address.|[Address](#address)|
|**shipFrom**  <br>*required*|The address.|[Address](#address)|
|**shipDate**  <br>*optional*|The start date and time. This defaults to the current date and time.|string (date-time)|
|**serviceType**  <br>*required*|The type of shipping service that will be used for the service offering.|[ServiceType](#servicetype)|
|**containers**  <br>*required*|A list of container.|[ContainerList](#containerlist)|
|**labelSpecification**  <br>*required*|The label specification info.|[LabelSpecification](#labelspecification)|


<a name="createshipmentresult"></a>
### CreateShipmentResult
The payload schema for the createShipment operation.


|Name|Description|Schema|
|---|---|---|
|**shipmentId**  <br>*required*|The unique shipment identifier.|[ShipmentId](#shipmentid)|
|**eligibleRates**  <br>*required*|A list of all the available rates that can be used to send the shipment.|[RateList](#ratelist)|


<a name="shipment"></a>
### Shipment
The shipment related data.


|Name|Description|Schema|
|---|---|---|
|**shipmentId**  <br>*required*|The unique shipment identifier.|[ShipmentId](#shipmentid)|
|**clientReferenceId**  <br>*required*|Client reference id.|[ClientReferenceId](#clientreferenceid)|
|**shipFrom**  <br>*required*|The address.|[Address](#address)|
|**shipTo**  <br>*required*|The address.|[Address](#address)|
|**acceptedRate**  <br>*optional*|The specific rate purchased for the shipment, or null if unpurchased.|[AcceptedRate](#acceptedrate)|
|**shipper**  <br>*optional*|The account related with the shipment.|[Party](#party)|
|**containers**  <br>*required*|A list of container.|[ContainerList](#containerlist)|


<a name="purchaselabelsresult"></a>
### PurchaseLabelsResult
The payload schema for the purchaseLabels operation.


|Name|Description|Schema|
|---|---|---|
|**shipmentId**  <br>*required*|The unique shipment identifier.|[ShipmentId](#shipmentid)|
|**clientReferenceId**  <br>*optional*|Client reference id.|[ClientReferenceId](#clientreferenceid)|
|**acceptedRate**  <br>*required*|The specific rate purchased for the shipment, or null if unpurchased.|[AcceptedRate](#acceptedrate)|
|**labelResults**  <br>*required*|A list of label results|[LabelResultList](#labelresultlist)|


<a name="retrieveshippinglabelresult"></a>
### RetrieveShippingLabelResult
The payload schema for the retrieveShippingLabel operation.


|Name|Description|Schema|
|---|---|---|
|**labelStream**  <br>*required*|Contains binary image data encoded as a base-64 string.|[LabelStream](#labelstream)|
|**labelSpecification**  <br>*required*|The label specification info.|[LabelSpecification](#labelspecification)|


<a name="account"></a>
### Account
The account related data.


|Name|Description|Schema|
|---|---|---|
|**accountId**  <br>*required*|This is the Amazon Shipping account id generated during the Amazon Shipping onboarding process.|[AccountId](#accountid)|


<a name="getratesresult"></a>
### GetRatesResult
The payload schema for the getRates operation.


|Name|Description|Schema|
|---|---|---|
|**serviceRates**  <br>*required*|A list of service rates.|[ServiceRateList](#serviceratelist)|


<a name="purchaseshipmentresult"></a>
### PurchaseShipmentResult
The payload schema for the purchaseShipment operation.


|Name|Description|Schema|
|---|---|---|
|**shipmentId**  <br>*required*|The unique shipment identifier.|[ShipmentId](#shipmentid)|
|**serviceRate**  <br>*required*|The specific rate for a shipping service, or null if no service available.|[ServiceRate](#servicerate)|
|**labelResults**  <br>*required*|A list of label results|[LabelResultList](#labelresultlist)|


<a name="trackinginformation"></a>
### TrackingInformation
The payload schema for the getTrackingInformation operation.


|Name|Description|Schema|
|---|---|---|
|**trackingId**  <br>*required*|The tracking id generated to each shipment. It contains a series of letters or digits or both.|[TrackingId](#trackingid)|
|**summary**  <br>*required*|The tracking summary.|[TrackingSummary](#trackingsummary)|
|**promisedDeliveryDate**  <br>*required*|The promised delivery date and time of a shipment.|[PromisedDeliveryDate](#promiseddeliverydate)|
|**eventHistory**  <br>*required*|A list of events of a shipment.|[EventList](#eventlist)|


<a name="createshipmentresponse"></a>
### CreateShipmentResponse
The response schema for the createShipment operation.


|Name|Description|Schema|
|---|---|---|
|**payload**  <br>*optional*|The payload for createShipment operation|[CreateShipmentResult](#createshipmentresult)|
|**errors**  <br>*optional*|Encountered errors for the operation.|[ErrorList](#errorlist)|


<a name="getshipmentresponse"></a>
### GetShipmentResponse
The response schema for the getShipment operation.


|Name|Description|Schema|
|---|---|---|
|**payload**  <br>*optional*|The payload for getShipment operation|[Shipment](#shipment)|
|**errors**  <br>*optional*|Encountered errors for the operation.|[ErrorList](#errorlist)|


<a name="getratesresponse"></a>
### GetRatesResponse
The response schema for the getRates operation.


|Name|Description|Schema|
|---|---|---|
|**payload**  <br>*optional*|The payload for getRates operation|[GetRatesResult](#getratesresult)|
|**errors**  <br>*optional*|Encountered errors for the operation.|[ErrorList](#errorlist)|


<a name="purchaseshipmentresponse"></a>
### PurchaseShipmentResponse
The response schema for the purchaseShipment operation.


|Name|Description|Schema|
|---|---|---|
|**payload**  <br>*optional*|The payload for purchaseShipment operation|[PurchaseShipmentResult](#purchaseshipmentresult)|
|**errors**  <br>*optional*|Encountered errors for the operation.|[ErrorList](#errorlist)|


<a name="cancelshipmentresponse"></a>
### CancelShipmentResponse
The response schema for the cancelShipment operation.


|Name|Description|Schema|
|---|---|---|
|**errors**  <br>*optional*|Encountered errors for the operation.|[ErrorList](#errorlist)|


<a name="purchaselabelsresponse"></a>
### PurchaseLabelsResponse
The response schema for the purchaseLabels operation.


|Name|Description|Schema|
|---|---|---|
|**payload**  <br>*optional*|The payload for purchaseLabels operation|[PurchaseLabelsResult](#purchaselabelsresult)|
|**errors**  <br>*optional*|Encountered errors for the operation.|[ErrorList](#errorlist)|


<a name="retrieveshippinglabelresponse"></a>
### RetrieveShippingLabelResponse
The response schema for the retrieveShippingLabel operation.


|Name|Description|Schema|
|---|---|---|
|**payload**  <br>*optional*|The payload for retrieveShippingLabel operation|[RetrieveShippingLabelResult](#retrieveshippinglabelresult)|
|**errors**  <br>*optional*|Encountered errors for the operation.|[ErrorList](#errorlist)|


<a name="getaccountresponse"></a>
### GetAccountResponse
The response schema for the getAccount operation.


|Name|Description|Schema|
|---|---|---|
|**payload**  <br>*optional*|The payload for getAccount operation|[Account](#account)|
|**errors**  <br>*optional*|Encountered errors for the operation.|[ErrorList](#errorlist)|


<a name="gettrackinginformationresponse"></a>
### GetTrackingInformationResponse
The response schema for the getTrackingInformation operation.


|Name|Description|Schema|
|---|---|---|
|**payload**  <br>*optional*|The payload for getTrackingInformation operation|[TrackingInformation](#trackinginformation)|
|**errors**  <br>*optional*|Encountered errors for the operation.|[ErrorList](#errorlist)|


<a name="labelformat"></a>
### LabelFormat
The format of the label. Enum of PNG only for now.

*Type* : enum


|Value|Description|
|---|---|
|**PNG**|PNG|


<a name="containertype"></a>
### ContainerType
The type of physical container being used. (always 'PACKAGE')

*Type* : enum


|Value|Description|
|---|---|
|**PACKAGE**|PACKAGE|


<a name="labelstocksize"></a>
### LabelStockSize
The label stock size specification in length and height. Enum of 4x6 only for now.

*Type* : enum


|Value|Description|
|---|---|
|**4x6**|4x6|


<a name="unit"></a>
### Unit
*Type* : enum

<a id="unit-subgroup-1"></a>**For use with the definition(s): [Weight](#weight)**
The unit of measurement.

|Value|Description|
|---|---|
|**g**|Grams|
|**kg**|Kilograms|
|**oz**|Ounces|
|**lb**|Pounds|

<a id="unit-subgroup-2"></a>**For use with the definition(s): [Dimensions](#dimensions)**
The unit of these measurements.

|Value|Description|
|---|---|
|**IN**|Inches|
|**CM**|Centimeters|

