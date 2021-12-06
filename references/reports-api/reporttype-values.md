# reportType values

Use a **reportType** value to specify the type of report that you want to request using the Reports API.

In the report descriptions, "Seller Central" refers to sellers who have registered to sell on Amazon in the past few years; "Marketplace" refers to legacy sellers who registered to sell on Amazon prior to the last few years. Some reports are only available for Marketplace or Seller Central sellers. 

For more information about registering in Amazon’s Brand Registry, see [Build and protect your  brand](https://brandservices.amazon.com/).

Report types fall into these categories:

- [Brand Analytics reports](#brand-analytics-reports)

- [Vendor retail analytics reports](#vendor-retail-analytics-reports)

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

- [B2B product opportunities reports](#b2b-product-opportunities-reports)

## Brand Analytics reports

<table>
  <thead>
    <tr class="header">
      <th><strong>Name</strong></th>
      <th><strong>Description</strong></th>
    </tr>
  </thead>
  <tbody>
      <tr class="odd">
      <td>
        <p><strong>Market Basket Analysis Report</strong></p>
        <p><strong>reportType</strong> value:<br>GET_BRAND_ANALYTICS_MARKET_BASKET_REPORT</p>
      </td>
      <td><p>JSON report containing data on the items that are most commonly purchased in combination with the items in the customer's basket (cart) at checkout. The data is available across different reporting periods: DAY, WEEK, MONTH, and QUARTER. Requests can span multiple reporting periods. In this report, an <b>asin</b> property is an ASIN in the selling partner's catalog and a <b>purchasedWithAsin</b> property might or might not be an ASIN in the selling partner's catalog. Available to selling partners who have the Brand Analytics Selling Partner API role and who are registered in Amazon's Brand Registry.
        </p>
        <p>This report accepts the following <b>reportOptions</b> property:</p>
        <ul>
        <li><b>reportPeriod</b>. Specifies the reporting period for the report. Values include <i>DAY</i>, <i>WEEK</i>, <i>MONTH</i>, and <i>QUARTER</i><br>
              Example:<br><code>"reportOptions":{"reportPeriod": "WEEK"}</code></li>
        </ul>
        <p>Requests must include the <b>reportPeriod</b> property. Use the <b>dataStartTime</b> and <b>dataEndTime</b> parameters to specify the date boundaries for the report. The <b>dataStartTime</b> and <b>dataEndTime</b> values must correspond to valid first and last days in the specified <b>reportPeriod</b>. For example, <b>dataStartTime</b> must be a Sunday and <b>dataEndTime</b> must be a Saturday when <b>reportPeriod</b>=<i>WEEK </i>.
        </p>
        <p>Can be requested by vendors.</p>
      </td>
    </tr>
    <tr class="even">
      <td>
        <p><strong>Amazon Search Terms Report</strong></p>
        <p><strong>reportType</strong> value:<br>GET_BRAND_ANALYTICS_SEARCH_TERMS_REPORT</p>
      </td>
      <td><p>JSON report containing data on the top clicked ASINs by search keyword and department for a marketplace. The data is available across different reporting periods: DAY, WEEK, MONTH, and QUARTER. Requests cannot span multiple reporting periods. For example, a request with <b>reportPeriod</b>=<i>WEEK</i> could not start on 2021-06-06 and end on 2021-06-19, as this would span more than one week. Available to selling partners who have the Brand Analytics Selling Partner API role and who are registered in Amazon's Brand Registry.</p>
      <p>This report accepts the following <b>reportOptions</b> property:</p>
        <ul>
        <li><b>reportPeriod</b>. Specifies the reporting period for the report.  Values include <i>DAY</i>, <i>WEEK</i>, <i>MONTH</i>, and <i>QUARTER</i><br>
              Example:<br><code>"reportOptions":{"reportPeriod": "WEEK"}</code></li>
        </ul>
        <p>Requests must include the <b>reportPeriod</b> property. Use the <b>dataStartTime</b> and <b>dataEndTime</b> parameters to specify the date boundaries for the report. The <b>dataStartTime</b> and <b>dataEndTime</b> values must correspond to valid first and last days in the specified <b>reportPeriod</b>. For example, <b>dataStartTime</b> must be a Sunday and <b>dataEndTime</b> must be the following Saturday when <b>reportPeriod</b>=<i>WEEK</i>.</p>
        <p>Can be requested by sellers and vendors.</p>
      </td>
    </tr>
  </tbody>
</table>

## Vendor retail analytics reports

<table>
  <thead>
    <tr class="header">
      <th><strong>Name</strong></th>
      <th><strong>Description</strong></th>
    </tr>
  </thead>
  <tbody>
    <tr class="odd">
      <td>
        <p><strong>Sales Diagnostic Report</strong></p>
        <p><strong>reportType</strong> value:<br>GET_VENDOR_SALES_DIAGNOSTIC_REPORT</p>
      </td>
      <td>
        <p>JSON report with key retail performance metrics such as ordered/shipped revenue and units, glance 
          views, conversion, replenishable out-of-stock rate, lost buy box rate, customer returns, and free
          replacements, among others. Data is reported daily within each ASIN for the trailing 13 months.
          Available to vendors who have the Brand Analytics Selling Partner API role and who are registered in
          Amazon's Brand Registry.</p>
        <p>Can be requested.</p>
        <p><i><strong>Note</strong>: A new version of this report is expected to launch as early as Q4 2021.
          Changes include the reportType value and report structure. The current version of this report will
          be deprecated 90 days after launch of the new version.</i></p>
      </td>
    </tr>
    <tr class="even">
      <td>
        <p><strong>Inventory Health & Planning Report</strong></p>
        <p><strong>reportType</strong> value:<br>GET_VENDOR_INVENTORY_HEALTH_AND_PLANNING_REPORT</p>
      </td>
      <td><p>JSON report with key vendor inventory health metrics such as net received inventory, open purchase order
        quantity, sell-through rate, on-hand inventory, aged inventory, vendor lead time, among others. Data is
        reported daily within each ASIN for the trailing 13-months. Available to vendors who have the Brand
        Analytics Selling Partner API role and who are registered in Amazon's Brand Registry.</p>
        <p>Can be requested.</p>
        <i><strong>Note</strong>: A new version of this report is expected to launch as early
          as Q4 2021. Changes include the reportType value and report structure. The current version of this
          report will be deprecated 90 days after launch of the new version.</i></td>
    </tr>
    <tr class="odd">
      <td>
        <p><strong>Demand Forecast Report</strong></p>
        <p><strong>reportType</strong> value:<br>GET_VENDOR_DEMAND_FORECAST_REPORT</p>
      </td>
      <td><p>JSON report with +26 weeks of Amazon's consumer demand forecast. Consumer demand data, in units, is
        available for each of the next 26 weeks from the report creation date. Available to vendors who have the
        Brand Analytics Selling Partner API role and who are registered in Amazon's Brand Registry.</p>
        <p>Can be requested.</p>
          <i><strong>Note</strong>: A new version of this report is expected to launch as early
          as Q4 2021. Changes include the reportType value and report structure. The current version of this
          report will be deprecated 90 days after launch of the new version.</i>
      </td>
    </tr>
  </tbody>
</table>

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
      <td>
        <p><strong>Inventory Report</strong></p>
        <p><strong>reportType</strong> value:<br/>GET_FLAT_FILE_OPEN_LISTINGS_DATA</p>
      </td>
      <td>
        <p>Tab-delimited flat file open listings report that contains a summary of the seller's product listings with
          the price and quantity for each SKU. For Marketplace and Seller Central sellers.</p>
        <p>This report accepts the following reportOptions values:</p>
        <ul>
          <li>
            <p><strong>Custom</strong> - A Boolean value that indicates whether a custom report is returned. Default:
              <code>false</code>.<br/>
              Example:<br/><code>"reportOptions":{"custom":"true"}</code>.</p>
          </li>
        </ul>
        <p>Can be requested.</p>
      </td>
    </tr>
    <tr class="even">
      <td>
        <p><strong>All Listings Report</strong></p>
        <p><strong>reportType</strong> value:<br/>GET_MERCHANT_LISTINGS_ALL_DATA</p>
      </td>
      <td><p>Tab-delimited flat file detailed all listings report. For Marketplace and Seller Central sellers.</p>
        <p>This report accepts the following reportOptions values:</p>
        <ul>
          <li>
            <p><strong>Custom</strong> - A Boolean value that indicates whether a custom report is returned. Default:
              <code>false</code>.<br/>
              Example:<br/>
              <code>"reportOptions":{"custom":"true"}</code>.</p>
          </li>
        </ul>
        <p>Can be requested.</p>
      </td>
    </tr>
    <tr class="odd">
      <td>
        <p><strong>Active Listings Report</strong></p>
        <p><strong>reportType</strong> value:<br/>GET_MERCHANT_LISTINGS_DATA</p>
      </td>
      <td><p>Tab-delimited flat file detailed active listings report. For Marketplace and Seller Central sellers.</p>
        <p>Can be requested.</p>
      </td>
    </tr>
    <tr class="even">
      <td>
        <p><strong>Inactive Listings Report</strong></p>
        <p><strong>reportType</strong> value:<br/>GET_MERCHANT_LISTINGS_INACTIVE_DATA</p>
      </td>
      <td><p>Tab-delimited flat file detailed inactive listings report. For Marketplace and Seller Central sellers.</p>
        <p>Can be requested.</p>
      </td>
    </tr>
    <tr class="odd">
      <td>
        <p><strong>Open Listings Report</strong></p>
        <p><strong>reportType</strong> value:<br/>GET_MERCHANT_LISTINGS_DATA_BACK_COMPAT</p>
      </td>
      <td>
        <p>Tab-delimited flat file open listings report.</p>
        <p>This report accepts the following reportOptions values:</p>
        <ul>
          <li>
            <p><strong>Custom</strong> - A Boolean value that indicates whether a custom report is returned. Default:
              <code>false</code>.<br/>Example:<br/> <code>"reportOptions":{"custom":"true"}</code>.</p>
          </li>
        </ul>
        <p>Can be requested.</p>
      </td>
    </tr>
    <tr class="even">
      <td>
        <p><strong>Open Listings Report Lite</strong></p>
        <p><strong>reportType</strong> value:<br/>GET_MERCHANT_LISTINGS_DATA_LITE</p>
      </td>
      <td><p>Tab-delimited flat file active listings report that contains only the SKU, ASIN, Price, and Quantity fields
        for items that have a quantity greater than zero. For Marketplace and Seller Central sellers.</p>
        <p>Can be requested.</p>
      </td>
    </tr>
    <tr class="odd">
      <td>
        <p><strong>Open Listings Report Liter</strong></p>
        <p><strong>reportType</strong> value:<br/>GET_MERCHANT_LISTINGS_DATA_LITER</p>
      </td>
      <td><p>Tab-delimited flat file active listings report that contains only the SKU and Quantity fields for items that
        have a quantity greater than zero. For Marketplace and Seller Central sellers.</p>
        <p>Can be requested.</p>
      </td>
    </tr>
    <tr class="even">
      <td>
        <p><strong>Canceled Listings Report</strong></p>
        <p><strong>reportType</strong> value:<br/>GET_MERCHANT_CANCELLED_LISTINGS_DATA</p>
      </td>
      <td>
        <p>Tab-delimited flat file canceled listings report. For Marketplace and Seller Central sellers.</p>
        <p>This report accepts the following reportOptions values:</p>
        <ul>
          <li>
            <p><strong>Custom</strong> - A Boolean value that indicates whether a custom report is returned. Default:
              <code>false</code>.<br/>Example:<br/> <code>"reportOptions":{"custom":"true"}</code>.</p>
          </li>
        </ul>
        <p>Can be requested.</p>
      </td>
    </tr>
    <tr class="odd">
      <td>
        <p><strong>Suppressed Listings Report</strong></p>
        <p><strong>reportType</strong> value:<br/>GET_MERCHANTS_LISTINGS_FYP_REPORT</p>
      </td>
      <td><p>Tab-delimited flat file that contains suppressed listings, the reason each listing is suppressed, and instructions for removing each suppression. For Marketplace and Seller Central users.</p>
        <p>Can be requested or scheduled.</p>
      </td>
    </tr>
    <tr class="even">
      <td>
        <p><strong>Listing Quality and Suppressed Listing Report</strong></p>
        <p><strong>reportType</strong> value:<br/>GET_MERCHANT_LISTINGS_DEFECT_DATA</p>
      </td>
      <td><p>Tab-delimited flat file listing quality and suppressed listing report that contains listing information that
        is incomplete or incorrect. For Marketplace and Seller Central sellers.</p>
        <p>Can be requested.</p>
      </td>
    </tr>
    <tr class="odd">
      <td><strong>Pan-European Eligibility: FBA ASINs</strong>
        <p><strong>reportType</strong> value:<br/> GET_PAN_EU_OFFER_STATUS</p>
      </td>
      <td>
      <p>Tab-delimited flat file report that contains enrollment status and eligibility information for the
        Pan-European FBA program for each of the seller's Amazon-fulfilled listings. This report is only available to
        FBA sellers in the Spain, UK, France, Germany, and Italy marketplaces. For more information, see the Seller
        Central Help.</p>
        <p>Can be requested.</p>
      </td>
    </tr>
    <tr class="even">
      <td><strong>Pan-European Eligibility: Self-fulfilled ASINs</strong>
        <p><strong>reportType</strong> value:<br/> GET_MFN_PAN_EU_OFFER_STATUS</p>
      </td>
      <td>
      <p>Tab-delimited flat file report that contains eligibility information for the Pan-European FBA Program for each
        of the seller's self-fulfilled listings. Self-fulfilled listings are not allowed in the Pan-European FBA
        program, and this report can help sellers determine whether to convert any of their self-fulfilled listings to
        Amazon-fulfilled listings in order to enroll them in the program. This report is only available in the Spain,
        UK, France, Germany, and Italy marketplaces. For more information, see the Seller Central Help.</p>
        <p>Can be requested.</p>
      </td>
    </tr>
    <tr class="odd">
      <td>
        <p><strong>Referral Fee Preview Report</strong></p>
        <p><strong>reportType</strong> value:<br/>GET_REFERRAL_FEE_PREVIEW_REPORT</p>
      </td>
      <td>
        <p>Tab-delimited flat file that contains the seller's open listings as well as the price and estimated referral
          fees for each SKU.</p>
        <p><strong>Note:</strong> The information in this report may be up to 24 hours old. Please do not request a
          report more than once per 24 hour period.</p>
        <p>Can be requested.</p>
      </td>
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
      <td>
        <p><strong>Unshipped Orders Report</strong></p>
        <p><strong>reportType</strong> value:<br/>GET_FLAT_FILE_ACTIONABLE_ORDER_DATA_SHIPPING</p>
      </td>
      <td>
        <p>Tab-delimited flat file report that contains only orders that are not confirmed as shipped. For Marketplace and Seller Central sellers.</p>
        <p>This report accepts the following reportOptions values:</p>
        <ul>
          <li>
            <p><strong>ShowSalesChannel</strong> - A Boolean value that indicates whether an additional column is added
              to the report that shows the sales channel. Default: <code>false</code>.<br/>Example:<br/>
              <code>"reportOptions":{"ShowSalesChannel":"true"}</code>
            </p>
          </li>
        </ul>
        <p>Can be requested or scheduled.</p>
      </td>
    </tr>
    <tr class="even">
      <td>
        <p><strong>Scheduled XML Order Report (Invoicing)</strong></p>
        <p><strong>reportType</strong> value:<br>GET_ORDER_REPORT_DATA_INVOICING</p>
      </td>
      <td>
        <p>Scheduled XML order report. For Seller Central sellers only. This report can be used to generate tax invoices
          in the EU region.</p>
        <p>You can only schedule one GET_ORDER_REPORT_DATA_INVOICING or GET_FLAT_FILE_ORDER_REPORT_DATA_INVOICING report
          at a time. If you have one of these reports scheduled and you schedule a new report, the existing report will
          be canceled.</p>
        <p>Can be scheduled.</p>
      </td>
    </tr>
    <tr class="odd">
      <td>
        <p><strong>Scheduled XML Order Report (Tax)</strong></p>
        <strong>reportType</strong> value:<br>GET_ORDER_REPORT_DATA_TAX
      </td>
      <td>
        <p>Scheduled XML order report. For Seller Central sellers only. This report is for calculating and remitting
          taxes in the NA region.</p>
        <p>You can only schedule one GET_ORDER_REPORT_DATA_TAX or GET_FLAT_FILE_ORDER_REPORT_DATA_TAX report at a time.
          If you have one of these reports scheduled and you schedule a new report, the existing report will be
          canceled.</p>
        <p>Can be scheduled.</p>
      </td>
    </tr>
    <tr class="even">
      <td>
        <p><strong>Scheduled XML Order Report (Shipping)</strong></p>
        <strong>reportType</strong> value:<br>GET_ORDER_REPORT_DATA_SHIPPING
      </td>
      <td>
        <p>Scheduled XML order report. For Seller Central sellers only. This report is for shipping seller fulfilled
          orders to customers.</p>
        <p>You can only schedule one GET_ORDER_REPORT_DATA_SHIPPING or GET_FLAT_FILE_ORDER_REPORT_DATA_SHIPPING report
          at a time. If you have one of these reports scheduled and you schedule a new report, the existing report will
          be canceled.</p>
        <p>Can be scheduled.</p>
      </td>
    </tr>
    <tr class="odd">
      <td>
        <p><strong>Requested or Scheduled Flat File Order Report (Invoicing)</strong></p> <strong>reportType</strong>
        value:<br>GET_FLAT_FILE_ORDER_REPORT_DATA_INVOICING
      </td>
      <td>
        <p>Tab-delimited flat file order report that can be requested or scheduled. This report can be used to generate
          tax invoices in the EU region. This report shows orders from the previous 60 days. For Marketplace and Seller
          Central sellers.</p>
        <p>Seller Central sellers can only schedule one GET_ORDER_REPORT_DATA_INVOICING or
          GET_FLAT_FILE_ORDER_REPORT_DATA_INVOICING report at a time.</p>
        <p>If you have one of these reports scheduled and you schedule a new report, the existing report will be
          canceled.</p>
        <p><strong>Note:</strong> The format of this report will differ slightly depending on whether it is scheduled or
          requested.</p>
        <p>This report accepts the following reportOptions values:</p>
        <ul>
          <li>
            <p><strong>ShowSalesChannel</strong> - A Boolean value that indicates whether an additional column is added
              to the report that shows the sales channel. Default: <code>false</code>.<br>Example:<br>
              <code>"reportOptions":{"ShowSalesChannel":"true"}</code></p>
          </li>
        </ul>
        <p>Can be requested or scheduled.</p>
      </td>
    </tr>
    <tr class="even">
      <td>
        <p><strong>Requested or Scheduled Flat File Order Report (Shipping)</strong></p>
        <strong>reportType</strong> value:<br>GET_FLAT_FILE_ORDER_REPORT_DATA_SHIPPING
      </td>
      <td>
        <p>Tab-delimited flat file order report that can be requested or scheduled. This report shows orders from the
          previous 60 days. This report can be used to ship Amazon orders. For Marketplace and Seller Central sellers.
        </p>
        <p>Seller Central sellers can only schedule one GET_ORDER_REPORT_DATA_SHIPPING or
          GET_FLAT_FILE_ORDER_REPORT_DATA_SHIPPING report at a time.</p>
        <p>If you have one of these reports scheduled and you schedule a new report, the existing report will be
          canceled.</p>
        <p><strong>Note:</strong> The format of this report will differ slightly depending on whether it is scheduled or
          requested.</p>
        <p>This report accepts the following reportOptions values:</p>
        <ul>
          <li>
            <p><strong>ShowSalesChannel</strong> - A Boolean value that indicates whether an additional column is added
              to the report that shows the sales channel. Default: <code>false</code>.<br>Example:<br>
              <code>"reportOptions":{"ShowSalesChannel":"true"}</code>
            </p>
          </li>
        </ul>
        <p>Can be requested or scheduled.</p>
      </td>
    </tr>
    <tr class="odd">
      <td>
        <p><strong>Requested or Scheduled Flat File Order Report (Tax)</strong></p>
        <strong>reportType</strong> value:<br>GET_FLAT_FILE_ORDER_REPORT_DATA_TAX
      </td>
      <td>
        <p>Tab-delimited flat file order report for the NA region that can be requested or scheduled. This report shows
          orders from the previous 60 days for NA region only. For Marketplace and Seller Central sellers.</p>
        <p>Seller Central sellers can only schedule one GET_ORDER_REPORT_DATA_TAX or GET_FLAT_FILE_ORDER_REPORT_DATA_TAX
          report at a time.</p>
        <p>If you have one of these reports scheduled and you schedule a new report, the existing report will be
          canceled.</p>
        <p><strong>Note:</strong> The format of this report will differ slightly depending on whether it is scheduled or
          requested.</p>
        <p>This report accepts the following reportOptions values:</p>
        <ul>
          <li>
            <p><strong>ShowSalesChannel</strong> - A Boolean value that indicates whether an additional column is added
              to the report that shows the sales channel. Default: <code>false</code>.<br>Example:<br>
              <code>"reportOptions":{"ShowSalesChannel":"true"}</code>
            </p>
          </li>
        </ul>
        <p>Can be requested or scheduled.</p>
      </td>
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
      <td><strong>Flat File Orders By Last Update Report</strong>
        <p><strong>reportType</strong> value:<br>
          GET_FLAT_FILE_ALL_ORDERS_DATA_BY_LAST_UPDATE_GENERAL</p>
      </td>
      <td><p>Tab-delimited flat file report that shows all orders updated in the specified period. For all sellers.</p>
        <p>Can be requested.</p>
      </td>
    </tr>
    <tr class="even">
      <td>
        <p><strong>Flat File Orders By Order Date Report</strong></p>
        <p><strong>reportType</strong> value:<br>
          GET_FLAT_FILE_ALL_ORDERS_DATA_BY_ORDER_DATE_GENERAL</p>
      </td>
      <td><p>Tab-delimited flat file report that shows all orders that were placed in the specified period. For all sellers.</p>
        <p>Can be requested.</p>
      </td>
    </tr>
    <tr class="odd">
      <td>
        <p><strong>Flat File Archived Orders Report</strong></p>
        <p><strong>reportType</strong> value:<br>
          GET_FLAT_FILE_ARCHIVED_ORDERS_DATA_BY_ORDER_DATE</p>
      </td>
      <td><p>Tab-delimited flat file report that shows all archived orders that were placed in the specified period. For
        all sellers.</p>
        <p>Can be requested.</p>
      </td>
    </tr>
    <tr class="even">
      <td>
        <p><strong>XML Orders By Last Update Report</strong></p>
        <p><strong>reportType</strong> value:<br>GET_XML_ALL_ORDERS_DATA_BY_LAST_UPDATE_GENERAL</p>
      </td>
      <td><p>XML report that shows all orders updated in the specified period. For all sellers.</p>
        <p>Can be requested.</p>
      </td>
    </tr>
    <tr class="odd">
      <td>
        <p><strong>XML Orders By Order Date Report</strong></p>
        <p><strong>reportType</strong> value:<br>GET_XML_ALL_ORDERS_DATA_BY_ORDER_DATE_GENERAL</p>
      </td>
      <td><p>XML report that shows all orders that were placed in the specified period. For all sellers.</p>
        <p>Can be requested.</p>
      </td>
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
      <td>
        <p><strong>Flat File Pending Orders Report</strong></p>
        <p><strong>reportType</strong> value:<br>GET_FLAT_FILE_PENDING_ORDERS_DATA</p>
      </td>
      <td><p>Tab-delimited flat file report that shows all pending orders. For all sellers.</p>
        <p>Can be requested or scheduled.</p>
      </td>
    </tr>
    <tr class="even">
      <td>
        <p><strong>XML Pending Orders Report</strong></p>
        <p><strong>reportType</strong> value:<br>GET_PENDING_ORDERS_DATA</p>
      </td>
      <td><p>XML report that shows all pending orders. Can only be scheduled using Amazon MWS.</p>
        <p>Can be requested or scheduled.</p>
      </td>
    </tr>
    <tr class="odd">
      <td>
        <p><strong>Converged Flat File Pending Orders Report</strong></p>
        <p><strong>reportType</strong> value:<br>
          GET_CONVERGED_FLAT_FILE_PENDING_ORDERS_DATA</p>
      </td>
      <td><p>Flat file report that shows all pending orders. For Marketplace sellers.</p>
        <p>Can be requested or scheduled.</p>
      </td>
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
      <td>
        <p><strong>XML Returns Report by Return Date</strong></p>
        <p><strong>reportType</strong> value:<br>GET_XML_RETURNS_DATA_BY_RETURN_DATE</p>
      </td>
      <td><p>XML report contains detailed returns information, including return request date, RMA ID, label details, ASIN,
        and return reason code. You can request up to 60 days of data in a single report.</p>
        <p>Can be requested or scheduled.</p>
      </td>
    </tr>
    <tr class="even">
      <td>
        <p><strong>Flat File Returns Report by Return Date</strong></p>
        <p><strong>reportType</strong> value:<br>
          GET_FLAT_FILE_RETURNS_DATA_BY_RETURN_DATE</p>
      </td>
      <td><p>Tab-delimited flat file report that contains detailed returns information, including return request date, RMA
        ID, label details, ASIN, and return reason code. You can request up to 60 days of data in a single report.</p>
        <p>Can be requested or scheduled.</p>
      </td>
    </tr>
    <tr class="odd">
      <td>
        <p><strong>XML Prime Returns Report by Return Date</strong></p>
        <p><strong>reportType</strong> value:<br>GET_XML_MFN_PRIME_RETURNS_REPORT</p>
      </td>
      <td><p>XML report that contains detailed Seller Fulfilled Prime returns information, including return request date,
        RMA ID, label details, ASIN, and return reason code. You can request up to 60 days of data in a single report.</p>
        <p>Can be requested or scheduled.</p>
      </td>
    </tr>
    <tr class="even">
      <td>
        <p><strong>CSV Prime Returns Report by Return Date</strong></p>
        <p><strong>reportType</strong> value:<br>GET_CSV_MFN_PRIME_RETURNS_REPORT</p>
      </td>
      <td><p>Comma-separated flat file report that contains detailed Seller Fulfilled Prime returns information, including
        return request date, RMA ID, label details, ASIN, and return reason code. You can request up to 60 days of data
        in a single report.</p>
        <p>Can be requested or scheduled.</p>
      </td>
    </tr>
    <tr class="odd">
      <td>
        <p><strong>XML Return Attributes Report by Return Date</strong></p>
        <p><strong>reportType</strong> value:</p>
        <p>GET_XML_MFN_SKU_RETURN_ATTRIBUTES_REPORT</p>
      </td>
      <td><p>XML report that contains detailed return attribute information by SKU, including prepaid label eligibility and
        returnless refund eligibility. You can request up to 60 days of data in a single report.</p>
        <p>Can be requested or scheduled.</p>
      </td>
    </tr>
    <tr class="even">
      <td>
        <p><strong>Flat File Return Attributes Report by Return Date</strong></p>
        <p><strong>reportType</strong> value:<br>
          GET_FLAT_FILE_MFN_SKU_RETURN_ATTRIBUTES_REPORT</p>
      </td>
      <td><p>Tab-delimited flat file report that contains detailed return attribute information by SKU, including prepaid
        label eligibility and returnless refund eligibility. You can request up to 60 days of data in a single report.</p>
        <p>Can be requested or scheduled.</p>
      </td>
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
      <td>
        <p><strong>Flat File Feedback Report</strong></p>
        <p><strong>reportType</strong> value:<br>GET_SELLER_FEEDBACK_DATA</p>
      </td>
      <td><p>Tab-delimited flat file report that contains negative and neutral feedback (one to three stars) from buyers
        who rated the seller's performance. For all sellers.</p>
        <p>Can be requested.</p>
      </td>
    </tr>
    <tr class="even">
      <td>
        <p><strong>XML Customer Metrics Report</strong></p>
        <p><strong>reportType</strong> value:<br>GET_V1_SELLER_PERFORMANCE_REPORT</p>
      </td>
      <td><p>XML report that contains select, individual performance metrics data from the Seller Central dashboard. For
        all sellers.</p>
        <p>Can be requested.</p>
      </td>
    </tr>
    <tr class="odd">
      <td>
        <p><strong>Seller Performance Report</strong></p>
        <p><strong>reportType</strong> value:<br>GET_V2_SELLER_PERFORMANCE_REPORT</p>
      </td>
      <td><p>Report that contains the individual performance metrics data from the Seller Central Account Health dashboard.
        For all sellers.</p>
        <p>Can be requested</p>
      </td>
    </tr>
    <tr class="even">
      <td>
        <p><strong>Promotions Performance Report</strong></p>
        <p><strong>reportType</strong> value:<br>GET_PROMOTION_PERFORMANCE_REPORT</p>
      </td>
      <td><p>JSON report containing data from promotion campaigns to help vendors and sellers optimize their promotions and adjust their advertising strategies. The report includes sales from promotions, the types of discounts that were offered, and how many items were sold as a result of the promotions. Currently, three promotion types are supported for vendors (Best Deal, Lightning Deal, and Price Discount), and two promotion types are supported for sellers (Best Deal and Lightning Deal). Available to vendors and sellers who have the Selling Partner Insights Selling Partner API role and who are registered in Amazon's Brand Registry.</p>
      <p>This report accepts the following <b>reportOptions</b> properties:</p>
        <ul>
        <li><b>promotionStartDateFrom</b>. The start of a date and time range (in ISO 8601 date time format) used for selecting promotions to report on. Be sure to specify the time zone: either UTC or an offset from UTC.</li>
        <li><b>promotionStartDateTo</b>. The end of a date and time range (in ISO 8601 date time format) used for selecting promotions to report on. Be sure to specify the time zone: either UTC or an offset from UTC.<br>
              Example:<br><pre>"reportOptions": {
  "promotionStartDateFrom": "2020-11-23T15:33:26Z",
  "promotionStartDateTo": "2020-12-06T15:33:26Z"
}</pre></li>
        </ul>
        <p>Requests must include the <b>promotionStartDateFrom</b> and  <b>promotionStartDateTo</b> properties. All promotions with a start date-time that fall within the range of <b>promotionStartDateFrom</b> and <b>promotionStartDateTo</b> will be included.</p>
      <p>Report behaviors:</p>
      <ul>
      <li>If a selected promotion is in progress when you request a report, the report will contain cumulative data for the promotion up until the day prior to your report request.</li>
      <li>A report will contain complete information on a selected promotion if the promotion ended one day or more before the time you requested the report.</li>
      <li>This report supports start dates up to two years before the current date.</li>
      <li>Data for this report is updated on a daily basis, so some fields might not reflect the most up-to-date state of the promotion.</li>
      </ul><p>Can be requested by both vendors and sellers.</p>
      </td>
    </tr>
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
      <td>
        <p><strong>Flat File Settlement Report</strong></p>
        <p><strong>reportType</strong> value: GET_V2_SETTLEMENT_REPORT_DATA_FLAT_FILE</p>
      </td>
      <td><p>Tab-delimited flat file settlement report. For all sellers.</p></td>
    </tr>
    <tr class="even">
      <td>
        <p><strong>XML Settlement Report</strong></p>
        <p><strong>reportType</strong> value:<br>GET_V2_SETTLEMENT_REPORT_DATA_XML</p>
      </td>
      <td><p>XML file settlement report. For Seller Central sellers only.</p></td>
    </tr>
    <tr class="odd">
      <td>
        <p><strong>Flat File V2 Settlement Report</strong></p>
        <p><strong>reportType</strong> value:<br>
          GET_V2_SETTLEMENT_REPORT_DATA_FLAT_FILE_V2</p>
      </td>
      <td><p>Tab-delimited flat file alternate version of the Flat File Settlement Report. Price columns are condensed into
        three general purpose columns: amounttype, amountdescription, and amount. For Seller Central sellers only.</p></td>
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
      <td>
        <p><strong>FBA Amazon Fulfilled Shipments Report</strong></p>
        <p><strong>reportType</strong> value:<br>GET_AMAZON_FULFILLED_SHIPMENTS_DATA_GENERAL</p>
      </td>
      <td>
        <p>Tab-delimited flat file report. Contains detailed order/shipment/item information including price, courier,
          and tracking data. You can request up to one month of data in a single report. Content updated near real- time
          in Europe (EU), Japan, and North America (NA). For FBA sellers only. For Marketplace and Seller Central
          sellers.</p>
        <p><strong>Note:</strong> In Japan, EU, and NA, in most cases, there will be a delay of approximately one to
          three hours from the time a fulfillment order ships and the time the items in the fulfillment order appear in
          the report. In some rare cases there could be a delay of up to 24 hours.</p>
        <p>Can be requested.</p>
      </td>
    </tr>
    <tr class="odd">
      <td>
        <p><strong>FBA Amazon Fulfilled Shipments Report (Invoicing)</strong></p>
        <p><strong>reportType</strong> value:<br>GET_AMAZON_FULFILLED_SHIPMENTS_DATA_INVOICING</p>
      </td>
      <td>
        <p>Tab-delimited flat file report. This report should be used to generate tax invoices in the EU region. You can
          request up to one month of data in a single report. Content updated near real-time in Europe (EU), Japan, and
          North America (NA). For FBA sellers only. For Marketplace and Seller Central sellers.</p>
        <p><strong>Note:</strong> In most cases, there will be a delay of approximately one to three hours from the time
          a fulfillment order ships and the time the items in the fulfillment order appear in the report. In some rare
          cases there could be a delay of up to 24 hours.</p>
        <p>Can be requested.</p>
      </td>
    </tr>
    <tr class="even">
      <td>
        <p><strong>FBA Amazon Fulfilled Shipments Report (Tax)</strong></p>
        <p><strong>reportType</strong> value:<br>GET_AMAZON_FULFILLED_SHIPMENTS_DATA_TAX</p>
      </td>
      <td>
        <p>Tab-delimited flat file report. This report is for calculating and remitting taxes in the NA region. You can
          request up to one month of data in a single report. Content updated near real-time in Europe (EU), Japan, and
          North America (NA). For FBA sellers only. For Marketplace and Seller Central sellers.</p>
        <p><strong>Note:</strong> In most cases, there will be a delay of approximately one to three hours from the time
          a fulfillment order ships and the time the items in the fulfillment order appear in the report. In some rare
          cases there could be a delay of up to 24 hours.</p>
        <p>Can be requested.</p>
      </td>
    </tr>
    <tr class="odd">
      <td>
        <p><strong>Flat File All Orders Report by Last Update</strong></p>
        <p><strong>reportType</strong> value:<br>
          GET_FLAT_FILE_ALL_ORDERS_DATA_BY_LAST_UPDATE_GENERAL</p>
      </td>
      <td><p>Tab-delimited flat file report. Returns all orders updated in the specified date range regardless of
        fulfillment channel or shipment status. This report is intended for order tracking, not to drive a seller's
        fulfillment process. It does not include customer identifying information and scheduling is not supported. For
        all sellers.</p>
        <p>Can be requested.</p>
      </td>
    </tr>
    <tr class="even">
      <td>
        <p><strong>Flat File All Orders Report by Order Date</strong></p>
        <p><strong>reportType</strong> value:<br>
          GET_FLAT_FILE_ALL_ORDERS_DATA_BY_ORDER_DATE_GENERAL</p>
      </td>
      <td><p>
        Tab-delimited flat file report. Returns all orders placed in the specified date range regardless of fulfillment
        channel or shipment status. This report is intended for order tracking, not to drive a seller's fulfillment
        process. It does not include customer identifying information and scheduling is not supported. For all sellers.</p>
        <p>Can be requested.</p>
      </td>
    </tr>
    <tr class="odd">
      <td>
        <p><strong>XML All Orders Report by Last Update</strong></p>
        <p><strong>reportType</strong> value:<br>GET_XML_ALL_ORDERS_DATA_BY_LAST_UPDATE_GENERAL</p>
      </td>
      <td><p>XML file order report that returns all orders updated in the specified date range regardless of fulfillment
        channel or shipment status. This report is intended for order tracking, not to drive a seller's fulfillment
        process. It does not include customer identifying information and scheduling is not supported. For all sellers.</p>
        <p>Can be requested.</p>
      </td>
    </tr>
    <tr class="even">
      <td>
        <p><strong>XML All Orders Report by Order Date</strong></p>
        <p><strong>reportType</strong> value:<br>GET_XML_ALL_ORDERS_DATA_BY_ORDER_DATE_GENERAL</p>
      </td>
      <td><p>XML file order report that returns all orders placed in the specified date range regardless of fulfillment
        channel or shipment status. This report is intended for order tracking, not to drive a seller's fulfillment
        process. It does not include customer identifying information and scheduling is not supported. For all sellers.</p>
        <p>Can be requested.</p>
      </td>
    </tr>
    <tr class="odd">
      <td>
        <p><strong>FBA Customer Shipment Sales Report</strong></p>
        <p><strong>reportType</strong> value:<br>
          GET_FBA_FULFILLMENT_CUSTOMER_SHIPMENT_SALES_DATA</p>
      </td>
      <td>
        <p>Tab-delimited flat file report. Contains condensed item level data on shipped FBA customer orders including
          price, quantity, and ship to location. Content updated near real-time in Europe (EU), Japan, and North America
          (NA). For FBA sellers only. For Marketplace and Seller Central sellers.</p>
        <p><strong>Note:</strong> In Japan, EU, and NA, in most cases, there will be a delay of approximately one to
          three hours from the time a fulfillment order ships and the time the items in the fulfillment order appear in
          the report. In some rare cases there could be a delay of up to 24 hours.</p>
        <p>Can be requested.</p>
      </td>
    </tr>
    <tr class="even">
      <td>
        <p><strong>FBA Promotions Report</strong></p>
        <p><strong>reportType</strong> value:<br>GET_FBA_FULFILLMENT_CUSTOMER_SHIPMENT_PROMOTION_DATA</p>
      </td>
      <td><p>Tab-delimited flat file report. Contains promotions applied to FBA customer orders sold through Amazon, such
        as Super Saver Shipping. Content updated daily. This report is only available to FBA sellers in North America
        (NA). For Marketplace and Seller Central sellers.</p>
        <p>Can be requested.</p>
      </td>
    </tr>
    <tr class="odd">
      <td>
        <p><strong>FBA Customer Taxes</strong></p>
        <p><strong>reportType</strong> value:<br>GET_FBA_FULFILLMENT_CUSTOMER_TAXES_DATA</p>
      </td>
      <td><p>Tab-delimited flat file report for tax-enabled US sellers. This report contains data through February 28,
        2013. All new transaction data can be found in the Sales Tax Report. For FBA sellers only. For Marketplace and
        Seller Central sellers.</p>
        <p>Can be requested.</p>
      </td>
    </tr>
    <tr class="even">
      <td>
        <p><strong>Remote Fulfillment Eligibility</strong></p>
        <p><strong>reportType</strong> value:<br>GET_REMOTE_FULFILLMENT_ELIGIBILITY</p>
      </td>
      <td>
        <p>Tab-delimited flat file report that contains all of a seller's US Fulfillment by Amazon offers, including
          whether they qualify for the North America Remote Fulfillment (NARF) program.</p>
        <p><strong>Note:</strong> Recheck this report regularly, since ASIN eligibility can change. This report can take
          up to 24 hours to generate.</p>
        <p>Can be requested.</p>
      </td>
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
      <td>
        <p><strong>FBA Amazon Fulfilled Inventory Report</strong></p>
        <p><strong>reportType</strong> value:<br>GET_AFN_INVENTORY_DATA</p>
      </td>
      <td><p>Tab-delimited flat file report. Content updated in near real-time. For FBA sellers only. For Marketplace and
        Seller Central sellers.</p>
        <p>Can be requested.</p>
      </td>
    </tr>
    <tr class="even">
      <td>
        <p><strong>FBA Multi-Country Inventory Report</strong></p>
        <p><strong>reportType</strong> value:<br>GET_AFN_INVENTORY_DATA_BY_COUNTRY</p>
      </td>
      <td><p>Tab-delimited flat file report. Contains quantity available for local fulfillment by country, helping
        Multi-Country Inventory sellers in Europe track their FBA inventory. Content updated in near-real time. This
        report is only available to FBA sellers in Europe (EU). For Seller Central sellers.</p>
        <p>Can be requested.</p>
      </td>
    </tr>
    <tr class="even">
      <td>
        <p><strong>Inventory Ledger Report - Summary View</strong></p>
        <p><strong>reportType</strong> value:<br>GET_LEDGER_SUMMARY_VIEW_DATA</p>
      </td>
      <td>
        <p>Tab-delimited flat file report. Inventory Ledger Report is like a "bank statement" of your inventory. It
          provides end-to-end inventory reconciliation capability by showing starting inventory balance, received
          inventory, customer orders, customer returns, adjustments, removals and ending balance.</p>
        <p>This report accepts the following <strong>reportOptions</strong> values:</p>
        <ul>
          <li>
            <p><strong>aggregateByLocation</strong> - Include <code>Country</code> to aggregate Summary View data by
              country. Include <code>FulfillmentCenter</code> to aggregate Summary View data by fulfillment center.
              Default: <code>COUNTRY</code>. <br>Example:<br>
              <code>"reportOptions":{"aggregateByLocation":"COUNTRY"}</code>
            </p>
          </li>
        </ul>
        <ul>
          <li>
            <p><strong>aggregatedByTimePeriod</strong> - Specify the time period to aggregate Summary View data
              accordingly (for example, <code>MONTHLY</code>, <code>WEEKLY</code>, <code>DAILY</code>, etc.). Default:
              <code>MONTHLY</code>.<br>Example:<br>
              <code>"reportOptions":{"aggregatedByTimePeriod":"MONTHLY"}</code></p>
          </li>
        </ul>
        <p>Can be requested.</p>
      </td>
    </tr>
    <tr class="odd">
      <td>
        <p><strong>Inventory Ledger Report - Detailed View</strong></p>
        <p><strong>reportType</strong> value:<br>GET_LEDGER_DETAIL_VIEW_DATA</p>
      </td>
      <td><p>Tab-delimited flat file report. Use the Inventory Ledger Report - Detailed View to analyze your inventory movements to and from Amazon fulfillment centers, including products that are sold, returned, removed/disposed, damaged, lost, and found. You can view all historical movements of your inventory for 18 months in this report.</p>
        <p>Can be requested.</p>
      </td>
    </tr>
    <tr class="odd">
      <td>
        <p><strong>FBA Daily Inventory History Report</strong></p>
        <p><strong>reportType</strong> value:<br>
          GET_FBA_FULFILLMENT_CURRENT_INVENTORY_DATA</p>
      </td>
      <td><p>Tab-delimited flat file report. Contains historical daily snapshots of a seller's available inventory in Amazon’s fulfillment centers including quantity, location, and disposition. Content updated daily. For FBA sellers only. For Marketplace and Seller Central sellers.</p>
        <p>Can be requested.</p>
      </td>
    </tr>
    <tr class="even">
      <td>
        <p><strong>FBA Monthly Inventory History Report</strong></p>
        <p><strong>reportType</strong> value:<br>
          GET_FBA_FULFILLMENT_MONTHLY_INVENTORY_DATA</p>
      </td>
      <td><p>Tab-delimited flat file report. Contains historical monthly snapshots of the seller's available inventory in
        Amazon’s fulfillment centers including average and end-of-month quantity, location, and disposition. Content
        updated daily. For FBA sellers only. For Marketplace and Seller Central sellers.</p>
        <p>Can be requested.</p>
      </td>
    </tr>
    <tr class="odd">
      <td>
        <p><strong>FBA Received Inventory Report</strong></p>
        <p><strong>reportType</strong> value:<br>
          GET_FBA_FULFILLMENT_INVENTORY_RECEIPTS_DATA</p>
      </td>
      <td><p>Tab-delimited flat file report. Contains inventory that has completed the receive process at Amazon’s
        fulfillment centers. Content updated daily. For FBA sellers only. For Marketplace and Seller Central sellers.</p>
        <p>Can be requested.</p>
      </td>
    </tr>
    <tr class="even">
      <td>
        <p><strong>FBA Reserved Inventory Report</strong></p>
        <p><strong>reportType</strong> value:<br>GET_RESERVED_INVENTORY_DATA</p>
      </td>
      <td><p>Tab-delimited flat file report. Provides data about the number of reserved units in a seller's inventory.
        Content updated in near real-time. For FBA sellers only. For Marketplace and Seller Central sellers.</p>
        <p>Can be requested.</p>
      </td>
    </tr>
    <tr class="odd">
      <td>
        <p><strong>FBA Inventory Event Detail Report</strong></p>
        <p><strong>reportType</strong> value:
          GET_FBA_FULFILLMENT_INVENTORY_SUMMARY_DATA</p>
      </td>
      <td><p>Tab-delimited flat file report. Contains history of inventory events (for example, receipts, shipments,
        adjustments etc.) by SKU and fulfillment center. Content updated daily. For FBA sellers only. For Marketplace
        and Seller Central sellers.</p>
        <p>Can be requested.</p>
      </td>
    </tr>
    <tr class="even">
      <td>
        <p><strong>FBA Inventory Adjustments Report</strong></p>
        <p><strong>reportType</strong> value:<br>
          GET_FBA_FULFILLMENT_INVENTORY_ADJUSTMENTS_DATA</p>
      </td>
      <td><p>Tab-delimited flat file report. Contains corrections and updates to a seller's inventory in response to issues
        such as damage, loss, receiving discrepancies, etc. Content updated daily. For FBA sellers only. For Marketplace
        and Seller Central sellers.</p>
        <p>Can be requested.</p>
      </td>
    </tr>
    <tr class="odd">
      <td>
        <p><strong>FBA Inventory Health Report</strong></p>
        <p><strong>reportType</strong> value:<br>
          GET_FBA_FULFILLMENT_INVENTORY_HEALTH_DATA</p>
      </td>
      <td><p>Tab-delimited flat file report. Contains information about inventory age, condition, sales volume, weeks of
        cover, and price. Content updated daily. For FBA Sellers only. For Marketplace and Seller Central sellers.</p>
        <p>Can be requested.</p>
      </td>
    </tr>
    <tr class="even">
      <td>
        <p><strong>FBA Manage Inventory</strong></p>
        <p><strong>reportType</strong> value:<br>GET_FBA_MYI_UNSUPPRESSED_INVENTORY_DATA</p>
      </td>
      <td><p>Tab-delimited flat file report. Contains current details of active (not archived) inventory including
        condition, quantity, and volume. Content updated in near real-time. For FBA sellers only. For Marketplace and
        Seller Central sellers.</p>
        <p>Can be requested.</p>
      </td>
    </tr>
    <tr class="odd">
      <td>
        <p><strong>FBA Manage Inventory - Archived</strong></p>
        <p><strong>reportType</strong> value:<br>GET_FBA_MYI_ALL_INVENTORY_DATA</p>
      </td>
      <td><p>Tab-delimited flat file report. Contains current details of all (including archived) inventory including
        condition, quantity, and volume. Content updated in near real-time. For FBA sellers only. For Marketplace and
        Seller Central sellers.</p>
        <p>Can be requested.</p>
      </td>
    </tr>
    <tr class="even">
      <td>
        <p><strong>Restock Inventory Report</strong></p>
        <p><strong>reportType</strong> value:<br>
          GET_RESTOCK_INVENTORY_RECOMMENDATIONS_REPORT</p>
      </td>
      <td><p>Tab-delimited flat file report. Provides recommendations on products to restock, suggested order quantities,
        and reorder dates. Content updated in near real-time. This report is only available to FBA sellers.</p>
        <p>Can be requested.</p>
      </td>
    </tr>
    <tr class="odd">
      <td>
        <p><strong>FBA Inbound Performance Report</strong></p>
        <p><strong>reportType</strong> value:<br>
          GET_FBA_FULFILLMENT_INBOUND_NONCOMPLIANCE_DATA</p>
      </td>
      <td><p>Tab-delimited flat file report. Contains inbound shipment problems by product and shipment. Content updated
        daily. For Marketplace and Seller Central sellers. This report is only available to FBA sellers.</p>
        <p>Can be requested.</p>
      </td>
    </tr>
    <tr class="even">
      <td>
        <p><strong>FBA Stranded Inventory Report</strong></p>
        <p><strong>reportType</strong> value:<br>GET_STRANDED_INVENTORY_UI_DATA</p>
      </td>
      <td><p>Tab-delimited flat file report. Contains a breakdown of inventory in stranded status, including recommended
        actions. Content updated in near real-time. This report is only available to FBA sellers.</p>
        <p>Can be requested.</p>
      </td>
    </tr>
    <tr class="odd">
      <td>
        <p><strong>FBA Bulk Fix Stranded Inventory Report</strong></p>
        <p><strong>reportType</strong> value:<br>GET_STRANDED_INVENTORY_LOADER_DATA</p>
      </td>
      <td>
        <p>Tab-delimited flat file report. Contains a list of stranded inventory. Update the listing information in this
          report file and then submit the file using the Flat File Inventory Loader Feed (POST_FLAT_FILE_INVLOADER_DATA)
          of the Feeds API. Content updated in near real-time. This report is only available to FBA sellers.</p>
        <p>Can be requested.</p>
      </td>
    </tr>
    <tr class="even">
      <td>
        <p><strong>FBA Inventory Age Report</strong></p>
        <p><strong>reportType</strong> value:<br>GET_FBA_INVENTORY_AGED_DATA</p>
      </td>
      <td><p>Tab-delimited flat file report. Indicates the age of inventory, which helps sellers take action to avoid
        paying the Long Term Storage Fee. Content updated daily. This report is only available to FBA sellers.</p>
        <p>Can be requested.</p>
      </td>
    </tr>
    <tr class="odd">
      <td>
        <p><strong>FBA Manage Excess Inventory Report</strong></p>
        <p><strong>reportType</strong> value:<br>GET_EXCESS_INVENTORY_DATA</p>
      </td>
      <td><p>Tab-delimited flat file report. Contains listings with excess inventory, which helps sellers take action to
        sell through faster. Content updated in near real-time. This report is only available to FBA sellers.</p>
        <p>Can be requested.</p>
      </td>
    </tr>
    <tr class="even">
      <td>
        <p><strong>FBA Storage Fees Report</strong></p>
        <p><strong>reportType</strong> value:<br>GET_FBA_STORAGE_FEE_CHARGES_DATA</p>
      </td>
      <td><p>Tab-delimited flat file report. Contains estimated monthly inventory storage fees for each ASIN of a seller's
        inventory in Amazon fulfillment centers. For FBA sellers only.</p>
        <p>Can be requested or scheduled.</p>
      </td>
    </tr>
    <tr class="odd">
      <td>
        <p><strong>Get Report Exchange Data</strong></p>
        <p><strong>reportType</strong> value:<br>GET_PRODUCT_EXCHANGE_DATA</p>
      </td>
      <td><p>Tab-delimited flat file report that contains product exchange information for the specified time duration.</p>
        <p>Can be requested.</p>
      </td>
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
      <td>
        <p><strong>FBA Fee Preview Report</strong></p>
        <p><strong>reportType</strong> value:<br>GET_FBA_ESTIMATED_FBA_FEES_TXT_DATA</p>
      </td>
      <td><p>Tab-delimited flat file report. Contains the estimated Amazon Selling and Fulfillment Fees for the seller's
        FBA inventory with active offers. The content is updated at least once every 72 hours. To successfully generate
        a report, specify the <strong>StartDate</strong> parameter for a minimum 72 hours prior to NOW and
        <strong>EndDate</strong> to NOW. For FBA sellers only. For Marketplace and Seller Central sellers.</p>
        <p>Can be requested.</p>
      </td>
    </tr>
    <tr class="even">
      <td>
        <p><strong>FBA Reimbursements Report</strong></p>
        <p><strong>reportType</strong> value:<br>GET_FBA_REIMBURSEMENTS_DATA</p>
      </td>
      <td><p>Tab-delimited flat file report. Contains itemized details of a seller's inventory reimbursements, including
        the reason for the reimbursement. Content updated daily. For FBA sellers only. For Marketplace and Seller
        Central sellers.</p>
        <p>Can be requested.</p>
      </td>
    </tr>
    <tr class="odd">
      <td>
        <p><strong>FBA Long Term Storage Fee Charges Report</strong></p>
        <p><strong>reportType</strong> value:<br>
          GET_FBA_FULFILLMENT_LONGTERM_STORAGE_FEE_CHARGES_DATA</p>
      </td>
      <td><p>Tab-delimited flat file report that contains the charge data for long-term storage.</p>
        <p>Can be requested.</p>
      </td>
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
      <td>
        <p><strong>FBA Returns Report</strong></p>
        <p><strong>reportType</strong> value:<br>
          GET_FBA_FULFILLMENT_CUSTOMER_RETURNS_DATA</p>
      </td>
      <td><p>Tab-delimited flat file report. Contains customer returned items received at an Amazon fulfillment center,
        including Return Reason and Disposition. Content updated daily. For FBA sellers only. For Marketplace and Seller
        Central sellers.</p>
        <p>Can be requested.</p>
      </td>
    </tr>
    <tr class="even">
      <td>
        <p><strong>FBA Replacements Report</strong></p>
        <p><strong>reportType</strong> value:<br>
          GET_FBA_FULFILLMENT_CUSTOMER_SHIPMENT_REPLACEMENT_DATA</p>
      </td>
      <td><p>Tab-delimited flat file report. Contains replacements that have been issued to customers for completed orders.
        Content updated daily. For FBA sellers only. For Marketplace and Seller Central sellers.</p>
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
      <td>
        <p><strong>FBA Recommended Removal Report</strong></p>
        <p><strong>reportType</strong> value: GET_FBA_RECOMMENDED_REMOVAL_DATA</p>
      </td>
      <td>
        <p>Tab-delimited flat file report. This report identifies sellable items that will be 365 days old or older
          during the next Long-Term Storage cleanup event, if the report is generated within six weeks of the cleanup
          event date.</p>
        <p>This report includes both sellable and unsellable items. Content updated daily. For FBA sellers. For
          Marketplace and Seller Central sellers.</p>
        <p>Can be requested.</p>
      </td>
    </tr>
    <tr class="even">
      <td>
        <p><strong>FBA Removal Order Detail Report</strong></p>
        <p><strong>reportType</strong> value:<br>
          GET_FBA_FULFILLMENT_REMOVAL_ORDER_DETAIL_DATA</p>
      </td>
      <td><p>Tab-delimited flat file report. This report contains all the removal orders, including the items in each
        removal order, placed during any given time period. This can be used to help reconcile the total number of items
        requested to be removed from an Amazon fulfillment center with the actual number of items removed, along with
        the status of each item in the removal order. Content updated in near real-time. For FBA sellers. For
        Marketplace and Seller Central sellers.</p>
        <p>Can be requested.</p>
      </td>
    </tr>
    <tr class="odd">
      <td>
        <p><strong>FBA Removal Shipment Detail Report</strong></p>
        <p><strong>reportType</strong> value:<br>
          GET_FBA_FULFILLMENT_REMOVAL_SHIPMENT_DETAIL_DATA</p>
      </td>
      <td><p>Tab-delimited flat file report. This report provides shipment tracking information for all removal orders and
        includes the items that have been removed from an Amazon fulfillment center for either a single removal order or
        for a date range. This report will not include canceled returns or disposed items; it is only for shipment
        information. Content updated in near real-time. For FBA sellers. For Marketplace and Seller Central sellers.</p>
        <p>Can be requested.</p>
      </td>
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
      <td>
        <p><strong>Small &amp; Light Inventory Report</strong></p>
        <p><strong>reportType</strong> value:<br>GET_FBA_UNO_INVENTORY_DATA</p>
      </td>
      <td>
        <p>Tab-delimited flat file report. Contains all of a seller's products that are enrolled in the Small &amp;
          Light program and how much inventory they currently have in Small &amp; Light fulfillment centers. The report
          also shows the seller's current prices and whether any of their products are in unsellable status.</p>
        <p>Can be requested.</p>
      </td>
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
      <td>
        <p><strong>Sales Tax Report</strong></p>
        <p><strong>reportType</strong> value:<br>GET_FLAT_FILE_SALES_TAX_DATA</p>
      </td>
      <td>
        <p>Tab-delimited flat file for tax-enabled US sellers. Content updated daily. This report cannot be requested or
          scheduled. The seller must generate the report from the Tax Document Library in Seller Central. After the
          report has been generated, you can search for it using the getReports operation. For Marketplace and Seller
          Central sellers.</p>
      </td>
    </tr>
    <tr class="even">
      <td>
        <p><strong>Amazon VAT Calculation Report</strong></p>
        <p><strong>reportType</strong> value:<br>SC_VAT_TAX_REPORT</p>
      </td>
      <td><p>Comma-separated flat file report that provides detailed value-added tax (VAT) calculation information for
        buyer shipments, returns, and refunds. This report is only available in the Germany, Spain, Italy, France, and
        UK marketplaces.</p>
        <p>Can be requested.</p>
      </td>
    </tr>
    <tr class="odd">
      <td>
        <p><strong>Amazon VAT Transactions Report</strong></p>
        <p><strong>reportType</strong> value:<br>GET_VAT_TRANSACTION_DATA</p>
      </td>
      <td><p>Tab-delimited flat file report that provides detailed information for sales, returns, refunds, cross border
        inbound, and cross border fulfillment center transfers. This report is only available in the Germany, Spain,
        Italy, France, and UK marketplaces.</p>
        <p>Can be requested.</p>
      </td>
    </tr>
    <tr class="even">
      <td>
        <p><strong>On Demand GST Merchant Tax Report B2B</strong></p>
        <p><strong>reportType</strong> value:<br>GET_GST_MTR_B2B_CUSTOM</p>
      </td>
      <td><p>Tab-delimited flat file report that provides detailed information about sales, refunds, and cancellations from
        Amazon Business invoices issued within a date range that you specify.</p>
        <p>Can be requested.</p>
      </td>
    </tr>
    <tr class="odd">
      <td>
        <p><strong>On Demand GST Merchant Tax Report B2C</strong></p>
        <p><strong>reportType</strong> value:<br>GET_GST_MTR_B2C_CUSTOM</p>
      </td>
      <td><p>Tab-delimited flat file report that provides detailed information about sales, refunds, and cancellations from
        consumer invoices issued within a date range that you specify.</p>
        <p>Can be requested.</p>
      </td>
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
      <td>
        <p><strong>Browse Tree Report</strong></p>
        <p><strong>reportType</strong> value:<br>
          GET_XML_BROWSE_TREE_DATA</p>
      </td>
      <td>
        <p>XML report that provides browse tree hierarchy information and node refinement information for the Amazon
          retail website in any marketplace.</p>
        <p>For Marketplace and Seller Central sellers.</p>
        <p>This report accepts the following <strong>reportOptions</strong> values:</p>
        <ul>
          <li><strong>MarketplaceId</strong> – Specifies the marketplace from which you want browse tree information.
            If <strong>MarketplaceId</strong> is not included in the <strong>reportOptions</strong> parameter,
            the report contains browse tree information from the seller's default marketplace.</li>
        </ul>
        <p><strong>Note:</strong> The seller must be registered in any marketplace that you specify using the
          <strong>MarketplaceId</strong> value. Also, your request must be sent to an endpoint that corresponds to the
          <strong>MarketplaceId</strong> that you specify. Otherwise the service returns an error.</p>
        <ul>
          <li><strong>RootNodesOnly</strong> - A Boolean value. When <code>true</code>, the report
            contains only the root nodes from the marketplace specified using <strong>MarketplaceId</strong> (or from
            the seller's default marketplace, if <strong>MarketplaceId</strong> is not specified). When 
            <code>false</code>, or if <strong>RootNodesOnly</strong> is not included in the
            <strong>ReportOptions</strong> parameter, the content of the report depends on the value of
            <strong>BrowseNodeId</strong>.</li>
        </ul>
        <ul>
          <li>
            <strong>BrowseNodeId</strong> – Specifies the top node of the browse tree hierarchy in the report.
            If <strong>BrowseNodeId</strong> is not included in the <strong>ReportOptions</strong> parameter, and if
            <strong>RootNodesOnly</strong> is <code>false</code> or is not included in the
            <strong>ReportOptions</strong> parameter, then the report contains the entire browse node hierarchy from the
            marketplace specified using <strong>MarketplaceId</strong> (or from the seller's default marketplace, if
            <strong>MarketplaceId</strong> is not specified). Note that if you include an invalid
            <strong>BrowseNodeId</strong> in your request, the service returns a report that contains no data.
          </li>
        </ul>
        <p>
        <strong>Note:</strong> If <strong>RootNodesOnly</strong> and <strong>BrowseNodeId</strong> are both included
          in the <strong>reportOptions</strong> parameter, <strong>RootNodesOnly</strong> takes precedence.
        </p>
        <p>
        <strong>Note:</strong> Amazon recommends that you do not include the <strong>marketplaceIds </strong>
          parameter with calls to the createReport operation that request the <strong>Browse Tree Report</strong>. If
          there is ever a conflict between a <strong>marketplaceIds</strong> parameter value and the
          <strong>MarketplaceId</strong> value of the <strong>reportOptions</strong> parameter, the
          <strong>MarketplaceId</strong> value takes precedence.
        </p>
        <p>To keep track of which browse nodes change over time, Amazon recommends that each time you request this
          report you compare it to the last report you requested using the same <strong>reportOptions</strong> values.
        </p>
        <p>Example:<br>
        <code>"reportOptions":{"MarketplaceId":"ATVPDKIKX0DER","BrowseNodeId":"15706661"}</code>
        </p>
        <p>The Browse Tree Report is described by the following XSD: 
        <a href="https://images-na.ssl-images-amazon.com/images/G/01/mwsportal/doc/en_US/Reports/XSDs/BrowseTreeReport.xsd">BrowseTreeReport.xsd</a>.
        </p>
        <p><strong>Note:</strong> Amazon may update the BrowseTreeReport.xsd schema. Keep this in mind if you choose to
          use this schema for validation.</p>
        <p>Can be requested or scheduled.</p>
      </td>
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
      <td>
        <p><strong>EasyShip Report</strong></p>
        <p><strong>reportType</strong> value:<br>
          GET_EASYSHIP_DOCUMENTS</p>
      </td>
      <td><p>PDF report that contains the invoice, shipping label, and warranty (if available) documents for an Amazon Easy
        Ship order. This report is only available in the India marketplace.</p></td>
    </tr>
    <tr class="even">
      <td>
        <p><strong>EasyShip Picked Up Report</strong></p>
        <p><strong>reportType</strong> value:<br>
          GET_EASYSHIP_PICKEDUP</p>
      </td>
      <td><p>Tab-delimited report that contains all of the seller-fulfilled orders that were picked up on the specified
        dates. This report is only available in the India marketplace.</p></td>
    </tr>
    <tr class="odd">
      <td>
        <p><strong>EasyShip Waiting for Pick Up Report</strong></p>
        <p><strong>reportType</strong> value:<br>
          GET_EASYSHIP_WAITING_FOR_PICKUP</p>
      </td>
      <td><p>Tab-delimited report that contains all of a seller's orders that are in the "Waiting for pick up" status in
        Seller Central. This report is only available in the India marketplace.</p></td>
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
      <td>
        <p><strong>Manage Quotes Report</strong></p>
        <p><strong>reportType</strong> value:<br>
          RFQD_BULK_DOWNLOAD</p>
      </td>
      <td><p>A Microsoft Excel Workbook (.xlsx) file. Contains current details of requests for quantity discounts,
        including customer requests, active quantity discounts, analysis of pending requests, and analysis of all
        requests. Content updated in near real-time. For Amazon Business sellers only.</p><p>Can be requested or scheduled.
        </p>
      </td>
    </tr>
    <tr class="even">
      <td><strong>Referral Fee Discounts Report</strong>
        <p><strong>reportType</strong> value:<br>
          FEE_DISCOUNTS_REPORT</p>
      </td>
      <td>A Microsoft Excel Workbook (.xlsx) file that contains a summary of the seller's fee discounts.
        <p><strong>Note:</strong> The information in this report may be up to 24 hours old. Please do not request a
          report more than once within a 24-hour period.</p>
        <p>Can be requested or scheduled.</p>
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
      <td><p><strong>AmazonPay Sandbox Settlement Report</strong></p>
        <p><strong>reportType</strong> value:<br>
          GET_FLAT_FILE_OFFAMAZONPAYMENTS_SANDBOX_SETTLEMENT_DATA</p>
      </td>
      <td><p>Comma-separated flat file report that contains all of the transactions made in seller's sandbox account. Here
        are the marketplace IDs for the available sandbox marketplaces:</p>
        <ul>
          <li>
            <p>EU: A1G8446IYHA4MR</p>
          </li>
          <li>
            <p>JP: A31YDYE76E6TCP</p>
          </li>
          <li>
            <p>UK: A3M3RRFO9XDT2G</p>
          </li>
          <li>
            <p>US: A3BXB0YN3XH17H</p>
          </li>
        </ul>
        <p>Can be requested.</p>
      </td>
    </tr>
  </tbody>
</table>

## B2B product opportunities reports

<table>
  <thead>
    <tr class="header">
      <th><strong>Name</strong></th>
      <th><strong>Description</strong></th>
    </tr>
  </thead>
  <tbody>
    <tr class="odd">
      <td>
      <p><strong>B2B Product Opportunities - Recommended for You Report</strong></p>
        <p><strong>reportType</strong> value:<br>
          GET_B2B_PRODUCT_OPPORTUNITIES_RECOMMENDED_FOR_YOU</p>
      </td>
      <td><p>Comma-separated report that includes recommended products that might be a good opportunity for the selling
        partner's business on Amazon. Each report offers up to 10,000 recommendations and is refreshed weekly.</p>
        <p>This report accepts the following <strong>reportOptions</strong> values:</p>
        <ul>
          <li><strong>categories</strong> - type: String | (Optional) | Defaults to "".<br>Accepts a semicolon separated list of categories to use to filter the report.  
            <br>Example:
            <code>"reportOptions":{"categories":"Luggage;Wireless;Groceries"}</code>
            <br> The list of categories can be obtained by generating a report without entering a <code>categories</code> parameter.
          </li>
          <li><strong>subCategories</strong> - type: String | (Optional) |Defaults to "". <br>Accepts a semicolon separated list of subcategories to use to filter the report. 
            <br>Example:
            <code>"reportOptions":{"subCategories":"9100 Backpacks;1500 Navigation Electronics"}</code>
            <br> The list of subcategories can be obtained by generating a report without entering a <code>subCategories</code> parameter.
          </li>
          <li><strong>depersonalized</strong> - type: Boolean | (Optional) | Defaults to <strong><code>false</code></strong>. <br>A value that indicates if you are requesting a depersonalized report. A depersonalized report provides default recommendations that are not customized based on current seller history. <br>Example:
            <code>"reportOptions":{"depersonalized":"true"}</code>
          </li>
          <li><strong>filterMode</strong> - type: "include" or "exclude" | (Optional) | Defaults to <strong><code>include</code></strong>. <br>Use <strong>"include"</strong> to include only the categories or
            subCategories specified in reportOptions, or <strong>"exclude"</strong> to exclude them from the report (for
            example, the report will not show any listings with "Home Improvement" if it was specified as the category).
            <br>Example:
            <code>"reportOptions":{"filterMode":"exclude"}</code>
          </li>
        </ul>
        <p><strong>Note:</strong> <code>categories</code> and <code>subCategories</code> are <strong>exclusive
            operations.</strong> If both a list of categories and subCategories are provided, the returned report will
          only filter for subCategories, and disregard the input from categories.</p>
        <p>This report is only available in these marketplaces:</p>
        <ul>
          <li>
            <p>US</p>
          </li>
          <li>
            <p>Spain</p>
          </li>
          <li>
            <p>UK</p>
          </li>
          <li>
            <p>France</p>
          </li>
          <li>
            <p>Germany</p>
          </li>
          <li>
            <p>Italy</p>
          </li>
          <li>
            <p>India</p>
          </li>
          <li>
            <p>Japan</p>
          </li>
        </ul>
        <p>Can be requested.</p>
      </td>
    </tr>
    <tr class="even">
      <td>
      <p><strong>B2B Product Opportunities - Not yet on Amazon</strong></p>
        <p><strong>reportType</strong> value:<br>
          GET_B2B_PRODUCT_OPPORTUNITIES_NOT_YET_ON_AMAZON</p>
      </td>
      <td><p>Comma-separated report includes a compiled a list of products that are in demand, but are not yet on Amazon.
        Each report offers up to 10,000 recommendations and is refreshed weekly.</p>
        <p>This report accepts the following <strong>reportOptions</strong> values:</p>
        <ul>
          <li><strong>categories</strong> - type: String | (Optional) | Defaults to "".<br>Accepts a semicolon separated list of categories to use to filter the report.  
            <br>Example:
            <code>"reportOptions":{"categories":"Luggage;Wireless;Groceries"}</code>
            <br> The list of categories can be obtained by generating a report without entering a <code>categories</code> parameter.
          </li>
          <li><strong>depersonalized</strong> - type: Boolean | (Optional) | Defaults to <strong><code>false</code></strong>. <br>A value that indicates if you are requesting a depersonalized report. A depersonalized report provides default recommendations that are not customized based on current seller history. <br>Example:
            <code>"reportOptions":{"depersonalized":"true"}</code>
          </li>
          <li><strong>filterMode</strong> - type: "include" or "exclude" | (Optional) | Defaults to <strong><code>include</code></strong>. <br>Use <strong>"include"</strong> to include only the categories or
            subCategories specified in reportOptions, or <strong>"exclude"</strong> to exclude them from the report (for
            example, the report will not show any listings with "Home Improvement" if it was specified as the category).
            <br>Example:
            <code>"reportOptions":{"filterMode":"exclude"}</code>
          </li>
        </ul>
          <p><strong>Note:</strong> <code>subCategories</code> are not available in this report.</p>
        <p>This report is only available in these marketplaces:</p>
        <ul>
          <li>
            <p>US</p>
          </li>
          <li>
            <p>Spain</p>
          </li>
          <li>
            <p>UK</p>
          </li>
          <li>
            <p>France</p>
          </li>
          <li>
            <p>Germany</p>
          </li>
          <li>
            <p>Italy</p>
          </li>
          <li>
            <p>India</p>
          </li>
          <li>
            <p>Japan</p>
          </li>
        </ul>
        <p>Can be requested.</p>
      </td>
    </tr>
  </tbody>
</table>
