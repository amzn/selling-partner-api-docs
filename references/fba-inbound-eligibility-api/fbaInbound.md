# Selling Partner API for FBA Inbound Eligibilty


<a name="overview"></a>
## Overview
With the FBA Inbound Eligibility API, you can build applications that let sellers get eligibility previews for items before shipping them to Amazon's fulfillment centers. With this API you can find out if an item is eligible for inbound shipment to Amazon's fulfillment centers in a specific marketplace. You can also find out if an item is eligible for using the manufacturer barcode for FBA inventory tracking. Sellers can use this information to inform their decisions about which items to ship Amazon's fulfillment centers.


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
[getItemEligibilityPreview](#getitemeligibilitypreview)<br>
<a name="paths"></a>
## Paths

<a name="getitemeligibilitypreview"></a>
### GET /fba/inbound/v1/eligibility/itemPreview
**Operation: getItemEligibilityPreview**

#### Description
This operation gets an eligibility preview for an item that you specify. You can specify the type of eligibility preview that you want (INBOUND or COMMINGLING). For INBOUND previews, you can specify the marketplace in which you want to determine the item's eligibility.

**Usage Plan:**

| Rate (requests per second) | Burst |
| ---- | ---- |
| 1 | 1 |

For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Query**|**marketplaceIds**  <br>*optional*|The identifier for the marketplace in which you want to determine eligibility. Required only when program=INBOUND.<br>**Max count** : 1|< string > array|
|**Query**|**asin**  <br>*required*|The ASIN of the item for which you want an eligibility preview.|string|
|**Query**|**program**  <br>*required*|The program that you want to check eligibility against.|enum ([Program](#program-subgroup-2))|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Success.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference ID.|[GetItemEligibilityPreviewResponse](#getitemeligibilitypreviewresponse)|

For error status codes, descriptions and schemas, see [Error responses and schemas](#error-responses-and-schemas).



<a name="error-responses-and-schemas"></a>
### Error Responses and Schemas
This table contains HTTP status codes and associated information for error responses.

|HTTP Code|Description|Schema|
|---|---|---|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers**:  <br>`x-amzn-RateLimit-Limit` (string):Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string):Unique request reference ID.|[GetItemEligibilityPreviewResponse](#getitemeligibilitypreviewresponse)|
|**401**|The request's Authorization header is not formatted correctly or does not contain a valid token.  <br>**Headers**:  <br>`x-amzn-RateLimit-Limit` (string):Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string):Unique request reference ID.|[GetItemEligibilityPreviewResponse](#getitemeligibilitypreviewresponse)|
|**403**|403 can be caused for reasons like Access Denied, Unauthorized, Expired Token, Invalid Signature or Resource Not Found.  <br>**Headers**:  <br>`x-amzn-RequestId` (string):Unique request reference ID.|[GetItemEligibilityPreviewResponse](#getitemeligibilitypreviewresponse)|
|**404**|The resource specified does not exist.  <br>**Headers**:  <br>`x-amzn-RateLimit-Limit` (string):Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string):Unique request reference ID.|[GetItemEligibilityPreviewResponse](#getitemeligibilitypreviewresponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers**:  <br>`x-amzn-RateLimit-Limit` (string):Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string):Unique request reference ID.|[GetItemEligibilityPreviewResponse](#getitemeligibilitypreviewresponse)|
|**500**|Encountered an unexpected condition which prevented the server from fulfilling the request.  <br>**Headers**:  <br>`x-amzn-RateLimit-Limit` (string):Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string):Unique request reference ID.|[GetItemEligibilityPreviewResponse](#getitemeligibilitypreviewresponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers**:  <br>`x-amzn-RateLimit-Limit` (string):Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string):Unique request reference ID.|[GetItemEligibilityPreviewResponse](#getitemeligibilitypreviewresponse)|


<a name="definitions"></a>
## Definitions

<a name="getitemeligibilitypreviewresponse"></a>
### GetItemEligibilityPreviewResponse
The response schema for the getItemEligibilityPreview operation.


|Name|Description|Schema|
|---|---|---|
|**payload**  <br>*optional*|The payload for the getItemEligibilityPreview operation.|[ItemEligibilityPreview](#itemeligibilitypreview)|
|**errors**  <br>*optional*|An unexpected condition occurred during the GetItemEligibilityPreview operation.|[ErrorList](#errorlist)|


<a name="itemeligibilitypreview"></a>
### ItemEligibilityPreview
The response object which contains the ASIN, marketplaceId if required, eligibility program, the eligibility status (boolean), and a list of ineligibility reason codes.


|Name|Description|Schema|
|---|---|---|
|**asin**  <br>*required*|The ASIN for which eligibility was determined.|string|
|**marketplaceId**  <br>*optional*|The marketplace for which eligibility was determined.|string|
|**program**  <br>*required*|The program for which eligibility was determined.|enum ([Program](#program-subgroup-1))|
|**isEligibleForProgram**  <br>*required*|Indicates if the item is eligible for the program.|boolean|
|**ineligibilityReasonList**  <br>*optional*|Potential Ineligibility Reason Codes.|< enum ([IneligibilityReasonList](#ineligibilityreasonlist)) > array|


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
|**message**  <br>*optional*|A message that describes the error condition in a human-readable form.|string|
|**details**  <br>*optional*|Additional information that can help the caller understand or fix the issue.|string|


<a name="ineligibilityreasonlist"></a>
### IneligibilityReasonList
Potential Ineligibility Reason Codes.

*Type* : enum


|Value|Description|
|---|---|
|**FBA_INB_0004**|Missing package dimensions. This product is missing necessary information; dimensions need to be provided in the manufacturer's original packaging.|
|**FBA_INB_0006**|The SKU for this product is unknown or cannot be found.|
|**FBA_INB_0007**|Product Under Dangerous Goods (Hazmat) Review. We do not have enough information to determine what the product is or comes with to enable us to complete our dangerous goods review. Until you provide the necessary information, the products will not be available for sale and you will not be able to send more units to Amazon fulfillment centers. You will need to add more details to the product listings, such as a clear title, bullet points, description, and image. The review process takes 4 business days.|
|**FBA_INB_0008**|Product Under Dangerous Goods (Hazmat) Review. We require detailed battery information to correctly classify the product, and until you provide the necessary information, the products will not be available for sale and you will not be able to send more units to Amazon fulfillment centers. Download an exemption sheet for battery and battery-powered products available in multiple languages in "Upload dangerous goods documents: safety data sheet (SDS) or exemption sheet" in Seller Central and follow instructions to submit it through the same page. The review process takes 4 business days.|
|**FBA_INB_0009**|Product Under Dangerous Goods (Hazmat) Review. We do not have enough dangerous goods information to correctly classify the product and until you provide the necessary information, the products will not be available for sale and you will not be able to send more units to Amazon fulfillment centers. Please provide a Safety Data Sheet (SDS) through "Upload dangerous goods documents: safety data sheet (SDS) or exemption sheet" in Seller Central, and make sure the SDS complies with all the requirements. The review process takes 4 business days.|
|**FBA_INB_0010**|Product Under Dangerous Goods (Hazmat) Review. The dangerous goods information is mismatched and so the product cannot be correctly classified. Until you provide the necessary information, the products will not be available for sale and you will not be able to send more units to Amazon fulfillment centers. Please provide compliant documents through "Upload dangerous goods documents: safety data sheet (SDS) or exemption sheet" in Seller Central, and make sure it complies with all the requirements. The review process takes 4 business days, the product will remain unfulfillable until review process is complete.|
|**FBA_INB_0011**|Product Under Dangerous Goods (Hazmat) Review. We have incomplete, inaccurate or conflicting dangerous goods information and cannot correctly classify the product. Until you provide the necessary information, the products will not be available for sale and you will not be able to send more units to Amazon fulfillment centers. Please provide compliant documents through "Upload dangerous goods documents: safety data sheet (SDS) or exemption sheet" in Seller Central, and make sure it complies with all the requirements. The review process takes 4 business days and the product will remain unfulfillable until the review process is complete.|
|**FBA_INB_0012**|Product Under Dangerous Goods (Hazmat) Review. We have determined there is conflicting product information (title, bullet points, images, or product description) within the product detail pages or with other offers for the product. Until the conflicting information is corrected, the products will not be available for sale and you will not be able to send more units to Amazon fulfillment centers. We need you to confirm the information on the product detail page The review process takes 4 business days.|
|**FBA_INB_0013**|Product Under Dangerous Goods (Hazmat) Review. Additional information is required in order to complete the Hazmat review process.|
|**FBA_INB_0014**|Product Under Dangerous Goods (Hazmat) Review. The product has been identified as possible dangerous goods. The review process generally takes 4 - 7 business days and until the review process is complete the product is unfulfillable and cannot be received at Amazon fulfilment centers or ordered by customers. For more information about dangerous goods please see "Dangerous goods identification guide (hazmat)"" help page in Seller Central.|
|**FBA_INB_0015**|Dangerous goods (Hazmat). The product is regulated as unfulfillable and not eligible for sale with Amazon. We ask that you refrain from sending additional units in new shipments. We will need to dispose of your dangerous goods inventory in accordance with the terms of the Amazon Business Services Agreement. If you have questions or concerns, please contact Seller Support within five business days of this notice. For more information about dangerous goods please see “Dangerous goods identification guide (hazmat)” help page in Seller Central.|
|**FBA_INB_0016**|Dangerous goods (Hazmat). The product is regulated as a fulfillable dangerous good (Hazmat). You may need to be in the FBA dangerous good (Hazmat) program to be able to sell your product. For more information on the FBA dangerous good (Hazmat) program please contact Seller Support. For more information about dangerous goods please see the "Dangerous goods identification guide (hazmat)" help page in Seller Central.|
|**FBA_INB_0017**|This product does not exist in the destination marketplace catalog. The necessary product information will need to be provided before it can be inbounded.|
|**FBA_INB_0018**|Product missing category. This product must have a category specified before it can be sent to Amazon.|
|**FBA_INB_0019**|This product must have a title before it can be sent to Amazon.|
|**FBA_INB_0034**|Product cannot be stickerless, commingled. This product must be removed. You can send in new inventory by creating a new listing for this product that requires product labels.|
|**FBA_INB_0035**|Expiration-dated/lot-controlled product needs to be labeled. This product requires labeling to be received at our fulfillment centers.|
|**FBA_INB_0036**|Expiration-dated or lot-controlled product needs to be commingled. This product cannot be shipped to Amazon without being commingled. This error condition cannot be corrected from here. This product must be removed.|
|**FBA_INB_0037**|This product is not eligible to be shipped to our fulfillment center. You do not have all the required tax documents. If you have already filed documents please wait up to 48 hours for the data to propagate.|
|**FBA_INB_0038**|Parent ASIN cannot be fulfilled by Amazon. You can send this product by creating a listing against the child ASIN.|
|**FBA_INB_0050**|There is currently no fulfillment center in the destination country capable of receiving this product. Please delete this product from the shipment or contact Seller Support if you believe this is an error.|
|**FBA_INB_0051**|This product has been blocked by FBA and cannot currently be sent to Amazon for fulfillment.|
|**FBA_INB_0053**|Product is not eligible in the destination marketplace. This product is not eligible either because the required shipping option is not available or because the product is too large or too heavy.|
|**FBA_INB_0055**|Product unfulfillable due to media region restrictions. This product has a region code restricted for this marketplace. This product must be removed.|
|**FBA_INB_0056**|Product is ineligible for inbound. Used non-media goods cannot be shipped to Amazon.|
|**FBA_INB_0059**|Unknown Exception. This product must be removed at this time.|
|**FBA_INB_0065**|Product cannot be stickerless, commingled. This product must be removed. You can send in new inventory by creating a new listing for this product that requires product labels.|
|**FBA_INB_0066**|Unknown Exception. This product must be removed at this time.|
|**FBA_INB_0067**|Product ineligible for freight shipping. This item is ineligible for freight shipping with our Global Shipping Service. This item must be removed.|
|**FBA_INB_0068**|Account not configured for expiration-dated or lot-controlled products. Please contact TAM if you would like to configure your account to handle expiration-dated or lot-controlled inventory. Once configured, you will be able to send in this product.|
|**FBA_INB_0095**|The barcode (UPC/EAN/JAN/ISBN) for this product is associated with more than one product in our fulfillment system. This product must be removed. You can send in new inventory by creating a new listing for this product that requires product labels.|
|**FBA_INB_0097**|Fully regulated dangerous good.|
|**FBA_INB_0098**|Merchant is not authorized to send item to destination marketplace.|
|**FBA_INB_0099**|Seller account previously terminated.|
|**FBA_INB_0100**|You do not have the required tax information to send inventory to fulfillment centers in Mexico.|
|**FBA_INB_0103**|This is an expiration-dated/lot-controlled product that cannot be handled at this time.|
|**FBA_INB_0104**|Item Requires Manufacturer Barcode. Only NEW products can be stored in our fulfillment centers without product labels.|
|**UNKNOWN_INB_ERROR_CODE**|Unknown Ineligibility Reason.|


<a name="program"></a>
### Program
*Type* : enum

<a id="program-subgroup-1"></a>**For use with the definition(s): [ItemEligibilityPreview](#itemeligibilitypreview)**
The program for which eligibility was determined.

|Value|Description|
|---|---|
|**INBOUND**|Inbound shipment.|
|**COMMINGLING**|Using the manufacturer barcode for FBA inventory tracking.|

<a id="program-subgroup-2"></a>**For use with the operation(s): [getItemEligibilityPreview](#getitemeligibilitypreview)**
The program that you want to check eligibility against.

|Value|Description|
|---|---|
|**INBOUND**|-|
|**COMMINGLING**|-|

