# Selling Partner API for Pricing


<a name="overview"></a>
## Overview
The Selling Partner API for Pricing helps you programmatically retrieve product pricing and offer information for Amazon Marketplace products.


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
[getPricing](#getpricing)<br>[getCompetitivePricing](#getcompetitivepricing)<br>[getListingOffers](#getlistingoffers)<br>[getItemOffers](#getitemoffers)<br>
<a name="paths"></a>
## Paths

<a name="getpricing"></a>
### GET /products/pricing/v0/price
**Operation: getPricing**

#### Description
Returns pricing information for a seller's offer listings based on seller SKU or ASIN.

**Usage Plans:**

| Plan type | Rate (requests per second) | Burst |
| ---- | ---- | ---- |
|Default| 10 | 20 |
|Selling partner specific| Variable | Variable |

The x-amzn-RateLimit-Limit response header returns the usage plan rate limits that were applied to the requested operation. Rate limits for some selling partners will vary from the default rate and burst shown in the table above. For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Query**|**MarketplaceId**  <br>*required*|A marketplace identifier. Specifies the marketplace for which prices are returned.|string|
|**Query**|**Asins**  <br>*optional*|A list of up to twenty Amazon Standard Identification Number (ASIN) values used to identify items in the given marketplace.<br>**Max count** : 20|< string > array|
|**Query**|**Skus**  <br>*optional*|A list of up to twenty seller SKU values used to identify items in the given marketplace.<br>**Max count** : 20|< string > array|
|**Query**|**ItemType**  <br>*required*|Indicates whether ASIN values or seller SKU values are used to identify items. If you specify Asin, the information in the response will be dependent on the list of Asins you provide in the Asins parameter. If you specify Sku, the information in the response will be dependent on the list of Skus you provide in the Skus parameter.|enum ([ItemType](#itemtype-subgroup-1))|
|**Query**|**ItemCondition**  <br>*optional*|Filters the offer listings based on item condition. Possible values: New, Used, Collectible, Refurbished, Club.|enum ([ItemCondition](#itemcondition-subgroup-1))|
|**Query**|**OfferType**  <br>*optional*|Indicates whether to request pricing information for the seller's B2C or B2B offers. Default is B2C.|enum ([OfferType](#offertype))|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Success.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference ID.|[GetPricingResponse](#getpricingresponse)|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference ID.|[GetPricingResponse](#getpricingresponse)|
|**401**|The request's Authorization header is not formatted correctly or does not contain a valid token.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference ID.|[GetPricingResponse](#getpricingresponse)|
|**403**|Indicates access to the resource is forbidden. Possible reasons include Access Denied, Unauthorized, Expired Token, or Invalid Signature.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference ID.|[GetPricingResponse](#getpricingresponse)|
|**404**|The specified resource does not exist.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference ID.|[GetPricingResponse](#getpricingresponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference ID.|[GetPricingResponse](#getpricingresponse)|
|**500**|An unexpected condition occurred that prevented the server from fulfilling the request.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference ID.|[GetPricingResponse](#getpricingresponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference ID.|[GetPricingResponse](#getpricingresponse)|


<a name="getcompetitivepricing"></a>
### GET /products/pricing/v0/competitivePrice
**Operation: getCompetitivePricing**

#### Description
Returns competitive pricing information for a seller's offer listings based on seller SKU or ASIN.

**Usage Plans:**

| Plan type | Rate (requests per second) | Burst |
| ---- | ---- | ---- |
|Default| 10 | 20 |
|Selling partner specific| Variable | Variable |

The x-amzn-RateLimit-Limit response header returns the usage plan rate limits that were applied to the requested operation. Rate limits for some selling partners will vary from the default rate and burst shown in the table above. For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Query**|**MarketplaceId**  <br>*required*|A marketplace identifier. Specifies the marketplace for which prices are returned.|string|
|**Query**|**Asins**  <br>*optional*|A list of up to twenty Amazon Standard Identification Number (ASIN) values used to identify items in the given marketplace.<br>**Max count** : 20|< string > array|
|**Query**|**Skus**  <br>*optional*|A list of up to twenty seller SKU values used to identify items in the given marketplace.<br>**Max count** : 20|< string > array|
|**Query**|**ItemType**  <br>*required*|Indicates whether ASIN values or seller SKU values are used to identify items. If you specify Asin, the information in the response will be dependent on the list of Asins you provide in the Asins parameter. If you specify Sku, the information in the response will be dependent on the list of Skus you provide in the Skus parameter. Possible values: Asin, Sku.|enum ([ItemType](#itemtype-subgroup-2))|
|**Query**|**CustomerType**  <br>*optional*|Indicates whether to request pricing information from the point of view of Consumer or Business buyers. Default is Consumer.|enum ([CustomerType](#customertype-subgroup-1))|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Success.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference ID.|[GetPricingResponse](#getpricingresponse)|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference ID.|[GetPricingResponse](#getpricingresponse)|
|**401**|The request's Authorization header is not formatted correctly or does not contain a valid token.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference ID.|[GetPricingResponse](#getpricingresponse)|
|**403**|Indicates access to the resource is forbidden. Possible reasons include Access Denied, Unauthorized, Expired Token, or Invalid Signature.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference ID.|[GetPricingResponse](#getpricingresponse)|
|**404**|The specified resource does not exist.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference ID.|[GetPricingResponse](#getpricingresponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference ID.|[GetPricingResponse](#getpricingresponse)|
|**500**|An unexpected condition occurred that prevented the server from fulfilling the request.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference ID.|[GetPricingResponse](#getpricingresponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference ID.|[GetPricingResponse](#getpricingresponse)|


<a name="getlistingoffers"></a>
### GET /products/pricing/v0/listings/{SellerSKU}/offers
**Operation: getListingOffers**

#### Description
Returns the lowest priced offers for a single SKU listing.

**Usage Plans:**

| Plan type | Rate (requests per second) | Burst |
| ---- | ---- | ---- |
|Default| 5 | 10 |
|Selling partner specific| Variable | Variable |

The x-amzn-RateLimit-Limit response header returns the usage plan rate limits that were applied to the requested operation. Rate limits for some selling partners will vary from the default rate and burst shown in the table above. For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Query**|**MarketplaceId**  <br>*required*|A marketplace identifier. Specifies the marketplace for which prices are returned.|string|
|**Query**|**ItemCondition**  <br>*required*|Filters the offer listings based on item condition. Possible values: New, Used, Collectible, Refurbished, Club.|enum ([ItemCondition](#itemcondition-subgroup-1))|
|**Path**|**SellerSKU**  <br>*required*|Identifies an item in the given marketplace. SellerSKU is qualified by the seller's SellerId, which is included with every operation that you submit.|string|
|**Query**|**CustomerType**  <br>*optional*|Indicates whether to request Consumer or Business offers. Default is Consumer.|enum ([CustomerType](#customertype-subgroup-2))|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Success.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference ID.|[GetOffersResponse](#getoffersresponse)|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference ID.|[GetOffersResponse](#getoffersresponse)|
|**401**|The request's Authorization header is not formatted correctly or does not contain a valid token.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference ID.|[GetOffersResponse](#getoffersresponse)|
|**403**|Indicates access to the resource is forbidden. Possible reasons include Access Denied, Unauthorized, Expired Token, or Invalid Signature.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference ID.|[GetOffersResponse](#getoffersresponse)|
|**404**|The specified resource does not exist.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference ID.|[GetOffersResponse](#getoffersresponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference ID.|[GetOffersResponse](#getoffersresponse)|
|**500**|An unexpected condition occurred that prevented the server from fulfilling the request.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference ID.|[GetOffersResponse](#getoffersresponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference ID.|[GetOffersResponse](#getoffersresponse)|


<a name="getitemoffers"></a>
### GET /products/pricing/v0/items/{Asin}/offers
**Operation: getItemOffers**

#### Description
Returns the lowest priced offers for a single item based on ASIN.

**Usage Plans:**

| Plan type | Rate (requests per second) | Burst |
| ---- | ---- | ---- |
|Default| 5 | 10 |
|Selling partner specific| Variable | Variable |

The x-amzn-RateLimit-Limit response header returns the usage plan rate limits that were applied to the requested operation. Rate limits for some selling partners will vary from the default rate and burst shown in the table above. For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Query**|**MarketplaceId**  <br>*required*|A marketplace identifier. Specifies the marketplace for which prices are returned.|string|
|**Query**|**ItemCondition**  <br>*required*|Filters the offer listings to be considered based on item condition. Possible values: New, Used, Collectible, Refurbished, Club.|enum ([ItemCondition](#itemcondition-subgroup-2))|
|**Path**|**Asin**  <br>*required*|The Amazon Standard Identification Number (ASIN) of the item.|string|
|**Query**|**CustomerType**  <br>*optional*|Indicates whether to request Consumer or Business offers. Default is Consumer.|enum ([CustomerType](#customertype-subgroup-2))|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Success.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference ID.|[GetOffersResponse](#getoffersresponse)|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference ID.|[GetOffersResponse](#getoffersresponse)|
|**401**|The request's Authorization header is not formatted correctly or does not contain a valid token.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference ID.|[GetOffersResponse](#getoffersresponse)|
|**403**|Indicates access to the resource is forbidden. Possible reasons include Access Denied, Unauthorized, Expired Token, or Invalid Signature.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference ID.|[GetOffersResponse](#getoffersresponse)|
|**404**|The specified resource does not exist.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference ID.|[GetOffersResponse](#getoffersresponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference ID.|[GetOffersResponse](#getoffersresponse)|
|**500**|An unexpected condition occurred that prevented the server from fulfilling the request.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference ID.|[GetOffersResponse](#getoffersresponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference ID.|[GetOffersResponse](#getoffersresponse)|


<a name="definitions"></a>
## Definitions

<a name="getpricingresponse"></a>
### GetPricingResponse
The response schema for the getPricing and getCompetitivePricing operations.


|Name|Description|Schema|
|---|---|---|
|**payload**  <br>*optional*|The payload for the getPricing and getCompetitivePricing operations.|[PriceList](#pricelist)|
|**errors**  <br>*optional*|One or more unexpected errors occurred during the operation.|[ErrorList](#errorlist)|


<a name="getoffersresponse"></a>
### GetOffersResponse
The response schema for the getListingOffers and getItemOffers operations.


|Name|Description|Schema|
|---|---|---|
|**payload**  <br>*optional*|The payload for the getListingOffers and getItemOffers operations.|[GetOffersResult](#getoffersresult)|
|**errors**  <br>*optional*|One or more unexpected errors occurred during the operation.|[ErrorList](#errorlist)|


<a name="pricelist"></a>
### PriceList
*Type* : < [Price](#price) > array

**Max items** : 20  

<a name="getoffersresult"></a>
### GetOffersResult

|Name|Description|Schema|
|---|---|---|
|**MarketplaceID**  <br>*required*|A marketplace identifier.|string|
|**ASIN**  <br>*optional*|The Amazon Standard Identification Number (ASIN) of the item.|string|
|**SKU**  <br>*optional*|The stock keeping unit (SKU) of the item.|string|
|**ItemCondition**  <br>*required*|The condition of the item.|[ConditionType](#conditiontype)|
|**status**  <br>*required*|The status of the operation.|string|
|**Identifier**  <br>*required*|Metadata that identifies the item.|[ItemIdentifier](#itemidentifier)|
|**Summary**  <br>*required*|Pricing information about the item.|[Summary](#summary)|
|**Offers**  <br>*required*|A list of offer details. The list is the same length as the TotalOfferCount in the Summary or 20, whichever is less.|[OfferDetailList](#offerdetaillist)|


<a name="price"></a>
### Price

|Name|Description|Schema|
|---|---|---|
|**status**  <br>*required*|The status of the operation.|string|
|**SellerSKU**  <br>*optional*|The seller stock keeping unit (SKU) of the item.|string|
|**ASIN**  <br>*optional*|The Amazon Standard Identification Number (ASIN) of the item.|string|
|**Product**  <br>*optional*|An item.|[Product](#product)|


<a name="product"></a>
### Product
An item.


|Name|Description|Schema|
|---|---|---|
|**Identifiers**  <br>*required*|Specifies the identifiers used to uniquely identify an item.|[IdentifierType](#identifiertype)|
|**AttributeSets**  <br>*optional*|A list of product attributes if they are applicable to the product that is returned.|[AttributeSetList](#attributesetlist)|
|**Relationships**  <br>*optional*|A list that contains product variation information, if applicable.|[RelationshipList](#relationshiplist)|
|**CompetitivePricing**  <br>*optional*|Competitive pricing information for the item.|[CompetitivePricingType](#competitivepricingtype)|
|**SalesRankings**  <br>*optional*|A list of sales rank information for the item, by category.|[SalesRankList](#salesranklist)|
|**Offers**  <br>*optional*|A list of offers.|[OffersList](#offerslist)|


<a name="identifiertype"></a>
### IdentifierType
Specifies the identifiers used to uniquely identify an item.


|Name|Description|Schema|
|---|---|---|
|**MarketplaceASIN**  <br>*required*|Indicates the item is identified by MarketPlaceId and ASIN.|[ASINIdentifier](#asinidentifier)|
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
A list of product attributes if they are applicable to the product that is returned.

*Type* : < object > array


<a name="relationshiplist"></a>
### RelationshipList
A list that contains product variation information, if applicable.

*Type* : < object > array


<a name="competitivepricingtype"></a>
### CompetitivePricingType
Competitive pricing information for the item.


|Name|Description|Schema|
|---|---|---|
|**CompetitivePrices**  <br>*required*|A list of competitive pricing information.|[CompetitivePriceList](#competitivepricelist)|
|**NumberOfOfferListings**  <br>*required*|The number of active offer listings for the item that was submitted. The listing count is returned by condition, one for each listing condition value that is returned.|[NumberOfOfferListingsList](#numberofofferlistingslist)|
|**TradeInValue**  <br>*optional*|The trade-in value of the item in the trade-in program.|[MoneyType](#moneytype)|


<a name="competitivepricelist"></a>
### CompetitivePriceList
A list of competitive pricing information.

*Type* : < [CompetitivePriceType](#competitivepricetype) > array


<a name="competitivepricetype"></a>
### CompetitivePriceType

|Name|Description|Schema|
|---|---|---|
|**CompetitivePriceId**  <br>*required*|The pricing model for each price that is returned.<br><br>Possible values:<br><br><li> 1 - New Buy Box Price.</li><br><li> 2 - Used Buy Box Price.</li>|string|
|**Price**  <br>*required*|Pricing information for a given CompetitivePriceId value.|[PriceType](#pricetype)|
|**condition**  <br>*optional*|Indicates the condition of the item whose pricing information is returned. Possible values are: New, Used, Collectible, Refurbished, or Club.|string|
|**subcondition**  <br>*optional*|Indicates the subcondition of the item whose pricing information is returned. Possible values are: New, Mint, Very Good, Good, Acceptable, Poor, Club, OEM, Warranty, Refurbished Warranty, Refurbished, Open Box, or Other.|string|
|**offerType**  <br>*optional*|Indicates the type of customer that the offer is valid for.<br><br>When the offer type is B2C in a quantity discount, the seller is winning the Buy Box because others do not have inventory at that quantity, not because they have a quantity discount on the ASIN.|[OfferCustomerType](#offercustomertype)|
|**quantityTier**  <br>*optional*|Indicates at what quantity this price becomes active.|integer (int32)|
|**quantityDiscountType**  <br>*optional*|Indicates the type of quantity discount this price applies to.|[QuantityDiscountType](#quantitydiscounttype)|
|**sellerId**  <br>*optional*|The seller identifier for the offer.|string|
|**belongsToRequester**  <br>*optional*|Indicates whether or not the pricing information is for an offer listing that belongs to the requester. The requester is the seller associated with the SellerId that was submitted with the request. Possible values are: true and false.|boolean|


<a name="numberofofferlistingslist"></a>
### NumberOfOfferListingsList
The number of active offer listings for the item that was submitted. The listing count is returned by condition, one for each listing condition value that is returned.

*Type* : < [OfferListingCountType](#offerlistingcounttype) > array


<a name="offerlistingcounttype"></a>
### OfferListingCountType
The number of offer listings with the specified condition.


|Name|Description|Schema|
|---|---|---|
|**Count**  <br>*required*|The number of offer listings.|integer (int32)|
|**condition**  <br>*required*|The condition of the item.|string|


<a name="moneytype"></a>
### MoneyType

|Name|Description|Schema|
|---|---|---|
|**CurrencyCode**  <br>*optional*|The currency code in ISO 4217 format.|string|
|**Amount**  <br>*optional*|The monetary value.|number|


<a name="salesranklist"></a>
### SalesRankList
A list of sales rank information for the item, by category.

*Type* : < [SalesRankType](#salesranktype) > array


<a name="salesranktype"></a>
### SalesRankType

|Name|Description|Schema|
|---|---|---|
|**ProductCategoryId**  <br>*required*|Identifies the item category from which the sales rank is taken.|string|
|**Rank**  <br>*required*|The sales rank of the item within the item category.|integer (int32)|


<a name="pricetype"></a>
### PriceType

|Name|Description|Schema|
|---|---|---|
|**LandedPrice**  <br>*optional*|The value calculated by adding ListingPrice + Shipping - Points. Note that if the landed price is not returned, the listing price represents the product with the lowest landed price.|[MoneyType](#moneytype)|
|**ListingPrice**  <br>*required*|The listing price of the item including any promotions that apply.|[MoneyType](#moneytype)|
|**Shipping**  <br>*optional*|The shipping cost of the product. Note that the shipping cost is not always available.|[MoneyType](#moneytype)|
|**Points**  <br>*optional*|The number of Amazon Points offered with the purchase of an item, and their monetary value.|[Points](#points)|


<a name="offerslist"></a>
### OffersList
A list of offers.

*Type* : < [OfferType](#offertype) > array


<a name="offertype"></a>
### OfferType
Indicates whether to request pricing information for the seller's B2C or B2B offers. Default is B2C.

*Type* : enum


|Value|Description|
|---|---|
|**B2C**|B2C|
|**B2B**|B2B|


<a name="offercustomertype"></a>
### OfferCustomerType
*Type* : enum


|Value|Description|
|---|---|
|**B2C**|B2C|
|**B2B**|B2B|


<a name="quantitydiscountpricetype"></a>
### QuantityDiscountPriceType
Contains pricing information that includes special pricing when buying in bulk.


|Name|Description|Schema|
|---|---|---|
|**quantityTier**  <br>*required*|Indicates at what quantity this price becomes active.|integer (int32)|
|**quantityDiscountType**  <br>*required*|Indicates the type of quantity discount this price applies to.|[QuantityDiscountType](#quantitydiscounttype)|
|**listingPrice**  <br>*required*|The price at this quantity tier.|[MoneyType](#moneytype)|


<a name="quantitydiscounttype"></a>
### QuantityDiscountType
*Type* : enum


|Value|Description|
|---|---|
|**QUANTITY_DISCOUNT**|Quantity Discount|


<a name="points"></a>
### Points

|Name|Description|Schema|
|---|---|---|
|**PointsNumber**  <br>*optional*|The number of points.|integer (int32)|
|**PointsMonetaryValue**  <br>*optional*|The monetary value of the points.|[MoneyType](#moneytype)|


<a name="conditiontype"></a>
### ConditionType
Indicates the condition of the item. Possible values: New, Used, Collectible, Refurbished, Club.

*Type* : enum


|Value|Description|
|---|---|
|**New**|New|
|**Used**|Used|
|**Collectible**|Collectible|
|**Refurbished**|Refurbished|
|**Club**|Club|


<a name="itemidentifier"></a>
### ItemIdentifier
Information that identifies an item.


|Name|Description|Schema|
|---|---|---|
|**MarketplaceId**  <br>*required*|A marketplace identifier. Specifies the marketplace from which prices are returned.|string|
|**ASIN**  <br>*optional*|The Amazon Standard Identification Number (ASIN) of the item.|string|
|**SellerSKU**  <br>*optional*|The seller stock keeping unit (SKU) of the item.|string|
|**ItemCondition**  <br>*required*|The condition of the item.|[ConditionType](#conditiontype)|


<a name="summary"></a>
### Summary
Contains price information about the product, including the LowestPrices and BuyBoxPrices, the ListPrice, the SuggestedLowerPricePlusShipping, and NumberOfOffers and NumberOfBuyBoxEligibleOffers.


|Name|Description|Schema|
|---|---|---|
|**TotalOfferCount**  <br>*required*|The number of unique offers contained in NumberOfOffers.|integer (int32)|
|**NumberOfOffers**  <br>*optional*|A list that contains the total number of offers for the item for the given conditions and fulfillment channels.|[NumberOfOffers](#numberofoffers)|
|**LowestPrices**  <br>*optional*|A list of the lowest prices for the item.|[LowestPrices](#lowestprices)|
|**BuyBoxPrices**  <br>*optional*|A list of item prices.|[BuyBoxPrices](#buyboxprices)|
|**ListPrice**  <br>*optional*|The list price of the item as suggested by the manufacturer.|[MoneyType](#moneytype)|
|**CompetitivePriceThreshold**  <br>*optional*|This price is based on competitive prices from other retailers (excluding other Amazon sellers). The offer may be ineligible for the Buy Box if the seller's price + shipping (minus Amazon Points) is greater than this competitive price.|[MoneyType](#moneytype)|
|**SuggestedLowerPricePlusShipping**  <br>*optional*|The suggested lower price of the item, including shipping and Amazon Points. The suggested lower price is based on a range of factors, including historical selling prices, recent Buy Box-eligible prices, and input from customers for your products.|[MoneyType](#moneytype)|
|**SalesRankings**  <br>*optional*|A list that contains the sales rank of the item in the given product categories.|[SalesRankList](#salesranklist)|
|**BuyBoxEligibleOffers**  <br>*optional*|A list that contains the total number of offers that are eligible for the Buy Box for the given conditions and fulfillment channels.|[BuyBoxEligibleOffers](#buyboxeligibleoffers)|
|**OffersAvailableTime**  <br>*optional*|When the status is ActiveButTooSoonForProcessing, this is the time when the offers will be available for processing.|string (date-time)|


<a name="buyboxeligibleoffers"></a>
### BuyBoxEligibleOffers
*Type* : < [OfferCountType](#offercounttype) > array


<a name="buyboxprices"></a>
### BuyBoxPrices
*Type* : < [BuyBoxPriceType](#buyboxpricetype) > array


<a name="lowestprices"></a>
### LowestPrices
*Type* : < [LowestPriceType](#lowestpricetype) > array


<a name="numberofoffers"></a>
### NumberOfOffers
*Type* : < [OfferCountType](#offercounttype) > array


<a name="offercounttype"></a>
### OfferCountType
The total number of offers for the specified condition and fulfillment channel.


|Name|Description|Schema|
|---|---|---|
|**condition**  <br>*optional*|Indicates the condition of the item. For example: New, Used, Collectible, Refurbished, or Club.|string|
|**fulfillmentChannel**  <br>*optional*|Indicates whether the item is fulfilled by Amazon or by the seller.|[FulfillmentChannelType](#fulfillmentchanneltype)|
|**OfferCount**  <br>*optional*|The number of offers in a fulfillment channel that meet a specific condition.|integer (int32)|


<a name="fulfillmentchanneltype"></a>
### FulfillmentChannelType
Indicates whether the item is fulfilled by Amazon or by the seller (merchant).

*Type* : enum


|Value|Description|
|---|---|
|**Amazon**|Fulfilled by Amazon.|
|**Merchant**|Fulfilled by the seller.|


<a name="lowestpricetype"></a>
### LowestPriceType

|Name|Description|Schema|
|---|---|---|
|**condition**  <br>*required*|Indicates the condition of the item. For example: New, Used, Collectible, Refurbished, or Club.|string|
|**fulfillmentChannel**  <br>*required*|Indicates whether the item is fulfilled by Amazon or by the seller.|string|
|**offerType**  <br>*optional*|Indicates the type of customer that the offer is valid for.|[OfferCustomerType](#offercustomertype)|
|**quantityTier**  <br>*optional*|Indicates at what quantity this price becomes active.|integer (int32)|
|**quantityDiscountType**  <br>*optional*|Indicates the type of quantity discount this price applies to.|[QuantityDiscountType](#quantitydiscounttype)|
|**LandedPrice**  <br>*required*|The value calculated by adding ListingPrice + Shipping - Points.|[MoneyType](#moneytype)|
|**ListingPrice**  <br>*required*|The price of the item.|[MoneyType](#moneytype)|
|**Shipping**  <br>*required*|The shipping cost.|[MoneyType](#moneytype)|
|**Points**  <br>*optional*|The number of Amazon Points offered with the purchase of an item.|[Points](#points)|


<a name="buyboxpricetype"></a>
### BuyBoxPriceType

|Name|Description|Schema|
|---|---|---|
|**condition**  <br>*required*|Indicates the condition of the item. For example: New, Used, Collectible, Refurbished, or Club.|string|
|**offerType**  <br>*optional*|Indicates the type of customer that the offer is valid for.<br><br>When the offer type is B2C in a quantity discount, the seller is winning the Buy Box because others do not have inventory at that quantity, not because they have a quantity discount on the ASIN.|[OfferCustomerType](#offercustomertype)|
|**quantityTier**  <br>*optional*|Indicates at what quantity this price becomes active.|integer (int32)|
|**quantityDiscountType**  <br>*optional*|Indicates the type of quantity discount this price applies to.|[QuantityDiscountType](#quantitydiscounttype)|
|**LandedPrice**  <br>*required*|The value calculated by adding ListingPrice + Shipping - Points.|[MoneyType](#moneytype)|
|**ListingPrice**  <br>*required*|The price of the item.|[MoneyType](#moneytype)|
|**Shipping**  <br>*required*|The shipping cost.|[MoneyType](#moneytype)|
|**Points**  <br>*optional*|The number of Amazon Points offered with the purchase of an item.|[Points](#points)|
|**sellerId**  <br>*optional*|The seller identifier for the offer.|string|


<a name="offerdetaillist"></a>
### OfferDetailList
*Type* : < [OfferDetail](#offerdetail) > array

**Max items** : 20  

<a name="offerdetail"></a>
### OfferDetail

|Name|Description|Schema|
|---|---|---|
|**MyOffer**  <br>*optional*|When true, this is the seller's offer.|boolean|
|**offerType**  <br>*optional*|Indicates the type of customer that the offer is valid for.|[OfferCustomerType](#offercustomertype)|
|**SubCondition**  <br>*required*|The subcondition of the item. Subcondition values: New, Mint, Very Good, Good, Acceptable, Poor, Club, OEM, Warranty, Refurbished Warranty, Refurbished, Open Box, or Other.|string|
|**SellerId**  <br>*optional*|The seller identifier for the offer.|string|
|**ConditionNotes**  <br>*optional*|Information about the condition of the item.|string|
|**SellerFeedbackRating**  <br>*optional*|Information about the seller's feedback, including the percentage of positive feedback, and the total number of ratings received.|[SellerFeedbackType](#sellerfeedbacktype)|
|**ShippingTime**  <br>*required*|The maximum time within which the item will likely be shipped once an order has been placed.|[DetailedShippingTimeType](#detailedshippingtimetype)|
|**ListingPrice**  <br>*required*|The price of the item.|[MoneyType](#moneytype)|
|**quantityDiscountPrices**  <br>*optional*|-|< [QuantityDiscountPriceType](#quantitydiscountpricetype) > array|
|**Points**  <br>*optional*|The number of Amazon Points offered with the purchase of an item.|[Points](#points)|
|**Shipping**  <br>*required*|The shipping cost.|[MoneyType](#moneytype)|
|**ShipsFrom**  <br>*optional*|The state and country from where the item is shipped.|[ShipsFromType](#shipsfromtype)|
|**IsFulfilledByAmazon**  <br>*required*|When true, the offer is fulfilled by Amazon.|boolean|
|**PrimeInformation**  <br>*optional*|Amazon Prime information.|[PrimeInformationType](#primeinformationtype)|
|**IsBuyBoxWinner**  <br>*optional*|When true, the offer is currently in the Buy Box. There can be up to two Buy Box winners at any time per ASIN, one that is eligible for Prime and one that is not eligible for Prime.|boolean|
|**IsFeaturedMerchant**  <br>*optional*|When true, the seller of the item is eligible to win the Buy Box.|boolean|


<a name="primeinformationtype"></a>
### PrimeInformationType
Amazon Prime information.


|Name|Description|Schema|
|---|---|---|
|**IsPrime**  <br>*required*|Indicates whether the offer is an Amazon Prime offer.|boolean|
|**IsNationalPrime**  <br>*required*|Indicates whether the offer is an Amazon Prime offer throughout the entire marketplace where it is listed.|boolean|


<a name="sellerfeedbacktype"></a>
### SellerFeedbackType
Information about the seller's feedback, including the percentage of positive feedback, and the total number of ratings received.


|Name|Description|Schema|
|---|---|---|
|**SellerPositiveFeedbackRating**  <br>*optional*|The percentage of positive feedback for the seller in the past 365 days.|number (double)|
|**FeedbackCount**  <br>*required*|The number of ratings received about the seller.|integer (int64)|


<a name="errorlist"></a>
### ErrorList
A list of error responses returned when a request is unsuccessful.

*Type* : < [Error](#error) > array


<a name="detailedshippingtimetype"></a>
### DetailedShippingTimeType
The time range in which an item will likely be shipped once an order has been placed.


|Name|Description|Schema|
|---|---|---|
|**minimumHours**  <br>*optional*|The minimum time, in hours, that the item will likely be shipped after the order has been placed.|integer (int64)|
|**maximumHours**  <br>*optional*|The maximum time, in hours, that the item will likely be shipped after the order has been placed.|integer (int64)|
|**availableDate**  <br>*optional*|The date when the item will be available for shipping. Only displayed for items that are not currently available for shipping.|string|
|**availabilityType**  <br>*optional*|Indicates whether the item is available for shipping now, or on a known or an unknown date in the future. If known, the availableDate property indicates the date that the item will be available for shipping. Possible values: NOW, FUTURE_WITHOUT_DATE, FUTURE_WITH_DATE.|enum ([AvailabilityType](#availabilitytype))|


<a name="shipsfromtype"></a>
### ShipsFromType
The state and country from where the item is shipped.


|Name|Description|Schema|
|---|---|---|
|**State**  <br>*optional*|The state from where the item is shipped.|string|
|**Country**  <br>*optional*|The country from where the item is shipped.|string|


<a name="error"></a>
### Error
Error response returned when the request is unsuccessful.


|Name|Description|Schema|
|---|---|---|
|**code**  <br>*required*|An error code that identifies the type of error that occurred.|string|
|**message**  <br>*required*|A message that describes the error condition in a human-readable form.|string|
|**details**  <br>*optional*|Additional information that can help the caller understand or fix the issue.|string|


<a name="availabilitytype"></a>
### AvailabilityType
Indicates whether the item is available for shipping now, or on a known or an unknown date in the future. If known, the availableDate property indicates the date that the item will be available for shipping. Possible values: NOW, FUTURE_WITHOUT_DATE, FUTURE_WITH_DATE.

*Type* : enum


|Value|Description|
|---|---|
|**NOW**|The item is available for shipping now.|
|**FUTURE_WITHOUT_DATE**|The item will be available for shipping on an unknown date in the future.|
|**FUTURE_WITH_DATE**|The item will be available for shipping on a known date in the future.|


<a name="itemtype"></a>
### ItemType
*Type* : enum

<a id="itemtype-subgroup-1"></a>**For use with the operation(s): [getPricing](#getpricing)**
Indicates whether ASIN values or seller SKU values are used to identify items. If you specify Asin, the information in the response will be dependent on the list of Asins you provide in the Asins parameter. If you specify Sku, the information in the response will be dependent on the list of Skus you provide in the Skus parameter.

|Value|Description|
|---|---|
|**Asin**|The Amazon Standard Identification Number (ASIN).|
|**Sku**|The seller SKU.|

<a id="itemtype-subgroup-2"></a>**For use with the operation(s): [getCompetitivePricing](#getcompetitivepricing)**
Indicates whether ASIN values or seller SKU values are used to identify items. If you specify Asin, the information in the response will be dependent on the list of Asins you provide in the Asins parameter. If you specify Sku, the information in the response will be dependent on the list of Skus you provide in the Skus parameter. Possible values: Asin, Sku.

|Value|Description|
|---|---|
|**Asin**|The Amazon Standard Identification Number (ASIN).|
|**Sku**|The seller SKU.|


<a name="customertype"></a>
### CustomerType
*Type* : enum

<a id="customertype-subgroup-1"></a>**For use with the operation(s): [getCompetitivePricing](#getcompetitivepricing)**
Indicates whether to request pricing information from the point of view of Consumer or Business buyers. Default is Consumer.

|Value|Description|
|---|---|
|**Consumer**|Consumer|
|**Business**|Business|

<a id="customertype-subgroup-2"></a>**For use with the operation(s): [getListingOffers](#getlistingoffers), [getItemOffers](#getitemoffers)**
Indicates whether to request Consumer or Business offers. Default is Consumer.

|Value|Description|
|---|---|
|**Consumer**|Consumer|
|**Business**|Business|


<a name="itemcondition"></a>
### ItemCondition
*Type* : enum

<a id="itemcondition-subgroup-1"></a>**For use with the operation(s): [getPricing](#getpricing), [getListingOffers](#getlistingoffers)**
Filters the offer listings based on item condition. Possible values: New, Used, Collectible, Refurbished, Club.

|Value|Description|
|---|---|
|**New**|New|
|**Used**|Used|
|**Collectible**|Collectible|
|**Refurbished**|Refurbished|
|**Club**|Club|

<a id="itemcondition-subgroup-2"></a>**For use with the operation(s): [getItemOffers](#getitemoffers)**
Filters the offer listings to be considered based on item condition. Possible values: New, Used, Collectible, Refurbished, Club.

|Value|Description|
|---|---|
|**New**|New|
|**Used**|Used|
|**Collectible**|Collectible|
|**Refurbished**|Refurbished|
|**Club**|Club|

