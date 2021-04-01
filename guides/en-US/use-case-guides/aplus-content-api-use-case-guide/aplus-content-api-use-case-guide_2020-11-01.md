A+ Content API Use Case Guide
=============================

Version: 2020-11-01

Contents
========

- [What is the A+ Content API?](#what-is-the-a+-content-api)
  - [Selling Partner API roles](#Selling-Partner-API-roles)
- [Tutorial: Create and edit A+ content and publish it to your ASINs](#tu#torial-create-and-edit-a-content-and-publish-it-to-your-asins)
  - [Prerequisites](#prerequisites)
  
  - [Step 1. Check existing A+ content](#Step-1-Check-existing-A+-content)
  
  - [Step 2. Create a content document](#step-2-create-a-content-document)
  
  - [Step 3. Get the content document approved for publication](#Step-3-Get-the-content-document-approved-for-publication)
  
- [Tutorial: Manage existing content](#Tutorial-Manage-existing-content)
  - [Task: Suspend a content document from all applied ASINs](#Task-Suspend-a-content-document-from-all-applied-ASINs)
  
  - [Task: Get previously published content](#Task-Get-previously-published-content)
  
  - [Task: Update a content document](#Task-Update-a-content-document)
  
  - [Task: Get the ASINs that are related to a content document](#Task-Get-the-ASINs-that-are-related-to-a-content-document)
  
  - [Task: Add or remove ASINs from a content document](#Task-Add-or-remove-ASINs-from-a-content-document)

What is the A+ Content API?
===========================

With the A+ Content API, you can build applications that enable selling partners to create and edit A+ content. This provides buyers with rich, high-quality content to help them make purchasing decisions.

## Selling Partner API roles

To access the A+ Content API, you must have the Product Listing role. You can request the Product Listing role when you [register as a developer](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/developer-guide/SellingPartnerApiDeveloperGuide.md#registering-as-a-developer), or by updating your existing Developer Profile at [https://sellercentral.amazon.com/developer/register](https://sellercentral.amazon.com/developer/register). In the **Roles** section of the Developer Profile form, select the **Product** **Listing** checkbox. Then in the text box in the **Use Cases** section, indicate that you want to use the A+ Content API. Click **Register** to submit your request, and a support case will be automatically created for you. We will review your request and contact you with next steps through your support case. You can access your support case in the Case Log in Seller Central. Also, when you [register your application](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/developer-guide/SellingPartnerApiDeveloperGuide.md#step-6-register-your-application), be sure to choose the Product Listing role. For more information about roles, see [Roles in the Selling Partner API](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/roles/Roles-in-the-Selling-Partner-API.md).

Tutorial: Create and edit A+ content and publish it to your ASINs
=================================================================

This tutorial shows you how to create a new content document, add ASINs to the content document, and get the content document approved for publication.

Prerequisites
-------------

To complete this tutorial you will need:

1.  Authorization from the selling partner for whom you are making calls. See [Selling Partner API Developer Guide](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md) for more information.
2.  One or more ASINs to which you would like to publish content.
3.  Content that you want to publish.

**Steps**

[Step 1. Check existing A+ content](#Step-1-Check-existing-A+-content)

[Step 2. Create a content document](#step-2-create-a-content-document)

[Step 3. Get the content document approved for publication](#Step-3-Get-the-content-document-approved-for-publication)

Step 1. Check existing A+ content
--------------------------------------------------

Before creating and publishing new A+ content, you can get information about the content documents that a selling partner has already created and published.

**Tasks**

[Task 1. Find out which content documents are published to an ASIN](#Task-1-Find-out-which-content-documents-are-published-to-an-ASIN)

[Task 2. Get all of the content documents created by the selling partner](#Task-2-Get-all-of-the-content-documents-created-by-the-selling-partner)

### Task 1. Find out which content documents are published to an ASIN

Call the searchContentPublishRecords operation to get a list of publishing records for content documents that the selling partner has already published to an ASIN. The selling partner can use this information to decide if they want to publish a new content document to that ASIN.

1.  Call the [searchContentPublishRecords](https://github.com/amzn/selling-partner-api-docs/blob/main/references/aplus-content-api/aplusContent_2020-11-01.md#searchcontentpublishrecords) operation, passing the following parameters:

Query parameters:

<table><thead><tr class="header"><th><strong>Parameter</strong></th><th><strong>Description</strong></th><th><strong>Required</strong></th></tr></thead><tbody><tr class="odd"><td><strong>asin</strong></td><td><p>The Amazon Standard Identification Number (ASIN).</p><p>Type: string</p></td><td>Yes</td></tr><tr class="even"><td><strong>marketplaceId</strong></td><td><p>The identifier for the marketplace where the A+ content is published. </p><p>Type: string</p></td><td>Yes</td></tr></tbody></table>

Request example:
```
GET https://sellingpartnerapi-na.amazon.com/aplus/2020-11-01/contentPublishRecords?marketplaceId=ATVPDKIKX0DER&asin=ZZZZZZZZZZ
```
**Response**

Response properties:

<table><thead><tr class="header"><th><strong>Name</strong></th><th><strong>Description</strong></th></tr></thead><tbody><tr class="odd"><td><strong>publishRecordList</strong></td><td><p>The list of A+ content publishing records.</p><p>Type: <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/aplus-content-api/aplusContent_2020-11-01.md#publishRecordList">PublishRecordList</a></p></td></tr><tr class="odd"><td><strong>warnings</strong></td><td><p>A set of messages to the user, such as warnings or comments.</p><p>Type: <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/aplus-content-api/aplusContent_2020-11-01.md#MessageSet">MessageSet</a></p></td></tr><tr class="odd"><td><strong>nextPageToken</strong></td><td><p>A page token that is returned when the results of the call exceed the page size. To get another page of results, call the operation again, passing in this value with the pageToken parameter.</p><p>Type: string</p></td></tr></tbody></table>

Response example:
```json
{
  "warnings": [],
  "nextPageToken": null,
  "publishRecordList": [{
      "marketplaceId": "ATVPDKIKX0DER",
      "locale": "en_US",
      "asin": "ZZZZZZZZZZ",
      "contentType": "EBC",
      "contentSubType": "",
      "contentReferenceKey": "d54a4096-f864-4326-bc80-ce8807497f98"
    }, {
      "marketplaceId": "ATVPDKIKX0DER",
      "locale": "es_US",
      "asin": "ZZZZZZZZZZ",
      "contentType": "EBC",
      "contentSubType": "",
      "contentReferenceKey": "f58cf4d7-b1b2-4f43-b900-5fd75cb688c5"
    }
  ]
}
```
2. To get the content documents and/or metadata for the records that are returned, call the [getContentDocument](https://github.com/amzn/selling-partner-api-docs/blob/main/references/aplus-content-api/aplusContent_2020-11-01.md#getcontentdocument) operation, passing in the contentReferenceKey value for the content document that you want.

### Task 2. Get all of the content documents created by the selling partner

Before creating a new content document it can be helpful for a selling partner to see all of the content documents that they have already created. This task shows you how to get the content documents that a selling partner has created, along with the associated metadata.

1. Call the [searchContentDocuments](https://github.com/amzn/selling-partner-api-docs/blob/main/references/aplus-content-api/aplusContent_2020-11-01.md#searchcontentdocuments) operation, passing in the following parameter:

Query parameter:

<table><thead><tr class="header"><th><strong>Parameter</strong></th><th><strong>Description</strong></th><th><strong>Required</strong></th></tr></thead><tbody><tr class="odd"><td><strong>marketplaceId</strong></td><td><p>The identifier for the marketplace where the A+ content is published.</p><p>Type: string</p></td><td>Yes</td></tr></tbody></table>

Request example:
```
GET https://sellingpartnerapi-na.amazon.com/aplus/2020-11-01/contentDocuments?marketplaceId=ATVPDKIKX0DER
```
**Response**

Response properties:

<table><thead><tr class="header"><th><strong>Name</strong></th><th><strong>Description</strong></th></tr></thead><tbody><tr class="odd"><td><strong>contentMetadataRecords</strong></td><td><p>The list of A+ content metadata records.</p><p>Type: <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/aplus-content-api/aplusContent_2020-11-01.md#ContentMetadataRecordList">ContentMetadataRecordList</a></p></td></tr><tr class="odd"><td><strong>warnings</strong></td><td><p>A set of messages to the user, such as warnings or comments.</p><p>Type: MessageSet</p></td></tr><tr class="even"><td><strong>nextPageToken</strong></td><td><p>A page token that is returned when the results of the call exceed the page size. To get another page of results, call the operation again, passing in this value with the pageToken parameter.</p><p>Type: string</p></td></tr></tbody></table>

Response example:
```json
{
  "warnings": [],
  "nextPageToken": null,
  "contentMetadataRecords": [{
      "contentReferenceKey": "436e986d-4a94-4511-a857-58802f3ba7b0",
      "contentMetadata": {
        "name": "Name of content document",
        "marketplaceId": "ATVPDKIKX0DER",
        "status": "DRAFT",
        "badgeSet": [null, "STANDARD"],
        "updateTime": null
      }
    }
  ]
}
```
2. To get the content documents for the records that are returned, call the [getContentDocument](https://github.com/amzn/selling-partner-api-docs/blob/main/references/aplus-content-api/aplusContent_2020-11-01.md#getcontentdocument) operation, passing in the contentReferenceKey value for the content documents that you want.

 Step 2. Create a content document
--------------------------------------

Creating a content document is a multi-step process that begins with constructing a content document.

**Tasks**

[Task 1. Construct a JSON content document](#Task-1-Construct-a-JSON-content-document)

[Task 2. Create upload destinations for images](#Task-2-Create-upload-destinations-for-images)

[Task 3. Upload images](#Task-3-Upload-images)

[Task 4. Submit the content document for validation](#Task-4-Submit-the-content-document-for-validation)

[Task 5. Create a content document](#Task-5-Create-a-content-document)

[Task 6. Add ASINs to the content document](#Task-6-Add-ASINs-to-the-content-document)

### Task 1. Construct a JSON content document

Construct a JSON content document, based on the [ContentDocument](https://github.com/amzn/selling-partner-api-docs/blob/main/references/aplus-content-api/aplusContent_2020-11-01.md#contentdocument) definition in the A+ Content API reference. See also [Content document example](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/use-case-guides/aplus-content-api-use-case-guide/aplus-content-api-content-document-examples_2020-11-01.md#Content-document-example) in the "A+ Content Examples" guide for an example of a content document and examples of content modules.

Content documents are composed of one or more content modules. Content documents for selling partners can contain up to seven modules, while content documents for vendors can contain up to five content modules.



ContentDocument definition:

|Name|Description|Schema|
|---|---|---|
|**name**  <br>*required*|The A+ Content document name.<br>**minLength** : 1<br>**maxLength** : 100|string|
|**contentType**  <br>*required*|The A+ Content document type.|[ContentType](https://github.com/amzn/selling-partner-api-docs/blob/main/references/aplus-content-api/aplusContent_2020-11-01.md#contenttype)|
|**contentSubType**  <br>*optional*|The A+ Content document subtype. This represents a special-purpose type of an A+ Content document. Not every A+ Content document type will have a subtype, and subtypes may change at any time.|[ContentSubType](https://github.com/amzn/selling-partner-api-docs/blob/main/references/aplus-content-api/aplusContent_2020-11-01.md#contentsubtype)|
|**locale**  <br>*required*|The IETF language tag. This only supports the primary language subtag with one secondary language subtag. The secondary language subtag is almost always a regional designation. This does not support additional subtags beyond the primary and secondary subtags.<br>**Pattern:** ^[a-z]{2,}-[A-Z0-9]{2,}$|[LanguageTag](https://github.com/amzn/selling-partner-api-docs/blob/main/references/aplus-content-api/aplusContent_2020-11-01.md#languagetag)|
|**contentModuleList**  <br>*required*|A list of A+ content modules.|[ContentModuleList](https://github.com/amzn/selling-partner-api-docs/blob/main/references/aplus-content-api/aplusContent_2020-11-01.md#contentmodulelist)|

contentDocument example:
```json
{
  "contentDocument": {
    "name": "Example content document",
    "contentType": "EMC",
    "locale": "en-US",
    "contentModuleList": [
      {
        "contentModuleType": "STANDARD_HEADER_IMAGE_TEXT",
        "standardHeaderImageText": {
          "headline": {
            "value": "Lorem ipsum",
            "decoratorSet": []
          },
          "block": {
            "image": {
              "uploadDestinationId": "SampleID",
              "imageCropSpecification": {
                "size": {
                  "width": {
                    "value": 970,
                    "units": "pixels"
                  },
                  "height": {
                    "value": 600,
                    "units": "pixels"
                  }
                },
                "offset": {
                  "x": {
                    "value": 7,
                    "units": "pixels"
                  },
                  "y": {
                    "value": 0,
                    "units": "pixels"
                  }
                }
              },
              "altText": "Lorem ipsum"
            },
            "headline": {
              "value": "Nunc faucibus neque auctor faucibus pretium.",
              "decoratorSet": []
            },
            "body": {
              "textList": [
                {
                  "value": "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc faucibus neque auctor faucibus pretium. Quisque sed blandit nunc. Pellentesque malesuada lorem vitae justo efficitur viverra.",
                  "decoratorSet": []
                }
              ]
            }
          }
        }
      }
    ]
  }
}
```

### Task 2. Create upload destinations for images

This task creates an upload destination for an image file and returns the information required to upload the image file to the destination. Complete this task for each image in your content document.

1. Call the [createUploadDestinationForResource](https://github.com/amzn/selling-partner-api-docs/blob/main/references/uploads-api/uploads_2020-11-01.md#createuploaddestinationforresource) operation of the Uploads API, passing in the following parameters:

Query parameters:

<table><thead><tr class="header"><th><strong>Parameter</strong></th><th><strong>Description</strong></th><th><strong>Required</strong></th></tr></thead><tbody><tr class="odd"><td><strong>marketplaceIds</strong></td><td><p>A list of marketplace identifiers. This specifies the marketplaces where the upload will be available. Only one marketplace can be specified.</p><p>Type: string</p></td><td>Yes</td></tr><tr class="even"><td><strong>contentMD5</strong></td><td><p>An MD5 hash of the content to be submitted to the upload destination. This value is used to determine if the data has been corrupted or tampered with during transit.</p><p>Type: string</p></td><td>Yes</td></tr><tr class="odd"><td><strong>contentType</strong></td><td><p>The content type of the file to be uploaded.</p><p>Type: string</p></td><td>No</td></tr></tbody></table>

Path parameter:

<table><thead><tr class="header"><th><strong>Parameter</strong></th><th><strong>Description</strong></th><th><strong>Required</strong></th></tr></thead><tbody><tr class="odd"><td><strong>resource</strong></td><td><p>The URL of the resource for the upload destination that you are creating. For example, to create an upload destination for a content document, the {resource} would be <font face=courier>/contentDocuments</font> and the path would be <font face=courier>/uploads/v1/uploadDestinations/aplus/2020-11-01/contentDocuments</font></p><p>Type: string</p></td><td>Yes</td></tr></tbody></table>

Request example:
```
POST https://sellingpartnerapi-na.amazon.com/uploads/2020-11-01/uploadDestinations/aplus/2020-11-01/contentDocuments?contentType=image/png&contentMD5=9e92dc1ed22ffc814f063f02b1c0f233&marketplaceIds=ATVPDKIKX0DER
```
**Response**

Response properties:

<table><thead><tr class="header"><th><strong>Name</strong></th><th><strong>Description</strong></th></tr></thead><tbody><tr class="odd"><td><strong>payload</strong></td><td><p>Information about an upload destination.</p><p>Type: <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/uploads-api/uploads_2020-11-01.md#uploaddestination">UploadDestination</a></p></td></tr><tr class="even"><td><strong>errors</strong></td><td><p>A list of error response returned when a request is unsuccessful.</p><p>Type: <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/uploads-api/uploads_2020-11-01.md#errorlist">ErrorList</a></p></td></tr></tbody></table>

Response example:
```json
{
  "errors": [],
  "payload": {
    "uploadDestinationId": "sc/7ae2d3b1-fdd3-42c4-98c4-9cc509fb95d8.png",
    "url": "https://aplus-media.s3.amazonaws.com/?x-amz-date=20201116T184623Z&x-amz-signature=c5c8efd95d883b6787a2b1a93c7c066f01cb4e8d7be3ece4360aa800332e0cf9&x-amz-meta-owner=A2CZ04NGKYDXDV&acl=private&key=sc/7ae2d3b1-fdd3-42c4-98c4-9cc509fb95d8.png&x-amz-algorithm=AWS4-HMAC-SHA256&policy=eyJjb25kaXRpb25zIjpbeyJidWNrZXQiOiJhcGx1cy1tZWRpYS1iZXRhIn0seyJrZXkiOiJzb3RhLzdhZTJkM2IxLWZkZDMtNDJjNC05OGM0LTljYzUwOWZiOTVkOC5wbmcifSx7ImFjbCI6InByaXZhdGUifSx7IngtYW16LW1ldGEtb3duZXIiOiJBMkNaMDROR0tZRFhEViJ9LHsieC1hbXotYWxnb3JpdGhtIjoiQVdTNC1ITUFDLVNIQTI1NiJ9LHsieC1hbXotY3JlZGVudGlhbCI6IkFLSUE2TDZSN1FFNTZGNkdNRzVFLzIwMjAxMTE2L3VzLWVhc3QtMS9zMy9hd3M0X3JlcXVlc3QifSx7IngtYW16LWRhdGUiOiIyMDIwMTExNlQxODQ2MjNaIn0sWyJjb250ZW50LWxlbmd0aC1yYW5nZSIsMSwzMTQ1NzI4XV0sImV4cGlyYXRpb24iOiIyMDIwLTExLTE2VDIxOjQ2OjIzLjg2OFoifQ==&x-amz-credential=AKIA6L6R7QE56F6GMG5E/20201116/us-east-1/s3/aws4_request",
    "headers": null
  }
}
```

2. Save the **uploadDestinationId** value to include in your content document in [Task 4. Submit the content document for validation](#Task-4-Submit-the-content-document-for-validation). Save the **url** value for [Task 3. Upload images](#Task-3-Upload-images).

### Task 3. Upload images

This task uploads an image file to the destination created in [Task 2. Create upload destinations for images](#Task-2-Create-upload-destinations-for-images). Complete this task for each image in your content document.

1. Use a cURL command to upload an image file (JPEG, PNG, or TIF), using the values in the **url** response element returned in the previous task.

Example cURL command:

```
curl -F "key=sc/7ae2d3b1-fdd3-42c4-98c4-9cc509fb95d8.png" \
-F "acl=private" \
-F "policy=eyJjb25kaXRpb25zIjpbeyJidWNrZXQiOiJhcGx1cy1tZWRpYS1iZXRhIn0seyJrZXkiOiJzb3RhLzdhZTJkM2IxLWZkZDMtNDJjNC05OGM0LTljYzUwOWZiOTVkOC5wbmcifSx7ImFjbCI6InByaXZhdGUifSx7IngtYW16LW1ldGEtb3duZXIiOiJBMkNaMDROR0tZRFhEViJ9LHsieC1hbXotYWxnb3JpdGhtIjoiQVdTNC1ITUFDLVNIQTI1NiJ9LHsieC1hbXotY3JlZGVudGlhbCI6IkFLSUE2TDZSN1FFNTZGNkdNRzVFLzIwMjAxMTE2L3VzLWVhc3QtMS9zMy9hd3M0X3JlcXVlc3QifSx7IngtYW16LWRhdGUiOiIyMDIwMTExNlQxODQ2MjNaIn0sWyJjb250ZW50LWxlbmd0aC1yYW5nZSIsMSwzMTQ1NzI4XV0sImV4cGlyYXRpb24iOiIyMDIwLTExLTE2VDIxOjQ2OjIzLjg2OFoifQ==" \
-F "x-amz-credential=AKIA6L6R7QE56F6GMG5E/20201116/us-east-1/s3/aws4_request" \
-F "x-amz-algorithm=AWS4-HMAC-SHA256" \
-F "x-amz-date=20201203T011128Z" \
-F "x-amz-signature=c5c8efd95d883b6787a2b1a93c7c066f01cb4e8d7be3ece4360aa800332e0cf9" \
-F "x-amz-meta-owner=A2CZ04NGKYDXDV" \
-F "file=@Sea.jpg" \
https://aplus-media.s3.amazonaws.com
```

2. Confirm that you receive a 200 status code in the response, which indicates that the image file was uploaded correctly.

### Task 4. Submit the content document for validation

Call the validateContentDocumentAsinRelations operation to submit your content document for automated validation against a set of ASINs that you specify.

1. If your content document includes images, add the **uploadDestinationId** values that you got from [Task 2. Create upload destinations for images](#Task-2-Create-upload-destinations-for-images) to your content document. See the request example below.
2. Call the [validateContentDocumentAsinRelations](https://github.com/amzn/selling-partner-api-docs/blob/main/references/aplus-content-api/aplusContent_2020-11-01.md#validatecontentdocumentasinrelations) operation, passing in the following parameters:

Query parameters:

<table><thead><tr class="header"><th><strong>Parameter</strong></th><th><strong>Description</strong></th><th><strong>Required</strong></th></tr></thead><tbody><tr class="odd"><td><strong>marketplaceId</strong></td><td><p>The Amazon marketplace identifier of where the A+ content is hosted or published.</p><p>Type: string</p></td><td>Yes</td></tr><tr class="even"><td><strong>asinSet</strong></td><td><p>The set of ASINs.</p><p>Type: &lt;string&gt; array(csv)</p></td><td>No</td></tr></tbody></table>

Body Parameter:

<table><thead><tr class="header"><th><strong>Parameter</strong></th><th><strong>Description</strong></th><th><strong>Required</strong></th></tr></thead><tbody><tr class="odd"><td><strong>postContentDocumentRequest</strong></td><td><p>The content document request details.</p><p>Type: <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/aplus-content-api/aplusContent_2020-11-01.md#PostContentDocumentRequest">PostContentDocumentRequest</a></p></td><td>Yes</td></tr></tbody></table>

Request example:
```
POST https: //sellingpartnerapi-na.amazon.com/aplus/2020-11-01/contentAsinValidations?marketplaceId=ATVPDKIKX0DER&asinSet=0123456789&asinSet=ZZZZZZZZZZ
{
  "contentDocument": {
    "name": "Example content document",
    "contentType": "EMC",
    "locale": "en-US",
    "contentModuleList": [
      {
        "contentModuleType": "STANDARD_HEADER_IMAGE_TEXT",
        "standardHeaderImageText": {
          "headline": {
            "value": "Lorem ipsum",
            "decoratorSet": []
          },
          "block": {
            "image": {
              "uploadDestinationId": "sc/7ae2d3b1-fdd3-42c4-98c4-9cc509fb95d8.png",
              "imageCropSpecification": {
                "size": {
                  "width": {
                    "value": 970,
                    "units": "pixels"
                  },
                  "height": {
                    "value": 600,
                    "units": "pixels"
                  }
                },
                "offset": {
                  "x": {
                    "value": 7,
                    "units": "pixels"
                  },
                  "y": {
                    "value": 0,
                    "units": "pixels"
                  }
                }
              },
              "altText": "Lorem ipsum"
            },
            "headline": {
              "value": "Nunc faucibus neque auctor faucibus pretium.",
              "decoratorSet": []
            },
            "body": {
              "textList": [
                {
                  "value": "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc faucibus neque auctor faucibus pretium. Quisque sed blandit nunc. Pellentesque malesuada lorem vitae justo efficitur viverra.",
                  "decoratorSet": []
                }
              ]
            }
          }
        }
      }
    ]
  }
}
```

**Response**

Error Response example:
```json
{
  "warnings": [],
  "errors": [
    {
      "code": "CONTENT_FAILED_VALIDATION",
      "message": "These keywords violate our community guidelines: $.",
      "details": ""
    }
  ]
}
```

Check for errors. If you receive an error, correct the error and retry. Repeat until you receive no errors.

**Note:** A 200 status code in the response means that Amazon ran a validation on your content document, not that your content document passed validation. Your content document has passed validation when the validateContentDocumentAsinRelations operation returns no errors.

### Task 5. Create a content document

Create a content document that you can later add ASINs to, submit for approval, and publish.

- Call the [createContentDocument](https://github.com/amzn/selling-partner-api-docs/blob/main/references/aplus-content-api/aplusContent_2020-11-01.md#createcontentdocument) operation, passing in the following parameters:

Query parameters:

<table><thead><tr class="header"><th><strong>Parameter</strong></th><th><strong>Description</strong></th><th><strong>Required</strong></th></tr></thead><tbody><tr class="odd"><td><strong>marketplaceId</strong></td><td><p>The identifier for the marketplace where the A+ content is published.</p><p>Type: string</p></td><td>Yes</td></tr></tbody></table>


Body parameters:

<table><thead><tr class="header"><th><strong>Parameter</strong></th><th><strong>Description</strong></th><th><strong>Required</strong></th></tr></thead><tbody><tr class="odd"><td><strong>postContentDocumentRequest</strong></td><td><p>The content document request details.</p><p>Type: <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/aplus-content-api/aplusContent_2020-11-01.md#PostContentDocumentRequest">PostContentDocumentRequest</a></p></td><td>Yes</td></tr></tbody></table>

Request example:
```
POST https://sellingpartnerapi-na.amazon.com/aplus/2020-11-01/contentDocuments?marketplaceId=ATVPDKIKX0DER
{
  "contentDocument": {
    "name": "Example content document",
    "contentType": "EMC",
    "locale": "en-US",
    "contentModuleList": [
      {
        "contentModuleType": "STANDARD_HEADER_IMAGE_TEXT",
        "standardHeaderImageText": {
          "headline": {
            "value": "Lorem ipsum",
            "decoratorSet": []
          },
          "block": {
            "image": {
              "uploadDestinationId": "sc/7ae2d3b1-fdd3-42c4-98c4-9cc509fb95d8.png",
              "imageCropSpecification": {
                "size": {
                  "width": {
                    "value": 970,
                    "units": "pixels"
                  },
                  "height": {
                    "value": 600,
                    "units": "pixels"
                  }
                },
                "offset": {
                  "x": {
                    "value": 7,
                    "units": "pixels"
                  },
                  "y": {
                    "value": 0,
                    "units": "pixels"
                  }
                }
              },
              "altText": "Lorem ipsum"
            },
            "headline": {
              "value": "Nunc faucibus neque auctor faucibus pretium.",
              "decoratorSet": []
            },
            "body": {
              "textList": [
                {
                  "value": "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc faucibus neque auctor faucibus pretium. Quisque sed blandit nunc. Pellentesque malesuada lorem vitae justo efficitur viverra.",
                  "decoratorSet": []
                }
              ]
            }
          }
        }
      }
    ]
  }
}
```

**Response**

Response properties:

<table><thead><tr class="header"><th><strong>Name</strong></th><th><strong>Description</strong></th></tr></thead><tbody><tr class="odd"><td><strong>warnings</strong></td><td><p>A set of messages to the user, such as warnings or comments.</p><p>Type: <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/aplus-content-api/aplusContent_2020-11-01.md#MessageSet">MessageSet</a></p></td></tr><tr class="even"><td><strong>contentReferenceKey</strong></td><td><p>A unique reference key for the A+ Content document. A content reference key cannot form a permalink and may change in the future. A content reference key is not guaranteed to match any A+ content identifier.</p><p>Type: <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/aplus-content-api/aplusContent_2020-11-01.md#ContentReferenceKey">ContentReferenceKey</a></p></td></tr></tbody></table>

Response example:
```json
{
  "warnings": [],
  "contentReferenceKey": "52c2534c-d37a-4854-b9b3-79e2f8a86bfa"
}
```

### Task 6. Add ASINs to the content document

Add ASINs to your content document.

1.  Call the postContentDocumentAsinRelations operation, passing in the following parameters:

Query parameter:

<table><thead><tr class="header"><th><strong>Parameter</strong></th><th><strong>Description</strong></th><th><strong>Required</strong></th></tr></thead><tbody><tr class="odd"><td><strong>marketplaceId</strong></td><td><p>The identifier for the marketplace where the A+ Content is published.</p><p>Type: string</p></td><td>Yes</td></tr></tbody></table>

Path parameter:

<table><thead><tr class="header"><th><strong>Parameter</strong></th><th><strong>Description</strong></th><th><strong>Required</strong></th></tr></thead><tbody><tr class="odd"><td><strong>contentReferenceKey</strong></td><td><p>The unique reference key for the A+ Content document. A content reference key cannot form a permalink and may change in the future. A content reference key is not guaranteed to match any A+ content identifier. Get this value from <a href="#Task-5-Create-a-content-document">Task 5. Create a content document</a>.</p><p>Type: string</p></td><td>Yes</td></tr></tbody></table>

Body parameters

<table><thead><tr class="header"><th><strong>Parameter</strong></th><th><strong>Description</strong></th><th><strong>Required</strong></th></tr></thead><tbody><tr class="odd"><td><strong>postContentDocumentAsinRelationsRequest</strong></td><td><p>The content document ASIN relations request details.</p><p>Type: <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/aplus-content-api/aplusContent_2020-11-01.md#PostContentDocumentAsinRelationsRequest">PostContentDocumentAsinRelationsRequest</a></p></td><td>Yes</td></tr></tbody></table>

Request example:
```
POST https: //sellingpartnerapi-na.amazon.com/aplus/2020-11-01/contentDocuments/52c2534c-d37a-4854-b9b3-79e2f8a86bfa/asins?marketplaceId=ATVPDKIKX0DER
{
  "asinSet": ["0123456789", "ZZZZZZZZZZ"]
}
```
**Response**

Response properties:

<table><thead><tr class="header"><th><strong>Name</strong></th><th><strong>Description</strong></th></tr></thead><tbody><tr class="odd"><td><strong>warnings</strong></td><td><p>The set of messages to the user, such as warnings or comments.</p><p>Type: <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/aplus-content-api/aplusContent_2020-11-01.md#MessageSet">MessageSet</a></p></td></tr></tbody></table>

Response example:
```json
{
  "warnings": []
}
```

## Step 3. Get the content document approved for publication

After creating your content document and adding ASINs to it, submit the content document for moderation and approval using the postContentDocumentApprovalSubmission operation. You can then check the submission status of your content document using the getContentDocument operation.

**Tasks**

[Task 1. Submit your content document for approval](#Task-1-Submit-your-content-document-for-approval)

[Task 2. Check the approval status of your submission](#Task-2-Check-the-approval-status-of-your-submission)

### Task 1. Submit your content document for approval

Call the postContentDocumentApprovalSubmission operation to submit your content documentation for moderation and approval.

1. Call the [postContentDocumentApprovalSubmission](https://github.com/amzn/selling-partner-api-docs/blob/main/references/aplus-content-api/aplusContent_2020-11-01.md#postcontentdocumentapprovalsubmission) operation, passing in the following parameters:

Path parameter:

<table><thead><tr class="header"><th><strong>Parameter</strong></th><th><strong>Description</strong></th><th><strong>Required</strong></th></tr></thead><tbody><tr class="odd"><td><strong>contentReferenceKey</strong></td><td><p>The unique reference key for the A+ Content document. A content reference key cannot form a permalink and may change in the future. A content reference key is not guaranteed to match any A+ content identifier. Get this value from <a href="#Task-5-Create-a-content-document">Task 5. Create a content document</a>.</p><p>Type: string</p></td><td>Yes</td></tr></tbody></table>

Query parameter:

<table><thead><tr class="header"><th><strong>Parameter</strong></th><th><strong>Description</strong></th><th><strong>Required</strong></th></tr></thead><tbody><tr class="odd"><td><strong>marketplaceId</strong></td><td><p>The identifier for the marketplace where the A+ Content is published.</p><p>Type: string</p></td><td>Yes</td></tr></tbody></table>

Request example:
```
POST https://sellingpartnerapi-na.amazon.com/aplus/2020-11-01/contentDocuments/52c2534c-d37a-4854-b9b3-79e2f8a86bfa/approvalSubmissions?marketplaceId=ATVPDKIKX0DER
```
**Response**

<table><thead><tr class="header"><th><strong>Name</strong></th><th><strong>Description</strong></th></tr></thead><tbody><tr class="odd"><td><strong>warnings</strong></td><td><p>A set of messages to the user, such as warnings or comments.</p><p>Type: <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/aplus-content-api/aplusContent_2020-11-01.md#MessageSet">MessageSet</a></p></td></tr></tbody></table>

Response example:
```json
{
  "warnings": [
    {
      "code": "ASIN_FAILED_VALIDATION",
      "message": "",
      "details": "0123456789"
    }
  ]
}
```

2. Check for warnings and errors. If you receive a warning or error, correct and retry. Repeat until you receive no warnings errors.

### Task 2. Check the approval status of your submission

Check the approval status of your submission by calling the getContentDocument operation. Call this operation no more than once an hour for each content document that you are checking for approval status.

1. Call the [getContentDocument](https://github.com/amzn/selling-partner-api-docs/blob/main/references/aplus-content-api/aplusContent_2020-11-01.md#getcontentdocument) operation, passing in the following parameters:

Path parameter:

<table><thead><tr class="header"><th><strong>Parameter</strong></th><th><strong>Description</strong></th><th><strong>Required</strong></th></tr></thead><tbody><tr class="odd"><td><strong>contentReferenceKey</strong></td><td><p>The unique reference key for the A+ Content document. A content reference key cannot form a permalink and may change in the future. A content reference key is not guaranteed to match any A+ content identifier. Get this value from <a href="#Task-5-Create-a-content-document">Task 5. Create a content document</a>.</p><p>Type: string</p></td><td>Yes</td></tr></tbody></table>

Query parameters:

<table><thead><tr class="header"><th><strong>Parameter</strong></th><th><strong>Description</strong></th><th><strong>Required</strong></th></tr></thead><tbody><tr class="odd"><td><strong>marketplaceId</strong></td><td><p>The identifier for the marketplace where the A+ Content is published.</p><p>Type: string</p></td><td>Yes</td></tr><tr class="even"><td><strong>includedDataSet</strong></td><td><p>The set of A+ Content data types to include in the response. Specify <font face=courier>METATDATA</font> to get the submission status and not the content document itself.</p><p>Type: <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/aplus-content-api/aplusContent_2020-11-01.md#IncludedDataSet">IncludedDataSet</a></p></td><td>Yes</td></tr></tbody></table>

Request example:
```
GET https://sellingpartnerapi-na.amazon.com/aplus/2020-11-01/contentDocuments/52c2534c-d37a-4854-b9b3-79e2f8a86bfa?marketplaceId=ATVPDKIKX0DER&includedDataSet=METADATA
```
**Response**

Response properties:

<table><thead><tr class="header"><th><strong>Name</strong></th><th><strong>Description</strong></th></tr></thead><tbody><tr class="odd"><td><strong>warnings</strong></td><td><p>A set of messages to the user, such as warnings or comments.</p><p>Type: <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/aplus-content-api/aplusContent_2020-11-01.md#MessageSet">MessageSet</a></p></td></tr><tr class="even"><td><strong>contentRecord</strong></td><td><p>A content document with additional information for content management. See the <strong>status</strong> property for the submission status.</p><p>Type: <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/aplus-content-api/aplusContent_2020-11-01.md#ContentRecord">ContentRecord</a></p></td></tr></tbody></table>

Response example:
```json
{
  "warnings": [],
  "contentRecord": {
    "contentReferenceKey": "52c2534c-d37a-4854-b9b3-79e2f8a86bfa",
    "contentMetadata": {
      "name": "Example content document",
      "marketplaceId": "ATVPDKIKX0DER",
      "status": "APPROVED",
      "badgeSet": ["STANDARD"],
      "updateTime": "2020-11-18T03:05:50.052Z"
    },
    "contentDocument": null
  }
}          
```

2. Check to the **status** property to find out the status of your submission. **status** property values:
    - **APPROVED.** The content is approved and will be published to the applied ASINs.
    - **REJECTED.**  The content has been rejected in moderation. Revise the content based on the provided rejection reasons and resubmit.
    - **DRAFT.** The content has not yet been submitted for approval. Wait a minimum of one hour and resubmit.
    - **SUBMITTED.** The content has been submitted for approval and is currently waiting for moderation. Wait a minimum of one hour and resubmit.

Tutorial: Manage existing content
===============================

This tutorial contains tasks for managing existing content.

[Task: Suspend a content document from all applied ASINs](#Task-Suspend-a-content-document-from-all-applied-ASINs)

[Task: Get previously published content](#Task-Get-previously-published-content)

[Task: Update a content document](#Task-Update-a-content-document)

[Task: Get the ASINs that are related to a content document](#Task-Get-the-ASINs-that-are-related-to-a-content-document)

[Task: Add or remove ASINs from a content document](#Task-Add-or-remove-ASINs-from-a-content-document)

## Task: Suspend a content document from all applied ASINs

Call the postContentDocumentSuspendSubmission operation to suspend a content document from all of its related ASINs.

**Note.** When you publish a content document to an ASIN that already has content published to it, or when you remove an ASIN from a content document, the existing content is automatically suspended from the ASIN. Therefore you don't need the postContentDocumentSuspendSubmission operation in those circumstances. 

1. Call the [postContentDocumentSuspendSubmission](https://github.com/amzn/selling-partner-api-docs/blob/main/references/aplus-content-api/aplusContent_2020-11-01.md#postcontentdocumentsuspendsubmission) operation, passing in the following parameters:

Path parameter:

<table><thead><tr class="header"><th><strong>Parameter</strong></th><th><strong>Description</strong></th><th><strong>Required</strong></th></tr></thead><tbody><tr class="odd"><td><strong>contentReferenceKey</strong></td><td><p>The unique reference key for the A+ Content document. A content reference key cannot form a permalink and may change in the future. A content reference key is not guaranteed to match any A+ content identifier. Get this value from <a href="#Task-5-Create-a-content-document">Task 5. Create a content document</a>.</p><p>Type: string</p></td><td>Yes</td></tr></tbody></table>

Query parameter:

<table><thead><tr class="header"><th><strong>Parameter</strong></th><th><strong>Description</strong></th><th><strong>Required</strong></th></tr></thead><tbody><tr class="odd"><td><strong>marketplaceId</strong></td><td><p>The identifier for the marketplace where the A+ Content is published.</p><p>Type: string</p></td><td>Yes</td></tr></tbody></table>

Request example:
```
POST https://sellingpartnerapi-na.amazon.com/aplus/2020-11-01/contentDocuments/52c2534c-d37a-4854-b9b3-79e2f8a86bfa/suspendSubmissions?marketplaceId=ATVPDKIKX0DER
```
**Response**

Response properties:

<table><thead><tr class="header"><th><strong>Name</strong></th><th><strong>Description</strong></th></tr></thead><tbody><tr class="odd"><td><strong>warnings</strong></td><td><p>A set of messages to the user, such as warnings or comments.</p><p>Type: <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/aplus-content-api/aplusContent_2020-11-01.md#MessageSet">MessageSet</a></p></td></tr></tbody></table>

Response example:

```json
{
  "warnings": []
}
```
## Task: Get previously published content

Call the [getContentDocument](https://github.com/amzn/selling-partner-api-docs/blob/main/references/aplus-content-api/aplusContent_2020-11-01.md#getcontentdocument) operation to get content previously published by the selling partner. Specify `includedDataSet=METADATA` to get content metadata. Specify `includedDataSet=CONTENTS` to get content documents.

Request example:
```
GET https://sellingpartnerapi-na.amazon.com/aplus/2020-11-01/contentDocuments/52c2534c-d37a-4854-b9b3-79e2f8a86bfa?marketplaceId=ATVPDKIKX0DER&includedDataSet=CONTENTS&includedDataSet=METADATA
```
**Response**

Response example:

```json
{
  "warnings": [],
  "contentRecord": {
    "contentReferenceKey": "52c2534c-d37a-4854-b9b3-79e2f8a86bfa",
    "contentMetadata": {
      "name": "Example content document",
      "marketplaceId": "ATVPDKIKX0DER",
      "status": "APPROVED",
      "badgeSet": ["STANDARD"],
      "updateTime": "2020-11-14T02:04:05.502Z"
    },
    "contentDocument": {
      "name": "Example content document",
      "contentType": "EMC",
      "locale": "en-US",
      "contentModuleList": [
        {
          "contentModuleType": "STANDARD_HEADER_IMAGE_TEXT",
          "standardHeaderImageText": {
            "headline": {
              "value": "Lorem ipsum",
              "decoratorSet": []
            },
            "block": {
              "image": {
                "uploadDestinationId": "sc/7ae2d3b1-fdd3-42c4-98c4-9cc509fb95d8.png",
                "imageCropSpecification": {
                  "size": {
                    "width": {
                      "value": 970,
                      "units": "pixels"
                    },
                    "height": {
                      "value": 600,
                      "units": "pixels"
                    }
                  },
                  "offset": {
                    "x": {
                      "value": 7,
                      "units": "pixels"
                    },
                    "y": {
                      "value": 0,
                      "units": "pixels"
                    }
                  }
                },
                "altText": "Lorem ipsum"
              },
              "headline": {
                "value": "Nunc faucibus neque auctor faucibus pretium.",
                "decoratorSet": []
              },
              "body": {
                "textList": [
                  {
                    "value": "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc faucibus neque auctor faucibus pretium. Quisque sed blandit nunc. Pellentesque malesuada lorem vitae justo efficitur viverra.",
                    "decoratorSet": []
                  }
                ]
              }
            }
          }
        }
      ]
    }
  }
}
```

## Task: Update a content document

Call the updateContentDocument operation to edit an existing content document.

1. Call the [updateContentDocument](https://github.com/amzn/selling-partner-api-docs/blob/main/references/aplus-content-api/aplusContent_2020-11-01.md#updatecontentdocument) operation, passing in the following parameters:

Path parameter:

<table><thead><tr class="header"><th><strong>Parameter</strong></th><th><strong>Description</strong></th><th><strong>Required</strong></th></tr></thead><tbody><tr class="odd"><td><strong>contentReferenceKey</strong></td><td><p>The unique reference key for the A+ Content document. A content reference key cannot form a permalink and may change in the future. A content reference key is not guaranteed to match any A+ content identifier. Get this value from <a href="#Task-5-Create-a-content-document">Task 5. Create a content document</a>.</p><p>Type: string</p></td><td>Yes</td></tr></tbody></table>

Query parameter:

<table><thead><tr class="header"><th><strong>Parameter</strong></th><th><strong>Description</strong></th><th><strong>Required</strong></th></tr></thead><tbody><tr class="odd"><td><strong>marketplaceId</strong></td><td><p>The identifier for the marketplace where the A+ Content is published.</p><p>Type: string</p></td><td>Yes</td></tr></tbody></table>

Body parameter:

<table><thead><tr class="header"><th><strong>Parameter</strong></th><th><strong>Description</strong></th><th><strong>Required</strong></th></tr></thead><tbody><tr class="odd"><td><strong>postContentDocumentRequest</strong></td><td><p>The content document request details.</p><p>Type: <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/aplus-content-api/aplusContent_2020-11-01.md#PostContentDocumentRequest">PostContentDocumentRequest</a></p></td><td>Yes</td></tr></tbody></table>

Request example:
```
POST https: //sellingpartnerapi-na.amazon.com/aplus/2020-11-01/contentDocuments/52c2534c-d37a-4854-b9b3-79e2f8a86bfa?marketplaceId=ATVPDKIKX0DER
{
  "contentDocument": {
    "name": "Example content document",
    "contentType": "EMC",
    "locale": "en-US",
    "contentModuleList": [
      {
        "contentModuleType": "STANDARD_HEADER_IMAGE_TEXT",
        "standardHeaderImageText": {
          "headline": {
            "value": "Example headline",
            "decoratorSet": []
          },
          "block": {
            "image": {
              "uploadDestinationId": "sc/7ae2d3b1-fdd3-42c4-98c4-9cc509fb95d8.png",
              "imageCropSpecification": {
                "size": {
                  "width": {
                    "value": 970,
                    "units": "pixels"
                  },
                  "height": {
                    "value": 600,
                    "units": "pixels"
                  }
                },
                "offset": {
                  "x": {
                    "value": 7,
                    "units": "pixels"
                  },
                  "y": {
                    "value": 0,
                    "units": "pixels"
                  }
                }
              },
              "altText": "Example alt text"
            },
            "headline": {
              "value": "Example heading",
              "decoratorSet": []
            },
            "body": {
              "textList": [
                {
                  "value": "Example text.",
                  "decoratorSet": []
                }
              ]
            }
          }
        }
      }
    ]
  }
}
```
**Response**

Response properties:

<table><thead><tr class="header"><th><strong>Name</strong></th><th><strong>Description</strong></th></tr></thead><tbody><tr class="odd"><td><strong>warnings</strong></td><td><p>A set of messages to the user, such as warnings or comments.</p><p>Type: <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/aplus-content-api/aplusContent_2020-11-01.md#MessageSet">MessageSet</a></p></td></tr><tr class="odd"><td><strong>contentReferenceKey</strong></td><td><p>The unique reference key for the A+ Content document. A content reference key cannot form a permalink and may change in the future. A content reference key is not guaranteed to match any A+ content identifier. </p><p>Type: string</p></td><td>Yes</td></tr></tbody></table>

Response example:
```json
{
  "warnings": [],
  "contentReferenceKey": "52c2534c-d37a-4854-b9b3-79e2f8a86bfa"
}
```

## Task: Get the ASINs that are related to a content document

If you need to find out which ASINs are related to a content document for the purposes of evaluating, adding, or removing ASINs from the content document, use the listContentDocumentAsinRelations operation. To get metadata for the purpose of sorting and evaluating ASINs, specify `includedDataSet=METADATA`. To reduce processing time when  the list of ASINs is known (for example, to check ASIN status for potential errors after publishing content documents), specify the ASINs using the **asinSet** parameter.

1. Call the [listContentDocumentAsinRelations](https://github.com/amzn/selling-partner-api-docs/blob/main/references/aplus-content-api/aplusContent_2020-11-01.md#listcontentdocumentasinrelations), passing in the following parameters:


Path parameter:

<table><thead><tr class="header"><th><strong>Parameter</strong></th><th><strong>Description</strong></th><th><strong>Required</strong></th></tr></thead><tbody><tr class="odd"><td><strong>contentReferenceKey</strong></td><td><p>The unique reference key for the A+ Content document. A content reference key cannot form a permalink and may change in the future. A content reference key is not guaranteed to match any A+ content identifier. Get this value from <a href="#Task-5-Create-a-content-document">Task 5. Create a content document</a>.</p><p>Type: string</p></td><td>Yes</td></tr></tbody></table>

Query parameters:

<table><thead><tr class="header"><th><strong>Parameter</strong></th><th><strong>Description</strong></th><th><strong>Required</strong></th></tr></thead><tbody><tr class="odd"><td><strong>marketplaceId</strong></td><td><p>The identifier for the marketplace where the A+ Content is published.</p><p>Type: string</p></td><td>Yes</td></tr><tr class="even"><td><strong>includedDataSet</strong></td><td><p>The set of A+ Content data types to include in the response.</p><p>Type: &lt; enum (<a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/aplus-content-api/aplusContent_2020-11-01.md#IncludedDataSet">IncludedDataSet</a>) &gt; array(csv)</p></td><td>No<p>Default: no metadata is returned.</p></td></tr><tr class="odd"><td><strong>asinSet</strong></td><td><p>The set of ASINs.</p><p>Type: &lt; string &gt; array(csv)</p></td><td>No<p> Default: all ASINs applied to the content document are returned.</p></td></tr></tbody></table>

Request example:
```
GET https://sellingpartnerapi-na.amazon.com/aplus/2020-11-01/contentDocuments/52c2534c-d37a-4854-b9b3-79e2f8a86bfa/asins?marketplaceId=ATVPDKIKX0DER&includedDataSet=METADATA&asinSet=0123456789&asinSet=ZZZZZZZZZZ
```
**Response**

Response properties:

<table><thead><tr class="header"><th><strong>Name</strong></th><th><strong>Description</strong></th></tr></thead><tbody><tr class="odd"><td><strong>warnings</strong></td><td><p>A set of messages to the user, such as warnings or comments.</p><p>Type: <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/aplus-content-api/aplusContent_2020-11-01.md#MessageSet">MessageSet</a></p></td></tr><tr class="even"><td><strong>nextPageToken</strong></td><td><p>A page token that is returned when the results of the call exceed the page size. To get another page of results, call the operation again, passing in this value with the pageToken parameter.</p><p>Type: <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/aplus-content-api/aplusContent_2020-11-01.md#PageToken">PageToken</a></p></td></tr><tr class="odd"><td><strong>asinMetadataSet</strong></td><td><p>The set of ASIN metadata.</p><p>Type: <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/aplus-content-api/aplusContent_2020-11-01.md#AsinMetadataSet">AsinMetadataSet</a></p></td></tr></tbody></table>

Response example:
```json
{
  "warnings": [],
  "nextPageToken": null,
  "asinMetadataSet": [
    {
      "asin": "ZZZZZZZZZZ",
      "badgeSet": null,
      "parent": "ZZZZZZZZZZ",
      "title": "Example title",
      "imageUrl": null,
      "contentReferenceKeySet": null
    }
  ]
}
```

## Task: Add or remove ASINs from a content document

Call the postContentDocumentAsinRelations operation to add or remove ASINs from a content document.

The ASINs that you post will replace all of the ASINs currently related to the content document. This could result in adding or removing ASINs, depending on the set of ASINs that are currently related to the content document. Removing an ASIN has the side-effect of suspending the content document from the ASIN. Be sure to always post the entire set of ASINs that you want to be related to the content document.

1. Call the [postContentDocumentAsinRelations](https://github.com/amzn/selling-partner-api-docs/blob/main/references/aplus-content-api/aplusContent_2020-11-01.md#postcontentdocumentasinrelations) operation, passing in the following parameters:

Path parameter:

<table><thead><tr class="header"><th><strong>Parameter</strong></th><th><strong>Description</strong></th><th><strong>Required</strong></th></tr></thead><tbody><tr class="odd"><td><strong>contentReferenceKey</strong></td><td><p>The unique reference key for the A+ Content document. A content reference key cannot form a permalink and may change in the future. A content reference key is not guaranteed to match any A+ content identifier. Get this value from <a href="#Task-5-Create-a-content-document">Task 5. Create a content document</a>.</p><p>Type: string</p></td><td>Yes</td></tr></tbody></table>

Query parameter:

<table><thead><tr class="header"><th><strong>Parameter</strong></th><th><strong>Description</strong></th><th><strong>Required</strong></th></tr></thead><tbody><tr class="odd"><td><strong>marketplaceId</strong></td><td><p>The identifier for the marketplace where the A+ Content is published.</p><p>Type: string</p></td><td>Yes</td></tr></tbody></table>

Body parameter:

<table><thead><tr class="header"><th><strong>Parameter</strong></th><th><strong>Description</strong></th><th><strong>Required</strong></th></tr></thead><tbody><tr class="odd"><td><strong>postContentDocumentAsinRelationsRequest</strong></td><td><p>The content document ASIN relations request details.</p><p>Type: <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/aplus-content-api/aplusContent_2020-11-01.md#PostContentDocumentAsinRelationsRequest">PostContentDocumentAsinRelationsRequest</a></p></td><td>Yes</td></tr></tbody></table>

Request example:
```
POST https: //sellingpartnerapi-na.amazon.com/aplus/2020-11-01/contentDocuments/52c2534c-d37a-4854-b9b3-79e2f8a86bfa/asins?marketplaceId=ATVPDKIKX0DER
{
  "asinSet": ["0123456789", "ZZZZZZZZZZ"]
}
```

**Response**

Response properties:

<table><thead><tr class="header"><th><strong>Name</strong></th><th><strong>Description</strong></th></tr></thead><tbody><tr class="odd"><td><strong>warnings</strong></td><td><p>A set of messages to the user, such as warnings or comments.</p><p>Type: <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/aplus-content-api/aplusContent_2020-11-01.md#MessageSet">MessageSet</a></p></td></tr></tbody></table>

Response example:
```json
{
  "warnings": []
}
```