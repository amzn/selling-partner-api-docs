# Selling Partner API for Retail Procurement Orders


<a name="overview"></a>
## Overview
The Selling Partner API for Retail Procurement Orders provides programmatic access to vendor orders data.


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
[getPurchaseOrders](#getpurchaseorders)<br>[getPurchaseOrder](#getpurchaseorder)<br>[submitAcknowledgement](#submitacknowledgement)<br>[getPurchaseOrdersStatus](#getpurchaseordersstatus)<br>
<a name="paths"></a>
## Paths

<a name="getpurchaseorders"></a>
### GET /vendor/orders/v1/purchaseOrders
**Operation: getPurchaseOrders**

#### Description
Returns a list of purchase orders created or changed during the time frame that you specify. You define the time frame using the createdAfter, createdBefore, changedAfter and changedBefore parameters. The date range to search must not be more than 7 days. You can choose to get only the purchase order numbers by setting includeDetails to false. You can then use the getPurchaseOrder operation to receive details for a specific purchase order.

**Usage Plans:**

| Plan type | Rate (requests per second) | Burst |
| ---- | ---- | ---- |
|Default| 10 | 10 |
|Selling partner specific| Variable | Variable |

The x-amzn-RateLimit-Limit response header returns the usage plan rate limits that were applied to the requested operation. Rate limits for some selling partners will vary from the default rate and burst shown in the table above. For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Query**|**limit**  <br>*optional*|The limit to the number of records returned. Default value is 100 records.<br>**Minimum** : 1<br>**Maximum** : 100|integer (int64)|
|**Query**|**createdAfter**  <br>*optional*|Purchase orders that became available after this time will be included in the result. Must be in ISO-8601 date/time format.|string (date-time)|
|**Query**|**createdBefore**  <br>*optional*|Purchase orders that became available before this time will be included in the result. Must be in ISO-8601 date/time format.|string (date-time)|
|**Query**|**sortOrder**  <br>*optional*|Sort in ascending or descending order by purchase order creation date.|enum ([SortOrder](#sortorder))|
|**Query**|**nextToken**  <br>*optional*|Used for pagination when there is more purchase orders than the specified result size limit. The token value is returned in the previous API call|string|
|**Query**|**includeDetails**  <br>*optional*|When true, returns purchase orders with complete details. Otherwise, only purchase order numbers are returned. Default value is true.|string (boolean)|
|**Query**|**changedAfter**  <br>*optional*|Purchase orders that changed after this timestamp will be included in the result. Must be in ISO-8601 date/time format.|string (date-time)|
|**Query**|**changedBefore**  <br>*optional*|Purchase orders that changed before this timestamp will be included in the result. Must be in ISO-8601 date/time format.|string (date-time)|
|**Query**|**poItemState**  <br>*optional*|Current state of the purchase order item. If this value is Cancelled, this API will return purchase orders which have one or more items cancelled by Amazon with updated item quantity as zero.|enum ([PoItemState](#poitemstate))|
|**Query**|**isPOChanged**  <br>*optional*|When true, returns purchase orders which were modified after the order was placed. Vendors are required to pull the changed purchase order and fulfill the updated purchase order and not the original one. Default value is false.|string (boolean)|
|**Query**|**purchaseOrderState**  <br>*optional*|Filters purchase orders based on the purchase order state.|enum ([PurchaseOrderState](#purchaseorderstate-subgroup-1))|
|**Query**|**orderingVendorCode**  <br>*optional*|Filters purchase orders based on the specified ordering vendor code. This value should be same as 'sellingParty.partyId' in the purchase order. If not included in the filter, all purchase orders for all of the vendor codes that exist in the vendor group used to authorize the API client application are returned.|string|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Success.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetPurchaseOrdersResponse](#getpurchaseordersresponse)|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetPurchaseOrdersResponse](#getpurchaseordersresponse)|
|**403**|Indicates that access to the resource is forbidden. Possible reasons include Access Denied, Unauthorized, Expired Token, or Invalid Signature.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetPurchaseOrdersResponse](#getpurchaseordersresponse)|
|**404**|The resource specified does not exist.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetPurchaseOrdersResponse](#getpurchaseordersresponse)|
|**415**|The request payload is in an unsupported format.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetPurchaseOrdersResponse](#getpurchaseordersresponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetPurchaseOrdersResponse](#getpurchaseordersresponse)|
|**500**|An unexpected condition occurred that prevented the server from fulfilling the request.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetPurchaseOrdersResponse](#getpurchaseordersresponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetPurchaseOrdersResponse](#getpurchaseordersresponse)|

For additional error status codes, descriptions and schemas, see [Error responses and schemas](#error-responses-and-schemas).
<a name="getpurchaseorder"></a>
### GET /vendor/orders/v1/purchaseOrders/{purchaseOrderNumber}
**Operation: getPurchaseOrder**

#### Description
Returns a purchase order based on the purchaseOrderNumber value that you specify.

**Usage Plans:**

| Plan type | Rate (requests per second) | Burst |
| ---- | ---- | ---- |
|Default| 10 | 10 |
|Selling partner specific| Variable | Variable |

The x-amzn-RateLimit-Limit response header returns the usage plan rate limits that were applied to the requested operation. Rate limits for some selling partners will vary from the default rate and burst shown in the table above. For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**purchaseOrderNumber**  <br>*required*|The purchase order identifier for the order that you want. Formatting Notes: 8-character alpha-numeric code.|string|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Success.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetPurchaseOrderResponse](#getpurchaseorderresponse)|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetPurchaseOrderResponse](#getpurchaseorderresponse)|
|**403**|Indicates that access to the resource is forbidden. Possible reasons include Access Denied, Unauthorized, Expired Token, or Invalid Signature.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetPurchaseOrderResponse](#getpurchaseorderresponse)|
|**404**|The resource specified does not exist.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetPurchaseOrderResponse](#getpurchaseorderresponse)|
|**415**|The request payload is in an unsupported format.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetPurchaseOrderResponse](#getpurchaseorderresponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetPurchaseOrderResponse](#getpurchaseorderresponse)|
|**500**|An unexpected condition occurred that prevented the server from fulfilling the request.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetPurchaseOrderResponse](#getpurchaseorderresponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetPurchaseOrderResponse](#getpurchaseorderresponse)|

For additional error status codes, descriptions and schemas, see [Error responses and schemas](#error-responses-and-schemas).
<a name="submitacknowledgement"></a>
### POST /vendor/orders/v1/acknowledgements
**Operation: submitAcknowledgement**

#### Description
Submits acknowledgements for one or more purchase orders.

**Usage Plans:**

| Plan type | Rate (requests per second) | Burst |
| ---- | ---- | ---- |
|Default| 10 | 10 |
|Selling partner specific| Variable | Variable |

The x-amzn-RateLimit-Limit response header returns the usage plan rate limits that were applied to the requested operation. Rate limits for some selling partners will vary from the default rate and burst shown in the table above. For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Body**|**body**  <br>*required*|The request schema for the submitAcknowledgment operation.|[SubmitAcknowledgementRequest](#submitacknowledgementrequest)|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**202**|Success.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[SubmitAcknowledgementResponse](#submitacknowledgementresponse)|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[SubmitAcknowledgementResponse](#submitacknowledgementresponse)|
|**403**|Indicates that access to the resource is forbidden. Possible reasons include Access Denied, Unauthorized, Expired Token, or Invalid Signature.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[SubmitAcknowledgementResponse](#submitacknowledgementresponse)|
|**404**|The resource specified does not exist.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[SubmitAcknowledgementResponse](#submitacknowledgementresponse)|
|**415**|The request payload is in an unsupported format.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[SubmitAcknowledgementResponse](#submitacknowledgementresponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[SubmitAcknowledgementResponse](#submitacknowledgementresponse)|
|**500**|An unexpected condition occurred that prevented the server from fulfilling the request.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[SubmitAcknowledgementResponse](#submitacknowledgementresponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[SubmitAcknowledgementResponse](#submitacknowledgementresponse)|

For additional error status codes, descriptions and schemas, see [Error responses and schemas](#error-responses-and-schemas).
<a name="getpurchaseordersstatus"></a>
### GET /vendor/orders/v1/purchaseOrdersStatus
**Operation: getPurchaseOrdersStatus**

#### Description
Returns purchase order statuses based on the filters that you specify. Date range to search must not be more than 7 days. You can return a list of purchase order statuses using the available filters, or a single purchase order status by providing the purchase order number.

**Usage Plans:**

| Plan type | Rate (requests per second) | Burst |
| ---- | ---- | ---- |
|Default| 10 | 10 |
|Selling partner specific| Variable | Variable |

The x-amzn-RateLimit-Limit response header returns the usage plan rate limits that were applied to the requested operation. Rate limits for some selling partners will vary from the default rate and burst shown in the table above. For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Query**|**limit**  <br>*optional*|The limit to the number of records returned. Default value is 100 records.<br>**Minimum** : 1<br>**Maximum** : 100|integer (int64)|
|**Query**|**sortOrder**  <br>*optional*|Sort in ascending or descending order by purchase order creation date.|enum ([SortOrder](#sortorder))|
|**Query**|**nextToken**  <br>*optional*|Used for pagination when there are more purchase orders than the specified result size limit.|string|
|**Query**|**createdAfter**  <br>*optional*|Purchase orders that became available after this timestamp will be included in the result. Must be in ISO-8601 date/time format.|string (date-time)|
|**Query**|**createdBefore**  <br>*optional*|Purchase orders that became available before this timestamp will be included in the result. Must be in ISO-8601 date/time format.|string (date-time)|
|**Query**|**updatedAfter**  <br>*optional*|Purchase orders for which the last purchase order update happened after this timestamp will be included in the result. Must be in ISO-8601 date/time format.|string (date-time)|
|**Query**|**updatedBefore**  <br>*optional*|Purchase orders for which the last purchase order update happened before this timestamp will be included in the result. Must be in ISO-8601 date/time format.|string (date-time)|
|**Query**|**purchaseOrderNumber**  <br>*optional*|Provides purchase order status for the specified purchase order number.|string|
|**Query**|**purchaseOrderStatus**  <br>*optional*|Filters purchase orders based on the specified purchase order status. If not included in filter, this will return purchase orders for all statuses.|enum ([PurchaseOrderStatus](#purchaseorderstatus-subgroup-2))|
|**Query**|**itemConfirmationStatus**  <br>*optional*|Filters purchase orders based on their item confirmation status. If the item confirmation status is not included in the filter, purchase orders for all confirmation statuses are included.|enum ([ItemConfirmationStatus](#itemconfirmationstatus))|
|**Query**|**itemReceiveStatus**  <br>*optional*|Filters purchase orders based on the purchase order's item receive status. If the item receive status is not included in the filter, purchase orders for all receive statuses are included.|enum ([ItemReceiveStatus](#itemreceivestatus))|
|**Query**|**orderingVendorCode**  <br>*optional*|Filters purchase orders based on the specified ordering vendor code. This value should be same as 'sellingParty.partyId' in the purchase order. If not included in filter, all purchase orders for all the vendor codes that exist in the vendor group used to authorize API client application are returned.|string|
|**Query**|**shipToPartyId**  <br>*optional*|Filters purchase orders for a specific buyer's Fulfillment Center/warehouse by providing ship to location id here. This value should be same as 'shipToParty.partyId' in the purchase order. If not included in filter, this will return purchase orders for all the buyer's warehouses used for vendor group purchase orders.|string|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Success.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetPurchaseOrdersStatusResponse](#getpurchaseordersstatusresponse)|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetPurchaseOrdersStatusResponse](#getpurchaseordersstatusresponse)|
|**403**|Indicates that access to the resource is forbidden. Possible reasons include Access Denied, Unauthorized, Expired Token, or Invalid Signature.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetPurchaseOrdersStatusResponse](#getpurchaseordersstatusresponse)|
|**404**|The resource specified does not exist.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetPurchaseOrdersStatusResponse](#getpurchaseordersstatusresponse)|
|**415**|The request payload is in an unsupported format.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetPurchaseOrdersStatusResponse](#getpurchaseordersstatusresponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetPurchaseOrdersStatusResponse](#getpurchaseordersstatusresponse)|
|**500**|An unexpected condition occurred that prevented the server from fulfilling the request.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetPurchaseOrdersStatusResponse](#getpurchaseordersstatusresponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetPurchaseOrdersStatusResponse](#getpurchaseordersstatusresponse)|

For additional error status codes, descriptions and schemas, see [Error responses and schemas](#error-responses-and-schemas).



<a name="error-responses-and-schemas"></a>
### Error Responses and Schemas
This table contains HTTP status codes and associated information for error responses.

|HTTP Code|Description|Schema|
|---|---|---|
|**401**|The request's Authorization header is not formatted correctly or does not contain a valid token.  <br>**Headers**:  <br>`x-amzn-RateLimit-Limit` (string):Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string):Unique request reference identifier.|[GetPurchaseOrderResponse](#getpurchaseorderresponse)|
|**413**|The request size exceeded the maximum accepted size.  <br>**Headers**:  <br>`x-amzn-RateLimit-Limit` (string):Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string):Unique request reference identifier.|[SubmitAcknowledgementResponse](#submitacknowledgementresponse)|


<a name="definitions"></a>
## Definitions

<a name="getpurchaseordersresponse"></a>
### GetPurchaseOrdersResponse
The response schema for the getPurchaseOrders operation.


|Name|Description|Schema|
|---|---|---|
|**payload**  <br>*optional*|A list of orders.|[OrderList](#orderlist)|
|**errors**  <br>*optional*|A list of error responses returned when a request is unsuccessful.|[ErrorList](#errorlist)|


<a name="getpurchaseorderresponse"></a>
### GetPurchaseOrderResponse
The response schema for the getPurchaseOrder operation.


|Name|Description|Schema|
|---|---|---|
|**payload**  <br>*optional*|The details of the requested order|[Order](#order)|
|**errors**  <br>*optional*|A list of error responses returned when a request is unsuccessful.|[ErrorList](#errorlist)|


<a name="orderlist"></a>
### OrderList

|Name|Schema|
|---|---|
|**pagination**  <br>*optional*|[Pagination](#pagination)|
|**orders**  <br>*optional*|< [Order](#order) > array|


<a name="pagination"></a>
### Pagination

|Name|Description|Schema|
|---|---|---|
|**nextToken**  <br>*optional*|A generated string used to pass information to your next request. If NextToken is returned, pass the value of NextToken to the next request. If NextToken is not returned, there are no more purchase order items to return.|string|


<a name="order"></a>
### Order

|Name|Description|Schema|
|---|---|---|
|**purchaseOrderNumber**  <br>*required*|The purchase order number for this order. Formatting Notes: 8-character alpha-numeric code.|string|
|**purchaseOrderState**  <br>*required*|This field will contain the current state of the purchase order.|enum ([PurchaseOrderState](#purchaseorderstate-subgroup-2))|
|**orderDetails**  <br>*optional*|Details of an order.|[OrderDetails](#orderdetails)|


<a name="orderdetails"></a>
### OrderDetails
Details of an order.


|Name|Description|Schema|
|---|---|---|
|**purchaseOrderDate**  <br>*required*|The date the purchase order was placed. Must be in ISO-8601 date/time format.|string (date-time)|
|**purchaseOrderChangedDate**  <br>*optional*|The date when purchase order was last changed by Amazon after the order was placed. This date will be greater than 'purchaseOrderDate'. This means the PO data was changed on that date and vendors are required to fulfill the  updated PO. The PO changes can be related to Item Quantity, Ship to Location, Ship Window etc. This field will not be present in orders that have not changed after creation. Must be in ISO-8601 date/time format.|string (date-time)|
|**purchaseOrderStateChangedDate**  <br>*required*|The date when current purchase order state was changed. Current purchase order state is available in the field 'purchaseOrderState'. Must be in ISO-8601 date/time format.|string (date-time)|
|**purchaseOrderType**  <br>*optional*|Type of purchase order.|enum ([PurchaseOrderType](#purchaseordertype))|
|**importDetails**  <br>*optional*|If the purchase order is an import order, the details for the import order.|[ImportDetails](#importdetails)|
|**dealCode**  <br>*optional*|If requested by the recipient, this field will contain a promotional/deal number. The discount code line is optional. It is used to obtain a price discount on items on the order.|string|
|**paymentMethod**  <br>*optional*|Payment method used.|enum ([PaymentMethod](#paymentmethod))|
|**buyingParty**  <br>*optional*|Name/Address and tax details of the buying party.|[PartyIdentification](#partyidentification)|
|**sellingParty**  <br>*optional*|Name/Address and tax details of the selling party.|[PartyIdentification](#partyidentification)|
|**shipToParty**  <br>*optional*|Name/Address and tax details of the ship to party.|[PartyIdentification](#partyidentification)|
|**billToParty**  <br>*optional*|Name/Address and tax details of the bill to party.|[PartyIdentification](#partyidentification)|
|**shipWindow**  <br>*optional*|This indicates the ship window. Format is start and end date separated by double hyphen (--). For example, 2007-03-01T13:00:00Z--2007-03-11T15:30:00Z.|[DateTimeInterval](#datetimeinterval)|
|**deliveryWindow**  <br>*optional*|This indicates the delivery window. Format is start and end date separated by double hyphen (--). For example, 2007-03-01T13:00:00Z--2007-03-11T15:30:00Z.|[DateTimeInterval](#datetimeinterval)|
|**items**  <br>*required*|A list of items in this purchase order.|< [OrderItem](#orderitem) > array|


<a name="importdetails"></a>
### ImportDetails
Import details for an import order.


|Name|Description|Schema|
|---|---|---|
|**methodOfPayment**  <br>*optional*|If the recipient requests, contains the shipment method of payment. This is for import PO's only.|enum ([MethodOfPayment](#methodofpayment))|
|**internationalCommercialTerms**  <br>*optional*|Incoterms (International Commercial Terms) are used to divide transaction costs and responsibilities between buyer and seller and reflect state-of-the-art transportation practices. This is for import purchase orders only.|enum ([InternationalCommercialTerms](#internationalcommercialterms))|
|**portOfDelivery**  <br>*optional*|The port where goods on an import purchase order must be delivered by the vendor. This should only be specified when the internationalCommercialTerms is FOB.<br>**maxLength** : 64|string|
|**importContainers**  <br>*optional*|Types and numbers of container(s) for import purchase orders. Can be a comma-separated list if the shipment has multiple containers. HC signifies a high-capacity container. Free-text field, limited to 64 characters. The format will be a comma-delimited list containing values of the type: $NUMBER_OF_CONTAINERS_OF_THIS_TYPE-$CONTAINER_TYPE. The list of values for the container type is: 40'(40-foot container), 40'HC (40-foot high-capacity container), 45', 45'HC, 30', 30'HC, 20', 20'HC.<br>**maxLength** : 64|string|
|**shippingInstructions**  <br>*optional*|Special instructions regarding the shipment. This field is for import purchase orders.|string|


<a name="datetimeinterval"></a>
### DateTimeInterval
Defines a date time interval according to ISO8601. Interval is separated by double hyphen (--).

*Type* : string


<a name="partyidentification"></a>
### PartyIdentification

|Name|Description|Schema|
|---|---|---|
|**partyId**  <br>*required*|Assigned identification for the party. For example, warehouse code or vendor code. Please refer to specific party for more details.|string|
|**address**  <br>*optional*|Identification of the party by address.|[Address](#address)|
|**taxInfo**  <br>*optional*|Tax registration details of the party.|[TaxRegistrationDetails](#taxregistrationdetails)|


<a name="taxregistrationdetails"></a>
### TaxRegistrationDetails
Tax registration details of the entity.


|Name|Description|Schema|
|---|---|---|
|**taxRegistrationType**  <br>*required*|Tax registration type for the entity.|enum ([TaxRegistrationType](#taxregistrationtype))|
|**taxRegistrationNumber**  <br>*required*|Tax registration number for the entity. For example, VAT ID.|string|


<a name="address"></a>
### Address
Address of the party.


|Name|Description|Schema|
|---|---|---|
|**name**  <br>*required*|The name of the person, business or institution at that address.|string|
|**addressLine1**  <br>*required*|First line of the address.|string|
|**addressLine2**  <br>*optional*|Additional address information, if required.|string|
|**addressLine3**  <br>*optional*|Additional address information, if required.|string|
|**city**  <br>*optional*|The city where the person, business or institution is located.|string|
|**county**  <br>*optional*|The county where person, business or institution is located.|string|
|**district**  <br>*optional*|The district where person, business or institution is located.|string|
|**stateOrRegion**  <br>*optional*|The state or region where person, business or institution is located.|string|
|**postalCode**  <br>*optional*|The postal code of that address. It conatins a series of letters or digits or both, sometimes including spaces or punctuation.|string|
|**countryCode**  <br>*required*|The two digit country code. In ISO 3166-1 alpha-2 format.<br>**maxLength** : 2|string|
|**phone**  <br>*optional*|The phone number of the person, business or institution located at that address.|string|


<a name="orderitem"></a>
### OrderItem

|Name|Description|Schema|
|---|---|---|
|**itemSequenceNumber**  <br>*required*|Numbering of the item on the purchase order. The first item will be 1, the second 2, and so on.|string|
|**amazonProductIdentifier**  <br>*optional*|Amazon Standard Identification Number (ASIN) of an item.|string|
|**vendorProductIdentifier**  <br>*optional*|The vendor selected product identification of the item.|string|
|**orderedQuantity**  <br>*required*|Item quantity ordered.|[ItemQuantity](#itemquantity)|
|**isBackOrderAllowed**  <br>*required*|When true, we will accept backorder confirmations for this item.|boolean|
|**netCost**  <br>*optional*|The price to Amazon each (cost).|[Money](#money)|
|**listPrice**  <br>*optional*|The price to Amazon each (list).|[Money](#money)|


<a name="money"></a>
### Money
An amount of money, including units in the form of currency.


|Name|Description|Schema|
|---|---|---|
|**currencyCode**  <br>*optional*|Three digit currency code in ISO 4217 format. String of length 3.<br>**maxLength** : 3|string|
|**amount**  <br>*optional*|A decimal number with no loss of precision. Useful when precision loss is unacceptable, as with currencies. Follows RFC7159 for number representation. <br>**Pattern** : `^-?(0\|([1-9]\d*))(\.\d+)?([eE][+-]?\d+)?$`.|[Decimal](#decimal)|


<a name="decimal"></a>
### Decimal
A decimal number with no loss of precision. Useful when precision loss is unacceptable, as with currencies. Follows RFC7159 for number representation. <br>**Pattern** : `^-?(0|([1-9]\d*))(\.\d+)?([eE][+-]?\d+)?$`.

*Type* : string


<a name="submitacknowledgementresponse"></a>
### SubmitAcknowledgementResponse
The response schema for the submitAcknowledgement operation


|Name|Description|Schema|
|---|---|---|
|**payload**  <br>*optional*|The payload for the submitAcknowledgement operation.|[TransactionId](#transactionid)|
|**errors**  <br>*optional*|A list of error responses returned when a request is unsuccessful.|[ErrorList](#errorlist)|


<a name="transactionid"></a>
### TransactionId

|Name|Description|Schema|
|---|---|---|
|**transactionId**  <br>*optional*|GUID assigned by Amazon to identify this transaction. This value can be used with the Transaction Status API to return the status of this transaction.|string|


<a name="errorlist"></a>
### ErrorList
A list of error responses returned when a request is unsuccessful.

*Type* : < [Error](#error) > array


<a name="submitacknowledgementrequest"></a>
### SubmitAcknowledgementRequest
The request schema for the submitAcknowledgment operation.


|Name|Schema|
|---|---|
|**acknowledgements**  <br>*optional*|< [OrderAcknowledgement](#orderacknowledgement) > array|


<a name="orderacknowledgement"></a>
### OrderAcknowledgement

|Name|Description|Schema|
|---|---|---|
|**purchaseOrderNumber**  <br>*required*|The purchase order number. Formatting Notes: 8-character alpha-numeric code.|string|
|**sellingParty**  <br>*required*|Name, address and tax details of the party receiving a shipment of products.|[PartyIdentification](#partyidentification)|
|**acknowledgementDate**  <br>*required*|The date and time when the purchase order is acknowledged, in ISO-8601 date/time format.|string (date-time)|
|**items**  <br>*required*|A list of the items being acknowledged with associated details.|< [OrderAcknowledgementItem](#orderacknowledgementitem) > array|


<a name="orderacknowledgementitem"></a>
### OrderAcknowledgementItem
Details of the item being acknowledged.


|Name|Description|Schema|
|---|---|---|
|**itemSequenceNumber**  <br>*optional*|Line item sequence number for the item.|string|
|**amazonProductIdentifier**  <br>*optional*|Amazon Standard Identification Number (ASIN) of an item.|string|
|**vendorProductIdentifier**  <br>*optional*|The vendor selected product identification of the item. Should be the same as was sent in the purchase order.|string|
|**orderedQuantity**  <br>*required*|The quantity of this item ordered.|[ItemQuantity](#itemquantity)|
|**netCost**  <br>*optional*|The cost to Amazon, which should match the cost on the invoice. This is a required field. If this is left blank the file will reject in Amazon systems. Price information should not be zero or negative. Indicates a net unit price.|[Money](#money)|
|**listPrice**  <br>*optional*|The list price. This is required only if a vendor sells books with a list price.|[Money](#money)|
|**discountMultiplier**  <br>*optional*|The discount multiplier that should be applied to the price if a vendor sells books with a list price. This is a multiplier factor to arrive at a final discounted price. A multiplier of .90 would be the factor if a 10% discount is given.|string|
|**itemAcknowledgements**  <br>*required*|This is used to indicate acknowledged quantity.|< [OrderItemAcknowledgement](#orderitemacknowledgement) > array|


<a name="orderitemacknowledgement"></a>
### OrderItemAcknowledgement

|Name|Description|Schema|
|---|---|---|
|**acknowledgementCode**  <br>*required*|This indicates the acknowledgement code.|enum ([AcknowledgementCode](#acknowledgementcode))|
|**acknowledgedQuantity**  <br>*required*|Details of quantity acknowledged with the above acknowledgement code.|[ItemQuantity](#itemquantity)|
|**scheduledShipDate**  <br>*optional*|Estimated ship date per line item. Must be in ISO-8601 date/time format.|string (date-time)|
|**scheduledDeliveryDate**  <br>*optional*|Estimated delivery date per line item. Must be in ISO-8601 date/time format.|string (date-time)|
|**rejectionReason**  <br>*optional*|Indicates the reason for rejection.|enum ([RejectionReason](#rejectionreason))|


<a name="itemquantity"></a>
### ItemQuantity
Details of quantity ordered.


|Name|Description|Schema|
|---|---|---|
|**amount**  <br>*optional*|Acknowledged quantity. This value should not be zero.|integer|
|**unitOfMeasure**  <br>*optional*|Unit of measure for the acknowledged quantity.|enum ([UnitOfMeasure](#unitofmeasure))|
|**unitSize**  <br>*optional*|The case size, in the event that we ordered using cases.|integer|


<a name="getpurchaseordersstatusresponse"></a>
### GetPurchaseOrdersStatusResponse
The response schema for the getPurchaseOrdersStatus operation.


|Name|Description|Schema|
|---|---|---|
|**payload**  <br>*optional*|Current status of list of purchase orders.|[OrderListStatus](#orderliststatus)|
|**errors**  <br>*optional*|A list of error responses returned when a request is unsuccessful.|[ErrorList](#errorlist)|


<a name="orderliststatus"></a>
### OrderListStatus

|Name|Schema|
|---|---|
|**pagination**  <br>*optional*|[Pagination](#pagination)|
|**ordersStatus**  <br>*optional*|< [OrderStatus](#orderstatus) > array|


<a name="orderstatus"></a>
### OrderStatus
Current status of a purchase order.


|Name|Description|Schema|
|---|---|---|
|**purchaseOrderNumber**  <br>*required*|The buyer's purchase order number for this order. Formatting Notes: 8-character alpha-numeric code.|string|
|**purchaseOrderStatus**  <br>*required*|The status of the buyer's purchase order for this order.|enum ([PurchaseOrderStatus](#purchaseorderstatus-subgroup-1))|
|**purchaseOrderDate**  <br>*required*|The date the purchase order was placed. Must be in ISO-8601 date/time format.|string (date-time)|
|**lastUpdatedDate**  <br>*optional*|The date when the purchase order was last updated. Must be in ISO-8601 date/time format.|string (date-time)|
|**sellingParty**  <br>*required*|Name/Address and tax details of the selling party.|[PartyIdentification](#partyidentification)|
|**shipToParty**  <br>*required*|Name/Address and tax details of the ship to party.|[PartyIdentification](#partyidentification)|
|**itemStatus**  <br>*required*|Detailed order status.|[ItemStatus](#itemstatus)|


<a name="itemstatus"></a>
### ItemStatus
Detailed description of items order status.

*Type* : < [OrderItemStatus](#orderitemstatus) > array


<a name="orderitemstatus"></a>
### OrderItemStatus

|Name|Description|Schema|
|---|---|---|
|**itemSequenceNumber**  <br>*required*|Numbering of the item on the purchase order. The first item will be 1, the second 2, and so on.|string|
|**buyerProductIdentifier**  <br>*optional*|Buyer's Standard Identification Number (ASIN) of an item.|string|
|**vendorProductIdentifier**  <br>*optional*|The vendor selected product identification of the item.|string|
|**netCost**  <br>*optional*|The net cost to Amazon each (cost).|[Money](#money)|
|**listPrice**  <br>*optional*|The list Price to Amazon each (list).|[Money](#money)|
|**orderedQuantity**  <br>*optional*|Ordered quantity information.|[orderedQuantity](#orderitemstatus-orderedquantity)|
|**acknowledgementStatus**  <br>*optional*|Acknowledgement status information.|[acknowledgementStatus](#orderitemstatus-acknowledgementstatus)|
|**receivingStatus**  <br>*optional*|Item receive status at the buyer's warehouse.|[receivingStatus](#orderitemstatus-receivingstatus)|

<a name="orderitemstatus-orderedquantity"></a>
**orderedQuantity**

|Name|Description|Schema|
|---|---|---|
|**orderedQuantity**  <br>*optional*|Item quantity ordered.|[ItemQuantity](#itemquantity)|
|**orderedQuantityDetails**  <br>*optional*|Details of item quantity ordered.|< [OrderedQuantityDetails](#orderedquantitydetails) > array|

<a name="orderitemstatus-acknowledgementstatus"></a>
**acknowledgementStatus**

|Name|Description|Schema|
|---|---|---|
|**confirmationStatus**  <br>*optional*|Confirmation status of line item.|enum ([ConfirmationStatus](#confirmationstatus))|
|**acceptedQuantity**  <br>*optional*|Item quantities accepted by vendor to be shipped.|[ItemQuantity](#itemquantity)|
|**rejectedQuantity**  <br>*optional*|Item quantities rejected by vendor.|[ItemQuantity](#itemquantity)|
|**acknowledgementStatusDetails**  <br>*optional*|Details of item quantity confirmed.|< [AcknowledgementStatusDetails](#acknowledgementstatusdetails) > array|

<a name="orderitemstatus-receivingstatus"></a>
**receivingStatus**

|Name|Description|Schema|
|---|---|---|
|**receiveStatus**  <br>*optional*|Receive status of the line item.|enum ([ReceiveStatus](#receivestatus))|
|**receivedQuantity**  <br>*optional*|The total item quantity received by the buyer so far.|[ItemQuantity](#itemquantity)|
|**lastReceiveDate**  <br>*optional*|The date when the most recent item was received at the buyer's warehouse. Must be in ISO-8601 date/time format.|string (date-time)|


<a name="orderedquantitydetails"></a>
### OrderedQuantityDetails
Details of item quantity ordered


|Name|Description|Schema|
|---|---|---|
|**updatedDate**  <br>*optional*|The date when the line item quantity was updated by buyer. Must be in ISO-8601 date/time format.|string (date-time)|
|**orderedQuantity**  <br>*optional*|Item quantity ordered.|[ItemQuantity](#itemquantity)|
|**cancelledQuantity**  <br>*optional*|Item quantity ordered.|[ItemQuantity](#itemquantity)|


<a name="acknowledgementstatusdetails"></a>
### AcknowledgementStatusDetails
Details of item quantity ordered


|Name|Description|Schema|
|---|---|---|
|**acknowledgementDate**  <br>*optional*|The date when the line item was confirmed by vendor. Must be in ISO-8601 date/time format.|string (date-time)|
|**acceptedQuantity**  <br>*optional*|Item quantity accepted by vendor to be shipped.|[ItemQuantity](#itemquantity)|
|**rejectedQuantity**  <br>*optional*|Item quantity rejected by vendor.|[ItemQuantity](#itemquantity)|


<a name="error"></a>
### Error
Error response returned when the request is unsuccessful.


|Name|Description|Schema|
|---|---|---|
|**code**  <br>*required*|An error code that identifies the type of error that occurred.|string|
|**message**  <br>*required*|A message that describes the error condition.|string|
|**details**  <br>*optional*|Additional details that can help the caller understand or fix the issue.|string|


<a name="methodofpayment"></a>
### MethodOfPayment
If the recipient requests, contains the shipment method of payment. This is for import PO's only.

*Type* : enum


|Value|Description|
|---|---|
|**PaidByBuyer**|Buyer pays for shipping.|
|**CollectOnDelivery**|Buyer pays for shipping on delivery.|
|**DefinedByBuyerAndSeller**|Shipping costs paid as agreed upon between buyer and seller.|
|**FOBPortOfCall**|Seller pays for transportation including loading and shipping.|
|**PrepaidBySeller**|Seller prepays for shipping.|
|**PaidBySeller**|Seller pays for shipping.|


<a name="confirmationstatus"></a>
### ConfirmationStatus
Confirmation status of line item.

*Type* : enum


|Value|Description|
|---|---|
|**ACCEPTED**|Status for orders accepted by vendors.|
|**PARTIALLY_ACCEPTED**|Status for orders that are partially accepted by vendors.|
|**REJECTED**|Status for orders that are rejected by vendors.|
|**UNCONFIRMED**|Status for orders that are yet to be confirmed by vendors.|


<a name="itemreceivestatus"></a>
### ItemReceiveStatus
Filters purchase orders based on the purchase order's item receive status. If the item receive status is not included in the filter, purchase orders for all receive statuses are included.

*Type* : enum


|Value|Description|
|---|---|
|**NOT_RECEIVED**|Provides a list of orders that have at least one item not received by the buyer.|
|**PARTIALLY_RECEIVED**|Provides a list of orders that have at least one item not received by the buyer.|
|**RECEIVED**|Provides a list of orders that have at least one item fully received by the buyer.|


<a name="unitofmeasure"></a>
### UnitOfMeasure
Unit of measure for the acknowledged quantity.

*Type* : enum


|Value|Description|
|---|---|
|**Cases**|Packing of individual items into a case.|
|**Eaches**|Individual items.|


<a name="acknowledgementcode"></a>
### AcknowledgementCode
This indicates the acknowledgement code.

*Type* : enum


|Value|Description|
|---|---|
|**Accepted**|Vendor accepts to fulfill the order item(s).|
|**Backordered**|Vendor placed a backorder to fulfill the original order and provides a scheduledShipDate or scheduledDeliveryDate which is different than the expectedShipDate or expectedDeliveryDate provided in the purchase order.|
|**Rejected**|Vendor rejects to fulfill the order item(s).|


<a name="poitemstate"></a>
### PoItemState
Current state of the purchase order item. If this value is Cancelled, this API will return purchase orders which have one or more items cancelled by Amazon with updated item quantity as zero.

*Type* : enum


|Value|Description|
|---|---|
|**Cancelled**|Status for order items cancelled by vendors.|


<a name="itemconfirmationstatus"></a>
### ItemConfirmationStatus
Filters purchase orders based on their item confirmation status. If the item confirmation status is not included in the filter, purchase orders for all confirmation statuses are included.

*Type* : enum


|Value|Description|
|---|---|
|**ACCEPTED**|Provides a list of orders that has at least one item fully accepted by vendors.|
|**PARTIALLY_ACCEPTED**|Provides a list of orders that has at least one item partially accepted by vendors.|
|**REJECTED**|Provides a list of orders that has at least one item rejected by vendors.|
|**UNCONFIRMED**|Provides a list of orders that has at least one item yet to be confirmed by vendors.|


<a name="internationalcommercialterms"></a>
### InternationalCommercialTerms
Incoterms (International Commercial Terms) are used to divide transaction costs and responsibilities between buyer and seller and reflect state-of-the-art transportation practices. This is for import purchase orders only.

*Type* : enum


|Value|Description|
|---|---|
|**ExWorks**|Places the maximum obligation on the buyer and minimum obligations on the seller. The seller makes the goods available at its premises. The buyer is responsible for all costs of the transportation of the shipment and bears all the risks for bringing the goods to their final destination.|
|**FreeCarrier**|The seller hands over the goods, cleared for export, into the disposal of the carrier (named by the buyer). The buyer pays for all the additional costs of transportation and risk passes when the goods are handed over to the carrier.|
|**FreeOnBoard**|Ocean shipments only. The seller must deliver the goods alongside the ship at the named port, and clear the goods for export. The buyer pays for all the additional costs of transportation and risk passes when the goods are alongside the ship.|
|**FreeAlongSideShip**|Ocean shipments only. The seller must load the goods on board the vessel, cleared for export. The buyer pays for all the additional costs of transportation and risk passes when the goods are loaded on the ship.|
|**CarriagePaidTo**|The seller pays for transportation to the named port of destination, but risk transfers to the buyer upon handing goods over to the first carrier. The buyer pays for all destination charges.|
|**CostAndFreight**|Ocean shipments only. Seller pays for transportation to the named port of destination, but risk transfers to the buyer once the goods are loaded on the vessel. The buyer pays for all destination charges.|
|**CarriageAndInsurancePaidTo**|Seller pays for transportation and insurance to the named port of destination, but risk transfers to the buyer upon handing goods over to the first carrier. The buyer pays for all destination charges.|
|**CostInsuranceAndFreight**|Ocean shipments only. Seller pays for transportation and insurance to the named port of destination, but risk transfers to the buyer once the goods are loaded on the vessel. The buyer pays for all destination charges.|
|**DeliveredAtTerminal**|Seller pays for transportation up to the destination terminal, and risks up to the point that the goods are unloaded at the terminal. The buyer pays for import clearance, duties & taxes and delivery costs.|
|**DeliveredAtPlace**|Seller pays for transportation to the named destination, and risk transfers at the point that the goods are ready for unloading by the buyer. The buyer pays for import clearance, duties & taxes and delivery costs.|
|**DeliverDutyPaid**|Seller is responsible for delivering the goods to the named place in the country of the buyer, and pays all costs in bringing the goods to the destination including import duties and taxes. This term places the maximum obligations on the seller and minimum obligations on the buyer.|


<a name="taxregistrationtype"></a>
### TaxRegistrationType
Tax registration type for the entity.

*Type* : enum


|Value|Description|
|---|---|
|**VAT**|Value-added tax.|
|**GST**|Goods and Services tax.|


<a name="receivestatus"></a>
### ReceiveStatus
Receive status of the line item.

*Type* : enum


|Value|Description|
|---|---|
|**NOT_RECEIVED**|The buyer has not received any of the item.|
|**PARTIALLY_RECEIVED**|-|
|**RECEIVED**|Receiving is complete. The buyer has received all confirmed items.|


<a name="sortorder"></a>
### SortOrder
Sort in ascending or descending order by purchase order creation date.

*Type* : enum


|Value|Description|
|---|---|
|**ASC**|Sort in ascending order by purchase order creation date.|
|**DESC**|Sort in descending order by purchase order creation date.|


<a name="rejectionreason"></a>
### RejectionReason
Indicates the reason for rejection.

*Type* : enum


|Value|Description|
|---|---|
|**TemporarilyUnavailable**|Items are currently not available.|
|**InvalidProductIdentifier**|Item cannot be found with the provided identifier.|
|**ObsoleteProduct**|Item is no longer sold.|


<a name="purchaseordertype"></a>
### PurchaseOrderType
Type of purchase order.

*Type* : enum


|Value|Description|
|---|---|
|**RegularOrder**|A regular purchase order is a method for placing orders for a one-time purchase and payment for line item goods that have a specific quantity and unit price.|
|**ConsignedOrder**|A consignment purchase order is an agreement with a vendor that allows the product to be received, but the inventory still belong to the vendor until the product is used.|
|**NewProductIntroduction**|A purchase order where a new product is introduced.|
|**RushOrder**|Rush orders are purchases of goods that need to be processed and delivered by a certain date that is much sooner than the standard arrival date.|


<a name="paymentmethod"></a>
### PaymentMethod
Payment method used.

*Type* : enum


|Value|Description|
|---|---|
|**Invoice**|An invoice payment is submitted by a business to pay for products and services purchased from vendors.|
|**Consignment**|A retail merchandiser acts as a consignor for goods supplied by the consignee. The consignor pays the consignee after the sale and keeps a percentage of the proceeds|
|**CreditCard**|Payment is made using a credit card.|
|**Prepaid**|Payment is prepaid.|


<a name="purchaseorderstatus"></a>
### PurchaseOrderStatus
*Type* : enum

<a id="purchaseorderstatus-subgroup-1"></a>**For use with the definition(s): [OrderStatus](#orderstatus)**
The status of the buyer's purchase order for this order.

|Value|Description|
|---|---|
|**OPEN**|Buyer has not yet received all of the items in the purchase order.|
|**CLOSED**|Buyer has received all of the items in the purchase order.|

<a id="purchaseorderstatus-subgroup-2"></a>**For use with the operation(s): [getPurchaseOrdersStatus](#getpurchaseordersstatus)**
Filters purchase orders based on the specified purchase order status. If not included in filter, this will return purchase orders for all statuses.

|Value|Description|
|---|---|
|**OPEN**|Buyer has not yet received all of the items in the purchase order.|
|**CLOSED**|Buyer has received all of the items in the purchase order.|


<a name="purchaseorderstate"></a>
### PurchaseOrderState
*Type* : enum

<a id="purchaseorderstate-subgroup-1"></a>**For use with the operation(s): [getPurchaseOrders](#getpurchaseorders)**
Filters purchase orders based on the purchase order state.

|Value|Description|
|---|---|
|**New**|Status of the orders that are newly created.|
|**Acknowledged**|Status of the orders acknowledged by vendors.|
|**Closed**|Status of the orders that are completed.|

<a id="purchaseorderstate-subgroup-2"></a>**For use with the definition(s): [Order](#order)**
This field will contain the current state of the purchase order.

|Value|Description|
|---|---|
|**New**|The purchase order is newly created and needs to be acknowledged by vendor.|
|**Acknowledged**|The purchase order has been acknowledged by vendor.|
|**Closed**|The purchase order is closed and no further action is required from the vendor. PO can be in closed state for many reasons such as order is rejected by vendor, order is cancelled by Amazon or order is fully received by Amazon.|

