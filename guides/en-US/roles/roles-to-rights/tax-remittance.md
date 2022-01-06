# Tax Remittance (Restricted)
## APIs
|Operation|Method|API Path (URL)|Region|
|-|-|-|-|
|cancelReport|DELETE|/reports/2020-09-04/reports/{reportId}|NA, EU, FE|
|cancelReport|DELETE|/reports/2021-06-30/reports/{reportId}|NA, EU, FE|
|cancelReportSchedule|DELETE|/reports/2020-09-04/schedules/{reportScheduleId}|NA, EU, FE|
|cancelReportSchedule|DELETE|/reports/2021-06-30/schedules/{reportScheduleId}|NA, EU, FE|
|createDestination|POST|/notifications/v1/destinations|NA, EU, FE|
|createReport|POST|/reports/2020-09-04/reports|NA, EU, FE|
|createReport|POST|/reports/2021-06-30/reports|NA, EU, FE|
|createReportSchedule|POST|/reports/2020-09-04/schedules|NA, EU, FE|
|createReportSchedule|POST|/reports/2021-06-30/schedules|NA, EU, FE|
|getDestination|GET|/notifications/v1/destinations/{destinationId}|NA, EU, FE|
|getDestinations|GET|/notifications/v1/destinations|NA, EU, FE|
|getMyFeesEstimateForASIN|POST|/products/fees/v0/items/{Asin}/feesEstimate|NA, EU, FE|
|getMyFeesEstimateForSKU|POST|/products/fees/v0/listings/{SellerSKU}/feesEstimate|NA, EU, FE|
|getOrderAddress - RDT|GET|/orders/v0/orders/{orderId}/address|NA, EU, FE|
|getOrderAddress|GET|/orders/v0/orders/{orderId}/address|NA, EU, FE|
|getOrderBuyerInfo - RDT|GET|/orders/v0/orders/{orderId}/buyerInfo|NA, EU, FE|
|getOrderBuyerInfo|GET|/orders/v0/orders/{orderId}/buyerInfo|NA, EU, FE|
|getOrder|GET|/orders/v0/orders/{orderId}|NA, EU, FE|
|getOrderItemsBuyerInfo - RDT|GET|/orders/v0/orders/{orderId}/orderItems/buyerInfo|NA, EU, FE|
|getOrderItemsBuyerInfo|GET|/orders/v0/orders/{orderId}/orderItems/buyerInfo|NA, EU, FE|
|getOrderItems|GET|/orders/v0/orders/{orderId}/orderItems|NA, EU, FE|
|getOrderMetrics|GET|/sales/v1/orderMetrics|FE|
|getOrders|GET|/orders/v0/orders|NA, EU, FE|
|getReportDocument - RDT|GET|/reports/2020-09-04/documents/{reportDocumentId}|NA, EU, FE|
|getReportDocument - RDT|GET|/reports/2021-06-30/documents/{reportDocumentId}|NA, EU, FE|
|getReportDocument|GET|/reports/2020-09-04/documents/{reportDocumentId}|NA, EU, FE|
|getReportDocument|GET|/reports/2021-06-30/documents/{reportDocumentId}|NA, EU, FE|
|getReport|GET|/reports/2020-09-04/reports/{reportId}|NA, EU, FE|
|getReport|GET|/reports/2021-06-30/reports/{reportId}|NA, EU, FE|
|getReportSchedule|GET|/reports/2020-09-04/schedules/{reportScheduleId}|NA, EU, FE|
|getReportSchedule|GET|/reports/2021-06-30/schedules/{reportScheduleId}|NA, EU, FE|
|getReportSchedules|GET|/reports/2020-09-04/schedules|NA, EU, FE|
|getReportSchedules|GET|/reports/2021-06-30/schedules|NA, EU, FE|
|getReports|GET|/reports/2020-09-04/reports|NA, EU, FE|
|getReports|GET|/reports/2021-06-30/reports|NA, EU, FE|
## Feeds, Reports and Notifications
|API Section|Type|Region|
|-|-|-|
|Reports|_GET_FLAT_FILE_SALES_TAX_DATA|NA, EU, FE|
|Reports|GET\_AMAZON\_FULFILLED\_SHIPMENTS\_DATA\_TAX|NA|
|Reports|GET\_FBA\_FULFILLMENT\_CUSTOMER\_TAXES\_DATA|NA, EU, FE|
|Reports|GET\_FLAT\_FILE\_ORDER\_REPORT\_DATA\_TAX|NA|
|Reports|GET\_FLAT\_FILE\_ORDERS\_RECONCILIATION\_DATA\_TAX|NA|
|Reports|GET\_FLAT\_FILE\_SALES\_TAX\_DATA|NA, EU, FE|
|Reports|GET\_GST\_MTR\_B2B\_CUSTOM|NA, EU, FE|
|Reports|GET\_GST\_MTR\_B2C\_CUSTOM|NA, EU, FE|
|Reports|GET\_ORDER\_REPORT\_DATA\_TAX|NA|
