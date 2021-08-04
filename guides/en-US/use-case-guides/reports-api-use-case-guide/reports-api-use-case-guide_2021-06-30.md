# Reports API Use Case Guide

API Version: 2021-06-30

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

  - [Step 1. Create a schedule for report requests](#step-1-create-a-schedule-for-report-requests)

  - [Step 2. Periodically retrieve information about the scheduled reports](#step-2-periodically-retrieve-information-about-the-scheduled-reports)

  - [Step 3. Retrieve the report](#step-3-retrieve-the-report-1)

- [Tutorial: Retrieve reports that are automatically generated](#tutorial-retrieve-reports-that-are-automatically-generated)
  - [Prerequisites](#prerequisites-2)
  
  - [Step 1. Retrieve information about reports that can be downloaded](#step-1-retrieve-information-about-reports-that-can-be-downloaded)
  
  - [Step 2. Retrieve the report](#step-2-retrieve-the-report)
  
- [How to Retrieve a Report](#how-to-retrieve-a-report)

  - [Step 1. Get information required to retrieve the report](#step-1-get-information-required-to-retrieve-the-report)

  - [Step 2. Download the report](#step-2-download-the-report)

  - [Sample Code (Java)](#sample-code-java)

- [Best practices](#best-practices)

  - [Expect changes to reports](#expect-changes-to-reports)

  - [Don't rely on document ID structure](#dont-rely-on-document-id-structure)

# What is the Reports API?

With the Selling Partner API for Reports (Reports API), you can build applications that enable sellers to get reports from Amazon that help them manage their selling business. There are reports for a wide variety of use cases, such as monitoring inventory, tracking orders for fulfillment, getting tax information, tracking returns and seller performance, managing a selling business with Fulfillment by Amazon, and more. See the [Reports API Reference](https://github.com/amzn/selling-partner-api-docs/blob/main/references/reports-api/reports_2021-06-30.md) for details about Reports API operations and associated data types and schemas. See [reportType values](https://github.com/amzn/selling-partner-api-docs/blob/main/references/reports-api/reporttype-values.md) for the available report types.

The three principal workflows for generating reports are requesting a report scheduling a report, and retrieving automatically generated reports.

**Requesting a report**

You can request any available report type on demand using the createReport operation. See [Tutorial: Request and retrieve a report](#tutorial-request-and-retrieve-a-report) for instructions.

**Scheduling a report**

You can have Amazon automatically submit report requests on a schedule using the createReportSchedule operation. See [Tutorial: Schedule and retrieve reports](#tutorial-schedule-and-retrieve-reports) for instructions for scheduling reports.

**Retrieving automatically generated reports**

Amazon generates some reports automatically. See [Tutorial: Retrieve reports that are automatically generated](#tutorial-retrieve-reports-that-are-automatically-generated) for instructions for retrieving those reports.

## Terminology

- **S3 pre-signed URL**. A URL for an AWS S3 bucket from which you can download an object without AWS security credentials or permissions.

# Tutorial: Request and retrieve a report

Here are the high-level steps for requesting a report:

1. Call the [createReport](https://github.com/amzn/selling-partner-api-docs/blob/main/references/reports-api/reports_2021-06-30.md#createreport) operation, specifying the type of report and the marketplaces that you are requesting, and any optional parameters that you want.

   Amazon receives the report request. If the operation is successful, the response includes a **reportId** value.

1. Periodically call the [getReport](https://github.com/amzn/selling-partner-api-docs/blob/main/references/reports-api/reports_2021-06-30.md#getreport) operation, passing the **reportId** value from the previous step, until the **processingStatus** value in the response indicates that processing has ended. Processing will have ended when the **processingStatus** equals CANCELLED, DONE or FATAL. At this point the response includes a **reportDocumentId** value if there is report data available.

1. Call the [getReportDocument](https://github.com/amzn/selling-partner-api-docs/blob/main/references/reports-api/reports_2021-06-30.md#getreportdocument) operation, passing the **reportDocumentId** value from the previous step.

   Amazon returns a pre-signed URL for the location of the report document, and the compression algorithm used if the report document contents have been compressed.

1. Download the report.

## Prerequisites

To complete this tutorial, you will need:

- A report type to request. See [reportType values](https://github.com/amzn/selling-partner-api-docs/blob/main/references/reports-api/reporttype-values.md) for a list of the available report types.

- Authorization from the seller for whom you are making calls. See the [Selling Partner API Developer Guide](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md) for more information.

- To use the sample code in this guide, a working Java Development Kit (JDK) installation.

**Steps**

[Step 1. Request a report](#_Step_1_Request_1)

[Step 2. Confirm report processing has completed](#step-2-confirm-that-report-processing-has-completed)

[Step 3. Retrieve the report](#step-3-retrieve-the-report)

<span id="_Step_1._Request_1" class="anchor"></span>

## Step 1. Request a report

Request a report by specifying the report type and marketplaces that you are requesting, and any optional parameters.

- Call the [createReport](https://github.com/amzn/selling-partner-api-docs/blob/main/references/reports-api/reports_2021-06-30.md#createreport) operation, passing the following parameters:

Request body:

<table>
  <thead>
    <tr class="header">
      <th>
        <strong>Name</strong>
      </th>
      <th>
        <strong>Description</strong>
      </th>
      <th>
        <strong>Required</strong>
      </th>
    </tr>
  </thead>
  <tbody>
    <tr class="odd">
      <td>reportOptions</td>
      <td>Additional information passed to reports. This varies by report type.<p>Type: <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/reports-api/reports_2021-06-30.md#reportoptions">ReportOptions</a>
        </p>
      </td>
      <td>No</td>
    </tr>
    <tr class="even">
      <td>reportType</td>
      <td>The report type. For more information, see <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/reports-api/reporttype-values.md">reportType values</a>.<p>Type: string</p>
      </td>
      <td>Yes</td>
    </tr>
    <tr class="odd">
      <td>dataStartTime</td>
      <td>The start of a date and time range, in ISO 8601 date time format, used for selecting the data to report. The default is now. The value must be prior to or equal to the current date and time. Not all report types make use of this.<p>Type: string (date-time)</p>
      </td>
      <td>No</td>
    </tr>
    <tr class="even">
      <td>dataEndTime</td>
      <td>The end of a date and time range, in ISO 8601 date time format, used for selecting the data to report. The default is now. The value must be prior to or equal to the current date and time. Not all report types make use of this.<p>Type: string (date-time)</p>
      </td>
      <td>No</td>
    </tr>
    <tr class="odd">
      <td>marketplaceIds</td>
      <td>A list of marketplace identifiers. The report document's contents will contain data for all of the specified marketplaces, unless the report type indicates otherwise.<p>Type: &lt; string &gt; array</p>
      </td>
      <td>Yes</td>
    </tr>
  </tbody>
</table>

#### Request example:

```
POST https://sellingpartnerapi-na.amazon.com/reports/2021-06-30/reports
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

<table>
  <thead>
    <tr class="header">
      <th>
        <strong>Name</strong>
      </th>
      <th>
        <strong>Description</strong>
      </th>
    </tr>
  </thead>
  <tbody>
    <tr class="odd">
      <td>
        <strong>reportId</strong>
      </td>
      <td>The identifier for the report. This identifier is unique only in combination with a seller ID.<p>Type: string</p>
      </td>
    </tr>
  </tbody>
</table>

#### Response example:

```json
{
  "reportId": "ID323"
}
```

## Step 2. Confirm that report processing has completed

After you call the createReport operation, Amazon receives the request and begins processing the report. You must then confirm that processing has completed before you continue.

- Periodically call the [getReport](https://github.com/amzn/selling-partner-api-docs/blob/main/references/reports-api/reports_2021-06-30.md#getreport) operation, passing the **reportId** value from the previous step, until the **processingStatus** value in the response indicates that processing has ended. Processing will have ended when the **processingStatus** equals CANCELLED, DONE or FATAL. At this point the response includes a **reportDocumentId** value if there is report data available.

  Here are the **processingStatus** values that confirm that processing has ended:

  - CANCELLED - The report was cancelled. There are two ways a report can be cancelled: an explicit cancellation request before the report starts processing, or an automatic cancellation if there is no data to return.

  - DONE - The report has completed processing and a **reportDocumentId** is available.

  - FATAL - The report was aborted due to a fatal error and a **reportDocumentId** may be present. If present, the report represented by the **reportDocumentId** may explain why the report processing ended.

  The following **processingStatus** values indicate that processing has _not_ ended, and you should continue to call the getReport operation until the operation returns a **processingStatus** of CANCELLED, DONE or FATAL.

  - IN_PROGRESS - The report is being processed.

  - IN_QUEUE - The report has not yet started processing. It may be waiting for another IN_PROGRESS report.

  **Note**: The getReport operation only serves information for on-demand or scheduled report requests that were created within the last 90 days.

Path parameter:

<table>
  <thead>
    <tr class="header">
      <th>
        <strong>Name</strong>
      </th>
      <th>
        <strong>Description</strong>
      </th>
      <th>
        <strong>Required</strong>
      </th>
    </tr>
  </thead>
  <tbody>
    <tr class="odd">
      <td>reportId</td>
      <td>The identifier for the report. This identifier is unique only in combination with a seller ID.<p>Type: string</p>
      </td>
      <td>Yes</td>
    </tr>
  </tbody>
</table>

#### Request example:

```plain
GET https://sellingpartnerapi-na.amazon.com/reports/2021-06-30/reports/ID323
```

**Response**

A successful response includes the following:

<table>
  <thead>
    <tr class="header">
      <th>
        <strong>Name</strong>
      </th>
      <th>
        <strong>Description</strong>
      </th>
      <th>
        <strong>Schema</strong>
      </th>
    </tr>
  </thead>
  <tbody>
    <tr class="odd">
      <td>Report</td>
      <td>The payload for the getReport operation.</td>
      <td>
        <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/reports-api/reports_2021-06-30.md#report">Report</a>
      </td>
    </tr>
  </tbody>
</table>

#### Response example:

```json
{
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
```

## Step 3. Retrieve the report

To retrieve the report, see [How to Retrieve a Report](#how-to-retrieve-a-report).

# Tutorial: Schedule and retrieve reports

You can schedule requests for reports so that they are submitted periodically, using the createReportSchedule operation. Use the period enumeration to specify the time period. To identify which reports can be scheduled, review the <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/reports-api/reporttype-values.md">reportType values</a> in the Selling Partner API documentation.

Here are the high-level steps for scheduling and retrieving reports:

1. Call the [createReportSchedule](https://github.com/amzn/selling-partner-api-docs/blob/main/references/reports-api/reports_2021-06-30.md#createreportschedule) operation to create a schedule for periodically submitting report requests. Specify **reportType, marketplaceIds** and **period** values and any optional parameters. For **reportType** values, see [reportType values](https://github.com/amzn/selling-partner-api-docs/blob/main/references/reports-api/reporttype-values.md). For **period** values, see [period enumeration](https://github.com/amzn/selling-partner-api-docs/blob/main/references/reports-api/reports_2021-06-30.md#period).

   **Note**: If a report schedule with the same report type and marketplace IDs already exists, it will be cancelled and replaced with this one. Otherwise a new report schedule will be created.

1. Periodically call the [getReports](https://github.com/amzn/selling-partner-api-docs/blob/main/references/reports-api/reports_2021-06-30.md#getreports) operation using an interval that is similar to the schedule that you configured in the previous step.

   If a call to the getReports operation succeeds, the response contains an array of report information, including **reportDocumentId** values if report data is available.

   **Note**: The getReports operation only serves information for on-demand or scheduled report requests that were created within the last 90 days.

1. For each **reportDocumentId**:

   1. Call the [getReportDocument](https://github.com/amzn/selling-partner-api-docs/blob/main/references/reports-api/reports_2021-06-30.md#getreportdocument) operation, passing the **reportDocumentId** value.

      Amazon returns a pre-signed URL for the location of the report document, and the compression algorithm used if the report document contents have been compressed.

   1. Download the report.<br>

## Prerequisites

To complete this tutorial, you will need:

- A report type to schedule. See [reportType values](https://github.com/amzn/selling-partner-api-docs/blob/main/references/reports-api/reporttype-values.md) for a list of the available report types.

- Authorization from the seller for whom you are making calls. See the [Selling Partner API Developer Guide](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md) for more information.

- To use the sample code in this guide, a working Java Development Kit (JDK) installation.

**Steps**

[Step 1. Create a schedule for report requests](#step-1-create-a-schedule-for-report-requests)

[Step 2. Periodically retrieve information about the scheduled reports](#step-2-periodically-retrieve-information-about-the-scheduled-reports)

[Step 3. Retrieve the report](#step-3-retrieve-the-report-1)

## Step 1. Create a schedule for report requests

Call the createReportSchedule operation to create a schedule for submitting report requests, specifying the **reportType**, **markeplaceIds**, and **period** values and any optional parameters. See [reportType values](https://github.com/amzn/selling-partner-api-docs/blob/main/references/reports-api/reporttype-values.md) for a list of the available report types.

- Call the [createReportSchedule](https://github.com/amzn/selling-partner-api-docs/blob/main/references/reports-api/reports_2021-06-30.md#createreportschedule) operation and pass the following parameters:

Body parameter:

<table>
  <thead>
    <tr class="header">
      <th>
        <strong>Name</strong>
      </th>
      <th>
        <strong>Description</strong>
      </th>
      <th>
        <strong>Required</strong>
      </th>
    </tr>
  </thead>
  <tbody>
    <tr class="odd">
      <td>reportType</td>
      <td>
        The report type.
        <p>Type: string</p>
      </td>
      <td>Yes</td>
    </tr>
    <tr class="even">
      <td>marketplaceIds</td>
      <td>
        A list of marketplace identifiers for the report schedule.
        <p>Type: &lt; string &gt; array</p>
      </td>
      <td>Yes</td>
    </tr>
    <tr class="odd">
      <td>reportOptions</td>
      <td>
        Additional information passed to reports. This varies by report type.
        <p>Type: <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/reports-api/reports_2021-06-30.md#reportoptions">ReportOptions</a>
        </p>
      </td>
      <td>No</td>
    </tr>
    <tr class="even">
      <td>period</td>
      <td>
        One of a set of predefined ISO 8601 periods that specifies how often a report should be created.
        <p>Type: enum (<a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/reports-api/reports_2021-06-30.md#period">Period</a>)</p>
      </td>
      <td>Yes</td>
    </tr>
    <tr class="odd">
      <td>nextReportCreationTime</td>
      <td>
        The date and time when the schedule will create its next report, in ISO 8601 date time format.
        <p>Type: string (date-time)</p>
      </td>
      <td>No</td>
    </tr>
  </tbody>
</table>

#### Request example:

```
POST https://sellingpartnerapi-na.amazon.com/reports/2021-06-30/schedules
{
  "reportType": "GET_XML_BROWSE_TREE_DATA",
  "period": "P2D",
  "marketplaceIds":["ATVPDKIKX0DER"]
}
```

**Response**

A successful response includes the following:

<table>
  <thead>
    <tr class="header">
      <th>
        <strong>Name</strong>
      </th>
      <th>
        <strong>Description</strong>
      </th>
      <th>
        <strong>Schema</strong>
      </th>
    </tr>
  </thead>
  <tbody>
    <tr class="odd">
      <td>
        <strong>CreateReportScheduleResponse</strong>
      </td>
      <td>
        The payload for the createReportSchedule operation.
      </td>
      <td>
        <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/reports-api/reports_2021-06-30.md#createreportscheduleresponse">CreateReportScheduleResponse</a>
      </td>
    </tr>
  </tbody>
</table>

#### Response example:

```json
{
  "reportScheduleId": "ID323"
}
```

## Step 2. Periodically retrieve information about the scheduled reports

Periodically call the getReports operation using an interval that is similar to the schedule that you configured. You'll want to try to time these calls so that they occur after scheduled reports are likely to have been completed.

1. Call the [getReports](https://github.com/amzn/selling-partner-api-docs/blob/main/references/reports-api/reports_2021-06-30.md#getreports) operation periodically to retrieve information about scheduled reports, passing the following parameters:

Query parameters:

<table>
  <thead>
    <tr class="header">
      <th>
        <strong>Name</strong>
      </th>
      <th>
        <strong>Description</strong>
      </th>
      <th>
        <strong>Required</strong>
      </th>
    </tr>
  </thead>
  <tbody>
    <tr class="odd">
      <td>reportTypes</td>
      <td>
        A list of report types used to filter reports. When reportTypes is provided, the other filter parameters (processingStatuses, marketplaceIds, createdSince, createdUntil) and pageSize may also be provided.
        <p>Either reportTypes or nextToken is required.</p>
        <p>Type: &lt; string &gt; array</p>
      </td>
      <td>No</td>
    </tr>
    <tr class="even">
      <td>processingStatuses</td>
      <td>
        A list of processing statuses used to filter reports.
        <p>Type: &lt; enum (<a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/reports-api/reports_2021-06-30.md#processingstatuses">ProcessingStatuses</a>) &gt; array</p>
      </td>
      <td>No</td>
    </tr>
    <tr class="odd">
      <td>marketplaceIds</td>
      <td>
        A list of marketplace identifiers used to filter reports. The reports returned will match at least one of the marketplaces that you specify.
        <p>Type: &lt; string &gt; array</p>
      </td>
      <td>No</td>
    </tr>
    <tr class="even">
      <td>pageSize</td>
      <td>
        The maximum number of reports to return in a single call.
        <p>Type: Integer</p>
      </td>
      <td>No</td>
    </tr>
    <tr class="odd">
      <td>createdSince</td>
      <td>
        The earliest report creation date and time for reports to include in the response, in ISO 8601 date time format. The default is 90 days ago. Reports are retained for a maximum of 90 days.
        <p>Type: string (date-time)</p>
      </td>
      <td>No</td>
    </tr>
    <tr class="even">
      <td>createdUntil</td>
      <td>
        The latest report creation date and time for reports to include in the response, in ISO 8601 date time format. The default is now.
        <p>Type: string (date-time)</p>
      </td>
      <td>No</td>
    </tr>
    <tr class="odd">
      <td>nextToken</td>
      <td>
        A string token returned in the response to your previous request. nextToken is returned when the number of results exceeds the specified pageSize value. To get the next page of results, call the getReports operation and include this token as the only parameter. Specifying nextToken with any other parameters will cause the request to fail.
        <p>Type: string</p>
      </td>
      <td>No</td>
    </tr>
  </tbody>
</table>

#### Request example:

```plain
GET https://sellingpartnerapi-na.amazon.com/reports/2021-06-30/reports?reportTypes=GET_XML_BROWSE_TREE_DATA
```

**Response**

A successful response includes the following:

<table>
  <thead>
    <tr class="header">
      <th>
        <strong>Name</strong>
      </th>
      <th>
        <strong>Description</strong>
      </th>
      <th>
        <strong>Schema</strong>
      </th>
    </tr>
  </thead>
  <tbody>
    <tr class="odd">
      <td>reports</td>
      <td>
        The reports.
      </td>
      <td>
        <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/reports-api/reports_2021-06-30.md#reportlist">ReportList</a>
      </td>
    </tr>
    <tr class="even">
      <td>nextToken</td>
      <td>
        Returned when the number of results exceeds pageSize. To get the next page of results, call getReports with this token as the only parameter.
      </td>
      <td>string</td>
    </tr>
  </tbody>
</table>
<br>

The **reports** array in the response contains a [Report](https://github.com/amzn/selling-partner-api-docs/blob/main/references/reports-api/reports_2021-06-30.md#report) object for each processed report, and that **Report** object contains the **reportDocumentId**.

**Note**: Information about both on-demand and scheduled reports is returned. To identify scheduled reports, look for the presence of a **reportScheduleId** in the **Report** object in the response. The **reportScheduleId** indicates which schedule submitted this report request.

2. For each **reportDocumentId**, save the **reportDocumentId** and go to Step 3 to retrieve the report.

#### Response example:

```json
{
  "nextToken": "VGhpcyB0b2tlbiBpcyBvcGFxdWUgYW5kIGludGVudGlvbmFsbHkgb2JmdXNjYXRlZA==",
  "reports": [
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

## Step 3. Retrieve the report

To retrieve a report, see [How to Retrieve a Report](#how-to-retrieve-a-report).


# Tutorial: Retrieve reports that are automatically generated

Some reports are automatically generated without your having to request them or schedule them. For example, settlement reports are automatically scheduled by Amazon. You can search for these reports using the getReports operation. 

Here are the high-level steps for retrieving reports that are automatically generated:

1. Call the [getReports](https://github.com/amzn/selling-partner-api-docs/blob/main/references/reports-api/reports_2021-06-30.md#getreports) operation to find reports that can be downloaded.

   If a call to the getReports operation succeeds, the response contains an array of report information, including **reportDocumentId** values if report data is available.

   **Note**: The getReports operation only serves information for report requests that were created within the last 90 days.

1. For each **reportDocumentId** that represents a report that you want to retrieve:

   1. Call the [getReportDocument](https://github.com/amzn/selling-partner-api-docs/blob/main/references/reports-api/reports_2021-06-30.md#getreportdocument) operation, passing the **reportDocumentId** value.

      Amazon returns a pre-signed URL for the location of the report document, and the compression algorithm used if the report document contents have been compressed.

   1. Download the report.<br>

## Prerequisites

To complete this tutorial, you will need:

- One or more report types to download if report data is available. See [reportType values](https://github.com/amzn/selling-partner-api-docs/blob/main/references/reports-api/reporttype-values.md) for a list of the report types.

- Authorization from the seller for whom you are making calls. See the [Selling Partner API Developer Guide](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md) for more information.

- To use the sample code in this guide, a working Java Development Kit (JDK) installation.

**Steps**

[Step 1. Retrieve information about reports that can be downloaded](#step-1-retrieve-information-about-reports-that-can-be-downloaded)

[Step 2. Retrieve the report](#step-2-retrieve-the-report)

## Step 1. Retrieve information about reports that can be downloaded

Call the getReports operation to find reports that can be downloaded, specifying the **reportTypes** parameter to filter the list of reports returned, and any optional parameters. See [reportType values](https://github.com/amzn/selling-partner-api-docs/blob/main/references/reports-api/reporttype-values.md) for a list of the available report types.

- Call the [getReports](https://github.com/amzn/selling-partner-api-docs/blob/main/references/reports-api/reports_2021-06-30.md#getreports) operation and pass the following parameters:

Query parameters:

<table>
  <thead>
    <tr class="header">
      <th>
        <strong>Name</strong>
      </th>
      <th>
        <strong>Description</strong>
      </th>
      <th>
        <strong>Required</strong>
      </th>
    </tr>
  </thead>
  <tbody>
    <tr class="odd">
      <td>reportTypes</td>
      <td>
        A list of report types used to filter reports. When reportTypes is provided, the other filter parameters (processingStatuses, marketplaceIds, createdSince, createdUntil) and pageSize may also be provided.
        <p>Either reportTypes or nextToken is required.</p>
        <p>Type: &lt; string &gt; array</p>
      </td>
      <td>No</td>
    </tr>
    <tr class="even">
      <td>processingStatuses</td>
      <td>
        A list of processing statuses used to filter reports.
        <p>Type: &lt; enum (<a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/reports-api/reports_2020-09-04.md#processingstatuses">ProcessingStatuses</a>) &gt; array</p>
      </td>
      <td>No</td>
    </tr>
    <tr class="odd">
      <td>marketplaceIds</td>
      <td>
        A list of marketplace identifiers used to filter reports. The reports returned will match at least one of the marketplaces that you specify.
        <p>Type: &lt; string &gt; array</p>
      </td>
      <td>No</td>
    </tr>
    <tr class="even">
      <td>pageSize</td>
      <td>
        The maximum number of reports to return in a single call.
        <p>Type: Integer</p>
      </td>
      <td>No</td>
    </tr>
    <tr class="odd">
      <td>createdSince</td>
      <td>
        The earliest report creation date and time for reports to include in the response, in ISO 8601 date time format. The default is 90 days ago. Reports are retained for a maximum of 90 days.
        <p>Type: string (date-time)</p>
      </td>
      <td>No</td>
    </tr>
    <tr class="even">
      <td>createdUntil</td>
      <td>
        The latest report creation date and time for reports to include in the response, in ISO 8601 date time format. The default is now.
        <p>Type: string (date-time)</p>
      </td>
      <td>No</td>
    </tr>
    <tr class="odd">
      <td>nextToken</td>
      <td>
        A string token returned in the response to your previous request. nextToken is returned when the number of results exceeds the specified pageSize value. To get the next page of results, call the getReports operation and include this token as the only parameter. Specifying nextToken with any other parameters will cause the request to fail.
        <p>Type: string</p>
      </td>
      <td>No</td>
    </tr>
  </tbody>
</table>

#### Request example:

```plain
GET https://sellingpartnerapi-na.amazon.com/reports/2021-06-30/reports?reportTypes=GET_V2_SETTLEMENT_REPORT_DATA_FLAT_FILE
```

**Response**

A successful response includes the following:

<table>
  <thead>
    <tr class="header">
      <th>
        <strong>Name</strong>
      </th>
      <th>
        <strong>Description</strong>
      </th>
      <th>
        <strong>Schema</strong>
      </th>
    </tr>
  </thead>
  <tbody>
    <tr class="odd">
      <td>reports</td>
      <td>
        The reports.
      </td>
      <td>
        <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/reports-api/reports_2021-06-30.md#reportlist">ReportList</a>
      </td>
    </tr>
    <tr class="even">
      <td>nextToken</td>
      <td>
        Returned when the number of results exceeds pageSize. To get the next page of results, call getReports with this token as the only parameter.
      </td>
      <td>string</td>
    </tr>
  </tbody>
</table>
<br>

The **reports** array in the response contains a [Report](https://github.com/amzn/selling-partner-api-docs/blob/main/references/reports-api/reports_2021-06-30.md#report) object for each processed report, and that **Report** object contains the **reportDocumentId**.

2. For each **reportDocumentId** that represents a report that you want to retrieve, save the **reportDocumentId** and go to Step 2 to retrieve the report.

#### Response example:

```json
{
  "reports": [
    {
      "reportType": "GET_V2_SETTLEMENT_REPORT_DATA_FLAT_FILE",
      "processingEndTime": "2021-08-03T01:02:25+00:00",
      "processingStatus": "DONE",
      "marketplaceIds": [
        "ATVPDKIKX0DER"
      ],
      "reportDocumentId": "DOC-b8b0-4226-b4b9-0ee058ea5760",
      "reportId": "ID222",
      "dataEndTime": "2021-08-03T01:02:25+00:00",
      "createdTime": "2021-08-03T01:02:25+00:00",
      "processingStartTime": "2021-08-03T01:02:25+00:00",
      "dataStartTime": "2021-08-03T01:02:25+00:00"
    }
  ]
}

```

## Step 2. Retrieve the report

To retrieve a report, see [How to Retrieve a Report](#how-to-retrieve-a-report).



# How to Retrieve a Report

Get your report by first getting the information required to retrieve a report document and then downloading the report.

**Steps**

[Step 1. Get information required to retrieve the report](#step-1-get-information-required-to-retrieve-the-report)

[Step 2. Download the report](#step-2-download-the-report)

## Step 1. Get information required to retrieve the report

Call the getReportDocument operation to get the information required for retrieving a report document's contents. This includes a pre-signed URL for the report document and optionally, the compression algorithm used if the report document contents have been compressed.

1. Call the [getReportDocument](https://github.com/amzn/selling-partner-api-docs/blob/main/references/reports-api/reports_2021-06-30.md#getreportdocument) operation, passing the following parameter:

Path parameter:

<table>
  <thead>
    <tr class="header">
      <th>
        <strong>Name</strong>
      </th>
      <th>
        <strong>Description</strong>
      </th>
      <th>
        <strong>Required</strong>
      </th>
    </tr>
  </thead>
  <tbody>
    <tr class="odd">
      <td>reportDocumentId</td>
      <td>The identifier for the report document.<p>Type: string</p>
      </td>
      <td>Yes</td>
    </tr>
  </tbody>
</table>

#### Request example:

```plain
GET https://sellingpartnerapi-na.amazon.com/reports/2021-06-30/documents/DOC-b8b0-4226-b4b9-0ee058ea5760
```

**Response**

A successful response includes the following:

<table>
  <thead>
    <tr class="header">
      <th>
        <strong>Name</strong>
      </th>
      <th>
        <strong>Description</strong>
      </th>
    </tr>
  </thead>
  <tbody>
    <tr class="odd">
      <td>reportDocumentId</td>
      <td>The identifier for the report document. This identifier is unique only in combination with a seller ID.</td>
    </tr>
    <tr class="even">
      <td>url</td>
      <td>
        A pre-signed URL for the report document. This URL expires after 5 minutes.
        <p>Type: string</p>
      </td>
    </tr>
    <tr class="odd">
      <td>compressionAlgorithm</td>
      <td>If present, the report document contents have been compressed with the provided algorithm.<p>Type: enum (<a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/reports-api/reports_2021-06-30.md#compressionalgorithm">CompressionAlgorithm</a>)</p>
      </td>
    </tr>
  </tbody>
</table>

#### Response example:

```json
{
  "reportDocumentId": "DOC-b8b0-4226-b4b9-0ee058ea5760",
  "url": "https://d34o8swod1owfl.cloudfront.net/SampleResult%2BKey%3DSample%2BINITVEC%3D58+fa+bf+a7+08+11+95+0f+c1+a8+c6+e0+d5+6f+ae+c8"
}
```

2. Save the **url**, and **compressionAlgorithm** (optional property) for use in Step 2.

## Step 2. Download the report

You will need to download the report using the information returned in the previous step. The following sample code demonstrates a way to download a plain text report document. You can also use the principles demonstrated in the sample code to guide you in building applications in other programming languages, or for other types of documents (XML,CSV,TSV, etc.). 

1. Use the following as inputs for the sample code:

   - The **url** and optional **compressionAlgorithm** values from the previous step are arguments for the `url`, and `compressionAlgorithm` parameters of the `download` method of the `DownloadExample` class.

**Note**: It's the developer's responsibility to always maintain encryption at rest. Unencrypted report content should never be stored on disk, even temporarily, because reports can contain sensitive information. The sample code that we provide demonstrates this principle.

## Sample Code (Java)

```java
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

# Best practices

## Expect changes to reports

Amazon periodically adds new fields and field values to reports. Be sure that any report parsers that you build into your applications can gracefully handle these types of report updates.

## Don't rely on document ID structure

You should not rely on the format and structure of document identifiers. The format and structure is subject to change.
