# Selling Partner API for Authorization


<a name="overview"></a>
## Overview
The Selling Partner API for Authorization helps developers manage authorizations and check the specific permissions associated with a given authorization.


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
[getAuthorizationCode](#getauthorizationcode)<br>
<a name="paths"></a>
## Paths

<a name="getauthorizationcode"></a>
### Returns the Login with Amazon (LWA) authorization code for an existing Amazon MWS authorization.
```
GET /authorization/v1/authorizationCode
```

**Operation: getAuthorizationCode**

#### Description
With the getAuthorizationCode operation, you can request a Login With Amazon (LWA) authorization code that will allow you to call a Selling Partner API on behalf of a seller who has already authorized you to call Amazon Marketplace Web Service (Amazon MWS). You specify a developer ID, an MWS auth token, and a seller ID. Taken together, these represent the Amazon MWS authorization that the seller previously granted you. The operation returns an LWA authorization code that can be exchanged for a refresh token and access token representing authorization to call the Selling Partner API on the seller's behalf. By using this API, sellers who have already authorized you for Amazon MWS do not need to re-authorize you for the Selling Partner API.

**Usage Plan:**

| Rate (requests per second) | Burst |
| ---- | ---- |
| 1 | 5 |

For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Query**|**sellingPartnerId**  <br>*required*|The seller ID of the seller for whom you are requesting Selling Partner API authorization. This must be the seller ID of the seller who authorized your application on the Marketplace Appstore.|string|
|**Query**|**developerId**  <br>*required*|Your developer ID. This must be one of the developer ID values that you provided when you registered your application in Developer Central.|string|
|**Query**|**mwsAuthToken**  <br>*required*|The MWS Auth Token that was generated when the seller authorized your application on the Marketplace Appstore.|string|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Success.  <br>**Headers** :   <br>`x-amzn-requestId` (string) : Unique request reference ID.|[GetAuthorizationCodeResponse](#getauthorizationcoderesponse)|

For error status codes, descriptions and schemas, see [Error responses and schemas](#error-responses-and-schemas).



<a name="error-responses-and-schemas"></a>
### Error Responses and Schemas
This table contains HTTP status codes and associated information for error responses.

|HTTP Code|Description|Schema|
|---|---|---|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers**:  <br>`x-amzn-RequestId` (string):Unique request reference ID.|[GetAuthorizationCodeResponse](#getauthorizationcoderesponse)|
|**403**|Indicates that access to the resource is forbidden. Possible reasons include Access Denied, Unauthorized, Expired Token, or Invalid Signature.  <br>**Headers**:  <br>`x-amzn-RequestId` (string):Unique request reference ID.|[GetAuthorizationCodeResponse](#getauthorizationcoderesponse)|
|**404**|The resource specified does not exist.  <br>**Headers**:  <br>`x-amzn-RequestId` (string):Unique request reference ID.|[GetAuthorizationCodeResponse](#getauthorizationcoderesponse)|
|**413**|The request size exceeded the maximum accepted size.  <br>**Headers**:  <br>`x-amzn-RequestId` (string):Unique request reference ID.|[GetAuthorizationCodeResponse](#getauthorizationcoderesponse)|
|**415**|The request payload is in an unsupported format.  <br>**Headers**:  <br>`x-amzn-RequestId` (string):Unique request reference ID.|[GetAuthorizationCodeResponse](#getauthorizationcoderesponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers**:  <br>`x-amzn-RequestId` (string):Unique request reference ID.|[GetAuthorizationCodeResponse](#getauthorizationcoderesponse)|
|**500**|An unexpected condition occurred that prevented the server from fulfilling the request.  <br>**Headers**:  <br>`x-amzn-RequestId` (string):Unique request reference ID.|[GetAuthorizationCodeResponse](#getauthorizationcoderesponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers**:  <br>`x-amzn-RequestId` (string):Unique request reference ID.|[GetAuthorizationCodeResponse](#getauthorizationcoderesponse)|


<a name="definitions"></a>
## Definitions

<a name="getauthorizationcoderesponse"></a>
### GetAuthorizationCodeResponse
The response schema for the GetAuthorizationCode operation.


|Name|Description|Schema|
|---|---|---|
|**payload**  <br>*optional*|A Login with Amazon (LWA) authorization code.|[AuthorizationCode](#authorizationcode)|
|**errors**  <br>*optional*|A list of error responses returned when a request is unsuccessful.|[ErrorList](#errorlist)|


<a name="authorizationcode"></a>
### AuthorizationCode
A Login with Amazon (LWA) authorization code.


|Name|Description|Schema|
|---|---|---|
|**authorizationCode**  <br>*optional*|A Login with Amazon (LWA) authorization code that can be exchanged for a refresh token and access token that authorize you to make calls to a Selling Partner API.|string|


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

