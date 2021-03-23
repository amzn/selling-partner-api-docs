# Selling Partner API for FBA Inventory


<a name="overview"></a>
## Overview
The Selling Partner API for FBA Inventory lets you programmatically retrieve information about inventory in Amazon's fulfillment network. Today this API is available only in the North America region. In 2021 we plan to release this API in the Europe and Far East regions.


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
[getInventorySummaries](#getinventorysummaries)<br>
<a name="paths"></a>
## Paths

<a name="getinventorysummaries"></a>
### GET /fba/inventory/v1/summaries
**Operation: getInventorySummaries**

#### Description
Returns a list of inventory summaries. The summaries returned depend on the presence or absence of the startDateTime and sellerSkus parameters:

- All inventory summaries with available details are returned when the startDateTime and sellerSkus parameters are omitted.
- When startDateTime is provided, the operation returns inventory summaries that have had changes after the date and time specified. The sellerSkus parameter is ignored.
- When the sellerSkus parameter is provided, the operation returns inventory summaries for only the specified sellerSkus.

**Usage Plan:**

| Rate (requests per second) | Burst |
| ---- | ---- |
| 90 | 150 |

For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|Default|
|---|---|---|---|---|
|**Query**|**details**  <br>*optional*|true to return inventory summaries with additional summarized inventory details and quantities. Otherwise, returns inventory summaries only (default value).|boolean|`"false"`|
|**Query**|**granularityType**  <br>*required*|The granularity type for the inventory aggregation level.|enum ([GranularityType](#granularitytype))|-|
|**Query**|**granularityId**  <br>*required*|The granularity ID for the inventory aggregation level.|string|-|
|**Query**|**startDateTime**  <br>*optional*|A start date and time in ISO8601 format. If specified, all inventory summaries that have changed since then are returned. You must specify a date and time that is no earlier than 18 months prior to the date and time when you call the API. Note: Changes in inboundWorkingQuantity, inboundShippedQuantity and inboundReceivingQuantity are not detected.|string (date-time)|-|
|**Query**|**sellerSkus**  <br>*optional*|A list of seller SKUs for which to return inventory summaries. You may specify up to 50 SKUs.<br>**Max count** : 50|< string > array|-|
|**Query**|**nextToken**  <br>*optional*|String token returned in the response of your previous request.|string|-|
|**Query**|**marketplaceIds**  <br>*required*|The marketplace ID for the marketplace for which to return inventory summaries.<br>**Max count** : 1|< string > array|-|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference ID.|[GetInventorySummariesResponse](#getinventorysummariesresponse)|

For error status codes, descriptions and schemas, see [Error responses and schemas](#error-responses-and-schemas).
#### Produces

* `application/json`





<a name="error-responses-and-schemas"></a>
### Error Responses and Schemas
This table contains HTTP status codes and associated information for error responses.

|HTTP Code|Description|Schema|
|---|---|---|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers**:  <br>`x-amzn-RequestId` (string):Unique request reference ID.|[GetInventorySummariesResponse](#getinventorysummariesresponse)|
|**403**|Indicates access to the resource is forbidden. Possible reasons include Access Denied, Unauthorized, Expired Token, Invalid Signature or Resource Not Found.  <br>**Headers**:  <br>`x-amzn-RequestId` (string):Unique request reference ID.|[GetInventorySummariesResponse](#getinventorysummariesresponse)|
|**404**|The specified resource does not exist.  <br>**Headers**:  <br>`x-amzn-RequestId` (string):Unique request reference ID.|[GetInventorySummariesResponse](#getinventorysummariesresponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers**:  <br>`x-amzn-RequestId` (string):Unique request reference ID.|[GetInventorySummariesResponse](#getinventorysummariesresponse)|
|**500**|An unexpected condition occurred that prevented the server from fulfilling the request.  <br>**Headers**:  <br>`x-amzn-RequestId` (string):Unique request reference ID.|[GetInventorySummariesResponse](#getinventorysummariesresponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers**:  <br>`x-amzn-RequestId` (string):Unique request reference ID.|[GetInventorySummariesResponse](#getinventorysummariesresponse)|


<a name="definitions"></a>
## Definitions

<a name="granularity"></a>
### Granularity
Describes a granularity at which inventory data can be aggregated. For example, if you use Marketplace granularity, the fulfillable quantity will reflect inventory that could be fulfilled in the given marketplace.


|Name|Description|Schema|
|---|---|---|
|**granularityType**  <br>*optional*|The granularity type for the inventory aggregation level.|enum ([GranularityType](#granularitytype))|
|**granularityId**  <br>*optional*|The granularity ID for the specified granularity type. When granularityType is Marketplace, specify the marketplaceId.|string|


<a name="reservedquantity"></a>
### ReservedQuantity
The quantity of reserved inventory.


|Name|Description|Schema|
|---|---|---|
|**totalReservedQuantity**  <br>*optional*|The total number of units in Amazon's fulfillment network that are currently being picked, packed, and shipped; or are sidelined for measurement, sampling, or other internal processes.|integer|
|**pendingCustomerOrderQuantity**  <br>*optional*|The number of units reserved for customer orders.|integer|
|**pendingTransshipmentQuantity**  <br>*optional*|The number of units being transferred from one fulfillment center to another.|integer|
|**fcProcessingQuantity**  <br>*optional*|The number of units that have been sidelined at the fulfillment center for additional processing.|integer|


<a name="researchingquantityentry"></a>
### ResearchingQuantityEntry
The misplaced or warehouse damaged inventory that is actively being confirmed at our fulfillment centers.


|Name|Description|Schema|
|---|---|---|
|**name**  <br>*required*|The duration of the research.|enum ([Name](#name))|
|**quantity**  <br>*required*|The number of units.|integer|


<a name="researchingquantity"></a>
### ResearchingQuantity
The number of misplaced or warehouse damaged units that are actively being confirmed at our fulfillment centers.


|Name|Description|Schema|
|---|---|---|
|**totalResearchingQuantity**  <br>*optional*|The total number of units currently being researched in Amazon's fulfillment network.|integer|
|**researchingQuantityBreakdown**  <br>*optional*|A list of quantity details for items currently being researched.|< [ResearchingQuantityEntry](#researchingquantityentry) > array|


<a name="unfulfillablequantity"></a>
### UnfulfillableQuantity
The quantity of unfulfillable inventory.


|Name|Description|Schema|
|---|---|---|
|**totalUnfulfillableQuantity**  <br>*optional*|The total number of units in Amazon's fulfillment network in unsellable condition.|integer|
|**customerDamagedQuantity**  <br>*optional*|The number of units in customer damaged disposition.|integer|
|**warehouseDamagedQuantity**  <br>*optional*|The number of units in warehouse damaged disposition.|integer|
|**distributorDamagedQuantity**  <br>*optional*|The number of units in distributor damaged disposition.|integer|
|**carrierDamagedQuantity**  <br>*optional*|The number of units in carrier damaged disposition.|integer|
|**defectiveQuantity**  <br>*optional*|The number of units in defective disposition.|integer|
|**expiredQuantity**  <br>*optional*|The number of units in expired disposition.|integer|


<a name="inventorydetails"></a>
### InventoryDetails
Summarized inventory details. This object will not appear if the details parameter in the request is false.


|Name|Description|Schema|
|---|---|---|
|**fulfillableQuantity**  <br>*optional*|The item quantity that can be picked, packed, and shipped.|integer|
|**inboundWorkingQuantity**  <br>*optional*|The number of units in an inbound shipment for which you have notified Amazon.|integer|
|**inboundShippedQuantity**  <br>*optional*|The number of units in an inbound shipment that you have notified Amazon about and have provided a tracking number.|integer|
|**inboundReceivingQuantity**  <br>*optional*|The number of units that have not yet been received at an Amazon fulfillment center for processing, but are part of an inbound shipment with some units that have already been received and processed.|integer|
|**reservedQuantity**  <br>*optional*|The quantity of reserved inventory.|[ReservedQuantity](#reservedquantity)|
|**researchingQuantity**  <br>*optional*|The number of misplaced or warehouse damaged units that are actively being confirmed at our fulfillment centers.|[ResearchingQuantity](#researchingquantity)|
|**unfulfillableQuantity**  <br>*optional*|The quantity of unfulfillable inventory.|[UnfulfillableQuantity](#unfulfillablequantity)|


<a name="inventorysummary"></a>
### InventorySummary
Inventory summary for a specific item.


|Name|Description|Schema|
|---|---|---|
|**asin**  <br>*optional*|The Amazon Standard Identification Number (ASIN) of an item.|string|
|**fnSku**  <br>*optional*|Amazon's fulfillment network SKU identifier.|string|
|**sellerSku**  <br>*optional*|The seller SKU of the item.|string|
|**condition**  <br>*optional*|The condition of the item as described by the seller (for example, New Item).|string|
|**inventoryDetails**  <br>*optional*|Summarized inventory details. This object will not appear if the details parameter in the request is false.|[InventoryDetails](#inventorydetails)|
|**lastUpdatedTime**  <br>*optional*|The date and time that any quantity was last updated.|string (date-time)|
|**productName**  <br>*optional*|The localized language product title of the item within the specific marketplace.|string|
|**totalQuantity**  <br>*optional*|The total number of units in an inbound shipment or in Amazon fulfillment centers.|integer|


<a name="inventorysummaries"></a>
### InventorySummaries
A list of inventory summaries.

*Type* : < [InventorySummary](#inventorysummary) > array


<a name="pagination"></a>
### Pagination
The process of returning the results to a request in batches of a defined size called pages. This is done to exercise some control over result size and overall throughput. It's a form of traffic management.


|Name|Description|Schema|
|---|---|---|
|**nextToken**  <br>*optional*|A generated string used to retrieve the next page of the result. If nextToken is returned, pass the value of nextToken to the next request. If nextToken is not returned, there are no more items to return.|string|


<a name="getinventorysummariesresult"></a>
### GetInventorySummariesResult
The payload schema for the getInventorySummaries operation.


|Name|Description|Schema|
|---|---|---|
|**granularity**  <br>*required*|Describes a granularity at which inventory data can be aggregated. For example, if you use Marketplace granularity, the fulfillable quantity will reflect inventory that could be fulfilled in the given marketplace.|[Granularity](#granularity)|
|**inventorySummaries**  <br>*required*|A list of inventory summaries.|[InventorySummaries](#inventorysummaries)|


<a name="getinventorysummariesresponse"></a>
### GetInventorySummariesResponse
The Response schema.


|Name|Description|Schema|
|---|---|---|
|**payload**  <br>*optional*|The payload for the getInventorySummaries operation.|[GetInventorySummariesResult](#getinventorysummariesresult)|
|**pagination**  <br>*optional*|The process of returning the results to a request in batches of a defined size called pages. This is done to exercise some control over result size and overall throughput. It's a form of traffic management.|[Pagination](#pagination)|
|**errors**  <br>*optional*|One or more unexpected errors occurred during the getInventorySummaries operation.|[ErrorList](#errorlist)|


<a name="error"></a>
### Error
An error response returned when the request is unsuccessful.


|Name|Description|Schema|
|---|---|---|
|**code**  <br>*required*|An error code that identifies the type of error that occurred.|string|
|**message**  <br>*optional*|A message that describes the error condition in a human-readable form.|string|
|**details**  <br>*optional*|Additional information that can help the caller understand or fix the issue.|string|


<a name="errorlist"></a>
### ErrorList
A list of error responses returned when a request is unsuccessful.

*Type* : < [Error](#error) > array


<a name="granularitytype"></a>
### GranularityType
The granularity type for the inventory aggregation level.

*Type* : enum


|Value|Description|
|---|---|
|**Marketplace**|Marketplace|


<a name="name"></a>
### Name
The duration of the research.

*Type* : enum


|Value|Description|
|---|---|
|**researchingQuantityInShortTerm**|Short Term for 1-10 days.|
|**researchingQuantityInMidTerm**|Mid Term for 11-20 days.|
|**researchingQuantityInLongTerm**|Long Term for 21 days or longer.|

