# Listings Restrictions API Use Case Guide
API Version: 2021-08-01

# Contents

* [What is the Listings Restrictions API?](#what-is-the-Listings-Restrictions-api)
* [Tutorial: Get listings restrictions for an item in the catalog](#tutorial-get-listings-restrictions-for-an-item-in-the-catalog)
  * [Step 1 - Get listings restrictions for an item in the Amazon catalog](#step-1---get-listings-restrictions-for-an-item-in-the-amazon-catalog)

# What is the Listings Restrictions API?
Using the Selling Partner API for Listings Restrictions (Listings Restrictions API),  you can check whether restrictions exist that prevent the creation of a listing for an item in the Amazon catalog. If an item is restricted, you may be able take additional steps to request approval to create a listing. See the [Listings Restrictions API Reference](https://github.com/amzn/selling-partner-api-docs/blob/main/references/listings-restrictions-api/listingsRestrictions_2021-08-01.md) for details about API operations and associated data types and schemas.

Use the Listings Restrictions API in conjunction with the Listings Items API. For example, you can first determine whether listings restrictions exist using the Listings Restrictions API. If no restrictions exist, you can then call the Listings Items API to create offer-only listings. See the [Listings Items API Reference](https://github.com/amzn/selling-partner-api-docs/blob/main/references/listings-items-api/listingsItems_2021-08-01.md) for more information about the Listings Items API. 

**Key Features**

* The Listings Restrictions API provides details about listings restrictions, if any, on an existing catalog item identified by ASIN.
* You can optionally filter the restrictions based on condition type.
* The Listings Restrictions API supports checking multiple marketplaces for listings restrictions in a single call.
* When approval is required, the Listings Restrictions API returns next step links so you can pursue approval to create the listing.

**Terminology**

* **ASIN**: Amazon Standard Identification Number that identifies an item in the Amazon catalog.

* **Listing**: An Amazon listing is an item that a selling partner has listed for sale on Amazon and is identified by a Stock Keeping Unit (SKU). Product facts included in Amazon listings are reconciled into Amazon catalog items, which are identified by Amazon Standard Identification Numbers (ASINs)

* **Restriction**: A restriction is a condition that prevents the creation of a listing. In some instances, the restriction is due to an approval requirement, in which case  additional steps may be available to apply for approval.

# Tutorial: Get listings restrictions for an item in the catalog

Use this tutorial to retrieve any listings restrictions for an existing item in the Amazon catalog.

**Prerequisites**

To complete this tutorial, you will need:

* Authorization from the selling partner for whom you are making calls. See the [Selling Partner API Developer Guide](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md) for more information.
* The Product Listing role assigned to your developer profile.<br>
* The Product Listing role selected in the App registration page for your application.<br>
* A basic understanding of the Selling Partner API. See the [Selling Partner API Developer Guide](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md) for more information.

## Step 1 - Get listings restrictions for an item in the Amazon catalog

Call the [getListingsRestrictions](https://github.com/amzn/selling-partner-api-docs/blob/main/references/listings-restrictions-api/listingsRestrictions_2021-08-01.md#getListingsRestrictions) operation to return any listings restrictions, passing the following parameters:

**Query Parameters**

<table width="100%">
  <thead>
    <tr class="header">
      <th>
        <b>Parameter</b>
      </th>
      <th>
        <b>Example</b>
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
  	<tr class="even">
			<td><code>asin</code></td>
			<td><code>B0000ASIN1</code></td>
			<td>The Amazon Standard Identification Number (ASIN) of the item.<p>Type: string</p></td>
			<td>Yes</td>
		</tr>
		<tr class="odd">
			<td><code>conditionType</code></td>
			<td><code>used_very_good</code></td>
			<td>The condition used to filter restrictions.<p>Type: enum(<a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/listings-restrictions-api/listingsRestrictions_2021-08-01.md#conditiontype-subgroup-1">ConditionType</a>)</p></td>
			<td>No</td>
		</tr>
		<tr class="even">
			<td><code>sellerid</code></td>
			<td><code>AXXXXXXXXXXX</code></td>
			<td>A selling partner identifier, such as a merchant account.<p>Type: string</p></td>
			<td>Yes</td>
		</tr>
		<tr class="odd">
			<td><code>marketplaceIds</code></td>
			<td><code>ATVPDKIKX0DER</code></td>
			<td>Comma-delimited list of Amazon marketplace identifiers for the request.<br/><br/>See the <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md" target="_blank">Selling Partner API Developer Guide</a> for the list of Amazon marketplace identifiers.<p>Type: < string > array(csv)</p></td>
			<td>Yes</td>
		</tr>
		<tr class="even">
			<td><code>reasonLocale</code></td>
			<td><code>en_US</code></td>
			<td>A locale for reason text localization. When not provided, the default language code of the first marketplace is used. Examples: <code>en_US</code>, <code>fr_CA</code>, <code>fr_FR</code>. Localized messages default to <code>en_US</code> when a localization is not available in the specified locale.<p>Type: string</p></td>
			<td>No</td>
		</tr>
	</tbody>
</table>

**Example Request**
```plain
https://sellingpartnerapi-na.amazon.com/listings/2021-08-01/restrictions
   ?asin=B08XXLG119
   &conditionType=
   &sellerId=AXXXXXXXXXXX
   &marketplaceIds=ATVPDKIKX0DER
```

**Response**

A successful response returns information about all of the applicable restrictions, if any. If there are no restrictions for the specified conditionType (when provided) in the specified marketplace, the list of restrictions in the response will be empty. 

When restrictions do exist for the specified conditionType (when provided) in the specified marketplace, evaluate the `reasons` array in the response to determine the reason and to identify next steps, if any. Each reason has a [reasonCode](https://github.com/amzn/selling-partner-api-docs/blob/main/references/listings-restrictions-api/listingsRestrictions_2021-08-01.md#reasoncode) indicating why the listing is restricted.

**When approval is required**

Amazon requires that selling partners obtain approval before listing certain items for sale. The approval process may include a variety of approval requirements and qualifications. If the reasonCode in the response indicates that approval is required, the selling partner may be able to apply for approval to list the item.

In this case, use the information in the links array in the response to instruct the selling partner to navigate to the URL link provided, and then to follow the instructions there to apply for approval to list.  


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
			<td><code>restrictions</code></td>
			<td>
			  <em>
			    See Example Response
			  <em>
			</td>
			<td>A list of restrictions for the specified Amazon catalog item.<p>Type: < <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/listings-restrictions-api/listingsRestrictions_2021-08-01.md#restriction">Restriction</a> > array</p></td>
		</tr>
	</tbody>
</table>

**Example Response (no restrictions)**
```json
{
  "restrictions": [
    {
    }
  ]
}
```

**Example Response (restrictions exist)**

```json
{
  "restrictions": [
    {
      "marketplaceId": "ATVPDKIKX0DER",
      "conditionType": "collectible_like_new",
      "reasons": [
        {
          "reasonCode": "APPROVAL_REQUIRED",
          "message": "You cannot list the product in this condition.",
          "links": [
            {
              "resource": "https://sellercentral.amazon.com/hz/approvalrequest/restrictions/approve?asin=B08XXLG119",
              "verb": "GET",
              "title": "Request Approval via Seller Central.",
              "type": "text/html"
            }
          ]
        }
      ]
    },
    {
      "marketplaceId": "ATVPDKIKX0DER",
      "conditionType": "new_new",
      "reasons": [
        {
          "reasonCode": "APPROVAL_REQUIRED",
          "message": "You need approval to list.",
          "links": [
            {
              "resource": "https://sellercentral.amazon.com/hz/approvalrequest/restrictions/approve?asin=B08XXLG119",
              "verb": "GET",
              "title": "Request Approval via Seller Central.",
              "type": "text/html"
            }
          ]
        }
      ]
    },
    {
      "marketplaceId": "ATVPDKIKX0DER",
      "conditionType": "used_acceptable",
      "reasons": [
        {
          "reasonCode": "APPROVAL_REQUIRED",
          "message": "You cannot list the product in this condition.",
          "links": [
            {
              "resource": "https://sellercentral.amazon.com/hz/approvalrequest/restrictions/approve?asin=B08XXLG119",
              "verb": "GET",
              "title": "Request Approval via Seller Central.",
              "type": "text/html"
            }
          ]
        }
      ]
    },
    {
      "marketplaceId": "ATVPDKIKX0DER",
      "conditionType": "used_like_new",
      "reasons": [
        {
          "reasonCode": "APPROVAL_REQUIRED",
          "message": "You cannot list the product in this condition.",
          "links": [
            {
              "resource": "https://sellercentral.amazon.com/hz/approvalrequest/restrictions/approve?asin=B08XXLG119",
              "verb": "GET",
              "title": "Request Approval via Seller Central.",
              "type": "text/html"
            }
          ]
        }
      ]
    },
    {
      "marketplaceId": "ATVPDKIKX0DER",
      "conditionType": "collectible_very_good",
      "reasons": [
        {
          "reasonCode": "APPROVAL_REQUIRED",
          "message": "You cannot list the product in this condition.",
          "links": [
            {
              "resource": "https://sellercentral.amazon.com/hz/approvalrequest/restrictions/approve?asin=B08XXLG119",
              "verb": "GET",
              "title": "Request Approval via Seller Central.",
              "type": "text/html"
            }
          ]
        }
      ]
    },
    {
      "marketplaceId": "ATVPDKIKX0DER",
      "conditionType": "used_very_good",
      "reasons": [
        {
          "reasonCode": "APPROVAL_REQUIRED",
          "message": "You cannot list the product in this condition.",
          "links": [
            {
              "resource": "https://sellercentral.amazon.com/hz/approvalrequest/restrictions/approve?asin=B08XXLG119",
              "verb": "GET",
              "title": "Request Approval via Seller Central.",
              "type": "text/html"
            }
          ]
        }
      ]
    },
    {
      "marketplaceId": "ATVPDKIKX0DER",
      "conditionType": "collectible_acceptable",
      "reasons": [
        {
          "reasonCode": "APPROVAL_REQUIRED",
          "message": "You cannot list the product in this condition.",
          "links": [
            {
              "resource": "https://sellercentral.amazon.com/hz/approvalrequest/restrictions/approve?asin=B08XXLG119",
              "verb": "GET",
              "title": "Request Approval via Seller Central.",
              "type": "text/html"
            }
          ]
        }
      ]
    },
    {
      "marketplaceId": "ATVPDKIKX0DER",
      "conditionType": "collectible_good",
      "reasons": [
        {
          "reasonCode": "APPROVAL_REQUIRED",
          "message": "You cannot list the product in this condition.",
          "links": [
            {
              "resource": "https://sellercentral.amazon.com/hz/approvalrequest/restrictions/approve?asin=B08XXLG119",
              "verb": "GET",
              "title": "Request Approval via Seller Central.",
              "type": "text/html"
            }
          ]
        }
      ]
    },
    {
      "marketplaceId": "ATVPDKIKX0DER",
      "conditionType": "used_good",
      "reasons": [
        {
          "reasonCode": "APPROVAL_REQUIRED",
          "message": "You cannot list the product in this condition.",
          "links": [
            {
              "resource": "https://sellercentral.amazon.com/hz/approvalrequest/restrictions/approve?asin=B08XXLG119",
              "verb": "GET",
              "title": "Request Approval via Seller Central.",
              "type": "text/html"
            }
          ]
        }
      ]
    },
    {
      "marketplaceId": "ATVPDKIKX0DER",
      "conditionType": "refurbished_refurbished",
      "reasons": [
        {
          "reasonCode": "APPROVAL_REQUIRED",
          "message": "You cannot list the product in this condition.",
          "links": [
            {
              "resource": "https://sellercentral.amazon.com/hz/approvalrequest/restrictions/approve?asin=B08XXLG119",
              "verb": "GET",
              "title": "Request Approval via Seller Central.",
              "type": "text/html"
            }
          ]
        }
      ]
    }
  ]
}


```

