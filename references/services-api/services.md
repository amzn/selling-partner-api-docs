# Selling Partner API for Services


<a name="overview"></a>
## Overview
With the Services API, you can build applications that help service providers get and modify their service orders.


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
[getServiceJobByServiceJobId](#getservicejobbyservicejobid)<br>[cancelServiceJobByServiceJobId](#cancelservicejobbyservicejobid)<br>[completeServiceJobByServiceJobId](#completeservicejobbyservicejobid)<br>[getServiceJobs](#getservicejobs)<br>[addAppointmentForServiceJobByServiceJobId](#addappointmentforservicejobbyservicejobid)<br>[rescheduleAppointmentForServiceJobByServiceJobId](#rescheduleappointmentforservicejobbyservicejobid)<br>[assignAppointmentResources](#assignappointmentresources)<br>[setAppointmentFulfillmentData](#setappointmentfulfillmentdata)<br>[updateSchedule](#updateschedule)<br>[createReservation](#createreservation)<br>[updateReservation](#updatereservation)<br>[cancelReservation](#cancelreservation)<br>[createServiceDocumentUploadDestination](#createservicedocumentuploaddestination)<br>
<a name="paths"></a>
## Paths

<a name="getservicejobbyservicejobid"></a>
### GET /service/v1/serviceJobs/{serviceJobId}
**Operation: getServiceJobByServiceJobId**

#### Description
Gets service job details for the service job indicated by the service job identifier you specify.

**Usage Plan:**

| Rate (requests per second) | Burst |
| ---- | ---- |
| 20 | 40 |

For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**serviceJobId**  <br>*required*|A service job identifier.<br>**minLength** : 1<br>**maxLength** : 100|string|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Success response  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetServiceJobByServiceJobIdResponse](#getservicejobbyservicejobidresponse)|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetServiceJobByServiceJobIdResponse](#getservicejobbyservicejobidresponse)|
|**403**|Indicates that access to the resource is forbidden. Possible reasons include Access Denied, Unauthorized, Expired Token, or Invalid Signature.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetServiceJobByServiceJobIdResponse](#getservicejobbyservicejobidresponse)|
|**404**|The resource specified does not exist.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetServiceJobByServiceJobIdResponse](#getservicejobbyservicejobidresponse)|
|**413**|The request size exceeded the maximum accepted size.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetServiceJobByServiceJobIdResponse](#getservicejobbyservicejobidresponse)|
|**415**|The request payload is in an unsupported format.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetServiceJobByServiceJobIdResponse](#getservicejobbyservicejobidresponse)|
|**422**|Unprocessable Entity. Unable to process the contained instructions.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetServiceJobByServiceJobIdResponse](#getservicejobbyservicejobidresponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetServiceJobByServiceJobIdResponse](#getservicejobbyservicejobidresponse)|
|**500**|An unexpected condition occurred that prevented the server from fulfilling the request.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetServiceJobByServiceJobIdResponse](#getservicejobbyservicejobidresponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetServiceJobByServiceJobIdResponse](#getservicejobbyservicejobidresponse)|


<a name="cancelservicejobbyservicejobid"></a>
### PUT /service/v1/serviceJobs/{serviceJobId}/cancellations
**Operation: cancelServiceJobByServiceJobId**

#### Description
Cancels the service job indicated by the service job identifier you specify.

**Usage Plan:**

| Rate (requests per second) | Burst |
| ---- | ---- |
| 5 | 20 |

For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**serviceJobId**  <br>*required*|An Amazon defined service job identifier.<br>**minLength** : 1<br>**maxLength** : 100|string|
|**Query**|**cancellationReasonCode**  <br>*required*|A cancel reason code that specifies the reason for cancelling a service job.<br>**minLength** : 1<br>**maxLength** : 100|string|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Success response  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[CancelServiceJobByServiceJobIdResponse](#cancelservicejobbyservicejobidresponse)|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[CancelServiceJobByServiceJobIdResponse](#cancelservicejobbyservicejobidresponse)|
|**403**|Indicates that access to the resource is forbidden. Possible reasons include Access Denied, Unauthorized, Expired Token, or Invalid Signature.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[CancelServiceJobByServiceJobIdResponse](#cancelservicejobbyservicejobidresponse)|
|**404**|The resource specified does not exist.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[CancelServiceJobByServiceJobIdResponse](#cancelservicejobbyservicejobidresponse)|
|**413**|The request size exceeded the maximum accepted size.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[CancelServiceJobByServiceJobIdResponse](#cancelservicejobbyservicejobidresponse)|
|**415**|The request payload is in an unsupported format.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[CancelServiceJobByServiceJobIdResponse](#cancelservicejobbyservicejobidresponse)|
|**422**|Unprocessable Entity. Unable to process the contained instructions  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[CancelServiceJobByServiceJobIdResponse](#cancelservicejobbyservicejobidresponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[CancelServiceJobByServiceJobIdResponse](#cancelservicejobbyservicejobidresponse)|
|**500**|An unexpected condition occurred that prevented the server from fulfilling the request.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[CancelServiceJobByServiceJobIdResponse](#cancelservicejobbyservicejobidresponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[CancelServiceJobByServiceJobIdResponse](#cancelservicejobbyservicejobidresponse)|


<a name="completeservicejobbyservicejobid"></a>
### PUT /service/v1/serviceJobs/{serviceJobId}/completions
**Operation: completeServiceJobByServiceJobId**

#### Description
Completes the service job indicated by the service job identifier you specify.

**Usage Plan:**

| Rate (requests per second) | Burst |
| ---- | ---- |
| 5 | 20 |

For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**serviceJobId**  <br>*required*|An Amazon defined service job identifier.<br>**minLength** : 1<br>**maxLength** : 100|string|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Success response  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[CompleteServiceJobByServiceJobIdResponse](#completeservicejobbyservicejobidresponse)|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[CompleteServiceJobByServiceJobIdResponse](#completeservicejobbyservicejobidresponse)|
|**403**|Indicates that access to the resource is forbidden. Possible reasons include Access Denied, Unauthorized, Expired Token, or Invalid Signature.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[CompleteServiceJobByServiceJobIdResponse](#completeservicejobbyservicejobidresponse)|
|**404**|The resource specified does not exist.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[CompleteServiceJobByServiceJobIdResponse](#completeservicejobbyservicejobidresponse)|
|**413**|The request size exceeded the maximum accepted size.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[CompleteServiceJobByServiceJobIdResponse](#completeservicejobbyservicejobidresponse)|
|**415**|The request payload is in an unsupported format.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[CompleteServiceJobByServiceJobIdResponse](#completeservicejobbyservicejobidresponse)|
|**422**|Unprocessable Entity. Unable to process the contained instructions  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[CompleteServiceJobByServiceJobIdResponse](#completeservicejobbyservicejobidresponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[CompleteServiceJobByServiceJobIdResponse](#completeservicejobbyservicejobidresponse)|
|**500**|An unexpected condition occurred that prevented the server from fulfilling the request.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[CompleteServiceJobByServiceJobIdResponse](#completeservicejobbyservicejobidresponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[CompleteServiceJobByServiceJobIdResponse](#completeservicejobbyservicejobidresponse)|


<a name="getservicejobs"></a>
### GET /service/v1/serviceJobs
**Operation: getServiceJobs**

#### Description
Gets service job details for the specified filter query.

**Usage Plan:**

| Rate (requests per second) | Burst |
| ---- | ---- |
| 10 | 40 |

For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|Default|
|---|---|---|---|---|
|**Query**|**serviceOrderIds**  <br>*optional*|List of service order ids for the query you want to perform.Max values supported 20.  <br>**Min count** : 1<br>**Max count** : 20|< string > array|-|
|**Query**|**serviceJobStatus**  <br>*optional*|A list of one or more job status by which to filter the list of jobs.|< enum ([ServiceJobStatus](#servicejobstatus-subgroup-2)) > array|-|
|**Query**|**pageToken**  <br>*optional*|String returned in the response of your previous request.|string|-|
|**Query**|**pageSize**  <br>*optional*|A non-negative integer that indicates the maximum number of jobs to return in the list, Value must be 1 - 20. Default 20.<br>**Minimum** : 1<br>**Maximum** : 20|integer|`20`|
|**Query**|**sortField**  <br>*optional*|Sort fields on which you want to sort the output.|enum ([SortField](#sortfield))|-|
|**Query**|**sortOrder**  <br>*optional*|Sort order for the query you want to perform.|enum ([SortOrder](#sortorder))|-|
|**Query**|**createdAfter**  <br>*optional*|A date used for selecting jobs created after (or at) a specified time must be in ISO 8601 format. Required if LastUpdatedAfter is not specified.Specifying both CreatedAfter and LastUpdatedAfter returns an error.|string|-|
|**Query**|**createdBefore**  <br>*optional*|A date used for selecting jobs created before (or at) a specified time must be in ISO 8601 format.|string|-|
|**Query**|**lastUpdatedAfter**  <br>*optional*|A date used for selecting jobs updated after (or at) a specified time must be in ISO 8601 format. Required if createdAfter is not specified.Specifying both CreatedAfter and LastUpdatedAfter returns an error.|string|-|
|**Query**|**lastUpdatedBefore**  <br>*optional*|A date used for selecting jobs updated before (or at) a specified time must be in ISO 8601 format.|string|-|
|**Query**|**scheduleStartDate**  <br>*optional*|A date used for filtering jobs schedule after (or at) a specified time must be in ISO 8601 format. schedule end date should not be earlier than schedule start date.|string|-|
|**Query**|**scheduleEndDate**  <br>*optional*|A date used for filtering jobs schedule before (or at) a specified time must be in ISO 8601 format. schedule end date should not be earlier than schedule start date.|string|-|
|**Query**|**marketplaceIds**  <br>*required*|Used to select jobs that were placed in the specified marketplaces.<br>**Max count** : 1|< string > array|-|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Success response  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetServiceJobsResponse](#getservicejobsresponse)|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetServiceJobsResponse](#getservicejobsresponse)|
|**403**|Indicates that access to the resource is forbidden. Possible reasons include Access Denied, Unauthorized, Expired Token, or Invalid Signature.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetServiceJobsResponse](#getservicejobsresponse)|
|**404**|The resource specified does not exist.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetServiceJobsResponse](#getservicejobsresponse)|
|**413**|The request size exceeded the maximum accepted size.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetServiceJobsResponse](#getservicejobsresponse)|
|**415**|The request payload is in an unsupported format.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetServiceJobsResponse](#getservicejobsresponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetServiceJobsResponse](#getservicejobsresponse)|
|**500**|An unexpected condition occurred that prevented the server from fulfilling the request.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetServiceJobsResponse](#getservicejobsresponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetServiceJobsResponse](#getservicejobsresponse)|


<a name="addappointmentforservicejobbyservicejobid"></a>
### POST /service/v1/serviceJobs/{serviceJobId}/appointments
**Operation: addAppointmentForServiceJobByServiceJobId**

#### Description
Adds an appointment to the service job indicated by the service job identifier you specify.

**Usage Plan:**

| Rate (requests per second) | Burst |
| ---- | ---- |
| 5 | 20 |

For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**serviceJobId**  <br>*required*|An Amazon defined service job identifier.<br>**minLength** : 1<br>**maxLength** : 100|string|
|**Body**|**body**  <br>*required*|Add appointment operation input details.|[AddAppointmentRequest](#addappointmentrequest)|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Success response  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[SetAppointmentResponse](#setappointmentresponse)|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[SetAppointmentResponse](#setappointmentresponse)|
|**403**|Indicates that access to the resource is forbidden. Possible reasons include Access Denied, Unauthorized, Expired Token, or Invalid Signature.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[SetAppointmentResponse](#setappointmentresponse)|
|**404**|The resource specified does not exist.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[SetAppointmentResponse](#setappointmentresponse)|
|**413**|The request size exceeded the maximum accepted size.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[SetAppointmentResponse](#setappointmentresponse)|
|**415**|The request payload is in an unsupported format.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[SetAppointmentResponse](#setappointmentresponse)|
|**422**|Unprocessable Entity. Unable to process the contained instructions  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[SetAppointmentResponse](#setappointmentresponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[SetAppointmentResponse](#setappointmentresponse)|
|**500**|Encountered an unexpected condition which prevented the server from fulfilling the request.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[SetAppointmentResponse](#setappointmentresponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[SetAppointmentResponse](#setappointmentresponse)|


<a name="rescheduleappointmentforservicejobbyservicejobid"></a>
### POST /service/v1/serviceJobs/{serviceJobId}/appointments/{appointmentId}
**Operation: rescheduleAppointmentForServiceJobByServiceJobId**

#### Description
Reschedules an appointment for the service job indicated by the service job identifier you specify.

**Usage Plan:**

| Rate (requests per second) | Burst |
| ---- | ---- |
| 5 | 20 |

For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**serviceJobId**  <br>*required*|An Amazon defined service job identifier.<br>**minLength** : 1<br>**maxLength** : 100|string|
|**Path**|**appointmentId**  <br>*required*|An existing appointment identifier for the Service Job.<br>**minLength** : 1<br>**maxLength** : 100|string|
|**Body**|**body**  <br>*required*|Reschedule appointment operation input details.|[RescheduleAppointmentRequest](#rescheduleappointmentrequest)|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Success response  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[SetAppointmentResponse](#setappointmentresponse)|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[SetAppointmentResponse](#setappointmentresponse)|
|**403**|Indicates that access to the resource is forbidden. Possible reasons include Access Denied, Unauthorized, Expired Token, or Invalid Signature.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[SetAppointmentResponse](#setappointmentresponse)|
|**404**|The resource specified does not exist.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[SetAppointmentResponse](#setappointmentresponse)|
|**413**|The request size exceeded the maximum accepted size.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[SetAppointmentResponse](#setappointmentresponse)|
|**415**|The request payload is in an unsupported format.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[SetAppointmentResponse](#setappointmentresponse)|
|**422**|Unprocessable Entity. Unable to process the contained instructions  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[SetAppointmentResponse](#setappointmentresponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[SetAppointmentResponse](#setappointmentresponse)|
|**500**|Encountered an unexpected condition which prevented the server from fulfilling the request.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[SetAppointmentResponse](#setappointmentresponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[SetAppointmentResponse](#setappointmentresponse)|


<a name="assignappointmentresources"></a>
### PUT /service/v1/serviceJobs/{serviceJobId}/appointments/{appointmentId}/resources
**Operation: assignAppointmentResources**

#### Description
Assigns new resource(s) or overwrite/update the existing one(s) to a service job appointment.

**Usage Plan:**

| Rate (requests per second) | Burst |
| ---- | ---- |
| 1 | 2 |

For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**serviceJobId**  <br>*required*|An Amazon-defined service job identifier. Get this value by calling getServiceJobs operation of the services API.<br>**minLength** : 1<br>**maxLength** : 100|string|
|**Path**|**appointmentId**  <br>*required*|An Amazon-defined identifier of active service job appointment.<br>**minLength** : 1<br>**maxLength** : 100|string|
|**Body**|**body**  <br>*required*|Request schema for AssignAppointmentResources operation.|[AssignAppointmentResourcesRequest](#assignappointmentresourcesrequest)|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Success response  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[AssignAppointmentResourcesResponse](#assignappointmentresourcesresponse)|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[AssignAppointmentResourcesResponse](#assignappointmentresourcesresponse)|
|**403**|Indicates that access to the resource is forbidden. Possible reasons include Access Denied, Unauthorized, Expired Token, or Invalid Signature.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[AssignAppointmentResourcesResponse](#assignappointmentresourcesresponse)|
|**404**|The resource specified does not exist.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[AssignAppointmentResourcesResponse](#assignappointmentresourcesresponse)|
|**413**|The request size exceeded the maximum accepted size.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[AssignAppointmentResourcesResponse](#assignappointmentresourcesresponse)|
|**415**|The request payload is in an unsupported format.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[AssignAppointmentResourcesResponse](#assignappointmentresourcesresponse)|
|**422**|Unprocessable Entity. Unable to process the contained instructions  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[AssignAppointmentResourcesResponse](#assignappointmentresourcesresponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[AssignAppointmentResourcesResponse](#assignappointmentresourcesresponse)|
|**500**|An unexpected condition occurred that prevented the server from fulfilling the request.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[AssignAppointmentResourcesResponse](#assignappointmentresourcesresponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[AssignAppointmentResourcesResponse](#assignappointmentresourcesresponse)|


<a name="setappointmentfulfillmentdata"></a>
### PUT /service/v1/serviceJobs/{serviceJobId}/appointments/{appointmentId}/fulfillment
**Operation: setAppointmentFulfillmentData**

#### Description
Captures the appointment fulfillment data.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**serviceJobId**  <br>*required*|An Amazon-defined service job identifier. Get this value by calling getServiceJobs operation of the services API.<br>**minLength** : 1<br>**maxLength** : 100|string|
|**Path**|**appointmentId**  <br>*required*|An Amazon-defined identifier of active service job appointment.<br>**minLength** : 1<br>**maxLength** : 100|string|
|**Body**|**body**  <br>*required*|Appointment fulfillment data collection details.|[SetAppointmentFulfillmentDataRequest](#setappointmentfulfillmentdatarequest)|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**204**|Success response  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference id.|string|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[ErrorList](#errorlist)|
|**403**|403 can be caused for reasons like Access Denied, Unauthorized, Expired Token, Invalid Signature or Resource Not Found.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference id.|[ErrorList](#errorlist)|
|**404**|The resource specified does not exist.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference id.|[ErrorList](#errorlist)|
|**413**|The request size exceeded the maximum accepted size.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference id.|[ErrorList](#errorlist)|
|**415**|The entity of the request is in a format not supported by the requested resource.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference id.|[ErrorList](#errorlist)|
|**422**|Unprocessable Entity. Unable to process the contained instructions  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference id.|[ErrorList](#errorlist)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference id.|[ErrorList](#errorlist)|
|**500**|Encountered an unexpected condition which prevented the server from fulfilling the request.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference id.|[ErrorList](#errorlist)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference id.|[ErrorList](#errorlist)|


<a name="updateschedule"></a>
### PUT /service/v1/serviceResources/{resourceId}/schedules
**Operation: updateSchedule**

#### Description
Update a schedule


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**resourceId**  <br>*required*|Resource (store) Identifier<br>**minLength** : 1<br>**maxLength** : 100|string|
|**Body**|**body**  <br>*required*|Schedule details|[UpdateScheduleRequest](#updateschedulerequest)|
|**Query**|**marketplaceIds**  <br>*required*|An identifier for the marketplace in which the resource operates<br>**Max count** : 1|< string > array|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Success response  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[UpdateScheduleResponse](#updatescheduleresponse)|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[UpdateScheduleResponse](#updatescheduleresponse)|
|**403**|Indicates that access to the resource is forbidden. Possible reasons include Access Denied, Unauthorized, Expired Token, or Invalid Signature.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[UpdateScheduleResponse](#updatescheduleresponse)|
|**404**|The resource specified does not exist.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[UpdateScheduleResponse](#updatescheduleresponse)|
|**413**|The request size exceeded the maximum accepted size.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[UpdateScheduleResponse](#updatescheduleresponse)|
|**415**|The request payload is in an unsupported format.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[UpdateScheduleResponse](#updatescheduleresponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[UpdateScheduleResponse](#updatescheduleresponse)|
|**500**|Encountered an unexpected condition which prevented the server from fulfilling the request.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[UpdateScheduleResponse](#updatescheduleresponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[UpdateScheduleResponse](#updatescheduleresponse)|


<a name="createreservation"></a>
### POST /service/v1/reservation
**Operation: createReservation**

#### Description
Create a reservation


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Body**|**body**  <br>*required*|Reservation details|[CreateReservationRequest](#createreservationrequest)|
|**Query**|**marketplaceIds**  <br>*required*|An identifier for the marketplace in which the resource operates<br>**Max count** : 1|< string > array|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Success response  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[CreateReservationResponse](#createreservationresponse)|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[CreateReservationResponse](#createreservationresponse)|
|**403**|Indicates that access to the resource is forbidden. Possible reasons include Access Denied, Unauthorized, Expired Token, or Invalid Signature.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[CreateReservationResponse](#createreservationresponse)|
|**404**|The resource specified does not exist.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[CreateReservationResponse](#createreservationresponse)|
|**413**|The request size exceeded the maximum accepted size.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[CreateReservationResponse](#createreservationresponse)|
|**415**|The request payload is in an unsupported format.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[CreateReservationResponse](#createreservationresponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[CreateReservationResponse](#createreservationresponse)|
|**500**|Encountered an unexpected condition which prevented the server from fulfilling the request.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[CreateReservationResponse](#createreservationresponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[CreateReservationResponse](#createreservationresponse)|


<a name="updatereservation"></a>
### PUT /service/v1/reservation/{reservationId}
**Operation: updateReservation**

#### Description
Update a reservation


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**reservationId**  <br>*required*|Reservation Identifier<br>**minLength** : 1<br>**maxLength** : 100|string|
|**Body**|**body**  <br>*required*|Reservation details|[UpdateReservationRequest](#updatereservationrequest)|
|**Query**|**marketplaceIds**  <br>*required*|An identifier for the marketplace in which the resource operates<br>**Max count** : 1|< string > array|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Success response  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[UpdateReservationResponse](#updatereservationresponse)|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[UpdateReservationResponse](#updatereservationresponse)|
|**403**|Indicates that access to the resource is forbidden. Possible reasons include Access Denied, Unauthorized, Expired Token, or Invalid Signature.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[UpdateReservationResponse](#updatereservationresponse)|
|**404**|The reservation specified does not exist.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[UpdateReservationResponse](#updatereservationresponse)|
|**413**|The request size exceeded the maximum accepted size.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[UpdateReservationResponse](#updatereservationresponse)|
|**415**|The request payload is in an unsupported format.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[UpdateReservationResponse](#updatereservationresponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[UpdateReservationResponse](#updatereservationresponse)|
|**500**|Encountered an unexpected condition which prevented the server from fulfilling the request.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[UpdateReservationResponse](#updatereservationresponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[UpdateReservationResponse](#updatereservationresponse)|


<a name="cancelreservation"></a>
### DELETE /service/v1/reservation/{reservationId}
**Operation: cancelReservation**

#### Description
Cancel a reservation


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**reservationId**  <br>*required*|Reservation Identifier<br>**minLength** : 1<br>**maxLength** : 100|string|
|**Query**|**marketplaceIds**  <br>*required*|An identifier for the marketplace in which the resource operates<br>**Max count** : 1|< string > array|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**204**|Success response  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference id.|[CancelReservationResponse](#cancelreservationresponse)|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference id.|[CancelReservationResponse](#cancelreservationresponse)|
|**403**|403 can be caused for reasons like Access Denied, Unauthorized, Expired Token, Invalid Signature or Resource Not Found.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference id.|[CancelReservationResponse](#cancelreservationresponse)|
|**404**|The reservation specified does not exist.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference id.|[CancelReservationResponse](#cancelreservationresponse)|
|**413**|The request size exceeded the maximum accepted size.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference id.|[CancelReservationResponse](#cancelreservationresponse)|
|**415**|The entity of the request is in a format not supported by the requested resource.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference id.|[CancelReservationResponse](#cancelreservationresponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference id.|[CancelReservationResponse](#cancelreservationresponse)|
|**500**|Encountered an unexpected condition which prevented the server from fulfilling the request.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference id.|[CancelReservationResponse](#cancelreservationresponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference id.|[CancelReservationResponse](#cancelreservationresponse)|


<a name="createservicedocumentuploaddestination"></a>
### POST /service/v1/documents
**Operation: createServiceDocumentUploadDestination**

#### Description
Creates an upload destination.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Body**|**body**  <br>*required*|upload document operation input details.|[ServiceUploadDocument](#serviceuploaddocument)|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Successfully created an upload destination for the given resource.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestId` (string) : Unique request reference identifier.|[CreateServiceDocumentUploadDestination](#createservicedocumentuploaddestination)|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference id.|[CreateServiceDocumentUploadDestination](#createservicedocumentuploaddestination)|
|**403**|Indicates that access to the resource is forbidden. Possible reasons include Access Denied, Unauthorized, Expired Token, or Invalid Signature.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[CreateServiceDocumentUploadDestination](#createservicedocumentuploaddestination)|
|**404**|The resource specified does not exist.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference id.|[CreateServiceDocumentUploadDestination](#createservicedocumentuploaddestination)|
|**413**|The request size exceeded the maximum accepted size.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference id.|[CreateServiceDocumentUploadDestination](#createservicedocumentuploaddestination)|
|**415**|The request's Content-Type header is invalid.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference identifier.|[CreateServiceDocumentUploadDestination](#createservicedocumentuploaddestination)|
|**422**|Unprocessable Entity. Unable to process the contained instructions  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[CreateServiceDocumentUploadDestination](#createservicedocumentuploaddestination)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-requestid` (string) : Unique request reference ID.|[CreateServiceDocumentUploadDestination](#createservicedocumentuploaddestination)|
|**500**|An unexpected condition occurred that prevented the server from fulfilling the request.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[CreateServiceDocumentUploadDestination](#createservicedocumentuploaddestination)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference id.|[CreateServiceDocumentUploadDestination](#createservicedocumentuploaddestination)|


<a name="definitions"></a>
## Definitions

<a name="getservicejobbyservicejobidresponse"></a>
### GetServiceJobByServiceJobIdResponse
The response schema for the GetServiceJobByServiceJobId operation.


|Name|Description|Schema|
|---|---|---|
|**payload**  <br>*optional*|The payload for the GetServiceJobByServiceJobId operation.|[ServiceJob](#servicejob)|
|**errors**  <br>*optional*|An unexpected condition occurred during the GetServiceJobByServiceJobId operation.|[ErrorList](#errorlist)|


<a name="cancelservicejobbyservicejobidresponse"></a>
### CancelServiceJobByServiceJobIdResponse
Response schema for CancelServiceJobByServiceJobId operation.


|Name|Description|Schema|
|---|---|---|
|**errors**  <br>*optional*|Encountered errors for the CancelServiceJobByServiceJobId operation.|[ErrorList](#errorlist)|


<a name="completeservicejobbyservicejobidresponse"></a>
### CompleteServiceJobByServiceJobIdResponse
Response schema for CompleteServiceJobByServiceJobId operation.


|Name|Description|Schema|
|---|---|---|
|**errors**  <br>*optional*|Encountered errors for the CompleteServiceJobByServiceJobId operation.|[ErrorList](#errorlist)|


<a name="getservicejobsresponse"></a>
### GetServiceJobsResponse
Response schema for GetJobs operation.


|Name|Description|Schema|
|---|---|---|
|**payload**  <br>*optional*|The payload for the GetJobs operation.|[JobListing](#joblisting)|
|**errors**  <br>*optional*|An unexpected condition occurred during the GetServiceJobs operation.|[ErrorList](#errorlist)|


<a name="setappointmentresponse"></a>
### SetAppointmentResponse
Response schema for add or reschedule appointment operation.


|Name|Description|Schema|
|---|---|---|
|**appointmentId**  <br>*optional*|New appointment id generated during add or reschedule appointment operation.|[AppointmentId](#appointmentid)|
|**warnings**  <br>*optional*|Warnings generated during add or reschedule appointment operation.|[WarningList](#warninglist)|
|**errors**  <br>*optional*|Errors occurred during during add or reschedule appointment operation.|[ErrorList](#errorlist)|


<a name="assignappointmentresourcesresponse"></a>
### AssignAppointmentResourcesResponse
Response schema for AssignAppointmentResources operation.


|Name|Description|Schema|
|---|---|---|
|**payload**  <br>*optional*|The payload for the Assign Appointment Resource operation.|[payload](#assignappointmentresourcesresponse-payload)|
|**errors**  <br>*optional*|Errors occurred during during assign appointment resources operation.|[ErrorList](#errorlist)|

<a name="assignappointmentresourcesresponse-payload"></a>
**payload**

|Name|Description|Schema|
|---|---|---|
|**warnings**  <br>*optional*|Warnings generated during assign appointment resources operation.|[WarningList](#warninglist)|


<a name="assignappointmentresourcesrequest"></a>
### AssignAppointmentResourcesRequest
Request schema for AssignAppointmentResources operation.


|Name|Description|Schema|
|---|---|---|
|**resources**  <br>*required*|List of resource objects to be assigned.|[AppointmentResources](#appointmentresources)|


<a name="joblisting"></a>
### JobListing
The payload for the GetJobs operation.


|Name|Description|Schema|
|---|---|---|
|**totalResultSize**  <br>*optional*|Total result size of the query result.|integer|
|**nextPageToken**  <br>*optional*|A generated string used to pass information to your next request. If nextPageToken is returned, pass the value of nextPageToken to the pageToken to get next results.|string|
|**previousPageToken**  <br>*optional*|A generated string used to pass information to your next request. If previousPageToken is returned, pass the value of previousPageToken to the pageToken to get previous page results.|string|
|**jobs**  <br>*optional*|List of job details for the given input.|< [ServiceJob](#servicejob) > array|


<a name="servicejob"></a>
### ServiceJob
The job details of a service.


|Name|Description|Schema|
|---|---|---|
|**createTime**  <br>*optional*|The date and time of the creation of the job, in ISO 8601 format.|string (date-time)|
|**serviceJobId**  <br>*optional*|The service job identifier.|[ServiceJobId](#servicejobid)|
|**serviceJobStatus**  <br>*optional*|The status of the service job.|enum ([ServiceJobStatus](#servicejobstatus-subgroup-1))|
|**scopeOfWork**  <br>*optional*|The scope of work for the order.|[ScopeOfWork](#scopeofwork)|
|**seller**  <br>*optional*|Information about the seller of the service job.|[Seller](#seller)|
|**serviceJobProvider**  <br>*optional*|Information about the service job provider.|[ServiceJobProvider](#servicejobprovider)|
|**preferredAppointmentTimes**  <br>*optional*|A list of appointment windows preferred by the buyer. Included only if the buyer selected appointment windows when creating the order.|< [AppointmentTime](#appointmenttime) > array|
|**appointments**  <br>*optional*|A list of appointments.|< [Appointment](#appointment) > array|
|**serviceOrderId**  <br>*optional*|The Amazon-defined identifier for an order placed by the buyer, in 3-7-7 format.|[OrderId](#orderid)|
|**marketplaceId**  <br>*optional*|The marketplace identifier.  <br>**Pattern** : `"^[A-Z0-9]<li>$"`</li>|string|
|**buyer**  <br>*optional*|Information about the buyer.|[Buyer](#buyer)|
|**associatedItems**  <br>*optional*|A list of items associated with the service job.|< [AssociatedItem](#associateditem) > array|
|**serviceLocation**  <br>*optional*|Information about the location of the service job.|[ServiceLocation](#servicelocation)|


<a name="servicejobid"></a>
### ServiceJobId
Amazon identifier for the service job.

*Type* : string

**minLength** : 1  
**maxLength** : 100  

<a name="orderid"></a>
### OrderId
The Amazon-defined identifier for an order placed by the buyer, in 3-7-7 format.

*Type* : string

**minLength** : 5  
**maxLength** : 20  

<a name="scopeofwork"></a>
### ScopeOfWork
The scope of work for the order.


|Name|Description|Schema|
|---|---|---|
|**asin**  <br>*optional*|The Amazon Standard Identification Number (ASIN) of the service job.|string|
|**title**  <br>*optional*|The title of the service job.|string|
|**quantity**  <br>*optional*|The number of service jobs.|integer|
|**requiredSkills**  <br>*optional*|A list of skills required to perform the job.|< string > array|


<a name="seller"></a>
### Seller
Information about the seller of the service job.


|Name|Description|Schema|
|---|---|---|
|**sellerId**  <br>*optional*|The identifier of the seller of the service job.  <br>**Pattern** : `"^[A-Z0-9]<li>$"`</li>|string|


<a name="servicejobprovider"></a>
### ServiceJobProvider
Information about the service job provider.


|Name|Description|Schema|
|---|---|---|
|**serviceJobProviderId**  <br>*optional*|The identifier of the service job provider.  <br>**Pattern** : `"^[A-Z0-9]<li>$"`</li>|string|


<a name="buyer"></a>
### Buyer
Information about the buyer.


|Name|Description|Schema|
|---|---|---|
|**buyerId**  <br>*optional*|The identifier of the buyer.  <br>**Pattern** : `"^[A-Z0-9]<li>$"`</li>|string|
|**name**  <br>*optional*|The name of the buyer.|string|
|**phone**  <br>*optional*|The phone number of the buyer.|string|
|**isPrimeMember**  <br>*optional*|When true, the service is for an Amazon Prime buyer.|boolean|


<a name="appointmenttime"></a>
### AppointmentTime
The time of the appointment window.


|Name|Description|Schema|
|---|---|---|
|**startTime**  <br>*required*|The date and time of the start of the appointment window, in ISO 8601 format.|string (date-time)|
|**durationInMinutes**  <br>*required*|The duration of the appointment window, in minutes.  <br>**Minimum value** : `1`|integer|


<a name="appointmentid"></a>
### AppointmentId
The appointment identifier.

*Type* : string

**minLength** : 5  
**maxLength** : 100  

<a name="appointment"></a>
### Appointment
The details of an appointment.


|Name|Description|Schema|
|---|---|---|
|**appointmentId**  <br>*optional*|The appointment identifier.|[AppointmentId](#appointmentid)|
|**appointmentStatus**  <br>*optional*|The status of the appointment.|enum ([AppointmentStatus](#appointmentstatus))|
|**appointmentTime**  <br>*optional*|The time of the appointment window.|[AppointmentTime](#appointmenttime)|
|**assignedTechnicians**  <br>*optional*|A list of technicians assigned to the service job.|< [Technician](#technician) > array|
|**rescheduledAppointmentId**  <br>*optional*|The identifier of a rescheduled appointment.|[AppointmentId](#appointmentid)|
|**poa**  <br>*optional*|Proof of Appointment (POA) details.|[Poa](#poa)|


<a name="technician"></a>
### Technician
A technician who is assigned to perform the service job in part or in full.


|Name|Description|Schema|
|---|---|---|
|**technicianId**  <br>*optional*|The technician identifier.<br>**minLength** : 1<br>**maxLength** : 50|string|
|**name**  <br>*optional*|The name of the technician.|string|


<a name="poa"></a>
### Poa
Proof of Appointment (POA) details.


|Name|Description|Schema|
|---|---|---|
|**appointmentTime**  <br>*optional*|The time of the appointment window.|[AppointmentTime](#appointmenttime)|
|**technicians**  <br>*optional*|A list of technicians.|< [Technician](#technician) > array|
|**uploadingTechnician**  <br>*optional*|The identifier of the technician who uploaded the POA.  <br>**Pattern** : `"^[A-Z0-9]<li>$"`</li>|string|
|**uploadTime**  <br>*optional*|The date and time when the POA was uploaded, in ISO 8601 format.|string (date-time)|
|**poaType**  <br>*optional*|The type of POA uploaded.|enum ([PoaType](#poatype))|


<a name="associateditem"></a>
### AssociatedItem
Information about an item associated with the service job.


|Name|Description|Schema|
|---|---|---|
|**asin**  <br>*optional*|The Amazon Standard Identification Number (ASIN) of the item.|string|
|**title**  <br>*optional*|The title of the item.|string|
|**quantity**  <br>*optional*|The total number of items included in the order.|integer|
|**orderId**  <br>*optional*|The Amazon-defined identifier for an order placed by the buyer, in 3-7-7 format.|[OrderId](#orderid)|
|**itemStatus**  <br>*optional*|The status of the item.|enum ([ItemStatus](#itemstatus))|
|**brandName**  <br>*optional*|The brand name of the item.|string|
|**itemDelivery**  <br>*optional*|Delivery information for the item.|[ItemDelivery](#itemdelivery)|


<a name="itemdelivery"></a>
### ItemDelivery
Delivery information for the item.


|Name|Description|Schema|
|---|---|---|
|**estimatedDeliveryDate**  <br>*optional*|The date and time of the latest Estimated Delivery Date (EDD) of all the items with an EDD. In ISO 8601 format.|string (date-time)|
|**itemDeliveryPromise**  <br>*optional*|Promised delivery information for the item.|[ItemDeliveryPromise](#itemdeliverypromise)|


<a name="itemdeliverypromise"></a>
### ItemDeliveryPromise
Promised delivery information for the item.


|Name|Description|Schema|
|---|---|---|
|**startTime**  <br>*optional*|The date and time of the start of the promised delivery window, in ISO 8601 format.|string (date-time)|
|**endTime**  <br>*optional*|The date and time of the end of the promised delivery window, in ISO 8601 format.|string (date-time)|


<a name="servicelocation"></a>
### ServiceLocation
Information about the location of the service job.


|Name|Description|Schema|
|---|---|---|
|**serviceLocationType**  <br>*optional*|The location of the service job.|enum ([ServiceLocationType](#servicelocationtype))|
|**address**  <br>*optional*|The shipping address for the service job.|[Address](#address)|


<a name="address"></a>
### Address
The shipping address for the service job.


|Name|Description|Schema|
|---|---|---|
|**name**  <br>*required*|The name of the person, business, or institution.|string|
|**addressLine1**  <br>*required*|The first line of the address.|string|
|**addressLine2**  <br>*optional*|Additional address information, if required.|string|
|**addressLine3**  <br>*optional*|Additional address information, if required.|string|
|**city**  <br>*optional*|The city.|string|
|**county**  <br>*optional*|The county.|string|
|**district**  <br>*optional*|The district.|string|
|**stateOrRegion**  <br>*optional*|The state or region.|string|
|**postalCode**  <br>*optional*|The postal code. This can contain letters, digits, spaces, and/or punctuation.|string|
|**countryCode**  <br>*optional*|The two digit country code, in ISO 3166-1 alpha-2 format.|string|
|**phone**  <br>*optional*|The phone number.|string|


<a name="addappointmentrequest"></a>
### AddAppointmentRequest
Input for add appointment operation.


|Name|Description|Schema|
|---|---|---|
|**appointmentTime**  <br>*required*|Input appointment time details.|[AppointmentTimeInput](#appointmenttimeinput)|


<a name="rescheduleappointmentrequest"></a>
### RescheduleAppointmentRequest
Input for rescheduled appointment operation.


|Name|Description|Schema|
|---|---|---|
|**appointmentTime**  <br>*required*|Input appointment time details.|[AppointmentTimeInput](#appointmenttimeinput)|
|**rescheduleReasonCode**  <br>*required*|Input appointment reschedule reason.|[RescheduleReasonCode](#reschedulereasoncode)|


<a name="appointmenttimeinput"></a>
### AppointmentTimeInput
The input appointment time details.


|Name|Description|Schema|
|---|---|---|
|**startTime**  <br>*required*|The date, time in UTC for the start time of an appointment in ISO 8601 format.|string (date-time)|
|**durationInMinutes**  <br>*optional*|The duration of an appointment in minutes.|integer|


<a name="reschedulereasoncode"></a>
### RescheduleReasonCode
Appointment reschedule reason code.

*Type* : string


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
|**errorLevel**  <br>*optional*|The type of error.|enum ([ErrorLevel](#errorlevel))|


<a name="warninglist"></a>
### WarningList
A list of warnings returned in the sucessful execution response of an API request.

*Type* : < [Warning](#warning) > array


<a name="warning"></a>
### Warning
Warning returned when the request is successful but execution have some important callouts on basis of which API clients should take defined actions.


|Name|Description|Schema|
|---|---|---|
|**code**  <br>*required*|An warning code that identifies the type of warning that occurred.|string|
|**message**  <br>*required*|A message that describes the warning condition in a human-readable form.|string|
|**details**  <br>*optional*|Additional details that can help the caller understand or address the warning.|string|


<a name="updatescheduleresponse"></a>
### UpdateScheduleResponse
Response schema for UpdateSchedule operation.


|Name|Description|Schema|
|---|---|---|
|**payload**  <br>*optional*|Contains the UpdateScheduleRecords for which the error/warning has occurred.|< [UpdateScheduleRecord](#updateschedulerecord) > array|
|**errors**  <br>*optional*|Errors encountered, if any.|[ErrorList](#errorlist)|


<a name="setappointmentfulfillmentdatarequest"></a>
### SetAppointmentFulfillmentDataRequest
Input for set appointment fulfillment data operation.


|Name|Description|Schema|
|---|---|---|
|**fulfillmentTime**  <br>*optional*|Input appointment time details.|[FulfillmentTime](#fulfillmenttime)|
|**appointmentResources**  <br>*optional*|Resources involved in appointment fulfillment.|[AppointmentResources](#appointmentresources)|
|**fulfillmentDocuments**  <br>*optional*|Documents specific to appointment fulfillment.|[FulfillmentDocuments](#fulfillmentdocuments)|


<a name="fulfillmenttime"></a>
### FulfillmentTime
Input for fulfillment time details


|Name|Description|Schema|
|---|---|---|
|**startTime**  <br>*optional*|The date, time in UTC of the fulfillment start time in ISO 8601 format.|string (date-time)|
|**endTime**  <br>*optional*|The date, time in UTC of the fulfillment end time in ISO 8601 format.|string (date-time)|


<a name="fulfillmentdocuments"></a>
### FulfillmentDocuments
List of documents captured during service appointment fulfillment.

*Type* : < [FulfillmentDocument](#fulfillmentdocument) > array


<a name="fulfillmentdocument"></a>
### FulfillmentDocument
Document that captured during service appointment fulfillment that portrays proof of completion


|Name|Description|Schema|
|---|---|---|
|**uploadDestinationId**  <br>*optional*|The identifier of the upload destination. Get this value by calling the createServiceDocumentUploadDestination operation of the services API.|string|
|**contentSha256**  <br>*optional*|Sha256 hash of the file content. This value is used to determine if the file has been corrupted or tampered with during transit.|string|


<a name="appointmentresources"></a>
### AppointmentResources
List of resources that performs or performed job appointment fulfillment.

*Type* : < [AppointmentResource](#appointmentresource) > array


<a name="appointmentresource"></a>
### AppointmentResource
The resource that performs or performed appointment fulfillment.


|Name|Description|Schema|
|---|---|---|
|**resourceId**  <br>*optional*|The resource identifier.|string|


<a name="createreservationresponse"></a>
### CreateReservationResponse
Response schema for CreateReservation operation.


|Name|Description|Schema|
|---|---|---|
|**payload**  <br>*optional*|CreateReservationRecord contains only the new reservationId if the operation was successful. Otherwise it would contain the Reservation entity with warnings/errors.|[CreateReservationRecord](#createreservationrecord)|
|**errors**  <br>*optional*|Errors encountered, if any.|[ErrorList](#errorlist)|


<a name="updatereservationresponse"></a>
### UpdateReservationResponse
Response schema for the UpdateReservation operation.


|Name|Description|Schema|
|---|---|---|
|**payload**  <br>*optional*|UpdateReservationRecord contains only the new reservationId if the operation was successful. Otherwise it would contain the Reservation entity with warnings/errors.|[UpdateReservationRecord](#updatereservationrecord)|
|**errors**  <br>*optional*|Errors encountered, if any.|[ErrorList](#errorlist)|


<a name="cancelreservationresponse"></a>
### CancelReservationResponse
Response schema for CancelReservation operation.


|Name|Description|Schema|
|---|---|---|
|**errors**  <br>*optional*|Errors encountered, if any|[ErrorList](#errorlist)|


<a name="dayofweek"></a>
### DayOfWeek
The day of the week.

*Type* : enum


|Value|Description|
|---|---|
|**MONDAY**|Monday|
|**TUESDAY**|Tuesday|
|**WEDNESDAY**|Wednesday|
|**THURSDAY**|Thursday|
|**FRIDAY**|Friday|
|**SATURDAY**|Saturday|
|**SUNDAY**|Sunday|


<a name="recurrence"></a>
### Recurrence
Repeated occurrence of an event in a time range.


|Name|Description|Schema|
|---|---|---|
|**endTime**  <br>*required*|End time of the recurrence.|string (date-time)|
|**daysOfWeek**  <br>*optional*|Days of the week when recurrence is valid. If the schedule is valid every Monday, input will contain a single item in the list - "MONDAY".|< [DayOfWeek](#dayofweek) > array|
|**daysOfMonth**  <br>*optional*|Days of the month when recurrence is valid.|< integer > array|


<a name="availabilityrecord"></a>
### AvailabilityRecord
AvailabilityRecord to represent the capacity of a resource over a time range.


|Name|Description|Schema|
|---|---|---|
|**startTime**  <br>*required*|Denotes the time from when the resource is available in a day, ISO-8601 format is followed.|string (date-time)|
|**endTime**  <br>*required*|Denotes the time till when the resource is available in a day, ISO-8601 format is followed.|string (date-time)|
|**recurrence**  <br>*optional*|Recurrence object containing the recurrence pattern of schedule.|[Recurrence](#recurrence)|
|**capacity**  <br>*optional*|Signifies the capacity of a resource which is available.  <br>**Minimum value** : `1`|integer|


<a name="availabilityrecords"></a>
### AvailabilityRecords
List of AvailabilityRecords to represent the capacity of a resource over a time range.

*Type* : < [AvailabilityRecord](#availabilityrecord) > array


<a name="reservation"></a>
### Reservation
Reservation object reduces the capacity of a resource.


|Name|Description|Schema|
|---|---|---|
|**reservationId**  <br>*optional*|Unique identifier for a reservation. If present, we treat it as an update reservation request and update the corresponding reservation. Otherwise, it's a new create reservation request.|string|
|**type**  <br>*required*|Type of reservation.|enum ([Type](#type))|
|**availability**  <br>*required*|AvailabilityRecord to represent the capacity of a resource over a time range.|[AvailabilityRecord](#availabilityrecord)|


<a name="reservations"></a>
### Reservations
List of reservations.

*Type* : < [Reservation](#reservation) > array


<a name="updateschedulerecord"></a>
### UpdateScheduleRecord
UpdateScheduleRecord entity contains the AvailabilityRecord if there is an error/warning while performing the requested operation on it.


|Name|Description|Schema|
|---|---|---|
|**availability**  <br>*optional*|Availability record if the operation failed.|[AvailabilityRecord](#availabilityrecord)|
|**warnings**  <br>*optional*|Warnings encountered, if any.|[WarningList](#warninglist)|
|**errors**  <br>*optional*|Errors encountered, if any.|[ErrorList](#errorlist)|


<a name="createreservationrecord"></a>
### CreateReservationRecord
CreateReservationRecord entity contains the Reservation if there is an error/warning while performing the requested operation on it, otherwise it will contain the new reservationId.


|Name|Description|Schema|
|---|---|---|
|**reservation**  <br>*optional*|Reservation record if the operation failed. It will only contain the new reservationId if the operation is successful.|[Reservation](#reservation)|
|**warnings**  <br>*optional*|Warnings encountered, if any.|[WarningList](#warninglist)|
|**errors**  <br>*optional*|Errors encountered, if any.|[ErrorList](#errorlist)|


<a name="updatereservationrecord"></a>
### UpdateReservationRecord
UpdateReservationRecord entity contains the Reservation if there is an error/warning while performing the requested operation on it, otherwise it will contain the new reservationId.


|Name|Description|Schema|
|---|---|---|
|**reservation**  <br>*optional*|Reservation record if the operation failed. It will only contain the new reservationId if the operation is successful.|[Reservation](#reservation)|
|**warnings**  <br>*optional*|Warnings encountered, if any.|[WarningList](#warninglist)|
|**errors**  <br>*optional*|Errors encountered, if any.|[ErrorList](#errorlist)|


<a name="updateschedulerequest"></a>
### UpdateScheduleRequest
Request schema for updateSchedule operation.


|Name|Description|Schema|
|---|---|---|
|**schedules**  <br>*required*|List of schedule objects to define the normal working hours of a resource.|[AvailabilityRecords](#availabilityrecords)|


<a name="createreservationrequest"></a>
### CreateReservationRequest
Request schema for CreateReservation operation.


|Name|Description|Schema|
|---|---|---|
|**resourceId**  <br>*required*|Resource (store) Identifier.|string|
|**reservation**  <br>*required*|Reservation object to reduce the capacity of a resource.|[Reservation](#reservation)|


<a name="updatereservationrequest"></a>
### UpdateReservationRequest
Request schema for UpdateReservation operation.


|Name|Description|Schema|
|---|---|---|
|**resourceId**  <br>*required*|Resource (store) Identifier.|string|
|**reservation**  <br>*required*|Reservation object to reduce the capacity of a resource.|[Reservation](#reservation)|


<a name="serviceuploaddocument"></a>
### ServiceUploadDocument
Input for to be uploaded document.


|Name|Description|Schema|
|---|---|---|
|**contentType**  <br>*required*|The content type of the to-be-uploaded file|enum ([ContentType](#contenttype))|
|**contentLength**  <br>*required*|The content length of the to-be-uploaded file  <br>**Minimum value** : `1`  <br>**Maximum value** : `5242880`|number (int64)|
|**contentMD5**  <br>*optional*|An MD5 hash of the content to be submitted to the upload destination. This value is used to determine if the data has been corrupted or tampered with during transit.  <br>**Pattern** : `"^[A-Za-z0-9\\\\+/]{22}={2}$"`|string|


<a name="createservicedocumentuploaddestination"></a>
### CreateServiceDocumentUploadDestination
The response schema for the createServiceDocumentUploadDestination operation.


|Name|Description|Schema|
|---|---|---|
|**payload**  <br>*optional*|Information about an upload destination.|[ServiceDocumentUploadDestination](#servicedocumentuploaddestination)|
|**errors**  <br>*optional*|A list of error responses returned when a request is unsuccessful.|[ErrorList](#errorlist)|


<a name="servicedocumentuploaddestination"></a>
### ServiceDocumentUploadDestination
Information about an upload destination.


|Name|Description|Schema|
|---|---|---|
|**uploadDestinationId**  <br>*required*|The unique identifier to be used by APIs that reference the upload destination.|string|
|**url**  <br>*required*|The URL to which to upload the file.|string|
|**encryptionDetails**  <br>*required*|Encryption details for required client-side encryption and decryption of document contents.|[EncryptionDetails](#encryptiondetails)|
|**headers**  <br>*optional*|The headers to include in the upload request.|object|


<a name="encryptiondetails"></a>
### EncryptionDetails
Encryption details for required client-side encryption and decryption of document contents.


|Name|Description|Schema|
|---|---|---|
|**standard**  <br>*required*|The encryption standard required to encrypt or decrypt the document contents.|enum ([Standard](#standard))|
|**initializationVector**  <br>*required*|The vector to encrypt or decrypt the document contents using Cipher Block Chaining (CBC).|string|
|**key**  <br>*required*|The encryption key used to encrypt or decrypt the document contents.|string|


<a name="servicelocationtype"></a>
### ServiceLocationType
The location of the service job.

*Type* : enum


|Value|Description|
|---|---|
|**IN_HOME**|Indicates the service for the service job is performed at the customers home address.|
|**IN_STORE**|Indicates the service for the service job is performed at the service providers store.|
|**ONLINE**|Indicates the service for the service job is performed remotely.|


<a name="itemstatus"></a>
### ItemStatus
The status of the item.

*Type* : enum


|Value|Description|
|---|---|
|**ACTIVE**|Indicates the item is yet to be shipped.|
|**CANCELLED**|Indicates the item has been cancelled.|
|**SHIPPED**|Indicates the item is shipped but not delivered.|
|**DELIVERED**|Indicates the item is delivered.|


<a name="type"></a>
### Type
Type of reservation.

*Type* : enum


|Value|Description|
|---|---|
|**APPOINTMENT**|Reduce resource(store) capacity because of an appointment.|
|**TRAVEL**|Reduce resource(store) capacity because technician(s) are travelling.|
|**VACATION**|Reduce resource(store) capacity because technician(s) are on vacation.|
|**BREAK**|Reduce resource(store) capacity because technician(s) are on break.|
|**TRAINING**|Reduce resource(store) capacity because technician(s) are in training.|


<a name="contenttype"></a>
### ContentType
The content type of the to-be-uploaded file

*Type* : enum


|Value|Description|
|---|---|
|**TIFF**|To be uploaded POA is of type image/tiff.|
|**JPG**|To be uploaded POA is of type image/jpg.|
|**PNG**|To be uploaded POA is of type image/png.|
|**JPEG**|To be uploaded POA is of type image/jpeg.|
|**GIF**|To be uploaded POA is of type image/gif.|
|**PDF**|To be uploaded POA is of type application/pdf.|


<a name="poatype"></a>
### PoaType
The type of POA uploaded.

*Type* : enum


|Value|Description|
|---|---|
|**NO_SIGNATURE_DUMMY_POS**|Indicates that the type of proof of appointment uploaded is a dummy signature.|
|**CUSTOMER_SIGNATURE**|Indicates that the type of proof of appointment uploaded is a customer signature.|
|**DUMMY_RECEIPT**|Indicates that the type of proof of appointment uploaded is a dummy receipt.|
|**POA_RECEIPT**|Indicates that the type of proof of appointment is a receipt.|


<a name="sortorder"></a>
### SortOrder
Sort order for the query you want to perform.

*Type* : enum


|Value|Description|
|---|---|
|**ASC**|Sort in ascending order.|
|**DESC**|Sort in descending order.|


<a name="errorlevel"></a>
### ErrorLevel
The type of error.

*Type* : enum


|Value|Description|
|---|---|
|**ERROR**|Error|
|**WARNING**|Warning|


<a name="sortfield"></a>
### SortField
Sort fields on which you want to sort the output.

*Type* : enum


|Value|Description|
|---|---|
|**JOB_DATE**|Sort on job date.|
|**JOB_STATUS**|Sort on job status.|


<a name="standard"></a>
### Standard
The encryption standard required to encrypt or decrypt the document contents.

*Type* : enum


|Value|Description|
|---|---|
|**AES**|The Advanced Encryption Standard (AES).|


<a name="appointmentstatus"></a>
### AppointmentStatus
The status of the appointment.

*Type* : enum


|Value|Description|
|---|---|
|**ACTIVE**|Indicates that an appointment is scheduled.|
|**CANCELLED**|Indicates that the appointment is cancelled.|
|**COMPLETED**|Indicates that the appointment is completed.|


<a name="servicejobstatus"></a>
### ServiceJobStatus
*Type* : enum

<a id="servicejobstatus-subgroup-1"></a>**For use with the definition(s): [ServiceJob](#servicejob)**
The status of the service job.

|Value|Description|
|---|---|
|**NOT_SERVICED**|Indicates that the service for the service job is not complete.|
|**CANCELLED**|Indicates that the service job is cancelled.|
|**COMPLETED**|Indicates that the service is performed and the service job is closed successfully.|
|**PENDING_SCHEDULE**|Indicates that an appointment for the service job has not been scheduled.|
|**NOT_FULFILLABLE**|Indicates that the service job is not actionable due to an unexpected exception.|
|**HOLD**|Indicates that the appointment time preference given by customer cannot be serviced by the service provider.|
|**PAYMENT_DECLINED**|Indicates that the customer payment has been declined.|

<a id="servicejobstatus-subgroup-2"></a>**For use with the operation(s): [getServiceJobs](#getservicejobs)**

|Value|Description|
|---|---|
|**NOT_SERVICED**|Jobs which are not serviced.|
|**CANCELLED**|Jobs which are cancelled.|
|**COMPLETED**|Jobs successfully completed.|
|**PENDING_SCHEDULE**|Jobs which are pending schedule.|
|**NOT_FULFILLABLE**|Jobs which are not fulfillable.|
|**HOLD**|Jobs which are on hold.|
|**PAYMENT_DECLINED**|Jobs for which payment was declined.|

