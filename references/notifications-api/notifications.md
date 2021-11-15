# Selling Partner API for Notifications


<a name="overview"></a>
## Overview
The Selling Partner API for Notifications lets you subscribe to notifications that are relevant to a selling partner's business. Using this API you can create a destination to receive notifications, subscribe to notifications, delete notification subscriptions, and more.

For more information, see the [Notifications Use Case Guide](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/use-case-guides/notifications-api-use-case-guide/notifications-use-case-guide-v1.md)


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
[getSubscription](#getsubscription)<br>[createSubscription](#createsubscription)<br>[getSubscriptionById](#getsubscriptionbyid)<br>[deleteSubscriptionById](#deletesubscriptionbyid)<br>[getDestinations](#getdestinations)<br>[createDestination](#createdestination)<br>[getDestination](#getdestination)<br>[deleteDestination](#deletedestination)<br>
<a name="paths"></a>
## Paths

<a name="getsubscription"></a>
### GET /notifications/v1/subscriptions/{notificationType}
**Operation: getSubscription**

#### Description
Returns information about subscriptions of the specified notification type. You can use this API to get subscription information when you do not have a subscription identifier.

**Usage Plan:**

| Rate (requests per second) | Burst |
| ---- | ---- |
| 1 | 5 |

For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**notificationType**  <br>*required*|The type of notification.<br><br> For more information about notification types, see [the Notifications API Use Case Guide](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/use-case-guides/notifications-api-use-case-guide/notifications-use-case-guide-v1.md).|enum ([NotificationType](#notificationtype))|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Success.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetSubscriptionResponse](#getsubscriptionresponse)|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetSubscriptionResponse](#getsubscriptionresponse)|
|**403**|Indicates that access to the resource is forbidden. Possible reasons include Access Denied, Unauthorized, Expired Token, or Invalid Signature.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetSubscriptionResponse](#getsubscriptionresponse)|
|**404**|The resource specified does not exist.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetSubscriptionResponse](#getsubscriptionresponse)|
|**413**|The request size exceeded the maximum accepted size.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetSubscriptionResponse](#getsubscriptionresponse)|
|**415**|The request payload is in an unsupported format.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetSubscriptionResponse](#getsubscriptionresponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetSubscriptionResponse](#getsubscriptionresponse)|
|**500**|An unexpected condition occurred that prevented the server from fulfilling the request.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetSubscriptionResponse](#getsubscriptionresponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetSubscriptionResponse](#getsubscriptionresponse)|


<a name="createsubscription"></a>
### POST /notifications/v1/subscriptions/{notificationType}
**Operation: createSubscription**

#### Description
Creates a subscription for the specified notification type to be delivered to the specified destination. Before you can subscribe, you must first create the destination by calling the createDestination operation.

**Usage Plan:**

| Rate (requests per second) | Burst |
| ---- | ---- |
| 1 | 5 |

For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Body**|**body**  <br>*required*|The request schema for the createSubscription operation.|[CreateSubscriptionRequest](#createsubscriptionrequest)|
|**Path**|**notificationType**  <br>*required*|The type of notification.<br><br> For more information about notification types, see [the Notifications API Use Case Guide](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/use-case-guides/notifications-api-use-case-guide/notifications-use-case-guide-v1.md).|enum ([NotificationType](#notificationtype))|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Success.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[CreateSubscriptionResponse](#createsubscriptionresponse)|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[CreateSubscriptionResponse](#createsubscriptionresponse)|
|**403**|Indicates that access to the resource is forbidden. Possible reasons include Access Denied, Unauthorized, Expired Token, or Invalid Signature.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[CreateSubscriptionResponse](#createsubscriptionresponse)|
|**404**|The resource specified does not exist.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[CreateSubscriptionResponse](#createsubscriptionresponse)|
|**409**|The resource specified conflicts with the current state.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[CreateSubscriptionResponse](#createsubscriptionresponse)|
|**413**|The request size exceeded the maximum accepted size.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[CreateSubscriptionResponse](#createsubscriptionresponse)|
|**415**|The request payload is in an unsupported format.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[CreateSubscriptionResponse](#createsubscriptionresponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[CreateSubscriptionResponse](#createsubscriptionresponse)|
|**500**|An unexpected condition occurred that prevented the server from fulfilling the request.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[CreateSubscriptionResponse](#createsubscriptionresponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[CreateSubscriptionResponse](#createsubscriptionresponse)|


<a name="getsubscriptionbyid"></a>
### GET /notifications/v1/subscriptions/{notificationType}/{subscriptionId}
**Operation: getSubscriptionById**

#### Description
Returns information about a subscription for the specified notification type. The getSubscriptionById API is grantless. For more information, see "Grantless operations" in the Selling Partner API Developer Guide.

**Usage Plan:**

| Rate (requests per second) | Burst |
| ---- | ---- |
| 1 | 5 |

For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**subscriptionId**  <br>*required*|The identifier for the subscription that you want to get.|string|
|**Path**|**notificationType**  <br>*required*|The type of notification.<br><br> For more information about notification types, see [the Notifications API Use Case Guide](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/use-case-guides/notifications-api-use-case-guide/notifications-use-case-guide-v1.md).|enum ([NotificationType](#notificationtype))|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Success.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetSubscriptionByIdResponse](#getsubscriptionbyidresponse)|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetSubscriptionByIdResponse](#getsubscriptionbyidresponse)|
|**403**|Indicates that access to the resource is forbidden. Possible reasons include Access Denied, Unauthorized, Expired Token, or Invalid Signature.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetSubscriptionByIdResponse](#getsubscriptionbyidresponse)|
|**404**|The resource specified does not exist.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetSubscriptionResponse](#getsubscriptionresponse)|
|**409**|The resource specified conflicts with the current state.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetSubscriptionByIdResponse](#getsubscriptionbyidresponse)|
|**413**|The request size exceeded the maximum accepted size.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetSubscriptionByIdResponse](#getsubscriptionbyidresponse)|
|**415**|The request payload is in an unsupported format.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetSubscriptionByIdResponse](#getsubscriptionbyidresponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetSubscriptionByIdResponse](#getsubscriptionbyidresponse)|
|**500**|An unexpected condition occurred that prevented the server from fulfilling the request.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetSubscriptionByIdResponse](#getsubscriptionbyidresponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetSubscriptionByIdResponse](#getsubscriptionbyidresponse)|


<a name="deletesubscriptionbyid"></a>
### DELETE /notifications/v1/subscriptions/{notificationType}/{subscriptionId}
**Operation: deleteSubscriptionById**

#### Description
Deletes the subscription indicated by the subscription identifier and notification type that you specify. The subscription identifier can be for any subscription associated with your application. After you successfully call this operation, notifications will stop being sent for the associated subscription. The deleteSubscriptionById API is grantless. For more information, see "Grantless operations" in the Selling Partner API Developer Guide.

**Usage Plan:**

| Rate (requests per second) | Burst |
| ---- | ---- |
| 1 | 5 |

For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**subscriptionId**  <br>*required*|The identifier for the subscription that you want to delete.|string|
|**Path**|**notificationType**  <br>*required*|The type of notification.<br><br> For more information about notification types, see [the Notifications API Use Case Guide](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/use-case-guides/notifications-api-use-case-guide/notifications-use-case-guide-v1.md).|enum ([NotificationType](#notificationtype))|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Success.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[DeleteSubscriptionByIdResponse](#deletesubscriptionbyidresponse)|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[DeleteSubscriptionByIdResponse](#deletesubscriptionbyidresponse)|
|**403**|Indicates that access to the resource is forbidden. Possible reasons include Access Denied, Unauthorized, Expired Token, or Invalid Signature.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[DeleteSubscriptionByIdResponse](#deletesubscriptionbyidresponse)|
|**404**|The resource specified does not exist.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[DeleteSubscriptionByIdResponse](#deletesubscriptionbyidresponse)|
|**409**|The resource specified conflicts with the current state.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[DeleteSubscriptionByIdResponse](#deletesubscriptionbyidresponse)|
|**413**|The request size exceeded the maximum accepted size.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[DeleteSubscriptionByIdResponse](#deletesubscriptionbyidresponse)|
|**415**|The request payload is in an unsupported format.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[DeleteSubscriptionByIdResponse](#deletesubscriptionbyidresponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[DeleteSubscriptionByIdResponse](#deletesubscriptionbyidresponse)|
|**500**|An unexpected condition occurred that prevented the server from fulfilling the request.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[DeleteSubscriptionByIdResponse](#deletesubscriptionbyidresponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[DeleteSubscriptionByIdResponse](#deletesubscriptionbyidresponse)|


<a name="getdestinations"></a>
### GET /notifications/v1/destinations
**Operation: getDestinations**

#### Description
Returns information about all destinations. The getDestinations API is grantless. For more information, see "Grantless operations" in the Selling Partner API Developer Guide.

**Usage Plan:**

| Rate (requests per second) | Burst |
| ---- | ---- |
| 1 | 5 |

For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Success.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetDestinationsResponse](#getdestinationsresponse)|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetDestinationsResponse](#getdestinationsresponse)|
|**403**|Indicates that access to the resource is forbidden. Possible reasons include Access Denied, Unauthorized, Expired Token, or Invalid Signature.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetDestinationsResponse](#getdestinationsresponse)|
|**404**|The resource specified does not exist.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetDestinationsResponse](#getdestinationsresponse)|
|**409**|The resource specified conflicts with the current state.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetDestinationsResponse](#getdestinationsresponse)|
|**413**|The request size exceeded the maximum accepted size.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetDestinationsResponse](#getdestinationsresponse)|
|**415**|The request payload is in an unsupported format.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetDestinationsResponse](#getdestinationsresponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetDestinationsResponse](#getdestinationsresponse)|
|**500**|An unexpected condition occurred that prevented the server from fulfilling the request.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetDestinationsResponse](#getdestinationsresponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetDestinationsResponse](#getdestinationsresponse)|


<a name="createdestination"></a>
### POST /notifications/v1/destinations
**Operation: createDestination**

#### Description
Creates a destination resource to receive notifications. The createDestination API is grantless. For more information, see "Grantless operations" in the Selling Partner API Developer Guide.

**Usage Plan:**

| Rate (requests per second) | Burst |
| ---- | ---- |
| 1 | 5 |

For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Body**|**body**  <br>*required*|The request schema for the createDestination operation.|[CreateDestinationRequest](#createdestinationrequest)|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Success.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[CreateDestinationResponse](#createdestinationresponse)|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[CreateDestinationResponse](#createdestinationresponse)|
|**403**|Indicates that access to the resource is forbidden. Possible reasons include Access Denied, Unauthorized, Expired Token, or Invalid Signature.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[CreateDestinationResponse](#createdestinationresponse)|
|**404**|The resource specified does not exist.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[CreateDestinationResponse](#createdestinationresponse)|
|**409**|The resource specified conflicts with the current state.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[CreateDestinationResponse](#createdestinationresponse)|
|**413**|The request size exceeded the maximum accepted size.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[CreateDestinationResponse](#createdestinationresponse)|
|**415**|The request payload is in an unsupported format.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[CreateDestinationResponse](#createdestinationresponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[CreateDestinationResponse](#createdestinationresponse)|
|**500**|An unexpected condition occurred that prevented the server from fulfilling the request.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[CreateDestinationResponse](#createdestinationresponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[CreateDestinationResponse](#createdestinationresponse)|


<a name="getdestination"></a>
### GET /notifications/v1/destinations/{destinationId}
**Operation: getDestination**

#### Description
Returns information about the destination that you specify. The getDestination API is grantless. For more information, see "Grantless operations" in the Selling Partner API Developer Guide.

**Usage Plan:**

| Rate (requests per second) | Burst |
| ---- | ---- |
| 1 | 5 |

For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**destinationId**  <br>*required*|The identifier generated when you created the destination.|string|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Success.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetDestinationResponse](#getdestinationresponse)|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetDestinationResponse](#getdestinationresponse)|
|**403**|Indicates that access to the resource is forbidden. Possible reasons include Access Denied, Unauthorized, Expired Token, or Invalid Signature.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetDestinationResponse](#getdestinationresponse)|
|**404**|The resource specified does not exist.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetDestinationResponse](#getdestinationresponse)|
|**409**|The resource specified conflicts with the current state.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetDestinationResponse](#getdestinationresponse)|
|**413**|The request size exceeded the maximum accepted size.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetDestinationResponse](#getdestinationresponse)|
|**415**|The request payload is in an unsupported format.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetDestinationResponse](#getdestinationresponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetDestinationResponse](#getdestinationresponse)|
|**500**|An unexpected condition occurred that prevented the server from fulfilling the request.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetDestinationResponse](#getdestinationresponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetDestinationResponse](#getdestinationresponse)|


<a name="deletedestination"></a>
### DELETE /notifications/v1/destinations/{destinationId}
**Operation: deleteDestination**

#### Description
Deletes the destination that you specify. The deleteDestination API is grantless. For more information, see "Grantless operations" in the Selling Partner API Developer Guide.

**Usage Plan:**

| Rate (requests per second) | Burst |
| ---- | ---- |
| 1 | 5 |

For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**destinationId**  <br>*required*|The identifier for the destination that you want to delete.|string|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Success.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[DeleteDestinationResponse](#deletedestinationresponse)|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[DeleteDestinationResponse](#deletedestinationresponse)|
|**403**|Indicates that access to the resource is forbidden. Possible reasons include Access Denied, Unauthorized, Expired Token, or Invalid Signature.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[DeleteDestinationResponse](#deletedestinationresponse)|
|**404**|The resource specified does not exist.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[DeleteDestinationResponse](#deletedestinationresponse)|
|**409**|The resource specified conflicts with the current state.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[DeleteDestinationResponse](#deletedestinationresponse)|
|**413**|The request size exceeded the maximum accepted size.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[DeleteDestinationResponse](#deletedestinationresponse)|
|**415**|The request payload is in an unsupported format.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[DeleteDestinationResponse](#deletedestinationresponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[DeleteDestinationResponse](#deletedestinationresponse)|
|**500**|An unexpected condition occurred that prevented the server from fulfilling the request.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[DeleteDestinationResponse](#deletedestinationresponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.<br>_Note:_ For this status code, the rate limit header is deprecated and no longer returned.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[DeleteDestinationResponse](#deletedestinationresponse)|


<a name="definitions"></a>
## Definitions

<a name="subscription"></a>
### Subscription
Represents a subscription to receive notifications.


|Name|Description|Schema|
|---|---|---|
|**subscriptionId**  <br>*required*|The subscription identifier generated when the subscription is created.|string|
|**payloadVersion**  <br>*required*|The version of the payload object to be used in the notification.|string|
|**destinationId**  <br>*required*|The identifier for the destination where notifications will be delivered.|string|


<a name="createsubscriptionresponse"></a>
### CreateSubscriptionResponse
The response schema for the createSubscription operation.


|Name|Description|Schema|
|---|---|---|
|**payload**  <br>*optional*|The payload for the createSubscription operation.|[Subscription](#subscription)|
|**errors**  <br>*optional*|One or more unexpected errors occurred during the createSubscription operation.|[ErrorList](#errorlist)|


<a name="createsubscriptionrequest"></a>
### CreateSubscriptionRequest
The request schema for the createSubscription operation.


|Name|Description|Schema|
|---|---|---|
|**payloadVersion**  <br>*optional*|The version of the payload object to be used in the notification.|string|
|**destinationId**  <br>*optional*|The identifier for the destination where notifications will be delivered.|string|


<a name="getsubscriptionbyidresponse"></a>
### GetSubscriptionByIdResponse
The response schema for the getSubscriptionById operation.


|Name|Description|Schema|
|---|---|---|
|**payload**  <br>*optional*|The payload for the getSubscriptionById operation.|[Subscription](#subscription)|
|**errors**  <br>*optional*|An unexpected condition occurred during the getSubscriptionById operation.|[ErrorList](#errorlist)|


<a name="getsubscriptionresponse"></a>
### GetSubscriptionResponse
The response schema for the getSubscription operation.


|Name|Description|Schema|
|---|---|---|
|**payload**  <br>*optional*|The payload for the getSubscription operation.|[Subscription](#subscription)|
|**errors**  <br>*optional*|One or more unexpected errors occurred during the getSubscription operation.|[ErrorList](#errorlist)|


<a name="deletesubscriptionbyidresponse"></a>
### DeleteSubscriptionByIdResponse
The response schema for the deleteSubscriptionById operation.


|Name|Description|Schema|
|---|---|---|
|**errors**  <br>*optional*|An unexpected condition occurred during the deleteSubscriptionById operation.|[ErrorList](#errorlist)|


<a name="destinationlist"></a>
### DestinationList
A list of destinations.

*Type* : < [Destination](#destination) > array


<a name="destination"></a>
### Destination
Represents a destination created when you call the createDestination operation.


|Name|Description|Schema|
|---|---|---|
|**name**  <br>*required*|The developer-defined name for this destination.<br>**maxLength** : 256|string|
|**destinationId**  <br>*required*|The destination identifier generated when you created the destination.|string|
|**resource**  <br>*required*|The resource that will receive notifications associated with this destination.|[DestinationResource](#destinationresource)|


<a name="destinationresource"></a>
### DestinationResource
The destination resource types.


|Name|Description|Schema|
|---|---|---|
|**sqs**  <br>*optional*|An Amazon Simple Queue Service (SQS) queue destination.|[SqsResource](#sqsresource)|
|**eventBridge**  <br>*optional*|An Amazon EventBridge destination.|[EventBridgeResource](#eventbridgeresource)|


<a name="destinationresourcespecification"></a>
### DestinationResourceSpecification
The information required to create a destination resource. Applications should use one resource type (sqs or eventBridge) per destination.


|Name|Description|Schema|
|---|---|---|
|**sqs**  <br>*optional*|The information required to create an Amazon Simple Queue Service (SQS) queue destination.|[SqsResource](#sqsresource)|
|**eventBridge**  <br>*optional*|The information required to create an Amazon EventBridge destination.|[EventBridgeResourceSpecification](#eventbridgeresourcespecification)|


<a name="sqsresource"></a>
### SqsResource
The information required to create an Amazon Simple Queue Service (Amazon SQS) queue destination.


|Name|Description|Schema|
|---|---|---|
|**arn**  <br>*required*|The Amazon Resource Name (ARN) associated with the SQS queue.<br>**maxLength** : 1000  <br>**Pattern** : `"^arn:aws:sqs:\\S+:\\S+:\\S+"`|string|


<a name="eventbridgeresourcespecification"></a>
### EventBridgeResourceSpecification
The information required to create an Amazon EventBridge destination.


|Name|Description|Schema|
|---|---|---|
|**region**  <br>*required*|The AWS region in which you will be receiving the notifications.|string|
|**accountId**  <br>*required*|The identifier for the AWS account that is responsible for charges related to receiving notifications.|string|


<a name="eventbridgeresource"></a>
### EventBridgeResource
Represents an Amazon EventBridge destination.


|Name|Description|Schema|
|---|---|---|
|**name**  <br>*required*|The name of the partner event source associated with the destination.<br>**maxLength** : 256|string|
|**region**  <br>*required*|The AWS region in which you receive the notifications. For AWS regions that are supported in Amazon EventBridge, see https://docs.aws.amazon.com/general/latest/gr/ev.html.|string|
|**accountId**  <br>*required*|The identifier for the AWS account that is responsible for charges related to receiving notifications.|string|


<a name="createdestinationrequest"></a>
### CreateDestinationRequest
The request schema for the createDestination operation.


|Name|Description|Schema|
|---|---|---|
|**resourceSpecification**  <br>*required*|The information required to create a destination resource. Applications should use one resource type (sqs or eventBridge) per destination.|[DestinationResourceSpecification](#destinationresourcespecification)|
|**name**  <br>*required*|A developer-defined name to help identify this destination.|string|


<a name="createdestinationresponse"></a>
### CreateDestinationResponse
The response schema for the createDestination operation.


|Name|Description|Schema|
|---|---|---|
|**payload**  <br>*optional*|The payload for the createDestination operation.|[Destination](#destination)|
|**errors**  <br>*optional*|One or more unexpected errors occurred during the createDestination operation.|[ErrorList](#errorlist)|


<a name="getdestinationresponse"></a>
### GetDestinationResponse
The response schema for the getDestination operation.


|Name|Description|Schema|
|---|---|---|
|**payload**  <br>*optional*|The payload for the getDestination operation.|[Destination](#destination)|
|**errors**  <br>*optional*|One or more unexpected errors occurred during the getDestination operation.|[ErrorList](#errorlist)|


<a name="getdestinationsresponse"></a>
### GetDestinationsResponse
The response schema for the getDestinations operation.


|Name|Description|Schema|
|---|---|---|
|**payload**  <br>*optional*|The payload for the getDestinations operation.|[DestinationList](#destinationlist)|
|**errors**  <br>*optional*|One or more unexpected errors occurred during the getDestinations operation.|[ErrorList](#errorlist)|


<a name="deletedestinationresponse"></a>
### DeleteDestinationResponse
The response schema for the deleteDestination operation.


|Name|Description|Schema|
|---|---|---|
|**errors**  <br>*optional*|One or more unexpected errors occurred during the deleteDestination operation.|[ErrorList](#errorlist)|


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


<a name="notificationtype"></a>
### NotificationType
The type of notification.

 For more information about notification types, see [the Notifications API Use Case Guide](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/use-case-guides/notifications-api-use-case-guide/notifications-use-case-guide-v1.md).

*Type* : enum


|Value|Description|
|---|---|
|**ANY_OFFER_CHANGED**|Sent whenever there is a listing change for any of the top 20 offers, by condition (new or used), or if the external price (the price from other retailers) changes for an item listed by the seller. The top 20 offers are determined by the landed price, which is the price plus shipping minus Amazon Points. If multiple sellers are charging the same landed price, the results will be returned in random order.<br><br> These notifications are only sent for items for which the seller has active offers. You cannot subscribe to notifications for items for which the seller does not have active offers.|
|**FEED_PROCESSING_FINISHED**|Sent whenever any feed submitted using the Selling Partner API for Feeds reaches a feed processing status of DONE or CANCELLED.|
|**FBA_OUTBOUND_SHIPMENT_STATUS**|Sent whenever Amazon creates or cancels a Fulfillment by Amazon shipment for a seller. This notification is only for FBA Onsite shipments. This notification is available only in the Brazil marketplace.|
|**FEE_PROMOTION**|Sent when a promotion becomes active. Sellers can benefit from time-limited fee promotions. To receive notifications of these fee promotions on behalf of the seller, subscribe to the FEE_PROMOTION notification. All currently active promotions are sent at first, with each promotion sent as a single message. Subsequent notifications are sent when the promotion becomes active.|
|**FULFILLMENT_ORDER_STATUS**|Sent whenever there is a change in the status of a Multi-Channel Fulfillment order.<br><br> Multi-Channel Fulfillment is a program where sellers use their FBA inventory to fulfill orders not sold on the retail site.|
|**REPORT_PROCESSING_FINISHED**|Sent whenever any report that you have requested using the Selling Partner API for Reports reaches a report processing status of DONE, CANCELLED, or DONE_NO_DATA.|
|**BRANDED_ITEM_CONTENT_CHANGE**|Sent whenever there is a change to the title, description, or bullet points for any ASIN that the selling partner has a brand relationship with.|
|**ITEM_PRODUCT_TYPE_CHANGE**|Sent whenever there is a change to the product type name of any ASIN that the selling partner has a brand relationship with.|
|**LISTINGS_ITEM_STATUS_CHANGE**|Sent whenever there is a listing status change including buyable transition, discoverable transition, listing create or delete for any SKU that the selling partner has.|
|**LISTINGS_ITEM_ISSUES_CHANGE**|Sent whenever there are issues change for any SKU that the selling partner has.|
|**MFN_ORDER_STATUS_CHANGE**|Sent whenever there is a change in the status of an MFN order availability.|
|**B2B_ANY_OFFER_CHANGED**|Sent whenever there is a listing change for any of the top 20 B2B offers, by condition (new or used). The top 20 offers are determined by the landed price, which is the price plus shipping minus Amazon Points(applicable only JP). If multiple sellers are charging the same landed price, the results will be returned in random order.<br><br> These notifications are only sent for items for which the seller has active offers. Seller cannot receive notifications for items for which the seller does not have active offers.|
|**ACCOUNT_STATUS_CHANGED**|Sent whenever the Account Status changes for the developers subscribed merchant/marketplace pairs. A notification is published whenever the merchant's account status changes between NORMAL, AT_RISK, and DEACTIVATED.<br><br> The notification will have a payload with 2 fields: previousAccountStatus and currentAccountStatus to indicate the direction of the change.|
|**PRODUCT_TYPE_DEFINITIONS_CHANGE**|Sent whenever there is a new Product Type or a Product Type Version in a marketplace.|

