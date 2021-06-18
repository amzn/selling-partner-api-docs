# Product Type Definitions API Use Case Guide
API Version: 2020-09-01

# Contents

* [What is the Product Type Definitions API?](#what-is-the-product-type-definitions-api)
* [Tutorial: Search Available Product Type Definitions](#tutorial-search-available-product-type-definitions)
  * [Step 1. Search Product Type Definitions](#step-1-search-product-type-definitions)
* [Tutorial: Retrieve a Product Type Definition](#tutorial-retrieve-a-product-type-definition)
  * [Step 1. Retrieve Product Type Definition](#step-1-retrieve-product-type-definition)
  * [Step 2. Retrieve Schema Documents](#step-2-retrieve-schema-documents)
* [Frequently Asked Questions](#frequently-asked-questions)
  * [How Fresh are Amazon Product Type Definitions?](#how-fresh-are-amazon-product-type-definitions)
  * [Are All Amazon Product Types Available with the Product Type Definitions API?](#are-all-amazon-product-types-available-with-the-product-type-definitions-api)
  * [What Version of JSON Schema is Used?](#what-version-of-json-schema-is-used)
    * [How Will Future Versions of JSON Schema be Leveraged?](#how-will-future-versions-of-json-schema-be-leveraged)
  * [Do Product Type Definition JSON Schemas Include Custom Vocabulary?](#do-product-type-definition-json-schemas-include-custom-vocabulary)
    * [Am I Required to Implement Validation for Custom Vocabulary?](#am-i-required-to-implement-validation-for-custom-vocabulary)
  * [Do I Need Custom Code to Use JSON Schemas?](#do-i-need-custom-code-to-use-json-schemas)
    * [What Open-Source Libraries are Available?](#what-open-source-libraries-are-available)
    * [What Examples are Available for Validating Data with Product Type Schemas?](#what-examples-are-available-for-validating-data-with-product-type-schemas)
  * [Why is SellerId Required for Seller-Agnostic Product Type Definitions?](#why-is-sellerid-required-for-seller-agnostic-product-type-definitions)
  * [How Do I Report Issues with Amazon Product Type Definitions?](#how-do-i-report-issues-with-amazon-product-type-definitions)

# What is the Product Type Definitions API?

Using the Selling Partner API for Product Type Definitions (Product Type Definitions API), you can search and retrieve Amazon product type definitions. Amazon product type definitions describe the attribute and data requirements for items in the Amazon catalog using JSON Schema.

For more details on the JSON Schema format provided by the Product Type Definitions API, see the accompanying [Amazon Product Type Definition Meta-Schema (v1)](amazon-product-type-definition-meta-schema-v1.md) documentation.

**Key Features**

* **JSON Schemas**: The Product Type Definitions API provides JSON Schemas that describe the seller-agnostic requirements for a given Amazon product type. This includes the data format, attribute constraints (i.e. required, length, maximum, etc.), and conditionally applied attribute constraints (i.e. if batteries are included, what type of battery).

* **Compatible with Open-Source Libraries**: The JSON Schemas provided can be used with widely available open-source and commercial libraries, applications, and services to understand data requirements, create data mappings, generate user interfaces, and validate listings data before submission to Amazon.

* **Localized Presentation Details**: The JSON Schemas provided include display labels and descriptions for attributes in any supported locale for any marketplace.

**Terminology**

* **JSON Schema**: JSON Schema is a vocabulary that allows you to annotate and validate JSON documents. See [json-schema.org](https://json-schema.org) for more details.

* **Meta Schema**: Meta schemas describe the vocabulary used by JSON Schema documents. For example, Amazon product type schemas include vocabulary for `selectors` and `editable`. This vocabulary is described in a meta schema, enabling libraries and applications to understand and validate JSON data based on these extensions to the standard JSON Schema vocabulary.

* **Product Type**: An Amazon product type is a hierarchical categorization of items in the Amazon catalog. Item data requirements are tied to the associated product type of the item.

# Tutorial: Search Available Product Type Definitions

Use this tutorial to search and identify Amazon product types available in the Product Type Definitions API for a given Amazon marketplace and type of selling partner account.

**Prerequisites**

To complete this tutorial, you will need:

* Authorization from the selling partner for whom you are making calls. See the [Selling Partner API Developer Guide](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md) for more information.

* Approval for the Product Listing role in your developer profile.

* The Product Listing role selected in the App registration page for your application. 

## Step 1. Search Product Type Definitions

Call the [searchDefinitionsProductTypes](https://github.com/amzn/selling-partner-api-docs/blob/main/references/product-type-definitions-api/definitionsProductTypes_2020-09-01.md#searchdefinitionsproducttypes) operation to search product types available in the Product Type Definitions API.

**Request Parameters**

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
			<td>Comma-delimited list of Amazon marketplace identifiers.<br/><br/>See the <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md" target="_blank">Selling Partner API Developer Guide</a> for the list of Amazon marketplace identifiers.</td>
			<td>Yes</td>
		</tr>
		<tr class="odd">
			<td><code>keywords</code></td>
			<td><code>LUGGAGE</code></td>
			<td>Comma-delimited list of keywords to search available product types by name.<br/><br/>Default: When no keywords are provided, the complete list of available product types is provided.</td>
			<td>No</td>
		</tr>
	</tbody>
</table>

**Example Request**

```plain
GET https://sellingpartnerapi-na.amazon.com/definitions/2020-09-01/productTypes
	?marketplaceIds=ATVPDKIKX0DER
	&keywords=LUGGAGE
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
			<td><code>productTypes</code></td>
			<td><em>See Example Response</em></td>
			<td>List of product types that match the search request.</td>
		</tr>
		<tr class="odd">
			<td><code>name</code></td>
			<td><code>LUGGAGE</code></td>
			<td>Name of the Amazon product type.</td>
		</tr>
		<tr class="even">
			<td><code>marketplaceIds</code></td>
			<td><code>ATVPDKIKX0DER</code></td>
			<td>List of Amazon marketplace identifiers for which the product type is available (within the requested marketplace identifiers).</td>
		</tr>
	</tbody>
</table>

**Example Response**

```json
{
  "productTypes": [
    {
      "name": "LUGGAGE",
      "marketplaceIds": [
        "ATVPDKIKX0DER"
      ]
    }
  ]
}
```

# Tutorial: Retrieve a Product Type Definition

Use this tutorial to return Amazon product type definitions and related schemas from the Product Type Definitions API for a given selling partner, Amazon product type, and Amazon marketplace.

**Prerequisites**

To complete this tutorial, you will need:

* Authorization from the Selling Partner for whom you are making calls. See the [Selling Partner API Developer Guide](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md) for more information.

* Approval for the Product Listing role in your developer profile.

* The Product Listing role selected in the App registration page for your application. 

## Step 1. Retrieve Product Type Definition

Call the [getDefinitionsProductType](https://github.com/amzn/selling-partner-api-docs/blob/main/references/product-type-definitions-api/definitionsProductTypes_2020-09-01.md#getdefinitionsproducttype) operation to retrieve an Amazon product type definition from the Product Type Definitions API.

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
		<tr class="odd">
			<td><code>productType</code></td>
			<td><code>LUGGAGE</code></td>
			<td>Name of the Amazon product type.<p>Type: string</p></td>
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
			<td><code>sellerId</code></td>
			<td><code>AXXXXXXXXXXXXX</code></td>
			<td>The selling partner identifier. When provided, seller-specific requirements and values are populated within the product type definition schema, such as brand names associated with the selling partner.<p>Type: string</p></td>
			<td>No</td>
		</tr>
		<tr class="odd">
			<td><code>marketplaceIds</code></td>
			<td><code>ATVPDKIKX0DER</code></td>
			<td>Comma-delimited list of Amazon marketplace identifiers.<br/><br/>See the <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md" target="_blank">Selling Partner API Developer Guide</a> for the list of Amazon marketplace identifiers.<p>Type: < string > array(csv)</p></td>
			<td>Yes</td>
		</tr>
		<tr class="even">
			<td><code>productTypeVersion</code></td>
			<td><code>U1d1eorqMs3U=</code></td>
			<td>Version of the Amazon product type definition to retrieve. Prerelease versions of product type definitions may be retrieved with <code>RELEASE_CANDIDATE</code>. If no prerelease version is currently available, the <code>LATEST</code> live version will be provided.<br/><br/>Default: <code>LATEST</code><p>Type: string</p></td>
			<td>No</td>
		</tr>
		<tr class="odd">
			<td><code>requirements</code></td>
			<td><code>LISTING</code></td>
			<td>
				Name of the requirements set to retrieve requirements for.				<p>
					<ul>
						<li><code>LISTING</code> - Requirements inclusive of product facts and sales terms.</li>
						<li><code>LISTING_OFFER_ONLY</code> - Requirements inclusive of sales terms only.</li>
						<li><code>LISTING_PRODUCT_ONLY</code> - Requirements inclusive of product facts only.</li>
					</ul>
				</p>
				Default: <code>LISTING</code><p>Type: enum (<a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/product-type-definitions-api/definitionsProductTypes_2020-09-01.md#requirements-subgroup-2">Requirements</a>)</p>
			</td>
			<td>No</td>
		</tr>
		<tr class="even">
			<td><code>requirementsEnforced</code></td>
			<td><code>ENFORCED</code></td>
			<td>
				Identifies if the required attributes for a requirements set are enforced by the product type definition schema. Non-enforced requirements enable structural validation of individual attributes without all required attributes being present (such as for partial updates).				<p>
					<ul>
						<li><code>ENFORCED</code> - Required attributes are enforced by the schema.</li>
						<li><code>NOT_ENFORCED</code> - Required attributes are not enforced by the schema.</li>
					</ul>
				</p>
				Default: <code>ENFORCED</code><p>Type: enum (<a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/product-type-definitions-api/definitionsProductTypes_2020-09-01.md#requirementsenforced-subgroup-2">RequirementsEnforced</a>)</p>
			</td>
			<td>No</td>
		</tr>
		<tr class="odd">
			<td><code>locale</code></td>
			<td><code>en_US</code></td>
			<td>
				Locale to retrieve presentation details (labels and descriptions) for. Defaults to the primary locale of the Amazon marketplace.
				<p>Default: <code>DEFAULT</code></p><p>Type: enum (<a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/product-type-definitions-api/definitionsProductTypes_2020-09-01.md#locale">Locale</a>)</p>
			</td>
			<td>No</td>
		</tr>
	</tbody>
</table>


**Example Request**

```plain
GET https://sellingpartnerapi-na.amazon.com/definitions/2020-09-01/productTypes/LUGGAGE
	?marketplaceIds=ATVPDKIKX0DER
	&requirements=LISTING
	&locale=en_US
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
			<td><code>metaSchema</code></td>
			<td>
<pre>"metaSchema": {
  "link": {
    "resource": "https://...",
    "verb": "GET"
  },
  "checksum": "QFQDmPwMARO7vwMEyLhOtw=="
}</pre>
			</td>
			<td>Link to retrieve the <a href="amazon-product-type-definition-meta-schema-v1.md">Amazon Product Type Definition Meta-Schema</a> document (valid for 7 days).<br/><br/>Checksum provided for comparison with previously retrieved documents.<p>Type: <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/product-type-definitions-api/definitionsProductTypes_2020-09-01.md#schemalink">SchemaLink</a></p></td>
		</tr>
		<tr class="odd">
			<td><code>schema</code></td>
			<td>
<pre>"schema": {
  "link": {
    "resource": "https://...",
    "verb": "GET"
  },
  "checksum": "TBr8ubaxXrUyay9hmxUXUw=="
}</pre>
			</td>
			<td>Link to retrieve the JSON Schema document for the Amazon product type definition (valid for 7 days).<br/><br/>Checksum provided for comparison with previously retrieved documents.<p>Type: <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/product-type-definitions-api/definitionsProductTypes_2020-09-01.md#schemalink">SchemaLink</a></p></td>
		</tr>
		<tr class="even">
			<td><code>requirements</code></td>
			<td><code>LISTING</code></td>
			<td>
				Name of the requirements set the Amazon product type definition applies to.				<p>
					<ul>
						<li><code>LISTING</code> - Requirements inclusive of product facts and sales terms.</li>
						<li><code>LISTING_OFFER_ONLY</code> - Requirements inclusive of sales terms only.</li>
						<li><code>LISTING_PRODUCT_ONLY</code> - Requirements inclusive of product facts only.</li>
					</ul>
				</p>
				Default: <code>LISTING</code><p>Type: <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/product-type-definitions-api/definitionsProductTypes_2020-09-01.md#requirements-subgroup-1">enum (Requirements)</a></p>
			</td>
		</tr>
		<tr class="odd">
			<td><code>requirementsEnforced</code></td>
			<td><code>ENFORCED</code></td>
	        <td>
				Identifies if the required attributes for a requirements set are enforced by the product type definition schema. Non-enforced requirements enable structural validation of individual attributes without all required attributes being present (such as for partial updates).				<p>
					<ul>
						<li><code>ENFORCED</code> - Required attributes are enforced by the schema.</li>
						<li><code>NOT_ENFORCED</code> - Required attributes are not enforced by the schema.</li>
					</ul>
				</p>
				Default: <code>ENFORCED</code><p>Type: enum (<a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/product-type-definitions-api/definitionsProductTypes_2020-09-01.md#requirementsenforced-subgroup-1">RequirementsEnforced</a>)</p>
			</td>
		</tr>
		<tr class="even">
			<td><code>propertyGroups</code></td>
			<td>
<pre>"propertyGroups": {
  "offer": {
    "title": "Offer",
    "description": "Product Offer",
    "propertyNames": [
      "purchasable_offer"
    ]
  }
}</pre>
			</td>
			<td>Property groups define logical segmentations of properties described in the Amazon product type definition JSON Schema document. This segmentations can be used for grouping properties in user interfaces, identifying purpose, and so forth.<br/><br/>Property groups are informational only and do not impact the structure or formatting of data.<p>Type: < string, <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/product-type-definitions-api/definitionsProductTypes_2020-09-01.md#propertygroup">PropertyGroup</a> > map</p></td>
		</tr>
		<tr class="odd">
			<td><code>locale</code></td>
			<td><code>en_US</code></td>
			<td>The locale of the presentation details (labels and descriptions) provided in the Amazon product type definition JSON Schema document.<p>Type: enum (<a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/product-type-definitions-api/definitionsProductTypes_2020-09-01.md#locale">Locale</a>)</p></td>
		</tr>
		<tr class="even">
			<td><code>marketplaceIds</code></td>
			<td><code>ATVPDKIKX0DER</code></td>
			<td>Amazon marketplace identifiers for which the Amazon product type definition is applicable.<p>Type: < string > array</p></td>
		</tr>
		<tr class="odd">
			<td><code>productType</code></td>
			<td><code>LUGGAGE</code></td>
			<td>The name of the Amazon product type that this product type definition applies to.<p>Type: string</p></td>
		</tr>
		<tr class="even">
			<td><code>productTypeVersion</code></td>
			<td><code>U8L4z4Ud95N16tZlR7rsmbQ==</code></td>
			<td>Version of the Amazon product type definition.<p>Type: (<a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/product-type-definitions-api/definitionsProductTypes_2020-09-01.md#producttypeversion">ProductTypeVersion</a>)</p></td>
		</tr>
	</tbody>
</table>

**Example Response**

```json
{
  "metaSchema": {
    "link": {
      "resource": "https://...",
      "verb": "GET"
    },
    "checksum": "QFQDmPwMARO7vwMEyLhOtw=="
  },
  "schema": {
    "link": {
      "resource": "https://...",
      "verb": "GET"
    },
    "checksum": "TBr8ubaxXrUyay9hmxUXUw=="
  },
  "requirements": "LISTING",
  "requirementsEnforced": "ENFORCED",
  "propertyGroups": {
    "offer": {
      "title": "Offer",
      "description": "Product Offer",
      "propertyNames": [
        "fulfillment_channel_availability",
        "purchasable_offer",
        "condition_type",
        "condition_note",
        "list_price",
        "product_tax_code",
        "merchant_release_date",
        "merchant_shipping_group",
        "max_order_quantity",
        "gift_options",
        "main_offer_image_locator",
        "other_offer_image_locator_1",
        "other_offer_image_locator_2",
        "other_offer_image_locator_3",
        "other_offer_image_locator_4",
        "other_offer_image_locator_5"
      ]
    },
    "images": {
      "title": "Images",
      "description": "Physical imagess or URL's",
      "propertyNames": [
        "main_product_image_locator",
        "other_product_image_locator_1",
        "other_product_image_locator_2",
        "other_product_image_locator_3",
        "other_product_image_locator_4",
        "other_product_image_locator_5",
        "other_product_image_locator_6",
        "other_product_image_locator_7",
        "other_product_image_locator_8",
        "swatch_product_image_locator"
      ]
    },
    "shipping": {
      "title": "Shipping",
      "description": "Information to determine shipping and storage of your product (e.g., package dimensions, weight, volume)",
      "propertyNames": [
        "item_dimensions",
        "item_package_dimensions",
        "item_package_weight"
      ]
    },
    "variations": {
      "title": "Variations",
      "description": "Variations that product will use",
      "propertyNames": [
        "parentage_level",
        "child_parent_sku_relationship",
        "variation_theme"
      ]
    },
    "safety_and_compliance": {
      "title": "Safety & Compliance",
      "description": "Information to indicate product compliance, hazardous materials, and legal and safety warnings (e.g., lithium batteries, choking hazards, Consumer Product Safety Information Act (CPSIA))",
      "propertyNames": [
        "country_of_origin",
        "warranty_description",
        "batteries_required",
        "batteries_included",
        "battery",
        "num_batteries",
        "number_of_lithium_metal_cells",
        "number_of_lithium_ion_cells",
        "lithium_battery",
        "supplier_declared_dg_hz_regulation",
        "hazmat",
        "safety_data_sheet_url",
        "item_weight",
        "ghs",
        "supplier_declared_material_regulation",
        "california_proposition_65",
        "pesticide_marking"
      ]
    },
    "product_identity": {
      "title": "Product Identity",
      "description": "Information to uniquely identify your product (e.g., UPC, EAN, GTIN, Product Type, Brand)",
      "propertyNames": [
        "item_name",
        "brand",
        "supplier_declared_has_product_identifier_exemption",
        "externally_assigned_product_identifier",
        "merchant_suggested_asin",
        "item_type_keyword",
        "item_type_name",
        "model_number",
        "manufacturer"
      ]
    },
    "product_details": {
      "title": "Product Details",
      "description": "Information and characteristics to describe the product to support search, browse and detail page content (e.g., bullets, product features, model, style name)",
      "propertyNames": [
        "product_description",
        "bullet_point",
        "generic_keyword",
        "special_feature",
        "style",
        "department",
        "target_gender",
        "age_range_description",
        "material",
        "outer",
        "fabric_type",
        "lining_description",
        "number_of_items",
        "number_of_wheels",
        "wheel",
        "model_name",
        "color",
        "size",
        "size_map",
        "part_number",
        "compliance_media"
      ]
    }
  },
  "locale": "en_US",
  "marketplaceIds": [
    "ATVPDKIKX0DER"
  ],
  "productType": "LUGGAGE",
  "productTypeVersion": {
    "version": "U8L4z4Ud95N16tZlR7rsmbQ==",
    "latest": true,
    "releaseCandidate": false
  }
}

```

## Step 2. Retrieve Schema Documents

In the previous step, the retrieved Amazon product type definition includes details about the Amazon product type and links to retrieve the meta schema and product type schema documents. The links provided are valid for 7 days.

Schema documents can be retrieved programmatically with a standard HTTP client or manually with a web browser.

**Important Note**: The Amazon product type definition JSON Schema document references the meta schema by name. Some JSON Schema libraries attempt to resolve meta schema names online via the web, which the [Amazon Product Type Definition Meta-Schema (v1)](amazon-product-type-definition-meta-schema-v1.md) does not support. These libraries should be configured to use a downloaded copy of the meta schema instead. See the accompanying [Amazon Product Type Definition Meta-Schema (v1)](amazon-product-type-definition-meta-schema-v1.md) documentation for more details.

# Frequently Asked Questions

This documentation covers common questions and details for the Product Type Definitions API. For questions or concerns not covered by this documentation, contact Selling Partner API support or create an issue on the GitHub repository.

## How Fresh are Amazon Product Type Definitions?

Unless specifying a previous `productTypeVersion`, the Amazon product type definitions always describe the latest up-to-date Amazon catalog requirements.

## Are All Amazon Product Types Available with the Product Type Definitions API?

No.

Amazon is continually expanding support for new and existing Amazon product types in the Product Type Definitions API. For the up-to-date list of available Amazon product types, use the Product Type Definitions API.

## What Version of JSON Schema is Used?

Amazon product type definition JSON Schemas extend [JSON Schema 2019-09](https://json-schema.org/draft/2019-09/release-notes.html). See the accompanying [Amazon Product Type Definition Meta-Schema (v1)](amazon-product-type-definition-meta-schema-v1.md) documentation for more details.

### How Will Future Versions of JSON Schema be Leveraged?

As future versions of JSON Schema are adopted by the Product Type Definitions API, they will be accompanied by a new version release of the Product Type Definitions API and [Amazon Product Type Definition Meta-Schema](amazon-product-type-definition-meta-schema-v1.md).

Future versions of JSON Schema will not be adopted by existing versions of the Product Type Definitions API or [Amazon Product Type Definition Meta-Schema](amazon-product-type-definition-meta-schema-v1.md).

## Do Product Type Definition JSON Schemas Include Custom Vocabulary?

Most Amazon catalog requirements are described utilizing standard [JSON Schema 2019-09](https://json-schema.org/draft/2019-09/release-notes.html) vocabulary. However, there are a few requirements that necessitate extending JSON Schema with custom vocabulary. See the accompanying [Amazon Product Type Definition Meta-Schema (v1)](amazon-product-type-definition-meta-schema-v1.md) documentation for more details.

### Am I Required to Implement Validation for Custom Vocabulary?

No.

The [Amazon Product Type Definition Meta-Schema (v1)](amazon-product-type-definition-meta-schema-v1.md) uses custom vocabulary to fully describe Amazon catalog requirements. Validating data with custom data enables you to prevent most listings-related issues from occurring before submitting to Amazon. However, it is up-to-you to implement such validation. Without implementing this validation, submitting data to Amazon may produce listings-related issues after submission to Amazon.

## Do I Need Custom Code to Use JSON Schemas?

Yes.

The amount of custom code depends upon your application. Example scenarios:

* **Using Open-Source Library with Validation of Custom Vocabulary**: Leveraging an open-source library to handle most JSON Schema validation means custom code is necessary to retrieve schemas from the Product Type Definitions API, to implement validation of custom vocabulary, and to integrate with the open-source library.

* **Using Open-Source Library without Validation of Custom Vocabulary**: Leveraging an open-source library to handle most JSON Schema validation means custom code is necessary to retrieve schemas from the Product Type Definitions API and to integrate with the open-source library.

### What Open-Source Libraries are Available?

Dozens of open-source libraries and implementations are available to validate data, render user interfaces, and generate code. See [JSON Schema Implementations](https://json-schema.org/implementations.html) for a full list.

Amazon does not directly support or endorse any specific open-source or commercial libraries and implementations. Examples provided in this documentation are for reference only.

### What Examples are Available for Validating Data with Product Type Schemas?

The accompanying [Amazon Product Type Definition Meta-Schema (v1)](amazon-product-type-definition-meta-schema-v1.md) documentation includes example integrations with open-source libraries to validate data with custom vocabulary in .NET (C#), Java, and JavaScript (Node.js).

## How Do I Report Issues with Amazon Product Type Definitions?

For issues specific to the Product Type Definitions API, create an issue on the GitHub repository.

For issues with the content of Amazon product type definition JSON Schemas, contact Selling Partner API support.