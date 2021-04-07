# Catalog Items Use Case Guide
API Version: 2020-12-01
# Contents
	 
* [What is the Catalog Items API?](#what-is-the-catalog-items-api)
* [Tutorial: Retrieve details for an item in the Amazon catalog](#tutorial-retrieve-details-for-an-item-in-the-amazon-catalog)
   * [Step 1: Submit catalog item GET request](#step-1-submit-catalog-item-get-request)
	 
# What is the Catalog Items API?
	 
Using the Selling Partner API for Catalog Items (Catalog Items API), you can retrieve information about items in the Amazon catalog.
	 
**Key Features**
* **Retrieve Detailed Item Information**: The Catalog Items API provides details about items in the Amazon catalog, such as summarized item details, product identifiers, sales rankings, variations, and thumbnail images. Vendors may retrieve additional vendor-specific details and brand owners of items may retrieve additional attributes and image content.
	 
**Terminology**
* **ASIN**: Amazon Standard Identification Number that identifies an item in the Amazon catalog.
* **Variation**: Every color or size for a catalog item represents a variation that is assigned a different ASIN. They are grouped together as variations of one parent ASIN.  
	 
# Tutorial: Retrieve details for an item in the Amazon catalog
	 
Use this tutorial to retrieve information about an item in the Amazon catalog for the given ASIN and marketplaces.
	 
**Prerequisites**
 
To complete this tutorial, you will need:
* Authorization from the Selling Partner for whom you are making calls. See the [Selling Partner API Developer Guide](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md) for more information.
* Approval for the Product Listing role in your developer profile.
* The Product Listing role selected in the App registration page for your application.  
	 
## Step 1: Submit catalog item GET request
	 
* Call the **getCatalogItem** operation, passing the following parameters:
	 
**Request Parameters**

**Path Parameter**	 
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
      <td>
        <code>asin</code>
      </td>
      <td>
        <code>XXXXXXXXXX</code>
      </td>
      <td>Amazon Standard Identification Number for the item of interest.</td>
      <td>Yes</td>
    </tr>
  </tbody>
</table>

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
    <tr class="odd">
      <td>
        <code>marketplaceIds</code>
      </td>
      <td>
        <code>ATVPDKIKX0DER</code>
      </td>
      <td>Comma-delimited list of Amazon marketplace identifiers.
        <br/>
        <br/>
        See the
        <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md" target="_blank">Selling Partner API Developer Guide</a>
        for the list of Amazon marketplace identifiers.
      </td>
      <td>Yes</td>
    </tr>
    <tr class="even">
      <td>
        <code>includedData</code>
      </td>
      <td>
        <code>summaries</code>
      </td>
      <td>Comma-delimited list of item details to request. If none are specified, will default to returning
        <code>summaries</code>
        data.
        <p>
          <ul>
            <li>
              <code>attributes</code>
              - Listable item attributes. Available to the brand owner of the item. Contains all listable item attributes present on the item for its particular product type.
            </li>
            <li>
              <code>identifiers</code>
              - External item identifiers such as EAN, UPC, ISBN, etc.
            </li>
            <li>
              <code>images</code>
              - Product images. Each product image will contain the name of the image variant, resolution, and a link to download the image. All requests for images will include the MAIN product image at small resolution. Requests from brand owners will additionally include other image variants at full resolution.
            </li>
            <li>
              <code>productTypes</code>
              - Item product type data. The category this product sells under in the Amazon marketplace.
            </li>
            <li>
              <code>salesRanks</code>
              - Item sales ranking data. Each sales ranking will contain the name of the category, the item's ranking, and a link to the sales ranking page on the retail website.
            </li>
            <li>
              <code>summaries</code>
              - Summary of item data. Basic attributes such as the item name, manufacturer, and brand.
            </li>
            <li>
              <code>variations</code>
              - Item variation data. Contains the list of the ASINs of the items related to this item and whether this item is a child or parent item.
            </li>
            <li>
              <code>vendorDetails</code>
              - Item vendor data. Available to vendors. Contains item replenishment, brand, and manufacturer information.
            </li>
          </ul>
        </p>
      </td>
      <td>No</td>
    </tr>
  </tbody>
</table>

**Example Request**
```plain
GET https://sellingpartnerapi-na.amazon.com/catalog/2020-12-01/items/XXXXXXXXXX
   ?marketplaceIds=ATVPDKIKX0DER
   &includedData=attributes,identifiers,images,productTypes,salesRanks,summaries,variations,vendorDetails
```

**Response**

A successful response includes the following:

<table width="100%">
  <thead>
    <tr class="header">
      <th>
        <b>Name</b>
      </th>
      <th>
        <b>Example</b>
      </th>
      <th>
        <b>Description</b>
      </th>
    </tr>
  </thead>
  <tbody>
    <tr class="even">
      <td>
        <code>asin</code>
      </td>
      <td>
        <code>XXXXXXXXXX</code>
      </td>
      <td>The requested ASIN.</td>
    </tr>
    <tr class="odd">
      <td>
        <code>attributes</code>
      </td>
      <td>
        <em>See example response</em>
      </td>
      <td>A JSON object containing detailed catalog item data. Values from multiple marketplaces are rolled up into a list under each attribute name.</td>
    </tr>
    <tr class="even">
      <td>
        <code>identifiers</code>
      </td>
      <td>
        <em>See example response</em>
      </td>
      <td>External identifiers such as UPC, EAN, etc., if applicable.</td>
    </tr>
    <tr class="odd">
      <td>
        <code>images</code>
      </td>
      <td>
        <em>See example response</em>
      </td>
      <td>Image data for the item.</td>
    </tr>
    <tr class="even">
      <td>
        <code>productTypes</code>
      </td>
      <td>
        <em>See example response</em>
      </td>
      <td>The product type category of the item within the Amazon catalog.</td>
    </tr>
    <tr class="odd">
      <td>
        <code>ranks</code>
      </td>
      <td>
        <em>See example response</em>
      </td>
      <td>The sales ranking data for the item in every category it is tracked in.</td>
    </tr>
    <tr class="even">
      <td>
        <code>summaries</code>
      </td>
      <td>
        <em>See example response</em>
      </td>
      <td>Summary of item data.</td>
    </tr>
    <tr class="odd">
      <td>
        <code>variations</code>
      </td>
      <td>
        <em>See example response</em>
      </td>
      <td>Other ASINs related to this one and whether this one is a parent ASIN or a child ASIN.</td>
    </tr>
    <tr class="even">
      <td>
        <code>vendorDetails</code>
      </td>
      <td>
        <em>See example response</em>
      </td>
      <td>Detailed vendor information for this product.</td>
    </tr>
  </tbody>
</table>

	 
**Example Response**

	 
```plain
{
  "asin": "B07N4M94X4",
  "attributes": {
    "total_hdmi_ports": [
      {
        "value": 4,
        "marketplace_id": "ATVPDKIKX0DER"
      }
    ],
    "resolution": [
      {
        "language_tag": "en_US",
        "value": "4K",
        "marketplace_id": "ATVPDKIKX0DER"
      }
    ],
    "item_weight": [
      {
        "unit": "pounds",
        "value": 107.6,
        "marketplace_id": "ATVPDKIKX0DER"
      }
    ],
    "product_subcategory": [
      {
        "value": "50400150",
        "marketplace_id": "ATVPDKIKX0DER"
      }
    ],
    "item_dimensions": [
      {
        "width": {
          "unit": "inches",
          "value": 72.4
        },
        "length": {
          "unit": "inches",
          "value": 2.4
        },
        "height": {
          "unit": "inches",
          "value": 41.4
        },
        "marketplace_id": "ATVPDKIKX0DER"
      }
    ],
    "brand": [
      {
        "language_tag": "en_US",
        "value": "Samsung Electronics",
        "marketplace_id": "ATVPDKIKX0DER"
      }
    ],
    "generic_keyword": [
      {
        "language_tag": "en_US",
        "value": "smart tv; 4k tv; roku tv ;lg tv; oled tv; 65 inch smart tv; 4k tv 65 inch; lg smart tv; nvidia shield tv 2018; tv 4k; oled tv 65; sony 4k tv; 4k smart tv; 4k hdr tv; nvidia shield tv; gaming tv; lg 65 inch 4k tv; tv 65 inch smart tv 4k; 65 inch 4k tv; sony 65 inch 4k tv; vizio 4k tv; uhd tv; uhd tv 4k",
        "marketplace_id": "ATVPDKIKX0DER"
      },
      {
        "language_tag": "en_US",
        "value": "lg oled; 65 inch smart tv; samsung qled 75 inch tv; 85 inch 4k tv; lg smart tv; 4k tv 65 inch; samsung qled 82 inch tv; 8k tv; lg oled 65; lg smart tv; qled samsung 65 inch; 80 inch tv 4k; sony 4k tv; nvidia shield tv 2018",
        "marketplace_id": "ATVPDKIKX0DER"
      },
      {
        "language_tag": "en_US",
        "value": "samsung q9fn qled 2018; vizio; lg oled; lg 4k; sony 4k; sony oled; toshiba; antenna; dvd player; outdoor tv; kitchen tv; fire tv; firetv; hdtv; hd tv; android; shield tv; gaming; deals; tv ears; roku; dvr; speakers; digital tv antenna; apple tv; android tv; frame; mount",
        "marketplace_id": "ATVPDKIKX0DER"
      },
      {
        "language_tag": "en_US",
        "value": "4k hdr tv; 70" tv; nvidia shield tv; 90 inch tv; gaming tv; 75" tv; lg 65 inch 4k tv; tv 65 inch smart tv 4k; 65 inch 4k tv; sony 65 inch 4k tv; vizio 4k tv; uhd tv; uhd tv 4k;",
        "marketplace_id": "ATVPDKIKX0DER"
      }
    ],
    "control_method": [
      {
        "value": "voice",
        "marketplace_id": "ATVPDKIKX0DER"
      }
    ],
    "item_package_dimensions": [
      {
        "length": {
          "unit": "centimeters",
          "value": 26.67
        },
        "width": {
          "unit": "centimeters",
          "value": 121.92
        },
        "height": {
          "unit": "centimeters",
          "value": 203.2
        },
        "marketplace_id": "ATVPDKIKX0DER"
      }
    ],
    "image_aspect_ratio": [
      {
        "language_tag": "en_US",
        "value": "16:9",
        "marketplace_id": "ATVPDKIKX0DER"
      }
    ],
    "part_number": [
      {
        "value": "QN82Q60RAFXZA",
        "marketplace_id": "ATVPDKIKX0DER"
      }
    ],
    "includes_remote": [
      {
        "value": true,
        "marketplace_id": "ATVPDKIKX0DER"
      }
    ],
    "item_type_name": [
      {
        "language_tag": "en_US",
        "value": "TV",
        "marketplace_id": "ATVPDKIKX0DER"
      }
    ],
    "battery": [
      {
        "cell_composition": [
          {
            "value": "alkaline"
          }
        ],
        "marketplace_id": "ATVPDKIKX0DER"
      }
    ],
    "manufacturer": [
      {
        "language_tag": "en_US",
        "value": "Samsung",
        "marketplace_id": "ATVPDKIKX0DER"
      }
    ],
    "number_of_boxes": [
      {
        "value": 1,
        "marketplace_id": "ATVPDKIKX0DER"
      }
    ],
    "total_usb_ports": [
      {
        "value": 2,
        "marketplace_id": "ATVPDKIKX0DER"
      }
    ],
    "model_number": [
      {
        "value": "QN82Q60RAFXZA",
        "marketplace_id": "ATVPDKIKX0DER"
      }
    ],
    "supplier_declared_dg_hz_regulation": [
      {
        "value": "not_applicable",
        "marketplace_id": "ATVPDKIKX0DER"
      }
    ],
    "num_batteries": [
      {
        "quantity": 2,
        "type": "aaa",
        "marketplace_id": "ATVPDKIKX0DER"
      }
    ],
    "california_proposition_65": [
      {
        "compliance_type": "on_product_combined_cancer_reproductive",
        "marketplace_id": "ATVPDKIKX0DER"
      },
      {
        "compliance_type": "chemical",
        "chemical_names": [
          "di_2_ethylhexyl_phthalate_dehp"
        ],
        "marketplace_id": "ATVPDKIKX0DER"
      }
    ],
    "display": [
      {
        "resolution_maximum": [
          {
            "unit": "pixels",
            "language_tag": "en_US",
            "value": "3840 x 2160"
          }
        ],
        "size": [
          {
            "unit": "inches",
            "value": 82
          }
        ],
        "type": [
          {
            "language_tag": "en_US",
            "value": "QLED"
          }
        ],
        "marketplace_id": "ATVPDKIKX0DER"
      }
    ],
    "item_name": [
      {
        "language_tag": "en_US",
        "value": "Samsung QN82Q60RAFXZA Flat 82-Inch QLED 4K Q60 Series (2019) Ultra HD Smart TV with HDR and Alexa Compatibility",
        "marketplace_id": "ATVPDKIKX0DER"
      }
    ],
    "list_price": [
      {
        "currency": "USD",
        "value": 3799.99,
        "marketplace_id": "ATVPDKIKX0DER"
      }
    ],
    "batteries_required": [
      {
        "value": false,
        "marketplace_id": "ATVPDKIKX0DER"
      }
    ],
    "includes_rechargable_battery": [
      {
        "value": false,
        "marketplace_id": "ATVPDKIKX0DER"
      }
    ],
    "product_site_launch_date": [
      {
        "value": "2019-03-11T08:00:01.000Z",
        "marketplace_id": "ATVPDKIKX0DER"
      }
    ],
    "product_category": [
      {
        "value": "50400100",
        "marketplace_id": "ATVPDKIKX0DER"
      }
    ],
    "batteries_included": [
      {
        "value": false,
        "marketplace_id": "ATVPDKIKX0DER"
      }
    ],
    "connectivity_technology": [
      {
        "language_tag": "en_US",
        "value": "Bluetooth",
        "marketplace_id": "ATVPDKIKX0DER"
      },
      {
        "language_tag": "en_US",
        "value": "USB",
        "marketplace_id": "ATVPDKIKX0DER"
      },
      {
        "language_tag": "en_US",
        "value": "Wireless",
        "marketplace_id": "ATVPDKIKX0DER"
      },
      {
        "language_tag": "en_US",
        "value": "HDMI",
        "marketplace_id": "ATVPDKIKX0DER"
      }
    ],
    "included_components": [
      {
        "language_tag": "en_US",
        "value": "QLED Standard Smart Remote",
        "marketplace_id": "ATVPDKIKX0DER"
      },
      {
        "language_tag": "en_US",
        "value": "Power Cable",
        "marketplace_id": "ATVPDKIKX0DER"
      },
      {
        "language_tag": "en_US",
        "value": "Stand",
        "marketplace_id": "ATVPDKIKX0DER"
      },
      {
        "language_tag": "en_US",
        "value": "Samsung Smart Control",
        "marketplace_id": "ATVPDKIKX0DER"
      }
    ],
    "specification_met": [
      {
        "language_tag": "en_US",
        "value": "",
        "marketplace_id": "ATVPDKIKX0DER"
      }
    ],
    "cpsia_cautionary_statement": [
      {
        "value": "no_warning_applicable",
        "marketplace_id": "ATVPDKIKX0DER"
      }
    ],
    "item_type_keyword": [
      {
        "value": "qled-televisions",
        "marketplace_id": "ATVPDKIKX0DER"
      }
    ],
    "number_of_items": [
      {
        "value": 1,
        "marketplace_id": "ATVPDKIKX0DER"
      }
    ],
    "warranty_description": [
      {
        "language_tag": "en_US",
        "value": "1 year manufacturer",
        "marketplace_id": "ATVPDKIKX0DER"
      }
    ],
    "max_resolution": [
      {
        "unit": "pixels",
        "value": 8.3,
        "marketplace_id": "ATVPDKIKX0DER"
      }
    ],
    "item_package_weight": [
      {
        "unit": "kilograms",
        "value": 62.142,
        "marketplace_id": "ATVPDKIKX0DER"
      }
    ],
    "supported_internet_services": [
      {
        "language_tag": "en_US",
        "value": "Amazon Instant Video",
        "marketplace_id": "ATVPDKIKX0DER"
      },
      {
        "language_tag": "en_US",
        "value": "YouTube",
        "marketplace_id": "ATVPDKIKX0DER"
      },
      {
        "language_tag": "en_US",
        "value": "Netflix",
        "marketplace_id": "ATVPDKIKX0DER"
      },
      {
        "language_tag": "en_US",
        "value": "Hulu",
        "marketplace_id": "ATVPDKIKX0DER"
      },
      {
        "language_tag": "en_US",
        "value": "Browser",
        "marketplace_id": "ATVPDKIKX0DER"
      }
    ],
    "tuner_technology": [
      {
        "language_tag": "en_US",
        "value": "Analog Tuner",
        "marketplace_id": "ATVPDKIKX0DER"
      }
    ],
    "wireless_communication_technology": [
      {
        "language_tag": "en_US",
        "value": "Wi-Fi::Wi-Fi Direct::Bluetooth",
        "marketplace_id": "ATVPDKIKX0DER"
      }
    ],
    "model_year": [
      {
        "value": 2019,
        "marketplace_id": "ATVPDKIKX0DER"
      }
    ],
    "power_source_type": [
      {
        "language_tag": "en_US",
        "value": "Corded Electric",
        "marketplace_id": "ATVPDKIKX0DER"
      }
    ],
    "street_date": [
      {
        "value": "2019-03-21T00:00:01Z",
        "marketplace_id": "ATVPDKIKX0DER"
      }
    ],
    "refresh_rate": [
      {
        "unit": "hertz",
        "language_tag": "en_US",
        "value": "120",
        "marketplace_id": "ATVPDKIKX0DER"
      }
    ]
  },
  "identifiers": [
    {
      "marketplaceId": "ATVPDKIKX0DER",
      "identifiers": [
        {
          "identifier": "0887276302195",
          "identifierType": "EAN"
        },
        {
          "identifier": "00887276302195",
          "identifierType": "GTIN"
        },
        {
          "identifier": "887276302195",
          "identifierType": "UPC"
        }
      ]
    }
  ],
  "images": [
    {
      "marketplaceId": "ATVPDKIKX0DER",
      "images": [
        {
          "variant": "MAIN",
          "link": "https://m.media-amazon.com/images/I/51DZzp3w3vL.jpg",
          "height": 333,
          "width": 500
        }
      ]
    }
  ],
  "productTypes": [
    {
      "marketplaceId": "ATVPDKIKX0DER",
      "productType": "TELEVISION"
    }
  ],
  "ranks": [
    {
      "marketplaceId": "ATVPDKIKX0DER",
      "ranks": [
        {
          "title": "Electronics",
          "link": "http://www.amazon.com/gp/bestsellers/electronics",
          "value": 61667
        },
        {
          "title": "QLED TVs",
          "link": "http://www.amazon.com/gp/bestsellers/electronics/21489946011",
          "value": 84
        }
      ]
    }
  ],
  "summaries": [
    {
      "marketplaceId": "ATVPDKIKX0DER",
      "brandName": "Samsung Electronics",
      "colorName": "Black",
      "itemName": "Samsung QN82Q60RAFXZA Flat 82-Inch QLED 4K Q60 Series (2019) Ultra HD Smart TV with HDR and Alexa Compatibility",
      "manufacturer": "Samsung",
      "modelNumber": "QN82Q60RAFXZA",
      "sizeName": "82-Inch",
      "styleName": "TV only"
    }
  ],
  "variations": [
    {
      "marketplaceId": "ATVPDKIKX0DER",
      "asins": [
        "B08J7TQ9FL"
      ],
      "variationType": "CHILD"
    }
  ],
  "vendorDetails": [
    {
      "marketplaceId": "ATVPDKIKX0DER",
      "brandCode": "SAMF9",
      "categoryCode": "50400100",
      "manufacturerCode": "SAMF9",
      "manufacturerCodeParent": "SAMF9",
      "productGroup": "Home Entertainment",
      "replenishmentCategory": "OBSOLETE",
      "subcategoryCode": "50400150"
    }
  ]
}
```