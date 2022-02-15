# Amazon MWS to Selling Partner API Migration Guide

### Contents

- [Overview](#overview)
- [What is the Selling Partner API?](#what-is-the-selling-partner-api)
  - [Selling Partner API features](#selling-partner-api-features)
  - [Mapping APIs from Amazon MWS to the Selling Partner API](#mapping-apis-from-amazon-mws-to-the-selling-partner-api)
- [Migration workflow overview](#migration-workflow-overview)
- [Tutorial: Convert an Amazon MWS application into an Selling Partner API application](#tutorial-convert-an-amazon-mws-application-into-an-selling-partner-api-application)
- [Roles in the Selling Partner API](#roles-in-the-selling-partner-api)
- [Restricted Data Token requirement](#restricted-data-token-requirement)
- [Selling Partner API sandbox](#selling-partner-api-sandbox)
- [Additional resources](#additional-resources)

# Overview
This document explains what the Selling Partner API is, how it differs from Amazon Marketplace Web Service (Amazon MWS), and shows you how to convert your Amazon MWS application to a hybrid Selling Partner API application.

# What is the Selling Partner API?
The Selling Partner API is a REST-based API that helps Amazon selling partners programmatically access their data on listings, orders, payments, reports, and more. Applications using the Selling Partner API can increase selling  efficiency, reduce labor requirements, and improve response time to  customers, helping selling partners grow their businesses. The Selling Partner API is a modernization of Amazon MWS and includes all functionality previously available from Amazon MWS. All future development will only be available for the Selling Partner API.

## Selling Partner API features
For every Selling Partner API there is a Swagger model, an API reference, and in some cases a use case guide. Client libraries are also included to help with authenticating calls to Selling Partner APIs.

Some of the new features of the Selling Partner API include:
* REST-based APIs with JSON-formatted input and output. 
* New endpoints that are supported in all regions.
* Step-by-step instructions for automated SDK generation (see the [Selling Partner API Developer Guide](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md)).
* A sandbox feature with separate sandbox endpoints for testing with mock data. 
* A dynamic usage plan that automatically adjusts rate limits for each selling partner based on a variety of measures.
* Support for Selling Partner API applications across all regions.
* Support for Restricted Data Tokens (RDTs), which help protect customers' Personally Identifiable Information (PII).

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

* **Services API.** Enables service providers to get and modify their service orders.

* **Shipping API.** Provides programmatic access to Amazon's shipping services.

* **Solicitations API.** Enables selling partners to send non-critical solicitations to customers.

* **Tokens API.** Provides a secure way to access a customer's Personally Identifiable Information (PII).

  

## Mapping APIs from Amazon MWS to the Selling Partner API

| Amazon MWS                                | Selling Partner API                 |
| ----------------------------------------- | ----------------------------------- |
| [Feeds API section](https://docs.developer.amazonservices.com/en_US/feeds/Feeds_Overview.html)                                      | [Feeds API](https://github.com/amzn/selling-partner-api-docs/tree/main/references/feeds-api)  |
| [Finances API section](https://docs.developer.amazonservices.com/en_US/finances/Finances_Overview.html)                             | [Finances API](https://github.com/amzn/selling-partner-api-docs/tree/main/references/finances-api)  |
| [Fulfillment Inbound Shipment API section](https://docs.developer.amazonservices.com/en_US/fba_inbound/FBAInbound_Overview.html)    | [Fulfillment Inbound API](https://github.com/amzn/selling-partner-api-docs/tree/main/references/fulfillment-inbound-api)   |
| [Fulfillment Inventory API section](https://docs.developer.amazonservices.com/en_US/fba_inventory/FBAInventory_Overview.html)       | [FBA Inventory API](https://github.com/amzn/selling-partner-api-docs/tree/main/references/fba-inventory-api)               |
| [Fulfillment Outbound Shipment API section](https://docs.developer.amazonservices.com/en_US/fba_outbound/FBAOutbound_Overview.html) | [Fulfillment Outbound API](https://github.com/amzn/selling-partner-api-docs/tree/main/references/fulfillment-outbound-api) |
| [Merchant Fulfillment API section](https://docs.developer.amazonservices.com/en_US/merch_fulfill/MerchFulfill_Overview.html)        | [Merchant Fulfillment API](https://github.com/amzn/selling-partner-api-docs/tree/main/references/merchant-fulfillment-api) |
| [Orders API section](https://docs.developer.amazonservices.com/en_US/orders-2013-09-01/Orders_Overview.html)                        | [Orders API](https://github.com/amzn/selling-partner-api-docs/tree/main/references/orders-api) |                         
| [Products API section](https://docs.developer.amazonservices.com/en_US/products/Products_Overview.html) - Product Fees            | [Product Fees API](https://github.com/amzn/selling-partner-api-docs/tree/main/references/product-fees-api)                 |
| [Products API section](https://docs.developer.amazonservices.com/en_US/products/Products_Overview.html) - Product Listings          | [Catalog Items API](https://github.com/amzn/selling-partner-api-docs/tree/main/references/catalog-items-api)               |
| [Products API section](https://docs.developer.amazonservices.com/en_US/products/Products_Overview.html) - Product Pricing           | [Pricing API](https://github.com/amzn/selling-partner-api-docs/tree/main/references/product-pricing-api)                   |
| [Recommendations API section](https://docs.developer.amazonservices.com/en_US/recommendations/Recommendations_Overview.html)        | *Deprecated in Selling Partner API*                                                                                        |
| [Reports API section](https://docs.developer.amazonservices.com/en_US/reports/Reports_Overview.html)                                | [Reports API](https://github.com/amzn/selling-partner-api-docs/tree/main/references/reports-api)                           |
| [Sellers API section](https://docs.developer.amazonservices.com/en_US/sellers/Sellers_Overview.html)                                | [Sellers API](https://github.com/amzn/selling-partner-api-docs/tree/main/references/sellers-api)                           |
| [Subscriptions API section](https://docs.developer.amazonservices.com/en_US/subscriptions/Subscriptions_Overview.html)              | [Notifications API](https://github.com/amzn/selling-partner-api-docs/tree/main/references/notifications-api)                   |

# Migration workflow overview

The migration workflow converts an Amazon MWS application into a hybrid Selling Partner API application. A hybrid application can make API calls to both Amazon MWS and SP-API. With a hybrid application, you have functionality from both services and zero application downtime during the migration process. 

The following diagram provides an overview of the migration workflow.

<img src="./media/amazon-mws-to-spapi-migration-workflow.png" alt="image showing overview of Amazon MWS to SP-API Migration workflow" />

# Tutorial: Convert an Amazon MWS application into an Selling Partner API application

This tutorial shows you how to convert an Amazon MWS application into a hybrid Selling Partner API application. 

**Prerequisites**

- A registered Amazon MWS application that is published in the Marketplace Appstore.
- An Amazon Web Services (AWS) account. To create an account, [sign up for AWS](https://portal.aws.amazon.com/billing/signup#/start).

**Steps**

[Step 1. Request the data access that your Selling Partner API application requires](#Step-1-Request-the-data-access-that-your-Selling-Partner-API-application-requires)

[Step 2. Create and configure IAM resources](#Step-2-Create-and-configure-IAM-resources)

[Step 3. Convert your Amazon MWS application into a hybrid Selling Partner API application](#Step-3-Convert-your-Amazon-MWS-application-into-a-hybrid-Selling-Partner-API-application)

[Step 4. Implement an authorization workflow](#Step-4-Implement-an-authorization-workflow)

[Step 5. Connect to the Selling Partner API](#Step-5-Connect-to-the-Selling-Partner-API)

[Step 6. Publish your hybrid Selling Partner application in the Marketplace Appstore](#Step-6-Publish-your-hybrid-Selling-Partner-application-in-the-Marketplace-Appstore)

[Step 7. Migrate Amazon MWS authorizations to Selling Partner API authorizations](#Step-7-Migrate-Amazon-MWS-authorizations-to-Selling-Partner-API-authorizations)

[Step 8. Migrate your Amazon MWS calls to Selling Partner API calls](#Step-8-Migrate-your-Amazon-MWS-calls-to-Selling-Partner-API-calls)

## Step 1. Request the data access that your Selling Partner API application requires

1. Sign into [Seller Central](sellercentral.amazon.com) with the credentials associated with your Amazon MWS developer account.
1. On the **Partner Network** menu, click **Develop Apps**.
1. On the **Developer Central** page, click **Your Developer Profile**.
1. On the **Developer Profile** page, in the **Data Access** section, select the roles that your applications require and submit the form. For more information on choosing or requesting roles, see [Roles in the Selling Partner API](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/roles/Roles-in-the-Selling-Partner-API.md).
1. Click **Register**.

The Developer Support team will evaluate your request and reply to your support case once their review is completed. This process may take several days depending on your profile responses. 

**Note:** You cannot change your Developer Profile while it is under review. However, you can monitor your registration status by visting **Developer Central** and viewing the instructions on the **Your developer registration is under review** banner. 

## Step 2. Create and configure IAM resources
Some [AWS Identity and Access Management (IAM)](https://docs.aws.amazon.com/IAM/latest/UserGuide/introduction.html) resources are required for you to convert your Amazon MWS application into a Selling Partner API application, including an IAM user, IAM policy, and an [IAM role](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles.html). When you create your IAM role, you also generate an Amazon Resource Name (ARN), which is a unique identifier for your IAM role. Make sure to take note of the IAM role ARN when you create and configure your IAM resources - you need this IAM role ARN when you convert your Amazon MWS application into a hybrid Selling Partner API application in [Step 3](#Step-3-Convert-your-Amazon-MWS-application-into-a-hybrid-Selling-Partner-API-application). 

You can create and configure your IAM resources in two ways:

* To programmatically create and configure the IAM resources, see the [Selling Partner API on AWS Quick Start](https://aws.amazon.com/quickstart/architecture/amazon-selling-partner-api/). The Selling Partner API on AWS Quick Start includes an AWS CloudFormation template that you deploy in your AWS account to programmatically create all of the required IAM policies and roles. 

* To manually create and configure the IAM resources, see [Creating and configuring IAM policies and entities](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md#Creating-and-configuring-IAM-policies-and-entities) in the Selling Partner API Developer Guide. 

## Step 3. Convert your Amazon MWS application into a hybrid Selling Partner API application

1. Sign into [Seller Central](https://sellercentral.amazon.com/) using the credentials that you used to register as a developer.
1. In the **Partner Network** menu, click **Develop Apps**.
1. On the **Developer Central** page, next to your Amazon MWS application, click **Edit App**.
1. On the **App registration** form, for **API Type**, choose **SP-API and MWS**. This selection populates the form with your app details. 
1. In the **IAM ARN** box, paste the ARN for the IAM role that you created in [Step 2. Create and configure an IAM role](#Step-2-Create-and-configure-an-IAM-role). If you are unsure of this value, you can find the ARN depending on how you created the IAM role:
   * If you created your IAM resources programmatically using the Selling Partner API on AWS Quick Start Deployment Guide, paste the ARN that you copied in [Post-deployment steps - Copy the IAM role ARN](https://aws-quickstart.github.io/quickstart-amazon-selling-partner-api/#_copy_the_iam_role_arn).
   * If you created your IAM resources manually using the steps in the Selling Partner API Developer Guide, paste the ARN for the IAM role that you copied in [Step 4. Create an IAM role](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md#step-4-create-an-iam-role). This IAM role should also have the AWS Security Token Service (AWS STS) policy attached. 
   * To view the ARN in the AWS Management Console, sign into the [IAM Dashboard](https://console.aws.amazon.com/iam/) and in the left navigation pane, choose **Roles**. Search for and select the SP-API role that you created. On the **Summary** page, copy the **Role ARN**.
1. In the **Roles** section, select all roles required by your application. For more information on choosing or requesting roles, see [Roles in the Selling Partner API](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/roles/Roles-in-the-Selling-Partner-API.md).
1. Click **Save and Exit** to complete the registration. 


After you submit the registration, you will have a hybrid Selling Partner API application in Draft status. You are now ready to set up and test an authorization workflow.

## Step 4. Implement an authorization workflow

Set up and test an authorization workflow for your hybrid Selling Partner API application. For more information, see [Authorizing Selling Partner API applications](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md#authorizing-selling-partner-api-applications) in the Selling Partner API Developer Guide. When you have finished testing your authorization workflow, be sure to convert your test authorization workflow to a production authorization workflow.

## Step 5. Connect to the Selling Partner API

Set up a workflow for calling operations in the Selling Partner API. This workflow includes exchanging Login with Amazon (LWA) tokens, constructing URIs, adding headers, and creating and signing requests. To set up this workflow, you can generate and use an SDK that includes LWA token exchange and authentication. For more information, see [Generating a Java SDK with LWA token exchange and authentication](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md#generating-a-java-sdk-with-lwa-token-exchange-and-authentication) and [Connecting to the Selling Partner API using a generated Java SDK](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md#connecting-to-the-selling-partner-api-using-a-generated-java-sdk) in the Selling Partner API Developer Guide.

For information about connecting to the Selling Partner API sandbox, see [Selling Partner API sandbox](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md#the-selling-partner-api-sandbox) in the Selling Partner API Developer Guide.

## Step 6. Publish your hybrid Selling Partner application in the Marketplace Appstore

1. Sign into [Seller Central](https://sellercentral.amazon.com/) using the credentials that you used to register as a developer.
1. On the **Partner Network** menu, click **Develop Apps**.
1. On the **Developer Central** page, locate your application. Click the **Edit App** drop-down and then click **Edit Listing**.
1. On the **App registration** form, for **API Type**, choose **SP-API and MWS**. This selection populates the form with your app details. 
1. Complete the remaining fields and submit the form. 

After completing the final screen, your hybrid Selling Partner application will be published to the Marketplace Appstore. This process can take 5 to 10 business days.

## Step 7. Migrate Amazon MWS authorizations to Selling Partner API authorizations

**Note:** Confirm that your Selling Partner API application is published in the Marketplace Appstore prior to migrating your existing Amazon MWS authorizations to Selling Partner API authorizations.

Migrate your existing Amazon MWS authorizations to Selling Partner API authorizations. For more information, see the [Authorization API Use Case Guide](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/use-case-guides/authorization-api-use-case-guide/authorization-api-use-case-guide-v1.md).

## Step 8. Migrate your Amazon MWS calls to Selling Partner API calls

The final step is to update your application so that actions that previously triggered calls to Amazon MWS operations now trigger calls the corresponding Selling Partner API operations. See [Mapping APIs from Amazon MWS to the Selling Partner API](#Mapping-APIs-from-Amazon-MWS-to-the-Selling-Partner-API) to see which Selling Partner API operations correspond to the Amazon MWS operations that your application has been calling.

# Roles in the Selling Partner API

A role is the mechanism used by the Selling Partner API to determine whether a developer or application has access to an operation or resource. As a developer, you must request and qualify for a particular role, or you will not be able to access the operations and resources grouped under that role.

The roles in the Selling Partner API are more fine grained than the roles in Amazon MWS. Whereas Amazon MWS had three roles, the Selling Partner API has 11. See [Roles in the Selling Partner API](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/roles/Roles-in-the-Selling-Partner-API.md) for a detailed explanation of roles in the Selling Partner API, as well as a list of roles and their definitions.

# Restricted Data Token (RDT) requirement

The Selling Partner API protects customers' Personally Identifiable Information (PII) by requiring a Restricted Data Token (RDT) with calls to restricted operations (operations that return restricted data). For information about getting and using RDTs to call restricted operations, see the [Tokens API Use Case Guide](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/use-case-guides/tokens-api-use-case-guide/tokens-API-use-case-guide-2021-03-01.md) 

# Selling Partner API sandbox
Selling Partner API provides a sandbox environment that allows you to test your applications without affecting production data or triggering real-world events. For more information, see [Selling Partner API Sandbox](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md#the-selling-partner-api-sandbox) in the Selling Partner API Developer Guide.

# Additional resources
* [SP-API Migration FAQs](https://github.com/amzn/selling-partner-api-docs/wiki/SP-API-Migration-FAQs)
* [Selling Partner API Developer Guide](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md)
* [Selling Partner API (SP-API) Video Series on YouTube](https://www.youtube.com/playlist?list=PLyrrqKCT7jFKENJO9n_Y68-5o2GZLgLUU)
* Contact [Amazon Selling Partner Developer Support](https://sellercentral.amazon.com/gp/mws/contactus.html) in Seller Central

