# Selling Partner API for Direct Fulfillment Orders


<a name="overview"></a>
## Overview
The Selling Partner API for Direct Fulfillment Orders provides programmatic access to a direct fulfillment vendor's order data.


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
[getOrders](#getorders)<br>[getOrder](#getorder)<br>[submitAcknowledgement](#submitacknowledgement)<br>
<a name="paths"></a>
## Paths

<a name="getorders"></a>
### GET /vendor/directFulfillment/orders/v1/purchaseOrders
**Operation: getOrders**

#### Description
Returns a list of purchase orders created during the time frame that you specify. You define the time frame using the createdAfter and createdBefore parameters. You must use both parameters. You can choose to get only the purchase order numbers by setting the includeDetails parameter to false. In that case, the operation returns a list of purchase order numbers. You can then call the getOrder operation to return the details of a specific order.

**Usage Plans:**

| Plan type | Rate (requests per second) | Burst |
| ---- | ---- | ---- |
|Default| 10 | 10 |
|Selling partner specific| Variable | Variable |

The x-amzn-RateLimit-Limit response header returns the usage plan rate limits that were applied to the requested operation. Rate limits for some selling partners will vary from the default rate and burst shown in the table above. For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|Default|
|---|---|---|---|---|
|**Query**|**shipFromPartyId**  <br>*optional*|The vendor warehouse identifier for the fulfillment warehouse. If not specified, the result will contain orders for all warehouses.|string|-|
|**Query**|**status**  <br>*optional*|Returns only the purchase orders that match the specified status. If not specified, the result will contain orders that match any status.|enum ([Status](#status))|-|
|**Query**|**limit**  <br>*optional*|The limit to the number of purchase orders returned.<br>**Minimum** : 1<br>**Maximum** : 100|integer (int64)|-|
|**Query**|**createdAfter**  <br>*required*|Purchase orders that became available after this date and time will be included in the result. Must be in ISO-8601 date/time format.|string (date-time)|-|
|**Query**|**createdBefore**  <br>*required*|Purchase orders that became available before this date and time will be included in the result. Must be in ISO-8601 date/time format.|string (date-time)|-|
|**Query**|**sortOrder**  <br>*optional*|Sort the list in ascending or descending order by order creation date.|enum ([SortOrder](#sortorder))|-|
|**Query**|**nextToken**  <br>*optional*|Used for pagination when there are more orders than the specified result size limit. The token value is returned in the previous API call.|string|-|
|**Query**|**includeDetails**  <br>*optional*|When true, returns the complete purchase order details. Otherwise, only purchase order numbers are returned.|string (boolean)|`"true"`|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Success.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetOrdersResponse](#getordersresponse)|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetOrdersResponse](#getordersresponse)|
|**403**|Indicates that access to the resource is forbidden. Possible reasons include Access Denied, Unauthorized, Expired Token, or Invalid Signature.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetOrdersResponse](#getordersresponse)|
|**404**|The resource specified does not exist.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetOrdersResponse](#getordersresponse)|
|**415**|The request payload is in an unsupported format.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetOrdersResponse](#getordersresponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetOrdersResponse](#getordersresponse)|
|**500**|An unexpected condition occurred that prevented the server from fulfilling the request.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetOrdersResponse](#getordersresponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetOrdersResponse](#getordersresponse)|

For additional error status codes, descriptions and schemas, see [Error responses and schemas](#error-responses-and-schemas).
<a name="getorder"></a>
### GET /vendor/directFulfillment/orders/v1/purchaseOrders/{purchaseOrderNumber}
**Operation: getOrder**

#### Description
Returns purchase order information for the purchaseOrderNumber that you specify.

**Usage Plans:**

| Plan type | Rate (requests per second) | Burst |
| ---- | ---- | ---- |
|Default| 10 | 10 |
|Selling partner specific| Variable | Variable |

The x-amzn-RateLimit-Limit response header returns the usage plan rate limits that were applied to the requested operation. Rate limits for some selling partners will vary from the default rate and burst shown in the table above. For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**purchaseOrderNumber**  <br>*required*|The order identifier for the purchase order that you want. Formatting Notes: alpha-numeric code.|string|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Success.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetOrderResponse](#getorderresponse)|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetOrderResponse](#getorderresponse)|
|**403**|Indicates that access to the resource is forbidden. Possible reasons include Access Denied, Unauthorized, Expired Token, or Invalid Signature.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetOrderResponse](#getorderresponse)|
|**404**|The resource specified does not exist.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetOrderResponse](#getorderresponse)|
|**415**|The request payload is in an unsupported format.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetOrderResponse](#getorderresponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetOrderResponse](#getorderresponse)|
|**500**|An unexpected condition occurred that prevented the server from fulfilling the request.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetOrderResponse](#getorderresponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetOrderResponse](#getorderresponse)|

For additional error status codes, descriptions and schemas, see [Error responses and schemas](#error-responses-and-schemas).
<a name="submitacknowledgement"></a>
### POST /vendor/directFulfillment/orders/v1/acknowledgements
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
|**Body**|**body**  <br>*required*|The request schema for the submitAcknowledgement operation.|[SubmitAcknowledgementRequest](#submitacknowledgementrequest)|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**202**|Success.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[SubmitAcknowledgementResponse](#submitacknowledgementresponse)|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[SubmitAcknowledgementResponse](#submitacknowledgementresponse)|
|**403**|Indicates that access to the resource is forbidden. Possible reasons include Access Denied, Unauthorized, Expired Token, or Invalid Signature.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[SubmitAcknowledgementResponse](#submitacknowledgementresponse)|
|**404**|The resource specified does not exist.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[SubmitAcknowledgementResponse](#submitacknowledgementresponse)|
|**415**|The request payload is in an unsupported format.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[SubmitAcknowledgementResponse](#submitacknowledgementresponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[SubmitAcknowledgementResponse](#submitacknowledgementresponse)|
|**500**|An unexpected condition occurred that prevented the server from fulfilling the request.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[SubmitAcknowledgementResponse](#submitacknowledgementresponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[SubmitAcknowledgementResponse](#submitacknowledgementresponse)|

For additional error status codes, descriptions and schemas, see [Error responses and schemas](#error-responses-and-schemas).



<a name="error-responses-and-schemas"></a>
### Error Responses and Schemas
This table contains HTTP status codes and associated information for error responses.

|HTTP Code|Description|Schema|
|---|---|---|
|**401**|The request's Authorization header is not formatted correctly or does not contain a valid token.  <br>**Headers**:  <br>`x-amzn-RateLimit-Limit` (string):Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string):Unique request reference identifier.|[GetOrderResponse](#getorderresponse)|
|**413**|The request size exceeded the maximum accepted size.  <br>**Headers**:  <br>`x-amzn-RateLimit-Limit` (string):Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string):Unique request reference identifier.|[SubmitAcknowledgementResponse](#submitacknowledgementresponse)|


<a name="definitions"></a>
## Definitions

<a name="getordersresponse"></a>
### GetOrdersResponse
The response schema for the getOrders operation.


|Name|Description|Schema|
|---|---|---|
|**payload**  <br>*optional*|A list of purchase orders.|[OrderList](#orderlist)|
|**errors**  <br>*optional*|A list of error responses returned when a request is unsuccessful.|[ErrorList](#errorlist)|


<a name="getorderresponse"></a>
### GetOrderResponse
The response schema for the getOrder operation.


|Name|Description|Schema|
|---|---|---|
|**payload**  <br>*optional*|The payload for the getOrder operation.|[Order](#order)|


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
|**nextToken**  <br>*optional*|A generated string used to pass information to your next request. If NextToken is returned, pass the value of NextToken to the next request. If NextToken is not returned, there are no more order items to return.|string|


<a name="order"></a>
### Order

|Name|Description|Schema|
|---|---|---|
|**purchaseOrderNumber**  <br>*required*|The purchase order number for this order. Formatting Notes: alpha-numeric code.|string|
|**orderDetails**  <br>*optional*|Purchase order details.|[OrderDetails](#orderdetails)|


<a name="orderdetails"></a>
### OrderDetails
Details of an order.


|Name|Description|Schema|
|---|---|---|
|**customerOrderNumber**  <br>*required*|The customer order number.|string|
|**orderDate**  <br>*required*|The date the order was placed. This field is expected to be in ISO-8601 date/time format, for example:2018-07-16T23:00:00Z/ 2018-07-16T23:00:00-05:00 /2018-07-16T23:00:00-08:00. If no time zone is specified, UTC should be assumed.|string (date-time)|
|**orderStatus**  <br>*optional*|Current status of the order.|enum ([OrderStatus](#orderstatus))|
|**shipmentDetails**  <br>*required*|Shipment details required for the shipment.|[ShipmentDetails](#shipmentdetails)|
|**taxTotal**  <br>*optional*|-|[taxTotal](#orderdetails-taxtotal)|
|**sellingParty**  <br>*required*|PartyID of vendor code.|[PartyIdentification](#partyidentification)|
|**shipFromParty**  <br>*required*|PartyID of vendor's warehouse.|[PartyIdentification](#partyidentification)|
|**shipToParty**  <br>*required*|Name/Address and tax details of the ship to party.|[Address](#address)|
|**billToParty**  <br>*required*|Name/Address and tax details of the bill to party.|[PartyIdentification](#partyidentification)|
|**items**  <br>*required*|A list of items in this purchase order.|< [OrderItem](#orderitem) > array|

<a name="orderdetails-taxtotal"></a>
**taxTotal**

|Name|Description|Schema|
|---|---|---|
|**taxLineItem**  <br>*optional*|Tax details.|[TaxLineItem](#taxlineitem)|


<a name="partyidentification"></a>
### PartyIdentification

|Name|Description|Schema|
|---|---|---|
|**partyId**  <br>*required*|Assigned identification for the party. For example, warehouse code or vendor code. Please refer to specific party for more details.|string|
|**address**  <br>*optional*|Address details of the party.|[Address](#address)|
|**taxInfo**  <br>*optional*|Tax registration details of the entity.|[TaxRegistrationDetails](#taxregistrationdetails)|


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
|**attention**  <br>*optional*|The attention name of the person at that address.|string|
|**addressLine1**  <br>*required*|First line of the address.|string|
|**addressLine2**  <br>*optional*|Additional address information, if required.|string|
|**addressLine3**  <br>*optional*|Additional address information, if required.|string|
|**city**  <br>*optional*|The city where the person, business or institution is located.|string|
|**county**  <br>*optional*|The county where person, business or institution is located.|string|
|**district**  <br>*optional*|The district where person, business or institution is located.|string|
|**stateOrRegion**  <br>*required*|The state or region where person, business or institution is located.|string|
|**postalCode**  <br>*optional*|The postal code of that address. It conatins a series of letters or digits or both, sometimes including spaces or punctuation.|string|
|**countryCode**  <br>*required*|The two digit country code. In ISO 3166-1 alpha-2 format.|string|
|**phone**  <br>*optional*|The phone number of the person, business or institution located at that address.|string|


<a name="orderitem"></a>
### OrderItem

|Name|Description|Schema|
|---|---|---|
|**itemSequenceNumber**  <br>*required*|Numbering of the item on the purchase order. The first item will be 1, the second 2, and so on.|string|
|**buyerProductIdentifier**  <br>*optional*|Buyer's standard identification number (ASIN) of an item.|string|
|**vendorProductIdentifier**  <br>*optional*|The vendor selected product identification of the item.|string|
|**title**  <br>*optional*|Title for the item.|string|
|**orderedQuantity**  <br>*required*|Item quantity ordered.|[ItemQuantity](#itemquantity)|
|**scheduledDeliveryShipment**  <br>*optional*|Details for the scheduled delivery shipment.|[ScheduledDeliveryShipment](#scheduleddeliveryshipment)|
|**giftDetails**  <br>*optional*|Gift message and wrapId details.|[GiftDetails](#giftdetails)|
|**netPrice**  <br>*required*|Net price (before tax) to vendor with currency details.|[Money](#money)|
|**taxDetails**  <br>*optional*|Total tax details for the line item.|[taxDetails](#orderitem-taxdetails)|
|**totalPrice**  <br>*optional*|The price to Amazon each (cost).|[Money](#money)|

<a name="orderitem-taxdetails"></a>
**taxDetails**

|Name|Description|Schema|
|---|---|---|
|**taxLineItem**  <br>*optional*|Tax details.|[TaxLineItem](#taxlineitem)|


<a name="money"></a>
### Money
An amount of money, including units in the form of currency.


|Name|Description|Schema|
|---|---|---|
|**currencyCode**  <br>*optional*|Three digit currency code in ISO 4217 format. String of length 3.|string|
|**amount**  <br>*optional*|A decimal number with no loss of precision. Useful when precision loss is unacceptable, as with currencies. Follows RFC7159 for number representation.|[Decimal](#decimal)|


<a name="decimal"></a>
### Decimal
A decimal number with no loss of precision. Useful when precision loss is unacceptable, as with currencies. Follows RFC7159 for number representation.

*Type* : string


<a name="submitacknowledgementresponse"></a>
### SubmitAcknowledgementResponse
The response schema for the submitAcknowledgement operation.


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
The request schema for the submitAcknowledgement operation.


|Name|Description|Schema|
|---|---|---|
|**orderAcknowledgements**  <br>*optional*|A list of one or more purchase orders.|< [OrderAcknowledgementItem](#orderacknowledgementitem) > array|


<a name="orderacknowledgementitem"></a>
### OrderAcknowledgementItem
Details of an individual order being acknowledged.


|Name|Description|Schema|
|---|---|---|
|**purchaseOrderNumber**  <br>*required*|The purchase order number for this order. Formatting Notes: alpha-numeric code.|string|
|**vendorOrderNumber**  <br>*required*|The vendor's order number for this order.|string|
|**acknowledgementDate**  <br>*required*|The date and time when the order is acknowledged, in ISO-8601 date/time format. For example: 2018-07-16T23:00:00Z / 2018-07-16T23:00:00-05:00 / 2018-07-16T23:00:00-08:00.|string (date-time)|
|**acknowledgementStatus**  <br>*required*|Status of acknowledgement.|[AcknowledgementStatus](#acknowledgementstatus)|
|**sellingParty**  <br>*required*|PartyID as vendor code.|[PartyIdentification](#partyidentification)|
|**shipFromParty**  <br>*required*|PartyID as the vendor's warehouseId.|[PartyIdentification](#partyidentification)|
|**itemAcknowledgements**  <br>*required*|Item details including acknowledged quantity.|< [OrderItemAcknowledgement](#orderitemacknowledgement) > array|


<a name="orderitemacknowledgement"></a>
### OrderItemAcknowledgement

|Name|Description|Schema|
|---|---|---|
|**itemSequenceNumber**  <br>*required*|Line item sequence number for the item.|string|
|**buyerProductIdentifier**  <br>*optional*|Buyer's standard identification number (ASIN) of an item.|string|
|**vendorProductIdentifier**  <br>*optional*|The vendor selected product identification of the item. Should be the same as was provided in the purchase order.|string|
|**acknowledgedQuantity**  <br>*required*|Details of quantity acknowledged with the above acknowledgement code.|[ItemQuantity](#itemquantity)|


<a name="itemquantity"></a>
### ItemQuantity
Details of quantity ordered.


|Name|Description|Schema|
|---|---|---|
|**amount**  <br>*optional*|Acknowledged quantity. This value should not be zero.|integer|
|**unitOfMeasure**  <br>*optional*|Unit of measure for the acknowledged quantity.|enum ([UnitOfMeasure](#unitofmeasure))|


<a name="taxlineitem"></a>
### TaxLineItem
A list of tax line items.

*Type* : < [TaxDetails](#taxdetails) > array


<a name="taxdetails"></a>
### TaxDetails

|Name|Description|Schema|
|---|---|---|
|**taxRate**  <br>*optional*|A decimal number with no loss of precision. Useful when precision loss is unacceptable, as with currencies. Follows RFC7159 for number representation.|[Decimal](#decimal)|
|**taxAmount**  <br>*required*|An amount of money, including units in the form of currency.|[Money](#money)|
|**taxableAmount**  <br>*optional*|An amount of money, including units in the form of currency.|[Money](#money)|
|**type**  <br>*optional*|Tax type.|enum ([Type](#type))|


<a name="acknowledgementstatus"></a>
### AcknowledgementStatus
Status of acknowledgement.


|Name|Description|Schema|
|---|---|---|
|**code**  <br>*optional*|Acknowledgement code is a unique two digit value which indicates the status of the acknowledgement. For a list of acknowledgement codes that Amazon supports, see the Vendor Direct Fulfillment APIs Use Case Guide.|string|
|**description**  <br>*optional*|Reason for the acknowledgement code.|string|


<a name="error"></a>
### Error
Error response returned when the request is unsuccessful.


|Name|Description|Schema|
|---|---|---|
|**code**  <br>*required*|An error code that identifies the type of error that occurred.|string|
|**message**  <br>*required*|A message that describes the error condition.|string|
|**details**  <br>*optional*|Additional details that can help the caller understand or fix the issue.|string|


<a name="shipmentdetails"></a>
### ShipmentDetails
Shipment details required for the shipment.


|Name|Description|Schema|
|---|---|---|
|**isPriorityShipment**  <br>*required*|When true, this is a priority shipment.|boolean|
|**isScheduledDeliveryShipment**  <br>*optional*|When true, this order is part of a scheduled delivery program.|boolean|
|**isPslipRequired**  <br>*required*|When true, a packing slip is required to be sent to the customer.|boolean|
|**isGift**  <br>*optional*|When true, the order contain a gift. Include the gift message and gift wrap information.|boolean|
|**shipMethod**  <br>*required*|Ship method to be used for shipping the order. Amazon defines ship method codes indicating the shipping carrier and shipment service level. To see the full list of ship methods in use, including both the code and the friendly name, search the 'Help' section on Vendor Central for 'ship methods'.|string|
|**shipmentDates**  <br>*required*|Shipment dates.|[ShipmentDates](#shipmentdates)|
|**messageToCustomer**  <br>*required*|Message to customer for order status.|string|


<a name="shipmentdates"></a>
### ShipmentDates
Shipment dates.


|Name|Description|Schema|
|---|---|---|
|**requiredShipDate**  <br>*required*|Time by which the vendor is required to ship the order.|string (date-time)|
|**promisedDeliveryDate**  <br>*optional*|Delivery date promised to the Amazon customer.|string (date-time)|


<a name="scheduleddeliveryshipment"></a>
### ScheduledDeliveryShipment
Dates for the scheduled delivery shipments.


|Name|Description|Schema|
|---|---|---|
|**scheduledDeliveryServiceType**  <br>*optional*|Scheduled delivery service type.|string|
|**earliestNominatedDeliveryDate**  <br>*optional*|Earliest nominated delivery date for the scheduled delivery.|string (date-time)|
|**latestNominatedDeliveryDate**  <br>*optional*|Latest nominated delivery date for the scheduled delivery.|string (date-time)|


<a name="giftdetails"></a>
### GiftDetails
Gift details for the item.


|Name|Description|Schema|
|---|---|---|
|**giftMessage**  <br>*optional*|Gift message to be printed in shipment.|string|
|**giftWrapId**  <br>*optional*|Gift wrap identifier for the gift wrapping, if any.|string|


<a name="status"></a>
### Status
Returns only the purchase orders that match the specified status. If not specified, the result will contain orders that match any status.

*Type* : enum


|Value|Description|
|---|---|
|**NEW**|Status for newly created purchase orders.|
|**SHIPPED**|Status for purchase orders that are already shipped.|
|**ACCEPTED**|Status for purchase orders accepted by vendors.|
|**CANCELLED**|Status for cancelled purchase orders.|


<a name="orderstatus"></a>
### OrderStatus
Current status of the order.

*Type* : enum


|Value|Description|
|---|---|
|**NEW**|Status for newly created orders.|
|**SHIPPED**|Status for orders that are already shipped.|
|**ACCEPTED**|Status for orders accepted by vendors.|
|**CANCELLED**|Status for cancelled orders.|


<a name="type"></a>
### Type
Tax type.

*Type* : enum


|Value|Description|
|---|---|
|**CONSUMPTION**|Tax levied on consumption spending on goods and services.|
|**GST**|Tax levied on most goods and services sold for domestic consumption.|
|**MwSt.**|Mehrwertsteuer, MwSt, is German for value-added tax.|
|**PST**|A provincial sales tax (PST) is imposed on consumers of goods and particular services in many Canadian provinces.|
|**TOTAL**|Combined total of all the applicable taxes.|
|**TVA**|Taxe sur la Valeur Ajout&#233;e (TVA) is French for value-added tax.|
|**VAT**|Value-added tax.|


<a name="unitofmeasure"></a>
### UnitOfMeasure
Unit of measure for the acknowledged quantity.

*Type* : enum


|Value|Description|
|---|---|
|**Each**|Unit of measure to represent individual piece.|


<a name="taxregistrationtype"></a>
### TaxRegistrationType
Tax registration type for the entity.

*Type* : enum


|Value|Description|
|---|---|
|**VAT**|Value-added tax.|
|**GST**|Goods and Services tax.|


<a name="sortorder"></a>
### SortOrder
Sort the list in ascending or descending order by order creation date.

*Type* : enum


|Value|Description|
|---|---|
|**ASC**|Sort in ascending order by order creation date.|
|**DESC**|Sort in descending order by order creation date.|

