# Selling Partner API for Sellers


<a name="overview"></a>
## Overview
The Selling Partner API for Sellers lets you retrieve information on behalf of sellers about their seller account, such as the marketplaces they participate in. Along with listing the marketplaces that a seller can sell in, the API also provides additional information about the marketplace such as the default language and the default currency. The API also provides seller-specific information such as whether the seller has suspended listings in that marketplace.


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
[getMarketplaceParticipations](#getmarketplaceparticipations)<br>
<a name="paths"></a>
## Paths

<a name="getmarketplaceparticipations"></a>
### GET /sellers/v1/marketplaceParticipations
**Operation: getMarketplaceParticipations**

#### Description
Returns a list of marketplaces that the seller submitting the request can sell in and information about the seller's participation in those marketplaces.

**Usage Plan:**

| Rate (requests per second) | Burst |
| ---- | ---- |
| .016 | 15 |

For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Marketplace participations successfully retrieved.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : unique request reference id.|[GetMarketplaceParticipationsResponse](#getmarketplaceparticipationsresponse)|

For error status codes, descriptions and schemas, see [Error responses and schemas](#error-responses-and-schemas).



<a name="error-responses-and-schemas"></a>
### Error Responses and Schemas
This table contains HTTP status codes and associated information for error responses.

|HTTP Code|Description|Schema|
|---|---|---|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers**:  <br>`x-amzn-RequestId` (string):Unique request reference id.|[GetMarketplaceParticipationsResponse](#getmarketplaceparticipationsresponse)|
|**403**|403 can be caused for reasons like Access Denied, Unauthorized, Expired Token, Invalid Signature or Resource Not Found.  <br>**Headers**:  <br>`x-amzn-RequestId` (string):Unique request reference id.|[GetMarketplaceParticipationsResponse](#getmarketplaceparticipationsresponse)|
|**404**|The resource specified does not exist.  <br>**Headers**:  <br>`x-amzn-RequestId` (string):Unique request reference id.|[GetMarketplaceParticipationsResponse](#getmarketplaceparticipationsresponse)|
|**413**|The request size exceeded the maximum accepted size.  <br>**Headers**:  <br>`x-amzn-RequestId` (string):Unique request reference id.|[GetMarketplaceParticipationsResponse](#getmarketplaceparticipationsresponse)|
|**415**|The entity of the request is in a format not supported by the requested resource.  <br>**Headers**:  <br>`x-amzn-RequestId` (string):Unique request reference id.|[GetMarketplaceParticipationsResponse](#getmarketplaceparticipationsresponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers**:  <br>`x-amzn-RequestId` (string):Unique request reference id.|[GetMarketplaceParticipationsResponse](#getmarketplaceparticipationsresponse)|
|**500**|Encountered an unexpected condition which prevented the server from fulfilling the request.  <br>**Headers**:  <br>`x-amzn-RequestId` (string):Unique request reference id.|[GetMarketplaceParticipationsResponse](#getmarketplaceparticipationsresponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers**:  <br>`x-amzn-RequestId` (string):Unique request reference id.|[GetMarketplaceParticipationsResponse](#getmarketplaceparticipationsresponse)|


<a name="definitions"></a>
## Definitions

<a name="error"></a>
### Error
Error response returned when the request is unsuccessful.


|Name|Description|Schema|
|---|---|---|
|**code**  <br>*required*|An error code that identifies the type of error that occured.|string|
|**message**  <br>*required*|A message that describes the error condition in a human-readable form.|string|
|**details**  <br>*optional*|Additional details that can help the caller understand or fix the issue.|string|


<a name="errorlist"></a>
### ErrorList
A list of error responses returned when a request is unsuccessful.

*Type* : < [Error](#error) > array


<a name="marketplaceparticipation"></a>
### MarketplaceParticipation

|Name|Description|Schema|
|---|---|---|
|**marketplace**  <br>*required*|Detailed information about an Amazon market where a seller can list items for sale and customers can view and purchase items.|[Marketplace](#marketplace)|
|**participation**  <br>*required*|Detailed information that is specific to a seller in a Marketplace.|[Participation](#participation)|


<a name="marketplaceparticipationlist"></a>
### MarketplaceParticipationList
List of marketplace participations.

*Type* : < [MarketplaceParticipation](#marketplaceparticipation) > array


<a name="getmarketplaceparticipationsresponse"></a>
### GetMarketplaceParticipationsResponse
The response schema for the getMarketplaceParticipations operation.


|Name|Description|Schema|
|---|---|---|
|**payload**  <br>*optional*|The payload for the getMarketplaceParticipations operation.|[MarketplaceParticipationList](#marketplaceparticipationlist)|
|**errors**  <br>*optional*|Encountered errors for the getMarketplaceParticipations operation.|[ErrorList](#errorlist)|


<a name="marketplace"></a>
### Marketplace
Detailed information about an Amazon market where a seller can list items for sale and customers can view and purchase items.


|Name|Description|Schema|
|---|---|---|
|**id**  <br>*required*|The encrypted marketplace value.|string|
|**name**  <br>*required*|Marketplace name.|string|
|**countryCode**  <br>*required*|The ISO 3166-1 alpha-2 format country code of the marketplace.  <br>**Pattern** : `"^([A-Z]{2})$"`|string|
|**defaultCurrencyCode**  <br>*required*|The ISO 4217 format currency code of the marketplace.|string|
|**defaultLanguageCode**  <br>*required*|The ISO 639-1 format language code of the marketplace.|string|
|**domainName**  <br>*required*|The domain name of the marketplace.|string|


<a name="participation"></a>
### Participation
Detailed information that is specific to a seller in a Marketplace.


|Name|Description|Schema|
|---|---|---|
|**isParticipating**  <br>*required*|-|boolean|
|**hasSuspendedListings**  <br>*required*|Specifies if the seller has suspended listings. True if the seller Listing Status is set to Inactive, otherwise False.|boolean|

