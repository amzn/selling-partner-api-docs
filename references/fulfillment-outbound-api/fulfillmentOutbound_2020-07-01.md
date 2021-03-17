# Selling Partner APIs for Fulfillment Outbound


<a name="overview"></a>
## Overview
The Selling Partner API for Fulfillment Outbound lets you create applications that help a seller fulfill Multi-Channel Fulfillment orders using their inventory in Amazon's fulfillment network. You can get information on both potential and existing fulfillment orders.


### Version information
*Version* : 2020-07-01


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
[getFulfillmentPreview](#getfulfillmentpreview)<br>[listAllFulfillmentOrders](#listallfulfillmentorders)<br>[createFulfillmentOrder](#createfulfillmentorder)<br>[getPackageTrackingDetails](#getpackagetrackingdetails)<br>[listReturnReasonCodes](#listreturnreasoncodes)<br>[createFulfillmentReturn](#createfulfillmentreturn)<br>[getFulfillmentOrder](#getfulfillmentorder)<br>[updateFulfillmentOrder](#updatefulfillmentorder)<br>[cancelFulfillmentOrder](#cancelfulfillmentorder)<br>[getFeatures](#getfeatures)<br>[getFeatureInventory](#getfeatureinventory)<br>[getFeatureSKU](#getfeaturesku)<br>
<a name="paths"></a>
## Paths

<a name="getfulfillmentpreview"></a>
### POST /fba/outbound/2020-07-01/fulfillmentOrders/preview
**Operation: getFulfillmentPreview**

#### Description
Returns a list of fulfillment order previews based on shipping criteria that you specify.

**Usage Plan:**

| Rate (requests per second) | Burst |
| ---- | ---- |
| 2 | 30 |

For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Body**|**body**  <br>*required*|The request body schema for the getFulfillmentPreview operation.|[GetFulfillmentPreviewRequest](#getfulfillmentpreviewrequest)|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Success.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetFulfillmentPreviewResponse](#getfulfillmentpreviewresponse)|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetFulfillmentPreviewResponse](#getfulfillmentpreviewresponse)|
|**401**|The request's Authorization header is not formatted correctly or does not contain a valid token.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetFulfillmentPreviewResponse](#getfulfillmentpreviewresponse)|
|**403**|Indicates that access to the resource is forbidden. Possible reasons include Access Denied, Unauthorized, Expired Token, or Invalid Signature.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetFulfillmentPreviewResponse](#getfulfillmentpreviewresponse)|
|**404**|The specified resource does not exist.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetFulfillmentPreviewResponse](#getfulfillmentpreviewresponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetFulfillmentPreviewResponse](#getfulfillmentpreviewresponse)|
|**500**|An unexpected condition occurred that prevented the server from fulfilling the request.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetFulfillmentPreviewResponse](#getfulfillmentpreviewresponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetFulfillmentPreviewResponse](#getfulfillmentpreviewresponse)|


<a name="listallfulfillmentorders"></a>
### GET /fba/outbound/2020-07-01/fulfillmentOrders
**Operation: listAllFulfillmentOrders**

#### Description
Returns a list of fulfillment orders fulfilled after (or at) a specified date-time, or indicated by the next token parameter.

**Usage Plan:**

| Rate (requests per second) | Burst |
| ---- | ---- |
| 2 | 30 |

For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Query**|**queryStartDate**  <br>*optional*|A date used to select fulfillment orders that were last updated after (or at) a specified time. An update is defined as any change in fulfillment order status, including the creation of a new fulfillment order.|string (date-time)|
|**Query**|**nextToken**  <br>*optional*|A string token returned in the response to your previous request.|string|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Success.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[ListAllFulfillmentOrdersResponse](#listallfulfillmentordersresponse)|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[ListAllFulfillmentOrdersResponse](#listallfulfillmentordersresponse)|
|**401**|The request's Authorization header is not formatted correctly or does not contain a valid token.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[ListAllFulfillmentOrdersResponse](#listallfulfillmentordersresponse)|
|**403**|Indicates that access to the resource is forbidden. Possible reasons include Access Denied, Unauthorized, Expired Token, or Invalid Signature.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[ListAllFulfillmentOrdersResponse](#listallfulfillmentordersresponse)|
|**404**|The specified resource does not exist.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[ListAllFulfillmentOrdersResponse](#listallfulfillmentordersresponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[ListAllFulfillmentOrdersResponse](#listallfulfillmentordersresponse)|
|**500**|An unexpected condition occurred that prevented the server from fulfilling the request.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[ListAllFulfillmentOrdersResponse](#listallfulfillmentordersresponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[ListAllFulfillmentOrdersResponse](#listallfulfillmentordersresponse)|


<a name="createfulfillmentorder"></a>
### POST /fba/outbound/2020-07-01/fulfillmentOrders
**Operation: createFulfillmentOrder**

#### Description
Requests that Amazon ship items from the seller's inventory in Amazon's fulfillment network to a destination address.

**Usage Plan:**

| Rate (requests per second) | Burst |
| ---- | ---- |
| 2 | 30 |

For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Body**|**body**  <br>*required*|The request body schema for the createFulfillmentOrder operation.|[CreateFulfillmentOrderRequest](#createfulfillmentorderrequest)|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Success.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[CreateFulfillmentOrderResponse](#createfulfillmentorderresponse)|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[CreateFulfillmentOrderResponse](#createfulfillmentorderresponse)|
|**401**|The request's Authorization header is not formatted correctly or does not contain a valid token.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[CreateFulfillmentOrderResponse](#createfulfillmentorderresponse)|
|**403**|Indicates that access to the resource is forbidden. Possible reasons include Access Denied, Unauthorized, Expired Token, or Invalid Signature.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[CreateFulfillmentOrderResponse](#createfulfillmentorderresponse)|
|**404**|The specified resource does not exist.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[CreateFulfillmentOrderResponse](#createfulfillmentorderresponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[CreateFulfillmentOrderResponse](#createfulfillmentorderresponse)|
|**500**|An unexpected condition occurred that prevented the server from fulfilling the request.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[CreateFulfillmentOrderResponse](#createfulfillmentorderresponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[CreateFulfillmentOrderResponse](#createfulfillmentorderresponse)|


<a name="getpackagetrackingdetails"></a>
### GET /fba/outbound/2020-07-01/tracking
**Operation: getPackageTrackingDetails**

#### Description
Returns delivery tracking information for a package in an outbound shipment for a Multi-Channel Fulfillment order.

**Usage Plan:**

| Rate (requests per second) | Burst |
| ---- | ---- |
| 2 | 30 |

For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Query**|**packageNumber**  <br>*required*|The unencrypted package identifier returned by the getFulfillmentOrder operation.|integer (int32)|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Success.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetPackageTrackingDetailsResponse](#getpackagetrackingdetailsresponse)|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetPackageTrackingDetailsResponse](#getpackagetrackingdetailsresponse)|
|**401**|The request's Authorization header is not formatted correctly or does not contain a valid token.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetPackageTrackingDetailsResponse](#getpackagetrackingdetailsresponse)|
|**403**|Indicates that access to the resource is forbidden. Possible reasons include Access Denied, Unauthorized, Expired Token, or Invalid Signature.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetPackageTrackingDetailsResponse](#getpackagetrackingdetailsresponse)|
|**404**|The specified resource does not exist.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetPackageTrackingDetailsResponse](#getpackagetrackingdetailsresponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetPackageTrackingDetailsResponse](#getpackagetrackingdetailsresponse)|
|**500**|An unexpected condition occurred that prevented the server from fulfilling the request.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetPackageTrackingDetailsResponse](#getpackagetrackingdetailsresponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetPackageTrackingDetailsResponse](#getpackagetrackingdetailsresponse)|


<a name="listreturnreasoncodes"></a>
### GET /fba/outbound/2020-07-01/returnReasonCodes
**Operation: listReturnReasonCodes**

#### Description
Returns a list of return reason codes for a seller SKU in a given marketplace.

**Usage Plan:**

| Rate (requests per second) | Burst |
| ---- | ---- |
| 2 | 30 |

For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Query**|**sellerSku**  <br>*required*|The seller SKU for which return reason codes are required.|string|
|**Query**|**marketplaceId**  <br>*optional*|The marketplace for which the seller wants return reason codes.|string|
|**Query**|**sellerFulfillmentOrderId**  <br>*optional*|The identifier assigned to the item by the seller when the fulfillment order was created. The service uses this value to determine the marketplace for which the seller wants return reason codes.|string|
|**Query**|**language**  <br>*required*|The language that the TranslatedDescription property of the ReasonCodeDetails response object should be translated into.|string|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Success.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[ListReturnReasonCodesResponse](#listreturnreasoncodesresponse)|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[ListReturnReasonCodesResponse](#listreturnreasoncodesresponse)|
|**401**|The request's Authorization header is not formatted correctly or does not contain a valid token.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[ListReturnReasonCodesResponse](#listreturnreasoncodesresponse)|
|**403**|Indicates that access to the resource is forbidden. Possible reasons include Access Denied, Unauthorized, Expired Token, or Invalid Signature.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[ListReturnReasonCodesResponse](#listreturnreasoncodesresponse)|
|**404**|The specified resource does not exist.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[ListReturnReasonCodesResponse](#listreturnreasoncodesresponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[ListReturnReasonCodesResponse](#listreturnreasoncodesresponse)|
|**500**|An unexpected condition occurred that prevented the server from fulfilling the request.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[ListReturnReasonCodesResponse](#listreturnreasoncodesresponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[ListReturnReasonCodesResponse](#listreturnreasoncodesresponse)|


<a name="createfulfillmentreturn"></a>
### PUT /fba/outbound/2020-07-01/fulfillmentOrders/{sellerFulfillmentOrderId}/return
**Operation: createFulfillmentReturn**

#### Description
Creates a fulfillment return. 

**Usage Plan:**

| Rate (requests per second) | Burst |
| ---- | ---- |
| 2 | 30 |

For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Body**|**body**  <br>*required*|The createFulfillmentReturn operation creates a fulfillment return for items that were fulfilled using the createFulfillmentOrder operation. For calls to createFulfillmentReturn, you must include ReturnReasonCode values returned by a previous call to the listReturnReasonCodes operation.|[CreateFulfillmentReturnRequest](#createfulfillmentreturnrequest)|
|**Path**|**sellerFulfillmentOrderId**  <br>*required*|An identifier assigned by the seller to the fulfillment order at the time it was created. The seller uses their own records to find the correct SellerFulfillmentOrderId value based on the buyer's request to return items.|string|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Success.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[CreateFulfillmentReturnResponse](#createfulfillmentreturnresponse)|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[CreateFulfillmentReturnResponse](#createfulfillmentreturnresponse)|
|**401**|The request's Authorization header is not formatted correctly or does not contain a valid token.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[CreateFulfillmentReturnResponse](#createfulfillmentreturnresponse)|
|**403**|Indicates that access to the resource is forbidden. Possible reasons include Access Denied, Unauthorized, Expired Token, or Invalid Signature.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[CreateFulfillmentReturnResponse](#createfulfillmentreturnresponse)|
|**404**|The specified resource does not exist.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[CreateFulfillmentReturnResponse](#createfulfillmentreturnresponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[CreateFulfillmentReturnResponse](#createfulfillmentreturnresponse)|
|**500**|An unexpected condition occurred that prevented the server from fulfilling the request.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[CreateFulfillmentReturnResponse](#createfulfillmentreturnresponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[CreateFulfillmentReturnResponse](#createfulfillmentreturnresponse)|


<a name="getfulfillmentorder"></a>
### GET /fba/outbound/2020-07-01/fulfillmentOrders/{sellerFulfillmentOrderId}
**Operation: getFulfillmentOrder**

#### Description
Returns the fulfillment order indicated by the specified order identifier.

**Usage Plan:**

| Rate (requests per second) | Burst |
| ---- | ---- |
| 2 | 30 |

For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**sellerFulfillmentOrderId**  <br>*required*|The identifier assigned to the item by the seller when the fulfillment order was created.<br>**maxLength** : 40|string|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Success.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetFulfillmentOrderResponse](#getfulfillmentorderresponse)|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetFulfillmentOrderResponse](#getfulfillmentorderresponse)|
|**401**|The request's Authorization header is not formatted correctly or does not contain a valid token.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetFulfillmentOrderResponse](#getfulfillmentorderresponse)|
|**403**|Indicates that access to the resource is forbidden. Possible reasons include Access Denied, Unauthorized, Expired Token, or Invalid Signature.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetFulfillmentOrderResponse](#getfulfillmentorderresponse)|
|**404**|The specified resource does not exist.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetFulfillmentOrderResponse](#getfulfillmentorderresponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetFulfillmentOrderResponse](#getfulfillmentorderresponse)|
|**500**|An unexpected condition occurred that prevented the server from fulfilling the request.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetFulfillmentOrderResponse](#getfulfillmentorderresponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetFulfillmentOrderResponse](#getfulfillmentorderresponse)|


<a name="updatefulfillmentorder"></a>
### PUT /fba/outbound/2020-07-01/fulfillmentOrders/{sellerFulfillmentOrderId}
**Operation: updateFulfillmentOrder**

#### Description
Updates and/or requests shipment for a fulfillment order with an order hold on it.

**Usage Plan:**

| Rate (requests per second) | Burst |
| ---- | ---- |
| 2 | 30 |

For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Body**|**body**  <br>*required*|-|[UpdateFulfillmentOrderRequest](#updatefulfillmentorderrequest)|
|**Path**|**sellerFulfillmentOrderId**  <br>*required*|The identifier assigned to the item by the seller when the fulfillment order was created.<br>**maxLength** : 40|string|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Success.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[UpdateFulfillmentOrderResponse](#updatefulfillmentorderresponse)|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[UpdateFulfillmentOrderResponse](#updatefulfillmentorderresponse)|
|**401**|The request's Authorization header is not formatted correctly or does not contain a valid token.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[UpdateFulfillmentOrderResponse](#updatefulfillmentorderresponse)|
|**403**|Indicates that access to the resource is forbidden. Possible reasons include Access Denied, Unauthorized, Expired Token, or Invalid Signature.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[UpdateFulfillmentOrderResponse](#updatefulfillmentorderresponse)|
|**404**|The specified resource does not exist.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[UpdateFulfillmentOrderResponse](#updatefulfillmentorderresponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[UpdateFulfillmentOrderResponse](#updatefulfillmentorderresponse)|
|**500**|An unexpected condition occurred that prevented the server from fulfilling the request.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[UpdateFulfillmentOrderResponse](#updatefulfillmentorderresponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[UpdateFulfillmentOrderResponse](#updatefulfillmentorderresponse)|


<a name="cancelfulfillmentorder"></a>
### PUT /fba/outbound/2020-07-01/fulfillmentOrders/{sellerFulfillmentOrderId}/cancel
**Operation: cancelFulfillmentOrder**

#### Description
Requests that Amazon stop attempting to fulfill the fulfillment order indicated by the specified order identifier.

**Usage Plan:**

| Rate (requests per second) | Burst |
| ---- | ---- |
| 2 | 30 |

For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**sellerFulfillmentOrderId**  <br>*required*|The identifier assigned to the item by the seller when the fulfillment order was created.<br>**maxLength** : 40|string|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Success.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[CancelFulfillmentOrderResponse](#cancelfulfillmentorderresponse)|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[CancelFulfillmentOrderResponse](#cancelfulfillmentorderresponse)|
|**401**|The request's Authorization header is not formatted correctly or does not contain a valid token.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[CancelFulfillmentOrderResponse](#cancelfulfillmentorderresponse)|
|**403**|Indicates that access to the resource is forbidden. Possible reasons include Access Denied, Unauthorized, Expired Token, or Invalid Signature.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[CancelFulfillmentOrderResponse](#cancelfulfillmentorderresponse)|
|**404**|The specified resource does not exist.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[CancelFulfillmentOrderResponse](#cancelfulfillmentorderresponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[CancelFulfillmentOrderResponse](#cancelfulfillmentorderresponse)|
|**500**|An unexpected condition occurred that prevented the server from fulfilling the request.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[CancelFulfillmentOrderResponse](#cancelfulfillmentorderresponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[CancelFulfillmentOrderResponse](#cancelfulfillmentorderresponse)|


<a name="getfeatures"></a>
### GET /fba/outbound/2020-07-01/features
**Operation: getFeatures**

#### Description
Returns a list of features available for Multi-Channel Fulfillment orders in the marketplace you specify, and whether the seller for which you made the call is enrolled for each feature.

**Usage Plan:**

| Rate (requests per second) | Burst |
| ---- | ---- |
| 2 | 30 |

For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Query**|**marketplaceId**  <br>*required*|The marketplace for which to return the list of features.|string|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Success.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetFeaturesResponse](#getfeaturesresponse)|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetFeaturesResponse](#getfeaturesresponse)|
|**401**|The request's Authorization header is not formatted correctly or does not contain a valid token.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetFeaturesResponse](#getfeaturesresponse)|
|**403**|Indicates that access to the resource is forbidden. Possible reasons include Access Denied, Unauthorized, Expired Token, or Invalid Signature.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetFeaturesResponse](#getfeaturesresponse)|
|**404**|The specified resource does not exist.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetFeaturesResponse](#getfeaturesresponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetFeaturesResponse](#getfeaturesresponse)|
|**500**|An unexpected condition occurred that prevented the server from fulfilling the request.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetFeaturesResponse](#getfeaturesresponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetFeaturesResponse](#getfeaturesresponse)|


<a name="getfeatureinventory"></a>
### GET /fba/outbound/2020-07-01/features/inventory/{featureName}
**Operation: getFeatureInventory**

#### Description
Returns a list of inventory items that are eligible for the fulfillment feature you specify.

**Usage Plan:**

| Rate (requests per second) | Burst |
| ---- | ---- |
| 2 | 30 |

For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Query**|**marketplaceId**  <br>*required*|The marketplace for which to return a list of the inventory that is eligible for the specified feature.|string|
|**Path**|**featureName**  <br>*required*|The name of the feature for which to return a list of eligible inventory.|string|
|**Query**|**nextToken**  <br>*optional*|A string token returned in the response to your previous request that is used to return the next response page. A value of null will return the first page.|string|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Success.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetFeatureInventoryResponse](#getfeatureinventoryresponse)|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetFeatureInventoryResponse](#getfeatureinventoryresponse)|
|**401**|The request's Authorization header is not formatted correctly or does not contain a valid token.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetFeatureInventoryResponse](#getfeatureinventoryresponse)|
|**403**|Indicates that access to the resource is forbidden. Possible reasons include Access Denied, Unauthorized, Expired Token, or Invalid Signature.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetFeatureInventoryResponse](#getfeatureinventoryresponse)|
|**404**|The specified resource does not exist.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetFeatureInventoryResponse](#getfeatureinventoryresponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetFeatureInventoryResponse](#getfeatureinventoryresponse)|
|**500**|An unexpected condition occurred that prevented the server from fulfilling the request.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetFeatureInventoryResponse](#getfeatureinventoryresponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetFeatureInventoryResponse](#getfeatureinventoryresponse)|


<a name="getfeaturesku"></a>
### GET /fba/outbound/2020-07-01/features/inventory/{featureName}/{sellerSku}
**Operation: getFeatureSKU**

#### Description
Returns the number of items with the sellerSKU you specify that can have orders fulfilled using the specified feature. Note that if the sellerSKU isn't eligible, the response will contain an empty skuInfo object.

**Usage Plan:**

| Rate (requests per second) | Burst |
| ---- | ---- |
| 2 | 30 |

For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Query**|**marketplaceId**  <br>*required*|The marketplace for which to return the count.|string|
|**Path**|**featureName**  <br>*required*|The name of the feature.|string|
|**Path**|**sellerSku**  <br>*required*|Used to identify an item in the given marketplace. SellerSKU is qualified by the seller's SellerId, which is included with every operation that you submit.|string|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Success.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetFeatureSkuResponse](#getfeatureskuresponse)|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetFeatureSkuResponse](#getfeatureskuresponse)|
|**401**|The request's Authorization header is not formatted correctly or does not contain a valid token.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetFeatureSkuResponse](#getfeatureskuresponse)|
|**403**|Indicates that access to the resource is forbidden. Possible reasons include Access Denied, Unauthorized, Expired Token, or Invalid Signature.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetFeatureSkuResponse](#getfeatureskuresponse)|
|**404**|The specified resource does not exist.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetFeatureSkuResponse](#getfeatureskuresponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetFeatureSkuResponse](#getfeatureskuresponse)|
|**500**|An unexpected condition occurred that prevented the server from fulfilling the request.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetFeatureSkuResponse](#getfeatureskuresponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetFeatureSkuResponse](#getfeatureskuresponse)|


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

*Type* : < [Error](#error) > array


<a name="address"></a>
### Address
A physical address.


|Name|Description|Schema|
|---|---|---|
|**name**  <br>*required*|The name of the person, business or institution at the address.|string|
|**addressLine1**  <br>*required*|The first line of the address.|string|
|**addressLine2**  <br>*optional*|Additional address information, if required.|string|
|**addressLine3**  <br>*optional*|Additional address information, if required.|string|
|**city**  <br>*optional*|The city where the person, business, or institution is located.|string|
|**districtOrCounty**  <br>*optional*|The district or county where the person, business, or institution is located.|string|
|**stateOrRegion**  <br>*required*|The state or region where the person, business or institution is located.|string|
|**postalCode**  <br>*optional*|The postal code of the address.|string|
|**countryCode**  <br>*required*|The two digit country code. In ISO 3166-1 alpha-2 format.|string|
|**phone**  <br>*optional*|The phone number of the person, business, or institution located at the address.|string|


<a name="codsettings"></a>
### CODSettings
The COD (Cash On Delivery) charges that you associate with a COD fulfillment order.


|Name|Description|Schema|
|---|---|---|
|**isCodRequired**  <br>*required*|When true, this fulfillment order requires a COD (Cash On Delivery) payment.|boolean|
|**codCharge**  <br>*optional*|The amount of the COD charge to be collected from the recipient for a COD order.|[Money](#money)|
|**codChargeTax**  <br>*optional*|The amount of the tax on the COD charge to be collected from the recipient for a COD order.|[Money](#money)|
|**shippingCharge**  <br>*optional*|The amount of the tax on the COD charge to be collected from the recipient for a COD order.|[Money](#money)|
|**shippingChargeTax**  <br>*optional*|The amount of the tax on the shipping charge to be collected from the recipient for a COD order.|[Money](#money)|


<a name="createfulfillmentorderitem"></a>
### CreateFulfillmentOrderItem
Item information for creating a fulfillment order.


|Name|Description|Schema|
|---|---|---|
|**sellerSku**  <br>*required*|The seller SKU of the item.<br>**maxLength** : 50|string|
|**sellerFulfillmentOrderItemId**  <br>*required*|A fulfillment order item identifier that the seller creates to track fulfillment order items. Used to disambiguate multiple fulfillment items that have the same SellerSKU. For example, the seller might assign different SellerFulfillmentOrderItemId values to two items in a fulfillment order that share the same SellerSKU but have different GiftMessage values.<br>**maxLength** : 50|string|
|**quantity**  <br>*required*|The item quantity.|[Quantity](#quantity)|
|**giftMessage**  <br>*optional*|A message to the gift recipient, if applicable.<br>**maxLength** : 512|string|
|**displayableComment**  <br>*optional*|Item-specific text that displays in recipient-facing materials such as the outbound shipment packing slip.<br>**maxLength** : 250|string|
|**fulfillmentNetworkSku**  <br>*optional*|Amazon's fulfillment network SKU of the item.|string|
|**perUnitDeclaredValue**  <br>*optional*|The monetary value assigned by the seller to this item.|[Money](#money)|
|**perUnitPrice**  <br>*optional*|The amount to be collected from the recipient for this item in a COD (Cash On Delivery) order.|[Money](#money)|
|**perUnitTax**  <br>*optional*|The tax on the amount to be collected from the recipient for this item in a COD (Cash On Delivery) order.|[Money](#money)|


<a name="createfulfillmentorderitemlist"></a>
### CreateFulfillmentOrderItemList
An array of item information for creating a fulfillment order.

*Type* : < [CreateFulfillmentOrderItem](#createfulfillmentorderitem) > array


<a name="fulfillmentpolicy"></a>
### FulfillmentPolicy
The FulfillmentPolicy value specified when you submitted the createFulfillmentOrder operation.

*Type* : enum


|Value|Description|
|---|---|
|**FillOrKill**|If an item in a fulfillment order is determined to be unfulfillable before any shipment in the order has acquired the status of Pending (the process of picking units from inventory has begun), then the entire order is considered unfulfillable. However, if an item in a fulfillment order is determined to be unfulfillable after a shipment in the order has acquired the status of Pending, Amazon cancels as much of the fulfillment order as possible. See the FulfillmentShipment object for shipment status definitions.|
|**FillAll**|All fulfillable items in the fulfillment order are shipped. The fulfillment order remains in a processing state until all items are either shipped by Amazon or cancelled by the seller.|
|**FillAllAvailable**|All fulfillable items in the fulfillment order are shipped. All unfulfillable items in the order are cancelled.|


<a name="fulfillmentorderstatus"></a>
### FulfillmentOrderStatus
The current status of the fulfillment order.

*Type* : enum


|Value|Description|
|---|---|
|**New**|The fulfillment order was received but not yet validated.|
|**Received**|The fulfillment order was received and validated. Validation includes determining that the destination address is valid and that Amazon's records indicate that the seller has enough sellable (undamaged) inventory to fulfill the order. The seller can cancel a fulfillment order that has a status of Received.|
|**Planning**|The fulfillment order has been sent to Amazon's fulfillment network to begin shipment planning, but no unit in any shipment has been picked from inventory yet. The seller can cancel a fulfillment order that has a status of Planning.|
|**Processing**|The process of picking units from inventory has begun on at least one shipment in the fulfillment order. The seller cannot cancel a fulfillment order that has a status of Processing.|
|**Cancelled**|The fulfillment order has been cancelled by the seller.|
|**Complete**|All item quantities in the fulfillment order have been fulfilled.|
|**CompletePartialled**|Some item quantities in the fulfillment order were fulfilled; the rest were either cancelled or unfulfillable.|
|**Unfulfillable**|No item quantities in the fulfillment order could be fulfilled because the Amazon fulfillment center workers found no inventory for those items or found no inventory that was in sellable (undamaged) condition.|
|**Invalid**|The fulfillment order was received but could not be validated. The reasons for this include an invalid destination address or Amazon's records indicating that the seller does not have enough sellable inventory to fulfill the order. When this happens, the fulfillment order is invalid and no items in the order will ship.|


<a name="createfulfillmentorderrequest"></a>
### CreateFulfillmentOrderRequest
The request body schema for the createFulfillmentOrder operation.


|Name|Description|Schema|
|---|---|---|
|**marketplaceId**  <br>*optional*|The marketplace the fulfillment order is placed against.|string|
|**sellerFulfillmentOrderId**  <br>*required*|A fulfillment order identifier that the seller creates to track their fulfillment order. The SellerFulfillmentOrderId must be unique for each fulfillment order that a seller creates. If the seller's system already creates unique order identifiers, then these might be good values for them to use.<br>**maxLength** : 40|string|
|**displayableOrderId**  <br>*required*|A fulfillment order identifier that the seller creates. This value displays as the order identifier in recipient-facing materials such as the outbound shipment packing slip. The value of DisplayableOrderId should match the order identifier that the seller provides to the recipient. The seller can use the SellerFulfillmentOrderId for this value or they can specify an alternate value if they want the recipient to reference an alternate order identifier.<br><br>The value must be an alpha-numeric or ISO 8859-1 compliant string from one to 40 characters in length. Cannot contain two spaces in a row. Leading and trailing white space is removed.<br>**maxLength** : 40|string|
|**displayableOrderDate**  <br>*required*|The date and time of the fulfillment order. Displays as the order date in recipient-facing materials such as the outbound shipment packing slip.|[Timestamp](#timestamp)|
|**displayableOrderComment**  <br>*required*|Order-specific text that appears in recipient-facing materials such as the outbound shipment packing slip.<br>**maxLength** : 1000|string|
|**shippingSpeedCategory**  <br>*required*|The shipping method for the fulfillment order.|[ShippingSpeedCategory](#shippingspeedcategory)|
|**deliveryWindow**  <br>*optional*|The time range within which a Scheduled Delivery fulfillment order should be delivered.|[DeliveryWindow](#deliverywindow)|
|**destinationAddress**  <br>*required*|The destination address for the fulfillment order.|[Address](#address)|
|**fulfillmentAction**  <br>*optional*|Specifies whether the fulfillment order should ship now or have an order hold put on it.|[FulfillmentAction](#fulfillmentaction)|
|**fulfillmentPolicy**  <br>*optional*|The FulfillmentPolicy value specified when you submitted the createFulfillmentOrder operation.|[FulfillmentPolicy](#fulfillmentpolicy)|
|**codSettings**  <br>*optional*|The COD (Cash On Delivery) charges that you associate with a COD fulfillment order.|[CODSettings](#codsettings)|
|**shipFromCountryCode**  <br>*optional*|The two-character country code for the country from which the fulfillment order ships. Must be in ISO 3166-1 alpha-2 format.|string|
|**notificationEmails**  <br>*optional*|A list of email addresses that the seller provides that are used by Amazon to send ship-complete notifications to recipients on behalf of the seller.|[NotificationEmailList](#notificationemaillist)|
|**featureConstraints**  <br>*optional*|A list of features and their fulfillment policies to apply to the order.|< [FeatureSettings](#featuresettings) > array|
|**items**  <br>*required*|A list of items to include in the fulfillment order preview, including quantity.|[CreateFulfillmentOrderItemList](#createfulfillmentorderitemlist)|


<a name="createfulfillmentreturnrequest"></a>
### CreateFulfillmentReturnRequest
The createFulfillmentReturn operation creates a fulfillment return for items that were fulfilled using the createFulfillmentOrder operation. For calls to createFulfillmentReturn, you must include ReturnReasonCode values returned by a previous call to the listReturnReasonCodes operation.


|Name|Description|Schema|
|---|---|---|
|**items**  <br>*required*|An array of items to be returned.|[CreateReturnItemList](#createreturnitemlist)|


<a name="createfulfillmentreturnresult"></a>
### CreateFulfillmentReturnResult

|Name|Description|Schema|
|---|---|---|
|**returnItems**  <br>*optional*|An array of items that Amazon accepted for return. Returns empty if no items were accepted for return.|[ReturnItemList](#returnitemlist)|
|**invalidReturnItems**  <br>*optional*|An array of invalid return item information.|[InvalidReturnItemList](#invalidreturnitemlist)|
|**returnAuthorizations**  <br>*optional*|An array of return authorization information.|[ReturnAuthorizationList](#returnauthorizationlist)|


<a name="createfulfillmentreturnresponse"></a>
### CreateFulfillmentReturnResponse
The response schema for the createFulfillmentReturn operation.


|Name|Description|Schema|
|---|---|---|
|**payload**  <br>*optional*|The payload for the createFulfillmentReturn operation.|[CreateFulfillmentReturnResult](#createfulfillmentreturnresult)|
|**errors**  <br>*optional*|One or more unexpected errors occurred during the createFulfillmentReturn operation.|[ErrorList](#errorlist)|


<a name="createreturnitem"></a>
### CreateReturnItem
An item that Amazon accepted for return.


|Name|Description|Schema|
|---|---|---|
|**sellerReturnItemId**  <br>*required*|An identifier assigned by the seller to the return item.<br>**maxLength** : 80|string|
|**sellerFulfillmentOrderItemId**  <br>*required*|The identifier assigned to the item by the seller when the fulfillment order was created.|string|
|**amazonShipmentId**  <br>*required*|The identifier for the shipment that is associated with the return item.|string|
|**returnReasonCode**  <br>*required*|The return reason code assigned to the return item by the seller.|string|
|**returnComment**  <br>*optional*|An optional comment about the return item.<br>**maxLength** : 1000|string|


<a name="createreturnitemlist"></a>
### CreateReturnItemList
An array of items to be returned.

*Type* : < [CreateReturnItem](#createreturnitem) > array


<a name="money"></a>
### Money
An amount of money, including units in the form of currency.


|Name|Description|Schema|
|---|---|---|
|**currencyCode**  <br>*required*|Three digit currency code in ISO 4217 format.|string|
|**value**  <br>*required*|A decimal number with no loss of precision. Useful when precision loss is unacceptable, as with currencies. Follows RFC7159 for number representation.|[Decimal](#decimal)|


<a name="decimal"></a>
### Decimal
A decimal number with no loss of precision. Useful when precision loss is unacceptable, as with currencies. Follows RFC7159 for number representation.

*Type* : string


<a name="deliverywindow"></a>
### DeliveryWindow
The time range within which a Scheduled Delivery fulfillment order should be delivered.


|Name|Description|Schema|
|---|---|---|
|**startDate**  <br>*required*|The date and time of the start of the Scheduled Delivery window, in ISO 8601 date time format.|[Timestamp](#timestamp)|
|**endDate**  <br>*required*|The date and time of the end of the Scheduled Delivery window, in ISO 8601 date time format.|[Timestamp](#timestamp)|


<a name="deliverywindowlist"></a>
### DeliveryWindowList
An array of delivery windows.

*Type* : < [DeliveryWindow](#deliverywindow) > array


<a name="fee"></a>
### Fee
Fee type and cost.


|Name|Description|Schema|
|---|---|---|
|**name**  <br>*required*|The type of fee.|enum ([Name](#name))|
|**amount**  <br>*required*|The amount of the fee.|[Money](#money)|


<a name="feelist"></a>
### FeeList
An array of fee type and cost pairs.

*Type* : < [Fee](#fee) > array


<a name="fulfillmentaction"></a>
### FulfillmentAction
Specifies whether the fulfillment order should ship now or have an order hold put on it.

*Type* : enum


|Value|Description|
|---|---|
|**Ship**|The fulfillment order ships now.|
|**Hold**|An order hold is put on the fulfillment order.|


<a name="fulfillmentorder"></a>
### FulfillmentOrder
General information about a fulfillment order, including its status.


|Name|Description|Schema|
|---|---|---|
|**sellerFulfillmentOrderId**  <br>*required*|The fulfillment order identifier submitted with the createFulfillmentOrder operation.|string|
|**marketplaceId**  <br>*required*|The identifier for the marketplace the fulfillment order is placed against.|string|
|**displayableOrderId**  <br>*required*|A fulfillment order identifier submitted with the createFulfillmentOrder operation. Displays as the order identifier in recipient-facing materials such as the packing slip.|string|
|**displayableOrderDate**  <br>*required*|A date and time submitted with the createFulfillmentOrder operation. Displays as the order date in recipient-facing materials such as the packing slip.|[Timestamp](#timestamp)|
|**displayableOrderComment**  <br>*required*|A text block submitted with the createFulfillmentOrder operation. Displays in recipient-facing materials such as the packing slip.|string|
|**shippingSpeedCategory**  <br>*required*|The shipping method used for the fulfillment order.|[ShippingSpeedCategory](#shippingspeedcategory)|
|**deliveryWindow**  <br>*optional*|The time range within which a Scheduled Delivery fulfillment order should be delivered.|[DeliveryWindow](#deliverywindow)|
|**destinationAddress**  <br>*required*|The destination address submitted with the createFulfillmentOrder operation.|[Address](#address)|
|**fulfillmentAction**  <br>*optional*|Specifies whether the fulfillment order should ship now or have an order hold put on it.|[FulfillmentAction](#fulfillmentaction)|
|**fulfillmentPolicy**  <br>*optional*|The FulfillmentPolicy value specified when you submitted the createFulfillmentOrder operation.|[FulfillmentPolicy](#fulfillmentpolicy)|
|**codSettings**  <br>*optional*|The COD (Cash On Delivery) charges that you associate with a COD fulfillment order.|[CODSettings](#codsettings)|
|**receivedDate**  <br>*required*|The date and time that the fulfillment order was received by an Amazon fulfillment center.|[Timestamp](#timestamp)|
|**fulfillmentOrderStatus**  <br>*required*|The current status of the fulfillment order.|[FulfillmentOrderStatus](#fulfillmentorderstatus)|
|**statusUpdatedDate**  <br>*required*|The date and time that the status of the fulfillment order last changed, in ISO 8601 date time format.|[Timestamp](#timestamp)|
|**notificationEmails**  <br>*optional*|A list of email addresses that the seller provides that are used by Amazon to send ship-complete notifications to recipients on behalf of the seller.|[NotificationEmailList](#notificationemaillist)|
|**featureConstraints**  <br>*optional*|A list of features and their fulfillment policies to apply to the order.|< [FeatureSettings](#featuresettings) > array|


<a name="fulfillmentorderitem"></a>
### FulfillmentOrderItem
Item information for a fulfillment order.


|Name|Description|Schema|
|---|---|---|
|**sellerSku**  <br>*required*|The seller SKU of the item.|string|
|**sellerFulfillmentOrderItemId**  <br>*required*|A fulfillment order item identifier submitted with a call to the createFulfillmentOrder operation.|string|
|**quantity**  <br>*required*|The item quantity.|[Quantity](#quantity)|
|**giftMessage**  <br>*optional*|A message to the gift recipient, if applicable.|string|
|**displayableComment**  <br>*optional*|Item-specific text that displays in recipient-facing materials such as the outbound shipment packing slip.|string|
|**fulfillmentNetworkSku**  <br>*optional*|Amazon's fulfillment network SKU of the item.|string|
|**orderItemDisposition**  <br>*optional*|Indicates whether the item is sellable or unsellable.|string|
|**cancelledQuantity**  <br>*required*|The item quantity that was cancelled by the seller.|[Quantity](#quantity)|
|**unfulfillableQuantity**  <br>*required*|The item quantity that is unfulfillable.|[Quantity](#quantity)|
|**estimatedShipDate**  <br>*optional*|The estimated date and time that the item quantity is scheduled to ship from the fulfillment center. Note that this value can change over time. If the shipment that contains the item quantity has been cancelled, estimatedShipDate is not returned.|[Timestamp](#timestamp)|
|**estimatedArrivalDate**  <br>*optional*|The estimated arrival date and time of the item quantity. Note that this value can change over time. If the shipment that contains the item quantity has been cancelled, estimatedArrivalDate is not returned.|[Timestamp](#timestamp)|
|**perUnitPrice**  <br>*optional*|The amount to be collected from the recipient for this item in a COD (Cash On Delivery) order.|[Money](#money)|
|**perUnitTax**  <br>*optional*|The tax on the amount to be collected from the recipient for this item in a COD (Cash On Delivery) order.|[Money](#money)|
|**perUnitDeclaredValue**  <br>*optional*|The monetary value assigned by the seller to this item.|[Money](#money)|


<a name="fulfillmentorderitemlist"></a>
### FulfillmentOrderItemList
An array of fulfillment order item information.

*Type* : < [FulfillmentOrderItem](#fulfillmentorderitem) > array


<a name="fulfillmentpreview"></a>
### FulfillmentPreview
Information about a fulfillment order preview, including delivery and fee information based on shipping method.


|Name|Description|Schema|
|---|---|---|
|**shippingSpeedCategory**  <br>*required*|The shipping method used for the fulfillment order.|[ShippingSpeedCategory](#shippingspeedcategory)|
|**scheduledDeliveryInfo**  <br>*optional*|Delivery information for a scheduled delivery.|[ScheduledDeliveryInfo](#scheduleddeliveryinfo)|
|**isFulfillable**  <br>*required*|When true, this fulfillment order preview is fulfillable.|boolean|
|**isCODCapable**  <br>*required*|When true, this fulfillment order preview is for COD (Cash On Delivery).|boolean|
|**estimatedShippingWeight**  <br>*optional*|Estimated shipping weight for this fulfillment order preview.|[Weight](#weight)|
|**estimatedFees**  <br>*optional*|The estimated fulfillment fees for this fulfillment order preview, if applicable.|[FeeList](#feelist)|
|**fulfillmentPreviewShipments**  <br>*optional*|An array of fulfillment preview shipment information.|[FulfillmentPreviewShipmentList](#fulfillmentpreviewshipmentlist)|
|**unfulfillablePreviewItems**  <br>*optional*|An array of unfulfillable preview item information.|[UnfulfillablePreviewItemList](#unfulfillablepreviewitemlist)|
|**orderUnfulfillableReasons**  <br>*optional*|Error codes associated with the fulfillment order preview that indicate why the order is not fulfillable.<br><br>Error code examples:<br><br>DeliverySLAUnavailable<br>InvalidDestinationAddress|[StringList](#stringlist)|
|**marketplaceId**  <br>*required*|The marketplace the fulfillment order is placed against.|string|
|**featureConstraints**  <br>*optional*|A list of features and their fulfillment policies to apply to the order.|< [FeatureSettings](#featuresettings) > array|


<a name="fulfillmentpreviewitem"></a>
### FulfillmentPreviewItem
Item information for a shipment in a fulfillment order preview.


|Name|Description|Schema|
|---|---|---|
|**sellerSku**  <br>*required*|The seller SKU of the item.|string|
|**quantity**  <br>*required*|The item quantity.|[Quantity](#quantity)|
|**sellerFulfillmentOrderItemId**  <br>*required*|A fulfillment order item identifier that the seller created with a call to the createFulfillmentOrder operation.|string|
|**estimatedShippingWeight**  <br>*optional*|The estimated shipping weight of the item quantity for a single item, as identified by sellerSku, in a shipment.|[Weight](#weight)|
|**shippingWeightCalculationMethod**  <br>*optional*|The method used to calculate the estimated shipping weight.|enum ([ShippingWeightCalculationMethod](#shippingweightcalculationmethod))|


<a name="fulfillmentpreviewitemlist"></a>
### FulfillmentPreviewItemList
An array of fulfillment preview item information.

*Type* : < [FulfillmentPreviewItem](#fulfillmentpreviewitem) > array


<a name="fulfillmentpreviewlist"></a>
### FulfillmentPreviewList
An array of fulfillment preview information.

*Type* : < [FulfillmentPreview](#fulfillmentpreview) > array


<a name="fulfillmentpreviewshipment"></a>
### FulfillmentPreviewShipment
Delivery and item information for a shipment in a fulfillment order preview.


|Name|Description|Schema|
|---|---|---|
|**earliestShipDate**  <br>*optional*|The earliest date that the shipment is expected to be sent from the fulfillment center, in ISO 8601 date time format.|[Timestamp](#timestamp)|
|**latestShipDate**  <br>*optional*|The latest date that the shipment is expected to be sent from the fulfillment center, in ISO 8601 date time format.|[Timestamp](#timestamp)|
|**earliestArrivalDate**  <br>*optional*|The earliest date that the shipment is expected to arrive at its destination.|[Timestamp](#timestamp)|
|**latestArrivalDate**  <br>*optional*|The latest date that the shipment is expected to arrive at its destination, in ISO 8601 date time format.|[Timestamp](#timestamp)|
|**shippingNotes**  <br>*optional*|Provides additional insight into the shipment timeline when exact delivery dates are not able to be precomputed.|< string > array|
|**fulfillmentPreviewItems**  <br>*required*|Information about the items in the shipment.|[FulfillmentPreviewItemList](#fulfillmentpreviewitemlist)|


<a name="fulfillmentpreviewshipmentlist"></a>
### FulfillmentPreviewShipmentList
An array of fulfillment preview shipment information.

*Type* : < [FulfillmentPreviewShipment](#fulfillmentpreviewshipment) > array


<a name="fulfillmentreturnitemstatus"></a>
### FulfillmentReturnItemStatus
Indicates if the return item has been processed by a fulfillment center.

*Type* : enum


|Value|Description|
|---|---|
|**New**|The return item has not yet been processed by a fulfillment center.|
|**Processed**|The return item has been processed by a fulfillment center.|


<a name="fulfillmentshipment"></a>
### FulfillmentShipment
Delivery and item information for a shipment in a fulfillment order.


|Name|Description|Schema|
|---|---|---|
|**amazonShipmentId**  <br>*required*|A shipment identifier assigned by Amazon.|string|
|**fulfillmentCenterId**  <br>*required*|An identifier for the fulfillment center that the shipment will be sent from.|string|
|**fulfillmentShipmentStatus**  <br>*required*|The current status of the shipment.|enum ([FulfillmentShipmentStatus](#fulfillmentshipmentstatus))|
|**shippingDate**  <br>*optional*|The meaning of the shippingDate value depends on the current status of the shipment. If the current value of FulfillmentShipmentStatus is:<br><br><li> Pending - shippingDate represents the estimated time that the shipment will leave the Amazon fulfillment center.</li><br><li> Shipped - shippingDate represents the date that the shipment left the Amazon fulfillment center.</li><br>If a shipment includes more than one package, shippingDate applies to all of the packages in the shipment. If the value of FulfillmentShipmentStatus is CancelledByFulfiller or CancelledBySeller, shippingDate is not returned. The value must be in ISO 8601 date time format.|[Timestamp](#timestamp)|
|**estimatedArrivalDate**  <br>*optional*|The estimated arrival date and time of the shipment, in ISO 8601 date time format. Note that this value can change over time. If a shipment includes more than one package, estimatedArrivalDate applies to all of the packages in the shipment. If the shipment has been cancelled, estimatedArrivalDate is not returned.|[Timestamp](#timestamp)|
|**shippingNotes**  <br>*optional*|Provides additional insight into shipment timeline. Primairly used to communicate that actual delivery dates aren't available.|< string > array|
|**fulfillmentShipmentItem**  <br>*required*|An array of fulfillment shipment item information.|[FulfillmentShipmentItemList](#fulfillmentshipmentitemlist)|
|**fulfillmentShipmentPackage**  <br>*optional*|An array of fulfillment shipment package information.|[FulfillmentShipmentPackageList](#fulfillmentshipmentpackagelist)|


<a name="fulfillmentshipmentitem"></a>
### FulfillmentShipmentItem
Item information for a shipment in a fulfillment order.


|Name|Description|Schema|
|---|---|---|
|**sellerSku**  <br>*required*|The seller SKU of the item.|string|
|**sellerFulfillmentOrderItemId**  <br>*required*|The fulfillment order item identifier that the seller created and submitted with a call to the createFulfillmentOrder operation.|string|
|**quantity**  <br>*required*|The item quantity.|[Quantity](#quantity)|
|**packageNumber**  <br>*optional*|An identifier for the package that contains the item quantity.|integer (int32)|
|**serialNumber**  <br>*optional*|The serial number of the shipped item.|string|


<a name="fulfillmentshipmentitemlist"></a>
### FulfillmentShipmentItemList
An array of fulfillment shipment item information.

*Type* : < [FulfillmentShipmentItem](#fulfillmentshipmentitem) > array


<a name="fulfillmentshipmentlist"></a>
### FulfillmentShipmentList
An array of fulfillment shipment information.

*Type* : < [FulfillmentShipment](#fulfillmentshipment) > array


<a name="fulfillmentshipmentpackage"></a>
### FulfillmentShipmentPackage
Package information for a shipment in a fulfillment order.


|Name|Description|Schema|
|---|---|---|
|**packageNumber**  <br>*required*|Identifies a package in a shipment.|integer (int32)|
|**carrierCode**  <br>*required*|Identifies the carrier who will deliver the shipment to the recipient.|string|
|**trackingNumber**  <br>*optional*|The tracking number, if provided, can be used to obtain tracking and delivery information.|string|
|**estimatedArrivalDate**  <br>*optional*|The estimated arrival date and time of the package, in ISO 8601 date time format.|[Timestamp](#timestamp)|


<a name="fulfillmentshipmentpackagelist"></a>
### FulfillmentShipmentPackageList
An array of fulfillment shipment package information.

*Type* : < [FulfillmentShipmentPackage](#fulfillmentshipmentpackage) > array


<a name="getfulfillmentorderresult"></a>
### GetFulfillmentOrderResult

|Name|Description|Schema|
|---|---|---|
|**fulfillmentOrder**  <br>*required*|General information about a fulfillment order, including its status.|[FulfillmentOrder](#fulfillmentorder)|
|**fulfillmentOrderItems**  <br>*required*|An array of fulfillment order item information.|[FulfillmentOrderItemList](#fulfillmentorderitemlist)|
|**fulfillmentShipments**  <br>*optional*|An array of fulfillment shipment information.|[FulfillmentShipmentList](#fulfillmentshipmentlist)|
|**returnItems**  <br>*required*|An array of items that Amazon accepted for return. Returns empty if no items were accepted for return.|[ReturnItemList](#returnitemlist)|
|**returnAuthorizations**  <br>*required*|An array of return authorization information.|[ReturnAuthorizationList](#returnauthorizationlist)|


<a name="getfulfillmentorderresponse"></a>
### GetFulfillmentOrderResponse
The response schema for the getFulfillmentOrder operation.


|Name|Description|Schema|
|---|---|---|
|**payload**  <br>*optional*|The payload for the getFulfillmentOrder operation.|[GetFulfillmentOrderResult](#getfulfillmentorderresult)|
|**errors**  <br>*optional*|One or more unexpected errors occurred during the getFulfillmentOrder operation.|[ErrorList](#errorlist)|


<a name="getfulfillmentpreviewitem"></a>
### GetFulfillmentPreviewItem
Item information for a fulfillment order preview.


|Name|Description|Schema|
|---|---|---|
|**sellerSku**  <br>*required*|The seller SKU of the item.<br>**maxLength** : 50|string|
|**quantity**  <br>*required*|The item quantity.|[Quantity](#quantity)|
|**perUnitDeclaredValue**  <br>*optional*|The monetary value assigned by the seller to this item. This is a required field if this order is an export order.|[Money](#money)|
|**sellerFulfillmentOrderItemId**  <br>*required*|A fulfillment order item identifier that the seller creates to track items in the fulfillment preview.<br>**maxLength** : 50|string|


<a name="getfulfillmentpreviewitemlist"></a>
### GetFulfillmentPreviewItemList
An array of fulfillment preview item information.

*Type* : < [GetFulfillmentPreviewItem](#getfulfillmentpreviewitem) > array


<a name="getfulfillmentpreviewrequest"></a>
### GetFulfillmentPreviewRequest
The request body schema for the getFulfillmentPreview operation.


|Name|Description|Schema|
|---|---|---|
|**marketplaceId**  <br>*optional*|The marketplace the fulfillment order is placed against.|string|
|**address**  <br>*required*|The destination address for the fulfillment order preview.|[Address](#address)|
|**items**  <br>*required*|Identifying information and quantity information for the items in the fulfillment order preview.|[GetFulfillmentPreviewItemList](#getfulfillmentpreviewitemlist)|
|**shippingSpeedCategories**  <br>*optional*|A list of shipping methods used for creating fulfillment order previews.<br><br>Possible values:<br><br><li> Standard - Standard shipping method.</li><br><li> Expedited - Expedited shipping method.</li><br><li> Priority - Priority shipping method.</li><br><li> ScheduledDelivery - Scheduled Delivery shipping method.</li><br>Note: Shipping method service level agreements vary by marketplace. Sellers should see the Seller Central website in their marketplace for shipping method service level agreements and fulfillment fees.|[ShippingSpeedCategoryList](#shippingspeedcategorylist)|
|**includeCODFulfillmentPreview**  <br>*optional*|Specifies whether to return fulfillment order previews that are for COD (Cash On Delivery).<br><br>Possible values:<br><br><li> true - Returns all fulfillment order previews (both for COD and not for COD).</li><br><li> false - Returns only fulfillment order previews that are not for COD.</li>|boolean|
|**includeDeliveryWindows**  <br>*optional*|Specifies whether to return the ScheduledDeliveryInfo response object, which contains the available delivery windows for a Scheduled Delivery. The ScheduledDeliveryInfo response object can only be returned for fulfillment order previews with ShippingSpeedCategories = ScheduledDelivery.|boolean|
|**featureConstraints**  <br>*optional*|A list of features and their fulfillment policies to apply to the order.|< [FeatureSettings](#featuresettings) > array|


<a name="getfulfillmentpreviewresult"></a>
### GetFulfillmentPreviewResult
A list of fulfillment order previews, including estimated shipping weights, estimated shipping fees, and estimated ship dates and arrival dates.


|Name|Description|Schema|
|---|---|---|
|**fulfillmentPreviews**  <br>*optional*|An array of fulfillment preview information.|[FulfillmentPreviewList](#fulfillmentpreviewlist)|


<a name="getfulfillmentpreviewresponse"></a>
### GetFulfillmentPreviewResponse
The response schema for the getFulfillmentPreview operation.


|Name|Description|Schema|
|---|---|---|
|**payload**  <br>*optional*|The response payload for the getFulfillmentPreview operation.|[GetFulfillmentPreviewResult](#getfulfillmentpreviewresult)|
|**errors**  <br>*optional*|One or more unexpected errors occurred during the getFulfillmentPreview operation.|[ErrorList](#errorlist)|


<a name="invaliditemreasoncode"></a>
### InvalidItemReasonCode
A code for why the item is invalid for return.

*Type* : enum


|Value|Description|
|---|---|
|**InvalidValues**|The item was not found in a fulfillment order.|
|**DuplicateRequest**|A fulfillment return has already been requested for this item.|
|**NoCompletedShipItems**|The fulfillment order containing this item has not yet shipped.|
|**NoReturnableQuantity**|All item quantity available for return has been allocated to other return items.|


<a name="invaliditemreason"></a>
### InvalidItemReason
The reason that the item is invalid for return.


|Name|Description|Schema|
|---|---|---|
|**invalidItemReasonCode**  <br>*required*|A code for why the item is invalid for return.|[InvalidItemReasonCode](#invaliditemreasoncode)|
|**description**  <br>*required*|A human readable description of the invalid item reason code.|string|


<a name="invalidreturnitem"></a>
### InvalidReturnItem
An item that is invalid for return.


|Name|Description|Schema|
|---|---|---|
|**sellerReturnItemId**  <br>*required*|An identifier assigned by the seller to the return item.|string|
|**sellerFulfillmentOrderItemId**  <br>*required*|The identifier assigned to the item by the seller when the fulfillment order was created.|string|
|**invalidItemReason**  <br>*required*|The reason that the item is invalid for return.|[InvalidItemReason](#invaliditemreason)|


<a name="invalidreturnitemlist"></a>
### InvalidReturnItemList
An array of invalid return item information.

*Type* : < [InvalidReturnItem](#invalidreturnitem) > array


<a name="listallfulfillmentordersresult"></a>
### ListAllFulfillmentOrdersResult

|Name|Description|Schema|
|---|---|---|
|**nextToken**  <br>*optional*|When present and not empty, pass this string token in the next request to return the next response page.|string|
|**fulfillmentOrders**  <br>*optional*|An array of fulfillment order information.|< [FulfillmentOrder](#fulfillmentorder) > array|


<a name="listallfulfillmentordersresponse"></a>
### ListAllFulfillmentOrdersResponse
The response schema for the listAllFulfillmentOrders operation.


|Name|Description|Schema|
|---|---|---|
|**payload**  <br>*optional*|The payload for the listAllFulfillmentOrders operation.|[ListAllFulfillmentOrdersResult](#listallfulfillmentordersresult)|
|**errors**  <br>*optional*|One or more unexpected errors occurred during the listAllFulfillmentOrders operation.|[ErrorList](#errorlist)|


<a name="listreturnreasoncodesresult"></a>
### ListReturnReasonCodesResult

|Name|Description|Schema|
|---|---|---|
|**reasonCodeDetails**  <br>*optional*|An array of return reason code details.|[ReasonCodeDetailsList](#reasoncodedetailslist)|


<a name="listreturnreasoncodesresponse"></a>
### ListReturnReasonCodesResponse
The response schema for the listReturnReasonCodes operation.


|Name|Description|Schema|
|---|---|---|
|**payload**  <br>*optional*|The payload for the listReturnReasonCodes operation.|[ListReturnReasonCodesResult](#listreturnreasoncodesresult)|
|**errors**  <br>*optional*|One or more unexpected errors occurred during the listReturnReasonCodes operation.|[ErrorList](#errorlist)|


<a name="notificationemaillist"></a>
### NotificationEmailList
A list of email addresses that the seller provides that are used by Amazon to send ship-complete notifications to recipients on behalf of the seller.

*Type* : < string > array


<a name="currentstatus"></a>
### CurrentStatus
The current delivery status of the package.

*Type* : enum


|Value|Description|
|---|---|
|**IN_TRANSIT**|In transit to the destination address.|
|**DELIVERED**|Delivered to the destination address.|
|**RETURNING**|In the process of being returned to Amazon's fulfillment network.|
|**RETURNED**|Returned to Amazon's fulfillment network.|
|**UNDELIVERABLE**|Undeliverable because package was lost or destroyed.|
|**DELAYED**|Delayed.|
|**AVAILABLE_FOR_PICKUP**|Available for pickup.|
|**CUSTOMER_ACTION**|Requires customer action.|


<a name="additionallocationinfo"></a>
### AdditionalLocationInfo
Additional location information.

*Type* : enum


|Value|Description|
|---|---|
|**AS_INSTRUCTED**|As instructed.|
|**CARPORT**|Carport.|
|**CUSTOMER_PICKUP**|Picked up by customer.|
|**DECK**|Deck.|
|**DOOR_PERSON**|Resident.|
|**FRONT_DESK**|Front desk.|
|**FRONT_DOOR**|Front door.|
|**GARAGE**|Garage.|
|**GUARD**|Residential guard.|
|**MAIL_ROOM**|Mail room.|
|**MAIL_SLOT**|Mail slot.|
|**MAILBOX**|Mailbox.|
|**MC_BOY**|Delivered to male child.|
|**MC_GIRL**|Delivered to female child.|
|**MC_MAN**|Delivered to male adult.|
|**MC_WOMAN**|Delivered to female adult.|
|**NEIGHBOR**|Delivered to neighbor.|
|**OFFICE**|Office.|
|**OUTBUILDING**|Outbuilding.|
|**PATIO**|Patio.|
|**PORCH**|Porch.|
|**REAR_DOOR**|Rear door.|
|**RECEPTIONIST**|Receptionist.|
|**RECEIVER**|Resident.|
|**SECURE_LOCATION**|Secure location.|
|**SIDE_DOOR**|Side door.|


<a name="packagetrackingdetails"></a>
### PackageTrackingDetails

|Name|Description|Schema|
|---|---|---|
|**packageNumber**  <br>*required*|The package identifier.|integer (int32)|
|**trackingNumber**  <br>*optional*|The tracking number for the package.|string|
|**customerTrackingLink**  <br>*optional*|Link on swiship.com that allows customers to track the package.|string|
|**carrierCode**  <br>*optional*|The name of the carrier.|string|
|**carrierPhoneNumber**  <br>*optional*|The phone number of the carrier.|string|
|**carrierURL**  <br>*optional*|The URL of the carrier’s website.|string|
|**shipDate**  <br>*optional*|The shipping date for the package.|[Timestamp](#timestamp)|
|**estimatedArrivalDate**  <br>*optional*|The estimated arrival date.|[Timestamp](#timestamp)|
|**shipToAddress**  <br>*optional*|The destination city for the package.|[TrackingAddress](#trackingaddress)|
|**currentStatus**  <br>*optional*|The current delivery status of the package.|[CurrentStatus](#currentstatus)|
|**currentStatusDescription**  <br>*optional*|Description corresponding to the CurrentStatus value.|string|
|**signedForBy**  <br>*optional*|The name of the person who signed for the package.|string|
|**additionalLocationInfo**  <br>*optional*|Additional location information.|[AdditionalLocationInfo](#additionallocationinfo)|
|**trackingEvents**  <br>*optional*|An array of tracking event information.|[TrackingEventList](#trackingeventlist)|


<a name="getpackagetrackingdetailsresponse"></a>
### GetPackageTrackingDetailsResponse
The response schema for the getPackageTrackingDetails operation.


|Name|Description|Schema|
|---|---|---|
|**payload**  <br>*optional*|The payload for the getPackageTrackingDetails operation.|[PackageTrackingDetails](#packagetrackingdetails)|
|**errors**  <br>*optional*|One or more unexpected errors occurred during the getPackageTrackingDetails operation.|[ErrorList](#errorlist)|


<a name="reasoncodedetails"></a>
### ReasonCodeDetails
A return reason code, a description, and an optional description translation.


|Name|Description|Schema|
|---|---|---|
|**returnReasonCode**  <br>*required*|A code that indicates a valid return reason.|string|
|**description**  <br>*required*|A human readable description of the return reason code.|string|
|**translatedDescription**  <br>*optional*|A translation of the description. The translation is in the language specified in the Language request parameter.|string|


<a name="reasoncodedetailslist"></a>
### ReasonCodeDetailsList
An array of return reason code details.

*Type* : < [ReasonCodeDetails](#reasoncodedetails) > array


<a name="returnauthorization"></a>
### ReturnAuthorization
Return authorization information for items accepted for return.


|Name|Description|Schema|
|---|---|---|
|**returnAuthorizationId**  <br>*required*|An identifier for the return authorization. This identifier associates return items with the return authorization used to return them.|string|
|**fulfillmentCenterId**  <br>*required*|An identifier for the Amazon fulfillment center that the return items should be sent to.|string|
|**returnToAddress**  <br>*required*|The address of the Amazon fulfillment center that the return items should be sent to.|[Address](#address)|
|**amazonRmaId**  <br>*required*|The return merchandise authorization (RMA) that Amazon needs to process the return.|string|
|**rmaPageURL**  <br>*required*|A URL for a web page that contains the return authorization barcode and the mailing label. This does not include pre-paid shipping.|string|


<a name="returnauthorizationlist"></a>
### ReturnAuthorizationList
An array of return authorization information.

*Type* : < [ReturnAuthorization](#returnauthorization) > array


<a name="returnitem"></a>
### ReturnItem
An item that Amazon accepted for return.


|Name|Description|Schema|
|---|---|---|
|**sellerReturnItemId**  <br>*required*|An identifier assigned by the seller to the return item.|string|
|**sellerFulfillmentOrderItemId**  <br>*required*|The identifier assigned to the item by the seller when the fulfillment order was created.|string|
|**amazonShipmentId**  <br>*required*|The identifier for the shipment that is associated with the return item.|string|
|**sellerReturnReasonCode**  <br>*required*|The return reason code assigned to the return item by the seller.|string|
|**returnComment**  <br>*optional*|An optional comment about the return item.|string|
|**amazonReturnReasonCode**  <br>*optional*|The return reason code that the Amazon fulfillment center assigned to the return item.|string|
|**status**  <br>*required*|Indicates if the return item has been processed by an Amazon fulfillment center.|[FulfillmentReturnItemStatus](#fulfillmentreturnitemstatus)|
|**statusChangedDate**  <br>*required*|Indicates when the status last changed.|[Timestamp](#timestamp)|
|**returnAuthorizationId**  <br>*optional*|Identifies the return authorization used to return this item. See ReturnAuthorization.|string|
|**returnReceivedCondition**  <br>*optional*|The condition of the return item when received by an Amazon fulfillment center.|[ReturnItemDisposition](#returnitemdisposition)|
|**fulfillmentCenterId**  <br>*optional*|The identifier for the Amazon fulfillment center that processed the return item.|string|


<a name="returnitemdisposition"></a>
### ReturnItemDisposition
The condition of the return item when received by an Amazon fulfillment center.

*Type* : enum


|Value|Description|
|---|---|
|**Sellable**|Item is in sellable condition.|
|**Defective**|Item is defective.|
|**CustomerDamaged**|Item was damaged by the buyer or the seller.|
|**CarrierDamaged**|Item was damaged by the carrier.|
|**FulfillerDamaged**|Item was damaged by Amazon.|


<a name="returnitemlist"></a>
### ReturnItemList
An array of items that Amazon accepted for return. Returns empty if no items were accepted for return.

*Type* : < [ReturnItem](#returnitem) > array


<a name="scheduleddeliveryinfo"></a>
### ScheduledDeliveryInfo
Delivery information for a scheduled delivery.


|Name|Description|Schema|
|---|---|---|
|**deliveryTimeZone**  <br>*required*|The time zone of the destination address for the fulfillment order preview. Must be an IANA time zone name. Example: Asia/Tokyo.|string|
|**deliveryWindows**  <br>*required*|An array of time ranges that are available for scheduled delivery.|[DeliveryWindowList](#deliverywindowlist)|


<a name="shippingspeedcategorylist"></a>
### ShippingSpeedCategoryList
*Type* : < [ShippingSpeedCategory](#shippingspeedcategory) > array


<a name="stringlist"></a>
### StringList
*Type* : < string > array


<a name="timestamp"></a>
### Timestamp
*Type* : string (date-time)


<a name="trackingaddress"></a>
### TrackingAddress
Address information for tracking the package.


|Name|Description|Schema|
|---|---|---|
|**city**  <br>*required*|The city.<br>**maxLength** : 150|string|
|**state**  <br>*required*|The state.<br>**maxLength** : 150|string|
|**country**  <br>*required*|The country.<br>**maxLength** : 6|string|


<a name="eventcode"></a>
### EventCode
The event code for the delivery event.

*Type* : enum


|Value|Description|
|---|---|
|**EVENT_101**|Carrier notified to pick up package.|
|**EVENT_102**|Shipment picked up from seller's facility.|
|**EVENT_201**|Arrival scan.|
|**EVENT_202**|Departure scan.|
|**EVENT_203**|Arrived at destination country.|
|**EVENT_204**|Initiated customs clearance process.|
|**EVENT_205**|Completed customs clearance process.|
|**EVENT_206**|In transit to pickup location.|
|**EVENT_301**|Delivered.|
|**EVENT_302**|Out for delivery.|
|**EVENT_304**|Delivery attempted.|
|**EVENT_306**|Customer contacted to arrange delivery.|
|**EVENT_307**|Delivery appointment scheduled.|
|**EVENT_308**|Available for pickup.|
|**EVENT_309**|Returned to seller.|
|**EVENT_401**|Held by carrier - incorrect address.|
|**EVENT_402**|Customs clearance delay.|
|**EVENT_403**|Customer moved.|
|**EVENT_404**|Delay in delivery due to external factors.|
|**EVENT_405**|Shipment damaged.|
|**EVENT_406**|Held by carrier.|
|**EVENT_407**|Customer refused delivery.|
|**EVENT_408**|Returning to seller.|
|**EVENT_409**|Lost by carrier.|
|**EVENT_411**|Paperwork received - did not receive shipment.|
|**EVENT_412**|Shipment received - did not receive paperwork.|
|**EVENT_413**|Held by carrier - customer refused shipment due to customs charges.|
|**EVENT_414**|Missorted by carrier.|
|**EVENT_415**|Received from prior carrier.|
|**EVENT_416**|Undeliverable.|
|**EVENT_417**|Shipment missorted.|
|**EVENT_418**|Shipment delayed.|
|**EVENT_419**|Address corrected - delivery rescheduled.|


<a name="trackingevent"></a>
### TrackingEvent
Information for tracking package deliveries.


|Name|Description|Schema|
|---|---|---|
|**eventDate**  <br>*required*|The date and time that the delivery event took place, in ISO 8601 date time format.|[Timestamp](#timestamp)|
|**eventAddress**  <br>*required*|The city where the delivery event took place.|[TrackingAddress](#trackingaddress)|
|**eventCode**  <br>*required*|The event code for the delivery event.|[EventCode](#eventcode)|
|**eventDescription**  <br>*required*|A description for the corresponding event code.|string|


<a name="trackingeventlist"></a>
### TrackingEventList
An array of tracking event information.

*Type* : < [TrackingEvent](#trackingevent) > array


<a name="unfulfillablepreviewitem"></a>
### UnfulfillablePreviewItem
Information about unfulfillable items in a fulfillment order preview.


|Name|Description|Schema|
|---|---|---|
|**sellerSku**  <br>*required*|The seller SKU of the item.<br>**maxLength** : 50|string|
|**quantity**  <br>*required*|The item quantity.|[Quantity](#quantity)|
|**sellerFulfillmentOrderItemId**  <br>*required*|A fulfillment order item identifier created with a call to the getFulfillmentPreview operation.<br>**maxLength** : 50|string|
|**itemUnfulfillableReasons**  <br>*optional*|Error codes associated with the fulfillment order preview that indicate why the item is unfulfillable.|[StringList](#stringlist)|


<a name="unfulfillablepreviewitemlist"></a>
### UnfulfillablePreviewItemList
An array of unfulfillable preview item information.

*Type* : < [UnfulfillablePreviewItem](#unfulfillablepreviewitem) > array


<a name="updatefulfillmentorderitem"></a>
### UpdateFulfillmentOrderItem
Item information for updating a fulfillment order.


|Name|Description|Schema|
|---|---|---|
|**sellerSku**  <br>*optional*|The seller SKU of the item.|string|
|**sellerFulfillmentOrderItemId**  <br>*required*|Identifies the fulfillment order item to update. Created with a previous call to the createFulfillmentOrder operation.<br>**maxLength** : 50|string|
|**quantity**  <br>*required*|The item quantity.|[Quantity](#quantity)|
|**giftMessage**  <br>*optional*|A message to the gift recipient, if applicable.<br>**maxLength** : 512|string|
|**displayableComment**  <br>*optional*|Item-specific text that displays in recipient-facing materials such as the outbound shipment packing slip.<br>**maxLength** : 250|string|
|**fulfillmentNetworkSku**  <br>*optional*|Amazon's fulfillment network SKU of the item.|string|
|**orderItemDisposition**  <br>*optional*|Indicates whether the item is sellable or unsellable.|string|
|**perUnitDeclaredValue**  <br>*optional*|The monetary value assigned by the seller to this item.|[Money](#money)|
|**perUnitPrice**  <br>*optional*|The amount to be collected from the recipient for this item in a COD (Cash On Delivery) order.|[Money](#money)|
|**perUnitTax**  <br>*optional*|The tax on the amount to be collected from the recipient for this item in a COD (Cash On Delivery) order.|[Money](#money)|


<a name="updatefulfillmentorderitemlist"></a>
### UpdateFulfillmentOrderItemList
An array of fulfillment order item information for updating a fulfillment order.

*Type* : < [UpdateFulfillmentOrderItem](#updatefulfillmentorderitem) > array


<a name="updatefulfillmentorderrequest"></a>
### UpdateFulfillmentOrderRequest

|Name|Description|Schema|
|---|---|---|
|**marketplaceId**  <br>*optional*|The marketplace the fulfillment order is placed against.|string|
|**displayableOrderId**  <br>*optional*|A fulfillment order identifier that the seller creates. This value displays as the order identifier in recipient-facing materials such as the outbound shipment packing slip. The value of DisplayableOrderId should match the order identifier that the seller provides to the recipient. The seller can use the SellerFulfillmentOrderId for this value or they can specify an alternate value if they want the recipient to reference an alternate order identifier.<br>**maxLength** : 40|string|
|**displayableOrderDate**  <br>*optional*|The date and time of the fulfillment order. Displays as the order date in recipient-facing materials such as the outbound shipment packing slip.|[Timestamp](#timestamp)|
|**displayableOrderComment**  <br>*optional*|Order-specific text that appears in recipient-facing materials such as the outbound shipment packing slip.<br>**maxLength** : 1000|string|
|**shippingSpeedCategory**  <br>*optional*|The shipping method used for the fulfillment order.|[ShippingSpeedCategory](#shippingspeedcategory)|
|**destinationAddress**  <br>*optional*|The destination address for the fulfillment order.|[Address](#address)|
|**fulfillmentAction**  <br>*optional*|Specifies whether the fulfillment order should ship now or have an order hold put on it.|[FulfillmentAction](#fulfillmentaction)|
|**fulfillmentPolicy**  <br>*optional*|The FulfillmentPolicy value specified when you submitted the createFulfillmentOrder operation.|[FulfillmentPolicy](#fulfillmentpolicy)|
|**shipFromCountryCode**  <br>*optional*|The two-character country code for the country from which the fulfillment order ships. Must be in ISO 3166-1 alpha-2 format.|string|
|**notificationEmails**  <br>*optional*|A list of email addresses that the seller provides that are used by Amazon to send ship-complete notifications to recipients on behalf of the seller.|[NotificationEmailList](#notificationemaillist)|
|**featureConstraints**  <br>*optional*|A list of features and their fulfillment policies to apply to the order.|< [FeatureSettings](#featuresettings) > array|
|**items**  <br>*optional*|A list of items to include in the fulfillment order preview, including quantity.|[UpdateFulfillmentOrderItemList](#updatefulfillmentorderitemlist)|


<a name="updatefulfillmentorderresponse"></a>
### UpdateFulfillmentOrderResponse
The response schema for the updateFulfillmentOrder operation.


|Name|Description|Schema|
|---|---|---|
|**errors**  <br>*optional*|One or more unexpected errors occurred during the updateFulfillmentOrder operation.|[ErrorList](#errorlist)|


<a name="createfulfillmentorderresponse"></a>
### CreateFulfillmentOrderResponse
The response schema for the createFulfillmentOrder operation.


|Name|Description|Schema|
|---|---|---|
|**errors**  <br>*optional*|One or more unexpected errors occurred during the createFulfillmentOrder operation.|[ErrorList](#errorlist)|


<a name="cancelfulfillmentorderresponse"></a>
### CancelFulfillmentOrderResponse
The response schema for the cancelFulfillmentOrder operation.


|Name|Description|Schema|
|---|---|---|
|**errors**  <br>*optional*|One or more unexpected errors occurred during the cancelFulfillmentOrder operation.|[ErrorList](#errorlist)|


<a name="weight"></a>
### Weight
The weight.


|Name|Description|Schema|
|---|---|---|
|**unit**  <br>*required*|The unit of weight.|enum ([Unit](#unit))|
|**value**  <br>*required*|The weight value.|string|


<a name="quantity"></a>
### Quantity
The item quantity.

*Type* : integer (int32)


<a name="shippingspeedcategory"></a>
### ShippingSpeedCategory
The shipping method used for the fulfillment order.

*Type* : enum


|Value|Description|
|---|---|
|**Standard**|Standard shipping method.|
|**Expedited**|Expedited shipping method.|
|**Priority**|Priority shipping method.|
|**ScheduledDelivery**|Scheduled Delivery shipping method.|


<a name="getfeatureinventoryresponse"></a>
### GetFeatureInventoryResponse
The breakdown of eligibility inventory by feature.


|Name|Description|Schema|
|---|---|---|
|**payload**  <br>*optional*|The payload for the getEligibileInventory operation.|[GetFeatureInventoryResult](#getfeatureinventoryresult)|
|**errors**  <br>*optional*|One or more unexpected errors occurred during the getFeatureInventory operation.|[ErrorList](#errorlist)|


<a name="getfeatureinventoryresult"></a>
### GetFeatureInventoryResult
The payload for the getEligibileInventory operation.


|Name|Description|Schema|
|---|---|---|
|**marketplaceId**  <br>*required*|The requested marketplace.|string|
|**featureName**  <br>*required*|The name of the feature.|string|
|**nextToken**  <br>*optional*|When present and not empty, pass this string token in the next request to return the next response page.|string|
|**featureSkus**  <br>*optional*|An array of SKUs eligible for this feature and the quantity available.|< [FeatureSku](#featuresku) > array|


<a name="featuresku"></a>
### FeatureSku
Information about an SKU, including the count available, identifiers, and a list of overlapping SKUs that share the same inventory pool.


|Name|Description|Schema|
|---|---|---|
|**sellerSku**  <br>*optional*|Used to identify an item in the given marketplace. SellerSKU is qualified by the seller's SellerId, which is included with every operation that you submit.|string|
|**fnSku**  <br>*optional*|The unique SKU used by Amazon's fulfillment network.|string|
|**asin**  <br>*optional*|The Amazon Standard Identification Number (ASIN) of the item.|string|
|**skuCount**  <br>*optional*|The number of SKUs available for this service.|number|
|**overlappingSkus**  <br>*optional*|Other seller SKUs that are shared across the same inventory.|< string > array|


<a name="getfeaturesresponse"></a>
### GetFeaturesResponse
The response schema for the getFeatures operation.


|Name|Description|Schema|
|---|---|---|
|**payload**  <br>*optional*|The payload for the getFeatures operation.|[GetFeaturesResult](#getfeaturesresult)|
|**errors**  <br>*optional*|A list of error responses returned when a request is unsuccessful.|[ErrorList](#errorlist)|


<a name="getfeaturesresult"></a>
### GetFeaturesResult
The payload for the getFeatures operation.


|Name|Description|Schema|
|---|---|---|
|**features**  <br>*required*|An array of features.|[Features](#features)|


<a name="features"></a>
### Features
An array of features.

*Type* : < [Feature](#feature) > array


<a name="feature"></a>
### Feature
A Multi-Channel Fulfillment feature.


|Name|Description|Schema|
|---|---|---|
|**featureName**  <br>*required*|The feature name.|string|
|**featureDescription**  <br>*required*|The feature description.|string|
|**sellerEligible**  <br>*optional*|When true, indicates that the seller is eligible to use the feature.|boolean|


<a name="getfeatureskuresponse"></a>
### GetFeatureSkuResponse
The response schema for the getFeatureSKU operation.


|Name|Description|Schema|
|---|---|---|
|**payload**  <br>*optional*|The payload for the getFeatureSKU operation.|[GetFeatureSkuResult](#getfeatureskuresult)|
|**errors**  <br>*optional*|A list of error responses returned when a request is unsuccessful.|[ErrorList](#errorlist)|


<a name="getfeatureskuresult"></a>
### GetFeatureSkuResult
The payload for the getFeatureSKU operation.


|Name|Description|Schema|
|---|---|---|
|**marketplaceId**  <br>*required*|The requested marketplace.|string|
|**featureName**  <br>*required*|The name of the feature.|string|
|**isEligible**  <br>*required*|When true, the seller SKU is eligible for the requested feature.|boolean|
|**ineligibleReasons**  <br>*optional*|A list of one or more reasons that the seller SKU is ineligibile for the feature.<br><br>Possible values:<br><li> MERCHANT_NOT_ENROLLED - The merchant isn't enrolled for the feature.</li><br><li> SKU_NOT_ELIGIBLE - The SKU doesn't reside in a warehouse that supports the feature.</li><br><li> INVALID_SKU - There is an issue with the SKU provided.</li>|< string > array|
|**skuInfo**  <br>*optional*|Information about the SKU, including the count available, identifiers, and a list of overlapping SKUs that share the same inventory pool.|[FeatureSku](#featuresku)|


<a name="featuresettings"></a>
### FeatureSettings
Settings to apply to an order that includes the specified fulfillment feature.


|Name|Description|Schema|
|---|---|---|
|**featureName**  <br>*optional*|The name of the feature.|string|
|**featureFulfillmentPolicy**  <br>*optional*|Specifies the policy to use when fulfilling an order.|enum ([FeatureFulfillmentPolicy](#featurefulfillmentpolicy))|


<a name="fulfillmentshipmentstatus"></a>
### FulfillmentShipmentStatus
The current status of the shipment.

*Type* : enum


|Value|Description|
|---|---|
|**PENDING**|The process of picking units from inventory has begun.|
|**SHIPPED**|All packages in the shipment have left the fulfillment center.|
|**CANCELLED_BY_FULFILLER**|The Amazon fulfillment center could not fulfill the shipment as planned. This might be because the inventory was not at the expected location in the fulfillment center. After cancelling the fulfillment order, Amazon immediately creates a new fulfillment shipment and again attempts to fulfill the order.|
|**CANCELLED_BY_SELLER**|The shipment was cancelled using the CancelFulfillmentOrder request.|


<a name="featurefulfillmentpolicy"></a>
### FeatureFulfillmentPolicy
Specifies the policy to use when fulfilling an order.

*Type* : enum


|Value|Description|
|---|---|
|**Required**|If the offer can't be shipped with the selected feature, reject the order.|
|**NotRequired**|The feature is not required for shipping.|


<a name="unit"></a>
### Unit
The unit of weight.

*Type* : enum


|Value|Description|
|---|---|
|**KG**|Kilograms.|
|**LB**|Pounds.|


<a name="name"></a>
### Name
The type of fee.

*Type* : enum


|Value|Description|
|---|---|
|**FBAPerUnitFulfillmentFee**|Estimated fee for each unit in the fulfillment order.|
|**FBAPerOrderFulfillmentFee**|Estimated order-level fee.|
|**FBATransportationFee**|Estimated shipping fee.|
|**FBAFulfillmentCODFee**|Estimated COD (Cash On Delivery) fee. This fee applies only to fulfillment order previews for COD.|


<a name="shippingweightcalculationmethod"></a>
### ShippingWeightCalculationMethod
The method used to calculate the estimated shipping weight.

*Type* : enum


|Value|Description|
|---|---|
|**Package**|Based on the actual weight of the items.|
|**Dimensional**|Based on the cubic space that the items occupy.|

