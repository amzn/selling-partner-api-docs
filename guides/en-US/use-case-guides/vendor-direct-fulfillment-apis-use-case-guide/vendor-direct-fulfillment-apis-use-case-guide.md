# Vendor Direct Fulfillment APIs Use Case Guide

API Version: V1

Contents
========

* [Overview](#overview)

* [What is the Direct Fulfillment Orders API?](#what-is-the-direct-fulfillment-orders-api)

   * [Get Purchase Orders](#get-purchase-orders)

   * [Get Purchase Order](#get-purchase-order)

   * [Acknowledge Order](#acknowledge-order)

* [What is the Direct Fulfillment Shipping API?](#what-is-the-direct-fulfillment-shipping-api)

   * [Submit Shipping Label Request](#submit-shipping-label-request)

   * [Get Shipping Labels](#get-shipping-labels)

   * [Get Shipping Label](#get-shipping-label)

   * [Submit Shipment Confirmations](#submit-shipment-confirmations)

   * [Submit Shipment Status Updates](#submit-shipment-status-updates)

   * [Get Packing Slips](#get-packing-slips)

   * [Get Packing Slip](#get-packing-slip)

   * [Get Customer Invoices](#get-customer-invoices)

   * [Get Customer Invoice](#get-customer-invoice)

* [What is the Direct Fulfillment Payments API?](#what-is-the-direct-fulfillment-payments-api)

   * [Submit Invoices](#submit-invoices)

* [What is the Direct Fulfillment Inventory API?](#what-is-the-direct-fulfillment-inventory-api)

   * [Submit Inventory Update](#submit-inventory-update)

* [What is the Direct Fulfillment Transaction Status API?](#what-is-the-direct-fulfillment-transaction-status-api)

   * [Get Transaction Status](#get-transaction-status)

Overview
========

The Selling Partner APIs for Direct Fulfillment help vendors in the direct fulfillment (DF) program manage their direct fulfillment operations programmatically through web service integration. This can help vendors improve and maintain their performance at scale, and grow their business with Amazon.

Vendors can use these APIs to build applications to increase operational efficiency, reduce effort, reduce errors, and improve performance.

For information on authentication and authorization, see the [Selling Partner API Developer Guide for Vendors](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuideForVendors.md).

What is the Direct Fulfillment Orders API?
==========================================

Using the [Direct Fulfillment Orders API](https://github.com/amzn/selling-partner-api-docs/blob/main/references/vendor-direct-fulfillment-orders-api/vendorDirectFulfillmentOrdersV1.md), vendors can receive purchase orders and send order acknowledgements.

The following operations are available:

<table>
  <thead>
    <tr class="header">
      <th>
        <b>Operation</b>
      </th>
      <th>
        <b>HTTP Method</b>
      </th>
      <th>
        <b>Path</b>
      </th>
      <th>
        <b>Description</b>
      </th>
    </tr>
  </thead>
  <tbody>
    <tr class="odd">
      <td>
        <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/vendor-direct-fulfillment-orders-api/vendorDirectFulfillmentOrdersV1.md#getorders">getOrders</a>
      </td>
      <td>GET</td>
      <td>/vendor/directFulfillment/orders/v1/purchaseOrders</td>
      <td>Get a list of orders based on creation date range.</td>
    </tr>
    <tr class="even">
      <td>
        <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/vendor-direct-fulfillment-orders-api/vendorDirectFulfillmentOrdersV1.md#getorder">getOrder</a>
      </td>
      <td>GET</td>
      <td>/vendor/directFulfillment/orders/v1/purchaseOrders /{purchaseOrderNumber}</td>
      <td>Get order details of a specific order by purchase order number.</td>
    </tr>
    <tr class="odd">
      <td>
        <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/vendor-direct-fulfillment-orders-api/vendorDirectFulfillmentOrdersV1.md#submitacknowledgement">submitAcknowledgement</a>
      </td>
      <td>POST</td>
      <td>/vendor/directFulfillment/orders/v1/acknowledgements</td>
      <td>Acknowledge (Accept or Reject) single or multiple orders.</td>
    </tr>
  </tbody>
</table>


You can use the [getOrders](https://github.com/amzn/selling-partner-api-docs/blob/main/references/vendor-direct-fulfillment-orders-api/vendorDirectFulfillmentOrdersV1.md#getorders) operation to access orders created during a time frame that you specify (time range of 7 days from a rolling window of the last 6 months, after the vendor went live on the API). You can also get detailed order information for specific orders using the getOrder operation. You can then acknowledge the order using the submitAcknowledgement operation.

**Note**: It's possible to get only purchase order numbers without complete order details using the getOrders operation (use "includeDetails=false" in query parameter). The default value for this parameter is true, so if you don't include this query parameter, you will get the full details of the purchase orders.

The following diagram shows the workflow using the Direct Fulfillment Orders APIs.

<img src="./media/DFOrdersWorkflow.png" 
alt="Direct Fulfillment orders workflow" 
style="width:5.872in;height:5.29546in" />

The details for each operation are in the sections below.

Get Purchase Orders
-------------------

The getOrders operation returns a list of order references (purchase order numbers) or complete order details for all orders which meet the criteria specified. If you return only the order numbers, you can use each order number later with the getOrder operation to get order details for a specific order.

You should use this API to get purchase orders available to you for fulfillment. Amazon recommends that vendors check for orders at least once per hour during business hours. Depending on your business volume, you may choose to check more frequently. You can return up to 100 orders in one API call. If there are more than 100 orders you can use the nextToken value in the response to get the next set of orders.

The following diagram shows the integration workflow when retrieving purchase orders:

<img src="./media/GetPurchaseOrders.png" 
alt="Direct Fulfillment integration workflow when retrieving purchase orders" 
style="width:3.072in;height:4.83538in" />

### getOrders Request

To return a list of purchase orders, call the [getOrders](https://github.com/amzn/selling-partner-api-docs/blob/main/references/vendor-direct-fulfillment-orders-api/vendorDirectFulfillmentOrdersV1.md#getorders) operation and pass the following parameters:

Query parameters:

<table>
  <thead>
    <tr class="header">
      <th>
        <b>Name</b>
      </th>
      <th>
        <b>Description</b>
      </th>
      <th>
        <b>Required</b>
      </th>
    </tr>
  </thead>
  <tbody>
    <tr class="odd">
      <td>shipFromPartyId</td>
      <td>The vendor warehouseId from which the order will be fulfilled. If not specified the result will contain orders for all warehouses.
        <p>Type: string</p>
      </td>
      <td>No</td>
    </tr>
    <tr class="even">
      <td>status</td>
      <td>Returns only orders that belong to this status. If not specified, the result will contain orders in any status.
        <p>Type: enum (
          <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/vendor-direct-fulfillment-orders-api/vendorDirectFulfillmentOrdersV1.md#status">Status</a>
          )
        </p>
      </td>
      <td>No</td>
    </tr>
    <tr class="odd">
      <td>limit</td>
      <td>The limit to the number of records returned.
        <p>Type: integer (int64)</p>
      </td>
      <td>No</td>
    </tr>
    <tr class="even">
      <td>createdAfter</td>
      <td>Orders that became available after this date and time will be included in the result. Must be in ISO-8601 date/time format.
        <p>Type: string (date-time)</p>
      </td>
      <td>Yes</td>
    </tr>
    <tr class="odd">
      <td>createdBefore</td>
      <td>Orders that became available before this date and time will be included in the result. Must be in ISO-8601 date/time format.
        <p>Type: string (date-time)</p>
      </td>
      <td>Yes</td>
    </tr>
    <tr class="even">
      <td>sortOrder</td>
      <td>Sort ASC or DESC by order creation date.
        <p>Type: enum (
          <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/vendor-direct-fulfillment-orders-api/vendorDirectFulfillmentOrdersV1.md#sortorder">SortOrder</a>
          )
        </p>
      </td>
      <td>No</td>
    </tr>
    <tr class="odd">
      <td>nextToken</td>
      <td>Used for pagination when there are more orders than the specified result size limit. The token value is returned in the previous API call.
        <p>Type: string</p>
      </td>
      <td>No</td>
    </tr>
    <tr class="even">
      <td>includeDetails</td>
      <td>Default value is true. When true, this API will return a list of orders with complete details. When false or not included in the filter, only purchase order numbers are returned.
        <p>Type: string</p>
      </td>
      <td>No</td>
    </tr>
  </tbody>
</table>


Request example:

```
GET https://sellingpartnerapi-na.amazon.com/vendor/directFulfillment/orders/v1/purchaseOrders?limit=2&createdAfter=2020-02-15T14:00:00-08:00&createdBefore=2020-02-20T00:00:00-08:00&sortOrder=DESC&includeDetails=true
```

### getOrders Response

A successful response includes the following:

<table>
  <thead>
    <tr class="header">
      <th>
        <b>Name</b>
      </th>
      <th>
        <b>Description</b>
      </th>
      <th>
        <b>Required</b>
      </th>
    </tr>
  </thead>
  <tbody>
    <tr class="odd">
      <td>pagination</td>
      <td>If more than 100 orders are returned, nextToken is returned in the response for pagination.
        <p>Type: string</p>
      </td>
      <td>No</td>
    </tr>
    <tr class="even">
      <td>orders</td>
      <td>Includes details for the purchase order.
        <p>Type:
          <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/vendor-direct-fulfillment-orders-api/vendorDirectFulfillmentOrdersV1.md#order">Order</a>
        </p>
      </td>
      <td>No</td>
    </tr>
  </tbody>
</table>


Response example:

```json
{
  "pagination":
  {
    "nextToken": "MDAwMDAwMDAwMQ=="
  },
  "orders": [
    {
      "purchaseOrderNumber": "2JK3S9VC",
      "orderDetails":
      {
        "customerOrderNumber": "123-ABC",
        "orderDate": "2020-02-20T13:51:00Z",
        "shipmentDetails":
        {
          "isPriorityShipment": false,
          "isScheduledDeliveryShipment": false,
          "isPslipRequired": true,
          "isGift": false,
          "shipMethod": "UPS_2ND",
          "shipmentDates":
          {
            "requiredShipDate": "2020-02-21T00:00:00Z",
            "promisedDeliveryDate": "2020-02-24T00:00:00Z"
          },
          "messageToCustomer": "This shipment completes your order. You can always check the status of your orders from the \"Your Account\" link at the top of each page of our site.Thank you for shopping at Amazon.com"
        },
        "taxTotal":
        {
          "taxLineItem": [
            {
              "taxRate": "0.1",
              "taxAmount":
              {
                "currencyCode": "USD",
                "amount": "190"
              },
              "type": "TOTAL"
            }
          ]
        },
        "sellingParty":
        {
          "partyId": "999US"
        },
        "shipFromParty":
        {
          "partyId": "ABCD"
        },
        "shipToParty":
        {
          "name": "ABCD",
          "attention": "ABCD",
          "addressLine1": "123 XYZ Street",
          "addressLine2": "Apt 5",
          "city": "San Jose",
          "stateOrRegion": "CA",
          "postalCode": "94086",
          "countryCode": "USA"
        },
        "billToParty":
        {
          "partyId": "ABCD"
        },
        "items": [
          {
            "itemSequenceNumber": "00001",
            "buyerProductIdentifier": "B07DFVDRAB",
            "vendorProductIdentifier": "8806098286500",
            "title": "LG 8 kg Inverter Wi-Fi Fully-Automatic Front Loading Washing Machine (FHT1408SWS, STS-VCM, Inbuilt Heater)",
            "orderedQuantity":
            {
              "amount": 1,
              "unitOfMeasure": "EACH"
            },

            "netPrice":
            {
              "currencyCode": "USD",
              "amount": "500"
            },
            "taxDetails":
            {
              "taxLineItem": [
                {
                  "taxRate": "0.1",
                  "taxAmount":
                  {
                    "currencyCode": "USD",
                    "amount": "50"
                  },
                  "type": "TOTAL"
                }
              ]
            }
          },
          {
            "itemSequenceNumber": "00002",
            "buyerProductIdentifier": "B07DFYF5AB",
            "vendorProductIdentifier": "8806098286123",
            "title": "LG 6.5 kg Inverter Fully-Automatic Front Loading Washing Machine (FHT1065SNW, Blue and White, Inbuilt Heater)",
            "orderedQuantity":
            {
              "amount": 2,
              "unitOfMeasure": "EACH"
            },
            "netPrice":
            {
              "currencyCode": "USD",
              "amount": "700"
            },
            "taxDetails":
            {
              "taxLineItem": [
                {
                  "taxRate": "0.1",
                  "taxAmount":
                  {
                    "currencyCode": "USD",
                    "amount": "140"
                  },
                  "type": "TOTAL"
                }
              ]
            }
          }
        ]
      }
    }
  ]
}
```


Get Purchase Order
------------------

The [getOrder](https://github.com/amzn/selling-partner-api-docs/blob/main/references/vendor-direct-fulfillment-orders-api/vendorDirectFulfillmentOrdersV1.md#getorder) operation returns information about the purchase order that you specify using the purchase order number. The response includes complete purchase order information for the purchase order, including line item details, quantity, cost, etc.

You should use this API to get the details of specific orders returned by the [getOrders](https://github.com/amzn/selling-partner-api-docs/blob/main/references/vendor-direct-fulfillment-orders-api/vendorDirectFulfillmentOrdersV1.md#getorders) operation. You can also use this API to get details for any purchase order (in the time range of 7 days from a rolling window of last 6 months, after the vendor went live on API).

The following diagram shows the integration workflow to retrieve a specific purchase order:

<img src="./media/GetPurchaseOrder.png" alt="Direct Fulfillment integration workflow to retrieve a specific purchase order" style="width:2.792in;height:3.78559in" />

### Business Requirements

-   **Are packing slips required for all orders?**

A packing slip is required if it is a Business to Business \[B2B\] order or a gift order. When "isPslipRequired" is true, a packing slip is required for the order.

-   **By when should the order be shipped?**

You are required to read the value in the "requiredShipDate" field which is the latest date the order should be shipped from the warehouse. "promisedDeliveryDate" field value denotes the date we promised to deliver to the customer.

-   **Changing an order using the API**

Submitting a change to an order using the API is not possible at this time. After an order has been placed, changing it is not possible.

### Country Specific Business Requirements 

| **Functionality** | **India**                                   | **Europe**                                  | **North America**                           |
|-------------------|---------------------------------------------|---------------------------------------------|---------------------------------------------|
| Net Cost          | Conditional. Either net cost or list price. | Conditional. Either net cost or list price. | Conditional. Either net cost or list price. |
| List Price        | Conditional. Either net cost or list price. | Conditional. Either Net Cost or List Price. | Conditional. Either net cost or list price. |
| Ship From Party   | The warehouse code assigned to the vendor.  | The warehouse code assigned to the vendor.  | The warehouse code assigned to the vendor.  |
| Selling Party     | The vendor code assigned to the vendor.     | The vendor code assigned to the vendor.     | The vendor code assigned to the vendor.     |
| Ship To Party     | The address of the customer.                | The address of the customer.                | The address of the customer.                |
| Bill To Party     | The address of the bill to entity.          | The address of the bill to entity.          | Not applicable.                             |

### getOrder Request

To return information about a specific purchase order, call the [getOrder](https://github.com/amzn/selling-partner-api-docs/blob/main/references/vendor-direct-fulfillment-orders-api/vendorDirectFulfillmentOrdersV1.md#getorder) operation and pass the following parameters:

Path parameters:

<table>
  <thead>
    <tr class="header">
      <th>
        <b>Name</b>
      </th>
      <th>
        <b>Description</b>
      </th>
      <th>
        <b>Required</b>
      </th>
    </tr>
  </thead>
  <tbody>
    <tr class="odd">
      <td>purchaseOrderNumber</td>
      <td>Order Id for which the details needs to be fetched. Formatting Notes: 8-character alpha-numeric code.
        <p>Type: string</p>
      </td>
      <td>Yes</td>
    </tr>
  </tbody>
</table>


Request example:

```
GET https://sellingpartnerapi-na.amazon.com/vendor/directFulfillment/orders/v1/purchaseOrders/4Z32PABC
```

### getOrder Response

A successful response includes the following:

<table>
  <thead>
    <tr class="header">
      <th>
        <b>Name</b>
      </th>
      <th>
        <b>Description</b>
      </th>
      <th>
        <b>Required</b>
      </th>
    </tr>
  </thead>
  <tbody>
    <tr class="odd">
      <td>purchaseOrderNumber</td>
      <td>This field will contain the Amazon Purchase OrderNumber for this order. Formatting Notes: 8-character alpha-numeric code.>
        <p>Type: string</p>
      </td>
      <td>No</td>
    </tr>
    <tr class="even">
      <td>orderDetails</td>
      <td>Details of an order.
        <p>Type:
          <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/vendor-direct-fulfillment-orders-api/vendorDirectFulfillmentOrdersV1.md#orderdetails">OrderDetails</a>
        </p>
      </td>
      <td>No</td>
    </tr>
  </tbody>
</table>


Response example:

```json
{
  "purchaseOrderNumber": "2JK3S9VC",
  "orderDetails":
  {
    "customerOrderNumber": "123-ABC",
    "orderDate": "2020-02-20T13:51:00Z",
    "shipmentDetails":
    {
      "isPriorityShipment": false,
      "isScheduledDeliveryShipment": false,
      "isPslipRequired": true,
      "isGift": false,
      "shipMethod": "UPS_2ND",
      "shipmentDates":
      {
        "requiredShipDate": "2020-02-21T00:00:00Z",
        "promisedDeliveryDate": "2020-02-24T00:00:00Z"
      },
      "messageToCustomer": "This shipment completes your order. You can always check the status of your orders from the \"Your Account\" link at the top of each page of our site.Thank you for shopping at Amazon.com"
    },
    "taxTotal":
    {
      "taxLineItem": [
        {
          "taxRate": "0.1",
          "taxAmount":
          {
            "currencyCode": "USD",
            "amount": "190"
          },
          "type": "TOTAL"
        }
      ]
    },
    "sellingParty":
    {
      "partyId": "999US"
    },
    "shipFromParty":
    {
      "partyId": "ABCD"
    },
    "shipToParty":
    {
      "name": "ABCD",
      "attention": "ABCD",
      "addressLine1": "123 XYZ Street",
      "addressLine2": "Apt 5",
      "city": "San Jose",
      "stateOrRegion": "CA",
      "postalCode": "94086",
      "countryCode": "USA"
    },
    "billToParty":
    {
      "partyId": "ABCD"
    },
    "items": [
      {
        "itemSequenceNumber": "00001",
        "buyerProductIdentifier": "B07DFVDRAB",
        "vendorProductIdentifier": "8806098286500",
        "title": "LG 8 kg Inverter Wi-Fi Fully-Automatic Front Loading Washing Machine (FHT1408SWS, STS-VCM, Inbuilt Heater)",
        "orderedQuantity":
        {
          "amount": 1,
          "unitOfMeasure": "EACH"
        },
        "netPrice":
        {
          "currencyCode": "USD",
          "amount": "500"
        },
        "taxDetails":
        {
          "taxLineItem": [
            {
              "taxRate": "0.1",
              "taxAmount":
              {
                "currencyCode": "USD",
                "amount": "50"
              },
              "type": "TOTAL"
            }
          ]
        }
      },
      {
        "itemSequenceNumber": "00002",
        "buyerProductIdentifier": "B07DFYF5AB",
        "vendorProductIdentifier": "8806098286123",
        "title": "LG 6.5 kg Inverter Fully-Automatic Front Loading Washing Machine (FHT1065SNW, Blue and White, Inbuilt Heater)",
        "orderedQuantity":
        {
          "amount": 2,
          "unitOfMeasure": "EACH"
        },
        "netPrice":
        {
          "currencyCode": "USD",
          "amount": "700"
        },
        "taxDetails":
        {
          "taxLineItem": [
            {
              "taxRate": "0.1",
              "taxAmount":
              {
                "currencyCode": "USD",
                "amount": "140"
              },
              "type": "TOTAL"
            }
          ]
        }
      }
    ]
  }
}
```

Acknowledge Order
-----------------

The [submitAcknowledgement](https://github.com/amzn/selling-partner-api-docs/blob/main/references/vendor-direct-fulfillment-orders-api/vendorDirectFulfillmentOrdersV1.md#submitacknowledgement) operation allows vendors to accept or reject a purchase order for fulfillment. Amazon expects a complete acknowledgement, including all purchase order line items of the purchase order. If the vendor does not provide all line items of the purchase order in the acknowledgement, Amazon does not accept the partial acknowledgement.

Amazon expects the vendor to submit the acknowledgement as fast as possible, at the latest within 24 hours. The acknowledgement should be an accurate view of the actual shipment quantities and items.

### Verification of successfully submitted order acknowledgements 

Vendors can verify the status of the original/updated version of the order acknowledgement using [Vendor Central](https://vendorcentral.amazon.com/) or using the Direct Fulfillment Transaction Management API. Allow the system to take up to 15 minutes to show the original/updated version once submitted. If Vendor Central is not showing the correct values for the acknowledgement, open a "Contact Us" case in Vendor Central.

The following diagram shows the integration workflow when acknowledging orders.

<img src="./media/OrderAcknowledgement.png" alt="Direct Fulfillment integration workflow when acknowledging orders" style="width:3.016in;height:7.08105in" />

### Business Requirements

-   **Can a vendor increase the original quantity submitted in the purchase order using the submitAcknowledgement operation?**

No, Amazon does not allow the vendor to send a higher quantity in the acknowledgement than what was submitted in the purchase order.

-   **Is it a requirement to send an order acknowledgement for each purchase order?**

Yes, in order to update the status of an order in the Amazon system correctly, Amazon requires PO confirmation using the API or Vendor Central. If you are unable to meet our order acknowledgement requirements using the API, you must confirm your POs using Vendor Central. Please contact your Amazon business representative if you do not have a Vendor Central account.

-   **Is it a requirement to provide every PO line item in the corresponding order acknowledgement?**

Yes, so Amazon can update the order status correctly.

-   **How should invalid items or details on an order be reported using the order acknowledgement?**

Do not process or ship an item that arrived with an invalid item number on the order. Please return the invalid item number on the acknowledgement and acknowledge it with one of the below codes.

Below is an example of the codes that may be used in the document. Amazon and the vendor will mutually agree upon a list of codes that will be appropriate for their relationship.

**Code & Description**

"00" Shipping 100 percent of ordered product<br>
"02" Canceled due to missing/invalid SKU<br>
"03" Canceled out of stock<br>
"04" Canceled due to duplicate Amazon Ship ID<br>
"05" Canceled due to missing/invalid Bill To Location Code<br>
"06" Canceled due to missing/invalid Ship From Location Code<br>
"07" Canceled due to missing/invalid Customer Ship to Name<br>
"08" Canceled due to missing/invalid Customer Ship to Address Line 1<br>
"09" Canceled due to missing/invalid Customer Ship to City<br>
"10" Canceled due to missing/invalid Customer Ship to State<br>
"11" Canceled due to missing/invalid Customer Ship to Postal Code<br>
"12" Canceled due to missing/invalid Customer Ship to Country Code<br>
"13" Canceled due to missing/invalid Shipping Carrier/Shipping Method<br>
"20" Canceled due to missing/invalid Unit Price<br>
"21" Canceled due to missing/invalid Ship to Address Line 2<br>
"22" Canceled due to missing/invalid Ship to Address Line 3<br>
"50" Canceled due to Tax Nexus Issue<br>
"51" Canceled due to Restricted SKU/Qty<br>
"53" Canceled due to USPS &gt;$400<br>
"54" Canceled due to Missing AmazonShipID<br>
"55" Canceled due to Missing AmazonOrderID<br>
"56" Canceled due to Missing LineItemId<br>
"71" Canceled due to discontinued item<br>

Note: Amazon expects an acknowledgement even if all the line items on the purchase order were invalid and did not produce an order or invoice.

-   **Do I need to return the same product identifier in the acknowledgement that I received in the orders transaction?**

Acknowledgements must return exactly the same product identifier that were sent in the purchase order.

-   **Is it a requirement that I provide an acknowledgement code for all line items regardless of status?**

Yes, it is required so we can correctly update the status of the order. If the acknowledgement code is omitted, the acknowledgement will be rejected in our system.

-   **What is the policy at Amazon.com on partial shipments? How should partial shipments be reported when submitting an order acknowledgement?**

Partial shipments are not allowed. Vendors need to either confirm or reject the full order (fill or kill model).

### Country Specific Business Requirements 

There are no country specific requirements for order acknowledgements.

### submitAcknowledgement Request

To submit order acknowledgements, call the [submitAcknowledgement](https://github.com/amzn/selling-partner-api-docs/blob/main/references/vendor-direct-fulfillment-orders-api/vendorDirectFulfillmentOrdersV1.md#submitacknowledgement) operation and pass the following parameters:

Body parameters:

<table>
  <thead>
    <tr class="header">
      <th>
        <b>Name</b>
      </th>
      <th>
        <b>Description</b>
      </th>
      <th>
        <b>Required</b>
      </th>
    </tr>
  </thead>
  <tbody>
    <tr class="odd">
      <td>orderAcknowledgements</td>
      <td>Details of individual order being acknowledged.
        <p>Type:&lt;
          <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/vendor-direct-fulfillment-orders-api/vendorDirectFulfillmentOrdersV1.md#orderacknowledgementitem">OrderAcknowledgementItem</a>
          &gt; array
        </p>
      </td>
      <td>Yes</td>
    </tr>
  </tbody>
</table>


Request example:

```
POST https://sellingpartnerapi-na.amazon.com/vendor/directFulfillment/orders/v1/acknowledgements
{
  "orderAcknowledgements": [
    {
      "purchaseOrderNumber": "2JK3S9VC",
      "vendorOrderNumber": "ABC",
      "acknowledgementDate": "2020-02-20T19:17:34.304Z",
      "acknowledgementStatus":
      {
        "code": "00",
        "description": "Shipping 100 percent of ordered product"
      },
      "sellingParty":
      {
        "partyId": "999US"
      },
      "shipFromParty":
      {
        "partyId": "ABCD"
      },
      "itemAcknowledgements": [
        {
          "itemSequenceNumber": "00001",
          "buyerProductIdentifier": "B07DFVDRAB",
          "vendorProductIdentifier": "8806098286500",
          "acknowledgedQuantity":
          {
            "amount": 1,
            "unitOfMeasure": "Each"
          }
        }
      ]
    }
  ]
}
```

### submitAcknowledgements Response

A successful response includes the following:

<table>
  <thead>
    <tr class="header">
      <th>
        <b>Name</b>
      </th>
      <th>
        <b>Description</b>
      </th>
      <th>
        <b>Required</b>
      </th>
    </tr>
  </thead>
  <tbody>
    <tr class="odd">
      <td>transactionId</td>
      <td>GUID assigned by Amazon to identify this transaction. It can be used with the Direct Fulfillment Transaction Status API to return the status of this transaction.
        <p>Type: string</p>
      </td>
      <td>Yes</td>
    </tr>
  </tbody>
</table>


Response example:

```json
{

  "transactionId": "20190827182357-8725bde9-c61c-49f9-86ac-46efd82d4da5"

}
```

### Acknowledgement Use Cases

#### Invalid Line Item in the purchase order

If the vendor receives an invalid product identifier in the purchase order, the vendor should reject the item with an acknowledgement code "02" and the "description" as "Canceled due to missing/invalid SKU".


```json
{
  "orderacknowledgements": [
    {
      "purchaseOrderNumber": "2JK3S9VC",
      "vendorOrderNumber": "ABC",
      "acknowledgementDate": "2020-02-20T19:17:34.304Z",
      "acknowledgementStatus": {
        "code": "02",
        "description": "Canceled due to missing/invalid SKU"
      },
      "sellingParty": {
        "partyId": "999US"
      },
      "shipFromParty": {
        "partyId": "ABCD"
      },
      "items": [
        {
          "itemSequenceNumber": "1",
          "buyerProductIdentifier": "B07DFVDRAB",
          "vendorProductIdentifier": 8806098286500,
          "acknowledgedQuantity": {
            "amount": 1,
            "unitOfMeasure": "Each"
          }
        }
      ]
    }
  ]
}
```


#### Out of stock line item in the purchase order

If the vendor receives a product in the purchase order which is now out of stock, the vendor should reject the item with an acknowledgement code "03" and the "description" as "Canceled out of stock".


```json
{
  "orderacknowledgements": [
    {
      "purchaseOrderNumber": "2JK3S9VC",
      "vendorOrderNumber": "ABC",
      "acknowledgementDate": "2020-02-20T19:17:34.304Z",
      "acknowledgementStatus": {
        "code": "03",
        "description": "Canceled out of stock"
      },
      "sellingParty": {
        "partyId": "999US"
      },
      "shipFromParty": {
        "partyId": "ABCD"
      },
      "items": [
        {
          "itemSequenceNumber": "1",
          "buyerProductIdentifier": "B07DFVDRAB",
          "vendorProductIdentifier": 8806098286500,
          "acknowledgedQuantity": {
            "amount": 1,
            "unitOfMeasure": "Each"
          }
        }
      ]
    }
  ]
}
```



#### Confirm purchase order as accepted

If the vendor receives a product in the purchase order which is available to ship, the vendor should accept the item with an acknowledgement code "00" and the "description" as "Shipping 100 percent of ordered product".

```json
{
  "orderacknowledgements": [
    {
      "purchaseOrderNumber": "2JK3S9VC",
      "vendorOrderNumber": "ABC",
      "acknowledgementDate": "2020-02-20T19:17:34.304Z",
      "acknowledgementStatus": {
        "code": "00",
        "description": "Shipping 100 percent of ordered product"
      },
      "sellingParty": {
        "partyId": "999US"
      },
      "shipFromParty": {
        "partyId": "ABCD"
      },
      "items": [
        {
          "itemSequenceNumber": "1",
          "buyerProductIdentifier": "B07DFVDRAB",
          "vendorProductIdentifier": 8806098286500,
          "acknowledgedQuantity": {
            "amount": 1,
            "unitOfMeasure": "Each"
          }
        }
      ]
    }
  ]
}
```


What is the Direct Fulfillment Shipping API?
============================================

Vendors can use the [Direct Fulfillment Shipping API](https://github.com/amzn/selling-partner-api-docs/blob/main/references/vendor-direct-fulfillment-shipping-api/vendorDirectFulfillmentShippingV1.md) to exchange shipment related documents with Amazon. Vendors can request shipping labels, receive shipping labels, send shipment confirmations, get packing slips, and retrieve customer invoices.

Please note that customer invoices are specific to the India region.

The following operations are available:

<table>
  <thead>
    <tr class="header">
      <th>
        <b>Operation</b>
      </th>
      <th>
        <b>HTTP Method</b>
      </th>
      <th>
        <b>Path</b>
      </th>
      <th>
        <b>Description</b>
      </th>
    </tr>
  </thead>
  <tbody>
    <tr class="odd">
      <td>
        <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/vendor-direct-fulfillment-shipping-api/vendorDirectFulfillmentShippingV1.md#submitshippinglabelrequest">submitShippingLabelRequest</a>
      </td>
      <td>POST</td>
      <td>/vendor/directFulfillment/shipping/v1/shippingLabels</td>
      <td>Submit single or multiple shipping label requests.</td>
    </tr>
    <tr class="even">
      <td>
        <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/vendor-direct-fulfillment-shipping-api/vendorDirectFulfillmentShippingV1.md#getShippingLabels">getShippingLabels</a>
      </td>
      <td>GET</td>
      <td>/vendor/directFulfillment/shipping/v1/ shippingLabels</td>
      <td>Get a list of shipping labels based on filter criterion.</td>
    </tr>
    <tr class="odd">
      <td>
        <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/vendor-direct-fulfillment-shipping-api/vendorDirectFulfillmentShippingV1.md#getshippinglabel">getShippingLabel</a>
      </td>
      <td>GET</td>
      <td>
        <p>/vendor/directFulfillment/shipping/v1/shippingLabels/{purchaseOrderNumber}</p>
      </td>
      <td>Get a shipping label by purchase order number.</td>
    </tr>
    <tr class="even">
      <td>
        <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/vendor-direct-fulfillment-shipping-api/vendorDirectFulfillmentShippingV1.md#submitshipmentconfirmations">submitShipmentConfirmations</a>
      </td>
      <td>POST</td>
      <td>/vendor/directFulfillment/shipping/v1/shipmentConfirmations</td>
      <td>Submit single or multiple shipment confirmations to Amazon.</td>
    </tr>
    <tr class="odd">
      <td>
        <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/vendor-direct-fulfillment-shipping-api/vendorDirectFulfillmentShippingV1.md#submitshipmentstatusupdates">submitShipmentStatusUpdates</a>
      </td>
      <td>POST</td>
      <td>/vendor/directFulfillment/shipping/v1/shipmentStatusUpdates</td>
      <td>Submit a shipment status update. Vendor Own Carrier vendors only.</td>
    </tr>
    <tr class="even">
      <td>
        <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/vendor-direct-fulfillment-shipping-api/vendorDirectFulfillmentShippingV1.md#getPackingSlips">getPackingSlips</a>
      </td>
      <td>GET</td>
      <td>/vendor/directFulfillment/shipping/v1/packingSlips</td>
      <td>Get a list of packing slips based on creation date range.</td>
    </tr>
    <tr class="odd">
      <td>
        <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/vendor-direct-fulfillment-shipping-api/vendorDirectFulfillmentShippingV1.md#getpackingslip">getPackingSlip</a>
      </td>
      <td>GET</td>
      <td>/vendor/directFulfillment/shipping/v1/packingSlips/{purchaseOrderNumber}</td>
      <td>Get the packing slip for a specific order by purchase order number.</td>
    </tr>
    <tr class="even">
      <td>
        <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/vendor-direct-fulfillment-shipping-api/vendorDirectFulfillmentShippingV1.md#getCustomerInvoices">getCustomerInvoices</a>
      </td>
      <td>GET</td>
      <td>/vendor/directFulfillment/shipping/v1/customerInvoices</td>
      <td>Get a list of customer invoices based on filter criterion.</td>
    </tr>
    <tr class="odd">
      <td>
        <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/vendor-direct-fulfillment-shipping-api/vendorDirectFulfillmentShippingV1.md#getCustomerInvoice">getCustomerInvoice</a>
      </td>
      <td>GET</td>
      <td>/vendor/directFulfillment/shipping/v1/customerInvoices/{purchaseOrderNumber}</td>
      <td>Get a customer invoice by purchase order number.</td>
    </tr>
  </tbody>
</table>


Submit Shipping Label Request
-----------------------------

The [submitShippingLabelRequest](https://github.com/amzn/selling-partner-api-docs/blob/main/references/vendor-direct-fulfillment-shipping-api/vendorDirectFulfillmentShippingV1.md#submitshippinglabelrequest) operation allows vendors to request shipping label information from Amazon for each purchase order. You can send multiple shipping label requests in bulk in one API call by adhering to the schema. When shipment labels are created by Amazon, they will be available to download using the getShippingLabel operation.

### Verification of successfully submitted shipping label requests

Vendors can verify the status of their shipping label requests using the Direct Fulfillment Transaction Status API. Allow the system up to 15 min to show the status once submitted. If the transaction status is not updated after 30 minutes, open a "Contact Us" case in Vendor Central.

### Shipping Label Request API integration workflow

The following diagram shows the workflow for submitting shipping label requests.

<img src="./media/DFShipLabelWorkflow.png" alt="Direct Fulfillment integration workflow for submitting shipping label requests" style="width:2.64in;height:5.92047in" />

### Business Requirements

-   Amazon must receive a shipping label request after the purchase order is confirmed to be accepted by the vendor using the order acknowledgement API.

-   If using Amazon own shipping labels, sending item information or package information in the request is optional.

### Country Specific Business Requirements 

No country specific requirements exist.

### submitShippingLabelRequest Request

To request shipping labels, call the [submitShippingLabelRequest](https://github.com/amzn/selling-partner-api-docs/blob/main/references/vendor-direct-fulfillment-shipping-api/vendorDirectFulfillmentShippingV1.md#submitshippinglabelrequest) operation and pass the following parameters:

Body parameters:

<table>
  <thead>
    <tr class="header">
      <th>
        <p>
          <b>Name</b>
        </p>
      </th>
      <th>
        <p>
          <b>Description</b>
        </p>
      </th>
      <th>
        <b>Required</b>
      </th>
    </tr>
  </thead>
  <tbody>
    <tr class="odd">
      <td>shippingLabelRequests</td>
      <td>Request one or more shipping labels.
        <p>Type: &lt;
          <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/vendor-direct-fulfillment-shipping-api/vendorDirectFulfillmentShippingV1.md#shippinglabelrequest">ShippingLabelRequest</a>
          &gt; array
        </p>
      </td>
      <td>Yes</td>
    </tr>
  </tbody>
</table>


Request example:

```
POST "https://sellingpartnerapi-na.amazon.com/vendor/directFulfillment/shipping/v1/shippingLabels"
{
  "shippingLabelRequests": [
    {
      "purchaseOrderNumber": "2JK3S9VC",
      "sellingParty": {
        "partyId": "999US"
      },
      "shipFromParty": {
        "partyId": "ABCD"
      },
      "containers": [
        {
          "containerType": "carton",
          "containerIdentifier": "123",
          "trackingNumber": "XXXX",
          "dimensions": {
            "length": "12",
            "width": "12",
            "height": "12",
            "unitOfMeasure": "IN"
          },
          "weight": {
            "unitOfMeasure": "KG",
            "value": "10"
          },
          "packedItems": [
            {
              "itemSequenceNumber": 1,
              "buyerProductIdentifier": "B07DFVDRAB",
              "packedQuantity": {
                "amount": 1,
                "unitOfMeasure": "Each"
              }
            }
          ]
        }
      ]
    }
  ]
}
```

### submitShippingLabelRequest Response

A successful response includes the following:

<table>
  <thead>
    <tr class="header">
      <th>
        <b>Name</b>
      </th>
      <th>
        <p>
          <b>Description</b>
        </p>
      </th>
      <th>
        <b>Required</b>
      </th>
    </tr>
  </thead>
  <tbody>
    <tr class="odd">
      <td>
        <b>transactionId</b>
      </td>
      <td>GUID to identify this transaction. This value can be used with the Transaction Status API to return the status of this transaction.
        <p>Type: string</p>
      </td>
      <td>No</td>
    </tr>
  </tbody>
</table>

Response example:

```json
{
  "transactionId": "20190905010908-8a3b6901-ef20-412f-9270-21c021796605"
}
```



Get Shipping Labels
-------------------

The [getShippingLabels](https://github.com/amzn/selling-partner-api-docs/blob/main/references/vendor-direct-fulfillment-shipping-api/vendorDirectFulfillmentShippingV1.md#getShippingLabels) operation returns shipping labels for all orders which meet the filter criteria specified in the request. You must have already requested shipping labels using the [submitShippingLabelRequest](https://github.com/amzn/selling-partner-api-docs/blob/main/references/vendor-direct-fulfillment-shipping-api/vendorDirectFulfillmentShippingV1.md#submitshippinglabelrequest) operation before you use this API to get shipping labels available to you for fulfillment. Amazon recommends that vendors check for shipping labels at least once per hour during business hours. Depending on your business volume, you may choose to check more frequently. You can get up to 100 shipping labels in one API call. If there are more than 100 shipping labels you can use the nextToken value to get the next set of shipping labels.

The following diagram shows the integration workflow when retrieving shipping labels:

<img src="./media/GetShipLabels.png" alt="Direct Fulfillment integration workflow when retrieving shipping labels" style="width:2.44654in;height:3.056in" />

### getShippingLabels Request

To retrieve a list of shipping labels, call the [getShippingLabels](https://github.com/amzn/selling-partner-api-docs/blob/main/references/vendor-direct-fulfillment-shipping-api/vendorDirectFulfillmentShippingV1.md#getShippingLabels) operation and pass the following parameters:

Query parameters:

<table>
  <thead>
    <tr class="header">
      <th>
        <b>Name</b>
      </th>
      <th>
        <b>Description</b>
      </th>
      <th>
        <b>Required</b>
      </th>
    </tr>
  </thead>
  <tbody>
    <tr class="odd">
      <td>shipFromPartyId</td>
      <td>The vendor warehouseId from which the order will be fulfilled. If not specified, the result will contain orders for all warehouses.
        <p>Type: string</p>
      </td>
      <td>No</td>
    </tr>
    <tr class="even">
      <td>limit</td>
      <td>The limit to the number of records returned.
        <p>Type: integer</p>
      </td>
      <td>No</td>
    </tr>
    <tr class="odd">
      <td>createdAfter</td>
      <td>Shipping labels that became available after this date and time will be included in the result. Must be in ISO-8601 date/time format.
        <p>Type: string (date-time)</p>
      </td>
      <td>Yes</td>
    </tr>
    <tr class="even">
      <td>createdBefore</td>
      <td>Shipping labels that became available before this date and time will be included in the result. Must be in ISO-8601 date/time format.
        <p>Type: string (date-time)</p>
      </td>
      <td>Yes</td>
    </tr>
    <tr class="odd">
      <td>sortOrder</td>
      <td>Sort ASC or DESC by order creation date.
        <p>Type: enum (
          <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/vendor-direct-fulfillment-shipping-api/vendorDirectFulfillmentShippingV1.md#sortorder-subgroup-2">SortOrder</a>
          )
        </p>
      </td>
      <td>No</td>
    </tr>
    <tr class="even">
      <td>nextToken</td>
      <td>Used for pagination when there are more ship labels than the specified result size limit. The token value is returned in the previous API call.
        <p>Type: string</p>
      </td>
      <td>No</td>
    </tr>
  </tbody>
</table>


Request example:

```
GET https://sellingpartnerapi-na.amazon.com/vendor/directFulfillment/shipping/v1/shippingLabels?limit=2&createdAfter=2020-02-15T14:00:00-08:00&createdBefore=2020-02-20T00:00:00-08:00&sortOrder=DESC
```

### getShippingLabels Response

A successful response includes the following:

<table>
  <thead>
    <tr class="header">
      <th>
        <b>Name</b>
      </th>
      <th>
        <b>Description</b>
      </th>
      <th>
        <b>Required</b>
      </th>
    </tr>
  </thead>
  <tbody>
    <tr class="odd">
      <td>pagination</td>
      <td>If more than 100 ship labels are returned, nextToken is returned in the response for pagination.
        <p>Type: string</p>
      </td>
      <td>No</td>
    </tr>
    <tr class="even">
      <td>shippingLabels</td>
      <td>List of ship labels.
        <p>Type: &lt;
          <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/vendor-direct-fulfillment-shipping-api/vendorDirectFulfillmentShippingV1.md#shippinglabel">ShippingLabel</a>
          &gt; array
        </p>
      </td>
      <td>No</td>
    </tr>
  </tbody>
</table>


Response example:

```json
{
  "pagination": {
    "nextToken": "MDAwMDAwMDAwMQ=="
  },
  "shippingLabels": [
    {
      "purchaseOrderNumber": "2JK3S9VC",
      "sellingParty": {
        "partyId": "999US"
      },
      "shipFromParty": {
        "partyId": "ABCD"
      },
      "labelFormat": "PNG",
      "labelData": [
        {
          "packageIdentifier": "PKG001",
          "trackingNumber": "1Z6A34Y60369738804",
          "shipMethod": "UPS_GR_RES",
          "shipMethodName": "UPS Ground Residential",
          "content": "Base 64 encoded string goes here "
        }
      ]
    }, {
      "purchaseOrderNumber": "2JK3S9VD",
      "sellingParty": {
        "partyId": "999US"
      },
      "shipFromParty": {
        "partyId": "ABCD"
      },
      "labelFormat": "PNG",
      "labelData": [
        {
          "packageIdentifier": "PKG002",
          "trackingNumber": "1Z6A34Y60369738805",
          "shipMethod": "UPS_GR_RES",
          "shipMethodName": "UPS Ground Residential",
          "content": "Base 64 encoded string goes here "
        }
      ]
    }
  ]
}
```



Get Shipping Label
------------------

The [getShippingLabel](https://github.com/amzn/selling-partner-api-docs/blob/main/references/vendor-direct-fulfillment-shipping-api/vendorDirectFulfillmentShippingV1.md#getshippinglabel) operation returns information about the shipping label that you specify using the purchase order number. The response includes complete shipping label information for the purchase order, including label type, purchase order details and ship method.

You can also use this API to get details for any shipping label (in the time range of 7 days from a rolling window of last 6 months, after the vendor went live on API).

The following diagram shows the integration workflow for retrieving a specific shipping label:

<img src="./media/GetShipLabel.png" alt="Direct Fulfillment integration workflow for retrieving a specific shipping label" style="width:2.712in;height:3.08478in" />

### Business Requirements

-   **What kind of labels are available to download?**

Both ZPL and PNG file format labels are supported. Label content is provided in base64 string format so you can convert the string into desired label format. The choice of label format is with the vendor and they decide this as part of on-boarding process into direct fulfillment program.

-   **By when the shipping label should be requested?**

ZPL and PNG labels should be requested only on the day when the orders are due for shipping.

### Country Specific Business Requirements 

There are no country specific requirements for shipping label responses.

### getShippingLabel Request

To request a shipping label, call the [getShippingLabel](https://github.com/amzn/selling-partner-api-docs/blob/main/references/vendor-direct-fulfillment-shipping-api/vendorDirectFulfillmentShippingV1.md#getshippinglabel) operation and pass the following parameters:

Path parameters:

<table>
  <thead>
    <tr class="header">
      <th>
        <b>Name</b>
      </th>
      <th>
        <b>Description</b>
      </th>
      <th>
        <b>Required</b>
      </th>
    </tr>
  </thead>
  <tbody>
    <tr class="odd">
      <td>
        <b>purchaseOrderNumber</b>
      </td>
      <td>The purchase order number for which you want to return the shipping label. It should be the same purchaseOrderNumber as received in the order message.
        <p>Type: string</p>
      </td>
      <td>Yes</td>
    </tr>
  </tbody>
</table>


Request example:

```
GET https://sellingpartnerapi-na.amazon.com/vendor/directFulfillment/shipping/v1/shippingLabels/2JK3S9VC
```

### getShippingLabel Response

A successful response includes the following:

<table>
  <thead>
    <tr class="header">
      <th>
        <b>Name</b>
      </th>
      <th>
        <b>Description</b>
      </th>
      <th>
        <b>Required</b>
      </th>
    </tr>
  </thead>
  <tbody>
    <tr class="odd">
      <td>
        <b>purchaseOrderNumber</b>
      </td>
      <td>This field will contain the Purchase Order Number for this order.
        <p>Type: string</p>
      </td>
      <td>Yes</td>
    </tr>
    <tr class="even">
      <td>
        <b>sellingParty</b>
      </td>
      <td>ID of the selling party or vendor.
        <p>Type:
          <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/vendor-direct-fulfillment-shipping-api/vendorDirectFulfillmentShippingV1.md#partyidentification">PartyIdentification</a>
        </p>
      </td>
      <td>Yes</td>
    </tr>
    <tr class="odd">
      <td>
        <b>shipFromParty</b>
      </td>
      <td>Warehouse code of vendor.
        <p>Type:
          <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/vendor-direct-fulfillment-shipping-api/vendorDirectFulfillmentShippingV1.md#partyidentification">PartyIdentification</a>
        </p>
      </td>
      <td>Yes</td>
    </tr>
    <tr class="even">
      <td>
        <b>labelFormat</b>
      </td>
      <td>Format of the label.
        <p>enum (
          <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/vendor-direct-fulfillment-shipping-api/vendorDirectFulfillmentShippingV1.md">LabelFormat</a>
          )
        </p>
      </td>
      <td>Yes</td>
    </tr>
    <tr class="odd">
      <td>
        <b>labelData</b>
      </td>
      <td>Provides the details of the packages in this shipment.
        <p>Type: &lt;
          <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/vendor-direct-fulfillment-shipping-api/vendorDirectFulfillmentShippingV1.md">LabelData</a>
          &gt; array
        </p>
      </td>
      <td>Yes</td>
    </tr>
  </tbody>
</table>


Response example:

```json
{
  "purchaseOrderNumber": "2JK3S9VC",
  "sellingParty": {
    "partyId": "999US"
  },
  "shipFromParty": {
    "partyId": "ABCD"
  },
  "labelFormat": "PNG",
  "labelData": [
    {
      "packageIdentifier": "PKG001",
      "trackingNumber": "1Z6A34Y60369738804",
      "shipMethod": "UPS_GR_RES",
      "shipMethodName": "UPS Ground Residential",
      "content": "Base 64 encoded string goes here"
    }
  ]
}
```


Submit Shipment Confirmations
-----------------------------

The [submitShipmentConfirmations](https://github.com/amzn/selling-partner-api-docs/blob/main/references/vendor-direct-fulfillment-shipping-api/vendorDirectFulfillmentShippingV1.md#submitshipmentconfirmations) operation lets vendors submit shipment confirmations to Amazon. Your shipment confirmation allows us to efficiently track your shipments and inform our customers. It contains information about the items being shipped, including purchase order number, ship date, estimated delivery date, and tracking number.

Shipment confirmations allow us to collaborate more effectively with carriers in tracking your shipments.

The lack of valid shipment confirmations can result in:

-   Inadequate visibility about shipments.

-   Errors in reconciling the physical shipments with purchase orders.

-   Manual follow-ups to resolve discrepancies.

### Verification of successfully submitted Shipment Confirmations

Vendors can verify the status of their shipment confirmations via "Vendor Central &gt;Orders&gt; Direct Fulfillment Orders" or using the Direct Fulfillment Transaction Status API. Allow the system up to 10 min to see the status once submitted. If Vendor Central is not showing the correct values for the shipment confirmation, open a "Contact Us" case in Vendor Central. Refer to the Business Requirements section for information about creating shipment confirmations.

The following diagram shows the integration workflow for submitting shipment confirmations:

<img src="./media/ShipmentConfirmationWorkflow.png" alt="Direct Fulfillment integration workflow for submitting shipment confirmations" style="width:2.968in;height:6.76848in" />

### Business Requirements

-   You should use this API to confirm shipment of an order within 4 hours after the order has shipped from your warehouse.

-   For floor denied shipments, set the "shipmentStatus" field value to "FLOOR\_DENIAL".

-   All the purchase order line items should be present in the shipment confirmation. Partial order fulfillment is not allowed. Vendors should reject the order as floor denial if any of the line items are not available to fulfill.

-   The "itemSequenceNumber" for an item should be the same as was received in the order message.

-   Either "buyerProductIdentifier" or "vendorProductIdentifier" is mandatory to send in the shipment confirmation. You need to send the same value as received in the purchase order.

-   For vendor own carriers, sending "scacCode" is mandatory.

-   If the shipment label is provided by Amazon, then the container section is optional since Amazon has access to the package information. Items section is mandatory to submit.

### Country Specific Business Requirements 

None

### submitShipmentConfirmations Request

To submit shipment confirmations, call the [submitShipmentConfirmations](https://github.com/amzn/selling-partner-api-docs/blob/main/references/vendor-direct-fulfillment-shipping-api/vendorDirectFulfillmentShippingV1.md#submitshipmentconfirmations) operation and pass the following parameters:

Body parameters:

<table>
  <thead>
    <tr class="header">
      <th>
        <b>Name</b>
      </th>
      <th>
        <b>Description</b>
      </th>
      <th>
        <b>Required</b>
      </th>
    </tr>
  </thead>
  <tbody>
    <tr class="odd">
      <td>shipmentConfirmations</td>
      <td>List of confirmed shipments
        <p>Type: &lt;
          <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/vendor-direct-fulfillment-shipping-api/vendorDirectFulfillmentShippingV1.md#shipmentconfirmation">ShipmentConfirmation</a>
          &gt; array
        </p>
      </td>
      <td>Yes</td>
    </tr>
  </tbody>
</table>


Request example:

```plain
POST https://sellingpartnerapi-na.amazon.com/vendor/directFulfillment/shipping/v1/shipmentConfirmations
```
```json
{
  "shipmentConfirmations": [
    {
      "purchaseOrderNumber": "PO00050003",
      "shipmentDetails": {
        "shippedDate": "2019-08-07T19:56:45.632Z",
        "shipmentStatus": "SHIPPED",
        "isPriorityShipment": true,
        "estimatedDeliveryDate": "2019-08-07T19:56:45.632Z"
      },
      "sellingParty": {
        "partyId": "VENDORCODE"
      },
      "shipFromParty": {
        "partyId": "VENDORWAREHOUSECODE"
      },
      "items": [
        {
          "itemSequenceNumber": 1,
          "buyerProductIdentifier": "ASIN001",
          "vendorProductIdentifier": "9782700001659",
          "shippedQuantity": {
            "amount": 100,
            "unitOfMeasure": "Each"
          }
        },
        {
          "itemSequenceNumber": 2,
          "buyerProductIdentifier": "ASIN002",
          "vendorProductIdentifier": "9782700001659",
          "shippedQuantity": {
            "amount": 100,
            "unitOfMeasure": "Each"
          }
        },
        {
          "itemSequenceNumber": 3,
          "buyerProductIdentifier": "ASIN003",
          "vendorProductIdentifier": "9782700001659",
          "shippedQuantity": {
            "amount": 100,
            "unitOfMeasure": "Each"
          }
        },
        {
          "itemSequenceNumber": 4,
          "buyerProductIdentifier": "ASIN004",
          "vendorProductIdentifier": "9782700001659",
          "shippedQuantity": {
            "amount": 100,
            "unitOfMeasure": "Each"
          }
        }
      ],
      "containers": [
        {
          "containerType": "carton",
          "containerIdentifier": "123",
          "trackingNumber": "TRACK001",
          "scacCode": "SCAC001",
          "carrier": "ABCD001",
          "shipMethod": "UPS",
          "dimensions": {
            "length": "10",
            "width": "10",
            "height": "10",
            "unitOfMeasure": "IN"
          },
          "weight": {
            "unitOfMeasure": "KG",
            "value": "10"
          },
          "packedItems": [
            {
              "itemSequenceNumber": 1,
              "buyerProductIdentifier": "ASIN001",
              "packedQuantity": {
                "amount": 100,
                "unitOfMeasure": "Each"
              }
            }
          ]
        },
        {
          "containerType": "carton",
          "containerIdentifier": "234",
          "trackingNumber": "TRACK002",
          "scacCode": "SCAC001",
          "carrier": "ABCD001",
          "shipMethod": "UPS",
          "dimensions": {
            "length": "10",
            "width": "10",
            "height": "10",
            "unitOfMeasure": "IN"
          },
          "weight": {
            "unitOfMeasure": "KG",
            "value": "10"
          },
          "packedItems": [
            {
              "itemSequenceNumber": 2,
              "buyerProductIdentifier": "ASIN002",
              "packedQuantity": {
                "amount": 100,
                "unitOfMeasure": "Each"
              }
            }
          ]
        },
        {
          "containerType": "carton",
          "containerIdentifier": "ABCD",
          "trackingNumber": "TRACK003",
          "scacCode": "SCAC001",
          "carrier": "ABCD001",
          "shipMethod": "UPS",
          "dimensions": {
            "length": "10",
            "width": "10",
            "height": "10",
            "unitOfMeasure": "IN"
          },
          "weight": {
            "unitOfMeasure": "KG",
            "value": "10"
          },
          "packedItems": [
            {
              "itemSequenceNumber": 3,
              "buyerProductIdentifier": "ASIN003",
              "packedQuantity": {
                "amount": 100,
                "unitOfMeasure": "Each"
              }
            }
          ]
        },
        {
          "containerType": "carton",
          "containerIdentifier": "id12",
          "trackingNumber": "TRACK004",
          "scacCode": "SCAC001",
          "carrier": "ABCD001",
          "shipMethod": "UPS",
          "dimensions": {
            "length": "10",
            "width": "10",
            "height": "10",
            "unitOfMeasure": "IN"
          },
          "weight": {
            "unitOfMeasure": "KG",
            "value": "10"
          },
          "packedItems": [
            {
              "itemSequenceNumber": 4,
              "buyerProductIdentifier": "ASIN004",
              "packedQuantity": {
                "amount": 100,
                "unitOfMeasure": "Each"
              }
            }
          ]
        }
      ]
    }
  ]
}
```


### submitShipmentConfirmations Response

A successful response includes the following:

<table>
  <thead>
    <tr class="header">
      <th>
        <b>Name</b>
      </th>
      <th>
        <b>Description</b>
      </th>
      <th>
        <b>Required</b>
      </th>
    </tr>
  </thead>
  <tbody>
    <tr class="odd">
      <td>transactionId</td>
      <td>GUID to identify this transaction. This value can be used with the Transaction Status API to return the status of this transaction.
        <p>Type: string</p>
      </td>
      <td>Yes</td>
    </tr>
  </tbody>
</table>


Response example:

```json
{
  "transactionId": "20190905010908-8a3b6901-ef20-412f-9270-21c021796605"
}
```

Submit Shipment Status Updates
------------------------------

**IMPORTANT**: Shipment Status Updates are only to be used by VOC (Vendor Own Carrier) vendors. This means vendors that use their own carrier for shipment delivery and do not use Amazon carriers to transport the shipment to the customer. Vendors will ultimately cover the transportation costs and the responsibility to deliver the shipment to customer.

The [submitShipmentStatusUpdates](https://github.com/amzn/selling-partner-api-docs/blob/main/references/vendor-direct-fulfillment-shipping-api/vendorDirectFulfillmentShippingV1.md#submitshipmentstatusupdates) operation allows vendors to update the transportation status event for shipments that are on route to the final customer. VOC vendors are required to update shipment status (commonly known as scans) during the transportation phase.

This information will then be forwarded to Amazon customers on the "your Orders" page and thus will improve visibility on the order tracking and delivery process.

Failure to update shipment status updates can result in bad operational KPIs such as low scan rate and eventually warehouse suspension.

### Verification of successfully submitted Shipment Status Updates

Vendors can verify the status of their shipment status updates via "Vendor Central &gt;Orders&gt; Direct Fulfillment Orders" or by using the Direct Fulfillment Transaction Status API. Allow the system up to 10 min to see the status once submitted. If Vendor Central is not showing the correct values for the shipment confirmation, open a "Contact Us" case in Vendor Central. Refer to the Business Requirements section for information about creating shipment confirmations.

The following diagram shows the integration workflow for submitting shipment status updates:

<img src="./media/ShipmentStatusUpdates.png" alt="Direct Fulfillment integration workflow for submitting shipment status updates" style="width:4.20833in;height:5.57569in" />

### Business Requirements

-   You should use this API only if you use your own carrier to transport the shipment to the customer i.e. you are a VOC (Vendor Own Carrier) vendor.

-   You should only use this API to update the status of a shipment after the shipment is confirmed via shipment confirmation API or Vendor Central shipment confirmation.

-   The trackingNumber in the shipment status API should match 100% with the trackingNumber provided in the shipment confirmation, otherwise shipment status update will fail.

-   One Shipment Status Update API call should correspond to one physical package. You can update the shipment status for several packages in one API call by batching them as an array of Shipment Status Updates.

-   A direct fulfillment order can result in several physical packages to be delivered to the customer. Thus, several shipment status updates are needed to reflect the full shipment status of the complete order.

-   Vendors should send shipment status whenever possible following the Amazon Shipment Status guidelines.

-   For scheduled delivery orders, vendors should send the "*shipmentSchedule"* array that specifies estimated delivery time and delivery window.

### Country Specific Business Requirements 

None

### Additional Fields Explanation

**1) "statusCode" and "reasonCode"**

These fields are standard codes used in EDI standards (for example, ISA X12 and EDIFACT) that are used to provide a specific status event and the reason for the status event. We expect a specific combination of "statusCode" and "reasonCode" that determine an event within the shipment transportation phase to the end customer.

These are the status and reason codes we support and their equivalency to current Vendor Central:

| **EDIFACT Status Code** | **EDIFACT Reason Code** | **Operational Description**                           | **Vendor Central UI Equivalency** |
|-------------------------|-------------------------|-------------------------------------------------------|-----------------------------------|
| 404                     | 117                     | Shipment is delayed because of a large scale accident | DELAYED                           |
| 301                     | 000                     | Shipment delivered to customer                        | DELIVERED                         |
| 101                     | 000                     | Shipment has departed the FC                          | DEPARTED\_FROM\_FC                |
| 201                     | 000                     | Shipment arrived at a carrier facility                | IN\_TRANSIT                       |
| 409                     | 000                     | Carrier lost the shipment                             | LOST                              |
| 302                     | 000                     | Shipment is out for delivery                          | OUT\_FOR\_DELIVERY                |
| 407                     | 000                     | Recipient refused to accept the shipment              | REJECTED                          |
| 416                     | 000                     | Shipment is undeliverable and will be destroyed       | UNDELIVERABLE                     |

| **X12 Status Code** | **X12 Reason Code** | **Operational Description**                           | **Vendor Central UI Equivalency** |
|---------------------|---------------------|-------------------------------------------------------|-----------------------------------|
| DE                  | AF                  | Shipment is delayed because of a large scale accident | DELAYED                           |
| D1                  | NS                  | Shipment delivered to customer                        | DELIVERED                         |
| XB                  | NS                  | Shipment has departed the FC                          | DEPARTED\_FROM\_FC                |
| O1                  | NS                  | Shipment arrived at a carrier facility                | IN\_TRANSIT                       |
| CA                  | PL                  | Carrier lost the shipment                             | LOST                              |
| OD                  | NS                  | Shipment is out for delivery                          | OUT\_FOR\_DELIVERY                |
| A7                  | AM                  | Recipient refused to accept the shipment              | REJECTED                          |
| AP                  | BG                  | Shipment is undeliverable and will be destroyed       | UNDELIVERABLE                     |

### submitShipmentStatusUpdates Request

To submit shipment status updates, call the [submitShipmentStatusUpdates](https://github.com/amzn/selling-partner-api-docs/blob/main/references/vendor-direct-fulfillment-shipping-api/vendorDirectFulfillmentShippingV1.md#submitshipmentstatusupdates) operation and pass the following parameters:

Body parameters:

<table>
  <thead>
    <tr class="header">
      <th>
        <b>Name</b>
      </th>
      <th>
        <b>Description</b>
      </th>
      <th>
        <b>Required</b>
      </th>
    </tr>
  </thead>
  <tbody>
    <tr class="odd">
      <td>shipmentStatusUpdates</td>
      <td>List of confirmed shipments.
        <p>Type: &lt;
          <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/vendor-direct-fulfillment-shipping-api/vendorDirectFulfillmentShippingV1.md#shipmentstatusupdate">ShipmentStatusUpdate</a>
          &gt; array
        </p>
      </td>
      <td>Yes</td>
    </tr>
  </tbody>
</table>


Request example:

```
POST https://sellingpartnerapi-na.amazon.com/ /vendor/directFulfillment/shipping/v1/shipmentStatusUpdates
{
  "shipmentStatusUpdates": [
    {
      "purchaseOrderNumber": "DX00050015",
      "sellingParty": {
        "partyId": "999US"
      },
      "shipFromParty": {
        "partyId": "ABCD"
      },
      "statusUpdateDetails": {
        "trackingNumber": "TRACK005",
        "statusCode": "D1",
        "reasonCode": "NS",
        "statusDateTime": "2020-08-07T19:56:45Z",
        "statusLocationAddress": {
          "city": "Seattle",
          "postalCode": "98101",
          "stateOrRegion": "Washington",
          "countryCode": "US"
        }
      }
    }
  ]
}
```

### submitShipmentStatusUpdates Response

A successful response includes the following:

<table>
  <thead>
    <tr class="header">
      <th>
        <b>Name</b>
      </th>
      <th>
        <b>Description</b>
      </th>
      <th>
        <b>Required</b>
      </th>
    </tr>
  </thead>
  <tbody>
    <tr class="odd">
      <td>transactionId</td>
      <td>GUID to identify this transaction. This value can be used with the Transaction Status API to return the status of this transaction.
        <p>Type: string</p>
      </td>
      <td>Yes</td>
    </tr>
  </tbody>
</table>


Response example:

```json
{
  "transactionId": "20190905010908-8a3b6901-ef20-412f-9270-21c021796605"
}
```



Get Packing Slips
-----------------

The [getPackingSlips](https://github.com/amzn/selling-partner-api-docs/blob/main/references/vendor-direct-fulfillment-shipping-api/vendorDirectFulfillmentShippingV1.md#getPackingSlips) operation returns a list of packing slips for the orders which meet the criteria specified. If you need to get a packing slip for a specific order, use the [getPackingSlip](https://github.com/amzn/selling-partner-api-docs/blob/main/references/vendor-direct-fulfillment-shipping-api/vendorDirectFulfillmentShippingV1.md#getpackingslip) operation instead.

You should use this API to get packing slips for the purchase orders available to you for fulfillment. Amazon recommends that vendors check for orders at least once per hour during business hours. Depending on your business volume, you may choose to check more frequently. You can get up to 100 packing slips in one API call. If there are more than 100 packing slips, you can use the nextToken value as a parameter in your next request to get the next set.

The following diagram shows the integration workflow when retrieving packing slips:

<img src="./media/GetPackingSlips.png" alt="Direct Fulfillment integration workflow when retrieving packing slips" style="width:2.55399in;height:2.81613in" />

### getPackingSlips Request

To retrieve packing slips, call the [getPackingSlips](https://github.com/amzn/selling-partner-api-docs/blob/main/references/vendor-direct-fulfillment-shipping-api/vendorDirectFulfillmentShippingV1.md#getPackingSlips) operation and pass the following parameters:

Query parameters:

<table>
  <thead>
    <tr class="header">
      <th>
        <b>Name</b>
      </th>
      <th>
        <b>Description</b>
      </th>
      <th>
        <b>Required</b>
      </th>
    </tr>
  </thead>
  <tbody>
    <tr class="odd">
      <td>shipFromPartyId</td>
      <td>The vendor warehouseId from which the order will be fulfilled. If not specified the result will contain orders for all warehouses.
        <p>Type: string</p>
      </td>
      <td>No</td>
    </tr>
    <tr class="even">
      <td>limit</td>
      <td>The limit to the number of records returned.
        <p>Type: integer</p>
      </td>
      <td>No</td>
    </tr>
    <tr class="odd">
      <td>createdAfter</td>
      <td>Packing slips that became available after this date and time will be included in the result. Must be in ISO-8601 date/time format.
        <p>Type: string (date-time)</p>
      </td>
      <td>Yes</td>
    </tr>
    <tr class="even">
      <td>createdBefore</td>
      <td>Packing slips that became available before this date and time will be included in the result. Must be in ISO-8601 date/time format.
        <p>Type: string (date-time)</p>
      </td>
      <td>Yes</td>
    </tr>
    <tr class="odd">
      <td>sortOrder</td>
      <td>Sort ASC or DESC by packing slip creation date.
        <p>Type: enum (
          <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/vendor-direct-fulfillment-shipping-api/vendorDirectFulfillmentShippingV1.md#sortorder-subgroup-1">SortOrder</a>
          )
        </p>
      </td>
      <td>No</td>
    </tr>
    <tr class="even">
      <td>nextToken</td>
      <td>Used for pagination when there are more orders than the specified result size limit. The token value is returned in the previous API call.
        <p>Type: string</p>
      </td>
      <td>No</td>
    </tr>
  </tbody>
</table>


Request example:

```
GET https://sellingpartnerapi-na.amazon.com/vendor/directFulfillment/shipping/v1/packingSlips?createdBefore=2020-06-12T12:00:00-08:00&createdAfter=2020-06-12T00:00:00-08:00&limit=2&sortOrder=DESC
```

### getPackingSlips Response

A successful response includes the following:

<table>
  <thead>
    <tr class="header">
      <th>
        <b>Name</b>
      </th>
      <th>
        <b>Description</b>
      </th>
      <th>
        <b>Required</b>
      </th>
    </tr>
  </thead>
  <tbody>
    <tr class="odd">
      <td>pagination</td>
      <td>If more than 100 orders are returned, nextToken is returned in the response for pagination.
        <p>Type: string</p>
      </td>
      <td>No</td>
    </tr>
    <tr class="even">
      <td>packingSlips</td>
      <td>Includes details for the packing slips.
        <p>Type: &lt;
          <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/vendor-direct-fulfillment-shipping-api/vendorDirectFulfillmentShippingV1.md#packingslip">PackingSlip</a>
          &gt; array
        </p>
      </td>
      <td>No</td>
    </tr>
  </tbody>
</table>


Response example:

```json
{
  "payload": {
    "pagination": {
      "nextToken": "NEBxNEBxNEBxNR=="
    },
    "packingSlips": [
      {
        "purchaseOrderNumber": "UvgABdBjQ",
        "content": "base64 encoded string",
        "contentType": "application/pdf"
      }, {
        "purchaseOrderNumber": "VvgCDdBjR",
        "content": "base64 encoded string",
        "contentType": "application/pdf"
      }
    ]
  }
}
```



Get Packing Slip
----------------

The [getPackingSlip](https://github.com/amzn/selling-partner-api-docs/blob/main/references/vendor-direct-fulfillment-shipping-api/vendorDirectFulfillmentShippingV1.md#getpackingslip) operation returns information about the specific packing slip that you specify using the purchase order number. The response includes a base64 encoded string of the packing slip. The content type will always be "application/pdf".

The following diagram shows the integration workflow when retrieving a packing slip:

<img src="./media/GetPackingSlip.png" alt="Direct Fulfillment integration workflow when retrieving a packing slip" style="width:2.24813in;height:2.47887in" />

### Business Requirements

-   **Are packing slips required for all orders?**

A packing slip is required only if it is for a Business to Business \[B2B\] order or a gift order. When the value of the "isPslipRequired" field is true, a packing slip is required for the order.

### getPackingSlip Request

To return a packing slip, call the [getPackingSlip](https://github.com/amzn/selling-partner-api-docs/blob/main/references/vendor-direct-fulfillment-shipping-api/vendorDirectFulfillmentShippingV1.md#getpackingslip) operation and pass the following parameters:

Path parameters:

<table>
  <thead>
    <tr class="header">
      <th>
        <b>Name</b>
      </th>
      <th>
        <b>Description</b>
      </th>
      <th>
        <b>Required</b>
      </th>
    </tr>
  </thead>
  <tbody>
    <tr class="odd">
      <td>purchaseOrderNumber</td>
      <td>The purchaseOrderNumber for the packing slip you want.
        <p>Type: string</p>
      </td>
      <td>Yes</td>
    </tr>
  </tbody>
</table>


Request example:

```
GET https://sellingpartnerapi-na.amazon.com /vendor/directFulfillment/shipping/v1/packingSlips/UkP3YkKDr
```

### getPackingSlip Response

A successful response includes the following:

<table>
  <thead>
    <tr class="header">
      <th>
        <b>Name</b>
      </th>
      <th>
        <b>Description</b>
      </th>
      <th>
        <b>Required</b>
      </th>
    </tr>
  </thead>
  <tbody>
    <tr class="odd">
      <td>purchaseOrderNumber</td>
      <td>Purchase order number of the shipment.
        <p>Type: string</p>
      </td>
      <td>No</td>
    </tr>
    <tr class="even">
      <td>packingSlip</td>
      <td>
        <p>Packing slip information.</p>
        <p>Type:
          <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/vendor-direct-fulfillment-shipping-api/vendorDirectFulfillmentShippingV1.md#packingslip">PackingSlip</a>
        </p>
      </td>
      <td>No</td>
    </tr>
  </tbody>
</table>


Response example:

```json
{
  "payload": {
    "purchaseOrderNumber": "UvgABdBjQ",
    "content": "base64 encoded string",
    "contentType": "application/pdf"
  }
}
```



Get Customer Invoices
---------------------

The [getCustomerInvoices](https://github.com/amzn/selling-partner-api-docs/blob/main/references/vendor-direct-fulfillment-shipping-api/vendorDirectFulfillmentShippingV1.md#getCustomerInvoices) operation returns customer invoices for all purchase orders which meet the filter criteria you specify. The use of this API is mandatory only in the India region and not required in any other region. Amazon recommends that vendors check for customer invoices at least once per hour during business hours. Depending on your business volume, you may choose to check more frequently. You can get up to 100 customer invoices in one API call. If there are more than 100 customer invoices you can use the nextToken value as a parameter in the next request to get the next set of customer invoices.

The following diagram shows the integration workflow when retrieving customer invoices:

<img src="./media/GetInvoices.png" alt="Direct Fulfillment integration workflow when retrieving customer invoices" style="width:2.696in;height:3.15923in" />

### getCustomerInvoices Request

To return customer invoices, call the [getCustomerInvoices](https://github.com/amzn/selling-partner-api-docs/blob/main/references/vendor-direct-fulfillment-shipping-api/vendorDirectFulfillmentShippingV1.md#getCustomerInvoices) operation and pass the following parameters:

Query parameters:

<table>
  <thead>
    <tr class="header">
      <th>
        <b>Name</b>
      </th>
      <th>
        <b>Description</b>
      </th>
      <th>
        <b>Required</b>
      </th>
    </tr>
  </thead>
  <tbody>
    <tr class="odd">
      <td>shipFromPartyId</td>
      <td>The vendor warehouseId from which the order will be fulfilled. If not specified, the result will contain orders for all warehouses.
        <p>Type: string</p>
      </td>
      <td>No</td>
    </tr>
    <tr class="even">
      <td>limit</td>
      <td>The limit to the number of records returned.
        <p>Type: integer</p>
      </td>
      <td>No</td>
    </tr>
    <tr class="odd">
      <td>createdAfter</td>
      <td>Orders that became available after this date and time will be included in the result. Must be in ISO-8601 date/time format.
        <p>Type: string (date-time)</p>
      </td>
      <td>Yes</td>
    </tr>
    <tr class="even">
      <td>createdBefore</td>
      <td>Orders that became available before this date and time will be included in the result. Must be in ISO-8601 date/time format.
        <p>Type: string (date-time)</p>
      </td>
      <td>Yes</td>
    </tr>
    <tr class="odd">
      <td>sortOrder</td>
      <td>Sort ASC or DESC by order creation date.
        <p>Type: enum (
          <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/vendor-direct-fulfillment-shipping-api/vendorDirectFulfillmentShippingV1.md#sortorder-subgroup-2">SortOrder</a>
          )
        </p>
      </td>
      <td>No</td>
    </tr>
    <tr class="even">
      <td>nextToken</td>
      <td>Used for pagination when there are more ship labels than the specified result size limit. The token value is returned in the previous API call.
        <p>Type: string</p>
      </td>
      <td>No</td>
    </tr>
  </tbody>
</table>


Request example:

```
GET https://sellingpartnerapi-na.amazon.com/vendor/directFulfillment/shipping/v1/customerInvoices?limit=2&createdAfter=2020-02-15T14:00:00-08:00&createdBefore=2020-02-20T00:00:00-08:00&sortOrder=DESC
```

### getCustomerInvoices Response

A successful response includes the following:

<table>
  <thead>
    <tr class="header">
      <th>
        <b>Name</b>
      </th>
      <th>
        <b>Description</b>
      </th>
      <th>
        <b>Required</b>
      </th>
    </tr>
  </thead>
  <tbody>
    <tr class="odd">
      <td>pagination</td>
      <td>If more than 100 customer invoices are returned, nextToken is returned in the response for pagination.
        <p>Type: string</p>
      </td>
      <td>No</td>
    </tr>
    <tr class="even">
      <td>customerInvoices</td>
      <td>List of customer invoices.
        <p>Type: &lt;
          <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/vendor-direct-fulfillment-shipping-api/vendorDirectFulfillmentShippingV1.md#customerinvoice">CustomerInvoice</a>
          &gt; array
        </p>
      </td>
      <td>No</td>
    </tr>
  </tbody>
</table>


Response example:

```json
{
  "pagination": {
    "nextToken": "MDAwMDAwMDAwMQ=="
  },
  "customerInvoices": [
    {
      "purchaseOrderNumber": "PO98676856",
      "content": "base 64 content goes here"
    }
  ]
}
```


Get Customer Invoice
--------------------

The [getCustomerInvoice](https://github.com/amzn/selling-partner-api-docs/blob/main/references/vendor-direct-fulfillment-shipping-api/vendorDirectFulfillmentShippingV1.md#getCustomerInvoice) operation returns information about the customer invoice that you specify using the purchase order number. The response includes complete customer invoice information for that purchase order.

You can also use this API to get details for any customer invoice (in the time range of 7 days from a rolling window of the last 6 months, after the vendor went live on the API).

The following diagram shows the integration workflow for returning a customer invoice:

<img src="./media/GetInvoice.png" alt="Direct Fulfillment integration workflow for retrieving a customer invoice" style="width:2.65673in;height:4.264in" />

### Business Requirements

-   **What kind of customer invoices are available to download?**

The customer invoice is a PDF file which is encoded in binary64 string format. All purchase orders for the India region should have a customer invoice created which should be sent with the shipment.

### Country Specific Business Requirements 

Only India region needs to use the customer invoice API.

### getCustomerInvoice Request

To return a customer invoice, call the [getCustomerInvoice](https://github.com/amzn/selling-partner-api-docs/blob/main/references/vendor-direct-fulfillment-shipping-api/vendorDirectFulfillmentShippingV1.md#getCustomerInvoice) operation and pass the following parameters:

Path parameters:

<table>
  <thead>
    <tr class="header">
      <th>
        <b>Name</b>
      </th>
      <th>
        <b>Description</b>
      </th>
      <th>
        <b>Required</b>
      </th>
    </tr>
  </thead>
  <tbody>
    <tr class="odd">
      <td>purchaseOrderNumber</td>
      <td>Purchase order number of the shipment for which to return the invoice.
        <p>Type: string</p>
      </td>
      <td>Yes</td>
    </tr>
  </tbody>
</table>


Request example:

```
GET https://sellingpartnerapi-na.amazon.com/vendor/directFulfillment/shipping/v1/shippingLabels/2JK3S9VC
```

### getCustomerInvoice Response

A successful response includes the following:

<table>
  <thead>
    <tr class="header">
      <th>
        <b>Name</b>
      </th>
      <th>
        <b>Description</b>
      </th>
      <th>
        <b>Required</b>
      </th>
    </tr>
  </thead>
  <tbody>
    <tr class="odd">
      <td>purchaseOrderNumber</td>
      <td>The purchase order number for this order.
        <p>Type: string</p>
      </td>
      <td>Yes</td>
    </tr>
    <tr class="even">
      <td>content</td>
      <td>The Base64-encoded customer invoice.
        <p>Type: string</p>
      </td>
      <td>Yes</td>
    </tr>
  </tbody>
</table>


Response example:

```json
{
  "payload": {
    "purchaseOrderNumber": "PO98676856",
    "content": "base 64 encoded string"
  }
}
```



What is the Direct Fulfillment Payments API?
============================================

Vendors can use the Direct Fulfillment Payments API to exchange payment related documents with Amazon. The submitInvoice operation allows vendors to send vendor invoices to Amazon for confirmed and shipped orders.

The following operations are included in the Payments API:

| **Operation**                                                                                                                                                                    | **HTTP Method** | **Path**                       | **Description**                                       |
|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|-----------------|------------------------------------------------|-------------------------------------------------------|
| [submitInvoice](https://github.com/amzn/selling-partner-api-docs/blob/main/references/vendor-direct-fulfillment-payments-api/vendorDirectFulfillmentPaymentsV1.md#submitinvoice) | POST            | /vendor/directFulfillment/payments/v1/invoices | Submits single or multiple vendor invoices to Amazon. |

Submit Invoices
---------------

The [submitInvoice](https://github.com/amzn/selling-partner-api-docs/blob/main/references/vendor-direct-fulfillment-payments-api/vendorDirectFulfillmentPaymentsV1.md#submitinvoice) operation allows vendors to submit vendor invoices to request payment from Amazon for items shipped. Using this API, vendors can submit multiple invoices in a single API call.

Items should be invoiced only after they are confirmed and shipped to Amazon. Otherwise the invoice will be rejected. An invoice with correct information will be processed by Amazon without any human interaction, which means that the vendor receives payment more quickly. Invoices with incorrect information will be rejected in Amazon's payee system, so sending correct information is very important. See the [business requirements](#business-requirements-4) section to learn how to create invoices with correct information.

### Parallel testing of invoice submission

Vendors need to complete parallel testing with our payments system before they can start using the submitInvoice operation for payment processing. When vendors begin sending their invoices using the API, the parallel testing phase begins. During the parallel testing phase, vendors send both paper and API invoices for all orders shipped. Vendors are required to parallel test until the content of at least 5 to 10 EDI invoice files are validated. Parallel testing is conducted with production POs and invoices. The Amazon API team will contact you when parallel testing is complete, or if there are any content discrepancies in your invoices. When a vendor receives an email saying parallel testing is complete, they no longer need to send paper invoices. From that moment on they can process their payments by sending their invoices using the API.

### Verification of successfully submitted Invoices

The Transaction Status API doesn't show the actual status of invoice processing, it only shows the status of the semantic validations of the submitted invoices. Vendors can verify the actual status of the original/updated version of the invoices via "Vendor Central &gt; Payments &gt; Direct Fulfillment Invoices". For more information on how to use the Transaction Status API, refer to the business use case documentation for Transaction Status. Allow the system to take up to 15 minutes to show the original/updated version once submitted. If Vendor Central is not showing the correct values for the updated invoice, open a "Contact Us" case in Vendor Central.

The following diagram shows the integration workflow for submitting invoices for direct fulfillment confirmed and shipped orders:

<img src="./media/PaymentsWorkflow.png" 
alt="Direct Fulfillment integration workflow for submitting invoices for direct fulfillment confirmed and shipped orders" 
style="width:2.47976in;height:4.76in" />

### Business Requirements 

-   **Invoice numbers** must be unique and they should never be reused (even after one year).

-   If an invoice sent using the API has failed due to incorrect data, but a paper invoice has the correct data, then the vendor should update the invoice through the API with the correct data using the same **Invoice ID**.

-   If an invoice has incorrect data (both paper and API) then the invoice is cancelled and a new invoice should be sent with a new **Invoice ID.**

-   An invoice with a **total amount** = 0 should not be sent, as this would cause the invoice to fail.

-   Amazon requires the full address details in the address segments for tax compliance reasons. This is especially important for the **bill-to party**. For this segment the Amazon Payee system requires an exact match.

-   **Payment terms** sent in an invoice should match the payment terms agreed upon with the Amazon buyer.

-   **Item product identifier** should match the order item product identifier that was sent to the vendor in the matching purchase order.

-   The invoice **total amount** should be equal to the total sum of the items, charges, and allowances.

-   The total of the **tax amount** for each line level must be equal to the total of the tax amount at the header level.

-   The invoice **total quantity** should match the sum of the quantity of all items.

-   Every different **charge and allowance** must be itemized on the header level (for example freight charge, package charge, small ordering charge, etc.).

### Country Specific Business Requirements

Invoices for Direct Fulfillment are not supported in India via the API.

<table>
  <thead>
    <tr class="header">
      <th>
        <b>Functionality</b>
      </th>
      <th>
        <b>India</b>
      </th>
      <th>
        <b>Europe</b>
      </th>
      <th>
        <b>North America</b>
      </th>
    </tr>
  </thead>
  <tbody>
    <tr class="odd">
      <td>Invoice Type</td>
      <td>Not supported.</td>
      <td>Invoice type should always be "Invoice".</td>
      <td>Invoice type should always be "Invoice".</td>
    </tr>
    <tr class="even">
      <td>Date</td>
      <td>Not supported.</td>
      <td>Must be "now" or before.</td>
      <td>Must be "now" or before.</td>
    </tr>
    <tr class="odd">
      <td>HSN Number</td>
      <td>Not supported.</td>
      <td>Not used.</td>
      <td>Not used.</td>
    </tr>
    <tr class="even">
      <td>Tax Type at line and header level</td>
      <td>Not supported.</td>
      <td>Tax type to be sent.</td>
      <td>Not Used.</td>
    </tr>
    <tr class="odd">
      <td>Tax Registration Number</td>
      <td>Not supported.</td>
      <td>VAT Number.</td>
      <td>VAT Number.</td>
    </tr>
    <tr class="even">
      <td>Tax Details at line and header level</td>
      <td>Not supported.</td>
      <td>
        <p>If multiple taxes are applicable for an item, the Tax details section must be sent multiple times with the appropriate tax type for that item.</p>
        <p>The same applies to the total amount of the invoice.</p>
        <p>There is also an additional tax type called "DomesticVAT", which can be used to submit the tax amount in the local currency. In order to process the Domestic VAT you must use the same TaxRate used on tax Type "VAT".</p>
      </td>
      <td>
        <p>If multiple taxes are applicable for an item, the Tax details section must be sent multiple times with the appropriate tax type for that item.</p>
        <p>The same applies to the total amount of the invoice.</p>
      </td>
    </tr>
    <tr class="odd">
      <td>Remit To Party</td>
      <td>Not supported.</td>
      <td>Tax and address details of the party (vendor) who will be receiving payment for the shipped items. This is
        <b>required.</b>
      </td>
      <td>Tax and address details of the party (vendor) who will be receiving payment for the shipped items. This is
        <b>required.</b>
      </td>
    </tr>
    <tr class="even">
      <td>Ship From Party</td>
      <td>Not supported.</td>
      <td>Vendor code or warehouse code and address of the party from where items will be shipped.</td>
      <td>Vendor code or warehouse code and address of the party from where items will be shipped.</td>
    </tr>
    <tr class="odd">
      <td>Ship To Party</td>
      <td>Not supported.</td>
      <td>Amazon ID or warehouse code and address of the party to which items will be shipped.</td>
      <td>Amazon ID or warehouse code and address of the party to which items will be shipped.</td>
    </tr>
    <tr class="even">
      <td>Bill To Party</td>
      <td>Not supported.</td>
      <td>
        <p>Tax and Address details of the party (Amazon) who will be billed for shipped items.</p>
        <p>This field is
          <b>required.</b>
        </p>
      </td>
      <td>
        <p>Tax and Address details of the party (Amazon) who will be billed for shipped items.</p>
        <p>This field is
          <b>required.</b>
        </p>
      </td>
    </tr>
    <tr class="odd">
      <td>Amazon Product Identifier and External Product Identifier</td>
      <td>Not supported.</td>
      <td>At least one of those values is required. The identifier must be the same as what is received in the order.</td>
      <td>At least one of those values is required. The identifier must be the same as what is received in the order.</td>
    </tr>
    <tr class="even">
      <td>Net Cost</td>
      <td>Not supported.</td>
      <td>This field is
        <b>required.</b>
      </td>
      <td>This field is
        <b>required.</b>
      </td>
    </tr>
    <tr class="odd">
      <td>Purchase Order Number</td>
      <td>Not supported.</td>
      <td>
        <p>One invoice can have information for multiple orders. The PO number should be sent accordingly for different line items.</p>
        <p>
          <b>Required.</b>
        </p>
      </td>
      <td>
        <p>One invoice can have information for multiple orders. The PO number should be sent accordingly for different line items.</p>
        <p>
          <b>Required.</b>
        </p>
      </td>
    </tr>
    <tr class="even">
      <td>Additional Details</td>
      <td>Not supported.</td>
      <td>This field is used when the selling party has to submit additional details for special purposes. For example, in the case of Polish split payment invoices, the selling party must send in the detail "mechanizm podzielonej płatności" of type "SUR" and languageCode "PL".</td>
      <td>Not used</td>
    </tr>
    <tr class="odd">
      <td>referenceNumber</td>
      <td>Not supported.</td>
      <td>Not used.</td>
      <td>Not used.</td>
    </tr>
  </tbody>
</table>


### submitInvoice Request

To submit one or more invoices, call the [submitInvoice](https://github.com/amzn/selling-partner-api-docs/blob/main/references/vendor-direct-fulfillment-payments-api/vendorDirectFulfillmentPaymentsV1.md#submitinvoice) operation and pass the following parameters:

Body parameters:

<table>
  <thead>
    <tr class="header">
      <th>
        <b>Name</b>
      </th>
      <th>
        <b>Description</b>
      </th>
      <th>
        <b>Required</b>
      </th>
    </tr>
  </thead>
  <tbody>
    <tr class="odd">
      <td>invoices</td>
      <td>The request schema for the submitInvoice operation.
        <p>Type: &lt;
          <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/vendor-direct-fulfillment-payments-api/vendorDirectFulfillmentPaymentsV1.md#invoicedetail">InvoiceDetail</a>
          &gt; array
        </p>
      </td>
      <td>Yes</td>
    </tr>
  </tbody>
</table>


Request example:

```
POST https://sellingpartnerapi-na.amazon.com/vendor/directFulfillment/payments/v1/invoices
{
  "invoiceNumber": "0092590411",
  "invoiceDate": "2020-03-13T11:16:24Z",
  "remitToParty": {
    "partyId": "YourVendorCode",
    "address": {
      "name": "vendor name",
      "addressLine1": "vendor address 1",
      "addressLine2": "vendor address 2",
      "addressLine3": "vendor address 3",
      "city": "DECity",
      "county": "Schwabing",
      "district": "München",
      "stateOrRegion": "Bayern",
      "postalCode": "DEPostCode",
      "countryCode": "DE"
    },
    "taxRegistrationDetails": [
      {
        "taxRegistrationType": "VAT",
        "taxRegistrationNumber": "DE123456789"
      }
    ]
  },
  "shipFromParty": {
    "partyId": "ABCD"
  },
  "billToParty": {
    "partyId": "5450534005838",
    "address": {
      "name": "Amazon EU SARL",
      "addressLine1": "Marcel-Breuer-Str. 12",
      "city": "München",
      "county": "Schwabing",
      "district": "München",
      "stateOrRegion": "Bayern",
      "postalCode": "80807",
      "countryCode": "DE"
    },
    "taxRegistrationDetails": [
      {
        "taxRegistrationType": "VAT",
        "taxRegistrationNumber": "DE814584193",
        "taxRegistrationAddress": {
          "name": "Amazon EU SARL",
          "addressLine1": "Marcel-Breuer-Str. 12",
          "city": "München",
          "postalCode": "80807",
          "countryCode": "DE"
        },
        "taxRegistrationMessage": "txmessage"
      }
    ]
  },
  "shipToCountryCode": "DE",
  "paymentTermsCode": "Basic",
  "invoiceTotal": {
    "currencyCode": "EUR",
    "amount": "1428.00"
  },
  "taxTotals": [
    {
      "taxType": "CGST",
      "taxRate": "0.19",
      "taxAmount": {
        "currencyCode": "EUR",
        "amount": "228.00"
      },
      "taxableAmount": {
        "currencyCode": "EUR",
        "amount": "1200.00"
      }
    }
  ],
  "items": [
    {
      "itemSequenceNumber": "1",
      "buyerProductIdentifier": "B00IVLAABC",
      "invoicedQuantity": {
        "amount": 1,
        "unitOfMeasure": "Each"
      },
      "netCost": {
        "currencyCode": "EUR",
        "amount": "1200.00"
      },
      "purchaseOrderNumber": "D3rC3KTxG",
      "vendorOrderNumber": "0092590411",
      "hsnCode": "76.06.92.99.00",
      "taxDetails": [
        {
          "taxType": "CGST",
          "taxRate": "0.19",
          "taxAmount": {
            "currencyCode": "EUR",
            "amount": "228.00"
          },
          "taxableAmount": {
            "currencyCode": "EUR",
            "amount": "1200.00"
          }
        }
      ]
    }
  ]
}

```



### submitInvoice Response

A successful response includes the following:

<table>
  <thead>
    <tr class="header">
      <th>
        <b>Name</b>
      </th>
      <th>
        <b>Description</b>
      </th>
      <th>
        <b>Required</b>
      </th>
    </tr>
  </thead>
  <tbody>
    <tr class="odd">
      <td>transactionId</td>
      <td>GUID to identify this transaction. This value can be used with the Transaction Status API to return the status of this transaction.
        <p>Type: string</p>
      </td>
      <td>No</td>
    </tr>
  </tbody>
</table>


Response example:

```json
{
  "transactionId": "20190905010908-8a3b6901-ef20-412f-9270-21c021796605"
}
```



What is the Direct Fulfillment Inventory API?
=============================================

Vendors can use the Direct Fulfillment Inventory API to exchange inventory stock levels with Amazon. We support the Inventory Feeds API, which lets vendors send inventory feeds to Amazon for the direct fulfillment catalog.

The following operations are included:

<table>
  <thead>
    <tr class="header">
      <th>
        <b>Operation</b>
      </th>
      <th>
        <b>HTTP Method</b>
      </th>
      <th>
        <b>Path</b>
      </th>
      <th>
        <b>Description</b>
      </th>
    </tr>
  </thead>
  <tbody>
    <tr class="odd">
      <td>
        <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/vendor-direct-fulfillment-inventory-api/vendorDirectFulfillmentInventoryV1.md#submitinventoryupdate">submitInventoryUpdate</a>
      </td>
      <td>POST</td>
      <td>/vendor/directFulfillment/inventory/v1/warehouses/{warehouseId}/items</td>
      <td>Submits partial or full feeds of inventory details to Amazon.</td>
    </tr>
  </tbody>
</table>


Submit Inventory Update
-----------------------

There are two types of inventory feeds that can be submitted using this API. When "isFullUpdate" is set to true, the feed is a full update. When "isFullUpdate" is set to false, the feed is a partial update to inventory. Both options are described below.

When you choose a full update, the operation updates the complete inventory for a specific warehouse. You must send information about all items in the warehouse. For any items not includes, the Available Quantity will be updated to zero. This operation should only be used to perform a full warehouse synchronization, and should only be used if you don't have the ability to update the inventory for out of stock items to zero. If you can manage inventory for all your items, Amazon *does not recommend* that you choose a full update.

When you choose a partial update, you update only the inventory of selected item(s) in a warehouse. This is typically called every few hours to update the items which are going out of stock or went out of stock since last update.

### Verification of successfully submitted Order inventory feeds 

Vendors can verify the status of an inventory update using Vendor Central or using the Transaction Status API. For more information about how to use the Transaction Status API, see the business use case documentation for the Transaction Status API. Allow the system to take up to 15 minutes to show the original/updated version once submitted. If Vendor Central is not showing the correct values for the acknowledgement, open a "Contact Us" case in Vendor Central.

The following diagram shows the integration workflow for submitting inventory updates.

<img src="./media/InventoryWorkflow.png" 
alt="Direct Fulfillment integration workflow for submitting inventory updates" 
style="width:2.11951in;height:5.8in" />

### Business Requirements 

-   One inventory feed is required for each warehouse. If a vendor has multiple warehouses, then multiple inventory feeds submissions are required, with each feed containing items for a given warehouse.

-   For a full update, all the items in the warehouse which are in stock should be submitted. Any items not submitted will have their availability is set to zero in Amazon, and no new orders will be issued for those non-available items.

-   For a partial update, only those items for which the stock quantity must to be updated should be included. Remaining items that are not in the partial update will remain unchanged.

-   When an item's status is set to obsolete using the **isObsolete** request body parameter, the item is marked as permanently unavailable. If the item becomes available and is back in stock, you must set **isObsolete** to false so that the item is marked as back in stock.

-   If an item is rejected using the order acknowledgement multiple times, then those items will be marked as 'out of stock' and this may impact your fulfillment metrics.

### Country Specific Business Requirements

No country specific requirements exist.

### submitInventoryUpdate Request

To submit inventory updates, call the [submitInventoryUpdate](https://github.com/amzn/selling-partner-api-docs/blob/main/references/vendor-direct-fulfillment-inventory-api/vendorDirectFulfillmentInventoryV1.md#submitinventoryupdate) operation and pass the following parameters:

Path parameters:

<table>
  <thead>
    <tr class="header">
      <th>
        <b>Name</b>
      </th>
      <th>
        <b>Description</b>
      </th>
      <th>
        <b>Required</b>
      </th>
    </tr>
  </thead>
  <tbody>
    <tr class="odd">
      <td>warehouseId</td>
      <td>Identifier for the warehouse for which to update inventory.
        <p>Type: string</p>
      </td>
      <td>Yes</td>
    </tr>
  </tbody>
</table>


Body parameters:

<table>
  <thead>
    <tr class="header">
      <th>
        <b>Name</b>
      </th>
      <th>
        <b>Description</b>
      </th>
      <th>
        <b>Required</b>
      </th>
    </tr>
  </thead>
  <tbody>
    <tr class="odd">
      <td>inventory</td>
      <td>Inventory feed request to update all or partial items for a given warehouse.
        <p>Type:
          <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/vendor-direct-fulfillment-inventory-api/vendorDirectFulfillmentInventoryV1.md#inventoryupdate">InventoryUpdate</a>
        </p>
      </td>
      <td>Yes</td>
    </tr>
  </tbody>
</table>


Request example:

```
POST "https://sellingpartnerapi-na.amazon.com/vendor/directFulfillment/inventory/v1/warehouses/ABCD/items"

{
  "inventory": {
    "sellingParty": {
      "partyId": "VENDORID"
    },
    "isFullUpdate": false,
    "items": [
      {
        "buyerProductIdentifier": "ABCD4562",
        "vendorProductIdentifier": "7Q89K11",
        "availableQuantity": {
          "amount": 10,
          "unitOfMeasure": "Each"
        },
        "isObsolete": false
      }, {
        "buyerProductIdentifier": "ABCD4563",
        "vendorProductIdentifier": "7Q89K12",
        "availableQuantity": {
          "amount": 15,
          "unitOfMeasure": "Each"
        },
        "isObsolete": false
      }, {
        "buyerProductIdentifier": "ABCD4564",
        "vendorProductIdentifier": "7Q89K13",
        "availableQuantity": {
          "amount": 20,
          "unitOfMeasure": "Each"
        },
        "isObsolete": false
      }
    ]
  }
}
```

### submitInventoryUpdate Response

A successful response includes the following:

<table>
  <thead>
    <tr class="header">
      <th>
        <b>Name</b>
      </th>
      <th>
        <b>Description</b>
      </th>
      <th>
        <b>Required</b>
      </th>
    </tr>
  </thead>
  <tbody>
    <tr class="odd">
      <td>transactionId</td>
      <td>GUID to identify this transaction. This value can be used with the Transaction Status API to return the status of this transaction.
        <p>Type: string</p>
      </td>
      <td>No</td>
    </tr>
  </tbody>
</table>


Response example:

```json
{
  "transactionId": "20190905010908-8a3b6901-ef20-412f-9270-21c021796605"
}
```



What is the Direct Fulfillment Transaction Status API?
======================================================

Vendors can use this API to check the transaction status of their POST transactions.

The following operations are included:

| **Operation**                                                                                                                                                                                          | **HTTP Method** | **Path**                                               | **Description**                   |
|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|-----------------|------------------------------------------------------------------------|-----------------------------------|
| [getTransactionStatus](https://github.com/amzn/selling-partner-api-docs/blob/main/references/vendor-direct-fulfillment-transactions-api/vendorDirectFulfillmentTransactionsV1.md#gettransactionstatus) | GET             | /vendor/directFulfillment/transactions/v1/transactions/{transactionId} | Get the status of a POST request. |

Get Transaction Status
----------------------

Vendors can use the [getTransactionStatus](https://github.com/amzn/selling-partner-api-docs/blob/main/references/vendor-direct-fulfillment-transactions-api/vendorDirectFulfillmentTransactionsV1.md#gettransactionstatus) operation to check the status of a POST transaction. When a request is posted to Amazon using certain POST operations in the vendor APIs, such as [submitAcknowledgement](https://github.com/amzn/selling-partner-api-docs/blob/main/references/vendor-direct-fulfillment-orders-api/vendorDirectFulfillmentOrdersV1.md#submitacknowledgement) or [submitShipmentConfirmations](https://github.com/amzn/selling-partner-api-docs/blob/main/references/vendor-direct-fulfillment-shipping-api/vendorDirectFulfillmentShippingV1.md#submitshipmentconfirmations), for example, a successful response contains a transaction ID that uniquely identifies the transaction. Amazon will process the transaction asynchronously, and the final response will be available via the getTransactionStatus operation.

See the corresponding integration workflow diagram in the other sections of this guide to understand when to call the getTransactionStatus operation to get the transaction status.

Amazon offers the final processed status for POST transactions such as submitAcknowledgement and submitShipmentConfirmations via this API. We highly recommend that vendors check the status using this API to ensure that transactions were processed successfully. If an error occurred you will receive the error details so you can correct the transaction and resubmit it.

| **Transaction Status** | **Definition**                                                                                                                                                                         |
|------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Processing             | The API transaction was received by Amazon is being processed. The processing is not completed yet. Check the SLA for each API operation for the expected time to complete processing. |
| Success                | The API transaction was successfully processed by Amazon.                                                                                                                              |
| Failure                | The API transaction failed during processing. The error details will be provided in the getTransactionStatus response body.                                                            |

NOTE:

The transaction status is supported for the following Direct Fulfillment APIs:

| **Description**               | **API Section**              | **Operation**               |
|-------------------------------|------------------------------|-----------------------------|
| Acknowledge Order             | Direct Fulfillment Orders    | submitAcknowledgement       |
| Submit Shipment Confirmations | Direct Fulfillment Shipping  | submitShipmentConfirmations |
| Shipping Label Request        | Direct Fulfillment Shipping  | submitShippingLabelRequest  |
| Shipping Status Updates       | Direct Fulfillment Shipping  | submitShipmentStatusUpdates |
| Inventory Update              | Direct Fulfillment Inventory | submitInventoryUpdate       |
| Invoice                       | Direct Fulfillment Payments  | submitInvoice               |

The transaction status supports only "Processing" and "Failure" status codes for now. If the transaction status is "Processing" and has not been updated to "Failure" after 30 minutes, that indicates the transaction has successfully processed in our systems. The "Success" status will be supported in the future.

### getTransactionStatus Request

To return the transaction status, call the [getTransactionStatus](https://github.com/amzn/selling-partner-api-docs/blob/main/references/vendor-direct-fulfillment-transactions-api/vendorDirectFulfillmentTransactionsV1.md#gettransactionstatus) operation and pass the following parameters:

Path parameters:

<table>
  <thead>
    <tr class="header">
      <th>
        <b>Name</b>
      </th>
      <th>
        <b>Description</b>
      </th>
      <th>
        <b>Required</b>
      </th>
    </tr>
  </thead>
  <tbody>
    <tr class="odd">
      <td>transactionId</td>
      <td>Previously returned in the response to the POST request of a specific transaction.
        <p>Type: string</p>
      </td>
      <td>Yes</td>
    </tr>
  </tbody>
</table>


Request Example:

```
GET https://sellingpartnerapi-na.amazon.com/vendor/directFulfillment/transactions/v1/transactions/20190904190535-eef8cad8-418e-4ed3-ac72-789e2ee6214a
```

### getTransactionStatus Response

A successful response includes the following:

<table>
  <thead>
    <tr class="header">
      <th>
        <b>Name</b>
      </th>
      <th>
        <b>Description</b>
      </th>
      <th>
        <b>Required</b>
      </th>
    </tr>
  </thead>
  <tbody>
    <tr class="odd">
      <td>transactionId</td>
      <td>The unique identifier returned in the response to the post request of a specific transaction.
        <p>Type: string</p>
      </td>
      <td>Yes</td>
    </tr>
    <tr class="even">
      <td>status</td>
      <td>Current processing status of the transaction.
        <p>enum (
          <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/vendor-direct-fulfillment-transactions-api/vendorDirectFulfillmentTransactionsV1.md#status">Status</a>
          )
        </p>
      </td>
      <td>Yes</td>
    </tr>
    <tr class="odd">
      <td>errors</td>
      <td>Error code and message for the failed transaction. Only available when transaction status is 'Failure'.
        <p>Type:
          <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/vendor-direct-fulfillment-transactions-api/vendorDirectFulfillmentTransactionsV1.md#errorlist">ErrorList</a>
        </p>
      </td>
      <td>No</td>
    </tr>
  </tbody>
</table>


Response Example:

```json
{
  "transactionId": "20190918190535-eef8cad8-418e-456f-ac72-789e2ee6813c",
  "status": "Failure",
  "errors": [
    {
      "code": "INVALID_ORDER_ID",
      "message": "Invalid order ID."
    }
  ]
}

```


