# Direct-to-Consumer Shipping (Restricted)
## APIs
|Operation|Method|API Path (URL)|Region|
|-|-|-|-|
|cancelFeed|DELETE|/feeds/2020-09-04/feeds/{feedId}|NA, EU, FE|
|cancelFeed|DELETE|/feeds/2021-06-30/feeds/{feedId}|NA, EU, FE|
|cancelReport|DELETE|/reports/2020-09-04/reports/{reportId}|NA, EU, FE|
|cancelReport|DELETE|/reports/2021-06-30/reports/{reportId}|NA, EU, FE|
|cancelReportSchedule|DELETE|/reports/2020-09-04/schedules/{reportScheduleId}|NA, EU, FE|
|cancelReportSchedule|DELETE|/reports/2021-06-30/schedules/{reportScheduleId}|NA, EU, FE|
|cancelShipment - RDT|DELETE|/mfn/v0/shipments/{shipmentId}|NA, EU, FE|
|cancelShipment|DELETE|/mfn/v0/shipments/{shipmentId}|NA, EU, FE|
|cancelShipmentOld - RDT|PUT|/mfn/v0/shipments/{shipmentId}/cancel|NA, EU, FE|
|cancelShipmentOld|PUT|/mfn/v0/shipments/{shipmentId}/cancel|NA, EU, FE|
|cancelShipment|POST|/shipping/v1/shipments/{shipmentId}/cancel|NA, EU, FE|
|cancelShipment|PUT|/shipping/sandbox/v2/shipments/{shipmentId}/cancel|NA, EU|
|cancelShipment|PUT|/shipping/v2/shipments/{shipmentId}/cancel|NA, EU, FE|
|createDestination|POST|/notifications/v1/destinations|NA, EU, FE|
|createFeedDocument|POST|/feeds/2020-09-04/documents|NA, EU, FE|
|createFeedDocument|POST|/feeds/2021-06-30/documents|NA, EU, FE|
|createFeed|POST|/feeds/2020-09-04/feeds|NA, EU, FE|
|createFeed|POST|/feeds/2021-06-30/feeds|NA, EU, FE|
|createPackages|POST|/externalFulfillment/shipments/2021-01-06/shipments/{shipmentId}/packages|NA, EU, FE|
|createReport|POST|/reports/2020-09-04/reports|NA, EU, FE|
|createReport|POST|/reports/2021-06-30/reports|NA, EU, FE|
|createReportSchedule|POST|/reports/2020-09-04/schedules|NA, EU, FE|
|createReportSchedule|POST|/reports/2021-06-30/schedules|NA, EU, FE|
|createScheduledPackage|POST|/easyship/v0/packages|EU|
|createShipment - RDT|POST|/mfn/v0/shipments|NA, EU, FE|
|createShipment|POST|/mfn/v0/shipments|NA, EU, FE|
|createShipment|POST|/shipping/v1/shipments|NA, EU, FE|
|createTrackingBatchTask|POST|/shipping/v2/tracking/batch|NA, EU, FE|
|directPurchaseShipment|POST|/shipping/v2/shipments/directPurchase|NA, EU|
|generateInvoice|POST|/externalFulfillment/shipments/2021-01-06/shipments/{shipmentId}/packages/{packageId}/invoice|NA, EU, FE|
|generateOrderScenarios|POST|/vendor/directFulfillment/sandbox/2021-10-28/orders|NA, EU, FE|
|generateShipLabel|POST|/externalFulfillment/shipments/2021-01-06/shipments/{shipmentId}/packages/{packageId}/shipLabel|NA, EU, FE|
|getAccount|GET|/shipping/v1/account|NA, EU, FE|
|getAdditionalInputs|GET|/shipping/v2/shipments/additionalInputs/schema|NA, EU|
|getAdditionalSellerInputsOld|POST|/mfn/v0/sellerInputs|NA, EU, FE|
|getAdditionalSellerInputs|POST|/mfn/v0/additionalSellerInputs|NA, EU, FE|
|getBatchTask|GET|/shipping/v2/batch/{taskId}|NA, EU, FE|
|getCustomerInvoice - RDT|GET|/vendor/directFulfillment/shipping/v1/customerInvoices/{purchaseOrderNumber}|NA, EU, FE|
|getCustomerInvoice|GET|/vendor/directFulfillment/shipping/v1/customerInvoices/{purchaseOrderNumber}|NA, EU, FE|
|getCustomerInvoices - RDT|GET|/vendor/directFulfillment/shipping/v1/customerInvoices|NA, EU, FE|
|getCustomerInvoices|GET|/vendor/directFulfillment/shipping/v1/customerInvoices|NA, EU, FE|
|getDestination|GET|/notifications/v1/destinations/{destinationId}|NA, EU, FE|
|getDestinations|GET|/notifications/v1/destinations|NA, EU, FE|
|getEligibleShipmentServicesOld|POST|/mfn/v0/eligibleServices|NA, EU, FE|
|getEligibleShipmentServices|POST|/mfn/v0/eligibleShippingServices|NA, EU, FE|
|getExternalShipMethods|POST|/meetPromise/2020-10-30/externalShipMethods|NA, EU, FE|
|getFeedDocument|GET|/feeds/2020-09-04/documents/{feedDocumentId}|NA, EU, FE|
|getFeedDocument|GET|/feeds/2021-06-30/documents/{feedDocumentId}|NA, EU, FE|
|getFeed|GET|/feeds/2020-09-04/feeds/{feedId}|NA, EU, FE|
|getFeed|GET|/feeds/2021-06-30/feeds/{feedId}|NA, EU, FE|
|getFeeds|GET|/feeds/2020-09-04/feeds|NA, EU, FE|
|getFeeds|GET|/feeds/2021-06-30/feeds|NA, EU, FE|
|getMarketplaceParticipations|GET|/sellers/v1/marketplaceParticipations|FE|
|getMyFeesEstimateForASIN|POST|/products/fees/v0/items/{Asin}/feesEstimate|EU, FE|
|getMyFeesEstimateForSKU|POST|/products/fees/v0/listings/{SellerSKU}/feesEstimate|NA, EU, FE|
|getOrder - RDT|GET|/orders/v0/orders/{orderId}|NA, EU, FE|
|getOrder - RDT|GET|/vendor/directFulfillment/orders/v1/purchaseOrders/{purchaseOrderNumber}|NA, EU, FE|
|getOrderAddress - RDT|GET|/orders/v0/orders/{orderId}/address|NA, EU, FE|
|getOrderAddress|GET|/orders/v0/orders/{orderId}/address|NA, EU, FE|
|getOrderBuyerInfo - RDT|GET|/orders/v0/orders/{orderId}/buyerInfo|NA, EU, FE|
|getOrderBuyerInfo|GET|/orders/v0/orders/{orderId}/buyerInfo|NA, EU, FE|
|getOrder|GET|/orders/v0/orders/{orderId}|NA, EU, FE|
|getOrder|GET|/vendor/directFulfillment/orders/2021-12-28/purchaseOrders/{purchaseOrderNumber}|NA, EU, FE|
|getOrder|GET|/vendor/directFulfillment/orders/v1/purchaseOrders/{purchaseOrderNumber}|NA, EU, FE|
|getOrderItems - RDT|GET|/orders/v0/orders/{orderId}/orderItems|NA, EU, FE|
|getOrderItemsBuyerInfo - RDT|GET|/orders/v0/orders/{orderId}/orderItems/buyerInfo|NA, EU, FE|
|getOrderItemsBuyerInfo|GET|/orders/v0/orders/{orderId}/orderItems/buyerInfo|NA, EU, FE|
|getOrderItems|GET|/orders/v0/orders/{orderId}/orderItems|NA, EU, FE|
|getOrderMetrics|GET|/sales/v1/orderMetrics|FE|
|getOrders - RDT|GET|/orders/v0/orders|NA, EU, FE|
|getOrders - RDT|GET|/vendor/directFulfillment/orders/v1/purchaseOrders|NA, EU, FE|
|getOrderScenarios|GET|/vendor/directFulfillment/sandbox/2021-10-28/transactions/{transactionId}|NA, EU, FE|
|getOrders|GET|/orders/v0/orders|NA, EU, FE|
|getOrders|GET|/vendor/directFulfillment/orders/2021-12-28/purchaseOrders|NA, EU, FE|
|getOrders|GET|/vendor/directFulfillment/orders/v1/purchaseOrders|NA, EU, FE|
|getPackingSlip - RDT|GET|/vendor/directFulfillment/shipping/v1/packingSlips/{purchaseOrderNumber}|NA, EU, FE|
|getPackingSlip|GET|/vendor/directFulfillment/shipping/v1/packingSlips/{purchaseOrderNumber}|NA, EU, FE|
|getPackingSlips - RDT|GET|/vendor/directFulfillment/shipping/v1/packingSlips|NA, EU, FE|
|getPackingSlips|GET|/vendor/directFulfillment/shipping/v1/packingSlips|NA, EU, FE|
|getRates|POST|/shipping/sandbox/v2/shipments/rates|NA, EU|
|getRates|POST|/shipping/v1/rates|NA, EU, FE|
|getRates|POST|/shipping/v2/shipments/rates|NA, EU, FE|
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
|getScheduledPackage|GET|/easyship/v0/packages|EU|
|getShipment - RDT|GET|/externalFulfillment/shipments/2021-01-06/shipments/{shipmentId}|NA, EU, FE|
|getShipment - RDT|GET|/mfn/v0/shipments/{shipmentId}|NA, EU, FE|
|getShipment - RDT|GET|/shipping/v1/shipments/{shipmentId}|NA, EU, FE|
|getShipmentDocuments|GET|/shipping/sandbox/v2/shipments/{shipmentId}/documents|NA, EU|
|getShipmentDocuments|GET|/shipping/v2/shipments/{shipmentId}/documents|NA, EU, FE|
|getShipment|GET|/externalFulfillment/shipments/2021-01-06/shipments/{shipmentId}|NA, EU, FE|
|getShipment|GET|/mfn/v0/shipments/{shipmentId}|NA, EU, FE|
|getShipment|GET|/shipping/v1/shipments/{shipmentId}|NA, EU, FE|
|getShipments - RDT|GET|/externalFulfillment/shipments/2021-01-06/shipments|NA, EU, FE|
|getShipments|GET|/externalFulfillment/shipments/2021-01-06/shipments|NA, EU, FE|
|getShippingLabel - RDT|GET|/vendor/directFulfillment/shipping/v1/shippingLabels/{purchaseOrderNumber}|NA, EU, FE|
|getShippingLabel|GET|/vendor/directFulfillment/shipping/2021-12-28/shippingLabels/{purchaseOrderNumber}|NA, EU, FE|
|getShippingLabel|GET|/vendor/directFulfillment/shipping/v1/shippingLabels/{purchaseOrderNumber}|NA, EU, FE|
|getShippingLabels - RDT|GET|/vendor/directFulfillment/shipping/v1/shippingLabels|NA, EU, FE|
|getShippingLabels|GET|/vendor/directFulfillment/shipping/2021-12-28/shippingLabels|NA, EU, FE|
|getShippingLabels|GET|/vendor/directFulfillment/shipping/v1/shippingLabels|NA, EU, FE|
|getTrackingBatchTask|GET|/shipping/v2/tracking/batch/{taskId}|NA, EU, FE|
|getTracking|GET|/shipping/sandbox/v2/tracking|NA, EU|
|getTracking|GET|/shipping/v2/tracking|NA, EU, FE|
|getTrackingInformation|GET|/shipping/v1/tracking/{trackingId}|NA, EU, FE|
|getTransactionStatus|GET|/vendor/directFulfillment/transactions/2021-12-28/transactions/{transactionId}|NA, EU, FE|
|getTransactionStatus|GET|/vendor/directFulfillment/transactions/v1/transactions/{transactionId}|NA, EU, FE|
|listCatalogCategories|GET|/catalog/v0/categories|NA, FE|
|listHandoverSlots|POST|/easyship/v0/timeSlots|EU|
|OffersSearch|GET|/listings/v1/offers|NA, FE|
|processShipment|POST|/externalFulfillment/shipments/2021-01-06/shipments/{shipmentId}|NA, EU, FE|
|purchaseLabels|POST|/shipping/v1/shipments/{shipmentId}/purchaseLabels|NA, EU, FE|
|purchaseShipment|POST|/shipping/sandbox/v2/shipments|NA, EU|
|purchaseShipment|POST|/shipping/v1/purchaseShipment|NA, EU, FE|
|purchaseShipment|POST|/shipping/v2/shipments|NA, EU, FE|
|retrieveInvoice - RDT|GET|/externalFulfillment/shipments/2021-01-06/shipments/{shipmentId}/packages/{packageId}/invoice|NA, EU, FE|
|retrieveInvoice|GET|/externalFulfillment/shipments/2021-01-06/shipments/{shipmentId}/packages/{packageId}/invoice|NA, EU, FE|
|retrieveShipLabel - RDT|GET|/externalFulfillment/shipments/2021-01-06/shipments/{shipmentId}/packages/{packageId}/shipLabel|NA, EU, FE|
|retrieveShipLabel|GET|/externalFulfillment/shipments/2021-01-06/shipments/{shipmentId}/packages/{packageId}/shipLabel|NA, EU, FE|
|retrieveShippingLabel|POST|/shipping/v1/shipments/{shipmentId}/containers/{trackingId}/label|NA, EU, FE|
|retrieveShippingOptions - RDT|GET|/externalFulfillment/shipments/2021-01-06/shippingOptions|NA, EU, FE|
|retrieveShippingOptions|GET|/externalFulfillment/shipments/2021-01-06/shippingOptions|NA, EU, FE|
|submitAcknowledgement|POST|/vendor/directFulfillment/orders/v1/acknowledgements|NA, EU, FE|
|submitInventoryUpdate|POST|/vendor/directFulfillment/inventory/v1/warehouses/{warehouseId}/items|NA, EU, FE|
|submitInvoice|POST|/vendor/directFulfillment/payments/v1/invoices|NA, EU, FE|
|submitShipmentConfirmations|POST|/vendor/directFulfillment/shipping/v1/shipmentConfirmations|NA, EU, FE|
|submitShipmentStatusUpdates|POST|/vendor/directFulfillment/shipping/v1/shipmentStatusUpdates|NA, EU, FE|
|submitShippingLabelRequest|POST|/vendor/directFulfillment/shipping/2021-12-28/shippingLabels|NA, EU, FE|
|submitShippingLabelRequest|POST|/vendor/directFulfillment/shipping/v1/shippingLabels|NA, EU, FE|
|updatePackage|PUT|/externalFulfillment/shipments/2021-01-06/shipments/{shipmentId}/packages/{packageId}|NA, EU, FE|
|updatePackageStatus|PATCH|/externalFulfillment/shipments/2021-01-06/shipments/{shipmentId}/packages/{packageId}|NA, EU, FE|
|updateScheduledPackages|PATCH|/easyship/v0/packages|EU|
## Feeds, Reports and Notifications
|API Section|Type|Region|
|-|-|-|
|Feeds|POST\_EASYSHIP\_DOCUMENTS|NA, EU, FE|
|Feeds|POST\_EXPECTED\_SHIP\_DATE\_SOD\_FLAT\_FILE|NA, EU, FE|
|Feeds|POST\_EXPECTED\_SHIP\_DATE\_SOD|NA, EU, FE|
|Feeds|POST\_FLAT\_FILE\_FULFILLMENT\_DATA|NA, EU, FE|
|Feeds|POST\_FLAT\_FILE\_ORDER\_ACKNOWLEDGEMENT\_DATA|NA, EU, FE|
|Feeds|POST\_FLAT\_FILE\_PAYMENT\_ADJUSTMENT\_DATA|NA, EU, FE|
|Feeds|POST\_INVOICE\_CONFIRMATION\_DATA|NA, EU, FE|
|Feeds|POST\_ORDER\_ACKNOWLEDGEMENT\_DATA|NA, EU, FE|
|Feeds|POST\_ORDER\_FULFILLMENT\_DATA|NA, EU, FE|
|Feeds|POST\_PAYMENT\_ADJUSTMENT\_DATA|NA, EU, FE|
|Notifications|EXTERNAL_FULFILLMENT_SHIPMENT_STATUS_CHANGE|NA, EU, FE|
|Notifications|FEED_PROCESSING_FINISHED|NA, EU, FE|
|Notifications|ORDER_STATUS_CHANGE|NA, EU, FE|
|Notifications|REPORT_PROCESSING_FINISHED|NA, EU, FE|
|Reports|GET\_CSV\_MFN\_PRIME\_RETURNS\_REPORT|NA, EU, FE|
|Reports|GET\_EASYSHIP\_DOCUMENTS|NA, EU, FE|
|Reports|GET\_EASYSHIP\_PICKEDUP|NA, EU, FE|
|Reports|GET\_EASYSHIP\_WAITING\_FOR\_PICKUP|NA, EU, FE|
|Reports|GET\_FLAT\_FILE\_ACTIONABLE\_ORDER\_DATA\_SHIPPING|NA, EU, FE|
|Reports|GET\_FLAT\_FILE\_ALL\_ORDERS\_DATA\_BY\_LAST\_UPDATE\_GENERAL|NA, EU, FE|
|Reports|GET\_FLAT\_FILE\_ALL\_ORDERS\_DATA\_BY\_ORDER\_DATE\_GENERAL|NA, EU, FE|
|Reports|GET\_FLAT\_FILE\_ARCHIVED\_ORDERS\_DATA\_BY\_ORDER\_DATE|NA, EU, FE|
|Reports|GET\_FLAT\_FILE\_GEO\_OPPORTUNITIES|NA, EU, FE|
|Reports|GET\_FLAT\_FILE\_MFN\_SKU\_RETURN\_ATTRIBUTES\_REPORT|NA, EU, FE|
|Reports|GET\_FLAT\_FILE\_OPEN\_LISTINGS\_DATA|NA, EU, FE|
|Reports|GET\_FLAT\_FILE\_ORDER\_REPORT\_DATA\_SHIPPING|NA, EU, FE|
|Reports|GET\_FLAT\_FILE\_ORDERS\_RECONCILIATION\_DATA\_SHIPPING|NA, EU, FE|
|Reports|GET\_FLAT\_FILE\_RETURNS\_DATA\_BY\_RETURN\_DATE|NA, EU, FE|
|Reports|GET\_MERCHANT\_CANCELLED\_LISTINGS\_DATA|NA, EU, FE|
|Reports|GET\_MERCHANT\_LISTINGS\_ALL\_DATA|NA, EU, FE|
|Reports|GET\_MERCHANT\_LISTINGS\_DATA\_BACK\_COMPAT|NA, EU, FE|
|Reports|GET\_MERCHANT\_LISTINGS\_DATA\_LITE|NA, EU, FE|
|Reports|GET\_MERCHANT\_LISTINGS\_DATA\_LITER|NA, EU, FE|
|Reports|GET\_MERCHANT\_LISTINGS\_DATA|NA, EU, FE|
|Reports|GET\_ORDER\_REPORT\_DATA\_SHIPPING|NA, EU, FE|
|Reports|GET\_ORDERS\_DATA|NA, EU, FE|
|Reports|GET\_PAN\_EU\_OFFER\_STATUS|NA, EU, FE|
|Reports|GET\_REMOTE\_FULFILLMENT\_ELIGIBILITY|NA, EU, FE|
|Reports|GET\_XML\_ALL\_ORDERS\_DATA\_BY\_LAST\_UPDATE\_GENERAL|NA, EU, FE|
|Reports|GET\_XML\_ALL\_ORDERS\_DATA\_BY\_ORDER\_DATE\_GENERAL|NA, EU, FE|
|Reports|GET\_XML\_BROWSE\_TREE\_DATA|NA, EU, FE|
|Reports|GET\_XML\_MFN\_PRIME\_RETURNS\_REPORT|NA, EU, FE|
|Reports|GET\_XML\_MFN\_SKU\_RETURN\_ATTRIBUTES\_REPORT|NA, EU, FE|
|Reports|GET\_XML\_RETURNS\_DATA\_BY\_RETURN\_DATE|NA, EU, FE|
