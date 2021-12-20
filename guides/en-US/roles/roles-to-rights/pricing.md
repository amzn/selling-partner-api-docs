# Pricing
## APIs
|Operation|Method|API Path (URL)|Region|
|-|-|-|-|
|cancelFeed|DELETE|/feeds/2020-09-04/feeds/{feedId}|NA, EU, FE|
|cancelFeed|DELETE|/feeds/2021-06-30/feeds/{feedId}|NA, EU, FE|
|cancelReport|DELETE|/reports/2020-09-04/reports/{reportId}|NA, EU, FE|
|cancelReport|DELETE|/reports/2021-06-30/reports/{reportId}|NA, EU, FE|
|cancelReportSchedule|DELETE|/reports/2020-09-04/schedules/{reportScheduleId}|NA, EU, FE|
|cancelReportSchedule|DELETE|/reports/2021-06-30/schedules/{reportScheduleId}|NA, EU, FE|
|createDestination|POST|/notifications/v1/destinations|NA|
|createFeedDocument|POST|/feeds/2020-09-04/documents|NA, EU, FE|
|createFeedDocument|POST|/feeds/2021-06-30/documents|NA, EU, FE|
|createFeed|POST|/feeds/2020-09-04/feeds|NA, EU, FE|
|createFeed|POST|/feeds/2021-06-30/feeds|NA, EU, FE|
|createReport|POST|/reports/2020-09-04/reports|NA, EU, FE|
|createReport|POST|/reports/2021-06-30/reports|NA, EU, FE|
|createReportSchedule|POST|/reports/2020-09-04/schedules|NA, EU, FE|
|createReportSchedule|POST|/reports/2021-06-30/schedules|NA, EU, FE|
|getCompetitivePricing|GET|/products/pricing/v0/competitivePrice|NA, EU, FE|
|getDestination|GET|/notifications/v1/destinations/{destinationId}|NA|
|getDestinations|GET|/notifications/v1/destinations|NA|
|getFeedDocument|GET|/feeds/2020-09-04/documents/{feedDocumentId}|NA, EU, FE|
|getFeedDocument|GET|/feeds/2021-06-30/documents/{feedDocumentId}|NA, EU, FE|
|getFeed|GET|/feeds/2020-09-04/feeds/{feedId}|NA, EU, FE|
|getFeed|GET|/feeds/2021-06-30/feeds/{feedId}|NA, EU, FE|
|getFeeds|GET|/feeds/2020-09-04/feeds|NA, EU, FE|
|getFeeds|GET|/feeds/2021-06-30/feeds|NA, EU, FE|
|getItemOffers|GET|/products/pricing/v0/items/{Asin}/offers|NA, EU, FE|
|getListingOffers|GET|/products/pricing/v0/listings/{SellerSKU}/offers|NA, EU, FE|
|getMarketplaceParticipations|GET|/sellers/v1/marketplaceParticipations|FE|
|getMyFeesEstimateForASIN|POST|/products/fees/v0/items/{Asin}/feesEstimate|NA, EU, FE|
|getMyFeesEstimateForSKU|POST|/products/fees/v0/listings/{SellerSKU}/feesEstimate|NA, EU, FE|
|getOrderAddress|GET|/orders/v0/orders/{orderId}/address|NA, EU, FE|
|getOrderBuyerInfo|GET|/orders/v0/orders/{orderId}/buyerInfo|NA, EU, FE|
|getOrder|GET|/orders/v0/orders/{orderId}|NA, EU, FE|
|getOrderItemsBuyerInfo|GET|/orders/v0/orders/{orderId}/orderItems/buyerInfo|NA, EU, FE|
|getOrderItems|GET|/orders/v0/orders/{orderId}/orderItems|NA, EU, FE|
|getOrderMetrics|GET|/sales/v1/orderMetrics|FE|
|getOrders|GET|/orders/v0/orders|NA, EU, FE|
|getPricing|GET|/products/pricing/v0/price|NA, EU, FE|
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
&nbsp;
## Feeds, Reports and Notifications
|API Section|Type|Region|
|-|-|-|
|Feeds|RFQ\_UPLOAD\_FEED|NA, EU, FE|
|Notifications|ANY_OFFER_CHANGED|NA, EU, FE\*|
|Notifications|B2B_ANY_OFFER_CHANGED|NA|
|Notifications|FEED_PROCESSING_FINISHED|NA, EU, FE\*|
|Notifications|ITEM_PRODUCT_TYPE_CHANGE|NA|
|Notifications|REPORT_PROCESSING_FINISHED|NA, EU, FE\*|
|Reports|GET\_AFN\_INVENTORY\_DATA\_BY\_COUNTRY|NA, EU, FE|
|Reports|GET\_AMAZON\_FULFILLED\_SHIPMENTS\_DATA\_GENERAL|NA, EU, FE|
|Reports|GET\_CSV\_MFN\_PRIME\_RETURNS\_REPORT|NA, EU, FE|
|Reports|GET\_EXCESS\_INVENTORY\_DATA|NA, EU, FE|
|Reports|GET\_FBA\_ESTIMATED\_FBA\_FEES\_TXT\_DATA|NA, EU, FE|
|Reports|GET\_FBA\_FULFILLMENT\_CURRENT\_INVENTORY\_DATA|NA, EU, FE|
|Reports|GET\_FBA\_FULFILLMENT\_CUSTOMER\_RETURNS\_DATA|NA, EU, FE|
|Reports|GET\_FBA\_FULFILLMENT\_CUSTOMER\_SHIPMENT\_PROMOTION\_DATA|NA, EU, FE|
|Reports|GET\_FBA\_FULFILLMENT\_INBOUND\_NONCOMPLIANCE\_DATA|NA, EU, FE|
|Reports|GET\_FBA\_FULFILLMENT\_INVENTORY\_ADJUSTMENTS\_DATA|NA, EU, FE|
|Reports|GET\_FBA\_FULFILLMENT\_INVENTORY\_HEALTH\_DATA|NA, EU, FE|
|Reports|GET\_FBA\_FULFILLMENT\_INVENTORY\_RECEIPTS\_DATA|NA, EU, FE|
|Reports|GET\_FBA\_FULFILLMENT\_INVENTORY\_SUMMARY\_DATA|NA, EU, FE|
|Reports|GET\_FBA\_FULFILLMENT\_LONGTERM\_STORAGE\_FEE\_CHARGES\_DATA|NA, EU, FE|
|Reports|GET\_FBA\_FULFILLMENT\_MONTHLY\_INVENTORY\_DATA|NA, EU, FE|
|Reports|GET\_FBA\_FULFILLMENT\_REMOVAL\_ORDER\_DETAIL\_DATA|NA, EU, FE|
|Reports|GET\_FBA\_FULFILLMENT\_REMOVAL\_SHIPMENT\_DETAIL\_DATA|NA, EU, FE|
|Reports|GET\_FBA\_INVENTORY\_AGED\_DATA|NA, EU, FE|
|Reports|GET\_FBA\_MYI\_ALL\_INVENTORY\_DATA|NA, EU, FE|
|Reports|GET\_FBA\_MYI\_UNSUPPRESSED\_INVENTORY\_DATA|NA, EU, FE|
|Reports|GET\_FBA\_RECOMMENDED\_REMOVAL\_DATA|NA, EU, FE|
|Reports|GET\_FBA\_REIMBURSEMENTS\_DATA|NA, EU, FE|
|Reports|GET\_FBA\_STORAGE\_FEE\_CHARGES\_DATA|NA, EU, FE|
|Reports|GET\_FBA\_UNO\_INVENTORY\_DATA|NA, EU, FE|
|Reports|GET\_FLAT\_FILE\_ALL\_ORDERS\_DATA\_BY\_LAST\_UPDATE\_GENERAL|NA, EU, FE|
|Reports|GET\_FLAT\_FILE\_ALL\_ORDERS\_DATA\_BY\_ORDER\_DATE\_GENERAL|NA, EU, FE|
|Reports|GET\_FLAT\_FILE\_ARCHIVED\_ORDERS\_DATA\_BY\_ORDER\_DATE|NA, EU, FE|
|Reports|GET\_FLAT\_FILE\_GEO\_OPPORTUNITIES|NA, EU, FE|
|Reports|GET\_FLAT\_FILE\_MFN\_SKU\_RETURN\_ATTRIBUTES\_REPORT|NA, EU, FE|
|Reports|GET\_FLAT\_FILE\_OPEN\_LISTINGS\_DATA|NA, EU, FE|
|Reports|GET\_MERCHANT\_CANCELLED\_LISTINGS\_DATA|NA, EU, FE|
|Reports|GET\_MERCHANT\_LISTINGS\_ALL\_DATA|NA, EU, FE|
|Reports|GET\_MERCHANT\_LISTINGS\_DATA\_BACK\_COMPAT|NA, EU, FE|
|Reports|GET\_MERCHANT\_LISTINGS\_DATA\_LITE|NA, EU, FE|
|Reports|GET\_MERCHANT\_LISTINGS\_DATA\_LITER|NA, EU, FE|
|Reports|GET\_MERCHANT\_LISTINGS\_DATA|NA, EU, FE|
|Reports|GET\_MERCHANT\_LISTINGS\_DEFECT\_DATA|NA, EU, FE|
|Reports|GET\_MERCHANT\_LISTINGS\_INACTIVE\_DATA|NA, EU, FE|
|Reports|GET\_PAN\_EU\_OFFER\_STATUS|NA, EU, FE|
|Reports|GET\_RESERVED\_INVENTORY\_DATA|NA, EU, FE|
|Reports|GET\_RESTOCK\_INVENTORY\_RECOMMENDATIONS\_REPORT|NA, EU, FE|
|Reports|GET\_STRANDED\_INVENTORY\_LOADER\_DATA|NA, EU, FE|
|Reports|GET\_STRANDED\_INVENTORY\_UI\_DATA|NA, EU, FE|
|Reports|GET\_XML\_ALL\_ORDERS\_DATA\_BY\_LAST\_UPDATE\_GENERAL|NA, EU, FE|
|Reports|GET\_XML\_ALL\_ORDERS\_DATA\_BY\_ORDER\_DATE\_\_GENERAL|NA, EU, FE|
|Reports|GET\_XML\_ALL\_ORDERS\_DATA\_BY\_ORDER\_DATE\_GENERAL|NA, EU, FE|
|Reports|GET\_XML\_BROWSE\_TREE\_DATA|NA, EU, FE|
|Reports|GET\_XML\_MFN\_PRIME\_RETURNS\_REPORT|NA, EU, FE|
\* Functionality may not be entirely available in this region.
