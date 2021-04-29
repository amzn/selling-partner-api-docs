# Selling Partner API for Retail Procurement Shipments


<a name="overview"></a>
## Overview
The Selling Partner API for Retail Procurement Shipments provides programmatic access to retail shipping data for vendors.


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
[SubmitShipmentConfirmations](#submitshipmentconfirmations)<br>
<a name="paths"></a>
## Paths

<a name="submitshipmentconfirmations"></a>
### POST /vendor/shipping/v1/shipmentConfirmations
**Operation: SubmitShipmentConfirmations**

#### Description
Submits one or more shipment confirmations for vendor orders.

**Usage Plans:**

| Plan type | Rate (requests per second) | Burst |
| ---- | ---- | ---- |
|Default| 10 | 10 |
|Selling partner specific| Variable | Variable |

The x-amzn-RateLimit-Limit response header returns the usage plan rate limits that were applied to the requested operation. Rate limits for some selling partners will vary from the default rate and burst shown in the table above. For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Body**|**body**  <br>*required*|The request schema for the SubmitShipmentConfirmations operation.|[SubmitShipmentConfirmationsRequest](#submitshipmentconfirmationsrequest)|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**202**|Success.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[SubmitShipmentConfirmationsResponse](#submitshipmentconfirmationsresponse)|

For error status codes, descriptions and schemas, see [Error responses and schemas](#error-responses-and-schemas).



<a name="error-responses-and-schemas"></a>
### Error Responses and Schemas
This table contains HTTP status codes and associated information for error responses.

|HTTP Code|Description|Schema|
|---|---|---|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers**:  <br>`x-amzn-RateLimit-Limit` (string):Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string):Unique request reference identifier.|[SubmitShipmentConfirmationsResponse](#submitshipmentconfirmationsresponse)|
|**403**|Indicates that access to the resource is forbidden. Possible reasons include Access Denied, Unauthorized, Expired Token, or Invalid Signature.  <br>**Headers**:  <br>`x-amzn-RequestId` (string):Unique request reference identifier.|[SubmitShipmentConfirmationsResponse](#submitshipmentconfirmationsresponse)|
|**404**|The resource specified does not exist.  <br>**Headers**:  <br>`x-amzn-RequestId` (string):Unique request reference identifier.|[SubmitShipmentConfirmationsResponse](#submitshipmentconfirmationsresponse)|
|**413**|The request size exceeded the maximum accepted size.  <br>**Headers**:  <br>`x-amzn-RateLimit-Limit` (string):Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string):Unique request reference identifier.|[SubmitShipmentConfirmationsResponse](#submitshipmentconfirmationsresponse)|
|**415**|The request payload is in an unsupported format.  <br>**Headers**:  <br>`x-amzn-RateLimit-Limit` (string):Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string):Unique request reference identifier.|[SubmitShipmentConfirmationsResponse](#submitshipmentconfirmationsresponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers**:  <br>`x-amzn-RateLimit-Limit` (string):Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string):Unique request reference identifier.|[SubmitShipmentConfirmationsResponse](#submitshipmentconfirmationsresponse)|
|**500**|An unexpected condition occurred that prevented the server from fulfilling the request.  <br>**Headers**:  <br>`x-amzn-RateLimit-Limit` (string):Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string):Unique request reference identifier.|[SubmitShipmentConfirmationsResponse](#submitshipmentconfirmationsresponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers**:  <br>`x-amzn-RateLimit-Limit` (string):Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string):Unique request reference identifier.|[SubmitShipmentConfirmationsResponse](#submitshipmentconfirmationsresponse)|


<a name="definitions"></a>
## Definitions

<a name="submitshipmentconfirmationsrequest"></a>
### SubmitShipmentConfirmationsRequest
The request schema for the SubmitShipmentConfirmations operation.


|Name|Schema|
|---|---|
|**shipmentConfirmations**  <br>*optional*|< [ShipmentConfirmation](#shipmentconfirmation) > array|


<a name="shipmentconfirmation"></a>
### ShipmentConfirmation

|Name|Description|Schema|
|---|---|---|
|**shipmentIdentifier**  <br>*required*|Unique shipment ID (not used over the last 365 days).|string|
|**shipmentConfirmationType**  <br>*required*|Indicates if this shipment confirmation is the initial confirmation, or intended to replace an already posted shipment confirmation. If replacing an existing shipment confirmation, be sure to provide the identical shipmentIdentifier and sellingParty information as in the previous confirmation.|enum ([ShipmentConfirmationType](#shipmentconfirmationtype))|
|**shipmentType**  <br>*optional*|The type of shipment.|enum ([ShipmentType](#shipmenttype))|
|**shipmentStructure**  <br>*optional*|Shipment hierarchical structure.|enum ([ShipmentStructure](#shipmentstructure))|
|**transportationDetails**  <br>*optional*|Transportation details for this shipment.|[TransportationDetails](#transportationdetails)|
|**amazonReferenceNumber**  <br>*optional*|The Amazon Reference Number is a unique identifier generated by Amazon for all Collect/WePay shipments when you submit  a routing request. This field is mandatory for Collect/WePay shipments.|string|
|**shipmentConfirmationDate**  <br>*required*|Date on which the shipment confirmation was submitted.|string (date-time)|
|**shippedDate**  <br>*optional*|The date and time of the departure of the shipment from the vendor's location. Vendors are requested to send ASNs within 30 minutes of departure from their warehouse/distribution center or at least 6 hours prior to the appointment time at the Amazon destination warehouse, whichever is sooner. Shipped date mentioned in the shipment confirmation should not be in the future.|string (date-time)|
|**estimatedDeliveryDate**  <br>*optional*|The date and time on which the shipment is expected to reach buyer's warehouse. It needs to be an estimate based on the average transit time between ship from location and the destination. The exact appointment time will be provided by the buyer and is potentially not known when creating the shipment confirmation.|string (date-time)|
|**sellingParty**  <br>*required*|Name/Address and tax details of the selling party.|[PartyIdentification](#partyidentification)|
|**shipFromParty**  <br>*required*|Name/Address and tax details of the ship from party.|[PartyIdentification](#partyidentification)|
|**shipToParty**  <br>*required*|Name/Address of the destination warehouse where the shipment is being shipped to.|[PartyIdentification](#partyidentification)|
|**shipmentMeasurements**  <br>*optional*|Shipment measurement details.|[ShipmentMeasurements](#shipmentmeasurements)|
|**importDetails**  <br>*optional*|Provide these fields only if this shipment is a direct import.|[ImportDetails](#importdetails)|
|**shippedItems**  <br>*required*|A list of the items in this shipment and their associated details. If any of the item detail fields are common at a carton or a pallet level, provide them at the corresponding carton or pallet level.|< [Item](#item) > array|
|**cartons**  <br>*optional*|A list of the cartons in this shipment.|< [Carton](#carton) > array|
|**pallets**  <br>*optional*|A list of the pallets in this shipment.|< [Pallet](#pallet) > array|


<a name="shipmentmeasurements"></a>
### ShipmentMeasurements
Shipment measurement details.


|Name|Description|Schema|
|---|---|---|
|**grossShipmentWeight**  <br>*optional*|Gross weight of the shipment.|[Weight](#weight)|
|**shipmentVolume**  <br>*optional*|Volume of the shipment.|[Volume](#volume)|
|**cartonCount**  <br>*optional*|Number of cartons present in the shipment. Provide the cartonCount only for unpalletized shipments.|integer|
|**palletCount**  <br>*optional*|Number of pallets present in the shipment. Provide the palletCount only for palletized shipments.|integer|


<a name="transportationdetails"></a>
### TransportationDetails

|Name|Description|Schema|
|---|---|---|
|**carrierScac**  <br>*optional*|Code that identifies the carrier for the shipment. The Standard Carrier Alpha Code (SCAC) is a unique two to four letter code used to identify a carrier. Carrier SCAC codes are assigned and maintained by the NMFTA (National Motor Freight Association). This field is mandatory for US, CA, MX shipment confirmations.|string|
|**carrierShipmentReferenceNumber**  <br>*optional*|The field also known as PRO number is a unique number assigned by the carrier. It is used to identify and track the shipment that goes out for delivery. This field is mandatory for UA, CA, MX shipment confirmations.|string|
|**transportationMode**  <br>*optional*|The mode of transportation for this shipment.|enum ([TransportationMode](#transportationmode))|
|**billOfLadingNumber**  <br>*optional*|Bill Of Lading (BOL) number is the unique number assigned by the vendor. The BOL present in the Shipment Confirmation message ideally matches the paper BOL provided with the shipment, but that is no must. Instead of BOL, an alternative reference number (like Delivery Note Number) for the shipment can also be sent in this field.|string|


<a name="importdetails"></a>
### ImportDetails

|Name|Description|Schema|
|---|---|---|
|**methodOfPayment**  <br>*optional*|This is used for import purchase orders only. If the recipient requests, this field will contain the shipment method of payment.|enum ([MethodOfPayment](#methodofpayment))|
|**sealNumber**  <br>*optional*|The container's seal number.|string|
|**route**  <br>*optional*|The route and stop details for this shipment.|[Route](#route)|
|**importContainers**  <br>*optional*|Types and numbers of container(s) for import purchase orders. Can be a comma-separated list if shipment has multiple containers.<br>**maxLength** : 64|string|
|**billableWeight**  <br>*optional*|Billable weight of the direct imports shipment.|[Weight](#weight)|
|**estimatedShipByDate**  <br>*optional*|Date on which the shipment is expected to be shipped. This value should not be in the past and not more than 60 days out in the future.|string (date-time)|


<a name="item"></a>
### Item
Details of the item being shipped.


|Name|Description|Schema|
|---|---|---|
|**itemSequenceNumber**  <br>*required*|Item sequence number for the item. The first item will be 001, the second 002, and so on. This number is used as a reference to refer to this item from the carton or pallet level.|string|
|**amazonProductIdentifier**  <br>*optional*|Amazon Standard Identification Number (ASIN) of an item.|string|
|**vendorProductIdentifier**  <br>*optional*|The vendor selected product identification of the item. Should be the same as was sent in the purchase order.|string|
|**shippedQuantity**  <br>*required*|Total item quantity shipped in this shipment.|[ItemQuantity](#itemquantity)|
|**itemDetails**  <br>*optional*|Item details for be provided for every item in shipment at either the item or carton or pallet level, whichever is appropriate.|[ItemDetails](#itemdetails)|


<a name="carton"></a>
### Carton
Details of the carton/package being shipped.


|Name|Description|Schema|
|---|---|---|
|**cartonIdentifiers**  <br>*optional*|A list of carton identifiers.|< [ContainerIdentification](#containeridentification) > array|
|**cartonSequenceNumber**  <br>*required*|Carton sequence number for the carton. The first carton will be 001, the second 002, and so on. This number is used as a reference to refer to this carton from the pallet level.|string|
|**dimensions**  <br>*optional*|Physical dimensional measurements of a container.|[Dimensions](#dimensions)|
|**weight**  <br>*optional*|The weight.|[Weight](#weight)|
|**trackingNumber**  <br>*optional*|This is required to be provided for every carton in the small parcel shipments.|string|
|**items**  <br>*required*|A list of container item details.|< [ContainerItem](#containeritem) > array|


<a name="pallet"></a>
### Pallet
Details of the Pallet/Tare being shipped.


|Name|Description|Schema|
|---|---|---|
|**palletIdentifiers**  <br>*required*|A list of pallet identifiers.|< [ContainerIdentification](#containeridentification) > array|
|**tier**  <br>*optional*|Number of layers per pallet.|integer|
|**block**  <br>*optional*|Number of cartons per layer on the pallet.|integer|
|**dimensions**  <br>*optional*|Physical dimensional measurements of a container.|[Dimensions](#dimensions)|
|**weight**  <br>*optional*|The weight.|[Weight](#weight)|
|**cartonReferenceDetails**  <br>*optional*|Carton reference details.|[CartonReferenceDetails](#cartonreferencedetails)|
|**items**  <br>*optional*|A list of container item details.|< [ContainerItem](#containeritem) > array|


<a name="itemdetails"></a>
### ItemDetails
Item details for be provided for every item in shipment at either the item or carton or pallet level, whichever is appropriate.


|Name|Description|Schema|
|---|---|---|
|**purchaseOrderNumber**  <br>*optional*|The Amazon purchase order number for the shipment being confirmed. If the items in this shipment belong to multiple purchase order numbers that are in particular carton or pallet within the shipment, then provide the purchaseOrderNumber at the appropriate carton or pallet level. Formatting Notes: 8-character alpha-numeric code.|string|
|**lotNumber**  <br>*optional*|The batch or lot number associates an item with information the manufacturer considers relevant for traceability of the trade item to which the Element String is applied. The data may refer to the trade item itself or to items contained. This field is mandatory for all perishable items.|string|
|**expiry**  <br>*optional*|Either expiryDate or mfgDate and expiryAfterDuration are mandatory for perishable items.|[Expiry](#expiry)|
|**maximumRetailPrice**  <br>*optional*|Maximum retail price of the item being shipped.|[Money](#money)|
|**handlingCode**  <br>*optional*|Identification of the instructions on how specified item/carton/pallet should be handled.|enum ([HandlingCode](#handlingcode))|


<a name="containeridentification"></a>
### ContainerIdentification

|Name|Description|Schema|
|---|---|---|
|**containerIdentificationType**  <br>*required*|The container identification type.|enum ([ContainerIdentificationType](#containeridentificationtype))|
|**containerIdentificationNumber**  <br>*required*|Container identification number that adheres to the definition of the container identification type.|string|


<a name="containeritem"></a>
### ContainerItem
Carton/Pallet level details for the item.


|Name|Description|Schema|
|---|---|---|
|**itemReference**  <br>*required*|The reference number for the item. Please provide the itemSequenceNumber from the 'items' segment to refer to that item's details here.|string|
|**shippedQuantity**  <br>*required*|Total item quantity shipped in this carton/pallet.|[ItemQuantity](#itemquantity)|
|**itemDetails**  <br>*optional*|Item details for be provided for every item in shipment at either the item or carton or pallet level, whichever is appropriate.|[ItemDetails](#itemdetails)|


<a name="cartonreferencedetails"></a>
### CartonReferenceDetails

|Name|Description|Schema|
|---|---|---|
|**cartonCount**  <br>*optional*|Pallet level carton count is mandatory for single item pallet and optional for mixed item pallet.|integer|
|**cartonReferenceNumbers**  <br>*required*|Array of reference numbers for the carton that are part of this pallet/shipment. Please provide the cartonSequenceNumber from the 'cartons' segment to refer to that carton's details here.|< string > array|


<a name="partyidentification"></a>
### PartyIdentification

|Name|Description|Schema|
|---|---|---|
|**address**  <br>*optional*|Identification of the party by address.|[Address](#address)|
|**partyId**  <br>*required*|Assigned identification for the party.|string|
|**taxRegistrationDetails**  <br>*optional*|Tax registration details of the entity.|< [TaxRegistrationDetails](#taxregistrationdetails) > array|


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
|**addressLine2**  <br>*optional*|Additional street address information, if required.|string|
|**addressLine3**  <br>*optional*|Additional street address information, if required.|string|
|**city**  <br>*optional*|The city where the person, business or institution is located.|string|
|**county**  <br>*optional*|The county where person, business or institution is located.|string|
|**district**  <br>*optional*|The district where person, business or institution is located.|string|
|**stateOrRegion**  <br>*optional*|The state or region where person, business or institution is located.|string|
|**postalCode**  <br>*optional*|The postal code of that address. It contains a series of letters or digits or both, sometimes including spaces or punctuation.|string|
|**countryCode**  <br>*required*|The two digit country code in ISO 3166-1 alpha-2 format.|string|
|**phone**  <br>*optional*|The phone number of the person, business or institution located at that address.|string|


<a name="route"></a>
### Route
This is used only for direct import shipment confirmations.


|Name|Schema|
|---|---|
|**stops**  <br>*required*|< [Stop](#stop) > array|


<a name="stop"></a>
### Stop
Contractual or operational port or point relevant to the movement of the cargo.


|Name|Description|Schema|
|---|---|---|
|**functionCode**  <br>*required*|Provide the function code.|enum ([FunctionCode](#functioncode))|
|**locationIdentification**  <br>*optional*|Location identifier.|[Location](#location)|
|**arrivalTime**  <br>*optional*|Date and time of the arrival of the cargo.|string (date-time)|
|**departureTime**  <br>*optional*|Date and time of the departure of the cargo.|string (date-time)|


<a name="location"></a>
### Location
Location identifier.


|Name|Description|Schema|
|---|---|---|
|**type**  <br>*optional*|Type of location identification.|string|
|**locationCode**  <br>*optional*|Location code.|string|
|**countryCode**  <br>*optional*|The two digit country code. In ISO 3166-1 alpha-2 format.|string|


<a name="dimensions"></a>
### Dimensions
Physical dimensional measurements of a container.


|Name|Description|Schema|
|---|---|---|
|**length**  <br>*required*|The length of the container.|[Decimal](#decimal)|
|**width**  <br>*required*|The width of the container.|[Decimal](#decimal)|
|**height**  <br>*required*|The height of the container.|[Decimal](#decimal)|
|**unitOfMeasure**  <br>*required*|The unit of measure for dimensions.|enum ([UnitOfMeasure](#unitofmeasure-subgroup-2))|


<a name="volume"></a>
### Volume
The volume of the container.


|Name|Description|Schema|
|---|---|---|
|**unitOfMeasure**  <br>*required*|The unit of measurement.|enum ([UnitOfMeasure](#unitofmeasure-subgroup-3))|
|**value**  <br>*required*|The measurement value.|[Decimal](#decimal)|


<a name="weight"></a>
### Weight
The weight.


|Name|Description|Schema|
|---|---|---|
|**unitOfMeasure**  <br>*required*|The unit of measurement.|enum ([UnitOfMeasure](#unitofmeasure-subgroup-1))|
|**value**  <br>*required*|The measurement value.|[Decimal](#decimal)|


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


<a name="itemquantity"></a>
### ItemQuantity
Details of item quantity.


|Name|Description|Schema|
|---|---|---|
|**amount**  <br>*required*|Amount of units shipped for a specific item at a shipment level. If the item is present only in certain cartons or pallets within the shipment, please provide this at the appropriate carton or pallet level.|integer|
|**unitOfMeasure**  <br>*required*|Unit of measure for the shipped quantity.|enum ([UnitOfMeasure](#unitofmeasure-subgroup-4))|
|**unitSize**  <br>*optional*|The case size, in the event that we ordered using cases. Otherwise, 1.|integer|


<a name="expiry"></a>
### Expiry

|Name|Description|Schema|
|---|---|---|
|**manufacturerDate**  <br>*optional*|Production, packaging or assembly date determined by the manufacturer. Its meaning is determined based on the trade item context.|string (date-time)|
|**expiryDate**  <br>*optional*|The date that determines the limit of consumption or use of a product. Its meaning is determined based on the trade item context.|string (date-time)|
|**expiryAfterDuration**  <br>*optional*|Duration after manufacturing date during which the product is valid for consumption.|[Duration](#duration)|


<a name="duration"></a>
### Duration

|Name|Description|Schema|
|---|---|---|
|**durationUnit**  <br>*required*|Unit for duration.|enum ([DurationUnit](#durationunit))|
|**durationValue**  <br>*required*|Value for the duration in terms of the durationUnit.|integer|


<a name="submitshipmentconfirmationsresponse"></a>
### SubmitShipmentConfirmationsResponse
The response schema for the SubmitShipmentConfirmations operation.


|Name|Description|Schema|
|---|---|---|
|**payload**  <br>*optional*|The response payload for the SubmitShipmentConfirmations operation.|[TransactionReference](#transactionreference)|
|**errors**  <br>*optional*|A list of error responses returned when a request is unsuccessful.|[ErrorList](#errorlist)|


<a name="transactionreference"></a>
### TransactionReference

|Name|Description|Schema|
|---|---|---|
|**transactionId**  <br>*optional*|GUID assigned by Amazon to identify this transaction. This value can be used with the Transaction Status API to return the status of this transaction.|string|


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


<a name="methodofpayment"></a>
### MethodOfPayment
This is used for import purchase orders only. If the recipient requests, this field will contain the shipment method of payment.

*Type* : enum


|Value|Description|
|---|---|
|**PaidByBuyer**|Buyer pays for shipping.|
|**CollectOnDelivery**|Buyer pays for shipping on delivery.|
|**DefinedByBuyerAndSeller**|Shipping costs paid as agreed upon between buyer and seller.|
|**FOBPortOfCall**|Seller pays for transportation incl. loading, shipping.|
|**PrepaidBySeller**|Seller prepays for shipping.|
|**PaidBySeller**|Seller pays for shipping.|


<a name="shipmenttype"></a>
### ShipmentType
The type of shipment.

*Type* : enum


|Value|Description|
|---|---|
|**TruckLoad**|Truckload shipping is the movement of large amounts of homogeneous cargo, generally the amount necessary to fill an entire semi-trailer or intermodal container.|
|**LessThanTruckLoad**|Shipping does not fill the entire truck.|
|**SmallParcel**|Small parcel shipments are under 70 pounds per and shipped in your own packaging or carrier supplied boxes.|


<a name="transportationmode"></a>
### TransportationMode
The mode of transportation for this shipment.

*Type* : enum


|Value|Description|
|---|---|
|**Road**|The mode of transportation is by Road (on a truck).|
|**Air**|The mode of transportation is by Air (on a plane).|
|**Ocean**|The mode of transportation is by Ocean (on a ship).|


<a name="handlingcode"></a>
### HandlingCode
Identification of the instructions on how specified item/carton/pallet should be handled.

*Type* : enum


|Value|Description|
|---|---|
|**Oversized**|A package weighing 150 pounds or less and measuring greater than 130 inches in length and girth is classified as an oversized package.|
|**Fragile**|A package containing easily breakable items.|
|**Food**|A package containing edible items.|
|**HandleWithCare**|A package containing fragile or dangerous items.|


<a name="taxregistrationtype"></a>
### TaxRegistrationType
Tax registration type for the entity.

*Type* : enum


|Value|Description|
|---|---|
|**VAT**|Value-added tax.|
|**GST**|Goods and Services tax.|


<a name="durationunit"></a>
### DurationUnit
Unit for duration.

*Type* : enum


|Value|Description|
|---|---|
|**Days**|Days|
|**Months**|Months|


<a name="functioncode"></a>
### FunctionCode
Provide the function code.

*Type* : enum


|Value|Description|
|---|---|
|**PortOfDischarge**|Port of Discharge is a place where a vessel discharges or unloads some or all of its shipments.|
|**FreightPayableAt**|Place where the payment for the freight is made.|
|**PortOfLoading**|The port where goods are put on a ship.|


<a name="containeridentificationtype"></a>
### ContainerIdentificationType
The container identification type.

*Type* : enum


|Value|Description|
|---|---|
|**SSCC**|2 Digit Application Identifier (00) followed by unique 18-digit Serial Shipment Container Code (SSCC) to be included to define a pallet/carton and to identify its contents.|
|**AMZNCC**|Amazon Container Code - a substitute for a SSCC that is generated by Amazon for small vendors and associated with a pallet/carton label.|
|**GTIN**|Global Trade Identification Number (part of the standard GS1 barcoding and product identification system).|
|**BPS**|Barcode Packing Slip.|
|**CID**|Container identifier for import shipments.|


<a name="shipmentconfirmationtype"></a>
### ShipmentConfirmationType
Indicates if this shipment confirmation is the initial confirmation, or intended to replace an already posted shipment confirmation. If replacing an existing shipment confirmation, be sure to provide the identical shipmentIdentifier and sellingParty information as in the previous confirmation.

*Type* : enum


|Value|Description|
|---|---|
|**Original**|Initial shipment confirmation message.|
|**Replace**|Replace the original shipment confirmation message.|


<a name="shipmentstructure"></a>
### ShipmentStructure
Shipment hierarchical structure.

*Type* : enum


|Value|Description|
|---|---|
|**PalletizedAssortmentCase**|Shipment -> Order -> Pallet/Tare -> Carton/Package -> Item|
|**LooseAssortmentCase**|Shipment -> Order -> Carton/Package -> Item|
|**PalletOfItems**|Shipment -> Order -> Pallet/Tare -> Item|
|**PalletizedStandardCase**|Shipment -> Order -> Pallet/Tare -> Item -> Carton/Package|
|**LooseStandardCase**|Shipment -> Order -> Item -> Carton/Package|
|**MasterPallet**|Shipment -> Pallet/Tare -> Order -> Item|
|**MasterCase**|Shipment -> Carton/Package -> Order -> Item|


<a name="unitofmeasure"></a>
### UnitOfMeasure
*Type* : enum

<a id="unitofmeasure-subgroup-1"></a>**For use with the definition(s): [Weight](#weight)**
The unit of measurement.

|Value|Description|
|---|---|
|**G**|Grams|
|**Kg**|Kilograms|
|**Oz**|Ounces|
|**Lb**|Pounds|

<a id="unitofmeasure-subgroup-2"></a>**For use with the definition(s): [Dimensions](#dimensions)**
The unit of measure for dimensions.

|Value|Description|
|---|---|
|**In**|Inches|
|**Ft**|Feet|
|**Meter**|Meters|
|**Yard**|Yards|

<a id="unitofmeasure-subgroup-3"></a>**For use with the definition(s): [Volume](#volume)**
The unit of measurement.

|Value|Description|
|---|---|
|**CuFt**|Cubic feet.|
|**CuIn**|Cubic inches.|
|**CuM**|Cubic meter.|
|**CuY**|Cubic yard.|

<a id="unitofmeasure-subgroup-4"></a>**For use with the definition(s): [ItemQuantity](#itemquantity)**
Unit of measure for the shipped quantity.

|Value|Description|
|---|---|
|**Cases**|Packing of individual items into a case.|
|**Eaches**|Individual items.|

