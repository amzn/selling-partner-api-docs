Tokens API Use Case Guide
=========================

Version: 2021-03-01

Contents
=================

- [What is the Tokens API?](#what-is-the-tokens-api)
    - [Terminology](#terminology)
    
- [Restricted operations](#restricted-operations)
    - [Restricted report types](#restricted-report-types)
    
- [Tutorial: Get authorization to access PII for bulk orders](#tutorial-get-authorization-to-access-pii-for-bulk-orders)
    - [Step 1. Get an RDT](#step-1-get-an-rdt-getorders)
    
    - [Step 2. Include the RDT with a call to the getOrders operation](#step-2-include-the-rdt-with-a-call-to-the-getorders-operation)
    
- [Tutorial: Get authorization to access PII for the order items in an order](#tutorial-get-authorization-to-access-pii-for-the-order-items-in-an-order)

    - [Step 1. Get an order ID](#step-1-get-an-order-id)

    - [Step 2. Get an RDT](#step-2-get-an-rdt)

    - [Step 3. Include the RDT with a call to the getOrderItems operation](#step-3-include-the-rdt-with-a-call-to-the-getorderitems-operation)

- [Tutorial: Delegate authorization to access PII](#tutorial-delegate-authorization-to-access-pii)

   - [Step 1. Get an RDT](#step-1-get-an-rdt-delegate-authorization)

   - [Step 2. Pass the RDT and order ID to the delegatee application](#step-2-pass-the-rdt-and-order-id-to-the-delegatee-application)

   - [Step 3. The delegatee application calls the getOrder operation](#step-3-the-delegatee-application-calls-the-getorder-operation)

- [Tutorial: Get authorization to access shipment information for multiple shipments](#tutorial-get-authorization-to-access-shipment-information-for-multiple-shipments)
    - [Step 1. Get an RDT](#step-1-get-an-rdt-getShipment)
    
    - [Step 2. Include the RDT with a call the getShipment operation](#step-2-include-the-rdt-with-a-call-the-getshipment-operation)
    
- [Tutorial: Generate a Java SDK for the Tokens API](#tutorial-generate-a-java-sdk-for-the-tokens-api)

What is the Tokens API?
=======================

The Selling Partner API for Tokens (Tokens API) provides a secure way to access a customer's Personally Identifiable Information (PII). You can call the [createRestrictedDataToken](https://github.com/amzn/selling-partner-api-docs/blob/main/references/tokens-api/tokens_2021-03-01.md#createrestricteddatatoken) operation of the Tokens API to get a Restricted Data Token (RDT) for one or more restricted resources that you specify. Or, if you have a 
"delegatee application," you can get an RDT from a "delegator application" owned by a developer that you work closely with (see [Delegating authorization](#delegating-authorization)). In either case, an RDT authorizes you to make calls to operations that return restricted data. For definitions, see [Terminology](#terminology).

When you call a restricted operation, you include an RDT in the `x-amz-access-token` header. This is in contrast to other Selling Partner API operations, where you include an LWA access token in the `x-amz-access-token` header. For more information, see [Step 3. Add headers to the URI](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md#step-3-add-headers-to-the-uri) in the Selling Partner API Developer Guide.

## Delegating authorization

With the Tokens API, a delegator application can get an RDT that delegates authorization to access PII to a delegatee application. The delegator application is authorized by the selling partner and is the application that the selling partner interacts with. The delegatee application performs a specialized function that requires PII, such as shipping, tax invoicing, or tax remittance services. These two applications are owned by different developers and are closely integrated, such that the delegator application can securely transmit an RDT to the delegatee application. For more information about delegating authorization using an RDT, see [Tutorial: Delegate authorization to access PII](#tutorial-delegate-authorization-to-access-pii).

Terminology
-----------

-   **Restricted Data Token (RDT)**. A short-lived access token that authorizes calls restricted operations. An RDT remains valid for one hour.


-   **Restricted operation.** An operation that returns restricted data, such as PII. You need an RDT to call a [restricted operation](#restricted-operations).

-   **Restricted resource.** An HTTP method and path that represent a restricted operation.

-   **Restricted report type.** A report type that contains PII. See [Restricted report types](#restricted-report-types).

-   **Delegator application**. An application that gets an RDT and passes it to a delegatee application. The selling partner authorizes and interacts with the delegator application.

-   **Delegatee application**. An application that gets authorization to call restricted operations from an RDT that is passed to it by a delegator application. A delegatee application performs a specialized function that requires PII, such as shipping, tax invoicing, or tax remittance services, and is not directly authorized by the selling partner.

-   **Specific path.** A path in a restricted resource that contains a specific order or shipment identifier. For example, `orders/v0/orders/902-3159896-1390916/address`

-   **Generic path.** A path in a restricted resource that contains a generic identifier, such as `{orderId}` or `{shipmentId}`. For example, `orders/v0/orders/{orderId}/address`

Restricted operations
=====================

Restricted operations return customers' Personally Identifiable Information (PII). You need an RDT to call a restricted operation.

Here is list of restricted operations, grouped by API:

Direct Fulfillment Orders API:

-   getOrders
-   getOrder

Direct Fulfillment Shipping API:

-   getShippingLabels
-   getPackingSlips
-   getCustomerInvoices

Merchant Fulfillment API:

-   getShipment

-   cancelShipment

-   cancelShipmentOld

-   createShipment

Orders API:

- getOrders

- getOrder

- getOrderItems

  **Important.** We recommend using the getOrder, getOrders, and getOrderItems operations to retrieve PII using the RDT because the getOrderBuyerInfo, getOrderAddress, and getOrderItemsBuyerInfo operations are scheduled for deprecation on January 12, 2022.

Reports API:

-   getReportDocument

    **Notes.**

    -  The getReportDocument operation is considered a restricted operation only when a restricted report type is specified. See the list of [restricted report types](#restricted-report-types).
    -  When calling the createRestrictedDataToken operation to get an RDT for the getReportDocument operation, the specified restricted resource can contain only a specific path, not a generic path. For definitions, see [Terminology](#terminology).

Shipment Invoicing:

-   getShipmentDetails

Shipping API:

-   getShipment

Restricted report types
-----------------------

Restricted report types contain PII. When specifying a restricted report type in a call to the getReportDocument operation, you must pass in an RDT with the call.

Here is a list of restricted report types:

-   GET_AMAZON_FULFILLED_SHIPMENTS_DATA_INVOICING

-   GET_AMAZON_FULFILLED_SHIPMENTS_DATA_TAX

-   GET_FLAT_FILE_ACTIONABLE_ORDER_DATA_SHIPPING

-   GET_FLAT_FILE_ORDER_REPORT_DATA_SHIPPING

-   GET_FLAT_FILE_ORDER_REPORT_DATA_INVOICING

-   GET_FLAT_FILE_ORDER_REPORT_DATA_TAX

-   GET_FLAT_FILE_ORDERS_RECONCILIATION_DATA_TAX

-   GET_FLAT_FILE_ORDERS_RECONCILIATION_DATA_INVOICING

-   GET_FLAT_FILE_ORDERS_RECONCILIATION_DATA_SHIPPING

-   GET_ORDER_REPORT_DATA_INVOICING

-   GET_ORDER_REPORT_DATA_TAX

-   GET_ORDER_REPORT_DATA_SHIPPING

-   GET_EASYSHIP_DOCUMENTS

-   GET_GST_MTR_B2B_CUSTOM

-   GET_VAT_TRANSACTION_DATA

-   SC_VAT_TAX_REPORT

# Tutorial: Get authorization to access PII for bulk orders

You can get an RDT that provides authorization to access Personally Identifiable Information (PII) for bulk orders. The `dataElements` values that you specify (using the [restrictedResources](https://github.com/amzn/selling-partner-api-docs/blob/main/references/tokens-api/tokens_2021-03-01.md#restrictedresource) parameter of the createRestrictedDataToken operation) determine the type of restricted data that the RDT authorizes your application to access. In this tutorial we request an RDT that authorizes access to both buyer information and shipping address information.

**Prerequisites**

To complete this tutorial, you will need:

-   Authorization from the selling partner for whom you are making calls. See the [Selling Partner API Developer Guide](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md) for more information.
-   Approval for the roles that are required to access buyer information and/or shipping address information. These are:
    -   **Direct-to-consumer shipping.** Required to access shipping address information.
    -   **Tax remittance.** Required to access buyer information.
    -   **Tax invoicing.** Required to access buyer information.

    
    To request access to these roles, see [Registering as a developer](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md#registering-as-a-developer) in the Selling Partner API Developer Guide and update your developer profile.

## <a name="step-1-get-an-rdt-getorders"></a>Step 1. Get an RDT

Call the createRestrictedDataToken operation to get an RDT.

1. Call the [createRestrictedDataToken](https://github.com/amzn/selling-partner-api-docs/blob/main/references/tokens-api/tokens_2021-03-01.md#createrestricteddatatoken) operation, passing the following parameters:

Body parameter:

<table><thead><tr class="header"><th><strong>Parameter</strong></th><th><strong>Description</strong></th><th><strong>Required</strong></th></tr></thead><tbody><tr class="odd"><td>restrictedResources</td><td><p>Model of a restricted resource. Maximum: 50</p><p>Type: <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/tokens-api/tokens_2021-03-01.md#restrictedresource">RestrictedResource</a></p></td><td>Yes</td></tr></tbody></table>

**Request Example:**
```
POST https://sellingpartnerapi-na.amazon.com/tokens/2021-03-01/restrictedDataToken
{
  "restrictedResources": [
    {
      "method": "GET",
      "path": "/orders/v0/orders",
      "dataElements": ["buyerInfo", "shippingAddress"]
    }
  ]
}
```
### Response

A successful response includes the following:

<table><thead><tr class="header"><th><strong>Name</strong></th><th><strong>Description</strong></th></tr></thead><tbody><tr class="odd"><td>restrictedDataToken</td><td><p>A Restricted Data Token (RDT). This is a short-lived access token that authorizes a call to the restricted operations represented by the restricted resources that you specified. Pass this value in the <code>x-amz-access-token</code> header when making subsequent calls to the restricted operations.</p><p>Type: string</p></td></tr><tr class="even"><td>expiresIn</td><td><p>The lifetime of the RDT, in seconds.</p><p>Type: integer</p></td></tr></tbody></table>

**Response Example:**
```json
{
  "payload": {
    "restrictedDataToken": "Atz.sprdt|IQEBLjAsAhRmHjNgHpi0U-Dme37rR6CuUpSR",
    "expiresIn": 3600
  }
}
```
2. Save the **restrictedDataToken** value (the RDT) to use in [Step 2. Include the RDT with a call the getOrders operation](#step-2-include-the-rdt-with-a-call-to-the-getorders-operation)

## Step 2. Include the RDT with a call to the getOrders operation

Call the [getOrders](https://github.com/amzn/selling-partner-api-docs/blob/main/references/orders-api/ordersV0.md#getorders) operation of the Orders API, specifying the appropriate parameters to filter for the orders that you want. Be sure to include the RDT from [Step 1. Get an RDT](#step-1-get-an-rdt-getorders) in the `x-amz-access-token` header of your call to getOrders. Because you specified both `buyerInfo` and `shippingAddress` in [Step 1. Get an RDT](#step-1-get-an-rdt-getorders), your call to getOrders is authorized to return both buyer information and shipping address information for each order. Had you specified only `buyerInfo` in Step 1, getOrders would be authorized to return only buyer information for each order. Had you specified only `shippingAddress` in Step 1, getOrders would be authorized to return only shipping address information for each order.

# Tutorial: Get authorization to access PII for the order items in an order

You can get an RDT that provides authorization to access Personally Identifiable Information (PII) in the order items in a specified order. In this workflow you specify `dataElements`=`buyerInfo` to indicate that the RDT will authorize your application to access buyer information for the order items.

**Prerequisites**

To complete this tutorial, you will need:

-   Authorization from the selling partner for whom you are making calls. See the [Selling Partner API Developer Guide](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md) for more information.

-   Approval for the roles that are required to access buyer information. These are:
    -   **Tax remittance**
    -   **Tax invoicing**
    
    You might need approval for only one of these roles, depending on your use case. To request access to these roles, see [Registering as a developer](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md#registering-as-a-developer) in the Selling Partner API Developer Guide and update your developer profile.

## Step 1. Get an order ID

You need an order ID to identify an order for which you want order item information. You also need an order ID to get an RDT that authorizes your application to access buyer information for the order items. You can use the getOrders operation of the Orders API to get a list of orders, from which you can get an order ID for the order that you are interested in.


1. Call the [getOrders](https://github.com/amzn/selling-partner-api-docs/blob/main/references/orders-api/ordersV0.md#getorders) operation of the Orders API, specifying the appropriate parameters to filter for the order that you want.

    The operation returns orders that match your request. Each order includes an order ID.

2. From the orders that are returned, identify the order for which you want order item information.

3. Save the order ID for the order that you want, to use in [Step 2. Get an RDT](#step-2-get-an-rdt) and [Step 3. Include the RDT with a call to the getOrderItems operation](#step-3-include-the-rdt-with-a-call-to-the-getorderitems-operation).

## Step 2. Get an RDT

Call the createRestrictedDataToken operation to get an RDT. In the **path** property of the **restrictedResources** parameter, include the order ID from  [Step 1. Get an order ID](#step-1-get-an-order-id). In this workflow we will specify the **buyerInfo** value of the **dataElements** parameter. This indicates that the RDT should provide authorization to access PII for use cases such as tax and gift wrapping. 

Call the createRestrictedDataToken operation to get an RDT.

1. Call the [createRestrictedDataToken](https://github.com/amzn/selling-partner-api-docs/blob/main/references/tokens-api/tokens_2021-03-01.md#createrestricteddatatoken) operation, passing the following parameter:

**Body parameter:**

<table><thead><tr class="header"><th><strong>Parameter</strong></th><th><strong>Description</strong></th><th><strong>Required</strong></th></tr></thead><tbody><tr class="odd"><td>restrictedResources</td><td><p>Model of a restricted resource. Maximum: 50</p><p>Type: <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/tokens-api/tokens_2021-03-01.md#restrictedresource">RestrictedResource</a></p></td><td>Yes</td></tr></tbody></table>

**Request Example:**
```
POST https://sellingpartnerapi-na.amazon.com/tokens/2021-03-01/restrictedDataToken
{
  "restrictedResources": [
    {
      "method": "GET",
      "path": "/orders/v0/orders/123-1234567-1234567/orderItems",
      "dataElements": ["buyerInfo"]
    }
  ]
}
```
### Response

A successful response includes the following:

<table><thead><tr class="header"><th><strong>Name</strong></th><th><strong>Description</strong></th></tr></thead><tbody><tr class="odd"><td>restrictedDataToken</td><td><p>A Restricted Data Token (RDT). This is a short-lived access token that authorizes a call to the restricted operations represented by the restricted resources that you specified. Pass this value in the <code>x-amz-access-token</code> header when making subsequent calls to the restricted operations.</p><p>Type: string</p></td></tr><tr class="even"><td>expiresIn</td><td><p>The lifetime of the RDT, in seconds.</p><p>Type: integer</p></td></tr></tbody></table>

**Response Example:**
```json
{
  "payload": {
    "restrictedDataToken": "Atz.sprdt|IQEBLjAsAhRmHjNgHpi0U-Dme37rR6CuUpSR",
    "expiresIn": 3600
  }
}
```
2. Save the **restrictedDataToken** value (the RDT) to use in [Step 3. Include the RDT with a call the getOrder operation](#step-3-include-the-rdt-with-a-call-the-getorderitems-operation).

## Step 3. Include the RDT with a call to the getOrderItems operation

Call the [getOrderItems](https://github.com/amzn/selling-partner-api-docs/blob/main/references/orders-api/ordersV0.md#getOrderItems) operation of the Orders API, specifying the order ID that you identified in [Step 1. Get an order ID](#step-1-get-an-order-id). Be sure to include the RDT from Step 1 in the `x-amz-access-token` header of your call to getOrderItems.

# Tutorial: Delegate authorization to access PII

You can delegate authorization to call restricted operations to a "delegatee application," which is an application that performs a specialized function for a selling partner (such as shipping, tax invoicing, or tax remittance services) but is not directly authorized by the selling partner. You delegate authorization in this way by (1) Calling the  [createRestrictedDataToken](https://github.com/amzn/selling-partner-api-docs/blob/main/references/tokens-api/tokens_2021-03-01.md#createrestricteddatatoken) operation of the Tokens API (specifying the application ID of the delegatee application), (2) Getting an RDT from the createRestrictedDataToken response, and (3) Passing the RDT to the delegatee application. The RDT authorizes the delegatee application to call restricted operations that return the PII required to perform functions on behalf of the selling partner. For definitions, see [Terminology](#terminology).

**Prerequisites**

To complete this tutorial, you will need:

- Authorization from the selling partner for whom you are making calls. See the [Selling Partner API Developer Guide](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md) for more information.

- To have indicated in the **App registration** form that you want to delegate access to PII to another application. For instructions for updating the **App registration** form, see [Registering your application](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md#registering-your-application) in the Selling Partner API Developer Guide. Indicate in the form the types of PII that you want to delegate.

- The order ID for an order that requires shipping or tax functionality.

- A partnership with a developer with a delegatee application.

- The application ID of the delegatee application.

- A secure means to transmit an RDT and an order ID to a delegatee application.

In addition, the developer with the delegatee application in [Step 3. The delegatee application calls the getOrder operation](#step-3-the-delegatee-application-calls-the-getorder-operation) will need to:

- [Register as a developer](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md#registering-as-a-developer), requesting approval for the roles that are required to access buyer information and/or shipping address information. These are:
   - **Direct-to-consumer shipping.** Required to access shipping address information.
   - **Tax remittance.** Required to access buyer information.
   - **Tax invoicing.** Required to access buyer information.
   
   For more information about roles, see [Roles in the Selling Partner API](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/roles/Roles-in-the-Selling-Partner-API.md).

## <a name="step-1-get-an-rdt-delegate-authorization"></a>Step 1. Get an RDT

Call the createRestrictedDataToken operation to get an RDT. In the **path** property of the **restrictedResources** parameter, include the order ID of the order for which PII is required. In this workflow we will specify both the **buyerInfo** and **shippingAddress** values of the **dataElements** parameter. This indicates that the RDT should include authorization to access PII for use cases such as tax and shipping. In your own workflow you might specify only one value, depending on the PII your use case requires. 

1. Call the [createRestrictedDataToken](https://github.com/amzn/selling-partner-api-docs/blob/main/references/tokens-api/tokens_2021-03-01.md#createrestricteddatatoken) operation, passing the following parameters:

**Body parameters:**

<table><thead><tr class="header"><th><strong>Parameter</strong></th><th><strong>Description</strong></th><th><strong>Required</strong></th></tr></thead><tbody><tr class="odd"><td>restrictedResources</td><td><p>Model of a restricted resource. Maximum: 50</p><p>Type: <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/tokens-api/tokens_2021-03-01.md#restrictedresource">RestrictedResource</a></p></td><td>Yes</td></tr><tr class="odd"><td>targetApplication</td><td><p>The application ID for the target application to which access is being delegated.</p><p>Type: string </p></td><td>No</td></tr></tbody></table>

**Request Example:**
```
POST https://sellingpartnerapi-na.amazon.com/tokens/2021-03-01/restrictedDataToken
{
  "restrictedResources": [
    {
      "method": "GET",
      "path": "/orders/v0/orders/123-1234567-1234567",
      "dataElements": ["buyerInfo", "shippingAddress"]
    }
  ],
  "targetApplication": "amzn1.sellerapps.app.target-application"
}
```
### Response

A successful response includes the following:

<table><thead><tr class="header"><th><strong>Name</strong></th><th><strong>Description</strong></th></tr></thead><tbody><tr class="odd"><td>restrictedDataToken</td><td><p>A Restricted Data Token (RDT). This is a short-lived access token that authorizes a call to the restricted operations represented by the restricted resources that you specified. Pass this value in the <code>x-amz-access-token</code> header when making subsequent calls to the restricted operations.</p><p>Type: string</p></td></tr><tr class="even"><td>expiresIn</td><td><p>The lifetime of the RDT, in seconds.</p><p>Type: integer</p></td></tr></tbody></table>

**Response Example:**
```json
{
  "payload": {
    "restrictedDataToken": "Atz.sprdt|IQEBLjAsAhRmHjNgHpi0U-Dme37rR6CuUpSR",
    "expiresIn": 3600
  }
}
```
2. Save the **restrictedDataToken** value (the RDT) to provide to the delegatee application in the following step.

## Step 2. Pass the RDT and order ID to the delegatee application

Securely transmit the RDT and order ID to the delegatee application. The application  will use these when calling the getOrder operation in the following step.

## Step 3. The delegatee application calls the getOrder operation

The delegatee application calls the [getOrder](https://github.com/amzn/selling-partner-api-docs/blob/main/references/orders-api/ordersV0.md#getorder) operation of the Orders API, specifying in the path the order ID from [Step 2. Pass the RDT and order ID to the delegatee application](#step-2-pass-the-rdt-and-order-id-to-the-delegatee-application). The call must include the RDT (also from Step 2) in the `x-amz-access-token` header of the call. Because both `buyerInfo` and `shippingAddress` were specified in [Step 1. Get an RDT](#step-1-get-an-rdt-delegate-authorization), the call to getOrder returns both buyer information and shipping address information for the order.

1. The delegatee application calls the [getOrder](https://github.com/amzn/selling-partner-api-docs/blob/main/references/orders-api/ordersV0.md#getorder) operation, passing the following parameters:

Body parameters:

<table><thead><tr class="header"><th><strong>Parameter</strong></th><th><strong>Description</strong></th><th><strong>Required</strong></th></tr></thead><tbody><tr class="odd"><td>orderId </td><td><p>An Amazon-defined order identifier, in 3-7-7 format.</p><p>Type: string</p></td><td>Yes</td></tr></tbody></table>

**Request Example:**
```
GET https://sellingpartnerapi-na.amazon.com/orders/v0/orders/123-1234567-1234567
```
### Response

A successful response includes the following:

<table><thead><tr class="header"><th><strong>Name</strong></th><th><strong>Description</strong></th></tr></thead><tbody><tr class="odd"><td>payload</td><td><p>The payload for the getOrder operation.</p><p>Type: <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/orders-api/ordersV0.md#order">Order</a></p></td></tr></tbody></table>

**Response Example:**
```json
{
  "payload": {
    "AmazonOrderId": "902-3159896-1390916",
    "PurchaseDate": "2017-01-20T19:49:35Z",
    "LastUpdateDate": "2017-01-20T19:49:35Z",
    "OrderStatus": "Pending",
    "FulfillmentChannel": "SellerFulfilled",
    "NumberOfItemsShipped": 0,
    "NumberOfItemsUnshipped": 0,
    "PaymentMethod": "Other",
    "PaymentMethodDetails": [
      "CreditCard",
      "GiftCerificate"
    ],
    "MarketplaceId": "ATVPDKIKX0DER",
    "ShipmentServiceLevelCategory": "Standard",
    "OrderType": "StandardOrder",
    "EarliestShipDate": "2017-01-20T19:51:16Z",
    "LatestShipDate": "2017-01-25T19:49:35Z",
    "IsBusinessOrder": false,
    "IsPrime": false,
    "IsGlobalExpressEnabled": false,
    "IsPremiumOrder": false,
    "IsSoldByAB": false,
    "DefaultShipFromLocationAddress": {
      "Name": "MFNIntegrationTestMerchant",
      "AddressLine1": "2201 WESTLAKE AVE",
      "City": "SEATTLE",
      "StateOrRegion": "WA",
      "PostalCode": "98121-2778",
      "CountryCode": "US",
      "Phone": "+1 480-386-0930 ext. 73824",
      "AddressType": "Commercial"
    },
    "FulfillmentInstruction": {
      "FulfillmentSupplySourceId": "sampleSupplySourceId"
    },
    "IsISPU": false,
    "ShippingAddress": {
      "Name": "Michigan address",
      "AddressLine1": "1 Cross St.",
      "City": "Canton",
      "StateOrRegion": "MI",
      "PostalCode": "48817",
      "CountryCode": "US"
    },
    "BuyerInfo": {
      "BuyerEmail": "user@example.com",
      "BuyerName": "John Doe",
      "BuyerTaxInfo": {
        "CompanyLegalName": "A Company Name"
      },
      "PurchaseOrderNumber": "1234567890123"
    }
  }
}
```
2. The delegatee application uses the data in the response to perform its shipping and tax functions.

# Tutorial: Get authorization to access shipment information for multiple shipments

You can get an RDT that provides authorization to get shipment information for any of a selling partner's shipments.

**Prerequisites**

To complete this tutorial, you will need:

-   Authorization from the selling partner for whom you are making calls. See the [Selling Partner API Developer Guide](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md) for more information.

-   Approval for the **Direct-to-consumer shipping** role, which is required to access shipping address information. To request access to this role, see [Registering as a developer](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md#registering-as-a-developer) in the Selling Partner API Developer Guide and update your developer profile.

- Shipment IDs for the shipments that you want to get shipment information for.

## <a name="step-1-get-an-rdt-getShipment"></a>Step 1. Get an RDT

Call the createRestrictedDataToken operation to get an RDT. In the **path** property of the  **restrictedResources** parameter that you specify, use a generic path that includes this text: `{shipmentId}`. For definitions, see [Terminology](#terminology).

1.   Call the [createRestrictedDataToken](https://github.com/amzn/selling-partner-api-docs/blob/main/references/tokens-api/tokens_2021-03-01.md#createrestricteddatatoken) operation, passing the following parameter:

**Body parameters:**

<table><thead><tr class="header"><th><strong>Parameter</strong></th><th><strong>Description</strong></th><th><strong>Required</strong></th></tr></thead><tbody><tr class="odd"><td>restrictedResources</td><td><p>Model of a restricted resource. Maximum: 50</p><p>Type: <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/tokens-api/tokens_2021-03-01.md#restrictedresource">RestrictedResource</a></p></td><td>Yes</td></tr></tbody></table>

**Request Example:**

```
POST https://sellingpartnerapi-na.amazon.com/tokens/2021-03-01/restrictedDataToken
{
  "restrictedResources": [
    {
      "method": "GET",
      "path": "/mfn/v0/shipments/{shipmentId}"
    }
  ]
}
```
### Response

A successful response includes the following:

<table><thead><tr class="header"><th><strong>Name</strong></th><th><strong>Description</strong></th></tr></thead><tbody><tr class="odd"><td>restrictedDataToken</td><td><p>A Restricted Data Token (RDT). This is a short-lived access token that authorizes you to call the restricted operations represented by the restricted resources that you specified. Pass the RDT value in the <code>x-amz-access-token</code> header when making subsequent calls to the restricted operations.</p><p>Type: string</p></td></tr><tr class="even"><td>expiresIn</td><td><p>The lifetime of the RDT, in seconds.</p><p>Type: integer</p></td></tr></tbody></table>

**Response Example:**
```json
{
  "payload": {
    "restrictedDataToken": "Atz.sprdt|IQEBLjAsAhRmHjNgHpi0U-Dme37rR6CuUpSR",
    "expiresIn": 3600
  }
}
```
2. Save the **restrictedDataToken** value (the RDT) to use in [Step 2. Include the RDT with a call the getShipment operation](#step-2-include-the-rdt-with-a-call-the-getshipment-operation).

   For definitions, see [Terminology](#terminology).

## Step 2. Include the RDT with a call the getShipment operation

Call the [getShipment](https://github.com/amzn/selling-partner-api-docs/blob/main/references/merchant-fulfillment-api/merchantFulfillmentV0.md#getshipment) operation of the Merchant Fulfillment API, using the generic path that you specified in [Step-1. Get an RDT](#step-1-get-an-rdt-getShipment) and replacing `{shipmentId}` with a real shipment ID from the selling partner. For example, `GET /mfn/v0/shipments/FBA1234ABC5D`. Repeat for all of the shipments for which you want shipping information, specifying the appropriate shipment ID with each call. Each call must include the RDT from [Step-1. Get an RDT](#step-1-get-an-rdt-getshipment) in the `x-amz-access-token` header.

**Note.** An RDT remains valid for one hour.

Tutorial: Generate a Java SDK for the Tokens API
================================================


With this SDK you can make calls to the Tokens API with the following code already set up for you: Login with Amazon token exchange (exchange a refresh token for an access token) and authentication.

**To generate a Java SDK with LWA token exchange and authentication**

1. Install [Java 8 or newer](https://www.oracle.com/technetwork/java/index.html), [Apache Maven 3.6. or greater](http://maven.apache.org/), and [GNU Wget](https://www.gnu.org/software/wget/wget.html) and make them available in your $PATH.

2. Go to <https://github.com/amzn/selling-partner-api-models>.

3. Clone the repository to make a local copy on your computer, if you haven't done so already.

4. Open a command prompt window and go to a directory where you want to download the Swagger Code Generator.

5. Download the latest version of the Swagger Code Generator.

    For example:
    ```
    wget https://repo1.maven.org/maven2/io/swagger/swagger-codegen-cli/2.4.13/swagger-codegen-cli-2.4.13.jar -O swagger-codegen-cli.jar
    ```
    **swagger-codegen-cli.jar** downloads to the current directory.
    
    **Note:** You can also download from maven.org by directing your browser here: <https://repo1.maven.org/maven2/io/swagger/swagger-codegen-cli/2.4.13/swagger-codegen-cli-2.4.13.jar>

6. Copy **swagger-codegen-cli.jar** into a directory structure that makes sense for you. For this example, we'll copy it to C:\SwaggerToCL.

7. Navigate to **tokens_2021-03-01.json** in the **selling-partner-api-models\models\tokens-api-model** folder of your local copy of the repository.

8. Copy **tokens_2021-03-01.json** into C:\SwaggerToCL.

9. Generate the SDK against the templates in the **selling-partner-api-models\clients\sellingpartner-api-aa-java folder** of your local copy of the repository. This folder contains an authorization and authentication library, along with customized templates for the Swagger Code Generator.

    For example:
    ```
    java -jar C:\SwaggerToCL\swagger-codegen-cli.jar generate -i C:\SwaggerToCL\tokens_2021-03-01.json -l java -t [path to selling-partner-api-models\clients\sellingpartner-api-aa-java folder]\resources\swagger-codegen\templates\ -o C:\SwaggerToCL\Tokens_JavaCL
    ```
    The SDK is copied to C:\SwaggerToCL\Tokens_JavaCL

10. Build the AA Library and add it as a dependency of the SDK:
    
    1.  Navigate to the **selling-partner-api-models\clients\sellingpartner-api-aa-java** folder of your local copy of the repository and run mvn package. This generates a folder named "target". In this folder is a JAR file named **sellingpartnerapi-aa-java-1.0-jar-with-dependencies.jar** (or something similar) and all of the required dependencies.
    
    2.  Install the JAR file in your local Maven repository.
    
        For example:
        ```
        mvn install:install-file -Dfile=[path to JAR file in "target" folder] -DgroupId=com.amazon.sellingpartnerapi -DartifactId=sellingpartnerapi-aa-java -Dversion=1.0 -Dpackaging=jar
        ```
        You can find the actual groupId, artifactId, and version values near the top of the **pom.xml** file in the **selling-partner-api-models\clients\sellingpartner-api-aa-java** folder.

11. Add a dependency on the AA library in the **pom.xml** of the client library:
    
     For example:
    
     ```
     <dependency>
     <groupId>com.amazon.sellingpartnerapi</groupId>
     <artifactId>sellingpartnerapi-aa-java</artifactId>
     <version>1.0</version>
     </dependency>
     ```
12. Run **mvn package** inside the generated SDK folder.

13. Download any of the following files and use them to build classes inside the **main/java/sampleCode/** folder of the generated client library. For definitions, see [Terminology](#terminology).

    - [RestrictedDataTokenWorkflow.java](https://github.com/amzn/selling-partner-api-models/blob/main/clients/sample-code/RestrictedDataTokenWorkflow.java). For getting an RDT and using it to authorize your own application to call one or more restricted operations.

    - [DelegatedRestrictedDataTokenWorkflowForDelegator.java](https://github.com/amzn/selling-partner-api-models/blob/main/clients/sample-code/DelegatedRestrictedDataTokenWorkflowForDelegator.java). For getting an RDT that delegates authorization to call restricted operations to a delegatee application.
    
    - [DelegatedRestrictedDataTokenWorkflowForDelegatee.java](https://github.com/amzn/selling-partner-api-models/blob/main/clients/sample-code/DelegatedRestrictedDataTokenWorkflowForDelegatee.java). For a delegatee application that receives an RDT from a delegator application and uses it for authorization to call restricted operations.

    **Note.** Use the latest version of **tokens_2021-03-01.json** when generating your SDK to ensure that you are getting the latest functionality.

You can now start testing workflows for getting RDTs and calling restricted operations. Use this code to guide you in building your own applications.