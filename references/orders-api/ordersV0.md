# Selling Partner API for Orders


<a name="overview"></a>
## Overview
The Selling Partner API for Orders helps you programmatically retrieve order information. These APIs let you develop fast, flexible, custom applications in areas like order synchronization, order research, and demand-based decision support tools.


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
[getOrders](#getorders)<br>[getOrder](#getorder)<br>[getOrderBuyerInfo](#getorderbuyerinfo)<br>[getOrderAddress](#getorderaddress)<br>[getOrderItems](#getorderitems)<br>[getOrderItemsBuyerInfo](#getorderitemsbuyerinfo)<br>[updateShipmentStatus](#updateshipmentstatus)<br>
<a name="paths"></a>
## Paths

<a name="getorders"></a>
### GET /orders/v0/orders
**Operation: getOrders**

#### Description
Returns orders created or updated during the time frame indicated by the specified parameters. You can also apply a range of filtering criteria to narrow the list of orders returned. If NextToken is present, that will be used to retrieve the orders instead of other criteria.

**Usage Plans:**

| Plan type | Rate (requests per second) | Burst |
| ---- | ---- | ---- |
|Default| 0.0055 | 20 |
|Selling partner specific| Variable | Variable |

The x-amzn-RateLimit-Limit response header returns the usage plan rate limits that were applied to the requested operation. Rate limits for some selling partners will vary from the default rate and burst shown in the table above. For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Query**|**CreatedAfter**  <br>*optional*|A date used for selecting orders created after (or at) a specified time. Only orders placed after the specified time are returned. Either the CreatedAfter parameter or the LastUpdatedAfter parameter is required. Both cannot be empty. The date must be in ISO 8601 format.|string|
|**Query**|**CreatedBefore**  <br>*optional*|A date used for selecting orders created before (or at) a specified time. Only orders placed before the specified time are returned. The date must be in ISO 8601 format.|string|
|**Query**|**LastUpdatedAfter**  <br>*optional*|A date used for selecting orders that were last updated after (or at) a specified time. An update is defined as any change in order status, including the creation of a new order. Includes updates made by Amazon and by the seller. The date must be in ISO 8601 format.|string|
|**Query**|**LastUpdatedBefore**  <br>*optional*|A date used for selecting orders that were last updated before (or at) a specified time. An update is defined as any change in order status, including the creation of a new order. Includes updates made by Amazon and by the seller. The date must be in ISO 8601 format.|string|
|**Query**|**OrderStatuses**  <br>*optional*|A list of OrderStatus values used to filter the results. Possible values: PendingAvailability (This status is available for pre-orders only. The order has been placed, payment has not been authorized, and the release date of the item is in the future.); Pending (The order has been placed but payment has not been authorized); Unshipped (Payment has been authorized and the order is ready for shipment, but no items in the order have been shipped); PartiallyShipped (One or more, but not all, items in the order have been shipped); Shipped (All items in the order have been shipped); InvoiceUnconfirmed (All items in the order have been shipped. The seller has not yet given confirmation to Amazon that the invoice has been shipped to the buyer.); Canceled (The order has been canceled); and Unfulfillable (The order cannot be fulfilled. This state applies only to Multi-Channel Fulfillment orders.).|< string > array|
|**Query**|**MarketplaceIds**  <br>*required*|A list of MarketplaceId values. Used to select orders that were placed in the specified marketplaces.<br><br>See the [Selling Partner API Developer Guide](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md#marketplaceid-values) for a complete list of marketplaceId values.<br>**Max count** : 50|< string > array|
|**Query**|**FulfillmentChannels**  <br>*optional*|A list that indicates how an order was fulfilled. Filters the results by fulfillment channel. Possible values: FBA (Fulfillment by Amazon); SellerFulfilled (Fulfilled by the seller).|< string > array|
|**Query**|**PaymentMethods**  <br>*optional*|A list of payment method values. Used to select orders paid using the specified payment methods. Possible values: COD (Cash on delivery); CVS (Convenience store payment); Other (Any payment method other than COD or CVS).|< string > array|
|**Query**|**BuyerEmail**  <br>*optional*|The email address of a buyer. Used to select orders that contain the specified email address.|string|
|**Query**|**SellerOrderId**  <br>*optional*|An order identifier that is specified by the seller. Used to select only the orders that match the order identifier. If SellerOrderId is specified, then FulfillmentChannels, OrderStatuses, PaymentMethod, LastUpdatedAfter, LastUpdatedBefore, and BuyerEmail cannot be specified.|string|
|**Query**|**MaxResultsPerPage**  <br>*optional*|A number that indicates the maximum number of orders that can be returned per page. Value must be 1 - 100. Default 100.|integer|
|**Query**|**EasyShipShipmentStatuses**  <br>*optional*|A list of EasyShipShipmentStatus values. Used to select Easy Ship orders with statuses that match the specified  values. If EasyShipShipmentStatus is specified, only Amazon Easy Ship orders are returned.Possible values: PendingPickUp (Amazon has not yet picked up the package from the seller). LabelCanceled (The seller canceled the pickup). PickedUp (Amazon has picked up the package from the seller). AtOriginFC (The packaged is at the origin fulfillment center). AtDestinationFC (The package is at the destination fulfillment center). OutForDelivery (The package is out for delivery). Damaged (The package was damaged by the carrier). Delivered (The package has been delivered to the buyer). RejectedByBuyer (The package has been rejected by the buyer). Undeliverable (The package cannot be delivered). ReturnedToSeller (The package was not delivered to the buyer and was returned to the seller). ReturningToSeller (The package was not delivered to the buyer and is being returned to the seller).|< string > array|
|**Query**|**NextToken**  <br>*optional*|A string token returned in the response of your previous request.|string|
|**Query**|**AmazonOrderIds**  <br>*optional*|A list of AmazonOrderId values. An AmazonOrderId is an Amazon-defined order identifier, in 3-7-7 format.<br>**Max count** : 50|< string > array|
|**Query**|**ActualFulfillmentSupplySourceId**  <br>*optional*|Denotes the recommended sourceId where the order should be fulfilled from.|string|
|**Query**|**IsISPU**  <br>*optional*|When true, this order is marked to be picked up from a store rather than delivered.|boolean|
|**Query**|**StoreChainStoreId**  <br>*optional*|The store chain store identifier. Linked to a specific store in a store chain.|string|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Success.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference ID.|[GetOrdersResponse](#getordersresponse)|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference ID.|[GetOrdersResponse](#getordersresponse)|
|**403**|Indicates access to the resource is forbidden. Possible reasons include Access Denied, Unauthorized, Expired Token, or Invalid Signature.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference ID.|[GetOrdersResponse](#getordersresponse)|
|**404**|The resource specified does not exist.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference ID.|[GetOrdersResponse](#getordersresponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference ID.|[GetOrdersResponse](#getordersresponse)|
|**500**|An unexpected condition occurred that prevented the server from fulfilling the request.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference ID.|[GetOrdersResponse](#getordersresponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference ID.|[GetOrdersResponse](#getordersresponse)|

For additional error status codes, descriptions and schemas, see [Error responses and schemas](#error-responses-and-schemas).
<a name="getorder"></a>
### GET /orders/v0/orders/{orderId}
**Operation: getOrder**

#### Description
Returns the order indicated by the specified order ID.

**Usage Plans:**

| Plan type | Rate (requests per second) | Burst |
| ---- | ---- | ---- |
|Default| 0.0055 | 20 |
|Selling partner specific| Variable | Variable |

The x-amzn-RateLimit-Limit response header returns the usage plan rate limits that were applied to the requested operation. Rate limits for some selling partners will vary from the default rate and burst shown in the table above. For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**orderId**  <br>*required*|An Amazon-defined order identifier, in 3-7-7 format.|string|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Success.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference ID.|[GetOrderResponse](#getorderresponse)|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference ID.|[GetOrderResponse](#getorderresponse)|
|**403**|Indicates access to the resource is forbidden. Possible reasons include Access Denied, Unauthorized, Expired Token, or Invalid Signature.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference ID.|[GetOrderResponse](#getorderresponse)|
|**404**|The resource specified does not exist.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference ID.|[GetOrderResponse](#getorderresponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference ID.|[GetOrderResponse](#getorderresponse)|
|**500**|An unexpected condition occurred that prevented the server from fulfilling the request.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference ID.|[GetOrderResponse](#getorderresponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference ID.|[GetOrderResponse](#getorderresponse)|

For additional error status codes, descriptions and schemas, see [Error responses and schemas](#error-responses-and-schemas).
<a name="getorderbuyerinfo"></a>
### GET /orders/v0/orders/{orderId}/buyerInfo
**Operation: getOrderBuyerInfo**

#### Description
Returns buyer information for the specified order.

**Important.** We recommend using the getOrders operation to get buyer information for an order, as the getOrderBuyerInfo operation is scheduled for deprecation on January 12, 2022. For more information, see the [Tokens API Use Case Guide](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/use-case-guides/tokens-api-use-case-guide/tokens-API-use-case-guide-2021-03-01.md).

**Usage Plans:**

| Plan type | Rate (requests per second) | Burst |
| ---- | ---- | ---- |
|Default| 0.0055 | 20 |
|Selling partner specific| Variable | Variable |

The x-amzn-RateLimit-Limit response header returns the usage plan rate limits that were applied to the requested operation. Rate limits for some selling partners will vary from the default rate and burst shown in the table above. For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**orderId**  <br>*required*|An orderId is an Amazon-defined order identifier, in 3-7-7 format.|string|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Success.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference ID.|[GetOrderBuyerInfoResponse](#getorderbuyerinforesponse)|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference ID.|[GetOrderBuyerInfoResponse](#getorderbuyerinforesponse)|
|**403**|Indicates access to the resource is forbidden. Possible reasons include Access Denied, Unauthorized, Expired Token, or Invalid Signature.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference ID.|[GetOrderBuyerInfoResponse](#getorderbuyerinforesponse)|
|**404**|The resource specified does not exist.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference ID.|[GetOrderBuyerInfoResponse](#getorderbuyerinforesponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference ID.|[GetOrderBuyerInfoResponse](#getorderbuyerinforesponse)|
|**500**|An unexpected condition occurred that prevented the server from fulfilling the request.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference ID.|[GetOrderBuyerInfoResponse](#getorderbuyerinforesponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference ID.|[GetOrderBuyerInfoResponse](#getorderbuyerinforesponse)|

For additional error status codes, descriptions and schemas, see [Error responses and schemas](#error-responses-and-schemas).
<a name="getorderaddress"></a>
### GET /orders/v0/orders/{orderId}/address
**Operation: getOrderAddress**

#### Description
Returns the shipping address for the specified order.

**Important.** We recommend using the getOrders operation to get shipping address information for an order, as the getOrderAddress operation is scheduled for deprecation on January 12, 2022. For more information, see the [Tokens API Use Case Guide](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/use-case-guides/tokens-api-use-case-guide/tokens-API-use-case-guide-2021-03-01.md).

**Usage Plans:**

| Plan type | Rate (requests per second) | Burst |
| ---- | ---- | ---- |
|Default| 0.0055 | 20 |
|Selling partner specific| Variable | Variable |

The x-amzn-RateLimit-Limit response header returns the usage plan rate limits that were applied to the requested operation. Rate limits for some selling partners will vary from the default rate and burst shown in the table above. For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**orderId**  <br>*required*|An orderId is an Amazon-defined order identifier, in 3-7-7 format.|string|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Success.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference ID.|[GetOrderAddressResponse](#getorderaddressresponse)|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference ID.|[GetOrderAddressResponse](#getorderaddressresponse)|
|**403**|Indicates access to the resource is forbidden. Possible reasons include Access Denied, Unauthorized, Expired Token, or Invalid Signature.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference ID.|[GetOrderAddressResponse](#getorderaddressresponse)|
|**404**|The resource specified does not exist.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference ID.|[GetOrderAddressResponse](#getorderaddressresponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference ID.|[GetOrderAddressResponse](#getorderaddressresponse)|
|**500**|An unexpected condition occurred that prevented the server from fulfilling the request.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference ID.|[GetOrderAddressResponse](#getorderaddressresponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference ID.|[GetOrderAddressResponse](#getorderaddressresponse)|

For additional error status codes, descriptions and schemas, see [Error responses and schemas](#error-responses-and-schemas).
<a name="getorderitems"></a>
### GET /orders/v0/orders/{orderId}/orderItems
**Operation: getOrderItems**

#### Description
Returns detailed order item information for the order indicated by the specified order ID. If NextToken is provided, it's used to retrieve the next page of order items.

Note: When an order is in the Pending state (the order has been placed but payment has not been authorized), the getOrderItems operation does not return information about pricing, taxes, shipping charges, gift status or promotions for the order items in the order. After an order leaves the Pending state (this occurs when payment has been authorized) and enters the Unshipped, Partially Shipped, or Shipped state, the getOrderItems operation returns information about pricing, taxes, shipping charges, gift status and promotions for the order items in the order.

**Usage Plans:**

| Plan type | Rate (requests per second) | Burst |
| ---- | ---- | ---- |
|Default| 0.0055 | 20 |
|Selling partner specific| Variable | Variable |

The x-amzn-RateLimit-Limit response header returns the usage plan rate limits that were applied to the requested operation. Rate limits for some selling partners will vary from the default rate and burst shown in the table above. For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**orderId**  <br>*required*|An Amazon-defined order identifier, in 3-7-7 format.|string|
|**Query**|**NextToken**  <br>*optional*|A string token returned in the response of your previous request.|string|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Success.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference ID.|[GetOrderItemsResponse](#getorderitemsresponse)|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference ID.|[GetOrderItemsResponse](#getorderitemsresponse)|
|**403**|Indicates access to the resource is forbidden. Possible reasons include Access Denied, Unauthorized, Expired Token, or Invalid Signature.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference ID.|[GetOrderItemsResponse](#getorderitemsresponse)|
|**404**|The resource specified does not exist.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference ID.|[GetOrderItemsResponse](#getorderitemsresponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference ID.|[GetOrderItemsResponse](#getorderitemsresponse)|
|**500**|An unexpected condition occurred that prevented the server from fulfilling the request.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference ID.|[GetOrderItemsResponse](#getorderitemsresponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference ID.|[GetOrderItemsResponse](#getorderitemsresponse)|

For additional error status codes, descriptions and schemas, see [Error responses and schemas](#error-responses-and-schemas).
<a name="getorderitemsbuyerinfo"></a>
### GET /orders/v0/orders/{orderId}/orderItems/buyerInfo
**Operation: getOrderItemsBuyerInfo**

#### Description
Returns buyer information for the order items in the specified order.

**Important.** We recommend using the getOrderItems operation to get buyer information for the order items in an order, as the getOrderItemsBuyerInfo operation is scheduled for deprecation on January 12, 2022. For more information, see the [Tokens API Use Case Guide](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/use-case-guides/tokens-api-use-case-guide/tokens-API-use-case-guide-2021-03-01.md).

**Usage Plans:**

| Plan type | Rate (requests per second) | Burst |
| ---- | ---- | ---- |
|Default| 0.0055 | 20 |
|Selling partner specific| Variable | Variable |

The x-amzn-RateLimit-Limit response header returns the usage plan rate limits that were applied to the requested operation. Rate limits for some selling partners will vary from the default rate and burst shown in the table above. For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**orderId**  <br>*required*|An Amazon-defined order identifier, in 3-7-7 format.|string|
|**Query**|**NextToken**  <br>*optional*|A string token returned in the response of your previous request.|string|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Success.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference ID.|[GetOrderItemsBuyerInfoResponse](#getorderitemsbuyerinforesponse)|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference ID.|[GetOrderItemsBuyerInfoResponse](#getorderitemsbuyerinforesponse)|
|**403**|Indicates access to the resource is forbidden. Possible reasons include Access Denied, Unauthorized, Expired Token, or Invalid Signature.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference ID.|[GetOrderItemsBuyerInfoResponse](#getorderitemsbuyerinforesponse)|
|**404**|The resource specified does not exist.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference ID.|[GetOrderItemsBuyerInfoResponse](#getorderitemsbuyerinforesponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference ID.|[GetOrderItemsBuyerInfoResponse](#getorderitemsbuyerinforesponse)|
|**500**|An unexpected condition occurred that prevented the server from fulfilling the request.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference ID.|[GetOrderItemsBuyerInfoResponse](#getorderitemsbuyerinforesponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference ID.|[GetOrderItemsBuyerInfoResponse](#getorderitemsbuyerinforesponse)|

For additional error status codes, descriptions and schemas, see [Error responses and schemas](#error-responses-and-schemas).
<a name="updateshipmentstatus"></a>
### POST /orders/v0/orders/{orderId}/shipment
**Operation: updateShipmentStatus**

#### Description
Update the shipment status.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**orderId**  <br>*required*|An Amazon-defined order identifier, in 3-7-7 format.|string|
|**Body**|**payload**  <br>*required*|Request to update the shipment status.|[UpdateShipmentStatusRequest](#updateshipmentstatusrequest)|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**204**|Success.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference ID.|No Content|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference ID.|[UpdateShipmentStatusErrorResponse](#updateshipmentstatuserrorresponse)|
|**403**|Indicates that access to the resource is forbidden. Possible reasons include Access Denied, Unauthorized, Expired Token, or Invalid Signature.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference ID.|[UpdateShipmentStatusErrorResponse](#updateshipmentstatuserrorresponse)|
|**404**|The resource specified does not exist.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference ID.|[UpdateShipmentStatusErrorResponse](#updateshipmentstatuserrorresponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference ID.|[UpdateShipmentStatusErrorResponse](#updateshipmentstatuserrorresponse)|
|**500**|An unexpected condition occurred that prevented the server from fulfilling the request.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference ID.|[UpdateShipmentStatusErrorResponse](#updateshipmentstatuserrorresponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference ID.|[UpdateShipmentStatusErrorResponse](#updateshipmentstatuserrorresponse)|

For additional error status codes, descriptions and schemas, see [Error responses and schemas](#error-responses-and-schemas).



<a name="error-responses-and-schemas"></a>
### Error Responses and Schemas
This table contains HTTP status codes and associated information for error responses.

|HTTP Code|Description|Schema|
|---|---|---|
|**413**|The request size exceeded the maximum accepted size.  <br>**Headers**:  <br>`x-amzn-RequestId` (string):Unique request reference ID.|[UpdateShipmentStatusErrorResponse](#updateshipmentstatuserrorresponse)|
|**415**|The request payload is in an unsupported format.  <br>**Headers**:  <br>`x-amzn-RequestId` (string):Unique request reference ID.|[UpdateShipmentStatusErrorResponse](#updateshipmentstatuserrorresponse)|


<a name="definitions"></a>
## Definitions

<a name="updateshipmentstatusrequest"></a>
### UpdateShipmentStatusRequest
Request to update the status of shipment of an order.


|Name|Description|Schema|
|---|---|---|
|**marketplaceId**  <br>*required*|the unobfuscated marketplace ID|[MarketplaceId](#marketplaceid)|
|**shipmentStatus**  <br>*required*|the status of the shipment of the order to be updated|[ShipmentStatus](#shipmentstatus)|
|**orderItems**  <br>*optional*|the list of order items and quantities when the seller wants to partially update the shipment status of the order|[OrderItems](#orderitems)|


<a name="marketplaceid"></a>
### MarketplaceId
the unobfuscated marketplace ID

*Type* : string


<a name="shipmentstatus"></a>
### ShipmentStatus
the status of the shipment of the order to be updated

*Type* : enum


|Value|Description|
|---|---|
|**ReadyForPickup**|-|
|**PickedUp**|-|
|**RefusedPickup**|-|


<a name="orderitems"></a>
### OrderItems
the list of order items and quantities when the seller wants to partially update the shipment status of the order

*Type* : < [OrderItems](#orderitems-inline) > array

<a name="orderitems-inline"></a>
**OrderItems**

|Name|Description|Schema|
|---|---|---|
|**orderItemId**  <br>*optional*|the unique identifier for the order item|string|
|**quantity**  <br>*optional*|the quantity of items that needs an update of the shipment status|integer|


<a name="updateshipmentstatuserrorresponse"></a>
### UpdateShipmentStatusErrorResponse
The error response schema for the UpdateShipmentStatus operation.


|Name|Description|Schema|
|---|---|---|
|**errors**  <br>*optional*|One or more unexpected errors occurred during the UpdateShipmentStatus operation.|[ErrorList](#errorlist)|


<a name="getordersresponse"></a>
### GetOrdersResponse
The response schema for the getOrders operation.


|Name|Description|Schema|
|---|---|---|
|**payload**  <br>*optional*|The payload for the getOrders operation.|[OrdersList](#orderslist)|
|**errors**  <br>*optional*|One or more unexpected errors occurred during the getOrders operation.|[ErrorList](#errorlist)|


<a name="getorderresponse"></a>
### GetOrderResponse
The response schema for the getOrder operation.


|Name|Description|Schema|
|---|---|---|
|**payload**  <br>*optional*|The payload for the getOrder operation.|[Order](#order)|
|**errors**  <br>*optional*|One or more unexpected errors occurred during the getOrder operation.|[ErrorList](#errorlist)|


<a name="getorderbuyerinforesponse"></a>
### GetOrderBuyerInfoResponse
The response schema for the getOrderBuyerInfo operation.


|Name|Description|Schema|
|---|---|---|
|**payload**  <br>*optional*|The payload for the getOrderBuyerInfo operations.|[OrderBuyerInfo](#orderbuyerinfo)|
|**errors**  <br>*optional*|One or more unexpected errors occurred during the getOrderBuyerInfo operation.|[ErrorList](#errorlist)|


<a name="getorderaddressresponse"></a>
### GetOrderAddressResponse
The response schema for the getOrderAddress operation.


|Name|Description|Schema|
|---|---|---|
|**payload**  <br>*optional*|The payload for the getOrderAddress operations.|[OrderAddress](#orderaddress)|
|**errors**  <br>*optional*|One or more unexpected errors occurred during the getOrderAddress operation.|[ErrorList](#errorlist)|


<a name="getorderitemsresponse"></a>
### GetOrderItemsResponse
The response schema for the getOrderItems operation.


|Name|Description|Schema|
|---|---|---|
|**payload**  <br>*optional*|The payload for the getOrderItems operation.|[OrderItemsList](#orderitemslist)|
|**errors**  <br>*optional*|One or more unexpected errors occurred during the getOrderItems operation.|[ErrorList](#errorlist)|


<a name="getorderitemsbuyerinforesponse"></a>
### GetOrderItemsBuyerInfoResponse
The response schema for the getOrderItemsBuyerInfo operation.


|Name|Description|Schema|
|---|---|---|
|**payload**  <br>*optional*|The payload for the getOrderItemsBuyerInfo operation.|[OrderItemsBuyerInfoList](#orderitemsbuyerinfolist)|
|**errors**  <br>*optional*|One or more unexpected errors occurred during the getOrderItemsBuyerInfo operation.|[ErrorList](#errorlist)|


<a name="orderslist"></a>
### OrdersList
A list of orders along with additional information to make subsequent API calls.


|Name|Description|Schema|
|---|---|---|
|**Orders**  <br>*required*|A list of orders.|[OrderList](#orderlist)|
|**NextToken**  <br>*optional*|When present and not empty, pass this string token in the next request to return the next response page.|string|
|**LastUpdatedBefore**  <br>*optional*|A date used for selecting orders that were last updated before (or at) a specified time. An update is defined as any change in order status, including the creation of a new order. Includes updates made by Amazon and by the seller. All dates must be in ISO 8601 format.|string|
|**CreatedBefore**  <br>*optional*|A date used for selecting orders created before (or at) a specified time. Only orders placed before the specified time are returned. The date must be in ISO 8601 format.|string|


<a name="orderlist"></a>
### OrderList
A list of orders.

*Type* : < [Order](#order) > array


<a name="order"></a>
### Order
Order information.


|Name|Description|Schema|
|---|---|---|
|**AmazonOrderId**  <br>*required*|An Amazon-defined order identifier, in 3-7-7 format.|string|
|**SellerOrderId**  <br>*optional*|A seller-defined order identifier.|string|
|**PurchaseDate**  <br>*required*|The date when the order was created.|string|
|**LastUpdateDate**  <br>*required*|The date when the order was last updated.<br><br>Note: LastUpdateDate is returned with an incorrect date for orders that were last updated before 2009-04-01.|string|
|**OrderStatus**  <br>*required*|The current order status.|enum ([OrderStatus](#orderstatus))|
|**FulfillmentChannel**  <br>*optional*|Whether the order was fulfilled by Amazon (AFN) or by the seller (MFN).|enum ([FulfillmentChannel](#fulfillmentchannel))|
|**SalesChannel**  <br>*optional*|The sales channel of the first item in the order.|string|
|**OrderChannel**  <br>*optional*|The order channel of the first item in the order.|string|
|**ShipServiceLevel**  <br>*optional*|The shipment service level of the order.|string|
|**OrderTotal**  <br>*optional*|The total charge for this order.|[Money](#money)|
|**NumberOfItemsShipped**  <br>*optional*|The number of items shipped.|integer|
|**NumberOfItemsUnshipped**  <br>*optional*|The number of items unshipped.|integer|
|**PaymentExecutionDetail**  <br>*optional*|Information about sub-payment methods for a Cash On Delivery (COD) order.<br><br>Note: For a COD order that is paid for using one sub-payment method, one PaymentExecutionDetailItem object is returned, with PaymentExecutionDetailItem/PaymentMethod = COD. For a COD order that is paid for using multiple sub-payment methods, two or more PaymentExecutionDetailItem objects are returned.|[PaymentExecutionDetailItemList](#paymentexecutiondetailitemlist)|
|**PaymentMethod**  <br>*optional*|The payment method for the order. This property is limited to Cash On Delivery (COD) and Convenience Store (CVS) payment methods. Unless you need the specific COD payment information provided by the PaymentExecutionDetailItem object, we recommend using the PaymentMethodDetails property to get payment method information.|enum ([PaymentMethod](#paymentmethod))|
|**PaymentMethodDetails**  <br>*optional*|A list of payment methods for the order.|[PaymentMethodDetailItemList](#paymentmethoddetailitemlist)|
|**MarketplaceId**  <br>*optional*|The identifier for the marketplace where the order was placed.|string|
|**ShipmentServiceLevelCategory**  <br>*optional*|The shipment service level category of the order.<br><br>Possible values: Expedited, FreeEconomy, NextDay, SameDay, SecondDay, Scheduled, Standard.|string|
|**EasyShipShipmentStatus**  <br>*optional*|The status of the Amazon Easy Ship order. This property is included only for Amazon Easy Ship orders.<br><br>Possible values: PendingPickUp, LabelCanceled, PickedUp, OutForDelivery, Damaged, Delivered, RejectedByBuyer, Undeliverable, ReturnedToSeller, ReturningToSeller.|string|
|**CbaDisplayableShippingLabel**  <br>*optional*|Custom ship label for Checkout by Amazon (CBA).|string|
|**OrderType**  <br>*optional*|The type of the order.|enum ([OrderType](#ordertype))|
|**EarliestShipDate**  <br>*optional*|The start of the time period within which you have committed to ship the order. In ISO 8601 date time format. Returned only for seller-fulfilled orders.<br><br>Note: EarliestShipDate might not be returned for orders placed before February 1, 2013.|string|
|**LatestShipDate**  <br>*optional*|The end of the time period within which you have committed to ship the order. In ISO 8601 date time format. Returned only for seller-fulfilled orders.<br><br>Note: LatestShipDate might not be returned for orders placed before February 1, 2013.|string|
|**EarliestDeliveryDate**  <br>*optional*|The start of the time period within which you have committed to fulfill the order. In ISO 8601 date time format. Returned only for seller-fulfilled orders.|string|
|**LatestDeliveryDate**  <br>*optional*|The end of the time period within which you have committed to fulfill the order. In ISO 8601 date time format. Returned only for seller-fulfilled orders that do not have a PendingAvailability, Pending, or Canceled status.|string|
|**IsBusinessOrder**  <br>*optional*|When true, the order is an Amazon Business order. An Amazon Business order is an order where the buyer is a Verified Business Buyer.|boolean|
|**IsPrime**  <br>*optional*|When true, the order is a seller-fulfilled Amazon Prime order.|boolean|
|**IsPremiumOrder**  <br>*optional*|When true, the order has a Premium Shipping Service Level Agreement. For more information about Premium Shipping orders, see "Premium Shipping Options" in the Seller Central Help for your marketplace.|boolean|
|**IsGlobalExpressEnabled**  <br>*optional*|When true, the order is a GlobalExpress order.|boolean|
|**ReplacedOrderId**  <br>*optional*|The order ID value for the order that is being replaced. Returned only if IsReplacementOrder = true.|string|
|**IsReplacementOrder**  <br>*optional*|When true, this is a replacement order.|boolean|
|**PromiseResponseDueDate**  <br>*optional*|Indicates the date by which the seller must respond to the buyer with an estimated ship date. Returned only for Sourcing on Demand orders.|string|
|**IsEstimatedShipDateSet**  <br>*optional*|When true, the estimated ship date is set for the order. Returned only for Sourcing on Demand orders.|boolean|
|**IsSoldByAB**  <br>*optional*|When true, the item within this order was bought and re-sold by Amazon Business EU SARL (ABEU). By buying and instantly re-selling your items, ABEU becomes the seller of record, making your inventory available for sale to customers who would not otherwise purchase from a third-party seller.|boolean|
|**DefaultShipFromLocationAddress**  <br>*optional*|The recommended location for the seller to ship the items from. It is calculated at checkout. The seller may or may not choose to ship from this location.|[Address](#address)|
|**BuyerInvoicePreference**  <br>*optional*|The buyer’s invoicing preference.|enum ([BuyerInvoicePreference](#buyerinvoicepreference))|
|**BuyerTaxInformation**  <br>*optional*|Contains the business invoice tax information.|[BuyerTaxInformation](#buyertaxinformation)|
|**FulfillmentInstruction**  <br>*optional*|Contains the instructions about the fulfillment like where should it be fulfilled from.|[FulfillmentInstruction](#fulfillmentinstruction)|
|**IsISPU**  <br>*optional*|When true, this order is marked to be picked up from a store rather than delivered.|boolean|
|**MarketplaceTaxInfo**  <br>*optional*|Tax information about the marketplace.|[MarketplaceTaxInfo](#marketplacetaxinfo)|
|**SellerDisplayName**  <br>*optional*|The seller’s friendly name registered in the marketplace.|string|
|**ShippingAddress**  <br>*optional*|The shipping address for the order.|[Address](#address)|
|**BuyerInfo**  <br>*optional*|Buyer information|[BuyerInfo](#buyerinfo)|
|**AutomatedShippingSettings**  <br>*optional*|Contains information regarding the Shipping Settings Automaton program, such as whether the order's shipping settings were generated automatically, and what those settings are.|[AutomatedShippingSettings](#automatedshippingsettings)|


<a name="orderbuyerinfo"></a>
### OrderBuyerInfo
Buyer information for an order.


|Name|Description|Schema|
|---|---|---|
|**AmazonOrderId**  <br>*required*|An Amazon-defined order identifier, in 3-7-7 format.|string|
|**BuyerEmail**  <br>*optional*|The anonymized email address of the buyer.|string|
|**BuyerName**  <br>*optional*|The name of the buyer.|string|
|**BuyerCounty**  <br>*optional*|The county of the buyer.|string|
|**BuyerTaxInfo**  <br>*optional*|Tax information about the buyer.|[BuyerTaxInfo](#buyertaxinfo)|
|**PurchaseOrderNumber**  <br>*optional*|The purchase order (PO) number entered by the buyer at checkout. Returned only for orders where the buyer entered a PO number at checkout.|string|


<a name="orderaddress"></a>
### OrderAddress
The shipping address for the order.


|Name|Description|Schema|
|---|---|---|
|**AmazonOrderId**  <br>*required*|An Amazon-defined order identifier, in 3-7-7 format.|string|
|**ShippingAddress**  <br>*optional*|The shipping address for the order.|[Address](#address)|


<a name="address"></a>
### Address
The shipping address for the order.


|Name|Description|Schema|
|---|---|---|
|**Name**  <br>*required*|The name.|string|
|**AddressLine1**  <br>*optional*|The street address.|string|
|**AddressLine2**  <br>*optional*|Additional street address information, if required.|string|
|**AddressLine3**  <br>*optional*|Additional street address information, if required.|string|
|**City**  <br>*optional*|The city|string|
|**County**  <br>*optional*|The county.|string|
|**District**  <br>*optional*|The district.|string|
|**StateOrRegion**  <br>*optional*|The state or region.|string|
|**Municipality**  <br>*optional*|The municipality.|string|
|**PostalCode**  <br>*optional*|The postal code.|string|
|**CountryCode**  <br>*optional*|The country code. A two-character country code, in ISO 3166-1 alpha-2 format.|string|
|**Phone**  <br>*optional*|The phone number. Not returned for Fulfillment by Amazon (FBA) orders.|string|
|**AddressType**  <br>*optional*|The address type of the shipping address.|enum ([AddressType](#addresstype))|


<a name="money"></a>
### Money
The monetary value of the order.


|Name|Description|Schema|
|---|---|---|
|**CurrencyCode**  <br>*optional*|The three-digit currency code. In ISO 4217 format.|string|
|**Amount**  <br>*optional*|The currency amount.|string|


<a name="paymentmethoddetailitemlist"></a>
### PaymentMethodDetailItemList
A list of payment method detail items.

*Type* : < string > array


<a name="paymentexecutiondetailitemlist"></a>
### PaymentExecutionDetailItemList
A list of payment execution detail items.

*Type* : < [PaymentExecutionDetailItem](#paymentexecutiondetailitem) > array


<a name="paymentexecutiondetailitem"></a>
### PaymentExecutionDetailItem
Information about a sub-payment method used to pay for a COD order.


|Name|Description|Schema|
|---|---|---|
|**Payment**  <br>*required*|The monetary value of the order.|[Money](#money)|
|**PaymentMethod**  <br>*required*|A sub-payment method for a COD order.<br><br>Possible values:<br><br><li> COD - Cash On Delivery.</li><br><li> GC - Gift Card.</li><br><li> PointsAccount - Amazon Points.</li>|string|


<a name="buyertaxinfo"></a>
### BuyerTaxInfo
Tax information about the buyer.


|Name|Description|Schema|
|---|---|---|
|**CompanyLegalName**  <br>*optional*|The legal name of the company.|string|
|**TaxingRegion**  <br>*optional*|The country or region imposing the tax.|string|
|**TaxClassifications**  <br>*optional*|A list of tax classifications that apply to the order.|< [TaxClassification](#taxclassification) > array|


<a name="marketplacetaxinfo"></a>
### MarketplaceTaxInfo
Tax information about the marketplace.


|Name|Description|Schema|
|---|---|---|
|**TaxClassifications**  <br>*optional*|A list of tax classifications that apply to the order.|< [TaxClassification](#taxclassification) > array|


<a name="taxclassification"></a>
### TaxClassification
The tax classification for the order.


|Name|Description|Schema|
|---|---|---|
|**Name**  <br>*optional*|The type of tax.|string|
|**Value**  <br>*optional*|The buyer's tax identifier.|string|


<a name="orderitemslist"></a>
### OrderItemsList
The order items list along with the order ID.


|Name|Description|Schema|
|---|---|---|
|**OrderItems**  <br>*required*|A list of order items.|[OrderItemList](#orderitemlist)|
|**NextToken**  <br>*optional*|When present and not empty, pass this string token in the next request to return the next response page.|string|
|**AmazonOrderId**  <br>*required*|An Amazon-defined order identifier, in 3-7-7 format.|string|


<a name="orderitemlist"></a>
### OrderItemList
A list of order items.

*Type* : < [OrderItem](#orderitem) > array


<a name="orderitem"></a>
### OrderItem
A single order item.


|Name|Description|Schema|
|---|---|---|
|**ASIN**  <br>*required*|The Amazon Standard Identification Number (ASIN) of the item.|string|
|**SellerSKU**  <br>*optional*|The seller stock keeping unit (SKU) of the item.|string|
|**OrderItemId**  <br>*required*|An Amazon-defined order item identifier.|string|
|**Title**  <br>*optional*|The name of the item.|string|
|**QuantityOrdered**  <br>*required*|The number of items in the order.|integer|
|**QuantityShipped**  <br>*optional*|The number of items shipped.|integer|
|**ProductInfo**  <br>*optional*|Product information for the item.|[ProductInfoDetail](#productinfodetail)|
|**PointsGranted**  <br>*optional*|The number and value of Amazon Points granted with the purchase of an item.|[PointsGrantedDetail](#pointsgranteddetail)|
|**ItemPrice**  <br>*optional*|The selling price of the order item. Note that an order item is an item and a quantity. This means that the value of ItemPrice is equal to the selling price of the item multiplied by the quantity ordered. Note that ItemPrice excludes ShippingPrice and GiftWrapPrice.|[Money](#money)|
|**ShippingPrice**  <br>*optional*|The shipping price of the item.|[Money](#money)|
|**ItemTax**  <br>*optional*|The tax on the item price.|[Money](#money)|
|**ShippingTax**  <br>*optional*|The tax on the shipping price.|[Money](#money)|
|**ShippingDiscount**  <br>*optional*|The discount on the shipping price.|[Money](#money)|
|**ShippingDiscountTax**  <br>*optional*|The tax on the discount on the shipping price.|[Money](#money)|
|**PromotionDiscount**  <br>*optional*|The total of all promotional discounts in the offer.|[Money](#money)|
|**PromotionDiscountTax**  <br>*optional*|The tax on the total of all promotional discounts in the offer.|[Money](#money)|
|**PromotionIds**  <br>*optional*|A list of promotion identifiers provided by the seller when the promotions were created.|[PromotionIdList](#promotionidlist)|
|**CODFee**  <br>*optional*|The fee charged for COD service.|[Money](#money)|
|**CODFeeDiscount**  <br>*optional*|The discount on the COD fee.|[Money](#money)|
|**IsGift**  <br>*optional*|When true, the item is a gift.|boolean|
|**ConditionNote**  <br>*optional*|The condition of the item as described by the seller.|string|
|**ConditionId**  <br>*optional*|The condition of the item.<br><br>Possible values: New, Used, Collectible, Refurbished, Preorder, Club.|string|
|**ConditionSubtypeId**  <br>*optional*|The subcondition of the item.<br><br>Possible values: New, Mint, Very Good, Good, Acceptable, Poor, Club, OEM, Warranty, Refurbished Warranty, Refurbished, Open Box, Any, Other.|string|
|**ScheduledDeliveryStartDate**  <br>*optional*|The start date of the scheduled delivery window in the time zone of the order destination. In ISO 8601 date time format.|string|
|**ScheduledDeliveryEndDate**  <br>*optional*|The end date of the scheduled delivery window in the time zone of the order destination. In ISO 8601 date time format.|string|
|**PriceDesignation**  <br>*optional*|Indicates that the selling price is a special price that is available only for Amazon Business orders. For more information about the Amazon Business Seller Program, see the [Amazon Business website](https://www.amazon.com/b2b/info/amazon-business). <br><br>Possible values: BusinessPrice - A special price that is available only for Amazon Business orders.|string|
|**TaxCollection**  <br>*optional*|Information about withheld taxes.|[TaxCollection](#taxcollection)|
|**SerialNumberRequired**  <br>*optional*|When true, the product type for this item has a serial number.<br><br>Returned only for Amazon Easy Ship orders.|boolean|
|**IsTransparency**  <br>*optional*|When true, transparency codes are required.|boolean|
|**IossNumber**  <br>*optional*|The IOSS number for the marketplace. Sellers shipping to the European Union (EU) from outside of the EU must provide this IOSS number to their carrier when Amazon has collected the VAT on the sale.|string|
|**StoreChainStoreId**  <br>*optional*|The store chain store identifier. Linked to a specific store in a store chain.|string|
|**DeemedResellerCategory**  <br>*optional*|The category of deemed reseller. This applies to selling partners that are not based in the EU and is used to help them meet the VAT Deemed Reseller tax laws in the EU and UK.|enum ([DeemedResellerCategory](#deemedresellercategory))|
|**BuyerInfo**  <br>*optional*|A single item's buyer information.|[ItemBuyerInfo](#itembuyerinfo)|


<a name="orderitemsbuyerinfolist"></a>
### OrderItemsBuyerInfoList
A single order item's buyer information list with the order ID.


|Name|Description|Schema|
|---|---|---|
|**OrderItems**  <br>*required*|A single order item's buyer information list.|[OrderItemBuyerInfoList](#orderitembuyerinfolist)|
|**NextToken**  <br>*optional*|When present and not empty, pass this string token in the next request to return the next response page.|string|
|**AmazonOrderId**  <br>*required*|An Amazon-defined order identifier, in 3-7-7 format.|string|


<a name="orderitembuyerinfolist"></a>
### OrderItemBuyerInfoList
A single order item's buyer information list.

*Type* : < [OrderItemBuyerInfo](#orderitembuyerinfo) > array


<a name="orderitembuyerinfo"></a>
### OrderItemBuyerInfo
A single order item's buyer information.


|Name|Description|Schema|
|---|---|---|
|**OrderItemId**  <br>*required*|An Amazon-defined order item identifier.|string|
|**BuyerCustomizedInfo**  <br>*optional*|Buyer information for custom orders from the Amazon Custom program.|[BuyerCustomizedInfoDetail](#buyercustomizedinfodetail)|
|**GiftWrapPrice**  <br>*optional*|The gift wrap price of the item.|[Money](#money)|
|**GiftWrapTax**  <br>*optional*|The tax on the gift wrap price.|[Money](#money)|
|**GiftMessageText**  <br>*optional*|A gift message provided by the buyer.|string|
|**GiftWrapLevel**  <br>*optional*|The gift wrap level specified by the buyer.|string|


<a name="pointsgranteddetail"></a>
### PointsGrantedDetail
The number of Amazon Points offered with the purchase of an item, and their monetary value.


|Name|Description|Schema|
|---|---|---|
|**PointsNumber**  <br>*optional*|The number of Amazon Points granted with the purchase of an item.|integer|
|**PointsMonetaryValue**  <br>*optional*|The monetary value of the Amazon Points granted.|[Money](#money)|


<a name="productinfodetail"></a>
### ProductInfoDetail
Product information on the number of items.


|Name|Description|Schema|
|---|---|---|
|**NumberOfItems**  <br>*optional*|The total number of items that are included in the ASIN.|integer|


<a name="promotionidlist"></a>
### PromotionIdList
A list of promotion identifiers provided by the seller when the promotions were created.

*Type* : < string > array


<a name="buyercustomizedinfodetail"></a>
### BuyerCustomizedInfoDetail
Buyer information for custom orders from the Amazon Custom program.


|Name|Description|Schema|
|---|---|---|
|**CustomizedURL**  <br>*optional*|The location of a zip file containing Amazon Custom data.|string|


<a name="taxcollection"></a>
### TaxCollection
Information about withheld taxes.


|Name|Description|Schema|
|---|---|---|
|**Model**  <br>*optional*|The tax collection model applied to the item.|enum ([Model](#model))|
|**ResponsibleParty**  <br>*optional*|The party responsible for withholding the taxes and remitting them to the taxing authority.|enum ([ResponsibleParty](#responsibleparty))|


<a name="buyertaxinformation"></a>
### BuyerTaxInformation
Contains the business invoice tax information.


|Name|Description|Schema|
|---|---|---|
|**BuyerLegalCompanyName**  <br>*optional*|Business buyer's company legal name.|string|
|**BuyerBusinessAddress**  <br>*optional*|Business buyer's address.|string|
|**BuyerTaxRegistrationId**  <br>*optional*|Business buyer's tax registration ID.|string|
|**BuyerTaxOffice**  <br>*optional*|Business buyer's tax office.|string|


<a name="fulfillmentinstruction"></a>
### FulfillmentInstruction
Contains the instructions about the fulfillment like where should it be fulfilled from.


|Name|Description|Schema|
|---|---|---|
|**FulfillmentSupplySourceId**  <br>*optional*|Denotes the recommended sourceId where the order should be fulfilled from.|string|


<a name="buyerinfo"></a>
### BuyerInfo
Buyer information


|Name|Description|Schema|
|---|---|---|
|**BuyerEmail**  <br>*optional*|The anonymized email address of the buyer.|string|
|**BuyerName**  <br>*optional*|The name of the buyer.|string|
|**BuyerCounty**  <br>*optional*|The county of the buyer.|string|
|**BuyerTaxInfo**  <br>*optional*|Tax information about the buyer.|[BuyerTaxInfo](#buyertaxinfo)|
|**PurchaseOrderNumber**  <br>*optional*|The purchase order (PO) number entered by the buyer at checkout. Returned only for orders where the buyer entered a PO number at checkout.|string|


<a name="itembuyerinfo"></a>
### ItemBuyerInfo
A single item's buyer information.


|Name|Description|Schema|
|---|---|---|
|**BuyerCustomizedInfo**  <br>*optional*|Buyer information for custom orders from the Amazon Custom program.|[BuyerCustomizedInfoDetail](#buyercustomizedinfodetail)|
|**GiftWrapPrice**  <br>*optional*|The gift wrap price of the item.|[Money](#money)|
|**GiftWrapTax**  <br>*optional*|The tax on the gift wrap price.|[Money](#money)|
|**GiftMessageText**  <br>*optional*|A gift message provided by the buyer.|string|
|**GiftWrapLevel**  <br>*optional*|The gift wrap level specified by the buyer.|string|


<a name="automatedshippingsettings"></a>
### AutomatedShippingSettings
Contains information regarding the Shipping Settings Automation program, such as whether the order's shipping settings were generated automatically, and what those settings are.


|Name|Description|Schema|
|---|---|---|
|**HasAutomatedShippingSettings**  <br>*optional*|If true, this order has automated shipping settings generated by Amazon. This order could be identified as an SSA order.|boolean|
|**AutomatedCarrier**  <br>*optional*|Auto-generated carrier for SSA orders.|string|
|**AutomatedShipMethod**  <br>*optional*|Auto-generated ship method for SSA orders.|string|


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


<a name="buyerinvoicepreference"></a>
### BuyerInvoicePreference
The buyer’s invoicing preference.

*Type* : enum


|Value|Description|
|---|---|
|**INDIVIDUAL**|Buyer should be issued an individual invoice.|
|**BUSINESS**|Buyer should be issued a business invoice. Tax information is available in BuyerTaxInformation structure.|


<a name="orderstatus"></a>
### OrderStatus
The current order status.

*Type* : enum


|Value|Description|
|---|---|
|**Pending**|The order has been placed but payment has not been authorized. The order is not ready for shipment. Note that for orders with OrderType = Standard, the initial order status is Pending. For orders with OrderType = Preorder, the initial order status is PendingAvailability, and the order passes into the Pending status when the payment authorization process begins.|
|**Unshipped**|Payment has been authorized and order is ready for shipment, but no items in the order have been shipped.|
|**PartiallyShipped**|One or more (but not all) items in the order have been shipped.|
|**Shipped**|All items in the order have been shipped.|
|**Canceled**|The order was canceled.|
|**Unfulfillable**|The order cannot be fulfilled. This state applies only to Amazon-fulfilled orders that were not placed on Amazon's retail web site.|
|**InvoiceUnconfirmed**|All items in the order have been shipped. The seller has not yet given confirmation to Amazon that the invoice has been shipped to the buyer.|
|**PendingAvailability**|This status is available for pre-orders only. The order has been placed, payment has not been authorized, and the release date of the item is in the future. The order is not ready for shipment.|


<a name="ordertype"></a>
### OrderType
The type of the order.

*Type* : enum


|Value|Description|
|---|---|
|**StandardOrder**|An order that contains items for which the selling partner currently has inventory in stock.|
|**LongLeadTimeOrder**|An order that contains items that have a long lead time to ship.|
|**Preorder**|An order that contains items with a release date that is in the future.|
|**BackOrder**|An order that contains items that already have been released in the market but are currently out of stock and will be available in the future.|
|**SourcingOnDemandOrder**|A Sourcing On Demand order.|


<a name="model"></a>
### Model
The tax collection model applied to the item.

*Type* : enum


|Value|Description|
|---|---|
|**MarketplaceFacilitator**|Tax is withheld and remitted to the taxing authority by Amazon on behalf of the seller.|


<a name="paymentmethod"></a>
### PaymentMethod
The payment method for the order. This property is limited to Cash On Delivery (COD) and Convenience Store (CVS) payment methods. Unless you need the specific COD payment information provided by the PaymentExecutionDetailItem object, we recommend using the PaymentMethodDetails property to get payment method information.

*Type* : enum


|Value|Description|
|---|---|
|**COD**|Cash on delivery.|
|**CVS**|Convenience store.|
|**Other**|A payment method other than COD and CVS.|


<a name="addresstype"></a>
### AddressType
The address type of the shipping address.

*Type* : enum


|Value|Description|
|---|---|
|**Residential**|The shipping address is a residential address.|
|**Commercial**|The shipping address is a commercial address.|


<a name="responsibleparty"></a>
### ResponsibleParty
The party responsible for withholding the taxes and remitting them to the taxing authority.

*Type* : enum


|Value|Description|
|---|---|
|**Amazon Services, Inc.**|Amazon Services, Inc.|


<a name="fulfillmentchannel"></a>
### FulfillmentChannel
Whether the order was fulfilled by Amazon (AFN) or by the seller (MFN).

*Type* : enum


|Value|Description|
|---|---|
|**MFN**|Fulfilled by the seller.|
|**AFN**|Fulfilled by Amazon.|


<a name="deemedresellercategory"></a>
### DeemedResellerCategory
The category of deemed reseller. This applies to selling partners that are not based in the EU and is used to help them meet the VAT Deemed Reseller tax laws in the EU and UK.

*Type* : enum


|Value|Description|
|---|---|
|**IOSS**|Import one stop shop. The item being purchased is not held in the EU for shipment.|
|**UOSS**|Union one stop shop. The item being purchased is held in the EU for shipment.|

