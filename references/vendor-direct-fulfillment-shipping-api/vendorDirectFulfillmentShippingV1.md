# Selling Partner API for Direct Fulfillment Shipping


<a name="overview"></a>
## Overview
The Selling Partner API for Direct Fulfillment Shipping provides programmatic access to a direct fulfillment vendor's shipping data.


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
[getShippingLabels](#getshippinglabels)<br>[submitShippingLabelRequest](#submitshippinglabelrequest)<br>[getShippingLabel](#getshippinglabel)<br>[submitShipmentConfirmations](#submitshipmentconfirmations)<br>[submitShipmentStatusUpdates](#submitshipmentstatusupdates)<br>[getCustomerInvoices](#getcustomerinvoices)<br>[getCustomerInvoice](#getcustomerinvoice)<br>[getPackingSlips](#getpackingslips)<br>[getPackingSlip](#getpackingslip)<br>
<a name="paths"></a>
## Paths

<a name="getshippinglabels"></a>
### GET /vendor/directFulfillment/shipping/v1/shippingLabels
**Operation: getShippingLabels**

#### Description
Returns a list of shipping labels created during the time frame that you specify. You define that time frame using the createdAfter and createdBefore parameters. You must use both of these parameters. The date range to search must not be more than 7 days.

**Usage Plans:**

| Plan type | Rate (requests per second) | Burst |
| ---- | ---- | ---- |
|Default| 10 | 10 |
|Selling partner specific| Variable | Variable |

The x-amzn-RateLimit-Limit response header returns the usage plan rate limits that were applied to the requested operation. Rate limits for some selling partners will vary from the default rate and burst shown in the table above. For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|Default|
|---|---|---|---|---|
|**Query**|**shipFromPartyId**  <br>*optional*|The vendor warehouseId for order fulfillment. If not specified, the result will contain orders for all warehouses.|string|-|
|**Query**|**limit**  <br>*optional*|The limit to the number of records returned.<br>**Minimum** : 1<br>**Maximum** : 100|integer|-|
|**Query**|**createdAfter**  <br>*required*|Shipping labels that became available after this date and time will be included in the result. Must be in ISO-8601 date/time format.|string (date-time)|-|
|**Query**|**createdBefore**  <br>*required*|Shipping labels that became available before this date and time will be included in the result. Must be in ISO-8601 date/time format.|string (date-time)|-|
|**Query**|**sortOrder**  <br>*optional*|Sort ASC or DESC by order creation date.|enum ([SortOrder](#sortorder-subgroup-2))|`"ASC"`|
|**Query**|**nextToken**  <br>*optional*|Used for pagination when there are more ship labels than the specified result size limit. The token value is returned in the previous API call.|string|-|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Success.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetShippingLabelListResponse](#getshippinglabellistresponse)|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetShippingLabelListResponse](#getshippinglabellistresponse)|
|**403**|Indicates that access to the resource is forbidden. Possible reasons include Access Denied, Unauthorized, Expired Token, or Invalid Signature.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetShippingLabelListResponse](#getshippinglabellistresponse)|
|**404**|The resource specified does not exist.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetShippingLabelListResponse](#getshippinglabellistresponse)|
|**415**|The request payload is in an unsupported format.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetShippingLabelListResponse](#getshippinglabellistresponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetShippingLabelListResponse](#getshippinglabellistresponse)|
|**500**|Encountered an unexpected condition which prevented the server from fulfilling the request.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetShippingLabelListResponse](#getshippinglabellistresponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetShippingLabelListResponse](#getshippinglabellistresponse)|


<a name="submitshippinglabelrequest"></a>
### POST /vendor/directFulfillment/shipping/v1/shippingLabels
**Operation: submitShippingLabelRequest**

#### Description
Creates a shipping label for a purchase order and returns a transactionId for reference.

**Usage Plans:**

| Plan type | Rate (requests per second) | Burst |
| ---- | ---- | ---- |
|Default| 10 | 10 |
|Selling partner specific| Variable | Variable |

The x-amzn-RateLimit-Limit response header returns the usage plan rate limits that were applied to the requested operation. Rate limits for some selling partners will vary from the default rate and burst shown in the table above. For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Schema|
|---|---|---|
|**Body**|**body**  <br>*required*|[SubmitShippingLabelsRequest](#submitshippinglabelsrequest)|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**202**|Success.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[SubmitShippingLabelsResponse](#submitshippinglabelsresponse)|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[SubmitShippingLabelsResponse](#submitshippinglabelsresponse)|
|**403**|Indicates that access to the resource is forbidden. Possible reasons include Access Denied, Unauthorized, Expired Token, or Invalid Signature.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[SubmitShippingLabelsResponse](#submitshippinglabelsresponse)|
|**404**|The resource specified does not exist.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[SubmitShippingLabelsResponse](#submitshippinglabelsresponse)|
|**413**|The request size exceeded the maximum accepted size.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[SubmitShippingLabelsResponse](#submitshippinglabelsresponse)|
|**415**|The request payload is in an unsupported format.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[SubmitShippingLabelsResponse](#submitshippinglabelsresponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[SubmitShippingLabelsResponse](#submitshippinglabelsresponse)|
|**500**|Encountered an unexpected condition which prevented the server from fulfilling the request.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[SubmitShippingLabelsResponse](#submitshippinglabelsresponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[SubmitShippingLabelsResponse](#submitshippinglabelsresponse)|


<a name="getshippinglabel"></a>
### GET /vendor/directFulfillment/shipping/v1/shippingLabels/{purchaseOrderNumber}
**Operation: getShippingLabel**

#### Description
Returns a shipping label for the purchaseOrderNumber that you specify.

**Usage Plans:**

| Plan type | Rate (requests per second) | Burst |
| ---- | ---- | ---- |
|Default| 10 | 10 |
|Selling partner specific| Variable | Variable |

The x-amzn-RateLimit-Limit response header returns the usage plan rate limits that were applied to the requested operation. Rate limits for some selling partners will vary from the default rate and burst shown in the table above. For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**purchaseOrderNumber**  <br>*required*|The purchase order number for which you want to return the shipping label. It should be the same purchaseOrderNumber as received in the order.|string|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Success.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetShippingLabelResponse](#getshippinglabelresponse)|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetShippingLabelResponse](#getshippinglabelresponse)|
|**401**|The request's Authorization header is not formatted correctly or does not contain a valid token.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetShippingLabelResponse](#getshippinglabelresponse)|
|**403**|Indicates that access to the resource is forbidden. Possible reasons include Access Denied, Unauthorized, Expired Token, or Invalid Signature.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetShippingLabelResponse](#getshippinglabelresponse)|
|**404**|The resource specified does not exist.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetShippingLabelResponse](#getshippinglabelresponse)|
|**415**|The request payload is in an unsupported format.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetShippingLabelResponse](#getshippinglabelresponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetShippingLabelResponse](#getshippinglabelresponse)|
|**500**|Encountered an unexpected condition which prevented the server from fulfilling the request.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetShippingLabelResponse](#getshippinglabelresponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetShippingLabelResponse](#getshippinglabelresponse)|


<a name="submitshipmentconfirmations"></a>
### POST /vendor/directFulfillment/shipping/v1/shipmentConfirmations
**Operation: submitShipmentConfirmations**

#### Description
Submits one or more shipment confirmations for vendor orders.

**Usage Plans:**

| Plan type | Rate (requests per second) | Burst |
| ---- | ---- | ---- |
|Default| 10 | 10 |
|Selling partner specific| Variable | Variable |

The x-amzn-RateLimit-Limit response header returns the usage plan rate limits that were applied to the requested operation. Rate limits for some selling partners will vary from the default rate and burst shown in the table above. For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Schema|
|---|---|---|
|**Body**|**body**  <br>*required*|[SubmitShipmentConfirmationsRequest](#submitshipmentconfirmationsrequest)|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**202**|Success.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[SubmitShipmentConfirmationsResponse](#submitshipmentconfirmationsresponse)|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[SubmitShipmentConfirmationsResponse](#submitshipmentconfirmationsresponse)|
|**403**|Indicates that access to the resource is forbidden. Possible reasons include Access Denied, Unauthorized, Expired Token, or Invalid Signature.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[SubmitShipmentConfirmationsResponse](#submitshipmentconfirmationsresponse)|
|**404**|The resource specified does not exist.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[SubmitShipmentConfirmationsResponse](#submitshipmentconfirmationsresponse)|
|**413**|The request size exceeded the maximum accepted size.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[SubmitShipmentConfirmationsResponse](#submitshipmentconfirmationsresponse)|
|**415**|The request payload is in an unsupported format.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[SubmitShipmentConfirmationsResponse](#submitshipmentconfirmationsresponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[SubmitShipmentConfirmationsResponse](#submitshipmentconfirmationsresponse)|
|**500**|Encountered an unexpected condition which prevented the server from fulfilling the request.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[SubmitShipmentConfirmationsResponse](#submitshipmentconfirmationsresponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[SubmitShipmentConfirmationsResponse](#submitshipmentconfirmationsresponse)|


<a name="submitshipmentstatusupdates"></a>
### POST /vendor/directFulfillment/shipping/v1/shipmentStatusUpdates
**Operation: submitShipmentStatusUpdates**

#### Description
This API call is only to be used by Vendor-Own-Carrier (VOC) vendors. Calling this API will submit a shipment status update for the package that a vendor has shipped. It will provide the Amazon customer visibility on their order, when the package is outside of Amazon Network visibility.

**Usage Plans:**

| Plan type | Rate (requests per second) | Burst |
| ---- | ---- | ---- |
|Default| 10 | 10 |
|Selling partner specific| Variable | Variable |

The x-amzn-RateLimit-Limit response header returns the usage plan rate limits that were applied to the requested operation. Rate limits for some selling partners will vary from the default rate and burst shown in the table above. For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Schema|
|---|---|---|
|**Body**|**body**  <br>*required*|[SubmitShipmentStatusUpdatesRequest](#submitshipmentstatusupdatesrequest)|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**202**|Success.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[SubmitShipmentStatusUpdatesResponse](#submitshipmentstatusupdatesresponse)|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[SubmitShipmentStatusUpdatesResponse](#submitshipmentstatusupdatesresponse)|
|**403**|Indicates that access to the resource is forbidden. Possible reasons include Access Denied, Unauthorized, Expired Token, or Invalid Signature.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[SubmitShipmentStatusUpdatesResponse](#submitshipmentstatusupdatesresponse)|
|**404**|The resource specified does not exist.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[SubmitShipmentStatusUpdatesResponse](#submitshipmentstatusupdatesresponse)|
|**413**|The request size exceeded the maximum accepted size.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[SubmitShipmentStatusUpdatesResponse](#submitshipmentstatusupdatesresponse)|
|**415**|The request payload is in an unsupported format.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[SubmitShipmentStatusUpdatesResponse](#submitshipmentstatusupdatesresponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[SubmitShipmentStatusUpdatesResponse](#submitshipmentstatusupdatesresponse)|
|**500**|Encountered an unexpected condition which prevented the server from fulfilling the request.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[SubmitShipmentStatusUpdatesResponse](#submitshipmentstatusupdatesresponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[SubmitShipmentStatusUpdatesResponse](#submitshipmentstatusupdatesresponse)|


<a name="getcustomerinvoices"></a>
### GET /vendor/directFulfillment/shipping/v1/customerInvoices
**Operation: getCustomerInvoices**

#### Description
Returns a list of customer invoices created during a time frame that you specify. You define the  time frame using the createdAfter and createdBefore parameters. You must use both of these parameters. The date range to search must be no more than 7 days.

**Usage Plans:**

| Plan type | Rate (requests per second) | Burst |
| ---- | ---- | ---- |
|Default| 10 | 10 |
|Selling partner specific| Variable | Variable |

The x-amzn-RateLimit-Limit response header returns the usage plan rate limits that were applied to the requested operation. Rate limits for some selling partners will vary from the default rate and burst shown in the table above. For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Query**|**shipFromPartyId**  <br>*optional*|The vendor warehouseId for order fulfillment. If not specified, the result will contain orders for all warehouses.|string|
|**Query**|**limit**  <br>*optional*|The limit to the number of records returned<br>**Minimum** : 1<br>**Maximum** : 100|integer|
|**Query**|**createdAfter**  <br>*required*|Orders that became available after this date and time will be included in the result. Must be in ISO-8601 date/time format.|string (date-time)|
|**Query**|**createdBefore**  <br>*required*|Orders that became available before this date and time will be included in the result. Must be in ISO-8601 date/time format.|string (date-time)|
|**Query**|**sortOrder**  <br>*optional*|Sort ASC or DESC by order creation date.|enum ([SortOrder](#sortorder-subgroup-2))|
|**Query**|**nextToken**  <br>*optional*|Used for pagination when there are more orders than the specified result size limit. The token value is returned in the previous API call.|string|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Success.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetCustomerInvoicesResponse](#getcustomerinvoicesresponse)|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetCustomerInvoiceResponse](#getcustomerinvoiceresponse)|
|**403**|Indicates that access to the resource is forbidden. Possible reasons include Access Denied, Unauthorized, Expired Token, or Invalid Signature.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetCustomerInvoiceResponse](#getcustomerinvoiceresponse)|
|**404**|The resource specified does not exist.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetCustomerInvoiceResponse](#getcustomerinvoiceresponse)|
|**415**|The request payload is in an unsupported format.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetCustomerInvoiceResponse](#getcustomerinvoiceresponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetCustomerInvoiceResponse](#getcustomerinvoiceresponse)|
|**500**|Encountered an unexpected condition which prevented the server from fulfilling the request.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetCustomerInvoiceResponse](#getcustomerinvoiceresponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetCustomerInvoiceResponse](#getcustomerinvoiceresponse)|


<a name="getcustomerinvoice"></a>
### GET /vendor/directFulfillment/shipping/v1/customerInvoices/{purchaseOrderNumber}
**Operation: getCustomerInvoice**

#### Description
Returns a customer invoice based on the purchaseOrderNumber that you specify.

**Usage Plans:**

| Plan type | Rate (requests per second) | Burst |
| ---- | ---- | ---- |
|Default| 10 | 10 |
|Selling partner specific| Variable | Variable |

The x-amzn-RateLimit-Limit response header returns the usage plan rate limits that were applied to the requested operation. Rate limits for some selling partners will vary from the default rate and burst shown in the table above. For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**purchaseOrderNumber**  <br>*required*|Purchase order number of the shipment for which to return the invoice.|string|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Success.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetCustomerInvoiceResponse](#getcustomerinvoiceresponse)|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetCustomerInvoiceResponse](#getcustomerinvoiceresponse)|
|**401**|The request's Authorization header is not formatted correctly or does not contain a valid token.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetCustomerInvoiceResponse](#getcustomerinvoiceresponse)|
|**403**|Indicates that access to the resource is forbidden. Possible reasons include Access Denied, Unauthorized, Expired Token, or Invalid Signature.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetCustomerInvoiceResponse](#getcustomerinvoiceresponse)|
|**404**|The resource specified does not exist.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetCustomerInvoiceResponse](#getcustomerinvoiceresponse)|
|**415**|The request payload is in an unsupported format.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetCustomerInvoiceResponse](#getcustomerinvoiceresponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetCustomerInvoiceResponse](#getcustomerinvoiceresponse)|
|**500**|Encountered an unexpected condition which prevented the server from fulfilling the request.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetCustomerInvoiceResponse](#getcustomerinvoiceresponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetCustomerInvoiceResponse](#getcustomerinvoiceresponse)|


<a name="getpackingslips"></a>
### GET /vendor/directFulfillment/shipping/v1/packingSlips
**Operation: getPackingSlips**

#### Description
Returns a list of packing slips for the purchase orders that match the criteria specified. Date range to search must not be more than 7 days.

**Usage Plans:**

| Plan type | Rate (requests per second) | Burst |
| ---- | ---- | ---- |
|Default| 10 | 10 |
|Selling partner specific| Variable | Variable |

The x-amzn-RateLimit-Limit response header returns the usage plan rate limits that were applied to the requested operation. Rate limits for some selling partners will vary from the default rate and burst shown in the table above. For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|Default|
|---|---|---|---|---|
|**Query**|**shipFromPartyId**  <br>*optional*|The vendor warehouseId for order fulfillment. If not specified the result will contain orders for all warehouses.|string|-|
|**Query**|**limit**  <br>*optional*|The limit to the number of records returned<br>**Minimum** : 1<br>**Maximum** : 100|integer|-|
|**Query**|**createdAfter**  <br>*required*|Packing slips that became available after this date and time will be included in the result. Must be in ISO-8601 date/time format.|string (date-time)|-|
|**Query**|**createdBefore**  <br>*required*|Packing slips that became available before this date and time will be included in the result. Must be in ISO-8601 date/time format.|string (date-time)|-|
|**Query**|**sortOrder**  <br>*optional*|Sort ASC or DESC by packing slip creation date.|enum ([SortOrder](#sortorder-subgroup-1))|`"ASC"`|
|**Query**|**nextToken**  <br>*optional*|Used for pagination when there are more packing slips than the specified result size limit. The token value is returned in the previous API call.|string|-|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Success.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetPackingSlipListResponse](#getpackingsliplistresponse)|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetPackingSlipListResponse](#getpackingsliplistresponse)|
|**401**|The request's Authorization header is not formatted correctly or does not contain a valid token.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetPackingSlipListResponse](#getpackingsliplistresponse)|
|**403**|Indicates that access to the resource is forbidden. Possible reasons include Access Denied, Unauthorized, Expired Token, or Invalid Signature.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetPackingSlipListResponse](#getpackingsliplistresponse)|
|**404**|The resource specified does not exist.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetPackingSlipListResponse](#getpackingsliplistresponse)|
|**415**|The request payload is in an unsupported format.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetPackingSlipListResponse](#getpackingsliplistresponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetPackingSlipListResponse](#getpackingsliplistresponse)|
|**500**|Encountered an unexpected condition which prevented the server from fulfilling the request.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetPackingSlipListResponse](#getpackingsliplistresponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetPackingSlipListResponse](#getpackingsliplistresponse)|


<a name="getpackingslip"></a>
### GET /vendor/directFulfillment/shipping/v1/packingSlips/{purchaseOrderNumber}
**Operation: getPackingSlip**

#### Description
Returns a packing slip based on the purchaseOrderNumber that you specify.

**Usage Plans:**

| Plan type | Rate (requests per second) | Burst |
| ---- | ---- | ---- |
|Default| 10 | 10 |
|Selling partner specific| Variable | Variable |

The x-amzn-RateLimit-Limit response header returns the usage plan rate limits that were applied to the requested operation. Rate limits for some selling partners will vary from the default rate and burst shown in the table above. For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**purchaseOrderNumber**  <br>*required*|The purchaseOrderNumber for the packing slip you want.|string|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Success.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetPackingSlipResponse](#getpackingslipresponse)|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetPackingSlipResponse](#getpackingslipresponse)|
|**401**|The request's Authorization header is not formatted correctly or does not contain a valid token.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetPackingSlipResponse](#getpackingslipresponse)|
|**403**|Indicates that access to the resource is forbidden. Possible reasons include Access Denied, Unauthorized, Expired Token, or Invalid Signature.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetPackingSlipResponse](#getpackingslipresponse)|
|**404**|The resource specified does not exist.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetPackingSlipResponse](#getpackingslipresponse)|
|**415**|The request payload is in an unsupported format.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetPackingSlipResponse](#getpackingslipresponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetPackingSlipResponse](#getpackingslipresponse)|
|**500**|Encountered an unexpected condition which prevented the server from fulfilling the request.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetPackingSlipResponse](#getpackingslipresponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetPackingSlipResponse](#getpackingslipresponse)|


<a name="definitions"></a>
## Definitions

<a name="packingslip"></a>
### PackingSlip
Packing slip information.


|Name|Description|Schema|
|---|---|---|
|**purchaseOrderNumber**  <br>*required*|Purchase order number of the shipment that the packing slip is for.  <br>**Pattern** : `"^[a-zA-Z0-9]+$"`|string|
|**content**  <br>*required*|A Base64encoded string of the packing slip PDF.|string|
|**contentType**  <br>*optional*|The format of the file such as PDF, JPEG etc.|enum ([ContentType](#contenttype))|


<a name="packingsliplist"></a>
### PackingSlipList
A list of packing slips.


|Name|Schema|
|---|---|
|**pagination**  <br>*optional*|[Pagination](#pagination)|
|**packingSlips**  <br>*optional*|< [PackingSlip](#packingslip) > array|


<a name="getpackingsliplistresponse"></a>
### GetPackingSlipListResponse

|Name|Description|Schema|
|---|---|---|
|**payload**  <br>*optional*|A list of packing slips.|[PackingSlipList](#packingsliplist)|
|**errors**  <br>*optional*|A list of error responses returned when a request is unsuccessful.|[ErrorList](#errorlist)|


<a name="getpackingslipresponse"></a>
### GetPackingSlipResponse

|Name|Description|Schema|
|---|---|---|
|**payload**  <br>*optional*|Packing slip information.|[PackingSlip](#packingslip)|
|**errors**  <br>*optional*|A list of error responses returned when a request is unsuccessful.|[ErrorList](#errorlist)|


<a name="submitshippinglabelsrequest"></a>
### SubmitShippingLabelsRequest

|Name|Schema|
|---|---|
|**shippingLabelRequests**  <br>*optional*|< [ShippingLabelRequest](#shippinglabelrequest) > array|


<a name="shippinglabelrequest"></a>
### ShippingLabelRequest

|Name|Description|Schema|
|---|---|---|
|**purchaseOrderNumber**  <br>*required*|Purchase order number of the order for which to create a shipping label.  <br>**Pattern** : `"^[a-zA-Z0-9]+$"`|string|
|**sellingParty**  <br>*required*|ID of the selling party or vendor.|[PartyIdentification](#partyidentification)|
|**shipFromParty**  <br>*required*|Warehouse code of vendor.|[PartyIdentification](#partyidentification)|
|**containers**  <br>*optional*|A list of the packages in this shipment.|< [Container](#container) > array|


<a name="item"></a>
### Item
Details of the item being shipped.


|Name|Description|Schema|
|---|---|---|
|**itemSequenceNumber**  <br>*required*|Item Sequence Number for the item. This must be the same value as sent in order for a given item.|integer|
|**buyerProductIdentifier**  <br>*optional*|Buyer's Standard Identification Number (ASIN) of an item. Either buyerProductIdentifier or vendorProductIdentifier is required.|string|
|**vendorProductIdentifier**  <br>*optional*|The vendor selected product identification of the item. Should be the same as was sent in the purchase order, like SKU Number.|string|
|**shippedQuantity**  <br>*required*|Total item quantity shipped in this shipment.|[ItemQuantity](#itemquantity)|


<a name="packeditem"></a>
### PackedItem

|Name|Description|Schema|
|---|---|---|
|**itemSequenceNumber**  <br>*required*|Item Sequence Number for the item. This must be the same value as sent in the order for a given item.|integer|
|**buyerProductIdentifier**  <br>*optional*|Buyer's Standard Identification Number (ASIN) of an item. Either buyerProductIdentifier or vendorProductIdentifier is required.|string|
|**vendorProductIdentifier**  <br>*optional*|The vendor selected product identification of the item. Should be the same as was sent in the Purchase Order, like SKU Number.|string|
|**packedQuantity**  <br>*required*|Total item quantity packed in the container.|[ItemQuantity](#itemquantity)|


<a name="package"></a>
### Package
Details of the package being shipped.


|Name|Description|Schema|
|---|---|---|
|**packageIdentifier**  <br>*required*|Package identifier for the package. The first package will be 001, the second 002, and so on. This number is used as a reference to refer to this package from the pallet level.|string|
|**trackingNumber**  <br>*optional*|This is required to be provided for every package in the small parcel shipments.|string|
|**manifestId**  <br>*optional*|Carrier manifest Id (Applicable for LTL shipments).|string|
|**manifestDate**  <br>*optional*|Carrier manifest Date (Applicable for LTL shipments).|string (date-time)|
|**shipMethod**  <br>*optional*|Shipment method.|string|
|**weight**  <br>*required*|The weight.|[Weight](#weight)|
|**dimensions**  <br>*optional*|Physical dimensional measurements of a container.|[Dimensions](#dimensions)|


<a name="partyidentification"></a>
### PartyIdentification

|Name|Description|Schema|
|---|---|---|
|**partyId**  <br>*required*|Assigned Identification for the party.|string|
|**address**  <br>*optional*|Identification of the party by address.|[Address](#address)|
|**taxRegistrationDetails**  <br>*optional*|Tax registration details of the entity.|< [TaxRegistrationDetails](#taxregistrationdetails) > array|


<a name="shipmentdetails"></a>
### ShipmentDetails
Details about a shipment.


|Name|Description|Schema|
|---|---|---|
|**shippedDate**  <br>*required*|This field indicates the date of the departure of the shipment from vendor's location. Vendors are requested to send ASNs within 30 minutes of departure from their warehouse/distribution center or at least 6 hours prior to the appointment time at the Amazon destination warehouse, whichever is sooner. Shipped date mentioned in the Shipment Confirmation should not be in the future.|string (date-time)|
|**shipmentStatus**  <br>*required*|Indicate the shipment status.|enum ([ShipmentStatus](#shipmentstatus))|
|**isPriorityShipment**  <br>*optional*|Provide the priority of the shipment.|boolean|
|**vendorOrderNumber**  <br>*optional*|The vendor order number is a unique identifier generated by a vendor for their reference.|string|
|**estimatedDeliveryDate**  <br>*optional*|Date on which the shipment is expected to reach the buyer's warehouse. It needs to be an estimate based on the average transit time between the ship-from location and the destination. The exact appointment time will be provided by buyer and is potentially not known when creating the shipment confirmation.|string (date-time)|


<a name="statusupdatedetails"></a>
### StatusUpdateDetails
Details for the shipment status update given by the vendor for the specific package.


|Name|Description|Schema|
|---|---|---|
|**trackingNumber**  <br>*required*|This is required to be provided for every package and should match with the trackingNumber sent for the shipment confirmation.|string|
|**statusCode**  <br>*required*|Indicates the shipment status code of the package that provides transportation information for Amazon tracking systems and ultimately for the final customer.|string|
|**reasonCode**  <br>*required*|Provides a reason code for the status of the package that will provide additional information about the transportation status.|string|
|**statusDateTime**  <br>*required*|The date and time when the shipment status was updated. This field is expected to be in ISO-8601 date/time format, with UTC time zone or UTC offset. For example, 2020-07-16T23:00:00Z or 2020-07-16T23:00:00+01:00.|string (date-time)|
|**statusLocationAddress**  <br>*required*|Address of the party.|[Address](#address)|
|**shipmentSchedule**  <br>*optional*|-|[shipmentSchedule](#statusupdatedetails-shipmentschedule)|

<a name="statusupdatedetails-shipmentschedule"></a>
**shipmentSchedule**

|Name|Description|Schema|
|---|---|---|
|**estimatedDeliveryDateTime**  <br>*optional*|Date on which the shipment is expected to reach the customer delivery location. This field is expected to be in ISO-8601 date/time format, with UTC time zone or UTC offset. For example, 2020-07-16T23:00:00Z or 2020-07-16T23:00:00+01:00.|string (date-time)|
|**apptWindowStartDateTime**  <br>*optional*|This field indicates the date and time at the start of the appointment window scheduled to deliver the shipment. This field is expected to be in ISO-8601 date/time format, with UTC time zone or UTC offset. For example, 2020-07-16T23:00:00Z or 2020-07-16T23:00:00+01:00.|string (date-time)|
|**apptWindowEndDateTime**  <br>*optional*|This field indicates the date and time at the end of the appointment window scheduled to deliver the shipment. This field is expected to be in ISO-8601 date/time format, with UTC time zone or UTC offset. For example, 2020-07-16T23:00:00Z or 2020-07-16T23:00:00+01:00.|string (date-time)|


<a name="taxregistrationdetails"></a>
### TaxRegistrationDetails
Tax registration details of the entity.


|Name|Description|Schema|
|---|---|---|
|**taxRegistrationType**  <br>*optional*|Tax registration type for the entity.|enum ([TaxRegistrationType](#taxregistrationtype))|
|**taxRegistrationNumber**  <br>*required*|Tax registration number for the party. For example, VAT ID.|string|
|**taxRegistrationAddress**  <br>*optional*|Address associated with the tax registration number.|[Address](#address)|
|**taxRegistrationMessages**  <br>*optional*|Tax registration message that can be used for additional tax related details.|string|


<a name="address"></a>
### Address
Address of the party.


|Name|Description|Schema|
|---|---|---|
|**name**  <br>*required*|The name of the person, business or institution at that address.|string|
|**addressLine1**  <br>*required*|First line of the address.|string|
|**addressLine2**  <br>*optional*|Additional street address information, if required.|string|
|**addressLine3**  <br>*optional*|Additional street address information, if required.|string|
|**city**  <br>*optional*|The city where the person, business or institution is located.|string|
|**county**  <br>*optional*|The county where person, business or institution is located.|string|
|**district**  <br>*optional*|The district where person, business or institution is located.|string|
|**stateOrRegion**  <br>*optional*|The state or region where person, business or institution is located.|string|
|**postalCode**  <br>*optional*|The postal code of that address. It contains a series of letters or digits or both, sometimes including spaces or punctuation.|string|
|**countryCode**  <br>*required*|The two digit country code in ISO 3166-1 alpha-2 format.|string|
|**phone**  <br>*optional*|The phone number of the person, business or institution located at that address.|string|


<a name="dimensions"></a>
### Dimensions
Physical dimensional measurements of a container.


|Name|Description|Schema|
|---|---|---|
|**length**  <br>*required*|The length of the container.|[Decimal](#decimal)|
|**width**  <br>*required*|The width of the container.|[Decimal](#decimal)|
|**height**  <br>*required*|The height of the container.|[Decimal](#decimal)|
|**unitOfMeasure**  <br>*required*|The unit of measure for dimensions.|enum ([UnitOfMeasure](#unitofmeasure-subgroup-2))|


<a name="weight"></a>
### Weight
The weight.


|Name|Description|Schema|
|---|---|---|
|**unitOfMeasure**  <br>*required*|The unit of measurement.|enum ([UnitOfMeasure](#unitofmeasure-subgroup-1))|
|**value**  <br>*required*|The measurement value.|[Decimal](#decimal)|


<a name="decimal"></a>
### Decimal
A decimal number with no loss of precision. Useful when precision loss is unacceptable, as with currencies. Follows RFC7159 for number representation.  <br>**Pattern** : `^-?(0|([1-9]\\d*))(\\.\\d+)?([eE][+-]?\\d+)?$`.

*Type* : string


<a name="itemquantity"></a>
### ItemQuantity
Details of item quantity.


|Name|Description|Schema|
|---|---|---|
|**amount**  <br>*required*|Quantity of units shipped for a specific item at a shipment level. If the item is present only in certain packages or pallets within the shipment, please provide this at the appropriate package or pallet level.|integer|
|**unitOfMeasure**  <br>*required*|Unit of measure for the shipped quantity.|string|


<a name="submitshipmentconfirmationsresponse"></a>
### SubmitShipmentConfirmationsResponse
The response schema for the submitShipmentConfirmations operation.


|Name|Description|Schema|
|---|---|---|
|**payload**  <br>*optional*|The response payload for the submitShipmentConfirmations operation.|[TransactionReference](#transactionreference)|
|**errors**  <br>*optional*|A list of error responses returned when a request is unsuccessful.|[ErrorList](#errorlist)|


<a name="submitshipmentstatusupdatesresponse"></a>
### SubmitShipmentStatusUpdatesResponse
The response schema for the submitShipmentStatusUpdates operation.


|Name|Description|Schema|
|---|---|---|
|**payload**  <br>*optional*|The response payload for the submitShipmentStatusUpdates operation.|[TransactionReference](#transactionreference)|
|**errors**  <br>*optional*|A list of error responses returned when a request is unsuccessful.|[ErrorList](#errorlist)|


<a name="getshippinglabellistresponse"></a>
### GetShippingLabelListResponse
The response schema for the getShippingLabels operation.


|Name|Description|Schema|
|---|---|---|
|**payload**  <br>*optional*|List of ship labels.|[ShippingLabelList](#shippinglabellist)|
|**errors**  <br>*optional*|A list of error responses returned when a request is unsuccessful.|[ErrorList](#errorlist)|


<a name="getshippinglabelresponse"></a>
### GetShippingLabelResponse
The response schema for the getShippingLabel operation.


|Name|Description|Schema|
|---|---|---|
|**payload**  <br>*optional*|The payload for the getShippingLabel operation.|[ShippingLabel](#shippinglabel)|
|**errors**  <br>*optional*|A list of error responses returned when a request is unsuccessful.|[ErrorList](#errorlist)|


<a name="shippinglabellist"></a>
### ShippingLabelList

|Name|Schema|
|---|---|
|**pagination**  <br>*optional*|[Pagination](#pagination)|
|**shippingLabels**  <br>*optional*|< [ShippingLabel](#shippinglabel) > array|


<a name="labeldata"></a>
### LabelData
Details of the shipment label.


|Name|Description|Schema|
|---|---|---|
|**packageIdentifier**  <br>*optional*|Identifier for the package. The first package will be 001, the second 002, and so on. This number is used as a reference to refer to this package from the pallet level.|string|
|**trackingNumber**  <br>*optional*|Package tracking identifier from the shipping carrier.|string|
|**shipMethod**  <br>*optional*|Ship method to be used for shipping the order. Amazon defines Ship Method Codes indicating shipping carrier and shipment service level. Ship Method Codes are case and format sensitive. The same ship method code should returned on the shipment confirmation. Note that the Ship Method Codes are vendor specific and will be provided to each vendor during the implementation.|string|
|**shipMethodName**  <br>*optional*|Shipping method name for internal reference.|string|
|**content**  <br>*required*|This field will contain the Base64encoded string of the shipment label content.|string|


<a name="shippinglabel"></a>
### ShippingLabel

|Name|Description|Schema|
|---|---|---|
|**purchaseOrderNumber**  <br>*required*|This field will contain the Purchase Order Number for this order.  <br>**Pattern** : `"^[a-zA-Z0-9]+$"`|string|
|**sellingParty**  <br>*required*|ID of the selling party or vendor.|[PartyIdentification](#partyidentification)|
|**shipFromParty**  <br>*required*|Warehouse code of vendor.|[PartyIdentification](#partyidentification)|
|**labelFormat**  <br>*required*|Format of the label.|enum ([LabelFormat](#labelformat))|
|**labelData**  <br>*required*|Provides the details of the packages in this shipment.|< [LabelData](#labeldata) > array|


<a name="submitshippinglabelsresponse"></a>
### SubmitShippingLabelsResponse
The response schema for the submitShippingLabelRequest operation.


|Name|Description|Schema|
|---|---|---|
|**payload**  <br>*optional*|The response payload for the submitShippingLabelRequest operation.|[TransactionReference](#transactionreference)|
|**errors**  <br>*optional*|A list of error responses returned when a request is unsuccessful.|[ErrorList](#errorlist)|


<a name="submitshipmentconfirmationsrequest"></a>
### SubmitShipmentConfirmationsRequest

|Name|Schema|
|---|---|
|**shipmentConfirmations**  <br>*optional*|< [ShipmentConfirmation](#shipmentconfirmation) > array|


<a name="shipmentconfirmation"></a>
### ShipmentConfirmation

|Name|Description|Schema|
|---|---|---|
|**purchaseOrderNumber**  <br>*required*|Purchase order number corresponding to the shipment.  <br>**Pattern** : `"^[a-zA-Z0-9]+$"`|string|
|**shipmentDetails**  <br>*required*|Shipment information.|[ShipmentDetails](#shipmentdetails)|
|**sellingParty**  <br>*required*|ID of the selling party or vendor.|[PartyIdentification](#partyidentification)|
|**shipFromParty**  <br>*required*|Warehouse code of vendor.|[PartyIdentification](#partyidentification)|
|**items**  <br>*required*|Provide the details of the items in this shipment. If any of the item details field is common at a package or a pallet level, then provide them at the corresponding package.|< [Item](#item) > array|
|**containers**  <br>*optional*|Provide the details of the items in this shipment. If any of the item details field is common at a package or a pallet level, then provide them at the corresponding package.|< [Container](#container) > array|


<a name="submitshipmentstatusupdatesrequest"></a>
### SubmitShipmentStatusUpdatesRequest

|Name|Schema|
|---|---|
|**shipmentStatusUpdates**  <br>*optional*|< [ShipmentStatusUpdate](#shipmentstatusupdate) > array|


<a name="shipmentstatusupdate"></a>
### ShipmentStatusUpdate

|Name|Description|Schema|
|---|---|---|
|**purchaseOrderNumber**  <br>*required*|Purchase order number of the shipment for which to update the shipment status.  <br>**Pattern** : `"^[a-zA-Z0-9]+$"`|string|
|**sellingParty**  <br>*required*|ID of the selling party or vendor.|[PartyIdentification](#partyidentification)|
|**shipFromParty**  <br>*required*|Warehouse code of vendor.|[PartyIdentification](#partyidentification)|
|**statusUpdateDetails**  <br>*required*|Provide the details about the status of the shipment at that particular point of time.|[StatusUpdateDetails](#statusupdatedetails)|


<a name="getcustomerinvoicesresponse"></a>
### GetCustomerInvoicesResponse
The response schema for the getCustomerInvoices operation.


|Name|Description|Schema|
|---|---|---|
|**payload**  <br>*optional*|List of customer invoices.|[CustomerInvoiceList](#customerinvoicelist)|
|**errors**  <br>*optional*|A list of error responses returned when a request is unsuccessful.|[ErrorList](#errorlist)|


<a name="getcustomerinvoiceresponse"></a>
### GetCustomerInvoiceResponse
The response schema for the getCustomerInvoice operation.


|Name|Description|Schema|
|---|---|---|
|**payload**  <br>*optional*|The payload for the getCustomerInvoice operation.|[CustomerInvoice](#customerinvoice)|
|**errors**  <br>*optional*|A list of error responses returned when a request is unsuccessful.|[ErrorList](#errorlist)|


<a name="customerinvoicelist"></a>
### CustomerInvoiceList

|Name|Schema|
|---|---|
|**pagination**  <br>*optional*|[Pagination](#pagination)|
|**customerInvoices**  <br>*optional*|< [CustomerInvoice](#customerinvoice) > array|


<a name="pagination"></a>
### Pagination

|Name|Description|Schema|
|---|---|---|
|**nextToken**  <br>*optional*|A generated string used to pass information to your next request. If NextToken is returned, pass the value of NextToken to the next request. If NextToken is not returned, there are no more order items to return.|string|


<a name="customerinvoice"></a>
### CustomerInvoice

|Name|Description|Schema|
|---|---|---|
|**purchaseOrderNumber**  <br>*required*|The purchase order number for this order.  <br>**Pattern** : `"^[a-zA-Z0-9]+$"`|string|
|**content**  <br>*required*|The Base64encoded customer invoice.|string|


<a name="transactionreference"></a>
### TransactionReference

|Name|Description|Schema|
|---|---|---|
|**transactionId**  <br>*optional*|GUID to identify this transaction. This value can be used with the Transaction Status API to return the status of this transaction.|string|


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


<a name="container"></a>
### Container

|Name|Description|Schema|
|---|---|---|
|**containerType**  <br>*required*|The type of container.|enum ([ContainerType](#containertype))|
|**containerIdentifier**  <br>*required*|The container identifier.|string|
|**trackingNumber**  <br>*optional*|The tracking number.|string|
|**manifestId**  <br>*optional*|The manifest identifier.|string|
|**manifestDate**  <br>*optional*|The date of the manifest.|string|
|**shipMethod**  <br>*optional*|The shipment method.|string|
|**scacCode**  <br>*optional*|SCAC code required for NA VOC vendors only.|string|
|**carrier**  <br>*optional*|Carrier required for EU VOC vendors only.|string|
|**containerSequenceNumber**  <br>*optional*|An integer that must be submitted for multi-box shipments only, where one item may come in separate packages.|integer|
|**dimensions**  <br>*optional*|Physical dimensional measurements of a container.|[Dimensions](#dimensions)|
|**weight**  <br>*optional*|The weight.|[Weight](#weight)|
|**packedItems**  <br>*required*|A list of packed items.|< [PackedItem](#packeditem) > array|


<a name="labelformat"></a>
### LabelFormat
Format of the label.

*Type* : enum


|Value|Description|
|---|---|
|**PNG**|Portable Network Graphics (png) format.|
|**ZPL**|Zebra Programming Language (zpl) format.|


<a name="contenttype"></a>
### ContentType
The format of the file such as PDF, JPEG etc.

*Type* : enum


|Value|Description|
|---|---|
|**application/pdf**|Portable Document Format (pdf).|


<a name="shipmentstatus"></a>
### ShipmentStatus
Indicate the shipment status.

*Type* : enum


|Value|Description|
|---|---|
|**SHIPPED**|Orders that have left the warehouse have shipped status.|
|**FLOOR_DENIAL**|Status for orders rejected due to quality issues with products on the floor, or the physical and virtual inventory do not match.|


<a name="taxregistrationtype"></a>
### TaxRegistrationType
Tax registration type for the entity.

*Type* : enum


|Value|Description|
|---|---|
|**VAT**|Value-added tax.|
|**GST**|Goods and Services Tax (GST).|


<a name="containertype"></a>
### ContainerType
The type of container.

*Type* : enum


|Value|Description|
|---|---|
|**carton**|Packing container type. Typically used for drinks or food.|
|**pallet**|A flat transport structure which supports goods in a stable fashion while being lifted by a forklift.|


<a name="unitofmeasure"></a>
### UnitOfMeasure
*Type* : enum

<a id="unitofmeasure-subgroup-1"></a>**For use with the definition(s): [Weight](#weight)**
The unit of measurement.

|Value|Description|
|---|---|
|**KG**|Kilogram|
|**LB**|Pounds (Libra for Latin).|

<a id="unitofmeasure-subgroup-2"></a>**For use with the definition(s): [Dimensions](#dimensions)**
The unit of measure for dimensions.

|Value|Description|
|---|---|
|**IN**|Inches|
|**CM**|Centimeters|


<a name="sortorder"></a>
### SortOrder
*Type* : enum

<a id="sortorder-subgroup-1"></a>**For use with the operation(s): [getPackingSlips](#getpackingslips)**
Sort ASC or DESC by packing slip creation date.

|Value|Description|
|---|---|
|**ASC**|Sort in ascending order by packing slip creation date.|
|**DESC**|Sort in descending order by packing slip creation date.|

<a id="sortorder-subgroup-2"></a>**For use with the operation(s): [getShippingLabels](#getshippinglabels), [getCustomerInvoices](#getcustomerinvoices)**
Sort ASC or DESC by order creation date.

|Value|Description|
|---|---|
|**ASC**|Sort in ascending order by order creation date.|
|**DESC**|Sort in descending order by order creation date.|

