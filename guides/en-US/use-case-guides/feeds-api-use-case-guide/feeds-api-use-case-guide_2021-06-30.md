# Feeds API Use Case Guide
Version: 2021-06-30

# Contents

- [What is the Feeds API?](#what-is-the-feeds-api)

  - [Workflow for submitting a feed](#workflow-for-submitting-a-feed)

  - [Terminology](#terminology)

- [Tutorial: Submit a feed](#tutorial-submit-a-feed)

  - [Step 1. Create a feed document](#step-1-create-a-feed-document)

  - [Step 2. Construct a feed](#step-2-construct-a-feed)

  - [Step 3. Upload the feed data](#step-3-upload-the-feed-data)

  - [Step 4. Create a feed](#step-4-create-a-feed)

  - [Step 5. Confirm feed processing](#step-5-confirm-feed-processing)

  - [Step 6. Get information for retrieving the feed processing report](#step-6-get-information-for-retrieving-the-feed-processing-report)

  - [Step 7. Download the feed processing report](#step-7-download-the-feed-processing-report)

  - [Step 8. Check the feed processing report for errors](#step-8-check-the-feed-processing-report-for-errors)

- [Best practices](#best-practices)

# What is the Feeds API?

With the Selling Partner API for Feeds (Feeds API), you can build applications that enable sellers to upload information to Amazon that helps them manage their selling businesses. There are feeds for a wide variety of use cases, such as creating listings, managing inventory and prices, acknowledging orders, and more. See [feedType values](https://github.com/amzn/selling-partner-api-docs/blob/main/references/feeds-api/feedtype-values.md) for a list of available feed types.

### Workflow for submitting a feed

Here are the high-level steps for submitting a feed:

1.  Call the [createFeedDocument](https://github.com/amzn/selling-partner-api-docs/blob/main/references/feeds-api/feeds_2021-06-30.md#createfeeddocument) operation, specifying the content type for the feed that you are submitting.

    Amazon returns a **feedDocumentId** value and a URL for uploading the feed contents.

2.  Upload your feed document contents to the URL from the previous step.

3.  Call the [createFeed](https://github.com/amzn/selling-partner-api-docs/blob/main/references/feeds-api/feeds_2021-06-30.md#createfeed) operation. Use the **inputFeedDocumentId** parameter to pass in the **feedDocumentId** value from step 1. Specify the marketplaces that you want the feed to be applied to and any relevant feed options.

    Amazon returns a **feedId** value.

4.  Periodically call the [getFeed](https://github.com/amzn/selling-partner-api-docs/blob/main/references/feeds-api/feeds_2021-06-30.md#getfeed) operation, specifying the **feedId** value from Step 3, until the feed moves into one of the following terminal states: DONE, CANCELLED, or FATAL. When the feed moves into the DONE state, proceed to Step 5. <p>Amazon returns the **resultFeedDocumentId** value when the feed moves into the DONE state.</p>

5.  Call the [getFeedDocument](https://github.com/amzn/selling-partner-api-docs/blob/main/references/feeds-api/feeds_2021-06-30.md#getfeeddocument) operation. Use the **feedDocumentId** parameter to pass in the **resultFeedDocumentId** value from the previous step.

    Amazon returns the **feedDocumentId** value, a URL for downloading the feed processing report, and the compression algorithm.

6.  Download the feed processing report.

7.  Check the feed processing report for errors generated during feed processing. If there are errors, correct them and submit the corrected feed, starting at step 1. If there are no errors, your feed submission was successful.

For more details about submitting a feed, see [Tutorial: Submit a feed](#tutorial-submit-a-feed).

### Terminology

-  **S3 presigned URL**. A URL for an AWS S3 bucket to which you can upload an object without AWS security credentials or permissions. You get an **S3 presigned URL** in [Step 1. Create a feed document](#step-1-create-a-feed-document) and [Step 6. Get information for retrieving the feed processing report](#step-6-get-information-for-retrieving-the-feed-processing-report).

# Tutorial: Submit a feed

This tutorial shows you how to submit a feed, check the status of feed processing, and verify that your feed submission was successful. The tutorial contains Java code samples that demonstrate a way to upload a feed and download a feed processing summary report. You can use the principles demonstrated in the sample code to guide you in building applications in other programming languages, using other HttpClient libraries or upload feeds with different formats.

**Prerequisites**

To complete this tutorial, you will need:

1.  A feed to submit. See [feedType values](https://github.com/amzn/selling-partner-api-docs/blob/main/references/feeds-api/feedtype-values.md) for a list of available feed types.

2.  Authorization from the seller for whom you are making calls. See the [Selling Partner API Developer Guide](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md) for more information.

3.  A working Java Development Kit (JDK) installation.


**Steps**

[Step 1. Create a feed document](#step-1-create-a-feed-document)

[Step 2. Construct a feed](#step-2-construct-a-feed)

[Step 3. Upload the feed data](#step-3-upload-the-feed-data)

[Step 4. Create a feed](#step-4-create-a-feed)

[Step 5. Confirm feed processing](#step-5-confirm-feed-processing)

[Step 6. Get information for retrieving the feed processing report](#step-6-get-information-for-retrieving-the-feed-processing-report)

[Step 7. Download the feed processing report](#step-7-download-the-feed-processing-report)

[Step 8. Check the feed processing report for errors](#step-8-check-the-feed-processing-report-for-errors)

## Step 1. Create a feed document

Call the createFeedDocument operation to create a feed document.

1.  Call the [createFeedDocument](https://github.com/amzn/selling-partner-api-docs/blob/main/references/feeds-api/feeds_2021-06-30.md#createfeeddocument) operation, passing the following parameter:

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
<p><strong>Important.</strong> Use this <strong>contentType</strong> value in <a href="#step-3-upload-the-feed-data">Step 3. Upload the feed data</a>. Otherwise your feed data upload will fail.</p>
<p>Type: string</p></td>
<td>Yes</td>
</tr>
</tbody>
</table>

Request example:
```
POST https://sellingpartnerapi-na.amazon.com/feeds/2021-06-30/documents
{
  "contentType":"text/xml; charset=UTF-8"
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

</tbody>
</table>

Response example:
```json
{
  "feedDocumentId": "amzn1.tortuga.3.920614b0-fc4c-4393-b0d9-fff175300000.T29XK4YL08B2VM",
  "url": "https://tortuga-prod-na.s3.amazonaws.com/%2FNinetyDays/amzn1.tortuga.3.920614b0-fc4c-4393-b0d9-fff175300000.T29XK4YL08B2VM?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Date=20200919T035824Z&X-Amz-SignedHeaders=<headers>&X-Amz-Expires=300&X-Amz-Credential=<credential>&X-Amz-Signature=<signature>"
}
```
2.  Save the following values:
    
      - **url**. Use this value in [Step 3. Upload the feed data](#step-3-upload-the-feed-data).
    
      - **feedDocumentId**. Use this value in [Step 4. Create a feed](#step-4-create-a-feed). This **feedDocumentId** value expires after two days. If you pass in an expired **feedDocumentId** value to the createFeed operation, the call will fail.

## Step 2. Construct a feed

Construct a feed that you can upload in [Step 3. Upload the feed data](#step-3-upload-the-feed-data)

### XML feeds

To construct an XML feed you need to include the three core XSDs (Base, Envelope, and Header) plus your category-specific feed.

Core XSDs:
- **[Base](https://images-na.ssl-images-amazon.com/images/G/01/rainier/help/xsd/release_1_9/amzn-base._TTH_.xsd).** Used to promote consistency among feeds. All other XSDs reference the elements and data types in the Base XSD.
- **[Envelope](https://images-na.ssl-images-amazon.com/images/G/01/rainier/help/xsd/release_1_9/amzn-envelope._TTH_.xsd).** Used to wrap all other data with message-level protocol data. Consists of a header and one or more messages.
- **[Header](https://images-na.ssl-images-amazon.com/images/G/01/rainier/help/xsd/release_1_9/amzn-header._TTH_.xsd).** Used by the Envelope XSD to specify universal data related to the feed or a message in the feed.

For links to XSDs for category-specific feeds, go to [XSDs](https://sellercentral.amazon.com/gp/help/G1611) in the Seller Central Help and look in the **Category XSDs** section.

The following is an example of an XML feed for a health-related product:

```xml
<?xml version="1.0" encoding="iso-8859-1"?>
<AmazonEnvelope xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:noNamespaceSchemaLocation="amzn-envelope.xsd">
  <Header>
    <DocumentVersion>1.01</DocumentVersion>
    <MerchantIdentifier>M_EXAMPLE_123456</MerchantIdentifier>
  </Header>
  <MessageType>Product</MessageType>
  <PurgeAndReplace>false</PurgeAndReplace>
  <Message>
    <MessageID>1</MessageID>
    <OperationType>Update</OperationType>
    <Product>
      <SKU>56789</SKU>
      <StandardProductID>
        <Type>ASIN</Type>
        <Value>B0EXAMPLEG</Value>
      </StandardProductID>
      <ProductTaxCode>A_GEN_NOTAX</ProductTaxCode>
      <DescriptionData>
        <Title>Example Product Title</Title>
        <Brand>Example Product Brand</Brand>
        <Description>This is an example product description.</Description>
        <BulletPoint>Example Bullet Point 1</BulletPoint>
        <BulletPoint>Example Bullet Point 2</BulletPoint>
        <MSRP currency="USD">25.19</MSRP>
        <Manufacturer>Example Product Manufacturer</Manufacturer>
        <ItemType>example-item-type</ItemType>
      </DescriptionData>
      <ProductData>
        <Health>
          <ProductType>
            <HealthMisc>
              <Ingredients>Example Ingredients</Ingredients>
              <Directions>Example Directions</Directions>
            </HealthMisc>
          </ProductType>
        </Health>
      </ProductData>
    </Product>
  </Message>
</AmazonEnvelope>
```
## Step 3. Upload the feed data

You can upload the feed that you constructed in [Step 2. Construct a feed](#step-2-construct-a-feed) using the information returned in [Step 1. Create a feed document](#step-1-create-a-feed-document). The following sample code demonstrates one way to upload the feed content. You can also use the principles demonstrated in the sample code to guide you in building applications in other programming languages or using other HttpClient libraries.

The sample `upload` method shown in the `UploadExample` class accepts your feed content as the first argument, and the `url` value that you saved in Step 1 as the second argument. 

### Upload sample code (Java)
```java
// UploadExample.java
// This example is for use with the Selling Partner API for Feeds, Version: 2021-06-30
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

/**
 * Example that uploads content.
 */
public class UploadExample {

  public static void main(String args[]) {
    String url = "<URL from the createFeedDocument operation>";
    String content = "<your feed content>";

    UploadExample obj = new UploadExample();
    obj.upload(content.getBytes(StandardCharsets.UTF_8), url);
  }

  /**
   * Upload content to the given URL.
   *
   * @param source the content to upload
   * @param url    the URL to upload content
   */
  public void upload(byte[] source, String url) {
    OkHttpClient client = new OkHttpClient();

    // The contentType must match the input provided to the createFeedDocument operation. This example uses text/xml, but your contentType may be different depending upon on your chosen feedType (text/plain, text/csv, and so on). 
    String contentType = String.format("text/xml; charset=%s", StandardCharsets.UTF_8);
    try {
      Request request = new Request.Builder()
        .url(url)
        .put(RequestBody.create(MediaType.parse(contentType), source))
        .build();

      Response response = client.newCall(request).execute();
      if (!response.isSuccessful()) {
        System.out.println(
          String.format("Call to upload document failed with response code: %d and message: %s",
            response.code(), response.message()));
      }
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }

  }
}
```
## Step 4. Create a feed

Call the createFeed operation to specify the feed document identifier, the feed type, the marketplaces that you want the feed to be applied to, and any optional parameters that you want.

1.  Call the [createFeed](https://github.com/amzn/selling-partner-api-docs/blob/main/references/feeds-api/feeds_2021-06-30.md#createfeed) operation, passing the following parameters:

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
<td><p>The type of feed that you are submitting. For more information, see <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/feeds-api/feedtype-values.md">feedType values</a>.</p>
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
POST https://sellingpartnerapi-na.amazon.com/feeds/2021-06-30/feeds
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
POST https://sellingpartnerapi-na.amazon.com/feeds/2021-06-30/feeds
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
```json
{
  "feedId": "23492394"
}
```
2.  Save the **feedId** value. Pass this value in the getFeed operation in [Step 5. Confirm feed processing](#step-5-confirm-feed-processing).

## Step 5. Confirm feed processing

Confirm feed processing by periodically calling the getFeed operation until the feed moves into one of the following terminal states: DONE, CANCELLED, or FATAL. When the feed moves into the DONE state, proceed to [Step 6. Get information for retrieving the feed processing report](#step-6-get-information-for-retrieving-the-feed-processing-report).

1.  Call the [getFeed](https://github.com/amzn/selling-partner-api-docs/blob/main/references/feeds-api/feeds_2021-06-30.md#getfeed) operation, passing the following parameter:

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
<td><p>The identifier for the feed. Get this identifier from the result of the call to the createFeed operation in <a href="#step-4-create-a-feed">Step 4. Create a feed</a>. This identifier is unique only in combination with a seller ID.</p>
<p>Type: string</p></td>
<td>Yes</td>
</tr>
</tbody>
</table>

Request example:
```
GET https://sellingpartnerapi-na.amazon.com/feeds/2021-06-30/feeds/23492394
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
<p>Type: <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/feeds-api/feeds_2021-06-30.md#processingstatus">ProcessingStatus</a></p></td>
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
```json
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
```

2.  Check the value of the **processingStatus** attribute.

    - If **processingStatus** is IN_QUEUE or IN_PROGRESS, feed processing is not yet complete. Retry the getFeed operation until **processingStatus** reaches one of the following terminal states: DONE, CANCELLED, or FATAL.

    - If **processingStatus** is DONE, feed processing is complete. Go to [Step 6. Get information for retrieving the feed processing report](#step-6-get-information-for-retrieving-the-feed-processing-report).

    - If **processingStatus** is CANCELLED, the feed was cancelled before it started processing. If you want to submit the feed again, start again at [Step 1. Create a feed document](#step-1-create-a-feed-document).

    - If **processingStatus** is FATAL, the feed was aborted due to a fatal error. Some, none, or all of the operations within the feed might have completed successfully. In some (but not all) cases Amazon generates a feed processing report. If Amazon generates a report, it could be in a different format from a feed processing report for a successfully completed feed. Go to [Step 6. Get information for retrieving the feed processing report](#step-6-get-information-for-retrieving-the-feed-processing-report) to attempt to retrieve a feed processing report. In rare cases Amazon might abort a feed for reasons unrelated to the feed. If you can find no errors in the feed to correct, try submitting the feed again.

**Note**: The getFeed operation only serves information for feed requests that were created within the last 90 days.

## Step 6. Get information for retrieving the feed processing report

The feed processing report indicates which records in the feed that you submitted were successful and which records generated errors. In this step you get a presigned URL for downloading the feed processing report.

1.  <span id="_Step_1._Get_1" class="anchor"></span>Call the [getFeedDocument](https://github.com/amzn/selling-partner-api-docs/blob/main/references/feeds-api/feeds_2021-06-30.md#getfeeddocument) operation, passing the following parameter:

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
<td><p>The identifier of the feed document. Use the <strong>resultFeedDocumentId</strong> value returned in <a href="#step-5-confirm-feed-processing">Step 5. Confirm feed processing</a>.</p>
<p>Type: string</p></td>
<td>Yes</td>
</tr>
</tbody>
</table>

Request example:
```
GET https://sellingpartnerapi-na.amazon.com/feeds/2021-06-30/documents/amzn1.tortuga.3.ed4cd0d8-447b-4c22-96b5-52da8ace1207.T3YUVYPGKE9BMY
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

<tr class="even">
<td>compressionAlgorithm</td>
<td><p>If present, the feed document contents are compressed using the indicated algorithm.</p>
<p>Type: <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/feeds-api/feeds_2021-06-30.md#compressionalgorithm">CompressionAlgorithm</a></p></td>
<td>No</td>
</tr>
</tbody>
</table>

Response example:
```json
{
  "feedDocumentId": "amzn1.tortuga.3.ed4cd0d8-447b-4c22-96b5-52da8ace1207.T3YUVYPGKE9BMY",
  "url": "https://tortuga-prod-na.s3.amazonaws.com/%2FNinetyDays/amzn1.tortuga.3.920614b0-fc4c-4393-b0d9-fff175300000.T29XK4YL08B2VM?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Date=20200919T035824Z&X-Amz-SignedHeaders=<headers>&X-Amz-Expires=300&X-Amz-Credential=<credential>&X-Amz-Signature=<signature>"
}
```
2.  Save the **url** and optional **compressionAlgorithm** values to pass in [Step 7. Download the feed processing report](#step-7-download-the-feed-processing-report).

## Step 7. Download the feed processing report

You can download the feed processing report using the information returned in the previous step. The following Java sample code can help. You can also use the principles demonstrated in the Java sample code to guide you in building applications in other programming languages.

1.  Use the following as inputs for the sample code:

    - The **url** and optional **compressionAlgorithm** values from the previous step are arguments for the ```url```, and ```compressionAlgorithm``` parameters of the ```download``` method of the ```DownloadExample``` class.

**Note**: It's the developer's responsibility to always maintain encryption at rest. Unencrypted feed processing report content should never be stored on disk, even temporarily, because feed processing reports can contain sensitive information. The sample code that we provide demonstrates this principle.

### Download sample code (Java)
```
// DownloadExample.java
// This example is for use with the Selling Partner API for Reports, Version: 2021-06-30
// and the Selling Partner API for Feeds, Version: 2021-06-30
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.zip.GZIPInputStream;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;

/**
 * Example that downloads a document.
 */
public class DownloadExample {

  public static void main(String args[]) {
    String url = "<URL from the getFeedDocument/getReportDocument response>";
    String compressionAlgorithm = "<compressionAlgorithm from the getFeedDocument/getReportDocument response>";

    DownloadExample obj = new DownloadExample();
    try {
      obj.download(url, compressionAlgorithm);
    } catch (IOException e) {
      //Handle exception here.
    } catch (IllegalArgumentException e) {
      //Handle exception here.
    }
  }

  /**
   * Download and optionally decompress the document retrieved from the given url.
   *
   * @param url                  the url pointing to a document
   * @param compressionAlgorithm the compressionAlgorithm used for the document
   * @throws IOException              when there is an error reading the response
   * @throws IllegalArgumentException when the charset is missing
   */
  public void download(String url, String compressionAlgorithm) throws IOException, IllegalArgumentException {
    OkHttpClient httpclient = new OkHttpClient();
    Request request = new Request.Builder()
      .url(url)
      .get()
      .build();

    Response response = httpclient.newCall(request).execute();
    if (!response.isSuccessful()) {
      System.out.println(
        String.format("Call to download content was unsuccessful with response code: %d and message: %s",
          response.code(), response.message()));
      return;
    }

    try (ResponseBody responseBody = response.body()) {
      MediaType mediaType = MediaType.parse(response.header("Content-Type"));
      Charset charset = mediaType.charset();
      if (charset == null) {
        throw new IllegalArgumentException(String.format(
          "Could not parse character set from '%s'", mediaType.toString()));
      }

      Closeable closeThis = null;
      try {
        InputStream inputStream = responseBody.byteStream();
        closeThis = inputStream;

        if ("GZIP".equals(compressionAlgorithm)) {
          inputStream = new GZIPInputStream(inputStream);
          closeThis = inputStream;
        }

        // This example assumes that the download content has a charset in the content-type header, e.g.
        // text/plain; charset=UTF-8
        if ("text".equals(mediaType.type()) && "plain".equals(mediaType.subtype())) {
          InputStreamReader inputStreamReader = new InputStreamReader(inputStream, charset);
          closeThis = inputStreamReader;

          BufferedReader reader = new BufferedReader(inputStreamReader);
          closeThis = reader;

          String line;
          do {
            line = reader.readLine();
            // Process line by line.
          } while (line != null);
        } else {
          //Handle content with binary data/other media types here.
        }
      } finally {
        if (closeThis != null) {
          closeThis.close();
        }
      }
    }
  }
}
```
## Step 8. Check the feed processing report for errors

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
