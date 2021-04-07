# Amazon MWS to Selling Partner API Migration Guide

### Contents

- [Overview](#overview)
- [What is the Selling Partner API?](#What-is-the-Selling-Partner-API?)
- [Differences between Amazon MWS and the Selling Partner API](#Differences-between-Amazon-MWS-and-the-Selling-Partner-API)
   - [Mapping APIs from Amazon MWS to the Selling Partner API](#Mapping-APIs-from-Amazon-MWS-to-the-Selling-Partner-API)
- [The migration process](#the-migration-process)
- [Migrating Amazon MWS selling partner authorizations to the Selling Partner API](#Migrating-Amazon-MWS-selling-partner-authorizations-to-the-Selling-Partner-API)
- [Roles in the Selling Partner API](#Roles-in-the-Selling-Partner-API)
- [The Selling Partner API sandbox](#the-selling-partner-api-sandbox)
- [Additional resources](#additional-resources)

# Overview
This document provides a set of guidelines to migrate from Amazon Marketplace Web Service (Amazon MWS) to the Selling Partner API. If your application currently uses Amazon MWS, you can migrate to Selling Partner operations that are built on the functionality of Amazon MWS operations, providing features to improve usability and security for developers and selling partners.

# What is the Selling Partner API?
The Selling Partner API is a REST-based API that helps Amazon selling partners programmatically access their data on listings, orders, payments, reports, and more. Applications using Amazon MWS can now adopt the Selling Partner API to increase selling efficiency, reduce labor requirements, improve response time to customers, and help selling partners grow their businesses. 

# Differences between Amazon MWS and the Selling Partner API
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
* **Messaging API.** Enables selling partners to send supported messages types to customers.
* **Solicitations API.** Enables selling partners to send non-critical solicitations to customers.
* **Sales API.** Enables selling partners to generate Sales history reports. 
* **FBA Small and Light API.** Supports the FBA small and light program.
* **FBA Inbound Eligibility API.**  Compliments the Fulfillment by Amazon (FBA) inbound workflow by enabling selling partners to check ASIN eligibility for participation in FBA before creating inbound shipments.  
* **FBA Inventory API.** New and improved FBA inventory API with new feature for FBA sellers.
* **Notifications API.** Get new ASIN change notifications. Enables developers to receive information about changes to ASIN detail page content. 

## Mapping APIs from Amazon MWS to the Selling Partner API

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

# The migration process

These steps describe how to migrate from Amazon MWS to the Selling Partner API:

1. **Convert your Amazon MWS application into a hybrid Selling Partner API application**  
Convert your current Amazon MWS application into a hybrid Selling Partner API application. For more information, see [Hybrid Selling Partner API applications](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md#hybrid-selling-partner-api-applications) in the Selling Partner API Developer Guide.
   
2. **Authorize a Selling Partner API application**  
Implement the Authorization model for Selling Partner APIs (OAuth 2.0). For more information, see [Authorizing Selling Partner API applications](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md#authorizing-selling-partner-api-applications) in the Selling Partner API Developer Guide.
  
3. **Connect to Selling Partner APIs**
Connecting to APIs using Selling Partner API endpoints. For more information, see [Connecting to the Selling Partner API](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md#connecting-to-the-selling-partner-api) in the Selling Partner API Developer Guide. For information about connecting to the Selling Partner API sandbox, see [The Selling Partner API sandbox](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md#the-selling-partner-api-sandbox).

4. **Integrate with Selling Partner APIs**
Integrate your application with the Selling Partner endpoints. For more information, see and the Selling Partner API [models](https://github.com/amzn/selling-partner-api-models/tree/main/models) and [API references](https://github.com/amzn/selling-partner-api-docs/tree/main/references).

5. **Publish your Selling Partner API Application in the Marketplace Appstore**   
Publish the hybrid version of your application. For more information, go to [Developer Central](https://sellercentral.amazon.com/sellingpartner/developerconsole/ref=xx_DevCon_dnav_xx).

6. **Migrate Amazon MWS authorizations to Selling Partner API**   
Migrate your Amazon MWS authorizations to Selling Partner API authorizations. For more information, see the [Authorization API Use Case Guide](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/use-case-guides/authorization-api-use-case-guide/authorization-api-use-case-guide-v1.md).

7. **Migrate your Amazon MWS calls to Selling Partner endpoints**   
Migrate your API calls from Amazon MWS to Selling Partner API endpoints. 

# Migrating Amazon MWS selling partner authorizations to the Selling Partner API
The Authorization API lets you migrate an Amazon Marketplace Web Service (Amazon MWS) authorization that a seller has granted you to a hybrid  Selling Partner API application. This eliminates the need to request  authorization from the seller again. For more information, see the [Authorization API Use Case Guide](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/use-case-guides/authorization-api-use-case-guide/authorization-api-use-case-guide-v1.md). For more information, see the [Authorization API reference](https://github.com/amzn/selling-partner-api-docs/tree/main/references/authorization-api) and [Authorization API JSON model](https://github.com/amzn/selling-partner-api-models/tree/main/models/authorization-api-model).

# Roles in the Selling Partner API

A role is the mechanism used by the Selling Partner API (SP-API) to determine whether a developer or application has access to an operation or resource. As a developer, you must request and qualify for a particular role, or you will not be able to access the operations and resources grouped under that role.

The roles in SP-API are more fine grained than the roles in Amazon MWS. Where Amazon MWS had three roles, SP-API has 11. See [Roles in the Selling Partner API](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/roles/Roles-in-the-Selling-Partner-API.md) for a detailed explanation of roles in SP-API, as well as a list of roles and their definitions.

# The selling Partner API sandbox
Selling Partner API provides a sandbox environment that allows you to test your applications without affecting production data or triggering real-world events. For more information, see the [Selling Partner API Sandbox](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md#the-selling-partner-api-sandbox).

# Additional resources
* [GitHub Issues](https://github.com/amzn/selling-partner-api-docs/issues)
* Contact support by opening a [case](https://sellercentral.amazon.com/cu/case-lobby?ref=xx_caseLog_xxxx_helphub&) in Seller Central
* [Selling Partner API Developer Guide](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md)
