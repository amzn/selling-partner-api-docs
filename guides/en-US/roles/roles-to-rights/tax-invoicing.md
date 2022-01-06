# Tax Invoicing (Restricted)
## APIs
|Operation|Method|API Path (URL)|Region|
|-|-|-|-|
|cancelFeed|DELETE|/feeds/2020-09-04/feeds/{feedId}|NA, EU, FE|
|cancelFeed|DELETE|/feeds/2021-06-30/feeds/{feedId}|NA, EU, FE|
|cancelReport|DELETE|/reports/2020-09-04/reports/{reportId}|NA, EU, FE|
|cancelReport|DELETE|/reports/2021-06-30/reports/{reportId}|NA, EU, FE|
|cancelReportSchedule|DELETE|/reports/2020-09-04/schedules/{reportScheduleId}|NA, EU, FE|
|cancelReportSchedule|DELETE|/reports/2021-06-30/schedules/{reportScheduleId}|NA, EU, FE|
|createDestination|POST|/notifications/v1/destinations|NA, EU, FE|
|createFeedDocument|POST|/feeds/2020-09-04/documents|NA, EU, FE|
|createFeedDocument|POST|/feeds/2021-06-30/documents|NA, EU, FE|
|createFeed|POST|/feeds/2020-09-04/feeds|NA, EU, FE|
|createFeed|POST|/feeds/2021-06-30/feeds|NA, EU, FE|
|createReport|POST|/reports/2020-09-04/reports|NA, EU, FE|
|createReport|POST|/reports/2021-06-30/reports|NA, EU, FE|
|createReportSchedule|POST|/reports/2020-09-04/schedules|NA, EU, FE|
|createReportSchedule|POST|/reports/2021-06-30/schedules|NA, EU, FE|
|createUploadDestination|POST|/uploads/v1/uploadDestinations|NA, EU, FE|
|getDestination|GET|/notifications/v1/destinations/{destinationId}|NA, EU, FE|
|getDestinations|GET|/notifications/v1/destinations|NA, EU, FE|
|getFeedDocument|GET|/feeds/2020-09-04/documents/{feedDocumentId}|NA, EU, FE|
|getFeedDocument|GET|/feeds/2021-06-30/documents/{feedDocumentId}|NA, EU, FE|
|getFeed|GET|/feeds/2020-09-04/feeds/{feedId}|NA, EU, FE|
|getFeed|GET|/feeds/2021-06-30/feeds/{feedId}|NA, EU, FE|
|getFeeds|GET|/feeds/2020-09-04/feeds|NA, EU, FE|
|getFeeds|GET|/feeds/2021-06-30/feeds|NA, EU, FE|
|getInvoiceStatus|GET|/fba/outbound/brazil/v0/shipments/{shipmentId}/invoice/status|NA|
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
|getShipmentDetails - RDT|GET|/fba/outbound/brazil/v0/shipments/{shipmentId}|NA|
|getShipmentDetails|GET|/fba/outbound/brazil/v0/shipments/{shipmentId}|NA|
|submitInvoice|POST|/fba/outbound/brazil/v0/shipments/{shipmentId}/invoice|NA|
## Feeds, Reports and Notifications
|API Section|Type|Region|
|-|-|-|
|Feeds|POST\_EASYSHIP\_DOCUMENTS|NA, EU, FE|
|Feeds|UPLOAD\_VAT\_INVOICE|EU|
|Reports|GET\_AMAZON\_FULFILLED\_SHIPMENTS\_DATA\_INVOICING|EU|
|Reports|GET\_EASYSHIP\_DOCUMENTS|NA, EU, FE|
|Reports|GET\_FLAT\_FILE\_ORDER\_REPORT\_DATA\_INVOICING|EU|
|Reports|GET\_FLAT\_FILE\_ORDERS\_RECONCILIATION\_DATA\_INVOICING|EU|
|Reports|GET\_FLAT\_FILE\_VAT\_INVOICE\_DATA\_REPORT|NA, EU, FE|
|Reports|GET\_GST\_MTR\_B2B\_CUSTOM|NA, EU, FE|
|Reports|GET\_GST\_MTR\_B2C\_CUSTOM|NA, EU, FE|
|Reports|GET\_ORDER\_REPORT\_DATA\_INVOICING|EU|
|Reports|GET\_VAT\_TRANSACTION\_DATA|NA, EU, FE|
|Reports|GET\_XML\_VAT\_INVOICE\_DATA\_REPORT|NA, EU, FE|
|Reports|SC\_VAT\_TAX\_REPORT|NA, EU, FE|
