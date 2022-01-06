# Buyer Communication
## APIs
|Operation|Method|API Path (URL)|Region|
|-|-|-|-|
|confirmCustomizationDetails|POST|/messaging/v1/orders/{amazonOrderId}/messages/confirmCustomizationDetails|NA, EU, FE|
|CreateAmazonMotors|POST|/messaging/v1/orders/{amazonOrderId}/messages/amazonMotors|NA, EU, FE|
|createConfirmDeliveryDetails|POST|/messaging/v1/orders/{amazonOrderId}/messages/confirmDeliveryDetails|NA, EU, FE|
|createConfirmOrderDetails|POST|/messaging/v1/orders/{amazonOrderId}/messages/confirmOrderDetails|NA, EU, FE|
|createConfirmServiceDetails|POST|/messaging/v1/orders/{amazonOrderId}/messages/confirmServiceDetails|NA, EU, FE|
|createDestination|POST|/notifications/v1/destinations|NA, EU, FE|
|createDigitalAccessKey|POST|/messaging/v1/orders/{amazonOrderId}/messages/digitalAccessKey|NA, EU, FE|
|createLegalDisclosure|POST|/messaging/v1/orders/{amazonOrderId}/messages/legalDisclosure|NA, EU, FE|
|createNegativeFeedbackRemoval|POST|/messaging/v1/orders/{amazonOrderId}/messages/negativeFeedbackRemoval|NA, EU, FE|
|createUnexpectedProblem|POST|/messaging/v1/orders/{amazonOrderId}/messages/unexpectedProblem|NA, EU, FE|
|createUploadDestination|POST|/uploads/v1/uploadDestinations|NA, EU, FE|
|CreateWarranty|POST|/messaging/v1/orders/{amazonOrderId}/messages/warranty|NA, EU, FE|
|getAdditionalSellerInputs|POST|/mfn/v0/additionalSellerInputs|NA, FE|
|GetAttributes|GET|/messaging/v1/orders/{amazonOrderId}/attributes|NA, EU, FE|
|getDestination|GET|/notifications/v1/destinations/{destinationId}|NA, EU, FE|
|getDestinations|GET|/notifications/v1/destinations|NA, EU, FE|
|getMarketplaceParticipations|GET|/sellers/v1/marketplaceParticipations|FE|
|getMessagingActionsForOrder|GET|/messaging/v1/orders/{amazonOrderId}|NA, EU, FE|
|getMyFeesEstimateForASIN|POST|/products/fees/v0/items/{Asin}/feesEstimate|NA, EU, FE|
|getMyFeesEstimateForSKU|POST|/products/fees/v0/listings/{SellerSKU}/feesEstimate|NA, EU, FE|
|getOrderAddress|GET|/orders/v0/orders/{orderId}/address|NA, EU, FE|
|getOrderBuyerInfo|GET|/orders/v0/orders/{orderId}/buyerInfo|NA, EU, FE|
|getOrder|GET|/orders/v0/orders/{orderId}|NA, EU, FE|
|getOrderItemsBuyerInfo|GET|/orders/v0/orders/{orderId}/orderItems/buyerInfo|NA, EU, FE|
|getOrderItems|GET|/orders/v0/orders/{orderId}/orderItems|NA, EU, FE|
|getOrderMetrics|GET|/sales/v1/orderMetrics|FE|
|getOrders|GET|/orders/v0/orders|NA, EU, FE|
|sendInvoice|POST|/messaging/v1/orders/{amazonOrderId}/messages/invoice|NA, EU, FE|
