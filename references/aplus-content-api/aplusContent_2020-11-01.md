# Selling Partner API for A+ Content Management


<a name="overview"></a>
## Overview
With the A+ Content API, you can build applications that help selling partners add rich marketing content to their Amazon product detail pages. A+ content helps selling partners share their brand and product story, which helps buyers make informed purchasing decisions. Selling partners assemble content by choosing from content modules and adding images and text.


### Version information
*Version* : 2020-11-01


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
[searchContentDocuments](#searchcontentdocuments)<br>[createContentDocument](#createcontentdocument)<br>[getContentDocument](#getcontentdocument)<br>[updateContentDocument](#updatecontentdocument)<br>[listContentDocumentAsinRelations](#listcontentdocumentasinrelations)<br>[postContentDocumentAsinRelations](#postcontentdocumentasinrelations)<br>[validateContentDocumentAsinRelations](#validatecontentdocumentasinrelations)<br>[searchContentPublishRecords](#searchcontentpublishrecords)<br>[postContentDocumentApprovalSubmission](#postcontentdocumentapprovalsubmission)<br>[postContentDocumentSuspendSubmission](#postcontentdocumentsuspendsubmission)<br>
<a name="paths"></a>
## Paths

<a name="searchcontentdocuments"></a>
### GET /aplus/2020-11-01/contentDocuments
**Operation: searchContentDocuments**

#### Description
Returns a list of all A+ Content documents assigned to a selling partner. This operation returns only the metadata of the A+ Content documents. Call the getContentDocument operation to get the actual contents of the A+ Content documents.

**Usage Plans:**

| Plan type | Rate (requests per second) | Burst |
| ---- | ---- | ---- |
|Default| 10 | 10 |
|Selling partner specific| Variable | Variable |

The x-amzn-RateLimit-Limit response header returns the usage plan rate limits that were applied to the requested operation. Rate limits for some selling partners will vary from the default rate and burst shown in the table above. For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Query**|**marketplaceId**  <br>*required*|The identifier for the marketplace where the A+ Content is published.<br>**minLength** : 1<br>|string|
|**Query**|**pageToken**  <br>*optional*|A page token from the nextPageToken response element returned by your previous call to this operation. nextPageToken is returned when the results of a call exceed the page size. To get the next page of results, call the operation and include pageToken as the only parameter. Specifying pageToken with any other parameter will cause the request to fail. When no nextPageToken value is returned there are no more pages to return. A pageToken value is not usable across different operations.<br>**minLength** : 1<br>|string|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Success.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[SearchContentDocumentsResponse](#searchcontentdocumentsresponse)|

For error status codes, descriptions and schemas, see [Error responses and schemas](#error-responses-and-schemas).
<a name="createcontentdocument"></a>
### POST /aplus/2020-11-01/contentDocuments
**Operation: createContentDocument**

#### Description
Creates a new A+ Content document.

**Usage Plans:**

| Plan type | Rate (requests per second) | Burst |
| ---- | ---- | ---- |
|Default| 10 | 10 |
|Selling partner specific| Variable | Variable |

The x-amzn-RateLimit-Limit response header returns the usage plan rate limits that were applied to the requested operation. Rate limits for some selling partners will vary from the default rate and burst shown in the table above. For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Query**|**marketplaceId**  <br>*required*|The identifier for the marketplace where the A+ Content is published.<br>**minLength** : 1<br>|string|
|**Body**|**postContentDocumentRequest**  <br>*required*|The content document request details.|[PostContentDocumentRequest](#postcontentdocumentrequest)|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Success.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[PostContentDocumentResponse](#postcontentdocumentresponse)|

For error status codes, descriptions and schemas, see [Error responses and schemas](#error-responses-and-schemas).
<a name="getcontentdocument"></a>
### GET /aplus/2020-11-01/contentDocuments/{contentReferenceKey}
**Operation: getContentDocument**

#### Description
Returns an A+ Content document, if available.

**Usage Plans:**

| Plan type | Rate (requests per second) | Burst |
| ---- | ---- | ---- |
|Default| 10 | 10 |
|Selling partner specific| Variable | Variable |

The x-amzn-RateLimit-Limit response header returns the usage plan rate limits that were applied to the requested operation. Rate limits for some selling partners will vary from the default rate and burst shown in the table above. For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**contentReferenceKey**  <br>*required*|The unique reference key for the A+ Content document. A content reference key cannot form a permalink and may change in the future. A content reference key is not guaranteed to match any A+ Content identifier.<br>**minLength** : 1<br>|string|
|**Query**|**marketplaceId**  <br>*required*|The identifier for the marketplace where the A+ Content is published.<br>**minLength** : 1<br>|string|
|**Query**|**includedDataSet**  <br>*required*|The set of A+ Content data types to include in the response.  <br>**Min count** : 1|< enum ([IncludedDataSet](#includeddataset-subgroup-1)) > array(csv)|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Success.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[GetContentDocumentResponse](#getcontentdocumentresponse)|

For error status codes, descriptions and schemas, see [Error responses and schemas](#error-responses-and-schemas).
<a name="updatecontentdocument"></a>
### POST /aplus/2020-11-01/contentDocuments/{contentReferenceKey}
**Operation: updateContentDocument**

#### Description
Updates an existing A+ Content document.

**Usage Plans:**

| Plan type | Rate (requests per second) | Burst |
| ---- | ---- | ---- |
|Default| 10 | 10 |
|Selling partner specific| Variable | Variable |

The x-amzn-RateLimit-Limit response header returns the usage plan rate limits that were applied to the requested operation. Rate limits for some selling partners will vary from the default rate and burst shown in the table above. For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**contentReferenceKey**  <br>*required*|The unique reference key for the A+ Content document. A content reference key cannot form a permalink and may change in the future. A content reference key is not guaranteed to match any A+ Content identifier.<br>**minLength** : 1<br>|string|
|**Query**|**marketplaceId**  <br>*required*|The identifier for the marketplace where the A+ Content is published.<br>**minLength** : 1<br>|string|
|**Body**|**postContentDocumentRequest**  <br>*required*|The content document request details.|[PostContentDocumentRequest](#postcontentdocumentrequest)|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Success.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[PostContentDocumentResponse](#postcontentdocumentresponse)|

For error status codes, descriptions and schemas, see [Error responses and schemas](#error-responses-and-schemas).
<a name="listcontentdocumentasinrelations"></a>
### GET /aplus/2020-11-01/contentDocuments/{contentReferenceKey}/asins
**Operation: listContentDocumentAsinRelations**

#### Description
Returns a list of ASINs related to the specified A+ Content document, if available. If you do not include the asinSet parameter, the operation returns all ASINs related to the content document.

**Usage Plans:**

| Plan type | Rate (requests per second) | Burst |
| ---- | ---- | ---- |
|Default| 10 | 10 |
|Selling partner specific| Variable | Variable |

The x-amzn-RateLimit-Limit response header returns the usage plan rate limits that were applied to the requested operation. Rate limits for some selling partners will vary from the default rate and burst shown in the table above. For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**contentReferenceKey**  <br>*required*|The unique reference key for the A+ Content document. A content reference key cannot form a permalink and may change in the future. A content reference key is not guaranteed to match any A+ Content identifier.<br>**minLength** : 1<br>|string|
|**Query**|**marketplaceId**  <br>*required*|The identifier for the marketplace where the A+ Content is published.<br>**minLength** : 1<br>|string|
|**Query**|**includedDataSet**  <br>*optional*|The set of A+ Content data types to include in the response. If you do not include this parameter, the operation returns the related ASINs without metadata.  <br>**Min count** : 0|< enum ([IncludedDataSet](#includeddataset-subgroup-2)) > array(csv)|
|**Query**|**asinSet**  <br>*optional*|The set of ASINs.<br>|< string > array(csv)|
|**Query**|**pageToken**  <br>*optional*|A page token from the nextPageToken response element returned by your previous call to this operation. nextPageToken is returned when the results of a call exceed the page size. To get the next page of results, call the operation and include pageToken as the only parameter. Specifying pageToken with any other parameter will cause the request to fail. When no nextPageToken value is returned there are no more pages to return. A pageToken value is not usable across different operations.<br>**minLength** : 1<br>|string|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Success.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[ListContentDocumentAsinRelationsResponse](#listcontentdocumentasinrelationsresponse)|

For error status codes, descriptions and schemas, see [Error responses and schemas](#error-responses-and-schemas).
<a name="postcontentdocumentasinrelations"></a>
### POST /aplus/2020-11-01/contentDocuments/{contentReferenceKey}/asins
**Operation: postContentDocumentAsinRelations**

#### Description
Replaces all ASINs related to the specified A+ Content document, if available. This may add or remove ASINs, depending on the current set of related ASINs. Removing an ASIN has the side effect of suspending the content document from that ASIN.

**Usage Plans:**

| Plan type | Rate (requests per second) | Burst |
| ---- | ---- | ---- |
|Default| 10 | 10 |
|Selling partner specific| Variable | Variable |

The x-amzn-RateLimit-Limit response header returns the usage plan rate limits that were applied to the requested operation. Rate limits for some selling partners will vary from the default rate and burst shown in the table above. For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**contentReferenceKey**  <br>*required*|The unique reference key for the A+ Content document. A content reference key cannot form a permalink and may change in the future. A content reference key is not guaranteed to match any A+ content identifier.<br>**minLength** : 1<br>|string|
|**Query**|**marketplaceId**  <br>*required*|The identifier for the marketplace where the A+ Content is published.<br>**minLength** : 1<br>|string|
|**Body**|**postContentDocumentAsinRelationsRequest**  <br>*required*|The content document ASIN relations request details.|[PostContentDocumentAsinRelationsRequest](#postcontentdocumentasinrelationsrequest)|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Success.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[PostContentDocumentAsinRelationsResponse](#postcontentdocumentasinrelationsresponse)|

For error status codes, descriptions and schemas, see [Error responses and schemas](#error-responses-and-schemas).
<a name="validatecontentdocumentasinrelations"></a>
### POST /aplus/2020-11-01/contentAsinValidations
**Operation: validateContentDocumentAsinRelations**

#### Description
Checks if the A+ Content document is valid for use on a set of ASINs.

**Usage Plans:**

| Plan type | Rate (requests per second) | Burst |
| ---- | ---- | ---- |
|Default| 10 | 10 |
|Selling partner specific| Variable | Variable |

The x-amzn-RateLimit-Limit response header returns the usage plan rate limits that were applied to the requested operation. Rate limits for some selling partners will vary from the default rate and burst shown in the table above. For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Query**|**marketplaceId**  <br>*required*|The identifier for the marketplace where the A+ Content is published.<br>**minLength** : 1<br>|string|
|**Query**|**asinSet**  <br>*optional*|The set of ASINs.<br>|< string > array(csv)|
|**Body**|**postContentDocumentRequest**  <br>*required*|The content document request details.|[PostContentDocumentRequest](#postcontentdocumentrequest)|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Success.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[ValidateContentDocumentAsinRelationsResponse](#validatecontentdocumentasinrelationsresponse)|

For error status codes, descriptions and schemas, see [Error responses and schemas](#error-responses-and-schemas).
<a name="searchcontentpublishrecords"></a>
### GET /aplus/2020-11-01/contentPublishRecords
**Operation: searchContentPublishRecords**

#### Description
Searches for A+ Content publishing records, if available.

**Usage Plans:**

| Plan type | Rate (requests per second) | Burst |
| ---- | ---- | ---- |
|Default| 10 | 10 |
|Selling partner specific| Variable | Variable |

The x-amzn-RateLimit-Limit response header returns the usage plan rate limits that were applied to the requested operation. Rate limits for some selling partners will vary from the default rate and burst shown in the table above. For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Query**|**marketplaceId**  <br>*required*|The identifier for the marketplace where the A+ Content is published.<br>**minLength** : 1<br>|string|
|**Query**|**asin**  <br>*required*|The Amazon Standard Identification Number (ASIN).<br>**minLength** : 10<br>|string|
|**Query**|**pageToken**  <br>*optional*|A page token from the nextPageToken response element returned by your previous call to this operation. nextPageToken is returned when the results of a call exceed the page size. To get the next page of results, call the operation and include pageToken as the only parameter. Specifying pageToken with any other parameter will cause the request to fail. When no nextPageToken value is returned there are no more pages to return. A pageToken value is not usable across different operations.<br>**minLength** : 1<br>|string|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Success.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[SearchContentPublishRecordsResponse](#searchcontentpublishrecordsresponse)|

For error status codes, descriptions and schemas, see [Error responses and schemas](#error-responses-and-schemas).
<a name="postcontentdocumentapprovalsubmission"></a>
### POST /aplus/2020-11-01/contentDocuments/{contentReferenceKey}/approvalSubmissions
**Operation: postContentDocumentApprovalSubmission**

#### Description
Submits an A+ Content document for review, approval, and publishing.

**Usage Plans:**

| Plan type | Rate (requests per second) | Burst |
| ---- | ---- | ---- |
|Default| 10 | 10 |
|Selling partner specific| Variable | Variable |

The x-amzn-RateLimit-Limit response header returns the usage plan rate limits that were applied to the requested operation. Rate limits for some selling partners will vary from the default rate and burst shown in the table above. For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**contentReferenceKey**  <br>*required*|The unique reference key for the A+ Content document. A content reference key cannot form a permalink and may change in the future. A content reference key is not guaranteed to match any A+ content identifier.<br>**minLength** : 1<br>|string|
|**Query**|**marketplaceId**  <br>*required*|The identifier for the marketplace where the A+ Content is published.<br>**minLength** : 1<br>|string|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Success.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[PostContentDocumentApprovalSubmissionResponse](#postcontentdocumentapprovalsubmissionresponse)|

For error status codes, descriptions and schemas, see [Error responses and schemas](#error-responses-and-schemas).
<a name="postcontentdocumentsuspendsubmission"></a>
### POST /aplus/2020-11-01/contentDocuments/{contentReferenceKey}/suspendSubmissions
**Operation: postContentDocumentSuspendSubmission**

#### Description
Submits a request to suspend visible A+ Content. This neither deletes the content document nor the ASIN relations.

**Usage Plans:**

| Plan type | Rate (requests per second) | Burst |
| ---- | ---- | ---- |
|Default| 10 | 10 |
|Selling partner specific| Variable | Variable |

The x-amzn-RateLimit-Limit response header returns the usage plan rate limits that were applied to the requested operation. Rate limits for some selling partners will vary from the default rate and burst shown in the table above. For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**contentReferenceKey**  <br>*required*|The unique reference key for the A+ Content document. A content reference key cannot form a permalink and may change in the future. A content reference key is not guaranteed to match any A+ content identifier.<br>**minLength** : 1<br>|string|
|**Query**|**marketplaceId**  <br>*required*|The identifier for the marketplace where the A+ Content is published.<br>**minLength** : 1<br>|string|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Success.  <br>**Headers** :   <br>`x-amzn-RateLimit-Limit` (string) : Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[PostContentDocumentSuspendSubmissionResponse](#postcontentdocumentsuspendsubmissionresponse)|

For error status codes, descriptions and schemas, see [Error responses and schemas](#error-responses-and-schemas).



<a name="error-responses-and-schemas"></a>
### Error Responses and Schemas
This table contains HTTP status codes and associated information for error responses.

|HTTP Code|Description|Schema|
|---|---|---|
|**400**|Request has missing or invalid parameters and cannot be parsed.  <br>**Headers**:  <br>`x-amzn-RateLimit-Limit` (string):Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string):Unique request reference identifier.|[ErrorList](#errorlist)|
|**401**|The request's Authorization header is not formatted correctly or does not contain a valid token.  <br>**Headers**:  <br>`x-amzn-RateLimit-Limit` (string):Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string):Unique request reference identifier.|[ErrorList](#errorlist)|
|**403**|Indicates that access to the resource is forbidden. Possible reasons include Access Denied, Unauthorized, Expired Token, or Invalid Signature.  <br>**Headers**:  <br>`x-amzn-RequestId` (string):Unique request reference identifier.|[ErrorList](#errorlist)|
|**404**|The specified resource does not exist.  <br>**Headers**:  <br>`x-amzn-RequestId` (string):Unique request reference identifier.|[ErrorList](#errorlist)|
|**410**|The specified resource no longer exists.  <br>**Headers**:  <br>`x-amzn-RateLimit-Limit` (string):Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string):Unique request reference identifier.|[ErrorList](#errorlist)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers**:  <br>`x-amzn-RateLimit-Limit` (string):Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string):Unique request reference identifier.|[ErrorList](#errorlist)|
|**500**|An unexpected condition occurred that prevented the server from fulfilling the request.  <br>**Headers**:  <br>`x-amzn-RateLimit-Limit` (string):Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string):Unique request reference identifier.|[ErrorList](#errorlist)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers**:  <br>`x-amzn-RateLimit-Limit` (string):Your rate limit (requests per second) for this operation.  <br>`x-amzn-RequestId` (string):Unique request reference identifier.|[ErrorList](#errorlist)|


<a name="definitions"></a>
## Definitions

<a name="aplusresponse"></a>
### AplusResponse
The base response data for all A+ Content operations when a request is successful or partially successful. Individual operations may extend this with additional data.


|Name|Description|Schema|
|---|---|---|
|**warnings**  <br>*optional*|A set of messages to the user, such as warnings or comments.|[MessageSet](#messageset)|


<a name="apluspaginatedresponse"></a>
### AplusPaginatedResponse
The base response data for paginated A+ Content operations. Individual operations may extend this with additional data. If nextPageToken is not returned, there are no more pages to return.

*Polymorphism* : Composition


|Name|Description|Schema|
|---|---|---|
|**warnings**  <br>*optional*|A set of messages to the user, such as warnings or comments.|[MessageSet](#messageset)|
|**nextPageToken**  <br>*optional*|A page token that is returned when the results of the call exceed the page size. To get another page of results, call the operation again, passing in this value with the pageToken parameter.|[PageToken](#pagetoken)|


<a name="errorlist"></a>
### ErrorList
The error response for when a request is unsuccessful.


|Name|Description|Schema|
|---|---|---|
|**errors**  <br>*required*|A list of error responses returned when a request is unsuccessful.|< [Error](#error) > array|


<a name="messageset"></a>
### MessageSet
A set of messages to the user, such as warnings or comments.

*Type* : < [Error](#error) > array

**Unique items** : true  

<a name="error"></a>
### Error
Error response returned when the request is unsuccessful.


|Name|Description|Schema|
|---|---|---|
|**code**  <br>*required*|The code that identifies the type of error condition.<br>**minLength** : 1<br>|string|
|**message**  <br>*required*|A human readable description of the error condition.<br>**minLength** : 1<br>|string|
|**details**  <br>*optional*|Additional information, if available, to clarify the error condition.<br>**minLength** : 1<br>|string|


<a name="contentmetadatarecordlist"></a>
### ContentMetadataRecordList
A list of A+ Content metadata records.

*Type* : < [ContentMetadataRecord](#contentmetadatarecord) > array

**Unique items** : false  

<a name="contentmetadatarecord"></a>
### ContentMetadataRecord
The metadata for an A+ Content document, with additional information for content management.


|Name|Description|Schema|
|---|---|---|
|**contentReferenceKey**  <br>*required*|A unique reference key for the A+ Content document. A content reference key cannot form a permalink and may change in the future. A content reference key is not guaranteed to match any A+ content identifier.|[ContentReferenceKey](#contentreferencekey)|
|**contentMetadata**  <br>*required*|The metadata of an A+ Content document.|[ContentMetadata](#contentmetadata)|


<a name="contentmetadata"></a>
### ContentMetadata
The metadata of an A+ Content document.


|Name|Description|Schema|
|---|---|---|
|**name**  <br>*required*|The A+ Content document name.<br>**minLength** : 1<br>**maxLength** : 100|string|
|**marketplaceId**  <br>*required*|The identifier for the marketplace where the A+ Content is published.|[MarketplaceId](#marketplaceid)|
|**status**  <br>*required*|The submission status of the content document.|[ContentStatus](#contentstatus)|
|**badgeSet**  <br>*required*|The set of content badges.|[ContentBadgeSet](#contentbadgeset)|
|**updateTime**  <br>*required*|The approximate age of the A+ Content document and metadata.|string (date-time)|


<a name="contenttype"></a>
### ContentType
The A+ Content document type.

*Type* : enum


|Value|Description|
|---|---|
|**EBC**|A+ Content published through the A+ Content Manager in Seller Central.|
|**EMC**|A+ Content published through the A+ Content Manager in Vendor Central.|


<a name="contentsubtype"></a>
### ContentSubType
The A+ Content document subtype. This represents a special-purpose type of an A+ Content document. Not every A+ Content document type will have a subtype, and subtypes may change at any time.

*Type* : string

**minLength** : 1  

<a name="contentstatus"></a>
### ContentStatus
The submission status of the content document.

*Type* : enum


|Value|Description|
|---|---|
|**APPROVED**|The content is approved and will be published to applied ASINs.|
|**DRAFT**|The content has not yet been submitted for approval.|
|**REJECTED**|The content has been rejected in moderation and needs to be revised and resubmitted based on the rejection reasons provided.|
|**SUBMITTED**|The content has been submitted for approval and is currently waiting for moderation.|


<a name="contentbadgeset"></a>
### ContentBadgeSet
The set of content badges.

*Type* : < [ContentBadge](#contentbadge) > array

**Unique items** : true  

<a name="contentbadge"></a>
### ContentBadge
A flag that provides additional information about an A+ Content document.

*Type* : enum


|Value|Description|
|---|---|
|**BULK**|This content is applied to ASINs in bulk.|
|**GENERATED**|This content is generated by an automated process. If any user modifies this content, it will lose the GENERATED badge.|
|**LAUNCHPAD**|Launchpad content.|
|**PREMIUM**|Premium content|
|**STANDARD**|Standard content.|


<a name="asinbadgeset"></a>
### AsinBadgeSet
The set of ASIN badges.

*Type* : < [AsinBadge](#asinbadge) > array

**Unique items** : true  

<a name="asinbadge"></a>
### AsinBadge
A flag that provides additional information about an ASIN. This is contextual and may change depending on the request that generated it.

*Type* : enum


|Value|Description|
|---|---|
|**BRAND_NOT_ELIGIBLE**|This ASIN is not part of the current user's brand. If the current user corrects their brand registration to include this ASIN, it will lose the `BrandNotEligible` badge.|
|**CATALOG_NOT_FOUND**|This ASIN was not found in the Amazon catalog. If any user creates or restores this ASIN, it will lose the `CatalogNotFound` badge.|
|**CONTENT_NOT_PUBLISHED**|This ASIN does not have the specified A+ Content published to it. If the current user publishes the specified content for this ASIN, it will lose the `ContentNotPublished` badge.|
|**CONTENT_PUBLISHED**|This ASIN has the specified A+ Content published to it. If the current user suspends the specified content for this ASIN, it will lose the `ContentPublished` badge.|


<a name="marketplaceid"></a>
### MarketplaceId
The identifier for the marketplace where the A+ Content is published.

*Type* : string

**minLength** : 1  

<a name="languagetag"></a>
### LanguageTag
The IETF language tag. This only supports the primary language subtag with one secondary language subtag. The secondary language subtag is almost always a regional designation. This does not support additional subtags beyond the primary and secondary subtags.
**Pattern:** ^[a-z]{2,}-[A-Z0-9]{2,}$

*Type* : string

**minLength** : 5  

<a name="asinset"></a>
### AsinSet
The set of ASINs.

*Type* : < [Asin](#asin) > array

**Unique items** : true  

<a name="asin"></a>
### Asin
The Amazon Standard Identification Number (ASIN).

*Type* : string

**minLength** : 10  

<a name="asinmetadataset"></a>
### AsinMetadataSet
The set of ASIN metadata.

*Type* : < [AsinMetadata](#asinmetadata) > array

**Unique items** : true  

<a name="asinmetadata"></a>
### AsinMetadata
The A+ Content ASIN with additional metadata for content management. If you don't include the `includedDataSet` parameter in a call to the listContentDocumentAsinRelations operation, the related ASINs are returned without metadata.


|Name|Description|Schema|
|---|---|---|
|**asin**  <br>*required*|The Amazon Standard Identification Number (ASIN).|[Asin](#asin)|
|**badgeSet**  <br>*optional*|The set of ASIN badges.|[AsinBadgeSet](#asinbadgeset)|
|**parent**  <br>*optional*|The Amazon Standard Identification Number (ASIN).|[Asin](#asin)|
|**title**  <br>*optional*|The title for the ASIN in the Amazon catalog.<br>**minLength** : 1<br>|string|
|**imageUrl**  <br>*optional*|The default image for the ASIN in the Amazon catalog.<br>**minLength** : 1<br>|string|
|**contentReferenceKeySet**  <br>*optional*|A set of content reference keys.|[ContentReferenceKeySet](#contentreferencekeyset)|


<a name="publishrecordlist"></a>
### PublishRecordList
A list of A+ Content publishing records.

*Type* : < [PublishRecord](#publishrecord) > array

**Unique items** : false  

<a name="publishrecord"></a>
### PublishRecord
The full context for an A+ Content publishing event.


|Name|Description|Schema|
|---|---|---|
|**marketplaceId**  <br>*required*|The identifier for the marketplace where the A+ Content is published.|[MarketplaceId](#marketplaceid)|
|**locale**  <br>*required*|The IETF language tag. This only supports the primary language subtag with one secondary language subtag. The secondary language subtag is almost always a regional designation. This does not support additional subtags beyond the primary and secondary subtags.<br>**Pattern:** ^[a-z]{2,}-[A-Z0-9]{2,}$|[LanguageTag](#languagetag)|
|**asin**  <br>*required*|The Amazon Standard Identification Number (ASIN).|[Asin](#asin)|
|**contentType**  <br>*required*|The A+ Content document type.|[ContentType](#contenttype)|
|**contentSubType**  <br>*optional*|The A+ Content document subtype. This represents a special-purpose type of an A+ Content document. Not every A+ Content document type will have a subtype, and subtypes may change at any time.|[ContentSubType](#contentsubtype)|
|**contentReferenceKey**  <br>*required*|A unique reference key for the A+ Content document. A content reference key cannot form a permalink and may change in the future. A content reference key is not guaranteed to match any A+ content identifier.|[ContentReferenceKey](#contentreferencekey)|


<a name="contentreferencekeyset"></a>
### ContentReferenceKeySet
A set of content reference keys.

*Type* : < [ContentReferenceKey](#contentreferencekey) > array

**Unique items** : true  

<a name="contentreferencekey"></a>
### ContentReferenceKey
A unique reference key for the A+ Content document. A content reference key cannot form a permalink and may change in the future. A content reference key is not guaranteed to match any A+ content identifier.

*Type* : string

**minLength** : 1  

<a name="pagetoken"></a>
### PageToken
A page token that is returned when the results of the call exceed the page size. To get another page of results, call the operation again, passing in this value with the pageToken parameter.

*Type* : string

**minLength** : 1  

<a name="imagecropspecification"></a>
### ImageCropSpecification
The instructions for optionally cropping an image. If no cropping is desired, set the dimensions to the original image size. If the image is cropped and no offset values are provided, then the coordinates of the top left corner of the cropped image, relative to the original image, are defaulted to (0,0).


|Name|Description|Schema|
|---|---|---|
|**size**  <br>*required*|The dimensions extending from the top left corner of the cropped image, or the top left corner of the original image if there is no cropping. Only `pixels` is allowed as the units value for ImageDimensions.|[ImageDimensions](#imagedimensions)|
|**offset**  <br>*optional*|The top left corner of the cropped image, specified in the original image's coordinate space.|[ImageOffsets](#imageoffsets)|


<a name="imagedimensions"></a>
### ImageDimensions
The dimensions extending from the top left corner of the cropped image, or the top left corner of the original image if there is no cropping. Only `pixels` is allowed as the units value for ImageDimensions.


|Name|Description|Schema|
|---|---|---|
|**width**  <br>*required*|A whole number dimension and its unit of measurement. For example, this can represent 100 pixels.|[IntegerWithUnits](#integerwithunits)|
|**height**  <br>*required*|A whole number dimension and its unit of measurement. For example, this can represent 100 pixels.|[IntegerWithUnits](#integerwithunits)|


<a name="imageoffsets"></a>
### ImageOffsets
The top left corner of the cropped image, specified in the original image's coordinate space.


|Name|Description|Schema|
|---|---|---|
|**x**  <br>*required*|A whole number dimension and its unit of measurement. For example, this can represent 100 pixels.|[IntegerWithUnits](#integerwithunits)|
|**y**  <br>*required*|A whole number dimension and its unit of measurement. For example, this can represent 100 pixels.|[IntegerWithUnits](#integerwithunits)|


<a name="integerwithunits"></a>
### IntegerWithUnits
A whole number dimension and its unit of measurement. For example, this can represent 100 pixels.


|Name|Description|Schema|
|---|---|---|
|**value**  <br>*required*|The dimension value.|integer|
|**units**  <br>*required*|The unit of measurement.|string|


<a name="contentrecordlist"></a>
### ContentRecordList
A list of A+ Content records.

*Type* : < [ContentRecord](#contentrecord) > array

**Unique items** : false  

<a name="contentrecord"></a>
### ContentRecord
A content document with additional information for content management.


|Name|Description|Schema|
|---|---|---|
|**contentReferenceKey**  <br>*required*|A unique reference key for the A+ Content document. A content reference key cannot form a permalink and may change in the future. A content reference key is not guaranteed to match any A+ content identifier.|[ContentReferenceKey](#contentreferencekey)|
|**contentMetadata**  <br>*optional*|The metadata of an A+ Content document.|[ContentMetadata](#contentmetadata)|
|**contentDocument**  <br>*optional*|The A+ Content document. This is the enhanced content that is published to product detail pages.|[ContentDocument](#contentdocument)|


<a name="contentdocument"></a>
### ContentDocument
The A+ Content document. This is the enhanced content that is published to product detail pages.


|Name|Description|Schema|
|---|---|---|
|**name**  <br>*required*|The A+ Content document name.<br>**minLength** : 1<br>**maxLength** : 100|string|
|**contentType**  <br>*required*|The A+ Content document type.|[ContentType](#contenttype)|
|**contentSubType**  <br>*optional*|The A+ Content document subtype. This represents a special-purpose type of an A+ Content document. Not every A+ Content document type will have a subtype, and subtypes may change at any time.|[ContentSubType](#contentsubtype)|
|**locale**  <br>*required*|The IETF language tag. This only supports the primary language subtag with one secondary language subtag. The secondary language subtag is almost always a regional designation. This does not support additional subtags beyond the primary and secondary subtags.<br>**Pattern:** ^[a-z]{2,}-[A-Z0-9]{2,}$|[LanguageTag](#languagetag)|
|**contentModuleList**  <br>*required*|A list of A+ Content modules.|[ContentModuleList](#contentmodulelist)|


<a name="contentmodulelist"></a>
### ContentModuleList
A list of A+ Content modules.

*Type* : < [ContentModule](#contentmodule) > array

**Min items** : 1  
**Max items** : 100  
**Unique items** : false  

<a name="contentmodule"></a>
### ContentModule
An A+ Content module. An A+ Content document is composed of content modules. The contentModuleType property selects which content module types to use.


|Name|Description|Schema|
|---|---|---|
|**contentModuleType**  <br>*required*|The type of A+ Content module.|[ContentModuleType](#contentmoduletype)|
|**standardCompanyLogo**  <br>*optional*|The standard company logo image.|[StandardCompanyLogoModule](#standardcompanylogomodule)|
|**standardComparisonTable**  <br>*optional*|The standard product comparison table.|[StandardComparisonTableModule](#standardcomparisontablemodule)|
|**standardFourImageText**  <br>*optional*|Four standard images with text, presented across a single row.|[StandardFourImageTextModule](#standardfourimagetextmodule)|
|**standardFourImageTextQuadrant**  <br>*optional*|Four standard images with text, presented on a grid of four quadrants.|[StandardFourImageTextQuadrantModule](#standardfourimagetextquadrantmodule)|
|**standardHeaderImageText**  <br>*optional*|Standard headline text, an image, and body text.|[StandardHeaderImageTextModule](#standardheaderimagetextmodule)|
|**standardImageSidebar**  <br>*optional*|Two images, two paragraphs, and two bulleted lists. One image is smaller and displayed in the sidebar.|[StandardImageSidebarModule](#standardimagesidebarmodule)|
|**standardImageTextOverlay**  <br>*optional*|A standard background image with a floating text box.|[StandardImageTextOverlayModule](#standardimagetextoverlaymodule)|
|**standardMultipleImageText**  <br>*optional*|Standard images with text, presented one at a time. The user clicks on thumbnails to view each block.|[StandardMultipleImageTextModule](#standardmultipleimagetextmodule)|
|**standardProductDescription**  <br>*optional*|Standard product description text.|[StandardProductDescriptionModule](#standardproductdescriptionmodule)|
|**standardSingleImageHighlights**  <br>*optional*|A standard image with several paragraphs and a bulleted list.|[StandardSingleImageHighlightsModule](#standardsingleimagehighlightsmodule)|
|**standardSingleImageSpecsDetail**  <br>*optional*|A standard image with paragraphs and a bulleted list, and extra space for technical details.|[StandardSingleImageSpecsDetailModule](#standardsingleimagespecsdetailmodule)|
|**standardSingleSideImage**  <br>*optional*|A standard headline and body text with an image on the side.|[StandardSingleSideImageModule](#standardsinglesideimagemodule)|
|**standardTechSpecs**  <br>*optional*|The standard table of technical feature names and definitions.|[StandardTechSpecsModule](#standardtechspecsmodule)|
|**standardText**  <br>*optional*|A standard headline and body text.|[StandardTextModule](#standardtextmodule)|
|**standardThreeImageText**  <br>*optional*|Three standard images with text, presented across a single row.|[StandardThreeImageTextModule](#standardthreeimagetextmodule)|


<a name="contentmoduletype"></a>
### ContentModuleType
The type of A+ Content module.

*Type* : enum


|Value|Description|
|---|---|
|**STANDARD_COMPANY_LOGO**|The standard company logo image.|
|**STANDARD_COMPARISON_TABLE**|The standard product comparison table or chart.|
|**STANDARD_FOUR_IMAGE_TEXT**|Four standard images with text, presented across a single row.|
|**STANDARD_FOUR_IMAGE_TEXT_QUADRANT**|Four standard images with text, presented on a grid of four quadrants.|
|**STANDARD_HEADER_IMAGE_TEXT**|Standard headline text, an image, and body text.|
|**STANDARD_IMAGE_SIDEBAR**|Two images, two paragraphs, and two bulleted lists. One image is smaller and is displayed in the sidebar.|
|**STANDARD_IMAGE_TEXT_OVERLAY**|A standard background image with a floating text box.|
|**STANDARD_MULTIPLE_IMAGE_TEXT**|Standard images with text, presented one at a time. The user clicks on thumbnails to view each block.|
|**STANDARD_PRODUCT_DESCRIPTION**|Standard product description text.|
|**STANDARD_SINGLE_IMAGE_HIGHLIGHTS**|A standard image with several paragraphs and a bulleted list.|
|**STANDARD_SINGLE_IMAGE_SPECS_DETAIL**|A standard image with paragraphs and a bulleted list, and extra space for technical details.|
|**STANDARD_SINGLE_SIDE_IMAGE**|A standard headline and body text with an image on the side.|
|**STANDARD_TECH_SPECS**|The standard table of technical feature names and definitions.|
|**STANDARD_TEXT**|Standard headline and body text.|
|**STANDARD_THREE_IMAGE_TEXT**|Three standard images with text, presented across one row.|


<a name="standardcompanylogomodule"></a>
### StandardCompanyLogoModule
The standard company logo image.


|Name|Description|Schema|
|---|---|---|
|**companyLogo**  <br>*required*|A reference to an image, hosted in the A+ Content media library.|[ImageComponent](#imagecomponent)|


<a name="standardcomparisontablemodule"></a>
### StandardComparisonTableModule
The standard product comparison table.


|Name|Schema|
|---|---|
|**productColumns**  <br>*optional*|< [StandardComparisonProductBlock](#standardcomparisonproductblock) > array|
|**metricRowLabels**  <br>*optional*|< [PlainTextItem](#plaintextitem) > array|


<a name="standardfourimagetextmodule"></a>
### StandardFourImageTextModule
Four standard images with text, presented across a single row.


|Name|Description|Schema|
|---|---|---|
|**headline**  <br>*optional*|Rich text content.|[TextComponent](#textcomponent)|
|**block1**  <br>*optional*|The A+ Content standard image and text box block.|[StandardImageTextBlock](#standardimagetextblock)|
|**block2**  <br>*optional*|The A+ Content standard image and text box block.|[StandardImageTextBlock](#standardimagetextblock)|
|**block3**  <br>*optional*|The A+ Content standard image and text box block.|[StandardImageTextBlock](#standardimagetextblock)|
|**block4**  <br>*optional*|The A+ Content standard image and text box block.|[StandardImageTextBlock](#standardimagetextblock)|


<a name="standardfourimagetextquadrantmodule"></a>
### StandardFourImageTextQuadrantModule
Four standard images with text, presented on a grid of four quadrants.


|Name|Description|Schema|
|---|---|---|
|**block1**  <br>*required*|The A+ Content standard image and text box block.|[StandardImageTextBlock](#standardimagetextblock)|
|**block2**  <br>*required*|The A+ Content standard image and text box block.|[StandardImageTextBlock](#standardimagetextblock)|
|**block3**  <br>*required*|The A+ Content standard image and text box block.|[StandardImageTextBlock](#standardimagetextblock)|
|**block4**  <br>*required*|The A+ Content standard image and text box block.|[StandardImageTextBlock](#standardimagetextblock)|


<a name="standardheaderimagetextmodule"></a>
### StandardHeaderImageTextModule
Standard headline text, an image, and body text.


|Name|Description|Schema|
|---|---|---|
|**headline**  <br>*optional*|Rich text content.|[TextComponent](#textcomponent)|
|**block**  <br>*optional*|The A+ Content standard image and text box block.|[StandardImageTextBlock](#standardimagetextblock)|


<a name="standardimagesidebarmodule"></a>
### StandardImageSidebarModule
Two images, two paragraphs, and two bulleted lists. One image is smaller and displayed in the sidebar.


|Name|Description|Schema|
|---|---|---|
|**headline**  <br>*optional*|Rich text content.|[TextComponent](#textcomponent)|
|**imageCaptionBlock**  <br>*optional*|The A+ Content standard image and caption block.|[StandardImageCaptionBlock](#standardimagecaptionblock)|
|**descriptionTextBlock**  <br>*optional*|The A+ Content standard text box block, comprised of a paragraph with a headline.|[StandardTextBlock](#standardtextblock)|
|**descriptionListBlock**  <br>*optional*|The A+ Content standard fixed length list of text, usually presented as bullet points.|[StandardTextListBlock](#standardtextlistblock)|
|**sidebarImageTextBlock**  <br>*optional*|The A+ Content standard image and text box block.|[StandardImageTextBlock](#standardimagetextblock)|
|**sidebarListBlock**  <br>*optional*|The A+ Content standard fixed length list of text, usually presented as bullet points.|[StandardTextListBlock](#standardtextlistblock)|


<a name="standardimagetextoverlaymodule"></a>
### StandardImageTextOverlayModule
A standard background image with a floating text box.


|Name|Description|Schema|
|---|---|---|
|**overlayColorType**  <br>*required*|The relative color scheme of content.|[ColorType](#colortype)|
|**block**  <br>*optional*|The A+ Content standard image and text box block.|[StandardImageTextBlock](#standardimagetextblock)|


<a name="standardmultipleimagetextmodule"></a>
### StandardMultipleImageTextModule
Standard images with text, presented one at a time. The user clicks on thumbnails to view each block.


|Name|Schema|
|---|---|
|**blocks**  <br>*optional*|< [StandardImageTextCaptionBlock](#standardimagetextcaptionblock) > array|


<a name="standardproductdescriptionmodule"></a>
### StandardProductDescriptionModule
Standard product description text.


|Name|Description|Schema|
|---|---|---|
|**body**  <br>*required*|A list of rich text content, usually presented in a text box.|[ParagraphComponent](#paragraphcomponent)|


<a name="standardsingleimagehighlightsmodule"></a>
### StandardSingleImageHighlightsModule
A standard image with several paragraphs and a bulleted list.


|Name|Description|Schema|
|---|---|---|
|**image**  <br>*optional*|A reference to an image, hosted in the A+ Content media library.|[ImageComponent](#imagecomponent)|
|**headline**  <br>*optional*|Rich text content.|[TextComponent](#textcomponent)|
|**textBlock1**  <br>*optional*|The A+ Content standard text box block, comprised of a paragraph with a headline.|[StandardTextBlock](#standardtextblock)|
|**textBlock2**  <br>*optional*|The A+ Content standard text box block, comprised of a paragraph with a headline.|[StandardTextBlock](#standardtextblock)|
|**textBlock3**  <br>*optional*|The A+ Content standard text box block, comprised of a paragraph with a headline.|[StandardTextBlock](#standardtextblock)|
|**bulletedListBlock**  <br>*optional*|The A+ standard fixed-length list of text, with a related headline.|[StandardHeaderTextListBlock](#standardheadertextlistblock)|


<a name="standardsingleimagespecsdetailmodule"></a>
### StandardSingleImageSpecsDetailModule
A standard image with paragraphs and a bulleted list, and extra space for technical details.


|Name|Description|Schema|
|---|---|---|
|**headline**  <br>*optional*|Rich text content.|[TextComponent](#textcomponent)|
|**image**  <br>*optional*|A reference to an image, hosted in the A+ Content media library.|[ImageComponent](#imagecomponent)|
|**descriptionHeadline**  <br>*optional*|Rich text content.|[TextComponent](#textcomponent)|
|**descriptionBlock1**  <br>*optional*|The A+ Content standard text box block, comprised of a paragraph with a headline.|[StandardTextBlock](#standardtextblock)|
|**descriptionBlock2**  <br>*optional*|The A+ Content standard text box block, comprised of a paragraph with a headline.|[StandardTextBlock](#standardtextblock)|
|**specificationHeadline**  <br>*optional*|Rich text content.|[TextComponent](#textcomponent)|
|**specificationListBlock**  <br>*optional*|The A+ standard fixed-length list of text, with a related headline.|[StandardHeaderTextListBlock](#standardheadertextlistblock)|
|**specificationTextBlock**  <br>*optional*|The A+ Content standard text box block, comprised of a paragraph with a headline.|[StandardTextBlock](#standardtextblock)|


<a name="standardsinglesideimagemodule"></a>
### StandardSingleSideImageModule
A standard headline and body text with an image on the side.


|Name|Description|Schema|
|---|---|---|
|**imagePositionType**  <br>*required*|The relative positioning of content.|[PositionType](#positiontype)|
|**block**  <br>*optional*|The A+ Content standard image and text box block.|[StandardImageTextBlock](#standardimagetextblock)|


<a name="standardtechspecsmodule"></a>
### StandardTechSpecsModule
The standard table of technical feature names and definitions.


|Name|Description|Schema|
|---|---|---|
|**headline**  <br>*optional*|Rich text content.|[TextComponent](#textcomponent)|
|**specificationList**  <br>*required*|The specification list.|< [StandardTextPairBlock](#standardtextpairblock) > array|
|**tableCount**  <br>*optional*|The number of tables to present. Features are evenly divided between the tables.  <br>**Minimum value** : `1`  <br>**Maximum value** : `2`|integer|


<a name="standardtextmodule"></a>
### StandardTextModule
A standard headline and body text.


|Name|Description|Schema|
|---|---|---|
|**headline**  <br>*optional*|Rich text content.|[TextComponent](#textcomponent)|
|**body**  <br>*required*|A list of rich text content, usually presented in a text box.|[ParagraphComponent](#paragraphcomponent)|


<a name="standardthreeimagetextmodule"></a>
### StandardThreeImageTextModule
Three standard images with text, presented across a single row.


|Name|Description|Schema|
|---|---|---|
|**headline**  <br>*optional*|Rich text content.|[TextComponent](#textcomponent)|
|**block1**  <br>*optional*|The A+ Content standard image and text box block.|[StandardImageTextBlock](#standardimagetextblock)|
|**block2**  <br>*optional*|The A+ Content standard image and text box block.|[StandardImageTextBlock](#standardimagetextblock)|
|**block3**  <br>*optional*|The A+ Content standard image and text box block.|[StandardImageTextBlock](#standardimagetextblock)|


<a name="standardcomparisonproductblock"></a>
### StandardComparisonProductBlock
The A+ Content standard comparison product block.


|Name|Description|Schema|
|---|---|---|
|**position**  <br>*required*|The rank or index of this comparison product block within the module. Different blocks cannot occupy the same position within a single module.  <br>**Minimum value** : `1`  <br>**Maximum value** : `6`|integer|
|**image**  <br>*optional*|A reference to an image, hosted in the A+ Content media library.|[ImageComponent](#imagecomponent)|
|**title**  <br>*optional*|The comparison product title.<br>**minLength** : 1<br>**maxLength** : 80|string|
|**asin**  <br>*optional*|The Amazon Standard Identification Number (ASIN).|[Asin](#asin)|
|**highlight**  <br>*optional*|Determines whether this block of content is visually highlighted.|boolean|
|**metrics**  <br>*optional*|Comparison metrics for the product.|< [PlainTextItem](#plaintextitem) > array|


<a name="standardheadertextlistblock"></a>
### StandardHeaderTextListBlock
The A+ standard fixed-length list of text, with a related headline.


|Name|Description|Schema|
|---|---|---|
|**headline**  <br>*optional*|Rich text content.|[TextComponent](#textcomponent)|
|**block**  <br>*optional*|The A+ Content standard fixed length list of text, usually presented as bullet points.|[StandardTextListBlock](#standardtextlistblock)|


<a name="standardtextlistblock"></a>
### StandardTextListBlock
The A+ Content standard fixed length list of text, usually presented as bullet points.


|Name|Schema|
|---|---|
|**textList**  <br>*required*|< [TextItem](#textitem) > array|


<a name="standardimagetextcaptionblock"></a>
### StandardImageTextCaptionBlock
The A+ Content standard image and text block, with a related caption. The caption may not display on all devices.


|Name|Description|Schema|
|---|---|---|
|**block**  <br>*optional*|The A+ Content standard image and text box block.|[StandardImageTextBlock](#standardimagetextblock)|
|**caption**  <br>*optional*|Rich text content.|[TextComponent](#textcomponent)|


<a name="standardimagecaptionblock"></a>
### StandardImageCaptionBlock
The A+ Content standard image and caption block.


|Name|Description|Schema|
|---|---|---|
|**image**  <br>*optional*|A reference to an image, hosted in the A+ Content media library.|[ImageComponent](#imagecomponent)|
|**caption**  <br>*optional*|Rich text content.|[TextComponent](#textcomponent)|


<a name="standardimagetextblock"></a>
### StandardImageTextBlock
The A+ Content standard image and text box block.


|Name|Description|Schema|
|---|---|---|
|**image**  <br>*optional*|A reference to an image, hosted in the A+ Content media library.|[ImageComponent](#imagecomponent)|
|**headline**  <br>*optional*|Rich text content.|[TextComponent](#textcomponent)|
|**body**  <br>*optional*|A list of rich text content, usually presented in a text box.|[ParagraphComponent](#paragraphcomponent)|


<a name="standardtextblock"></a>
### StandardTextBlock
The A+ Content standard text box block, comprised of a paragraph with a headline.


|Name|Description|Schema|
|---|---|---|
|**headline**  <br>*optional*|Rich text content.|[TextComponent](#textcomponent)|
|**body**  <br>*optional*|A list of rich text content, usually presented in a text box.|[ParagraphComponent](#paragraphcomponent)|


<a name="standardtextpairblock"></a>
### StandardTextPairBlock
The A+ Content standard label and description block, comprised of a pair of text components.


|Name|Description|Schema|
|---|---|---|
|**label**  <br>*optional*|Rich text content.|[TextComponent](#textcomponent)|
|**description**  <br>*optional*|Rich text content.|[TextComponent](#textcomponent)|


<a name="textitem"></a>
### TextItem
Rich positional text, usually presented as a collection of bullet points.


|Name|Description|Schema|
|---|---|---|
|**position**  <br>*required*|The rank or index of this text item within the collection. Different items cannot occupy the same position within a single collection.  <br>**Minimum value** : `1`  <br>**Maximum value** : `100`|integer|
|**text**  <br>*required*|Rich text content.|[TextComponent](#textcomponent)|


<a name="plaintextitem"></a>
### PlainTextItem
Plain positional text, used in collections of brief labels and descriptors.


|Name|Description|Schema|
|---|---|---|
|**position**  <br>*required*|The rank or index of this text item within the collection. Different items cannot occupy the same position within a single collection.  <br>**Minimum value** : `1`  <br>**Maximum value** : `100`|integer|
|**value**  <br>*required*|The actual plain text.<br>**minLength** : 1<br>**maxLength** : 250|string|


<a name="imagecomponent"></a>
### ImageComponent
A reference to an image, hosted in the A+ Content media library.


|Name|Description|Schema|
|---|---|---|
|**uploadDestinationId**  <br>*required*|This identifier is provided by the Selling Partner API for Uploads.<br>**minLength** : 1<br>|string|
|**imageCropSpecification**  <br>*required*|The instructions for optionally cropping an image. If no cropping is desired, set the dimensions to the original image size. If the image is cropped and no offset values are provided, then the coordinates of the top left corner of the cropped image, relative to the original image, are defaulted to (0,0).|[ImageCropSpecification](#imagecropspecification)|
|**altText**  <br>*required*|The alternative text for the image.<br>**minLength** : 1<br>**maxLength** : 100|string|


<a name="paragraphcomponent"></a>
### ParagraphComponent
A list of rich text content, usually presented in a text box.


|Name|Schema|
|---|---|
|**textList**  <br>*required*|< [TextComponent](#textcomponent) > array|


<a name="textcomponent"></a>
### TextComponent
Rich text content.


|Name|Description|Schema|
|---|---|---|
|**value**  <br>*required*|The actual plain text.<br>**minLength** : 1<br>**maxLength** : 10000|string|
|**decoratorSet**  <br>*optional*|A set of content decorators.|[DecoratorSet](#decoratorset)|


<a name="colortype"></a>
### ColorType
The relative color scheme of content.

*Type* : enum


|Value|Description|
|---|---|
|**DARK**|Dark grey, semi-opaque shaded background for light text overlay box.|
|**LIGHT**|White, semi-opaque shaded background for dark text overlay box.|


<a name="positiontype"></a>
### PositionType
The relative positioning of content.

*Type* : enum


|Value|Description|
|---|---|
|**LEFT**|Indicates that the content is to be positioned on the left side of the module.|
|**RIGHT**|Indicates that the content is to be positioned on the right side of the module.|


<a name="decoratorset"></a>
### DecoratorSet
A set of content decorators.

*Type* : < [Decorator](#decorator) > array

**Unique items** : true  

<a name="decorator"></a>
### Decorator
A decorator applied to a content string value in order to create rich text.


|Name|Description|Schema|
|---|---|---|
|**type**  <br>*optional*|The type of rich text decorator.|[DecoratorType](#decoratortype)|
|**offset**  <br>*optional*|The starting character of this decorator within the content string. Use zero for the first character.  <br>**Minimum value** : `0`  <br>**Maximum value** : `10000`|integer|
|**length**  <br>*optional*|The number of content characters to alter with this decorator. Decorators such as line breaks can have zero length and fit between characters.  <br>**Minimum value** : `0`  <br>**Maximum value** : `10000`|integer|
|**depth**  <br>*optional*|The relative intensity or variation of this decorator. Decorators such as bullet-points, for example, can have multiple indentation depths.  <br>**Minimum value** : `0`  <br>**Maximum value** : `100`|integer|


<a name="decoratortype"></a>
### DecoratorType
The type of rich text decorator.

*Type* : enum


|Value|Description|
|---|---|
|**LIST_ITEM**|Formatted list item, used in either numbered or bulleted lists, inside the list enclosure.|
|**LIST_ORDERED**|Numbered list enclosure.|
|**LIST_UNORDERED**|Bulleted list enclosure.|
|**STYLE_BOLD**|Bold text formatting.|
|**STYLE_ITALIC**|Italic text formatting.|
|**STYLE_LINEBREAK**|New line of text.|
|**STYLE_PARAGRAPH**|Paragraph text formatting.|
|**STYLE_UNDERLINE**|Underline text formatting.|


<a name="searchcontentdocumentsresponse"></a>
### SearchContentDocumentsResponse
*Polymorphism* : Composition


|Name|Description|Schema|
|---|---|---|
|**warnings**  <br>*optional*|A set of messages to the user, such as warnings or comments.|[MessageSet](#messageset)|
|**nextPageToken**  <br>*optional*|A page token that is returned when the results of the call exceed the page size. To get another page of results, call the operation again, passing in this value with the pageToken parameter.|[PageToken](#pagetoken)|
|**contentMetadataRecords**  <br>*required*|The content metadata records.|[ContentMetadataRecordList](#contentmetadatarecordlist)|


<a name="getcontentdocumentincludeddatatype"></a>
### GetContentDocumentIncludedDataType
The type of data to include in the response, such as the contents or the metadata of the A+ Content documents.

*Type* : enum


|Value|Description|
|---|---|
|**CONTENTS**|The contents of the content document.|
|**METADATA**|The metadata of the content document.|


<a name="getcontentdocumentresponse"></a>
### GetContentDocumentResponse
*Polymorphism* : Composition


|Name|Description|Schema|
|---|---|---|
|**warnings**  <br>*optional*|A set of messages to the user, such as warnings or comments.|[MessageSet](#messageset)|
|**contentRecord**  <br>*required*|A content document with additional information for content management.|[ContentRecord](#contentrecord)|


<a name="postcontentdocumentrequest"></a>
### PostContentDocumentRequest

|Name|Description|Schema|
|---|---|---|
|**contentDocument**  <br>*required*|The A+ Content document. This is the enhanced content that is published to product detail pages.|[ContentDocument](#contentdocument)|


<a name="postcontentdocumentresponse"></a>
### PostContentDocumentResponse
*Polymorphism* : Composition


|Name|Description|Schema|
|---|---|---|
|**warnings**  <br>*optional*|A set of messages to the user, such as warnings or comments.|[MessageSet](#messageset)|
|**contentReferenceKey**  <br>*required*|A unique reference key for the A+ Content document. A content reference key cannot form a permalink and may change in the future. A content reference key is not guaranteed to match any A+ content identifier.|[ContentReferenceKey](#contentreferencekey)|


<a name="listcontentdocumentasinrelationsincludeddatatype"></a>
### ListContentDocumentAsinRelationsIncludedDataType
The type of data to include in the response, such as metadata about the related ASINs.

*Type* : enum


|Value|Description|
|---|---|
|**METADATA**|The metadata of the content document.|


<a name="listcontentdocumentasinrelationsresponse"></a>
### ListContentDocumentAsinRelationsResponse
*Polymorphism* : Composition


|Name|Description|Schema|
|---|---|---|
|**warnings**  <br>*optional*|A set of messages to the user, such as warnings or comments.|[MessageSet](#messageset)|
|**nextPageToken**  <br>*optional*|A page token that is returned when the results of the call exceed the page size. To get another page of results, call the operation again, passing in this value with the pageToken parameter.|[PageToken](#pagetoken)|
|**asinMetadataSet**  <br>*required*|The set of ASIN metadata.|[AsinMetadataSet](#asinmetadataset)|


<a name="postcontentdocumentasinrelationsrequest"></a>
### PostContentDocumentAsinRelationsRequest

|Name|Description|Schema|
|---|---|---|
|**asinSet**  <br>*required*|The set of ASINs.|[AsinSet](#asinset)|


<a name="postcontentdocumentasinrelationsresponse"></a>
### PostContentDocumentAsinRelationsResponse
*Polymorphism* : Composition


|Name|Description|Schema|
|---|---|---|
|**warnings**  <br>*optional*|A set of messages to the user, such as warnings or comments.|[MessageSet](#messageset)|


<a name="validatecontentdocumentasinrelationsresponse"></a>
### ValidateContentDocumentAsinRelationsResponse
*Polymorphism* : Composition


|Name|Description|Schema|
|---|---|---|
|**warnings**  <br>*optional*|A set of messages to the user, such as warnings or comments.|[MessageSet](#messageset)|
|**errors**  <br>*required*|A list of error responses returned when a request is unsuccessful.|< [Error](#error) > array|


<a name="searchcontentpublishrecordsresponse"></a>
### SearchContentPublishRecordsResponse
*Polymorphism* : Composition


|Name|Description|Schema|
|---|---|---|
|**warnings**  <br>*optional*|A set of messages to the user, such as warnings or comments.|[MessageSet](#messageset)|
|**nextPageToken**  <br>*optional*|A page token that is returned when the results of the call exceed the page size. To get another page of results, call the operation again, passing in this value with the pageToken parameter.|[PageToken](#pagetoken)|
|**publishRecordList**  <br>*required*|A list of A+ Content publishing records.|[PublishRecordList](#publishrecordlist)|


<a name="postcontentdocumentapprovalsubmissionresponse"></a>
### PostContentDocumentApprovalSubmissionResponse
*Polymorphism* : Composition


|Name|Description|Schema|
|---|---|---|
|**warnings**  <br>*optional*|A set of messages to the user, such as warnings or comments.|[MessageSet](#messageset)|


<a name="postcontentdocumentsuspendsubmissionresponse"></a>
### PostContentDocumentSuspendSubmissionResponse
*Polymorphism* : Composition


|Name|Description|Schema|
|---|---|---|
|**warnings**  <br>*optional*|A set of messages to the user, such as warnings or comments.|[MessageSet](#messageset)|


<a name="includeddataset"></a>
### IncludedDataSet
*Type* : enum

<a id="includeddataset-subgroup-1"></a>**For use with the definition(s): [GetContentDocument](#getcontentdocument)**

|Value|Description|
|---|---|
|**CONTENTS**|The contents of the content document.|
|**METADATA**|The metadata of the content document.|

<a id="includeddataset-subgroup-2"></a>**For use with the definition(s): [ListContentDocumentAsinRelations](#listcontentdocumentasinrelations)**

|Value|Description|
|---|---|
|**METADATA**|The metadata of the content document.|

