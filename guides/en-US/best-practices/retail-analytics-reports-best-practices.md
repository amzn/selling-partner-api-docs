# Retail Analytics Reports Best Practices
Reports API Version: [2021-06-30](https://github.com/amzn/selling-partner-api-docs/blob/main/references/reports-api/reports_2021-06-30.md)

This document provides important guidance for developers whose application integrations use one of the following reports, indicated by reportType value: 
* GET_VENDOR_SALES_DIAGNOSTIC_REPORT
* GET_VENDOR_INVENTORY_HEALTH_AND_PLANNING_REPORT
* GET_VENDOR_DEMAND_FORECAST_REPORT

For more information about using the **Reports API**, see the [Reports API Use Case Guide](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/use-case-guides/reports-api-use-case-guide/reports-api-use-case-guide_2021-06-30.md). For more information about **report type** values, see [reportType Values](https://github.com/amzn/selling-partner-api-docs/blob/main/references/reports-api/reporttype-values.md).

# Contents

* [Key features of the retail analytics reports](#key-features-of-the-retail-analytics-reports)
* [Upcoming changes and integration tips](#upcoming-changes-and-integration-tips)
  * [Report type value changes](#report-type-value-changes)
  * [New report options](#new-report-options)
  * [Report structure and data element changes](#report-structure-and-data-element-changes)


## Key features of the retail analytics reports
The retail analytics reports offer integrators programmatic access to key retail performance metrics that were historically only available through the Vendor Central portal. Data is reported daily within each ASIN for the trailing 13-months, or, in the case of the demand forecast report, weekly demand is forecast for the next 26 weeks from the report creation date. This means you can retrieve the reports (they are in JSON format) and build your integration to query and aggregate data across time ranges to support your use case. 

The data is refreshed daily subject to a 36-hour service level window. This means createReport requests must provide end dates that are no sooner than two days in the past. For example, a createReport request made on 2021-08-12 should not provide a dataEndTime any later than 2021-08-10. If you receive an empty report (i.e. a report with no data in it), retry the createReport request at a later time.

## Upcoming changes and integration tips 

The current retail analytics report types are stable and reliable, but we’re already working on newer versions that will better meet the needs of integrators. 

We’ve highlighted some specific actions to take as you build your production integrations today in anticipation of upcoming changes. These techniques should make it easier to incorporate improved versions of these reports in the future.

### Report type value changes
New versions of the retail analytics reports will have new reportType values. Design your integration to treat reportType values as parameters that can be changed. Do not hard code reportType values into your implementation.

### New report options 

The new versions of the retail analytics reports will likely require that you provide the new  ```sellingProgram```, ```distributorView``` and ```reportPeriod``` report options in the ```createReport``` request (subject to change). The current version does not support these report options (i.e. data for *all* selling programs are included in the response to each request, only the manufacturing distributor view is supported, and the period is day). 

Build your implementation in anticipation of these new report options, so that when the new reports are available, you can start using them easily. See the examples below for how the current request structure could change in the future. 

**Current Sales Diagnostics Report Request Body example**
```json
{
  "reportType": "GET_VENDOR_SALES_DIAGNOSTIC_REPORT",
  "marketplaceIds": [
    "ATVPDKIKX0DER"
  ],
  "dataStartTime": "2021-05-10",
  "dataEndTime": "2021-05-10"
}
```
**Potential Sales Diagnostics Report Request Body example** (subject to change)

```json
{
  "reportType": "GET_VENDOR_SALES_DIAGNOSTIC_REPORT_ABC",
  "reportOptions": {
    "sellingProgram": "AMAZON_RETAIL",
    "distributorView": "SOURCING",
    "reportPeriod": "WEEK"
  },
  "dataStartTime": "2021-06-06",
  "dataEndTime": "2021-06-19",
  "marketplaceIds": [
    "ATVPDKIKX0DER"
  ]
}
```

You will eventually need to call the same API report type multiple times to get data across all selling programs and distributor views. Today, you can get data across all selling programs for the manufacturer view in one call.

### Report structure and data element changes
The new versions of the retail analytics reports will have a similar structure to the current version with one layer less of nesting in the payload section. Design your JSON parser so that you can adjust it when the report structure changes. Your data processing implementation should also be prepared for single selling program data per report in the future. 

Some data elements may be replaced by updated, more relevant data elements. The means the names of some data elements will effectively change. 

See below for examples of how the report structure could change in the future.

**Current Sales Diagnostics Report example**

```distributorView```= Manufacturing of all Selling Programs

```json
{
  "reportSummary":
  {
    "reportingDateRange":
    {
      "reportingDateFrom": "2021-05-10",
      "reportingDateTo": "2021-05-10"
    },
    "distributorView": "manufacturing",
    "currencyCode": "USD"
  },
  "reportDetails": [
    {
      "sellingProgramName": "AMAZON_PRIME_NOW",
      "salesMetricsByProgram": []
    },
    {
      "sellingProgramName": "AMAZON_RETAIL",
      "salesMetricsByProgram": [
        {
          "asin": "B123456789",
          "salesMetricsByAsin": [
            {
              "reportingDate": "2021-05-10",
              "salesMetricsByDate":
              {
                "preOrderedRevenue":
                {
                  "amount": 0.00,
                  "currencyCode": "USD"
                },
                "orderedRevenue":
                {
                  "amount": 32.34,
                  "currencyCode": "USD"
                },
                "shippedRevenue":
                {
                  "amount": 27.72,
                  "currencyCode": "USD"
                },
                "shippedCOGS":
                {
                  "amount": 23.10,
                  "currencyCode": "USD"
                },
                "orderedUnits": 7,
                "preOrderedUnits": 0,
                "shippedUnits": 6,
                "shippedSubcategorySalesRank": 403,
                "orderedSubcategorySalesRank": 374,
                "replenishableOutOfStock": 0.2381,
                "lostBuyBox": 0.0000,
                "customerReturns": 0,
                "freeReplacements": 0,
                "glanceViews": 17,
                "conversionRate": 0.4118
              }
            }
          ]
        },
        {
          "asin": "B876543219",
          "salesMetricsByAsin": [
            {
              "reportingDate": "2021-03-20",
              "salesMetricsByDate":
              {
                "preOrderedRevenue":
                {
                  "amount": 0.00,
                  "currencyCode": "USD"
                },
                "orderedRevenue":
                {
                  "amount": 0.00,
                  "currencyCode": "USD"
                },
                "shippedRevenue":
                {
                  "amount": 0.00,
                  "currencyCode": "USD"
                },
                "shippedCOGS":
                {
                  "amount": 0.00,
                  "currencyCode": "USD"
                },
                "orderedUnits": 0,
                "preOrderedUnits": 0,
                "shippedUnits": 0,
                "shippedSubcategorySalesRank": null,
                "orderedSubcategorySalesRank": 41,
                "replenishableOutOfStock": 1.0000,
                "lostBuyBox": 0.0000,
                "customerReturns": 1,
                "freeReplacements": 0,
                "glanceViews": 0,
                "conversionRate": 0.0000
              }
            }
          ]
        }
      ]
    },
    {
      "sellingProgramName": "AMAZON_FRESH",
      "salesMetricsByProgram": []
    },
    {
      "sellingProgramName": "AMAZON_BUSINESS",
      "salesMetricsByProgram": []
    }
  ]
}
```

**Potential Sales Diagnostics Report example** (subject to change)

```distributorView```= Sourcing

```sellingProgram```= Amazon Retail

```json

{
  "reportSpecification":
  {
    "reportType": "GET_VENDOR_SALES_DIAGNOSTIC_REPORT_ABC",
    "reportOptions": {
      "sellingProgram": "AMAZON_RETAIL",
      "distributorView": "SOURCING",
      "reportPeriod": "WEEK"
    },
    "dataStartTime": "2021-06-06",
    "dataEndTime": "2021-06-19",
    "marketplaceIds": [
      "ATVPDKIKX0DER"
    ]
  },
  "salesDiagnosticAggregate": [
    {
      "startDate": "2021-06-06",
      "endDate": "2021-06-12",
      "shippedRevenue":
      {
        "amount": 27.72,
        "currencyCode": "USD"
      },
      "shippedCOGS":
      {
        "amount": 23.10,
        "currencyCode": "USD"
      },
      "shippedUnits": 6,
      "customerReturns": 0
    },
    {
      "startDate": "2021-06-13",
      "endDate": "2021-06-19",
      "shippedRevenue":
      {
        "amount": 48.94,
        "currencyCode": "USD"
      },
      "shippedCOGS":
      {
        "amount": 24.23,
        "currencyCode": "USD"
      },
      "shippedUnits": 27,
      "customerReturns": 5
    }
  ],
  "salesDiagnosticByAsin": [
    {
      "startDate": "2021-06-06",
      "endDate": "2021-06-12",
      "asin": "B123456789",
      "shippedRevenue":
      {
        "amount": 11.13,
        "currencyCode": "USD"
      },
      "shippedCOGS":
      {
        "amount": 8.56,
        "currencyCode": "USD"
      },
      "shippedUnits": 3,
      "customerReturns": 0
    },
    {
      "startDate": "2021-06-13",
      "endDate": "2021-06-19",
      "asin": "B123456789",
      "shippedRevenue":
      {
        "amount": 26.56,
        "currencyCode": "USD"
      },
      "shippedCOGS":
      {
        "amount": 11.01,
        "currencyCode": "USD"
      },
      "shippedUnits": 17,
      "customerReturns": 0
    },
    {
      "startDate": "2021-06-06",
      "endDate": "2021-06-12",
      "asin": "B987654321",
      "shippedRevenue":
      {
        "amount": 16.59,
        "currencyCode": "USD"
      },
      "shippedCOGS":
      {
        "amount": 14.54,
        "currencyCode": "USD"
      },
      "shippedUnits": 3,
      "customerReturns": 0
    },
    {
      "startDate": "2021-06-13",
      "endDate": "2021-06-19",
      "asin": "B987654321",
      "shippedRevenue":
      {
        "amount": 22.38,
        "currencyCode": "USD"
      },
      "shippedCOGS":
      {
        "amount": 13.22,
        "currencyCode": "USD"
      },
      "shippedUnits": 10,
      "customerReturns": 5
    }
  ]
}
```