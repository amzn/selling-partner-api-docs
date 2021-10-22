# Listings Items API Use Case Guide
API Version: 2020-09-01

# Contents

* [What is the Listings Items API?](#what-is-the-listings-items-api)
* [Tutorial: Create or Fully Update a Listing](#tutorial-create-or-fully-update-a-listing)
  * [Step 1. Submit Listings Item Put Request](#step-1-submit-listings-item-put-request)
* [Tutorial: Partially Update a Listing](#tutorial-partially-update-a-listing)
  * [Step 1. Submit Listings Item Patch Request](#step-1-submit-listings-item-patch-request)
* [Tutorial: Delete a Listing](#tutorial-delete-a-listing)
  * [Step 1. Submit Listings Item Delete Request](#step-1-submit-listings-item-delete-request)
* [Submitting Images and Other Media Attributes](#submitting-images-and-other-media-attributes)

# What is the Listings Items API?

Using the Selling Partner API for Listings Items (Listings Items API), you can create, edit, and delete Amazon listings (SKUs) for a selling partner. This includes product facts, such as item titles, and sales terms, such as price and inventory. See the [Listings Items API Reference](https://github.com/amzn/selling-partner-api-docs/blob/main/references/listings-items-api/listingsItems_2020-09-01.md) for details about Listings Items API operations and associated data types and schemas.

Listings data submitted to the Listings Items API adheres to the JSON Schema format provided by the [Selling Partner API for Product Type Definitions](https://github.com/amzn/selling-partner-api-docs/blob/main/references/product-type-definitions-api/definitionsProductTypes_2020-09-01.md). See the Product Type Definitions API documentation for details on retrieving schemas for supported Amazon product types and validating data prior to submitting to Amazon with the Listings Items API.

**Key Features**

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

* **Results and Issues**: Responses from the Listings Items API indicate whether or not the submission was accepted for processing, along with any issues preventing the submission from being accepted. Responses do not include issues that occur after accepting the submission for processing. Future releases of the Listings Items API and related push notifications will provide the ability to receive these post-acceptance issues. 

# Tutorial: Create or Fully Update a Listing

Use this tutorial to create or fully update an Amazon listing for a given selling partner and Amazon marketplace.

**Prerequisites**

To complete this tutorial, you will need:

* Authorization from the selling partner for whom you are making calls. See the [Selling Partner API Developer Guide](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md) for more information.

* Approval for the Product Listing role in your developer profile.

* The Product Listing role selected in the App registration page for your application. 

* A JSON-based listing payload adhering to the JSON Schema provided by the [Selling Partner API for Product Type Definitions](https://github.com/amzn/selling-partner-api-docs/blob/main/references/product-type-definitions-api/definitionsProductTypes_2020-09-01.md) for the given selling partner, Amazon marketplace, and Amazon product type.

## Step 1. Submit Listings Item Put Request

Call the [putListingsItem](https://github.com/amzn/selling-partner-api-docs/blob/main/references/listings-items-api/listingsItems_2020-09-01.md#putlistingsitem) operation to create or fully update a listing using the Listings Items API.

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
			<td>The request body schema for the putListingsItem operation.<p>Type: <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/listings-items-api/listingsItems_2020-09-01.md#listingsitemputrequest">ListingsItemPutRequest</a></p></td></td>
			<td>Yes</td>
		</tr>
	</tbody>
</table>

**Example Request**

```plain
PUT https://sellingpartnerapi-na.amazon.com/listings/2020-09-01/items/AXXXXXXXXXXXXX/ABC123
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
				</p><p>Type: enum(<a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/listings-items-api/listingsItems_2020-09-01.md#status">Status</a>)</p>
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
			<td>Listings item issues related to the listings item submission.<p>Type < <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/listings-items-api/listingsItems_2020-09-01.md#issue">Issue</a> > array</p></td>
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
      "attributeName": "product_description"
    }
    ...
  ]
}
</pre>

# Tutorial: Partially Update a Listing

Use this tutorial to partially update an Amazon listing for a given selling partner and Amazon marketplace using the Listings Items API.

Partial updates are submitted in the form of JSON Patch documents. See [https://tools.ietf.org/html/rfc6902](https://tools.ietf.org/html/rfc6902) for more details about JSON Patch documents. For Amazon listings, JSON Patch documents can add, replace, or delete entire attributes. Patching content within attributes is not supported.

**Prerequisites**

To complete this tutorial, you will need:

* Authorization from the selling partner for whom you are making calls. See the [Selling Partner API Developer Guide](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md) for more information.

* Approval for the Product Listing role in your developer profile.

* The Product Listing role selected in the App registration page for your application. 

* For attribute updates, JSON-based listing attribute payloads adhering to the JSON Schema provided by the [Selling Partner API for Product Type Definitions](https://github.com/amzn/selling-partner-api-docs/blob/main/references/product-type-definitions-api/definitionsProductTypes_2020-09-01.md) for the given selling partner, Amazon marketplace, Amazon product type, and attributes.

* For attribute deletes, JSON-based listing attribute payloads adhering to the JSON Schema provided by the [Selling Partner API for Product Type Definitions](https://github.com/amzn/selling-partner-api-docs/blob/main/references/product-type-definitions-api/definitionsProductTypes_2020-09-01.md) for the given selling partner, Amazon marketplace, Amazon product type, and attributes with the selector properties of the attributes to delete. Attributes cannot be deleted by name alone, the selector values identify which instance of attributes to delete.

## Step 1. Submit Listings Item Patch Request

Call the [patchListingsItem](https://github.com/amzn/selling-partner-api-docs/blob/main/references/listings-items-api/listingsItems_2020-09-01.md#patchlistingsitem) operation to partially update a listing using the Listings Items API.

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
			<td>The request body schema for the patchListingsItem operation.<p>Type: <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/listings-items-api/listingsItems_2020-09-01.md#listingsitempatchrequest">ListingsItemPatchRequest</a></p></td></td>
			<td>Yes</td>
		</tr>
	</tbody>
</table>

**Example Request**

```plain
PATCH https://sellingpartnerapi-na.amazon.com/listings/2020-09-01/items/AXXXXXXXXXXXXX/ABC123
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
				</p><p>Type: enum(<a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/listings-items-api/listingsItems_2020-09-01.md#status">Status</a>)</p>
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
			<td>Listings item issues related to the listings item submission.<p>Type < <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/listings-items-api/listingsItems_2020-09-01.md#issue">Issue</a> > array</p></td>
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

# Tutorial: Delete a Listing

Use this tutorial to delete an Amazon listing for a given selling partner and Amazon marketplace using the Listings Items API.

**Prerequisites**

To complete this tutorial, you will need:

* Authorization from the selling partner for whom you are making calls. See the [Selling Partner API Developer Guide](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md) for more information.

* Approval for the Product Listing role in your developer profile.

* The Product Listing role selected in the App registration page for your application. 

## Step 1. Submit Listings Item Delete Request

Call the [deleteListingsItem](https://github.com/amzn/selling-partner-api-docs/blob/main/references/listings-items-api/listingsItems_2020-09-01.md#deletelistingsitem) operation to delete a listing with the Listings Items API.

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
DELETE https://sellingpartnerapi-na.amazon.com/listings/2020-09-01/items/AXXXXXXXXXXXXX/ABC123
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
				</p><p>Type: enum(<a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/listings-items-api/listingsItems_2020-09-01.md#status">Status</a>)</p>
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
			<td>Listings item issues related to the listings item submission.<p>Type < <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/listings-items-api/listingsItems_2020-09-01.md#issue">Issue</a> > array</p></td>
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

# Submitting Images and Other Media Attributes

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