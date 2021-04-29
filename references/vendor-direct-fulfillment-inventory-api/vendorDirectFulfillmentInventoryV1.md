# Selling Partner API for Direct Fulfillment Inventory Updates


<a name="overview"></a>
## Overview
The Selling Partner API for Direct Fulfillment Inventory Updates provides programmatic access to a direct fulfillment vendor's inventory updates.


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
[submitInventoryUpdate](#submitinventoryupdate)<br>
<a name="paths"></a>
## Paths

<a name="submitinventoryupdate"></a>
### POST /vendor/directFulfillment/inventory/v1/warehouses/{warehouseId}/items
**Operation: submitInventoryUpdate**

#### Description
Submits inventory updates for the specified warehouse for either a partial or full feed of inventory items.

**Usage Plans:**

| Plan type | Rate (requests per second) | Burst |
| ---- | ---- | ---- |
|Default| 10 | 10 |
|Selling partner specific| Variable | Variable |

The x-amzn-RateLimit-Limit response header returns the usage plan rate limits that were applied to the requested operation. Rate limits for some selling partners will vary from the default rate and burst shown in the table above. For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Body**|**body**  <br>*required*|The request body for the submitInventoryUpdate operation.|[SubmitInventoryUpdateRequest](#submitinventoryupdaterequest)|
|**Path**|**warehouseId**  <br>*required*|Identifier for the warehouse for which to update inventory.|string|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**202**|Success.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[SubmitInventoryUpdateResponse](#submitinventoryupdateresponse)|

For error status codes, descriptions and schemas, see [Error responses and schemas](#error-responses-and-schemas).



<a name="error-responses-and-schemas"></a>
### Error Responses and Schemas
This table contains HTTP status codes and associated information for error responses.

|HTTP Code|Description|Schema|
|---|---|---|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers**:  <br>`x-amzn-RateLimit-Limit` (string):Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string):Unique request reference identifier.|[SubmitInventoryUpdateResponse](#submitinventoryupdateresponse)|
|**403**|Indicates that access to the resource is forbidden. Possible reasons include Access Denied, Unauthorized, Expired Token, or Invalid Signature.  <br>**Headers**:  <br>`x-amzn-RequestId` (string):Unique request reference identifier.|[SubmitInventoryUpdateResponse](#submitinventoryupdateresponse)|
|**404**|The resource specified does not exist.  <br>**Headers**:  <br>`x-amzn-RequestId` (string):Unique request reference identifier.|[SubmitInventoryUpdateResponse](#submitinventoryupdateresponse)|
|**413**|The request size exceeded the maximum accepted size.  <br>**Headers**:  <br>`x-amzn-RateLimit-Limit` (string):Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string):Unique request reference identifier.|[SubmitInventoryUpdateResponse](#submitinventoryupdateresponse)|
|**415**|The request payload is in an unsupported format.  <br>**Headers**:  <br>`x-amzn-RateLimit-Limit` (string):Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string):Unique request reference identifier.|[SubmitInventoryUpdateResponse](#submitinventoryupdateresponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers**:  <br>`x-amzn-RateLimit-Limit` (string):Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string):Unique request reference identifier.|[SubmitInventoryUpdateResponse](#submitinventoryupdateresponse)|
|**500**|An unexpected condition occurred that prevented the server from fulfilling the request.  <br>**Headers**:  <br>`x-amzn-RateLimit-Limit` (string):Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string):Unique request reference identifier.|[SubmitInventoryUpdateResponse](#submitinventoryupdateresponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers**:  <br>`x-amzn-RateLimit-Limit` (string):Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string):Unique request reference identifier.|[SubmitInventoryUpdateResponse](#submitinventoryupdateresponse)|


<a name="definitions"></a>
## Definitions

<a name="submitinventoryupdaterequest"></a>
### SubmitInventoryUpdateRequest
The request body for the submitInventoryUpdate operation.


|Name|Description|Schema|
|---|---|---|
|**inventory**  <br>*optional*|Inventory details required to update some or all items for the requested warehouse.|[InventoryUpdate](#inventoryupdate)|


<a name="inventoryupdate"></a>
### InventoryUpdate

|Name|Description|Schema|
|---|---|---|
|**sellingParty**  <br>*required*|ID of the selling party or vendor.|[PartyIdentification](#partyidentification)|
|**isFullUpdate**  <br>*required*|When true, this request contains a full feed. Otherwise, this request contains a partial feed. When sending a full feed, you must send information about all items in the warehouse. Any items not in the full feed are updated as not available. When sending a partial feed, only include the items that need an update to inventory. The status of other items will remain unchanged.|boolean|
|**items**  <br>*required*|A list of inventory items with updated details, including quantity available.|< [ItemDetails](#itemdetails) > array|


<a name="itemdetails"></a>
### ItemDetails
Updated inventory details for an item.


|Name|Description|Schema|
|---|---|---|
|**buyerProductIdentifier**  <br>*optional*|The buyer selected product identification of the item. Either buyerProductIdentifier or vendorProductIdentifier should be submitted.|string|
|**vendorProductIdentifier**  <br>*optional*|The vendor selected product identification of the item. Either buyerProductIdentifier or vendorProductIdentifier should be submitted.|string|
|**availableQuantity**  <br>*required*|Total item quantity available in the warehouse.|[ItemQuantity](#itemquantity)|
|**isObsolete**  <br>*optional*|When true, the item is permanently unavailable.|boolean|


<a name="partyidentification"></a>
### PartyIdentification

|Name|Description|Schema|
|---|---|---|
|**partyId**  <br>*required*|Assigned identification for the party.|string|


<a name="itemquantity"></a>
### ItemQuantity
Details of item quantity.


|Name|Description|Schema|
|---|---|---|
|**amount**  <br>*optional*|Quantity of units available for a specific item.|integer|
|**unitOfMeasure**  <br>*required*|Unit of measure for the available quantity.|string|


<a name="submitinventoryupdateresponse"></a>
### SubmitInventoryUpdateResponse
The response schema for the submitInventoryUpdate operation.


|Name|Description|Schema|
|---|---|---|
|**payload**  <br>*optional*|The response payload for the submitInventoryUpdate operation.|[TransactionReference](#transactionreference)|
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

