# Selling Partner API for Shipment Invoicing


<a name="overview"></a>
## Overview
The Selling Partner API for Shipment Invoicing helps you programmatically retrieve shipment invoice information in the Brazil marketplace for a selling partner’s Fulfillment by Amazon (FBA) orders.


### Version information
*Version* : v0


### Contact information
*Contact* : Selling Partner API Developer Support  
*Contact URL* : https://sellercentral.amazon.com/gp/mws/contactus.html  


### License information
*License* : Apache License 2.0  
*License URL* : http://www.apache.org/licenses/LICENSE-2.0  


### URI scheme
*BasePath* : /  
*Schemes* : HTTPS


### Consumes

* `application/json`


### Produces

* `application/json`


### Operations
[getShipmentDetails](#getshipmentdetails)<br>[submitInvoice](#submitinvoice)<br>[getInvoiceStatus](#getinvoicestatus)<br>
<a name="paths"></a>
## Paths

<a name="getshipmentdetails"></a>
### GET /fba/outbound/brazil/v0/shipments/{shipmentId}
**Operation: getShipmentDetails**

#### Description
Returns the shipment details required to issue an invoice for the specified shipment.

**Usage Plans:**

| Plan type | Rate (requests per second) | Burst |
| ---- | ---- | ---- |
|Default| 1.133 | 25 |
|Selling partner specific| Variable | Variable |

The x-amzn-RateLimit-Limit response header returns the usage plan rate limits that were applied to the requested operation. Rate limits for some selling partners will vary from the default rate and burst shown in the table above. For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**shipmentId**  <br>*required*|The identifier for the shipment. Get this value from the FBAOutboundShipmentStatus notification. For information about subscribing to notifications, see the [Notifications API Use Case Guide](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/use-case-guides/notifications-api-use-case-guide/notifications-use-case-guide-v1.md).|string|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Success.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetShipmentDetailsResponse](#getshipmentdetailsresponse)|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetShipmentDetailsResponse](#getshipmentdetailsresponse)|
|**401**|The request's Authorization header is not formatted correctly or does not contain a valid token.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetShipmentDetailsResponse](#getshipmentdetailsresponse)|
|**403**|Indicates that access to the resource is forbidden. Possible reasons include Access Denied, Unauthorized, Expired Token, or Invalid Signature.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetShipmentDetailsResponse](#getshipmentdetailsresponse)|
|**404**|The resource specified does not exist.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetShipmentDetailsResponse](#getshipmentdetailsresponse)|
|**415**|The request payload is in an unsupported format.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetShipmentDetailsResponse](#getshipmentdetailsresponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetShipmentDetailsResponse](#getshipmentdetailsresponse)|
|**500**|An unexpected condition occurred that prevented the server from fulfilling the request.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetShipmentDetailsResponse](#getshipmentdetailsresponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetShipmentDetailsResponse](#getshipmentdetailsresponse)|


<a name="submitinvoice"></a>
### POST /fba/outbound/brazil/v0/shipments/{shipmentId}/invoice
**Operation: submitInvoice**

#### Description
Submits a shipment invoice document for a given shipment.

**Usage Plans:**

| Plan type | Rate (requests per second) | Burst |
| ---- | ---- | ---- |
|Default| 1.133 | 25 |
|Selling partner specific| Variable | Variable |

The x-amzn-RateLimit-Limit response header returns the usage plan rate limits that were applied to the requested operation. Rate limits for some selling partners will vary from the default rate and burst shown in the table above. For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**shipmentId**  <br>*required*|The identifier for the shipment.|string|
|**Body**|**body**  <br>*required*|The request schema for the submitInvoice operation.|[SubmitInvoiceRequest](#submitinvoicerequest)|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Success.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[SubmitInvoiceResponse](#submitinvoiceresponse)|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[SubmitInvoiceResponse](#submitinvoiceresponse)|
|**401**|The request's Authorization header is not formatted correctly or does not contain a valid token.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[SubmitInvoiceResponse](#submitinvoiceresponse)|
|**403**|Indicates that access to the resource is forbidden. Possible reasons include Access Denied, Unauthorized, Expired Token, or Invalid Signature.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[SubmitInvoiceResponse](#submitinvoiceresponse)|
|**404**|The resource specified does not exist.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[SubmitInvoiceResponse](#submitinvoiceresponse)|
|**415**|The request payload is in an unsupported format.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[SubmitInvoiceResponse](#submitinvoiceresponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[SubmitInvoiceResponse](#submitinvoiceresponse)|
|**500**|An unexpected condition occurred that prevented the server from fulfilling the request.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[SubmitInvoiceResponse](#submitinvoiceresponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[SubmitInvoiceResponse](#submitinvoiceresponse)|


<a name="getinvoicestatus"></a>
### GET /fba/outbound/brazil/v0/shipments/{shipmentId}/invoice/status
**Operation: getInvoiceStatus**

#### Description
Returns the invoice status for the shipment you specify.

**Usage Plans:**

| Plan type | Rate (requests per second) | Burst |
| ---- | ---- | ---- |
|Default| 1.133 | 25 |
|Selling partner specific| Variable | Variable |

The x-amzn-RateLimit-Limit response header returns the usage plan rate limits that were applied to the requested operation. Rate limits for some selling partners will vary from the default rate and burst shown in the table above. For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**shipmentId**  <br>*required*|The shipment identifier for the shipment.|string|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Success.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetInvoiceStatusResponse](#getinvoicestatusresponse)|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetInvoiceStatusResponse](#getinvoicestatusresponse)|
|**401**|The request's Authorization header is not formatted correctly or does not contain a valid token.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetInvoiceStatusResponse](#getinvoicestatusresponse)|
|**403**|Indicates that access to the resource is forbidden. Possible reasons include Access Denied, Unauthorized, Expired Token, or Invalid Signature.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetInvoiceStatusResponse](#getinvoicestatusresponse)|
|**404**|The resource specified does not exist.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetInvoiceStatusResponse](#getinvoicestatusresponse)|
|**415**|The request payload is in an unsupported format.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetInvoiceStatusResponse](#getinvoicestatusresponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetInvoiceStatusResponse](#getinvoicestatusresponse)|
|**500**|An unexpected condition occurred that prevented the server from fulfilling the request.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetInvoiceStatusResponse](#getinvoicestatusresponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetInvoiceStatusResponse](#getinvoicestatusresponse)|


<a name="definitions"></a>
## Definitions

<a name="getshipmentdetailsresponse"></a>
### GetShipmentDetailsResponse
The response schema for the getShipmentDetails operation.


|Name|Description|Schema|
|---|---|---|
|**payload**  <br>*optional*|The payload for the getShipmentDetails operation|[ShipmentDetail](#shipmentdetail)|
|**errors**  <br>*optional*|A list of error responses returned when a request is unsuccessful.|[ErrorList](#errorlist)|


<a name="shipmentdetail"></a>
### ShipmentDetail
The information required by a selling partner to issue a shipment invoice.


|Name|Description|Schema|
|---|---|---|
|**WarehouseId**  <br>*optional*|The Amazon-defined identifier for the warehouse.|string|
|**AmazonOrderId**  <br>*optional*|The Amazon-defined identifier for the order.|string|
|**AmazonShipmentId**  <br>*optional*|The Amazon-defined identifier for the shipment.|string|
|**PurchaseDate**  <br>*optional*|The date and time when the order was created.|string (date-time)|
|**ShippingAddress**  <br>*optional*|The shipping address details of the shipment.|[Address](#address)|
|**PaymentMethodDetails**  <br>*optional*|The list of payment method details.|[PaymentMethodDetailItemList](#paymentmethoddetailitemlist)|
|**MarketplaceId**  <br>*optional*|The identifier for the marketplace where the order was placed.|string|
|**SellerId**  <br>*optional*|The seller identifier.|string|
|**BuyerName**  <br>*optional*|The name of the buyer.|string|
|**BuyerCounty**  <br>*optional*|The county of the buyer.|string|
|**BuyerTaxInfo**  <br>*optional*|Tax information about the buyer.|[BuyerTaxInfo](#buyertaxinfo)|
|**MarketplaceTaxInfo**  <br>*optional*|Tax information about the marketplace.|[MarketplaceTaxInfo](#marketplacetaxinfo)|
|**SellerDisplayName**  <br>*optional*|The seller’s friendly name registered in the marketplace.|string|
|**ShipmentItems**  <br>*optional*|A list of shipment items.|[ShipmentItems](#shipmentitems)|


<a name="address"></a>
### Address
The shipping address details of the shipment.


|Name|Description|Schema|
|---|---|---|
|**Name**  <br>*optional*|The name.|string|
|**AddressLine1**  <br>*optional*|The street address.|string|
|**AddressLine2**  <br>*optional*|Additional street address information, if required.|string|
|**AddressLine3**  <br>*optional*|Additional street address information, if required.|string|
|**City**  <br>*optional*|The city.|string|
|**County**  <br>*optional*|The county.|string|
|**District**  <br>*optional*|The district.|string|
|**StateOrRegion**  <br>*optional*|The state or region.|string|
|**PostalCode**  <br>*optional*|The postal code.|string|
|**CountryCode**  <br>*optional*|The country code.|string|
|**Phone**  <br>*optional*|The phone number.|string|
|**AddressType**  <br>*optional*|The shipping address type.|[AddressTypeEnum](#addresstypeenum)|


<a name="addresstypeenum"></a>
### AddressTypeEnum
The shipping address type.

*Type* : enum


|Value|Description|
|---|---|
|**Residential**|The address type is residential.|
|**Commercial**|The address type is commercial.|


<a name="paymentmethoddetailitemlist"></a>
### PaymentMethodDetailItemList
The list of payment method details.

*Type* : < string > array


<a name="buyertaxinfo"></a>
### BuyerTaxInfo
Tax information about the buyer.


|Name|Description|Schema|
|---|---|---|
|**CompanyLegalName**  <br>*optional*|The legal name of the company.|string|
|**TaxingRegion**  <br>*optional*|The country or region imposing the tax.|string|
|**TaxClassifications**  <br>*optional*|The list of tax classifications.|[TaxClassificationList](#taxclassificationlist)|


<a name="marketplacetaxinfo"></a>
### MarketplaceTaxInfo
Tax information about the marketplace.


|Name|Description|Schema|
|---|---|---|
|**CompanyLegalName**  <br>*optional*|The legal name of the company.|string|
|**TaxingRegion**  <br>*optional*|The country or region imposing the tax.|string|
|**TaxClassifications**  <br>*optional*|The list of tax classifications.|[TaxClassificationList](#taxclassificationlist)|


<a name="taxclassificationlist"></a>
### TaxClassificationList
The list of tax classifications.

*Type* : < [TaxClassification](#taxclassification) > array


<a name="taxclassification"></a>
### TaxClassification
The tax classification for the entity.


|Name|Description|Schema|
|---|---|---|
|**Name**  <br>*optional*|The type of tax.|string|
|**Value**  <br>*optional*|The entity's tax identifier.|string|


<a name="shipmentitems"></a>
### ShipmentItems
A list of shipment items.

*Type* : < [ShipmentItem](#shipmentitem) > array


<a name="shipmentitem"></a>
### ShipmentItem
The shipment item information required by a seller to issue a shipment invoice.


|Name|Description|Schema|
|---|---|---|
|**ASIN**  <br>*optional*|The Amazon Standard Identification Number (ASIN) of the item.|string|
|**SellerSKU**  <br>*optional*|The seller SKU of the item.|string|
|**OrderItemId**  <br>*optional*|The Amazon-defined identifier for the order item.|string|
|**Title**  <br>*optional*|The name of the item.|string|
|**QuantityOrdered**  <br>*optional*|The number of items ordered.|number|
|**ItemPrice**  <br>*optional*|The selling price of the item multiplied by the quantity ordered. Note that ItemPrice excludes ShippingPrice and GiftWrapPrice.|[Money](#money)|
|**ShippingPrice**  <br>*optional*|The shipping price of the item.|[Money](#money)|
|**GiftWrapPrice**  <br>*optional*|The gift wrap price of the item.|[Money](#money)|
|**ShippingDiscount**  <br>*optional*|The discount on the shipping price.|[Money](#money)|
|**PromotionDiscount**  <br>*optional*|The total of all promotional discounts in the offer.|[Money](#money)|
|**SerialNumbers**  <br>*optional*|The list of serial numbers.|[SerialNumbersList](#serialnumberslist)|


<a name="money"></a>
### Money
The currency type and amount.


|Name|Description|Schema|
|---|---|---|
|**CurrencyCode**  <br>*optional*|Three-digit currency code in ISO 4217 format.|string|
|**Amount**  <br>*optional*|The currency amount.|string|


<a name="serialnumberslist"></a>
### SerialNumbersList
The list of serial numbers.

*Type* : < string > array


<a name="errorlist"></a>
### ErrorList
A list of error responses returned when a request is unsuccessful.

*Type* : < [Error](#error) > array


<a name="error"></a>
### Error
An error response returned when the request is unsuccessful.


|Name|Description|Schema|
|---|---|---|
|**code**  <br>*required*|An error code that identifies the type of error that occurred.|string|
|**message**  <br>*required*|A message that describes the error condition.|string|
|**details**  <br>*optional*|Additional details that can help the caller understand or fix the issue.|string|


<a name="submitinvoicerequest"></a>
### SubmitInvoiceRequest
The request schema for the submitInvoice operation.


|Name|Description|Schema|
|---|---|---|
|**InvoiceContent**  <br>*required*|Shipment invoice document content.|[Blob](#blob)|
|**MarketplaceId**  <br>*optional*|An Amazon marketplace identifier.|string|
|**ContentMD5Value**  <br>*required*|MD5 sum for validating the invoice data. For more information about calculating this value, see [Working with Content-MD5 Checksums](https://docs.developer.amazonservices.com/en_US/dev_guide/DG_MD5.html).|string|


<a name="blob"></a>
### Blob
Shipment invoice document content.

*Type* : string (byte)


<a name="submitinvoiceresponse"></a>
### SubmitInvoiceResponse
The response schema for the submitInvoice operation.


|Name|Description|Schema|
|---|---|---|
|**errors**  <br>*optional*|A list of error responses returned when a request is unsuccessful.|[ErrorList](#errorlist)|


<a name="shipmentinvoicestatusinfo"></a>
### ShipmentInvoiceStatusInfo
The shipment invoice status information.


|Name|Description|Schema|
|---|---|---|
|**AmazonShipmentId**  <br>*optional*|The Amazon-defined shipment identifier.|string|
|**InvoiceStatus**  <br>*optional*|The shipment invoice status.|[ShipmentInvoiceStatus](#shipmentinvoicestatus)|


<a name="shipmentinvoicestatus"></a>
### ShipmentInvoiceStatus
The shipment invoice status.

*Type* : enum


|Value|Description|
|---|---|
|**Processing**|The invoice validation process is in progress.|
|**Accepted**|The invoice validation process succeeded, and the invoice was successfully ingested.|
|**Errored**|The invoice validation process failed.|
|**NotFound**|The requested invoice was not found.|


<a name="shipmentinvoicestatusresponse"></a>
### ShipmentInvoiceStatusResponse
The shipment invoice status response.


|Name|Description|Schema|
|---|---|---|
|**Shipments**  <br>*optional*|The shipment invoice status information.|[ShipmentInvoiceStatusInfo](#shipmentinvoicestatusinfo)|


<a name="getinvoicestatusresponse"></a>
### GetInvoiceStatusResponse
The response schema for the getInvoiceStatus operation.


|Name|Description|Schema|
|---|---|---|
|**payload**  <br>*optional*|The payload for the getInvoiceStatus operation.|[ShipmentInvoiceStatusResponse](#shipmentinvoicestatusresponse)|
|**errors**  <br>*optional*|A list of error responses returned when a request is unsuccessful.|[ErrorList](#errorlist)|

