# Selling Partner API for Direct Fulfillment Transaction Status


<a name="overview"></a>
## Overview
The Selling Partner API for Direct Fulfillment Transaction Status provides programmatic access to a direct fulfillment vendor's transaction status.


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
[getTransactionStatus](#gettransactionstatus)<br>
<a name="paths"></a>
## Paths

<a name="gettransactionstatus"></a>
### GET /vendor/directFulfillment/transactions/v1/transactions/{transactionId}
**Operation: getTransactionStatus**

#### Description
Returns the status of the transaction indicated by the specified transactionId.

**Usage Plans:**

| Plan type | Rate (requests per second) | Burst |
| ---- | ---- | ---- |
|Default| 10 | 10 |
|Selling partner specific| Variable | Variable |

The x-amzn-RateLimit-Limit response header returns the usage plan rate limits that were applied to the requested operation. Rate limits for some selling partners will vary from the default rate and burst shown in the table above. For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**transactionId**  <br>*required*|Previously returned in the response to the POST request of a specific transaction.|string|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Success.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetTransactionResponse](#gettransactionresponse)|

For error status codes, descriptions and schemas, see [Error responses and schemas](#error-responses-and-schemas).



<a name="error-responses-and-schemas"></a>
### Error Responses and Schemas
This table contains HTTP status codes and associated information for error responses.

|HTTP Code|Description|Schema|
|---|---|---|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers**:  <br>`x-amzn-RateLimit-Limit` (string):Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string):Unique request reference identifier.|[GetTransactionResponse](#gettransactionresponse)|
|**401**|The request's Authorization header is not formatted correctly or does not contain a valid token.  <br>**Headers**:  <br>`x-amzn-RateLimit-Limit` (string):Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string):Unique request reference identifier.|[GetTransactionResponse](#gettransactionresponse)|
|**403**|Indicates that access to the resource is forbidden. Possible reasons include Access Denied, Unauthorized, Expired Token, or Invalid Signature.  <br>**Headers**:  <br>`x-amzn-RequestId` (string):Unique request reference identifier.|[GetTransactionResponse](#gettransactionresponse)|
|**404**|The resource specified does not exist.  <br>**Headers**:  <br>`x-amzn-RequestId` (string):Unique request reference identifier.|[GetTransactionResponse](#gettransactionresponse)|
|**415**|The request payload is in an unsupported format.  <br>**Headers**:  <br>`x-amzn-RateLimit-Limit` (string):Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string):Unique request reference identifier.|[GetTransactionResponse](#gettransactionresponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers**:  <br>`x-amzn-RateLimit-Limit` (string):Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string):Unique request reference identifier.|[GetTransactionResponse](#gettransactionresponse)|
|**500**|An unexpected condition occurred that prevented the server from fulfilling the request.  <br>**Headers**:  <br>`x-amzn-RateLimit-Limit` (string):Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string):Unique request reference identifier.|[GetTransactionResponse](#gettransactionresponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers**:  <br>`x-amzn-RateLimit-Limit` (string):Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string):Unique request reference identifier.|[GetTransactionResponse](#gettransactionresponse)|


<a name="definitions"></a>
## Definitions

<a name="gettransactionresponse"></a>
### GetTransactionResponse
The response schema for the getTransactionStatus operation.


|Name|Description|Schema|
|---|---|---|
|**payload**  <br>*optional*|The payload for the getTransactionStatus operation.|[TransactionStatus](#transactionstatus)|
|**errors**  <br>*optional*|A list of error responses returned when a request is unsuccessful.|[ErrorList](#errorlist)|


<a name="transactionstatus"></a>
### TransactionStatus
The payload for the getTransactionStatus operation.


|Name|Description|Schema|
|---|---|---|
|**transactionStatus**  <br>*optional*|The transaction status details.|[Transaction](#transaction)|


<a name="transaction"></a>
### Transaction
The transaction status details.


|Name|Description|Schema|
|---|---|---|
|**transactionId**  <br>*required*|The unique identifier sent in the 'transactionId' field in response to the post request of a specific transaction.|string|
|**status**  <br>*required*|Current processing status of the transaction.|enum ([Status](#status))|
|**errors**  <br>*optional*|Error code and message for the failed transaction. Only available when transaction status is 'Failure'.|[ErrorList](#errorlist)|


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


<a name="status"></a>
### Status
Current processing status of the transaction.

*Type* : enum


|Value|Description|
|---|---|
|**Failure**|Transaction has failed.|
|**Processing**|Transaction is in process.|
|**Success**|Transaction has completed successfully.|

