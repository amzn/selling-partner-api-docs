# Selling Partner API for Merchant Fulfillment


<a name="overview"></a>
## Overview
The Selling Partner API for Merchant Fulfillment helps you build applications that let sellers purchase shipping for non-Prime and Prime orders using Amazon’s Buy Shipping Services.


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
[getEligibleShipmentServicesOld](#geteligibleshipmentservicesold)<br>[getEligibleShipmentServices](#geteligibleshipmentservices)<br>[getShipment](#getshipment)<br>[cancelShipment](#cancelshipment)<br>[cancelShipmentOld](#cancelshipmentold)<br>[createShipment](#createshipment)<br>[getAdditionalSellerInputsOld](#getadditionalsellerinputsold)<br>[getAdditionalSellerInputs](#getadditionalsellerinputs)<br>
<a name="paths"></a>
## Paths

<a name="geteligibleshipmentservicesold"></a>
### POST /mfn/v0/eligibleServices
**Operation: getEligibleShipmentServicesOld**

#### Description
Returns a list of shipping service offers that satisfy the specified shipment request details.

**Usage Plan:**

| Rate (requests per second) | Burst |
| ---- | ---- |
| 1 | 1 |

For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Body**|**body**  <br>*required*|Request schema.|[GetEligibleShipmentServicesRequest](#geteligibleshipmentservicesrequest)|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Success  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetEligibleShipmentServicesResponse](#geteligibleshipmentservicesresponse)|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetEligibleShipmentServicesResponse](#geteligibleshipmentservicesresponse)|
|**401**|The request's Authorization header is not formatted correctly or does not contain a valid token.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetEligibleShipmentServicesResponse](#geteligibleshipmentservicesresponse)|
|**403**|Indicates that access to the resource is forbidden. Possible reasons include Access Denied, Unauthorized, Expired Token, or Invalid Signature.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetEligibleShipmentServicesResponse](#geteligibleshipmentservicesresponse)|
|**404**|The specified resource does not exist.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetEligibleShipmentServicesResponse](#geteligibleshipmentservicesresponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetEligibleShipmentServicesResponse](#geteligibleshipmentservicesresponse)|
|**500**|An unexpected condition occurred that prevented the server from fulfilling the request.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetEligibleShipmentServicesResponse](#geteligibleshipmentservicesresponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetEligibleShipmentServicesResponse](#geteligibleshipmentservicesresponse)|


<a name="geteligibleshipmentservices"></a>
### POST /mfn/v0/eligibleShippingServices
**Operation: getEligibleShipmentServices**

#### Description
Returns a list of shipping service offers that satisfy the specified shipment request details.

**Usage Plan:**

| Rate (requests per second) | Burst |
| ---- | ---- |
| 1 | 1 |

For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Body**|**body**  <br>*required*|Request schema.|[GetEligibleShipmentServicesRequest](#geteligibleshipmentservicesrequest)|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Success  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetEligibleShipmentServicesResponse](#geteligibleshipmentservicesresponse)|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetEligibleShipmentServicesResponse](#geteligibleshipmentservicesresponse)|
|**401**|The request's Authorization header is not formatted correctly or does not contain a valid token.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetEligibleShipmentServicesResponse](#geteligibleshipmentservicesresponse)|
|**403**|Indicates that access to the resource is forbidden. Possible reasons include Access Denied, Unauthorized, Expired Token, or Invalid Signature.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetEligibleShipmentServicesResponse](#geteligibleshipmentservicesresponse)|
|**404**|The specified resource does not exist.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetEligibleShipmentServicesResponse](#geteligibleshipmentservicesresponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetEligibleShipmentServicesResponse](#geteligibleshipmentservicesresponse)|
|**500**|An unexpected condition occurred that prevented the server from fulfilling the request.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetEligibleShipmentServicesResponse](#geteligibleshipmentservicesresponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetEligibleShipmentServicesResponse](#geteligibleshipmentservicesresponse)|


<a name="getshipment"></a>
### GET /mfn/v0/shipments/{shipmentId}
**Operation: getShipment**

#### Description
Returns the shipment information for an existing shipment.

**Usage Plan:**

| Rate (requests per second) | Burst |
| ---- | ---- |
| 1 | 1 |

For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**shipmentId**  <br>*required*|The Amazon-defined shipment identifier for the shipment.|string|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Success  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetShipmentResponse](#getshipmentresponse)|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetShipmentResponse](#getshipmentresponse)|
|**401**|The request's Authorization header is not formatted correctly or does not contain a valid token.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetShipmentResponse](#getshipmentresponse)|
|**403**|Indicates that access to the resource is forbidden. Possible reasons include Access Denied, Unauthorized, Expired Token, or Invalid Signature.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetShipmentResponse](#getshipmentresponse)|
|**404**|The specified resource does not exist.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetShipmentResponse](#getshipmentresponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetShipmentResponse](#getshipmentresponse)|
|**500**|An unexpected condition occurred that prevented the server from fulfilling the request.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetShipmentResponse](#getshipmentresponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetShipmentResponse](#getshipmentresponse)|


<a name="cancelshipment"></a>
### DELETE /mfn/v0/shipments/{shipmentId}
**Operation: cancelShipment**

#### Description
Cancel the shipment indicated by the specified shipment identifier.

**Usage Plan:**

| Rate (requests per second) | Burst |
| ---- | ---- |
| 1 | 1 |

For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**shipmentId**  <br>*required*|The Amazon-defined shipment identifier for the shipment to cancel.|string|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Success  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[CancelShipmentResponse](#cancelshipmentresponse)|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[CancelShipmentResponse](#cancelshipmentresponse)|
|**401**|The request's Authorization header is not formatted correctly or does not contain a valid token.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[CancelShipmentResponse](#cancelshipmentresponse)|
|**403**|Indicates that access to the resource is forbidden. Possible reasons include Access Denied, Unauthorized, Expired Token, or Invalid Signature.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[CancelShipmentResponse](#cancelshipmentresponse)|
|**404**|The resource specified does not exist.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[CancelShipmentResponse](#cancelshipmentresponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[CancelShipmentResponse](#cancelshipmentresponse)|
|**500**|An unexpected condition occurred that prevented the server from fulfilling the request.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[CancelShipmentResponse](#cancelshipmentresponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[CancelShipmentResponse](#cancelshipmentresponse)|


<a name="cancelshipmentold"></a>
### PUT /mfn/v0/shipments/{shipmentId}/cancel
**Operation: cancelShipmentOld**

#### Description
Cancel the shipment indicated by the specified shipment identifer.

**Usage Plan:**

| Rate (requests per second) | Burst |
| ---- | ---- |
| 1 | 1 |

For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**shipmentId**  <br>*required*|The Amazon-defined shipment identifier for the shipment to cancel.|string|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Success  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[CancelShipmentResponse](#cancelshipmentresponse)|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[CancelShipmentResponse](#cancelshipmentresponse)|
|**401**|The request's Authorization header is not formatted correctly or does not contain a valid token.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[CancelShipmentResponse](#cancelshipmentresponse)|
|**403**|Indicates that access to the resource is forbidden. Possible reasons include Access Denied, Unauthorized, Expired Token, or Invalid Signature.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[CancelShipmentResponse](#cancelshipmentresponse)|
|**404**|The specified resource does not exist.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[CancelShipmentResponse](#cancelshipmentresponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[CancelShipmentResponse](#cancelshipmentresponse)|
|**500**|An unexpected condition occurred that prevented the server from fulfilling the request.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[CancelShipmentResponse](#cancelshipmentresponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[CancelShipmentResponse](#cancelshipmentresponse)|


<a name="createshipment"></a>
### POST /mfn/v0/shipments
**Operation: createShipment**

#### Description
Create a shipment with the information provided.

**Usage Plan:**

| Rate (requests per second) | Burst |
| ---- | ---- |
| 1 | 1 |

For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Body**|**body**  <br>*required*|Request schema.|[CreateShipmentRequest](#createshipmentrequest)|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Success  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[CreateShipmentResponse](#createshipmentresponse)|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[CreateShipmentResponse](#createshipmentresponse)|
|**401**|The request's Authorization header is not formatted correctly or does not contain a valid token.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[CreateShipmentResponse](#createshipmentresponse)|
|**403**|Indicates that access to the resource is forbidden. Possible reasons include Access Denied, Unauthorized, Expired Token, or Invalid Signature.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[CreateShipmentResponse](#createshipmentresponse)|
|**404**|The specified resource does not exist.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[CreateShipmentResponse](#createshipmentresponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[CreateShipmentResponse](#createshipmentresponse)|
|**500**|An unexpected condition occurred that prevented the server from fulfilling the request.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[CreateShipmentResponse](#createshipmentresponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[CreateShipmentResponse](#createshipmentresponse)|


<a name="getadditionalsellerinputsold"></a>
### POST /mfn/v0/sellerInputs
**Operation: getAdditionalSellerInputsOld**

#### Description
Get a list of additional seller inputs required for a ship method. This is generally used for international shipping.

**Usage Plan:**

| Rate (requests per second) | Burst |
| ---- | ---- |
| 1 | 1 |

For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Body**|**body**  <br>*required*|Request schema.|[GetAdditionalSellerInputsRequest](#getadditionalsellerinputsrequest)|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Success  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetAdditionalSellerInputsResponse](#getadditionalsellerinputsresponse)|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetAdditionalSellerInputsResponse](#getadditionalsellerinputsresponse)|
|**401**|The request's Authorization header is not formatted correctly or does not contain a valid token.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetAdditionalSellerInputsResponse](#getadditionalsellerinputsresponse)|
|**403**|Indicates that access to the resource is forbidden. Possible reasons include Access Denied, Unauthorized, Expired Token, or Invalid Signature.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetAdditionalSellerInputsResponse](#getadditionalsellerinputsresponse)|
|**404**|The specified resource does not exist.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetAdditionalSellerInputsResponse](#getadditionalsellerinputsresponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetAdditionalSellerInputsResponse](#getadditionalsellerinputsresponse)|
|**500**|An unexpected condition occurred that prevented the server from fulfilling the request.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetAdditionalSellerInputsResponse](#getadditionalsellerinputsresponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetAdditionalSellerInputsResponse](#getadditionalsellerinputsresponse)|


<a name="getadditionalsellerinputs"></a>
### POST /mfn/v0/additionalSellerInputs
**Operation: getAdditionalSellerInputs**

#### Description
Gets a list of additional seller inputs required for a ship method. This is generally used for international shipping.

**Usage Plan:**

| Rate (requests per second) | Burst |
| ---- | ---- |
| 1 | 1 |

For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Body**|**body**  <br>*required*|Request schema.|[GetAdditionalSellerInputsRequest](#getadditionalsellerinputsrequest)|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Success  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetAdditionalSellerInputsResponse](#getadditionalsellerinputsresponse)|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetAdditionalSellerInputsResponse](#getadditionalsellerinputsresponse)|
|**401**|The request's Authorization header is not formatted correctly or does not contain a valid token.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetAdditionalSellerInputsResponse](#getadditionalsellerinputsresponse)|
|**403**|Indicates that access to the resource is forbidden. Possible reasons include Access Denied, Unauthorized, Expired Token, or Invalid Signature.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetAdditionalSellerInputsResponse](#getadditionalsellerinputsresponse)|
|**404**|The specified resource does not exist.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetAdditionalSellerInputsResponse](#getadditionalsellerinputsresponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetAdditionalSellerInputsResponse](#getadditionalsellerinputsresponse)|
|**500**|An unexpected condition occurred that prevented the server from fulfilling the request.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetAdditionalSellerInputsResponse](#getadditionalsellerinputsresponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetAdditionalSellerInputsResponse](#getadditionalsellerinputsresponse)|


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


<a name="labelformatoptionrequest"></a>
### LabelFormatOptionRequest
Whether to include a packing slip.


|Name|Description|Schema|
|---|---|---|
|**IncludePackingSlipWithLabel**  <br>*optional*|When true, include a packing slip with the label.|boolean|


<a name="labelformatoption"></a>
### LabelFormatOption
The label format details and whether to include a packing slip.


|Name|Description|Schema|
|---|---|---|
|**IncludePackingSlipWithLabel**  <br>*optional*|When true, include a packing slip with the label.|boolean|
|**LabelFormat**  <br>*optional*|The label format.|[LabelFormat](#labelformat)|


<a name="availablecarrierwillpickupoption"></a>
### AvailableCarrierWillPickUpOption
Indicates whether the carrier will pick up the package, and what fee is charged, if any.


|Name|Description|Schema|
|---|---|---|
|**CarrierWillPickUpOption**  <br>*required*|Carrier will pick up option.|[CarrierWillPickUpOption](#carrierwillpickupoption)|
|**Charge**  <br>*required*|The fee charged.|[CurrencyAmount](#currencyamount)|


<a name="availablecarrierwillpickupoptionslist"></a>
### AvailableCarrierWillPickUpOptionsList
List of available carrier pickup options.

*Type* : < [AvailableCarrierWillPickUpOption](#availablecarrierwillpickupoption) > array


<a name="availabledeliveryexperienceoption"></a>
### AvailableDeliveryExperienceOption
The available delivery confirmation options, and the fee charged, if any.


|Name|Description|Schema|
|---|---|---|
|**DeliveryExperienceOption**  <br>*required*|The delivery confirmation level.|[DeliveryExperienceOption](#deliveryexperienceoption)|
|**Charge**  <br>*required*|Currency type and amount.|[CurrencyAmount](#currencyamount)|


<a name="availabledeliveryexperienceoptionslist"></a>
### AvailableDeliveryExperienceOptionsList
List of available delivery experience options.

*Type* : < [AvailableDeliveryExperienceOption](#availabledeliveryexperienceoption) > array


<a name="availableshippingserviceoptions"></a>
### AvailableShippingServiceOptions
The available shipping service options.


|Name|Description|Schema|
|---|---|---|
|**AvailableCarrierWillPickUpOptions**  <br>*required*|List of available carrier pickup options.|[AvailableCarrierWillPickUpOptionsList](#availablecarrierwillpickupoptionslist)|
|**AvailableDeliveryExperienceOptions**  <br>*required*|List of available delivery experience options.|[AvailableDeliveryExperienceOptionsList](#availabledeliveryexperienceoptionslist)|


<a name="availableformatoptionsforlabellist"></a>
### AvailableFormatOptionsForLabelList
The available label formats.

*Type* : < [LabelFormatOption](#labelformatoption) > array


<a name="constraint"></a>
### Constraint
A validation constraint.


|Name|Description|Schema|
|---|---|---|
|**ValidationRegEx**  <br>*optional*|A regular expression.|string|
|**ValidationString**  <br>*required*|A validation string.|string|


<a name="constraints"></a>
### Constraints
List of constraints.

*Type* : < [Constraint](#constraint) > array


<a name="additionalinputs"></a>
### AdditionalInputs
Maps the additional seller input to the definition. The key to the map is the field name.


|Name|Description|Schema|
|---|---|---|
|**AdditionalInputFieldName**  <br>*optional*|The field name.|string|
|**SellerInputDefinition**  <br>*optional*|Specifies characteristics that apply to a seller input.|[SellerInputDefinition](#sellerinputdefinition)|


<a name="sellerinputdefinition"></a>
### SellerInputDefinition
Specifies characteristics that apply to a seller input.


|Name|Description|Schema|
|---|---|---|
|**IsRequired**  <br>*required*|When true, the additional input field is required.|boolean|
|**DataType**  <br>*required*|The data type of the additional input field.|string|
|**Constraints**  <br>*required*|List of constraints.|[Constraints](#constraints)|
|**InputDisplayText**  <br>*required*|The display text for the additional input field.|string|
|**InputTarget**  <br>*optional*|Whether the seller input applies to the item or the shipment.|[InputTargetType](#inputtargettype)|
|**StoredValue**  <br>*required*|Additional information required to purchase shipping.|[AdditionalSellerInput](#additionalsellerinput)|
|**RestrictedSetValues**  <br>*optional*|The set of fixed values in an additional seller input.|[RestrictedSetValues](#restrictedsetvalues)|


<a name="inputtargettype"></a>
### InputTargetType
Indicates whether the additional seller input is at the item or shipment level.

*Type* : enum


|Value|Description|
|---|---|
|**SHIPMENT_LEVEL**|The additional seller input is at the shipment level.|
|**ITEM_LEVEL**|The additional seller input is at the item level.|


<a name="additionalinputslist"></a>
### AdditionalInputsList
A list of additional inputs.

*Type* : < [AdditionalInputs](#additionalinputs) > array


<a name="additionalsellerinput"></a>
### AdditionalSellerInput
Additional information required to purchase shipping.


|Name|Description|Schema|
|---|---|---|
|**DataType**  <br>*optional*|The data type of the additional information.|string|
|**ValueAsString**  <br>*optional*|The value when the data type is string.|string|
|**ValueAsBoolean**  <br>*optional*|The value when the data type is boolean.|boolean|
|**ValueAsInteger**  <br>*optional*|The value when the data type is integer.|integer|
|**ValueAsTimestamp**  <br>*optional*|The value when the data type is a date-time formatted string.|[Timestamp](#timestamp)|
|**ValueAsAddress**  <br>*optional*|The postal address information.|[Address](#address)|
|**ValueAsWeight**  <br>*optional*|The weight.|[Weight](#weight)|
|**ValueAsDimension**  <br>*optional*|The length.|[Length](#length)|
|**ValueAsCurrency**  <br>*optional*|Currency type and amount.|[CurrencyAmount](#currencyamount)|


<a name="additionalsellerinputs"></a>
### AdditionalSellerInputs
An additional set of seller inputs required to purchase shipping.


|Name|Description|Schema|
|---|---|---|
|**AdditionalInputFieldName**  <br>*required*|The name of the additional input field.|string|
|**AdditionalSellerInput**  <br>*required*|Additional information required to purchase shipping.|[AdditionalSellerInput](#additionalsellerinput)|


<a name="additionalsellerinputslist"></a>
### AdditionalSellerInputsList
A list of additional seller input pairs required to purchase shipping.

*Type* : < [AdditionalSellerInputs](#additionalsellerinputs) > array


<a name="address"></a>
### Address
The postal address information.


|Name|Description|Schema|
|---|---|---|
|**Name**  <br>*required*|The name of the addressee, or business name.|[AddressName](#addressname)|
|**AddressLine1**  <br>*required*|The street address information.|[AddressLine1](#addressline1)|
|**AddressLine2**  <br>*optional*|Additional street address information.|[AddressLine2](#addressline2)|
|**AddressLine3**  <br>*optional*|Additional street address information.|[AddressLine3](#addressline3)|
|**DistrictOrCounty**  <br>*optional*|The district or county.|[DistrictOrCounty](#districtorcounty)|
|**Email**  <br>*required*|The email address.|[EmailAddress](#emailaddress)|
|**City**  <br>*required*|The city.|[City](#city)|
|**StateOrProvinceCode**  <br>*optional*|The state or province code. **Note.** Required in the Canada, US, and UK marketplaces. Also required for shipments originating from China.|[StateOrProvinceCode](#stateorprovincecode)|
|**PostalCode**  <br>*required*|The zip code or postal code.|[PostalCode](#postalcode)|
|**CountryCode**  <br>*required*|The country code. A two-character country code, in ISO 3166-1 alpha-2 format.|[CountryCode](#countrycode)|
|**Phone**  <br>*required*|The phone number.|[PhoneNumber](#phonenumber)|


<a name="addressline1"></a>
### AddressLine1
The street address information.

*Type* : string

**maxLength** : 180  

<a name="addressline2"></a>
### AddressLine2
Additional street address information.

*Type* : string

**maxLength** : 60  

<a name="addressline3"></a>
### AddressLine3
Additional street address information.

*Type* : string

**maxLength** : 60  

<a name="addressname"></a>
### AddressName
The name of the addressee, or business name.

*Type* : string

**maxLength** : 30  

<a name="amazonorderid"></a>
### AmazonOrderId
An Amazon-defined order identifier, in 3-7-7 format.

*Type* : string


<a name="cancelshipmentresponse"></a>
### CancelShipmentResponse
Response schema.


|Name|Description|Schema|
|---|---|---|
|**payload**  <br>*optional*|The payload for the cancelShipment operation.|[Shipment](#shipment)|
|**errors**  <br>*optional*|One or more unexpected errors occurred during the cancelShipment operation.|[ErrorList](#errorlist)|


<a name="city"></a>
### City
The city.

*Type* : string

**maxLength** : 30  

<a name="countrycode"></a>
### CountryCode
The country code. A two-character country code, in ISO 3166-1 alpha-2 format.

*Type* : string


<a name="createshipmentrequest"></a>
### CreateShipmentRequest
Request schema.


|Name|Description|Schema|
|---|---|---|
|**ShipmentRequestDetails**  <br>*required*|Shipment information required for creating a shipment.|[ShipmentRequestDetails](#shipmentrequestdetails)|
|**ShippingServiceId**  <br>*required*|An Amazon-defined shipping service identifier.|[ShippingServiceIdentifier](#shippingserviceidentifier)|
|**ShippingServiceOfferId**  <br>*optional*|Identifies a shipping service order made by a carrier.|string|
|**HazmatType**  <br>*optional*|Hazardous materials options for a package. Consult the terms and conditions for each carrier for more information about hazardous materials.|[HazmatType](#hazmattype)|
|**LabelFormatOption**  <br>*optional*|Whether to include a packing slip.|[LabelFormatOptionRequest](#labelformatoptionrequest)|
|**ShipmentLevelSellerInputsList**  <br>*optional*|A list of additional seller inputs required to ship this shipment.|[AdditionalSellerInputsList](#additionalsellerinputslist)|


<a name="createshipmentresponse"></a>
### CreateShipmentResponse
Response schema.


|Name|Description|Schema|
|---|---|---|
|**payload**  <br>*optional*|Shipment information.|[Shipment](#shipment)|
|**errors**  <br>*optional*|One or more unexpected errors occurred during the createShipment operation.|[ErrorList](#errorlist)|


<a name="itemlevelfields"></a>
### ItemLevelFields

|Name|Description|Schema|
|---|---|---|
|**Asin**  <br>*required*|The Amazon Standard Identification Number (ASIN) of the item.|string|
|**AdditionalInputs**  <br>*required*|A list of additional inputs.|[AdditionalInputsList](#additionalinputslist)|


<a name="itemlevelfieldslist"></a>
### ItemLevelFieldsList
A list of item level fields.

*Type* : < [ItemLevelFields](#itemlevelfields) > array


<a name="getadditionalsellerinputsrequest"></a>
### GetAdditionalSellerInputsRequest
Request schema.


|Name|Description|Schema|
|---|---|---|
|**ShippingServiceId**  <br>*required*|An Amazon-defined shipping service identifier.|[ShippingServiceIdentifier](#shippingserviceidentifier)|
|**ShipFromAddress**  <br>*required*|The address from which to ship.|[Address](#address)|
|**OrderId**  <br>*required*|An Amazon defined order identifier|[AmazonOrderId](#amazonorderid)|


<a name="getadditionalsellerinputsresult"></a>
### GetAdditionalSellerInputsResult
The payload for the getAdditionalSellerInputs operation.


|Name|Description|Schema|
|---|---|---|
|**ShipmentLevelFields**  <br>*optional*|A list of additional inputs.|[AdditionalInputsList](#additionalinputslist)|
|**ItemLevelFieldsList**  <br>*optional*|A list of item level fields.|[ItemLevelFieldsList](#itemlevelfieldslist)|


<a name="getadditionalsellerinputsresponse"></a>
### GetAdditionalSellerInputsResponse
Response schema.


|Name|Description|Schema|
|---|---|---|
|**payload**  <br>*optional*|The payload for the getAdditionalSellerInputs operation.|[GetAdditionalSellerInputsResult](#getadditionalsellerinputsresult)|
|**errors**  <br>*optional*|A list of error responses returned when a request is unsuccessful.|[ErrorList](#errorlist)|


<a name="currencyamount"></a>
### CurrencyAmount
Currency type and amount.


|Name|Description|Schema|
|---|---|---|
|**CurrencyCode**  <br>*required*|Three-digit currency code in ISO 4217 format.<br>**maxLength** : 3|string|
|**Amount**  <br>*required*|The currency amount.|number (double)|


<a name="customtextforlabel"></a>
### CustomTextForLabel
Custom text to print on the label.

Note: Custom text is only included on labels that are in ZPL format (ZPL203). FedEx does not support CustomTextForLabel.

*Type* : string

**maxLength** : 14  

<a name="deliveryexperiencetype"></a>
### DeliveryExperienceType
The delivery confirmation level.

*Type* : enum


|Value|Description|
|---|---|
|**DeliveryConfirmationWithAdultSignature**|Delivery confirmation with adult signature.|
|**DeliveryConfirmationWithSignature**|Delivery confirmation with signature. Required for DPD (UK).|
|**DeliveryConfirmationWithoutSignature**|Delivery confirmation without signature.|
|**NoTracking**|No delivery confirmation.|


<a name="districtorcounty"></a>
### DistrictOrCounty
The district or county.

*Type* : string


<a name="emailaddress"></a>
### EmailAddress
The email address.

*Type* : string


<a name="filecontents"></a>
### FileContents
The document data and checksum.


|Name|Description|Schema|
|---|---|---|
|**Contents**  <br>*required*|Data for printing labels, in the form of a Base64-encoded, GZip-compressed string.|string|
|**FileType**  <br>*required*|The file type for a label.|[FileType](#filetype)|
|**Checksum**  <br>*required*|An MD5 hash to validate the PDF document data, in the form of a Base64-encoded string.|string|


<a name="filetype"></a>
### FileType
The file type for a label.

*Type* : enum


|Value|Description|
|---|---|
|**application/pdf**|A Portable Document Format (pdf) file.|
|**application/zpl**|A Zebra Programming Language (zpl) file.|
|**image/png**|A Portable Network Graphics (png) file.|


<a name="geteligibleshipmentservicesrequest"></a>
### GetEligibleShipmentServicesRequest
Request schema.


|Name|Description|Schema|
|---|---|---|
|**ShipmentRequestDetails**  <br>*required*|Shipment information required for requesting shipping service offers.|[ShipmentRequestDetails](#shipmentrequestdetails)|
|**ShippingOfferingFilter**  <br>*optional*|Filter for use when requesting eligible shipping services.|[ShippingOfferingFilter](#shippingofferingfilter)|


<a name="geteligibleshipmentservicesresponse"></a>
### GetEligibleShipmentServicesResponse
Response schema.


|Name|Description|Schema|
|---|---|---|
|**payload**  <br>*optional*|The payload for the getEligibleShipmentServices operation.|[GetEligibleShipmentServicesResult](#geteligibleshipmentservicesresult)|
|**errors**  <br>*optional*|One or more unexpected errors occurred during this operation.|[ErrorList](#errorlist)|


<a name="geteligibleshipmentservicesresult"></a>
### GetEligibleShipmentServicesResult
The payload for the getEligibleShipmentServices operation.


|Name|Description|Schema|
|---|---|---|
|**ShippingServiceList**  <br>*required*|A list of shipping services offers.|[ShippingServiceList](#shippingservicelist)|
|**RejectedShippingServiceList**  <br>*optional*|List of services that were for some reason unavailable for this request|[RejectedShippingServiceList](#rejectedshippingservicelist)|
|**TemporarilyUnavailableCarrierList**  <br>*optional*|A list of temporarily unavailable carriers.|[TemporarilyUnavailableCarrierList](#temporarilyunavailablecarrierlist)|
|**TermsAndConditionsNotAcceptedCarrierList**  <br>*optional*|List of carriers whose terms and conditions were not accepted by the seller.|[TermsAndConditionsNotAcceptedCarrierList](#termsandconditionsnotacceptedcarrierlist)|


<a name="getshipmentresponse"></a>
### GetShipmentResponse
Response schema.


|Name|Description|Schema|
|---|---|---|
|**payload**  <br>*optional*|The payload for the getShipment operation.|[Shipment](#shipment)|
|**errors**  <br>*optional*|One or more unexpected errors occurred during this operation.|[ErrorList](#errorlist)|


<a name="hazmattype"></a>
### HazmatType
Hazardous materials options for a package. Consult the terms and conditions for each carrier for more information on hazardous materials.

*Type* : enum


|Value|Description|
|---|---|
|**None**|The package does not contain hazardous material.|
|**LQHazmat**|The package contains limited quantities of hazardous material.|


<a name="item"></a>
### Item
An Amazon order item identifier and a quantity.


|Name|Description|Schema|
|---|---|---|
|**OrderItemId**  <br>*required*|An Amazon-defined identifier for an individual item in an order.|[OrderItemId](#orderitemid)|
|**Quantity**  <br>*required*|The number of items.|[ItemQuantity](#itemquantity)|
|**ItemWeight**  <br>*optional*|The weight.|[Weight](#weight)|
|**ItemDescription**  <br>*optional*|The description of the item.|[ItemDescription](#itemdescription)|
|**TransparencyCodeList**  <br>*optional*|A list of transparency codes.|[TransparencyCodeList](#transparencycodelist)|
|**ItemLevelSellerInputsList**  <br>*optional*|A list of additional seller inputs required to ship this item using the chosen shipping service.|[AdditionalSellerInputsList](#additionalsellerinputslist)|


<a name="itemlist"></a>
### ItemList
The list of items to be included in a shipment.

*Type* : < [Item](#item) > array


<a name="itemquantity"></a>
### ItemQuantity
The number of items.

*Type* : integer (int32)


<a name="itemdescription"></a>
### ItemDescription
The description of the item.

*Type* : string


<a name="label"></a>
### Label
Data for creating a shipping label and dimensions for printing the label.


|Name|Description|Schema|
|---|---|---|
|**CustomTextForLabel**  <br>*optional*|Custom text to print on the label.<br><br>Note: Custom text is only included on labels that are in ZPL format (ZPL203). FedEx does not support CustomTextForLabel.|[CustomTextForLabel](#customtextforlabel)|
|**Dimensions**  <br>*required*|Dimensions for printing a shipping label.|[LabelDimensions](#labeldimensions)|
|**FileContents**  <br>*required*|The document data and checksum.|[FileContents](#filecontents)|
|**LabelFormat**  <br>*optional*|The label format.|[LabelFormat](#labelformat)|
|**StandardIdForLabel**  <br>*optional*|The type of standard identifier to print on the label.|[StandardIdForLabel](#standardidforlabel)|


<a name="labelcustomization"></a>
### LabelCustomization
Custom text for shipping labels.


|Name|Description|Schema|
|---|---|---|
|**CustomTextForLabel**  <br>*optional*|Custom text to print on the label.<br><br>Note: Custom text is only included on labels that are in ZPL format (ZPL203). FedEx does not support CustomTextForLabel.|[CustomTextForLabel](#customtextforlabel)|
|**StandardIdForLabel**  <br>*optional*|The type of standard identifier to print on the label.|[StandardIdForLabel](#standardidforlabel)|


<a name="labeldimension"></a>
### LabelDimension
A label dimension.

*Type* : number


<a name="labeldimensions"></a>
### LabelDimensions
Dimensions for printing a shipping label.


|Name|Description|Schema|
|---|---|---|
|**Length**  <br>*required*|The length dimension.|[LabelDimension](#labeldimension)|
|**Width**  <br>*required*|The width dimension.|[LabelDimension](#labeldimension)|
|**Unit**  <br>*required*|The unit of measurement.|[UnitOfLength](#unitoflength)|


<a name="labelformat"></a>
### LabelFormat
The label format.

*Type* : enum


|Value|Description|
|---|---|
|**PDF**|Portable Document Format (pdf).|
|**PNG**|Portable Network Graphics (png) format.|
|**ZPL203**|Zebra Programming Language (zpl) format, 203 dots per inch resolution.|
|**ZPL300**|Zebra Programming Language (zpl) format, 300 dots per inch resolution.|
|**ShippingServiceDefault**|The default provided by the shipping service.|


<a name="labelformatlist"></a>
### LabelFormatList
List of label formats.

*Type* : < [LabelFormat](#labelformat) > array


<a name="length"></a>
### Length
The length.


|Name|Description|Schema|
|---|---|---|
|**value**  <br>*optional*|The value in units.|number|
|**unit**  <br>*optional*|The unit of length.|[UnitOfLength](#unitoflength)|


<a name="orderitemid"></a>
### OrderItemId
An Amazon-defined identifier for an individual item in an order.

*Type* : string


<a name="packagedimension"></a>
### PackageDimension
*Type* : number (double)


<a name="packagedimensions"></a>
### PackageDimensions
The dimensions of a package contained in a shipment.


|Name|Description|Schema|
|---|---|---|
|**Length**  <br>*optional*|The length dimension. If you don't specify PredefinedPackageDimensions, you must specify the Length.|[PackageDimension](#packagedimension)|
|**Width**  <br>*optional*|The width dimension. If you don't specify PredefinedPackageDimensions, you must specify the Width.|[PackageDimension](#packagedimension)|
|**Height**  <br>*optional*|The height dimension. If you don't specify PredefinedPackageDimensions, you must specify the Height.|[PackageDimension](#packagedimension)|
|**Unit**  <br>*optional*|The unit of measurement. If you don't specify PredefinedPackageDimensions, you must specify the Unit.|[UnitOfLength](#unitoflength)|
|**PredefinedPackageDimensions**  <br>*optional*|An enumeration of predefined parcel tokens. If you specify a PredefinedPackageDimensions token, you are not obligated to use a branded package from a carrier. For example, if you specify the FedEx_Box_10kg token, you do not have to use that particular package from FedEx. You are only obligated to use a box that matches the dimensions specified by the token.<br><br>Note: Please note that carriers can have restrictions on the type of package allowed for certain ship methods. Check the carrier website for all details. Example: Flat rate pricing is available when materials are sent by USPS in a USPS-produced Flat Rate Envelope or Box.|[PredefinedPackageDimensions](#predefinedpackagedimensions)|


<a name="phonenumber"></a>
### PhoneNumber
The phone number.

*Type* : string

**maxLength** : 30  

<a name="postalcode"></a>
### PostalCode
The zip code or postal code.

*Type* : string

**maxLength** : 30  

<a name="predefinedpackagedimensions"></a>
### PredefinedPackageDimensions
An enumeration of predefined parcel tokens. If you specify a PredefinedPackageDimensions token, you are not obligated to use a branded package from a carrier. For example, if you specify the FedEx_Box_10kg token, you do not have to use that particular package from FedEx. You are only obligated to use a box that matches the dimensions specified by the token.

Note: Please note that carriers can have restrictions on the type of package allowed for certain ship methods. Check the carrier website for all details. Example: Flat rate pricing is available when materials are sent by USPS in a USPS-produced Flat Rate Envelope or Box.

*Type* : enum


|Value|Description|
|---|---|
|**FedEx_Box_10kg**|15.81 x 12.94 x 10.19 in.|
|**FedEx_Box_25kg**|54.80 x 42.10 x 33.50 in.|
|**FedEx_Box_Extra_Large_1**|11.88 x 11.00 x 10.75 in.|
|**FedEx_Box_Extra_Large_2**|15.75 x 14.13 x 6.00 in.|
|**FedEx_Box_Large_1**|17.50 x 12.38 x 3.00 in.|
|**FedEx_Box_Large_2**|11.25 x 8.75 x 7.75 in.|
|**FedEx_Box_Medium_1**|13.25 x 11.50 x 2.38 in.|
|**FedEx_Box_Medium_2**|11.25 x 8.75 x 4.38 in.|
|**FedEx_Box_Small_1**|12.38 x 10.88 x 1.50 in.|
|**FedEx_Box_Small_2**|8.75 x 2.63 x 11.25 in.|
|**FedEx_Envelope**|12.50 x 9.50 x 0.80 in.|
|**FedEx_Padded_Pak**|11.75 x 14.75 x 2.00 in.|
|**FedEx_Pak_1**|15.50 x 12.00 x 0.80 in.|
|**FedEx_Pak_2**|12.75 x 10.25 x 0.80 in.|
|**FedEx_Tube**|38.00 x 6.00 x 6.00 in.|
|**FedEx_XL_Pak**|17.50 x 20.75 x 2.00 in.|
|**UPS_Box_10kg**|41.00 x 33.50 x 26.50 cm.|
|**UPS_Box_25kg**|48.40 x 43.30 x 35.00 cm.|
|**UPS_Express_Box**|46.00 x 31.50 x 9.50 cm.|
|**UPS_Express_Box_Large**|18.00 x 13.00 x 3.00 in.|
|**UPS_Express_Box_Medium**|15.00 x 11.00 x 3.00 in.|
|**UPS_Express_Box_Small**|13.00 x 11.00 x 2.00 in.|
|**UPS_Express_Envelope**|12.50 x 9.50 x 2.00 in.|
|**UPS_Express_Hard_Pak**|14.75 x 11.50 x 2.00 in.|
|**UPS_Express_Legal_Envelope**|15.00 x 9.50 x 2.00 in.|
|**UPS_Express_Pak**|16.00 x 12.75 x 2.00 in.|
|**UPS_Express_Tube**|97.00 x 19.00 x 16.50 cm.|
|**UPS_Laboratory_Pak**|17.25 x 12.75 x 2.00 in.|
|**UPS_Pad_Pak**|14.75 x 11.00 x 2.00 in.|
|**UPS_Pallet**|120.00 x 80.00 x 200.00 cm.|
|**USPS_Card**|6.00 x 4.25 x 0.01 in.|
|**USPS_Flat**|15.00 x 12.00 x 0.75 in.|
|**USPS_FlatRateCardboardEnvelope**|12.50 x 9.50 x 4.00 in.|
|**USPS_FlatRateEnvelope**|12.50 x 9.50 x 4.00 in.|
|**USPS_FlatRateGiftCardEnvelope**|10.00 x 7.00 x 4.00 in|
|**USPS_FlatRateLegalEnvelope**|15.00 x 9.50 x 4.00 in.|
|**USPS_FlatRatePaddedEnvelope**|12.50 x 9.50 x 4.00 in.|
|**USPS_FlatRateWindowEnvelope**|10.00 x 5.00 x 4.00 in.|
|**USPS_LargeFlatRateBoardGameBox**|24.06 x 11.88 x 3.13 in.|
|**USPS_LargeFlatRateBox**|12.25 x 12.25 x 6.00 in.|
|**USPS_Letter**|11.50 x 6.13 x 0.25 in.|
|**USPS_MediumFlatRateBox1**|11.25 x 8.75 x 6.00 in.|
|**USPS_MediumFlatRateBox2**|14.00 x 12.00 x 3.50 in.|
|**USPS_RegionalRateBoxA1**|10.13 x 7.13 x 5.00 in.|
|**USPS_RegionalRateBoxA2**|13.06 x 11.06 x 2.50 in.|
|**USPS_RegionalRateBoxB1**|16.25 x 14.50 x 3.00 in.|
|**USPS_RegionalRateBoxB2**|12.25 x 10.50 x 5.50 in.|
|**USPS_RegionalRateBoxC**|15.00 x 12.00 x 12.00 in.|
|**USPS_SmallFlatRateBox**|8.69 x 5.44 x 1.75 in.|
|**USPS_SmallFlatRateEnvelope**|10.00 x 6.00 x 4.00 in.|


<a name="restrictedsetvalues"></a>
### RestrictedSetValues
The set of fixed values in an additional seller input.

*Type* : < string > array


<a name="sellerorderid"></a>
### SellerOrderId
A seller-defined order identifier.

*Type* : string

**maxLength** : 64  

<a name="shipment"></a>
### Shipment
The details of a shipment, including the shipment status.


|Name|Description|Schema|
|---|---|---|
|**ShipmentId**  <br>*required*|An Amazon-defined shipment identifier.|[ShipmentId](#shipmentid)|
|**AmazonOrderId**  <br>*required*|An Amazon-defined order identifier, in 3-7-7 format.|[AmazonOrderId](#amazonorderid)|
|**SellerOrderId**  <br>*optional*|A seller-defined order identifier.|[SellerOrderId](#sellerorderid)|
|**ItemList**  <br>*required*|The list of items to be included in a shipment.|[ItemList](#itemlist)|
|**ShipFromAddress**  <br>*required*|The address of the sender.|[Address](#address)|
|**ShipToAddress**  <br>*required*|The destination address for the shipment.|[Address](#address)|
|**PackageDimensions**  <br>*required*|The dimensions of a package contained in a shipment.|[PackageDimensions](#packagedimensions)|
|**Weight**  <br>*required*|The package weight.|[Weight](#weight)|
|**Insurance**  <br>*required*|If DeclaredValue was specified in a previous call to the createShipment operation, then Insurance indicates the amount that the carrier will use to insure the shipment. If DeclaredValue was not specified with a previous call to the createShipment operation, then the shipment will be insured for the carrier's minimum insurance amount, or the combined sale prices that the items are listed for in the shipment, whichever is less.|[CurrencyAmount](#currencyamount)|
|**ShippingService**  <br>*required*|A shipping service offer made by a carrier.|[ShippingService](#shippingservice)|
|**Label**  <br>*required*|Data for creating a shipping label and dimensions for printing the label. If the shipment is canceled, an empty Label is returned.|[Label](#label)|
|**Status**  <br>*required*|The shipment status.|[ShipmentStatus](#shipmentstatus)|
|**TrackingId**  <br>*optional*|The shipment tracking identifier provided by the carrier.|[TrackingId](#trackingid)|
|**CreatedDate**  <br>*required*|The date and time the shipment was created.|[Timestamp](#timestamp)|
|**LastUpdatedDate**  <br>*optional*|The date and time of the last update.|[Timestamp](#timestamp)|


<a name="shipmentid"></a>
### ShipmentId
An Amazon-defined shipment identifier.

*Type* : string


<a name="shipmentrequestdetails"></a>
### ShipmentRequestDetails
Shipment information required for requesting shipping service offers or for creating a shipment.


|Name|Description|Schema|
|---|---|---|
|**AmazonOrderId**  <br>*required*|An Amazon-defined order identifier in 3-7-7 format.|[AmazonOrderId](#amazonorderid)|
|**SellerOrderId**  <br>*optional*|A seller-defined order identifier.|[SellerOrderId](#sellerorderid)|
|**ItemList**  <br>*required*|The list of items to be included in a shipment.|[ItemList](#itemlist)|
|**ShipFromAddress**  <br>*required*|The address of the sender.|[Address](#address)|
|**PackageDimensions**  <br>*required*|The package dimensions.|[PackageDimensions](#packagedimensions)|
|**Weight**  <br>*required*|The package weight.|[Weight](#weight)|
|**MustArriveByDate**  <br>*optional*|The date by which the package must arrive to keep the promise to the customer, in ISO 8601 datetime format. If MustArriveByDate is specified, only shipping service offers that can be delivered by that date are returned.|[Timestamp](#timestamp)|
|**ShipDate**  <br>*optional*|When used in a request, this is the date and time that the seller wants to ship the package. When used in a response, this is the date and time that the package can be shipped by the indicated method.|[Timestamp](#timestamp)|
|**ShippingServiceOptions**  <br>*required*|Extra services offered by the carrier.|[ShippingServiceOptions](#shippingserviceoptions)|
|**LabelCustomization**  <br>*optional*|Label customization options.|[LabelCustomization](#labelcustomization)|


<a name="shipmentstatus"></a>
### ShipmentStatus
The shipment status.

*Type* : enum


|Value|Description|
|---|---|
|**Purchased**|The seller purchased a label by calling the createShipment operation.|
|**RefundPending**|The seller requested a label refund by calling the cancelShipment operation, and the refund request is being processed by the carrier.<br><br>Note:<br><br><li> A seller can create a new shipment for an order while Status=RefundPending for a canceled shipment.</li><br><li> After a label refund is requested by calling the cancelShipment operation, the order status of the order remains "Shipped".</li>|
|**RefundRejected**|The label refund request was rejected by the carrier. A refund request is rejected for either of the following reasons:<br><br><li> The cancellation window has expired. Cancellation policies vary by carrier. For more information about carrier cancellation policies, see the Seller Central Help.</li><br><li> The carrier has already accepted the shipment for delivery.</li>|
|**RefundApplied**|The refund has been approved and credited to the seller's account.|


<a name="deliveryexperienceoption"></a>
### DeliveryExperienceOption
The delivery confirmation level.

*Type* : enum


|Value|Description|
|---|---|
|**DeliveryConfirmationWithAdultSignature**|Delivery confirmation with adult signature.|
|**DeliveryConfirmationWithSignature**|Delivery confirmation with signature. Required for DPD (UK).|
|**DeliveryConfirmationWithoutSignature**|Delivery confirmation without signature.|
|**NoTracking**|No delivery confirmation.|
|**NoPreference**|No preference.|


<a name="shippingofferingfilter"></a>
### ShippingOfferingFilter
Filter for use when requesting eligible shipping services.


|Name|Description|Schema|
|---|---|---|
|**IncludePackingSlipWithLabel**  <br>*optional*|When true, include a packing slip with the label.|boolean|
|**IncludeComplexShippingOptions**  <br>*optional*|When true, include complex shipping options.|boolean|
|**CarrierWillPickUp**  <br>*optional*|Carrier will pick up option.|[CarrierWillPickUpOption](#carrierwillpickupoption)|
|**DeliveryExperience**  <br>*optional*|The delivery confirmation level.|[DeliveryExperienceOption](#deliveryexperienceoption)|


<a name="shippingservice"></a>
### ShippingService
A shipping service offer made by a carrier.


|Name|Description|Schema|
|---|---|---|
|**ShippingServiceName**  <br>*required*|A plain text representation of a carrier's shipping service. For example, "UPS Ground" or "FedEx Standard Overnight".|string|
|**CarrierName**  <br>*required*|The name of the carrier.|string|
|**ShippingServiceId**  <br>*required*|An Amazon-defined shipping service identifier.|[ShippingServiceIdentifier](#shippingserviceidentifier)|
|**ShippingServiceOfferId**  <br>*required*|An Amazon-defined shipping service offer identifier.|string|
|**ShipDate**  <br>*required*|The date that the carrier will ship the package.|[Timestamp](#timestamp)|
|**EarliestEstimatedDeliveryDate**  <br>*optional*|The earliest date by which the shipment will be delivered.|[Timestamp](#timestamp)|
|**LatestEstimatedDeliveryDate**  <br>*optional*|The latest date by which the shipment will be delivered.|[Timestamp](#timestamp)|
|**Rate**  <br>*required*|The amount that the carrier will charge for the shipment.|[CurrencyAmount](#currencyamount)|
|**ShippingServiceOptions**  <br>*required*|Extra services offered by the carrier.|[ShippingServiceOptions](#shippingserviceoptions)|
|**AvailableShippingServiceOptions**  <br>*optional*|The available shipping service options.|[AvailableShippingServiceOptions](#availableshippingserviceoptions)|
|**AvailableLabelFormats**  <br>*optional*|List of label formats.|[LabelFormatList](#labelformatlist)|
|**AvailableFormatOptionsForLabel**  <br>*optional*|The available label formats.|[AvailableFormatOptionsForLabelList](#availableformatoptionsforlabellist)|
|**RequiresAdditionalSellerInputs**  <br>*required*|When true, additional seller inputs are required.|boolean|


<a name="shippingserviceidentifier"></a>
### ShippingServiceIdentifier
An Amazon-defined shipping service identifier.

*Type* : string


<a name="shippingservicelist"></a>
### ShippingServiceList
A list of shipping services offers.

*Type* : < [ShippingService](#shippingservice) > array


<a name="shippingserviceoptions"></a>
### ShippingServiceOptions
Extra services provided by a carrier.


|Name|Description|Schema|
|---|---|---|
|**DeliveryExperience**  <br>*required*|The delivery confirmation level.|[DeliveryExperienceType](#deliveryexperiencetype)|
|**DeclaredValue**  <br>*optional*|The declared value of the shipment. The carrier uses this value to determine the amount to use to insure the shipment. If DeclaredValue is greater than the carrier's minimum insurance amount, the seller is charged for the additional insurance as determined by the carrier. For information about optional insurance coverage, see the Seller Central Help [UK](https://sellercentral.amazon.co.uk/gp/help/200204080) [US](https://sellercentral.amazon.com/gp/help/200204080).|[CurrencyAmount](#currencyamount)|
|**CarrierWillPickUp**  <br>*required*|When true, the carrier will pick up the package.<br><br>Note: Scheduled carrier pickup is available only using Dynamex (US), DPD (UK), and Royal Mail (UK).|boolean|
|**CarrierWillPickUpOption**  <br>*optional*|Carrier will pick up option.|[CarrierWillPickUpOption](#carrierwillpickupoption)|
|**LabelFormat**  <br>*optional*|The seller's preferred label format.|[LabelFormat](#labelformat)|


<a name="carrierwillpickupoption"></a>
### CarrierWillPickUpOption
Carrier will pick up option.

*Type* : enum


|Value|Description|
|---|---|
|**CarrierWillPickUp**|The carrier will pick up the package.|
|**ShipperWillDropOff**|The seller is responsible for arranging pickup or dropping off the package to the carrier.|
|**NoPreference**|No preference.|


<a name="standardidforlabel"></a>
### StandardIdForLabel
The type of standard identifier to print on the label.

*Type* : enum


|Value|Description|
|---|---|
|**AmazonOrderId**|An Amazon-defined order identifier in 3-7-7 format.|


<a name="stateorprovincecode"></a>
### StateOrProvinceCode
The state or province code. **Note.** Required in the Canada, US, and UK marketplaces. Also required for shipments originating from China.

*Type* : string

**maxLength** : 30  

<a name="rejectedshippingservice"></a>
### RejectedShippingService
Information about a rejected shipping service


|Name|Description|Schema|
|---|---|---|
|**CarrierName**  <br>*required*|The rejected shipping carrier name. e.g. USPS|string|
|**ShippingServiceName**  <br>*required*|The rejected shipping service localized name. e.g. FedEx Standard Overnight|string|
|**ShippingServiceId**  <br>*required*|The rejected shipping service identifier. e.g. FEDEX_PTP_STANDARD_OVERNIGHT|[ShippingServiceIdentifier](#shippingserviceidentifier)|
|**RejectionReasonCode**  <br>*required*|A reason code meant to be consumed programatically. e.g. CARRIER_CANNOT_SHIP_TO_POBOX|string|
|**RejectionReasonMessage**  <br>*optional*|A localized human readable description of the rejected reason.|string|


<a name="rejectedshippingservicelist"></a>
### RejectedShippingServiceList
List of services that were for some reason unavailable for this request

*Type* : < [RejectedShippingService](#rejectedshippingservice) > array


<a name="temporarilyunavailablecarrier"></a>
### TemporarilyUnavailableCarrier
A carrier who is temporarily unavailable, most likely due to a service outage experienced by the carrier.


|Name|Description|Schema|
|---|---|---|
|**CarrierName**  <br>*required*|The name of the carrier.|string|


<a name="temporarilyunavailablecarrierlist"></a>
### TemporarilyUnavailableCarrierList
A list of temporarily unavailable carriers.

*Type* : < [TemporarilyUnavailableCarrier](#temporarilyunavailablecarrier) > array


<a name="termsandconditionsnotacceptedcarrier"></a>
### TermsAndConditionsNotAcceptedCarrier
A carrier whose terms and conditions have not been accepted by the seller.


|Name|Description|Schema|
|---|---|---|
|**CarrierName**  <br>*required*|The name of the carrier.|string|


<a name="termsandconditionsnotacceptedcarrierlist"></a>
### TermsAndConditionsNotAcceptedCarrierList
List of carriers whose terms and conditions were not accepted by the seller.

*Type* : < [TermsAndConditionsNotAcceptedCarrier](#termsandconditionsnotacceptedcarrier) > array


<a name="timestamp"></a>
### Timestamp
*Type* : string (date-time)


<a name="trackingid"></a>
### TrackingId
The shipment tracking identifier provided by the carrier.

*Type* : string


<a name="transparencycode"></a>
### TransparencyCode
The Transparency code associated with the item.

*Type* : string


<a name="transparencycodelist"></a>
### TransparencyCodeList
A list of transparency codes.

*Type* : < [TransparencyCode](#transparencycode) > array


<a name="unitoflength"></a>
### UnitOfLength
The unit of length.

*Type* : enum


|Value|Description|
|---|---|
|**inches**|The unit of length is inches.|
|**centimeters**|The unit of length is centimeters.|


<a name="unitofweight"></a>
### UnitOfWeight
The unit of weight.

*Type* : enum


|Value|Description|
|---|---|
|**oz**|The unit of weight is ounces.|
|**g**|The unit of weight is grams.|


<a name="weight"></a>
### Weight
The weight.


|Name|Description|Schema|
|---|---|---|
|**Value**  <br>*required*|The weight value.|[WeightValue](#weightvalue)|
|**Unit**  <br>*required*|The unit of weight.|[UnitOfWeight](#unitofweight)|


<a name="weightvalue"></a>
### WeightValue
The weight value.

*Type* : number (double)

