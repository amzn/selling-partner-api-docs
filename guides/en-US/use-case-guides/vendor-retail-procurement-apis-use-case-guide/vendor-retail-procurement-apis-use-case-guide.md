# Vendor Retail Procurement APIs Use Case Guide

API Version: V1

Contents
========

* [Overview](#overview)

* [What is the Vendor Orders API?](#what-is-the-vendor-orders-api)

   * [Get Purchase Orders](#get-purchase-orders)

   * [Get Purchase Order](#get-purchase-order)

   * [Acknowledge Order](#acknowledge-order)

   * [Get Purchase Orders Status](#get-purchase-orders-status)

* [What is the Vendor Shipments API?](#what-is-the-vendor-shipments-api)

   * [Submit Shipment Confirmations](#submit-shipment-confirmations)

* [What is the Vendor Payments API?](#what-is-the-vendor-payments-api)

   * [Submit Invoices](#submit-invoices)

* [What is the Vendor Transaction Status API?](#what-is-the-vendor-transaction-status-api)

   * [Get Transaction Status](#get-transaction-status)

Overview
========

The Selling Partner APIs for Retail Vendors help vendors manage their retail business operations programmatically through web service integration. Automated integration with Amazon can help vendors improve and maintain their performance at scale and grow their business with Amazon.

Vendors in the direct fulfillment program will want to see the Direct Fulfillment APIs Use Case Guide for Vendors to learn about APIs specific to direct fulfillment.

Vendors can use these APIs to build applications to increase operational efficiency, reduce effort, reduce errors, and improve performance.

For information on authentication and authorization, see the [Selling Partner API Developer Guide for Vendors](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuideForVendors.md).

What is the Vendor Orders API?
==============================

Using the Vendor Orders API (Orders API), vendors can receive purchase orders and send order acknowledgements to accept or reject order fulfillment. 

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
      <td><a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/vendor-orders-api/vendorOrders.md#getPurchaseOrders">getPurchaseOrders</a></td>
      <td>GET</td>
      <td>/vendor/orders/v1/purchaseOrders</td>
      <td>Returns a list of purchase orders created or changed during the time frame that you specify.</td>
    </tr>
    <tr class="even">
      <td><a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/vendor-orders-api/vendorOrders.md#getPurchaseOrder">getPurchaseOrder</a></td>
      <td>GET</td>
      <td>/vendor/orders/v1/purchaseOrders /{purchaseOrderNumber}</td>
      <td>Returns a purchase order (PO) based on the purchaseOrderNumber value that you specify.</td>
    </tr>
    <tr class="odd">
      <td><a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/vendor-orders-api/vendorOrders.md#submitAcknowledgement">submitAcknowledgement</a></td>
      <td>POST</td>
      <td>/vendor/orders/v1/acknowledgements</td>
      <td>Acknowledges (accepts or rejects) one or more purchase orders.</td>
    </tr>
    <tr class="even">
      <td><a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/vendor-orders-api/vendorOrders.md#getPurchaseOrdersStatus">getPurchaseOrdersStatus</a></td>
      <td>GET</td>
      <td>/vendor/orders/v1/purchaseOrdersStatus</td>
      <td>Returns purchase order statuses based on the filters that you specify.</td>
    </tr>
  </tbody>
</table>


You can use the [getPurchaseOrders](https://github.com/amzn/selling-partner-api-docs/blob/main/references/vendor-orders-api/vendorOrders.md#getPurchaseOrders) operation to access orders created or changed during a time period that you specify (within a rolling window of the last 6 months after June 2020). We recommend that you limit the time range to no more than 7 days to optimize response time. You can also get detailed order information for a specific order using the [getPurchaseOrder](https://github.com/amzn/selling-partner-api-docs/blob/main/references/vendor-orders-api/vendorOrders.md#getPurchaseOrder) operation. You can then acknowledge (accept or reject) the order using the [submitAcknowledgement](https://github.com/amzn/selling-partner-api-docs/blob/main/references/vendor-orders-api/vendorOrders.md#submitAcknowledgement) operation. After acknowledging orders, you can use [getPurchaseOrdersStatus](https://github.com/amzn/selling-partner-api-docs/blob/main/references/vendor-orders-api/vendorOrders.md#getPurchaseOrdersStatus) operation to return the acknowledgement status of one or more purchase orders.

Note: You can return complete purchase order details or only the purchase order numbers by calling the getPurchaseOrders operation with the "includeDetails" filter. The default value for this parameter is true, so if you don't include this query parameter, you will return the complete details of the purchase orders. If you "includeDetails=false", the response will include only a list of purchase order numbers and the current state of each purchase order.

The following diagram shows the workflow using the Vendor Orders API.

<img src="media\vendorOrdersWorkflow.png" style="width:6.5in;height:5.21389in" />

## Get Purchase Orders

### Usage

The [getPurchaseOrders](https://github.com/amzn/selling-partner-api-docs/blob/main/references/vendor-orders-api/vendorOrders.md#getPurchaseOrders) operation returns either a list of only order references (purchase order numbers and status) or complete order details, for all orders that meet the criteria specified in the request. If you are returning only order references, they can be used later with the [getPurchaseOrder](https://github.com/amzn/selling-partner-api-docs/blob/main/references/vendor-orders-api/vendorOrders.md#getPurchaseOrder) operation to get the order details for a specific order.

You should use this API to get purchase orders available to you for fulfillment. Amazon recommends that vendors check for orders at least once per hour during business hours. Depending on your business volume, you may choose to check more frequently. You can get up to 100 orders in one API call. If there are more than 100 orders, you can use nextToken to get the next set of orders.

### Order Changes and Cancellation

You can return order changes and cancellations using the getPurchaseOrders operation. 

**Order Changes**: Sometimes Amazon will change the purchase order data after order creation due to a requirement change. Vendors can use the getPurchaseOrders API to get updated orders. If Amazon changes a purchase order, the order will have a 'purchaseOrderChangedDate' field that is the timestamp when Amazon updated the order. If this field does not exist, the order has never changed after creation.

**Note**: Amazon can also change the purchase order after the vendor has acknowledged it.

Vendors can get a list of orders that have changed within a specified date range by using the "changedAfter" and "changedBefore" query parameters. This will return the orders that have been changed by Amazon within the date range, and vendors must fulfill the updated purchase order. Alternatively, vendors can filter using 'isPOChanged=true' to get all changed purchase orders.

Amazon recommends running a separate API call with the changed date range a few times a day to get the changed orders in a day. For example, you can call the get purchase orders API to get orders changed in the last 6 hours 4 times a day.

Here is the list of changes that can contribute to order changes for which the vendor must pull the changed order to ship the correct purchase order:

-   Ship/delivery window change

-   PO item updates such as quantity change, item cancellation, item cost change

-   New item added in PO

-   PO Cancelled/Uncancelled

-   PO type changed

-   PO Delivery Destination (Fulfillment Center) changed

-   PO Freight information changed

**Item Cancellation:** The orders API can also be used to return orders with one or more cancelled items by filtering using "poItemState"=Cancelled. This will return all the orders that have had one or more items cancelled by Amazon after purchase order creation. This will help vendors to get only the orders that have cancelled items (ordered quantity is zero) and they can make sure not to ship the cancelled items.

**Note**: Vendors will also return these orders in the list of changed orders because item cancellation qualifies as an order change.

**Purchase Order State and Vendor Code:** The purchase order schema includes the current purchase order state and the state update time. You can filter orders based on the current state using filter 'purchaseOrderState'.

For example, vendors can get all the purchase orders which have not yet been acknowledged or fulfilled using 'purchaseOrderState=New'. 

Vendors can also get purchase orders for a specific vendor code by providing one of the authorized vendor codes in filter 'orderingVendorCode'. This filter will return only purchase orders raised for the vendor code mentioned in the filter.

For details about all the available filters, see the [Vendor Orders API Reference](https://github.com/amzn/selling-partner-api-docs/blob/main/references/vendor-orders-api/vendorOrders.md).

The following diagram shows the integration workflow when retrieving purchase orders:

<img src="media\getPurchaseOrders.png" style="width:4.906in;height:7.489in" alt="Vendor orders workflow when retrieving purchase orders" />

## Get Purchase Order

### Usage

The [getPurchaseOrder](https://github.com/amzn/selling-partner-api-docs/blob/main/references/vendor-orders-api/vendorOrders.md#getPurchaseOrder) operation returns information about the purchase order that you specify using the purchase order number. The response includes complete purchase order information for the purchase order, including line item details, quantity, cost, etc.

You should use this API to get the details of specific orders returned by the getPurchaseOrders operation. 

The following diagram shows the integration workflow:

<img src="media\getPurchaseOrder.png" style="width:5.166in;height:7.388in" alt="Vendor orders workflow when retrieving a specific purchase order" />

### Business Requirements

-   **Ship Window/Delivery Window Usage**

For vendor paid freights, the delivery window information should be used. The date is represented in date time interval format according to ISO8601. Format is start and end date separated by double hyphen (--). The start date field represents the earliest date that Amazon expects the freight to be delivered to the Amazon fulfillment center listed on the purchase order. The end date in the field represents the latest date that Amazon expects the freight to be delivered to the Amazon fulfillment center listed on the purchase order.

For Amazon-paid freights, the ship window information should be used. The date is represented in date time interval format according to ISO8601. Format is start and end date separated by double hyphen (--). The start date field represents the earliest date that Amazon expects to pick up the freight. The end date represents the latest date that Amazon expects to pick up the freight. If the same date is listed in the start date and end date fields, then read that date as the date that Amazon expects to pick up the freight.

-   **Are backorders acceptable for a line item?**

You are required to read the value in the "isBackOrderAllowed" field. When true, the order can be processed as a backorder. When false, backorders are not allowed.

-   **Deal codes**

Deal codes are promotional codes reported in the "dealCode" field of the order. Any information related to promo code, special discounts, or pricing will be present in this field.

-   **Backorder cancellation policy**

The backorder policy is determined by your Amazon business representative. Please discuss the details with your vendor manager.

Note: Backorder cancellation dates may not be submitted in the order. Vendors are required to set up our backorder policy at the account level.

-   **Changing an order using the API**

Submitting a change to an order using the API is not possible at this time. After an order has been placed, changing it is a manual process.

### Country Specific Business Requirements 

| Functionality | India                                         | Europe                                        | North America                                 |
|---------------|-----------------------------------------------|-----------------------------------------------|-----------------------------------------------|
| Net Cost      | Conditional. Either Net Cost or List Price.   | Conditional. Either Net Cost or List Price.   | Conditional. Either Net Cost or List Price.   |
| List Price    | Conditional. Either Net Cost or List Price.   | Conditional. Either Net Cost or List Price.   | Conditional. Either Net Cost or List Price.   |
| Back Order    | Not Applicable                                | Supported                                     | Supported                                     |
| Buying Party  | The address of the Amazon Buying Entity       | The assigned party ID for the buying party    | Not Applicable                                |
| Selling Party | The Amazon Vendor Code assigned to the vendor | The Amazon Vendor Code assigned to the vendor | The Amazon Vendor Code assigned to the vendor |
| Ship To Party | The address of the Ship to Entity             | The assigned party ID for the ship to party   | Not Applicable                                |
| Bill To Party | The address of the Bill To Entity             | The address of the Bill To Entity             | Not Applicable                                |

## Acknowledge Order

### Usage

The [submitAcknowledgement](https://github.com/amzn/selling-partner-api-docs/blob/main/references/vendor-orders-api/vendorOrders.md#submitAcknowledgement) operation lets a vendor accept or reject a purchase order for fulfillment. Amazon expects a complete acknowledgement, including all of the purchase order line items of the purchase order. If the vendor does not provide all of the line items of the purchase order in the acknowledgement, Amazon will implicitly reject the missing line items.

Amazon expects the vendor to submit the acknowledgement as fast as possible; at the latest within 24 hours. The acknowledgement should be an accurate view of the actual shipment quantities and dates.

For any change in quantity, price, ship dates, or delivery dates, Amazon expects an update to the acknowledgement submitted by the vendor within 48 hours. The vendor can submit a full acknowledgement update or only update a specific line item. Amazon always treats the update as a replacement of the earlier acknowledgements for the line item. After 48 hours, we only expect to receive updates to ship dates or delivery dates.

If the first acknowledgement code for a specific line item was 'rejected', you are not allowed to change this with your update to either 'accepted' or 'backordered'.

### Verification of successfully submitted order acknowledgements 

Vendors can verify the status of the original/updated version of the order acknowledgement using Vendor Central or using the [Transaction Status API](#what-is-the-vendor-transaction-status-api). Allow the system to take up to 30 minutes to show the original or updated version once submitted. If Vendor Central is not showing the correct values for the acknowledgement, open a "Contact Us" case in Vendor Central.

The following diagram shows the integration workflow when acknowledging orders.

<img src="media\submitAcknowledgement.png" style="width:6.08333in;height:7.875in" alt="Vendor orders workflow when acknowledging orders" />

### Business Requirements

-   **Can a vendor increase the original quantity submitted in the purchase order when acknowledging an order?**

No, Amazon does not allow the vendor to send a higher quantity in the acknowledgement than what was submitted in the purchase order.

-   **Is it a requirement to send an order acknowledgement for each purchase order?**

Yes, in order to update the status of an order in the Amazon system correctly, Amazon requires PO confirmation using the API or Vendor Central. If you are unable to meet our order acknowledgement requirements using the API, you must confirm your purchase orders using Vendor Central. Please contact your Amazon business representative if you do not have a Vendor Central account.

-   **Is it a requirement to provide every PO line item in the corresponding order acknowledgement?**

Yes, so that Amazon can update the order status correctly.

-   **If a line item is placed on backorder, is it required to provide the quantity in the order acknowledgement?**

Yes, so that the Amazon system can update the status of the line item correctly.

-   **How should invalid or obsolete items on an order be reported using the order acknowledgement?**

Do not process or ship an item that arrived with an invalid item number on the order. Please return the invalid item number on the acknowledgement and acknowledge it as 'invalid'. The following acknowledgement codes indicate "rejected" due to the item being obsolete:

Rejected: Amazon's interpretation is that the quantity stated with this code will not be delivered to Amazon as part of this purchase order. You should send the appropriate rejection reason as "obsolete" in the acknowledgement. This indicates that due to the item being obsolete, the item should no longer be ordered. The Amazon nomenclature for this is "hard reject", meaning this item should not be re-ordered. If this code is received two consecutive times for the same project (separated by a time gap of at least 48 hours), the item will not be reordered.

**Note**: Amazon expects an acknowledgement even if all the line items on the purchase order were invalid and did not produce an order or invoice. If a corresponding acknowledgement cannot be sent for a purchase order, Amazon requires manual notification of invalid items. Your buying team may be notified through the Vendor Central Contact Us link.

-   **Do I need to return the same product identifier in the acknowledgement that I received in the orders transaction?**

Acknowledgements must return exactly the same product identifier that was sent in the purchase order.

-   **Is it required to provide price in the acknowledgement?**

Yes, vendors are required to return the unit cost price in the acknowledgement. The cost price should match the unit cost price that will be invoiced. Book vendors are required to provide a list price and discount multiplier.

-   **Can the price in the purchase order be simply returned on the acknowledgement?**

No. Regardless of the price submitted on the purchase order, Amazon requires the cost price in the acknowledgement. The cost price submitted on the acknowledgement should match the cost price submitted in the invoice. Amazon payment systems will compare the two and may delay payment if they do not match.

-   **What does Amazon.com require if the price and/or availability change after the initial acknowledgement has been transmitted?**

Provide manual notification regarding any changes to Amazon orders after the initial acknowledgement has been transmitted. Your Amazon.com business representative can advise on when, how, and who to notify.

-   **Is it required to provide price data for items on backorder?**

Yes, this is required so Amazon can update the status of the order correctly. If the price is omitted, this will cause the acknowledgement to be rejected within the EDI system.

-   **How will I know if backorders are allowed or not?**

You are required to read the value in the "isBackOrderAllowed" field in the purchase order. A value of true indicates that backorders are allowed. A value of false indicates that backorders are not allowed.

-   **Is it required to provide an acknowledgement code for all line items regardless of status?**

Yes, it is required so we can correctly update the status of the order. If the acknowledgement code is omitted, the acknowledgement will be rejected in our EDI system.

-   **What is the policy at Amazon.com on partial shipments? How should partial shipments be reported when submitting an order acknowledgement?**

Partial shipments are allowed. Amazon recommends that you indicate one acknowledgement loop using the code "accepted" with the corresponding date and another acknowledgement loop using the code "backordered" and the corresponding date.

Accepted: For the items that can be fulfilled immediately.

Backordered: For the remaining quantity that cannot be fulfilled immediately. The remaining quantity (ordered quantity minus all confirmed quantity) will be delivered later (back-ordered).

-   **When should I use the listPrice segment?**

The listPrice segment is required only if a vendor sells books with a list price.

### Country Specific Business Requirements

| Functionality           | India                                                                                       | Europe    | North America                |
|-------------------------|---------------------------------------------------------------------------------------------|-----------|------------------------------|
| Scheduled Ship Date     | Conditional. Depends on the freight terms and current business arrangement with the vendor. | Optional  | Optional                     |
| Scheduled Delivery Date | Conditional. Depends on the freight terms and current business arrangement with the vendor. | Optional  | Optional                     |
| List Price              | Needed only for Book Vendors                                                                | Supported | Needed only for Book Vendors |

## Get Purchase Orders Status

### Usage

The [getPurchaseOrdersStatus](https://github.com/amzn/selling-partner-api-docs/blob/main/references/vendor-orders-api/vendorOrders.md#getPurchaseOrdersStatus) operation returns the status of the list of purchase orders that meet the criteria specified in the request. You can use this API to get the acknowledgement status of the items in purchase orders available to you for fulfillment. This API returns the history of ordered quantity and acknowledgements of an item. You can view details of all the acknowledgements processed for an item in a purchase order. We have provided wide range of query parameters to filter the list of POs as per your requirement.

You can return up to 100 orders in one API call. If there are more than 100 orders, you can use nextToken to get the next set of orders.

Here are a few examples of how you can use the getPurchaseOrdersStatus operation with different query parameters:

1.  You can get the status of all open purchase orders within a specified date range by using either the PO create date (createdBefore and createdAfter) or the PO update date (updatedBefore and updatedAfter) along with 'purchaseOrderStatus=OPEN'.

1.  You can use item status to filter the st of POs. For example, if 'itemConfirmationStatus=REJECTED', the response will return all of the orders that have one or more items' status as rejected.

1.  You can check the status of a specific PO by providing the PO number in the 'purchaseOrderNumber' query parameter.

1.  You can get the status of all the open POs raised for a specific vendor code by providing the vendor code value in 'orderingVendorCode' and including 'purchaseOrderStatus=OPEN'.

1.  You can get the status of all the POs created in a time range that need to be shipped to a specific Amazon FC by providing the fulfillment center (FC) code in 'shipToPartyId' and the time period range in 'createdBefore and createdAfter'.

## Purchase Order and Acknowledgement Use Cases

### Invalid line item in the purchase order

If the vendor receives an invalid product identifier in the purchase order, the vendor should reject the item with an acknowledgement code "Rejected" and the "rejectionReason" as "InvalidProductIdentifier":

Purchase Order

```json
{
  "order": {
    "purchaseOrderNumber": " L8266355",
    "purchaseOrderState": "New",
    "orderDetails": {
      "purchaseOrderDate": "2019-07-16T19:17:34.304Z",
      "purchaseOrderStateChangedDate": "2019-07-16T19:17:34.304Z",
      "purchaseOrderType": "RegularOrder",
      "paymentMethod": "Invoice",
      "buyingParty": {
        "partyId": "NAG1"
      },
      "sellingParty": {
        "partyId": "999US"
      },
      "shipToParty": {
        "partyId": "NAG1"
      },
      "billToParty": {
        "partyId": "NAG1"
      },
      "items": [
        {
          "itemSequenceNumber": "1",
          "amazonProductIdentifier": " ABC123434",
          "vendorProductIdentifier": "028877454078",
          "orderedQuantity": {
            "amount": "10",
            "unitOfMeasure": "Cases",
            "unitSize": "5"
          },
          "isBackOrderAllowed": false,
          "netCost": {
            "amount": "10.2",
            "currencyCode": "USD"
          },
          "listPrice": {
            "amount": "10.2",
            "currencyCode": "USD"
          }
        }
      ]
    }
  }
}
```

Purchase Order Acknowledgement

```json
{
  "acknowledgements": [
    {
      "purchaseOrderNumber": "L8266355",
      "sellingParty": {
        "partyId": "999US"
      },
      "acknowledgementDate": "2019-07-17T19:17:34.304Z",
      "items": [
        {
          "itemSequenceNumber": "1",
          "amazonProductIdentifier": " ABC123434",
          "vendorProductIdentifier": "028877454078",
          "orderedQuantity": {
            "amount": 10,
            "unitOfMeasure": "Cases",
            "unitSize": 5
          },
          "netCost": {
            "currencyCode": "USD",
            "amount": "10.2"
          },
          "itemAcknowledgements": [
            {
              "acknowledgementCode": "Rejected",
              "acknowledgedQuantity": {
                "amount": 10
              },
              "rejectionReason": "InvalidProductIdentifier"
            }
          ]
        }
      ]
    }
  ]
}
```


Purchase Order Status

```json
{
  "payload": {
    "ordersStatus": [
      {
        "purchaseOrderNumber": "L8266355",
        "purchaseOrderStatus": "CLOSED",
        "purchaseOrderDate": "2019-07-16T19:17:34.304Z",
        "lastUpdatedDate": "2019-07-17T19:17:34.304Z",
        "sellingParty": {
          "partyId": "999US"
        },
        "shipToParty": {
          "partyId": "NAG1"
        },
        "itemStatus": [
          {
            "itemSequenceNumber": "1",
            "buyerProductIdentifier": "ABC123434",
            "vendorProductIdentifier": "028877454078",
            "netCost": {
              "amount": "10.2",
              "currencyCode": "USD"
            },
            "listPrice": {
              "amount": "10.2",
              "currencyCode": "USD"
            },
            "orderedQuantity": {
              "orderedQuantity": {
                "amount": 10,
                "unitOfMeasure": "Cases",
                "unitSize": 5
              },
              "orderedQuantityDetails": [
                {
                  "updatedDate": "2019-07-16T19:17:34.304Z",
                  "orderedQuantity": {
                    "amount": 10,
                    "unitOfMeasure": "Cases",
                    "unitSize": 5
                  }
                }
              ]
            },
            "acknowledgementStatus": {
              "confirmationStatus": "REJECTED",
              "acceptedQuantity": {
                "amount": 0,
                "unitOfMeasure": "Cases",
                "unitSize": 5
              },
              "rejectedQuantity": {
                "amount": 10,
                "unitOfMeasure": "Cases",
                "unitSize": 5
              },
              "acknowledgementStatusDetails": [
                {
                  "acknowledgementDate": "2019-07-17T19:17:34.304Z",
                  "acceptedQuantity": {
                    "amount": 0,
                    "unitOfMeasure": "Cases",
                    "unitSize": 5
                  },
                  "rejectedQuantity": {
                    "amount": 10,
                    "unitOfMeasure": "Cases",
                    "unitSize": 5
                  }
                }
              ]
            }
          }
        ]
      }
    ]
  }
}
```



### Obsolete line item in the purchase order

If the vendor receives an obsolete product in the purchase order, the vendor should reject the item with an acknowledgement code "Rejected" and the "rejectionReason" as "ObsoleteProduct"

Purchase Order

```json
{
  "order": {
    "purchaseOrderNumber": " L8266355",
    "purchaseOrderState": "New",
    "orderDetails": {
      "purchaseOrderDate": "2019-07-16T19:17:34.304Z",
      "purchaseOrderStateChangedDate": "2019-07-16T19:17:34.304Z",
      "purchaseOrderType": "RegularOrder",
      "paymentMethod": "Invoice",
      "buyingParty": {
        "partyId": "NAG1"
      },
      "sellingParty": {
        "partyId": "999US"
      },
      "shipToParty": {
        "partyId": "NAG1"
      },
      "billToParty": {
        "partyId": "NAG1"
      },
      "items": [
        {
          "itemSequenceNumber": "1",
          "amazonProductIdentifier": " ABC123434",
          "vendorProductIdentifier": "028877454078",
          "orderedQuantity": {
            "amount": "10",
            "unitOfMeasure": "Cases",
            "unitSize": "5"
          },
          "isBackOrderAllowed": false,
          "netCost": {
            "amount": "10.2",
            "currencyCode": "USD"
          }
        }
      ]
    }
  }
}
```



Purchase Order Acknowledgement

```json
{
  "acknowledgements": [
    {
      "purchaseOrderNumber": "L8266356",
      "sellingParty": {
        "partyId": "999US"
      },
      "acknowledgementDate": "2019-07-17T19:17:34.304Z",
      "items": [
        {
          "itemSequenceNumber": "1",
          "amazonProductIdentifier": "ABC123438",
          "vendorProductIdentifier": "028877454079",
          "orderedQuantity": {
            "amount": 10,
            "unitOfMeasure": "Cases",
            "unitSize": "5"
          },
          "netCost": {
            "currencyCode": "IN",
            "amount": "100.20"
          },
          "itemAcknowledgements": [
            {
              "acknowledgementCode": "Rejected",
              "acknowledgedQuantity": {
                "amount": 10
              },
              "rejectionReason": " ObsoleteProduct"
            }
          ]
        }
      ]
    }
  ]
}
```



### Confirm partial item quantity and backorder the rest of the quantity

Amazon ordered 10 item quantities. The vendor plans to split shipments and therefore sends an "Accepted" item quantity of 6 and a "BackOrdered" item quantity of 4 to indicate 6 units will be shipped in the first shipment and 4 units in the second one.

Purchase order – (Import Purchase Order)

```json
{
  "order": {
    "purchaseOrderNumber": " L8266357",
    "purchaseOrderState": "Acknowledged",
    "orderDetails": {
      "purchaseOrderDate": "2019-07-16T19:17:34.304Z",
      "purchaseOrderChangedDate": "2019-07-18T16:05:00Z",
      "purchaseOrderStateChangedDate": "2019-07-17T10:00:34.304Z",
      "purchaseOrderType": "RegularOrder",
      "importDetails": {
        "importContainers": "2-20'HC,1-45',1-45'HC",
        "internationalCommercialTerms": "FreeOnBoard",
        "methodOfPayment": "PrepaidBySeller",
        "portOfDelivery": "USA",
        "shippingInstructions": "PREFERENCE IS PALLET-LOAD, BUT IF CONTAINERS ARE FLOOR-LOADED"
      },
      "paymentMethod": "Invoice",
      "buyingParty": {
        "partyId": "XYZ1"
      },
      "sellingParty": {
        "partyId": "999US"
      },
      "shipToParty": {
        "partyId": "XYZ1"
      },
      "billToParty": {
        "partyId": "XYZ1",
        "taxInfo": {
          "taxRegistrationNumber": "12AAXYZ4259Z123",
          "taxRegistrationType": "VAT"
        }
      },
      "items": [
        {
          "itemSequenceNumber": "1",
          "amazonProductIdentifier": " ABC123434",
          "vendorProductIdentifier": "028877454078",
          "orderedQuantity": {
            "amount": "10",
            "unitOfMeasure": "Eaches"
          },
          "isBackOrderAllowed": true,
          "netCost": {
            "amount": "10.2",
            "currencyCode": "USD"
          },
          "listPrice": {
            "amount": "10.2",
            "currencyCode": "USD"
          }
        }
      ]
    }
  }
}
```


Purchase Order Acknowledgement

```json
{
  "acknowledgements": [
    {
      "purchaseOrderNumber": "L8266355",
      "sellingParty": {
        "partyId": "999US"
      },
      "acknowledgementDate": "2019-07-17T19:17:34.304Z",
      "items": [
        {
          "itemSequenceNumber": "1",
          "amazonProductIdentifier": " ABC123434",
          "vendorProductIdentifier": "028877454078",
          "orderedQuantity": {
            "amount": 10,
            "unitOfMeasure": "Eaches"
          },
          "netCost": {
            "currencyCode": "USD",
            "amount": "10.2"
          },
          "itemAcknowledgements": [
            {
              "acknowledgementCode": "Accepted",
              "acknowledgedQuantity": {
                "amount": 6
              },
              "scheduledShipDate": "2019-07-17T19:17:34.304Z"
            }, 
            {
              "acknowledgementCode": "Backordered",
              "acknowledgedQuantity": {
                "amount": 4
              },
              "scheduledShipDate": "2019-07-25T19:17:34.304Z"
            }
          ]
        }
      ]
    }
  ]
}
```



After shipping the first part of the order the vendor provides Amazon with a more accurate date of the second shipment using "scheduledShipDate" for the back-ordered items. Note that vendors should always send full updates with the total ordered quantity for individual line items. Full updates provide explicit visibility into quantities.

Purchase Order Status

```json
{
  "payload": {
    "ordersStatus": [
      {
        "purchaseOrderNumber": "L8266355",
        "purchaseOrderStatus": "OPEN",
        "purchaseOrderDate": "2019-07-16T19:17:34.304Z",
        "lastUpdatedDate": "2019-07-18T16:05:00Z",
        "sellingParty": {
          "partyId": "999US"
        },
        "shipToParty": {
          "partyId": "XYZ1"
        },
        "itemStatus": [
          {
            "itemSequenceNumber": "1",
            "buyerProductIdentifier": "ABC123434",
            "vendorProductIdentifier": "028877454078",
            "netCost": {
              "amount": "10.2",
              "currencyCode": "USD"
            },
            "listPrice": {
              "amount": "10.2",
              "currencyCode": "USD"
            },
            "orderedQuantity": {
              "orderedQuantity": {
                "amount": 10,
                "unitOfMeasure": "Eaches",
                "unitSize": 1
              },
              "orderedQuantityDetails": [
                {
                  "updatedDate": "2019-07-16T19:17:34.304Z",
                  "orderedQuantity": {
                    "amount": 10,
                    "unitOfMeasure": "Eaches",
                    "unitSize": 1
                  }
                }
              ]
            },
            "acknowledgementStatus": {
              "confirmationStatus": "ACCEPTED",
              "acceptedQuantity": {
                "amount": 10,
                "unitOfMeasure": "Eaches",
                "unitSize": 1
              },
              "acknowledgementStatusDetails": [
                {
                  "acknowledgementDate": "2019-07-17T19:17:34.304Z",
                  "acceptedQuantity": {
                    "amount": 10,
                    "unitOfMeasure": "Eaches",
                    "unitSize": 1
                  },
                  "rejectedQuantity": {
                    "amount": 0,
                    "unitOfMeasure": "Eaches",
                    "unitSize": 1
                  }
                }
              ]
            }
          }
        ]
      }
    ]
  }
}
```



### Multiple acknowledgements to cancel initially accepted quantities

A vendor can use this when they discover that they can't fulfill some or all of the units of an order that they initially accepted and they want to inform Amazon that these units will not be shipped.

Purchase Order

```json
{
  "order": {
    "purchaseOrderNumber": " L8266355",
    "purchaseOrderState": "New",
    "orderDetails": {
      "purchaseOrderDate": "2019-07-16T19:17:34.304Z",
      "purchaseOrderStateChangedDate": "2019-07-16T19:17:34.304Z",
      "purchaseOrderType": "RegularOrder",
      "paymentMethod": "Invoice",
      "buyingParty": {
        "partyId": "NAG1"
      },
      "sellingParty": {
        "partyId": "999US"
      },
      "shipToParty": {
        "partyId": "NAG1"
      },
      "billToParty": {
        "partyId": "NAG1"
      },
      "items": [
        {
          "itemSequenceNumber": "1",
          "amazonProductIdentifier": "ABC123434",
          "vendorProductIdentifier": "028877454078",
          "orderedQuantity": {
            "amount": "10",
            "unitOfMeasure": "Cases",
            "unitSize": "5"
          },
          "isBackOrderAllowed": false,
          "netCost": {
            "amount": "10.2",
            "currencyCode": "USD"
          },
          "listPrice": {
            "amount": "10.2",
            "currencyCode": "USD"
          }
        }
      ]
    }
  }
}
```

Purchase Order Acknowledgement

Vendor initially accepted the quantity.

```json
{
  "acknowledgements": [
    {
      "purchaseOrderNumber": "L8266355",
      "sellingParty": {
        "partyId": "999US"
      },
      "acknowledgementDate": "2019-07-17T19:17:34.304Z",
      "items": [
        {
          "itemSequenceNumber": "1",
          "amazonProductIdentifier": "ABC123434",
          "vendorProductIdentifier": "028877454078",
          "orderedQuantity": {
            "amount": 10,
            "unitOfMeasure": "Cases",
            "unitSize": "5"
          },
          "netCost": {
            "currencyCode": "USD",
            "amount": "10.2"
          },
          "itemAcknowledgements": [
            {
              "acknowledgementCode": "Accepted",
              "acknowledgedQuantity": {
                "amount": 10,
                "unitOfMeasure": "Cases",
                "unitSize": "5"
              },
              "scheduledShipDate": "2019-07-17T19:17:34.304Z"
            }
          ]
        }
      ]
    }
  ]
}
```


Later the vendor is not able to fulfill the accepted quantity and sends either a full or a partial cancellation through another purchase order acknowledgement request.

Full cancellation

```json
  {
    "acknowledgements": [
      {
        "purchaseOrderNumber": "L8266355",
        "sellingParty": {
          "partyId": "999US"
        },
        "acknowledgementDate": "2019-07-17T19:17:34.304Z",
        "items": [
          {
            "itemSequenceNumber": "1",
            "amazonProductIdentifier": "ABC123434",
            "vendorProductIdentifier": "028877454078",
            "orderedQuantity": {
              "amount": 10,
              "unitOfMeasure": "Cases",
              "unitSize": "5"
            },
            "netCost": {
              "currencyCode": "USD",
              "amount": "10.2"
            },
            "itemAcknowledgements": [
              {
                "acknowledgementCode": "Rejected",
                "acknowledgedQuantity": {
                  "amount": 10,
                  "unitOfMeasure": "Cases",
                  "unitSize": "5"
                },
                "rejectionReason": "TemporarilyUnavailable"
              }
            ]
          }
        ]
      }
    ]
  }
```


Partial cancellation

```json
{
  "acknowledgements": [
    {
      "purchaseOrderNumber": "L8266355",
      "sellingParty": {
        "partyId": "999US"
      },
      "acknowledgementDate": "2019-07-17T20:10:34.304Z",
      "items": [
        {
          "itemSequenceNumber": "1",
          "amazonProductIdentifier": "ABC123434",
          "vendorProductIdentifier": "028877454078",
          "orderedQuantity": {
            "amount": 10,
            "unitOfMeasure": "Cases",
            "unitSize": "5"
          },
          "netCost": {
            "currencyCode": "USD",
            "amount": "10.2"
          },
          "itemAcknowledgements": [
            {
              "acknowledgementCode": "Accepted",
              "acknowledgedQuantity": {
                "amount": 3,
                "unitOfMeasure": "Cases",
                "unitSize": "5"
              },
              "scheduledShipDate": "2019-07-17T19:17:34.304Z"
            }, 
            {
              "acknowledgementCode": "Rejected",
              "acknowledgedQuantity": {
                "amount": 7,
                "unitOfMeasure": "Cases",
                "unitSize": "5"
              },
              "rejectionReason": "TemporarilyUnavailable"
            }
          ]
        }
      ]
    }
  ]
}
```

Purchase order status after subsequent partial cancellation

```json
{
  "payload": {
    "ordersStatus": [
      {
        "purchaseOrderNumber": "L8266355",
        "purchaseOrderStatus": "OPEN",
        "purchaseOrderDate": "2019-07-16T19:17:34.304Z",
        "lastUpdatedDate": "2019-07-17T19:17:34.304Z",
        "sellingParty": {
          "partyId": "999US"
        },
        "shipToParty": {
          "partyId": "NAG1"
        },
        "itemStatus": [
          {
            "itemSequenceNumber": "1",
            "buyerProductIdentifier": "ABC123434",
            "vendorProductIdentifier": "028877454078",
            "netCost": {
              "amount": "10.2",
              "currencyCode": "USD"
            },
            "listPrice": {
              "amount": "10.2",
              "currencyCode": "USD"
            },
            "orderedQuantity": {
              "orderedQuantity": {
                "amount": 10,
                "unitOfMeasure": "Cases",
                "unitSize": 5
              },
              "orderedQuantityDetails": [
                {
                  "updatedDate": "2019-07-16T19:17:34.304Z",
                  "orderedQuantity": {
                    "amount": 10,
                    "unitOfMeasure": "Cases",
                    "unitSize": 5
                  }
                }
              ]
            },
            "acknowledgementStatus": {
              "confirmationStatus": "PARTIALLY_ACCEPTED",
              "acceptedQuantity": {
                "amount": 3,
                "unitOfMeasure": "Cases",
                "unitSize": 5
              },
              "rejectedQuantity": {
                "amount": 7,
                "unitOfMeasure": "Cases",
                "unitSize": 5
              },
              "acknowledgementStatusDetails": [
                {
                  "acknowledgementDate": "2019-07-17T19:17:34.304Z",
                  "acceptedQuantity": {
                    "amount": 10,
                    "unitOfMeasure": "Cases",
                    "unitSize": 5
                  },
                  "rejectedQuantity": {
                    "amount": 0,
                    "unitOfMeasure": "Cases",
                    "unitSize": 5
                  }
                }, 
                {
                  "acknowledgementDate": "2019-07-17T20:10:34.304Z",
                  "acceptedQuantity": {
                    "amount": 3,
                    "unitOfMeasure": "Cases",
                    "unitSize": 5
                  },
                  "rejectedQuantity": {
                    "amount": 7,
                    "unitOfMeasure": "Cases",
                    "unitSize": 5
                  }
                }
              ]
            }
          }
        ]
      }
    ]
  }
}
```


What is the Vendor Shipments API?
=================================

Vendors can use the Vendor Shipments API (Shipments API) to exchange shipment related documents with Amazon. The [SubmitShipmentConfirmations](https://github.com/amzn/selling-partner-api-docs/blob/main/references/vendor-shipments-api/vendorShipments.md#SubmitShipmentConfirmations) operation lets vendors send shipment confirmations for a confirmed order.

The following operations are included in the Shipments API:

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
        <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/vendor-shipments-api/vendorShipments.md#SubmitShipmentConfirmations">SubmitShipmentConfirmations</a>
      </td>
      <td>POST</td>
      <td>/vendor/shipping/v1/shipmentConfirmations</td>
      <td>Submit one or more shipment confirmations to Amazon.</td>
    </tr>
  </tbody>
</table>


## Submit Shipment Confirmations

### Usage

The [SubmitShipmentConfirmations](https://github.com/amzn/selling-partner-api-docs/blob/main/references/vendor-shipments-api/vendorShipments.md#SubmitShipmentConfirmations) operation lets vendors submit shipment confirmations to Amazon. Your shipment confirmation allows us to efficiently receive and process your shipments. It contains information about the items being shipped, including purchase order number, ship date, estimated delivery date, lot number, expiration date and SSCC.

By receiving a valid and timely shipment confirmation, we can correctly anticipate the shipments you send us. Here are some of the advantages of submitting shipment confirmations:

-   Shipment confirmations allow us to collaborate more effectively with carriers in tracking and receiving your shipments. This allows us to effectively plan our labor resources and helps ensure quicker and more efficient receipt of your shipment, which means you can invoice your POs faster.

-   Shipment confirmation allows Amazon to keep track of incoming inventory and create automated orders to ensure that items do not go out of stock.

-   Shipment confirmations gives greater visibility into in-transit products, which enables us to more accurately reflect item availability (deliver by period) to end customers.

-   Amazon's PO cancellation policies allow cancellation of outstanding PO shipments. However, POs with accurate shipment confirmation alert our internal systems of in-transit status. This can help avoid unnecessary PO cancellations, chargebacks, and freight refusals.

The lack of a valid shipment confirmations can result in:

-   Inadequate visibility for incoming shipments.

-   Errors in reconciling the physical shipments with purchase orders.

-   Manual follow-ups to resolve discrepancies.

-   Providing PODs (proof of delivery) for invoicing.

**Shipment Confirmation - Replace**

Shipment confirmations where the "shipmentConfirmationType" is "Replace" lets vendors correct previously submitted shipment confirmations by sending an updated version. The second shipment confirmation call will completely overwrite the first shipment confirmation data.

The main advantage is to improve booking accuracy by updating faulty shipment confirmations after initial submission.

**How does it work?**

In order to replace a previously submitted shipment confirmation, a second shipment confirmation can be sent. The "shipmentIdentifier" and "sellingParty"-&gt; "partyId" needs to be identical for both transmissions, so that we can successfully overwrite the previous version of the shipment confirmation.

**Scope of Shipment Confirmation - Replace**:

-   All shipment confirmation values can be edited except for the "shipmentIdentifier" and "sellingParty"-&gt;"partyId", which need to remain identical for a successful Shipment Confirmation - Replace.

-   Pallet, carton, and shipped quantity cannot be increased but only reduced. In order to increase volumes, you need to send a second shipment confirmation with a new "shipmentIdentifier". You can use the same BOL reference if the additional units are to be delivered with the same shipment.

-   A shipment confirmation that is submitted using the API can only be edited by submitting another shipment confirmation using the API. A shipment confirmation created in Vendor Central cannot be edited using the API, and vice versa.

-   Replacing a shipment confirmation is only possible within 7 days after the initial shipment confirmation, and then only if the shipment has not yet reached the Amazon fulfillment center.

**Verification of successfully submitted shipment confirmations**

Vendors can verify the status of their original/replaced shipment confirmations via "Vendor Central &gt;Orders&gt; Shipments" or by using the Transaction Status API. Allow the system up to 30 min to show the original/replaced version once submitted. If Vendor Central is not showing the correct values for the replaced shipment confirmation, open a "Contact Us" case in Vendor Central.

The following diagram shows the integration workflow when submitting shipment confirmations.

<img src="media\SubmitShipmentConfirmations.png" style="width:5.531in;height:7.072" alt="Vendor shipments  workflow when submitting shipment confirmations" />

### Business Requirements

-   There is a limit of 100 shipment confirmations for every truck load shipment. This means you can send separate shipment confirmation at the PO level or carton level only if the total number of individual shipment confirmations is less than or equal to 100 for that truck load (TL) / less than truck load (LTL) shipment. We recommend that you send a single shipment confirmation for the entire TL/LTL shipment, including all PO and carton details.

-   Amazon must receive the shipment confirmation prior to the product being received on at the Amazon fulfillment center. Missing or delayed shipment confirmation will result in chargebacks.

-   For Small Parcel Shipments, a shipment confirmation is required for every package/carton.

-   The following is required by Amazon and is measured to track compliance:

    -   For palletized deliveries, vendors must send a shipment confirmation before requesting a delivery slot at the Amazon fulfillment center, since appointments are only provided if a valid shipment confirmation is found in the Amazon systems. For exceptions, refer to the local shipment confirmation Help pages to understand the available options. For parcels, the shipment confirmation needs to be submitted before items are shipped. Missing or delayed shipment confirmation will result in chargebacks.
    
    -   A shipment confirmation needs to be for one delivery from one vendor and can be for no more than one truck. Shipments in multiple trucks, to multiple Amazon fulfillment centers, from multiple vendor accounts or with arrivals on multiple days require multiple shipment confirmations.
    
    -   If several smaller shipments for the same vendor account are combined in a larger shipment and multiple shipment confirmations are required, you can use the umbrella BOL option according to the following example:

        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;**Shipment Confirmation 1**<br>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"billOfLadingNumber": "BOL1"<br>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"shipmentIdentifier": "SHIPMENT CONFIRMATION_ID1"<br>
        
        
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;**Shipment Confirmation 2**<br>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"billOfLadingNumber": "BOL1"<br>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"shipmentIdentifier": "SHIPMENT CONFIRMATION_ID2"<br>
<br>

### Country Specific Business Requirements 

<table>
  <thead>
    <tr class="header">
      <th>Functionality</th>
      <th>Business Definition</th>
      <th>India</th>
      <th>Europe</th>
      <th>North America</th>
    </tr>
  </thead>
  <tbody>
    <tr class="odd">
      <td>
        Bill of Lading Number / Delivery Quote
        <h2 id="section-2"/>
      </td>
      <td>
        BOL number is the unique number assigned by the vendor. The BOL present in the shipment confirmation ideally matches the paper BOL provided with the shipment, but that is not required. See the detailed specifications in the references below the table. The BOL is the reference that is used for appointment booking and shipment label creation.
        <p>The Delivery Quote number is an alternative to a Bill of Lading as a reference number for a shipment.</p>
        <h2 id="section-3"/>
      </td>
      <td>
        Conditional
        <h2 id="section-4"/>
      </td>
      <td>Mandatory for all shipment confirmations.</td>
      <td>Mandatory for TL/LTL shipments.</td>
    </tr>
    <tr class="even">
      <td>Carrier Shipment Reference Number (PRO#)</td>
      <td>The PRO number (Pro Number) is a unique number assigned by the carrier. It is used to identify and track the shipment that goes out for delivery.</td>
      <td>Mandatory for all shipment confirmations.</td>
      <td>Optional</td>
      <td>Mandatory for all shipment confirmations.</td>
    </tr>
    <tr class="odd">
      <td>Shipped Date</td>
      <td>
        Date on which the shipment leaves the vendor's warehouse.
        <h2 id="section-5"/>
      </td>
      <td>
        Mandatory for all shipment confirmations.
        <h2 id="section-6"/>
      </td>
      <td>Mandatory for all shipment confirmations.</td>
      <td>Mandatory for all shipment confirmations.</td>
    </tr>
    <tr class="even">
      <td>
        Estimated Delivery Date
        <h2 id="section-7"/>
      </td>
      <td>
        Date on which the shipment is expected to reach Amazon's fulfillment center. This needs to be an estimate based on the average transit time between the ship from location and the destination. The exact appointment time will be provided by Amazon and is potentially not known when creating the shipment.
        <h2 id="section-8"/>
      </td>
      <td>
        Mandatory for all shipment confirmations.
        <h2 id="section-9"/>
      </td>
      <td>Mandatory for all shipment confirmations.</td>
      <td>Mandatory for all shipment confirmations.</td>
    </tr>
    <tr class="odd">
      <td>Carton Count</td>
      <td>Number of cartons present in the shipment. Units that are stacked on the pallet without the outer carton are counted as 1 unit = 1 carton. The carton count is required at the shipment level.</td>
      <td>Mandatory for all shipment confirmations.</td>
      <td>Mandatory for all shipment confirmations.</td>
      <td>Mandatory for all shipment confirmations.</td>
    </tr>
    <tr class="even">
      <td>Pallet Count</td>
      <td>Number of pallets present in the shipment. For pure parcel shipments the value 0 needs to be indicated, all volumes that reach the FC on a pallet need to have a minimum of 1 stated in this segment. The information is required at shipment level.</td>
      <td>Mandatory for all shipment confirmations for palletized deliveries.</td>
      <td>Mandatory for all shipment confirmations.</td>
      <td>Recommended with Tl/LTL shipments.</td>
    </tr>
    <tr class="odd">
      <td>Standard carrier Alpha Code (SCAC)</td>
      <td>Code that identifies the carrier for the shipment. The Standard Carrier Alpha Code (SCAC) is a unique two-to-four-letter code used to identify a carrier. Carrier SCAC codes are assigned and maintained by the NMFTA (National Motor Freight Association).</td>
      <td>Optional</td>
      <td>Optional</td>
      <td>Mandatory for all shipment confirmations.</td>
    </tr>
    <tr class="even">
      <td>Shipping Location (Ship To)</td>
      <td>Party Id/Warehouse Code of the location where the products are being shipped to. API schema field name is "shipToParty"</td>
      <td>Mandatory for all shipment confirmations.</td>
      <td>Mandatory for all shipment confirmations.</td>
      <td>Mandatory for all shipment confirmations.</td>
    </tr>
    <tr class="odd">
      <td>Supplier Identification</td>
      <td>Supplier identification of the supplier who ships the goods to Amazon. API schema field name is "sellingParty".</td>
      <td>Mandatory for all shipment confirmations.</td>
      <td>Mandatory for all shipment confirmations.</td>
      <td>Optional</td>
    </tr>
    <tr class="even">
      <td>Ship From</td>
      <td>Address (ZIP code) and country reference of the location where the products are physically shipped from.</td>
      <td>Mandatory for all shipment confirmations.</td>
      <td>Mandatory for all shipment confirmations.</td>
      <td>Mandatory for all shipment confirmations.</td>
    </tr>
    <tr class="odd">
      <td>Amazon Reference Number (only for WePay Shipments).</td>
      <td>Amazon Reference Number as received in the related purchase order for a WePay Shipment.</td>
      <td>
        Mandatory only for shipment confirmations
        <p>(for WePay Shipments).</p>
      </td>
      <td>
        Mandatory only for shipment confirmations
        <p>(for WePay Shipments).</p>
      </td>
      <td>Mandatory for Collect Shipments.</td>
    </tr>
    <tr class="even">
      <td>Purchase Order Number</td>
      <td>The Amazon Purchase Order Number. Written authorization for a supplier to ship products at a specified price, which becomes a legally binding contract once the supplier accepts it.</td>
      <td>Mandatory on header or line item level.</td>
      <td>Mandatory on header or line item level.</td>
      <td>Mandatory on header or line item level.</td>
    </tr>
    <tr class="odd">
      <td>Serial Shipping Container Code (SSCC)</td>
      <td>Unique 18-digit Serial Shipment Container Code (SSCC) to be included to define a Pallet/Carton.</td>
      <td>
        Recommended for all shipment confirmations
        within the packaging unit.
      </td>
      <td>
        Mandatory for all shipment confirmations
        within the packaging unit.
      </td>
      <td>Mandatory for every carton, optional for pallets.</td>
    </tr>
    <tr class="even">
      <td>Item Identification</td>
      <td>Vendor SKU of the product.</td>
      <td>Mandatory for all shipment confirmations.</td>
      <td>Mandatory for all shipment confirmations.</td>
      <td>Mandatory for all shipment confirmations.</td>
    </tr>
    <tr class="odd">
      <td>Lot Number</td>
      <td>The batch or lot number associates an item with information the manufacturer considers relevant for traceability of the trade item to which the Element String is applied. The data may refer to the trade item itself or to items contained.</td>
      <td>Mandatory for Perishable Items.</td>
      <td>Mandatory for Perishable Items.</td>
      <td>Mandatory for Perishable Items.</td>
    </tr>
    <tr class="even">
      <td>Expiry Date</td>
      <td>The date that determines the limit of consumption or the use of a product. Its meaning is determined based on the trade item context.</td>
      <td>Mandatory for Perishable Items.</td>
      <td>Mandatory for Perishable Items.</td>
      <td>Either Expiry or Manufacturer Date and Shelf Life is required.</td>
    </tr>
    <tr class="odd">
      <td>Manufacture Date</td>
      <td>Production, Packaging or Assembly Date determined by the manufacturer. Its meaning is determined based on the trade item context.</td>
      <td>Optional</td>
      <td>Optional</td>
      <td>Either Expiry or Manufacturer Date and Shelf Life is required.</td>
    </tr>
    <tr class="even">
      <td>Quantity</td>
      <td>Number of units shipped for a specific item.</td>
      <td>Mandatory for all shipment confirmations.</td>
      <td>Mandatory for all shipment confirmations.</td>
      <td>Mandatory for all shipment confirmations.</td>
    </tr>
  </tbody>
</table>



#### Additional Field Explanations

##### Bill of Lading (BOL\#)

The Bill of Lading (BOL\#) is the reference number **needed for the appointment booking** at Amazon. This reference has to be provided when Amazon is asking for a valid shipment confirmation of the shipment. It is the default reference number of the document accompanying the physical shipment. The BOL\# in the shipment confirmation should match the BOL\# provided in the shipment documentation. 

Take note of the following while defining the BOL\#:

- BOL\# must be unique for every shipment and cannot be repeated.

- BOL\# can be the physical bill of lading reference, but if it is not, ensure its uniqueness by:

   -   Creating the BOL\# with a minimum of 8 digits.
    
   -   Using the Amazon vendor code as a prefix (e.g. ABCD193939393).

- BOL\# must not be a date/time.

##### Shipment Identification

This field is a unique ID (uniqueness is defined within the context of the vendor) which represents this shipment confirmation. Failure to provide a "Shipment Identification" will result in the shipment confirmation being rejected. Please ensure that the ID being sent has not been used in the last 365 days.

##### Shipped Date

This field indicates the date of departure of the shipment from the vendor's location. Vendors are requested to send the shipment confirmations within 30 minutes of departure from their warehouse/distribution center or at least 6 hours prior to the appointment time at the Amazon fulfillment center, whichever is sooner.

The ship date mentioned in the shipment confirmation should be either within past 7 calendar days (from the shipment confirmation submission date) or up to 2 calendar days in the future (from the shipment confirmation submission date).

##### Estimated Delivery Date

This is a rough estimate, based on experience, of when a shipment is expected to be delivered to the Amazon fulfillment center. Vendors are required to determine this based on the average transit time of the carrier. This information helps us plan for the shipment if we do not get an Estimated Delivery Date from the carrier.

This date needs to be provided for each shipment, even though an appointment date is potentially unknown at this stage.

##### Serial Shipment Container Code (SSCC)

Vendors are required to provide carton content details in their shipment confirmation messages to enable Amazon to process receipts using a highly automated approach, called License Plate or LP Receive. This is the required receive process, in which items are received by scanning a Serial Shipment Container Code (SSCC) barcode on the outside of a carton or pallet, eliminating the need to scan each item within the carton/pallet. This process has a number of significant advantages, including increased efficiency, improved receiving accuracy, more accurate payment, and faster payment cycle time.

In order to let vendors choose the technical solution they want, Amazon decided not to strictly follow the GS1-128 solution. To be compliant with Amazon License Plate requirements, a SSCC should be a unique 18-digit code that defines a pallet or carton, it cannot be repeated within 365 days and has to be barcoded on the carton label as well as included into the shipment confirmation message. Additionally, the barcode on the physical label has to match 100% to the SSCC in shipment confirmation. As a result, vendors wanting to implement GS1-128 are asked to add a '00' at the beginning of their SSCC within the shipment confirmation.

For additional details and the requirements for the physical shipment, please refer the License Plate Receive manual in the Vendor Central Resource Center.

##### Expiration Date

The expiration date is the date that determines the limit of consumption or use of a product. It is determined based on the trade item context (e.g. for food this indicates the possibility of a direct health risk resulting from use of the product after the date, for pharmaceutical products it indicates the possibility of an indirect health risk resulting from the ineffectiveness of the product after the date). It is often referred to as "use by date" or "maximum durability date."

##### Manufacturing Date

This is the date when the goods were packaged or manufactured. This field should be provided if an item is perishable or has a defined shelf life.

##### Lot Number

The batch or lot number associates an item with information that the manufacturer considers relevant for traceability of the trade item to which the Element String is applied. The data may refer to the trade item itself or to items contained. The number may be, for example, a production lot number, a shift number, a machine number, a time, or an internal production code.

##### Usage of Expiration Date / Manufacturing Date / Lot Numbers in the shipment confirmation

These fields are mandatory only for perishable items, i.e. for those items where the 'is expiration dated product' attribute was is 'Yes' in the NIS (new item set-up) form. 

Take note of the following while defining the Expiration Dates / Manufacturing Dates / Lot Numbers in the shipment confirmation:

- Expiration Dates / Manufacturing Dates / Lot Numbers must be sent on item level.

- A case/pallet can have multiple items (ASINs), each with individual Expiration Dates / Manufacturing Dates / Lot Numbers.

- One item (ASIN) should not have multiple Expiration Dates / Manufacturing Dates / Lot Numbers within the same Case/Pallet.

Vendors are required to provide Expiration Date and Manufacturing Date in the shipment confirmation in YYYYMMDD format.


## Shipment Confirmation Use Cases

### Small parcel with expiration and lot numbers

```json
{
  "shipmentConfirmations": [
    {
      "shipmentIdentifier": "00050003",
      "shipmentConfirmationType": "Original",
      "shipmentType": "TruckLoad",
      "shipmentStructure": "LooseAssortmentCase",
      "transportationDetails": {
        "carrierScac": "UPSN",
        "billOfLadingNumber": "02440000"
      },
      "amazonReferenceNumber": "ARN_Number",
      "shipmentConfirmationDate": "2019-07-29T21:56:18.575Z",
      "shippedDate": "2019-07-29T21:56:18.575Z",
      "estimatedDeliveryDate": "2019-07-29T21:56:18.575Z",
      "sellingParty": {
        "partyId": "VENDORCODE"
      },
      "shipFromParty": {
        "address": {
          "name": "ABC electronics warehouse",
          "addressLine1": "DEF 1st street",
          "city": "Lisses",
          "stateOrRegion": "abcland",
          "postalCode": "91090",
          "countryCode": "DE"
        },
        "partyId": "ABCED"
      },
      "shipToParty": {
        "partyId": "AMZWAREHOUSECODE"
      },
      "shipmentMeasurements": {
        "grossShipmentWeight": {
          "unitOfMeasure": "Kg",
          "value": "120.45"
        },
        "shipmentVolume": {
          "unitOfMeasure": "CuFt",
          "value": "2.4"
        },
        "cartonCount": 2
      },
      "shippedItems": [
        {
          "itemSequenceNumber": "001",
          "amazonProductIdentifier": "AB1234233",
          "vendorProductIdentifier": "VN24343334",
          "shippedQuantity": {
            "amount": 50,
            "unitOfMeasure": "Eaches",
            "unitSize": 1
          },
          "itemDetails": {
            "purchaseOrderNumber": "PO1234BD",
            "lotNumber": " 12345",
            "expiry": {
              "expiryDate": "2019-11-29T21:56:18.575Z"
            }
          }
        }
      ],
      "cartons": [ 
        {
          "cartonIdentifiers": [
            {
              "containerIdentificationType": "SSCC",
              "containerIdentificationNumber": "00102234567666698888"
            }
          ],
          "cartonSequenceNumber": " 001",
          "trackingNumber": "UPS TRACKING NUMBER",
          "items": [
            {
              "itemReference": "001",
              "shippedQuantity": {
                "amount": 25,
                "unitOfMeasure": "Eaches",
                "unitSize": 1
              }
            }
          ]
        }, 
        {
          "cartonIdentifiers": [
            {
              "containerIdentificationType": "SSCC",
              "containerIdentificationNumber": "00102234567666698889"
            }
          ],
          "cartonSequenceNumber": " 002",
          "trackingNumber": "UPS TRACKING NUMBER",
          "items": [
            {
              "itemReference": "001",
              "shippedQuantity": {
                "amount": 25,
                "unitOfMeasure": "Eaches",
                "unitSize": 1
              }
            }
          ]
        }
      ]
    }
  ]
}
```

### Palletized truck load with multiple items

```json
{
  "shipmentConfirmations": [
    {
      "shipmentIdentifier": "00050003",
      "shipmentConfirmationType": "Original",
      "shipmentType": "TruckLoad",
      "shipmentStructure": "PalletizedAssortmentCase",
      "transportationDetails": {
        "transportationMode": "Road",
        "billOfLadingNumber": "02440000"
      },
      "shipmentConfirmationDate": "2019-08-07T19:56:45.632Z",
      "shippedDate": "2019-08-07T19:56:45.632Z",
      "estimatedDeliveryDate": "2019-08-07T19:56:45.632Z",
      "sellingParty": {
        "partyId": "VENDORCODE"
      },
      "shipFromParty": {
        "address": {
          "name": "ABC electronics warehouse",
          "addressLine1": "DEF 1st street",
          "city": "Lisses",
          "stateOrRegion": "abcland",
          "postalCode": "91090",
          "countryCode": "DE"
        },
        "partyId": "VENDORWAREHOUSECODE"
      },
      "shipToParty": {
        "partyId": "AMZWAREHOUSECODE"
      },
      "shipmentMeasurements": {
        "grossShipmentWeight": {
          "unitOfMeasure": "Kg",
          "value": "250"
        },
        "shipmentVolume": {
          "unitOfMeasure": "CuFt",
          "value": "2.4"
        },
        "palletCount": 2
      },
      "shippedItems": [
        {
          "itemSequenceNumber": "001",
          "vendorProductIdentifier": "9782700001659",
          "shippedQuantity": {
            "amount": 100,
            "unitOfMeasure": "Eaches",
            "unitSize": 1
          }
        }, 
        {
          "itemSequenceNumber": "002",
          "vendorProductIdentifier": "9782700001000",
          "shippedQuantity": {
            "amount": 400,
            "unitOfMeasure": "Eaches",
            "unitSize": 1
          }
        }
      ],
      "cartons": [
        {
          "cartonIdentifiers": [
            {
              "containerIdentificationType": "SSCC",
              "containerIdentificationNumber": "00102234567666698888"
            }
          ],
          "cartonSequenceNumber": "001",
          "items": [
            {
              "itemReference": "001",
              "shippedQuantity": {
                "amount": 25,
                "unitOfMeasure": "Eaches",
                "unitSize": 1
              },
              "itemDetails": {
                "purchaseOrderNumber": "1BBBAAAA",
                "lotNumber": "1045",
                "maximumRetailPrice": {
                  "currencyCode": "EUR",
                  "amount": "89.00"
                },
                "handlingCode": "Oversized"
              }
            }, 
            {
              "itemReference": "002",
              "shippedQuantity": {
                "amount": 100,
                "unitOfMeasure": "Eaches",
                "unitSize": 1
              },
              "itemDetails": {
                "purchaseOrderNumber": "1BBBAACC",
                "lotNumber": "1087",
                "maximumRetailPrice": {
                  "currencyCode": "EUR",
                  "amount": "120.00"
                },
                "handlingCode": "Oversized"
              }
            }
          ]
        }, 
        {
          "cartonIdentifiers": [
            {
              "containerIdentificationType": "SSCC",
              "containerIdentificationNumber": "00102234567666698999"
            }
          ],
          "cartonSequenceNumber": "002",
          "items": [
            {
              "itemReference": "001",
              "shippedQuantity": {
                "amount": 25,
                "unitOfMeasure": "Eaches",
                "unitSize": 1
              },
              "itemDetails": {
                "purchaseOrderNumber": "1BBBAACD",
                "lotNumber": "1045",
                "maximumRetailPrice": {
                  "currencyCode": "EUR",
                  "amount": "89.00"
                },
                "handlingCode": "Oversized"
              }
            }, 
            {
              "itemReference": "002",
              "shippedQuantity": {
                "amount": 100,
                "unitOfMeasure": "Eaches",
                "unitSize": 1
              },
              "itemDetails": {
                "purchaseOrderNumber": "1BBBAADD",
                "lotNumber": "1087",
                "maximumRetailPrice": {
                  "currencyCode": "EUR",
                  "amount": "120.00"
                },
                "handlingCode": "Oversized"
              }
            }
          ]
        }, 
        {
          "cartonIdentifiers": [
            {
              "containerIdentificationType": "SSCC",
              "containerIdentificationNumber": "00102234567666698669"
            }
          ],
          "cartonSequenceNumber": "003",
          "items": [
            {
              "itemReference": "001",
              "shippedQuantity": {
                "amount": 25,
                "unitOfMeasure": "Eaches",
                "unitSize": 1
              },
              "itemDetails": {
                "purchaseOrderNumber": "1BBBAACD",
                "lotNumber": "1045",
                "maximumRetailPrice": {
                  "currencyCode": "EUR",
                  "amount": "89.00"
                },
                "handlingCode": "Oversized"
              }
            }, 
            {
              "itemReference": "002",
              "shippedQuantity": {
                "amount": 100,
                "unitOfMeasure": "Eaches",
                "unitSize": 1
              },
              "itemDetails": {
                "purchaseOrderNumber": "1BBBAADD",
                "lotNumber": "1087",
                "maximumRetailPrice": {
                  "currencyCode": "EUR",
                  "amount": "120.00"
                },
                "handlingCode": "Oversized"
              }
            }
          ]
        }, 
        {
          "cartonIdentifiers": [
            {
              "containerIdentificationType": "SSCC",
              "containerIdentificationNumber": "00102234567666697799"
            }
          ],
          "cartonSequenceNumber": "004",
          "items": [
            {
              "itemReference": "001",
              "shippedQuantity": {
                "amount": 25,
                "unitOfMeasure": "Eaches",
                "unitSize": 1
              },
              "itemDetails": {
                "purchaseOrderNumber": "1BBBAACD",
                "lotNumber": "1045",
                "maximumRetailPrice": {
                  "currencyCode": "EUR",
                  "amount": "89.00"
                },
                "handlingCode": "Oversized"
              }
            }, 
              {
              "itemReference": "002",
              "shippedQuantity": {
                "amount": 100,
                "unitOfMeasure": "Eaches",
                "unitSize": 1
              },
              "itemDetails": {
                "purchaseOrderNumber": "1BBBAADD",
                "lotNumber": "1087",
                "maximumRetailPrice": {
                  "currencyCode": "EUR",
                  "amount": "120.00"
                },
                "handlingCode": "Oversized"
              }
            }
          ]
        }
      ],
      "pallets": [
        {
          "palletIdentifiers": [
            {
              "containerIdentificationType": "SSCC",
              "containerIdentificationNumber": "00102234567898098745"
            }
          ],
          "tier": 1,
          "block": 2,
          "dimensions": {
            "length": "1.2",
            "width": "0.8",
            "height": "1",
            "unitOfMeasure": "In"
          },
          "weight": {
            "unitOfMeasure": "Kg",
            "value": "55"
          },
          "cartonReferenceDetails": {
            "cartonCount": 2,
            "cartonReferenceNumbers": [
              "001",
              "002"
            ]
          }
        }, 
        {
          "palletIdentifiers": [
            {
              "containerIdentificationType": "SSCC",
              "containerIdentificationNumber": "00102234567898098700"
            }
          ],
          "tier": 1,
          "block": 2,
          "dimensions": {
            "length": "1.2",
            "width": "0.8",
            "height": "1",
            "unitOfMeasure": "In"
          },
          "weight": {
            "unitOfMeasure": "Kg",
            "value": "55"
          },
          "cartonReferenceDetails": {
            "cartonCount": 2,
            "cartonReferenceNumbers": [
              "003",
              "004"
            ]
          }
        }
      ]
    }
  ]
}
```



### Less than truck load shipment with palletized standard cases

```json
{
  "shipmentConfirmations": [
    {
      "shipmentIdentifier": "00050003",
      "shipmentConfirmationType": "Original",
      "shipmentType": "LessThanTruckLoad",
      "shipmentStructure": "PalletizedStandardCase",
      "transportationDetails": {
        "transportationMode": "Road",
        "billOfLadingNumber": "02440000"
      },
      "shipmentConfirmationDate": "2019-08-07T19:56:45.632Z",
      "shippedDate": "2019-08-07T19:56:45.632Z",
      "estimatedDeliveryDate": "2019-08-07T19:56:45.632Z",
      "sellingParty": {
        "partyId": "VENDORCODE"
      },
      "shipFromParty": {
        "address": {
          "name": "ABC electronics warehouse",
          "addressLine1": "DEF 1st street",
          "city": "Lisses",
          "stateOrRegion": "abcland",
          "postalCode": "91090",
          "countryCode": "DE"
        },
        "partyId": "VENDORWAREHOUSECODE"
      },
      "shipToParty": {
        "partyId": "AMZWAREHOUSECODE"
      },
      "shipmentMeasurements": {
        "grossShipmentWeight": {
          "unitOfMeasure": "Kg",
          "value": "120.45"
        },
        "shipmentVolume": {
          "unitOfMeasure": "CuFt",
          "value": "2.4"
        },
        "palletCount": 1
      },
      "shippedItems": [
        {
          "itemSequenceNumber": "001",
          "vendorProductIdentifier": "9782700001659",
          "shippedQuantity": {
            "amount": 100,
            "unitOfMeasure": "Eaches",
            "unitSize": 1
          },
          "itemDetails": {
            "purchaseOrderNumber": "1BBBAAAA",
            "lotNumber": "1045",
            "maximumRetailPrice": {
              "currencyCode": "EUR",
              "amount": "299.00"
            },
            "handlingCode": "Oversized"
          }
        }
      ],
      "cartons": [
        {
          "cartonIdentifiers": [
            {
              "containerIdentificationType": "SSCC",
              "containerIdentificationNumber": "00102234567666698888"
            }
          ],
          "cartonSequenceNumber": "001",
          "items": [
            {
              "itemReference": "001",
              "shippedQuantity": {
                "amount": 25,
                "unitOfMeasure": "Eaches",
                "unitSize": 1
              }
            }
          ]
        }, 
        {
          "cartonIdentifiers": [
            {
              "containerIdentificationType": "SSCC",
              "containerIdentificationNumber": "00102234567666699999"
            }
          ],
          "cartonSequenceNumber": "002",
          "items": [
            {
              "itemReference": "001",
              "shippedQuantity": {
                "amount": 25,
                "unitOfMeasure": "Eaches",
                "unitSize": 1
              }
            }
          ]
        }, 
        {
          "cartonIdentifiers": [
            {
              "containerIdentificationType": "SSCC",
              "containerIdentificationNumber": "00102234567666696666"
            }
          ],
          "cartonSequenceNumber": "003",
          "items": [
            {
              "itemReference": "001",
              "shippedQuantity": {
                "amount": 25,
                "unitOfMeasure": "Eaches",
                "unitSize": 1
              }
            }
          ]
        }, 
        {
          "cartonIdentifiers": [
            {
              "containerIdentificationType": "SSCC",
              "containerIdentificationNumber": "00102234567666697777"
            }
          ],
          "cartonSequenceNumber": "004",
          "items": [
            {
              "itemReference": "001",
              "shippedQuantity": {
                "amount": 25,
                "unitOfMeasure": "Eaches",
                "unitSize": 1
              }
            }
          ]
        }
      ],
      "pallets": [
        {
          "palletIdentifiers": [
            {
              "containerIdentificationType": "SSCC",
              "containerIdentificationNumber": "00102234567898098745"
            }
          ],
          "tier": 2,
          "block": 2,
          "dimensions": {
            "length": "1.2",
            "width": "0.8",
            "height": "1",
            "unitOfMeasure": "In"
          },
          "weight": {
            "unitOfMeasure": "Kg",
            "value": "120.45"
          },
          "cartonReferenceDetails": {
            "cartonCount": 4,
            "cartonReferenceNumbers": [
              "001",
              "002",
              "003",
              "004"
            ]
          }
        }
      ]
    }
  ]
}
```

What is the Vendor Payments API?
================================

Using the Vendor Payments API, vendors can exchange payment related documents with Amazon. The Submit Invoices API lets vendors send vendor invoices to Amazon for confirmed and shipped orders.

The following operations are included:

| **Operation**    | **HTTP Method** | **Path**     | **Description**                                      |
|-----------------|-----------------|------------------------------|------------------------------------------------------|
| [submitInvoices](https://github.com/amzn/selling-partner-api-docs/blob/main/references/vendor-invoices-api/vendorInvoices.md#submitInvoices) | POST            | /vendor/payments/v1/invoices | Submits one or more vendor invoices to Amazon |

Note: The submitInvoices operation can be used to submit credit notes in Europe.

## Submit Invoices

### Usage

The [submitInvoices](https://github.com/amzn/selling-partner-api-docs/blob/main/references/vendor-invoices-api/vendorInvoices.md#submitInvoices) operation lets vendors submit vendor invoices to request payment from Amazon for items shipped. Using this API, vendors can submit multiple invoices in a single API call.

Items should be invoiced only after they are confirmed and shipped to Amazon. Otherwise the invoice will be rejected.

An invoice with correct information will be processed by Amazon without any human interaction, which means that the vendor receives payment more quickly.

Invoices with incorrect information will be rejected in Amazon's payee system, so sending correct information is important. See the business requirements section to learn how to create invoices with correct information.

### Parallel testing of invoice submission

Vendors need to complete parallel testing with our payments system before they can start using the Submit Invoices API for payment processing. When vendors begin sending their invoices using the API, the parallel testing phase begins. During the parallel testing phase, vendors send both paper and API invoices for all orders shipped. Vendors are required to parallel test until the content of at least 5 to 10 EDI invoice files is validated. Parallel testing is conducted with production POs and invoices. The Amazon AP team will contact you when parallel testing is complete, or if there are any content discrepancies in your invoices. When a vendor receives an email saying parallel testing is complete, they no longer need to send paper invoices. From that moment on they can process their payments by sending their invoices using the API.

### Verification of successfully submitted invoices

The Transaction Status API doesn't show the actual status of invoice processing, just the status of the semantic validations of the submitted invoices. Vendors can verify the actual status of the original/updated version of the invoices via "Vendor Central &gt; Payments &gt; Invoices". For more information on how to use the Transaction Status API, Refer to the business use case documentation for Transaction Status. Allow the system to take up to 15 minutes to show the original/updated version once submitted. If Vendor Central is not showing the correct values for the updated invoice, open a "Contact Us" case in Vendor Central.

The following diagram shows the integration workflow when submitting an invoice for a confirmed and shipped order.

<img src="media\submitInvoices.png" style="width:5.218in;height:6.968" alt="Vendor invoices workflow when submitting an invoice for a confirmed and shipped order"/>


### Business Requirements 

-   **Invoice numbers** must be unique and they should never be reused (even after one year).

-   If an invoice sent by API has failed due to incorrect data but a paper invoice has the correct data, then the vendor should update it through the API with the correct data using the same **Invoice ID**.

-   If an invoice has incorrect data (both paper and API) then the invoice is cancelled and a new invoice should be sent with a new **Invoice ID.**

-   No invoice with **total amount** = 0 should be sent, as this would cause the invoice to fail.

-   Amazon requires the full address details in the address segments for tax compliance reasons. This is especially important for the **bill-to party**. For this segment the Amazon Payee system requires an exact match.

-   **Payment terms** sent in an invoice should match the payment terms agreed upon with the Amazon buyer.

-   **Item product identifier** should match the order item product identifier that was sent to the vendor in the matching purchase order.

-   The invoice **total amount** should be equal to the total sum of the items, charges, and allowances.

-   Total of **tax amount** for each line level must be equal to total of tax amount at the header level.

-   The invoice **total quantity** should match the sum of the quantity of all items.

-   Each different **charges and allowance** has to be itemized on the header level (for example freight charge, package charge, small ordering charge, etc.)

###  Country Specific Business Requirements

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
      <td>Invoice type "CreditNote" is not supported. Invoice type should always be "Invoice".</td>
      <td>Invoice types "Invoice" and "CreditNote" are supported. Vendors need to send the invoice type accordingly.</td>
      <td>Invoice type "CreditNote" is not supported. Invoice type should always be "Invoice".</td>
    </tr>
    <tr class="even">
      <td>Credit Note References</td>
      <td>Not used</td>
      <td>Vendors are required to send these references at the item level if the invoice type is "CreditNote".</td>
      <td>Not used</td>
    </tr>
    <tr class="odd">
      <td>Date</td>
      <td>Must be "now" or before.</td>
      <td>Must be "now" or before.</td>
      <td>Must be "now" or before.</td>
    </tr>
    <tr class="even">
      <td>HSN Number</td>
      <td>The HSN code is mandatory for Tax Compliant Invoices. Maximum length allowed is 8 characters.</td>
      <td>Not used</td>
      <td>Not used</td>
    </tr>
    <tr class="odd">
      <td>Tax Type at line and header level</td>
      <td>The following are allowed for tax type:
        <ul>
          <li>SGST &amp; CGST</li>
          <li>SGST &amp; CGST &amp; CESS</li>
          <li>UTGST &amp; CGST</li>
          <li>UTGST &amp; CGST &amp; CESS</li>
          <li>IGST</li>
          <li>IGST &amp; CESS</li>
        </ul>
        <p>If no tax information is provided the invoice is rejected.</p>
      </td>
      <td>Tax type to be sent.</td>
      <td>Not Used</td>
    </tr>
    <tr class="even">
      <td>Tax Registration Number</td>
      <td>A 15 character long GST ID must be provided.</td>
      <td>VAT Number</td>
      <td>VAT Number</td>
    </tr>
    <tr class="odd">
      <td>Tax Details at line and header level</td>
      <td>If multiple taxes are applicable for an item, the Tax details section must be sent multiple times with the appropriate tax type for that item.
        <p>The same applies to the total amount of the invoice.</p>
      </td>
      <td>If multiple taxes are applicable for an item, the Tax details section must be sent multiple times with the appropriate tax type for that item.
        <p>The same applies to the total amount of the invoice.</p>
        <p>There is also an additional tax type called "DomesticVAT", which can be used to submit the tax amount in the local currency. In order to process the Domestic VAT you must use the same TaxRate used on tax Type "VAT".</p>
      </td>
      <td>If multiple taxes are applicable for an item, the Tax details section must be sent multiple times with the appropriate tax type for that item.
        <p>The same applies to the total amount of the invoice.</p>
      </td>
    </tr>
    <tr class="even">
      <td>Remit To Party</td>
      <td>The party who supplies goods to Amazon and will get the payment. Also called Supplier.</td>
      <td>Tax and address details of the party (vendor) who will be receiving payment for the shipped items (in the case of an invoice) or the returned items (in case of a credit note). This is
        <b>required</b>.
      </td>
      <td>Tax and address details of the party (vendor) who will be receiving payment for the shipped items. This is
        <b>required</b>.
      </td>
    </tr>
    <tr class="odd">
      <td>Ship From Party</td>
      <td>Ship From Address details, along with the State ISO Code.
        <p>GST ID must be sent in the Tax registration number. Ship From Party is required. Values should match the values in Amazon's systems.</p>
      </td>
      <td>Vendor code or warehouse code and address of the party from where items will be shipped.</td>
      <td>Vendor code or warehouse code and address of the party from where items will be shipped.</td>
    </tr>
    <tr class="even">
      <td>Ship To Party</td>
      <td>Ship to Address details along with the State ISO Code. Ship to party is required.
        <p>Values should match the values in Amazon's systems.</p>
      </td>
      <td>Amazon ID or warehouse code and address of the party to which items will be shipped.</td>
      <td>Amazon ID or warehouse code and address of the party to which items will be shipped.</td>
    </tr>
    <tr class="odd">
      <td>Bill To Party</td>
      <td>Bill to Party is required. It might be same as Ship to party. If so, the vendor is required to send the same information in both segments.</td>
      <td>Tax and Address details of the party (Amazon) who will be billed for the shipped items (in case of an Invoice) or the returned items (in case of a credit note).
        <p>This field is
          <b>required</b>.
        </p>
      </td>
      <td>Tax and Address details of the party (Amazon) who will be billed for shipped items.
        <p>This field is
          <b>required</b>.
        </p>
      </td>
    </tr>
    <tr class="even">
      <td>Amazon Product Identifier and External Product Identifier</td>
      <td>At least one of these values is required. The identifier must be the same as what is received in order.</td>
      <td>At least one of those values is required. The identifier must be the same as what is received in order.</td>
      <td>At least one of those values is required. The identifier must be the same as what is received in order.</td>
    </tr>
    <tr class="odd">
      <td>Net Cost</td>
      <td>This field is
        <b>required</b>.
      </td>
      <td>This field is
        <b>required</b>.
      </td>
      <td>This field is
        <b>required</b>.
      </td>
    </tr>
    <tr class="even">
      <td>Purchase Order Number</td>
      <td>One invoice can contain information for only one order. Therefore the PO number should be the same for all line items in one invoice.
        <p>
          <b>Required</b>.</p>
      </td>
      <td>One invoice can have information for multiple orders. The PO number should be sent accordingly for different line items. This field is <b>required</b> if the invoice type is "Invoice" and is not used when the invoice type is "CreditNote".</td>
      <td>One invoice can have information for multiple orders. The PO number should be sent accordingly for different line items.
        <p>
          <b>Required</b>.</p>
      </td>
    </tr>
    <tr class="odd">
      <td>Additional Details</td>
      <td>Not used</td>
      <td>This field is used when the selling party has to submit additional details for special purposes. For example, in the case of Polish split payment invoices, the selling party must send in the detail "mechanizm podzielonej płatności" of type "SUR" and languageCode "PL".</td>
      <td>Not used</td>
    </tr>
    <tr class="even">
      <td>referenceNumber</td>
      <td>A unique invoice reference number generated by Government of India for every invoice. This field is mandatory only for invoices in India.</td>
      <td>Not used</td>
      <td>Not used</td>
    </tr>
  </tbody>
</table>

### Credit Note

The Submit Invoices API allows vendors to send credit notes to Amazon. A credit note lists the products, quantities, and agreed prices for products or services that the vendor provided to Amazon and Amazon returned or did not receive it. It may be issued in the case of damaged goods or errors in price where allowances or rebates are agreed beforehand between Amazon and the vendor.


#### Credit Notes supported by Amazon

<table>
  <thead>
    <tr class="header">
      <th>
        <b>Accounts Payable (AP) CREDIT NOTES</b>
      </th>
      <th>
        <b>Accounts Receivable (AR) CREDIT NOTES</b>
      </th>
    </tr>
  </thead>
  <tbody>
    <tr class="odd">
      <td>
        <b>PQV credit<b>
        <p>Credit for items billed but not received, or credit for duplicate payments.</p>
      </td>
      <td>
        <b>Returns</b>
        <p>Credit for the items returned to the vendor due to damaged goods, goods wrongly shipped, overstock, etc.</p>
      </td>
    </tr>
    <tr class="even">
      <td>
        <b>PPV credit</b>
        <p>Credit for items billed at a higher/lower cost.</p>
      </td>
      <td>
        <b>COOP (Price Protection, Damage Allowance etc.)</b>
        <p>COOP Credits paid by the vendor to Amazon to sell their product or for a price protection agreement.</p>
      </td>
    </tr>
    <tr class="odd">
      <td>
        <b>Credits for freight</b>
        <p>A charge paid for carriage or transportation of goods by air, land, or sea.</p>
      </td>
    </tr>
  </tbody>
</table>



**Note**: The credit note is not supported in all the marketplaces.

## Submit Invoices Use Cases

### Invoice with multiple items with no tax

```json
{
  "invoices": [
    {
      "invoiceType": "Invoice",
      "id": "I5599913",
      "date": "2019-07-24T21:17:59.821Z",
      "remitToParty": {
        "partyId": "VENDORID",
        "address": {
          "name": "VENDORNAME",
          "addressLine1": "PO BOX 1234",
          "city": "SAN RAFAEL",
          "stateOrRegion": "CA",
          "postalOrZipCode": "60693",
          "countryCode": "US"
        }
      },
      "shipToParty": {
        "partyId": "AMAZON",
        "address": {
          "name": "AMAZON.COM",
          "addressLine1": "500 MCCARTHY DR",
          "addressLine2": "FAIRVIEW BUSINESS PARK",
          "city": "LEWISBERRY",
          "stateOrRegion": "PA",
          "postalOrZipCode": "17339",
          "countryCode": "US"
        }
      },
      "billToParty": {
        "partyId": "AMAZON",
        "address": {
          "name": "AMAZON.COM",
          "addressLine1": "500 MCCARTHY DR",
          "addressLine2": "FAIRVIEW BUSINESS PARK",
          "addressLine3": "string",
          "city": "LEWISBERRY",
          "stateOrRegion": "PA",
          "postalOrZipCode": "17339",
          "countryCode": "US"
        }
      },
      "paymentTerms": {
        "type": "Basic",
        "discountPercent": "2.00",
        "discountDueDays": 30,
        "netDueDays": 31
      },
      "invoiceTotal": {
        "currencyCode": "USD",
        "amount": "1295"
      },
      "items": [
        {
          "itemSequenceNumber": 1,
          "amazonProductIdentifier": "ABC123434",
          "vendorProductIdentifier": "040YP0U",
          "invoicedQuantity": {
            "amount": 2,
            "unitOfMeasure": "Cases",
            "unitSize": "10"
          },
          "netCost": {
            "currencyCode": "USD",
            "amount": "140"
          },
          "purchaseOrderNumber": "S8672793"
        },
        {
          "itemSequenceNumber": 2,
          "amazonProductIdentifier": "ABC123435",
          "vendorProductIdentifier": "0264CBS",
          "invoicedQuantity": {
            "amount": 5,
            "unitOfMeasure": "Cases",
            "unitSize": "10"
          },
          "netCost": {
            "currencyCode": "USD",
            "amount": "125"
          },
          "purchaseOrderNumber": "S8672793"
        },
        {
          "itemSequenceNumber": 3,
          "amazonProductIdentifier": "ABC123436",
          "vendorProductIdentifier": "040YP0K",
          "invoicedQuantity": {
            "amount": 3,
            "unitOfMeasure": "Cases",
            "unitSize": "5"
          },
          "netCost": {
            "currencyCode": "USD",
            "amount": "130"
          },
          "purchaseOrderNumber": "S8672793"
        }
      ]
    }
  ]
}
```



### Invoice with single tax on an item

```json
{
  "invoices": [
    {
      "invoiceType": "Invoice",
      "id": "5002841638",
      "date": "2019-07-24T21:17:59.821Z",
      "remitToParty": {
        "partyId": "VENDORID",
        "address": {
          "name": "VENDORNAME",
          "addressLine1": "PO BOX 1234",
          "city": "TORONTO",
          "stateOrRegion": "ON",
          "postalOrZipCode": "M5W 5M5",
          "countryCode": "CA"
        },
        "taxRegistrationDetails": [
          {
            "taxRegistrationType": "VAT",
            "taxRegistrationNumber": "VENDORTAXID"
          }
        ]
      },
      "shipToParty": {
        "partyId": "AMAZONCA",
        "address": {
          "name": "AMAZON CANADA",
          "addressLine1": "500 MCCARTHY DR",
          "addressLine2": "FAIRVIEW BUSINESS PARK",
          "city": "MISSISSAUGA",
          "stateOrRegion": "ON",
          "postalOrZipCode": "M5W 5M5",
          "countryCode": "CA"
        }
      },
      "billToParty": {
        "partyId": "AMAZONCA",
        "address": {
          "name": "AMAZON CANADA",
          "addressLine1": "500 MCCARTHY DR",
          "addressLine2": "FAIRVIEW BUSINESS PARK",
          "addressLine3": "string",
          "city": "MISSISSAUGA",
          "stateOrRegion": "ON",
          "postalOrZipCode": "M5W 5M5",
          "countryCode": "CA"
        },
        "taxRegistrationDetails": [
          {
            "taxRegistrationType": "VAT",
            "taxRegistrationNumber": "AMAZONTAXID"
          }
        ]
      },
      "paymentTerms": {
        "type": "Basic",
        "netDueDays": 31
      },
      "invoiceTotal": {
        "currencyCode": "CAD",
        "amount": "1950"
      },
      "taxDetails": [
        {
          "taxType": "GS",
          "taxRate": "5",
          "taxAmount": {
            "currencyCode": "CAD",
            "amount": "97.5"
          },
          "taxableAmount": {
            "currencyCode": "CAD",
            "amount": "1950"
          }
        }
      ],
      "items": [
        {
          "itemSequenceNumber": 1,
          "amazonProductIdentifier": "ABC123434",
          "vendorProductIdentifier": "1012380100000",
          "invoicedQuantity": {
            "amount": 4,
            "unitOfMeasure": "Eaches"
          },
          "netCost": {
            "currencyCode": "CAD",
            "amount": "20.00"
          },
          "purchaseOrderNumber": "Q6515853",
          "taxDetails": [
            {
              "taxType": "GS",
              "taxRate": "5",
              "taxAmount": {
                "currencyCode": "CAD",
                "amount": "1.00"
              }
            }
          ]
        },
        {
          "itemSequenceNumber": 2,
          "amazonProductIdentifier": "ABC123435",
          "vendorProductIdentifier": "1000570100000",
          "invoicedQuantity": {
            "amount": 30,
            "unitOfMeasure": "Eaches"
          },
          "netCost": {
            "currencyCode": "CAD",
            "amount": "50.00"
          },
          "purchaseOrderNumber": "Q6515853",
          "taxDetails": [
            {
              "taxType": "GS",
              "taxRate": "5",
              "taxAmount": {
                "currencyCode": "CAD",
                "amount": "2.50"
              }
            }
          ]
        },
        {
          "itemSequenceNumber": 3,
          "amazonProductIdentifier": "ABC123436",
          "vendorProductIdentifier": "0543900100000",
          "invoicedQuantity": {
            "amount": 3,
            "unitOfMeasure": "Eaches"
          },
          "netCost": {
            "currencyCode": "CAD",
            "amount": "90"
          },
          "purchaseOrderNumber": "Q6515853",
          "taxDetails": [
            {
              "taxType": "GS",
              "taxRate": "5",
              "taxAmount": {
                "currencyCode": "CAD",
                "amount": "4.50"
              }
            }
          ]
        },
        {
          "itemSequenceNumber": 4,
          "amazonProductIdentifier": "ABC123437",
          "vendorProductIdentifier": "1000570200000",
          "invoicedQuantity": {
            "amount": 5,
            "unitOfMeasure": "Eaches"
          },
          "netCost": {
            "currencyCode": "CAD",
            "amount": "20.00"
          },
          "purchaseOrderNumber": "Q6515853",
          "taxDetails": [
            {
              "taxType": "GS",
              "taxRate": "5",
              "taxAmount": {
                "currencyCode": "CAD",
                "amount": "1.00"
              }
            }
          ]
        }
      ]
    }
  ]
}
```


### Invoice with multiple taxes on an item

```json
{
  "invoices": [
    {
      "invoiceType": "Invoice",
      "id": "8900000001234",
      "date": "2019-07-24T21:17:59.821Z",
      "remitToParty": {
        "partyId": "XYZ123",
        "address": {
          "name": "XYZ INDIA PRIVATE LIMITED",
          "addressLine1": "4TH FLOOR",
          "city": "GURUGRAM",
          "stateOrRegion": "HR",
          "postalOrZipCode": "122002",
          "countryCode": "IN"
        },
        "taxRegistrationDetails": [
          {
            "taxRegistrationType": "VAT",
            "taxRegistrationNumber": "VENDORTAXID"
          }
        ]
      },
      "shipToParty": {
        "partyId": "AMAZONIN",
        "address": {
          "name": "AMAZON INDIA",
          "addressLine1": "Chowranghee Mansion JN Road",
          "city": "Kolkata",
          "stateOrRegion": "WB",
          "countryCode": "IN"
        }
      },
      "shipFromParty": {
        "partyId": "XYZ123",
        "address": {
          "name": "XYZ RETAIL PVT LTD",
          "addressLine1": "Chowranghee Mansion JN Road",
          "city": "Kolkata",
          "stateOrRegion": "WB",
          "postalOrZipCode": "700016",
          "countryCode": "IN"
        }
      },
      "billToParty": {
        "partyId": "AMAZONIN",
        "address": {
          "name": "AMAZON INDIA",
          "addressLine1": "Arrjaw Industrial & Warehouse Park",
          "addressLine2": "Near Coal India Complex",
          "city": "Hooghly",
          "stateOrRegion": "WB",
          "postalOrZipCode": "712310",
          "countryCode": "IN"
        },
        "taxRegistrationDetails": [
          {
            "taxRegistrationType": "VAT",
            "taxRegistrationNumber": "AMAZONTAXID"
          }
        ]
      },
      "paymentTerms": {
        "type": "Basic",
        "netDueDays": 30
      },
      "invoiceTotal": {
        "currencyCode": "INR",
        "amount": "258262.39"
      },
      "taxDetails": [
        {
          "taxType": "SGST",
          "taxRate": "9",
          "taxAmount": {
            "currencyCode": "INR",
            "amount": "19697.98"
          },
          "taxableAmount": {
            "currencyCode": "INR",
            "amount": "218866.43"
          }
        },
        {
          "taxType": "CGST",
          "taxRate": "9",
          "taxAmount": {
            "currencyCode": "INR",
            "amount": "19697.98"
          },
          "taxableAmount": {
            "currencyCode": "INR",
            "amount": "218866.43"
          }
        }
      ],
      "items": [
        {
          "itemSequenceNumber": 1,
          "amazonProductIdentifier": "ABC123434",
          "vendorProductIdentifier": "809000-0000",
          "invoicedQuantity": {
            "amount": 2,
            "unitOfMeasure": "Eaches"
          },
          "netCost": {
            "currencyCode": "INR",
            "amount": "21060.34"
          },
          "purchaseOrderNumber": "3DY3TK6T",
          "hsnCode": "76.06.92.90",
          "taxDetails": [
            {
              "taxType": "SGST",
              "taxRate": "9",
              "taxAmount": {
                "currencyCode": "INR",
                "amount": "1895.43"
              },
              "taxableAmount": {
                "currencyCode": "INR",
                "amount": "21060.34"
              }
            },
            {
              "taxType": "CGST",
              "taxRate": "9",
              "taxAmount": {
                "currencyCode": "INR",
                "amount": "1895.43"
              },
              "taxableAmount": {
                "currencyCode": "INR",
                "amount": "21060.34"
              }
            }
          ]
        },
        {
          "itemSequenceNumber": 2,
          "amazonProductIdentifier": "ABC123435",
          "vendorProductIdentifier": "795000-0001",
          "invoicedQuantity": {
            "amount": 3,
            "unitOfMeasure": "Eaches"
          },
          "netCost": {
            "currencyCode": "INR",
            "amount": "58915.25"
          },
          "purchaseOrderNumber": "3DY3TK6T",
          "hsnCode": "76.06.92.91",
          "taxDetails": [
            {
              "taxType": "SGST",
              "taxRate": "9",
              "taxAmount": {
                "currencyCode": "INR",
                "amount": "5302.37"
              },
              "taxableAmount": {
                "currencyCode": "INR",
                "amount": "58915.25"
              }
            },
            {
              "taxType": "CGST",
              "taxRate": "9",
              "taxAmount": {
                "currencyCode": "INR",
                "amount": "5302.37"
              },
              "taxableAmount": {
                "currencyCode": "INR",
                "amount": "58915.25"
              }
            }
          ]
        }
      ]
    }
  ]
}
```


### Invoice with header level and line level allowance/charge details with tax

```json
{
  "invoices": [
    {
      "invoiceType": "Invoice",
      "id": "0136981234",
      "date": "2019-07-24T21:17:59.821Z",
      "remitToParty": {
        "partyId": "XYZ12345",
        "address": {
          "name": "XYZ INDIA PRIVATE LIMITED",
          "addressLine1": "4TH FLOOR",
          "city": "GURUGRAM",
          "stateOrRegion": "HR",
          "postalOrZipCode": "122002",
          "countryCode": "IN"
        },
        "taxRegistrationDetails": [
          {
            "taxRegistrationType": "VAT",
            "taxRegistrationNumber": "VENDORVATID"
          }
        ]
      },
      "shipToParty": {
        "partyId": "AMAZONIN",
        "address": {
          "name": "AMAZON INDIA",
          "addressLine1": "Chowranghee Mansion JN Road",
          "city": "Kolkata",
          "stateOrRegion": "WB",
          "countryCode": "IN"
        }
      },
      "shipFromParty": {
        "partyId": "XYZ12345",
        "address": {
          "name": "XYZ RETAIL PVT LTD",
          "addressLine1": "Chowranghee Mansion JN Road",
          "city": "Kolkata",
          "stateOrRegion": "WB",
          "postalOrZipCode": "700016",
          "countryCode": "IN"
        }
      },
      "billToParty": {
        "partyId": "AMAZONIN",
        "address": {
          "name": "AMAZON INDIA",
          "addressLine1": "Arrjaw Industrial & Warehouse Park",
          "addressLine2": "Near Coal India Complex",
          "city": "Hooghly",
          "stateOrRegion": "WB",
          "postalOrZipCode": "712310",
          "countryCode": "IN"
        },
        "taxRegistrationDetails": [
          {
            "taxRegistrationType": "VAT",
            "taxRegistrationNumber": "AMAZONVATID"
          }
        ]
      },
      "paymentTerms": {
        "type": "Basic",
        "discountPercent": "5",
        "discountDueDays": 15,
        "netDueDays": 30
      },
      "invoiceTotal": {
        "currencyCode": "INR",
        "amount": "259678.39"
      },
      "taxDetails": [
        {
          "taxType": "SGST",
          "taxRate": "9",
          "taxAmount": {
            "currencyCode": "INR",
            "amount": "19697.98"
          },
          "taxableAmount": {
            "currencyCode": "INR",
            "amount": "218866.43"
          }
        },
        {
          "taxType": "CGST",
          "taxRate": "9",
          "taxAmount": {
            "currencyCode": "INR",
            "amount": "19697.98"
          },
          "taxableAmount": {
            "currencyCode": "INR",
            "amount": "218866.43"
          }
        }
      ],
      "chargeDetails": [
        {
          "type": "Freight",
          "description": "Freight Charges",
          "chargeAmount": {
            "currencyCode": "INR",
            "amount": "1200.00"
          },
          "taxDetails": [
            {
              "taxType": "CGST",
              "taxRate": "9",
              "taxAmount": {
                "currencyCode": "INR",
                "amount": "108.00"
              },
              "taxableAmount": {
                "currencyCode": "string",
                "amount": "string"
              }
            },
            {
              "taxType": "SGST",
              "taxRate": "9",
              "taxAmount": {
                "currencyCode": "INR",
                "amount": "108.00"
              },
              "taxableAmount": {
                "currencyCode": "string",
                "amount": "string"
              }
            }
          ]
        }
      ],
      "items": [
        {
          "itemSequenceNumber": 1,
          "amazonProductIdentifier": "ABC123434",
          "vendorProductIdentifier": "809281-5100",
          "invoicedQuantity": {
            "amount": 2,
            "unitOfMeasure": "Eaches"
          },
          "netCost": {
            "currencyCode": "INR",
            "amount": "21060.34"
          },
          "purchaseOrderNumber": "3DY3TK6T",
          "hsnCode": "76.06.92.93",
          "taxDetails": [
            {
              "taxType": "SGST",
              "taxRate": "9",
              "taxAmount": {
                "currencyCode": "INR",
                "amount": "1895.43"
              },
              "taxableAmount": {
                "currencyCode": "INR",
                "amount": "21060.34"
              }
            },
            {
              "taxType": "CGST",
              "taxRate": "9",
              "taxAmount": {
                "currencyCode": "INR",
                "amount": "1895.43"
              },
              "taxableAmount": {
                "currencyCode": "INR",
                "amount": "21060.34"
              }
            }
          ],
          "chargeDetails": [
            {
              "type": "Freight",
              "description": "Freight Charges",
              "chargeAmount": {
                "currencyCode": "INR",
                "amount": "600.00"
              }
            }
          ]
        },
        {
          "itemSequenceNumber": 2,
          "amazonProductIdentifier": "ABC123435",
          "vendorProductIdentifier": "795000-0001",
          "invoicedQuantity": {
            "amount": 3,
            "unitOfMeasure": "Eaches"
          },
          "netCost": {
            "currencyCode": "INR",
            "amount": "58915.25"
          },
          "purchaseOrderNumber": "3DY3TK6T",
          "taxDetails": [
            {
              "taxType": "SGST",
              "taxRate": "9",
              "taxAmount": {
                "currencyCode": "INR",
                "amount": "5302.37"
              },
              "taxableAmount": {
                "currencyCode": "INR",
                "amount": "58915.25"
              }
            },
            {
              "taxType": "CGST",
              "taxRate": "9",
              "taxAmount": {
                "currencyCode": "INR",
                "amount": "5302.37"
              },
              "taxableAmount": {
                "currencyCode": "INR",
                "amount": "58915.25"
              }
            }
          ],
          "chargeDetails": [
            {
              "type": "Freight",
              "description": "Freight Charges",
              "chargeAmount": {
                "currencyCode": "INR",
                "amount": "600.00"
              }
            }
          ]
        }
      ]
    }
  ]
}
```


### EU credit note with tax

```json
{
  "invoices": [
    {
      "invoiceType": "CreditNote",
      "id": "BasicCredit",
      "date": "2019-07-24T21:17:59.821Z",
      "remitToParty": {
        "partyId": "AMAZON",
        "address": {
          "name": "AMAZON EU SARL, UK BRANCH",
          "addressLine1": "1 PRINCIPAL PLACE WORSHIP STREET",
          "city": "LONDON",
          "postalOrZipCode": "EC2A 2FA",
          "countryCode": "GB"
        }
      },
      "billToParty": {
        "partyId": "VendorCode",
        "address": {
          "name": "Vendor Name",
          "addressLine1": "Vendor Address",
          "city": "Vendor City",
          "stateOrRegion": "Vendor State",
          "postalOrZipCode": "Vendor ZIP Code",
          "countryCode": "Vendor Country"
        }
      },
      "invoiceTotal": {
        "currencyCode": "GBP",
        "amount": "100"
      },
      "taxDetails": [
        {
          "taxType": "VAT",
          "taxRate": "10",
          "taxAmount": {
            "currencyCode": "GBP",
            "amount": "10.00"
          },
          "taxableAmount": {
            "currencyCode": "GBP",
            "amount": "100.00"
          }
        }
      ],
      "items": [
        {
          "itemSequenceNumber": 1,
          "amazonProductIdentifier": "ABC123434",
          "vendorProductIdentifier": "TESTSKU",
          "invoicedQuantity": {
            "amount": 1,
            "unitOfMeasure": "Cases",
            "unitSize": "10"
          },
          "netCost": {
            "currencyCode": "GBP",
            "amount": "100"
          },
          "creditNoteDetails": {
            "referenceInvoiceNumber": "test-basic-ref",
            "debitNoteNumber": "debit-ref",
            "returnsReferenceNumber": "return-ref",
            "goodsReturnDate": "2019-07-24T21:17:59.821Z",
            "rmaId": "rma-ref",
            "consignorsReferenceNumber": "VRET-ref"
          }
        }
      ]
    }
  ]
}
```

What is the Vendor Transaction Status API?
==========================================

Vendors can use this API to check the transaction status of their POST transactions.

The following operations are included:

| **Operation**           | **HTTP Method** | **Path**                                  | **Description**                           |
|------------------------|-----------------|-----------------------------------------------------------|-------------------------------------------|
| <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/vendor-transaction-status-api/vendorTransactionStatus.md#getTransaction">getTransaction</a> | GET             | /vendor/transactions/v1/transactionStatus/{transactionId} | Get status of a post transaction request. |

## Get Transaction Status

### Usage

Vendors can use this API to check the status of a POST transaction. When a transaction such as an Order Acknowledgement or Shipment Confirmation is posted to Amazon using an API, the response includes a transaction identifier that uniquely identifies the transaction. Amazon will process the transaction asynchronously and the final response will be available via the  [getTransaction](https://github.com/amzn/selling-partner-api-docs/blob/main/references/vendor-transaction-status-api/vendorTransactionStatus.md#getTransaction) operation. See the corresponding integration workflow diagrams in the individual API sections (i.e. Vendor Orders, Vendor Shipments, etc.) to understand when to call this API to get the transaction status.

Amazon offers the final processed status for POST API transactions such as Order Acknowledgement and Shipment Confirmation via this API. We highly recommend that vendors check the status using this API to ensure that their transactions were processed successfully. If an error occurs the response will contain error information. You can then correct the transaction and resubmit it.

| **Transaction Status** | **Definition**                                                                                                                                                                         |
|------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Processing             | The API transaction was received by Amazon and is being processed. The processing has not completed yet. Check the SLA for each API operation for the expected time to complete processing. |
| Success                | The API transaction was successfully processed by Amazon. This status is currently not supported, but will be supported in future.                                                              |
| Failure                | The API transaction failed during processing. The error details will be provided in the transaction status response body.                                                              |

**Note**: Transaction status is supported for the following API operations:

-   Acknowledge Order

-   Submit Shipment Confirmations

Transaction status currently supports only the "Processing" and "Failure" status values. If transaction status is "Processing" and not updated to "Failure" after 15 minutes, that indicates transaction has successfully processed in our systems. The "Success" status will be supported in the future.

It is generally considered to be successfully delivered at our end when the status is "Processing". If for any reason, Vendor Central status is not updated after 30 minutes from sending the message, please open a support case using Vendor Central by providing the transaction ID returned in the POST call. Please ensure the data submitted is in correct format before opening the case.

You can't use this API for "Invoice" messages as they are not supported and status will be always "Processing". For any payment related queries first check in Vendor Central and then create a "contact us" case on Vendor Central and select the relevant queue.

## Transaction Status Use Cases

### Transaction is in processing state

```json
{
  "payload": {
    "transactionStatus": {
      "transactionId": "20190905193800-0c6b76cb-9662-4f3a-be03-1686c1e21477",
      "status": "Processing"
    }
  }
}
```


### Transaction has successfully processed

Transaction has been in the processing state for 15 minutes after posting it.

```json
{
  "payload": {
    "transactionStatus": {
      "transactionId": "20190905193800-0c6b76cb-9662-4f3a-be03-1686c1e21477",
      "status": "Processing"
    }
  }
}
```


### Transaction has failed in Amazon

```json
{
  "payload": {
    "transactionStatus": {
      "transactionId": "20190908091302-6ca0ac50-d06e-45f5-a1e2-eb448eadac50",
      "status": "Failure",
      "errors": [
        {
          "code": "INVALID_ORDER_ID",
          "message": "Invalid order ID."
        }
      ]
    }
  }
}
```
