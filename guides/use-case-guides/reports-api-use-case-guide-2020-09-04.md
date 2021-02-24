# Reports API Use Case Guide

API Version: 2020-09-04

# Contents

- [What is the Reports API?](#what-is-the-reports-api)

  - [Terminology](#terminology)

- [Tutorial: Request and retrieve a report](#tutorial-request-and-retrieve-a-report)

  - [Prerequisites](#prerequisites)

  - [Step 1. Request a report](#step-1-request-a-report)

  - [Step 2. Confirm that report processing has completed](#step-2-confirm-that-report-processing-has-completed)

  - [Step 3. Retrieve the report](#step-3-retrieve-the-report)

- [Tutorial: Schedule and retrieve reports](#tutorial-schedule-and-retrieve-reports)

  - [Prerequisites](#prerequisites-1)

  - [Step 1: Create a schedule for report requests](#step-1-create-a-schedule-for-report-requests)

  - [Step 2: Periodically retrieve information about the scheduled reports](#step-2-periodically-retrieve-information-about-the-scheduled-reports)

  - [Step 3: Retrieve the report](#step-3-retrieve-the-report)

- [How to Retrieve a Report](#how-to-retrieve-a-report)

  - [Step 1. Get information required to retrieve the report](#step-1-get-information-required-to-retrieve-the-report)

  - [Step 2. Download and decrypt the report](#step-2-download-and-decrypt-the-report)

  - [Sample Code (Java)](#sample-code-java)

- [Best practices](#best-practices)

  - [Expect changes to reports](#expect-changes-to-reports)

  - [Don't rely on document ID structure](#dont-rely-on-document-id-structure)

# What is the Reports API?

With the Selling Partner API for Reports (Reports API), you can build applications that enable sellers to get reports from Amazon that helps them manage their selling business. There are reports for a wide variety of use cases, such as monitoring inventory, tracking orders for fulfillment, getting tax information, tracking returns and seller performance, managing a selling business with Fulfillment by Amazon, and more. See the [Reports API Reference](https://github.com/amzn/selling-partner-api-docs/blob/main/references/reports-api/reports_2020-09-04.md) for details about Reports API operations and associated data types and schemas. See [reportType values](https://github.com/amzn/selling-partner-api-docs/blob/main/references/reports-api/reportType_string_array_values.md) for the available report types.

The two principal workflows for generating reports are requesting a report and scheduling a report.

**Requesting a report**

You can request any available report type on demand using the createReport operation. See [Tutorial: Request and retrieve a report](#tutorial-request-and-retrieve-a-report) for instructions.

**Scheduling a report**

You can have Amazon automatically submit report requests on a schedule using the createReportSchedule operation. See [Tutorial: Schedule and retrieve reports](#tutorial-schedule-and-retrieve-reports) for instructions for scheduling reports.

## Terminology

- **Cipher block chaining**. Cipher block chaining is an algorithm that uses a block cipher to provide information security such as confidentiality or authenticity. This algorithm uses an initialization vector and a key to encrypt the data.

- **S3 pre-signed URL**. A URL for an AWS S3 bucket from which you can download an object without AWS security credentials or permissions.

# Tutorial: Request and retrieve a report

Here are the high-level steps for requesting a report:

1. Call the [createReport](https://github.com/amzn/selling-partner-api-docs/blob/main/references/reports-api/reports_2020-09-04.md#createreport) operation, specifying the type of report and the marketplaces that you are requesting, and any optional parameters that you want.

   Amazon receives the report request. If the operation is successful, the response includes a **reportId** value.

1. Periodically call the [getReport](https://github.com/amzn/selling-partner-api-docs/blob/main/references/reports-api/reports_2020-09-04.md#getreport) operation, passing the **reportId** value from the previous step, until the **processingStatus** value in the response indicates that processing has ended. Processing will have ended when the **processingStatus** equals CANCELLED, DONE or FATAL. At this point the response includes a **reportDocumentId** value if there is report data available.

1. Call the [getReportDocument](https://github.com/amzn/selling-partner-api-docs/blob/main/references/reports-api/reports_2020-09-04.md#getreportdocument) operation, passing the **reportDocumentId** value from the previous step.

   Amazon returns a pre-signed URL for the location of the report document along with the encryption details.

1. Download and decrypt the report.

## Prerequisites

To complete this tutorial, you will need:

- A report type to request. See [reportType values](https://github.com/amzn/selling-partner-api-docs/blob/main/references/reports-api/reportType_string_array_values.md) for a list of the available report types.

- Authorization from the seller for whom you are making calls. See the [Selling Partner API Developer Guide](https://github.com/amzn/selling-partner-api-docs/tree/main/guides/developer-guide) for more information.

- An understanding of client-side encryption using the cipher block chaining (CBC). For definitions, see [Terminology](#terminology).

- To use the sample code in this guide, a working Java Development Kit (JDK) installation, including the javax.crypto library.

**Steps**

[Step 1. Request a report](#_Step_1_Request_1)

[Step 2. Confirm report processing has completed](#step-2-confirm-that-report-processing-has-completed)

[Step 3. Retrieve the report](#step-3-retrieve-the-report)

<span id="_Step_1._Request_1" class="anchor"></span>

## Step 1. Request a report

Request a report by specifying the report type and marketplaces that you are requesting, and any optional parameters.

- Call the [createReport](https://github.com/amzn/selling-partner-api-docs/blob/main/references/reports-api/reports_2020-09-04.md#createreport) operation, passing the following parameters:

Request body:

<table><thead><tr class="header"><th><strong>Name</strong></th><th><strong>Description</strong></th><th><strong>Required</strong></th></tr></thead><tbody><tr class="odd"><td>reportOptions</td><td>Additional information passed to reports. This varies by report type.<p>Type: <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/reports-api/reports_2020-09-04.md#reportoptions">ReportOptions</a></p></td><td>No</td></tr><tr class="even"><td>reportType</td><td>The report type. For more information, see <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/reports-api/reportType_string_array_values.md">reportType values</a>.<p>Type: string</p></td><td>Yes</td></tr><tr class="odd"><td>dataStartTime</td><td>The start of a date and time range, in ISO 8601 date time format, used for selecting the data to report. The default is now. The value must be prior to or equal to the current date and time. Not all report types make use of this.<p>Type: string (date-time)</p></td><td>No</td></tr><tr class="even"><td>dataEndTime</td><td>The end of a date and time range, in ISO 8601 date time format, used for selecting the data to report. The default is now. The value must be prior to or equal to the current date and time. Not all report types make use of this.<p>Type: string (date-time)</p></td><td>No</td></tr><tr class="odd"><td>marketplaceIds</td><td>A list of marketplace identifiers. The report document's contents will contain data for all of the specified marketplaces, unless the report type indicates otherwise.<p>Type: &lt; string &gt; array</p></td><td>Yes</td></tr></tbody></table>

#### Request example:

```
POST https://sellingpartnerapi-na.amazon.com/reports/2020-09-04/reports
{
  "reportType": "GET_MERCHANT_LISTINGS_ALL_DATA",
  "dataStartTime": "2019-12-10T20:11:24.000Z",
  "marketplaceIds": [
    "A1PA6795UKMFR9",
    "ATVPDKIKX0DER"
  ]
}
```

**Response**

A successful response includes the following property:

<table><thead><tr class="header"><th><strong>Name</strong></th><th><strong>Description</strong></th></tr></thead><tbody><tr class="odd"><td><strong>reportId</strong></td><td>The identifier for the report. This identifier is unique only in combination with a seller ID.<p>Type: string</p></td></tr></tbody></table>

#### Response example:

```json
{
  "payload":
  {
    "reportId": "ID323"
  }
}
```

## Step 2. Confirm that report processing has completed

After you call the createReport operation, Amazon receives the request and begins processing the report. You must then confirm that processing has completed before you continue.

- Periodically call the [getReport](https://github.com/amzn/selling-partner-api-docs/blob/main/references/reports-api/reports_2020-09-04.md#getreport) operation, passing the **reportId** value from the previous step, until the **processingStatus** value in the response indicates that processing has ended. Processing will have ended when the **processingStatus** equals CANCELLED, DONE or FATAL. At this point the response includes a **reportDocumentId** value if there is report data available.

  Here are the **processingStatus** values that confirm that processing has ended:

  - CANCELLED - The report was cancelled. There are two ways a report can be cancelled: an explicit cancellation request before the report starts processing, or an automatic cancellation if there is no data to return.

  - DONE - The report has completed processing and a **reportDocumentId** is available.

  - FATAL - The report was aborted due to a fatal error and a **reportDocumentId** may be present. If present, the report represented by the **reportDocumentId** may explain why the report processing ended.

  The following **processingStatus** values indicate that processing has _not_ ended, and you should continue to call the getReport operation until the operation returns a **processingStatus** of CANCELLED, DONE or FATAL.

  - IN_PROGRESS - The report is being processed.

  - IN_QUEUE - The report has not yet started processing. It may be waiting for another IN_PROGRESS report.

  **Note**: The getReport operation only serves information for on-demand or scheduled report requests that were created within the last 90 days.

Path parameter:

<table><thead><tr class="header"><th><strong>Name</strong></th><th><strong>Description</strong></th><th><strong>Required</strong></th></tr></thead><tbody><tr class="odd"><td>reportId</td><td>The identifier for the report. This identifier is unique only in combination with a seller ID.<p>Type: string</p></td><td>Yes</td></tr></tbody></table>

#### Request example:

```plain
GET https://sellingpartnerapi-na.amazon.com/reports/2020-09-04/reports/ID323
```

**Response**

A successful response includes the following:

<table><thead><tr class="header"><th><strong>Name</strong></th><th><strong>Description</strong></th><th><strong>Schema</strong></th></tr></thead><tbody><tr class="odd"><td>payload</td><td>The payload for the getReport operation.</td><td><a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/reports-api/reports_2020-09-04.md#report">Report</a></td></tr></tbody></table>

#### Response example

```json
{
  "payload": {
    "reportId": "ID323",
    "reportType": "GET_MERCHANT_LISTINGS_ALL_DATA",
    "dataStartTime": "2019-12-11T13:47:20.677Z",
    "dataEndTime": "2019-12-12T13:47:20.677Z",
    "createdTime": "2019-12-10T13:47:20.677Z",
    "processingStatus": "DONE",
    "processingStartTime": "2019-12-10T13:47:20.677Z",
    "processingEndTime": "2019-12-12T13:47:20.677Z",
    "reportDocumentId": "DOC-b8b0-4226-b4b9-0ee058ea5760"
  }
}
```

## Step 3. Retrieve the report

To retrieve the report, see [How to Retrieve a Report](#how-to-retrieve-a-report).

# Tutorial: Schedule and retrieve reports

You can schedule requests for reports so that they are submitted periodically, using the createReportSchedule operation. Use the period enumeration to specify the time period. To identify which reports can be scheduled, review the reportType values in the Selling Partner API documentation.

Here are the high-level steps for scheduling and retrieving reports:

1. Call the [createReportSchedule](https://github.com/amzn/selling-partner-api-docs/blob/main/references/reports-api/reports_2020-09-04.md#createreportschedule) operation to create a schedule for periodically submitting report requests. Specify **reportType, marketplaceIds** and **period** values and any optional parameters. For **reportType** values, see [reportType values](https://github.com/amzn/selling-partner-api-docs/blob/main/references/reports-api/reportType_string_array_values.md). For **period** values, see [period enumeration](https://github.com/amzn/selling-partner-api-docs/blob/main/references/reports-api/reports_2020-09-04.md#period).

   **Note**: If a report schedule with the same report type and marketplace IDs already exists, it will be cancelled and replaced with this one. Otherwise a new report schedule will be created.

1. Periodically call the [getReports](https://github.com/amzn/selling-partner-api-docs/blob/main/references/reports-api/reports_2020-09-04.md#getreports) operation using an interval that is similar to the schedule that you configured in the previous step.

   If a call to the getReports operation succeeds, the response contains an array of report information, including **reportDocumentId** values if report data is available.

   **Note**: The getReports operation only serves information for on-demand or scheduled report requests that were created within the last 90 days.

1. For each **reportDocumentId**:

   1. Call the [getReportDocument](https://github.com/amzn/selling-partner-api-docs/blob/main/references/reports-api/reports_2020-09-04.md#getreportdocument) operation, passing the **reportDocumentId** value.

      Amazon returns a pre-signed URL for the location of the report document along with the encryption details.

   1. Download and decrypt the report.<br>

## Prerequisites

To complete this tutorial, you will need:

- A report type to schedule. See [reportType values](https://github.com/amzn/selling-partner-api-docs/blob/main/references/reports-api/reportType_string_array_values.md) for a list of the available report types.

- Authorization from the seller for whom you are making calls. See the [Selling Partner API Developer Guide](https://github.com/amzn/selling-partner-api-docs/tree/main/guides/developer-guide) for more information.

- An understanding of client-side encryption using the cipher block chaining (CBC). For definitions, see [Terminology](#terminology).

- To use the sample code in this guide, a working Java Development Kit (JDK) installation, including the javax.crypto library.

**Steps**

[Step 1: Create a schedule for report requests](#step-1-create-a-schedule-for-report-requests)

[Step 2: Periodically retrieve information about the scheduled reports](#step-2-periodically-retrieve-information-about-the-scheduled-reports)

[Step 3: Retrieve the reports](#step-3-retrieve-the-report)

## Step 1: Create a schedule for report requests

Call the createReportSchedule operation to create a schedule for submitting report requests, specifying the **reportType**, **markeplaceIds**, and **period** values and any optional parameters. See [reportType values](https://github.com/amzn/selling-partner-api-docs/blob/main/references/reports-api/reportType_string_array_values.md) for a list of the available report types.

- Call the [createReportSchedule](https://github.com/amzn/selling-partner-api-docs/blob/main/references/reports-api/reports_2020-09-04.md#createreportschedule) operation and pass the following parameters:

Body parameter:

<table><thead><tr class="header"><th><strong>Name</strong></th><th><strong>Description</strong></th><th><strong>Required</strong></th></tr></thead><tbody><tr class="odd"><td>reportType</td><td><p>The report type.</p><p>Type: string</p></td><td>Yes</td></tr><tr class="even"><td>marketplaceIds</td><td><p>A list of marketplace identifiers for the report schedule.</p><p>Type: &lt; string &gt; array</p></td><td>Yes</td></tr><tr class="odd"><td>reportOptions</td><td><p>Additional information passed to reports. This varies by report type.</p><p>Type: <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/reports-api/reports_2020-09-04.md#reportoptions">ReportOptions</a></p></td><td>No</td></tr><tr class="even"><td>period</td><td><p>One of a set of predefined ISO 8601 periods that specifies how often a report should be created.</p><p>Type: enum (<a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/reports-api/reports_2020-09-04.md#period">Period</a>)</p></td><td>Yes</td></tr><tr class="odd"><td>nextReportCreationTime</td><td><p>The date and time when the schedule will create its next report, in ISO 8601 date time format.</p><p>Type: string (date-time)</p></td><td>No</td></tr></tbody></table>

#### Request example:

```
POST https://sellingpartnerapi-na.amazon.com/reports/2020-09-04/schedules
{
  "reportType": "GET_XML_BROWSE_TREE_DATA",
  "period": "P2D",
  "marketplaceIds":["ATVPDKIKX0DER"]
}
```

**Response**

A successful response includes the following:

<table><thead><tr class="header"><th><strong>Name</strong></th><th><strong>Description</strong></th><th><strong>Schema</strong></th></tr></thead><tbody><tr class="odd"><td><strong>payload</strong></td><td><p>The payload for the createReportSchedule operation.</p></td><td><a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/reports-api/reports_2020-09-04.md#createreportscheduleresult">CreateReportScheduleResult</a></td></tr></tbody></table>

#### Response example:

```json
{
  "payload":
  {
    "reportScheduleId": "ID323"
  }
}
```

## Step 2: Periodically retrieve information about the scheduled reports

Periodically call the getReports operation using an interval that is similar to the schedule that you configured. You'll want to try to time these calls so that they occur after scheduled reports are likely to have been completed.

1. Call the [getReports](https://github.com/amzn/selling-partner-api-docs/blob/main/references/reports-api/reports_2020-09-04.md#getreports) operation periodically to retrieve information about scheduled reports, passing the following parameters:

Query parameters:

<table><thead><tr class="header"><th><strong>Name</strong></th><th><strong>Description</strong></th><th><strong>Required</strong></th></tr></thead><tbody><tr class="odd"><td>reportTypes</td><td><p>A list of report types used to filter reports. When reportTypes is provided, the other filter parameters (processingStatuses, marketplaceIds, createdSince, createdUntil) and pageSize may also be provided.</p><p>Either reportTypes or nextToken is required.</p><p>Type: &lt; string &gt; array</p></td><td>No</td></tr><tr class="even"><td>processingStatuses</td><td><p>A list of processing statuses used to filter reports.</p><p>Type: &lt; enum (<a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/reports-api/reports_2020-09-04.md#processingstatuses">ProcessingStatuses</a>) &gt; array</p></td><td>No</td></tr><tr class="odd"><td>marketplaceIds</td><td><p>A list of marketplace identifiers used to filter reports. The reports returned will match at least one of the marketplaces that you specify.</p><p>Type: &lt; string &gt; array</p></td><td>No</td></tr><tr class="even"><td>pageSize</td><td><p>The maximum number of reports to return in a single call.</p><p>Type: Integer</p></td><td>No</td></tr><tr class="odd"><td>createdSince</td><td><p>The earliest report creation date and time for reports to include in the response, in ISO 8601 date time format. The default is 90 days ago. Reports are retained for a maximum of 90 days.</p><p>Type: string (date-time)</p></td><td>No</td></tr><tr class="even"><td>createdUntil</td><td><p>The latest report creation date and time for reports to include in the response, in ISO 8601 date time format. The default is now.</p><p>Type: string (date-time)</p></td><td>No</td></tr><tr class="odd"><td>nextToken</td><td><p>A string token returned in the response to your previous request. nextToken is returned when the number of results exceeds the specified pageSize value. To get the next page of results, call the getReports operation and include this token as the only parameter. Specifying nextToken with any other parameters will cause the request to fail.</p><p>Type: string</p></td><td>No</td></tr></tbody></table>

#### Request example:

```plain
GET https://sellingpartnerapi-na.amazon.com/reports/2020-09-04/reports?reportTypes=GET_XML_BROWSE_TREE_DATA
```

**Response**

A successful response includes the following:

<table><thead><tr class="header"><th><strong>Name</strong></th><th><strong>Description</strong></th><th><strong>Schema</strong></th></tr></thead><tbody><tr class="odd"><td>payload</td><td><p>The payload for the getReports operation.</p></td><td><a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/reports-api/reports_2020-09-04.md#reportlist">ReportList</a></td></tr><tr class="even"><td>nextToken</td><td><p>Returned when the number of results exceeds pageSize. To get the next page of results, call getReports with this token as the only parameter.</p></td><td>string</td></tr></tbody></table><br>

The **ReportList** array in the response payload contains a [Report](https://github.com/amzn/selling-partner-api-docs/blob/main/references/reports-api/reports_2020-09-04.md#report) object for each processed report, and that **Report** object contains the **reportDocumentId**.

**Note**: Information about both on-demand and scheduled reports is returned. To identify scheduled reports, look for the presence of a **reportScheduleId** in the **Report** object in the response. The **reportScheduleId** indicates which schedule submitted this report request.

2. For each **reportDocumentId**, save the **reportDocumentId** and go to Step 3 to retrieve the report.

#### Response example:

```json
{
  "nextToken": "VGhpcyB0b2tlbiBpcyBvcGFxdWUgYW5kIGludGVudGlvbmFsbHkgb2JmdXNjYXRlZA==",
  "payload": [
    {
      "reportType": "GET_XML_BROWSE_TREE_DATA",
      "processingEndTime": "2020-09-23T22:52:59+00:00",
      "processingStatus": "DONE",
      "marketplaceIds": ["ATVPDKIKX0DER"],
      "reportDocumentId": "FOO_eae0a7b7-6c33-4191-ad1a-f31ac1ae0ce3",
      "reportId": "ID222",
      "dataEndTime": "2020-09-23T22:52:24+00:00",
      "createdTime": "2020-09-23T22:52:43+00:00",
      "processingStartTime": "2020-09-23T22:52:49+00:00",
      "reportScheduleId": "ID323",
      "dataStartTime": "2020-09-23T22:37:24+00:00"
    }
  ]
}
```

## Step 3: Retrieve the report

To retrieve a report, see [How to Retrieve a Report](#how-to-retrieve-a-report).

# How to Retrieve a Report

Get your report by first getting the information required to retrieve a report document and then downloading and decrypting the report.

**Steps**

[Step 1. Get information required to retrieve the report](#step-1-get-information-required-to-retrieve-the-report)

[Step 2. Download and decrypt the report](#step-2-download-and-decrypt-the-report)

## Step 1. Get information required to retrieve the report

Call the getReportDocument operation to get the information required for retrieving a report document's contents. This includes a pre-signed URL for the report document as well as the information required to decrypt the document's contents.

1. Call the [getReportDocument](https://github.com/amzn/selling-partner-api-docs/blob/main/references/reports-api/reports_2020-09-04.md#getreportdocument) operation, passing the following parameter:

Path parameter:

<table><thead><tr class="header"><th><strong>Name</strong></th><th><strong>Description</strong></th><th><strong>Required</strong></th></tr></thead><tbody><tr class="odd"><td>reportDocumentId</td><td>The identifier for the report document.<p>Type: string</p></td><td>Yes</td></tr></tbody></table>

#### Request example:

```plain
GET https://sellingpartnerapi-na.amazon.com/reports/2020-09-04/documents/DOC-b8b0-4226-b4b9-0ee058ea5760
```

**Response**

A successful response includes the following elements:

<table><thead><tr class="header"><th><strong>Name</strong></th><th><strong>Description</strong></th></tr></thead><tbody><tr class="odd"><td>reportDocumentId</td><td>The identifier for the report document. This identifier is unique only in combination with a seller ID.</td></tr><tr class="even"><td>url</td><td><p>A pre-signed URL for the report document. This URL expires after 5 minutes.</p><p>Type: string</p></td></tr><tr class="odd"><td>encryptionDetails</td><td>Encryption details required for decryption of a report document's contents.<p>Type: <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/reports-api/reports_2020-09-04.md#reportdocumentencryptiondetails">ReportDocumentEncryptionDetails</a></p></td></tr><tr class="even"><td>compressionAlgorithm</td><td>If present, the report document contents have been compressed with the provided algorithm.<p>Type: enum (<a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/reports-api/reports_2020-09-04.md#compressionalgorithm">CompressionAlgorithm</a>)</p></td></tr></tbody></table>

#### Response example:

```json
{
  "payload": {
    "reportDocumentId": "DOC-b8b0-4226-b4b9-0ee058ea5760",
    "url": "https://d34o8swod1owfl.cloudfront.net/SampleResult%2BKey%3DSample%2BINITVEC%3D58+fa+bf+a7+08+11+95+0f+c1+a8+c6+e0+d5+6f+ae+c8",
    "encryptionDetails": {
      "standard": "AES",
      "initializationVector": "58 fa bf a7 08 11 95 0f c1 a8 c6 e0 d5 6f ae c8",
      "key": "Sample"
    }
  }
}
```

2. Save the **key**, **initializationVector**, **url**, and **compressionAlgorithm** (optional property) for use in Step 2.

## Step 2. Download and decrypt the report

You will need to download and decrypt the report using the information returned in the previous step. The following sample code along with the classes provided in the [Selling Partner API Documents Helper](https://github.com/amzn/selling-partner-api-models/tree/main/clients/sellingpartner-api-documents-helper-java) can help. You can also use the principles demonstrated in the sample code and in the SP-API Documents Helper code to guide you in building applications in other programming languages.

1. Use the following as inputs for the sample code:

   - The **key**, **initializationVector**, **url**, and optional **compressionAlgorithm** values from the previous step are arguments for the `key`, `initializationVector`, `url`, and `compressionAlgorithm` parameters of the `downloadAndDecrypt` method of the `DownloadExample` class.

**Note**: It's the developer's responsibility to always maintain encryption at rest. Unencrypted report content should never be stored on disk, even temporarily, because reports can contain sensitive information. The sample code that we provide demonstrates this principle.

## Sample Code (Java)

```java
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

  // The key, initializationVector, url, and compressionAlgorithm are obtained from the response to
  // the getReportDocument operation.
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
        // Handle exception here.
    }
  }
}
```

# Best practices

## Expect changes to reports

Amazon periodically adds new fields and field values to reports. Be sure that any report parsers that you build into your applications can gracefully handle these types of report updates.

## Don't rely on document ID structure

You should not rely on the format and structure of document identifiers. The format and structure is subject to change.
