# Roles in the Selling Partner API

# Overview

## What is a role?

A role is the mechanism used by Selling Partner APIs to determine whether a developer or application has access to an operation or resource. As a developer, you must request and qualify for a particular role, or you will not be able to access the operations and resources grouped under that role. Roles protect access to personally identifiable information (PII) and other sensitive data, and limit data access to ensure developers only access data that is required for an application. This helps ensure that customers trust Amazon and trust Selling Partner Services businesses that employ the Selling Partner APIs.

# Role Definitions

In the following table, *Restricted* means the role requires sensitive information which may include personally identifiable information (PII). You will be required to provide additional information about your use of the data and your security controls.

The example operations provided in each role description are examples only and not meant to be a definitive or comprehensive list.

<table>
<thead>
<tr class="header">
<th><strong>Role</strong></th>
<th><strong>Description</strong></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td><strong>Product Listing</strong></td>
<td>Create and manage product listings.
Generally used for product catalog related reports and feeds, and operations.
Examples of operations that require this role assignment:
<ul>
<li>The <strong>getCatalogItem</strong> operation of the Selling Partner API for Catalog Items, which returns information about the item indicated and its attributes.</li>
<li>The <strong>createReport</strong> operation of the Selling Partner API for Reports, when used to request the <strong>GET_MERCHANT_LISTINGS_INACTIVE_DATA</strong> report. This report returns detailed inactive listings.</li>
<li>The <strong>getMyFeesEstimateForSKU</strong> operation of the Selling Partner API for Product Fees, which returns the estimated fees for the item indicated.</li>
</ul></td>
</tr>
<tr class="even">
<td><strong>Pricing</strong></td>
<td>Determine list prices and automate product pricing.
Generally used for pricing related reports, feeds and operations.
Examples of operations that require this role assignment:
<ul>
<li>The <strong>createFeed</strong> operation of the Selling Partner API for Feeds when used to submit a <strong>RFQ_UPLOAD_FEED</strong> feed. This lets you upload quantity discounts in response to requests from business customers.</li>
<li>The <strong>getPricing</strong> operation of the Selling Partner API for Pricing, which returns pricing information for a seller's offer listings.</li>
<li>The <strong>createReport</strong> operation of the Selling Partner API for Reports, when used to request the <strong>GET_MERCHANT_CANCELLED_LISTINGS_DATA</strong> report. This report returns cancelled listings.</li>
</ul></td>
</tr>
<tr class="odd">
<td><strong>Inventory and Order Management</strong></td>
<td>Analyze and manage inventory.
Generally used for FBA Sales Reports, Order Tracking Reports, and operations related to orders, vendor orders, sales order metrics and inventory management. Operations that require this role do not use PII required to ship an order. Rather, this role is required for applications that track order shipments to manage inventory/manufacturing/purchasing.
Examples of operations that require this role assignment:
<ul>
<li>The <strong>createReport</strong> operation of the Selling Partner API for Reports, when used to request the <strong>GET_MERCHANT_LISTINGS_DATA</strong> report. This report returns detailed active listings.</li>
<li>The <strong>createFeed</strong> operation of the Selling Partner API for Feeds when used to submit a <strong>POST_FLAT_FILE_FULFILLMENT_DATA</strong> feed. This lets you submit order fulfillment information to Amazon.</li>
<li>The <strong>getOrderMetrics</strong> operation of the Selling Partners API for Sales, which returns aggregated order metrics.</li>
</ul></td>
</tr>
<tr class="even">
<td><strong>Amazon Fulfillment</strong></td>
<td>Ship to Amazon, and Amazon ships directly to customers (Fulfillment by Amazon (FBA), Amazon Fulfillment Network (AFN)).
Generally used for FBA Sales Reports, Order Tracking Reports, and operations related to order fulfillment.
Examples of operations that require this role assignment:
<ul>
<li>The <strong>createReport</strong> operation of the Selling Partner API for Reports, when used to request the <strong>GET_FBA_ESTIMATED_FBA_FEES_TXT_DATA</strong> report. This report contains estimated Amazon Selling and Fulfillment Fees.</li>
<li>The <strong>getSubscription</strong> operation of the Selling Partner API for Notifications when used to subscribe to <strong>FBA_OUTBOUND_SHIPMENT_STATUS</strong> notifications. These notifications are sent whenever we create or cancel a FBA shipment for a seller.</li>
<li>The <strong>getLabels</strong> operation of the Selling Partner API for Fulfillment Inbound, which returns package/pallet labels.</li>
<li>The <strong>createFeed</strong> operation of the Selling Partner API for Feeds when used to submit a <strong>POST_FBA_INBOUND_CARTON_CONTENTS</strong> feed. This lets you submit carton content information when shipping inventory to Amazon’s fulfillment network.</li>
</ul></td>
</tr>
<tr class="odd">
<td><strong>Buyer Communication</strong></td>
<td>Manage messaging to and from Amazon buyers.
Generally used for messaging to Amazon buyers using the Selling Partner API for Messaging.
Examples of operations that require this role assignment:
<ul>
<li>The <strong>getMessagingActionsForOrder</strong> operation of the Selling Partner API for Messaging, which returns a list of message types available for a specified order.</li>
<li>The <strong>createConfirmOrderDetails</strong> operation of the Selling Partner API for Messaging, which sends a message to ask a buyer an order-related question prior to shipping.</li>
<li>The <strong>createConfirmDeliveryDetails</strong> operation of the Selling Partner API for Messaging, which sends a message to a buyer to arrange a deliver or confirm contact information for making a delivery.</li>
</ul></td>
</tr>
<tr class="even">
<td><strong>Buyer Solicitation</strong></td>
<td>Solicit Amazon buyers for feedback.
Generally used to solicit Amazon buyers for feedback using the Selling Partner API for Solicitations.
Examples of operations that require this role assignment:
<ul>
<li>The <strong>getSolicitationActionsForOrder</strong> operation of the Selling Partner API for Solicitations, which returns a list of solicitation types available for an order.</li>
<li>The <strong>createProductReviewAndSellerFeedbackSolicitation</strong> operation, which sends a solicitation to a buyer asking for feedback and a product review for an order.</li>
</ul></td>
</tr>
<tr class="odd">
<td><strong>Finance and Accounting</strong></td>
<td>Produce accounting and financial statements.
Generally used for creating accounting and financial statements.
Examples of operations that require this role assignment:
<ul>
<li>The <strong>getReports</strong> operation of the Selling Partner API for Reports, when used to return a list of the <strong>GET_V2_SETTLEMENT_REPORT_DATA_FLAT_FILE</strong> reports created.</li>
<li>The <strong>getSubscription</strong> operation of the Selling Partner API for Notifications, when used to return information about subscriptions to the <strong>FEE_PROMOTION</strong> notification type. </li>
</ul></td>
</tr>
<tr class="even">
<td><strong>Selling Partner Insights</strong></td>
<td>View information about the Amazon Selling Partner account and performance.
Generally used for reports and operations used to return seller insights.
Examples of operations that require this role assignment:
<ul>
<li>The <strong>createReport</strong> operation of the Selling Partner API for Reports, when used to request the <strong>GET_V1_SELLER_PERFORMANCE_REPORT</strong> report. This report contains individual performance metrics from the Seller Central dashboard.</li>
<li>The <strong>getMarketplaceParticipations</strong> operation of the Selling Partner API for Sellers, which returns a list of marketplaces that a seller can sell in, and information about the seller’s participation in those marketplaces.</li>
</ul></td>
</tr>
<tr class="odd">
<td><strong>Direct-to-Consumer Shipping</strong> (<em>Restricted</em>)</td>
<td>Ship orders directly to customers using their carrier of choice, including Amazon. Operations that require this role use PII to enable shipping.
Generally used for Order Reports, Order Tracking Reports, EasyShip, and for operations related to shipping orders placed on Amazon.
Example operations that require this role assignment:
<ul>
<li>The <strong>getShipment</strong> operation of the Selling Partner API for Merchant Fulfillment, which returns shipment information for a specified shipment.</li>
<li>The <strong>getOrders</strong> operation of the Selling Partner API for Orders, which returns a list of orders and order information based on the criteria specified.</li>
<li>The <strong>createReport</strong> operation of the Selling Partner API for Reports, when used to request the <strong>GET_FLAT_FILE_ ORDER_REPORT_DATA_SHIPPING</strong> report.</li>
<li>The <strong>createFeed</strong> operation of the Selling Partner API for Feeds, when used to submit a <strong>POST_ORDER_FULFILLMENT_DATA</strong> feed. This feed allows your system to update Amazon's system with order fulfillment information.</li>
</ul></td>
</tr>
<tr class="even">
<td><strong>Tax Invoicing</strong> (<em>Restricted</em>)</td>
<td>Generate tax invoices to comply with tax regulation. Operations that require this role require PII to enable tax invoice generation.
Generally used for Tax Reports and Order Reports, and operations that return information about orders.
Examples of operations that require this role assignment:
<ul>
<li>The <strong>createReport</strong> operation of the Selling Partner API for Reports, when used to request the <strong>GET_AMAZON_FULFILLED_SHIPMENTS_INVOICING</strong> report. This report returns detailed order/shipment/item information.</li>
<li>The <strong>getOrderAddress</strong> operation of the Selling Partner API for Orders, which returns the shipping address for an order.</li>
<li>The <strong>getOrderBuyerInfo</strong> operation of the Selling Partner API for Orders, which returns buyer information for an order.</li>
<li>The <strong>createReport</strong> operation of the Selling Partner API for Reports, when used to request the <strong>GET_EASYSHIP_DOCUMENTS</strong> report. This report contains the invoice, shipping label and warranty documents for an Easy Ship order.</li>
</ul></td>
</tr>
<tr class="odd">
<td><strong>Tax Remittance</strong> (<em>Restricted</em>)</td>
<td>Calculate and remit sales taxes. Operations that require this role may use PII to calculate sales taxes.
Generally used for FBA Sales Reports and Order Reports and operations that return information about orders.
Examples of operations that require this role assignment:
<ul>
<li>The <strong>createReport</strong> operation of the Selling Partner API for Reports, when used to request the <strong>GET_AMAZON_FULFILLED_SHIPMENTS_REMITTANCE</strong> report. This report returns detailed order/shipment/item information.</li>
<li>The <strong>getOrderItems</strong> operation of the Selling Partner API for Orders, which returns detailed order item information for an order.</li>
<li>The <strong>getOrders</strong> operation of the Selling Partner API for Orders, which returns a list of order item information for a time frame and a range of criteria.</li>
</ul></td>
</tr>
</tbody>
</table>

# Frequently Asked Questions

## How do I request and qualify for a role?

You request and qualify for Selling Partner API roles by populating your Developer Profile, when available. The specific information requested depends on whether you are an already existing Amazon Marketplace Web Service (MWS) developer or not, and whether you have previously registered.

Once your profile is submitted, Amazon evaluates the information provided and approves or denies your request. If denied, you can address the reason for the denial and then resubmit your profile.

## How do I choose the roles for my application?

When you create your Selling Partner API application on the application client creation page, you can choose roles from among those that were requested and approved in your developer profile. If the role you need is missing, you must update the roles in your developer profile to include it, and resubmit your profile for evaluation by Amazon. Once approved, the added role will be available to select for your application.

## How do I determine what roles to request?

Review the role descriptions in this document to understand the purpose of each role, and to see examples of the resources and operations governed by each role.

## What happens when I call an operation for which I do not have the required role(s)?

The response to the request will have an HTTP status code of 403 and error information in the response body.
