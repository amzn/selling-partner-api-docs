# Amazon MWS to Selling Partner API Migration Guide

### Contents

- [Overview](#overview)
- [Migration Guidelines Summary](#migration-guidelines-summary)
- [Differences between Amazon MWS and Selling Partner API](#differences-between-amazon-mws-and-selling-partner-api)
   - [Amazon MWS to Selling Partner API migration mapping](#amazon-mws-to-selling-partner-api-migration-mapping)
- [Migration Process](#migration-process)
- [Migrating MWS Seller Authorizations to Selling Partner API](#migrating-mws-seller-authorizations-to-selling-partner)
   - [Prerequisites of using the Authorization API](#prerequisites-of-using-the-authorization-api)
   - [How does the Authorization API Work?](#how-does-the-authorization-api-work)
- [Roles definitions in Selling Partner APIs](#role-definitions-in-selling-partner-apis)
- [Selling Partner API sandbox](#selling-partner-api-sandbox)
- [Additional Resources](#additional-resources)

# Overview
This document provides a set of guidelines to migrate from Amazon Marketplace Web Service (Amazon MWS) to the Selling Partner API. If your application currently uses Amazon MWS, you can migrate to Selling Partner operations that are built on the functionality of Amazon MWS operations, providing features to improve usability and security for developers and selling partners.

# Migration Guidelines Summary
The Selling Partner API is a REST-based API that helps Amazon sellers programmatically access their data on listings, orders, payments, reports, and more. Applications using Amazon MWS can now adopt the Selling Partner API to increase selling efficiency, reduce labor requirements, improve response time to customers, and help sellers grow their businesses. 

## Differences between Amazon MWS and the Selling Partner API
The Selling Partner API is a modernization of Amazon MWS and includes all functionality previously available from Amazon MWS. All future development will only be available for the Selling Partner API. 

Each API documentation set contains a Swagger model, an API reference, and may include a Use Case Guide. The documentation also provides sample client libraries for use when authenticating calls to Selling Partner API operations.

Some of the new features in the Selling Partner API:
* A REST-based service with JSON based input and output format. 
* New endpoints that are supported in all regions.
* Step-by-step instructions in the SP-API Developer Guide for automated SDK generation.
* A sandbox feature with separate sandbox endpoints and support for testing with mock data. 
* A dynamic usage plan that automatically adjusts (throttles) rate-limits to each selling partner based on a variety of measures.
* Single Selling Partner API application are applicable across all regions.
* Support for Restricted Data Tokens, which help protect customers' Personally Identifiable Information (PII).

New APIs in the Selling Partner API:
* **Authorization API.** Exchange an existing MWS auth token with a Selling Partner API LWA auth code.
* **Messaging API.** Enables sellers to send supported messages types to customers.
* **Solicitations API.** Enables sellers to send non-critical solicitations to customers.
* **Sales API.** Enables sellers to generate Sales history reports. 
* **FBA Small and Light API.** Supports the FBA small and light program.
* **FBA Inbound Eligibility API.**  Compliments the Fulfillment by Amazon (FBA) inbound workflow by enabling selling partners to check ASIN eligibility for participation in FBA before creating inbound shipments.  
* **FBA Inventory API.** New and improved FBA inventory API with new feature for FBA sellers.
* **Notifications API.** Get new ASIN change notifications. Enables developers to receive information about changes to ASIN detail page content. 

**Amazon MWS to Selling Partner API migration mapping**

| Amazon MWS                        | Selling Partner API               |
|-----------------------------------|-----------------------------------|
| Feeds API section           | Uploads API and Feeds API         |
| Finances API section           | Finances API                      |
| Merchant Fulfillment API section | Merchant Fulfillment API          |
| Fulfillment Inventory API section | FBA Inventory API                 |
| Orders API section                | Orders API                        |
| Products API section - Product Listings          | Catalog Items API                 |
| Products API section - Product Fees              | Product Fees API                  |
| Products API section - Product Pricing           | Product Pricing API               |
| Recommendations API section       | *Deprecated in Selling Partner API* |
| Reports API section            | Reports API                       |
| Sellers API section               | Sellers API                       |
| Fulfillment Inbound Shipment API section | Fulfillment Inbound API           |
| Fulfillment Outbound Shipment API section | Fulfillment Outbound API          |
| Subscriptions API section         | Notifications API                 |

## Migration Process
These steps describe how to migrate from Amazon MWS to Selling Partner API:
1. **Register your MWS App as a hybrid application**  
    Convert your current Amazon MWS application into a hybrid Selling Partner Application. For more information, see the [Selling Partner API Developer Guide](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/developer-guide/SellingPartnerApiDeveloperGuide.md#registering-your-selling-partner-api-application).  
2. **Authorize a Selling Partner API application**  
    Implement the Authorization model for Selling Partner APIs (OAuth 2.0). For more information, see the [Selling Partner API Developer Guide](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/developer-guide/SellingPartnerApiDeveloperGuide.md#authorizing-selling-partner-api-applications).
  
3. **Connect to Selling Partner APIs**   
Implement connecting to APIs using the Selling Partner endpoint. For more information, see the [Selling Partner API Developer Guide](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/developer-guide/SellingPartnerApiDeveloperGuide.md#connecting-to-the-selling-partner-api). For information on connecting to the Selling Partner API Sandbox, see the [Selling Partner API Sandbox section](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/developer-guide/SellingPartnerApiDeveloperGuide.md#the-selling-partner-api-sandbox).

4. **Integrate with Selling Partner APIs**   
Integrate your application with the Selling Partner endpoints. For more information, see the [Selling Partner API models](https://github.com/amzn/selling-partner-api-models/tree/main/models) and the [Selling Partner API reference guides](https://github.com/amzn/selling-partner-api-docs/tree/main/references).

5. **Publish your Selling Partner Application in the Marketplace Appstore**   
Publish the hybrid version of your application. For more information, see [Seller Central Help](https://sellercentral.amazon.com/sellingpartner/developerconsole/ref=xx_DevCon_dnav_xx).

6. **Migrate MWS authorizations to Selling Partner API**   
Migrate your MWS Seller Authentications to Selling Partner API Authorizations. For more information, see the [Selling Partner API for Authorization JSON model](https://github.com/amzn/selling-partner-api-models/tree/main/models/authorization-api-model) and the [Selling Partner API for Authorization reference guide](https://github.com/amzn/selling-partner-api-docs/tree/main/references/authorization-api).

7. **Migrate your MWS API calls to Selling Partner endpoints**   
Migrate your API calls from MWS to Selling Partner endpoints. 

## Migrating MWS Seller Authorizations to Selling Partner API
The Authorization API lets you migrate an Amazon Marketplace Web Service (Amazon MWS) authorization that a seller has granted you to a hybrid  Selling Partner API application. This eliminates the need to request  authorization from the seller again. For more information, see the [Authorization API Use Case Guide](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/use-case-guides/authorization-api-use-case-guide/authorization-api-use-case-guide-v1.md). For more information, see the [Authorization API reference](https://github.com/amzn/selling-partner-api-docs/tree/main/references/authorization-api) and [Authorization API JSON model](https://github.com/amzn/selling-partner-api-models/tree/main/models/authorization-api-model).

## Roles definitions in Selling Partner APIs
In Amazon MWS, 3 roles were applied across APIs and reports with post-data qualifications. In Selling Partner API, Access will be controlled by 10 roles and all APIs, reports, feeds, and notifications. The principle of Least Privilege is used for access. If you do not request and qualify for a particular role; you will not be able to access the resources grouped under that role. 

| Role                                     | Data Classification                      |  Description   |
|------------------------------------------|------------------------------------------|------------------|
| Product Listing                          | General                                  | Create and manage product listings |
| Pricing                                  | General                                  | Determine list prices and automate product pricing |
| Inventory and Order Management           | General                                  | Analyze and manage inventory |
| Amazon Fulfillment                       | General                                  | Ship to Amazon, and Amazon ships directly to customers (FBA, AFN) |
| Buyer Communications                     | General                                  | Solicit Amazon buyers for feedback |
| Finance and Accounting                   | General                                  | Product accounting and financial statements |
| Selling Partner Insights                 | General                                  | View information about the Amazon Selling Partner account and performance   |
| Direct-to-consumer Shipping (Restricted) | Personally Identifiable Information (PII) | Ship orders directly to customers using carrier of choice, including Amazon |
| Tax Invoicing (Restricted)               | Personally Identifiable Information (PII) | Generate tax invoices to comply with tax regulations |
| Tax Remittance (Restricted)              | Personally Identifiable Information (PII) | Calculate and remit sales taxes |

For more information, see [Roles in the Selling Partner API](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/roles/Roles-in-the-Selling-Partner-API.md).

## Selling Partner API sandbox
Selling Partner API provides a sandbox environment that allows you to test your applications without affecting production data or triggering real-world events. For more information, see the [Selling Partner API Sandbox](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/developer-guide/SellingPartnerApiDeveloperGuide.md#the-selling-partner-api-sandbox).

## Additional Resources
* [GitHub Issues](https://github.com/amzn/selling-partner-api-docs/issues)
* Contact support by opening a [case](https://sellercentral.amazon.com/cu/case-lobby?ref=xx_caseLog_xxxx_helphub&) in Seller Central
* [Selling Partner API Developer Guide](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md)

