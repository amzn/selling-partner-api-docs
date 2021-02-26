# Selling Partner API for Fulfillment Inbound


<a name="overview"></a>
## Overview
The Selling Partner API for Fulfillment Inbound lets you create applications that create and update inbound shipments of inventory to Amazon's fulfillment network.


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
[getInboundGuidance](#getinboundguidance)<br>[createInboundShipmentPlan](#createinboundshipmentplan)<br>[updateInboundShipment](#updateinboundshipment)<br>[createInboundShipment](#createinboundshipment)<br>[getPreorderInfo](#getpreorderinfo)<br>[confirmPreorder](#confirmpreorder)<br>[getPrepInstructions](#getprepinstructions)<br>[getTransportDetails](#gettransportdetails)<br>[putTransportDetails](#puttransportdetails)<br>[voidTransport](#voidtransport)<br>[estimateTransport](#estimatetransport)<br>[confirmTransport](#confirmtransport)<br>[getLabels](#getlabels)<br>[getBillOfLading](#getbilloflading)<br>[getShipments](#getshipments)<br>[getShipmentItemsByShipmentId](#getshipmentitemsbyshipmentid)<br>[getShipmentItems](#getshipmentitems)<br>
<a name="paths"></a>
## Paths

<a name="getinboundguidance"></a>
### GET /fba/inbound/v0/itemsGuidance
**Operation: getInboundGuidance**

#### Description
Returns information that lets a seller know if Amazon recommends sending an item to a given marketplace. In some cases, Amazon provides guidance for why a given SellerSKU or ASIN is not recommended for shipment to Amazon's fulfillment network. Sellers may still ship items that are not recommended, at their discretion.

**Usage Plan:**

| Rate (requests per second) | Burst |
| ---- | ---- |
| 2 | 30 |

For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Query**|**MarketplaceId**  <br>*required*|A marketplace identifier. Specifies the marketplace where the product would be stored.|string|
|**Query**|**SellerSKUList**  <br>*optional*|A list of SellerSKU values. Used to identify items for which you want inbound guidance for shipment to Amazon's fulfillment network. Note: SellerSKU is qualified by the SellerId, which is included with every Selling Partner API operation that you submit. If you specify a SellerSKU that identifies a variation parent ASIN, this operation returns an error. A variation parent ASIN represents a generic product that cannot be sold. Variation child ASINs represent products that have specific characteristics (such as size and color) and can be sold.<br>**Max count** : 50|< string > array|
|**Query**|**ASINList**  <br>*optional*|A list of ASIN values. Used to identify items for which you want inbound guidance for shipment to Amazon's fulfillment network. Note: If you specify a ASIN that identifies a variation parent ASIN, this operation returns an error. A variation parent ASIN represents a generic product that cannot be sold. Variation child ASINs represent products that have specific characteristics (such as size and color) and can be sold.<br>**Max count** : 50|< string > array|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Success.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[GetInboundGuidanceResponse](#getinboundguidanceresponse)|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[GetInboundGuidanceResponse](#getinboundguidanceresponse)|
|**401**|The request's Authorization header is not formatted correctly or does not contain a valid token.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[GetInboundGuidanceResponse](#getinboundguidanceresponse)|
|**403**|Indicates that access to the resource is forbidden. Possible reasons include Access Denied, Unauthorized, Expired Token, or Invalid Signature.  <br>**Headers** :   <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[GetInboundGuidanceResponse](#getinboundguidanceresponse)|
|**404**|The specified resource does not exist.  <br>**Headers** :   <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[GetInboundGuidanceResponse](#getinboundguidanceresponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[GetInboundGuidanceResponse](#getinboundguidanceresponse)|
|**500**|An unexpected condition occurred that prevented the server from fulfilling the request.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[GetInboundGuidanceResponse](#getinboundguidanceresponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[GetInboundGuidanceResponse](#getinboundguidanceresponse)|


<a name="createinboundshipmentplan"></a>
### POST /fba/inbound/v0/plans
**Operation: createInboundShipmentPlan**

#### Description
Returns one or more inbound shipment plans, which provide the information you need to create one or more inbound shipments for a set of items that you specify. Multiple inbound shipment plans might be required so that items can be optimally placed in Amazon's fulfillment network—for example, positioning inventory closer to the customer. Alternatively, two inbound shipment plans might be created with the same Amazon fulfillment center destination if the two shipment plans require different processing—for example, items that require labels must be shipped separately from stickerless, commingled inventory.

**Usage Plan:**

| Rate (requests per second) | Burst |
| ---- | ---- |
| 2 | 30 |

For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Body**|**body**  <br>*required*|The request schema for the createInboundShipmentPlan operation.|[CreateInboundShipmentPlanRequest](#createinboundshipmentplanrequest)|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Success.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[CreateInboundShipmentPlanResponse](#createinboundshipmentplanresponse)|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[CreateInboundShipmentPlanResponse](#createinboundshipmentplanresponse)|
|**401**|The request's Authorization header is not formatted correctly or does not contain a valid token.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[CreateInboundShipmentPlanResponse](#createinboundshipmentplanresponse)|
|**403**|Indicates that access to the resource is forbidden. Possible reasons include Access Denied, Unauthorized, Expired Token, or Invalid Signature.  <br>**Headers** :   <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[CreateInboundShipmentPlanResponse](#createinboundshipmentplanresponse)|
|**404**|The specified resource does not exist.  <br>**Headers** :   <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[CreateInboundShipmentPlanResponse](#createinboundshipmentplanresponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[CreateInboundShipmentPlanResponse](#createinboundshipmentplanresponse)|
|**500**|An unexpected condition occurred that prevented the server from fulfilling the request.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[CreateInboundShipmentPlanResponse](#createinboundshipmentplanresponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[CreateInboundShipmentPlanResponse](#createinboundshipmentplanresponse)|


<a name="updateinboundshipment"></a>
### PUT /fba/inbound/v0/shipments/{shipmentId}
**Operation: updateInboundShipment**

#### Description
Adds, updates, or removes items from the inbound shipment identified by the specified shipment identifier. 

**Usage Plan:**

| Rate (requests per second) | Burst |
| ---- | ---- |
| 2 | 30 |

For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Body**|**body**  <br>*required*|The request schema for an inbound shipment.|[InboundShipmentRequest](#inboundshipmentrequest)|
|**Path**|**shipmentId**  <br>*required*|A shipment identifier originally returned by the createInboundShipmentPlan operation.|string|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Success.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[InboundShipmentResponse](#inboundshipmentresponse)|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[InboundShipmentResponse](#inboundshipmentresponse)|
|**401**|The request's Authorization header is not formatted correctly or does not contain a valid token.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[InboundShipmentResponse](#inboundshipmentresponse)|
|**403**|Indicates that access to the resource is forbidden. Possible reasons include Access Denied, Unauthorized, Expired Token, or Invalid Signature.  <br>**Headers** :   <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[InboundShipmentResponse](#inboundshipmentresponse)|
|**404**|The specified resource does not exist.  <br>**Headers** :   <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[InboundShipmentResponse](#inboundshipmentresponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[InboundShipmentResponse](#inboundshipmentresponse)|
|**500**|An unexpected condition occurred that prevented the server from fulfilling the request.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[InboundShipmentResponse](#inboundshipmentresponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[InboundShipmentResponse](#inboundshipmentresponse)|


<a name="createinboundshipment"></a>
### POST /fba/inbound/v0/shipments/{shipmentId}
**Operation: createInboundShipment**

#### Description
Returns a new inbound shipment based on the specified shipmentId that was returned by the createInboundShipmentPlan operation.

**Usage Plan:**

| Rate (requests per second) | Burst |
| ---- | ---- |
| 2 | 30 |

For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Body**|**body**  <br>*required*|The request schema for an inbound shipment.|[InboundShipmentRequest](#inboundshipmentrequest)|
|**Path**|**shipmentId**  <br>*required*|A shipment identifier originally returned by the createInboundShipmentPlan operation.|string|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Success.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[InboundShipmentResponse](#inboundshipmentresponse)|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[InboundShipmentResponse](#inboundshipmentresponse)|
|**401**|The request's Authorization header is not formatted correctly or does not contain a valid token.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[InboundShipmentResponse](#inboundshipmentresponse)|
|**403**|Indicates that access to the resource is forbidden. Possible reasons include Access Denied, Unauthorized, Expired Token, or Invalid Signature.  <br>**Headers** :   <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[InboundShipmentResponse](#inboundshipmentresponse)|
|**404**|The specified resource does not exist.  <br>**Headers** :   <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[InboundShipmentResponse](#inboundshipmentresponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[InboundShipmentResponse](#inboundshipmentresponse)|
|**500**|An unexpected condition occurred that prevented the server from fulfilling the request.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[InboundShipmentResponse](#inboundshipmentresponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[InboundShipmentResponse](#inboundshipmentresponse)|


<a name="getpreorderinfo"></a>
### GET /fba/inbound/v0/shipments/{shipmentId}/preorder
**Operation: getPreorderInfo**

#### Description
Returns pre-order information, including dates, that a seller needs before confirming a shipment for pre-order. 

**Usage Plan:**

| Rate (requests per second) | Burst |
| ---- | ---- |
| 2 | 30 |

For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**shipmentId**  <br>*required*|A shipment identifier originally returned by the createInboundShipmentPlan operation.|string|
|**Query**|**MarketplaceId**  <br>*required*|A marketplace identifier. Specifies the marketplace the shipment is tied to.|string|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Success.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[GetPreorderInfoResponse](#getpreorderinforesponse)|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[GetPreorderInfoResponse](#getpreorderinforesponse)|
|**401**|The request's Authorization header is not formatted correctly or does not contain a valid token.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[GetPreorderInfoResponse](#getpreorderinforesponse)|
|**403**|Indicates that access to the resource is forbidden. Possible reasons include Access Denied, Unauthorized, Expired Token, or Invalid Signature.  <br>**Headers** :   <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[GetPreorderInfoResponse](#getpreorderinforesponse)|
|**404**|The specified resource does not exist.  <br>**Headers** :   <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[GetPreorderInfoResponse](#getpreorderinforesponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[GetPreorderInfoResponse](#getpreorderinforesponse)|
|**500**|An unexpected condition occurred that prevented the server from fulfilling the request.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[GetPreorderInfoResponse](#getpreorderinforesponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[GetPreorderInfoResponse](#getpreorderinforesponse)|


<a name="confirmpreorder"></a>
### PUT /fba/inbound/v0/shipments/{shipmentId}/preorder/confirm
**Operation: confirmPreorder**

#### Description
Returns information needed to confirm a shipment for pre-order. Call this operation after calling the getPreorderInfo operation to get the NeedByDate value and other pre-order information about the shipment.

**Usage Plan:**

| Rate (requests per second) | Burst |
| ---- | ---- |
| 2 | 30 |

For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**shipmentId**  <br>*required*|A shipment identifier originally returned by the createInboundShipmentPlan operation.|string|
|**Query**|**NeedByDate**  <br>*required*|Date that the shipment must arrive at the Amazon fulfillment center to avoid delivery promise breaks for pre-ordered items. Must be in YYYY-MM-DD format. The response to the getPreorderInfo operation returns this value.|string (date)|
|**Query**|**MarketplaceId**  <br>*required*|A marketplace identifier. Specifies the marketplace the shipment is tied to.|string|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Success.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[ConfirmPreorderResponse](#confirmpreorderresponse)|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[ConfirmPreorderResponse](#confirmpreorderresponse)|
|**401**|The request's Authorization header is not formatted correctly or does not contain a valid token.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[ConfirmPreorderResponse](#confirmpreorderresponse)|
|**403**|Indicates that access to the resource is forbidden. Possible reasons include Access Denied, Unauthorized, Expired Token, or Invalid Signature.  <br>**Headers** :   <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[ConfirmPreorderResponse](#confirmpreorderresponse)|
|**404**|The specified resource does not exist.  <br>**Headers** :   <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[ConfirmPreorderResponse](#confirmpreorderresponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[ConfirmPreorderResponse](#confirmpreorderresponse)|
|**500**|An unexpected condition occurred that prevented the server from fulfilling the request.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[ConfirmPreorderResponse](#confirmpreorderresponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[ConfirmPreorderResponse](#confirmpreorderresponse)|


<a name="getprepinstructions"></a>
### GET /fba/inbound/v0/prepInstructions
**Operation: getPrepInstructions**

#### Description
Returns labeling requirements and item preparation instructions to help prepare items for shipment to Amazon's fulfillment network.

**Usage Plan:**

| Rate (requests per second) | Burst |
| ---- | ---- |
| 2 | 30 |

For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Query**|**ShipToCountryCode**  <br>*required*|The country code of the country to which the items will be shipped. Note that labeling requirements and item preparation instructions can vary by country.|string ([A-Z]{2})|
|**Query**|**SellerSKUList**  <br>*optional*|A list of SellerSKU values. Used to identify items for which you want labeling requirements and item preparation instructions for shipment to Amazon's fulfillment network. The SellerSKU is qualified by the Seller ID, which is included with every call to the Seller Partner API.<br><br>Note: Include seller SKUs that you have used to list items on Amazon's retail website. If you include a seller SKU that you have never used to list an item on Amazon's retail website, the seller SKU is returned in the InvalidSKUList property in the response.<br>**Max count** : 50|< string > array|
|**Query**|**ASINList**  <br>*optional*|A list of ASIN values. Used to identify items for which you want item preparation instructions to help with item sourcing decisions.<br><br>Note: ASINs must be included in the product catalog for at least one of the marketplaces that the seller  participates in. Any ASIN that is not included in the product catalog for at least one of the marketplaces that the seller participates in is returned in the InvalidASINList property in the response. You can find out which marketplaces a seller participates in by calling the getMarketplaceParticipations operation in the Selling Partner API for Sellers.<br>**Max count** : 50|< string > array|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Success.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[GetPrepInstructionsResponse](#getprepinstructionsresponse)|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[GetPrepInstructionsResponse](#getprepinstructionsresponse)|
|**401**|The request's Authorization header is not formatted correctly or does not contain a valid token.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[GetPrepInstructionsResponse](#getprepinstructionsresponse)|
|**403**|Indicates that access to the resource is forbidden. Possible reasons include Access Denied, Unauthorized, Expired Token, or Invalid Signature.  <br>**Headers** :   <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[GetPrepInstructionsResponse](#getprepinstructionsresponse)|
|**404**|The specified resource does not exist.  <br>**Headers** :   <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[GetPrepInstructionsResponse](#getprepinstructionsresponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[GetPrepInstructionsResponse](#getprepinstructionsresponse)|
|**500**|An unexpected condition occurred that prevented the server from fulfilling the request.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[GetPrepInstructionsResponse](#getprepinstructionsresponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[GetPrepInstructionsResponse](#getprepinstructionsresponse)|


<a name="gettransportdetails"></a>
### GET /fba/inbound/v0/shipments/{shipmentId}/transport
**Operation: getTransportDetails**

#### Description
Returns current transportation information about an inbound shipment.

**Usage Plan:**

| Rate (requests per second) | Burst |
| ---- | ---- |
| 2 | 30 |

For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**shipmentId**  <br>*required*|A shipment identifier originally returned by the createInboundShipmentPlan operation.|string|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Success.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[GetTransportDetailsResponse](#gettransportdetailsresponse)|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[GetTransportDetailsResponse](#gettransportdetailsresponse)|
|**401**|The request's Authorization header is not formatted correctly or does not contain a valid token.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[GetTransportDetailsResponse](#gettransportdetailsresponse)|
|**403**|Indicates that access to the resource is forbidden. Possible reasons include Access Denied, Unauthorized, Expired Token, or Invalid Signature.  <br>**Headers** :   <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[GetTransportDetailsResponse](#gettransportdetailsresponse)|
|**404**|The specified resource does not exist.  <br>**Headers** :   <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[GetTransportDetailsResponse](#gettransportdetailsresponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[GetTransportDetailsResponse](#gettransportdetailsresponse)|
|**500**|An unexpected condition occurred that prevented the server from fulfilling the request.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[GetTransportDetailsResponse](#gettransportdetailsresponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[GetTransportDetailsResponse](#gettransportdetailsresponse)|


<a name="puttransportdetails"></a>
### PUT /fba/inbound/v0/shipments/{shipmentId}/transport
**Operation: putTransportDetails**

#### Description
Sends transportation information to Amazon about an inbound shipment.

**Usage Plan:**

| Rate (requests per second) | Burst |
| ---- | ---- |
| 2 | 30 |

For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**shipmentId**  <br>*required*|A shipment identifier originally returned by the createInboundShipmentPlan operation.|string|
|**Body**|**body**  <br>*required*|The request schema for a putTransportDetails operation.|[PutTransportDetailsRequest](#puttransportdetailsrequest)|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Success.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[PutTransportDetailsResponse](#puttransportdetailsresponse)|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[PutTransportDetailsResponse](#puttransportdetailsresponse)|
|**401**|The request's Authorization header is not formatted correctly or does not contain a valid token.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[PutTransportDetailsResponse](#puttransportdetailsresponse)|
|**403**|Indicates that access to the resource is forbidden. Possible reasons include Access Denied, Unauthorized, Expired Token, or Invalid Signature.  <br>**Headers** :   <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[PutTransportDetailsResponse](#puttransportdetailsresponse)|
|**404**|The specified resource does not exist.  <br>**Headers** :   <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[PutTransportDetailsResponse](#puttransportdetailsresponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[PutTransportDetailsResponse](#puttransportdetailsresponse)|
|**500**|An unexpected condition occurred that prevented the server from fulfilling the request.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[PutTransportDetailsResponse](#puttransportdetailsresponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[PutTransportDetailsResponse](#puttransportdetailsresponse)|


<a name="voidtransport"></a>
### POST /fba/inbound/v0/shipments/{shipmentId}/transport/void
**Operation: voidTransport**

#### Description
Cancels a previously-confirmed request to ship an inbound shipment using an Amazon-partnered carrier.

To be successful, you must call this operation before the VoidDeadline date that is returned by the getTransportDetails operation.

Important: The VoidDeadline date is 24 hours after you confirm a Small Parcel shipment transportation request or one hour after you confirm a Less Than Truckload/Full Truckload (LTL/FTL) shipment transportation request. After the void deadline passes, your account will be charged for the shipping cost.

**Usage Plan:**

| Rate (requests per second) | Burst |
| ---- | ---- |
| 2 | 30 |

For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**shipmentId**  <br>*required*|A shipment identifier originally returned by the createInboundShipmentPlan operation.|string|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Success.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[VoidTransportResponse](#voidtransportresponse)|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[VoidTransportResponse](#voidtransportresponse)|
|**401**|The request's Authorization header is not formatted correctly or does not contain a valid token.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[VoidTransportResponse](#voidtransportresponse)|
|**403**|Indicates that access to the resource is forbidden. Possible reasons include Access Denied, Unauthorized, Expired Token, or Invalid Signature.  <br>**Headers** :   <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[VoidTransportResponse](#voidtransportresponse)|
|**404**|The specified resource does not exist.  <br>**Headers** :   <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[VoidTransportResponse](#voidtransportresponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[VoidTransportResponse](#voidtransportresponse)|
|**500**|An unexpected condition occurred that prevented the server from fulfilling the request.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[VoidTransportResponse](#voidtransportresponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[VoidTransportResponse](#voidtransportresponse)|


<a name="estimatetransport"></a>
### POST /fba/inbound/v0/shipments/{shipmentId}/transport/estimate
**Operation: estimateTransport**

#### Description
Initiates the process of estimating the shipping cost for an inbound shipment by an Amazon-partnered carrier.

Prior to calling the estimateTransport operation, you must call the putTransportDetails operation to provide Amazon with the transportation information for the inbound shipment.

**Usage Plan:**

| Rate (requests per second) | Burst |
| ---- | ---- |
| 2 | 30 |

For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**shipmentId**  <br>*required*|A shipment identifier originally returned by the createInboundShipmentPlan operation.|string|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Success.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[EstimateTransportResponse](#estimatetransportresponse)|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[EstimateTransportResponse](#estimatetransportresponse)|
|**401**|The request's Authorization header is not formatted correctly or does not contain a valid token.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[EstimateTransportResponse](#estimatetransportresponse)|
|**403**|Indicates that access to the resource is forbidden. Possible reasons include Access Denied, Unauthorized, Expired Token, or Invalid Signature.  <br>**Headers** :   <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[EstimateTransportResponse](#estimatetransportresponse)|
|**404**|The specified resource does not exist.  <br>**Headers** :   <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[EstimateTransportResponse](#estimatetransportresponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[EstimateTransportResponse](#estimatetransportresponse)|
|**500**|An unexpected condition occurred that prevented the server from fulfilling the request.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[EstimateTransportResponse](#estimatetransportresponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[EstimateTransportResponse](#estimatetransportresponse)|


<a name="confirmtransport"></a>
### POST /fba/inbound/v0/shipments/{shipmentId}/transport/confirm
**Operation: confirmTransport**

#### Description
Confirms that the seller accepts the Amazon-partnered shipping estimate, agrees to allow Amazon to charge their account for the shipping cost, and requests that the Amazon-partnered carrier ship the inbound shipment.

Prior to calling the confirmTransport operation, you should call the getTransportDetails operation to get the Amazon-partnered shipping estimate.

Important: After confirming the transportation request, if the seller decides that they do not want the Amazon-partnered carrier to ship the inbound shipment, you can call the voidTransport operation to cancel the transportation request. Note that for a Small Parcel shipment, the seller has 24 hours after confirming a transportation request to void the transportation request. For a Less Than Truckload/Full Truckload (LTL/FTL) shipment, the seller has one hour after confirming a transportation request to void it. After the grace period has expired the seller's account will be charged for the shipping cost.

**Usage Plan:**

| Rate (requests per second) | Burst |
| ---- | ---- |
| 2 | 30 |

For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**shipmentId**  <br>*required*|A shipment identifier originally returned by the createInboundShipmentPlan operation.|string|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Success.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[ConfirmTransportResponse](#confirmtransportresponse)|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[ConfirmTransportResponse](#confirmtransportresponse)|
|**401**|The request's Authorization header is not formatted correctly or does not contain a valid token.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[ConfirmTransportResponse](#confirmtransportresponse)|
|**403**|Indicates that access to the resource is forbidden. Possible reasons include Access Denied, Unauthorized, Expired Token, or Invalid Signature.  <br>**Headers** :   <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[ConfirmTransportResponse](#confirmtransportresponse)|
|**404**|The specified resource does not exist.  <br>**Headers** :   <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[ConfirmTransportResponse](#confirmtransportresponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[ConfirmTransportResponse](#confirmtransportresponse)|
|**500**|An unexpected condition occurred that prevented the server from fulfilling the request.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[ConfirmTransportResponse](#confirmtransportresponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[ConfirmTransportResponse](#confirmtransportresponse)|


<a name="getlabels"></a>
### GET /fba/inbound/v0/shipments/{shipmentId}/labels
**Operation: getLabels**

#### Description
Returns package/pallet labels for faster and more accurate shipment processing at the Amazon fulfillment center.

**Usage Plan:**

| Rate (requests per second) | Burst |
| ---- | ---- |
| 2 | 30 |

For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**shipmentId**  <br>*required*|A shipment identifier originally returned by the createInboundShipmentPlan operation.|string|
|**Query**|**PageType**  <br>*required*|The page type to use to print the labels. Submitting a PageType value that is not supported in your marketplace returns an error.|enum ([PageType](#pagetype))|
|**Query**|**LabelType**  <br>*required*|The type of labels requested.|enum ([LabelType](#labeltype))|
|**Query**|**NumberOfPackages**  <br>*optional*|The number of packages in the shipment.|integer|
|**Query**|**PackageLabelsToPrint**  <br>*optional*|A list of identifiers that specify packages for which you want package labels printed.<br><br>Must match CartonId values previously passed using the FBA Inbound Shipment Carton Information Feed. If not, the operation returns the IncorrectPackageIdentifier error code.<br>**Max count** : 999|< string > array|
|**Query**|**NumberOfPallets**  <br>*optional*|The number of pallets in the shipment. This returns four identical labels for each pallet.|integer|
|**Query**|**PageSize**  <br>*optional*|The page size for paginating through the total packages' labels. This is a required parameter for Non-Partnered LTL Shipments. Max value:1000.|integer|
|**Query**|**PageStartIndex**  <br>*optional*|The page start index for paginating through the total packages' labels. This is a required parameter for Non-Partnered LTL Shipments.|integer|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Success.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[GetLabelsResponse](#getlabelsresponse)|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[GetLabelsResponse](#getlabelsresponse)|
|**401**|The request's Authorization header is not formatted correctly or does not contain a valid token.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[GetLabelsResponse](#getlabelsresponse)|
|**403**|Indicates that access to the resource is forbidden. Possible reasons include Access Denied, Unauthorized, Expired Token, or Invalid Signature.  <br>**Headers** :   <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[GetLabelsResponse](#getlabelsresponse)|
|**404**|The specified resource does not exist.  <br>**Headers** :   <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[GetLabelsResponse](#getlabelsresponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[GetLabelsResponse](#getlabelsresponse)|
|**500**|An unexpected condition occurred that prevented the server from fulfilling the request.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[GetLabelsResponse](#getlabelsresponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[GetLabelsResponse](#getlabelsresponse)|


<a name="getbilloflading"></a>
### GET /fba/inbound/v0/shipments/{shipmentId}/billOfLading
**Operation: getBillOfLading**

#### Description
Returns a bill of lading for a Less Than Truckload/Full Truckload (LTL/FTL) shipment. The getBillOfLading operation returns PDF document data for printing a bill of lading for an Amazon-partnered Less Than Truckload/Full Truckload (LTL/FTL) inbound shipment.

**Usage Plan:**

| Rate (requests per second) | Burst |
| ---- | ---- |
| 2 | 30 |

For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**shipmentId**  <br>*required*|A shipment identifier originally returned by the createInboundShipmentPlan operation.|string|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Success.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[GetBillOfLadingResponse](#getbillofladingresponse)|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[GetBillOfLadingResponse](#getbillofladingresponse)|
|**401**|The request's Authorization header is not formatted correctly or does not contain a valid token.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[GetBillOfLadingResponse](#getbillofladingresponse)|
|**403**|Indicates that access to the resource is forbidden. Possible reasons include Access Denied, Unauthorized, Expired Token, or Invalid Signature.  <br>**Headers** :   <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[GetBillOfLadingResponse](#getbillofladingresponse)|
|**404**|The specified resource does not exist.  <br>**Headers** :   <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[GetBillOfLadingResponse](#getbillofladingresponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[GetBillOfLadingResponse](#getbillofladingresponse)|
|**500**|An unexpected condition occurred that prevented the server from fulfilling the request.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[GetBillOfLadingResponse](#getbillofladingresponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[GetBillOfLadingResponse](#getbillofladingresponse)|


<a name="getshipments"></a>
### GET /fba/inbound/v0/shipments
**Operation: getShipments**

#### Description
Returns a list of inbound shipments based on criteria that you specify.

**Usage Plan:**

| Rate (requests per second) | Burst |
| ---- | ---- |
| 2 | 30 |

For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Query**|**ShipmentStatusList**  <br>*optional*|A list of ShipmentStatus values. Used to select shipments with a current status that matches the status values that you specify.|< enum ([ShipmentStatusList](#shipmentstatuslist)) > array|
|**Query**|**ShipmentIdList**  <br>*optional*|A list of shipment IDs used to select the shipments that you want. If both ShipmentStatusList and ShipmentIdList are specified, only shipments that match both parameters are returned.|< string > array|
|**Query**|**LastUpdatedAfter**  <br>*optional*|A date used for selecting inbound shipments that were last updated after (or at) a specified time. The selection includes updates made by Amazon and by the seller.|string (date-time)|
|**Query**|**LastUpdatedBefore**  <br>*optional*|A date used for selecting inbound shipments that were last updated before (or at) a specified time. The selection includes updates made by Amazon and by the seller.|string (date-time)|
|**Query**|**QueryType**  <br>*required*|Indicates whether shipments are returned using shipment information (by providing the ShipmentStatusList or ShipmentIdList parameters), using a date range (by providing the LastUpdatedAfter and LastUpdatedBefore parameters), or by using NextToken to continue returning items specified in a previous request.|enum ([QueryType](#querytype-subgroup-1))|
|**Query**|**NextToken**  <br>*optional*|A string token returned in the response to your previous request.|string|
|**Query**|**MarketplaceId**  <br>*required*|A marketplace identifier. Specifies the marketplace where the product would be stored.|string|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Success.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[GetShipmentsResponse](#getshipmentsresponse)|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[GetShipmentsResponse](#getshipmentsresponse)|
|**401**|The request's Authorization header is not formatted correctly or does not contain a valid token.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[GetShipmentsResponse](#getshipmentsresponse)|
|**403**|Indicates that access to the resource is forbidden. Possible reasons include Access Denied, Unauthorized, Expired Token, or Invalid Signature.  <br>**Headers** :   <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[GetShipmentsResponse](#getshipmentsresponse)|
|**404**|The specified resource does not exist.  <br>**Headers** :   <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[GetShipmentsResponse](#getshipmentsresponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[GetShipmentsResponse](#getshipmentsresponse)|
|**500**|An unexpected condition occurred that prevented the server from fulfilling the request.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[GetShipmentsResponse](#getshipmentsresponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[GetShipmentsResponse](#getshipmentsresponse)|


<a name="getshipmentitemsbyshipmentid"></a>
### GET /fba/inbound/v0/shipments/{shipmentId}/items
**Operation: getShipmentItemsByShipmentId**

#### Description
Returns a list of items in a specified inbound shipment.

**Usage Plan:**

| Rate (requests per second) | Burst |
| ---- | ---- |
| 2 | 30 |

For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**shipmentId**  <br>*required*|A shipment identifier used for selecting items in a specific inbound shipment.|string|
|**Query**|**MarketplaceId**  <br>*required*|A marketplace identifier. Specifies the marketplace where the product would be stored.|string|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Success.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[GetShipmentItemsResponse](#getshipmentitemsresponse)|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[GetShipmentItemsResponse](#getshipmentitemsresponse)|
|**401**|The request's Authorization header is not formatted correctly or does not contain a valid token.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[GetShipmentItemsResponse](#getshipmentitemsresponse)|
|**403**|Indicates that access to the resource is forbidden. Possible reasons include Access Denied, Unauthorized, Expired Token, or Invalid Signature.  <br>**Headers** :   <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[GetShipmentItemsResponse](#getshipmentitemsresponse)|
|**404**|The specified resource does not exist.  <br>**Headers** :   <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[GetShipmentItemsResponse](#getshipmentitemsresponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[GetShipmentItemsResponse](#getshipmentitemsresponse)|
|**500**|An unexpected condition occurred that prevented the server from fulfilling the request.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[GetShipmentItemsResponse](#getshipmentitemsresponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[GetShipmentItemsResponse](#getshipmentitemsresponse)|


<a name="getshipmentitems"></a>
### GET /fba/inbound/v0/shipmentItems
**Operation: getShipmentItems**

#### Description
Returns a list of items in a specified inbound shipment, or a list of items that were updated within a specified time frame.

**Usage Plan:**

| Rate (requests per second) | Burst |
| ---- | ---- |
| 2 | 30 |

For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Query**|**LastUpdatedAfter**  <br>*optional*|A date used for selecting inbound shipment items that were last updated after (or at) a specified time. The selection includes updates made by Amazon and by the seller.|string (date-time)|
|**Query**|**LastUpdatedBefore**  <br>*optional*|A date used for selecting inbound shipment items that were last updated before (or at) a specified time. The selection includes updates made by Amazon and by the seller.|string (date-time)|
|**Query**|**QueryType**  <br>*required*|Indicates whether items are returned using a date range (by providing the LastUpdatedAfter and LastUpdatedBefore parameters), or using NextToken, which continues returning items specified in a previous request.|enum ([QueryType](#querytype-subgroup-2))|
|**Query**|**NextToken**  <br>*optional*|A string token returned in the response to your previous request.|string|
|**Query**|**MarketplaceId**  <br>*required*|A marketplace identifier. Specifies the marketplace where the product would be stored.|string|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Success.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[GetShipmentItemsResponse](#getshipmentitemsresponse)|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[GetShipmentItemsResponse](#getshipmentitemsresponse)|
|**401**|The request's Authorization header is not formatted correctly or does not contain a valid token.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[GetShipmentItemsResponse](#getshipmentitemsresponse)|
|**403**|Indicates that access to the resource is forbidden. Possible reasons include Access Denied, Unauthorized, Expired Token, or Invalid Signature.  <br>**Headers** :   <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[GetShipmentItemsResponse](#getshipmentitemsresponse)|
|**404**|The specified resource does not exist.  <br>**Headers** :   <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[GetShipmentItemsResponse](#getshipmentitemsresponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[GetShipmentItemsResponse](#getshipmentitemsresponse)|
|**500**|An unexpected condition occurred that prevented the server from fulfilling the request.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[GetShipmentItemsResponse](#getshipmentitemsresponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[GetShipmentItemsResponse](#getshipmentitemsresponse)|


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


<a name="asininboundguidance"></a>
### ASINInboundGuidance
Reasons why a given ASIN is not recommended for shipment to Amazon's fulfillment network.


|Name|Description|Schema|
|---|---|---|
|**ASIN**  <br>*required*|The Amazon Standard Identification Number (ASIN) of the item.|string|
|**InboundGuidance**  <br>*required*|Specific inbound guidance for an item.|[InboundGuidance](#inboundguidance)|
|**GuidanceReasonList**  <br>*optional*|A list of reasons for the current inbound guidance for this item.|[GuidanceReasonList](#guidancereasonlist)|


<a name="asininboundguidancelist"></a>
### ASINInboundGuidanceList
A list of ASINs and their associated inbound guidance.

*Type* : < [ASINInboundGuidance](#asininboundguidance) > array


<a name="asinprepinstructions"></a>
### ASINPrepInstructions
Item preparation instructions to help with item sourcing decisions.


|Name|Description|Schema|
|---|---|---|
|**ASIN**  <br>*optional*|The Amazon Standard Identification Number (ASIN) of the item.|string|
|**BarcodeInstruction**  <br>*optional*|Labeling requirements for the item. For more information about FBA labeling requirements, see the Seller Central Help for your marketplace.|[BarcodeInstruction](#barcodeinstruction)|
|**PrepGuidance**  <br>*optional*|Item preparation instructions.|[PrepGuidance](#prepguidance)|
|**PrepInstructionList**  <br>*optional*|A list of preparation instructions to help with item sourcing decisions.|[PrepInstructionList](#prepinstructionlist)|


<a name="asinprepinstructionslist"></a>
### ASINPrepInstructionsList
A list of item preparation instructions.

*Type* : < [ASINPrepInstructions](#asinprepinstructions) > array


<a name="address"></a>
### Address

|Name|Description|Schema|
|---|---|---|
|**Name**  <br>*required*|Name of the individual or business.<br>**maxLength** : 50|string|
|**AddressLine1**  <br>*required*|The street address information.<br>**maxLength** : 180|string|
|**AddressLine2**  <br>*optional*|Additional street address information, if required.<br>**maxLength** : 60|string|
|**DistrictOrCounty**  <br>*optional*|The district or county.<br>**maxLength** : 25|string|
|**City**  <br>*required*|The city.<br>**maxLength** : 30|string|
|**StateOrProvinceCode**  <br>*required*|The state or province code.<br><br>If state or province codes are used in your marketplace, it is recommended that you include one with your request. This helps Amazon to select the most appropriate Amazon fulfillment center for your inbound shipment plan.|string|
|**CountryCode**  <br>*required*|The country code in two-character ISO 3166-1 alpha-2 format.|string|
|**PostalCode**  <br>*required*|The postal code.<br><br>If postal codes are used in your marketplace, we recommended that you include one with your request. This helps Amazon select the most appropriate Amazon fulfillment center for the inbound shipment plan.<br>**maxLength** : 30|string|


<a name="amazonprepfeesdetails"></a>
### AmazonPrepFeesDetails
The fees for Amazon to prep goods for shipment.


|Name|Description|Schema|
|---|---|---|
|**PrepInstruction**  <br>*optional*|Preparation instructions for shipping an item to Amazon's fulfillment network. For more information about preparing items for shipment to Amazon's fulfillment network, see the Seller Central Help for your marketplace.|[PrepInstruction](#prepinstruction)|
|**FeePerUnit**  <br>*optional*|The fee for Amazon to prepare 1 unit.|[Amount](#amount)|


<a name="amazonprepfeesdetailslist"></a>
### AmazonPrepFeesDetailsList
A list of preparation instructions and fees for Amazon to prep goods for shipment.

*Type* : < [AmazonPrepFeesDetails](#amazonprepfeesdetails) > array


<a name="amount"></a>
### Amount
The monetary value.


|Name|Description|Schema|
|---|---|---|
|**CurrencyCode**  <br>*required*|The currency code.|[CurrencyCode](#currencycode)|
|**Value**  <br>*required*|The amount.|[BigDecimalType](#bigdecimaltype)|


<a name="barcodeinstruction"></a>
### BarcodeInstruction
Labeling requirements for the item. For more information about FBA labeling requirements, see the Seller Central Help for your marketplace.

*Type* : enum


|Value|Description|
|---|---|
|**RequiresFNSKULabel**|Indicates that a scannable FBA product label must be applied to the item. Cover any original bar codes on the item.|
|**CanUseOriginalBarcode**|Indicates that the item does not require a scannable FBA product label. The original manufacturer's bar code can be used.|
|**MustProvideSellerSKU**|Amazon is unable to return labeling requirements. To get labeling requirements for items, call the getPrepInstructions operation.|


<a name="bigdecimaltype"></a>
### BigDecimalType
*Type* : number (double)


<a name="boxcontentsfeedetails"></a>
### BoxContentsFeeDetails
The manual processing fee per unit and total fee for a shipment.


|Name|Description|Schema|
|---|---|---|
|**TotalUnits**  <br>*optional*|The number of units to ship.|[Quantity](#quantity)|
|**FeePerUnit**  <br>*optional*|The manual processing fee per unit.|[Amount](#amount)|
|**TotalFee**  <br>*optional*|The total manual processing fee for the shipment.|[Amount](#amount)|


<a name="boxcontentssource"></a>
### BoxContentsSource
Where the seller provided box contents information for a shipment.

*Type* : enum


|Value|Description|
|---|---|
|**NONE**|There is no box contents information for this shipment. Amazon will manually process the box contents information. This may incur a fee.|
|**FEED**|Box contents information is provided through the _POST_FBA_INBOUND_CARTON_CONTENTS_ feed.|
|**2D_BARCODE**|Box contents information is provided by a barcode on the shipment. For more information, see Using 2D barcodes for box content information on Seller Central.|
|**INTERACTIVE**|Box contents information is provided by an interactive source, such as a web tool.|


<a name="condition"></a>
### Condition
The condition of the item.

*Type* : enum


|Value|Description|
|---|---|
|**NewItem**|NewItem|
|**NewWithWarranty**|NewWithWarranty|
|**NewOEM**|NewOEM|
|**NewOpenBox**|NewOpenBox|
|**UsedLikeNew**|UsedLikeNew|
|**UsedVeryGood**|UsedVeryGood|
|**UsedGood**|UsedGood|
|**UsedAcceptable**|UsedAcceptable|
|**UsedPoor**|UsedPoor|
|**UsedRefurbished**|UsedRefurbished|
|**CollectibleLikeNew**|CollectibleLikeNew|
|**CollectibleVeryGood**|CollectibleVeryGood|
|**CollectibleGood**|CollectibleGood|
|**CollectibleAcceptable**|CollectibleAcceptable|
|**CollectiblePoor**|CollectiblePoor|
|**RefurbishedWithWarranty**|RefurbishedWithWarranty|
|**Refurbished**|Refurbished|
|**Club**|Club|


<a name="confirmpreorderresult"></a>
### ConfirmPreorderResult

|Name|Description|Schema|
|---|---|---|
|**ConfirmedNeedByDate**  <br>*optional*|Date passed in with the NeedByDate parameter. The confirmed shipment must arrive at the Amazon fulfillment center by this date to avoid delivery promise breaks for pre-ordered items. In YYYY-MM-DD format.|[DateStringType](#datestringtype)|
|**ConfirmedFulfillableDate**  <br>*optional*|Date that determines which pre-order items in the shipment are eligible for pre-order. The pre-order Buy Box will appear for any pre-order item in the shipment with a release date on or after this date. In YYYY-MM-DD format.|[DateStringType](#datestringtype)|


<a name="confirmpreorderresponse"></a>
### ConfirmPreorderResponse
The response schema for the confirmPreorder operation.


|Name|Description|Schema|
|---|---|---|
|**payload**  <br>*optional*|The payload for the confirmPreorder operation.|[ConfirmPreorderResult](#confirmpreorderresult)|
|**errors**  <br>*optional*|A list of error responses returned when a request is unsuccessful.|[ErrorList](#errorlist)|


<a name="commontransportresult"></a>
### CommonTransportResult

|Name|Description|Schema|
|---|---|---|
|**TransportResult**  <br>*optional*|The workflow status for a shipment with an Amazon-partnered carrier.|[TransportResult](#transportresult)|


<a name="confirmtransportresponse"></a>
### ConfirmTransportResponse
The response schema for the confirmTransport operation.


|Name|Description|Schema|
|---|---|---|
|**payload**  <br>*optional*|The payload for the confirmTransport operation.|[CommonTransportResult](#commontransportresult)|
|**errors**  <br>*optional*|A list of error responses returned when a request is unsuccessful.|[ErrorList](#errorlist)|


<a name="contact"></a>
### Contact
Contact information for the person in the seller's organization who is responsible for a Less Than Truckload/Full Truckload (LTL/FTL) shipment.


|Name|Description|Schema|
|---|---|---|
|**Name**  <br>*required*|The name of the contact person.<br>**maxLength** : 50|string|
|**Phone**  <br>*required*|The phone number of the contact person.<br>**maxLength** : 20|string|
|**Email**  <br>*required*|The email address of the contact person.<br>**maxLength** : 50|string|
|**Fax**  <br>*optional*|The fax number of the contact person.<br>**maxLength** : 20|string|


<a name="createinboundshipmentplanrequest"></a>
### CreateInboundShipmentPlanRequest
The request schema for the createInboundShipmentPlan operation.


|Name|Description|Schema|
|---|---|---|
|**ShipFromAddress**  <br>*required*|The address from which the inbound shipment will be sent.|[Address](#address)|
|**LabelPrepPreference**  <br>*required*|The seller's preference for label preparation for an inbound shipment.|[LabelPrepPreference](#labelpreppreference)|
|**ShipToCountryCode**  <br>*optional*|The two-character country code for the country where the inbound shipment is to be sent.<br><br>Note: Not required. Specifying both ShipToCountryCode and ShipToCountrySubdivisionCode returns an error.<br><br> Values:<br><br> ShipToCountryCode values for North America:<br> <li> CA – Canada</li><br><li> MX - Mexico</li><br><li> US - United States</li><br><br>ShipToCountryCode values for MCI sellers in Europe:<br> <li> DE – Germany</li><br><li> ES – Spain</li><br><li> FR – France</li><br><li> GB – United Kingdom</li><br><li> IT – Italy</li><br><br>Default: The country code for the seller's home marketplace.|string|
|**ShipToCountrySubdivisionCode**  <br>*optional*|The two-character country code, followed by a dash and then up to three characters that represent the subdivision of the country where the inbound shipment is to be sent. For example, "IN-MH". In full ISO 3166-2 format.<br><br>Note: Not required. Specifying both ShipToCountryCode and ShipToCountrySubdivisionCode returns an error.|string|
|**InboundShipmentPlanRequestItems**  <br>*required*|-|[InboundShipmentPlanRequestItemList](#inboundshipmentplanrequestitemlist)|


<a name="createinboundshipmentplanresult"></a>
### CreateInboundShipmentPlanResult

|Name|Description|Schema|
|---|---|---|
|**InboundShipmentPlans**  <br>*optional*|A list of inbound shipment plan information|[InboundShipmentPlanList](#inboundshipmentplanlist)|


<a name="createinboundshipmentplanresponse"></a>
### CreateInboundShipmentPlanResponse
The response schema for the createInboundShipmentPlan operation.


|Name|Description|Schema|
|---|---|---|
|**payload**  <br>*optional*|The payload for the createInboundShipmentPlan operation.|[CreateInboundShipmentPlanResult](#createinboundshipmentplanresult)|
|**errors**  <br>*optional*|A list of error responses returned when a request is unsuccessful.|[ErrorList](#errorlist)|


<a name="inboundshipmentrequest"></a>
### InboundShipmentRequest
The request schema for an inbound shipment.


|Name|Description|Schema|
|---|---|---|
|**InboundShipmentHeader**  <br>*required*|Inbound shipment information used to create and update inbound shipments.|[InboundShipmentHeader](#inboundshipmentheader)|
|**InboundShipmentItems**  <br>*required*|A list of inbound shipment item information.|[InboundShipmentItemList](#inboundshipmentitemlist)|
|**MarketplaceId**  <br>*required*|A marketplace identifier. Specifies the marketplace where the product would be stored.|string|


<a name="inboundshipmentresult"></a>
### InboundShipmentResult

|Name|Description|Schema|
|---|---|---|
|**ShipmentId**  <br>*required*|The shipment identifier submitted in the request.|string|


<a name="inboundshipmentresponse"></a>
### InboundShipmentResponse
The response schema for this operation.


|Name|Description|Schema|
|---|---|---|
|**payload**  <br>*optional*|The payload for this operation.|[InboundShipmentResult](#inboundshipmentresult)|
|**errors**  <br>*optional*|A list of error responses returned when a request is unsuccessful.|[ErrorList](#errorlist)|


<a name="currencycode"></a>
### CurrencyCode
The currency code.

*Type* : enum


|Value|Description|
|---|---|
|**USD**|United States Dollar.|
|**GBP**|British pound sterling.|


<a name="datestringtype"></a>
### DateStringType
*Type* : string (date)


<a name="dimensions"></a>
### Dimensions
The dimension values and unit of measurement.


|Name|Description|Schema|
|---|---|---|
|**Length**  <br>*required*|The length dimension.|[BigDecimalType](#bigdecimaltype)|
|**Width**  <br>*required*|The width dimension.|[BigDecimalType](#bigdecimaltype)|
|**Height**  <br>*required*|The height dimension.|[BigDecimalType](#bigdecimaltype)|
|**Unit**  <br>*required*|The unit of measurement for the dimensions.|[UnitOfMeasurement](#unitofmeasurement)|


<a name="errorreason"></a>
### ErrorReason
The reason that the ASIN is invalid.

*Type* : enum


|Value|Description|
|---|---|
|**DoesNotExist**|Indicates that the ASIN is not included in the Amazon product catalog for any of the marketplaces that the seller participates in.|
|**InvalidASIN**|The ASIN is invalid.|


<a name="estimatetransportresponse"></a>
### EstimateTransportResponse
The response schema for the estimateTransport operation.


|Name|Description|Schema|
|---|---|---|
|**payload**  <br>*optional*|The payload for the estimateTransport operation.|[CommonTransportResult](#commontransportresult)|
|**errors**  <br>*optional*|A list of error responses returned when a request is unsuccessful.|[ErrorList](#errorlist)|


<a name="getbillofladingresponse"></a>
### GetBillOfLadingResponse
The response schema for the getBillOfLading operation.


|Name|Description|Schema|
|---|---|---|
|**payload**  <br>*optional*|The payload for the getBillOfLading operation.|[BillOfLadingDownloadURL](#billofladingdownloadurl)|
|**errors**  <br>*optional*|A list of error responses returned when a request is unsuccessful.|[ErrorList](#errorlist)|


<a name="getinboundguidanceresult"></a>
### GetInboundGuidanceResult

|Name|Description|Schema|
|---|---|---|
|**SKUInboundGuidanceList**  <br>*optional*|A list of SKU inbound guidance information.|[SKUInboundGuidanceList](#skuinboundguidancelist)|
|**InvalidSKUList**  <br>*optional*|A list of invalid SKU values and the reason they are invalid.|[InvalidSKUList](#invalidskulist)|
|**ASINInboundGuidanceList**  <br>*optional*|A list of ASINs and their associated inbound guidance.|[ASINInboundGuidanceList](#asininboundguidancelist)|
|**InvalidASINList**  <br>*optional*|A list of invalid ASIN values and the reasons they are invalid.|[InvalidASINList](#invalidasinlist)|


<a name="getinboundguidanceresponse"></a>
### GetInboundGuidanceResponse
The response schema for the getInboundGuidance operation.


|Name|Description|Schema|
|---|---|---|
|**payload**  <br>*optional*|The payload for the getInboundGuidance operation.|[GetInboundGuidanceResult](#getinboundguidanceresult)|
|**errors**  <br>*optional*|A list of error responses returned when a request is unsuccessful.|[ErrorList](#errorlist)|


<a name="labeldownloadurl"></a>
### LabelDownloadURL

|Name|Description|Schema|
|---|---|---|
|**DownloadURL**  <br>*optional*|URL to download the label for the package. Note: The URL will only be valid for 15 seconds|string|


<a name="billofladingdownloadurl"></a>
### BillOfLadingDownloadURL

|Name|Description|Schema|
|---|---|---|
|**DownloadURL**  <br>*optional*|URL to download the bill of lading for the package. Note: The URL will only be valid for 15 seconds|string|


<a name="getlabelsresponse"></a>
### GetLabelsResponse
The response schema for the getLabels operation.


|Name|Description|Schema|
|---|---|---|
|**payload**  <br>*optional*|The payload for the getLabels operation.|[LabelDownloadURL](#labeldownloadurl)|
|**errors**  <br>*optional*|A list of error responses returned when a request is unsuccessful.|[ErrorList](#errorlist)|


<a name="getpreorderinforesult"></a>
### GetPreorderInfoResult

|Name|Description|Schema|
|---|---|---|
|**ShipmentContainsPreorderableItems**  <br>*optional*|Indicates whether the shipment contains items that have been enabled for pre-order. For more information about enabling items for pre-order, see the Seller Central Help.|boolean|
|**ShipmentConfirmedForPreorder**  <br>*optional*|Indicates whether this shipment has been confirmed for pre-order.|boolean|
|**NeedByDate**  <br>*optional*|Date that the shipment would need to arrive at an Amazon fulfillment center to avoid delivery promise breaks for pre-ordered items if this shipment is later confirmed for pre-order. In YYYY-MM-DD format. See also the confirmPreorder operation.|[DateStringType](#datestringtype)|
|**ConfirmedFulfillableDate**  <br>*optional*|Date in YYYY-MM-DD format that determines which pre-order items in the shipment are eligible for pre-order. If this shipment is confirmed for pre-order with a subsequent call to the confirmPreorder operation, the pre-order Buy Box will appear for any pre-order items in the shipment with a release date on or after this date. Call the getShipmentItems operation to get the release dates for the pre-order items in this shipment.|[DateStringType](#datestringtype)|


<a name="getpreorderinforesponse"></a>
### GetPreorderInfoResponse
The response schema for the getPreorderInfo operation.


|Name|Description|Schema|
|---|---|---|
|**payload**  <br>*optional*|The payload for the getPreorderInfo operation.|[GetPreorderInfoResult](#getpreorderinforesult)|
|**errors**  <br>*optional*|One or more unexpected errors occurred during the operation.|[ErrorList](#errorlist)|


<a name="getprepinstructionsresult"></a>
### GetPrepInstructionsResult

|Name|Description|Schema|
|---|---|---|
|**SKUPrepInstructionsList**  <br>*optional*|A list of SKU labeling requirements and item preparation instructions.|[SKUPrepInstructionsList](#skuprepinstructionslist)|
|**InvalidSKUList**  <br>*optional*|A list of invalid SKU values and the reason they are invalid.|[InvalidSKUList](#invalidskulist)|
|**ASINPrepInstructionsList**  <br>*optional*|A list of item preparation instructions.|[ASINPrepInstructionsList](#asinprepinstructionslist)|
|**InvalidASINList**  <br>*optional*|A list of invalid ASIN values and the reasons they are invalid.|[InvalidASINList](#invalidasinlist)|


<a name="getprepinstructionsresponse"></a>
### GetPrepInstructionsResponse
The response schema for the getPrepInstructions operation.


|Name|Description|Schema|
|---|---|---|
|**payload**  <br>*optional*|The payload for the getPrepInstructions operation.|[GetPrepInstructionsResult](#getprepinstructionsresult)|
|**errors**  <br>*optional*|A list of error responses returned when a request is unsuccessful.|[ErrorList](#errorlist)|


<a name="gettransportdetailsresult"></a>
### GetTransportDetailsResult

|Name|Description|Schema|
|---|---|---|
|**TransportContent**  <br>*optional*|Inbound shipment information, including carrier details, shipment status, and the workflow status for a request for shipment with an Amazon-partnered carrier.|[TransportContent](#transportcontent)|


<a name="gettransportdetailsresponse"></a>
### GetTransportDetailsResponse
The response schema for the getTransportDetails operation.


|Name|Description|Schema|
|---|---|---|
|**payload**  <br>*optional*|The payload for the getTransportDetails operation.|[GetTransportDetailsResult](#gettransportdetailsresult)|
|**errors**  <br>*optional*|A list of error responses returned when a request is unsuccessful.|[ErrorList](#errorlist)|


<a name="guidancereason"></a>
### GuidanceReason
A reason for the current inbound guidance for an item.

*Type* : enum


|Value|Description|
|---|---|
|**SlowMovingASIN**|The ASIN is well stocked and/or not selling quickly.|
|**NoApplicableGuidance**|No applicable guidance.|


<a name="guidancereasonlist"></a>
### GuidanceReasonList
A list of inbound guidance reason information.

*Type* : < [GuidanceReason](#guidancereason) > array


<a name="inboundguidance"></a>
### InboundGuidance
Specific inbound guidance for an item.

*Type* : enum


|Value|Description|
|---|---|
|**InboundNotRecommended**|Shipping this item to Amazon's fulfillment network is not recommended.|
|**InboundOK**|Shipping this item to Amazon's fulfillment network should not cause any problems.|


<a name="inboundshipmentheader"></a>
### InboundShipmentHeader
Inbound shipment information used to create and update inbound shipments.


|Name|Description|Schema|
|---|---|---|
|**ShipmentName**  <br>*required*|The name for the shipment. Use a naming convention that helps distinguish between shipments over time, such as the date the shipment was created.|string|
|**ShipFromAddress**  <br>*required*|The return address.|[Address](#address)|
|**DestinationFulfillmentCenterId**  <br>*required*|The identifier for the fulfillment center to which the shipment will be shipped. Get this value from the InboundShipmentPlan object in the response returned by the createInboundShipmentPlan operation.|string|
|**AreCasesRequired**  <br>*optional*|Indicates whether or not an inbound shipment contains case-packed boxes. Note: A shipment must contain either all case-packed boxes or all individually packed boxes.<br><br>Possible values:<br><br>true - All boxes in the shipment must be case packed.<br><br>false - All boxes in the shipment must be individually packed.<br><br>Note: If AreCasesRequired = true for an inbound shipment, then the value of QuantityInCase must be greater than zero for every item in the shipment. Otherwise the service returns an error.|boolean|
|**ShipmentStatus**  <br>*required*|Indicates the status of the inbound shipment. When used with the createInboundShipment operation, WORKING is the only valid value. When used with the updateInboundShipment operation, possible values are WORKING, SHIPPED or CANCELLED.|[ShipmentStatus](#shipmentstatus)|
|**LabelPrepPreference**  <br>*required*|The preference for label preparation for an inbound shipment.|[LabelPrepPreference](#labelpreppreference)|
|**IntendedBoxContentsSource**  <br>*optional*|How the seller intends to provide box contents information for a shipment.|[IntendedBoxContentsSource](#intendedboxcontentssource)|


<a name="inboundshipmentinfo"></a>
### InboundShipmentInfo
Information about the seller's inbound shipments. Returned by the listInboundShipments operation.


|Name|Description|Schema|
|---|---|---|
|**ShipmentId**  <br>*optional*|The shipment identifier submitted in the request.|string|
|**ShipmentName**  <br>*optional*|The name for the inbound shipment.|string|
|**ShipFromAddress**  <br>*required*|The return address.|[Address](#address)|
|**DestinationFulfillmentCenterId**  <br>*optional*|An Amazon fulfillment center identifier created by Amazon.|string|
|**ShipmentStatus**  <br>*optional*|Indicates the status of the inbound shipment. When used with the createInboundShipment operation, WORKING is the only valid value. When used with the updateInboundShipment operation, possible values are WORKING, SHIPPED or CANCELLED.|[ShipmentStatus](#shipmentstatus)|
|**LabelPrepType**  <br>*optional*|The type of label preparation that is required for the inbound shipment.|[LabelPrepType](#labelpreptype)|
|**AreCasesRequired**  <br>*required*|Indicates whether or not an inbound shipment contains case-packed boxes. When AreCasesRequired = true for an inbound shipment, all items in the inbound shipment must be case packed.|boolean|
|**ConfirmedNeedByDate**  <br>*optional*|Date by which the shipment must arrive at the Amazon fulfillment center to avoid delivery promise breaks for pre-ordered items.|[DateStringType](#datestringtype)|
|**BoxContentsSource**  <br>*optional*|Where the seller provided box contents information for a shipment.|[BoxContentsSource](#boxcontentssource)|
|**EstimatedBoxContentsFee**  <br>*optional*|An estimate of the manual processing fee charged by Amazon for boxes without box content information. This is only returned when BoxContentsSource is NONE.|[BoxContentsFeeDetails](#boxcontentsfeedetails)|


<a name="inboundshipmentitem"></a>
### InboundShipmentItem
Item information for an inbound shipment. Submitted with a call to the createInboundShipment or updateInboundShipment operation.


|Name|Description|Schema|
|---|---|---|
|**ShipmentId**  <br>*optional*|A shipment identifier originally returned by the createInboundShipmentPlan operation.|string|
|**SellerSKU**  <br>*required*|The seller SKU of the item.|string|
|**FulfillmentNetworkSKU**  <br>*optional*|Amazon's fulfillment network SKU of the item.|string|
|**QuantityShipped**  <br>*required*|The item quantity that you are shipping.|[Quantity](#quantity)|
|**QuantityReceived**  <br>*optional*|The item quantity that has been received at an Amazon fulfillment center.|[Quantity](#quantity)|
|**QuantityInCase**  <br>*optional*|The item quantity in each case, for case-packed items. Note that QuantityInCase multiplied by the number of boxes in the inbound shipment equals QuantityShipped. Also note that all of the boxes of an inbound shipment must either be case packed or individually packed. For that reason, when you submit the createInboundShipment or the updateInboundShipment operation, the value of QuantityInCase must be provided for every item in the shipment or for none of the items in the shipment.|[Quantity](#quantity)|
|**ReleaseDate**  <br>*optional*|The date that a pre-order item will be available for sale.|[DateStringType](#datestringtype)|
|**PrepDetailsList**  <br>*optional*|A list of preparation instructions and who is responsible for that preparation.|[PrepDetailsList](#prepdetailslist)|


<a name="inboundshipmentitemlist"></a>
### InboundShipmentItemList
A list of inbound shipment item information.

*Type* : < [InboundShipmentItem](#inboundshipmentitem) > array


<a name="inboundshipmentlist"></a>
### InboundShipmentList
A list of inbound shipment information.

*Type* : < [InboundShipmentInfo](#inboundshipmentinfo) > array


<a name="inboundshipmentplan"></a>
### InboundShipmentPlan
Inbound shipment information used to create an inbound shipment. Returned by the createInboundShipmentPlan operation.


|Name|Description|Schema|
|---|---|---|
|**ShipmentId**  <br>*required*|A shipment identifier originally returned by the createInboundShipmentPlan operation.|string|
|**DestinationFulfillmentCenterId**  <br>*required*|An Amazon fulfillment center identifier created by Amazon.|string|
|**ShipToAddress**  <br>*required*|The address of the Amazon fulfillment center to which to ship the items.|[Address](#address)|
|**LabelPrepType**  <br>*required*|The type of label preparation that is required for the inbound shipment.|[LabelPrepType](#labelpreptype)|
|**Items**  <br>*required*|SKU and quantity information for the items in the shipment.|[InboundShipmentPlanItemList](#inboundshipmentplanitemlist)|
|**EstimatedBoxContentsFee**  <br>*optional*|The manual processing fee per unit and total fee for a shipment.|[BoxContentsFeeDetails](#boxcontentsfeedetails)|


<a name="inboundshipmentplanitem"></a>
### InboundShipmentPlanItem
Item information used to create an inbound shipment. Returned by the createInboundShipmentPlan operation.


|Name|Description|Schema|
|---|---|---|
|**SellerSKU**  <br>*required*|The seller SKU of the item.|string|
|**FulfillmentNetworkSKU**  <br>*required*|Amazon's fulfillment network SKU of the item.|string|
|**Quantity**  <br>*required*|The item quantity that you are shipping.|[Quantity](#quantity)|
|**PrepDetailsList**  <br>*optional*|A list of preparation instructions and who is responsible for that preparation.|[PrepDetailsList](#prepdetailslist)|


<a name="inboundshipmentplanitemlist"></a>
### InboundShipmentPlanItemList
A list of inbound shipment plan item information.

*Type* : < [InboundShipmentPlanItem](#inboundshipmentplanitem) > array


<a name="inboundshipmentplanlist"></a>
### InboundShipmentPlanList
A list of inbound shipment plan information

*Type* : < [InboundShipmentPlan](#inboundshipmentplan) > array


<a name="inboundshipmentplanrequestitem"></a>
### InboundShipmentPlanRequestItem
Item information for creating an inbound shipment plan. Submitted with a call to the createInboundShipmentPlan operation.


|Name|Description|Schema|
|---|---|---|
|**SellerSKU**  <br>*required*|The seller SKU of the item.|string|
|**ASIN**  <br>*required*|The Amazon Standard Identification Number (ASIN) of the item.|string|
|**Condition**  <br>*required*|The condition of the item.|[Condition](#condition)|
|**Quantity**  <br>*required*|The item quantity.|[Quantity](#quantity)|
|**QuantityInCase**  <br>*optional*|The item quantity in each case, for case-packed items. Note that QuantityInCase multiplied by the number of cases in the inbound shipment equals Quantity. Also note that all of the boxes of an inbound shipment must either be case packed or individually packed. For that reason, when you submit the createInboundShipmentPlan operation, the value of QuantityInCase must be provided for every item in the shipment or for none of the items in the shipment.|[Quantity](#quantity)|
|**PrepDetailsList**  <br>*optional*|A list of preparation instructions and who is responsible for that preparation.|[PrepDetailsList](#prepdetailslist)|


<a name="inboundshipmentplanrequestitemlist"></a>
### InboundShipmentPlanRequestItemList
*Type* : < [InboundShipmentPlanRequestItem](#inboundshipmentplanrequestitem) > array


<a name="intendedboxcontentssource"></a>
### IntendedBoxContentsSource
How the seller intends to provide box contents information for a shipment.

*Type* : enum


|Value|Description|
|---|---|
|**NONE**|There is no box content information for this shipment. Amazon will manually process the box contents. This may incur a fee.|
|**FEED**|Box content information is provided through the _POST_FBA_INBOUND_CARTON_CONTENTS_ feed.|
|**2D_BARCODE**|Box content information is provided by a barcode on the shipment.|


<a name="invalidasin"></a>
### InvalidASIN

|Name|Description|Schema|
|---|---|---|
|**ASIN**  <br>*optional*|The Amazon Standard Identification Number (ASIN) of the item.|string|
|**ErrorReason**  <br>*optional*|The reason that the ASIN is invalid.|[ErrorReason](#errorreason)|


<a name="invalidasinlist"></a>
### InvalidASINList
A list of invalid ASIN values and the reasons they are invalid.

*Type* : < [InvalidASIN](#invalidasin) > array


<a name="invalidsku"></a>
### InvalidSKU

|Name|Description|Schema|
|---|---|---|
|**SellerSKU**  <br>*optional*|The seller SKU of the item.|string|
|**ErrorReason**  <br>*optional*|The reason why the seller SKU is invalid.|[ErrorReason](#errorreason)|


<a name="invalidskulist"></a>
### InvalidSKUList
A list of invalid SKU values and the reason they are invalid.

*Type* : < [InvalidSKU](#invalidsku) > array


<a name="labelpreppreference"></a>
### LabelPrepPreference
The preference for label preparation for an inbound shipment.

*Type* : enum


|Value|Description|
|---|---|
|**SELLER_LABEL**|The seller labels the items in the inbound shipment when labels are required.|
|**AMAZON_LABEL_ONLY**|Amazon attempts to label the items in the inbound shipment when labels are required. If Amazon determines that it does not have the information required to successfully label an item, that item is not included in the inbound shipment plan.|
|**AMAZON_LABEL_PREFERRED**|Amazon attempts to label the items in the inbound shipment when labels are required. If Amazon determines that it does not have the information required to successfully label an item, that item is included in the inbound shipment plan and the seller must label it.|


<a name="labelpreptype"></a>
### LabelPrepType
The type of label preparation that is required for the inbound shipment.

*Type* : enum


|Value|Description|
|---|---|
|**NO_LABEL**|No label preparation is required. All items in this shipment will be handled as stickerless, commingled inventory.|
|**SELLER_LABEL**|Label preparation by the seller is required.|
|**AMAZON_LABEL**|Label preparation by Amazon is required.<br><br> Note: AMAZON_LABEL is available only if you are enrolled in the FBA Label Service. For more information about the FBA Label Service, see the Seller Central Help for your marketplace.|


<a name="getshipmentitemsresult"></a>
### GetShipmentItemsResult

|Name|Description|Schema|
|---|---|---|
|**ItemData**  <br>*optional*|A list of item information for an inbound shipment.|[InboundShipmentItemList](#inboundshipmentitemlist)|
|**NextToken**  <br>*optional*|When present and not empty, pass this string token in the next request to return the next response page.|string|


<a name="getshipmentitemsresponse"></a>
### GetShipmentItemsResponse
The response schema for the getShipmentItems operation.


|Name|Description|Schema|
|---|---|---|
|**payload**  <br>*optional*|The payload for the getShipmentItems operation.|[GetShipmentItemsResult](#getshipmentitemsresult)|
|**errors**  <br>*optional*|A list of error responses returned when a request is unsuccessful.|[ErrorList](#errorlist)|


<a name="getshipmentsresult"></a>
### GetShipmentsResult

|Name|Description|Schema|
|---|---|---|
|**ShipmentData**  <br>*optional*|Information about your inbound shipments.|[InboundShipmentList](#inboundshipmentlist)|
|**NextToken**  <br>*optional*|When present and not empty, pass this string token in the next request to return the next response page.|string|


<a name="getshipmentsresponse"></a>
### GetShipmentsResponse
The response schema for the getShipments operation.


|Name|Description|Schema|
|---|---|---|
|**payload**  <br>*optional*|The payload for the getShipments operation.|[GetShipmentsResult](#getshipmentsresult)|
|**errors**  <br>*optional*|A list of error responses returned when a request is unsuccessful.|[ErrorList](#errorlist)|


<a name="nonpartneredltldatainput"></a>
### NonPartneredLtlDataInput
Information that you provide to Amazon about a Less Than Truckload/Full Truckload (LTL/FTL) shipment by a carrier that has not partnered with Amazon.


|Name|Description|Schema|
|---|---|---|
|**CarrierName**  <br>*required*|The carrier that you are using for the inbound shipment.|string|
|**ProNumber**  <br>*required*|The PRO number ("progressive number" or "progressive ID") assigned to the shipment by the carrier.|[ProNumber](#pronumber)|


<a name="nonpartneredltldataoutput"></a>
### NonPartneredLtlDataOutput
Information returned by Amazon about a Less Than Truckload/Full Truckload (LTL/FTL) shipment shipped by a carrier that has not partnered with Amazon.


|Name|Description|Schema|
|---|---|---|
|**CarrierName**  <br>*required*|The carrier that you are using for the inbound shipment.|string|
|**ProNumber**  <br>*required*|The PRO number ("progressive number" or "progressive ID") assigned to the shipment by the carrier.|[ProNumber](#pronumber)|


<a name="nonpartneredsmallparceldatainput"></a>
### NonPartneredSmallParcelDataInput
Information that you provide to Amazon about a Small Parcel shipment shipped by a carrier that has not partnered with Amazon.


|Name|Description|Schema|
|---|---|---|
|**CarrierName**  <br>*required*|The carrier that you are using for the inbound shipment.|string|
|**PackageList**  <br>*required*|A list of package tracking information.|[NonPartneredSmallParcelPackageInputList](#nonpartneredsmallparcelpackageinputlist)|


<a name="nonpartneredsmallparceldataoutput"></a>
### NonPartneredSmallParcelDataOutput
Information returned by Amazon about a Small Parcel shipment by a carrier that has not partnered with Amazon.


|Name|Description|Schema|
|---|---|---|
|**PackageList**  <br>*required*|A list of packages, including carrier, tracking number, and status information for each package.|[NonPartneredSmallParcelPackageOutputList](#nonpartneredsmallparcelpackageoutputlist)|


<a name="nonpartneredsmallparcelpackageinput"></a>
### NonPartneredSmallParcelPackageInput
The tracking number of the package, provided by the carrier.


|Name|Description|Schema|
|---|---|---|
|**TrackingId**  <br>*required*|The tracking number of the package, provided by the carrier.|[TrackingId](#trackingid)|


<a name="nonpartneredsmallparcelpackageinputlist"></a>
### NonPartneredSmallParcelPackageInputList
A list of package tracking information.

*Type* : < [NonPartneredSmallParcelPackageInput](#nonpartneredsmallparcelpackageinput) > array


<a name="nonpartneredsmallparcelpackageoutput"></a>
### NonPartneredSmallParcelPackageOutput
Carrier, tracking number, and status information for the package.


|Name|Description|Schema|
|---|---|---|
|**CarrierName**  <br>*required*|The carrier that you are using for the inbound shipment.|string|
|**TrackingId**  <br>*required*|The tracking number of the package, provided by the carrier.|[TrackingId](#trackingid)|
|**PackageStatus**  <br>*required*|The shipment status of the package.|[PackageStatus](#packagestatus)|


<a name="nonpartneredsmallparcelpackageoutputlist"></a>
### NonPartneredSmallParcelPackageOutputList
A list of packages, including carrier, tracking number, and status information for each package.

*Type* : < [NonPartneredSmallParcelPackageOutput](#nonpartneredsmallparcelpackageoutput) > array


<a name="packagestatus"></a>
### PackageStatus
The shipment status of the package.

*Type* : enum


|Value|Description|
|---|---|
|**SHIPPED**|The carrier has picked up the package from your facility.|
|**IN_TRANSIT**|The carrier has made an appointment for delivery to an Amazon fulfillment center.|
|**DELIVERED**|The carrier has delivered the package to the loading dock of an Amazon fulfillment center.|
|**CHECKED_IN**|The Amazon fulfillment center has accepted delivery of the package from the carrier.|
|**RECEIVING**|The Amazon fulfillment center has begun the receiving process on the package.|
|**CLOSED**|The Amazon fulfillment center has completed the receiving process on the package.|
|**DELETED**|The shipment has been deleted.|


<a name="pallet"></a>
### Pallet
Pallet information.


|Name|Description|Schema|
|---|---|---|
|**Dimensions**  <br>*required*|The dimensions of the pallet. Length and width must be 40 inches by 48 inches. Height must be less than or equal to 60 inches.|[Dimensions](#dimensions)|
|**Weight**  <br>*optional*|The weight of the pallet.|[Weight](#weight)|
|**IsStacked**  <br>*required*|Indicates whether pallets will be stacked when carrier arrives for pick-up.|boolean|


<a name="palletlist"></a>
### PalletList
A list of pallet information.

*Type* : < [Pallet](#pallet) > array


<a name="partneredestimate"></a>
### PartneredEstimate
The estimated shipping cost for a shipment using an Amazon-partnered carrier.


|Name|Description|Schema|
|---|---|---|
|**Amount**  <br>*required*|The amount that the Amazon-partnered carrier will charge to ship the inbound shipment.|[Amount](#amount)|
|**ConfirmDeadline**  <br>*optional*|The date in ISO 8601 date time format by which this estimate must be confirmed. After this date the estimate is no longer valid and cannot be confirmed.<br><br>Returned only if the TransportStatus value of the inbound shipment is ESTIMATED.|[TimeStampStringType](#timestampstringtype)|
|**VoidDeadline**  <br>*optional*|The date in ISO 8601 date time format after which a confirmed transportation request can no longer be voided. This date is 24 hours after a Small Parcel shipment transportation request is confirmed or one hour after a Less Than Truckload/Full Truckload (LTL/FTL) shipment transportation request is confirmed. After the void deadline passes the seller's account will be charged for the shipping cost.<br><br>Returned only if the TransportStatus value of the inbound shipment is CONFIRMED.|[TimeStampStringType](#timestampstringtype)|


<a name="partneredltldatainput"></a>
### PartneredLtlDataInput
Information that is required by an Amazon-partnered carrier to ship a Less Than Truckload/Full Truckload (LTL/FTL) inbound shipment.


|Name|Description|Schema|
|---|---|---|
|**Contact**  <br>*optional*|Contact information for the person in the seller's organization who is responsible for the shipment. Used by the carrier if they have questions about the shipment.|[Contact](#contact)|
|**BoxCount**  <br>*optional*|The number of boxes in the shipment.|[UnsignedIntType](#unsignedinttype)|
|**SellerFreightClass**  <br>*optional*|The freight class of the shipment. For information about determining the freight class, contact the carrier.|[SellerFreightClass](#sellerfreightclass)|
|**FreightReadyDate**  <br>*optional*|The date that the shipment will be ready to be picked up by the carrier.|[DateStringType](#datestringtype)|
|**PalletList**  <br>*optional*|A list of pallet information.|[PalletList](#palletlist)|
|**TotalWeight**  <br>*optional*|The total weight of the shipment.|[Weight](#weight)|
|**SellerDeclaredValue**  <br>*optional*|The declaration of the total value of the inventory in the shipment.|[Amount](#amount)|


<a name="partneredltldataoutput"></a>
### PartneredLtlDataOutput
Information returned by Amazon about a Less Than Truckload/Full Truckload (LTL/FTL) shipment by an Amazon-partnered carrier.


|Name|Description|Schema|
|---|---|---|
|**Contact**  <br>*required*|Contact information for the person in the seller's organization who is responsible for the shipment. Used by the carrier if they have questions about the shipment.|[Contact](#contact)|
|**BoxCount**  <br>*required*|The number of boxes in the shipment.|[UnsignedIntType](#unsignedinttype)|
|**SellerFreightClass**  <br>*optional*|The freight class of the shipment. For information about determining the freight class, contact the carrier.|[SellerFreightClass](#sellerfreightclass)|
|**FreightReadyDate**  <br>*required*|The date that the shipment will be ready to be picked up by the carrier. Must be in YYYY-MM-DD format.|[DateStringType](#datestringtype)|
|**PalletList**  <br>*required*|A list of pallet information.|[PalletList](#palletlist)|
|**TotalWeight**  <br>*required*|The total weight of the shipment.|[Weight](#weight)|
|**SellerDeclaredValue**  <br>*optional*|Your declaration of the total value of the inventory in the shipment.|[Amount](#amount)|
|**AmazonCalculatedValue**  <br>*optional*|Estimate by Amazon of the total value of the inventory in the shipment.|[Amount](#amount)|
|**PreviewPickupDate**  <br>*required*|The estimated date that the shipment will be picked up by the carrier, in YYYY-MM-DD format.|[DateStringType](#datestringtype)|
|**PreviewDeliveryDate**  <br>*required*|The estimated date that the shipment will be delivered to an Amazon fulfillment center, in YYYY-MM-DD format.|[DateStringType](#datestringtype)|
|**PreviewFreightClass**  <br>*required*|The freight class of the shipment as estimated by Amazon if you did not include a freight class when you called the putTransportDetails operation.|[SellerFreightClass](#sellerfreightclass)|
|**AmazonReferenceId**  <br>*required*|A unique identifier created by Amazon that identifies this Amazon-partnered, Less Than Truckload/Full Truckload (LTL/FTL) shipment.|string|
|**IsBillOfLadingAvailable**  <br>*required*|Indicates whether the bill of lading for the shipment is available.|boolean|
|**PartneredEstimate**  <br>*optional*|The estimated shipping cost using an Amazon-partnered carrier.|[PartneredEstimate](#partneredestimate)|
|**CarrierName**  <br>*required*|The carrier for the inbound shipment.|string|


<a name="partneredsmallparceldatainput"></a>
### PartneredSmallParcelDataInput
Information that is required by an Amazon-partnered carrier to ship a Small Parcel inbound shipment.


|Name|Description|Schema|
|---|---|---|
|**PackageList**  <br>*optional*|A list of dimensions and weight information for packages.|[PartneredSmallParcelPackageInputList](#partneredsmallparcelpackageinputlist)|
|**CarrierName**  <br>*optional*|The Amazon-partnered carrier to use for the inbound shipment.|string|


<a name="partneredsmallparceldataoutput"></a>
### PartneredSmallParcelDataOutput
Information returned by Amazon about a Small Parcel shipment by an Amazon-partnered carrier.


|Name|Description|Schema|
|---|---|---|
|**PackageList**  <br>*required*|A list of packages, including shipping information from the Amazon-partnered carrier.|[PartneredSmallParcelPackageOutputList](#partneredsmallparcelpackageoutputlist)|
|**PartneredEstimate**  <br>*optional*|The estimated shipping cost for a shipment using an Amazon-partnered carrier.|[PartneredEstimate](#partneredestimate)|


<a name="partneredsmallparcelpackageinput"></a>
### PartneredSmallParcelPackageInput
Dimension and weight information for the package.


|Name|Description|Schema|
|---|---|---|
|**Dimensions**  <br>*required*|The dimension values and unit of measurement.|[Dimensions](#dimensions)|
|**Weight**  <br>*required*|The weight of the package.|[Weight](#weight)|


<a name="partneredsmallparcelpackageinputlist"></a>
### PartneredSmallParcelPackageInputList
A list of dimensions and weight information for packages.

*Type* : < [PartneredSmallParcelPackageInput](#partneredsmallparcelpackageinput) > array


<a name="partneredsmallparcelpackageoutput"></a>
### PartneredSmallParcelPackageOutput
Dimension, weight, and shipping information for the package.


|Name|Description|Schema|
|---|---|---|
|**Dimensions**  <br>*required*|The dimension values and unit of measurement.|[Dimensions](#dimensions)|
|**Weight**  <br>*required*|The weight of the package.|[Weight](#weight)|
|**CarrierName**  <br>*required*|The carrier specified with a previous call to putTransportDetails.|string|
|**TrackingId**  <br>*required*|The tracking number of the package, provided by the carrier.|[TrackingId](#trackingid)|
|**PackageStatus**  <br>*required*|The shipment status of the package.|[PackageStatus](#packagestatus)|


<a name="partneredsmallparcelpackageoutputlist"></a>
### PartneredSmallParcelPackageOutputList
A list of packages, including shipping information from the Amazon-partnered carrier.

*Type* : < [PartneredSmallParcelPackageOutput](#partneredsmallparcelpackageoutput) > array


<a name="prepdetails"></a>
### PrepDetails
Preparation instructions and who is responsible for the preparation.


|Name|Description|Schema|
|---|---|---|
|**PrepInstruction**  <br>*required*|Preparation instructions for shipping an item to Amazon's fulfillment network. For more information about preparing items for shipment to Amazon's fulfillment network, see the Seller Central Help for your marketplace.|[PrepInstruction](#prepinstruction)|
|**PrepOwner**  <br>*required*|Indicates who will prepare the item.|[PrepOwner](#prepowner)|


<a name="prepdetailslist"></a>
### PrepDetailsList
A list of preparation instructions and who is responsible for that preparation.

*Type* : < [PrepDetails](#prepdetails) > array


<a name="prepguidance"></a>
### PrepGuidance
Item preparation instructions.

*Type* : enum


|Value|Description|
|---|---|
|**ConsultHelpDocuments**|Indicates that Amazon is currently unable to determine the preparation instructions for this item. Amazon might be able to provide guidance at a future date, after evaluating the item.|
|**NoAdditionalPrepRequired**|Indicates that the item does not require preparation in addition to any item labeling that might be required.|
|**SeePrepInstructionsList**|Indicates that the item requires preparation in addition to any item labeling that might be required. See the PrepInstructionList in the response for item preparation instructions.|


<a name="prepinstruction"></a>
### PrepInstruction
Preparation instructions for shipping an item to Amazon's fulfillment network. For more information about preparing items for shipment to Amazon's fulfillment network, see the Seller Central Help for your marketplace.

*Type* : enum


|Value|Description|
|---|---|
|**Polybagging**|Indicates that polybagging is required.|
|**BubbleWrapping**|Indicates that bubble wrapping is required.|
|**Taping**|Indicates that taping is required.|
|**BlackShrinkWrapping**|Indicates that black shrink wrapping is required.|
|**Labeling**|Indicates that the FNSKU label should be applied to the item.|
|**HangGarment**|Indicates that the item should be placed on a hanger.|


<a name="prepinstructionlist"></a>
### PrepInstructionList
A list of preparation instructions to help with item sourcing decisions.

*Type* : < [PrepInstruction](#prepinstruction) > array


<a name="prepowner"></a>
### PrepOwner
Indicates who will prepare the item.

*Type* : enum


|Value|Description|
|---|---|
|**AMAZON**|Indicates Amazon will prepare the item.|
|**SELLER**|Indicates the seller will prepare the item.|


<a name="pronumber"></a>
### ProNumber
The PRO number ("progressive number" or "progressive ID") assigned to the shipment by the carrier.

*Type* : string


<a name="puttransportdetailsrequest"></a>
### PutTransportDetailsRequest
The request schema for a putTransportDetails operation.


|Name|Description|Schema|
|---|---|---|
|**IsPartnered**  <br>*required*|Indicates whether a putTransportDetails request is for an Amazon-partnered carrier.|boolean|
|**ShipmentType**  <br>*required*|Specifies the carrier shipment type in a putTransportDetails request.|[ShipmentType](#shipmenttype)|
|**TransportDetails**  <br>*required*|Information required to create an Amazon-partnered carrier shipping estimate, or to alert the Amazon fulfillment center to the arrival of an inbound shipment by a non-Amazon-partnered carrier.|[TransportDetailInput](#transportdetailinput)|


<a name="puttransportdetailsresponse"></a>
### PutTransportDetailsResponse
Workflow status for a shipment with an Amazon-partnered carrier.


|Name|Description|Schema|
|---|---|---|
|**payload**  <br>*optional*|The payload for the putTransportDetails operation.|[CommonTransportResult](#commontransportresult)|
|**errors**  <br>*optional*|A list of error responses returned when a request is unsuccessful.|[ErrorList](#errorlist)|


<a name="quantity"></a>
### Quantity
The item quantity.

*Type* : integer (int32)


<a name="skuinboundguidance"></a>
### SKUInboundGuidance
Reasons why a given seller SKU is not recommended for shipment to Amazon's fulfillment network.


|Name|Description|Schema|
|---|---|---|
|**SellerSKU**  <br>*required*|The seller SKU of the item.|string|
|**ASIN**  <br>*required*|The Amazon Standard Identification Number (ASIN) of the item.|string|
|**InboundGuidance**  <br>*required*|Specific inbound guidance for an item.|[InboundGuidance](#inboundguidance)|
|**GuidanceReasonList**  <br>*optional*|A list of reasons for the current inbound guidance for this item.|[GuidanceReasonList](#guidancereasonlist)|


<a name="skuinboundguidancelist"></a>
### SKUInboundGuidanceList
A list of SKU inbound guidance information.

*Type* : < [SKUInboundGuidance](#skuinboundguidance) > array


<a name="skuprepinstructions"></a>
### SKUPrepInstructions
Labeling requirements and item preparation instructions to help you prepare items for shipment to Amazon's fulfillment network.


|Name|Description|Schema|
|---|---|---|
|**SellerSKU**  <br>*optional*|The seller SKU of the item.|string|
|**ASIN**  <br>*optional*|The Amazon Standard Identification Number (ASIN) of the item.|string|
|**BarcodeInstruction**  <br>*optional*|Labeling requirements for the item. For more information about FBA labeling requirements, see the Seller Central Help for your marketplace.|[BarcodeInstruction](#barcodeinstruction)|
|**PrepGuidance**  <br>*optional*|Item preparation instructions.|[PrepGuidance](#prepguidance)|
|**PrepInstructionList**  <br>*optional*|A list of preparation instructions to help with item sourcing decisions.|[PrepInstructionList](#prepinstructionlist)|
|**AmazonPrepFeesDetailsList**  <br>*optional*|A list of preparation instructions and fees for Amazon to prep goods for shipment.|[AmazonPrepFeesDetailsList](#amazonprepfeesdetailslist)|


<a name="skuprepinstructionslist"></a>
### SKUPrepInstructionsList
A list of SKU labeling requirements and item preparation instructions.

*Type* : < [SKUPrepInstructions](#skuprepinstructions) > array


<a name="sellerfreightclass"></a>
### SellerFreightClass
The freight class of the shipment. For information about determining the freight class, contact the carrier.

*Type* : enum


|Value|Description|
|---|---|
|**50**|50|
|**55**|55|
|**60**|60|
|**65**|65|
|**70**|70|
|**77.5**|77.5|
|**85**|85|
|**92.5**|92.5|
|**100**|100|
|**110**|110|
|**125**|125|
|**150**|150|
|**175**|175|
|**200**|200|
|**250**|250|
|**300**|300|
|**400**|400|
|**500**|500|


<a name="shipmentstatus"></a>
### ShipmentStatus
Indicates the status of the inbound shipment. When used with the createInboundShipment operation, WORKING is the only valid value. When used with the updateInboundShipment operation, possible values are WORKING, SHIPPED or CANCELLED.

*Type* : enum


|Value|Description|
|---|---|
|**WORKING**|The shipment was created by the seller, but has not yet shipped.|
|**SHIPPED**|The shipment was picked up by the carrier.|
|**RECEIVING**|The shipment has arrived at the fulfillment center, but not all items have been marked as received.|
|**CANCELLED**|The shipment was cancelled by the seller after the shipment was sent to the fulfillment center.|
|**DELETED**|The shipment was cancelled by the seller before the shipment was sent to the  fulfillment center.|
|**CLOSED**|The shipment has arrived at the fulfillment center and all items have been marked as received.|
|**ERROR**|There was an error with the shipment and it was not processed by Amazon.|
|**IN_TRANSIT**|The carrier has notified the fulfillment center that it is aware of the shipment.|
|**DELIVERED**|The shipment was delivered by the carrier to the fulfillment center.|
|**CHECKED_IN**|The shipment was checked-in at the receiving dock of the fulfillment center.|


<a name="shipmenttype"></a>
### ShipmentType
Specifies the carrier shipment type in a putTransportDetails request.

*Type* : enum


|Value|Description|
|---|---|
|**SP**|Small Parcel.|
|**LTL**|Less Than Truckload/Full Truckload (LTL/FTL).|


<a name="timestampstringtype"></a>
### TimeStampStringType
*Type* : string (date-time)


<a name="trackingid"></a>
### TrackingId
The tracking number of the package, provided by the carrier.

*Type* : string


<a name="transportcontent"></a>
### TransportContent
Inbound shipment information, including carrier details, shipment status, and the workflow status for a request for shipment with an Amazon-partnered carrier.


|Name|Description|Schema|
|---|---|---|
|**TransportHeader**  <br>*required*|The shipping identifier, information about whether the shipment is by an Amazon-partnered carrier, and information about whether the shipment is Small Parcel or Less Than Truckload/Full Truckload (LTL/FTL).|[TransportHeader](#transportheader)|
|**TransportDetails**  <br>*required*|Inbound shipment information, including carrier details and shipment status.|[TransportDetailOutput](#transportdetailoutput)|
|**TransportResult**  <br>*required*|The workflow status for a shipment with an Amazon-partnered carrier.|[TransportResult](#transportresult)|


<a name="transportdetailinput"></a>
### TransportDetailInput
Information required to create an Amazon-partnered carrier shipping estimate, or to alert the Amazon fulfillment center to the arrival of an inbound shipment by a non-Amazon-partnered carrier.


|Name|Description|Schema|
|---|---|---|
|**PartneredSmallParcelData**  <br>*optional*|Information that is required by an Amazon-partnered carrier to ship a Small Parcel inbound shipment.|[PartneredSmallParcelDataInput](#partneredsmallparceldatainput)|
|**NonPartneredSmallParcelData**  <br>*optional*|Information that you provide to Amazon about a Small Parcel shipment shipped by a carrier that has not partnered with Amazon.|[NonPartneredSmallParcelDataInput](#nonpartneredsmallparceldatainput)|
|**PartneredLtlData**  <br>*optional*|Information that is required by an Amazon-partnered carrier to ship a Less Than Truckload/Full Truckload (LTL/FTL) inbound shipment.|[PartneredLtlDataInput](#partneredltldatainput)|
|**NonPartneredLtlData**  <br>*optional*|Information that you provide to Amazon about a Less Than Truckload/Full Truckload (LTL/FTL) shipment by a carrier that has not partnered with Amazon.|[NonPartneredLtlDataInput](#nonpartneredltldatainput)|


<a name="transportdetailoutput"></a>
### TransportDetailOutput
Inbound shipment information, including carrier details and shipment status.


|Name|Description|Schema|
|---|---|---|
|**PartneredSmallParcelData**  <br>*optional*|Information returned by Amazon about a Small Parcel shipment by an Amazon-partnered carrier.|[PartneredSmallParcelDataOutput](#partneredsmallparceldataoutput)|
|**NonPartneredSmallParcelData**  <br>*optional*|Information returned by Amazon about a Small Parcel shipment by a carrier that has not partnered with Amazon.|[NonPartneredSmallParcelDataOutput](#nonpartneredsmallparceldataoutput)|
|**PartneredLtlData**  <br>*optional*|Information returned by Amazon about a Less Than Truckload/Full Truckload (LTL/FTL) shipment by an Amazon-partnered carrier.|[PartneredLtlDataOutput](#partneredltldataoutput)|
|**NonPartneredLtlData**  <br>*optional*|Information returned by Amazon about a Less Than Truckload/Full Truckload (LTL/FTL) shipment shipped by a carrier that has not partnered with Amazon.|[NonPartneredLtlDataOutput](#nonpartneredltldataoutput)|


<a name="transportheader"></a>
### TransportHeader
The shipping identifier, information about whether the shipment is by an Amazon-partnered carrier, and information about whether the shipment is Small Parcel or Less Than Truckload/Full Truckload (LTL/FTL).


|Name|Description|Schema|
|---|---|---|
|**SellerId**  <br>*required*|The Amazon seller identifier.|string|
|**ShipmentId**  <br>*required*|A shipment identifier originally returned by the createInboundShipmentPlan operation.|string|
|**IsPartnered**  <br>*required*|Indicates whether a putTransportDetails request is for a partnered carrier.<br><br>Possible values:<br><br><li> true – Request is for an Amazon-partnered carrier.</li><br><li> false – Request is for a non-Amazon-partnered carrier.</li>|boolean|
|**ShipmentType**  <br>*required*|Specifies the carrier shipment type in a putTransportDetails request.|[ShipmentType](#shipmenttype)|


<a name="transportresult"></a>
### TransportResult
The workflow status for a shipment with an Amazon-partnered carrier.


|Name|Description|Schema|
|---|---|---|
|**TransportStatus**  <br>*required*|Indicates the status of the Amazon-partnered carrier shipment.|[TransportStatus](#transportstatus)|
|**ErrorCode**  <br>*optional*|An error code that identifies the type of error that occured.|string|
|**ErrorDescription**  <br>*optional*|A message that describes the error condition.|string|


<a name="transportstatus"></a>
### TransportStatus
Indicates the status of the Amazon-partnered carrier shipment.

*Type* : enum


|Value|Description|
|---|---|
|**WORKING**|You have successfully called the putTransportDetails operation for this shipment but have not yet called the estimateTransport operation|
|**ESTIMATING**|You have successfully called the  estimateTransport operation for this shipment and the carrier is in the process of estimating the shipment cost.|
|**ESTIMATED**|The carrier has completed the process of estimating the shipment cost. Your transportation request is ready to be confirmed by you.|
|**ERROR_ON_ESTIMATING**|There was a problem with your call to the estimateTransport operation and an error was returned.|
|**CONFIRMING**|You have successfully called the confirmTransport operation but the confirmation process is not yet complete.|
|**CONFIRMED**|Your transportation request has been confirmed. Important: For a Small Parcel shipment, you can void your transportation request up to 24 hours after you confirm it. For a Less Than Truckload/Full Truckload (LTL/FTL) shipment, you can void your transportation request up to one hour after you confirm it. After the grace period has expired the seller's account will be charged for the shipping cost|
|**ERROR_ON_CONFIRMING**|There was a problem with your call to the confirmTransport operation and an error was returned.|
|**VOIDING**|You have successfully called the voidTransport operation for a confirmed carrier shipment but the voiding process is not yet complete.|
|**VOIDED**|Your confirmed carrier shipment has been voided. The seller's account will not be charged for the shipping cost.|
|**ERROR_IN_VOIDING**|There was a problem with your call to the voidTransport operation and an error was returned.|
|**ERROR**|There was a problem with your call and an error was returned.|


<a name="unitofmeasurement"></a>
### UnitOfMeasurement
Indicates the unit of measurement.

*Type* : enum


|Value|Description|
|---|---|
|**inches**|The unit of measurement is inches.|
|**centimeters**|The unit of measurement is centimeters.|


<a name="unitofweight"></a>
### UnitOfWeight
Indicates the unit of weight.

*Type* : enum


|Value|Description|
|---|---|
|**pounds**|The unit of weight is pounds.|
|**kilograms**|The unit of weight is kilograms.|


<a name="unsignedinttype"></a>
### UnsignedIntType
*Type* : integer (int64)


<a name="voidtransportresponse"></a>
### VoidTransportResponse
The response schema for the voidTransport operation.


|Name|Description|Schema|
|---|---|---|
|**payload**  <br>*optional*|The payload for the voidTransport operation.|[CommonTransportResult](#commontransportresult)|
|**errors**  <br>*optional*|A list of error responses returned when a request is unsuccessful.|[ErrorList](#errorlist)|


<a name="weight"></a>
### Weight
The weight of the package.


|Name|Description|Schema|
|---|---|---|
|**Value**  <br>*required*|The weight value.|[BigDecimalType](#bigdecimaltype)|
|**Unit**  <br>*required*|Indicates the unit of weight.|[UnitOfWeight](#unitofweight)|


<a name="labeltype"></a>
### LabelType
The type of labels requested.

*Type* : enum


|Value|Description|
|---|---|
|**BARCODE_2D**|This option is provided only for shipments where 2D Barcodes will be applied to all packages. Amazon strongly recommends using the UNIQUE option to get package labels instead of the BARCODE_2D option.|
|**UNIQUE**|Document data for printing unique shipping labels and carrier labels for an inbound shipment.|
|**PALLET**|Document data for printing pallet labels for a Less Than Truckload/Full Truckload (LTL/FTL) inbound shipment.|


<a name="shipmentstatuslist"></a>
### ShipmentStatusList
*Type* : enum


|Value|Description|
|---|---|
|**WORKING**|The shipment was created by the seller, but has not yet shipped.|
|**SHIPPED**|The shipment was picked up by the carrier.|
|**RECEIVING**|The shipment has arrived at the fulfillment center, but not all items have been marked as received.|
|**CANCELLED**|The shipment was cancelled by the seller after the shipment was sent to the fulfillment center.|
|**DELETED**|The shipment was cancelled by the seller before the shipment was sent to the  fulfillment center.|
|**CLOSED**|The shipment has arrived at the fulfillment center and all items have been marked as received.|
|**ERROR**|There was an error with the shipment and it was not processed by Amazon.|
|**IN_TRANSIT**|The carrier has notified the fulfillment center that it is aware of the shipment.|
|**DELIVERED**|The shipment was delivered by the carrier to the fulfillment center.|
|**CHECKED_IN**|The shipment was checked-in at the receiving dock of the fulfillment center.|


<a name="pagetype"></a>
### PageType
The page type to use to print the labels. Submitting a PageType value that is not supported in your marketplace returns an error.

*Type* : enum


|Value|Description|
|---|---|
|**PackageLabel_Letter_2**|Two labels per US Letter label sheet. This is the only valid value for Amazon-partnered shipments in the US that use United Parcel Service (UPS) as the carrier. Supported in Canada and the US.|
|**PackageLabel_Letter_4**|Four labels per US Letter label sheet. This is the only valid value for non-Amazon-partnered shipments in the US. Supported in Canada and the US.|
|**PackageLabel_Letter_6**|Six labels per US Letter label sheet. This is the only valid value for non-Amazon-partnered shipments in the US. Supported in Canada and the US.|
|**PackageLabel_Letter_6_CarrierLeft**|PackageLabel_Letter_6_CarrierLeft|
|**PackageLabel_A4_2**|Two labels per A4 label sheet.|
|**PackageLabel_A4_4**|Four labels per A4 label sheet.|
|**PackageLabel_Plain_Paper**|One label per sheet of US Letter paper. Only for non-Amazon-partnered shipments.|
|**PackageLabel_Plain_Paper_CarrierBottom**|PackageLabel_Plain_Paper_CarrierBottom|
|**PackageLabel_Thermal**|For use of a thermal printer. Supports Amazon-partnered shipments with UPS.|
|**PackageLabel_Thermal_Unified**|For use of a thermal printer. Supports shipments with ATS.|
|**PackageLabel_Thermal_NonPCP**|For use of a thermal printer. Supports non-Amazon-partnered shipments.|
|**PackageLabel_Thermal_No_Carrier_Rotation**|For use of a thermal printer. Supports Amazon-partnered shipments with DHL.|


<a name="querytype"></a>
### QueryType
*Type* : enum

<a id="querytype-subgroup-1"></a>**For use with the operation(s): [GetShipments](#getshipments)**
Indicates whether shipments are returned using shipment information (by providing the ShipmentStatusList or ShipmentIdList parameters), using a date range (by providing the LastUpdatedAfter and LastUpdatedBefore parameters), or by using NextToken to continue returning items specified in a previous request.

|Value|Description|
|---|---|
|**SHIPMENT**|Returns shipments based on the shipment information provided by the ShipmentStatusList or ShipmentIdList parameters.|
|**DATE_RANGE**|Returns shipments based on the date range information provided by the LastUpdatedAfter and LastUpdatedBefore parameters.|
|**NEXT_TOKEN**|Returns shipments by using NextToken to continue returning items specified in a previous request.|

<a id="querytype-subgroup-2"></a>**For use with the operation(s): [GetShipmentItems](#getshipmentitems)**
Indicates whether items are returned using a date range (by providing the LastUpdatedAfter and LastUpdatedBefore parameters), or using NextToken, which continues returning items specified in a previous request.

|Value|Description|
|---|---|
|**DATE_RANGE**|Returns items based on the date range information provided by the LastUpdatedAfter and LastUpdatedBefore parameters.|
|**NEXT_TOKEN**|Returns items by using NextToken to continue returning items specified in a previous request.|

