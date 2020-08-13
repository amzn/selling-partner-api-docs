# Selling Partner API for Uploads


<a name="overview"></a>
## Overview
The Selling Partner API for Uploads provides operations that support uploading files. These operations support the Selling Partner APIs for Feeds and EasyShip, for example.


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
[createUploadDestination](#createuploaddestination)<br>[createUploadDestinationForFeed](#createuploaddestinationforfeed)<br>
<a name="paths"></a>
## Paths

<a name="createuploaddestination"></a>
### POST /uploads/v1/uploadDestinations
**Operation: createUploadDestination**

#### Description
Creates an upload destination and returns the required information to upload to that destination.

**Usage Plan:**

| Rate (requests per second) | Burst |
| ---- | ---- |
| .1 | 5 |

For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Query**|**marketplaceIds**  <br>*required*|Marketplace identifiers. Specifies the marketplace where the upload will be available. NOTE: Accepts only a single marketplace.<br>**Max count** : 1|< string > array|
|**Query**|**Content-MD5**  <br>*required*|An MD5 hash of the content to be submitted to the upload destination. This value is used to determine if the data has been corrupted or tampered with during transit.|string|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**201**|Successfully created an upload destination.  <br>**Headers** :   <br>`x-amzn-requestId` (string) : Unique request reference ID.  <br>`Location` (string) : The URI of the created destination.|[CreateUploadDestinationResponse](#createuploaddestinationresponse)|

For error status codes, descriptions and schemas, see [Error responses and schemas](#error-responses-and-schemas).
<a name="createuploaddestinationforfeed"></a>
### POST /uploads/v1/uploadDestinations/feeds/{feedType}
**Operation: createUploadDestinationForFeed**

#### Description
Creates an upload destination for the specified feed type and returns the required information to upload to that destination.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**feedType**  <br>*required*|-|enum ([FeedType](#feedtype))|
|**Query**|**Content-Type**  <br>*required*|The content type of the feed. Possible values: text/tab-separated-values; charset=iso-8859-1, text/tab-separated-values; charset=Shift_JIS, text/xml|string|
|**Query**|**Content-Length**  <br>*required*|The content length of the feed in bytes.|integer|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**201**|Successfully created an upload destination for a feed.  <br>**Headers** :   <br>`x-amzn-requestId` (string) : Unique request reference ID.|[CreateUploadDestinationResponse](#createuploaddestinationresponse)|

For error status codes, descriptions and schemas, see [Error responses and schemas](#error-responses-and-schemas).



<a name="error-responses-and-schemas"></a>
### Error Responses and Schemas
This table contains HTTP status codes and associated information for error responses.

|HTTP Code|Description|Schema|
|---|---|---|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers**:  <br>`x-amzn-RequestId` (string):Unique request reference ID.|[CreateUploadDestinationResponse](#createuploaddestinationresponse)|
|**403**|Indicates that access to the resource is forbidden. Possible reasons include Access Denied, Unauthorized, Expired Token, or Invalid Signature.  <br>**Headers**:  <br>`x-amzn-RequestId` (string):Unique request reference ID.|[CreateUploadDestinationResponse](#createuploaddestinationresponse)|
|**404**|The resource specified does not exist.  <br>**Headers**:  <br>`x-amzn-RequestId` (string):Unique request reference ID.|[CreateUploadDestinationResponse](#createuploaddestinationresponse)|
|**413**|The request size exceeded the maximum accepted size.  <br>**Headers**:  <br>`x-amzn-RequestId` (string):Unique request reference ID.|[CreateUploadDestinationResponse](#createuploaddestinationresponse)|
|**415**|The request payload is in an unsupported format.  <br>**Headers**:  <br>`x-amzn-RequestId` (string):Unique request reference ID.|[CreateUploadDestinationResponse](#createuploaddestinationresponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers**:  <br>`x-amzn-RequestId` (string):Unique request reference ID.|[CreateUploadDestinationResponse](#createuploaddestinationresponse)|
|**500**|An unexpected condition occurred that prevented the server from fulfilling the request.  <br>**Headers**:  <br>`x-amzn-RequestId` (string):Unique request reference ID.|[CreateUploadDestinationResponse](#createuploaddestinationresponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers**:  <br>`x-amzn-RequestId` (string):Unique request reference ID.|[CreateUploadDestinationResponse](#createuploaddestinationresponse)|


<a name="definitions"></a>
## Definitions

<a name="createuploaddestinationresponse"></a>
### CreateUploadDestinationResponse
The response schema for the createUploadDestination operation.


|Name|Description|Schema|
|---|---|---|
|**payload**  <br>*optional*|Information about an upload destination.|[UploadDestination](#uploaddestination)|
|**errors**  <br>*optional*|A list of error responses returned when a request is unsuccessful.|[ErrorList](#errorlist)|


<a name="uploaddestination"></a>
### UploadDestination
Information about an upload destination.


|Name|Description|Schema|
|---|---|---|
|**uploadDestinationId**  <br>*optional*|The unique identifier to be used by APIs that reference the upload destination.|string|
|**url**  <br>*optional*|The URL to which to upload the file.|string|
|**encryptionDetails**  <br>*optional*|Encryption details for the required client-side encryption of the upload.|[EncryptionDetails](#encryptiondetails)|
|**headers**  <br>*optional*|The headers to include in the upload request.|object|


<a name="encryptiondetails"></a>
### EncryptionDetails
Encryption details for the required client-side encryption of the upload.


|Name|Description|Schema|
|---|---|---|
|**standard**  <br>*optional*|The encryption standard required prior to upload.|enum ([Standard](#standard))|
|**initializationVector**  <br>*optional*|The vector to encrypt the content using Cipher Block Chaining (CBC).|string|
|**key**  <br>*optional*|The encryption key used to encrypt the content.|string|


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


<a name="feedtype"></a>
### FeedType
*Type* : enum


|Value|Description|
|---|---|
|**\_POST_PRODUCT_DATA_**|The Product feed.|
|**\_POST_INVENTORY_AVAILABILITY_DATA_**|The Inventory feed.|
|**\_POST_PRODUCT_OVERRIDES_DATA_**|The Overrides feed.|
|**\_POST_PRODUCT_PRICING_DATA_**|The Pricing feed.|
|**\_POST_PRODUCT_IMAGE_DATA_**|The Product Images feed.|
|**\_POST_PRODUCT_RELATIONSHIP_DATA_**|The Relationships feed.|
|**\_POST_FLAT_FILE_INVLOADER_DATA_**|The Flat File Inventory Loader feed.|
|**\_POST_FLAT_FILE_LISTINGS_DATA_**|The Flat File Listings feed.|
|**\_POST_FLAT_FILE_BOOKLOADER_DATA_**|The Flat File Book Loader feed.|
|**\_POST_FLAT_FILE_CONVERGENCE_LISTINGS_DATA_**|The Flat File Music Loader feed.|
|**\_POST_FLAT_FILE_PRICEANDQUANTITYONLY_UPDATE_DATA_**|The Flat File Price and Quantity Update feed.|
|**\_POST_UIEE_BOOKLOADER_DATA_**|The UIEE Inventory feed.|
|**\_POST_STD_ACES_DATA_**|The ACES 3.0 Data (Automotive Part Finder) feed.|
|**\_POST_ORDER_ACKNOWLEDGEMENT_DATA_**|The Order Acknowledgement feed.|
|**\_POST_PAYMENT_ADJUSTMENT_DATA_**|The Order Adjustments feed.|
|**\_POST_ORDER_FULFILLMENT_DATA_**|The Order Fulfillment feed.|
|**\_POST_INVOICE_CONFIRMATION_DATA_**|The Invoice Confirmation feed.|
|**\_POST_EXPECTED_SHIP_DATE_SOD_**|The Sourcing On Demand feed.|
|**\_POST_FLAT_FILE_ORDER_ACKNOWLEDGEMENT_DATA_**|The Flat File Order Acknowledgement feed.|
|**\_POST_FLAT_FILE_PAYMENT_ADJUSTMENT_DATA_**|The Flat File Order Adjustments feed.|
|**\_POST_FLAT_FILE_FULFILLMENT_DATA_**|The Flat File Order Fulfillment feed.|
|**\_POST_EXPECTED_SHIP_DATE_SOD_FLAT_FILE_**|The Flat File Sourcing On Demand feed.|
|**\_POST_FULFILLMENT_ORDER_REQUEST_DATA_**|The FBA Fulfillment Order feed.|
|**\_POST_FULFILLMENT_ORDER_CANCELLATION_REQUEST_DATA_**|The FBA Fulfillment Order Cancellation feed.|
|**\_POST_FBA_INBOUND_CARTON_CONTENTS_**|The FBA Inbound Shipment Carton Information feed.|
|**\_POST_FLAT_FILE_FULFILLMENT_ORDER_REQUEST_DATA_**|The Flat File FBA Fulfillment Order feed.|
|**\_POST_FLAT_FILE_FULFILLMENT_ORDER_CANCELLATION_REQUEST_DATA_**|The Flat File FBA Fulfillment Order Cancellation feed.|
|**\_POST_FLAT_FILE_FBA_CREATE_INBOUND_PLAN_**|The Flat File FBA Create Inbound Shipment Plan feed.|
|**\_POST_FLAT_FILE_FBA_UPDATE_INBOUND_PLAN_**|The Flat File FBA Update Inbound Shipment Plan feed.|
|**\_POST_FLAT_FILE_FBA_CREATE_REMOVAL_**|The Flat File FBA Create Removal feed.|
|**\_POST_ENHANCED_CONTENT_DATA_**|The Enhanced Content feed.|
|**\_RFQ_UPLOAD_FEED_**|The Flat File Manage Quotes feed.|
|**\_POST_EASYSHIP_DOCUMENTS_**|The Easy Ship feed.|


<a name="standard"></a>
### Standard
The encryption standard required prior to upload.

*Type* : enum


|Value|Description|
|---|---|
|**AES**|AES|

