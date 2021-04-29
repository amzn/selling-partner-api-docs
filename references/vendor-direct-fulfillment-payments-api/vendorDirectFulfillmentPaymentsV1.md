# Selling Partner API for Direct Fulfillment Payments


<a name="overview"></a>
## Overview
The Selling Partner API for Direct Fulfillment Payments provides programmatic access to a direct fulfillment vendor's invoice data.


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
[submitInvoice](#submitinvoice)<br>
<a name="paths"></a>
## Paths

<a name="submitinvoice"></a>
### POST /vendor/directFulfillment/payments/v1/invoices
**Operation: submitInvoice**

#### Description
Submits one or more invoices for a vendor's direct fulfillment orders.

**Usage Plans:**

| Plan type | Rate (requests per second) | Burst |
| ---- | ---- | ---- |
|Default| 10 | 10 |
|Selling partner specific| Variable | Variable |

The x-amzn-RateLimit-Limit response header returns the usage plan rate limits that were applied to the requested operation. Rate limits for some selling partners will vary from the default rate and burst shown in the table above. For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Body**|**body**  <br>*required*|The request schema for the submitInvoice operation.|[SubmitInvoiceRequest](#submitinvoicerequest)|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**202**|Success.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[SubmitInvoiceResponse](#submitinvoiceresponse)|

For error status codes, descriptions and schemas, see [Error responses and schemas](#error-responses-and-schemas).



<a name="error-responses-and-schemas"></a>
### Error Responses and Schemas
This table contains HTTP status codes and associated information for error responses.

|HTTP Code|Description|Schema|
|---|---|---|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers**:  <br>`x-amzn-RateLimit-Limit` (string):Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string):Unique request reference identifier.|[SubmitInvoiceResponse](#submitinvoiceresponse)|
|**403**|Indicates that access to the resource is forbidden. Possible reasons include Access Denied, Unauthorized, Expired Token, or Invalid Signature.  <br>**Headers**:  <br>`x-amzn-RequestId` (string):Unique request reference identifier.|[SubmitInvoiceResponse](#submitinvoiceresponse)|
|**404**|The resource specified does not exist.  <br>**Headers**:  <br>`x-amzn-RequestId` (string):Unique request reference identifier.|[SubmitInvoiceResponse](#submitinvoiceresponse)|
|**413**|The request size exceeded the maximum accepted size.  <br>**Headers**:  <br>`x-amzn-RateLimit-Limit` (string):Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string):Unique request reference identifier.|[SubmitInvoiceResponse](#submitinvoiceresponse)|
|**415**|The request payload is in an unsupported format.  <br>**Headers**:  <br>`x-amzn-RateLimit-Limit` (string):Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string):Unique request reference identifier.|[SubmitInvoiceResponse](#submitinvoiceresponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers**:  <br>`x-amzn-RateLimit-Limit` (string):Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string):Unique request reference identifier.|[SubmitInvoiceResponse](#submitinvoiceresponse)|
|**500**|An unexpected condition occurred that prevented the server from fulfilling the request.  <br>**Headers**:  <br>`x-amzn-RateLimit-Limit` (string):Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string):Unique request reference identifier.|[SubmitInvoiceResponse](#submitinvoiceresponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers**:  <br>`x-amzn-RateLimit-Limit` (string):Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string):Unique request reference identifier.|[SubmitInvoiceResponse](#submitinvoiceresponse)|


<a name="definitions"></a>
## Definitions

<a name="submitinvoicerequest"></a>
### SubmitInvoiceRequest
The request schema for the submitInvoice operation.


|Name|Schema|
|---|---|
|**invoices**  <br>*optional*|< [InvoiceDetail](#invoicedetail) > array|


<a name="invoicedetail"></a>
### InvoiceDetail

|Name|Description|Schema|
|---|---|---|
|**invoiceNumber**  <br>*required*|The unique invoice number.|string|
|**invoiceDate**  <br>*required*|Invoice date.|string (date-time)|
|**referenceNumber**  <br>*optional*|An additional unique reference number used for regulatory or other purposes.|string|
|**remitToParty**  <br>*required*|Name, address and tax details of the party receiving the payment of this invoice.|[PartyIdentification](#partyidentification)|
|**shipFromParty**  <br>*required*|Warehouse code of the vendor as in the order.|[PartyIdentification](#partyidentification)|
|**billToParty**  <br>*optional*|Name, address and tax details of the party to whom this invoice is issued.|[PartyIdentification](#partyidentification)|
|**shipToCountryCode**  <br>*optional*|Ship-to country code.|string|
|**paymentTermsCode**  <br>*optional*|The payment terms for the invoice.|string|
|**invoiceTotal**  <br>*required*|Total amount details of the invoice.|[Money](#money)|
|**taxTotals**  <br>*optional*|Individual tax details per line item.|< [TaxDetail](#taxdetail) > array|
|**additionalDetails**  <br>*optional*|Additional details provided by the selling party, for tax related or other purposes.|< [AdditionalDetails](#additionaldetails) > array|
|**chargeDetails**  <br>*optional*|Total charge amount details for all line items.|< [ChargeDetails](#chargedetails) > array|
|**items**  <br>*required*|Provides the details of the items in this invoice.|< [InvoiceItem](#invoiceitem) > array|


<a name="invoiceitem"></a>
### InvoiceItem

|Name|Description|Schema|
|---|---|---|
|**itemSequenceNumber**  <br>*required*|Numbering of the item on the purchase order. The first item will be 1, the second 2, and so on.|string|
|**buyerProductIdentifier**  <br>*optional*|Buyer's standard identification number (ASIN) of an item.|string|
|**vendorProductIdentifier**  <br>*optional*|The vendor selected product identification of the item.|string|
|**invoicedQuantity**  <br>*required*|Item quantity invoiced.|[ItemQuantity](#itemquantity)|
|**netCost**  <br>*required*|Net price (before tax) to vendor with currency details.|[Money](#money)|
|**purchaseOrderNumber**  <br>*required*|The purchase order number for this order. Formatting Notes: 8-character alpha-numeric code.|string|
|**vendorOrderNumber**  <br>*optional*|The vendor's order number for this order.|string|
|**hsnCode**  <br>*optional*|HSN tax code. The HSN number cannot contain alphabets.|string|
|**taxDetails**  <br>*optional*|Individual tax details per line item.|< [TaxDetail](#taxdetail) > array|
|**chargeDetails**  <br>*optional*|Individual charge details per line item.|< [ChargeDetails](#chargedetails) > array|


<a name="partyidentification"></a>
### PartyIdentification

|Name|Description|Schema|
|---|---|---|
|**partyId**  <br>*required*|Assigned Identification for the party.|string|
|**address**  <br>*optional*|Identification of the party by address.|[Address](#address)|
|**taxRegistrationDetails**  <br>*optional*|Tax registration details of the entity.|< [TaxRegistrationDetail](#taxregistrationdetail) > array|


<a name="taxregistrationdetail"></a>
### TaxRegistrationDetail
Tax registration details of the entity.


|Name|Description|Schema|
|---|---|---|
|**taxRegistrationType**  <br>*optional*|Tax registration type for the entity.|enum ([TaxRegistrationType](#taxregistrationtype))|
|**taxRegistrationNumber**  <br>*required*|Tax registration number for the party. For example, VAT ID.|string|
|**taxRegistrationAddress**  <br>*optional*|Address associated with the tax registration number.|[Address](#address)|
|**taxRegistrationMessage**  <br>*optional*|Tax registration message that can be used for additional tax related details.|string|


<a name="address"></a>
### Address
Address of the party.


|Name|Description|Schema|
|---|---|---|
|**name**  <br>*required*|The name of the person, business or institution at that address.|string|
|**addressLine1**  <br>*required*|First line of the address.|string|
|**addressLine2**  <br>*optional*|Additional street address information, if required.|string|
|**addressLine3**  <br>*optional*|Additional street address information, if required.|string|
|**city**  <br>*required*|The city where the person, business or institution is located.|string|
|**county**  <br>*optional*|The county where person, business or institution is located.|string|
|**district**  <br>*optional*|The district where person, business or institution is located.|string|
|**stateOrRegion**  <br>*required*|The state or region where person, business or institution is located.|string|
|**postalCode**  <br>*required*|The postal code of that address. It conatins a series of letters or digits or both, sometimes including spaces or punctuation.|string|
|**countryCode**  <br>*required*|The two digit country code in ISO 3166-1 alpha-2 format.|string|
|**phone**  <br>*optional*|The phone number of the person, business or institution located at that address.|string|


<a name="money"></a>
### Money
An amount of money, including units in the form of currency.


|Name|Description|Schema|
|---|---|---|
|**currencyCode**  <br>*required*|Three digit currency code in ISO 4217 format.|string|
|**amount**  <br>*required*|A decimal number with no loss of precision. Useful when precision loss is unacceptable, as with currencies. Follows RFC7159 for number representation. <br>**Pattern** : `^-?(0\|([1-9]\d*))(\.\d+)?([eE][+-]?\d+)?$`.|[Decimal](#decimal)|


<a name="decimal"></a>
### Decimal
A decimal number with no loss of precision. Useful when precision loss is unacceptable, as with currencies. Follows RFC7159 for number representation. <br>**Pattern** : `^-?(0|([1-9]\d*))(\.\d+)?([eE][+-]?\d+)?$`.

*Type* : string


<a name="taxdetail"></a>
### TaxDetail
Details of tax amount applied.


|Name|Description|Schema|
|---|---|---|
|**taxType**  <br>*required*|Type of the tax applied.|enum ([TaxType](#taxtype))|
|**taxRate**  <br>*optional*|Tax percentage applied. Percentage must be expressed in decimal.|[Decimal](#decimal)|
|**taxAmount**  <br>*required*|Total tax amount applied on invoice total or an item total.|[Money](#money)|
|**taxableAmount**  <br>*optional*|This field will contain the invoice amount that is taxable at the rate specified in the tax rate field.|[Money](#money)|


<a name="chargedetails"></a>
### ChargeDetails
Monetary and tax details of the charge.


|Name|Description|Schema|
|---|---|---|
|**type**  <br>*required*|Type of charge applied.|enum ([Type](#type-subgroup-2))|
|**chargeAmount**  <br>*required*|An amount of money, including units in the form of currency.|[Money](#money)|
|**taxDetails**  <br>*optional*|Individual tax details per line item.|< [TaxDetail](#taxdetail) > array|


<a name="additionaldetails"></a>
### AdditionalDetails
A field where selling party can provide additional information for tax related or any other purposes.


|Name|Description|Schema|
|---|---|---|
|**type**  <br>*required*|The type of the additional information provided by the selling party.|enum ([Type](#type-subgroup-1))|
|**detail**  <br>*required*|The detail of the additional information provided by the selling party.|string|
|**languageCode**  <br>*optional*|The language code of the additional information detail.|string|


<a name="itemquantity"></a>
### ItemQuantity
Details of item quantity.


|Name|Description|Schema|
|---|---|---|
|**amount**  <br>*required*|Quantity of units available for a specific item.|integer|
|**unitOfMeasure**  <br>*required*|Unit of measure for the available quantity.|string|


<a name="submitinvoiceresponse"></a>
### SubmitInvoiceResponse
The response schema for the submitInvoice operation.


|Name|Description|Schema|
|---|---|---|
|**payload**  <br>*optional*|The response payload for the submitInvoice operation.|[TransactionReference](#transactionreference)|
|**errors**  <br>*optional*|A list of error responses returned when a request is unsuccessful.|[ErrorList](#errorlist)|


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


<a name="taxtype"></a>
### TaxType
Type of the tax applied.

*Type* : enum


|Value|Description|
|---|---|
|**CGST**|Central Goods and Services Tax (CGST) is levied by the Indian government for intrastate movement of goods and services.|
|**SGST**|State Goods and Services Tax (SGST) is an indirect tax levied and collected by a State Government in India on the intra-state supplies.|
|**CESS**|A cess is a form of tax levied by the government on tax with specific purposes till the time the government gets enough money for that purpose.|
|**UTGST**|Union Territory Goods and Services Tax in India.|
|**IGST**|Integrated Goods and Services Tax (IGST) is a tax levied on all Inter-State supplies of goods and/or services in India.|
|**MwSt.**|Mehrwertsteuer, MwSt, is the German for value-added tax.|
|**PST**|A provincial sales tax (PST) is imposed on consumers of goods and particular services in many Canadian provinces.|
|**TVA**|Taxe sur la Valeur Ajout&#233;e (TVA) is French for Value-added tax.|
|**VAT**|Value-added tax.|
|**GST**|Tax levied on most goods and services sold for domestic consumption.|
|**ST**|Sales tax.|
|**Consumption**|Tax levied on consumption spending on goods and services.|
|**MutuallyDefined**|Tax component that was mutually agreed upon between Amazon and vendor.|
|**DomesticVAT**|Domestic Value-added tax.|


<a name="taxregistrationtype"></a>
### TaxRegistrationType
Tax registration type for the entity.

*Type* : enum


|Value|Description|
|---|---|
|**VAT**|Value-added tax.|
|**GST**|Goods and Services tax.|


<a name="type"></a>
### Type
*Type* : enum

<a id="type-subgroup-1"></a>**For use with the definition(s): [AdditionalDetails](#additionaldetails)**
The type of the additional information provided by the selling party.

|Value|Description|
|---|---|
|**SUR**|An additional tax on something already taxed, such as a higher rate of tax on incomes above a certain level.|
|**OCR**|OCR.|

<a id="type-subgroup-2"></a>**For use with the definition(s): [ChargeDetails](#chargedetails)**
Type of charge applied.

|Value|Description|
|---|---|
|**GIFTWRAP**|Additional charge applied for giftwrap order.|
|**FULFILLMENT**|Fulfillment fees are the costs associated with receiving and storing products along with processing orders from handling to shipping.|
|**MARKETINGINSERT**|Charge to insert ads on orders.|
|**PACKAGING**|Additional charge for packaging orders.|
|**LOADING**|Additional charge for loading orders.|
|**FREIGHTOUT**|Freight-out refers to the costs for which the seller is responsible when shipping to a buyer, such as delivery and insurance expenses.|
|**TAX_COLLECTED_AT_SOURCE**|Tax collected at source (TCS) is the tax payable by a seller which he collects from the buyer at the time of sale.|

