# Feeds API Use Case Guide
Version: 2020-09-04

# Contents

- [What is the Feeds API?](#what-is-the-feeds-api)

  - [Workflow for submitting a feed](#workflow-for-submitting-a-feed)

  - [Terminology](#terminology)

- [Tutorial: Submit a feed](#tutorial-submit-a-feed)

  - [Step 1. Create a feed document](#step-1-create-a-feed-document)

  - [Step 2. Encrypt and upload the feed data](#step-2-encrypt-and-upload-the-feed-data)

    - [Encrypt and upload sample code (Java)](#encrypt-and-upload-sample-code-java)

  - [Step 3. Create a feed](#step-3-create-a-feed)

  - [Step 4. Confirm feed processing](#step-4-confirm-feed-processing)

  - [Step 5. Get information for retrieving the feed processing report](#step-5-get-information-for-retrieving-the-feed-processing-report)

  - [Step 6. Download and decrypt the feed processing report](#step-6-download-and-decrypt-the-feed-processing-report)

    - [Download and decrypt sample code (Java)](#download-and-decrypt-sample-code-java)

  - [Step 7. Check the feed processing report for errors](#step-7-check-the-feed-processing-report-for-errors)

- [Best practices](#best-practices)

# What is the Feeds API?

With the Selling Partner API for Feeds (Feeds API), you can build applications that enable sellers to upload information to Amazon that helps them manage their selling businesses. There are feeds for a wide variety of use cases, such as creating listings, managing inventory and prices, acknowledging orders, and more. See [feedType values](https://github.com/amzn/selling-partner-api-docs/blob/main/references/feeds-api/feedType_string_array_values.md) for a list of available feed types.

### Workflow for submitting a feed

Here are the high-level steps for submitting a feed:

1.  Call the [createFeedDocument](https://github.com/amzn/selling-partner-api-docs/blob/main/references/feeds-api/feeds_2020-09-04.md#createfeeddocument) operation, specifying the content type for the feed that you are submitting.

    Amazon returns a **feedDocumentId** value, encryption details, and a URL for uploading the feed contents.

2.  Encrypt and upload your feed document contents to the URL from the previous step.

3.  Call the [createFeed](https://github.com/amzn/selling-partner-api-docs/blob/main/references/feeds-api/feeds_2020-09-04.md#createfeed) operation. Use the **inputFeedDocumentId** parameter to pass in the **feedDocumentId** value from step 1. Specify the marketplaces that you want the feed to be applied to and any relevant feed options.

    Amazon returns a **feedId** value.

4.  Periodically call the [getFeed](https://github.com/amzn/selling-partner-api-docs/blob/main/references/feeds-api/feeds_2020-09-04.md#getfeed) operation, specifying the **feedId** value from step 3, until the feed moves into one of the following terminal states: DONE, CANCELLED, or FATAL. When the feed moves into the DONE state, proceed to Step 5. <p>Amazon returns the **resultFeedDocumentId** value when the feed moves into the DONE state.</p>

5.  Call the [getFeedDocument](https://github.com/amzn/selling-partner-api-docs/blob/main/references/feeds-api/feeds_2020-09-04.md#getfeeddocument) operation. Use the **feedDocumentId** parameter to pass in the **resultFeedDocumentId** value from the previous step.

    Amazon returns the **feedDocumentId** value, a URL for downloading the feed processing report, and the encryption details.

6.  Download and decrypt the feed processing report.

7.  Check the feed processing report for errors generated during feed processing. If there are errors, correct them and submit the corrected feed, starting at step 1. If there are no errors, your feed submission was successful.

For more details about submitting a feed, see [Tutorial: Submit a feed](#tutorial-submit-a-feed).

### Terminology

1.  **Cipher block chaining**. Cipher block chaining is an algorithm that uses a block cipher to provide information security such as confidentiality or authenticity. This algorithm uses an initialization vector and a key to encrypt the data.

2.  **S3 presigned URL**. A URL for an AWS S3 bucket to which you can upload an object without AWS security credentials or permissions. You get an **S3 presigned URL** in [Step 1. Create a feed document](#step-1-create-a-feed-document) and [Step 5. Get information for retrieving the feed processing report](#step-5-get-information-for-retrieving-the-feed-processing-report).

# Tutorial: Submit a feed

This tutorial shows you how to submit a feed, check the status of feed processing, and verify that your feed submission was successful. The tutorial contains Java code samples that can help you with tasks such as encrypting and uploading a feed and downloading and decrypting a feed processing report. You can use the principles demonstrated in these code samples to guide you in accomplishing these tasks using other programming languages.

**Prerequisites**

To complete this tutorial, you will need:

1.  A feed to submit. See [feedType values](https://github.com/amzn/selling-partner-api-docs/blob/main/references/feeds-api/feedType_string_array_values.md) for a list of available feed types.

1.  Authorization from the seller for whom you are making calls. See the [Selling Partner API Developer Guide](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md) for more information.

1.  A working Java Development Kit (JDK) installation, including the javax.crypto library.

1. The [Selling Partner API Documents Helper](https://github.com/amzn/selling-partner-api-models/tree/main/clients/sellingpartner-api-documents-helper-java).

1.  An understanding of client-side encryption using the cipher block chaining (CBC). For definitions, see [Terminology](#terminology).

**Steps**

[Step 1. Create a feed document](#step-1-create-a-feed-document)

[Step 2. Encrypt and upload the feed data](#step-2-encrypt-and-upload-the-feed-data)

[Step 3. Create a feed](#step-3-create-a-feed)

[Step 4. Confirm feed processing](#step-4-confirm-feed-processing)

[Step 5. Get information for retrieving the feed processing report](#step-5-get-information-for-retrieving-the-feed-processing-report)

[Step 6. Download and decrypt the feed processing report](#step-6-download-and-decrypt-the-feed-processing-report)

[Step 7. Check the feed processing report for errors](#download-and-decrypt-sample-code-java)

## Step 1. Create a feed document

Call the createFeedDocument operation to create a feed document.

1.  Call the [createFeedDocument](https://github.com/amzn/selling-partner-api-docs/blob/main/references/feeds-api/feeds_2020-09-04.md#createfeeddocument) operation, passing the following parameter:

Body parameter:

<table>
<thead>
<tr class="header">
<th><strong>Name</strong></th>
<th><strong>Description</strong></th>
<th><strong>Required</strong></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>contentType</td>
<td><p>The content type of the feed. Amazon recommends UTF-8 character encoding.</p>
<p><strong>Important.</strong> Use this <strong>contentType</strong> value in <a href="#step-2-encrypt-and-upload-the-feed-data">Step 2. Encrypt and upload the feed data</a>. Otherwise your feed data upload will fail.</p>
<p>Type: string</p></td>
<td>Yes</td>
</tr>
</tbody>
</table>

Request example:
```
POST https://sellingpartnerapi-na.amazon.com/feeds/2020-09-04/documents
{
  "contentType":"text/tab-separated-values; charset=UTF-8"
}
```
**Response**

A successful response includes the following:

<table>
<thead>
<tr class="header">
<th><strong>Name</strong></th>
<th><strong>Description</strong></th>
<th><strong>Required</strong></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>feedDocumentId</td>
<td><p>The identifier of the feed document.</p>
<p>Type: string</p></td>
<td>Yes</td>
</tr>
<tr class="even">
<td>url</td>
<td><p>The presigned URL for uploading the feed contents. This URL expires after 5 minutes.</p>
<p>Type: string</p></td>
<td>Yes</td>
</tr>
<tr class="odd">
<td>encryptionDetails</td>
<td><p>Encryption details for required client-side encryption of document contents.</p>
<p>Type: <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/feeds-api/feeds_2020-09-04.md#feeddocumentencryptiondetails">FeedDocumentEncryptionDetails</a></p></td>
<td>Yes</td>
</tr>
</tbody>
</table>

Response example:
```
{
  "payload":
  {
    "feedDocumentId":"amzn1.tortuga.3.920614b0-fc4c-4393-b0d9-fff175300000.T29XK4YL08B2VM",
    "url":"https://tortuga-prod-na.s3.amazonaws.com/%2FNinetyDays/amzn1.tortuga.3.920614b0-fc4c-4393-b0d9-fff175300000.T29XK4YL08B2VM?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Date=20200919T035824Z&X-Amz-SignedHeaders=<headers>&X-Amz-Expires=300&X-Amz-Credential=<credential>&X-Amz-Signature=<signature>",
    "encryptionDetails":
    {
      "standard":"AES",
      "initializationVector":"kF3bZt0FSv6JQEimfEJD8g==",
      "key":"5EZo/P06OGF0UAy8QuOnMIaQbkAvYBru6EGsFvK8wJ2="
    }
  }
```
2.  Save the following values:
    
      - **initializationVector**, **key**, and **url**. Use these values in [Step 2. Encrypt and upload the feed data](#step-2-encrypt-and-upload-the-feed-data).
    
      - **feedDocumentId**. Use this value in [Step 3. Create a feed](#step-3-create-a-feed). This **feedDocumentId** value expires after two days. If you pass in an expired **feedDocumentId** value to the createFeed operation, the call will fail.

## Step 2. Encrypt and upload the feed data

You can encrypt and upload feed data using the information returned in the previous step. The following sample code, along with the classes provided in the [Selling Partner API (SP-API) Documents Helper](https://github.com/amzn/selling-partner-api-models/tree/main/clients/sellingpartner-api-documents-helper-java), can help. You can also use the principles demonstrated in the sample code and in the SP-API Documents Helper to guide you in building applications in other programming languages.

The sample code has methods for creating an input stream from a string and creating a piped input stream.

**To create an input stream from a string**

  - Use the following as input for the sample code:
    
      - Your feed data is input to the ```ByteArrayInputStream``` class.
    
      - The **key**, **initializationVector**, and **url** values from the previous step are arguments for the ```key```, ```initializationVector```, and ```url``` parameters of the ```encryptAndUpload_fromString``` method of the ```UploadExample``` class.

**To create a piped input stream**

  - Use the following as input for the sample code:
    
      - Your feed data is input to the ```PipedInputStream``` by way of its connection to the ```PipedOutputStream```.
    
      - The **key**, **initializationVector**, and **url** values from the previous step are arguments for the ```key```, ```initializationVector```, and ```url``` parameters of the ```encryptAndUpload_fromPipedInputStream``` method of the ```UploadExample``` class.

### Encrypt and upload sample code (Java)
```JAVA
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.nio.charset.StandardCharsets;

import com.amazon.spapi.documents.UploadHelper;
import com.amazon.spapi.documents.UploadSpecification;
import com.amazon.spapi.documents.exception.CryptoException;
import com.amazon.spapi.documents.exception.HttpResponseException;
import com.amazon.spapi.documents.impl.AESCryptoStreamFactory;

/* We want to maintain encryption at rest, so do not write unencrypted data to disk.  This is bad:
InputStream source = new FileInputStream(new File("/path/to/myFeed.xml"));

Instead, if your data can fit in memory, you can create an InputStream from a String (see encryptAndUpload_fromString()).
Otherwise, you can pipe data into an InputStream using Piped streams (see encryptAndUpload_fromPipedInputStream()).
 */
public class UploadExample {
  private final UploadHelper uploadHelper = new UploadHelper.Builder().build();

  // key, initializationVector, and url are returned by the createFeedDocument operation.
  public void encryptAndUpload_fromString(String key, String initializationVector, String url) {
    AESCryptoStreamFactory aesCryptoStreamFactory =
      new AESCryptoStreamFactory.Builder(key, initializationVector)
      .build();

    // This contentType must be the same value that was provided to createFeedDocument.
    String contentType = String.format("text/plain; charset=%s", StandardCharsets.UTF_8);

    // The character set must be the same one that is specified in contentType.
    try
      (InputStream source = new ByteArrayInputStream("my feed data".getBytes(StandardCharsets.UTF_8))) {
        UploadSpecification uploadSpec =
          new UploadSpecification.Builder(contentType, aesCryptoStreamFactory, source, url)
          .build();

        uploadHelper.upload(uploadSpec);
      }
    catch (CryptoException | HttpResponseException | IOException e) {
      // Handle exception.
    }
  }

  // key, initializationVector, and url are returned from createFeedDocument.
  public void encryptAndUpload_fromPipedInputStream(String key, String initializationVector, String url) {
    AESCryptoStreamFactory aesCryptoStreamFactory =
      new AESCryptoStreamFactory.Builder(key, initializationVector)
      .build();

    // This contentType must be the same value that was provided to createFeedDocument.
    String contentType = String.format("text/plain; charset=%s", StandardCharsets.UTF_8);

    try
      (PipedInputStream source = new PipedInputStream()) {
        new Thread(
          new Runnable() {
          public void run() {
            try
              (PipedOutputStream feedContents = new PipedOutputStream(source)) {
                // The character set must be the same one that is specified in contentType.
                feedContents.write("my feed data\n".getBytes(StandardCharsets.UTF_8));
                feedContents.write("more feed data".getBytes(StandardCharsets.UTF_8));
              }
            catch (IOException e) {
              // Handle exception.
            }
          }
        }).start();

        UploadSpecification uploadSpec =
          new UploadSpecification.Builder(contentType, aesCryptoStreamFactory, source, url)
          .build();

        uploadHelper.upload(uploadSpec);
      }
    catch (CryptoException | HttpResponseException | IOException e) {
      // Handle exception.
    }
  }
}
```
## Step 3. Create a feed

Call the createFeed operation to specify the feed document identifier, the feed type, the marketplaces that you want the feed to be applied to, and any optional parameters that you want.

1.  Call the [createFeed](https://github.com/amzn/selling-partner-api-docs/blob/main/references/feeds-api/feeds_2020-09-04.md#createfeed) operation, passing the following parameters:

Body parameters:

<table>
<thead>
<tr class="header">
<th><strong>Name</strong></th>
<th>
<strong>Description</strong>
</th>
<th><strong>Required</strong></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>feedType</td>
<td><p>The type of feed that you are submitting. For more information, see <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/feeds-api/feedType_string_array_values.md">feedType values</a>.</p>
<p>Type: string</p></td>
<td>Yes</td>
</tr>
<tr class="even">
<td>marketplaceIds</td>
<td><p>A list of identifiers for marketplaces that you want the feed to be applied to.</p>
<p>Type: &lt; string &gt; array</p></td>
<td>Yes</td>
</tr>
<tr class="odd">
<td>inputFeedDocumentId</td>
<td><p>The document identifier returned by the createFeedDocument operation in <a href="#step-1-create-a-feed-document">Step 1. Create a feed document</a>.</p>
<p>Type: string</p></td>
<td>Yes</td>
</tr>
<tr class="even">
<td>feedOptions</td>
<td><p>Additional options to control the feed. These vary by feed type.</p>
<p>Type: string</p></td>
<td>No</td>
</tr>
</tbody>
</table>

Request example:
```
POST https://sellingpartnerapi-na.amazon.com/feeds/2020-09-04/feeds
{
  "feedType":"POST_PRODUCT_DATA",
  "marketplaceIds":[
    "ATVPDKIKX0DER",
    "A2EUQ1WTGCTBG2"
  ],
  "inputFeedDocumentId":"amzn1.tortuga.3.920614b0-fc4c-4393-b0d9-fff175300000.T29XK4YL08B2VM"
}
```
Request example for an Easy Ship order:
```
POST https://sellingpartnerapi-na.amazon.com/feeds/2020-09-04/feeds
{
  "feedType":"POST_EASYSHIP_DOCUMENTS",
  "marketplaceIds":["A21TJRUUN4KGV"],
  "feedOptions":
  {
    "AmazonOrderId":"902-3159896-1390916",
    "DocumentType":"ShippingLabel"
  },
  "inputFeedDocumentId":"amzn1.tortuga.3.06438a22-2b6f-4138-a120-362c096d5e04.TKXDFQFUMYD86"
}
```
**Response**

A successful response includes the following element:

<table>
<thead>
<tr class="header">
<th><strong>Name</strong></th>
<th><strong>Description</strong></th>
<th><strong>Required</strong></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>feedId</td>
<td><p>The identifier for the feed. This identifier is unique only in combination with a seller ID.</p>
<p>Type: string</p></td>
<td>Yes</td>
</tr>
</tbody>
</table>

Response example:
```
{
  "payload":
  {
    "feedId": "23492394"
  }
}
```
2.  Save the **feedId** value. Pass this value in the getFeed operation in [Step 4. Confirm feed processing](#step-4-confirm-feed-processing).

## Step 4. Confirm feed processing

Confirm feed processing by periodically calling the getFeed operation until the feed moves into one of the following terminal states: DONE, CANCELLED, or FATAL. When the feed moves into the DONE state, proceed to [Step 5. Get information for retrieving the feed processing report](#step-5-get-information-for-retrieving-the-feed-processing-report).

1.  Call the [getFeed](https://github.com/amzn/selling-partner-api-docs/blob/main/references/feeds-api/feeds_2020-09-04.md#getfeed) operation, passing the following parameter:

Path parameter:

<table>
<thead>
<tr class="header">
<th><strong>Name</strong></th>
<th><strong>Description</strong></th>
<th><strong>Required</strong></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>feedId</td>
<td><p>The identifier for the feed. Get this identifier from the result of the call to the createFeed operation in <a href="#step-3-create-a-feed">Step 3. Create a feed</a>. This identifier is unique only in combination with a seller ID.</p>
<p>Type: string</p></td>
<td>Yes</td>
</tr>
</tbody>
</table>

Request example:
```
GET https://sellingpartnerapi-na.amazon.com/feeds/2020-09-04/feeds/23492394
```
**Response**

A successful response includes the following elements:

<table>
<thead>
<tr class="header">
<th><strong>Name</strong></th>
<th><strong>Description</strong></th>
<th><strong>Required</strong></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>feedId</td>
<td><p>The identifier for the feed document. This identifier is unique only in combination with a seller ID.</p>
<p>Type: string</p></td>
<td>Yes</td>
</tr>
<tr class="even">
<td>feedType</td>
<td><p>The feed type.</p>
<p>Type: string</p></td>
<td>Yes</td>
</tr>
<tr class="odd">
<td>marketplaceIds</td>
<td><p>A list of identifiers for the marketplaces that the feed is applied to.</p>
<p>Type: < string > array</p></td>
<td>No</td>
</tr>
<tr class="even">
<td>createdTime</td>
<td><p>The date and time when the feed was created, in ISO 8601 date time format.</p>
<p>Type: string (date-time)</p></td>
<td>Yes</td>
</tr>
<tr class="odd">
<td>processingStatus</td>
<td><p>The processing status of the feed.</p>
<p>Type: <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/feeds-api/feeds_2020-09-04.md#processingstatus">ProcessingStatus</a></p></td>
<td>Yes</td>
</tr>
<tr class="even">
<td>processingStartTime</td>
<td><p>The date and time when feed processing started, in ISO 8601 date time format.</p>
<p>Type: string (date-time)</p></td>
<td>No</td>
</tr>
<tr class="odd">
<td>processingEndTime</td>
<td><p>The date and time when feed processing completed, in ISO 8601 date time format.</p>
<p>Type: string (date-time)</p></td>
<td>No</td>
</tr>
<tr class="even">
<td>resultFeedDocumentId</td>
<td><p>The identifier for the feed document. This identifier is unique only in combination with a seller ID.</p>
<p>Type: string</p></td>
<td>No</td>
</tr>
</tbody>
</table>

Response Example:
```
{
  "payload":
  {
    "processingEndTime":"2020-08-10T16:56:55+00:00",
    "processingStatus":"DONE",
    "marketplaceIds":[
      "ATVPDKIKX0DER"
    ],
    "feedId":"23492394",
    "feedType":"POST_PRODUCT_DATA",
    "createdTime":"2020-08-10T16:55:32+00:00",
    "processingStartTime":"2020-08-10T16:55:40+00:00",
    "resultFeedDocumentId":"amzn1.tortuga.3.ed4cd0d8-447b-4c22-96b5-52da8ace1207.T3YUVYPGKE9BMY"
  }
}
```

2.  Check the value of the **processingStatus** attribute.

    - If **processingStatus** is IN_QUEUE or IN_PROGRESS, feed processing is not yet complete. Retry the getFeed operation until **processingStatus** reaches one of the following terminal states: DONE, CANCELLED, or FATAL.

    - If **processingStatus** is DONE, feed processing is complete. Go to [Step 5. Get information for retrieving the feed processing report](#step-5-get-information-for-retrieving-the-feed-processing-report).

    - If **processingStatus** is CANCELLED, the feed was cancelled before it started processing. If you want to submit the feed again, start again at [Step 1. Create a feed document](#step-1-create-a-feed-document).

    - If **processingStatus** is FATAL, the feed was aborted due to a fatal error. Some, none, or all of the operations within the feed might have completed successfully. In some (but not all) cases Amazon generates a feed processing report. If Amazon generates a report, it could be in a different format from a feed processing report for a successfully completed feed. Go to [Step 5. Get information for retrieving the feed processing report](#step-5-get-information-for-retrieving-the-feed-processing-report) to attempt to retrieve a feed processing report. In rare cases Amazon might abort a feed for reasons unrelated to the feed. If you can find no errors in the feed to correct, try submitting the feed again.

**Note**: The getFeed operation only serves information for feed requests that were created within the last 90 days.

## Step 5. Get information for retrieving the feed processing report

The feed processing report indicates which records in the feed that you submitted were successful and which records generated errors. In this step you get a presigned URL for downloading the feed processing report as well as the information required to decrypt the document's contents.

1.  <span id="_Step_1._Get_1" class="anchor"></span>Call the [getFeedDocument](https://github.com/amzn/selling-partner-api-docs/blob/main/references/feeds-api/feeds_2020-09-04.md#getfeeddocument) operation, passing the following parameter:

Path parameter:

<table>
<thead>
<tr class="header">
<th><strong>Name</strong></th>
<th><strong>Description</strong></th>
<th><strong>Required</strong></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>feedDocumentId</td>
<td><p>The identifier of the feed document. Use the <strong>resultFeedDocumentId</strong> value returned in <a href="#step-4-confirm-feed-processing">Step 4. Confirm feed processing</a>.</p>
<p>Type: string</p></td>
<td>Yes</td>
</tr>
</tbody>
</table>

Request example:
```
GET https://sellingpartnerapi-na.amazon.com/feeds/2020-09-04/documents/amzn1.tortuga.3.ed4cd0d8-447b-4c22-96b5-52da8ace1207.T3YUVYPGKE9BMY
```
**Response**

A successful response includes the following elements:

<table>
<thead>
<tr class="header">
<th><strong>Name</strong></th>
<th><strong>Description</strong></th>
<th><strong>Required</strong></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>feedDocumentId</td>
<td><p>The identifier for the feed document. This identifier is unique only in combination with a seller ID.</p>
<p>Type: string</p></td>
<td>Yes</td>
</tr>
<tr class="even">
<td>url</td>
<td><p>A presigned URL for the feed document. This URL expires after 5 minutes.</p>
<p>Type: string</p></td>
<td>Yes</td>
</tr>
<tr class="odd">
<td>encryptionDetails</td>
<td><p>Encryption details for required client-side decryption of document contents.</p>
<p>Type: <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/feeds-api/feeds_2020-09-04.md#feeddocumentencryptiondetails">FeedDocumentEncryptionDetails</a></p></td>
<td>Yes</td>
</tr>
<tr class="even">
<td>compressionAlgorithm</td>
<td><p>If present, the feed document contents are compressed using the indicated algorithm.</p>
<p>Type: <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/feeds-api/feeds_2020-09-04.md#compressionalgorithm">CompressionAlgorithm</a></p></td>
<td>No</td>
</tr>
</tbody>
</table>

Response example:
```
{
  "payload":
  {
    "feedDocumentId":"amzn1.tortuga.3.ed4cd0d8-447b-4c22-96b5-52da8ace1207.T3YUVYPGKE9BMY",
    "url":"https://tortuga-prod-na.s3.amazonaws.com/%2FNinetyDays/amzn1.tortuga.3.920614b0-fc4c-4393-b0d9-fff175300000.T29XK4YL08B2VM?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Date=20200919T035824Z&X-Amz-SignedHeaders=<headers>&X-Amz-Expires=300&X-Amz-Credential=<credential>&X-Amz-Signature=<signature>",
    "encryptionDetails":
    {
      "standard":"AES",
      "initializationVector":"kF3bZt0FSv6JQEimfEJD8g==",
      "key":"5EZo/P06OGF0UAy8QuOnMIaQbkAvYBru6EGsFvK8wJ2="
    }
  }
```
2.  Save the **initializationVector**, **key**, and **url** values to pass in [Step 6. Download and decrypt the feed processing report](#step-6-download-and-decrypt-the-feed-processing-report).

## Step 6. Download and decrypt the feed processing report

You can download and decrypt the feed processing report using the information returned in the previous step. The following Java sample code along with the classes provided in the [Selling Partner API (SP-API) Documents Helper](https://github.com/amzn/selling-partner-api-models/tree/main/clients/sellingpartner-api-documents-helper-java) can help. You can also use the principles demonstrated in the Java sample code and in the SP-API Documents Helper to guide you in building applications in other programming languages.

1.  Use the following as inputs for the sample code:

    - The **key**, **initializationVector**, **url**, and optional **compressionAlgorithm** values from the previous step are arguments for the ```key```, ```initializationVector```, ```url```, and ```compressionAlgorithm``` parameters of the ```downloadAndDecrypt``` method of the ```DownloadExample``` class.

**Note**: It's the developer's responsibility to always maintain encryption at rest. Unencrypted feed processing report content should never be stored on disk, even temporarily, because feed processing reports can contain sensitive information. The sample code that we provide demonstrates this principle.

### Download and decrypt sample code (Java)
```
// DownloadExample.java
import java.io.BufferedReader;
import java.io.IOException;
 
import com.amazon.spapi.documents.CompressionAlgorithm;
import com.amazon.spapi.documents.DownloadBundle;
import com.amazon.spapi.documents.DownloadHelper;
import com.amazon.spapi.documents.DownloadSpecification;
import com.amazon.spapi.documents.exception.CryptoException;
import com.amazon.spapi.documents.exception.HttpResponseException;
import com.amazon.spapi.documents.exception.MissingCharsetException;
import com.amazon.spapi.documents.impl.AESCryptoStreamFactory;
 
public class DownloadExample {
  final DownloadHelper downloadHelper = new DownloadHelper.Builder().build();
 
  // key, initializationVector, url, and compressionAlgorithm are returned by the getReportDocument operation.
  public void downloadAndDecrypt(String key, String initializationVector, String url, String compressionAlgorithm) {
    AESCryptoStreamFactory aesCryptoStreamFactory =
      new AESCryptoStreamFactory.Builder(key, initializationVector).build();
 
    DownloadSpecification downloadSpec = new DownloadSpecification.Builder(aesCryptoStreamFactory, url)
      .withCompressionAlgorithm(CompressionAlgorithm.fromEquivalent(compressionAlgorithm))
      .build();
 
    try (DownloadBundle downloadBundle = downloadHelper.download(downloadSpec)) {
      // This example assumes that the downloaded file has a charset in the content type, e.g. 
      // text/plain; charset=UTF-8
      try (BufferedReader reader = downloadBundle.newBufferedReader()) {
        String line;
        do {
          line = reader.readLine();
          // Process the decrypted line.
        } while (line != null);
      }
    } 
    catch (CryptoException | HttpResponseException | IOException | MissingCharsetException e) {
        // Handle exception.
    }
  }
}
```
## Step 7. Check the feed processing report for errors

Check the feed processing report for errors generated during processing. If there are no errors, your feed submission is complete. If there are errors, correct them and submit the corrected feed, starting at [Step 1. Create a feed document](#step-1-create-a-feed-document). Repeat the process until there are no errors in the feed processing report.

# Best practices

## Maximize feed performance

You can generally get the best overall feed processing performance by following these guidelines:

  - Avoid submitting a lot of feeds with only a few records in each feed. When possible, combine the data into larger feeds that you submit less frequently.

  - Include only the products you are updating, not your entire inventory.

  - Upload one feed of the same type no more than once every 20 minutes. Allow more time between larger feeds.

  - Keep file size below 10 MiB (5\*2<sup>21</sup>, or 10,485,760 bytes).

## Don't rely on document ID structure

You should not rely on the format and structure of document identifiers. The format and structure is subject to change.
