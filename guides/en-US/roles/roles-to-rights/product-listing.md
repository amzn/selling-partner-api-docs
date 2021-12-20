# Product Listing
## APIs
|Operation|Method|API Path (URL)|Region|
|-|-|-|-|
|cancelFeed|DELETE|/feeds/2020-09-04/feeds/{feedId}|NA, EU, FE|
|cancelFeed|DELETE|/feeds/2021-06-30/feeds/{feedId}|NA, EU, FE|
|cancelFulfillmentOrder|PUT|/fba/outbound/v0/fulfillmentOrders/{sellerFulfillmentOrderId}/cancel|NA, FE|
|cancelReport|DELETE|/reports/2020-09-04/reports/{reportId}|NA, EU, FE|
|cancelReport|DELETE|/reports/2021-06-30/reports/{reportId}|NA, EU, FE|
|cancelReportSchedule|DELETE|/reports/2020-09-04/schedules/{reportScheduleId}|NA, EU, FE|
|cancelReportSchedule|DELETE|/reports/2021-06-30/schedules/{reportScheduleId}|NA, EU, FE|
|cancelShipment|POST|/shipping/v1/shipments/{shipmentId}/cancel|NA, EU, FE|
|createContentDocument|POST|/aplus/2020-11-01/contentDocuments|NA, EU, FE|
|createDestination|POST|/notifications/v1/destinations|NA|
|createFeedDocument|POST|/feeds/2020-09-04/documents|NA, EU, FE|
|createFeedDocument|POST|/feeds/2021-06-30/documents|NA, EU, FE|
|createFeed|POST|/feeds/2020-09-04/feeds|NA, EU, FE|
|createFeed|POST|/feeds/2021-06-30/feeds|NA, EU, FE|
|createProductReviewAndSellerFeedbackSolicitation|POST|/solicitations/v1/orders/{amazonOrderId}/solicitations/productReviewAndSellerFeedback|NA, EU, FE|
|createReport|POST|/reports/2020-09-04/reports|NA, EU, FE|
|createReport|POST|/reports/2021-06-30/reports|NA, EU, FE|
|createReportSchedule|POST|/reports/2020-09-04/schedules|NA, EU, FE|
|createReportSchedule|POST|/reports/2021-06-30/schedules|NA, EU, FE|
|createShipment|POST|/shipping/v1/shipments|NA, EU, FE|
|createUnexpectedProblem|POST|/messaging/v1/orders/{amazonOrderId}/messages/unexpectedProblem|NA, FE|
|createUploadDestinationForResource|POST|/uploads/2020-11-01/uploadDestinations/{resource}|NA|
|createUploadDestination|POST|/uploads/v1/uploadDestinations|NA, EU, FE|
|deleteListingsItem|DELETE|/listings/2020-09-01/items/{sellerId}/{sku}|NA, EU, FE|
|deleteListingsItem|DELETE|/listings/2021-08-01/items/{sellerId}/{sku}|NA, EU, FE|
|deleteSmallAndLightEnrollmentBySellerSKU|DELETE|/fba/smallAndLight/v1/enrollments/{sellerSKU}|NA, EU, FE|
|getAccount|GET|/shipping/v1/account|NA, EU, FE|
|getCatalogItem|GET|/catalog/2020-12-01/items/{asin}|NA, EU, FE|
|getCatalogItem|GET|/catalog/v0/items/{asin}|NA, EU, FE|
|GetClassification|GET|/catalog/v1/classifications/{classificationId}|NA, EU, FE|
|GetClassifications|GET|/catalog/v1/classifications|NA, EU, FE|
|getCompetitivePricing|GET|/products/pricing/v0/competitivePrice|NA, EU, FE|
|getContentDocument|GET|/aplus/2020-11-01/contentDocuments/{contentReferenceKey}|NA, EU, FE|
|getDefinitionsProductType|GET|/definitions/2020-09-01/productTypes/{productType}|NA, EU, FE|
|getDestination|GET|/notifications/v1/destinations/{destinationId}|NA|
|getDestinations|GET|/notifications/v1/destinations|NA|
|getFeedDocument|GET|/feeds/2020-09-04/documents/{feedDocumentId}|NA, EU, FE|
|getFeedDocument|GET|/feeds/2021-06-30/documents/{feedDocumentId}|NA, EU, FE|
|getFeed|GET|/feeds/2020-09-04/feeds/{feedId}|NA, EU, FE|
|getFeed|GET|/feeds/2021-06-30/feeds/{feedId}|NA, EU, FE|
|getFeeds|GET|/feeds/2020-09-04/feeds|NA, EU, FE|
|getFeeds|GET|/feeds/2021-06-30/feeds|NA, EU, FE|
|getInventorySummaries|GET|/fba/inventory/v1/summaries|NA|
|GetItem|GET|/catalog/v1/items/{asin}|NA, EU, FE|
|getItemOffers|GET|/products/pricing/v0/items/{Asin}/offers|NA, EU, FE|
|getListingOffers|GET|/products/pricing/v0/listings/{SellerSKU}/offers|NA, EU, FE|
|getListingsItem|GET|/listings/2021-08-01/items/{sellerId}/{sku}|NA, EU, FE|
|getListingsRestrictions|GET|/listings/2021-08-01/restrictions|NA, EU, FE|
|getMarketplaceParticipations|GET|/sellers/v1/marketplaceParticipations|NA, EU, FE|
|getMyFeesEstimateForASIN|POST|/products/fees/v0/items/{Asin}/feesEstimate|NA, EU, FE|
|getMyFeesEstimateForSKU|POST|/products/fees/v0/listings/{SellerSKU}/feesEstimate|NA, EU, FE|
|getOrderAddress|GET|/orders/v0/orders/{orderId}/address|NA, EU, FE|
|getOrderBuyerInfo|GET|/orders/v0/orders/{orderId}/buyerInfo|NA, EU, FE|
|getOrder|GET|/orders/v0/orders/{orderId}|NA, EU, FE|
|getOrderItemsBuyerInfo|GET|/orders/v0/orders/{orderId}/orderItems/buyerInfo|NA, EU, FE|
|getOrderItems|GET|/orders/v0/orders/{orderId}/orderItems|NA, EU, FE|
|getOrderMetrics|GET|/sales/v1/orderMetrics|NA, EU, FE|
|getOrders|GET|/orders/v0/orders|NA, EU, FE|
|getPricing|GET|/products/pricing/v0/price|NA, EU, FE|
|getRates|POST|/shipping/v1/rates|NA, EU, FE|
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
|getShipment|GET|/shipping/v1/shipments/{shipmentId}|NA, EU, FE|
|getSmallAndLightEligibilityBySellerSKU|GET|/fba/smallAndLight/v1/eligibilities/{sellerSKU}|NA, EU, FE|
|getSmallAndLightEnrollmentBySellerSKU|GET|/fba/smallAndLight/v1/enrollments/{sellerSKU}|NA, EU, FE|
|getSmallAndLightFeePreview|POST|/fba/smallAndLight/v1/feePreviews|NA, EU, FE|
|getSolicitationActionsForOrder|GET|/solicitations/v1/orders/{amazonOrderId}|NA, EU, FE|
|getTrackingInformation|GET|/shipping/v1/tracking/{trackingId}|NA, EU, FE|
|listCatalogCategories|GET|/catalog/v0/categories|NA, EU, FE|
|listCatalogItems|GET|/catalog/v0/items|NA, EU, FE|
|listContentDocumentAsinRelations|GET|/aplus/2020-11-01/contentDocuments/{contentReferenceKey}/asins|NA, EU, FE|
|OffersSearch|GET|/listings/v1/offers|NA, EU, FE|
|patchListingsItem|PATCH|/listings/2020-09-01/items/{sellerId}/{sku}|NA, EU, FE|
|patchListingsItem|PATCH|/listings/2021-08-01/items/{sellerId}/{sku}|NA, EU, FE|
|postContentDocumentApprovalSubmission|POST|/aplus/2020-11-01/contentDocuments/{contentReferenceKey}/approvalSubmissions|NA, EU, FE|
|postContentDocumentAsinRelations|POST|/aplus/2020-11-01/contentDocuments/{contentReferenceKey}/asins|NA, EU, FE|
|postContentDocumentSuspendSubmission|POST|/aplus/2020-11-01/contentDocuments/{contentReferenceKey}/suspendSubmissions|NA, EU|
|purchaseLabels|POST|/shipping/v1/shipments/{shipmentId}/purchaseLabels|NA, EU, FE|
|purchaseShipment|POST|/shipping/v1/purchaseShipment|NA, EU, FE|
|putListingsItem|PUT|/listings/2020-09-01/items/{sellerId}/{sku}|NA, EU, FE|
|putListingsItem|PUT|/listings/2021-08-01/items/{sellerId}/{sku}|NA, EU, FE|
|putSmallAndLightEnrollmentBySellerSKU|PUT|/fba/smallAndLight/v1/enrollments/{sellerSKU}|NA, EU, FE|
|retrieveShippingLabel|POST|/shipping/v1/shipments/{shipmentId}/containers/{trackingId}/label|NA, EU, FE|
|searchCatalogItems|GET|/catalog/2020-12-01/items|NA, EU, FE|
|searchContentDocuments|GET|/aplus/2020-11-01/contentDocuments|NA, EU, FE|
|searchContentPublishRecords|GET|/aplus/2020-11-01/contentPublishRecords|NA, EU, FE|
|searchDefinitionsProductTypes|GET|/definitions/2020-09-01/productTypes|NA, EU, FE|
|updateContentDocument|POST|/aplus/2020-11-01/contentDocuments/{contentReferenceKey}|NA, EU, FE|
|validateContentDocumentAsinRelations|POST|/aplus/2020-11-01/contentAsinValidations|NA, EU|
&nbsp;
## Feeds, Reports and Notifications
|API Section|Type|Region|
|-|-|-|
|Feeds|JSON\_LISTINGS\_FEED|NA, EU, FE|
|Feeds|POST\_ENHANCED\_CONTENT\_DATA|NA, EU, FE|
|Feeds|POST\_FLAT\_FILE\_BOOKLOADER\_DATA|NA, EU, FE|
|Feeds|POST\_FLAT\_FILE\_CONVERGENCE\_LISTINGS\_DATA|NA, EU, FE|
|Feeds|POST\_FLAT\_FILE\_INVLOADER\_DATA|NA, EU, FE|
|Feeds|POST\_FLAT\_FILE\_LISTINGS\_DATA|NA, EU, FE|
|Feeds|POST\_FLAT\_FILE\_PRICEANDQUANTITYONLY\_UPDATE\_DATA|NA, EU, FE|
|Feeds|POST\_INVENTORY\_AVAILABILITY\_DATA|NA, EU, FE|
|Feeds|POST\_PRODUCT\_DATA|NA, EU, FE|
|Feeds|POST\_PRODUCT\_IMAGE\_DATA|NA, EU, FE|
|Feeds|POST\_PRODUCT\_OVERRIDES\_DATA|NA, EU, FE|
|Feeds|POST\_PRODUCT\_PRICING\_DATA|NA, EU, FE|
|Feeds|POST\_PRODUCT\_RELATIONSHIP\_DATA|NA, EU, FE|
|Feeds|POST\_SHIPPING\_OVERRIDE\_DATA|NA, EU, FE|
|Feeds|POST\_STD\_ACES\_DATA|NA, EU, FE|
|Feeds|POST\_UIEE\_BOOKLOADER\_DATA|NA, EU, FE|
|Notifications|BRANDED_ITEM_CONTENT_CHANGE|NA, EU, FE|
|Notifications|brandedItemContentChange|NA|
|Notifications|FEE_PROMOTION|NA, EU, FE|
|Notifications|FEED_PROCESSING_FINISHED|NA, EU, FE|
|Notifications|ITEM_PRODUCT_TYPE_CHANGE|NA, EU, FE|
|Notifications|itemProductTypeChange|NA|
|Notifications|LISTINGS_ITEM_ISSUES_CHANGE|NA, EU, FE|
|Notifications|LISTINGS_ITEM_STATUS_CHANGE|NA, EU, FE|
|Notifications|PRODUCT_TYPE_DEFINITIONS_CHANGE|NA, EU, FE|
|Notifications|REPORT_PROCESSING_FINISHED|NA, EU, FE|
|Reports|FEE\_DISCOUNTS\_REPORT|NA, EU, FE|
|Reports|GET\_B2B\_PRODUCT\_OPPORTUNITIES\_NOT\_YET\_ON\_AMAZON|NA, EU, FE|
|Reports|GET\_B2B\_PRODUCT\_OPPORTUNITIES\_RECOMMENDED\_FOR\_YOU|NA, EU, FE|
|Reports|GET\_CONVERGED\_FLAT\_FILE\_PENDING\_ORDERS\_DATA|NA, EU, FE|
|Reports|GET\_CONVERGED\_FLAT\_FILE\_SOLD\_LISTINGS\_DATA|NA, EU, FE|
|Reports|GET\_FLAT\_FILE\_ALL\_ORDERS\_DATA\_BY\_LAST\_UPDATE\_GENERAL|NA, EU, FE|
|Reports|GET\_FLAT\_FILE\_GEO\_OPPORTUNITIES|NA, EU, FE|
|Reports|GET\_FLAT\_FILE\_OPEN\_LISTINGS\_DATA|NA, EU, FE|
|Reports|GET\_MERCHANT\_CANCELLED\_LISTINGS\_DATA|NA, EU, FE|
|Reports|GET\_MERCHANT\_LISTINGS\_ALL\_DATA|NA, EU, FE|
|Reports|GET\_MERCHANT\_LISTINGS\_DATA\_BACK\_COMPAT|NA, EU, FE|
|Reports|GET\_MERCHANT\_LISTINGS\_DATA\_LITE|NA, EU, FE|
|Reports|GET\_MERCHANT\_LISTINGS\_DATA\_LITER|NA, EU, FE|
|Reports|GET\_MERCHANT\_LISTINGS\_DATA|NA, EU, FE|
|Reports|GET\_MERCHANT\_LISTINGS\_DEFECT\_DATA|NA, EU, FE|
|Reports|GET\_MERCHANT\_LISTINGS\_INACTIVE\_DATA|NA, EU, FE|
|Reports|GET\_MERCHANTS\_LISTINGS\_FYP\_REPORT|NA, EU, FE|
|Reports|GET\_PAN\_EU\_OFFER\_STATUS|NA, EU, FE|
|Reports|GET\_XML\_BROWSE\_TREE\_DATA|NA, EU, FE|
