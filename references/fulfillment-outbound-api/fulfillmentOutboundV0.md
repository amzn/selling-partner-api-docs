# Selling Partner API for Fulfillment Outbound


<a name="overview"></a>
## Overview
The Selling Partner API for Fulfillment Outbound lets you create applications that help a seller fulfill Multi-Channel Fulfillment orders using their inventory in Amazon's fulfillment network. You can get information on both potential and existing fulfillment orders.


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
[getFulfillmentPreview](#getfulfillmentpreview)<br>[listAllFulfillmentOrders](#listallfulfillmentorders)<br>[createFulfillmentOrder](#createfulfillmentorder)<br>[getPackageTrackingDetails](#getpackagetrackingdetails)<br>[listReturnReasonCodes](#listreturnreasoncodes)<br>[createFulfillmentReturn](#createfulfillmentreturn)<br>[getFulfillmentOrder](#getfulfillmentorder)<br>[updateFulfillmentOrder](#updatefulfillmentorder)<br>[cancelFulfillmentOrder](#cancelfulfillmentorder)<br>
<a name="paths"></a>
## Paths

<a name="getfulfillmentpreview"></a>
### POST /fba/outbound/v0/fulfillmentOrders/preview
**Operation: getFulfillmentPreview**

#### Description
Returns a list of fulfillment order previews based on shipping criteria that you specify.

**Usage Plan:**

| Rate (requests per second) | Burst |
| ---- | ---- |
| 2 | 30 |

For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Schema|
|---|---|---|
|**Body**|**body**  <br>*required*|[GetFulfillmentPreviewRequest](#getfulfillmentpreviewrequest)|


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
### GET /fba/outbound/v0/fulfillmentOrders
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
|**Query**|**QueryStartDateTime**  <br>*optional*|A date and time used to select fulfillment orders that were last updated after (or at) a specified time. An update is defined as any change in fulfillment order status, including the creation of a new fulfillment order.|string (date-time)|
|**Query**|**FulfillmentMethod**  <br>*optional*|Indicates the intended recipient channel for the order.|< string > array|
|**Query**|**NextToken**  <br>*optional*|A string token returned in the response to your previous request.|string|


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
### POST /fba/outbound/v0/fulfillmentOrders
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
### GET /fba/outbound/v0/tracking
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
### GET /fba/outbound/v0/returnReasonCodes
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
|**Query**|**SellerSKU**  <br>*required*|The seller SKU for which return reason codes are required.|string|
|**Query**|**MarketplaceId**  <br>*optional*|The marketplace for which the seller wants return reason codes.|string|
|**Query**|**SellerFulfillmentOrderId**  <br>*optional*|The identifier assigned to the item by the seller when the fulfillment order was created. The service uses this value to determine the marketplace for which the seller wants return reason codes.|string|
|**Query**|**Language**  <br>*required*|The language that the TranslatedDescription property of the ReasonCodeDetails response object should be translated into.|string|


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
### PUT /fba/outbound/v0/fulfillmentOrders/{sellerFulfillmentOrderId}/return
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
### GET /fba/outbound/v0/fulfillmentOrders/{sellerFulfillmentOrderId}
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
### PUT /fba/outbound/v0/fulfillmentOrders/{sellerFulfillmentOrderId}
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
### PUT /fba/outbound/v0/fulfillmentOrders/{sellerFulfillmentOrderId}/cancel
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


<a name="definitions"></a>
## Definitions

<a name="error"></a>
### Error
Error response returned when the request is unsuccessful.


|Name|Description|Schema|
|---|---|---|
|**code**  <br>*required*|An error code that identifies the type of error that occured.|string|
|**message**  <br>*required*|A message that describes the error condition.|string|
|**details**  <br>*optional*|Additional details that can help the caller understand or fix the issue.|string|


<a name="errorlist"></a>
### ErrorList
A list of error responses returned when a request is unsuccessful.

*Type* : < [Error](#error) > array


<a name="address"></a>
### Address

|Name|Description|Schema|
|---|---|---|
|**Name**  <br>*required*|Recipient's name.<br>**maxLength** : 50|string|
|**Line1**  <br>*required*|Recipient's street address information.<br>**maxLength** : 60|string|
|**Line2**  <br>*optional*|Additional street address information, if required.<br>**maxLength** : 60|string|
|**Line3**  <br>*optional*|Additional street address information, if required.<br>**maxLength** : 60|string|
|**DistrictOrCounty**  <br>*optional*|Recipient's district or county.<br>**maxLength** : 150|string|
|**City**  <br>*optional*|Recipient's city.<br>**maxLength** : 50|string|
|**StateOrProvinceCode**  <br>*required*|Recipient's state or province code.<br>**maxLength** : 150|string|
|**CountryCode**  <br>*required*|Recipient's country code.<br>**maxLength** : 2|string|
|**PostalCode**  <br>*optional*|The postal code (required for shipments to the U.S.).<br>**maxLength** : 20|string|
|**PhoneNumber**  <br>*optional*|Recipient's phone number.<br>**maxLength** : 20|string|


<a name="codsettings"></a>
### CODSettings
The COD (Cash On Delivery) charges that you associate with a COD fulfillment order.


|Name|Description|Schema|
|---|---|---|
|**IsCODRequired**  <br>*required*|Indicates whether this fulfillment order requires COD (Cash On Delivery) payment.|boolean|
|**CODCharge**  <br>*optional*|The amount of the COD charge to be collected from the recipient for a COD order.|[Currency](#currency)|
|**CODChargeTax**  <br>*optional*|The amount of the tax on the COD charge to be collected from the recipient for a COD order.|[Currency](#currency)|
|**ShippingCharge**  <br>*optional*|The amount of the tax on the COD charge to be collected from the recipient for a COD order.|[Currency](#currency)|
|**ShippingChargeTax**  <br>*optional*|The amount of the tax on the shipping charge to be collected from the recipient for a COD order.|[Currency](#currency)|


<a name="createfulfillmentorderitem"></a>
### CreateFulfillmentOrderItem
Item information for creating a fulfillment order.


|Name|Description|Schema|
|---|---|---|
|**SellerSKU**  <br>*required*|The seller SKU of the item.<br>**maxLength** : 50|string|
|**SellerFulfillmentOrderItemId**  <br>*required*|A fulfillment order item identifier that the seller creates to track fulfillment order items. Used to disambiguate multiple fulfillment items that have the same seller SKU. For example, the seller might assign different SellerFulfillmentOrderItemId values to two items in a fulfillment order that share the same seller SKU but have different GiftMessage values.<br>**maxLength** : 50|string|
|**Quantity**  <br>*required*|The item quantity.|[Quantity](#quantity)|
|**GiftMessage**  <br>*optional*|A message to the gift recipient, if applicable.<br>**maxLength** : 512|string|
|**DisplayableComment**  <br>*optional*|Item-specific text that displays in recipient-facing materials such as the outbound shipment packing slip.<br>**maxLength** : 250|string|
|**FulfillmentNetworkSKU**  <br>*optional*|Amazon's fulfillment network SKU of the item.|string|
|**PerUnitDeclaredValue**  <br>*optional*|The monetary value assigned by the seller to this item.|[Currency](#currency)|
|**PerUnitPrice**  <br>*optional*|The amount to be collected from the recipient for this item in a COD (Cash On Delivery) order.|[Currency](#currency)|
|**PerUnitTax**  <br>*optional*|The tax on the amount to be collected from the recipient for this item in a COD (Cash On Delivery) order.|[Currency](#currency)|


<a name="createfulfillmentorderitemlist"></a>
### CreateFulfillmentOrderItemList
A list of item information for creating a fulfillment order.

*Type* : < [CreateFulfillmentOrderItem](#createfulfillmentorderitem) > array


<a name="fulfillmentpolicy"></a>
### FulfillmentPolicy
The FulfillmentPolicy value specified when you submitted the createFulfillmentOrder operation.

*Type* : enum


|Value|Description|
|---|---|
|**FillOrKill**|If an item in a fulfillment order is determined to be unfulfillable before any shipment in the order has acquired the status of Pending (the process of picking units from inventory has begun), then the entire order is considered unfulfillable. However, if an item in a fulfillment order is determined to be unfulfillable after a shipment in the order has acquired the status of Pending, Amazon cancels as much of the fulfillment order as possible. See the FulfillmentShipment datatype for shipment status definitions.|
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
|**MarketplaceId**  <br>*optional*|The marketplace the fulfillment order is placed against.|string|
|**SellerFulfillmentOrderId**  <br>*required*|A fulfillment order identifier that the seller creates to track their fulfillment order. The SellerFulfillmentOrderId must be unique for each fulfillment order that a seller creates. If the seller's system already creates unique order identifiers, then these might be good values for them to use.<br>**maxLength** : 40|string|
|**DisplayableOrderId**  <br>*required*|A fulfillment order identifier that the seller creates. This value displays as the order identifier in recipient-facing materials such as the outbound shipment packing slip. The value of DisplayableOrderId should match the order identifier that the seller provides to the recipient. The seller can use the SellerFulfillmentOrderId for this value or they can specify an alternate value if they want the recipient to reference an alternate order identifier.<br><br>The value must be an alpha-numeric or ISO 8859-1 compliant string from one to 40 characters in length. Cannot contain two spaces in a row. Leading and trailing white space is removed.<br>**maxLength** : 40|string|
|**DisplayableOrderDateTime**  <br>*required*|The date and time of the fulfillment order. Displays as the order date in recipient-facing materials such as the outbound shipment packing slip.|[Timestamp](#timestamp)|
|**DisplayableOrderComment**  <br>*required*|Order-specific text that appears in recipient-facing materials such as the outbound shipment packing slip.<br>**maxLength** : 1000|string|
|**ShippingSpeedCategory**  <br>*required*|The shipping method for the fulfillment order.|[ShippingSpeedCategory](#shippingspeedcategory)|
|**DeliveryWindow**  <br>*optional*|The time range within which a Scheduled Delivery fulfillment order should be delivered.|[DeliveryWindow](#deliverywindow)|
|**DestinationAddress**  <br>*required*|The destination address for the fulfillment order.|[Address](#address)|
|**FulfillmentAction**  <br>*optional*|Specifies whether the fulfillment order should ship now or have an order hold put on it.|[FulfillmentAction](#fulfillmentaction)|
|**FulfillmentPolicy**  <br>*optional*|The FulfillmentPolicy value specified when you submitted the createFulfillmentOrder operation.|[FulfillmentPolicy](#fulfillmentpolicy)|
|**FulfillmentMethod**  <br>*optional*|Indicates the intended recipient channel for the order.|string|
|**CODSettings**  <br>*optional*|The COD (Cash On Delivery) charges that you associate with a COD fulfillment order.|[CODSettings](#codsettings)|
|**ShipFromCountryCode**  <br>*optional*|The two-character country code for the country from which the fulfillment order ships. Must be in ISO 3166-1 alpha-2 format.|string|
|**NotificationEmailList**  <br>*optional*|A list of email addresses that the seller provides that are used by Amazon to send ship-complete notifications to recipients on behalf of the seller.|[NotificationEmailList](#notificationemaillist)|
|**Items**  <br>*required*|A list of items to include in the fulfillment order preview, including quantity.|[CreateFulfillmentOrderItemList](#createfulfillmentorderitemlist)|


<a name="createfulfillmentreturnrequest"></a>
### CreateFulfillmentReturnRequest
The createFulfillmentReturn operation creates a fulfillment return for items that were fulfilled using the createFulfillmentOrder operation. For calls to createFulfillmentReturn, you must include ReturnReasonCode values returned by a previous call to the listReturnReasonCodes operation.


|Name|Description|Schema|
|---|---|---|
|**Items**  <br>*required*|A list of items to be returned.|[CreateReturnItemList](#createreturnitemlist)|


<a name="createfulfillmentreturnresult"></a>
### CreateFulfillmentReturnResult

|Name|Description|Schema|
|---|---|---|
|**ReturnItemList**  <br>*optional*|A list of items that Amazon accepted for return. Returns empty if no items were accepted for return.|[ReturnItemList](#returnitemlist)|
|**InvalidReturnItemList**  <br>*optional*|A list of invalid return item information.|[InvalidReturnItemList](#invalidreturnitemlist)|
|**ReturnAuthorizationList**  <br>*optional*|A list of return authorization information.|[ReturnAuthorizationList](#returnauthorizationlist)|


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
|**SellerReturnItemId**  <br>*required*|An identifier assigned by the seller to the return item.<br>**maxLength** : 80|string|
|**SellerFulfillmentOrderItemId**  <br>*required*|The identifier assigned to the item by the seller when the fulfillment order was created.|string|
|**AmazonShipmentId**  <br>*required*|The identifier for the shipment that is associated with the return item.|string|
|**ReturnReasonCode**  <br>*required*|The return reason code assigned to the return item by the seller.|string|
|**ReturnComment**  <br>*optional*|An optional comment about the return item.<br>**maxLength** : 1000|string|


<a name="createreturnitemlist"></a>
### CreateReturnItemList
A list of items to be returned.

*Type* : < [CreateReturnItem](#createreturnitem) > array


<a name="currency"></a>
### Currency
Currency type and amount.


|Name|Description|Schema|
|---|---|---|
|**CurrencyCode**  <br>*required*|Three-digit currency code in ISO 4217 format.|string|
|**Value**  <br>*required*|The currency amount.|string|


<a name="deliverywindow"></a>
### DeliveryWindow
The time range within which a Scheduled Delivery fulfillment order should be delivered.


|Name|Description|Schema|
|---|---|---|
|**StartDateTime**  <br>*required*|The date and time of the start of the Scheduled Delivery window, in ISO 8601 date time format.|[Timestamp](#timestamp)|
|**EndDateTime**  <br>*required*|The date and time of the end of the Scheduled Delivery window, in ISO 8601 date time format.|[Timestamp](#timestamp)|


<a name="deliverywindowlist"></a>
### DeliveryWindowList
A list of delivery windows.

*Type* : < [DeliveryWindow](#deliverywindow) > array


<a name="fee"></a>
### Fee
Fee type and cost.


|Name|Description|Schema|
|---|---|---|
|**Name**  <br>*required*|The type of fee.|enum ([Name](#name))|
|**Amount**  <br>*required*|The amount of the fee.|[Currency](#currency)|


<a name="feelist"></a>
### FeeList
A list of fee type and cost pairs.

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
|**SellerFulfillmentOrderId**  <br>*required*|The fulfillment order identifier submitted with the createFulfillmentOrder operation.|string|
|**MarketplaceId**  <br>*required*|The identifier for the marketplace the fulfillment order is placed against.|string|
|**DisplayableOrderId**  <br>*required*|A fulfillment order identifier submitted with the createFulfillmentOrder operation. Displays as the order identifier in recipient-facing materials such as the packing slip.|string|
|**DisplayableOrderDateTime**  <br>*required*|A date and time submitted with the createFulfillmentOrder operation. Displays as the order date in recipient-facing materials such as the packing slip.|[Timestamp](#timestamp)|
|**DisplayableOrderComment**  <br>*required*|A text block submitted with the createFulfillmentOrder operation. Displays in recipient-facing materials such as the packing slip.|string|
|**ShippingSpeedCategory**  <br>*required*|The shipping method used for the fulfillment order.|[ShippingSpeedCategory](#shippingspeedcategory)|
|**DeliveryWindow**  <br>*optional*|The time range within which a Scheduled Delivery fulfillment order should be delivered.|[DeliveryWindow](#deliverywindow)|
|**DestinationAddress**  <br>*required*|The destination address submitted with the createFulfillmentOrder operation.|[Address](#address)|
|**FulfillmentAction**  <br>*optional*|Specifies whether the fulfillment order should ship now or have an order hold put on it.|[FulfillmentAction](#fulfillmentaction)|
|**FulfillmentPolicy**  <br>*optional*|The FulfillmentPolicy value specified when you submitted the createFulfillmentOrder operation.|[FulfillmentPolicy](#fulfillmentpolicy)|
|**FulfillmentMethod**  <br>*optional*|Indicates the intended recipient channel for the order.|string|
|**CODSettings**  <br>*optional*|The COD (Cash On Delivery) charges that you associate with a COD fulfillment order.|[CODSettings](#codsettings)|
|**ReceivedDateTime**  <br>*required*|The date and time that the fulfillment order was received by an Amazon fulfillment center.|[Timestamp](#timestamp)|
|**FulfillmentOrderStatus**  <br>*required*|The current status of the fulfillment order.|[FulfillmentOrderStatus](#fulfillmentorderstatus)|
|**StatusUpdatedDateTime**  <br>*required*|The date and time that the status of the fulfillment order last changed, in ISO 8601 date time format.|[Timestamp](#timestamp)|
|**NotificationEmailList**  <br>*optional*|A list of email addresses that the seller provides that are used by Amazon to send ship-complete notifications to recipients on behalf of the seller.|[NotificationEmailList](#notificationemaillist)|


<a name="fulfillmentorderitem"></a>
### FulfillmentOrderItem
Item information for a fulfillment order.


|Name|Description|Schema|
|---|---|---|
|**SellerSKU**  <br>*required*|The seller SKU of the item.|string|
|**SellerFulfillmentOrderItemId**  <br>*required*|A fulfillment order item identifier submitted with a call to the createFulfillmentOrder operation.|string|
|**Quantity**  <br>*required*|The item quantity.|[Quantity](#quantity)|
|**GiftMessage**  <br>*optional*|A message to the gift recipient, if applicable.|string|
|**DisplayableComment**  <br>*optional*|Item-specific text that displays in recipient-facing materials such as the outbound shipment packing slip.|string|
|**FulfillmentNetworkSKU**  <br>*optional*|Amazon's fulfillment network SKU of the item.|string|
|**OrderItemDisposition**  <br>*optional*|Indicates whether the item is sellable or unsellable.|string|
|**CancelledQuantity**  <br>*required*|The item quantity that was cancelled by the seller.|[Quantity](#quantity)|
|**UnfulfillableQuantity**  <br>*required*|The item quantity that is unfulfillable.|[Quantity](#quantity)|
|**EstimatedShipDateTime**  <br>*optional*|The estimated date and time that the item quantity is scheduled to ship from the fulfillment center. Note that this value can change over time. If the shipment that contains the item quantity has been cancelled, EstimatedShipDateTime is not returned.|[Timestamp](#timestamp)|
|**EstimatedArrivalDateTime**  <br>*optional*|The estimated arrival date and time of the item quantity. Note that this value can change over time. If the shipment that contains the item quantity has been cancelled, EstimatedArrivalDateTime is not returned.|[Timestamp](#timestamp)|
|**PerUnitPrice**  <br>*optional*|The amount to be collected from the recipient for this item in a COD (Cash On Delivery) order.|[Currency](#currency)|
|**PerUnitTax**  <br>*optional*|The tax on the amount to be collected from the recipient for this item in a COD (Cash On Delivery) order.|[Currency](#currency)|
|**PerUnitDeclaredValue**  <br>*optional*|The monetary value assigned by the seller to this item.|[Currency](#currency)|


<a name="fulfillmentorderitemlist"></a>
### FulfillmentOrderItemList
A list of fulfillment order item information.

*Type* : < [FulfillmentOrderItem](#fulfillmentorderitem) > array


<a name="fulfillmentorderlist"></a>
### FulfillmentOrderList
A list of fulfillment order information.

*Type* : < [FulfillmentOrder](#fulfillmentorder) > array


<a name="fulfillmentpreview"></a>
### FulfillmentPreview
Information about a fulfillment order preview, including delivery and fee information based on shipping method.


|Name|Description|Schema|
|---|---|---|
|**ShippingSpeedCategory**  <br>*required*|The shipping method used for the fulfillment order.|[ShippingSpeedCategory](#shippingspeedcategory)|
|**ScheduledDeliveryInfo**  <br>*optional*|Delivery information for a Scheduled Delivery.|[ScheduledDeliveryInfo](#scheduleddeliveryinfo)|
|**IsFulfillable**  <br>*required*|When true, this fulfillment order preview is fulfillable.|boolean|
|**IsCODCapable**  <br>*required*|When true, this fulfillment order preview is for COD (Cash On Delivery).|boolean|
|**EstimatedShippingWeight**  <br>*optional*|Estimated shipping weight for this fulfillment order preview.|[Weight](#weight)|
|**EstimatedFees**  <br>*optional*|The estimated fulfillment fees for this fulfillment order preview, if applicable.|[FeeList](#feelist)|
|**FulfillmentPreviewShipments**  <br>*optional*|A list of fulfillment preview shipment information.|[FulfillmentPreviewShipmentList](#fulfillmentpreviewshipmentlist)|
|**UnfulfillablePreviewItems**  <br>*optional*|A list of unfulfillable preview item information.|[UnfulfillablePreviewItemList](#unfulfillablepreviewitemlist)|
|**OrderUnfulfillableReasons**  <br>*optional*|Error codes associated with the fulfillment order preview that indicate why the order is not fulfillable.<br><br>Error code examples:<br><br>DeliverySLAUnavailable<br><br>InvalidDestinationAddress|[StringList](#stringlist)|
|**MarketplaceId**  <br>*required*|The marketplace the fulfillment order is placed against.|string|


<a name="fulfillmentpreviewitem"></a>
### FulfillmentPreviewItem
Item information for a shipment in a fulfillment order preview.


|Name|Description|Schema|
|---|---|---|
|**SellerSKU**  <br>*required*|The seller SKU of the item.|string|
|**Quantity**  <br>*required*|The item quantity.|[Quantity](#quantity)|
|**SellerFulfillmentOrderItemId**  <br>*required*|A fulfillment order item identifier that the seller created with a call to the createFulfillmentOrder operation.|string|
|**EstimatedShippingWeight**  <br>*optional*|The estimated shipping weight of the item quantity for a single item, as identified by sellerSKU, in a shipment.|[Weight](#weight)|
|**ShippingWeightCalculationMethod**  <br>*optional*|The method used to calculate EstimatedShippingWeight.|enum ([ShippingWeightCalculationMethod](#shippingweightcalculationmethod))|


<a name="fulfillmentpreviewitemlist"></a>
### FulfillmentPreviewItemList
A list of fulfillment preview item information.

*Type* : < [FulfillmentPreviewItem](#fulfillmentpreviewitem) > array


<a name="fulfillmentpreviewlist"></a>
### FulfillmentPreviewList
A list of fulfillment preview information.

*Type* : < [FulfillmentPreview](#fulfillmentpreview) > array


<a name="fulfillmentpreviewshipment"></a>
### FulfillmentPreviewShipment
Delivery and item information for a shipment in a fulfillment order preview.


|Name|Description|Schema|
|---|---|---|
|**EarliestShipDate**  <br>*required*|The earliest date that the shipment is expected to be sent from the fulfillment center, in ISO 8601 date time format.|[Timestamp](#timestamp)|
|**LatestShipDate**  <br>*required*|The latest date that the shipment is expected to be sent from the fulfillment center, in ISO 8601 date time format.|[Timestamp](#timestamp)|
|**EarliestArrivalDate**  <br>*required*|The earliest date that the shipment is expected to arrive at its destination.|[Timestamp](#timestamp)|
|**LatestArrivalDate**  <br>*required*|The latest date that the shipment is expected to arrive at its destination, in ISO 8601 date time format.|[Timestamp](#timestamp)|
|**FulfillmentPreviewItems**  <br>*required*|Information about the items in the shipment.|[FulfillmentPreviewItemList](#fulfillmentpreviewitemlist)|


<a name="fulfillmentpreviewshipmentlist"></a>
### FulfillmentPreviewShipmentList
A list of fulfillment preview shipment information.

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
|**AmazonShipmentId**  <br>*required*|A shipment identifier assigned by Amazon.|string|
|**FulfillmentCenterId**  <br>*required*|An identifier for the fulfillment center that the shipment will be sent from.|string|
|**FulfillmentShipmentStatus**  <br>*required*|The current status of the shipment.|enum ([FulfillmentShipmentStatus](#fulfillmentshipmentstatus))|
|**ShippingDateTime**  <br>*optional*|The meaning of the ShippingDateTime value depends on the current status of the shipment. If the current value of FulfillmentShipmentStatus is:<br><br><li> Pending - ShippingDateTime represents the estimated time that the shipment will leave the Amazon fulfillment center.</li><br><li> Shipped - ShippingDateTime represents the date that the shipment left the Amazon fulfillment center.</li><br>If a shipment includes more than one package, ShippingDateTime applies to all of the packages in the shipment. If the value of FulfillmentShipmentStatus is CancelledByFulfiller or CancelledBySeller, ShippingDateTime is not returned. The value must be in ISO 8601 date time format.|[Timestamp](#timestamp)|
|**EstimatedArrivalDateTime**  <br>*optional*|The estimated arrival date and time of the shipment, in ISO 8601 date time format. Note that this value can change over time. If a shipment includes more than one package, EstimatedArrivalDateTime applies to all of the packages in the shipment. If the shipment has been cancelled, EstimatedArrivalDateTime is not returned.|[Timestamp](#timestamp)|
|**FulfillmentShipmentItem**  <br>*required*|A list of fulfillment shipment item information.|[FulfillmentShipmentItemList](#fulfillmentshipmentitemlist)|
|**FulfillmentShipmentPackage**  <br>*optional*|A list of fulfillment shipment package information.|[FulfillmentShipmentPackageList](#fulfillmentshipmentpackagelist)|


<a name="fulfillmentshipmentitem"></a>
### FulfillmentShipmentItem
Item information for a shipment in a fulfillment order.


|Name|Description|Schema|
|---|---|---|
|**SellerSKU**  <br>*required*|The seller SKU of the item.|string|
|**SellerFulfillmentOrderItemId**  <br>*required*|The fulfillment order item identifier that the seller created and submitted with a call to the createFulfillmentOrder operation.|string|
|**Quantity**  <br>*required*|The item quantity.|[Quantity](#quantity)|
|**PackageNumber**  <br>*optional*|An identifier for the package that contains the item quantity.|integer (int32)|


<a name="fulfillmentshipmentitemlist"></a>
### FulfillmentShipmentItemList
A list of fulfillment shipment item information.

*Type* : < [FulfillmentShipmentItem](#fulfillmentshipmentitem) > array


<a name="fulfillmentshipmentlist"></a>
### FulfillmentShipmentList
A list of fulfillment shipment information.

*Type* : < [FulfillmentShipment](#fulfillmentshipment) > array


<a name="fulfillmentshipmentpackage"></a>
### FulfillmentShipmentPackage
Package information for a shipment in a fulfillment order.


|Name|Description|Schema|
|---|---|---|
|**PackageNumber**  <br>*required*|Identifies a package in a shipment.|integer (int32)|
|**CarrierCode**  <br>*required*|Identifies the carrier who will deliver the shipment to the recipient.|string|
|**TrackingNumber**  <br>*optional*|The tracking number, if provided, can be used to obtain tracking and delivery information.|string|
|**EstimatedArrivalDateTime**  <br>*optional*|The estimated arrival date and time of the package, in ISO 8601 date time format.|[Timestamp](#timestamp)|


<a name="fulfillmentshipmentpackagelist"></a>
### FulfillmentShipmentPackageList
A list of fulfillment shipment package information.

*Type* : < [FulfillmentShipmentPackage](#fulfillmentshipmentpackage) > array


<a name="getfulfillmentorderresult"></a>
### GetFulfillmentOrderResult

|Name|Description|Schema|
|---|---|---|
|**FulfillmentOrder**  <br>*required*|General information about a fulfillment order, including its status.|[FulfillmentOrder](#fulfillmentorder)|
|**FulfillmentOrderItem**  <br>*required*|A list of fulfillment order item information.|[FulfillmentOrderItemList](#fulfillmentorderitemlist)|
|**FulfillmentShipment**  <br>*optional*|A list of fulfillment shipment information.|[FulfillmentShipmentList](#fulfillmentshipmentlist)|
|**ReturnItemList**  <br>*required*|A list of items that Amazon accepted for return. Returns empty if no items were accepted for return.|[ReturnItemList](#returnitemlist)|
|**ReturnAuthorizationList**  <br>*required*|A list of return authorization information.|[ReturnAuthorizationList](#returnauthorizationlist)|


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
|**SellerSKU**  <br>*required*|The seller SKU of the item.<br>**maxLength** : 50|string|
|**Quantity**  <br>*required*|The item quantity.|[Quantity](#quantity)|
|**SellerFulfillmentOrderItemId**  <br>*required*|A fulfillment order item identifier that the seller creates to track items in the fulfillment preview.<br>**maxLength** : 50|string|


<a name="getfulfillmentpreviewitemlist"></a>
### GetFulfillmentPreviewItemList
A list of fulfillment preview item information.

*Type* : < [GetFulfillmentPreviewItem](#getfulfillmentpreviewitem) > array


<a name="getfulfillmentpreviewrequest"></a>
### GetFulfillmentPreviewRequest

|Name|Description|Schema|
|---|---|---|
|**MarketplaceId**  <br>*optional*|The marketplace the fulfillment order is placed against.|string|
|**Address**  <br>*required*|The destination address for the fulfillment order preview.|[Address](#address)|
|**Items**  <br>*required*|Identifying information and quantity information for the items in the fulfillment order preview.|[GetFulfillmentPreviewItemList](#getfulfillmentpreviewitemlist)|
|**ShippingSpeedCategories**  <br>*optional*|A list of shipping methods used for creating fulfillment order previews.<br>Note: Shipping method service level agreements vary by marketplace. Sellers should see the Seller Central website in their marketplace for shipping method service level agreements and fulfillment fees.|[ShippingSpeedCategoryList](#shippingspeedcategorylist)|
|**IncludeCODFulfillmentPreview**  <br>*optional*|Specifies whether to return fulfillment order previews that are for COD (Cash On Delivery).<br><br>Possible values:<br><br>true - Returns all fulfillment order previews (both for COD and not for COD).<br><br>false - Returns only fulfillment order previews that are not for COD.|boolean|
|**IncludeDeliveryWindows**  <br>*optional*|Specifies whether to return the ScheduledDeliveryInfo response object, which contains the available delivery windows for a Scheduled Delivery. The ScheduledDeliveryInfo response object can only be returned for fulfillment order previews with ShippingSpeedCategories = ScheduledDelivery.|boolean|


<a name="getfulfillmentpreviewresult"></a>
### GetFulfillmentPreviewResult
A list of fulfillment order previews, including estimated shipping weights, estimated shipping fees, and estimated ship dates and arrival dates.


|Name|Description|Schema|
|---|---|---|
|**FulfillmentPreviews**  <br>*optional*|A list of fulfillment preview information.|[FulfillmentPreviewList](#fulfillmentpreviewlist)|


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
|**InvalidItemReasonCode**  <br>*required*|A code for why the item is invalid for return.|[InvalidItemReasonCode](#invaliditemreasoncode)|
|**Description**  <br>*required*|A human readable description of the invalid item reason code.|string|


<a name="invalidreturnitem"></a>
### InvalidReturnItem
An item that is invalid for return.


|Name|Description|Schema|
|---|---|---|
|**SellerReturnItemId**  <br>*required*|An identifier assigned by the seller to the return item.|string|
|**SellerFulfillmentOrderItemId**  <br>*required*|The identifier assigned to the item by the seller when the fulfillment order was created.|string|
|**InvalidItemReason**  <br>*required*|The reason that the item is invalid for return.|[InvalidItemReason](#invaliditemreason)|


<a name="invalidreturnitemlist"></a>
### InvalidReturnItemList
A list of invalid return item information.

*Type* : < [InvalidReturnItem](#invalidreturnitem) > array


<a name="listallfulfillmentordersresult"></a>
### ListAllFulfillmentOrdersResult

|Name|Description|Schema|
|---|---|---|
|**NextToken**  <br>*optional*|When present and not empty, pass this string token in the next request to return the next response page.|string|
|**FulfillmentOrders**  <br>*optional*|A list of fulfillment order information.|[FulfillmentOrderList](#fulfillmentorderlist)|


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
|**ReasonCodeDetailsList**  <br>*optional*|A list of return reason code details.|[ReasonCodeDetailsList](#reasoncodedetailslist)|


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
|**PackageNumber**  <br>*required*|The package identifier.|integer (int32)|
|**TrackingNumber**  <br>*optional*|The tracking number for the package.|string|
|**CarrierCode**  <br>*optional*|The name of the carrier.|string|
|**CarrierPhoneNumber**  <br>*optional*|The phone number of the carrier.|string|
|**CarrierURL**  <br>*optional*|The URL of the carrier’s website.|string|
|**ShipDate**  <br>*optional*|The shipping date for the package.|[Timestamp](#timestamp)|
|**EstimatedArrivalDate**  <br>*optional*|The estimated arrival date.|[Timestamp](#timestamp)|
|**ShipToAddress**  <br>*optional*|The destination city for the package.|[TrackingAddress](#trackingaddress)|
|**CurrentStatus**  <br>*optional*|The current delivery status of the package.|[CurrentStatus](#currentstatus)|
|**SignedForBy**  <br>*optional*|The name of the person who signed for the package.|string|
|**AdditionalLocationInfo**  <br>*optional*|Additional location information.|[AdditionalLocationInfo](#additionallocationinfo)|
|**TrackingEvents**  <br>*optional*|A list of tracking event information.|[TrackingEventList](#trackingeventlist)|


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
|**ReturnReasonCode**  <br>*required*|A code that indicates a valid return reason.|string|
|**Description**  <br>*required*|A human readable description of the return reason code.|string|
|**TranslatedDescription**  <br>*optional*|A translation of the description. The translation is in the language specified in the Language request parameter.|string|


<a name="reasoncodedetailslist"></a>
### ReasonCodeDetailsList
A list of return reason code details.

*Type* : < [ReasonCodeDetails](#reasoncodedetails) > array


<a name="returnauthorization"></a>
### ReturnAuthorization
Return authorization information for items accepted for return.


|Name|Description|Schema|
|---|---|---|
|**ReturnAuthorizationId**  <br>*required*|An identifier for the return authorization. This identifier associates return items with the return authorization used to return them.|string|
|**FulfillmentCenterId**  <br>*required*|An identifier for the Amazon fulfillment center that the return items should be sent to.|string|
|**ReturnToAddress**  <br>*required*|The address of the Amazon fulfillment center that the return items should be sent to.|[Address](#address)|
|**AmazonRmaId**  <br>*required*|The return merchandise authorization (RMA) that Amazon needs to process the return.|string|
|**RmaPageURL**  <br>*required*|A URL for a web page that contains the return authorization barcode and the mailing label. This does not include pre-paid shipping.|string|


<a name="returnauthorizationlist"></a>
### ReturnAuthorizationList
A list of return authorization information.

*Type* : < [ReturnAuthorization](#returnauthorization) > array


<a name="returnitem"></a>
### ReturnItem
An item that Amazon accepted for return.


|Name|Description|Schema|
|---|---|---|
|**SellerReturnItemId**  <br>*required*|An identifier assigned by the seller to the return item.|string|
|**SellerFulfillmentOrderItemId**  <br>*required*|The identifier assigned to the item by the seller when the fulfillment order was created.|string|
|**AmazonShipmentId**  <br>*required*|The identifier for the shipment that is associated with the return item.|string|
|**SellerReturnReasonCode**  <br>*required*|The return reason code assigned to the return item by the seller.|string|
|**ReturnComment**  <br>*optional*|An optional comment about the return item.|string|
|**AmazonReturnReasonCode**  <br>*optional*|The return reason code that the Amazon fulfillment center assigned to the return item.|string|
|**Status**  <br>*required*|Indicates if the return item has been processed by an Amazon fulfillment center.|[FulfillmentReturnItemStatus](#fulfillmentreturnitemstatus)|
|**StatusChangedDate**  <br>*required*|Indicates when the status last changed.|[Timestamp](#timestamp)|
|**ReturnAuthorizationId**  <br>*optional*|Identifies the return authorization used to return this item. See ReturnAuthorization.|string|
|**ReturnReceivedCondition**  <br>*optional*|The condition of the return item when received by an Amazon fulfillment center.|[ReturnItemDisposition](#returnitemdisposition)|
|**FulfillmentCenterId**  <br>*optional*|The identifier for the Amazon fulfillment center that processed the return item.|string|


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
A list of items that Amazon accepted for return. Returns empty if no items were accepted for return.

*Type* : < [ReturnItem](#returnitem) > array


<a name="scheduleddeliveryinfo"></a>
### ScheduledDeliveryInfo
Delivery information for a Scheduled Delivery.


|Name|Description|Schema|
|---|---|---|
|**DeliveryTimeZone**  <br>*required*|The time zone of the destination address for the fulfillment order preview. Must be an IANA time zone name. Example: Asia/Tokyo.|string|
|**DeliveryWindows**  <br>*required*|A list of time ranges that are available for Scheduled Delivery.|[DeliveryWindowList](#deliverywindowlist)|


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
|**City**  <br>*required*|The city.<br>**maxLength** : 150|string|
|**State**  <br>*required*|The state.<br>**maxLength** : 150|string|
|**Country**  <br>*required*|The country.<br>**maxLength** : 6|string|


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
|**EventDate**  <br>*required*|The date and time that the delivery event took place, in ISO 8601 date time format.|[Timestamp](#timestamp)|
|**EventAddress**  <br>*required*|The city where the delivery event took place.|[TrackingAddress](#trackingaddress)|
|**EventCode**  <br>*required*|The event code for the delivery event.|[EventCode](#eventcode)|


<a name="trackingeventlist"></a>
### TrackingEventList
A list of tracking event information.

*Type* : < [TrackingEvent](#trackingevent) > array


<a name="unfulfillablepreviewitem"></a>
### UnfulfillablePreviewItem
Information about unfulfillable items in a fulfillment order preview.


|Name|Description|Schema|
|---|---|---|
|**SellerSKU**  <br>*required*|The seller SKU of the item.<br>**maxLength** : 50|string|
|**Quantity**  <br>*required*|The item quantity.|[Quantity](#quantity)|
|**SellerFulfillmentOrderItemId**  <br>*required*|A fulfillment order item identifier created with a call to the getFulfillmentPreview operation.<br>**maxLength** : 50|string|
|**ItemUnfulfillableReasons**  <br>*optional*|Error codes associated with the fulfillment order preview that indicate why the item is unfulfillable.|[StringList](#stringlist)|


<a name="unfulfillablepreviewitemlist"></a>
### UnfulfillablePreviewItemList
A list of unfulfillable preview item information.

*Type* : < [UnfulfillablePreviewItem](#unfulfillablepreviewitem) > array


<a name="updatefulfillmentorderitem"></a>
### UpdateFulfillmentOrderItem
Item information for updating a fulfillment order.


|Name|Description|Schema|
|---|---|---|
|**SellerSKU**  <br>*optional*|The seller SKU of the item.|string|
|**SellerFulfillmentOrderItemId**  <br>*required*|Identifies the fulfillment order item to update. Created with a previous call to the createFulfillmentOrder operation.<br>**maxLength** : 50|string|
|**Quantity**  <br>*required*|The item quantity.|[Quantity](#quantity)|
|**GiftMessage**  <br>*optional*|A message to the gift recipient, if applicable.<br>**maxLength** : 512|string|
|**DisplayableComment**  <br>*optional*|Item-specific text that displays in recipient-facing materials such as the outbound shipment packing slip.<br>**maxLength** : 250|string|
|**FulfillmentNetworkSKU**  <br>*optional*|Amazon's fulfillment network SKU of the item.|string|
|**OrderItemDisposition**  <br>*optional*|Indicates whether the item is sellable or unsellable.|string|
|**PerUnitDeclaredValue**  <br>*optional*|The monetary value assigned by the seller to this item.|[Currency](#currency)|
|**PerUnitPrice**  <br>*optional*|The amount to be collected from the recipient for this item in a COD (Cash On Delivery) order.|[Currency](#currency)|
|**PerUnitTax**  <br>*optional*|The tax on the amount to be collected from the recipient for this item in a COD (Cash On Delivery) order.|[Currency](#currency)|


<a name="updatefulfillmentorderitemlist"></a>
### UpdateFulfillmentOrderItemList
A list of fulfillment order item information for updating a fulfillment order.

*Type* : < [UpdateFulfillmentOrderItem](#updatefulfillmentorderitem) > array


<a name="updatefulfillmentorderrequest"></a>
### UpdateFulfillmentOrderRequest

|Name|Description|Schema|
|---|---|---|
|**MarketplaceId**  <br>*optional*|The marketplace the fulfillment order is placed against.|string|
|**DisplayableOrderId**  <br>*optional*|A fulfillment order identifier that the seller creates. This value displays as the order identifier in recipient-facing materials such as the outbound shipment packing slip. The value of DisplayableOrderId should match the order identifier that the seller provides to the recipient. The seller can use the SellerFulfillmentOrderId for this value or they can specify an alternate value if they want the recipient to reference an alternate order identifier.<br>**maxLength** : 40|string|
|**DisplayableOrderDateTime**  <br>*optional*|The date of the fulfillment order. Displays as the order date in recipient-facing materials such as the outbound shipment packing slip.|[Timestamp](#timestamp)|
|**DisplayableOrderComment**  <br>*optional*|Order-specific text that appears in recipient-facing materials such as the outbound shipment packing slip.<br>**maxLength** : 1000|string|
|**ShippingSpeedCategory**  <br>*optional*|The shipping method used for the fulfillment order.|[ShippingSpeedCategory](#shippingspeedcategory)|
|**DestinationAddress**  <br>*optional*|The destination address for the fulfillment order.|[Address](#address)|
|**FulfillmentAction**  <br>*optional*|Specifies whether the fulfillment order should ship now or have an order hold put on it.|[FulfillmentAction](#fulfillmentaction)|
|**FulfillmentPolicy**  <br>*optional*|The FulfillmentPolicy value specified when you submitted the createFulfillmentOrder operation.|[FulfillmentPolicy](#fulfillmentpolicy)|
|**FulfillmentMethod**  <br>*optional*|Indicates the intended recipient channel for the order.|string|
|**ShipFromCountryCode**  <br>*optional*|The two-character country code for the country from which the fulfillment order ships. Must be in ISO 3166-1 alpha-2 format.|string|
|**NotificationEmailList**  <br>*optional*|A list of email addresses that the seller provides that are used by Amazon to send ship-complete notifications to recipients on behalf of the seller.|[NotificationEmailList](#notificationemaillist)|
|**Items**  <br>*optional*|A list of items to include in the fulfillment order preview, including quantity.|[UpdateFulfillmentOrderItemList](#updatefulfillmentorderitemlist)|


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

|Name|Description|Schema|
|---|---|---|
|**Unit**  <br>*required*|The unit of weight.|enum ([Unit](#unit))|
|**Value**  <br>*required*|The weight value.|string|


<a name="boolean"></a>
### boolean
*Type* : boolean


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
The method used to calculate EstimatedShippingWeight.

*Type* : enum


|Value|Description|
|---|---|
|**Package**|Based on the actual weight of the items.|
|**Dimensional**|Based on the cubic space that the items occupy.|

