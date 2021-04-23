# Amazon MWS to Selling Partner API Migration Guide

### Contents

- [Overview](#overview)
- [What is the Selling Partner API?](#What-is-the-Selling-Partner-API?)
  - [Selling Partner API features](#Selling-Partner-API-features)
  - [Mapping APIs from Amazon MWS to the Selling Partner API](#Mapping-APIs-from-Amazon-MWS-to-the-Selling-Partner-API)
- [Tutorial: Convert an Amazon MWS application into an Selling Partner API application](#Tutorial-Convert-an-Amazon-MWS-application-into-an-Selling-Partner-API-application)
- [Roles in the Selling Partner API](#Roles-in-the-Selling-Partner-API)
- [The Restricted Data Token](#The-Restricted-Data-Token)
- [The Selling Partner API sandbox](#the-selling-partner-api-sandbox)
- [Additional resources](#additional-resources)

# Overview
This document explains what the Selling Partner API is, how it differs from Amazon Marketplace Web Service (Amazon MWS), and shows you how to convert your Amazon MWS application to a Selling Partner API application.

# What is the Selling Partner API?
The Selling Partner API is a REST-based API that helps Amazon selling partners programmatically access their data on listings, orders, payments, reports, and more. The Selling Partner API is a modernization of Amazon MWS and includes all functionality previously available from Amazon MWS. All future development will only be available for the Selling Partner API.

## Selling Partner API features
For every Selling Partner API there is a Swagger model, an API reference, and in some cases a Use Case Guide. Also included are client libraries to help with authenticating calls to Selling Partner APIs.

Some of the new features of the Selling Partner API include:
* REST-based with JSON-formatted input and output. 
* New endpoints that are supported in all regions.
* Step-by-step instructions in the Selling Partner API Developer Guide for automated SDK generation.
* A sandbox feature with separate sandbox endpoints for testing with mock data. 
* A dynamic usage plan that automatically adjusts rate limits for each selling partner based on a variety of measures.
* Selling Partner API applications are applicable across all regions.
* Support for Restricted Data Tokens, which help protect customers' Personally Identifiable Information (PII).

New and updated Selling Partner APIs:
* **A+ Content API.** Enables selling partners to create and edit A+ content.
* **Authorization API.** Exchanges an existing MWS Auth Token with a Selling Partner API authorization code.
* **Catalog Items API.** Provides detailed information about the Amazon catalog.
* **FBA Inbound Eligibility API.**  Checks ASIN eligibility for participation in Fulfillment by Amazon (FBA) to avoid creating inbound shipments for ineligible ASINs.  
* **FBA Inventory API.** New and improved FBA inventory API with new features for FBA sellers.
* **FBA Small and Light API.** Supports the FBA Small and Light program.
* **Messaging API.** Enables selling partners to send supported message types to customers.
* **Notifications API.** Includes new notifications for branded item content changes, product type name changes, MFN order status changes, and B2B offer changes. 
* **Pricing API.** Gets product pricing and offer information.
* **Product Fees API.** Gets estimated fees for a product.
* **Sales API.** Generate sales history reports. 
* **Services API. ** Enables service providers to get and modify their service orders.
* **Shipping API.** Provides programmatic access to Amazon's shipping services.
* **Solicitations API.** Enables selling partners to send non-critical solicitations to customers.
* **Tokens API.** Provides a secure way to access a customer's Personally Identifiable Information (PII).

## Mapping APIs from Amazon MWS to the Selling Partner API

| Amazon MWS                                | Selling Partner API                 |
| ----------------------------------------- | ----------------------------------- |
| Feeds API section                         | Feeds API                           |
| Finances API section                      | Finances API                        |
| Fulfillment Inbound Shipment API section  | Fulfillment Inbound API             |
| Fulfillment Inventory API section         | FBA Inventory API                   |
| Fulfillment Outbound Shipment API section | Fulfillment Outbound API            |
| Merchant Fulfillment API section          | Merchant Fulfillment API            |
| Orders API section                        | Orders API                          |
| Products API section - Product Fees       | Product Fees API                    |
| Products API section - Product Listings   | Catalog Items API                   |
| Products API section - Product Pricing    | Pricing API                         |
| Recommendations API section               | *Deprecated in Selling Partner API* |
| Reports API section                       | Reports API                         |
| Sellers API section                       | Sellers API                         |
| Subscriptions API section                 | Notifications API                   |

# Tutorial: Convert an Amazon MWS application into an Selling Partner API application

This tutorial shows you how to convert an Amazon MWS application into a Selling Partner API application.

**Prerequisites**

- You have registered your Amazon MWS application and published it in the Marketplace Appstore.

**Steps**

[Step 1. Request the data access that your Selling Partner API application requires](#Step-1-Request-the-data-access-that-your-Selling-Partner-API-application-requires)

[Step 2. Create and configure an IAM ARN](#Step-2-Create-and-configure-an-IAM-ARN)

[Step 3. Convert your Amazon MWS application into a hybrid Selling Partner API application](#Step-3-Convert-your-Amazon-MWS-application-into-a-hybrid-Selling-Partner-API-application)

[Step 4. Implement an authorization workflow](#Step-4-Implement-an-authorization-workflow)

[Step 5. Connect to the Selling Partner API](#Step-5-Connect-to-the-Selling-Partner-API)

[Step 6. Publish your hybrid Selling Partner application in the Marketplace Appstore](#Step-6-Publish-your-hybrid-Selling-Partner-application-in-the-Marketplace-Appstore)

[Step 7. Migrate Amazon MWS authorizations to Selling Partner API authorizations](#Step-7-Migrate-Amazon-MWS-authorizations-to-Selling-Partner-API-authorizations)

[Step 8. Migrate your Amazon MWS calls to Selling Partner API calls](#Step-8-Migrate-your-Amazon-MWS-calls-to-Selling-Partner-API-calls)

## Step 1. Request the data access that your Selling Partner API application requires

1. Sign into Seller Central with the credentials associated with your Amazon MWS developer account.

1. In the **Apps & Services** menu, click **Develop Apps**.

   The **Developer Central** page appears.
   
1. On the **Developer Central** page, click the **Your Developer Profile** link.

   The **Developer Profile page** appears.

1. In the **Data Access** section of the form, select the roles that your applications require and submit the form.

We will open a Contact Us ticket for you to track this request. We will contact you after we have evaluated your request; this could take several days.

## Step 2. Create and configure an IAM ARN
Follow the steps in [Creating and configuring IAM policies and entities](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md#Creating-and-configuring-IAM-policies-and-entities) in the Selling Partner API Developer Guide to create and configure an IAM ARN for use in the following step.

## Step 3. Convert your Amazon MWS application into a hybrid Selling Partner API application

1. Sign into Seller Central using the credentials that you used to register as a developer.

1. In the **Apps & Services** menu, click **Develop Apps**.

   The **Developer Central** page appears.

1. Next to your Amazon MWS application, on the **Edit App** menu, click **Edit App**.

1. Follow the instructions to register your application. In the **IAM ARN** box, use the IAM ARN from [Step 2. Create and configure an IAM ARN](#Step-2-Create-and-configure-an-IAM-ARN).

When you complete the form you will have a hybrid Selling Partner API application in Draft status. You are now ready to set up and test an authorization workflow in the following step.

## Step 4. Implement an authorization workflow

Set up and test an authorization workflow for your hybrid Selling Partner API application. For more information, see [Authorizing Selling Partner API applications](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md#authorizing-selling-partner-api-applications) in the Selling Partner API Developer Guide. When you have finished testing your authorization workflow, be sure to convert your test authorization workflow to a production authorization workflow.

## Step 5. Connect to the Selling Partner API

Set up a workflow for calling operations in the Selling Partner API. This includes exchanging LWA tokens, constructing URIs, adding headers, and creating and signing requests. The easiest way to do this is to generate and use an SDK that includes LWA token exchange and authentication. For more information, see [Generating a Java SDK with LWA token exchange and authentication](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md#generating-a-java-sdk-with-lwa-token-exchange-and-authentication) and [Connecting to the Selling Partner API using a generated Java SDK](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md#connecting-to-the-selling-partner-api-using-a-generated-java-sdk) in the Selling Partner API Developer Guide.

For information about connecting to the Selling Partner API sandbox, see [The Selling Partner API sandbox](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md#the-selling-partner-api-sandbox) in the Selling Partner API Developer Guide.

## Step 6. Publish your hybrid Selling Partner application in the Marketplace Appstore

1. Sign into Seller Central using the credentials that you used to register as a developer.

1. In the **Apps & Services** menu, click **Develop Apps**.

   The **Developer Central** page appears.

1. Next to your application, in the **Edit App** menu, click the arrow and then click **Edit Listing**.

1. Proceed through the workflow.

After completing the final screen, your hybrid Selling Partner application will be published to the Marketplace Appstore. This process can take 5 to 10 business days.

## Step 7. Migrate Amazon MWS authorizations to Selling Partner API authorizations

Migrate your existing Amazon MWS authorizations to Selling Partner API authorizations. For more information, see the [Authorization API Use Case Guide](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/use-case-guides/authorization-api-use-case-guide/authorization-api-use-case-guide-v1.md).

## Step 8. Migrate your Amazon MWS calls to Selling Partner API calls

The final step is to update your application so that actions that previously triggered calls to Amazon MWS operations now trigger calls the corresponding Selling Partner API operations. See [Mapping APIs from Amazon MWS to the Selling Partner API](#Mapping-APIs-from-Amazon-MWS-to-the-Selling-Partner-API) to see which Selling Partner API operations correspond to the Amazon MWS operations that your application has been calling.

# Roles in the Selling Partner API

A role is the mechanism used by the Selling Partner API to determine whether a developer or application has access to an operation or resource. As a developer, you must request and qualify for a particular role, or you will not be able to access the operations and resources grouped under that role.

The roles in the Selling Partner API are more fine grained than the roles in Amazon MWS. Where Amazon MWS had three roles, the Selling Partner API has 11. See [Roles in the Selling Partner API](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/roles/Roles-in-the-Selling-Partner-API.md) for a detailed explanation of roles in the Selling Partner API, as well as a list of roles and their definitions.

# The Restricted Data Token

The Selling Partner API protects customers' Personally Identifiable Information (PII) by requiring a Restricted Data Token (RDT) with calls to restricted operations (operations that return restricted data). For information about getting and using RDTs to call restricted operations, see the [Tokens API Use Case Guide](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/use-case-guides/tokens-api-use-case-guide/tokens-API-use-case-guide-2021-03-01.md) 

# The Selling Partner API sandbox
Selling Partner API provides a sandbox environment that allows you to test your applications without affecting production data or triggering real-world events. For more information, see [Selling Partner API Sandbox](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md#the-selling-partner-api-sandbox) in the Selling Partner API Developer Guide.

# Additional resources
* [GitHub Issues](https://github.com/amzn/selling-partner-api-docs/issues)
* Contact support by opening a [case](https://sellercentral.amazon.com/cu/case-lobby?ref=xx_caseLog_xxxx_helphub&) in Seller Central
* [Selling Partner API Developer Guide](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md)
