# Listings Items API Use Case Guide
API Version: 2021-08-01

# Contents

* [What is the Listings Items API?](#what-is-the-listings-items-api)
* [Tutorial: Retrieve details about a listing](#tutorial-retrieve-details-about-a-listing)
  * [Step 1. Submit listings items get request](#step-1-submit-listings-item-get-request)
* [Tutorial: Create or fully update a listing](#tutorial-create-or-fully-update-a-listing)
  * [Step 1. Submit listings item put request](#step-1-submit-listings-item-put-request)
* [Tutorial: Partially update a listing](#tutorial-partially-update-a-listing)
  * [Step 1. Submit listings item patch request](#step-1-submit-listings-item-patch-request)
* [Tutorial: Delete a listing](#tutorial-delete-a-listing)
  * [Step 1. Submit listings item delete request](#step-1-submit-listings-item-delete-request)
* [Submitting images and other media attributes](#submitting-images-and-other-media-attributes)

# What is the Listings Items API?

Using the Selling Partner API for Listings Items (Listings Items API), you can create, edit, delete, and retrieve details about Amazon listings (SKUs) for a selling partner. This includes product facts, such as item titles, and sales terms, such as price and inventory. See the [Listings Items API Reference](https://github.com/amzn/selling-partner-api-docs/blob/main/references/listings-items-api/listingsItems_2021-08-01.md) for details about Listings Items API operations and associated data types and schemas.

Listings data submitted to the Listings Items API adheres to the JSON Schema format provided by the [Selling Partner API for Product Type Definitions](https://github.com/amzn/selling-partner-api-docs/blob/main/references/product-type-definitions-api/definitionsProductTypes_2020-09-01.md). See the Product Type Definitions API documentation for details on retrieving schemas for supported Amazon product types and validating data prior to submitting to Amazon with the Listings Items API.

**Key Features**

* **Retrieve Details about Listings**: The Listings Items API accepts `GET` operations to return detailed information about an existing listing. 

* **Create or Fully Update Listings**: The Listings Items API accepts `PUT` operations to create a new listing or fully replace the data for an existing listing.

* **Partially Update Listings**: The Listings Items API accepts `PATCH` operations to update one or more individual attributes for an existing listing, such as for updating price and quantity. Additionally, the Listings Items API accepts `PATCH` operations to delete one or more individual attributes for an existing listing.

* **Delete Listings**: The Listings Items API accepts `DELETE` operations to delete an existing listing.

* **Localized Issue Messages**: The Listings Items API provides localized issue messaging either in the locale specified by the calling application or the default locale of the Amazon marketplace.

* **Submission Validation**: The Listings Items API provides validation of submission data prior to accepting a submission for processing. Validation errors that prevent further processing are provided synchronously to the calling application.

**Terminology**

* **Listing**: An Amazon listing is an item that a selling partner has listed for sale on Amazon and is identified by a Stock Keeping Unit (SKU). Product facts included in Amazon listings are reconciled into Amazon catalog items, which are identified by Amazon Standard Identification Numbers (ASINs).

* **Full Update**: A full update to an Amazon listing results in full data requirements validation on the submitted data and either creates a new listing or replaces the data for an existing listing.

* **Partial Update**: A partial update to an Amazon listing results in partial data requirements validation for the attributes provided and updates one or more attributes for an existing listing.

* **Product Type**: An Amazon product type is a hierarchal categorization of items in the Amazon catalog. Item data requirements are tied to the associated product type of the item.

**Considerations**

* **1x1 Updates**: The Listings Items API accepts listings updates one at a time. For use-cases better suited to bulk uploads, the `JSON_LISTINGS_FEED` feed type may be used with the Selling Partner API for Feeds. The `JSON_LISTINGS_FEED` is the bulk equivalent of the Listings Items API, offering the same features and schemas provided by the Selling Partner API for Product Type Definitions. 

* **Fully Supported Product Types**: The Listings Items API does not yet fully support all Amazon product types. Supported Amazon product types differ by selling partner type (merchant or vendor) and by Amazon marketplace. Refer to the Selling Partner API for Product Type Definitions for the latest available Amazon product types. 

* **Partially Supported Product Types**: For Amazon product types not yet fully supported by the Listings Items API, offer-only submissions for existing ASINs and partial updates are supported by using the `PRODUCT` product type.

* **Results and Issues**: Responses from the Listings Items `putListingsItem`, `patchListingsItem` and `deleteListingsItem` operations indicate whether or not the submission was accepted for processing, along with any issues preventing the submission from being accepted. Responses do not include issues that occur after accepting the submission for processing. Responses to the Listings Items `getListingsItem` operation can include issues that occur after the submission has been processed. 

# Tutorial: Retrieve details about a listing

Use this tutorial to return detailed information about an Amazon listing for a given selling partner and Amazon marketplace. The details returned can include a number of optional data sets that provide important information about the state of the listing.  

**Important**: The new `LISTINGS_ITEM_ISSUES_CHANGE` and `LISTINGS_ITEM_STATUS_CHANGE` notifications mentioned in the following paragraphs are available only to sellers at this time.

For example, if you have subscribed to receive the `LISTINGS_ITEM_ISSUES_CHANGE` notification using the [Selling Partner API for Notifications](https://github.com/amzn/selling-partner-api-docs/blob/main/references/notifications-api/notifications.md) (Notifications API) and you receive the notification, you can call the `getListingsItem` operation of the Listings Item API to get more details. The `LISTINGS_ITEM_ISSUES_CHANGE` notification does not include the same level of detailed information about issues as does the API. To return more detailed information, call `getListingsItem` and specify `issues` in the `includedData` parameter to get the issues data set. 

Similarly, if you subscribe to the `LISTINGS_ITEM_STATUS_CHANGE` notification using the Notifications API and you receive the notification, you can call the `getListingsItem` operation to receive more detailed info. For example, if a listing ceases to be DISCOVERABLE as indicated in the notification, you may want to get the issues data set to see the reason for the search suppression.

For another example, if the `LISTINGS_ITEM_STATUS_CHANGE` notification does not indicate that the listing is buyable (i.e. Status does not include BUYABLE), a common reason could be a lack of inventory. In that case, call the `getListingsItem` operation and include `fulfillmentAvailability` in the `includedData` parameter to return the fulfillmentAvailability data set.

In general, the data sets available via the `includedData` parameter will help you better understand the status of the listing. The data sets available include summary information, contributed attributes, issues, offer information (sellers), fulfillment availability (sellers), and procurement details (vendors). 

**Prerequisites**

To complete this tutorial, you will need:

* Authorization from the selling partner for whom you are making calls. See the [Selling Partner API Developer Guide](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md) for more information.

* Approval for the Product Listing role in your developer profile.

* The Product Listing role selected in the App registration page for your application. 

## Step 1: Submit listings item get request

Call the [getListingsItem](https://github.com/amzn/selling-partner-api-docs/blob/main/references/listings-items-api/listingsItems_2021-08-01.md#getlistingsitem) operation to return details about a listings item, passing the following parameters:

**Request Parameters**

**Path Parameters**

<table width="100%">
	<thead>
		<tr class="header">
			<th><strong>Parameter</strong></th>
			<th><strong>Example</strong></th>
			<th><strong>Description</strong></th>
			<th><strong>Required</strong></th>
		</tr>
	</thead>
	<tbody>
		<tr class="even">
			<td><code>sellerId</code></td>
			<td><code>AXXXXXXXXXXXXX</code></td>
			<td>A selling partner identifier, such as a merchant account or vendor code.<p>Type: string</p></td>
			<td>Yes</td>
		</tr>
		<tr class="odd">
			<td><code>sku</code></td>
			<td><code>ABC123</code></td>
			<td>Identifier (stock keeping unit) of the listings item that is unique to the selling partner.<p>Type: string</p></td>
			<td>Yes</td>
		</tr>
	</tbody>
</table>

**Query Parameters**

<table width="100%">
	<thead>
		<tr class="header">
			<th><strong>Parameter</strong></th>
			<th><strong>Example</strong></th>
			<th><strong>Description</strong></th>
			<th><strong>Required</strong></th>
		</tr>
	</thead>
	<tbody>
		<tr class="even">
			<td><code>marketplaceIds</code></td>
			<td><code>ATVPDKIKX0DER</code></td>
			<td>Comma-delimited list of Amazon marketplace identifiers.<br/><br/>See the <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md" target="_blank">Selling Partner API Developer Guide</a> for the list of Amazon marketplace identifiers.<p>Type: < string > array(csv)</p></td>
			<td>Yes</td>
		</tr>
		<tr class="odd">
			<td><code>issueLocale</code></td>
			<td><code>en_US</code></td>
			<td>Locale for issue localization.<br/><br/>Default: When no locale is provided, the default locale of the first marketplace is used. Localization defaults to <code>en_US</code> when a localized message is not available in the specified locale.<p>Type: string</p></td>
			<td>No</td>
		</tr>
		<tr class="even">
		<td><code>includedData</code></td>
		<td><code>summaries</code></td>
		<td>A comma-delimited list of data sets to include in the response. See <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/listings-items-api/listingsItems_2021-08-01.md#includeddata">IncludedData</a> in the API reference for the list of available data sets.<br/><br/>Default: summaries.<p>Type: < enum (<a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/listings-items-api/listingsItems_2021-08-01.md#includeddata">IncludedData</a>) > array(csv)</p></td>
		<td>No</td>
		</tr>
	</tbody>
</table>

**Example Request**

```plain
GET https://sellingpartnerapi-na.amazon.com/listings/2021-08-01/items/AXXXXXXXXXXXX/50-TS3D-QEPT
  ?marketplaceIds=ATVPDKIKX0DER
  &issueLocale=en_US
  &includedData=issues,attributes,summaries,offers,fulfillmentAvailability
```

**Response**

A successful response includes one or more of the following:

<table width="100%">
	<thead>
		<tr class="header">
			<th><strong>Name</strong></th>
			<th><strong>Example</strong></th>
			<th><strong>Description</strong></th>
		</tr>
	</thead>
	<tbody>
		<tr class="even">
			<td><code>sku</code></td>
			<td><code>ABC123</code></td>
			<td>Identifier (stock keeping unit) of the listings item that is unique to the selling partner.<p>Type: string</p></td>
		</tr>
		<tr class="odd">
			<td><code>summaries</code></td>
			<td><em>See Example Response</em></td>
			<td>
				Summary details of a listings item.<p>
				</p><p>Type: <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/listings-items-api/listingsItems_2021-08-01.md#itemsummaries">ItemSummaries</a></p>
			</td>
		</tr>
		<tr class="even">
			<td><code>attributes</code></td>
			<td><em>See Example Response</em></td>
			<td>JSON object containing structured listings item attribute data keyed by attribute name.<p>Type: <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/listings-items-api/listingsItems_2021-08-01.md#itemattributes">ItemAttributes</a></p></td>
		</tr>
		<tr class="odd">
			<td><code>issues</code></td>
			<td><em>See Example Response</em></td>
			<td>Issues associated with the listings item.<p>Type: <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/listings-items-api/listingsItems_2021-08-01.md#itemissues">ItemIssues</a></p></td>
		</tr>
		<tr class="even">
			<td><code>offers</code></td>
			<td><em>See Example Response</em></td>
			<td>Offer details for the listings item.<p>Type: <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/listings-items-api/listingsItems_2021-08-01.md#itemoffers">ItemOffers</a></p></td>
		</tr>
		<tr class="odd">
			<td><code>fulfillmentAvailability</code></td>
			<td><em>See Example Response</em></td>
			<td>Fulfillment availability for the listings item.<p>Type: < <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/listings-items-api/listingsItems_2021-08-01.md#fulfillmentavailability">FulfillmentAvailability</a> > array</p></td>
		</tr>
		<tr class="even">
			<td><code>procurement</code></td>
			<td><em>See Example Response</em></td>
			<td>Vendor procurement information for the listings item.<p>Type: <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/listings-items-api/listingsItems_2021-08-01.md#itemprocurement">ItemProcurement</a></p></td>
		</tr>
	</tbody>
</table>

**Example Response**

**Example response for a seller (merchant) that includes the summaries, attributes, issues, offers, and fulfillmentAvailability data sets.**

```json
{
  "sku": "50-TS3D-QEPT",
  "summaries": [
    {
      "marketplaceId": "ATVPDKIKX0DER",
      "asin": "B08YRD1CNN",
      "productType": "DRINKING_CUP",
      "conditionType": "new_new",
      "status": [
        "BUYABLE",
        "DISCOVERABLE"
      ],
      "itemName": "6 Pack Coffee Mug Set, Farielyn-X 16 Ounce Ceramic Coffee Cups, Black Large Coffee mugs, Restaurant Coffee Cups for Coffee, Tea, Cappuccino, Cocoa, Cereal, Matte Black Outside and Colorful Inside",
      "createdDate": "2021-07-14T19:57:02.327Z",
      "lastUpdatedDate": "2021-07-14T19:57:10.637Z",
      "mainImage":
      {
        "link": "https://m.media-amazon.com/images/I/41epVg7mZoS.jpg",
        "height": 500,
        "width": 500
      }
    }
  ],
  "attributes":
  {
    "condition_type": [
      {
        "value": "new_new",
        "marketplace_id": "ATVPDKIKX0DER"
      }
    ],
    "merchant_shipping_group": [
      {
        "value": "legacy-template-id",
        "marketplace_id": "ATVPDKIKX0DER"
      }
    ],
    "merchant_suggested_asin": [
      {
        "value": "B08YRD1CNN",
        "marketplace_id": "ATVPDKIKX0DER"
      }
    ],
    "purchasable_offer": [
      {
        "currency": "USD",
        "start_at":
        {
          "value": "2021-07-14T19:56:57.717Z"
        },
        "our_price": [
          {
            "schedule": [
              {
                "value_with_tax": 30.0
              }
            ]
          }
        ],
        "marketplace_id": "ATVPDKIKX0DER"
      }
    ],
    "fulfillment_availability": [
      {
        "fulfillment_channel_code": "DEFAULT",
        "quantity": 1,
        "marketplace_id": "ATVPDKIKX0DER"
      }
    ],
    "main_product_image_locator": [
      {
        "media_location": "https://media-origin-na-ssl.integ.amazon.com/images/I/xxxx1.jpg",
        "marketplace_id": "ATVPDKIKX0DER"
      }
    ],
    "other_product_image_locator_1": [
      {
        "media_location": "https://media-origin-na-ssl.integ.amazon.com/images/I/xxxxx2.jpg",
        "marketplace_id": "ATVPDKIKX0DER"
      }
    ],
    "other_product_image_locator_2": [
      {
        "media_location": "https://media-origin-na-ssl.integ.amazon.com/images/I/xxxxx3.jpg",
        "marketplace_id": "ATVPDKIKX0DER"
      }
    ]
  },
  "issues": [
    {
      "message": "Attributes tagged as relevant_attributes are incomplete. Provide values for the following attribute(s): item_weight, theme, item_dimensions, item_diameter",
      "severity": "WARNING",
      "attributeName": "item_diameter",
      "attributeNames": [
        "item_diameter",
        "item_dimensions",
        "item_weight",
        "theme"
      ]
    },
    {
      "message": "Attributes tagged as customer_returns are incomplete. Provide values for the following attribute(s): color, item_dimensions, item_weight",
      "severity": "WARNING",
      "attributeName": "color",
      "attributeNames": [
        "color",
        "item_dimensions",
        "item_weight"
      ]
    }
  ],
  "offers": [
    {
      "marketplaceId": "ATVPDKIKX0DER",
      "offerType": "B2C",
      "price":
      {
        "currency": "USD",
        "amount": "30.0"
      }
    }
  ],
  "fulfillmentAvailability": [
    {
      "fulfillmentChannelCode": "DEFAULT",
      "quantity": 1
    }
  ]
}
```
<br>

**Example request and response for a vendor that includes summaries, procurement, and issues data sets.**

**Example Request**

```plain
GET https://sellingpartnerapi-na.amazon.com/listings/2021-08-01/items/AXXXXXXXXXXXX/example-sku
  ?marketplaceIds=ATVPDKIKX0DER
  &issueLocale=en_US
  &includedData=summaries,procurement,issues
```

**Example Response**

```json
{
  "sku": "example-sku",
  "summaries": [
    {
      "marketplaceId": "ATVPDKIKX0DER",
      "asin": "B071VG5N9D",
      "productType": "LUGGAGE",
      "conditionType": "new_new",
      "status": [
        "DISCOVERABLE"
      ],
      "itemName": "Hardside Carry-On Spinner Suitcase Luggage",
      "createdDate": "2021-02-01T00:00:00Z",
      "lastUpdatedDate": "2021-03-01T00:00:00Z",
      "mainImage":
      {
        "link": "https://www.example.com/luggage.png",
        "height": 500,
        "width": 500
      }
    }
  ],
  "procurement": [
    {
      "costPrice":
      {
        "currencyCode": "USD",
        "amount": "100.00"
      }
    }
  ],
  "issues": [
    {
      "message": "Attributes tagged as relevant_attributes are incomplete. Provide values for the following attribute(s): item_weight, theme, item_dimensions, item_diameter",
      "severity": "WARNING",
      "attributeName": "item_diameter",
      "attributeNames": [
        "item_diameter",
        "item_dimensions",
        "item_weight",
        "theme"
      ]
    },
    {
      "message": "Attributes tagged as customer_returns are incomplete. Provide values for the following attribute(s): color, item_dimensions, item_weight",
      "severity": "WARNING",
      "attributeName": "color",
      "attributeNames": [
        "color",
        "item_dimensions",
        "item_weight"
      ]
    }
  ]
}

```

# Tutorial: Create or fully update a listing

Use this tutorial to create or fully update an Amazon listing for a given selling partner and Amazon marketplace.

**Prerequisites**

To complete this tutorial, you will need:

* Authorization from the selling partner for whom you are making calls. See the [Selling Partner API Developer Guide](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md) for more information.

* Approval for the Product Listing role in your developer profile.

* The Product Listing role selected in the App registration page for your application. 

* A JSON-based listing payload adhering to the JSON Schema provided by the [Selling Partner API for Product Type Definitions](https://github.com/amzn/selling-partner-api-docs/blob/main/references/product-type-definitions-api/definitionsProductTypes_2020-09-01.md) for the given selling partner, Amazon marketplace, and Amazon product type.

## Step 1. Submit listings item put request

Call the [putListingsItem](https://github.com/amzn/selling-partner-api-docs/blob/main/references/listings-items-api/listingsItems_2021-08-01.md#putlistingsitem) operation to create or fully update a listing, passing the following parameters:

**Request Parameters**

**Path Parameters**

<table width="100%">
	<thead>
		<tr class="header">
			<th><strong>Parameter</strong></th>
			<th><strong>Example</strong></th>
			<th><strong>Description</strong></th>
			<th><strong>Required</strong></th>
		</tr>
	</thead>
	<tbody>
		<tr class="even">
			<td><code>sellerId</code></td>
			<td><code>AXXXXXXXXXXXXX</code></td>
			<td>A selling partner identifier, such as a merchant account or vendor code.<p>Type: string</p></td>
			<td>Yes</td>
		</tr>
		<tr class="odd">
			<td><code>sku</code></td>
			<td><code>ABC123</code></td>
			<td>Identifier (stock keeping unit) of the listings item that is unique to the selling partner.<p>Type: string</p></td>
			<td>Yes</td>
		</tr>
	</tbody>
</table>

**Query Parameters**

<table width="100%">
	<thead>
		<tr class="header">
			<th><strong>Parameter</strong></th>
			<th><strong>Example</strong></th>
			<th><strong>Description</strong></th>
			<th><strong>Required</strong></th>
		</tr>
	</thead>
	<tbody>
		<tr class="even">
			<td><code>marketplaceIds</code></td>
			<td><code>ATVPDKIKX0DER</code></td>
			<td>Comma-delimited list of Amazon marketplace identifiers.<br/><br/>See the <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md" target="_blank">Selling Partner API Developer Guide</a> for the list of Amazon marketplace identifiers.<p>Type: < string > array(csv)</p></td>
			<td>Yes</td>
		</tr>
		<tr class="odd">
			<td><code>issueLocale</code></td>
			<td><code>en_US</code></td>
			<td>Locale for issue localization.<br/><br/>Default: When no locale is provided, the default locale of the first marketplace is used. Localization defaults to <code>en_US</code> when a localized message is not available in the specified locale.<p>Type: string</p></td>
			<td>No</td>
		</tr>
	</tbody>
</table>

**Body Parameter**

<table width="100%">
	<thead>
		<tr class="header">
			<th><strong>Parameter</strong></th>
			<th><strong>Example</strong></th>
			<th><strong>Description</strong></th>
			<th><strong>Required</strong></th>
		</tr>
	</thead>
	<tbody>
		<tr class="even">
			<td><code>body</code></td>
			<td><em>See Example Request</em></td>
			<td>The request body schema for the putListingsItem operation.<p>Type: <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/listings-items-api/listingsItems_2021-08-01.md#listingsitemputrequest">ListingsItemPutRequest</a></p></td></td>
			<td>Yes</td>
		</tr>
	</tbody>
</table>

**Example Request**

```plain
PUT https://sellingpartnerapi-na.amazon.com/listings/2021-08-01/items/AXXXXXXXXXXXXX/ABC123
	?marketplaceIds=ATVPDKIKX0DER
	&issueLocale=en_US
```

<pre>
{
  "productType": "LUGGAGE",
  "requirements": "LISTING",
  "attributes": {
    "condition_type": [
      {
        "value": "new_new",
        "marketplace_id": "ATVPDKIKX0DER"
      }
    ],
    "item_name": [
      {
        "value": "AmazonBasics 16\" Underseat Spinner Carry-On",
        "language_tag": "en_US",
        "marketplace_id": "ATVPDKIKX0DER"
      }
    ],
    ...
  }
}
</pre>

**Response**

A successful response includes the following:

<table width="100%">
	<thead>
		<tr class="header">
			<th><strong>Name</strong></th>
			<th><strong>Example</strong></th>
			<th><strong>Description</strong></th>
		</tr>
	</thead>
	<tbody>
		<tr class="even">
			<td><code>sku</code></td>
			<td><code>ABC123</code></td>
			<td>Identifier (stock keeping unit) of the listings item that is unique to the selling partner.<p>Type: string</p></td>
		</tr>
		<tr class="odd">
			<td><code>status</code></td>
			<td><code>ACCEPTED</code></td>
			<td>
				Status of the listings item submission.<p>
				</p><p>Type: enum(<a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/listings-items-api/listingsItems_2021-08-01.md#status">Status</a>)</p>
			</td>
		</tr>
		<tr class="even">
			<td><code>submissionId</code></td>
			<td><code>f1dc291475dd11eabc550242ac130003</code></td>
			<td>Unique identifier of the listings item submission.<p>Type: string</p></td>
		</tr>
		<tr class="odd">
			<td><code>issues</code></td>
			<td><em>See Example Response</em></td>
			<td>Listings item issues related to the listings item submission.<p>Type < <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/listings-items-api/listingsItems_2021-08-01.md#issue">Issue</a> > array</p></td>
		</tr>
	</tbody>
</table>


**Example Response**

<pre>
{
  "sku": "ABC123",
  "status": "INVALID",
  "submissionId": "f1dc291475dd11eabc550242ac130003",
  "issues": [
    {
      "code": "90220",
      "message": "'product_description' is required but not supplied.",
      "severity": "ERROR",
      "attributeNames": [
        "product_description"
      ]
    }
    ...
  ]
}
</pre>

# Tutorial: Partially update a listing

Use this tutorial to partially update an Amazon listing for a given selling partner and Amazon marketplace using the Listings Items API.

Partial updates are submitted in the form of JSON Patch documents. See [https://tools.ietf.org/html/rfc6902](https://tools.ietf.org/html/rfc6902) for more details about JSON Patch documents. For Amazon listings, JSON Patch documents can add, replace, or delete entire attributes. Patching content within attributes is not supported.

**Prerequisites**

To complete this tutorial, you will need:

* Authorization from the selling partner for whom you are making calls. See the [Selling Partner API Developer Guide](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md) for more information.

* Approval for the Product Listing role in your developer profile.

* The Product Listing role selected in the App registration page for your application. 

* For attribute updates, JSON-based listing attribute payloads adhering to the JSON Schema provided by the [Selling Partner API for Product Type Definitions](https://github.com/amzn/selling-partner-api-docs/blob/main/references/product-type-definitions-api/definitionsProductTypes_2020-09-01.md) for the given selling partner, Amazon marketplace, Amazon product type, and attributes.

* For attribute deletes, JSON-based listing attribute payloads adhering to the JSON Schema provided by the [Selling Partner API for Product Type Definitions](https://github.com/amzn/selling-partner-api-docs/blob/main/references/product-type-definitions-api/definitionsProductTypes_2020-09-01.md) for the given selling partner, Amazon marketplace, Amazon product type, and attributes with the selector properties of the attributes to delete. Attributes cannot be deleted by name alone, the selector values identify which instance of attributes to delete.

## Step 1. Submit listings item patch request

Call the [patchListingsItem](https://github.com/amzn/selling-partner-api-docs/blob/main/references/listings-items-api/listingsItems_2021-08-01.md#patchlistingsitem) operation to partially update a listing, passing the following parameters:

**Request Parameters**

**Path Parameters**

<table width="100%">
	<thead>
		<tr class="header">
			<th><strong>Parameter</strong></th>
			<th><strong>Example</strong></th>
			<th><strong>Description</strong></th>
			<th><strong>Required</strong></th>
		</tr>
	</thead>
	<tbody>
		<tr class="even">
			<td><code>sellerId</code></td>
			<td><code>AXXXXXXXXXXXXX</code></td>
			<td>A selling partner identifier, such as a merchant account or vendor code.<p>Type: string</p></td>
			<td>Yes</td>
		</tr>
		<tr class="odd">
			<td><code>sku</code></td>
			<td><code>ABC123</code></td>
			<td>Identifier (stock keeping unit) of the listings item that is unique to the selling partner.<p>Type: string</p></td>
			<td>Yes</td>
		</tr>
  </tbody>
</table>

**Query Parameters**

<table width="100%">
	<thead>
		<tr class="header">
			<th><strong>Parameter</strong></th>
			<th><strong>Example</strong></th>
			<th><strong>Description</strong></th>
			<th><strong>Required</strong></th>
		</tr>
	</thead>
	<tbody>
		<tr class="even">
			<td><code>marketplaceIds</code></td>
			<td><code>ATVPDKIKX0DER</code></td>
			<td>Comma-delimited list of Amazon marketplace identifiers.<br/><br/>See the <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md" target="_blank">Selling Partner API Developer Guide</a> for the list of Amazon marketplace identifiers.<p>Type: < string > array(csv)</p></td>
			<td>Yes</td>
		</tr>
		<tr class="odd">
			<td><code>issueLocale</code></td>
			<td><code>en_US</code></td>
			<td>Locale for issue localization.<br/><br/>Default: When no locale provided, the default locale of the first marketplace is used. Localization defaults to <code>en_US</code> when a localized message is not available in the specified locale.<p>Type: string</p></td>
			<td>No</td>
		</tr>
	</tbody>
</table>

**Body Parameter**

<table width="100%">
	<thead>
		<tr class="header">
			<th><strong>Parameter</strong></th>
			<th><strong>Example</strong></th>
			<th><strong>Description</strong></th>
			<th><strong>Required</strong></th>
		</tr>
	</thead>
  <tbody>
		<tr class="even">
			<td><code>body</code></td>
			<td><em>See Example Request</em></td>
			<td>The request body schema for the patchListingsItem operation.<p>Type: <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/listings-items-api/listingsItems_2021-08-01.md#listingsitempatchrequest">ListingsItemPatchRequest</a></p></td></td>
			<td>Yes</td>
		</tr>
	</tbody>
</table>

**Example Request**

```plain
PATCH https://sellingpartnerapi-na.amazon.com/listings/2021-08-01/items/AXXXXXXXXXXXXX/ABC123
	?marketplaceIds=ATVPDKIKX0DER
	&issueLocale=en_US
```

```json
{
  "productType":"LUGGAGE",
  "patches":[
    {
      "op":"replace",
      "path":"/attributes/item_name",
      "value":[
        {
          "value": "AmazonBasics 16\" Underseat Spinner Carry-On",
          "language_tag": "en_US",
          "marketplace_id": "ATVPDKIKX0DER"
        }
      ]
    },
    {
      "op":"replace",
      "path":"/attributes/purchasable_offer",
      "value":[
        {
          "marketplace_id": "ATVPDKIKX0DER",
          "currency": "USD",
          "our_price": [
            {
              "schedule": [
                {
                  "value_with_tax": 15.00
                }
              ]
            }
          ]
        }
      ]
    },
    {
      "op":"delete",
      "path":"/attributes/item_type_name",
      "value":[
        {
          "marketplace_id": "ATVPDKIKX0DER",
          "language_tag": "en_US"
        }
      ]
    }
  ]
}
```

**Response**

A successful response includes the following:

<table width="100%">
	<thead>
		<tr class="header">
			<th><strong>Name</strong></th>
			<th><strong>Example</strong></th>
			<th><strong>Description</strong></th>
		</tr>
	</thead>
	<tbody>
		<tr class="even">
			<td><code>sku</code></td>
			<td><code>ABC123</code></td>
			<td>Identifier (stock keeping unit) of the listings item that is unique to the selling partner.<p>Type: string</p></td>
		</tr>
		<tr class="odd">
			<td><code>status</code></td>
			<td><code>ACCEPTED</code></td>
			<td>
				Status of the listings item submission.<p>
				</p><p>Type: enum(<a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/listings-items-api/listingsItems_2021-08-01.md#status">Status</a>)</p>
			</td>
		</tr>
		<tr class="even">
			<td><code>submissionId</code></td>
			<td><code>f1dc291475dd11eabc550242ac130003</code></td>
			<td>Unique identifier of the listings item submission.<p>Type: string</p></td>
		</tr>
		<tr class="odd">
			<td><code>issues</code></td>
			<td><em>See Example Response</em></td>
			<td>Listings item issues related to the listings item submission.<p>Type < <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/listings-items-api/listingsItems_2021-08-01.md#issue">Issue</a> > array</p></td>
		</tr>
	</tbody>
</table>


**Example Response**

```json
{
  "sku": "ABC123",
  "status": "ACCEPTED",
  "submissionId": "f1dc291475dd11eabc550242ac130003",
  "issues": []
}
```

# Tutorial: Delete a listing

Use this tutorial to delete an Amazon listing for a given selling partner and Amazon marketplace using the Listings Items API.

**Prerequisites**

To complete this tutorial, you will need:

* Authorization from the selling partner for whom you are making calls. See the [Selling Partner API Developer Guide](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md) for more information.

* Approval for the Product Listing role in your developer profile.

* The Product Listing role selected in the App registration page for your application. 

## Step 1. Submit listings item delete request

Call the [deleteListingsItem](https://github.com/amzn/selling-partner-api-docs/blob/main/references/listings-items-api/listingsItems_2021-08-01.md#deletelistingsitem) operation to delete a listing, passing the following parameters:

**Request Parameters**

**Path Parameters**

<table width="100%">
	<thead>
		<tr class="header">
			<th><strong>Parameter</strong></th>
			<th><strong>Example</strong></th>
			<th><strong>Description</strong></th>
			<th><strong>Required</strong></th>
		</tr>
	</thead>
	<tbody>
		<tr class="even">
			<td><code>sellerId</code></td>
			<td><code>AXXXXXXXXXXXXX</code></td>
			<td>A selling partner identifier, such as a merchant account or vendor code.<p>Type: string</p></td>
			<td>Yes</td>
		</tr>
		<tr class="odd">
			<td><code>sku</code></td>
			<td><code>ABC123</code></td>
			<td>Identifier (stock keeping unit) of the listings item that is unique to the selling partner.<p>Type: string</p></td>
			<td>Yes</td>
		</tr>
  </tbody>
</table>		


**Query Parameters**    
    
<table width="100%">
	<thead>
		<tr class="header">
			<th><strong>Parameter</strong></th>
			<th><strong>Example</strong></th>
			<th><strong>Description</strong></th>
			<th><strong>Required</strong></th>
		</tr>
	</thead>
	<tbody>    
    <tr class="even">
			<td><code>marketplaceIds</code></td>
			<td><code>ATVPDKIKX0DER</code></td>
			<td>Comma-delimited list of Amazon marketplace identifiers.<br/><br/>See the <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md" target="_blank">Selling Partner API Developer Guide</a> for the list of Amazon marketplace identifiers.<p>Type: < string > array(csv)</p></td>
			<td>Yes</td>
		</tr>
		<tr class="odd">
			<td><code>issueLocale</code></td>
			<td><code>en_US</code></td>
			<td>Locale for issue localization.<br/><br/>Default: When no locale provided, the default locale of the first marketplace is used. Localization defaults to <code>en_US</code> when a localized message is not available in the specified locale.<p>Type: string</p></td>
			<td>No</td>
		</tr>
	</tbody>
</table>

**Example Request**

```plain
DELETE https://sellingpartnerapi-na.amazon.com/listings/2021-08-01/items/AXXXXXXXXXXXXX/ABC123
	?marketplaceIds=ATVPDKIKX0DER
	&issueLocale=en_US
```

**Response**

A successful response includes the following:

<table width="100%">
	<thead>
		<tr class="header">
			<th><strong>Name</strong></th>
			<th><strong>Example</strong></th>
			<th><strong>Description</strong></th>
		</tr>
	</thead>
	<tbody>
		<tr class="even">
			<td><code>sku</code></td>
			<td><code>ABC123</code></td>
			<td>Identifier (stock keeping unit) of the listings item that is unique to the selling partner.<p>Type: string</p></td>
		</tr>
		<tr class="odd">
			<td><code>status</code></td>
			<td><code>ACCEPTED</code></td>
			<td>
				Status of the listings item submission.<p>
				</p><p>Type: enum(<a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/listings-items-api/listingsItems_2021-08-01.md#status">Status</a>)</p>
			</td>
		</tr>
		<tr class="even">
			<td><code>submissionId</code></td>
			<td><code>f1dc291475dd11eabc550242ac130003</code></td>
			<td>Unique identifier of the listings item submission.<p>Type: string</p></td>
		</tr>
		<tr class="odd">
			<td><code>issues</code></td>
			<td><em>See Example Response</em></td>
			<td>Listings item issues related to the listings item submission.<p>Type < <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/listings-items-api/listingsItems_2021-08-01.md#issue">Issue</a> > array</p></td>
		</tr>
	</tbody>
</table>



**Example Response**

```json
{
  "sku": "ABC123",
  "status": "ACCEPTED",
  "submissionId": "f1dc291475dd11eabc550242ac130003",
  "issues": []
}
```

# Submitting images and other media attributes

The Listings Items API accepts product images and other media content attributes that are downloaded by Amazon from publicly accessible AWS S3 or AWS CloudFront HTTP or HTTPS URLs. Private AWS S3 content may also be downloaded from S3 URLs (e.g. `s3://bucket-name/object-name.jpg`). In order for Amazon to download from private AWS S3 URLs, the `GetObject` and `ListBucket` operations must be allowed for the `arn:aws:iam::368641386589:role/Media-Download-Role` AWS IAM Role on the AWS S3 bucket. Please note that private AWS S3 content is treated as immutable, which means that changing the content for an AWS S3 object key is not supported (i.e. new media content requires a new AWS S3 object key). This convention provides the benefit of improved processing times and avoids the cost of redundant downloads in case listing submissions are re-processed.

The following is an example AWS S3 bucket policy enabling the required operations on a bucket named `bucket-name`:
```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Sid": "",
            "Action": [
                "s3:GetObject",
                "s3:ListBucket"
            ],
            "Effect": "Allow",
            "Resource": [
                "arn:aws:s3:::bucket-name/*",
                "arn:aws:s3:::bucket-name"
            ],
            "Principal": {
                "AWS": [
                    "arn:aws:iam::368641386589:role/Media-Download-Role"
                ]
            }
        }
    ]
}
```