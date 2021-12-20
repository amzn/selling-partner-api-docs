# Inventory and Order Tracking
## APIs
|Operation|Method|API Path (URL)|Region|
|-|-|-|-|
|cancelFeed|DELETE|/feeds/2020-09-04/feeds/{feedId}|NA, EU, FE|
|cancelFeed|DELETE|/feeds/2021-06-30/feeds/{feedId}|NA, EU, FE|
|cancelReport|DELETE|/reports/2020-09-04/reports/{reportId}|NA, EU, FE|
|cancelReport|DELETE|/reports/2021-06-30/reports/{reportId}|NA, EU, FE|
|cancelReportSchedule|DELETE|/reports/2020-09-04/schedules/{reportScheduleId}|NA, EU, FE|
|cancelReportSchedule|DELETE|/reports/2021-06-30/schedules/{reportScheduleId}|NA, EU, FE|
|cancelSubscription|PUT|/buyerSubscriptions/v1/subscriptions/{subscriptionId}/cancel|NA|
|createDestination|POST|/notifications/v1/destinations|NA|
|createFeedDocument|POST|/feeds/2020-09-04/documents|NA, EU, FE|
|createFeedDocument|POST|/feeds/2021-06-30/documents|NA, EU, FE|
|createFeed|POST|/feeds/2020-09-04/feeds|NA, EU, FE|
|createFeed|POST|/feeds/2021-06-30/feeds|NA, EU, FE|
|createReport|POST|/reports/2020-09-04/reports|NA, EU, FE|
|createReport|POST|/reports/2021-06-30/reports|NA, EU, FE|
|createReportSchedule|POST|/reports/2020-09-04/schedules|NA, EU, FE|
|createReportSchedule|POST|/reports/2021-06-30/schedules|NA, EU, FE|
|getDestination|GET|/notifications/v1/destinations/{destinationId}|NA|
|getDestinations|GET|/notifications/v1/destinations|NA|
|getFeedDocument|GET|/feeds/2020-09-04/documents/{feedDocumentId}|NA, EU, FE|
|getFeedDocument|GET|/feeds/2021-06-30/documents/{feedDocumentId}|NA, EU, FE|
|getFeed|GET|/feeds/2020-09-04/feeds/{feedId}|NA, EU, FE|
|getFeed|GET|/feeds/2021-06-30/feeds/{feedId}|NA, EU, FE|
|getFeeds|GET|/feeds/2020-09-04/feeds|NA, EU, FE|
|getFeeds|GET|/feeds/2021-06-30/feeds|NA, EU, FE|
|getInventory|GET|/externalFulfillment/inventory/2021-01-06/locations/{locationId}/skus/{skuId}|NA, EU, FE|
|getMarketplaceParticipations|GET|/sellers/v1/marketplaceParticipations|FE|
|getMyFeesEstimateForASIN|POST|/products/fees/v0/items/{Asin}/feesEstimate|NA, EU, FE|
|getMyFeesEstimateForSKU|POST|/products/fees/v0/listings/{SellerSKU}/feesEstimate|NA, EU, FE|
|getOrderAddress|GET|/orders/v0/orders/{orderId}/address|NA, EU, FE|
|getOrderBuyerInfo|GET|/orders/v0/orders/{orderId}/buyerInfo|NA, EU, FE|
|getOrder|GET|/orders/v0/orders/{orderId}|NA, EU, FE|
|getOrderItemsBuyerInfo|GET|/orders/v0/orders/{orderId}/orderItems/buyerInfo|NA, EU, FE|
|getOrderItems|GET|/orders/v0/orders/{orderId}/orderItems|NA, EU, FE|
|getOrderMetrics|GET|/sales/v1/orderMetrics|NA, EU, FE|
|getOrders|GET|/orders/v0/orders|NA, EU, FE|
|getPurchaseOrder|GET|/vendor/orders/v1/purchaseOrders/{purchaseOrderNumber}|NA, EU, FE|
|getPurchaseOrders|GET|/vendor/orders/v1/purchaseOrders|NA, EU, FE|
|getPurchaseOrdersStatus|GET|/vendor/orders/v1/purchaseOrdersStatus|NA, EU, FE|
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
|getTransaction|GET|/vendor/transactions/v1/transactions/{transactionId}|NA, EU|
|submitAcknowledgement|POST|/vendor/orders/v1/acknowledgements|NA, EU|
|submitInvoices|POST|/vendor/payments/v1/invoices|NA, EU, FE|
|SubmitShipmentConfirmations|POST|/vendor/shipping/v1/shipmentConfirmations|NA, FE|
|updateInventory|PUT|/externalFulfillment/inventory/2021-01-06/locations/{locationId}/skus/{skuId}|NA, EU, FE|
|updateShipmentStatus|POST|/orders/v0/orders/{orderId}/shipment|NA, EU, FE|
&nbsp;
## Feeds, Reports and Notifications
|API Section|Type|Region|
|-|-|-|
|Feeds|POST\_EASYSHIP\_DOCUMENTS|NA, EU, FE|
|Feeds|POST\_EXPECTED\_SHIP\_DATE\_SOD\_FLAT\_FILE|NA, EU, FE|
|Feeds|POST\_EXPECTED\_SHIP\_DATE\_SOD|NA, EU, FE|
|Feeds|POST\_FLAT\_FILE\_BOOKLOADER\_DATA|NA, EU, FE|
|Feeds|POST\_FLAT\_FILE\_CONVERGENCE\_LISTINGS\_DATA|NA, EU, FE|
|Feeds|POST\_FLAT\_FILE\_FULFILLMENT\_DATA|NA, EU, FE|
|Feeds|POST\_FLAT\_FILE\_IL\_ALLOCATION\_REQUESTS\_CONFIRMATION\_FEED|FE|
|Feeds|POST\_FLAT\_FILE\_IL\_SNAPSHOT\_FEED|FE|
|Feeds|POST\_FLAT\_FILE\_INVLOADER\_DATA|NA, EU, FE|
|Feeds|POST\_FLAT\_FILE\_ORDER\_ACKNOWLEDGEMENT\_DATA|NA, EU, FE|
|Feeds|POST\_FLAT\_FILE\_PAYMENT\_ADJUSTMENT\_DATA|NA, EU, FE|
|Feeds|POST\_FLAT\_FILE\_PRICEANDQUANTITYONLY\_UPDATE\_DATA|NA, EU, FE|
|Feeds|POST\_INVENTORY\_AVAILABILITY\_DATA|NA, EU, FE|
|Feeds|POST\_INVOICE\_CONFIRMATION\_DATA|NA, EU, FE|
|Feeds|POST\_MYR\_AUTO\_AUTHORIZATION\_LIST\_DATA|NA, EU, FE|
|Feeds|POST\_ORDER\_ACKNOWLEDGEMENT\_DATA|NA, EU, FE|
|Feeds|POST\_ORDER\_FULFILLMENT\_DATA|NA, EU, FE|
|Feeds|POST\_PAYMENT\_ADJUSTMENT\_DATA|NA, EU, FE|
|Feeds|POST\_PRODUCT\_DATA|NA, EU, FE|
|Feeds|POST\_PRODUCT\_IMAGE\_DATA|NA, EU, FE|
|Feeds|POST\_PRODUCT\_OVERRIDES\_DATA|NA, EU, FE|
|Feeds|POST\_PRODUCT\_PRICING\_DATA|NA, EU, FE|
|Feeds|POST\_PRODUCT\_RELATIONSHIP\_DATA|NA, EU, FE|
|Feeds|POST\_SELLER\_RATE\_CARD\_FEED|NA, EU, FE|
|Feeds|POST\_STD\_ACES\_DATA|NA, EU, FE|
|Feeds|POST\_UIEE\_BOOKLOADER\_DATA|NA, EU, FE|
|Feeds|RFQ\_UPLOAD\_FEED|NA, EU, FE|
|Notifications|EXTERNAL_FULFILLMENT_SHIPMENT_STATUS_CHANGE|NA, EU, FE|
|Notifications|FEED_PROCESSING_FINISHED|NA, EU, FE|
|Notifications|ORDER_STATUS_CHANGE|NA, EU, FE|
|Notifications|REPORT_PROCESSING_FINISHED|NA, EU, FE|
|Reports|GET\_AMAZON\_FULFILLED\_SHIPMENTS\_DATA\_GENERAL|NA, EU, FE|
|Reports|GET\_CSV\_MFN\_PRIME\_RETURNS\_REPORT|NA, EU, FE|
|Reports|GET\_FLAT\_FILE\_ALL\_ORDERS\_DATA\_BY\_LAST\_UPDATE\_GENERAL|NA, EU, FE|
|Reports|GET\_FLAT\_FILE\_ALL\_ORDERS\_DATA\_BY\_ORDER\_DATE\_GENERAL|NA, EU, FE|
|Reports|GET\_FLAT\_FILE\_ARCHIVED\_ORDERS\_DATA\_BY\_ORDER\_DATE|NA, EU, FE|
|Reports|GET\_FLAT\_FILE\_GEO\_OPPORTUNITIES|NA, EU, FE|
|Reports|GET\_FLAT\_FILE\_MFN\_SKU\_RETURN\_ATTRIBUTE\_FEED\_RECORDS\_REPORT|NA, EU, FE|
|Reports|GET\_FLAT\_FILE\_MFN\_SKU\_RETURN\_ATTRIBUTES\_REPORT|NA, EU, FE|
|Reports|GET\_FLAT\_FILE\_OPEN\_LISTINGS\_DATA|NA, EU, FE|
|Reports|GET\_FLAT\_FILE\_PENDING\_ORDERS\_DATA|NA, EU, FE|
|Reports|GET\_FLAT\_FILE\_RETURNS\_DATA\_BY\_RETURN\_DATE|NA, EU, FE|
|Reports|GET\_IL\_PENDING\_ALLOCATION\_REQUESTS|FE|
|Reports|GET\_MERCHANT\_CANCELLED\_LISTINGS\_DATA|NA, EU, FE|
|Reports|GET\_MERCHANT\_LISTINGS\_ALL\_DATA|NA, EU, FE|
|Reports|GET\_MERCHANT\_LISTINGS\_DATA\_BACK\_COMPAT|NA, EU, FE|
|Reports|GET\_MERCHANT\_LISTINGS\_DATA\_LITE|NA, EU, FE|
|Reports|GET\_MERCHANT\_LISTINGS\_DATA\_LITER|NA, EU, FE|
|Reports|GET\_MERCHANT\_LISTINGS\_DATA|NA, EU, FE|
|Reports|GET\_MERCHANT\_LISTINGS\_DEFECT\_DATA|NA, EU, FE|
|Reports|GET\_MERCHANT\_LISTINGS\_INACTIVE\_DATA|NA, EU, FE|
|Reports|GET\_OUT\_OF\_STOCK\_MFN\_INFORMATION|NA, EU, FE|
|Reports|GET\_PAN\_EU\_OFFER\_STATUS|NA, EU, FE|
|Reports|GET\_PENDING\_ORDERS\_DATA|NA, EU, FE|
|Reports|GET\_XML\_ALL\_ORDERS\_DATA\_BY\_LAST\_UPDATE\_GENERAL|NA, EU, FE|
|Reports|GET\_XML\_ALL\_ORDERS\_DATA\_BY\_ORDER\_DATE\_GENERAL|NA, EU, FE|
|Reports|GET\_XML\_BROWSE\_TREE\_DATA|NA, EU, FE|
|Reports|GET\_XML\_MFN\_PRIME\_RETURNS\_REPORT|NA, EU, FE|
|Reports|GET\_XML\_MFN\_SKU\_RETURN\_ATTRIBUTE\_FEED\_RECORDS\_REPORT|NA, EU, FE|
|Reports|GET\_XML\_MFN\_SKU\_RETURN\_ATTRIBUTES\_REPORT|NA, EU, FE|
|Reports|GET\_XML\_RETURNS\_DATA\_BY\_RETURN\_DATE|NA, EU, FE|
|Reports|RFQD\_BULK\_DOWNLOAD|NA, EU, FE|
