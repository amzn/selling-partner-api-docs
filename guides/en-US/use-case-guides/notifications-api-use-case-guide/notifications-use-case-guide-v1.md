# Notifications API Use Case Guide

Version: 1.0

### Contents

- [What is the Notifications API?](#what-is-the-notifications-api)

- [Tutorial: Set up notifications (Amazon EventBridge workflow)](#tutorial-set-up-notifications-amazon-eventbridge-workflow)
  - [Step 1. Create a destination](#step-1-create-a-destination)
  - [Step 2. Configure Amazon EventBridge to handle notifications](#step-2-configure-amazon-eventbridge-to-handle-notifications)
  - [Step 3. Create a rule that triggers on a notification event](#step-3-create-a-rule-that-triggers-on-a-notification-event)
  - [Step 4. Create a subscription](#step-4-create-a-subscription)
- [Tutorial: Set up notifications (Amazon Simple Queue Service workflow)](#tutorial-set-up-notifications-amazon-simple-queue-service-workflow)
  - [Step 1. Grant Selling Partner API permission to write to your SQS queue](#step-1-grant-selling-partner-api-permission-to-write-to-your-sqs-queue)
  - [Step 2. Create a destination](#step-2-create-a-destination)
  - [Step 3. Create a subscription](#step-3-create-a-subscription)
- [Notification structure](#notification-structure)

- [notificationType](#notificationtype)
  - [ANY_OFFER_CHANGED](#any_offer_changed)
  - [B2B_ANY_OFFER_CHANGED](#B2B_ANY_OFFER_CHANGED)
  - [BRANDED_ITEM_CONTENT_CHANGE](#branded_item_content_change)
  - [FBA_OUTBOUND_SHIPMENT_STATUS](#fba_outbound_shipment_status)
  - [FEE_PROMOTION](#fee_promotion)
  - [FULFILLMENT_ORDER_STATUS](#fulfillment_order_status)
  - [ITEM_PRODUCT_TYPE_CHANGE](#item_product_type_change)
- [Common types](#common-types)
  - [AvailabilityType](#availabilitytype)
  - [FulfillmentChannelType](#fulfillmentchanneltype)
  - [MarketplaceType](#marketplacetype)
  - [MoneyType](#moneytype)

# What is the Notifications API?

The Selling Partner API for Notifications lets you subscribe to notifications that are relevant to a selling partner's business. Using this API, you can create a destination to receive notifications, subscribe to notifications, delete notification subscriptions, and more. Instead of polling for information, your application can receive information directly from Amazon when an event triggers a notification to which you are subscribed.

### Terminology

  - **Amazon EventBridge.** A serverless event bus that connects application data from your own applications, integrated Software-as-a-Service (SaaS) applications, and AWS services. For more information, see [Amazon EventBridge](https://aws.amazon.com/eventbridge/).

  - **Amazon Simple Queue Service.** A fully managed message queuing service for microservices, distributed systems, and serverless applications. For more information, see [Amazon Simple Queue Service](https://aws.amazon.com/sqs/).

  - **Partner event source**. Used by an AWS partner to send events to an AWS customer account. To receive these events, the customer must associate an event bus with the partner event source. For more information, see [What Is Amazon EventBridge?](https://docs.aws.amazon.com/eventbridge/latest/userguide/what-is-amazon-eventbridge.html)

  - **Event bus.** Receives events from a source and routes them to target resources according rules associated with the event bus. For more information, see [EventBus](https://docs.aws.amazon.com/eventbridge/latest/APIReference/API_EventBus.html).

### Notification workflows

There are two separate workflows for receiving notifications. The workflow you use depends on the notification type that you want to receive.

**Amazon EventBridge workflow**

Use this workflow to receive the following notification types:

  - [BRANDED_ITEM_CONTENT_CHANGE](#branded_item_content_change). Sent whenever there is a change to the title, description, or bullet points for any ASIN that the selling partner has a brand relationship with.

  - [ITEM_PRODUCT_TYPE_CHANGE](#item_product_type_change). Sent whenever there is a change to the product type name of any ASIN that the selling partner has a brand relationship with.

See [Tutorial: Set up notifications (Amazon EventBridge workflow)](#tutorial-set-up-notifications-amazon-eventbridge-workflow).

**Amazon Simple Queue Service workflow**

Use this workflow to receive the following notification types:

  - [ANY_OFFER_CHANGED](#any_offer_changed). Sent whenever there is a change to any of the top 20 offers, by condition (new or used), or if the external price (the price from other retailers) changes for an item listed by the seller.

  - [B2B_ANY_OFFER_CHANGED](#B2B_ANY_OFFER_CHANGED). Sent whenever there is a change in any of the top 20 B2B offers, in the form of any price change (either single unit or quantity discount tier prices) for an item listed by the seller.

  - [FBA_OUTBOUND_SHIPMENT_STATUS](#fba_outbound_shipment_status). Sent whenever we create or cancel a Fulfillment by Amazon shipment for a seller.

  - [FEE_PROMOTION](#fee_promotion). Sent when a promotion becomes active.

  - [FULFILLMENT_ORDER_STATUS](#fulfillment_order_status). Sent whenever there is a change in the status of a Multi-Channel Fulfillment order.


See [Tutorial: Set up notifications (Amazon Simple Queue Service workflow)](#tutorial-set-up-notifications-amazon-simple-queue-service-workflow).

# Tutorial: Set up notifications (Amazon EventBridge workflow)

Use this tutorial to receive any of the following notifications types:

  - [BRANDED_ITEM_CONTENT_CHANGE](#branded_item_content_change). Sent whenever there is a change to the title, description, or bullet points for any ASIN that the selling partner has a brand relationship with.

  - [ITEM_PRODUCT_TYPE_CHANGE](#item_product_type_change). Sent whenever there is a change to the product type name of any ASIN that the selling partner has a brand relationship with.

**Important.** Today this Amazon EventBridge workflow is available in the Canada, US, and Mexico marketplaces.

If you want to receive any other notification type, skip this tutorial and go to [Tutorial: Set up notifications (Amazon Simple Queue Service workflow)](#tutorial-set-up-notifications-amazon-simple-queue-service-workflow).

**Prerequisites**

To complete this tutorial you will need:

  - Authorization from the seller for whom you are making calls. See the [Selling Partner API Developer Guide](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/developer-guide/SellingPartnerApiDeveloperGuide.md) for more information.

  - An AWS Account. This AWS account will be responsible for charges related to receiving notifications. If you are not already an AWS customer, you can create a free AWS account. For more information, see [AWS Free Tier](https://aws.amazon.com/free).

  - A target resource to receive notification events. For more information, see [What Is Amazon EventBridge?](https://docs.aws.amazon.com/eventbridge/latest/userguide/what-is-amazon-eventbridge.html)

  - A basic understanding of Amazon EventBridge. For more information, see [Amazon EventBridge](https://aws.amazon.com/eventbridge/).

## Step 1. Create a destination

Call the **createDestination** operation to create an Amazon EventBridge destination.

1.  Call the [createDestination](https://github.com/amzn/selling-partner-api-docs/blob/main/references/notifications-api/notifications.md#createdestination) operation, passing the following body parameters:

<table>
<thead>
<tr class="header">
<th><b>Parameter</b></th>
<th><b>Description</b></th>
<th><b>Required</b></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>resourceSpecification</td>
<td><p>The information required to create a destination resource. In this workflow, include the <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/notifications-api/notifications.md#eventbridgeresourcespecification">eventBridge</a> specification.</p>
<p>Type: <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/notifications-api/notifications.md#destinationresourcespecification">resourceSpecification</a></p></td>
<td>Yes.</td>
</tr>
<tr class="even">
<td>name</td>
<td><p>A developer-defined name to help identify this destination.</p>
<p>Type: string</p></td>
<td>Yes</td>
</tr>
</tbody>
</table>

**Note:** Calling the **createDestination** operation does not require authorization from any selling partner. In this respect, this operation is a "grantless" operation and has a different authorization model from most other Selling Partner API operations. For more information, see [Grantless operations](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/developer-guide/SellingPartnerApiDeveloperGuide.md#grantless-operations-1) in the Selling Partner API Developer Guide.

Request example:
```
POST https://sellingpartnerapi-na.amazon.com/ notifications/v1/destinations
{
  "resourceSpecification":
  {
    "eventBridge":
    {
      "accountId": "123456789",
      "region": "us-east-1"
    }
  },
  "name": "YourDestinationName"
}
```
**Response**

A successful response includes the following elements:

<table>
<thead>
<tr class="header">
<th><b>Name</b></th>
<th><b>Description</b></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>resource</td>
<td><p>The resource that will receive notifications associated with this destination.</p>
<p>Type: <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/notifications-api/notifications.md#destinationresource">DestinationResource</a></p></td>
</tr>
<tr class="even">
<td>destinationId</td>
<td><p>The destination identifier generated when you created the destination.</p>
<p>Type: string</p></td>
</tr>
<tr class="odd">
<td>name</td>
<td><p>The name of this destination.</p>
<p>Type: string</p></td>
</tr>
</tbody>
</table>

Response example
```
{
  "payload": {
    "resource": {
      "sqs": null,
      "eventBridge": {
        "name": "sellingpartnerapi.amazon.com/amzn1.sellerapps.app.15a75829-cd4a-4efc-b947-0cc39d874577",
        "accountId": "123456789",
        "region": "us-east-1"
      }
    },
    "destinationId": "64a4a891-60dd-303f-89f9-43caf25cb3ec",
    "name": "YourDestinationName"
  }
}
```
2.  Save the following values:

  - **resource:eventBridge:name.** Use this value in [Step 2. Configure Amazon EventBridge to handle notifications](#step-2-configure-amazon-eventbridge-to-handle-notifications).

  - **destinationId.** Pass in this value in [Step 4. Create a subscription](#step-4-create-a-subscription).

## Step 2. Configure Amazon EventBridge to handle notifications

Associate an event bus with your partner event source. For definitions, see [Terminology](#terminology).

1. Go to [Amazon EventBridge](https://console.aws.amazon.com/events) and sign into the AWS console using the AWS Account ID that you specified when you called the **createDestination** operation in  [Step 1. Create a destination](#step-1-create-a-destination).

2.  In the console, ensure that the AWS region that you specified when you called the **createDestination** operation is selected.

3.  In the navigation pane, click **Partner event sources**.

4.  In the **Partner event sources** area, under **Name**, click the partner event source that matches the **resource:eventBridge:name** value returned in [Step 1. Create a destination](#step-1-create-a-destination). The partner event source is in this format: aws.partner/sellingpartnerapi.amazon.com/{AWS Account Id}/{Application Id}

5.  On the new page that appears, click the **Associate with event bus** button.

6.  On the **Associate with event bus** page, leave the checkboxes cleared and click the **Associate** button.

You have created a partner event bus and associated it with your partner event source. Go to [Step 3. Create a rule that triggers on a notification event](#step-3-create-a-rule-that-triggers-on-a-notification-event).

## Step 3. Create a rule that triggers on a notification event

Create a rule that watches for specific notification events and routes them to the target resource of your choice.

1.  Go to [Amazon EventBridge](https://console.aws.amazon.com/events). If you are not already signed into the AWS console, sign in using the AWS Account ID that you specified when you called the **createDestination** operation in  [Step 1. Create a destination](#step-1-create-a-destination).

2. In the console, ensure that the AWS region that you specified when you called the **createDestination** operation is selected.

3.  In the navigation pane, click **Rules**.

4.  Click the **Create rule** button.

5.  Enter a name and optional description for the rule.

6.  In the **Define pattern** area, select **Event pattern**.

7.  Select **Pre-defined pattern by service**.

8.  Under **Service provider**, select **Service partners**.

9.  Under **Service name**, select **Amazon Selling Partner APIs**.

The event pattern that displays should be similar to the following, which indicates that you will receive all events emitted by sellingpartnerapi.amazon.com:
```
{
  "account": [
    "1234567890"
  ]
}
```
10.  (Optional) Edit the event pattern to include rules that match only the notification events that you want. The following event pattern contains a rule that matches only BRANDED_ITEM_CONTENT_CHANGE events from sellingpartnerapi.amazon.com:
```
{
  "account": [
    "1234567890"
  ],
  "detail-type": [
    "BRANDED_ITEM_CONTENT_CHANGE"
  ]
}
```
For information about creating more complex rules, see [Event Patterns](https://docs.aws.amazon.com/eventbridge/latest/userguide/filtering-examples-structure.html) in the AWS documentation.

11.  In the **Select event bus** area, select **Custom or partner event bus** and then select the partner event bus that you configured in [Step 2. Configure Amazon EventBridge to handle notifications](#step-2-configure-amazon-eventbridge-to-handle-notifications).

12. In the **Select targets** area, select the AWS service that is to act when an event of the selected type is detected. Enter other information specific to this target type, if required.

    **Note.** For many target types, EventBridge needs permissions to send events to the target. In these cases, you can create a new IAM role or you can use an existing IAM role. Do one of the following:

    - To create an IAM role, select **Create a new role for this specific resource**.

    - To use an IAM role that you have already created, select **Use existing role**.

13. (Optional) Click **Add target** to add another target for this rule.

14. (Optional) Enter one or more tags for the rule. For more information, see [Tagging Your Amazon EventBridge Resources](https://docs.aws.amazon.com/eventbridge/latest/userguide/eventbridge-tagging.html) in the AWS documentation.

15. Click the **Create** button.

Troubleshooting:

  - If you create a rule with an encrypted Amazon SQS queue as a target, you must include a decrypt action in your [AWS Key Management Service](https://aws.amazon.com/kms/) key policy for the event to be successfully delivered to the encrypted queue. For more information, see [My events are not delivered to the target Amazon SQS queue](https://docs.aws.amazon.com/eventbridge/latest/userguide/eventbridge-troubleshooting.html#sqs-encrypted) in the AWS documentation.

  - For more troubleshooting information, see [Troubleshooting Amazon EventBridge](https://docs.aws.amazon.com/eventbridge/latest/userguide/eventbridge-troubleshooting.html) in the AWS documentation.

## Step 4. Create a subscription

Subscribe to a notification type, to be delivered to the destination that you created in [Step 1. Create a destination](#step-1-create-a-destination).

1.  Call the [createSubscription](https://github.com/amzn/selling-partner-api-docs/blob/main/references/notifications-api/notifications.md#createsubscription) operation, passing the following parameters:

Path parameters:

<table>
<thead>
<tr class="header">
<th><b>Parameter</b></th>
<th><b>Description</b></th>
<th><b>Required</b></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>notificationType</td>
<td><p>The type of notification to which you want to subscribe.</p>
<p>Values: BRANDED_ITEM_CONTENT_CHANGE, ITEM_PRODUCT_TYPE_CHANGE. See <a href="#notificationtype">notificationType</a>.</p>
<p>Type: string</p></td>
<td>Yes</td>
</tr>
</tbody>
</table>

Body parameters:

<table>
<thead>
<tr class="header">
<th><b>Parameter</b></th>
<th><b>Description</b></th>
<th><b>Required</b></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>payloadVersion</td>
<td><p>The version of the payload object to be used in the notification.</p>
<p>Value must be: 1.0</p>
<p>Type: string</p></td>
<td>Yes</td>
</tr>
<tr class="even">
<td>destinationId</td>
<td><p>The identifier for the destination where notifications will be delivered. Use the <b>destinationId</b> value that you saved in <a href="#step-1.-create-a-destination">Step 1. Create a destination</a>.</p>
<p>Type: string</p></td>
<td>Yes</td>
</tr>
</tbody>
</table>

Request example:
```
POST https://sellingpartnerapi-na.amazon.com/ notifications/v1/subscriptions/BRANDED_ITEM_CONTENT_CHANGE
{
  "payloadVersion":"1.0",
  "destinationId":"3acafc7e-121b-1329-8ae8-1571be663aa2"
}
```
**Response**

<table>
<thead>
<tr class="header">
<th><b>Name</b></th>
<th><b>Description</b></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>subscriptionId</td>
<td><p>The subscription identifier generated when the subscription is created.</p>
<p>Type: string</p></td>
</tr>
<tr class="even">
<td>payloadVersion</td>
<td><p>The version of the payload object to be used in the notification.</p>
<p>Type: string</p></td>
</tr>
<tr class="odd">
<td>destinationId</td>
<td><p>The identifier for the destination where notifications will be delivered.</p>
<p>Type: string</p></td>
</tr>
</tbody>
</table>

Response example:
```
{
  "payload":{
    "subscriptionId":" 7fcacc7e-727b-11e9-8848-1681be663d3e",
    "payloadVersion":" 1.0",
    "destinationId":"3acafc7e-121b-1329-8ae8-1571be663aa2"
  }
}
```
You are now subscribed to receive BRANDED_ITEM_CONTENT_CHANGE notifications.

# Tutorial: Set up notifications (Amazon Simple Queue Service workflow)

Use this tutorial to set up your system to receive any of the following notifications types:

  - [ANY_OFFER_CHANGED](#any_offer_changed). Sent whenever there is a listing change for any of the top 20 offers, by condition (new or used), or if the external price (the price from other retailers) changes for an item listed by the seller.

  - [FEE_PROMOTION](#fee_promotion). Sent when a promotion becomes active.

  - [FBA_OUTBOUND_SHIPMENT_STATUS](#fba_outbound_shipment_status). Sent whenever we create or cancel a Fulfillment by Amazon shipment for a seller.

  - [FULFILLMENT_ORDER_STATUS](#fulfillment_order_status). Sent whenever there is a change in the status of a Multi-Channel Fulfillment order.


**Important:** To receive any other notification type, go to [Tutorial: Set up notifications (Amazon EventBridge workflow)](#tutorial-set-up-notifications-amazon-eventbridge-workflow).

**Prerequisites**

To complete this tutorial you will need:

  - Authorization from the seller for whom you are making calls. See the [Selling Partner API Developer Guide](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/developer-guide/SellingPartnerApiDeveloperGuide.md) for more information.

  - An AWS Account. If you are not already an AWS customer, you can create a free AWS account. For more information, see [AWS Free Tier](https://aws.amazon.com/free).

  - An Amazon Simple Queue Service (SQS) queue. For information about setting up an SQS queue, see [Amazon Simple Queue Service](http://aws.amazon.com/sqs/).

## Step 1. Grant Selling Partner API permission to write to your SQS queue

To receive notifications you must grant Selling Partner API permission to write to your SQS queue.

1.  Go to the [AWS Management Console](https://console.aws.amazon.com/console) and sign in with your AWS credentials.

2.  In the console, open Simple Queue Service, either by clicking on it or by searching for it.

3.  Select the Standard queue where you want to receive notifications.

4.  Click the **Permissions** tab.

5.  Click the **Add a Permission** button.

6.  In the dialog that opens: set **Effect** to **Allow**. Set **Principal** to **437568002678**. Set **Actions** to **SendMessage** and **GetQueueAttributes**. Finally, click the **Add Permission** button to save your changes.

7.  Click the **Details** tab and take note of the ARN for this queue. You will pass this value using the **arn** parameter when you call the **createDestination** operation in [Step 2. Create a destination](#step-2-create-a-destination).

## Step 2. Create a destination

Call the **createDestination** operation to create an Amazon Simple Queue Service (SQS) destination.

1.  Call the [createDestination](https://github.com/amzn/selling-partner-api-docs/blob/main/references/notifications-api/notifications.md#createdestination) operation, passing the following body parameters:

<table>
<thead>
<tr class="header">
<th><b>Parameter</b></th>
<th><b>Description</b></th>
<th><b>Required</b></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>resourceSpecification</td>
<td><p>The information required to create an SQS destination. This includes the <b>sqs:arn</b> value that you got from <a href="#step-1.-grant-selling-partner-api-permission-to-write-to-your-sqs-queue">Step 1. Grant Selling Partner API permission to write to your SQS queue</a>.</p>
<p>Type: object</p></td>
<td>Yes.</td>
</tr>
<tr class="even">
<td>name</td>
<td><p>A name that you specify to help you identify this destination.</p>
<p>Type: string</p></td>
<td>Yes</td>
</tr>
</tbody>
</table>

**Note:** Calling the **createDestination** operation does not require authorization from any selling partner. In this respect, this operation is a "grantless" operation and has a different authorization model from most other Selling Partner API operations. For more information, see [Grantless operations](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/developer-guide/SellingPartnerApiDeveloperGuide.md#grantless-operations-1) in the Selling Partner API Developer Guide.

Request example:
```
POST https://sellingpartnerapi-na.amazon.com/ notifications/v1/destinations
{
  "name": "YourDestinationName",
  "resourceSpecification":
  {
    "sqs":
    {
      "arn": "arn:aws:sqs:us-east-2:444455556666:queue1"
    }
  }
}
```
**Response**

<table>
<thead>
<tr class="header">
<th><b>Name</b></th>
<th><b>Description</b></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>name</td>
<td><p>The developer-defined name for this destination.</p>
<p>Type: string</p></td>
</tr>
<tr class="even">
<td>destinationId</td>
<td><p>The destination identifier generated when you created the destination.</p>
<p>Type: string</p></td>
</tr>
<tr class="odd">
<td>resource</td>
<td><p>The resource that will receive notifications associated with this destination.</p>
<p>Type: object</p></td>
</tr>
</tbody>
</table>

Response example:
```
{
  "payload": {
    "name": "YourDestinationName",
    "destinationId": "ExampleDestinationId",
    "resource": {
      "sqs": {
        "arn": "arn:aws:sqs:us-east-2:444455556666:queue1"
      }
    }
  }
}
```
2.  Save the **destinationId** value as input for [Step 3. Create a subscription](#step-3-create-a-subscription).

## Step 3. Create a subscription

Create a subscription to a notification type, to be delivered to the destination that you created in the previous step.

1.  Call the [createSubscription](https://github.com/amzn/selling-partner-api-docs/blob/main/references/notifications-api/notifications.md#createsubscription) operation, passing the following parameters:

Path parameters:

<table>
<thead>
<tr class="header">
<th><b>Parameter</b></th>
<th><b>Description</b></th>
<th><b>Required</b></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>notificationType</td>
<td><p>The type of notification to which you want to subscribe.</p>
<p>Values: ANY_OFFER_CHANGED, FBA_OUTBOUND_SHIPMENT_STATUS, FEE_PROMOTION, FULFILLMENT_ORDER_STATUS. See <a href="#notificationtype">notificationType</a></p>
<p>Type: string</p></td>
<td>Yes</td>
</tr>
</tbody>
</table>


Body parameters:

<table>
<thead>
<tr class="header">
<th><b>Parameter</b></th>
<th><b>Description</b></th>
<th><b>Required</b></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>payloadVersion</td>
<td><p>The version of the payload object to be used in the notification. Value must be: 1.0</p>
<p>Type: string</p></td>
<td>Yes</td>
</tr>
<tr class="even">
<td>destinationId</td>
<td><p>The identifier for the destination where notifications will be delivered. Use the value you saved in <a href="#step-2.-create-a-destination">Step 2. Create a destination</a>.</p>
<p>Type: string</p></td>
<td>Yes</td>
</tr>
</tbody>
</table>

Request example:
```
POST https://sellingpartnerapi-na.amazon.com/ notifications/v1/subscriptions/ANY_OFFER_CHANGED
{
  "payloadVersion":"1.0",
  "destinationId":"3acafc7e-121b-1329-8ae8-1571be663aa2"
}
```
**Response**

<table>
<thead>
<tr class="header">
<th><b>Name</b></th>
<th><b>Description</b></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>subscriptionId</td>
<td><p>The subscription identifier generated when the subscription is created.</p>
<p>Type: string</p></td>
</tr>
<tr class="even">
<td>payloadVersion</td>
<td><p>The version of the payload object to be used in the notification.</p>
<p>Type: string</p></td>
</tr>
<tr class="odd">
<td>destinationId</td>
<td><p>The identifier for the destination where notifications will be delivered. Use the <b>destinationId</b> value that you saved in the previous step.</p>
<p>Type: string</p></td>
</tr>
</tbody>
</table>

Response example:
```
{
  "payload": {
    "subscriptionId": "7fcacc7e-727b-11e9-8848-1681be663d3e",
    "payloadVersion": "1.0",
    "destinationId": "3acafc7e-121b-1329-8ae8-1571be663aa2"
  }
}
```
# Notification structure

Selling Partner notifications are in JSON format. Each notification contains a **Payload** object, which contains the actionable data of the notification. [Notification Type](#notificationtype), in combination with **PayloadVersion**, determines the structure of the **Payload** object.

A Selling Partner notification with **NotificationVersion**=1.0 contain the following properties:

<table>
<thead>
<tr class="header">
<th><b>Object</b></th>
<th><b>Description</b></th>
<th><b>Type</b></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>NotificationVersion</td>
<td>The notification version. This controls the structure of the notification.</td>
<td>string</td>
</tr>
<tr class="even">
<td>NotificationType</td>
<td>The notification type. <b>NotificationType</b>, combined with <b>PayloadVersion,</b> controls the structure of the <b>Payload object</b>.</td>
<td>string</td>
</tr>
<tr class="odd">
<td>PayloadVersion</td>
<td>The payload version. <b>PayloadVersion</b>, combined with <b>NotificationType,</b> controls the structure of the <b>Payload object</b>.</td>
<td>string</td>
</tr>
<tr class="even">
<td>EventTime</td>
<td>The date and time (in UTC) that the event which triggered the notification occurred.</td>
<td>string</td>
</tr>
<tr class="odd">
<td>Payload</td>
<td>The actionable data of the notification. The structure of the <b>Payload</b> is determined by <b>NotificationType</b>, in combination with <b>PayloadVersion</b>.</td>
<td><p>JSON object</p>
<p>For more information, see <a href="#notificationtype">Notifications</a>.</p></td>
</tr>
<tr class="even">
<td><b>NotificationMetadata</b></td>
<td><p>The notification metadata. This includes the following objects:</p>
<ul>
<li><p><b>ApplicationId</b> – The identifier for the application that uses the notifications. Type = string</p></li>
<li><p><b>SubscriptionId</b> - A unique identifier for the subscription which resulted in this notification. Type = string</p></li>
<li><p><b>PublishTime</b> - The date and time (in UTC) that the notification was sent. Type = string</p></li>
<li><p><b>NotificationId</b> - A unique identifier for this notification instance. Type = string</p></li>
</ul></td>
<td>JSON object</td>
</tr>
</tbody>
</table>

Notification example:
```
{
  "NotificationVersion": "1.0",
  "NotificationType": "BRANDED_ITEM_CONTENT_CHANGE",
  "PayloadVersion": "1.0",
  "EventTime": "2019-03-20T18:59:30.194Z",
  "Payload": {
    "MarketplaceId": "ATVPDKIKX0DER",
    "BrandName": "Great Brand",
    "Asin": "B1234567"
  },
  "NotificationMetadata": {
    "ApplicationId": "amzn1.sellerapps.app.f1234566-aaec-55a6-b123-bcb752069ec5",
    "SubscriptionId": "93b098e1-c42-2f45-93a1-78910a6a8369",
    "PublishTime": "2019-03-20T18:59:48.768Z",
    "NotificationId": "8e009934-da2c-4f9c-9bc7-93f23b7e1f60"
  }
}
```
# notificationType

You can subscribe to various notifications, depending on the selling partner information that you want to receive.

The following **notificationType** values indicate the notification type:
  - [ANY_OFFER_CHANGED](#any_offer_changed). Sent whenever there is a change in any of the top 20 offers, by condition (new or used), or if the external price (the price from other retailers) changes for an item listed by the seller.

  - [B2B_ANY_OFFER_CHANGED](#B2B_ANY_OFFER_CHANGED). Sent whenever there is a change in any of the top 20 B2B offers, in the form of any price change (either single unit or quantity discount tier prices) for an item listed by the seller.

  - [BRANDED_ITEM_CONTENT_CHANGE](#branded_item_content_change). Sent whenever there is a change to the title, description, or bullet points for any ASIN that the selling partner has a brand relationship with.

  - [ITEM_PRODUCT_TYPE_CHANGE](#item_product_type_change). Sent whenever there is a change to the product type name of any ASIN that the selling partner has a brand relationship with.

  - [FEE_PROMOTION](#fee_promotion). Sent when a promotion becomes active.

  - [FBA_OUTBOUND_SHIPMENT_STATUS](#fba_outbound_shipment_status). Sent whenever we create or cancel a Fulfillment by Amazon shipment for a seller.

  - [FULFILLMENT_ORDER_STATUS](#fulfillment_order_status). Sent whenever there is a change in the status of a Multi-Channel Fulfillment order.

## ANY_OFFER_CHANGED

The **ANY_OFFER_CHANGED** notification is sent whenever there is a change to any of the top 20 offers, by condition (new or used), or if the external price (the price from other retailers) changes for an item that you sell, or if there is a change to which offer wins the BuyBox, or a change to the BuyBox price. The top 20 offers are determined by the landed price, which is the price plus shipping minus Amazon Points. If multiple sellers are charging the same landed price, the results will be returned in random order.

You will only receive **ANY_OFFER_CHANGED** notifications for items for which you have active offers. You cannot subscribe to notifications for items for which you do not have active offers.

The following table shows the child elements of the AnyOfferChangedNotification element:

<table>
<thead>
<tr class="header">
<th><b>Name</b></th>
<th><b>Description</b></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>OfferChangeTrigger</td>
<td><p>The event that caused the notification to be sent.</p><p>Required.</p>
<p>Type: <a href="#OfferChangeTrigger_AnyOfferChanged">OfferChangeTrigger</a></p></td>
</tr>
<tr class="even">
<td>Summary</td>
<td><p>Information about the product that had the offer change. The information in this summary applies to all conditions of the product.</p>
<p>Required.</p>
<p>Type: <a href="#Summary_AnyOfferChanged">Summary</a></p></td>
</tr>
<tr class="odd">
<td>Offers</td>
<td><p>The top 20 competitive offers for the item and condition that triggered the notification.</p>
<p>Required.</p>
<p>Type: List of <a href="#Offer_AnyOfferChanged">Offer</a></p></td>
</tr>
<tr class="even">
<td>SellerId</td>
<td><p>The seller identifier for the offer.</p>
<p>Required.</p>
<p>Type: String</p></td>
</tr>
</tbody>
</table>

<h3 id="BuyBoxPrice_AnyOfferChanged">BuyBoxPrice</h3>

The following table shows the child elements of the BuyBoxPrice element:

<table>
<thead>
<tr class="header">
<th><b>Name</b></th>
<th><b>Description</b></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>LandedPrice</td>
<td><p>ListingPrice + Shipping - Points.</p>
<p>Required.</p>
<p>Type: <a href="#moneytype">MoneyType</a></p></td>
</tr>
<tr class="even">
<td>ListingPrice</td>
<td><p>The price of the item.</p>
<p>Required.</p>
<p>Type: <a href="#moneytype">MoneyType</a></p></td>
</tr>
<tr class="odd">
<td>Shipping</td>
<td><p>The shipping cost.</p>
<p>Required.</p>
<p>Type: <a href="#moneytype">MoneyType</a></p></td>
</tr>
<tr class="even">
<td>Points</td>
<td><p>The number of Amazon Points offered with the purchase of an item.</p>
<p>Optional.</p>
<p>Note: The Points element is only returned in Japan (JP).</p>
<p>Type: <a href="#Points_AnyOfferChanged">Points</a></p></td>
</tr>
<tr class="odd">
<td>Condition</td>
<td><p>Indicates the condition of the item. For example: New, Used, Collectible, Refurbished, or Club.</p>
<p>Required.</p>
<p>Type: String</p></td>
</tr>
</tbody>
</table>

<h3 id="LowestPrice_AnyOfferChanged">LowestPrice</h3>

The following table shows the child elements of the LowestPrice element:

<table>
<thead>
<tr class="header">
<th><b>Name</b></th>
<th><b>Description</b></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>LandedPrice</td>
<td><p>ListingPrice + Shipping - Points.</p>
<p>Required.</p>
<p>Type: <a href="#moneytype">MoneyType</a></p></td>
</tr>
<tr class="even">
<td>ListingPrice</td>
<td><p>The price of the item.</p>
<p>Required.</p>
<p>Type: <a href="#moneytype">MoneyType</a></p></td>
</tr>
<tr class="odd">
<td>Shipping</td>
<td><p>The shipping cost.</p>
<p>Required.</p>
<p>Type: <a href="#moneytype">MoneyType</a></p></td>
</tr>
<tr class="even">
<td>Points</td>
<td><p>The number of Amazon Points offered with the purchase of an item.</p>
<p>Optional.</p>
<p>Note: The Points element is only returned in Japan (JP).</p>
<p>Type: <a href="#Points_AnyOfferChanged">Points</a></p></td>
</tr>
<tr class="odd">
<td>Condition</td>
<td><p>Indicates the condition of the item. For example: New, Used, Collectible, Refurbished, or Club.</p>
<p>Required.</p>
<p>Type: String</p></td>
</tr>
<tr class="even">
<td>FulfillmentChannel</td>
<td><p>Indicates whether the item is fulfilled by Amazon or by the seller.</p>
<p>Required.</p>
<p>Type: <a href="#fulfillmentchanneltype">FulfillmentChannelType</a></p></td>
</tr>
</tbody>
</table>

<h3 id="Offer_AnyOfferChanged">Offer</h3>

The following table shows the child elements of the Offer element:

<table>
<thead>
<tr class="header">
<th><b>Name</b></th>
<th><b>Description</b></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>SellerId</td>
<td><p>The seller identifier for the offer.</p>
<p>Required.</p>
<p>Type: String</p></td>
</tr>
<tr class="even">
<td>SubCondition</td>
<td><p>The subcondition of the item. For example: <em>New</em>, <em>Mint</em>, <em>Very Good</em>, <em>Good</em>, <em>Acceptable</em>, <em>Poor</em>, <em>Club</em>, <em>OEM</em>, <em>Warranty</em>, <em>Refurbished Warranty</em>, <em>Refurbished</em>, <em>Open Box</em>, or <em>Other</em>.</p>
<p>Required.</p>
<p>Type: String</p></td>
</tr>
<tr class="odd">
<td>SellerFeedbackRating</td>
<td><p>Information about the seller's feedback, including the percentage of positive feedback, and the total count of feedback received.</p>
<p>Optional.</p>
<p>Type: <a href="#SellerFeedbackRating_AnyOfferChanged">SellerFeedbackRating</a></p></td>
</tr>
<tr class="even">
<td>ShippingTime</td>
<td><p>The minimum and maximum time, in hours, that the item will likely be shipped after the order has been placed.</p>
<p>Required.</p>
<p>Type: <a href="#ShippingTime_AnyOfferChanged">ShippingTime</a></p></td>
</tr>
<tr class="odd">
<td>ListingPrice</td>
<td><p>The price of the item.</p>
<p>Required.</p>
<p>Type: <a href="#moneytype">MoneyType</a></p></td>
</tr>
<tr class="even">
<td>Points</td>
<td><p>The number of Amazon Points offered with the purchase of an item.</p>
<p>Optional.</p>
<p>Note: The Points element is only returned in Japan (JP).</p>
<p>Type: <a href="#Points_AnyOfferChanged">Points</a></p></td>
</tr>
<tr class="odd">
<td>Shipping</td>
<td><p>The shipping cost.</p>
<p>Required.</p>
<p>Type: <a href="#moneytype">MoneyType</a></p></td>
</tr>
<tr class="even">
<td>ShipsFrom</td>
<td><p>The state and country from where the item is shipped.</p>
<p>Optional.</p>
<p>Type: <a href="#ShipsFrom_AnyOfferChanged">ShipsFrom</a></p></td>
</tr>
<tr class="odd">
<td>IsFulfilledByAmazon</td>
<td><p>Indicates whether the offer is fulfilled by Amazon.</p>
<p>Required.</p>
<p>Type: boolean</p></td>
</tr>
<tr class="even">
<td>IsBuyBoxWinner</td>
<td><p>Indicates whether the offer is currently in the Buy Box. There can be up to two Buy Box winners at any time per ASIN, one that is eligible for Prime and one that is not eligible for Prime.</p>
<p>Optional.</p>
<p>Type: boolean</p></td>
</tr>
<tr class="odd">
<td>ConditionNotes</td>
<td><p>Information about the condition of the item.</p>
<p>Optional.</p>
<p>Type: string</p></td>
</tr>
<tr class="even">
<td>PrimeInformation</td>
<td><p>Amazon Prime information.</p>
<p>Optional.</p>
<p>Type: <a href="#PrimeInformation_AnyOfferChanged">PrimeInformation</a></p></td>
</tr>
<tr class="odd">
<td>IsExpeditedShippingAvailable</td>
<td><p>Indicates whether expedited shipping is available.</p>
<p>Optional.</p>
<p>Type: boolean</p></td>
</tr>
<tr class="even">
<td>IsFeaturedMerchant</td>
<td><p>Indicates whether the seller of the item is eligible to win the Buy Box.</p>
<p>Optional.</p>
<p>Type: boolean</p></td>
</tr>
<tr class="odd">
<td>ShipsDomestically</td>
<td><p>Indicates whether the item ships domestically.</p>
<p>Optional.</p>
<p>Type: boolean</p></td>
</tr>
</tbody>
</table>

<h3 id="OfferChangeTrigger_AnyOfferChanged">OfferChangeTrigger</h3>

The following table shows the child elements of the OfferChangeTrigger element:

<table>
<thead>
<tr class="header">
<th><b>Name</b></th>
<th><b>Description</b></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>MarketplaceId</td>
<td><p>The marketplace identifier of the item that had an offer change.</p>
<p>Required.</p>
<p>Type: <a href="#marketplacetype">MarketplaceType</a></p></td>
</tr>
<tr class="even">
<td>ASIN</td>
<td><p>The ASIN for the item that had an offer change.</p>
<p>Required.</p>
<p>Type: string</p></td>
</tr>
<tr class="odd">
<td>ItemCondition</td>
<td><p>The condition of the item that had an offer change. For example, if a used offer changes, the list of offers in the Offers element will be only used items. The Summary element provides a summary for the other conditions that can be used for repricing.</p>
<p>Required.</p>
<p>Type: string</p></td>
</tr>
<tr class="even">
<td>TimeOfOfferChange</td>
<td><p>The update time for the offer that caused this notification.</p>
<p>Required.</p>
<p>Type: dateTime</p></td>
</tr>
<tr class="odd">
<td>OfferChangeType</td>
<td><p>The type of offer that changed and triggered this notification.</p>
<p>OfferChangeType values:</p>
<p><em>External</em> - The CompetitivePriceThreshold in the Summary element has changed, triggered by a new offer from a non-Amazon seller.</p>
<p><em>Internal</em> - The price of an offer on Amazon's retail website has changed.</p>
<p><em>Featured Offer</em> - The BuyBox winner or BuyBox price has changed.</p>
<p>Required.</p>
<p>Type: string</p></td>
</tr>
</tbody>
</table>

<h3 id="OfferCount_AnyOfferChanged">OfferCount</h3>

The following table shows the child elements of the OfferCount element:

<table>
<thead>
<tr class="header">
<th><b>Name</b></th>
<th><b>Description</b></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>Condition</td>
<td><p>Indicates the condition of the item. For example: New, Used, Collectible, Refurbished, or Club.</p>
<p>Required.</p>
<p>Type: string</p></td>
</tr>
<tr class="even">
<td>FulfillmentChannel</td>
<td><p>Indicates whether the item is fulfilled by Amazon or by the seller.</p>
<p>Required.</p>
<p>Type: <a href="#fulfillmentchanneltype">FulfillmentChannelType</a></p></td>
</tr>
<tr class="odd">
<td>OfferCount</td>
<td><p>The total number of offers for the specified condition and fulfillment channel.</p>
<p>Type: int</p></td>
</tr>
</tbody>
</table>

<h3 id="Points_AnyOfferChanged">Points</h3>

The following table shows the child elements of the Points element:

<table>
<thead>
<tr class="header">
<th><b>Name</b></th>
<th><b>Description</b></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>PointsNumber</td>
<td><p>The number of Amazon Points offered with the purchase of an item.</p>
<p>Required.</p>
<p>Type: int</p></td>
</tr>
</tbody>
</table>

<h3 id="PrimeInformation_AnyOfferChanged">PrimeInformation</h3>

The following table shows the child elements of the PrimeInformation element:

<table>
<thead>
<tr class="header">
<th><b>Name</b></th>
<th><b>Description</b></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>IsNationalPrime</td>
<td><p>Indicates whether the offer is an Amazon Prime offer throughout the entire marketplace where it is listed.</p>
<p>Required.</p>
<p>Type: boolean</p></td>
</tr>
<tr class="even">
<td>IsPrime</td>
<td><p>Indicates whether the offer is an Amazon Prime offer.</p>
<p>Required.</p>
<p>Type: boolean</p></td>
</tr>
</tbody>
</table>

<h3 id="SalesRank_AnyOfferChanged">SalesRank</h3>

The following table shows the child elements of the SalesRank element:

<table>
<thead>
<tr class="header">
<th><b>Name</b></th>
<th><b>Description</b></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>ProductCategoryId</td>
<td><p>The product category identifier of the item.</p>
<p>Required.</p>
<p>Type: string</p></td>
</tr>
<tr class="even">
<td>Rank</td>
<td><p>The sales rank of the item in the given product category.</p>
<p>Required.</p>
<p>Type: int</p></td>
</tr>
</tbody>
</table>

<h3 id="SellerFeedbackRating_AnyOfferChanged">SellerFeedbackRating</h3>

The following table shows the child elements of the SellerFeedbackRating element:

<table>
<thead>
<tr class="header">
<th><b>Name</b></th>
<th><b>Description</b></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>SellerPositiveFeedbackRating</td>
<td><p>The percentage of positive feedback for the seller in the past 365 days.</p>
<p>Optional.</p>
<p>Type: double</p></td>
</tr>
<tr class="even">
<td>FeedbackCount</td>
<td><p>The count of feedback received about the seller.</p>
<p>Required.</p>
<p>Type: long</p></td>
</tr>
</tbody>
</table>

<h3 id="ShippingTime_AnyOfferChanged">ShippingTime</h3>

The following table shows the child elements of the ShippingTime element:

<table>
<thead>
<tr class="header">
<th><b>Name</b></th>
<th><b>Description</b></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>MinimumHours</td>
<td><p>The minimum time, in hours, that the item will likely be shipped after the order has been placed.</p>
<p>Optional.</p>
<p>Type: short</p></td>
</tr>
<tr class="even">
<td>MaximumHours</td>
<td><p>The maximum time, in hours, that the item will likely be shipped after the order has been placed.</p>
<p>Optional.</p>
<p>Type: short</p></td>
</tr>
<tr class="odd">
<td>AvailableDate</td>
<td><p>The date when the item will be available for shipping. Only displayed for items that are not currently available for shipping.</p>
<p>Optional.</p>
<p>Type: dateTime</p></td>
</tr>
<tr class="even">
<td>AvailabilityType</td>
<td><p>Indicates whether the item is available for shipping now, or on a known or an unknown date in the future. If known, the availableDate attribute indicates the date that the item will be available for shipping.</p>
<p>Optional.</p>
<p>Type: <a href="#availabilitytype">AvailabilityType</a></p></td>
</tr>
</tbody>
</table>

<h3 id="ShipsFrom_AnyOfferChanged">ShipsFrom</h3>

The following table shows the child elements of the ShipsFrom element:

<table>
<thead>
<tr class="header">
<th><b>Name</b></th>
<th><b>Description</b></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>State</td>
<td><p>The state from where the item is shipped.</p>
<p>Optional.</p>
<p>Type: string</p></td>
</tr>
<tr class="even">
<td>Country</td>
<td><p>The country from where the item is shipped.</p>
<p>Optional.</p>
<p>Type: string</p></td>
</tr>
<tr class="odd">
<td>IsFulfilledByAmazon</td>
<td><p>Indicates whether the offer is fulfilled by Amazon.</p>
<p>Required.</p>
<p>Type: boolean</p></td>
</tr>
</tbody>
</table>

<h3 id="Summary_AnyOfferChanged">Summary</h3>

The following table shows the child elements of the Summary element:

<table>
<thead>
<tr class="header">
<th><b>Name</b></th>
<th><b>Description</b></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>NumberOfOffers</td>
<td><p>A list that contains the total number of offers for the item for the given conditions and fulfillment channels.</p>
<p>Required.</p>
<p>Type: List of <a href="#OfferCount_AnyOfferChanged">OfferCount</a></p></td>
</tr>
<tr class="even">
<td>LowestPrices</td>
<td><p>A list that contains the lowest prices of the item for the given conditions and fulfillment channels.</p>
<p>Required.</p>
<p>Type: List of <a href="#LowestPrice_AnyOfferChanged">LowestPrice</a></p></td>
</tr>
<tr class="odd">
<td>BuyBoxPrices</td>
<td><p>A list that contains the Buy Box price of the item for the given conditions.</p>
<p>Optional.</p>
<p>Type: List of <a href="#BuyBoxPrice_AnyOfferChanged">BuyBoxPrice</a></p></td>
</tr>
<tr class="even">
<td>ListPrice</td>
<td><p>The list price of the item as suggested by the manufacturer.</p>
<p>Optional.</p>
<p>Type: <a href="#moneytype">MoneyType</a></p></td>
</tr>
<tr class="odd">
<td>SuggestedLowerPricePlusShipping</td>
<td><p>The suggested lower price of the item, including shipping (minus Amazon Points). The suggested lower price is based on a range of factors, including historical selling prices, recent Buy Box-eligible prices, and input from customers for your products.</p>
<p>Optional.</p>
<p>Type: <a href="#moneytype">MoneyType</a></p></td>
</tr>
<tr class="even">
<td>SalesRankings</td>
<td><p>A list that contains the sales rank of the item in the given product categories.</p>
<p>Optional.</p>
<p>Type: List of <a href="#SalesRank_AnyOfferChanged">SalesRank</a></p></td>
</tr>
<tr class="odd">
<td>NumberOfBuyBoxEligibleOffers</td>
<td><p>A list that contains the total number of offers that are eligible for the Buy Box for the given conditions and fulfillment channels.</p>
<p>Required.</p>
<p>Type: List of <a href="#OfferCount_AnyOfferChanged">OfferCount</a></p></td>
</tr>
<tr class="even">
<td>CompetitivePriceThreshold</td>
<td><p>This price is based on competitive prices from other retailers (excluding other Amazon sellers). Your offer may be ineligible for the Buy Box if Your price + shipping is greater than this competitive price.</p>
<p>Optional.</p>
<p>Type: <a href="#moneytype">MoneyType</a></p></td>
</tr>
</tbody>
</table>

**Notification schema:** [AnyOfferChangedNotification.json](https://amazonservicesstatic.com/json-schemas/notifications/AnyOfferChangedNotification.json)

**Notification example:**
```
{
  "NotificationVersion": "1.0",
  "NotificationType": "ANY_OFFER_CHANGED",
  "PayloadVersion": "1.0",
  "EventTime": "2020-01-11T00:09:53.109Z",
  "NotificationMetadata":
  {
    "ApplicationId": "amzn1.sellerapps.app.f1234566-aaec-55a6-b123-bcb752069ec5",
    "SubscriptionId": "7d78cc50-95c8-4641-add7-10af4b1fedc9",
    "PublishTime": "2020-01-11T00:02:50.501Z",
    "NotificationId": " 2012e8e5-b365-4cb1-9fd8-be9dfc6d5eaf"
  },
  "Payload":
  {
    "AnyOfferChangedNotification":
    {
      "SellerId": "merchantId",
      "OfferChangeTrigger":
      {
        "MarketplaceId": "marketplaceId",
        "ASIN": "ysp2k4cziG",
        "ItemCondition": "Collectible",
        "TimeOfOfferChange": "2020-01-11T00:02:50.501Z",
        "OfferChangeType": ""
      },
      "Summary":
      {
        "NumberOfOffers": [
          {
            "Condition": "new",
            "FulfillmentChannel": "Merchant",
            "OfferCount": 28
          }
        ],
        "LowestPrices": [
          {
            "Condition": "new",
            "FulfillmentChannel": "Merchant",
            "LandedPrice":
            {
              "Amount": 28.59,
              "CurrencyCode": "USD"
            },
            "ListingPrice":
            {
              "Amount": 28.59,
              "CurrencyCode": "USD"
            },
            "Shipping":
            {
              "Amount": 0,
              "CurrencyCode": "USD"
            }
          }
        ],
        "BuyBoxPrices": [
          {
            "Condition": "new",
            "LandedPrice":
            {
              "Amount": 14,
              "CurrencyCode": "USD"
            },
            "ListingPrice":
            {
              "Amount": 12,
              "CurrencyCode": "USD"
            },
            "Shipping":
            {
              "Amount": 2,
              "CurrencyCode": "USD"
            }
          }
        ],
        "ListPrice":
        {
          "Amount": 14,
          "CurrencyCode": "USD"
        },
        "SalesRankings": [
          {
            "ProductCategoryId": "lawn_and_garden_display_on_website",
            "Rank": 4013
          },
          {
            "ProductCategoryId": "home_garden_display_on_website",
            "Rank": 17316
          }
        ],
        "NumberOfBuyBoxEligibleOffers": [
          {
            "Condition": "new",
            "FulfillmentChannel": "Merchant",
            "OfferCount": 10
          }
        ]
      },
      "Offers": [
        {
          "SellerId": "AQNACJEM8PUJ1",
          "SubCondition": "new",
          "SellerFeedbackRating":
          {
            "FeedbackCount": 78786,
            "SellerPositiveFeedbackRating": 92
          },
          "ShippingTime":
          {
            "MinimumHours": 24,
            "MaximumHours": 48,
            "AvailabilityType": "",
            "AvailableDate": ""
          },
          "ListingPrice":
          {
            "Amount": 28.59,
            "CurrencyCode": "USD"
          },
          "Shipping":
          {
            "Amount": 0,
            "CurrencyCode": "USD"
          },
          "ShipsFrom":
          {
            "Country": "",
            "State": ""
          },
          "IsFulfilledByAmazon": false
        },
        {
          "SellerId": "A28SS3BS1DBQ92",
          "SubCondition": "new",
          "SellerFeedbackRating":
          {
            "FeedbackCount": 6532,
            "SellerPositiveFeedbackRating": 99
          },
          "ShippingTime":
          {
            "MinimumHours": 24,
            "MaximumHours": 48,
            "AvailabilityType": "",
            "AvailableDate": ""
          },
          "ListingPrice":
          {
            "Amount": 28.69,
            "CurrencyCode": "USD"
          },
          "Shipping":
          {
            "Amount": 0,
            "CurrencyCode": "USD"
          },
          "ShipsFrom":
          {
            "Country": "",
            "State": ""
          },
          "IsFulfilledByAmazon": false
        }
      ]
    }
  }
}
```
## B2B_ANY_OFFER_CHANGED


The **B2B_ANY_OFFER_CHANGED** notification is sent whenever there is a change in any of the top 20 B2B offers, in the form of any price change (either single unit or quantity discount tier prices) for an item listed by the seller. The top 20 B2B offers are determined by the single-unit landed price, which is the price plus shipping. If multiple sellers are charging the same landed price, the results will be returned in random order.

You will only receive **B2B_ANY_OFFER_CHANGED** notifications for items for which the seller has active offers. You cannot subscribe to notifications for items for which the seller does not have active offers.

The following table shows the child elements of the B2B AnyOfferChangedNotification element:

<table>
<thead>
<tr class="header">
<th><b>Name</b></th>
<th><b>Description</b></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>OfferChangeTrigger</td>
<td><p>The event that caused the notification to be sent.</p> <p>Required.</p>
<p>Type: <a href="#offerchangetrigger">OfferChangeTrigger</a></p></td>
</tr>
<tr class="even">
<td>Summary</td>
<td><p>Information about the product that had the offer change. The information in this summary applies to all conditions of the product.</p>
<p>Required.</p>
<p>Type: <a href="#summary">Summary</a></p></td>
</tr>
<tr class="odd">
<td>Offers</td>
<td><p>The top 20 competitive B2B offers for the item and condition that triggered the notification.</p>
<p>Required.</p>
<p>Type: List of <a href="#offer">Offer</a></p></td>
</tr>
<tr class="even">
<td>SellerId</td>
<td><p>The seller identifier for the offer.</p>
<p>Required.</p>
<p>Type: string</p></td>
</tr>
</tbody>
</table>


### BuyBoxPrice

The following table shows the child elements of the BuyBoxPrice element.

<table>
<thead>
<tr class="header">
<th><strong>Name</strong></th>
<th><strong>Description</strong></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>LandedPrice</td>
<td><p>ListingPrice + Shipping.</p>
<p>Optional.</p>
<p>Type: <a href="#moneytype">MoneyType</a></p></td>
</tr>
<tr class="even">
<td>ListingPrice</td>
<td><p>The price of the item.</p>
<p>Required.</p>
<p>Type: <a href="#moneytype">MoneyType</a></p></td>
</tr>
<tr class="odd">
<td>Shipping</td>
<td><p>The shipping cost.</p>
<p>Optional.</p>
<p>Type: <a href="#moneytype">MoneyType</a></p></td>
</tr>
<tr class="even">
<td>OfferType</td>
<td><p>Indicates whether the offer is a B2B offer or a B2C offer</p>
<p>Required.</p>
<p>Type: string</p></td>
</tr>
<tr class="odd">
<td>QuantityTier</td>
<td><p>The quantity tier for the offer</p>
<p>Required.</p>
<p>Type: int</p></td>
</tr>
<tr class="even">
<td>DiscountType</td>
<td><p>Indicates whether the quantity tier is for Quantity Discount or Progressive Discount.</p>
<p>Optional.</p>
<p>Type: string</p></td>
</tr>
<tr class="odd">
<td>Condition</td>
<td><p>Indicates the condition of the item. For example: New, Used, Collectible, Refurbished, or Club.</p>
<p>Required.</p>
<p>Type: string</p></td>
</tr>
</tbody>
</table>


### LowestPrice

The following table shows the child elements of the LowestPrice type under Summary element:

<table>
<thead>
<tr class="header">
<th><strong>Name</strong></th>
<th><strong>Description</strong></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>LandedPrice</td>
<td><p>ListingPrice + Shipping.</p>
<p>Optional.</p>
<p>Type: <a href="#moneytype">MoneyType</a></p></td>
</tr>
<tr class="even">
<td>ListingPrice</td>
<td><p>The price of the item.</p>
<p>Required.</p>
<p>Type: <a href="#moneytype">MoneyType</a></p></td>
</tr>
<tr class="odd">
<td>Shipping</td>
<td><p>The shipping cost.</p>
<p>Optional.</p>
<p>Type: <a href="#moneytype">MoneyType</a></p></td>
</tr>
<tr class="even">
<td>OfferType</td>
<td><p>Indicates whether the offer is a B2B offer or a B2C offer</p>
<p>Required.</p>
<p>Type: string</p></td>
</tr>
<tr class="odd">
<td>QuantityTier</td>
<td><p>The quantity tier for the offer</p>
<p>Required.</p>
<p>Type: int</p></td>
</tr>
<tr class="even">
<td>DiscountType</td>
<td><p>Indicates whether the quantity tier is for Quantity Discount or Progressive Discount.</p>
<p>Optional.</p>
<p>Type: string</p></td>
</tr>
<tr class="odd">
<td>Condition</td>
<td><p>Indicates the condition of the item. For example: New, Used, Collectible, Refurbished, or Club.</p>
<p>Required.</p>
<p>Type: string</p></td>
</tr>
<tr class="even">
<td>FulfillmentChannel</td>
<td><p>Indicates whether the item is fulfilled by Amazon or by the seller.</p>
<p>Required.</p>
<p>Type: <a href="#FulfillmentChannelType">FulfillmentChannelType</a></p></td>
</tr>
</tbody>
</table>


### Offer

The following table shows the child elements of the Offer element:

<table>
<thead>
<tr class="header">
<th><strong>Name</strong></th>
<th><strong>Description</strong></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>SellerId</td>
<td><p>The seller identifier for the offer.</p>
<p>Required.</p>
<p>Type: string</p></td>
</tr>
<tr class="even">
<td>SubCondition</td>
<td><p>The subcondition of the item. For example: <em>New</em>, <em>Mint</em>, <em>Very Good</em>, <em>Good</em>, <em>Acceptable</em>, <em>Poor</em>, <em>Club</em>, <em>OEM</em>, <em>Warranty</em>, <em>Refurbished Warranty</em>, <em>Refurbished</em>, <em>Open Box</em>, or <em>Other</em>.</p>
<p>Required.</p>
<p>Type: string</p></td>
</tr>
<tr class="odd">
<td>SellerFeedbackRating</td>
<td><p>Information about the seller's feedback, including the percentage of positive feedback, and the total count of feedback received.</p>
<p>Optional.</p>
<p>Type: <a href="#SellerFeedbackRating">SellerFeedbackRating</a></p></td>
</tr>
<tr class="even">
<td>ShippingTime</td>
<td><p>The minimum and maximum time, in hours, that the item will likely be shipped after the order has been placed.</p>
<p>Required.</p>
<p>Type: <a href="#ShippingTime">ShippingTime</a></p></td>
</tr>
<tr class="odd">
<td>ListingPrice</td>
<td><p>The price of the item.</p>
<p>Required.</p>
<p>Type: <a href="#moneytype">MoneyType</a></p></td>
</tr>
<tr class="even">
<td>Shipping</td>
<td><p>The shipping cost.</p>
<p>Required.</p>
<p>Type: <a href="#moneytype">MoneyType</a></p></td>
</tr>
<tr class="odd">
<td>ShipsFrom</td>
<td><p>The country from where the item is shipped.</p>
<p>Optional.</p>
<p>Type: <a href="#ShipsFrom">ShipsFrom</a></p></td>
</tr>
<tr class="even">
<td>IsFulfilledByAmazon</td>
<td><p>Indicates whether the offer is fulfilled by Amazon.</p>
<p>Required.</p>
<p>Type: boolean</p></td>
</tr>
<tr class="odd">
<td>IsBuyBoxWinner</td>
<td><p>Indicates whether the offer is currently in the Buy Box. There can be up to two Buy Box winners at any time per ASIN, one that is eligible for Prime and one that is not eligible for Prime.</p>
<p>Optional.</p>
<p>Type: boolean</p></td>
</tr>
<tr class="even">
<td>ConditionNotes</td>
<td><p>Information about the condition of the item.</p>
<p>Optional.</p>
<p>Type: string</p></td>
</tr>
<tr class="odd">
<td>PrimeInformation</td>
<td><p>Amazon Prime information.</p>
<p>Optional.</p>
<p>Type: <a href="#PrimeInformation">PrimeInformation</a></p></td>
</tr>
<tr class="even">
<td>IsFeaturedMerchant</td>
<td><p>Indicates whether the seller of the item is eligible to win the Buy Box.</p>
<p>Optional.</p>
<p>Type: boolean</p></td>
</tr>
</tbody>
</table>


### OfferChangeTrigger

The following table shows the child elements of the OfferChangeTrigger element:

<table>
<thead>
<tr class="header">
<th><strong>Name</strong></th>
<th><strong>Description</strong></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>MarketplaceId</td>
<td><p>The marketplace identifier of the item that had an offer change.</p>
<p>Required.</p>
<p>Type: <a href="#MarketplaceType">MarketplaceType</a></p></td>
</tr>
<tr class="even">
<td>ASIN</td>
<td><p>The ASIN for the item that had an offer change.</p>
<p>Required.</p>
<p>Type: string</p></td>
</tr>
<tr class="odd">
<td>ItemCondition</td>
<td><p>The condition of the item that had an offer change. For example, if a used offer changes, the list of offers in the Offers element will be only used items. The Summary element provides a summary for the other conditions that can be used for repricing.</p>
<p>Required.</p>
<p>Type: string</p></td>
</tr>
<tr class="even">
<td>TimeOfOfferChange</td>
<td><p>The update time for the offer that caused this notification.</p>
<p>Required.</p>
<p>Type: dateTime</p></td>
</tr>
</tbody>
</table>


### OfferCount

The following table shows the child elements of the OfferCount type:

<table>
<thead>
<tr class="header">
<th><strong>Name</strong></th>
<th><strong>Description</strong></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>Condition</td>
<td><p>Indicates the condition of the item. For example: <em>New</em>, <em>Used</em>, <em>Collectible</em>, <em>Refurbished</em>, or <em>Club</em>.</p>
<p>Required.</p>
<p>Type: string</p></td>
</tr>
<tr class="even">
<td>FulfillmentChannel</td>
<td><p>Indicates whether the item is fulfilled by Amazon or by the seller.</p>
<p>Required.</p>
<p>Type: <a href="#FulfillmentChannelType">FulfillmentChannelType</a></p></td>
</tr>
<tr class="odd">
<td>OfferCount</td>
<td><p>The total number of offers for the specified condition and fulfillment channel.</p>
<p>Type: int</p></td>
</tr>
</tbody>
</table>


### PrimeInformation

The following table shows the child elements of the PrimeInformation element:

<table>
<thead>
<tr class="header">
<th><strong>Name</strong></th>
<th><strong>Description</strong></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>IsNationalPrime</td>
<td><p>Indicates whether the offer is an Amazon Prime offer throughout the entire marketplace where it is listed.</p>
<p>Required.</p>
<p>Type: boolean</p></td>
</tr>
<tr class="even">
<td>IsPrime</td>
<td><p>Indicates whether the offer is an Amazon Prime offer.</p>
<p>Required.</p>
<p>Type: boolean</p></td>
</tr>
</tbody>
</table>

### SellerFeedbackRating

The following table shows the child elements of the SellerFeedbackRating element:

<table>
<thead>
<tr class="header">
<th><strong>Name</strong></th>
<th><strong>Description</strong></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>SellerPositiveFeedbackRating</td>
<td><p>The percentage of positive feedback for the seller in the past 365 days.</p>
<p>Optional.</p>
<p>Type: double</p></td>
</tr>
<tr class="even">
<td>FeedbackCount</td>
<td><p>The count of feedback received about the seller.</p>
<p>Required.</p>
<p>Type: long</p></td>
</tr>
</tbody>
</table>

### ShippingTime

The following table shows the child elements of the ShippingTime element:

<table>
<thead>
<tr class="header">
<th><strong>Name</strong></th>
<th><strong>Description</strong></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td><em>MinimumHours</em></td>
<td><p>The minimum time, in hours, that the item will likely be shipped after the order has been placed.</p>
<p>Optional.</p>
<p>Type: short</p></td>
</tr>
<tr class="even">
<td>MaximumHours</td>
<td><p>The maximum time, in hours, that the item will likely be shipped after the order has been placed.</p>
<p>Optional.</p>
<p>Type: short</p></td>
</tr>
<tr class="odd">
<td>AvailableDate</td>
<td><p>The date when the item will be available for shipping. Only displayed for items that are not currently available for shipping.</p>
<p>Optional.</p>
<p>Type: dateTime</p></td>
</tr>
<tr class="even">
<td>AvailabilityType</td>
<td><p>Indicates whether the item is available for shipping now, or on a known or an unknown date in the future. If known, the <em>availableDate</em> attribute indicates the date that the item will be available for shipping.</p>
<p>Optional.</p>
<p>Type: <a href="#AvailabilityType">AvailabilityType</a></p></td>
</tr>
</tbody>
</table>


### ShipsFrom

The following table shows the child elements of the ShipsFrom element:

<table>
<thead>
<tr class="header">
<th><strong>Name</strong></th>
<th><strong>Description</strong></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>Country</td>
<td><p>The country from where the item is shipped.</p>
<p>Optional.</p>
<p>Type: string</p></td>
</tr>
</tbody>
</table>

### Summary

The following table shows the child elements of the Summary element:

<table>
<thead>
<tr class="header">
<th><strong>Name</strong></th>
<th><strong>Description</strong></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>NumberOfOffers</td>
<td><p>A list that contains the total number of B2B offers for the item for the given conditions and fulfillment channels.</p>
<p>Required.</p>
<p>Type: List of <a href="#OfferCount">OfferCount</a></p></td>
</tr>
<tr class="even">
<td>LowestPrices</td>
<td><p>A list that contains the lowest prices of the item for the given conditions, fulfillment channels, quantity tiers, and discount types.</p>
<p>The seven pre-defined quantity tiers for discount type “Quantity Discounts” are 2, 3, 5, 10, 20, 30 and 50.</p>
<p>Required.</p>
<p>Type: List of <a href="#LowestPrice">LowestPrice</a></p></td>
</tr>
<tr class="odd">
<td>BuyBoxPrices</td>
<td><p>A list that contains the Buy Box price of the item for the given conditions, quantity tiers, and discount types.</p>
<p>The seven pre-defined quantity tiers for discount type “Quantity Discounts” are 2, 3, 5, 10, 20, 30 and 50.</p>
<p>Optional.</p>
<p>Type: List of <a href="#BuyBoxPrice">BuyBoxPrice</a></p></td>
</tr>
<tr class="even">
<td>BuyBoxEligibleOffers</td>
<td><p>A list that contains the total number of B2B offers that are eligible for the Buy Box for the given conditions and fulfillment channels.</p>
<p>Required.</p>
<p>Type: List of <a href="#OfferCount">OfferCount</a></p></td>
</tr>
</tbody>
</table>

**Notification schema:** [B2bAnyOfferChangedNotification.json](https://amazonservicesstatic.com/json-schemas/notifications/B2bAnyOfferChangedNotification.json)

**Notification example:**
```
{
  "notificationVersion": "1.0",
  "notificationType": "B2B_ANY_OFFER_CHANGED",
  "payloadVersion": "1.0",
  "eventTime": "2020-09-23T21:30:13.713Z",
  "notificationMetadata": {
    "applicationId": "amzn1.sellerapps.app.1da85d14-a68d-4ff3-9ff0-df6429e00d9a",
    "subscriptionId": "e3a059ca-677a-442a-8d39-05b2848971b6",
    "publishTime": "2020-09-23T21:30:16.903Z",
    "notificationId": "23ae41cd-3537-4676-af46-6ee9abf8802e"
  },
  "payload": {
    "b2bAnyOfferChangedNotification": {
      "sellerId": "A3EZFOFNDPFB8R",
      "offerChangeTrigger": {
        "marketplaceId": "ATVPDKIKX0DER",
        "asin": "B007IBIWZY",
        "itemCondition": "new",
        "timeOfOfferChange": "2020-09-23T21:30:13.409Z"
      },
      "summary": {
        "numberOfOffers": [{
            "condition": "new",
            "fulfillmentChannel": "Merchant",
            "offerCount": 3
          }
        ],
        "buyBoxEligibleOffers": [{
            "condition": "new",
            "fulfillmentChannel": "Merchant",
            "offerCount": 3
          }
        ],
        "lowestPrices": [{
            "condition": "new",
            "fulfillmentChannel": "Merchant",
            "offerType": "B2B",
            "quantityTier": 1,
            "listingPrice": {
              "amount": 8184.23,
              "currencyCode": "USD"
            },
            "shipping": {
              "amount": 4.49,
              "currencyCode": "USD"
            },
            "landedPrice": {
              "amount": 8188.72,
              "currencyCode": "USD"
            }
          }, {
            "condition": "new",
            "fulfillmentChannel": "Merchant",
            "offerType": "B2B",
            "quantityTier": 20,
            "listingPrice": {
              "amount": 7500,
              "currencyCode": "USD"
            }
          }, {
            "condition": "new",
            "fulfillmentChannel": "Merchant",
            "offerType": "B2B",
            "quantityTier": 30,
            "discountType": "QUANTITY_DISCOUNT",
            "listingPrice": {
              "amount": 6975,
              "currencyCode": "USD"
            }
          }
        ],
        "buyBoxPrices": [{
            "condition": "new",
            "offerType": "B2B",
            "quantityTier": 1,
            "listingPrice": {
              "amount": 8184.23,
              "currencyCode": "USD"
            },
            "shipping": {
              "amount": 4.49,
              "currencyCode": "USD"
            },
            "landedPrice": {
              "amount": 8188.72,
              "currencyCode": "USD"
            }
          }, {
            "condition": "new",
            "offerType": "B2B",
            "quantityTier": 20,
            "discountType": "QUANTITY_DISCOUNT",
            "listingPrice": {
              "amount": 8000,
              "currencyCode": "USD"
            }
          }, {
            "condition": "new",
            "offerType": "B2B",
            "quantityTier": 30,
            "discountType": "QUANTITY_DISCOUNT",
            "listingPrice": {
              "amount": 7800,
              "currencyCode": "USD"
            }
          }
        ]
      },
      "offers": [{
          "sellerId": "A2VUIDM8BZ902A",
          "subCondition": "new",
          "sellerFeedbackRating": {
            "feedbackCount": 1,
            "sellerPositiveFeedbackRating": 0
          },
          "shippingTime": {
            "minimumHours": 24,
            "maximumHours": 48,
            "availabilityType": "available",
            "availableDate": "2020-07-13T19:42:04.284Z"
          },
          "listingPrice": {
            "amount": 8184.23,
            "currencyCode": "USD"
          },
          "shipping": {
            "amount": 4.49,
            "currencyCode": "USD"
          },
          "shipsFrom": {
            "country": "US"
          },
          "isFulfilledByAmazon": false,
          "isBuyBoxWinner": true,
          "conditionNotes": "New in box",
          "primeInformation": {
            "isPrime": true,
            "isNationalPrime": true
          },
          "isFeaturedMerchant": true
        }
      ]
    }
  }
}


```
## BRANDED_ITEM_CONTENT_CHANGE

Amazon sends a **BRANDED_ITEM_CONTENT_CHANGE** notification whenever there is a change to the title, description, or bullet points for any ASIN that the selling partner has a brand relationship with. A selling partner has a brand relationship with an ASIN, as defined in the Amazon Registered Brands program, when they are a Brand Representative or an Authorized Reseller. The selling partner is the party who authorizes an application to call the Notifications API on their behalf, for the purpose of creating and managing notification subscriptions. Amazon sends **BRANDED_ITEM_CONTENT_CHANGE** notifications for items listed in any Amazon marketplace.

**BRANDED_ITEM_CONTENT_CHANGE Payload schema: Version 1.0**

A **BRANDED_ITEM_CONTENT_CHANGE** notification with **PayloadVersion**=*1.0* includes the following objects in the **Payload** object.

| **Object**    | **Description**                             |
| ------------- | ------------------------------------------- |
| MarketplaceId | The marketplace that the item is listed in. |
| BrandName     | The brand name of the item.                 |
| Asin          | The ASIN of the item.                       |

**Notification schema:** [BrandedItemContentChangeNotification.json](https://amazonservicesstatic.com/json-schemas/notifications/BrandedItemContentChangeNotification.json)

**Notification example:**
```
{
  "NotificationVersion": "1.0",
  "NotificationType": "BRANDED_ITEM_CONTENT_CHANGE",
  "PayloadVersion": "1.0",
  "EventTime": "2019-03-20T18:59:30.194Z",
  "Payload": {
    "MarketplaceId": "ATVPDKIKX0DER",
    "BrandName": "Great Brand",
    "Asin": "B1234567",
    "AttributesChanged": ["bullet_point", "item_name", "product_description"]
  },
  "NotificationMetadata": {
    "ApplicationId": "amzn1.sellerapps.app.f1234566-aaec-55a6-b123-bcb752069ec5",
    "SubscriptionId": "93b098e1-c42-2f45-93a1-78910a6a8369",
    "PublishTime": "2019-03-20T18:59:48.768Z",
    "NotificationId": "8e009934-da2c-4f9c-9bc7-93f23b7e1f60"
  }
}
```
## FEE_PROMOTION

Sellers using  Selling Partner API can benefit from time-limited fee promotions. To receive notification of available fee promotions, sellers must subscribe to FEE_PROMOTION notification. When the seller initially signs up for the subscription and *isEnabled* is set to *true*, the seller receives all currently active promotions. Each promotion is sent as a single message. Subsequent promotion notifications are sent when the promotion becomes active.

FEE_PROMOTION notification is made up of a set of data fields describing the details of that promotion. All qualifying criteria for each promotion will be described in those data fields.

Note: The estimated fees returned by this API are not guaranteed. Actual fees may vary. For more information on fees, see [Selling on Amazon Fee Schedule](https://sellercentral.amazon.co.uk/gp/help/200336920) and [FBA features and fees](https://sellercentral-europe.amazon.com/gp/help/201074400) on Seller Central.

### FeeDetail

The following table shows the attributes of a FeeDetail element:

<table>
<thead>
<tr class="header">
<th><b>Name</b></th>
<th><b>Description</b></th>
<th><b>Required</b></th>
<th><b>Value</b></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>FeeType</td>
<td>The type of fees charged.</td>
<td>Yes</td>
<td><p>Allowed Fee types: ReferralFee, VariableClosingFee, PerItemFee, FBAFees, FBAPickAndPack, FBAWeightHandling, FBAOrderHandling, FBADeliveryServicesFee.</p>
<p>Type: string</p></td>
</tr>
<tr class="even">
<td>FeeAmount</td>
<td>The fee amount corresponding to the fee type.</td>
<td>Yes</td>
<td>Type: <a href="#moneytype">MoneyType</a></td>
</tr>
<tr class="odd">
<td>FeePromotion</td>
<td>The fee promotion amount corresponding to the fee type.</td>
<td>No</td>
<td>Type: <a href="#moneytype">MoneyType</a></td>
</tr>
<tr class="even">
<td>TaxAmount</td>
<td>The tax calculated over fee that would be charged to the seller.</td>
<td>No</td>
<td>Type: <a href="#moneytype">MoneyType</a></td>
</tr>
<tr class="odd">
<td>FinalFee</td>
<td>The final fee that would be charged to the seller.</td>
<td>Yes</td>
<td><p>The FeeAmount minus the FeePromotion.</p>
<p>Type: <a href="#moneytype">MoneyType</a></p></td>
</tr>
<tr class="even">
<td>IncludedFees</td>
<td>A structured list of FeeDetail that contains the itemization of a specific fee type.</td>
<td>No</td>
<td>Type: List of <a href="#feedetail">FeeDetail</a></td>
</tr>
</tbody>
</table>

### FeesEstimate

The following table shows the child elements of the FeesEstimate element:

| **Name**            | **Description**                                              | **Required** | **Value**                             |
| ------------------- | ------------------------------------------------------------ | ------------ | ------------------------------------- |
| TimeOfFeesEstimated | The date time when the fees were estimated.                  | Yes          | Type: dateTime                        |
| TotalFeesEstimate   | The total amount of fees if the price is lowered to or below the price threshold. | Yes          | Type: [MoneyType](#moneytype)         |
| FeeDetails          | An itemization of the TotalFeesEstimate).                    | Yes          | Type: List of [FeeDetail](#feedetail) |

### FeePromotionNotification

Each FeePromotionNotification element is made up of the following data objects:

<table>
<thead>
<tr class="header">
<th><b>Name</b></th>
<th><b>Description</b></th>
<th><b>Required</b></th>
<th><b>Value</b></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>FeePromotionType</td>
<td>The type of promotion.</td>
<td>Yes</td>
<td><p>Values: Pricing, SelectionASIN, or SelectionCategory. Additional types may become available in the future.</p>
<p>Type: string</p></td>
</tr>
<tr class="even">
<td>FeePromotionTypeDescription</td>
<td>Provides more details on the purpose of a promotion.</td>
<td>No</td>
<td><p>A friendly, localized string description. Useful for integrators to display on a UI.</p>
<p>Type: string</p></td>
</tr>
<tr class="odd">
<td>MarketplaceId</td>
<td>The promotion applies to this marketplaceId.</td>
<td>Yes</td>
<td>Type: string</td>
</tr>
<tr class="even">
<td>MerchantId</td>
<td>The promotion applies to this merchantId.</td>
<td>Yes</td>
<td>Type: string</td>
</tr>
<tr class="odd">
<td>Identifiers</td>
<td>A list of items to which this promotion applies.</td>
<td>Yes</td>
<td>Type: List of <a href="#_Identifier">Identifier</a></td>
</tr>
<tr class="even">
<td>PromotionActiveTimeRange</td>
<td>The range of time when this promotion is active.</td>
<td>Yes</td>
<td>Type: <a href="#_PromotionActiveTimeRange">PromotionActiveTimeRange</a></td>
</tr>
<tr class="odd">
<td>PromotionInformation</td>
<td>An object containing additional details about the promotion. A fee estimate is included if applicable.</td>
<td>Yes</td>
<td>Type: <a href="#promotioninformation">PromotionInformation</a></td>
</tr>
</tbody>
</table>

### Identifier

The following table describes the attributes of an item from the IdentifierList element:

<table>
<thead>
<tr class="header">
<th><b>Name</b></th>
<th><b>Description</b></th>
<th><b>Required</b></th>
<th><b>Value</b></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>IdentifierType</td>
<td>The merchant identifier type for which this promotion will apply to.</td>
<td>Yes</td>
<td><p>For example: ASIN, SKU, Browse node, Brand.</p>
<p>Type: string</p></td>
</tr>
<tr class="even">
<td>IdentifierValues</td>
<td>The friendly name of the ID value.</td>
<td>Yes</td>
<td><p>For example: the merchant's actual ASINs or SKUs, an actual list of brands (like Nike), an actual list of browse nodes.</p>
<p>Type: List of <a href="#identifiervalue">IndentifierValue</a></p></td>
</tr>
</tbody>
</table>

### IdentifierValue

A description of identifier values to which this promotion applies.

<table>
<thead>
<tr class="header">
<th><b>Name</b></th>
<th><b>Description</b></th>
<th><b>Required</b></th>
<th><b>Value</b></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>IdentifierValueId</td>
<td>The actual browse node ID, actual ASIN/SKU, or brand value.</td>
<td>Yes</td>
<td>Type: xs:string</td>
</tr>
<tr class="even">
<td>IdentifierValueFriendlyName</td>
<td>The merchant identifier values to which this promotion will apply.</td>
<td>No</td>
<td><p>Only relevant/populated for things like browse nodes. For example, this would be a browse node's <em>friendly</em> name.</p>
<p>Type: xs:string</p></td>
</tr>
</tbody>
</table>

### PromotionInformation

The following table shows the child elements of the PromotionInformation element:

<table>
<thead>
<tr class="header">
<th><b>Name</b></th>
<th><b>Description</b></th>
<th><b>Required</b></th>
<th><b>Value</b></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>FeeType</td>
<td>The fee type which is being discounted in this promotion.</td>
<td>Yes</td>
<td><p>Allowed Fee types: ReferralFee, VariableClosingFee, PerItemFee, FBAFees, FBAPickAndPack, FBAWeightHandling, FBAOrderHandling, FBADeliveryServicesFee.</p>
<p>Type: string</p></td>
</tr>
<tr class="even">
<td>FeeDiscountType</td>
<td>The type of promotion you will be receiving for your fees.</td>
<td>Yes</td>
<td><p>Either Fixed, Discount, or Percentage points off.</p>
<p>Type: string</p></td>
</tr>
<tr class="odd">
<td>PriceThreshold</td>
<td>The qualifying threshold offer price, or less, that must be met for the promotion to apply.</td>
<td>No</td>
<td>Type: <a href="#moneytype">MoneyType</a></td>
</tr>
<tr class="even">
<td>FeeDiscountMonetaryAmount</td>
<td>The amount you will receive off of your fees if the FeeDiscountType involves a monetary amount.</td>
<td>No</td>
<td><p>If the FeeDiscountType involves a monetary amount, this value will be populated.</p>
<p>Type: <a href="#moneytype">MoneyType</a></p></td>
</tr>
<tr class="odd">
<td>FeeDiscountValue</td>
<td>The percentage discount of your fees if the FeeDiscountType involves a non-monetary amount.</td>
<td>No</td>
<td><p>If the FeeDiscountType involves a non-monetary amount, this value will be populated.</p>
<p>Type: BigDecimal</p></td>
</tr>
<tr class="even">
<td>FeesEstimate</td>
<td>The fee estimate for this promotion, if it is available. The estimate assumes that all condition required for the promotion have been met.</td>
<td>No</td>
<td>Type: <a href="#feesestimate">FeesEstimate</a></td>
</tr>
</tbody>
</table>

### PromotionActiveTimeRange

The following table shows the child elements of the PromotionActiveTimeRange element:

| **Name**             | **Description**                                     | **Required** | **Value**        |
| -------------------- | --------------------------------------------------- | ------------ | ---------------- |
| EffectiveFromDate    | Date (inclusive) when the promotion becomes active. | Yes          | *Type: dateTime* |
| EffectiveThroughDate | Date (exclusive) when the promotion has ended.      | *Yes*        | *Type: dateTime* |

**Notification schema:** [FeePromotionNotification.json](https://amazonservicesstatic.com/json-schemas/notifications/FeePromotionNotification.json)

**Notification example:**
```
{
  "NotificationVersion": "1.0",
  "NotificationType": "FEE_PROMOTION",
  "PayloadVersion": "1.0",
  "EventTime": "2020-01-11T00:09:53.109Z",
  "NotificationMetadata":
  {
    "ApplicationId": "amzn1.sellerapps.app.f1234566-aaec-55a6-b123-bcb752069ec5",
    "SubscriptionId": "7d78cc50-95c8-4641-add7-10af4b1fedc9",
    "PublishTime": "2020-01-11T00:02:50.501Z",
    "NotificationId": " 2012e8e5-b365-4cb1-9fd8-be9dfc6d5eaf"
  },
  "Payload":
  {
    "FeePromotionNotification":
    {
      "MerchantId": "merchantId",
      "MarketplaceId": "marketplaceId1",
      "FeePromotionType": "Pricing",
      "FeePromotionTypeDescription": "To help you offer a lower price to customers, we are offering you a temporary referral fee discount for every sale when the total sale price (price + shipping+ gift wrap) is at or below the pricing threshold.",
      "PromotionActiveTimeRange":
      {
        "EffectiveFromDate": "2016-05-04T22:24:39.615Z",
        "EffectiveThroughDate": "2016-04-28T02:45:12.786Z"
      },
      "Identifiers": [
        {
          "IdentifierType": "ASIN",
          "IdentifierValues": [
            {
              "IdentifierValueId": "B0000000",
              "IdentifierValueFriendlyName": "1234"
            }
          ]
        }
      ],
      "PromotionInformations": [
        {
          "FeeType": "ReferralFee",
          "FeeDiscountType": "Percentage points off",
          "FeeDiscountValue": 5,
          "PriceThreshold":
          {
            "Amount": 1,
            "CurrencyCode": "USD"
          },
          "FeesEstimate":
          {
            "TimeOfFeesEstimated": "2016-05-05T22:24:39.635Z",
            "TotalFeesEstimate":
            {
              "Amount": 10,
              "CurrencyCode": "USD"
            },
            "FeeDetails": [
              {
                "FeeType": "feeType",
                "FeeAmount":
                {
                  "Amount": 1,
                  "CurrencyCode": "USD"
                },
                "FeePromotion":
                {
                  "Amount": 0.8,
                  "CurrencyCode": "USD"
                },
                "FinalFee":
                {
                  "Amount": 0.2,
                  "CurrencyCode": "USD"
                }
              }
            ]
          }
        }
      ]
    }
  }
}
```
## FBA_OUTBOUND_SHIPMENT_STATUS

The FBA_OUTBOUND_SHIPMENT_STATUS notification is sent whenever Amazon creates or cancels a Fulfillment by Amazon shipment for a seller.

### FBAOutboundShipmentStatusNotification

The following table shows the child elements of the FBAOutboundShipmentStatusNotification element:

<table>
<thead>
<tr class="header">
<th><b>Name</b></th>
<th><b>Description</b></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>AmazonOrderId</td>
<td><p>The Amazon-defined order identifier.</p>
<p>Type: string</p></td>
</tr>
<tr class="even">
<td>AmazonShipmentId</td>
<td><p>The Amazon-defined shipment identifier.</p>
<p>Type: string</p></td>
</tr>
<tr class="odd">
<td>ShipmentStatus</td>
<td><p>The shipment status. ShipmentStatus values: Created, Cancelled.</p>
<p>Type: string</p></td>
</tr>
</tbody>
</table>

**Notification schema:** [FBAOutboundShipmentStatusNotification.json](https://amazonservicesstatic.com/json-schemas/notifications/FBAOutboundShipmentStatusNotification.json)

**Notification example:**

```
{
  "NotificationVersion": "1.0",
  "NotificationType": "FBA_OUTBOUND_SHIPMENT_STATUS",
  "PayloadVersion": "1.0",
  "EventTime": "2020-01-11T00:09:53.109Z",
  "Payload":
  {
    "FBAOutboundShipmentStatusNotification":
    {
      "SellerId": "merchantId",
      "AmazonOrderId": "113-2646096-4474645",
      "AmazonShipmentId": "DrLqQwqvb",
      "ShipmentStatus": "Created"
    }
  },
  "NotificationMetadata":
  {
    "ApplicationId": "appId",
    "SubscriptionId": "subId",
    "PublishTime": "2020-01-11T00:02:50.501Z",
    "NotificationId": "requestId"
  }
}
```
## FULFILLMENT_ORDER_STATUS

The FULFILLMENT_ORDER_STATUS notification is sent whenever there is a change in the status of a Multi-Channel Fulfillment fulfillment order.

### FulfillmentOrderStatusNotification

The following table shows the child elements of the FulfillmentOrderStatusNotification element:

<table>
<thead>
<tr class="header">
<th><b>Name</b></th>
<th><b>Description</b></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>EventType</td>
<td><p>Indicates whether the notification contains order, shipment, or return information.</p>
<p>EventType values:</p>
<p>Order - This notification contains information about a fulfillment order.</p>
<p>Shipment - This notification contains information about a fulfillment shipment. For more information, see the <a href="#fulfillmentshipment">FulfillmentShipment</a> element.</p>
<p>Return - This notification contains information about a fulfillment return.</p>
<p>Required</p>
<p>Type: xs:string</p></td>
</tr>
<tr class="even">
<td>SellerId</td>
<td><p>The identifier of the seller.</p>
<p>Type: string</p></td>
</tr>
<tr class="odd">
<td>StatusUpdatedDateTime</td>
<td><p>The date and time when the status was last updated. In ISO 8601 format.</p>
<p>Required</p>
<p>Type: xs:dateTime</p></td>
</tr>
<tr class="even">
<td>SellerFulfillmentOrderId</td>
<td><p>The fulfillment order identifier that you created and submitted using the CreateFulfillmentOrder operation.</p>
<p>Required</p>
<p>Type: xs:string</p></td>
</tr>
<tr class="odd">
<td>FulfillmentOrderStatus</td>
<td><p>The current status of the fulfillment order.</p>
<p>FulfillmentOrderStatus values:</p>
<ul>
<li>
<p>Received - The fulfillment order was received and validated. Validation includes determining that the destination address is valid and that Amazon's records indicate that the seller has enough sellable (undamaged) inventory to fulfill the order. The seller can cancel a fulfillment order that has a status of Received.</p>
</li>
<li>
<p>Invalid - The fulfillment order was received but could not be validated. The reasons for this include an invalid destination address or Amazon's records indicating that the seller does not have enough sellable inventory to fulfill the order. When this happens, the fulfillment order is invalid and no items in the order will ship.</p>
</li>
<li>
<p>Planning - The fulfillment order has been sent to Amazon's fulfillment network to begin shipment planning, but no unit in any shipment has been picked from inventory yet. The seller can cancel a fulfillment order that has a status of Planning.</p>
</li>
<li>
<p>Processing - The process of picking units from inventory has begun on at least one shipment in the fulfillment order. The seller cannot cancel a fulfillment order that has a status of Processing.</p>
</li>
<li>
<p>Cancelled - The fulfillment order has been cancelled by the seller.</p>
</li>
<li>
<p>Complete - All item quantities in the fulfillment order have been fulfilled.</p>
</li>
<li>
<p>CompletePartialled - Some item quantities in the fulfillment order were fulfilled; the rest were either cancelled or unfulfillable.</p>
</li>
<li>
<p>Unfulfillable - No item quantities in the fulfillment order could be fulfilled because the Amazon fulfillment center workers found no inventory for those items or found no inventory that was in sellable (undamaged) condition.</p>
</li>
</ul>
<p>Required</p>
<p>Type: xs:string</p></td>
</tr>
<tr class="even">
<td>FulfillmentShipment</td>
<td><p>Delivery and item information for a shipment in a fulfillment order.</p>
<p>Optional. Returned only when EventType is Shipment.</p>
<p>Type: <a href="#fulfillmentshipment">FulfillmentShipment</a></p></td>
</tr>
<tr class="odd">
<td>FulfillmentReturnItem</td>
<td><p>Information about an item that was returned to an Amazon fulfillment center.</p>
<p>Optional. Returned only when EventType is Return.</p>
<p>Type: <a href="#fulfillmentreturnitem">FulfillmentReturnItem</a></p></td>
</tr>
</tbody>
</table>

### FulfillmentReturnItem

The following table shows the child elements of the FulfillmentReturnItem element:

<table>
<thead>
<tr class="header">
<th><b>Name</b></th>
<th><b>Description</b></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>ReceivedDateTime</td>
<td><p>The date and time when the returned item was received by the Amazon fulfillment center. In <a href="https://docs.developer.amazonservices.com/en_UK/dev_guide/DG_ISO8601.html">ISO 8601 date time format</a>.</p>
<p>Required</p>
<p>Type: xs:dateTime</p></td>
</tr>
<tr class="even">
<td>ReturnedQuantity</td>
<td><p>The quantity that was returned.</p>
<p>Required</p>
<p>Type: xs:int</p></td>
</tr>
<tr class="odd">
<td>SellerSKU</td>
<td><p>The seller SKU of the item.</p>
<p>Required</p>
<p>Type: xs:string</p></td>
</tr>
</tbody>
</table>

### FulfillmentShipment

The following table shows the child elements of the FulfillmentShipment element:

<table>
<thead>
<tr class="header">
<th><b>Name</b></th>
<th><b>Description</b></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>FulfillmentShipmentStatus</td>
<td><p>The current status of the shipment.</p>
<p>FulfillmentShipmentStatus values:</p>
<ul>
<li><p>Pending - The process of picking units from inventory has begun.</p></li>
<li><p>Shipped - All packages in the shipment have left the fulfillment center.</p></li>
<li><p>CancelledByFulfiller - The Amazon fulfillment center could not fulfill the shipment as planned. This might be because the inventory was not at the expected location in the fulfillment center. After cancelling the fulfillment order, Amazon immediately creates a new fulfillment shipment and again attempts to fulfill the order.</p></li>
<li><p>CancelledBySeller - The shipment was cancelled using the CancelFulfillmentOrder operation.</p></li>
</ul>
<p>Required</p>
<p>Type: string</p></td>
</tr>
<tr class="even">
<td>AmazonShipmentId</td>
<td><p>A shipment identifier assigned by Amazon.</p>
<p>Required</p>
<p>Type: string</p></td>
</tr>
<tr class="odd">
<td>EstimatedArrivalDateTime</td>
<td><p>The estimated arrival time of the shipment, in <a href="https://docs.developer.amazonservices.com/en_UK/dev_guide/DG_ISO8601.html">ISO 8601 date time format</a>. Note that this value can change over time. If a shipment includes more than one package, EstimatedArrivalDateTime applies to all of the packages in the shipment. If the shipment has been cancelled, EstimatedArrivalDateTime is not returned.</p>
<p>Required</p>
<p>Type: dateTime</p></td>
</tr>
<tr class="even">
<td>FulfillmentShipmentPackages</td>
<td><p>Contains all the packages in the fulfillment shipment.</p>
<p>Optional</p>
<p>Type: List of <a href="#_FulfillmentShipmentPackage">FulfillmentShipmentPackage</a></p></td>
</tr>
</tbody>
</table>

### FulfillmentShipmentPackage

The following table shows the child elements of the FulfillmentShipmentPackage element:

<table>
<thead>
<tr class="header">
<th><b>Name</b></th>
<th><b>Description</b></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>PackageNumber</td>
<td><p>Identifies a package within a shipment.</p>
<p>Required</p>
<p>Type: int</p></td>
</tr>
<tr class="even">
<td>CarrierCode</td>
<td><p>Identifies the carrier that will deliver the package.</p>
<p>Required</p>
<p>Type: string</p></td>
</tr>
<tr class="odd">
<td>TrackingNumber</td>
<td><p>The tracking number used to obtain tracking and delivery information.</p>
<p>Required</p>
<p>Type: string</p></td>
</tr>
</tbody>
</table>

**Notification schema:** [FulfillmentOrderStatusNotification.json](https://amazonservicesstatic.com/json-schemas/notifications/FulfillmentOrderStatusNotification.json)

**Notification example:**
```
{
  "NotificationVersion": "1.0",
  "NotificationType": "FULFILLMENT_ORDER_STATUS",
  "PayloadVersion": "1.0",
  "EventTime": "2020-01-11T00:09:53.109Z",
  "Payload":
  {
    "FulfillmentOrderStatusNotification":
    {
      "SellerId": "merchantId",
      "EventType": "Shipment",
      "StatusUpdatedDateTime": "2020-01-11T00:09:53.109Z",
      "SellerFulfillmentOrderId": "OrderId",
      "FulfillmentOrderStatus": "Complete",
      "FulfillmentShipment":
      {
        "FulfillmentShipmentStatus": "Shipped",
        "AmazonShipmentId": "DZRSmwG2N",
        "EstimatedArrivalDateTime": "2014-12-19T22:59:59Z",
        "FulfillmentShipmentPackages": [
          {
            "PackageNumber": 1,
            "CarrierCode": "HERMESIT",
            "TrackingNumber": "&0113838XXXXXX8300169397"
          }
        ]
      }
    }
  },
  "NotificationMetadata":
  {
    "ApplicationId": "amzn1.sellerapps.app.f1234566-aaec-55a6-b123-bcb752069ec5",
    "SubscriptionId": "7d78cc50-95c8-4641-add7-10af4b1fedc9",
    "PublishTime": "2020-01-11T00:02:50.501Z",
    "NotificationId": " 2012e8e5-b365-4cb1-9fd8-be9dfc6d5eaf"
  }
}
```
## ITEM_PRODUCT_TYPE_CHANGE

Amazon sends an **ITEM_PRODUCT_TYPE_CHANGE** notification whenever there is a change to the product type of any item that the selling partner has a brand relationship with. A selling partner has a brand relationship with an item, as defined in the Amazon Registered Brands program, when they are a Brand Representative or an Authorized Reseller. The selling partner is the party who authorizes an application to call the Notifications API on their behalf, for the purpose of creating and managing notification subscriptions. Amazon sends **ITEM_PRODUCT_TYPE_CHANGE** notifications for items listed in any Amazon marketplace.

**ITEM_PRODUCT_TYPE_CHANGE Payload schema: Version 1.0**

An **ITEM_PRODUCT_TYPE_CHANGE** notification with **PayloadVersion**=*1.0* includes the following objects in the **Payload** object.

| **Object**          | **Description**                             |
| ------------------- | ------------------------------------------- |
| MarketplaceId       | The marketplace that the item is listed in. |
| Asin                | The ASIN of the item.                       |
| PreviousProductType | The previous product type.                  |
| CurrentProductType  | The current product type.                   |

**Notification schema:** [ItemProductTypeChangeNotification.json](https://amazonservicesstatic.com/json-schemas/notifications/ItemProductTypeChangeNotification.json)

**Notification example:**
```
{
  "NotificationVersion":"1.0",
  "NotificationType":"ITEM_PRODUCT_TYPE_CHANGE",
  "PayloadVersion":"1.0",
  "EventTime":"2019-03-20T18:59:30.194Z",
  "Payload":{ 
    "MarketplaceId": "ATVPDKIKX0DER",
    "Asin": "B1234567",
    "PreviousProductType": "PET_HEALTH_CARE",
    "CurrentProductType": "PET_APPAREL"
  },
  "NotificationMetadata":{
    "ApplicationId":"amzn1.sellerapps.app.f1234566-aaec-55a6-b123-bcb752069ec5",
    "SubscriptionId":"93b098e1-c42-2f45-93a1-78910a6a8369",
    "PublishTime":"2019-03-20T18:59:48.768Z",
    "NotificationId":"0e999936-da2c-4f9c-9fc2-02b67bae5f49"
  }
}
```
# Common types

Contains common types that are used by all notifications that are contained in the Notification payload elements.

## AvailabilityType

Indicates whether the item is available for shipping now, or on a known or an unknown date in the future.

Type: xs:string

AvailabilityType values:

  - NOW - The item is available for shipping now.

  - FUTURE_WITHOUT_DATE - The item will be available for shipping on an unknown date in the future.

  - FUTURE_WITH_DATE - The item will be available for shipping on a known date in the future.

## FulfillmentChannelType

Indicates whether the item is fulfilled by Amazon or by the seller.

Type: string

FulfillmentChannelType values:

  - Amazon

  - Merchant

## MarketplaceType

Represents the unique identifier of a marketplace.

Type: xs:string

Restriction: \[A-Z0-9\]+

## MoneyType

Currency type and amount.

The following table shows the elements of the MoneyType element:

<table>
<thead>
<tr class="header">
<th><b>Element</b></th>
<th><b>Description</b></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>Amount</td>
<td><p>The currency amount.</p>
<p>Type: decimal</p></td>
</tr>
<tr class="even">
<td>CurrencyCode</td>
<td><p>Three-digit currency code. In <a href="https://docs.developer.amazonservices.com/en_UK/dev_guide/DG_ISO4217.html">ISO 4217 format</a> .</p>
<p>Type: string</p></td>
</tr>
</tbody>
</table>
