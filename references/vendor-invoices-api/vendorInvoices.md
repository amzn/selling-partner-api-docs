# Selling Partner API for Retail Procurement Payments


<a name="overview"></a>
## Overview
The Selling Partner API for Retail Procurement Payments provides programmatic access to vendors payments data.


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
[submitInvoices](#submitinvoices)<br>
<a name="paths"></a>
## Paths

<a name="submitinvoices"></a>
### POST /vendor/payments/v1/invoices
**Operation: submitInvoices**

#### Description
Submit new invoices to Amazon.

**Usage Plans:**

| Plan type | Rate (requests per second) | Burst |
| ---- | ---- | ---- |
|Default| 10 | 10 |
|Selling partner specific| Variable | Variable |

The x-amzn-RateLimit-Limit response header returns the usage plan rate limits that were applied to the requested operation. Rate limits for some selling partners will vary from the default rate and burst shown in the table above. For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Body**|**body**  <br>*required*|The request schema for the submitInvoices operation.|[SubmitInvoicesRequest](#submitinvoicesrequest)|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**202**|Success.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[SubmitInvoicesResponse](#submitinvoicesresponse)|

For error status codes, descriptions and schemas, see [Error responses and schemas](#error-responses-and-schemas).



<a name="error-responses-and-schemas"></a>
### Error Responses and Schemas
This table contains HTTP status codes and associated information for error responses.

|HTTP Code|Description|Schema|
|---|---|---|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers**:  <br>`x-amzn-RateLimit-Limit` (string):Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string):Unique request reference identifier.|[SubmitInvoicesResponse](#submitinvoicesresponse)|
|**403**|Indicates that access to the resource is forbidden. Possible reasons include Access Denied, Unauthorized, Expired Token, or Invalid Signature.  <br>**Headers**:  <br>`x-amzn-RequestId` (string):Unique request reference identifier.|[SubmitInvoicesResponse](#submitinvoicesresponse)|
|**404**|The resource specified does not exist.  <br>**Headers**:  <br>`x-amzn-RequestId` (string):unique request reference identifier.|[SubmitInvoicesResponse](#submitinvoicesresponse)|
|**413**|The request size exceeded the maximum accepted size.  <br>**Headers**:  <br>`x-amzn-RateLimit-Limit` (string):Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string):Unique request reference identifier.|[SubmitInvoicesResponse](#submitinvoicesresponse)|
|**415**|The request payload is in an unsupported format.  <br>**Headers**:  <br>`x-amzn-RateLimit-Limit` (string):Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string):Unique request reference identifier.|[SubmitInvoicesResponse](#submitinvoicesresponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers**:  <br>`x-amzn-RateLimit-Limit` (string):Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string):Unique request reference identifier.|[SubmitInvoicesResponse](#submitinvoicesresponse)|
|**500**|An unexpected condition occurred that prevented the server from fulfilling the request.  <br>**Headers**:  <br>`x-amzn-RateLimit-Limit` (string):Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string):Unique request reference identifier.|[SubmitInvoicesResponse](#submitinvoicesresponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers**:  <br>`x-amzn-RateLimit-Limit` (string):Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string):Unique request reference identifier.|[SubmitInvoicesResponse](#submitinvoicesresponse)|


<a name="definitions"></a>
## Definitions

<a name="submitinvoicesresponse"></a>
### SubmitInvoicesResponse
The response schema for the submitInvoices operation.


|Name|Description|Schema|
|---|---|---|
|**payload**  <br>*optional*|The response payload for the submitInvoices operation.|[TransactionId](#transactionid)|
|**errors**  <br>*optional*|A list of error responses returned when a request is unsuccessful.|[ErrorList](#errorlist)|


<a name="transactionid"></a>
### TransactionId

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


<a name="submitinvoicesrequest"></a>
### SubmitInvoicesRequest
The request schema for the submitInvoices operation.


|Name|Schema|
|---|---|
|**invoices**  <br>*optional*|< [Invoice](#invoice) > array|


<a name="invoice"></a>
### Invoice

|Name|Description|Schema|
|---|---|---|
|**invoiceType**  <br>*required*|Identifies the type of invoice.|enum ([InvoiceType](#invoicetype))|
|**id**  <br>*required*|Unique number relating to the charges defined in this document. This will be invoice number if the document type is Invoice or CreditNote number if the document type is Credit Note. Failure to provide this reference will result in a rejection.|string|
|**referenceNumber**  <br>*optional*|An additional unique reference number used for regulatory or other purposes.|string|
|**date**  <br>*required*|Date when the invoice/credit note information was generated in the origin's accounting system. The invoice date should be on or after the purchase order creation date.|[DateTime](#datetime)|
|**remitToParty**  <br>*required*|Name, address and tax details of the party receiving the payment of this invoice.|[PartyIdentification](#partyidentification)|
|**shipToParty**  <br>*optional*|Name, address and tax details of the party receiving a shipment of products.|[PartyIdentification](#partyidentification)|
|**shipFromParty**  <br>*optional*|Name, address and tax details of the party sending a shipment of products.|[PartyIdentification](#partyidentification)|
|**billToParty**  <br>*optional*|Name, address and tax details of the party to whom this invoice is issued.|[PartyIdentification](#partyidentification)|
|**paymentTerms**  <br>*optional*|The payment terms for the invoice.|[PaymentTerms](#paymentterms)|
|**invoiceTotal**  <br>*required*|Total monetary amount charged in the invoice or full value of credit note to be paid including all relevant taxes. It is the total amount of invoice (including charges, less allowances) before terms discount (if discount is applicable).|[Money](#money)|
|**taxDetails**  <br>*optional*|Total tax amount details for all line items.|< [TaxDetails](#taxdetails) > array|
|**additionalDetails**  <br>*optional*|Additional details provided by the selling party, for tax related or other purposes.|< [AdditionalDetails](#additionaldetails) > array|
|**chargeDetails**  <br>*optional*|Total charge amount details for all line items.|< [ChargeDetails](#chargedetails) > array|
|**allowanceDetails**  <br>*optional*|Total allowance amount details for all line items.|< [AllowanceDetails](#allowancedetails) > array|
|**items**  <br>*optional*|The list of invoice items.|< [InvoiceItem](#invoiceitem) > array|


<a name="partyidentification"></a>
### PartyIdentification

|Name|Description|Schema|
|---|---|---|
|**partyId**  <br>*required*|Assigned identification for the party.|string|
|**address**  <br>*optional*|Identification of the party by address.|[Address](#address)|
|**taxRegistrationDetails**  <br>*optional*|Tax registration details of the party.|< [TaxRegistrationDetails](#taxregistrationdetails) > array|


<a name="taxregistrationdetails"></a>
### TaxRegistrationDetails
Tax registration details of the entity.


|Name|Description|Schema|
|---|---|---|
|**taxRegistrationType**  <br>*required*|The tax registration type for the entity.|enum ([TaxRegistrationType](#taxregistrationtype))|
|**taxRegistrationNumber**  <br>*required*|The tax registration number for the entity. For example, VAT ID.|string|


<a name="address"></a>
### Address
A physical address.


|Name|Description|Schema|
|---|---|---|
|**name**  <br>*required*|The name of the person, business or institution at that address.|string|
|**addressLine1**  <br>*required*|First line of street address.|string|
|**addressLine2**  <br>*optional*|Additional address information, if required.|string|
|**addressLine3**  <br>*optional*|Additional address information, if required.|string|
|**city**  <br>*optional*|The city where the person, business or institution is located.|string|
|**county**  <br>*optional*|The county where person, business or institution is located.|string|
|**district**  <br>*optional*|The district where person, business or institution is located.|string|
|**stateOrRegion**  <br>*optional*|The state or region where person, business or institution is located.|string|
|**postalOrZipCode**  <br>*optional*|The postal or zip code of that address. It contains a series of letters or digits or both, sometimes including spaces or punctuation.|string|
|**countryCode**  <br>*required*|The two digit country code. In ISO 3166-1 alpha-2 format.<br>**maxLength** : 2|string|
|**phone**  <br>*optional*|The phone number of the person, business or institution located at that address.|string|


<a name="invoiceitem"></a>
### InvoiceItem
Details of the item being invoiced.


|Name|Description|Schema|
|---|---|---|
|**itemSequenceNumber**  <br>*required*|Unique number related to this line item.|integer|
|**amazonProductIdentifier**  <br>*optional*|Amazon Standard Identification Number (ASIN) of an item.|string|
|**vendorProductIdentifier**  <br>*optional*|The vendor selected product identifier of the item. Should be the same as was provided in the purchase order.|string|
|**invoicedQuantity**  <br>*required*|Invoiced quantity of this item. Quantity must be greater than zero.|[ItemQuantity](#itemquantity)|
|**netCost**  <br>*required*|The item cost to Amazon, which should match the cost on the order. Price information should not be zero or negative. It indicates net unit price. Net cost means VAT is not included in cost.|[Money](#money)|
|**purchaseOrderNumber**  <br>*optional*|The Amazon purchase order number for this invoiced line item. Formatting Notes: 8-character alpha-numeric code. This value is mandatory only when invoiceType is Invoice, and is not required when invoiceType is CreditNote.|string|
|**hsnCode**  <br>*optional*|HSN Tax code. The HSN number cannot contain alphabets.|string|
|**creditNoteDetails**  <br>*optional*|Details required in order to process a credit note. This information is required only if invoiceType is CreditNote.|[CreditNoteDetails](#creditnotedetails)|
|**taxDetails**  <br>*optional*|Individual tax details per line item.|< [TaxDetails](#taxdetails) > array|
|**chargeDetails**  <br>*optional*|Individual charge details per line item.|< [ChargeDetails](#chargedetails) > array|
|**allowanceDetails**  <br>*optional*|Individual allowance details per line item.|< [AllowanceDetails](#allowancedetails) > array|


<a name="taxdetails"></a>
### TaxDetails
Details of tax amount applied.


|Name|Description|Schema|
|---|---|---|
|**taxType**  <br>*required*|Type of the tax applied.|enum ([TaxType](#taxtype))|
|**taxRate**  <br>*optional*|Tax percentage applied. Percentage must be expressed in decimal.|[Decimal](#decimal)|
|**taxAmount**  <br>*required*|Total tax amount applied on invoice total or an item total.|[Money](#money)|
|**taxableAmount**  <br>*optional*|The invoice amount that is taxable at the rate specified in the tax rate field.|[Money](#money)|


<a name="money"></a>
### Money
An amount of money, including units in the form of currency.


|Name|Description|Schema|
|---|---|---|
|**currencyCode**  <br>*optional*|Three-digit currency code in ISO 4217 format.|string|
|**amount**  <br>*optional*|A decimal number with no loss of precision. Useful when precision loss is unacceptable, as with currencies. Follows RFC7159 for number representation. <br>**Pattern** : `^-?(0\|([1-9]\d*))(\.\d+)?([eE][+-]?\d+)?$`.|[Decimal](#decimal)|


<a name="additionaldetails"></a>
### AdditionalDetails
Additional information provided by the selling party for tax-related or any other purpose.


|Name|Description|Schema|
|---|---|---|
|**type**  <br>*required*|The type of the additional information provided by the selling party.|enum ([Type](#type-subgroup-2))|
|**detail**  <br>*required*|The detail of the additional information provided by the selling party.|string|
|**languageCode**  <br>*optional*|The language code of the additional information detail.|string|


<a name="chargedetails"></a>
### ChargeDetails
Monetary and tax details of the charge.


|Name|Description|Schema|
|---|---|---|
|**type**  <br>*required*|Type of the charge applied.|enum ([Type](#type-subgroup-4))|
|**description**  <br>*optional*|Description of the charge.|string|
|**chargeAmount**  <br>*required*|Total monetary amount related to this charge.|[Money](#money)|
|**taxDetails**  <br>*optional*|Tax amount details applied on this charge.|< [TaxDetails](#taxdetails) > array|


<a name="allowancedetails"></a>
### AllowanceDetails
Monetary and tax details of the allowance.


|Name|Description|Schema|
|---|---|---|
|**type**  <br>*required*|Type of the allowance applied.|enum ([Type](#type-subgroup-3))|
|**description**  <br>*optional*|Description of the allowance.|string|
|**allowanceAmount**  <br>*required*|Total monetary amount related to this allowance.|[Money](#money)|
|**taxDetails**  <br>*optional*|Tax amount details applied on this allowance.|< [TaxDetails](#taxdetails) > array|


<a name="paymentterms"></a>
### PaymentTerms
Terms of the payment for the invoice. The basis of the payment terms is the invoice date.


|Name|Description|Schema|
|---|---|---|
|**type**  <br>*optional*|The payment term type for the invoice.|enum ([Type](#type-subgroup-1))|
|**discountPercent**  <br>*optional*|The discount percent value, which is good until the discount due date.|[Decimal](#decimal)|
|**discountDueDays**  <br>*optional*|The number of calendar days from the Base date (Invoice date) until the discount is no longer valid.|number|
|**netDueDays**  <br>*optional*|The number of calendar days from the base date (invoice date) until the total amount on the invoice is due.|number|


<a name="creditnotedetails"></a>
### CreditNoteDetails
References required in order to process a credit note. This information is required only if InvoiceType is CreditNote.


|Name|Description|Schema|
|---|---|---|
|**referenceInvoiceNumber**  <br>*optional*|Original Invoice Number when sending a credit note relating to an existing invoice. One Invoice only to be processed per Credit Note. This is mandatory for AP Credit Notes.|string|
|**debitNoteNumber**  <br>*optional*|Debit Note Number as generated by Amazon. Recommended for Returns and COOP Credit Notes.|string|
|**returnsReferenceNumber**  <br>*optional*|Identifies the Returns Notice Number. Mandatory for all Returns Credit Notes.|string|
|**goodsReturnDate**  <br>*optional*|Date that a return is received by the vendor. It is mandatory for Returns Credit Note.|[DateTime](#datetime)|
|**rmaId**  <br>*optional*|Identifies the Returned Merchandise Authorization ID, if generated.|string|
|**coopReferenceNumber**  <br>*optional*|Identifies the COOP reference used for COOP agreement. Failure to provide the COOP reference number or the Debit Note number may lead to a rejection of the Credit Note.|string|
|**consignorsReferenceNumber**  <br>*optional*|Identifies the consignor reference number (VRET number), if generated by Amazon.|string|


<a name="itemquantity"></a>
### ItemQuantity
Details of quantity.


|Name|Description|Schema|
|---|---|---|
|**amount**  <br>*required*|Quantity of an item. This value should not be zero.|integer|
|**unitOfMeasure**  <br>*required*|Unit of measure for the quantity.|enum ([UnitOfMeasure](#unitofmeasure))|
|**unitSize**  <br>*optional*|The case size, if the unit of measure value is Cases.|integer|


<a name="decimal"></a>
### Decimal
A decimal number with no loss of precision. Useful when precision loss is unacceptable, as with currencies. Follows RFC7159 for number representation. <br>**Pattern** : `^-?(0|([1-9]\d*))(\.\d+)?([eE][+-]?\d+)?$`.

*Type* : string


<a name="datetime"></a>
### DateTime
Defines a date and time according to ISO8601.

*Type* : string (date-time)


<a name="date"></a>
### Date
ISO Date without time, Example 2018-09-20.

*Type* : string


<a name="taxtype"></a>
### TaxType
Type of the tax applied.

*Type* : enum


|Value|Description|
|---|---|
|**CGST**|Central Goods and Services Tax (CGST) is levied by the Indian government for intrastate movement of goods and services.|
|**SGST**|State Goods and Services Tax (SGST) is an indirect tax levied and collected by a State Government in India on the intra-state supplies.|
|**CESS**|A CESS is a form of tax levied by the government on tax with specific purposes till the time the government gets enough money for that purpose.|
|**UTGST**|Union Territory Goods and Services Tax in India.|
|**IGST**|Integrated Goods and Services Tax (IGST) is a tax levied on all Inter-State supplies of goods and/or services in India.|
|**MwSt.**|Mehrwertsteuer, MwSt, is German for value-added tax.|
|**PST**|A provincial sales tax (PST) is imposed on consumers of goods and particular services in many Canadian provinces.|
|**TVA**|Taxe sur la Valeur Ajout&#233;e (TVA) is French for value-added tax.|
|**VAT**|Value-added tax.|
|**GST**|Tax levied on most goods and services sold for domestic consumption.|
|**ST**|Sales tax.|
|**Consumption**|Tax levied on consumption spending on goods and services.|
|**MutuallyDefined**|Tax component that was mutually agreed upon between Amazon and vendor.|
|**DomesticVAT**|Domestic value-added tax.|


<a name="unitofmeasure"></a>
### UnitOfMeasure
Unit of measure for the quantity.

*Type* : enum


|Value|Description|
|---|---|
|**Cases**|Packing of individual items into a case.|
|**Eaches**|Individual items.|


<a name="taxregistrationtype"></a>
### TaxRegistrationType
The tax registration type for the entity.

*Type* : enum


|Value|Description|
|---|---|
|**VAT**|Value-added tax.|
|**GST**|Goods and services tax.|


<a name="invoicetype"></a>
### InvoiceType
Identifies the type of invoice.

*Type* : enum


|Value|Description|
|---|---|
|**Invoice**|A commercial document issued by a seller to a buyer, relating to a sale transaction and indicating the products, quantities, and agreed prices for products or services the seller had provided the buyer.|
|**CreditNote**|A commercial document issued by a seller to a buyer. It is evidence of the reduction in sales.|


<a name="type"></a>
### Type
*Type* : enum

<a id="type-subgroup-1"></a>**For use with the definition(s): [PaymentTerms](#paymentterms)**
The payment term type for the invoice.

|Value|Description|
|---|---|
|**Basic**|Payment term that buyer and seller have agreed to.|
|**EndOfMonth**|Payment term where seller gets paid end of month.|
|**FixedDate**|Payment term where seller gets paid on a fixed date as agreed with buyer.|
|**Proximo**|Payment term where seller gets paid end of following month.|
|**PaymentDueUponReceiptOfInvoice**|Payment term where seller gets paid upon receipt of the invoice by the buyer.|
|**LetterofCredit**|A payment undertaking given by a bank to the seller and is issued on behalf of the applicant i.e. the buyer.|

<a id="type-subgroup-2"></a>**For use with the definition(s): [AdditionalDetails](#additionaldetails)**
The type of the additional information provided by the selling party.

|Value|Description|
|---|---|
|**SUR**|An additional tax on something already taxed, such as a higher rate of tax on incomes above a certain level.|
|**OCR**|OCR.|
|**CartonCount**|The total number of cartons invoiced.|

<a id="type-subgroup-3"></a>**For use with the definition(s): [AllowanceDetails](#allowancedetails)**
Type of the allowance applied.

|Value|Description|
|---|---|
|**Discount**|Discount allowance.|
|**DiscountIncentive**|Discount incentive allowance.|
|**Defective**|Allowance applied for defective item.|
|**Promotional**|Promotional allowance.|
|**UnsaleableMerchandise**|Allowance applied due to unsaleable merchandise.|
|**Special**|Special allowances.|

<a id="type-subgroup-4"></a>**For use with the definition(s): [ChargeDetails](#chargedetails)**
Type of the charge applied.

|Value|Description|
|---|---|
|**Freight**|Freight charges.|
|**Packing**|Packing fee.|
|**Duty**|Duty charges.|
|**Service**|Service fee.|
|**SmallOrder**|Small order fee.|
|**InsurancePlacementCost**|Insurance placement cost.|
|**InsuranceFee**|Insurance fee.|
|**SpecialHandlingService**|Special handling service fee.|
|**CollectionAndRecyclingService**|Collection and recycling service fee.|
|**EnvironmentalProtectionService**|Environmental protection service fee.|
|**TaxCollectedAtSource**|Tax collected at source.|

