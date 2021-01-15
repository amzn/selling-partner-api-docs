# Selling Partner API for Messaging


<a name="overview"></a>
## Overview
With the Messaging API you can build applications that send messages to buyers. You can get a list of message types that are available for an order that you specify, then call an operation that sends a message to the buyer for that order. The Messaging API returns responses that are formed according to the <a href=https://tools.ietf.org/html/draft-kelly-json-hal-08>JSON Hypertext Application Language</a> (HAL) standard.


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

* `application/hal+json`


### Operations
[getMessagingActionsForOrder](#getmessagingactionsfororder)<br>[confirmCustomizationDetails](#confirmcustomizationdetails)<br>[createConfirmDeliveryDetails](#createconfirmdeliverydetails)<br>[createLegalDisclosure](#createlegaldisclosure)<br>[createNegativeFeedbackRemoval](#createnegativefeedbackremoval)<br>[createConfirmOrderDetails](#createconfirmorderdetails)<br>[createConfirmServiceDetails](#createconfirmservicedetails)<br>[CreateAmazonMotors](#createamazonmotors)<br>[CreateWarranty](#createwarranty)<br>[GetAttributes](#getattributes)<br>[createDigitalAccessKey](#createdigitalaccesskey)<br>[createUnexpectedProblem](#createunexpectedproblem)<br>
<a name="paths"></a>
## Paths

<a name="getmessagingactionsfororder"></a>
### GET /messaging/v1/orders/{amazonOrderId}
**Operation: getMessagingActionsForOrder**

#### Description
Returns a list of message types that are available for an order that you specify. A message type is represented by an actions object, which contains a path and query parameter(s). You can use the path and parameter(s) to call an operation that sends a message.

**Usage Plan:**

| Rate (requests per second) | Burst |
| ---- | ---- |
| 1 | 5 |

For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**amazonOrderId**  <br>*required*|An Amazon order identifier. This specifies the order for which you want a list of available message types.|string|
|**Query**|**marketplaceIds**  <br>*required*|A marketplace identifier. This specifies the marketplace in which the order was placed. Only one marketplace can be specified.<br>**Max count** : 1|< string > array|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Returns hypermedia links under the _links.actions key that specify which messaging actions are allowed for the order.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[GetMessagingActionsForOrderResponse](#getmessagingactionsfororderresponse)|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[GetMessagingActionsForOrderResponse](#getmessagingactionsfororderresponse)|
|**403**|Indicates that access to the resource is forbidden. Possible reasons include Access Denied, Unauthorized, Expired Token, or Invalid Signature.  <br>**Headers** :   <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[GetMessagingActionsForOrderResponse](#getmessagingactionsfororderresponse)|
|**404**|The resource specified does not exist.  <br>**Headers** :   <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[GetMessagingActionsForOrderResponse](#getmessagingactionsfororderresponse)|
|**413**|The request size exceeded the maximum accepted size.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[GetMessagingActionsForOrderResponse](#getmessagingactionsfororderresponse)|
|**415**|The request payload is in an unsupported format.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[GetMessagingActionsForOrderResponse](#getmessagingactionsfororderresponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[GetMessagingActionsForOrderResponse](#getmessagingactionsfororderresponse)|
|**500**|An unexpected condition occurred that prevented the server from fulfilling the request.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[GetMessagingActionsForOrderResponse](#getmessagingactionsfororderresponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[GetMessagingActionsForOrderResponse](#getmessagingactionsfororderresponse)|


<a name="confirmcustomizationdetails"></a>
### POST /messaging/v1/orders/{amazonOrderId}/messages/confirmCustomizationDetails
**Operation: confirmCustomizationDetails**

#### Description
Sends a message asking a buyer to provide or verify customization details such as name spelling, images, initials, etc.

**Usage Plan:**

| Rate (requests per second) | Burst |
| ---- | ---- |
| 1 | 5 |

For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**amazonOrderId**  <br>*required*|An Amazon order identifier. This specifies the order for which a message is sent.|string|
|**Query**|**marketplaceIds**  <br>*required*|A marketplace identifier. This specifies the marketplace in which the order was placed. Only one marketplace can be specified.<br>**Max count** : 1|< string > array|
|**Body**|**body**  <br>*required*|The request schema for the confirmCustomizationDetails operation.|[CreateConfirmCustomizationDetailsRequest](#createconfirmcustomizationdetailsrequest)|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**201**|The message was created for the order.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[CreateConfirmCustomizationDetailsResponse](#createconfirmcustomizationdetailsresponse)|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[CreateConfirmCustomizationDetailsResponse](#createconfirmcustomizationdetailsresponse)|
|**403**|Indicates that access to the resource is forbidden. Possible reasons include Access Denied, Unauthorized, Expired Token, or Invalid Signature.  <br>**Headers** :   <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[CreateConfirmCustomizationDetailsResponse](#createconfirmcustomizationdetailsresponse)|
|**404**|The resource specified does not exist.  <br>**Headers** :   <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[CreateConfirmCustomizationDetailsResponse](#createconfirmcustomizationdetailsresponse)|
|**413**|The request size exceeded the maximum accepted size.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[CreateConfirmCustomizationDetailsResponse](#createconfirmcustomizationdetailsresponse)|
|**415**|The request payload is in an unsupported format.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[CreateConfirmCustomizationDetailsResponse](#createconfirmcustomizationdetailsresponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[CreateConfirmCustomizationDetailsResponse](#createconfirmcustomizationdetailsresponse)|
|**500**|An unexpected condition occurred that prevented the server from fulfilling the request.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[CreateConfirmCustomizationDetailsResponse](#createconfirmcustomizationdetailsresponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[CreateConfirmCustomizationDetailsResponse](#createconfirmcustomizationdetailsresponse)|


<a name="createconfirmdeliverydetails"></a>
### POST /messaging/v1/orders/{amazonOrderId}/messages/confirmDeliveryDetails
**Operation: createConfirmDeliveryDetails**

#### Description
Sends a message to a buyer to arrange a delivery or to confirm contact information for making a delivery.

**Usage Plan:**

| Rate (requests per second) | Burst |
| ---- | ---- |
| 1 | 5 |

For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**amazonOrderId**  <br>*required*|An Amazon order identifier. This specifies the order for which a message is sent.|string|
|**Query**|**marketplaceIds**  <br>*required*|A marketplace identifier. This specifies the marketplace in which the order was placed. Only one marketplace can be specified.<br>**Max count** : 1|< string > array|
|**Body**|**body**  <br>*required*|The request schema for the createConfirmDeliveryDetails operation.|[CreateConfirmDeliveryDetailsRequest](#createconfirmdeliverydetailsrequest)|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**201**|The message was created for the order.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[CreateConfirmDeliveryDetailsResponse](#createconfirmdeliverydetailsresponse)|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[CreateConfirmDeliveryDetailsResponse](#createconfirmdeliverydetailsresponse)|
|**403**|Indicates that access to the resource is forbidden. Possible reasons include Access Denied, Unauthorized, Expired Token, or Invalid Signature.  <br>**Headers** :   <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[CreateConfirmDeliveryDetailsResponse](#createconfirmdeliverydetailsresponse)|
|**404**|The resource specified does not exist.  <br>**Headers** :   <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[CreateConfirmDeliveryDetailsResponse](#createconfirmdeliverydetailsresponse)|
|**413**|The request size exceeded the maximum accepted size.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[CreateConfirmDeliveryDetailsResponse](#createconfirmdeliverydetailsresponse)|
|**415**|The request payload is in an unsupported format.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[CreateConfirmDeliveryDetailsResponse](#createconfirmdeliverydetailsresponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[CreateConfirmDeliveryDetailsResponse](#createconfirmdeliverydetailsresponse)|
|**500**|An unexpected condition occurred that prevented the server from fulfilling the request.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[CreateConfirmDeliveryDetailsResponse](#createconfirmdeliverydetailsresponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[CreateConfirmDeliveryDetailsResponse](#createconfirmdeliverydetailsresponse)|


<a name="createlegaldisclosure"></a>
### POST /messaging/v1/orders/{amazonOrderId}/messages/legalDisclosure
**Operation: createLegalDisclosure**

#### Description
Sends a critical message that contains documents that a seller is legally obligated to provide to the buyer. This message should only be used to deliver documents that are required by law.

**Usage Plan:**

| Rate (requests per second) | Burst |
| ---- | ---- |
| 1 | 5 |

For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**amazonOrderId**  <br>*required*|An Amazon order identifier. This specifies the order for which a message is sent.|string|
|**Query**|**marketplaceIds**  <br>*required*|A marketplace identifier. This specifies the marketplace in which the order was placed. Only one marketplace can be specified.<br>**Max count** : 1|< string > array|
|**Body**|**body**  <br>*required*|The request schema for the createLegalDisclosure operation.|[CreateLegalDisclosureRequest](#createlegaldisclosurerequest)|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**201**|The legal disclosure message was created for the order.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[CreateLegalDisclosureResponse](#createlegaldisclosureresponse)|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[CreateLegalDisclosureResponse](#createlegaldisclosureresponse)|
|**403**|Indicates that access to the resource is forbidden. Possible reasons include Access Denied, Unauthorized, Expired Token, or Invalid Signature.  <br>**Headers** :   <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[CreateLegalDisclosureResponse](#createlegaldisclosureresponse)|
|**404**|The resource specified does not exist.  <br>**Headers** :   <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[CreateLegalDisclosureResponse](#createlegaldisclosureresponse)|
|**413**|The request size exceeded the maximum accepted size.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[CreateLegalDisclosureResponse](#createlegaldisclosureresponse)|
|**415**|The request payload is in an unsupported format.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[CreateLegalDisclosureResponse](#createlegaldisclosureresponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[CreateLegalDisclosureResponse](#createlegaldisclosureresponse)|
|**500**|An unexpected condition occurred that prevented the server from fulfilling the request.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[CreateLegalDisclosureResponse](#createlegaldisclosureresponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[CreateLegalDisclosureResponse](#createlegaldisclosureresponse)|


<a name="createnegativefeedbackremoval"></a>
### POST /messaging/v1/orders/{amazonOrderId}/messages/negativeFeedbackRemoval
**Operation: createNegativeFeedbackRemoval**

#### Description
Sends a non-critical message that asks a buyer to remove their negative feedback. This message should only be sent after the seller has resolved the buyer's problem.

**Usage Plan:**

| Rate (requests per second) | Burst |
| ---- | ---- |
| 1 | 5 |

For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**amazonOrderId**  <br>*required*|An Amazon order identifier. This specifies the order for which a message is sent.|string|
|**Query**|**marketplaceIds**  <br>*required*|A marketplace identifier. This specifies the marketplace in which the order was placed. Only one marketplace can be specified.<br>**Max count** : 1|< string > array|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**201**|The negativeFeedbackRemoval message was created for the order.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[CreateNegativeFeedbackRemovalResponse](#createnegativefeedbackremovalresponse)|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[CreateNegativeFeedbackRemovalResponse](#createnegativefeedbackremovalresponse)|
|**403**|Indicates that access to the resource is forbidden. Possible reasons include Access Denied, Unauthorized, Expired Token, or Invalid Signature.  <br>**Headers** :   <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[CreateNegativeFeedbackRemovalResponse](#createnegativefeedbackremovalresponse)|
|**404**|The resource specified does not exist.  <br>**Headers** :   <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[CreateNegativeFeedbackRemovalResponse](#createnegativefeedbackremovalresponse)|
|**413**|The request size exceeded the maximum accepted size.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[CreateNegativeFeedbackRemovalResponse](#createnegativefeedbackremovalresponse)|
|**415**|The request payload is in an unsupported format.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[CreateNegativeFeedbackRemovalResponse](#createnegativefeedbackremovalresponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[CreateNegativeFeedbackRemovalResponse](#createnegativefeedbackremovalresponse)|
|**500**|An unexpected condition occurred that prevented the server from fulfilling the request.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[CreateNegativeFeedbackRemovalResponse](#createnegativefeedbackremovalresponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[CreateNegativeFeedbackRemovalResponse](#createnegativefeedbackremovalresponse)|


<a name="createconfirmorderdetails"></a>
### POST /messaging/v1/orders/{amazonOrderId}/messages/confirmOrderDetails
**Operation: createConfirmOrderDetails**

#### Description
Sends a message to ask a buyer an order-related question prior to shipping their order.

**Usage Plan:**

| Rate (requests per second) | Burst |
| ---- | ---- |
| 1 | 5 |

For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**amazonOrderId**  <br>*required*|An Amazon order identifier. This specifies the order for which a message is sent.|string|
|**Query**|**marketplaceIds**  <br>*required*|A marketplace identifier. This specifies the marketplace in which the order was placed. Only one marketplace can be specified.<br>**Max count** : 1|< string > array|
|**Body**|**body**  <br>*required*|The request schema for the createConfirmOrderDetails operation.|[CreateConfirmOrderDetailsRequest](#createconfirmorderdetailsrequest)|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**201**|The message was created for the order.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[CreateConfirmOrderDetailsResponse](#createconfirmorderdetailsresponse)|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[CreateConfirmOrderDetailsResponse](#createconfirmorderdetailsresponse)|
|**403**|Indicates that access to the resource is forbidden. Possible reasons include Access Denied, Unauthorized, Expired Token, or Invalid Signature.  <br>**Headers** :   <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[CreateConfirmOrderDetailsResponse](#createconfirmorderdetailsresponse)|
|**404**|The resource specified does not exist.  <br>**Headers** :   <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[CreateConfirmOrderDetailsResponse](#createconfirmorderdetailsresponse)|
|**413**|The request size exceeded the maximum accepted size.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[CreateConfirmOrderDetailsResponse](#createconfirmorderdetailsresponse)|
|**415**|The request payload is in an unsupported format.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[CreateConfirmOrderDetailsResponse](#createconfirmorderdetailsresponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[CreateConfirmOrderDetailsResponse](#createconfirmorderdetailsresponse)|
|**500**|An unexpected condition occurred that prevented the server from fulfilling the request.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[CreateConfirmOrderDetailsResponse](#createconfirmorderdetailsresponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[CreateConfirmOrderDetailsResponse](#createconfirmorderdetailsresponse)|


<a name="createconfirmservicedetails"></a>
### POST /messaging/v1/orders/{amazonOrderId}/messages/confirmServiceDetails
**Operation: createConfirmServiceDetails**

#### Description
Sends a message to contact a Home Service customer to arrange a service call or to gather information prior to a service call.

**Usage Plan:**

| Rate (requests per second) | Burst |
| ---- | ---- |
| 1 | 5 |

For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**amazonOrderId**  <br>*required*|An Amazon order identifier. This specifies the order for which a message is sent.|string|
|**Query**|**marketplaceIds**  <br>*required*|A marketplace identifier. This specifies the marketplace in which the order was placed. Only one marketplace can be specified.<br>**Max count** : 1|< string > array|
|**Body**|**body**  <br>*required*|The request schema for the createConfirmServiceDetails operation.|[CreateConfirmServiceDetailsRequest](#createconfirmservicedetailsrequest)|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**201**|The message was created for the order.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[CreateConfirmServiceDetailsResponse](#createconfirmservicedetailsresponse)|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[CreateConfirmServiceDetailsResponse](#createconfirmservicedetailsresponse)|
|**403**|Indicates that access to the resource is forbidden. Possible reasons include Access Denied, Unauthorized, Expired Token, or Invalid Signature.  <br>**Headers** :   <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[CreateConfirmServiceDetailsResponse](#createconfirmservicedetailsresponse)|
|**404**|The resource specified does not exist.  <br>**Headers** :   <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[CreateConfirmServiceDetailsResponse](#createconfirmservicedetailsresponse)|
|**413**|The request size exceeded the maximum accepted size.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[CreateConfirmServiceDetailsResponse](#createconfirmservicedetailsresponse)|
|**415**|The request payload is in an unsupported format.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[CreateConfirmServiceDetailsResponse](#createconfirmservicedetailsresponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[CreateConfirmServiceDetailsResponse](#createconfirmservicedetailsresponse)|
|**500**|An unexpected condition occurred that prevented the server from fulfilling the request.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[CreateConfirmServiceDetailsResponse](#createconfirmservicedetailsresponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[CreateConfirmServiceDetailsResponse](#createconfirmservicedetailsresponse)|


<a name="createamazonmotors"></a>
### POST /messaging/v1/orders/{amazonOrderId}/messages/amazonMotors
**Operation: CreateAmazonMotors**

#### Description
Sends a message to a buyer to provide details about an Amazon Motors order. This message can only be sent by Amazon Motors sellers.

**Usage Plan:**

| Rate (requests per second) | Burst |
| ---- | ---- |
| 1 | 5 |

For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**amazonOrderId**  <br>*required*|An Amazon order identifier. This specifies the order for which a message is sent.|string|
|**Query**|**marketplaceIds**  <br>*required*|A marketplace identifier. This specifies the marketplace in which the order was placed. Only one marketplace can be specified.<br>**Max count** : 1|< string > array|
|**Body**|**body**  <br>*required*|The request schema for the createAmazonMotors operation.|[CreateAmazonMotorsRequest](#createamazonmotorsrequest)|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**201**|The message was created for the order.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[CreateAmazonMotorsResponse](#createamazonmotorsresponse)|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[CreateAmazonMotorsResponse](#createamazonmotorsresponse)|
|**403**|Indicates that access to the resource is forbidden. Possible reasons include Access Denied, Unauthorized, Expired Token, or Invalid Signature.  <br>**Headers** :   <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[CreateAmazonMotorsResponse](#createamazonmotorsresponse)|
|**404**|The resource specified does not exist.  <br>**Headers** :   <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[CreateAmazonMotorsResponse](#createamazonmotorsresponse)|
|**413**|The request size exceeded the maximum accepted size.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[CreateAmazonMotorsResponse](#createamazonmotorsresponse)|
|**415**|The request payload is in an unsupported format.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[CreateAmazonMotorsResponse](#createamazonmotorsresponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[CreateAmazonMotorsResponse](#createamazonmotorsresponse)|
|**500**|An unexpected condition occurred that prevented the server from fulfilling the request.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[CreateAmazonMotorsResponse](#createamazonmotorsresponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[CreateAmazonMotorsResponse](#createamazonmotorsresponse)|


<a name="createwarranty"></a>
### POST /messaging/v1/orders/{amazonOrderId}/messages/warranty
**Operation: CreateWarranty**

#### Description
Sends a message to a buyer to provide details about warranty information on a purchase in their order.

**Usage Plan:**

| Rate (requests per second) | Burst |
| ---- | ---- |
| 1 | 5 |

For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**amazonOrderId**  <br>*required*|An Amazon order identifier. This specifies the order for which a message is sent.|string|
|**Query**|**marketplaceIds**  <br>*required*|A marketplace identifier. This specifies the marketplace in which the order was placed. Only one marketplace can be specified.<br>**Max count** : 1|< string > array|
|**Body**|**body**  <br>*required*|The request schema for the createWarranty operation.|[CreateWarrantyRequest](#createwarrantyrequest)|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**201**|The message was created for the order.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[CreateWarrantyResponse](#createwarrantyresponse)|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[CreateWarrantyResponse](#createwarrantyresponse)|
|**403**|Indicates that access to the resource is forbidden. Possible reasons include Access Denied, Unauthorized, Expired Token, or Invalid Signature.  <br>**Headers** :   <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[CreateWarrantyResponse](#createwarrantyresponse)|
|**404**|The resource specified does not exist.  <br>**Headers** :   <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[CreateWarrantyResponse](#createwarrantyresponse)|
|**413**|The request size exceeded the maximum accepted size.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[CreateWarrantyResponse](#createwarrantyresponse)|
|**415**|The request payload is in an unsupported format.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[CreateWarrantyResponse](#createwarrantyresponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[CreateWarrantyResponse](#createwarrantyresponse)|
|**500**|An unexpected condition occurred that prevented the server from fulfilling the request.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[CreateWarrantyResponse](#createwarrantyresponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[CreateWarrantyResponse](#createwarrantyresponse)|


<a name="getattributes"></a>
### GET /messaging/v1/orders/{amazonOrderId}/attributes
**Operation: GetAttributes**

#### Description
Returns a response containing attributes related to an order. This includes buyer preferences.

**Usage Plan:**

| Rate (requests per second) | Burst |
| ---- | ---- |
| 1 | 5 |


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**amazonOrderId**  <br>*required*|An Amazon order identifier. This specifies the order for which a message is sent.|string|
|**Query**|**marketplaceIds**  <br>*required*|A marketplace identifier. This specifies the marketplace in which the order was placed. Only one marketplace can be specified.<br>**Max count** : 1|< string > array|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Response has successfully been returned.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[GetAttributesResponse](#getattributesresponse)|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[GetAttributesResponse](#getattributesresponse)|
|**403**|Indicates that access to the resource is forbidden. Possible reasons include Access Denied, Unauthorized, Expired Token, or Invalid Signature.  <br>**Headers** :   <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[GetAttributesResponse](#getattributesresponse)|
|**404**|The resource specified does not exist.  <br>**Headers** :   <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[GetAttributesResponse](#getattributesresponse)|
|**413**|The request size exceeded the maximum accepted size.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[GetAttributesResponse](#getattributesresponse)|
|**415**|The request payload is in an unsupported format.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[GetAttributesResponse](#getattributesresponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[GetAttributesResponse](#getattributesresponse)|
|**500**|An unexpected condition occurred that prevented the server from fulfilling the request.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[GetAttributesResponse](#getattributesresponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[GetAttributesResponse](#getattributesresponse)|


<a name="createdigitalaccesskey"></a>
### POST /messaging/v1/orders/{amazonOrderId}/messages/digitalAccessKey
**Operation: createDigitalAccessKey**

#### Description
Sends a message to a buyer to share a digital access key needed to utilize digital content in their order.

**Usage Plan:**

| Rate (requests per second) | Burst |
| ---- | ---- |
| 1 | 5 |

For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**amazonOrderId**  <br>*required*|An Amazon order identifier. This specifies the order for which a message is sent.|string|
|**Query**|**marketplaceIds**  <br>*required*|A marketplace identifier. This specifies the marketplace in which the order was placed. Only one marketplace can be specified.<br>**Max count** : 1|< string > array|
|**Body**|**body**  <br>*required*|The request schema for the createDigitalAccessKey operation.|[CreateDigitalAccessKeyRequest](#createdigitalaccesskeyrequest)|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**201**|The message was created for the order.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[CreateDigitalAccessKeyResponse](#createdigitalaccesskeyresponse)|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[CreateDigitalAccessKeyResponse](#createdigitalaccesskeyresponse)|
|**403**|Indicates that access to the resource is forbidden. Possible reasons include Access Denied, Unauthorized, Expired Token, or Invalid Signature.  <br>**Headers** :   <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[CreateDigitalAccessKeyResponse](#createdigitalaccesskeyresponse)|
|**404**|The resource specified does not exist.  <br>**Headers** :   <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[CreateDigitalAccessKeyResponse](#createdigitalaccesskeyresponse)|
|**413**|The request size exceeded the maximum accepted size.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[CreateDigitalAccessKeyResponse](#createdigitalaccesskeyresponse)|
|**415**|The request payload is in an unsupported format.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[CreateDigitalAccessKeyResponse](#createdigitalaccesskeyresponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[CreateDigitalAccessKeyResponse](#createdigitalaccesskeyresponse)|
|**500**|An unexpected condition occurred that prevented the server from fulfilling the request.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[CreateDigitalAccessKeyResponse](#createdigitalaccesskeyresponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[CreateDigitalAccessKeyResponse](#createdigitalaccesskeyresponse)|


<a name="createunexpectedproblem"></a>
### POST /messaging/v1/orders/{amazonOrderId}/messages/unexpectedProblem
**Operation: createUnexpectedProblem**

#### Description
Sends a critical message to a buyer that an unexpected problem was encountered affecting the completion of the order.

**Usage Plan:**

| Rate (requests per second) | Burst |
| ---- | ---- |
| 1 | 5 |

For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**amazonOrderId**  <br>*required*|An Amazon order identifier. This specifies the order for which a message is sent.|string|
|**Query**|**marketplaceIds**  <br>*required*|A marketplace identifier. This specifies the marketplace in which the order was placed. Only one marketplace can be specified.<br>**Max count** : 1|< string > array|
|**Body**|**body**  <br>*required*|The request schema for the createUnexpectedProblem operation.|[CreateUnexpectedProblemRequest](#createunexpectedproblemrequest)|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**201**|The message was created for the order.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[CreateUnexpectedProblemResponse](#createunexpectedproblemresponse)|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[CreateUnexpectedProblemResponse](#createunexpectedproblemresponse)|
|**403**|Indicates that access to the resource is forbidden. Possible reasons include Access Denied, Unauthorized, Expired Token, or Invalid Signature.  <br>**Headers** :   <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[CreateUnexpectedProblemResponse](#createunexpectedproblemresponse)|
|**404**|The resource specified does not exist.  <br>**Headers** :   <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[CreateUnexpectedProblemResponse](#createunexpectedproblemresponse)|
|**413**|The request size exceeded the maximum accepted size.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[CreateUnexpectedProblemResponse](#createunexpectedproblemresponse)|
|**415**|The request payload is in an unsupported format.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[CreateUnexpectedProblemResponse](#createunexpectedproblemresponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[CreateUnexpectedProblemResponse](#createunexpectedproblemresponse)|
|**500**|An unexpected condition occurred that prevented the server from fulfilling the request.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[CreateUnexpectedProblemResponse](#createunexpectedproblemresponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[CreateUnexpectedProblemResponse](#createunexpectedproblemresponse)|


<a name="definitions"></a>
## Definitions

<a name="attachment"></a>
### Attachment
Represents a file uploaded to a destination that was created by the createUploadDestination operation of the Uploads API.


|Name|Description|Schema|
|---|---|---|
|**uploadDestinationId**  <br>*required*|The identifier of the upload destination. Get this value by calling the createUploadDestination operation of the Uploads API.|string|
|**fileName**  <br>*required*|The name of the file, including the extension. This is the file name that will appear in the message. This does not need to match the file name of the file that you uploaded.|string|


<a name="linkobject"></a>
### LinkObject
A Link object.


|Name|Description|Schema|
|---|---|---|
|**href**  <br>*required*|A URI for this object.|string|
|**name**  <br>*optional*|An identifier for this object.|string|


<a name="messagingaction"></a>
### MessagingAction
A simple object containing the name of the template.


|Name|Schema|
|---|---|
|**name**  <br>*required*|string|


<a name="schema"></a>
### Schema
A JSON schema document describing the expected payload of the action. This object can be validated against <a href=http://json-schema.org/draft-04/schema>http://json-schema.org/draft-04/schema</a>.

*Type* : object


<a name="getmessagingactionsfororderresponse"></a>
### GetMessagingActionsForOrderResponse
The response schema for the getMessagingActionsForOrder operation.


|Name|Description|Schema|
|---|---|---|
|**_links**  <br>*optional*|-|[_links](#getmessagingactionsfororderresponse-links)|
|**_embedded**  <br>*optional*|-|[_embedded](#getmessagingactionsfororderresponse-embedded)|
|**errors**  <br>*optional*|A list of error responses returned when a request is unsuccessful.|[ErrorList](#errorlist)|

<a name="getmessagingactionsfororderresponse-links"></a>
**_links**

|Name|Description|Schema|
|---|---|---|
|**self**  <br>*required*|-|[LinkObject](#linkobject)|
|**actions**  <br>*required*|Eligible actions for the specified amazonOrderId.|< [LinkObject](#linkobject) > array|

<a name="getmessagingactionsfororderresponse-embedded"></a>
**_embedded**

|Name|Schema|
|---|---|
|**actions**  <br>*required*|< [GetMessagingActionResponse](#getmessagingactionresponse) > array|


<a name="getmessagingactionresponse"></a>
### GetMessagingActionResponse
Describes a messaging action that can be taken for an order. Provides a JSON Hypertext Application Language (HAL) link to the JSON schema document that describes the expected input.


|Name|Description|Schema|
|---|---|---|
|**_links**  <br>*optional*|-|[_links](#getmessagingactionresponse-links)|
|**_embedded**  <br>*optional*|-|[_embedded](#getmessagingactionresponse-embedded)|
|**payload**  <br>*optional*|A simple object containing the name of the template.|[MessagingAction](#messagingaction)|
|**errors**  <br>*optional*|A list of error responses returned when a request is unsuccessful.|[ErrorList](#errorlist)|

<a name="getmessagingactionresponse-links"></a>
**_links**

|Name|Schema|
|---|---|
|**self**  <br>*required*|[LinkObject](#linkobject)|
|**schema**  <br>*required*|[LinkObject](#linkobject)|

<a name="getmessagingactionresponse-embedded"></a>
**_embedded**

|Name|Schema|
|---|---|
|**schema**  <br>*optional*|[GetSchemaResponse](#getschemaresponse)|


<a name="getschemaresponse"></a>
### GetSchemaResponse

|Name|Description|Schema|
|---|---|---|
|**_links**  <br>*optional*|-|[_links](#getschemaresponse-links)|
|**payload**  <br>*optional*|A JSON schema document describing the expected payload of the action. This object can be validated against <a href=http://json-schema.org/draft-04/schema>http://json-schema.org/draft-04/schema</a>.|[Schema](#schema)|
|**errors**  <br>*optional*|A list of error responses returned when a request is unsuccessful.|[ErrorList](#errorlist)|

<a name="getschemaresponse-links"></a>
**_links**

|Name|Schema|
|---|---|
|**self**  <br>*required*|[LinkObject](#linkobject)|


<a name="createconfirmcustomizationdetailsrequest"></a>
### CreateConfirmCustomizationDetailsRequest
The request schema for the confirmCustomizationDetails operation.


|Name|Description|Schema|
|---|---|---|
|**text**  <br>*optional*|The text to be sent to the buyer. Only links related to customization details are allowed. Do not include HTML or email addresses. The text must be written in the buyer's language of preference, which can be retrieved from the GetAttributes operation.<br>**minLength** : 1<br>**maxLength** : 800|string|
|**attachments**  <br>*optional*|Attachments to include in the message to the buyer.|< [Attachment](#attachment) > array|


<a name="createconfirmcustomizationdetailsresponse"></a>
### CreateConfirmCustomizationDetailsResponse
The response schema for the confirmCustomizationDetails operation.


|Name|Description|Schema|
|---|---|---|
|**errors**  <br>*optional*|A list of error responses returned when a request is unsuccessful.|[ErrorList](#errorlist)|


<a name="createconfirmdeliverydetailsrequest"></a>
### CreateConfirmDeliveryDetailsRequest
The request schema for the createConfirmDeliveryDetails operation.


|Name|Description|Schema|
|---|---|---|
|**text**  <br>*optional*|The text to be sent to the buyer. Only links related to order delivery are allowed. Do not include HTML or email addresses. The text must be written in the buyer's language of preference, which can be retrieved from the GetAttributes operation.<br>**minLength** : 1<br>**maxLength** : 2000|string|


<a name="createconfirmdeliverydetailsresponse"></a>
### CreateConfirmDeliveryDetailsResponse
The response schema for the createConfirmDeliveryDetails operation.


|Name|Description|Schema|
|---|---|---|
|**errors**  <br>*optional*|A list of error responses returned when a request is unsuccessful.|[ErrorList](#errorlist)|


<a name="createnegativefeedbackremovalresponse"></a>
### CreateNegativeFeedbackRemovalResponse
The response schema for the createNegativeFeedbackRemoval operation.


|Name|Description|Schema|
|---|---|---|
|**errors**  <br>*optional*|A list of error responses returned when a request is unsuccessful.|[ErrorList](#errorlist)|


<a name="createlegaldisclosurerequest"></a>
### CreateLegalDisclosureRequest
The request schema for the createLegalDisclosure operation.


|Name|Description|Schema|
|---|---|---|
|**attachments**  <br>*optional*|Attachments to include in the message to the buyer. If any text is included in the attachment, the text must be written in the buyer's language of preference, which can be retrieved from the GetAttributes operation.|< [Attachment](#attachment) > array|


<a name="createlegaldisclosureresponse"></a>
### CreateLegalDisclosureResponse
The response schema for the createLegalDisclosure operation.


|Name|Description|Schema|
|---|---|---|
|**errors**  <br>*optional*|A list of error responses returned when a request is unsuccessful.|[ErrorList](#errorlist)|


<a name="createconfirmorderdetailsrequest"></a>
### CreateConfirmOrderDetailsRequest
The request schema for the createConfirmOrderDetails operation.


|Name|Description|Schema|
|---|---|---|
|**text**  <br>*optional*|The text to be sent to the buyer. Only links related to order completion are allowed. Do not include HTML or email addresses. The text must be written in the buyer's language of preference, which can be retrieved from the GetAttributes operation.<br>**minLength** : 1<br>**maxLength** : 2000|string|


<a name="createconfirmorderdetailsresponse"></a>
### CreateConfirmOrderDetailsResponse
The response schema for the createConfirmOrderDetails operation.


|Name|Description|Schema|
|---|---|---|
|**errors**  <br>*optional*|A list of error responses returned when a request is unsuccessful.|[ErrorList](#errorlist)|


<a name="createconfirmservicedetailsrequest"></a>
### CreateConfirmServiceDetailsRequest
The request schema for the createConfirmServiceDetails operation.


|Name|Description|Schema|
|---|---|---|
|**text**  <br>*optional*|The text to be sent to the buyer. Only links related to Home Service calls are allowed. Do not include HTML or email addresses. The text must be written in the buyer's language of preference, which can be retrieved from the GetAttributes operation.<br>**minLength** : 1<br>**maxLength** : 2000|string|


<a name="createconfirmservicedetailsresponse"></a>
### CreateConfirmServiceDetailsResponse
The response schema for the createConfirmServiceDetails operation.


|Name|Description|Schema|
|---|---|---|
|**errors**  <br>*optional*|A list of error responses returned when a request is unsuccessful.|[ErrorList](#errorlist)|


<a name="createamazonmotorsrequest"></a>
### CreateAmazonMotorsRequest
The request schema for the createAmazonMotors operation.


|Name|Description|Schema|
|---|---|---|
|**attachments**  <br>*optional*|Attachments to include in the message to the buyer. If any text is included in the attachment, the text must be written in the buyer's language of preference, which can be retrieved from the GetAttributes operation.|< [Attachment](#attachment) > array|


<a name="createamazonmotorsresponse"></a>
### CreateAmazonMotorsResponse
The response schema for the createAmazonMotors operation.


|Name|Description|Schema|
|---|---|---|
|**errors**  <br>*optional*|A list of error responses returned when a request is unsuccessful.|[ErrorList](#errorlist)|


<a name="createwarrantyrequest"></a>
### CreateWarrantyRequest
The request schema for the createWarranty operation.


|Name|Description|Schema|
|---|---|---|
|**attachments**  <br>*optional*|Attachments to include in the message to the buyer. If any text is included in the attachment, the text must be written in the buyer's language of preference, which can be retrieved from the GetAttributes operation.|< [Attachment](#attachment) > array|
|**coverageStartDate**  <br>*optional*|The start date of the warranty coverage to include in the message to the buyer.|string (date-time)|
|**coverageEndDate**  <br>*optional*|The end date of the warranty coverage to include in the message to the buyer.|string (date-time)|


<a name="createwarrantyresponse"></a>
### CreateWarrantyResponse
The response schema for the createWarranty operation.


|Name|Description|Schema|
|---|---|---|
|**errors**  <br>*optional*|A list of error responses returned when a request is unsuccessful.|[ErrorList](#errorlist)|


<a name="getattributesresponse"></a>
### GetAttributesResponse
The response schema for the GetAttributes operation.


|Name|Description|Schema|
|---|---|---|
|**buyer**  <br>*optional*|The list of attributes related to the buyer.|[buyer](#getattributesresponse-buyer)|
|**errors**  <br>*optional*|A list of error responses returned when a request is unsuccessful.|[ErrorList](#errorlist)|

<a name="getattributesresponse-buyer"></a>
**buyer**

|Name|Description|Schema|
|---|---|---|
|**locale**  <br>*optional*|The buyer's language of preference, indicated with a locale-specific language tag. Examples: "en-US", "zh-CN", and "en-GB".|string|


<a name="createdigitalaccesskeyrequest"></a>
### CreateDigitalAccessKeyRequest
The request schema for the createDigitalAccessKey operation.


|Name|Description|Schema|
|---|---|---|
|**text**  <br>*optional*|The text to be sent to the buyer. Only links related to the digital access key are allowed. Do not include HTML or email addresses. The text must be written in the buyer's language of preference, which can be retrieved from the GetAttributes operation.<br>**minLength** : 1<br>**maxLength** : 400|string|
|**attachments**  <br>*optional*|Attachments to include in the message to the buyer.|< [Attachment](#attachment) > array|


<a name="createdigitalaccesskeyresponse"></a>
### CreateDigitalAccessKeyResponse
The response schema for the createDigitalAccessKey operation.


|Name|Description|Schema|
|---|---|---|
|**errors**  <br>*optional*|A list of error responses returned when a request is unsuccessful.|[ErrorList](#errorlist)|


<a name="createunexpectedproblemrequest"></a>
### CreateUnexpectedProblemRequest
The request schema for the createUnexpectedProblem operation.


|Name|Description|Schema|
|---|---|---|
|**text**  <br>*optional*|The text to be sent to the buyer. Only links related to unexpected problem calls are allowed. Do not include HTML or email addresses. The text must be written in the buyer's language of preference, which can be retrieved from the GetAttributes operation.<br>**minLength** : 1<br>**maxLength** : 2000|string|


<a name="createunexpectedproblemresponse"></a>
### CreateUnexpectedProblemResponse
The response schema for the createUnexpectedProblem operation.


|Name|Description|Schema|
|---|---|---|
|**errors**  <br>*optional*|A list of error responses returned when a request is unsuccessful.|[ErrorList](#errorlist)|


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

