# reportType values

Use a **reportType** value to specify the type of report that you want to request using the Reports API.

In the report descriptions, "Seller Central" refers to sellers who have registered to sell on Amazon in the past few years; "Marketplace" refers to legacy sellers who registered to sell on Amazon prior to the last few years. Some reports are only available for Marketplace or Seller Central sellers.

For additional information about reports, see the Seller Central Help.

Report types fall into these categories:

- [Inventory reports](#inventory-reports)

- [Order reports](#order-reports)

- [Order tracking reports](#order-tracking-reports)

- [Pending order reports](#pending-order-reports)

- [Returns reports](#returns-reports)

- [Performance reports](#performance-reports)

- [Settlement reports](#settlement-reports)

- [Fulfillment by Amazon (FBA) reports](#fulfillment-by-amazon-fba-reports)

- [Tax reports](#tax-reports)

- [Browse tree report](#browse-tree-report)

- [Easy ship reports](#easy-ship-reports)

- [Amazon business reports](#amazon-business-reports)

- [Amazon pay report](#amazon-pay-report)

## Inventory reports

<table>
<thead>
<tr class="header">
<th><strong>Name</strong></th>
<th><strong>Description</strong></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td><p><strong>Inventory Report</strong></p>
<p><strong>reportType</strong> value: GET_FLAT_FILE_OPEN_LISTINGS_DATA</p>
</td>
<td><p>Tab-delimited flat file open listings report that contains a summary of the seller's product listings with the price and quantity for each SKU. For Marketplace and Seller Central sellers.</p>
<p>This report accepts the following reportOptions values:</p>
<ul>
<li><p><strong>Custom</strong> - A Boolean value that indicates whether a custom report is returned. Default: <code>false</code>. URL-encoded example: <code>ReportOptions=custom%3Dtrue</code>.</p></li>
</ul>
<p>Can be requested.</p>
</td>
</tr>
<tr class="even">
<td><p><strong>All Listings Report</strong></p>
<p><strong>reportType</strong> value: GET_MERCHANT_LISTINGS_ALL_DATA</p></td>
<td>Tab-delimited flat file detailed all listings report. For Marketplace and Seller Central sellers.
<p>This report accepts the following reportOptions values:</p>
<ul>
<li><p><strong>Custom</strong> - A Boolean value that indicates whether a custom report is returned. Default: <code>false</code>. URL-encoded example: <code>ReportOptions=custom%3Dtrue</code>.</p></li>
</ul>
<p>Can be requested.</p></td>
</tr>
<tr class="odd">
<td><p><strong>Active Listings Report</strong></p>
<p><strong>reportType</strong> value: GET_MERCHANT_LISTINGS_DATA</p>
</td>
<td>Tab-delimited flat file detailed active listings report. For Marketplace and Seller Central sellers.
<p>Can be requested.</p></td>
</tr>
<tr class="even">
<td><p><strong>Inactive Listings Report</strong></p>
<p><strong>reportType</strong> value: GET_MERCHANT_LISTINGS_INACTIVE_DATA</p>
</td>
<td>Tab-delimited flat file detailed inactive listings report. For Marketplace and Seller Central sellers.
<p>Can be requested.</p></td>
</tr>
<tr class="odd">
<td><p><strong>Open Listings Report</strong></p>
<p><strong>reportType</strong> value: GET_MERCHANT_LISTINGS_DATA_BACK_COMPAT</p>
</td>
<td><p>Tab-delimited flat file open listings report.</p>
<p>This report accepts the following reportOptions values:</p>
<ul>
<li><p><strong>Custom</strong> - A Boolean value that indicates whether a custom report is returned. Default: <code>false</code>. URL-encoded example: <code>ReportOptions=custom%3Dtrue</code>.</p></li>
</ul>
<p>Can be requested.</p>
</td>
</tr>
<tr class="even">
<td><p><strong>Open Listings Report Lite</strong></p>
<p><strong>reportType</strong> value: GET_MERCHANT_LISTINGS_DATA_LITE</p>
</td>
<td>Tab-delimited flat file active listings report that contains only the SKU, ASIN, Price, and Quantity fields for items that have a quantity greater than zero. For Marketplace and Seller Central sellers.
<p>Can be requested.</p></td>
</tr>
<tr class="odd">
<td><p><strong>Open Listings Report Liter</strong></p>
<p><strong>reportType</strong> value: GET_MERCHANT_LISTINGS_DATA_LITER</p>
</td>
<td>Tab-delimited flat file active listings report that contains only the SKU and Quantity fields for items that have a quantity greater than zero. For Marketplace and Seller Central sellers.
<p>Can be requested.</p></td>
</tr>
<tr class="even">
<td><p><strong>Canceled Listings Report</strong></p>
<p><strong>reportType</strong> value: GET_MERCHANT_CANCELLED_LISTINGS_DATA</p>
</td>
<td><p>Tab-delimited flat file canceled listings report. For Marketplace and Seller Central sellers.</p>
<p>This report accepts the following reportOptions values:</p>
<ul>
<li><p><strong>Custom</strong> - A Boolean value that indicates whether a custom report is returned. Default: <code>false</code>. URL-encoded example: <code>ReportOptions=custom%3Dtrue</code>.</p></li>
</ul>
<p>Can be requested.</p>
</td>
</tr>
<tr class="odd">
<td><p><strong>Listing Quality and Suppressed Listing Report</strong></p>
<p><strong>reportType</strong> value: GET_MERCHANT_LISTINGS_DEFECT_DATA</p>
</td>
<td>Tab-delimited flat file listing quality and suppressed listing report that contains listing information that is incomplete or incorrect. For Marketplace and Seller Central sellers.
<p>Can be requested.</p></td>
</tr>
<tr class="even">
<td><strong>Pan-European Eligibility: FBA ASINs</strong> <p><strong>reportType</strong> value:</p> GET_PAN_EU_OFFER_STATUS</td>
<td>Tab-delimited flat file report that contains enrollment status and eligibility information for the Pan-European FBA program for each of the seller's Amazon-fulfilled listings. This report is only available to FBA sellers in the Spain, UK, France, Germany, and Italy marketplaces. For more information, see the Seller Central Help.
<p>Can be requested.</p></td>
</tr>
<tr class="odd">
<td><strong>Pan-European Eligibility: Self-fulfilled ASINs</strong> <strong>reportType</strong> value: GET_MFN_PAN_EU_OFFER_STATUS</td>
<td><p>Tab-delimited flat file report that contains eligibility information for the Pan-European FBA Program for each of the seller's self-fulfilled listings. Self-fulfilled listings are not allowed in the Pan-European FBA program, and this report can help sellers determine whether to convert any of their self-fulfilled listings to Amazon-fulfilled listings in order to enroll them in the program. This report is only available in the Spain, UK, France, Germany, and Italy marketplaces. For more information, see the Seller Central Help.</p>
<p>Can be requested.</p></td>
</tr>
<tr class="even">
<td><p><strong>Global Expansion Opportunities Report</strong></p>
<p><strong>reportType</strong> value: GET_FLAT_FILE_GEO_OPPORTUNITIES</p>
</td>
<td>Tab-delimited flat file report that contains products that a seller lists which have a high sales potential in other Amazon marketplaces.
<p>Can be requested.</p></td>
</tr>
<tr class="odd">
<td><p><strong>Referral Fee Preview Report</strong></p>
<p><strong>reportType</strong> value: GET_REFERRAL_FEE_PREVIEW_REPORT</p>
</td>
<td><p>Tab-delimited flat file that contains the seller's open listings as well as the price and estimated referral fees for each SKU.</p>

<p><strong>Note:</strong> The information in this report may be up to 24 hours old. Please do not request a report more than once per 24 hour period.</p>
<p>Can be requested.</p></td>
</tr>
</tbody>
</table>

## Order reports

The date range that you specify when requesting an order report indicates when the orders became eligible for fulfillment (no longer in a "pending" state), not when the orders were created.

<table>
<thead>
<tr class="header">
<th><strong>Name</strong></th>
<th><strong>Description</strong></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td><p><strong>Unshipped Orders Report</strong></p>
<p><strong>reportType</strong> value: GET_FLAT_FILE_ACTIONABLE_ORDER_DATA_SHIPPING</p></td>
<td><p>Tab-delimited flat file report that contains only orders that are not confirmed as shipped. Can be requested or scheduled. For Marketplace and Seller Central sellers.</p>
<p>This report accepts the following reportOptions values:</p>
<ul>
<li><p><strong>ShowSalesChannel</strong> - A Boolean value that indicates whether an additional column is added to the report that shows
the sales channel. Default: <code>false</code>. URL-encoded example: <code>ReportOptions=ShowSalesChannel%3Dtrue</code></p></li></ul>
<p>Can be requested or scheduled.</p>
</td>
</tr>
<tr class="even">
<td><p><strong>Scheduled XML Order Report (Invoicing)</strong></p> <strong>reportType</strong> value: GET_ORDER_REPORT_DATA_INVOICING</td>
<td><p>Scheduled XML order report. For Seller Central sellers only. This report can be used to generate tax invoices in the EU region.</p>
<p>You can only schedule one GET_ORDER_REPORT_DATA_INVOICING or GET_FLAT_FILE_ORDER_REPORT_DATA_INVOICING report at a time. If you have one of these reports scheduled and you schedule a new report, the existing report will be canceled.</p>
<p>Can be scheduled.</p></td>
</tr>
<tr class="odd">
<td><p><strong>Scheduled XML Order Report (Tax)</strong></p> <strong>reportType</strong> value: GET_ORDER_REPORT_DATA_TAX</td>
<td><p>Scheduled XML order report. For Seller Central sellers only. This report is for calculating and remitting taxes in the NA region.</p>
<p>You can only schedule one GET_ORDER_REPORT_DATA_TAX or GET_FLAT_FILE_ORDER_REPORT_DATA_TAX report at a time. If you have one of these reports scheduled and you schedule a new report, the existing report will be canceled.</p>
<p>Can be scheduled.</p></td>
</tr>
<tr class="even">
<td><p><strong>Scheduled XML Order Report (Shipping)</strong></p> <strong>reportType</strong> value: GET_ORDER_REPORT_DATA_SHIPPING</td>
<td><p>Scheduled XML order report. For Seller Central sellers only. This report is for shipping seller fulfilled orders to customers.</p>
<p>You can only schedule one GET_ORDER_REPORT_DATA_SHIPPING or GET_FLAT_FILE_ORDER_REPORT_DATA_SHIPPING report at a time. If you have one of these reports scheduled and you schedule a new report, the existing report will be canceled.</p>
<p>Can be scheduled.</p></td>
</tr>
<tr class="odd">
<td><p><strong>Requested or Scheduled Flat File Order Report (Invoicing)</strong></p> <strong>reportType</strong> value: GET_FLAT_FILE_ORDER_REPORT_DATA_INVOICING</td>
<td><p>Tab-delimited flat file order report that can be requested or scheduled. This report can be used to generate tax invoices in the EU region. This report shows orders from the previous 60 days. For Marketplace and Seller Central sellers.</p>
<p>Seller Central sellers can only schedule one GET_ORDER_REPORT_DATA_INVOICING or GET_FLAT_FILE_ORDER_REPORT_DATA_INVOICING report at a time.</p>
<p>If you have one of these reports scheduled and you schedule a new report, the existing report will be canceled.</p>

<p><strong>Note:</strong> The format of this report will differ slightly depending on whether it is scheduled or requested.</p>

<p>This report accepts the following reportOptions values:</p>
<ul>
<li><p><strong>ShowSalesChannel</strong> - A Boolean value that indicates whether an additional column is added to the report that shows the sales channel. Default: <code>false</code>. URL-encoded example: <code>ReportOptions=ShowSalesChannel%3Dtrue</code></p></li>
</ul>
<p>Can be requested or scheduled.</p></td>
</tr>
<tr class="even">
<td><p><strong>Requested or Scheduled Flat File Order Report (Shipping)</strong></p>
<strong>reportType</strong> value: GET_FLAT_FILE_ORDER_REPORT_DATA_SHIPPING</td>
<td><p>Tab-delimited flat file order report that can be requested or scheduled. This report shows orders from the previous 60 days. This report can be used to ship Amazon orders. For Marketplace and Seller Central sellers.</p>
<p>Seller Central sellers can only schedule one GET_ORDER_REPORT_DATA_SHIPPING or GET_FLAT_FILE_ORDER_REPORT_DATA_SHIPPING report at a time.</p>
<p>If you have one of these reports scheduled and you schedule a new report, the existing report will be canceled.</p>

<p><strong>Note:</strong> The format of this report will differ slightly depending on whether it is scheduled or requested.</p>

<p>This report accepts the following reportOptions values:</p>
<ul>
<li><p><strong>ShowSalesChannel</strong> - A Boolean value that indicates whether an additional column is added to the report that shows the sales channel. Default: <code>false</code>. URL-encoded example: <code>ReportOptions=ShowSalesChannel%3Dtrue</code></p></li>
</ul>
<p>Can be requested or scheduled.</p></td>
</tr>
<tr class="odd">
<td><p><strong>Requested or Scheduled Flat File Order Report (Tax)</p></strong> <strong>reportType</strong> value: GET_FLAT_FILE_ORDER_REPORT_DATA_TAX</td>
<td><p>Tab-delimited flat file order report for the NA region that can be requested or scheduled. This report shows orders from the previous 60 days for NA region only. For Marketplace and Seller Central sellers.</p>
<p>Seller Central sellers can only schedule one GET_ORDER_REPORT_DATA_TAX or GET_FLAT_FILE_ORDER_REPORT_DATA_TAX report at a time.</p>
<p>If you have one of these reports scheduled and you schedule a new report, the existing report will be canceled.</p>

<p><strong>Note:</strong> The format of this report will differ slightly depending on whether it is scheduled or requested.</p>

<p>This report accepts the following reportOptions values:</p>
<ul>
<li><p><strong>ShowSalesChannel</strong> - A Boolean value that indicates whether an additional column is added to the report that shows the sales channel. Default: <code>false</code>. URL-encoded example: <code>ReportOptions=ShowSalesChannel%3Dtrue</code></p></li>
</ul>
<p>Can be requested or scheduled.</p></td>
</tr>

</tbody>
</table>

## Order tracking reports

These order tracking reports are available in North America (NA) and Europe (EU). For all sellers. These reports return all orders, regardless of fulfillment channel or shipment status. These reports are intended for order tracking, not to drive a seller's fulfillment process, as the reports do not include customer-identifying information and scheduling is not supported. Also note that for self-fulfilled orders, item price is not shown for orders in a "pending" state.

<table>
<thead>
<tr class="header">
<th><strong>Name</strong></th>
<th><strong>Description</strong></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td><p><strong>Flat File Orders By Last Update Report</strong></p>
<p><strong>reportType</strong> value:</p>
<p>GET_FLAT_FILE_ALL_ORDERS_DATA_BY_LAST_UPDATE_GENERAL</p>
</td>
<td>Tab-delimited flat file report that shows all orders updated in the specified period. For all sellers.
<p>Can be requested.</p></td>
</tr>
<tr class="even">
<td><p><strong>Flat File Orders By Order Date Report</strong></p>
<p><strong>reportType</strong> value:</p>
<p>GET_FLAT_FILE_ALL_ORDERS_DATA_BY_ORDER_DATE_GENERAL</p>
</td>
<td>Tab-delimited flat file report that shows all orders that were placed in the specified period. For all sellers.
<p>Can be requested.</p></td>
</tr>
<tr class="odd">
<td><p><strong>Flat File Archived Orders Report</strong></p>
<p><strong>reportType</strong> value:</p>
<p>GET_FLAT_FILE_ARCHIVED_ORDERS_DATA_BY_ORDER_DATE</p>
</td>
<td>Tab-delimited flat file report that shows all archived orders that were placed in the specified period. For all sellers.
<p>Can be requested.</p></td>
</tr>
<tr class="even">
<td><p><strong>XML Orders By Last Update Report</strong></p>
<p><strong>reportType</strong> value: GET_XML_ALL_ORDERS_DATA_BY_LAST_UPDATE_GENERAL</p>
</td>
<td>XML report that shows all orders updated in the specified period. For all sellers.
<p>Can be requested.</p></td>
</tr>
<tr class="odd">
<td><p><strong>XML Orders By Order Date Report</strong></p>
<p><strong>reportType</strong> value: GET_XML_ALL_ORDERS_DATA_BY_ORDER_DATE_GENERAL</p>
</td>
<td>XML report that shows all orders that were placed in the specified period. For all sellers.
<p>Can be requested.</p></td>
</tr>
</tbody>
</table>

## Pending order reports

These pending order reports are only available in the Japan marketplace.

<table>
<thead>
<tr class="header">
<th><strong>Name</strong></th>
<th><strong>Description</strong></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td><p><strong>Flat File Pending Orders Report</strong></p>
<p><strong>reportType</strong> value: GET_FLAT_FILE_PENDING_ORDERS_DATA</p></td>
<td>Tab-delimited flat file report that shows all pending orders. For all sellers.
<p>Can be requested or scheduled.</p></td>
</tr>
<tr class="even">
<td><p><strong>XML Pending Orders Report</strong></p>
<p><strong>reportType</strong> value: GET_PENDING_ORDERS_DATA</p></td>
<td>XML report that shows all pending orders. Can only be scheduled using Amazon MWS.
<p>Can be requested or scheduled.</p></td>
</tr>
<tr class="odd">
<td><p><strong>Converged Flat File Pending Orders Report</strong></p>
<p><strong>reportType</strong> value:</p>
<p>GET_CONVERGED_FLAT_FILE_PENDING_ORDERS_DATA</p></td>
<td>Flat file report that shows all pending orders. For Marketplace sellers.
<p>Can be requested or scheduled.</p></td>
</tr>
</tbody>
</table>

## Returns reports

<table>
<thead>
<tr class="header">
<th><strong>Name</strong></th>
<th><strong>Description</strong></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td><p><strong>XML Returns Report by Return Date</strong></p>
<p><strong>reportType</strong> value: GET_XML_RETURNS_DATA_BY_RETURN_DATE</p></td>
<td>XML report contains detailed returns information, including return request date, RMA ID, label details, ASIN, and return reason code. You can request up to 60 days of data in a single report.
<p>Can be requested or scheduled.</p></td>
</tr>
<tr class="even">
<td><p><strong>Flat File Returns Report by Return Date</strong></p>
<p><strong>reportType</strong> value:</p>
<p>GET_FLAT_FILE_RETURNS_DATA_BY_RETURN_DATE</p></td>
<td>Tab-delimited flat file report that contains detailed returns information, including return request date, RMA ID, label details, ASIN, and return reason code. You can request up to 60 days of data in a single report.
<p>Can be requested or scheduled.</p></td>
</tr>

<tr class="odd">
<td><p><strong>XML Prime Returns Report by Return Date</strong></p>
<p><strong>reportType</strong> value: GET_XML_MFN_PRIME_RETURNS_REPORT</p></td>
<td>XML report that contains detailed Seller Fulfilled Prime returns information, including return request date, RMA ID, label details, ASIN, and return reason code. You can request up to 60 days of data in a single report.
<p>Can be requested or scheduled.</p></td>
</tr>
<tr class="even">
<td><p><strong>CSV Prime Returns Report by Return Date</strong></p>
<p><strong>reportType</strong> value: GET_CSV_MFN_PRIME_RETURNS_REPORT</p></td>
<td>Comma-separated flat file report that contains detailed Seller Fulfilled Prime returns information, including return request date, RMA ID, label details, ASIN, and return reason code. You can request up to 60 days of data in a single report.
<p>Can be requested or scheduled.</p></td>
</tr>
<tr class="odd">
<td><p><strong>XML Return Attributes Report by Return Date</strong></p>
<p><strong>reportType</strong> value:</p>
<p>GET_XML_MFN_SKU_RETURN_ATTRIBUTES_REPORT</p></td>
<td>XML report that contains detailed return attribute information by SKU, including prepaid label eligibility and returnless refund eligibility. You can request up to 60 days of data in a single report.
<p>Can be requested or scheduled.</p></td>
</tr>
<tr class="even">
<td><p><strong>Flat File Return Attributes Report by Return Date</strong></p>
<p><strong>reportType</strong> value:</p>
<p>GET_FLAT_FILE_MFN_SKU_RETURN_ATTRIBUTES_REPORT</p></td>
<td>Tab-delimited flat file report that contains detailed return attribute information by SKU, including prepaid label eligibility and returnless refund eligibility. You can request up to 60 days of data in a single report.
<p>Can be requested or scheduled.</p></td>
</tr>
</tbody>
</table>

## Performance reports

<table>
<thead>
<tr class="header">
<th><strong>Name</strong></th>
<th><strong>Description</strong></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td><p><strong>Flat File Feedback Report</strong></p>
<p><strong>reportType</strong> value: GET_SELLER_FEEDBACK_DATA</p>
</td>
<td>Tab-delimited flat file report that contains negative and neutral feedback (one to three stars) from buyers who rated the seller's performance. For all sellers.
<p>Can be requested.</p></td>
</tr>
<tr class="even">
<td><p><strong>XML Customer Metrics Report</strong></p>
<p><strong>reportType</strong> value: GET_V1_SELLER_PERFORMANCE_REPORT</p>
</td>
<td>XML report that contains select, individual performance metrics data from the Seller Central dashboard. For all sellers.
<p>Can be requested.</p></td>
</tr>
<tr class="odd">
<td><p><strong>Seller Performance Report</strong></p>
<p><strong>reportType</strong> value: GET_V2_SELLER_PERFORMANCE_REPORT</p>
</td>
<td>Report that contains the individual performance metrics data from the Seller Central Account Health dashboard. For all sellers.
<p>Can be requested</p></td>
</tbody>
</table>

## Settlement reports

Settlement reports cannot be requested or scheduled. They are automatically scheduled by Amazon. You can search for these reports using the getReports operation.

<table>
<thead>
<tr class="header">
<th><strong>Name</strong></th>
<th><strong>Description</strong></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td><p><strong>Flat File Settlement Report</strong></p>
<p><strong>reportType</strong> value: GET_V2_SETTLEMENT_REPORT_DATA_FLAT_FILE</p></td>
<td>Tab-delimited flat file settlement report. For all sellers.</td>
</tr>
<tr class="even">
<td><p><strong>XML Settlement Report</strong></p>
<p><strong>reportType</strong> value: GET_V2_SETTLEMENT_REPORT_DATA_XML</p></td>
<td>XML file settlement report. For Seller Central sellers only.</td>
</tr>
<tr class="odd">
<td><p><strong>Flat File V2 Settlement Report</strong></p>
<p><strong>reportType</strong> value:</p>
<p>GET_V2_SETTLEMENT_REPORT_DATA_FLAT_FILE_V2</p></td>
<td>Tab-delimited flat file alternate version of the Flat File Settlement Report. Price columns are condensed into three general purpose columns: amounttype, amountdescription, and amount. For Seller Central sellers only.</td>
</tr>
</tbody>
</table>

## Fulfillment by Amazon (FBA) reports

There are limits to how often Amazon will generate FBA reports. These limits depend on whether an FBA report is a near real-time report or a daily report. See the following table to see which FBA reports are near real-time and which are daily.

A near real-time FBA report is generated no more than once every 30 minutes. This means that after a near real-time FBA report is generated following your report request, a 30-minute waiting period must pass before Amazon will generate an updated version of that report. Note that the four "All Orders" reports are not subject to this limitation.

A daily FBA report is generated no more than once every four hours. This means that after a daily FBA report is generated following your report request, a four-hour waiting period must pass before Amazon will generate an updated version of that report.

<table>
<thead>
<tr class="header">
<th><strong>Name</strong></th>
<th><strong>Description</strong></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td><strong>FBA Sales Reports</strong></td>
<td></td>
</tr>
<tr class="even">
<td><p><strong>FBA Amazon Fulfilled Shipments Report</strong></p>
<p><strong>reportType</strong> value: GET_AMAZON_FULFILLED_SHIPMENTS_DATA_GENERAL</p>
</td>
<td><p>Tab-delimited flat file report. Contains detailed order/shipment/item information including price, courier, and tracking data. You can request up to one month of data in a single report. Content updated near real- time in Europe (EU), Japan, and North America (NA). For FBA sellers only. For Marketplace and Seller Central sellers.</p>

<p><strong>Note:</strong> In Japan, EU, and NA, in most cases, there will be a delay of approximately one to three hours from the time a fulfillment order ships and the time the items in the fulfillment order appear in the report. In some rare cases there could be a delay of up to 24 hours.</p>
<p>Can be requested.</p>
</td>
</tr>
<tr class="odd">
<td><p><strong>FBA Amazon Fulfilled Shipments Report (Invoicing)</strong></p>
<p><strong>reportType</strong> value: GET_AMAZON_FULFILLED_SHIPMENTS_DATA_INVOICING</p>
</td>
<td><p>Tab-delimited flat file report. This report should be used to generate tax invoices in the EU region. You can request up to one month of data in a single report. Content updated near real-time in Europe (EU), Japan, and North America (NA). For FBA sellers only. For Marketplace and Seller Central sellers.</p>

<p><strong>Note:</strong> In most cases, there will be a delay of approximately one to three hours from the time a fulfillment order ships and the time the items in the fulfillment order appear in the report. In some rare cases there could be a delay of up to 24 hours.</p>
<p>Can be requested.</p>
</td>
</tr>
<tr class="even">
<td><p><strong>FBA Amazon Fulfilled Shipments Report (Tax)</strong></p>
<p><strong>reportType</strong> value: GET_AMAZON_FULFILLED_SHIPMENTS_DATA_TAX</p>
</td>
<td><p>Tab-delimited flat file report. This report is for calculating and remitting taxes in the NA region. You can request up to one month of data in a single report. Content updated near real-time in Europe (EU), Japan, and North America (NA). For FBA sellers only. For Marketplace and Seller Central sellers.</p>

<p><strong>Note:</strong> In most cases, there will be a delay of approximately one to three hours from the time a fulfillment order ships and the time the items in the fulfillment order appear in the report. In some rare cases there could be a delay of up to 24 hours.</p>
<p>Can be requested.</p>
</td>
</tr>
<tr class="odd">
<td><p><strong>Flat File All Orders Report by Last Update</strong></p>
<p><strong>reportType</strong> value:</p>
<p>GET_FLAT_FILE_ALL_ORDERS_DATA_BY_LAST_UPDATE_GENERAL</p>
</td>
<td>Tab-delimited flat file report. Returns all orders updated in the specified date range regardless of fulfillment channel or shipment status. This report is intended for order tracking, not to drive a seller's fulfillment process. It does not include customer identifying information and scheduling is not supported. For all sellers.
<p>Can be requested.</p></td>
</tr>
<tr class="even">
<td><p><strong>Flat File All Orders Report by Order Date</strong></p>
<p><strong>reportType</strong> value:</p>
<p>GET_FLAT_FILE_ALL_ORDERS_DATA_BY_ORDER_DATE_GENERAL</p>
</td>
<td>Tab-delimited flat file report. Returns all orders placed in the specified date range regardless of fulfillment channel or shipment status. This report is intended for order tracking, not to drive a seller's fulfillment process. It does not include customer identifying information and scheduling is not supported. For all sellers.
<p>Can be requested.</p></td>
</tr>
<tr class="odd">
<td><p><strong>XML All Orders Report by Last Update</strong></p>
<p><strong>reportType</strong> value: GET_XML_ALL_ORDERS_DATA_BY_LAST_UPDATE_GENERAL</p>
</td>
<td>XML file order report that returns all orders updated in the specified date range regardless of fulfillment channel or shipment status. This report is intended for order tracking, not to drive a seller's fulfillment process. It does not include customer identifying information and scheduling is not supported. For all sellers.
<p>Can be requested.</p></td>
</tr>
<tr class="even">
<td><p><strong>XML All Orders Report by Order Date</strong></p>
<p><strong>reportType</strong> value: GET_XML_ALL_ORDERS_DATA_BY_ORDER_DATE_GENERAL</p>
</td>
<td>XML file order report that returns all orders placed in the specified date range regardless of fulfillment channel or shipment status. This report is intended for order tracking, not to drive a seller's fulfillment process. It does not include customer identifying information and scheduling is not supported. For all sellers.
<p>Can be requested.</p></td>
</tr>
<tr class="odd">
<td><p><strong>FBA Customer Shipment Sales Report</strong></p>
<p><strong>reportType</strong> value:</p>
<p>GET_FBA_FULFILLMENT_CUSTOMER_SHIPMENT_SALES_DATA</p>
</td>
<td><p>Tab-delimited flat file report. Contains condensed item level data on shipped FBA customer orders including price, quantity, and ship to location. Content updated near real-time in Europe (EU), Japan, and North America (NA). For FBA sellers only. For Marketplace and Seller Central sellers.</p>

<p><strong>Note:</strong> In Japan, EU, and NA, in most cases, there will be a delay of approximately one to three hours from the time a fulfillment order ships and the time the items in the fulfillment order appear in the report. In some rare cases there could be a delay of up to 24 hours.</p>
<p>Can be requested.</p>
</td>
</tr>
<tr class="even">
<td><p><strong>FBA Promotions Report</strong></p>
<p><strong>reportType</strong> value:</p>
<p>GET_FBA_FULFILLMENT_CUSTOMER_SHIPMENT_PROMOTION_DATA</p>
</td>
<td>Tab-delimited flat file report. Contains promotions applied to FBA customer orders sold through Amazon, such as Super Saver Shipping. Content updated daily. This report is only available to FBA sellers in North America (NA). For Marketplace and Seller Central sellers.
<p>Can be requested.</p></td>
</tr>
<tr class="odd">
<td><p><strong>FBA Customer Taxes</strong></p>
<p><strong>reportType</strong> value: GET_FBA_FULFILLMENT_CUSTOMER_TAXES_DATA</p>
</td>
<td>Tab-delimited flat file report for tax-enabled US sellers. This report contains data through February 28, 2013. All new transaction data can be found in the Sales Tax Report. For FBA sellers only. For Marketplace and Seller Central sellers.
<p>Can be requested.</p></td>
</tr>
<tr class="even">
<td><p><strong>Remote Fulfillment Eligibility</strong></p>
<p><strong>reportType</strong> value: GET_REMOTE_FULFILLMENT_ELIGIBILITY</p>
</td>
<td><p>Tab-delimited flat file report that contains all of a seller's US Fulfillment by Amazon offers, including whether they qualify for the North America Remote Fulfillment (NARF) program.</p>

<p><strong>Note:</strong> Recheck this report regularly, since ASIN eligibility can change. This report can take up to 24 hours to generate.</p>

<p>Can be requested.</p></td>
</tr>
</tbody>
</table>

<table>
<thead>
<tr class="header">
<th><strong>FBA Inventory Reports</strong></th>
<th></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td><p><strong>FBA Amazon Fulfilled Inventory Report</strong></p>
<p><strong>reportType</strong> value: GET_AFN_INVENTORY_DATA</p>
</td>
<td>Tab-delimited flat file report. Content updated in near real-time. For FBA sellers only. For Marketplace and Seller Central sellers.
<p>Can be requested.</p>
</td>
</tr>
<tr class="even">
<td><p><strong>FBA Multi-Country Inventory Report</strong></p>
<p><strong>reportType</strong> value: GET_AFN_INVENTORY_DATA_BY_COUNTRY</p>
</td>
<td>Tab-delimited flat file report. Contains quantity available for local fulfillment by country, helping Multi-Country Inventory sellers in Europe track their FBA inventory. Content updated in near-real time. This report is only available to FBA sellers in Europe (EU). For Seller Central sellers.
<p>Can be requested.</p></td>
</tr>
<tr class="even">
<td><p><strong>Inventory Ledger Report - Summary View</strong></p>
<p><strong>reportType</strong> value: GET_LEDGER_SUMMARY_VIEW_DATA</p>
</td>
<td><p>Tab-delimited flat file report. Inventory Ledger Report is like a "bank statement" of your inventory. It provides end-to-end inventory reconciliation capability by showing starting inventory balance, received inventory, customer orders, customer returns, adjustments, removals and ending balance. </p>
<p>This report accepts the following <strong>reportOptions</strong> values:</p>
<ul>
<li><p><strong>aggregateByLocation.</strong> Include <code>Country</code> to aggregate Summary View data by country. Include <code>FulfillmentCenter</code> to aggregate Summary View data by fulfillment center. Default: <code>COUNTRY</code>. URL-encoded example: <code>ReportOptions=aggregateByLocation%3DCOUNTRY</code></p></li></ul>	
<ul>
<li><p><strong>aggregatedByTimePeriod.</strong> Specify the time period to aggregate Summary View data accordingly (for example, <code>MONTHLY</code>, <code>WEEKLY</code>, <code>DAILY</code>, etc.). Default: <code>MONTHLY</code>. URL-encoded example: <code>ReportOptions=aggregatedByTimePeriod%3DMONTHLY</code></p></li></ul>	
<p>Can be requested.</p>
</td>
</tr>
<tr class="odd">
<td><p><strong>Inventory Ledger Report - Detailed View</strong></p>
<p><strong>reportType</strong> value: GET_LEDGER_DETAIL_VIEW_DATA</p>
</td>
<td>Tab-delimited flat file report. Use the Inventory Ledger Report - Detailed View to analyze your inventory movements to and from Amazon fulfillment centers, including products that are sold, returned, removed/disposed, damaged, lost, and found. You can view all historical movements of your inventory for 18 months in this report.
<p>Can be requested.</p></td>
</tr>
<tr class="odd">
<td><p><strong>FBA Daily Inventory History Report</strong></p>
<p><strong>reportType</strong> value:</p>
<p>GET_FBA_FULFILLMENT_CURRENT_INVENTORY_DATA</p>
</td>
<td>Tab-delimited flat file report. Contains historical daily snapshots of a seller's available inventory in Amazon’s fulfillment centers including quantity, location, and disposition. Content updated daily. For FBA sellers only. For Marketplace and Seller Central sellers.
<p>Can be requested.</p></td>
</tr>
<tr class="even">
<td><p><strong>FBA Monthly Inventory History Report</strong></p>
<p><strong>reportType</strong> value:</p>
<p>GET_FBA_FULFILLMENT_MONTHLY_INVENTORY_DATA</p>
</td>
<td>Tab-delimited flat file report. Contains historical monthly snapshots of the seller's available inventory in Amazon’s fulfillment centers including average and end-of-month quantity, location, and disposition. Content updated daily. For FBA sellers only. For Marketplace and Seller Central sellers.
<p>Can be requested.</p></td>
</tr>
<tr class="odd">
<td><p><strong>FBA Received Inventory Report</strong></p>
<p><strong>reportType</strong> value:</p>
<p>GET_FBA_FULFILLMENT_INVENTORY_RECEIPTS_DATA</p>
</td>
<td>Tab-delimited flat file report. Contains inventory that has completed the receive process at Amazon’s fulfillment centers. Content updated daily. For FBA sellers only. For Marketplace and Seller Central sellers.
<p>Can be requested.</p></td>
</tr>
<tr class="even">
<td><p><strong>FBA Reserved Inventory Report</strong></p>
<p><strong>reportType</strong> value: GET_RESERVED_INVENTORY_DATA</p>
</td>
<td>Tab-delimited flat file report. Provides data about the number of reserved units in a seller's inventory. Content updated in near real-time. For FBA sellers only. For Marketplace and Seller Central sellers.
<p>Can be requested.</p></td>
</tr>
<tr class="odd">
<td><p><strong>FBA Inventory Event Detail Report</strong></p>
<p><strong>reportType</strong> value:</p>
<p>GET_FBA_FULFILLMENT_INVENTORY_SUMMARY_DATA</p>
</td>
<td>Tab-delimited flat file report. Contains history of inventory events (for example, receipts, shipments, adjustments etc.) by SKU and fulfillment center. Content updated daily. For FBA sellers only. For Marketplace and Seller Central sellers.
<p>Can be requested.</p></td>
</tr>
<tr class="even">
<td><p><strong>FBA Inventory Adjustments Report</strong></p>
<p><strong>reportType</strong> value:</p>
<p>GET_FBA_FULFILLMENT_INVENTORY_ADJUSTMENTS_DATA</p>
</td>
<td>Tab-delimited flat file report. Contains corrections and updates to a seller's inventory in response to issues such as damage, loss, receiving discrepancies, etc. Content updated daily. For FBA sellers only. For Marketplace and Seller Central sellers.
<p>Can be requested.</p></td>
</tr>
<tr class="odd">
<td><p><strong>FBA Inventory Health Report</strong></p>
<p><strong>reportType</strong> value:</p>
<p>GET_FBA_FULFILLMENT_INVENTORY_HEALTH_DATA</p>
</td>
<td>Tab-delimited flat file report. Contains information about inventory age, condition, sales volume, weeks of cover, and price. Content updated daily. For FBA Sellers only. For Marketplace and Seller Central sellers.
<p>Can be requested.</p></td>
</tr>
<tr class="even">
<td><p><strong>FBA Manage Inventory</strong></p>
<p><strong>reportType</strong> value: GET_FBA_MYI_UNSUPPRESSED_INVENTORY_DATA</p>
</td>
<td>Tab-delimited flat file report. Contains current details of active (not archived) inventory including condition, quantity, and volume. Content updated in near real-time. For FBA sellers only. For Marketplace and Seller Central sellers.
<p>Can be requested.</p></td>
</tr>
<tr class="odd">
<td><p><strong>FBA Manage Inventory - Archived</strong></p>
<p><strong>reportType</strong> value: GET_FBA_MYI_ALL_INVENTORY_DATA</p>
</td>
<td>Tab-delimited flat file report. Contains current details of all (including archived) inventory including condition, quantity, and volume. Content updated in near real-time. For FBA sellers only. For Marketplace and Seller Central sellers.
<p>Can be requested.</p></td>
</tr>
<tr class="even">
<td><p><strong>Restock Inventory Report</strong></p>
<p><strong>reportType</strong> value:</p>
<p>GET_RESTOCK_INVENTORY_RECOMMENDATIONS_REPORT</p>
</td>
<td>Tab-delimited flat file report. Provides recommendations on products to restock, suggested order quantities, and reorder dates. Content updated in near real-time. This report is only available to FBA sellers.
<p>Can be requested.</p></td>
</tr>
<tr class="odd">
<td><p><strong>FBA Inbound Performance Report</strong></p>
<p><strong>reportType</strong> value:</p>
<p>GET_FBA_FULFILLMENT_INBOUND_NONCOMPLIANCE_DATA</p>
</td>
<td>Tab-delimited flat file report. Contains inbound shipment problems by product and shipment. Content updated daily. For Marketplace and Seller Central sellers. This report is only available to FBA sellers.
<p>Can be requested.</p></td>
</tr>
<tr class="even">
<td><p><strong>FBA Stranded Inventory Report</strong></p>
<p><strong>reportType</strong> value: GET_STRANDED_INVENTORY_UI_DATA</p>
</td>
<td>Tab-delimited flat file report. Contains a breakdown of inventory in stranded status, including recommended actions. Content updated in near real-time. This report is only available to FBA sellers.
<p>Can be requested.</p></td>
</tr>
<tr class="odd">
<td><p><strong>FBA Bulk Fix Stranded Inventory Report</strong></p>
<p><strong>reportType</strong> value: GET_STRANDED_INVENTORY_LOADER_DATA</p>
</td>
<td><p>Tab-delimited flat file report. Contains a list of stranded inventory. Update the listing information in this report file and then submit the file using the Flat File Inventory Loader Feed (POST_FLAT_FILE_INVLOADER_DATA) of the Feeds API. Content updated in near real-time. This report is only available to FBA sellers.</p>
<p>Can be requested.</p></td>
</tr>
<tr class="even">
<td><p><strong>FBA Inventory Age Report</strong></p>
<p><strong>reportType</strong> value: GET_FBA_INVENTORY_AGED_DATA</p>
</td>
<td>Tab-delimited flat file report. Indicates the age of inventory, which helps sellers take action to avoid paying the Long Term Storage Fee. Content updated daily. This report is only available to FBA sellers.
<p>Can be requested.</p></td>
</tr>
<tr class="odd">
<td><p><strong>FBA Manage Excess Inventory Report</strong></p>
<p><strong>reportType</strong> value: GET_EXCESS_INVENTORY_DATA</p>
</td>
<td>Tab-delimited flat file report. Contains listings with excess inventory, which helps sellers take action to sell through faster. Content updated in near real-time. This report is only available to FBA sellers.
<p>Can be requested.</p></td>
</tr>
<tr class="even">
<td><p><strong>FBA Storage Fees Report</strong></p>
<p><strong>reportType</strong> value: GET_FBA_STORAGE_FEE_CHARGES_DATA</p></td>
<td>Tab-delimited flat file report. Contains estimated monthly inventory storage fees for each ASIN of a seller's inventory in Amazon fulfillment centers. For FBA sellers only.
<p>Can be requested or scheduled.</p></td>
</tr>
<tr class="odd">
<td><p><strong>Get Report Exchange Data</strong></p>
<p><strong>reportType</strong> value: GET_PRODUCT_EXCHANGE_DATA</p>
</td>
<td>Tab-delimited flat file report that contains product exchange information for the specified time duration.
<p>Can be requested.</p></td>
</tr>
</tbody>
</table>

<table>
<thead>
<tr class="header">
<th><strong>FBA Payments Reports</strong></th>
<th></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td><p><strong>FBA Fee Preview Report</strong></p>
<p><strong>reportType</strong> value: GET_FBA_ESTIMATED_FBA_FEES_TXT_DATA</p>
</td>
<td>Tab-delimited flat file report. Contains the estimated Amazon Selling and Fulfillment Fees for the seller's FBA inventory with active offers. The content is updated at least once every 72 hours. To successfully generate a report, specify the <strong>StartDate</strong> parameter for a minimum 72 hours prior to NOW and <strong>EndDate</strong> to NOW. For FBA sellers only. For Marketplace and Seller Central sellers.
<p>Can be requested.</p></td>
</tr>
<tr class="even">
<td><p><strong>FBA Reimbursements Report</strong></p>
<p><strong>reportType</strong> value: GET_FBA_REIMBURSEMENTS_DATA</p>
</td>
<td>Tab-delimited flat file report. Contains itemized details of a seller's inventory reimbursements, including the reason for the reimbursement. Content updated daily. For FBA sellers only. For Marketplace and Seller Central sellers.
<p>Can be requested.</p></td>
</tr>
<tr class="odd">
<td><p><strong>FBA Long Term Storage Fee Charges Report</strong></p>
<p><strong>reportType</strong> value:</p>
<p>GET_FBA_FULFILLMENT_LONGTERM_STORAGE_FEE_CHARGES_DATA</p>
</td>
<td>Tab-delimited flat file report that contains the charge data for long-term storage.
<p>Can be requested.</p></td>
</tr>
</tbody>
</table>

<table>
<thead>
<tr class="header">
<th><strong>FBA Customer Concessions Reports</strong></th>
<th></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td><p><strong>FBA Returns Report</strong></p>
<p><strong>reportType</strong> value:</p>
<p>GET_FBA_FULFILLMENT_CUSTOMER_RETURNS_DATA</p>
</td>
<td>Tab-delimited flat file report. Contains customer returned items received at an Amazon fulfillment center, including Return Reason and Disposition. Content updated daily. For FBA sellers only. For Marketplace and Seller Central sellers.
<p>Can be requested.</p></td>
</tr>
<tr class="even">
<td><p><strong>FBA Replacements Report</strong></p>
<p><strong>reportType</strong> value:</p>
<p>GET_FBA_FULFILLMENT_CUSTOMER_SHIPMENT_REPLACEMENT_DATA</p>
</td>
<td>Tab-delimited flat file report. Contains replacements that have been issued to customers for completed orders. Content updated daily. For FBA sellers only. For Marketplace and Seller Central sellers.
<p>Can be requested.</p>
</td>
</tr>
</tbody>
</table>

<table>
<thead>
<tr class="header">
<th><strong>FBA Removals Reports</strong></th>
<th></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td><p><strong>FBA Recommended Removal Report</strong></p>
<p><strong>reportType</strong> value: GET_FBA_RECOMMENDED_REMOVAL_DATA</p>
</td>
<td><p>Tab-delimited flat file report. This report identifies sellable items that will be 365 days old or older during the next Long-Term Storage cleanup event, if the report is generated within six weeks of the cleanup event date.</p>
<p>This report includes both sellable and unsellable items. Content updated daily. For FBA sellers. For Marketplace and Seller Central sellers.</p>
<p>Can be requested.</p></td>
</tr>
<tr class="even">
<td><p><strong>FBA Removal Order Detail Report</strong></p>
<p><strong>reportType</strong> value:</p>
<p>GET_FBA_FULFILLMENT_REMOVAL_ORDER_DETAIL_DATA</p>
</td>
<td>Tab-delimited flat file report. This report contains all the removal orders, including the items in each removal order, placed during any given time period. This can be used to help reconcile the total number of items requested to be removed from an Amazon fulfillment center with the actual number of items removed, along with the status of each item in the removal order. Content updated in near real-time. For FBA sellers. For Marketplace and Seller Central sellers.
<p>Can be requested.</p></td>
</tr>
<tr class="odd">
<td><p><strong>FBA Removal Shipment Detail Report</strong></p>
<p><strong>reportType</strong> value:</p>
<p>GET_FBA_FULFILLMENT_REMOVAL_SHIPMENT_DETAIL_DATA</p>
</td>
<td>Tab-delimited flat file report. This report provides shipment tracking information for all removal orders and includes the items that have been removed from an Amazon fulfillment center for either a single removal order or for a date range. This report will not include canceled returns or disposed items; it is only for shipment information. Content updated in near real-time. For FBA sellers. For Marketplace and Seller Central sellers.
<p>Can be requested.</p></td>
</tr>
</tbody>
</table>

<table>
<thead>
<tr class="header">
<th><strong>FBA Small and Light Reports</strong></th>
<th></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td><p><strong>Small &amp; Light Inventory Report</strong></p>
<p><strong>reportType</strong> value: GET_FBA_UNO_INVENTORY_DATA</p>
</td>
<td><p>Tab-delimited flat file report. Contains all of a seller's products that are enrolled in the Small &amp; Light program and how much inventory they currently have in Small &amp; Light fulfillment centers. The report also shows the seller's current prices and whether any of their products are in unsellable status.</p>
<p>Can be requested.</p></td>
</tr>
</tbody>
</table>

## Tax Reports

<table>
<thead>
<tr class="header">
<th><strong>Name</strong></th>
<th><strong>Description</strong></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td><p><strong>Sales Tax Report</strong></p>
<p><strong>reportType</strong> value: GET_FLAT_FILE_SALES_TAX_DATA</p></td>
<td><p>Tab-delimited flat file for tax-enabled US sellers. Content updated daily. This report cannot be requested or scheduled. The seller must generate the report from the Tax Document Library in Seller Central. After the report has been generated, you can search for it using the getReports operation. For Marketplace and Seller Central sellers.</p></td>
</tr>
<tr class="even">
<td><p><strong>Amazon VAT Calculation Report</strong></p>
<p><strong>reportType</strong> value: SC_VAT_TAX_REPORT</p>
</td>
<td>Comma-separated flat file report that provides detailed value-added tax (VAT) calculation information for buyer shipments, returns, and refunds. This report is only available in the Germany, Spain, Italy, France, and UK marketplaces.
<p>Can be requested.</p></td>
</tr>
<tr class="odd">
<td><p><strong>Amazon VAT Transactions Report</strong></p>
<p><strong>reportType</strong> value: GET_VAT_TRANSACTION_DATA</p>
</td>
<td>Tab-delimited flat file report that provides detailed information for sales, returns, refunds, cross border inbound, and cross border fulfillment center transfers. This report is only available in the Germany, Spain, Italy, France, and UK marketplaces.
<p>Can be requested.</p></td>
</tr>
<tr class="even">
<td><p><strong>On Demand GST Merchant Tax Report B2B</strong></p>
<p><strong>reportType</strong> value: GET_GST_MTR_B2B_CUSTOM</p>
</td>
<td>Tab-delimited flat file report that provides detailed information about sales, refunds, and cancellations from Amazon Business invoices issued within a date range that you specify.
<p>Can be requested.</p></td>
</tr>
<tr class="odd">
<td><p><strong>On Demand GST Merchant Tax Report B2C</strong></p>
<p><strong>reportType</strong> value: GET_GST_MTR_B2C_CUSTOM</p>
</td>
<td>Tab-delimited flat file report that provides detailed information about sales, refunds, and cancellations from consumer invoices issued within a date range that you specify.
<p>Can be requested.</p></td>
</tr>
</tbody>
</table>

## Browse tree report

<table>
<thead>
<tr class="header">
<th><strong>Name</strong></th>
<th><strong>Description</strong></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td><p><strong>Browse Tree Report</strong></p>
<p><strong>reportType</strong> value:</p>
<p>GET_XML_BROWSE_TREE_DATA</p>
</td>
<td><p>XML report that provides browse tree hierarchy information and node refinement information for the Amazon retail website in any marketplace.</p>
<p>For Marketplace and Seller Central sellers.</p>
<p>This report accepts the following <strong>reportOptions</strong> values:</p>
<ul>
<li><strong>MarketplaceId</strong> – Specifies the marketplace from which you want browse tree information. Optional. If <strong>MarketplaceId</strong> is not included in the <strong>reportOptions</strong> parameter, the report contains browse tree information from the seller's default marketplace.</li>
</ul>
<p><strong>Note:</strong> The seller must be registered in any marketplace that you specify using the <strong>MarketplaceId</strong> value. Also, your request must be sent to an endpoint that corresponds to the <strong>MarketplaceId</strong> that you specify. Otherwise the service returns an error.</p>
<ul>
<li><strong>RootNodesOnly</strong> - Type: xs:boolean. Optional. If <code>true</code>, then the report contains only the root nodes from the marketplace specified using <strong>MarketplaceId</strong> (or from the seller's default marketplace, if <strong>MarketplaceId</strong> is not specified). If <code>false</code>, or if <strong>RootNodesOnly</strong> is not included in the <strong>ReportOptions</strong> parameter, then the content of the report depends on the value of <strong>BrowseNodeId</strong>.</li>
</ul>
<ul>
<li><strong>BrowseNodeId</strong> – Specifies the top node of the browse tree hierarchy in the report. Optional. If <strong>BrowseNodeId</strong> is not included in the <strong>ReportOptions</strong> parameter, and if <strong>RootNodesOnly</strong> is <code>false</code> or is not included in the <strong>ReportOptions</strong> parameter, then the report contains the entire browse node hierarchy from the marketplace specified using <strong>MarketplaceId</strong> (or from the seller's default marketplace, if <strong>MarketplaceId</strong> is not specified). Note that if you include an invalid <strong>BrowseNodeId</strong> in your request, the service returns a report that contains no data.</li>
</ul>
<p><strong>Note:</strong> If <strong>RootNodesOnly</strong> and <strong>BrowseNodeId</strong> are both included in the <strong>reportOptions</strong> parameter, <strong>RootNodesOnly</strong> takes precedence.</p>
<p><strong>Note:</strong> Amazon recommends that you do not include the <strong>MarketplaceIdList</strong> parameter with calls to the createReport operation that request the <strong>Browse Tree Report</strong>. If there is ever a conflict between a <strong>MarketplaceIdList</strong> parameter value and the <strong>MarketplaceId</strong> value of the <strong>reportOptions</strong> parameter, the <strong>MarketplaceId</strong> value takes precedence.</p>

<p>To keep track of which browse nodes change over time, Amazon recommends that each time you request this report you compare it to the last report you requested using the same <strong>reportOptions</strong> values.</p>
<p>URL-encoded example: <code>ReportOptions=MarketplaceId%3DATVPDKIKX0DER;BrowseNodeId%3D15706661</code></p>
<p>The Browse Tree Report is described by the following XSD: <a href="https://images-na.ssl-images-amazon.com/images/G/01/mwsportal/doc/en_US/Reports/XSDs/BrowseTreeReport.xsd"><span class="underline">BrowseTreeReport.xsd</span></a>.</p>

<p><strong>Note:</strong> Amazon may update the BrowseTreeReport.xsd schema. Keep this in mind if you choose to use this schema for validation.</p>
<p>Can be requested or scheduled.</p></td>
</tr>
</tbody>
</table>

## Easy ship reports

<table>
<thead>
<tr class="header">
<th><strong>Name</strong></th>
<th><strong>Description</strong></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td><p><strong>EasyShip Report</strong></p>
<p><strong>reportType</strong> value:</p>
<p>GET_EASYSHIP_DOCUMENTS</p></td>
<td>PDF report that contains the invoice, shipping label, and warranty (if available) documents for an Amazon Easy Ship order. This report is only available in the India marketplace.</td>
</tr>
<tr class="even">
<td><p><strong>EasyShip Picked Up Report</strong></p>
<p><strong>reportType</strong> value:</p>
<p>GET_EASYSHIP_PICKEDUP</p></td>
<td>Tab-delimited report that contains all of the seller-fulfilled orders that were picked up on the specified dates. This report is only available in the India marketplace.</td>
</tr>
<tr class="odd">
<td><p><strong>EasyShip Waiting for Pick Up Report</strong></p>
<p><strong>reportType</strong> value:</p>
<p>GET_EASYSHIP_WAITING_FOR_PICKUP</p></td>
<td>Tab-delimited report that contains all of a seller's orders that are in the "Waiting for pick up" status in Seller Central. This report is only available in the India marketplace.</td>
</tr>
</tbody>
</table>

## Amazon business reports

<table>
<thead>
<tr class="header">
<th><strong>Name</strong></th>
<th><strong>Description</strong></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td><p><strong>Manage Quotes Report</strong></p>
<p><strong>reportType</strong> value:</p>
<p>RFQD_BULK_DOWNLOAD</p></td>
<td>A Microsoft Excel Workbook (.xlsx) file. Contains current details of requests for quantity discounts, including customer requests, active quantity discounts, analysis of pending requests, and analysis of all requests. Content updated in near real-time. For Amazon Business sellers only.<p>Can be requested or scheduled.</p></td>
</tr>
<tr class="even">
<td><strong>Referral Fee Discounts Report</strong>
<p><strong>reportType</strong> value:</p>
<p>FEE_DISCOUNTS_REPORT</p>
</td>
<td>A Microsoft Excel Workbook (.xlsx) file that contains a summary of the seller's fee discounts.
<p><strong>Note:</strong> The information in this report may be up to 24 hours old. Please do not request a report more than once within a 24-hour period.</p><p>Can be requested or scheduled.</p>
</td>
</tr>
</tbody>
</table>

## Amazon pay report

<table>
<thead>
<tr class="header">
<th><strong>Name</strong></th>
<th><strong>Description</strong></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td><strong>AmazonPay Sandbox Settlement Report</strong>
<p><strong>reportType</strong> value:</p>
<p>GET_FLAT_FILE_OFFAMAZONPAYMENTS_SANDBOX_SETTLEMENT_DATA</p>

</td>
<td>Comma-separated flat file report that contains all of the transactions made in seller's sandbox account. Here are the marketplace IDs for the available sandbox marketplaces:
<ul>
<li><p>EU: A1G8446IYHA4MR</p></li> 
<li><p>JP: A31YDYE76E6TCP</p></li>
<li><p>UK: A3M3RRFO9XDT2G</p></li>
<li><p>US: A3BXB0YN3XH17H</p></li>
</ul>
<p>Can be requested.</p></td>
</tr>
</tbody>
</table>

## B2B Product Opportunities Reports

<table>
<thead>
<tr class="header">
<th><strong>Name</strong></th>
<th><strong>Description</strong></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td><strong>B2B Product Opportunities - Recommended for You Report</strong>
<p><strong>reportType</strong> value:</p>
<p>GET_B2B_PRODUCT_OPPORTUNITIES_RECOMMENDED_FOR_YOU</p>
</td>
<td>Comma-separated report includes recommended products that might be a good opportunity for the selling partner's business on Amazon. Each report offers 1,000 recommendations and is refreshed weekly.
<p>This report is only available in these marketplaces:</p>
<ul>
<li><p>US</p></li> 
<li><p>UK</p></li>
<li><p>France</p></li>
<li><p>Spain</p></li>
<li><p>Italy</p></li>
<li><p>India</p></li>
<li><p>Japan</p></li>
</ul></td>
</tr>
<tr class="even">
<td><strong>B2B Product Opportunities - Not yet on Amazon</strong>
<p><strong>reportType</strong> value:</p>
<p>GET_B2B_PRODUCT_OPPORTUNITIES_NOT_YET_ON_AMAZON</p>
</td>
<td>Comma-separated report includes a compiled a list of products that are in demand, but are not yet on Amazon. Each report offers 1,000 recommendations and is refreshed weekly.
<p>This report is only available in these marketplaces:</p>
<ul>
<li><p>US</p></li> 
<li><p>UK</p></li>
<li><p>France</p></li>
<li><p>Spain</p></li>
<li><p>Italy</p></li>
<li><p>India</p></li>
<li><p>Japan</p></li>
</ul></td>
</tr>
</tbody>
</table>

