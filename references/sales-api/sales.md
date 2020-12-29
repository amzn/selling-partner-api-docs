# Selling Partner API for Sales


<a name="overview"></a>
## Overview
The Selling Partner API for Sales provides APIs related to sales performance.


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
[getOrderMetrics](#getordermetrics)<br>
<a name="paths"></a>
## Paths

<a name="getordermetrics"></a>
### GET /sales/v1/orderMetrics
**Operation: getOrderMetrics**

#### Description
Returns aggregated order metrics for given interval, broken down by granularity, for given buyer type.

**Usage Plan:**

| Rate (requests per second) | Burst |
| ---- | ---- |
| .5 | 15 |

For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|Default|
|---|---|---|---|---|
|**Query**|**marketplaceIds**  <br>*required*|A list of marketplace identifiers. Example: ATVPDKIKX0DER indicates the US marketplace.|< string > array|-|
|**Query**|**interval**  <br>*required*|A time interval used for selecting order metrics. This takes the form of two dates separated by two hyphens (first date is inclusive; second date is exclusive). Dates are in ISO8601 format and must represent absolute time (either Z notation or offset notation). Example: 2018-09-01T00:00:00-07:00--2018-09-04T00:00:00-07:00 requests order metrics for Sept 1st, 2nd and 3rd in the -07:00 zone.|string|-|
|**Query**|**granularityTimeZone**  <br>*optional*|An IANA-compatible time zone for determining the day boundary. Required when specifying a granularity value greater than Hour. The granularityTimeZone value must align with the offset of the specified interval value. For example, if the interval value uses Z notation, then granularityTimeZone must be UTC. If the interval value uses an offset, then granularityTimeZone must be an IANA-compatible time zone that matches the offset. Example: US/Pacific to compute day boundaries, accounting for daylight time savings, for US/Pacific zone.|string|-|
|**Query**|**granularity**  <br>*required*|The granularity of the grouping of order metrics, based on a unit of time. Specifying granularity=Hour results in a successful request only if the interval specified is less than or equal to 30 days from now. For all other granularities, the interval specified must be less or equal to 2 years from now. Specifying granularity=Total results in order metrics that are aggregated over the entire interval that you specify. If the interval start and end date don’t align with the specified granularity, the head and tail end of the response interval will contain partial data. Example: Day to get a daily breakdown of the request interval, where the day boundary is defined by the granularityTimeZone.|enum ([Granularity](#granularity))|-|
|**Query**|**buyerType**  <br>*optional*|Filters the results by the buyer type that you specify, B2B (business to business) or B2C (business to customer). Example: B2B, if you want the response to include order metrics for only B2B buyers.|enum ([BuyerType](#buyertype))|`"All"`|
|**Query**|**fulfillmentNetwork**  <br>*optional*|Filters the results by the fulfillment network that you specify, MFN (merchant fulfillment network) or AFN (Amazon fulfillment network). Do not include this filter if you want the response to include order metrics for all fulfillment networks. Example: AFN, if you want the response to include order metrics for only Amazon fulfillment network.|string|-|
|**Query**|**firstDayOfWeek**  <br>*optional*|Specifies the day that the week starts on when granularity=Week, either Monday or Sunday. Default: Monday. Example: Sunday, if you want the week to start on a Sunday.|enum ([FirstDayOfWeek](#firstdayofweek))|`"Monday"`|
|**Query**|**asin**  <br>*optional*|Filters the results by the ASIN that you specify. Specifying both ASIN and SKU returns an error. Do not include this filter if you want the response to include order metrics for all ASINs. Example: B0792R1RSN, if you want the response to include order metrics for only ASIN B0792R1RSN.|string|-|
|**Query**|**sku**  <br>*optional*|Filters the results by the SKU that you specify. Specifying both ASIN and SKU returns an error. Do not include this filter if you want the response to include order metrics for all SKUs. Example: TestSKU, if you want the response to include order metrics for only SKU TestSKU.|string|-|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OrderMetric action taken on the resource OrderMetrics.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : TPS throttle rate customer is authorized for.  <br>`x-amzn-RequestId` (string) : unique request reference id.|[GetOrderMetricsResponse](#getordermetricsresponse)|

For error status codes, descriptions and schemas, see [Error responses and schemas](#error-responses-and-schemas).



<a name="error-responses-and-schemas"></a>
### Error Responses and Schemas
This table contains HTTP status codes and associated information for error responses.

|HTTP Code|Description|Schema|
|---|---|---|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers**:  <br>`x-amzn-RateLimit-Limit` (string):TPS throttle rate customer is authorized for.  <br>`x-amzn-RequestId` (string):Unique request reference id.|[GetOrderMetricsResponse](#getordermetricsresponse)|
|**403**|403 can be caused for reasons like Access Denied, Unauthorized, Expired Token, Invalid Signature or Resource Not Found.  <br>**Headers**:  <br>`x-amzn-RequestId` (string):Unique request reference id.|[GetOrderMetricsResponse](#getordermetricsresponse)|
|**404**|The resource specified does not exist.  <br>**Headers**:  <br>`x-amzn-RequestId` (string):Unique request reference id.|[GetOrderMetricsResponse](#getordermetricsresponse)|
|**413**|The request size exceeded the maximum accepted size.  <br>**Headers**:  <br>`x-amzn-RateLimit-Limit` (string):TPS throttle rate customer is authorized for.  <br>`x-amzn-RequestId` (string):Unique request reference id.|[GetOrderMetricsResponse](#getordermetricsresponse)|
|**415**|The entity of the request is in a format not supported by the requested resource.  <br>**Headers**:  <br>`x-amzn-RateLimit-Limit` (string):TPS throttle rate customer is authorized for.  <br>`x-amzn-RequestId` (string):Unique request reference id.|[GetOrderMetricsResponse](#getordermetricsresponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers**:  <br>`x-amzn-RateLimit-Limit` (string):TPS throttle rate customer is authorized for.  <br>`x-amzn-RequestId` (string):Unique request reference id.|[GetOrderMetricsResponse](#getordermetricsresponse)|
|**500**|Encountered an unexpected condition which prevented the server from fulfilling the request.  <br>**Headers**:  <br>`x-amzn-RateLimit-Limit` (string):TPS throttle rate customer is authorized for.  <br>`x-amzn-RequestId` (string):Unique request reference id.|[GetOrderMetricsResponse](#getordermetricsresponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers**:  <br>`x-amzn-RateLimit-Limit` (string):TPS throttle rate customer is authorized for.  <br>`x-amzn-RequestId` (string):Unique request reference id.|[GetOrderMetricsResponse](#getordermetricsresponse)|


<a name="definitions"></a>
## Definitions

<a name="getordermetricsresponse"></a>
### GetOrderMetricsResponse
The response schema for the getOrderMetrics operation.


|Name|Description|Schema|
|---|---|---|
|**payload**  <br>*optional*|The payload for the getOrderMetrics operation.|[OrderMetricsList](#ordermetricslist)|
|**errors**  <br>*optional*|Encountered errors for the getOrderMetrics operation.|[ErrorList](#errorlist)|


<a name="ordermetricslist"></a>
### OrderMetricsList
A set of order metrics, each scoped to a particular time interval.

*Type* : < [OrderMetricsInterval](#ordermetricsinterval) > array


<a name="ordermetricsinterval"></a>
### OrderMetricsInterval
Contains order metrics.


|Name|Description|Schema|
|---|---|---|
|**interval**  <br>*required*|The interval of time based on requested granularity (ex. Hour, Day, etc.) If this is the first or the last interval from the list, it might contain incomplete data if the requested interval doesn't align with the requested granularity (ex. request interval 2018-09-01T02:00:00Z--2018-09-04T19:00:00Z and granularity day will result in Sept 1st UTC day and Sept 4th UTC days having partial data).|string|
|**unitCount**  <br>*required*|The number of units in orders based on the specified filters.|integer|
|**orderItemCount**  <br>*required*|The number of order items based on the specified filters.|integer|
|**orderCount**  <br>*required*|The number of orders based on the specified filters.|integer|
|**averageUnitPrice**  <br>*required*|The average price for an item based on the specified filters. Formula is totalSales/unitCount.|[Money](#money)|
|**totalSales**  <br>*required*|The total ordered product sales for all orders based on the specified filters.|[Money](#money)|


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


<a name="money"></a>
### Money
The currency type and the amount.


|Name|Description|Schema|
|---|---|---|
|**currencyCode**  <br>*required*|Three-digit currency code. In ISO 4217 format.|string|
|**amount**  <br>*required*|The currency amount.|[Decimal](#decimal)|


<a name="decimal"></a>
### Decimal
A decimal number with no loss of precision. Useful when precision loss is unacceptable, as with currencies. Follows RFC7159 for number representation. <br>**Pattern** : `^-?(0|([1-9]\d*))(\.\d+)?([eE][+-]?\d+)?$`.

*Type* : string


<a name="buyertype"></a>
### BuyerType
Filters the results by the buyer type that you specify, B2B (business to business) or B2C (business to customer). Example: B2B, if you want the response to include order metrics for only B2B buyers.

*Type* : enum


|Value|Description|
|---|---|
|**B2B**|Business to business.|
|**B2C**|Business to customer.|
|**All**|Business to business and business to customer.|


<a name="granularity"></a>
### Granularity
The granularity of the grouping of order metrics, based on a unit of time. Specifying granularity=Hour results in a successful request only if the interval specified is less than or equal to 30 days from now. For all other granularities, the interval specified must be less or equal to 2 years from now. Specifying granularity=Total results in order metrics that are aggregated over the entire interval that you specify. If the interval start and end date don’t align with the specified granularity, the head and tail end of the response interval will contain partial data. Example: Day to get a daily breakdown of the request interval, where the day boundary is defined by the granularityTimeZone.

*Type* : enum


|Value|Description|
|---|---|
|**Hour**|Hour|
|**Day**|Day|
|**Week**|Week|
|**Month**|Month|
|**Year**|Year|
|**Total**|Total|


<a name="firstdayofweek"></a>
### FirstDayOfWeek
Specifies the day that the week starts on when granularity=Week, either Monday or Sunday. Default: Monday. Example: Sunday, if you want the week to start on a Sunday.

*Type* : enum


|Value|Description|
|---|---|
|**Monday**|Monday|
|**Sunday**|Sunday|

