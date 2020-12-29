# feedType values

A **feedType** value indicates to Amazon how to process a feed that you submit using the Feeds API. This page lists **feedType** values for the various feed types.

For additional information about feed types, including flat file feed templates, see the Amazon Marketplace Web Service documentation. 

Feed types fall into these categories:

- [Product and inventory feeds](#product-and-inventory-feeds)

- [Order feeds](#order-feeds)

- [Fulfillment by Amazon feeds](#fulfillment-by-amazon-feeds)

- [Business feed](#business-feed)

- [Easy Ship feed](#easy-ship-feed)

## Product and inventory feeds

<table>
<thead>
<tr class="header">
<th><strong>Feed</strong></th>
<th><strong>Description</strong></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td><p><strong>Product Feed</strong></p>
<p><strong>feedType</strong> value: POST_PRODUCT_DATA</p>
<p>XSD: <a href="https://images-na.ssl-images-amazon.com/images/G/01/rainier/help/xsd/release_4_1/Product.xsd">Product.xsd</a></p></td>
<td>
<p>Builds a record and assigns an ASIN (Amazon Standard Item Number) to a product.</p>
<p>For more information about Category XSDs, see "XSDs" in the Seller Central Help for your marketplace.</p></td>
</tr>
<tr class="even">
<td><p><strong>Inventory Feed</strong></p>
<p><strong>feedType</strong> value: POST_INVENTORY_AVAILABILITY_DATA</p>
<p>XSD: <a href="https://images-na.ssl-images-amazon.com/images/G/01/rainier/help/xsd/release_4_1/Inventory.xsd">Inventory.xsd</a></p></td>
<td><p>Updates inventory quantities (stock levels) for items.</p></td>
</tr>
<tr class="odd">
<td><p><strong>Overrides Feed</strong></p>
<p><strong>feedType</strong> value: POST_PRODUCT_OVERRIDES_DATA</p>
<p>XSD: <a href="https://images-na.ssl-images-amazon.com/images/G/01/rainier/help/xsd/release_4_1/Override.xsd">Override.xsd</a></p></td>
<td>
<p>Posts product overrides.</p></td>
</tr>
<tr class="even">
<td><p><strong>Pricing Feed</strong></p>
<p><strong>feedType</strong> value: POST_PRODUCT_PRICING_DATA</p>
<p>XSD: <a href="https://images-na.ssl-images-amazon.com/images/G/01/rainier/help/xsd/release_4_1/Price.xsd">Price.xsd</a></p></td>
<td>
<p>Assigns the current price and sale price (when applicable) for an item.</p></td>
</tr>
<tr class="odd">
<td><p><strong>Product Images Feed</strong></p>
<p><strong>feedType</strong> value: POST_PRODUCT_IMAGE_DATA</p>
<p>XSD: <a href="https://images-na.ssl-images-amazon.com/images/G/01/rainier/help/xsd/release_4_1/ProductImage.xsd">ProductImage.xsd</a></p></td>
<td>
<p>Uploads Product Images and Listing photos.</p></td>
</tr>
<tr class="even">
<td><p><strong>Relationships Feed</strong></p>
<p><strong>feedType</strong> value: POST_PRODUCT_RELATIONSHIP_DATA</p>
<p>XSD: <a href="https://images-na.ssl-images-amazon.com/images/G/01/rainier/help/xsd/release_4_1/Relationship.xsd">Relationship.xsd</a></p></td>
<td>
<p>Establishes optional relationships between items in your catalog.</p></td>
</tr>
<tr class="odd">
<td><p><strong>Flat File Inventory Loader Feed</strong></p>
<p><strong><strong>feedType</strong></strong> value: POST_FLAT_FILE_INVLOADER_DATA</p></td>
<td><p>Creates or updating listings for products already in Amazon's catalog.</p></td>
</tr>
<tr class="even">
<td><p><strong>Flat File Listings Feed</strong></p>
<p><strong>feedType</strong> value: POST_FLAT_FILE_LISTINGS_DATA</p></td>
<td><p>Creates a listing for a product not yet in Amazon's catalog.</p></td>
</tr>
<tr class="odd">
<td><p><strong>Flat File Book Loader Feed</strong></p>
<p><strong>feedType</strong> value: POST_FLAT_FILE_BOOKLOADER_DATA_</p></td>
<td><p>Uploads product data for book formats to match existing book listings or create new book listings.</p></td>
</tr>
<tr class="even">
<td><p><strong>Flat File Music Loader Feed</strong></p>
<p><strong>feedType</strong> value: POST_FLAT_FILE_CONVERGENCE_LISTINGS_DATA</p></td>
<td><p>Uploads product data for CDs, cassette tapes, vinyl albums, and other music formats.</p></td>
</tr>
<tr class="odd">
<td><p><strong>Flat File Video Loader Feed</strong></p>
<p><strong>feedType</strong> value: POST_FLAT_FILE_LISTINGS_DATA</p></td>
<td><p>Uploads product data for Videos (VHS), DVDs, HD DVDs, Blu-ray Discs, and other video formats.</p></td>
</tr>
<tr class="even">
<td><p><strong>Flat File Price and Quantity Update Feed</strong></p>
<p><strong>feedType</strong> value: POST_FLAT_FILE_PRICEANDQUANTITYONLY_UPDATE_DATA</p></td>
<td><p>Updates the price and quantity for inventory.</p></td>
</tr>
<tr class="odd">
<td><p><strong>UIEE Inventory Feed</strong></p>
<p><strong>feedType</strong> value: POST_UIEE_BOOKLOADER_DATA</p></td>
<td><p>Book sellers with data files in the Universal Information Exchange Environment (UIEE) format can use this format as an alternative to the Standard Book Loader Feed.</p></td>
</tr>
<tr class="even">
<td><p><strong>ACES 3.0 Data (Automotive Part Finder) Feed</strong></p>
<p><strong>feedType</strong> value: POST_STD_ACES_DATA</p>
<p>XSD: <a href="https://images-na.ssl-images-amazon.com/images/G/01/rainier/help/xsd/release_4_1/AutoAccessory.xsd">AutoAccessory.xsd</a></p></td>
<td>
<p>Uploads fitment data.</p></td>
</tr>
</tbody>
</table>

## Order feeds

<table>
<thead>
<tr class="header">
<th><strong>Feed</strong></th>
<th><strong>Description</strong></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td><p><strong>Order Acknowledgement Feed</strong></p>
<p><strong>feedType</strong> value: POST_ORDER_ACKNOWLEDGEMENT_DATA</p><p>XSD: <a href="https://images-na.ssl-images-amazon.com/images/G/01/rainier/help/xsd/release_4_1/OrderAcknowledgement.xsd">OrderAcknowledgement.xsd</a></p></td>
<td>
<p>Acknowledges or cancels an order.</p></td>
</tr>
<tr class="even">
<td><p><strong>Order Adjustments Feed</strong></p>
<p><strong>feedType</strong> value: POST_PAYMENT_ADJUSTMENT_DATA</p><p>XSD: <a href="https://images-na.ssl-images-amazon.com/images/G/01/rainier/help/xsd/release_4_1/OrderAdjustment.xsd">OrderAdjustment.xsd</a></p></td>
<td>
<p>Issues a refund (adjustment) for an order.</p></td>
</tr>
<tr class="odd">
<td><p><strong>Order Fulfillment Feed</strong></p>
<p><strong>feedType</strong> value: POST_ORDER_FULFILLMENT_DATA</p><p>XSD: <a href="https://images-na.ssl-images-amazon.com/images/G/01/rainier/help/xsd/release_4_1/OrderFulfillment.xsd">OrderFulfillment.xsd</a></p></td>
<td>
<p>Directs Amazon to charge the buyer, credit your seller account, and notify the buyer that the order is on the way.</p></td>
</tr>
<tr class="even">
<td><p><strong>Invoice Confirmation Feed</strong></p>
<p><strong>feedType</strong> value: POST_INVOICE_CONFIRMATION_DATA</p><p>XSD: <a href="https://images-na.ssl-images-amazon.com/images/G/28/rainier/help/xsd/InvoiceConfirmation.xsd">InvoiceConfirmation.xsd</a></p></td>
<td>
<p>The Invoice Confirmation Feed</p></td>
</tr>
<tr class="odd">
<td><p><strong>Sourcing On Demand Feed</strong> (Japan only)</p>
<p><strong>feedType</strong> value: POST_EXPECTED_SHIP_DATE_SOD</p><p>XSD: <a href="https://m.media-amazon.com/images/G/01/rainier/help/xsd/release_4_1/OrderSourcingOnDemand._CB475945388_.xsd">OrderSourcingOnDemand.xsd</a></p></td>
<td>
<p>The Sourcing On Demand Feed</p></td>
</tr>
<tr class="even">
<td><p><strong>Flat File Order Acknowledgement Feed</strong></p>
<p><strong>feedType</strong> value: POST_FLAT_FILE_ORDER_ACKNOWLEDGEMENT_DATA</p></td>
<td><p>Cancels multiple orders at the same time.</p><p><strong>Note:</strong> This feed does not acknowledge orders.</p></td>
</tr>
<tr class="odd">
<td><p><strong>Flat File Order Adjustments Feed</strong></p>
<p><strong>feedType</strong> value: POST_FLAT_FILE_PAYMENT_ADJUSTMENT_DATA</p></td>
<td><p>Makes financial adjustment to customers' orders, such as in the case of a refund.</p></td>
</tr>
<tr class="even">
<td><p><strong>Flat File Order Fulfillment Feed</strong></p>
<p><strong>feedType</strong> value: POST_FLAT_FILE_FULFILLMENT_DATA</p></td>
<td><p>Confirms shipping for multiple orders.</p></td>
</tr>
<tr class="odd">
<td><p><strong>Flat File Sourcing On Demand Feed</strong> (Japan only)</p>
<p><strong>feedType</strong> value: POST_EXPECTED_SHIP_DATE_SOD_FLAT_FILE</p></td>
<td><p>Sets the estimated ship date for Sourcing on Demand orders.</p></td>
</tr>
</tbody>
</table>

## Fulfillment by Amazon feeds

<table>
<thead>
<tr class="header">
<th><strong>Feed</strong></th>
<th><strong>Description</strong></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td><p><strong>FBA Fulfillment Order Feed</strong></p>
<p><strong>feedType</strong> value: POST_FULFILLMENT_ORDER_REQUEST_DATA</p><p>XSD: <a href="https://images-na.ssl-images-amazon.com/images/G/01/rainier/help/xsd/release_4_1/FulfillmentOrderRequest.xsd">FulfillmentOrderRequest.xsd</a></p></td>
<td>
<p>Submits FBA fulfillment orders.</p></td>
</tr>
<tr class="even">
<td><p><strong>FBA Fulfillment Order Cancellation Feed</strong></p>
<p><strong>feedType</strong> value: POST_FULFILLMENT_ORDER_CANCELLATION_REQUEST_DATA</p><p>XSD: <a href="https://images-na.ssl-images-amazon.com/images/G/01/rainier/help/xsd/release_4_1/FulfillmentOrderCancellationRequest.xsd">FulfillmentOrderCancellationRequest.xsd</a></p></td>
<td>
<p>Cancels FBA fulfillment orders.</p></td>
</tr>
<tr class="odd">
<td><p><strong>FBA Inbound Shipment Carton Information Feed</strong></p>
<p><strong>feedType</strong> value: POST_FBA_INBOUND_CARTON_CONTENTS</p><p>XSD: <a href="https://images-na.ssl-images-amazon.com/images/G/01/rainier/help/xsd/release_4_1/CartonContentsRequest.xsd">CartonContentsRequest.xsd</a></p></td>
<td>
<p>Submits carton content information for FBA inbound shipments.</p></td>
</tr>
<tr class="even">
<td><p><strong>Flat File FBA Fulfillment Order Feed</strong></p>
<p><strong>feedType</strong> value: POST_FLAT_FILE_FULFILLMENT_ORDER_REQUEST_DATA</p></td>
<td><p>Creates a Multi-Channel Fulfillment File order.</p></td>
</tr>
<tr class="odd">
<td><p><strong>Flat File FBA Fulfillment Order Cancellation Feed</strong></p>
<p><strong>feedType</strong> value: POST_FLAT_FILE_FULFILLMENT_ORDER_CANCELLATION_REQUEST_DATA</p></td>
<td><p>Cancels a Multi-Channel Fulfillment order.</p></td>
</tr>
<tr class="even">
<td><p><strong>Flat File FBA Create Inbound Shipment Plan Feed</strong></p>
<p><strong>feedType</strong> value: POST_FLAT_FILE_FBA_CREATE_INBOUND_PLAN</p></td>
<td><p>Creates a bulk shipment plan.</p></td>
</tr>
<tr class="odd">
<td><p><strong>Flat File FBA Update Inbound Shipment Plan Feed</strong></p>
<p><strong>feedType</strong> value: POST_FLAT_FILE_FBA_UPDATE_INBOUND_PLAN</p></td>
<td><p>Updates a bulk shipment plan.</p></td>
</tr>
<tr class="even">
<td><p><strong>Flat File FBA Create Removal Feed</strong></p>
<p><strong>feedType</strong> value: POST_FLAT_FILE_FBA_CREATE_REMOVAL</p></td>
<td><p>Creates a bulk removal order.</p></td>
</tr>
</tbody>
</table>

## Business feed

<table>
<thead>
<tr class="header">
<th><strong>Feed</strong></th>
<th><strong>Description</strong></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td><p><strong>Flat File Manage Quotes Feed</strong></p>
<p><strong>feedType</strong> value: RFQ_UPLOAD_FEED</p></td>
<td><p>Uploads quantity discounts in response to requests from business customers. For Amazon Business sellers only.</p>
<p>For more information, see "Manage Quotes feed files" in the Seller Central Help.</p></td>
</tr>
</tbody>
</table>

## Easy Ship feed

<table>
<thead>
<tr class="header">
<th><strong>Feed</strong></th>
<th><strong>Description</strong></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td><p><strong>Easy Ship Feed</strong></p>
<p><strong>feedType</strong> value: POST_EASYSHIP_DOCUMENTS</p></td>
<td>
<p>For getting invoices, shipping labels, and warranties for Amazon Easy Ship orders that are scheduled for pickup.</p>
<p>This functionality is available only in the India marketplace.</p></td>
</tr>
</tbody>
</table>
