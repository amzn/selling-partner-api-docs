# Selling Partner API for Catalog Items


<a name="overview"></a>
## Overview
The Selling Partner API for Catalog Items provides programmatic access to information about items in the Amazon catalog.


### Version information
*Version* : 2020-12-01


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
[searchCatalogItems](#searchcatalogitems)<br>[getCatalogItem](#getcatalogitem)<br>
<a name="paths"></a>
## Paths

<a name="searchcatalogitems"></a>
### GET /catalog/2020-12-01/items
**Operation: searchCatalogItems**

#### Description
Search for and return a list of Amazon catalog items and associated information.

**Usage Plans:**

| Plan type | Rate (requests per second) | Burst |
| ---- | ---- | ---- |
|Default| 1 | 5 |
|Selling partner specific| Variable | Variable |

The x-amzn-RateLimit-Limit response header returns the usage plan rate limits that were applied to the requested operation. Rate limits for some selling partners will vary from the default rate and burst shown in the table above. For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|Default|
|---|---|---|---|---|
|**Query**|**keywords**  <br>*required*|A comma-delimited list of words or item identifiers to search the Amazon catalog for.|< string > array(csv)|-|
|**Query**|**marketplaceIds**  <br>*required*|A comma-delimited list of Amazon marketplace identifiers for the request.<br>**Max count** : 1|< string > array(csv)|-|
|**Query**|**includedData**  <br>*optional*|A comma-delimited list of data sets to include in the response. Default: summaries.|< enum ([IncludedData](#includeddata-subgroup-1)) > array(csv)|-|
|**Query**|**brandNames**  <br>*optional*|A comma-delimited list of brand names to limit the search to.|< string > array(csv)|-|
|**Query**|**classificationIds**  <br>*optional*|A comma-delimited list of classification identifiers to limit the search to.|< string > array(csv)|-|
|**Query**|**pageSize**  <br>*optional*|Number of results to be returned per page.<br>**Maximum** : 20|integer|`10`|
|**Query**|**pageToken**  <br>*optional*|A token to fetch a certain page when there are multiple pages worth of results.|string|-|
|**Query**|**keywordsLocale**  <br>*optional*|The language the keywords are provided in. Defaults to the primary locale of the marketplace.|string|-|
|**Query**|**locale**  <br>*optional*|Locale for retrieving localized summaries. Defaults to the primary locale of the marketplace.|string|-|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Success.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[ItemSearchResults](#itemsearchresults)|

For error status codes, descriptions and schemas, see [Error responses and schemas](#error-responses-and-schemas).
#### Consumes

* `application/json`


#### Produces

* `application/json`


<a name="getcatalogitem"></a>
### GET /catalog/2020-12-01/items/{asin}
**Operation: getCatalogItem**

#### Description
Retrieves details for an item in the Amazon catalog.

**Usage Plans:**

| Plan type | Rate (requests per second) | Burst |
| ---- | ---- | ---- |
|Default| 5 | 5 |
|Selling partner specific| Variable | Variable |

The x-amzn-RateLimit-Limit response header returns the usage plan rate limits that were applied to the requested operation. Rate limits for some selling partners will vary from the default rate and burst shown in the table above. For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**asin**  <br>*required*|The Amazon Standard Identification Number (ASIN) of the item.|string|
|**Query**|**marketplaceIds**  <br>*required*|A comma-delimited list of Amazon marketplace identifiers. Data sets in the response contain data only for the specified marketplaces.|< string > array(csv)|
|**Query**|**includedData**  <br>*optional*|A comma-delimited list of data sets to include in the response. Default: summaries.|< enum ([IncludedData](#includeddata-subgroup-2)) > array(csv)|
|**Query**|**locale**  <br>*optional*|Locale for retrieving localized summaries. Defaults to the primary locale of the marketplace.|string|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Success.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[Item](#item)|

For error status codes, descriptions and schemas, see [Error responses and schemas](#error-responses-and-schemas).
#### Consumes

* `application/json`


#### Produces

* `application/json`





<a name="error-responses-and-schemas"></a>
### Error Responses and Schemas
This table contains HTTP status codes and associated information for error responses.

|HTTP Code|Description|Schema|
|---|---|---|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers**:  <br>`x-amzn-RateLimit-Limit` (string):Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string):Unique request reference identifier.|[ErrorList](#errorlist)|
|**403**|Indicates that access to the resource is forbidden. Possible reasons include Access Denied, Unauthorized, Expired Token, or Invalid Signature.  <br>**Headers**:  <br>`x-amzn-RequestId` (string):Unique request reference identifier.|[ErrorList](#errorlist)|
|**404**|The resource specified does not exist.  <br>**Headers**:  <br>`x-amzn-RateLimit-Limit` (string):Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string):Unique request reference identifier.|[ErrorList](#errorlist)|
|**413**|The request size exceeded the maximum accepted size.  <br>**Headers**:  <br>`x-amzn-RateLimit-Limit` (string):Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string):Unique request reference identifier.|[ErrorList](#errorlist)|
|**415**|The request payload is in an unsupported format.  <br>**Headers**:  <br>`x-amzn-RateLimit-Limit` (string):Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string):Unique request reference identifier.|[ErrorList](#errorlist)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers**:  <br>`x-amzn-RateLimit-Limit` (string):Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string):Unique request reference identifier.|[ErrorList](#errorlist)|
|**500**|An unexpected condition occurred that prevented the server from fulfilling the request.  <br>**Headers**:  <br>`x-amzn-RateLimit-Limit` (string):Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string):Unique request reference identifier.|[ErrorList](#errorlist)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers**:  <br>`x-amzn-RateLimit-Limit` (string):Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string):Unique request reference identifier.|[ErrorList](#errorlist)|


<a name="definitions"></a>
## Definitions

<a name="error"></a>
### Error
Error response returned when the request is unsuccessful.


|Name|Description|Schema|
|---|---|---|
|**code**  <br>*required*|An error code that identifies the type of error that occurred.|string|
|**message**  <br>*required*|A message that describes the error condition.|string|
|**details**  <br>*optional*|Additional details that can help the caller understand or fix the issue.|string|


<a name="errorlist"></a>
### ErrorList
A list of error responses returned when a request is unsuccessful.


|Name|Schema|
|---|---|
|**errors**  <br>*required*|< [Error](#error) > array|


<a name="item"></a>
### Item
An item in the Amazon catalog.


|Name|Description|Schema|
|---|---|---|
|**asin**  <br>*required*|Amazon Standard Identification Number (ASIN) is the unique identifier for an item in the Amazon catalog.|[ItemAsin](#itemasin)|
|**attributes**  <br>*optional*|A JSON object that contains structured item attribute data keyed by attribute name. Catalog item attributes are available only to brand owners and conform to the related product type definitions available in the Selling Partner API for Product Type Definitions.|[ItemAttributes](#itemattributes)|
|**identifiers**  <br>*optional*|Identifiers associated with the item in the Amazon catalog, such as UPC and EAN identifiers.|[ItemIdentifiers](#itemidentifiers)|
|**images**  <br>*optional*|Images for an item in the Amazon catalog. All image variants are provided to brand owners. Otherwise, a thumbnail of the "MAIN" image variant is provided.|[ItemImages](#itemimages)|
|**productTypes**  <br>*optional*|Product types associated with the Amazon catalog item.|[ItemProductTypes](#itemproducttypes)|
|**salesRanks**  <br>*optional*|Sales ranks of an Amazon catalog item.|[ItemSalesRanks](#itemsalesranks)|
|**summaries**  <br>*optional*|Summary details of an Amazon catalog item.|[ItemSummaries](#itemsummaries)|
|**variations**  <br>*optional*|Variation details by marketplace for an Amazon catalog item (variation relationships).|[ItemVariations](#itemvariations)|
|**vendorDetails**  <br>*optional*|Vendor details associated with an Amazon catalog item. Vendor details are available to vendors only.|[ItemVendorDetails](#itemvendordetails)|


<a name="itemasin"></a>
### ItemAsin
Amazon Standard Identification Number (ASIN) is the unique identifier for an item in the Amazon catalog.

*Type* : string


<a name="itemattributes"></a>
### ItemAttributes
A JSON object that contains structured item attribute data keyed by attribute name. Catalog item attributes are available only to brand owners and conform to the related product type definitions available in the Selling Partner API for Product Type Definitions.

*Type* : object


<a name="itemidentifiers"></a>
### ItemIdentifiers
Identifiers associated with the item in the Amazon catalog, such as UPC and EAN identifiers.

*Type* : < [ItemIdentifiersByMarketplace](#itemidentifiersbymarketplace) > array


<a name="itemidentifiersbymarketplace"></a>
### ItemIdentifiersByMarketplace
Identifiers associated with the item in the Amazon catalog for the indicated Amazon marketplace.


|Name|Description|Schema|
|---|---|---|
|**marketplaceId**  <br>*required*|Amazon marketplace identifier.|string|
|**identifiers**  <br>*required*|Identifiers associated with the item in the Amazon catalog for the indicated Amazon marketplace.|< [ItemIdentifier](#itemidentifier) > array|


<a name="itemidentifier"></a>
### ItemIdentifier
Identifier associated with the item in the Amazon catalog, such as a UPC or EAN identifier.


|Name|Description|Schema|
|---|---|---|
|**identifierType**  <br>*required*|Type of identifier, such as UPC, EAN, or ISBN.|string|
|**identifier**  <br>*required*|Identifier.|string|


<a name="itemimages"></a>
### ItemImages
Images for an item in the Amazon catalog. All image variants are provided to brand owners. Otherwise, a thumbnail of the "MAIN" image variant is provided.

*Type* : < [ItemImagesByMarketplace](#itemimagesbymarketplace) > array


<a name="itemimagesbymarketplace"></a>
### ItemImagesByMarketplace
Images for an item in the Amazon catalog for the indicated Amazon marketplace.


|Name|Description|Schema|
|---|---|---|
|**marketplaceId**  <br>*required*|Amazon marketplace identifier.|string|
|**images**  <br>*required*|Images for an item in the Amazon catalog for the indicated Amazon marketplace.|< [ItemImage](#itemimage) > array|


<a name="itemimage"></a>
### ItemImage
Image for an item in the Amazon catalog.


|Name|Description|Schema|
|---|---|---|
|**variant**  <br>*required*|Variant of the image, such as MAIN or PT01.  <br>**Example** : `"MAIN"`|enum ([Variant](#variant))|
|**link**  <br>*required*|Link, or URL, for the image.|string|
|**height**  <br>*required*|Height of the image in pixels.|integer|
|**width**  <br>*required*|Width of the image in pixels.|integer|


<a name="itemproducttypes"></a>
### ItemProductTypes
Product types associated with the Amazon catalog item.

*Type* : < [ItemProductTypeByMarketplace](#itemproducttypebymarketplace) > array


<a name="itemproducttypebymarketplace"></a>
### ItemProductTypeByMarketplace
Product type associated with the Amazon catalog item for the indicated Amazon marketplace.


|Name|Description|Schema|
|---|---|---|
|**marketplaceId**  <br>*optional*|Amazon marketplace identifier.|string|
|**productType**  <br>*optional*|Name of the product type associated with the Amazon catalog item.  <br>**Example** : `"LUGGAGE"`|string|


<a name="itemsalesranks"></a>
### ItemSalesRanks
Sales ranks of an Amazon catalog item.

*Type* : < [ItemSalesRanksByMarketplace](#itemsalesranksbymarketplace) > array


<a name="itemsalesranksbymarketplace"></a>
### ItemSalesRanksByMarketplace
Sales ranks of an Amazon catalog item for the indicated Amazon marketplace.


|Name|Description|Schema|
|---|---|---|
|**marketplaceId**  <br>*required*|Amazon marketplace identifier.|string|
|**ranks**  <br>*required*|Sales ranks of an Amazon catalog item for an Amazon marketplace.|< [ItemSalesRank](#itemsalesrank) > array|


<a name="itemsalesrank"></a>
### ItemSalesRank
Sales rank of an Amazon catalog item.


|Name|Description|Schema|
|---|---|---|
|**title**  <br>*required*|Title, or name, of the sales rank.|string|
|**link**  <br>*optional*|Corresponding Amazon retail website link, or URL, for the sales rank.|string|
|**rank**  <br>*required*|Sales rank value.|integer|


<a name="itemsummaries"></a>
### ItemSummaries
Summary details of an Amazon catalog item.

*Type* : < [ItemSummaryByMarketplace](#itemsummarybymarketplace) > array


<a name="itemsummarybymarketplace"></a>
### ItemSummaryByMarketplace
Summary details of an Amazon catalog item for the indicated Amazon marketplace.


|Name|Description|Schema|
|---|---|---|
|**marketplaceId**  <br>*required*|Amazon marketplace identifier.|string|
|**brandName**  <br>*optional*|Name of the brand associated with an Amazon catalog item.|string|
|**browseNode**  <br>*optional*|Identifier of the browse node associated with an Amazon catalog item.|string|
|**colorName**  <br>*optional*|Name of the color associated with an Amazon catalog item.|string|
|**itemName**  <br>*optional*|Name, or title, associated with an Amazon catalog item.|string|
|**manufacturer**  <br>*optional*|Name of the manufacturer associated with an Amazon catalog item.|string|
|**modelNumber**  <br>*optional*|Model number associated with an Amazon catalog item.|string|
|**sizeName**  <br>*optional*|Name of the size associated with an Amazon catalog item.|string|
|**styleName**  <br>*optional*|Name of the style associated with an Amazon catalog item.|string|


<a name="itemvariations"></a>
### ItemVariations
Variation details by marketplace for an Amazon catalog item (variation relationships).

*Type* : < [ItemVariationsByMarketplace](#itemvariationsbymarketplace) > array


<a name="itemvariationsbymarketplace"></a>
### ItemVariationsByMarketplace
Variation details for the Amazon catalog item for the indicated Amazon marketplace.


|Name|Description|Schema|
|---|---|---|
|**marketplaceId**  <br>*required*|Amazon marketplace identifier.|string|
|**asins**  <br>*required*|Identifiers (ASINs) of the related items.|< string > array|
|**variationType**  <br>*required*|Type of variation relationship of the Amazon catalog item in the request to the related item(s): "PARENT" or "CHILD".  <br>**Example** : `"PARENT"`|enum ([VariationType](#variationtype))|


<a name="itemvendordetails"></a>
### ItemVendorDetails
Vendor details associated with an Amazon catalog item. Vendor details are available to vendors only.

*Type* : < [ItemVendorDetailsByMarketplace](#itemvendordetailsbymarketplace) > array


<a name="itemvendordetailsbymarketplace"></a>
### ItemVendorDetailsByMarketplace
Vendor details associated with an Amazon catalog item for the indicated Amazon marketplace.


|Name|Description|Schema|
|---|---|---|
|**marketplaceId**  <br>*required*|Amazon marketplace identifier.|string|
|**brandCode**  <br>*optional*|Brand code associated with an Amazon catalog item.|string|
|**categoryCode**  <br>*optional*|Product category associated with an Amazon catalog item.|string|
|**manufacturerCode**  <br>*optional*|Manufacturer code associated with an Amazon catalog item.|string|
|**manufacturerCodeParent**  <br>*optional*|Parent vendor code of the manufacturer code.|string|
|**productGroup**  <br>*optional*|Product group associated with an Amazon catalog item.|string|
|**replenishmentCategory**  <br>*optional*|Replenishment category associated with an Amazon catalog item.|enum ([ReplenishmentCategory](#replenishmentcategory))|
|**subcategoryCode**  <br>*optional*|Product subcategory associated with an Amazon catalog item.|string|


<a name="itemsearchresults"></a>
### ItemSearchResults
Items in the Amazon catalog and search related metadata.


|Name|Description|Schema|
|---|---|---|
|**numberOfResults**  <br>*required*|The estimated total number of products matched by the search query (only results up to the page count limit will be returned per request regardless of the number found).<br><br>Note: The maximum number of items (ASINs) that can be returned and paged through is 1000.|integer|
|**pagination**  <br>*required*|If available, the nextToken and/or previousToken values required to return paginated results.|[Pagination](#pagination)|
|**refinements**  <br>*required*|Search refinements.|[Refinements](#refinements)|
|**items**  <br>*required*|A list of items from the Amazon catalog.|< [Item](#item) > array|


<a name="pagination"></a>
### Pagination
When a request produces a response that exceeds the pageSize, pagination occurs. This means the response is divided into individual pages. To retrieve the next page or the previous page, you must pass the nextToken value or the previousToken value as the pageToken parameter in the next request. When you receive the last page, there will be no nextToken key in the pagination object.


|Name|Description|Schema|
|---|---|---|
|**nextToken**  <br>*optional*|A token that can be used to fetch the next page.|string|
|**previousToken**  <br>*optional*|A token that can be used to fetch the previous page.|string|


<a name="refinements"></a>
### Refinements
Search refinements.


|Name|Description|Schema|
|---|---|---|
|**brands**  <br>*required*|Brand search refinements.|< [BrandRefinement](#brandrefinement) > array|
|**classifications**  <br>*required*|Classification search refinements.|< [ClassificationRefinement](#classificationrefinement) > array|


<a name="brandrefinement"></a>
### BrandRefinement
Description of a brand that can be used to get more fine-grained search results.


|Name|Description|Schema|
|---|---|---|
|**numberOfResults**  <br>*required*|The estimated number of results that would still be returned if refinement key applied.|integer|
|**brandName**  <br>*required*|Brand name. For display and can be used as a search refinement.|string|


<a name="classificationrefinement"></a>
### ClassificationRefinement
Description of a classification that can be used to get more fine-grained search results.


|Name|Description|Schema|
|---|---|---|
|**numberOfResults**  <br>*required*|The estimated number of results that would still be returned if refinement key applied.|integer|
|**displayName**  <br>*required*|Display name for the classification.|string|
|**classificationId**  <br>*required*|Identifier for the classification that can be used for search refinement purposes.|string|


<a name="variant"></a>
### Variant
Variant of the image, such as MAIN or PT01.

*Type* : enum


|Value|Description|
|---|---|
|**MAIN**|Main image for the item.|
|**PT01**|Other image #1 for the item.|
|**PT02**|Other image #2 for the item.|
|**PT03**|Other image #3 for the item.|
|**PT04**|Other image #4 for the item.|
|**PT05**|Other image #5 for the item.|
|**PT06**|Other image #6 for the item.|
|**PT07**|Other image #7 for the item.|
|**PT08**|Other image #8 for the item.|
|**SWCH**|Swatch image for the item.|


<a name="variationtype"></a>
### VariationType
Type of variation relationship of the Amazon catalog item in the request to the related item(s): "PARENT" or "CHILD".

*Type* : enum


|Value|Description|
|---|---|
|**PARENT**|The Amazon catalog item in the request is a variation parent of the related item(s) indicated by ASIN.|
|**CHILD**|The Amazon catalog item in the request is a variation child of the related item identified by ASIN.|


<a name="replenishmentcategory"></a>
### ReplenishmentCategory
Replenishment category associated with an Amazon catalog item.

*Type* : enum


|Value|Description|
|---|---|
|**ALLOCATED**|Indicates non-automated purchasing of inventory that has been allocated to Amazon by the vendor.|
|**BASIC_REPLENISHMENT**|Indicates non-automated purchasing of inventory.|
|**IN_SEASON**|Indicates non-automated purchasing of inventory for seasonal items.|
|**LIMITED_REPLENISHMENT**|Holding queue replenishment status before an item is NEW_PRODUCT.|
|**MANUFACTURER_OUT_OF_STOCK**|Indicates vendor is out of stock for a longer period of time and cannot backorder.|
|**NEW_PRODUCT**|Indicates a new item that Amazon does not yet stock in inventory.|
|**NON_REPLENISHABLE**|Indicates assortment parent used for detail page display, not actual items.|
|**NON_STOCKUPABLE**|Indicates drop ship inventory that Amazon does not stock in its fulfillment centers.|
|**OBSOLETE**|Indicates item is obsolete and should not be ordered.|
|**PLANNED_REPLENISHMENT**|Indicates active items that should be automatically ordered.|


<a name="includeddata"></a>
### IncludedData
*Type* : enum

<a id="includeddata-subgroup-1"></a>**For use with the operation(s): [searchCatalogItems](#searchcatalogitems)**

|Value|Description|
|---|---|
|**identifiers**|Identifiers associated with the item in the Amazon catalog, such as UPC and EAN identifiers.|
|**images**|Images for an item in the Amazon catalog. All image variants are provided to brand owners; a thumbnail of the "MAIN" image variant is provided otherwise.|
|**productTypes**|Product types associated with the Amazon catalog item.|
|**salesRanks**|Sales ranks of an Amazon catalog item.|
|**summaries**|Summary details of an Amazon catalog item.|
|**variations**|Variation details of an Amazon catalog item (variation relationships).|
|**vendorDetails**|Vendor details associated with an Amazon catalog item. Vendor details are available to vendors only.|

<a id="includeddata-subgroup-2"></a>**For use with the operation(s): [getCatalogItem](#getcatalogitem)**

|Value|Description|
|---|---|
|**attributes**|A JSON object containing structured item attribute data keyed by attribute name. Catalog item attributes are available only to brand owners and conform to the related Amazon product type definitions available in the Selling Partner API for Product Type Definitions.|
|**identifiers**|Identifiers associated with the item in the Amazon catalog, such as UPC and EAN identifiers.|
|**images**|Images for an item in the Amazon catalog. All image variants are provided to brand owners. Otherwise, a thumbnail of the "MAIN" image variant is provided.|
|**productTypes**|Product types associated with the Amazon catalog item.|
|**salesRanks**|Sales ranks of an Amazon catalog item.|
|**summaries**|Summary details of an Amazon catalog item.|
|**variations**|Variation details of an Amazon catalog item (variation relationships).|
|**vendorDetails**|Vendor details associated with an Amazon catalog item. Vendor details are available to vendors only.|

