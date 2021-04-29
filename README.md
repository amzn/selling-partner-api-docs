## Selling Partner API Documentation
This repository contains documentation for developers to use when building applications that call the Selling Partner APIs. The documentation includes API references, use case guides, and additional guides and documents. 

Please see the [Selling Partner API Developer Guide](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md) for instructions to get started.

The [guides](https://github.com/amzn/selling-partner-api-docs/tree/main/guides) directory contains use case guides and additional guides and documentation.

The [references](https://github.com/amzn/selling-partner-api-docs/tree/main/references) directory contains API references for all available Selling Partner APIs. In order to use these APIs you must be a registered developer. Not all APIs are accessible by all registered developers and you must have approval from Amazon before you can access these APIs.

You can find the API models and currently available client helper code in the [selling-partner-api-models](https://github.com/amzn/selling-partner-api-models) repo.

The [selling-partner-api-models/models](https://github.com/amzn/selling-partner-api-models/tree/main/models) directory contains all of the currently available Selling Partner API models.

The [selling-partner-api-models/clients](https://github.com/amzn/selling-partner-api-models/tree/main/clients) directory contains a [Java library](https://github.com/amzn/selling-partner-api-models/tree/main/clients/sellingpartner-api-aa-java) and a [C# library](https://github.com/amzn/selling-partner-api-models/tree/main/clients/sellingpartner-api-aa-csharp) with mustache templates for use with [swagger-codegen](https://swagger.io/tools/swagger-codegen/) to generate client libraries with authentication and authorization functionality included. The templates are located in *resources/swagger-codegen*.

### Selling Partner APIs that support Amazon's Vendor Programs

Developers can use the Selling Partner vendor APIs to help automate the program operations of vendors enrolled in the following invitation-only programs:

* **Retail Procurement Program**. With the Retail Procurement program Amazon invites selected vendors to partner with Amazon to fulfill purchase orders to be shipped to an Amazon fulfillment center.

* **Direct Fulfillment Program**. With the Direct Fulfillment program Amazon invites selected vendors to partner with Amazon to fulfill orders directly to customers on Amazon's behalf.

If you are a developer working with a vendor enrolled in the retail procurement or direct fulfillment programs, see below for links to more information about the related Selling Partner APIs. 

#### Retail Procurement Program
Retail Procurement Use Case Guide: [Vendor Retail Procurement APIs Use Case Guide](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/use-case-guides/vendor-retail-procurement-apis-use-case-guide/vendor-retail-procurement-apis-use-case-guide.md)

| **Selling Partner API**                                       | **Vendor Model**                                                                                                                                                     | **API Reference**                                                                                                                                            |
|---------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Selling Partner API for Retail Procurement Payments           | [vendorInvoices.json](https://github.com/amzn/selling-partner-api-models/tree/main/models/vendor-invoices-api-model/vendorInvoices.json)                             | [vendorInvoices.md](https://github.com/amzn/selling-partner-api-docs/blob/main/references/vendor-invoices-api/vendorInvoices.md)                             |
| Selling Partner API for Retail Procurement Orders             | [vendorOrders.json](https://github.com/amzn/selling-partner-api-models/tree/main/models/vendor-orders-api-model/vendorOrders.json)                                   | [vendorOrders.md](https://github.com/amzn/selling-partner-api-docs/blob/main/references/vendor-orders-api/vendorOrders.md)                                   |
| Selling Partner API for Retail Procurement Shipments          | [vendorShipments.json](https://github.com/amzn/selling-partner-api-models/tree/main/models/vendor-shipments-api-model/vendorShipments.json)                          | [vendorShipments.md](https://github.com/amzn/selling-partner-api-docs/blob/main/references/vendor-shipments-api/vendorShipments.md)                          |
| Selling Partner API for Retail Procurement Transaction Status | [vendorTransactionStatus.json](https://github.com/amzn/selling-partner-api-models/tree/main/models/vendor-transaction-status-api-model/vendorTransactionStatus.json) | [vendorTransactionStatus.md](https://github.com/amzn/selling-partner-api-docs/blob/main/references/vendor-transaction-status-api/vendorTransactionStatus.md) |


#### Direct Fulfillment Program
Direct Fulfillment Use Case Guide: [Vendor Direct Fulfillment APIs Use Case Guide](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/use-case-guides/vendor-direct-fulfillment-apis-use-case-guide/vendor-direct-fulfillment-apis-use-case-guide.md)

| **Selling Partner API**                                       | **Vendor Model**                                                                                                                                                                                              | **API Reference**                                                                                                                                                                                     |
|---------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Selling Partner API for Direct Fulfillment Inventory Updates  | [vendorDirectFulfillmentInventoryV1.json](https://github.com/amzn/selling-partner-api-models/tree/main/models/vendor-direct-fulfillment-inventory-api-model/vendorDirectFulfillmentInventoryV1.json)          | [vendorDirectFulfillmentInventoryV1.md](https://github.com/amzn/selling-partner-api-docs/blob/main/references/vendor-direct-fulfillment-inventory-api/vendorDirectFulfillmentInventoryV1.md)          |
| Selling Partner API for Direct Fulfillment Orders             | [vendorDirectFulfillmentOrdersV1.json](https://github.com/amzn/selling-partner-api-models/tree/main/models/vendor-direct-fulfillment-orders-api-model/vendorDirectFulfillmentOrdersV1.json)                   | [vendorDirectFulfillmentOrdersV1.md](https://github.com/amzn/selling-partner-api-docs/blob/main/references/vendor-direct-fulfillment-orders-api/vendorDirectFulfillmentOrdersV1.md)                   |
| Selling Partner API for Direct Fulfillment Payments           | [vendorDirectFulfillmentPaymentsV1.json](https://github.com/amzn/selling-partner-api-models/tree/main/models/vendor-direct-fulfillment-payments-api-model/vendorDirectFulfillmentPaymentsV1.json)             | [vendorDirectFulfillmentPaymentsV1.md](https://github.com/amzn/selling-partner-api-docs/blob/main/references/vendor-direct-fulfillment-payments-api/vendorDirectFulfillmentPaymentsV1.md)             |
| Selling Partner API for Direct Fulfillment Shipping           | [vendorDirectFulfillmentShippingV1.json](https://github.com/amzn/selling-partner-api-models/tree/main/models/vendor-direct-fulfillment-shipping-api-model/vendorDirectFulfillmentShippingV1.json)             | [vendorDirectFulfillmentShippingV1.md](https://github.com/amzn/selling-partner-api-docs/blob/main/references/vendor-direct-fulfillment-shipping-api/vendorDirectFulfillmentShippingV1.md)             |
| Selling Partner API for Direct Fulfillment Transaction Status | [vendorDirectFulfillmentTransactionsV1.json](https://github.com/amzn/selling-partner-api-models/tree/main/models/vendor-direct-fulfillment-transactions-api-model/vendorDirectFulfillmentTransactionsV1.json) | [vendorDirectFulfillmentTransactionsV1.md](https://github.com/amzn/selling-partner-api-docs/blob/main/references/vendor-direct-fulfillment-transactions-api/vendorDirectFulfillmentTransactionsV1.md) |


## Security

See [CONTRIBUTING](CONTRIBUTING.md#security-issue-notifications) for more information.

## License

This project is licensed under the Apache-2.0 License.

