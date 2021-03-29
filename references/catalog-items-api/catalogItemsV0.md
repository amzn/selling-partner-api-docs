# Selling Partner API for Catalog Items


<a name="overview"></a>
## Overview
The Selling Partner API for Catalog Items helps you programmatically retrieve item details for items in the catalog.


### Version information
*Version* : v0


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
[listCatalogItems](#listcatalogitems)<br>[getCatalogItem](#getcatalogitem)<br>[listCatalogCategories](#listcatalogcategories)<br>
<a name="paths"></a>
## Paths

<a name="listcatalogitems"></a>
### GET /catalog/v0/items
**Operation: listCatalogItems**

#### Description
Returns a list of items and their attributes, based on a search query or item identifiers that you specify. When based on a search query, provide the Query parameter and optionally, the QueryContextId parameter. When based on item identifiers, provide a single appropriate parameter based on the identifier type, and specify the associated item value. MarketplaceId is always required.

**Usage Plans:**

| Plan type | Rate (requests per second) | Burst |
| ---- | ---- | ---- |
|Default| 6 | 40 |
|Selling partner specific| Variable | Variable |

The x-amzn-RateLimit-Limit response header returns the usage plan rate limits that were applied to the requested operation. Rate limits for some selling partners will vary from the default rate and burst shown in the table above. For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Query**|**MarketplaceId**  <br>*required*|A marketplace identifier. Specifies the marketplace for which items are returned.|string|
|**Query**|**Query**  <br>*optional*|Keyword(s) to use to search for items in the catalog. Example: 'harry potter books'.|string|
|**Query**|**QueryContextId**  <br>*optional*|An identifier for the context within which the given search will be performed. A marketplace might provide mechanisms for constraining a search to a subset of potential items. For example, the retail marketplace allows queries to be constrained to a specific category. The QueryContextId parameter specifies such a subset. If it is omitted, the search will be performed using the default context for the marketplace, which will typically contain the largest set of items.|string|
|**Query**|**SellerSKU**  <br>*optional*|Used to identify an item in the given marketplace. SellerSKU is qualified by the seller's SellerId, which is included with every operation that you submit.|string|
|**Query**|**UPC**  <br>*optional*|A 12-digit bar code used for retail packaging.|string|
|**Query**|**EAN**  <br>*optional*|A European article number that uniquely identifies the catalog item, manufacturer, and its attributes.|string|
|**Query**|**ISBN**  <br>*optional*|The unique commercial book identifier used to identify books internationally.|string|
|**Query**|**JAN**  <br>*optional*|A Japanese article number that uniquely identifies the product, manufacturer, and its attributes.|string|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Success.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference ID.|[ListCatalogItemsResponse](#listcatalogitemsresponse)|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference ID.|[ListCatalogItemsResponse](#listcatalogitemsresponse)|
|**401**|The request's Authorization header is not formatted correctly or does not contain a valid token.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference ID.|[ListCatalogItemsResponse](#listcatalogitemsresponse)|
|**403**|Indicates access to the resource is forbidden. Possible reasons include Access Denied, Unauthorized, Expired Token, or Invalid Signature.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference ID.|[ListCatalogItemsResponse](#listcatalogitemsresponse)|
|**404**|The specified resource does not exist.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference ID.|[ListCatalogItemsResponse](#listcatalogitemsresponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference ID.|[ListCatalogItemsResponse](#listcatalogitemsresponse)|
|**500**|An unexpected condition occurred that prevented the server from fulfilling the request.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference ID.|[ListCatalogItemsResponse](#listcatalogitemsresponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference ID.|[ListCatalogItemsResponse](#listcatalogitemsresponse)|


<a name="getcatalogitem"></a>
### GET /catalog/v0/items/{asin}
**Operation: getCatalogItem**

#### Description
Returns a specified item and its attributes.

**Usage Plans:**

| Plan type | Rate (requests per second) | Burst |
| ---- | ---- | ---- |
|Default| 2 | 20 |
|Selling partner specific| Variable | Variable |

The x-amzn-RateLimit-Limit response header returns the usage plan rate limits that were applied to the requested operation. Rate limits for some selling partners will vary from the default rate and burst shown in the table above. For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Query**|**MarketplaceId**  <br>*required*|A marketplace identifier. Specifies the marketplace for the item.|string|
|**Path**|**asin**  <br>*required*|The Amazon Standard Identification Number (ASIN) of the item.|string|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Success.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference ID.|[GetCatalogItemResponse](#getcatalogitemresponse)|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference ID.|[GetCatalogItemResponse](#getcatalogitemresponse)|
|**401**|The request's Authorization header is not formatted correctly or does not contain a valid token.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference ID.|[GetCatalogItemResponse](#getcatalogitemresponse)|
|**403**|Indicates access to the resource is forbidden. Possible reasons include Access Denied, Unauthorized, Expired Token, or Invalid Signature.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference ID.|[GetCatalogItemResponse](#getcatalogitemresponse)|
|**404**|The specified resource does not exist.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference ID.|[GetCatalogItemResponse](#getcatalogitemresponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference ID.|[GetCatalogItemResponse](#getcatalogitemresponse)|
|**500**|An unexpected condition occurred that prevented the server from fulfilling the request.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference ID.|[GetCatalogItemResponse](#getcatalogitemresponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference ID.|[GetCatalogItemResponse](#getcatalogitemresponse)|


<a name="listcatalogcategories"></a>
### GET /catalog/v0/categories
**Operation: listCatalogCategories**

#### Description
Returns the parent categories to which an item belongs, based on the specified ASIN or SellerSKU.

**Usage Plans:**

| Plan type | Rate (requests per second) | Burst |
| ---- | ---- | ---- |
|Default| 1 | 40 |
|Selling partner specific| Variable | Variable |

The x-amzn-RateLimit-Limit response header returns the usage plan rate limits that were applied to the requested operation. Rate limits for some selling partners will vary from the default rate and burst shown in the table above. For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Query**|**MarketplaceId**  <br>*required*|A marketplace identifier. Specifies the marketplace for the item.|string|
|**Query**|**ASIN**  <br>*optional*|The Amazon Standard Identification Number (ASIN) of the item.|string|
|**Query**|**SellerSKU**  <br>*optional*|Used to identify items in the given marketplace. SellerSKU is qualified by the seller's SellerId, which is included with every operation that you submit.|string|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Success.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference ID.|[ListCatalogCategoriesResponse](#listcatalogcategoriesresponse)|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference ID.|[ListCatalogCategoriesResponse](#listcatalogcategoriesresponse)|
|**401**|The request's Authorization header is not formatted correctly or does not contain a valid token.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference ID.|[ListCatalogCategoriesResponse](#listcatalogcategoriesresponse)|
|**403**|Indicates access to the resource is forbidden. Possible reasons include Access Denied, Unauthorized, Expired Token, or Invalid Signature.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference ID.|[ListCatalogCategoriesResponse](#listcatalogcategoriesresponse)|
|**404**|The specified resource does not exist.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference ID.|[ListCatalogCategoriesResponse](#listcatalogcategoriesresponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference ID.|[ListCatalogCategoriesResponse](#listcatalogcategoriesresponse)|
|**500**|An unexpected condition occurred that prevented the server from fulfilling the request.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference ID.|[ListCatalogCategoriesResponse](#listcatalogcategoriesresponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference ID.|[ListCatalogCategoriesResponse](#listcatalogcategoriesresponse)|


<a name="definitions"></a>
## Definitions

<a name="listcatalogitemsresponse"></a>
### ListCatalogItemsResponse

|Name|Description|Schema|
|---|---|---|
|**payload**  <br>*optional*|The payload for the listCatalogItems operation.|[ListMatchingItemsResponse](#listmatchingitemsresponse)|
|**errors**  <br>*optional*|One or more unexpected errors occurred during the listCatalogItems operation.|[ErrorList](#errorlist)|


<a name="listmatchingitemsresponse"></a>
### ListMatchingItemsResponse

|Name|Description|Schema|
|---|---|---|
|**Items**  <br>*optional*|A list of items.|[ItemList](#itemlist)|


<a name="itemlist"></a>
### ItemList
A list of items.

*Type* : < [Item](#item) > array


<a name="getcatalogitemresponse"></a>
### GetCatalogItemResponse

|Name|Description|Schema|
|---|---|---|
|**payload**  <br>*optional*|The payload for the getCatalogItem operation.|[Item](#item)|
|**errors**  <br>*optional*|One or more unexpected errors occurred during the getCatalogItem operation.|[ErrorList](#errorlist)|


<a name="item"></a>
### Item
An item in the Amazon catalog.


|Name|Description|Schema|
|---|---|---|
|**Identifiers**  <br>*required*|The identifiers that uniquely identify the item.|[IdentifierType](#identifiertype)|
|**AttributeSets**  <br>*optional*|A list of attributes of the item.|[AttributeSetList](#attributesetlist)|
|**Relationships**  <br>*optional*|A list of variation relationship information for the item.|[RelationshipList](#relationshiplist)|
|**SalesRankings**  <br>*optional*|A list of sales rank information for the item by category.|[SalesRankList](#salesranklist)|


<a name="identifiertype"></a>
### IdentifierType

|Name|Description|Schema|
|---|---|---|
|**MarketplaceASIN**  <br>*optional*|Indicates the item is identified by MarketPlaceId and ASIN.|[ASINIdentifier](#asinidentifier)|
|**SKUIdentifier**  <br>*optional*|Indicates the item is identified by MarketPlaceId, SellerId, and SellerSKU.|[SellerSKUIdentifier](#sellerskuidentifier)|


<a name="asinidentifier"></a>
### ASINIdentifier

|Name|Description|Schema|
|---|---|---|
|**MarketplaceId**  <br>*required*|A marketplace identifier.|string|
|**ASIN**  <br>*required*|The Amazon Standard Identification Number (ASIN) of the item.|string|


<a name="sellerskuidentifier"></a>
### SellerSKUIdentifier

|Name|Description|Schema|
|---|---|---|
|**MarketplaceId**  <br>*required*|A marketplace identifier.|string|
|**SellerId**  <br>*required*|The seller identifier submitted for the operation.|string|
|**SellerSKU**  <br>*required*|The seller stock keeping unit (SKU) of the item.|string|


<a name="attributesetlist"></a>
### AttributeSetList
A list of attributes for the item.

*Type* : < [AttributeSetListType](#attributesetlisttype) > array


<a name="attributesetlisttype"></a>
### AttributeSetListType
The attributes of the item.


|Name|Description|Schema|
|---|---|---|
|**Actor**  <br>*optional*|The actor attributes of the item.|< string > array|
|**Artist**  <br>*optional*|The artist attributes of the item.|< string > array|
|**AspectRatio**  <br>*optional*|The aspect ratio attribute of the item.|string|
|**AudienceRating**  <br>*optional*|The audience rating attribute of the item.|string|
|**Author**  <br>*optional*|The author attributes of the item.|< string > array|
|**BackFinding**  <br>*optional*|The back finding attribute of the item.|string|
|**BandMaterialType**  <br>*optional*|The band material type attribute of the item.|string|
|**Binding**  <br>*optional*|The binding attribute of the item.|string|
|**BlurayRegion**  <br>*optional*|The Bluray region attribute of the item.|string|
|**Brand**  <br>*optional*|The brand attribute of the item.|string|
|**CeroAgeRating**  <br>*optional*|The CERO age rating attribute of the item.|string|
|**ChainType**  <br>*optional*|The chain type attribute of the item.|string|
|**ClaspType**  <br>*optional*|The clasp type attribute of the item.|string|
|**Color**  <br>*optional*|The color attribute of the item.|string|
|**CpuManufacturer**  <br>*optional*|The CPU manufacturer attribute of the item.|string|
|**CpuSpeed**  <br>*optional*|The CPU speed attribute of the item.|[DecimalWithUnits](#decimalwithunits)|
|**CpuType**  <br>*optional*|The CPU type attribute of the item.|string|
|**Creator**  <br>*optional*|The creator attributes of the item.|< [CreatorType](#creatortype) > array|
|**Department**  <br>*optional*|The department attribute of the item.|string|
|**Director**  <br>*optional*|The director attributes of the item.|< string > array|
|**DisplaySize**  <br>*optional*|The display size attribute of the item.|[DecimalWithUnits](#decimalwithunits)|
|**Edition**  <br>*optional*|The edition attribute of the item.|string|
|**EpisodeSequence**  <br>*optional*|The episode sequence attribute of the item.|string|
|**EsrbAgeRating**  <br>*optional*|The ESRB age rating attribute of the item.|string|
|**Feature**  <br>*optional*|The feature attributes of the item|< string > array|
|**Flavor**  <br>*optional*|The flavor attribute of the item.|string|
|**Format**  <br>*optional*|The format attributes of the item.|< string > array|
|**GemType**  <br>*optional*|The gem type attributes of the item.|< string > array|
|**Genre**  <br>*optional*|The genre attribute of the item.|string|
|**GolfClubFlex**  <br>*optional*|The golf club flex attribute of the item.|string|
|**GolfClubLoft**  <br>*optional*|The golf club loft attribute of the item.|[DecimalWithUnits](#decimalwithunits)|
|**HandOrientation**  <br>*optional*|The hand orientation attribute of the item.|string|
|**HardDiskInterface**  <br>*optional*|The hard disk interface attribute of the item.|string|
|**HardDiskSize**  <br>*optional*|The hard disk size attribute of the item.|[DecimalWithUnits](#decimalwithunits)|
|**HardwarePlatform**  <br>*optional*|The hardware platform attribute of the item.|string|
|**HazardousMaterialType**  <br>*optional*|The hazardous material type attribute of the item.|string|
|**ItemDimensions**  <br>*optional*|The item dimensions attribute of the item.|[DimensionType](#dimensiontype)|
|**IsAdultProduct**  <br>*optional*|The adult product attribute of the item.|boolean|
|**IsAutographed**  <br>*optional*|The autographed attribute of the item.|boolean|
|**IsEligibleForTradeIn**  <br>*optional*|The is eligible for trade in attribute of the item.|boolean|
|**IsMemorabilia**  <br>*optional*|The is memorabilia attribute of the item.|boolean|
|**IssuesPerYear**  <br>*optional*|The issues per year attribute of the item.|string|
|**ItemPartNumber**  <br>*optional*|The item part number attribute of the item.|string|
|**Label**  <br>*optional*|The label attribute of the item.|string|
|**Languages**  <br>*optional*|The languages attribute of the item.|< [LanguageType](#languagetype) > array|
|**LegalDisclaimer**  <br>*optional*|The legal disclaimer attribute of the item.|string|
|**ListPrice**  <br>*optional*|The list price attribute of the item.|[Price](#price)|
|**Manufacturer**  <br>*optional*|The manufacturer attribute of the item.|string|
|**ManufacturerMaximumAge**  <br>*optional*|The manufacturer maximum age attribute of the item.|[DecimalWithUnits](#decimalwithunits)|
|**ManufacturerMinimumAge**  <br>*optional*|The manufacturer minimum age attribute of the item.|[DecimalWithUnits](#decimalwithunits)|
|**ManufacturerPartsWarrantyDescription**  <br>*optional*|The manufacturer parts warranty description attribute of the item.|string|
|**MaterialType**  <br>*optional*|The material type attributes of the item.|< string > array|
|**MaximumResolution**  <br>*optional*|The maximum resolution attribute of the item.|[DecimalWithUnits](#decimalwithunits)|
|**MediaType**  <br>*optional*|The media type attributes of the item.|< string > array|
|**MetalStamp**  <br>*optional*|The metal stamp attribute of the item.|string|
|**MetalType**  <br>*optional*|The metal type attribute of the item.|string|
|**Model**  <br>*optional*|The model attribute of the item.|string|
|**NumberOfDiscs**  <br>*optional*|The number of discs attribute of the item.|integer|
|**NumberOfIssues**  <br>*optional*|The number of issues attribute of the item.|integer|
|**NumberOfItems**  <br>*optional*|The number of items attribute of the item.|integer|
|**NumberOfPages**  <br>*optional*|The number of pages attribute of the item.|integer|
|**NumberOfTracks**  <br>*optional*|The number of tracks attribute of the item.|integer|
|**OperatingSystem**  <br>*optional*|The operating system attributes of the item.|< string > array|
|**OpticalZoom**  <br>*optional*|The optical zoom attribute of the item.|[DecimalWithUnits](#decimalwithunits)|
|**PackageDimensions**  <br>*optional*|The package dimensions attribute of the item.|[DimensionType](#dimensiontype)|
|**PackageQuantity**  <br>*optional*|The package quantity attribute of the item.|integer|
|**PartNumber**  <br>*optional*|The part number attribute of the item.|string|
|**PegiRating**  <br>*optional*|The PEGI rating attribute of the item.|string|
|**Platform**  <br>*optional*|The platform attributes of the item.|< string > array|
|**ProcessorCount**  <br>*optional*|The processor count attribute of the item.|integer|
|**ProductGroup**  <br>*optional*|The product group attribute of the item.|string|
|**ProductTypeName**  <br>*optional*|The product type name attribute of the item.|string|
|**ProductTypeSubcategory**  <br>*optional*|The product type subcategory attribute of the item.|string|
|**PublicationDate**  <br>*optional*|The publication date attribute of the item.|string|
|**Publisher**  <br>*optional*|The publisher attribute of the item.|string|
|**RegionCode**  <br>*optional*|The region code attribute of the item.|string|
|**ReleaseDate**  <br>*optional*|The release date attribute of the item.|string|
|**RingSize**  <br>*optional*|The ring size attribute of the item.|string|
|**RunningTime**  <br>*optional*|The running time attribute of the item.|[DecimalWithUnits](#decimalwithunits)|
|**ShaftMaterial**  <br>*optional*|The shaft material attribute of the item.|string|
|**Scent**  <br>*optional*|The scent attribute of the item.|string|
|**SeasonSequence**  <br>*optional*|The season sequence attribute of the item.|string|
|**SeikodoProductCode**  <br>*optional*|The Seikodo product code attribute of the item.|string|
|**Size**  <br>*optional*|The size attribute of the item.|string|
|**SizePerPearl**  <br>*optional*|The size per pearl attribute of the item.|string|
|**SmallImage**  <br>*optional*|The small image attribute of the item.|[Image](#image)|
|**Studio**  <br>*optional*|The studio attribute of the item.|string|
|**SubscriptionLength**  <br>*optional*|The subscription length attribute of the item.|[DecimalWithUnits](#decimalwithunits)|
|**SystemMemorySize**  <br>*optional*|The system memory size attribute of the item.|[DecimalWithUnits](#decimalwithunits)|
|**SystemMemoryType**  <br>*optional*|The system memory type attribute of the item.|string|
|**TheatricalReleaseDate**  <br>*optional*|The theatrical release date attribute of the item.|string|
|**Title**  <br>*optional*|The title attribute of the item.|string|
|**TotalDiamondWeight**  <br>*optional*|The total diamond weight attribute of the item.|[DecimalWithUnits](#decimalwithunits)|
|**TotalGemWeight**  <br>*optional*|The total gem weight attribute of the item.|[DecimalWithUnits](#decimalwithunits)|
|**Warranty**  <br>*optional*|The warranty attribute of the item.|string|
|**WeeeTaxValue**  <br>*optional*|The WEEE tax value attribute of the item.|[Price](#price)|


<a name="decimalwithunits"></a>
### DecimalWithUnits
The decimal value and unit.


|Name|Description|Schema|
|---|---|---|
|**value**  <br>*optional*|The decimal value.|number|
|**Units**  <br>*optional*|The unit of the decimal value.|string|


<a name="creatortype"></a>
### CreatorType
The creator type attribute of an item.


|Name|Description|Schema|
|---|---|---|
|**value**  <br>*optional*|The value of the attribute.|string|
|**Role**  <br>*optional*|The role of the value.|string|


<a name="dimensiontype"></a>
### DimensionType
The dimension type attribute of an item.


|Name|Description|Schema|
|---|---|---|
|**Height**  <br>*optional*|The height attribute of the dimension.|[DecimalWithUnits](#decimalwithunits)|
|**Length**  <br>*optional*|The length attribute of the dimension.|[DecimalWithUnits](#decimalwithunits)|
|**Width**  <br>*optional*|The width attribute of the dimension.|[DecimalWithUnits](#decimalwithunits)|
|**Weight**  <br>*optional*|The weight attribute of the dimension.|[DecimalWithUnits](#decimalwithunits)|


<a name="languagetype"></a>
### LanguageType
The language type attribute of an item.


|Name|Description|Schema|
|---|---|---|
|**Name**  <br>*optional*|The name attribute of the item.|string|
|**Type**  <br>*optional*|The type attribute of the item.|string|
|**AudioFormat**  <br>*optional*|The audio format attribute of the item.|string|


<a name="image"></a>
### Image
The image attribute of the item.


|Name|Description|Schema|
|---|---|---|
|**URL**  <br>*optional*|The image URL attribute of the item.|string|
|**Height**  <br>*optional*|The image height attribute of the item.|[DecimalWithUnits](#decimalwithunits)|
|**Width**  <br>*optional*|The image width attribute of the item.|[DecimalWithUnits](#decimalwithunits)|


<a name="price"></a>
### Price
The price attribute of the item.


|Name|Description|Schema|
|---|---|---|
|**Amount**  <br>*optional*|The amount.|number|
|**CurrencyCode**  <br>*optional*|The currency code of the amount.|string|


<a name="relationshiplist"></a>
### RelationshipList
A list of variation relationship information, if applicable for the item.

*Type* : < [RelationshipType](#relationshiptype) > array


<a name="relationshiptype"></a>
### RelationshipType
Specific variations of the item.


|Name|Description|Schema|
|---|---|---|
|**Identifiers**  <br>*optional*|The identifiers that uniquely identify the item that is related.|[IdentifierType](#identifiertype)|
|**Color**  <br>*optional*|The color variation of the item.|string|
|**Edition**  <br>*optional*|The edition variation of the item.|string|
|**Flavor**  <br>*optional*|The flavor variation of the item.|string|
|**GemType**  <br>*optional*|The gem type variations of the item.|< string > array|
|**GolfClubFlex**  <br>*optional*|The golf club flex variation of an item.|string|
|**HandOrientation**  <br>*optional*|The hand orientation variation of an item.|string|
|**HardwarePlatform**  <br>*optional*|The hardware platform variation of an item.|string|
|**MaterialType**  <br>*optional*|The material type variations of an item.|< string > array|
|**MetalType**  <br>*optional*|The metal type variation of an item.|string|
|**Model**  <br>*optional*|The model variation of an item.|string|
|**OperatingSystem**  <br>*optional*|The operating system variations of an item.|< string > array|
|**ProductTypeSubcategory**  <br>*optional*|The product type subcategory variation of an item.|string|
|**RingSize**  <br>*optional*|The ring size variation of an item.|string|
|**ShaftMaterial**  <br>*optional*|The shaft material variation of an item.|string|
|**Scent**  <br>*optional*|The scent variation of an item.|string|
|**Size**  <br>*optional*|The size variation of an item.|string|
|**SizePerPearl**  <br>*optional*|The size per pearl variation of an item.|string|
|**GolfClubLoft**  <br>*optional*|The golf club loft variation of an item.|[DecimalWithUnits](#decimalwithunits)|
|**TotalDiamondWeight**  <br>*optional*|The total diamond weight variation of an item.|[DecimalWithUnits](#decimalwithunits)|
|**TotalGemWeight**  <br>*optional*|The total gem weight variation of an item.|[DecimalWithUnits](#decimalwithunits)|
|**PackageQuantity**  <br>*optional*|The package quantity variation of an item.|integer|
|**ItemDimensions**  <br>*optional*|The item dimensions relationship of an item.|[DimensionType](#dimensiontype)|


<a name="salesranklist"></a>
### SalesRankList
A list of sales rank information for the item by category.

*Type* : < [SalesRankType](#salesranktype) > array


<a name="salesranktype"></a>
### SalesRankType

|Name|Description|Schema|
|---|---|---|
|**ProductCategoryId**  <br>*required*|Identifies the item category from which the sales rank is taken.|string|
|**Rank**  <br>*required*|The sales rank of the item within the item category.|integer (int32)|


<a name="numberofofferlistingslist"></a>
### NumberOfOfferListingsList
The number of active offer listings for the item that was submitted. The listing count is returned by condition, one for each listing condition value that is returned. Possible listing condition values are: Any, New, Used, Collectible, Refurbished, or Club.

*Type* : < [OfferListingCountType](#offerlistingcounttype) > array


<a name="offerlistingcounttype"></a>
### OfferListingCountType
The number of offer listings with the specified condition.


|Name|Description|Schema|
|---|---|---|
|**Count**  <br>*required*|The number of offer listings.|integer (int32)|
|**condition**  <br>*required*|The condition of the item.|string|


<a name="qualifierstype"></a>
### QualifiersType

|Name|Description|Schema|
|---|---|---|
|**ItemCondition**  <br>*required*|The condition of the item. Possible values: New, Used, Collectible, Refurbished, or Club.|string|
|**ItemSubcondition**  <br>*required*|The item subcondition for the offer listing. Possible values: New, Mint, Very Good, Good, Acceptable, Poor, Club, OEM, Warranty, Refurbished Warranty, Refurbished, Open Box, or Other.|string|
|**FulfillmentChannel**  <br>*required*|The fulfillment channel for the item. Possible values:<br><br><li> Amazon - Fulfilled by Amazon.</li><br><li> Merchant - Fulfilled by the seller.</li>|string|
|**ShipsDomestically**  <br>*required*|Indicates whether the marketplace specified in the request and the location that the item ships from are in the same country. Possible values: True, False, or Unknown.|string|
|**ShippingTime**  <br>*required*|(0-2 days, 3-7 days, 8-13 days, or 14 or more days) – Indicates the maximum time within which the item will likely be shipped once an order has been placed.|[ShippingTimeType](#shippingtimetype)|
|**SellerPositiveFeedbackRating**  <br>*required*|(98-100%, 95-97%, 90-94%, 80-89%, 70-79%, Less than 70%, or Just launched ) – Indicates the percentage of feedback ratings that were positive over the past 12 months.|string|


<a name="shippingtimetype"></a>
### ShippingTimeType

|Name|Description|Schema|
|---|---|---|
|**Max**  <br>*optional*|(0-2 days, 3-7 days, 8-13 days, or 14 or more days) – Indicates the maximum time within which the item will likely be shipped once an order has been placed.|string|


<a name="listcatalogcategoriesresponse"></a>
### ListCatalogCategoriesResponse

|Name|Description|Schema|
|---|---|---|
|**payload**  <br>*optional*|The payload for the listCatalogCategories operation.|[ListOfCategories](#listofcategories)|
|**errors**  <br>*optional*|One or more unexpected errors occurred during the listCatalogCategories operation.|[ErrorList](#errorlist)|


<a name="listofcategories"></a>
### ListOfCategories
*Type* : < [Categories](#categories) > array


<a name="categories"></a>
### Categories

|Name|Description|Schema|
|---|---|---|
|**ProductCategoryId**  <br>*optional*|The identifier for the product category (or browse node).|string|
|**ProductCategoryName**  <br>*optional*|The name of the product category (or browse node).|string|
|**parent**  <br>*optional*|The parent product category.|object|


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
|**details**  <br>*optional*|Additional information that can help the caller understand or fix the issue.|string|

