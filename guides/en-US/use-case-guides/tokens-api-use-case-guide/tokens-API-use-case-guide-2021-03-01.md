Tokens API Use Case Guide
=========================

Version: 2021-03-01

Contents
=================

- [What is the Tokens API?](#what-is-the-tokens-api)

    - [Terminology](#terminology)

- [Restricted operations](#restricted-operations)

    - [Restricted report types](#restricted-report-types)

- [Tutorial: Get an RDT and call restricted operations](#tutorial-get-an-rdt-and-call-restricted-operations)

    - [Step 1. Get an RDT](#step-1-get-an-rdt)

    - [Step 2. Call restricted operations](#step-2-call-restricted-operations)

    - [Datatypes](#datatypes)

- [Tutorial: Generate a Java SDK for the Tokens API](#tutorial-generate-a-java-sdk-for-the-tokens-api)

- [Tokens API Postman collection](#tokens-api-postman-collection)

What is the Tokens API?
=======================

The Selling Partner API for Tokens (Tokens API) provides a secure way to access a customer's Personally Identifiable Information (PII). You can call the Tokens API to get a Restricted Data Token (RDT) for one or more restricted resources that you specify. The RDT authorizes you to make subsequent calls to the restricted operations that the restricted resources represent. See [Terminology](#terminology).

When you call a restricted operation you include an RDT in the `x-amz-access-token` header. This is in contrast to all other SP-API operations, where you include an LWA access token in the `x-amz-access-token` header. For more information, see [Step 3. Add headers to the URI](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md#step-3-add-headers-to-the-uri).

Terminology
-----------

-   **Restricted Data Token (RDT)**. A short-lived access token that authorizes you to call restricted operations.

-   **Restricted operation.** An operation that returns restricted data, such as Personally Identifiable Information (PII). You need an RDT to call a restricted operation. See [Restricted operations](#restricted-operations).

-   **Restricted resource.** An HTTP method and path that represent a restricted operation.

-   **Restricted report type.** A report type that contains PII. See [Restricted report types](#restricted-report-types)

-   **Specific path.** A path in a restricted resource that contains a specific order ID or shipment ID. For example, `orders/v0/orders/902-3159896-1390916/address`

-   **Generic path.** A path in a restricted resource that does not contain a specific order ID or shipment ID. Instead, it contains the string `{orderId}` or `{shipmentId}`. For example, `orders/v0/orders/{orderId}/address`

Restricted operations
=====================

Restricted operations return customers' Personally Identifiable Information (PII). For more information about calling restricted operations, see [Tutorial: Get an RDT and call restricted operations](#tutorial-get-an-rdt-and-call-restricted-operations).

Here is list of restricted operations, grouped by API:

Orders API:

-   getOrderBuyerInfo

-   getOrderAddress

-   getOrderItemsBuyerInfo

Shipping API:

-   getShipment

Merchant Fulfillment API:

-   getShipment

-   cancelShipment

-   cancelShipmentOld

-   createShipment

Reports API:

-   getReportDocument

    **Notes:**

    -  The getReportDocument operation is considered a restricted operation only when a restricted report is specified. See the list of restricted report types below.

    -  When calling the createRestrictedDataToken operation to get an RDT for the getReportDocument operation, the specified restricted resource can contain only a specific path, not a generic path. For more information, see [Tutorial: Get an RDT and call restricted operations](#tutorial-get-an-rdt-and-call-restricted-operations) and [Terminology](#terminology).

Restricted report types
-----------------------

Restricted report types contain PII. When specifying a restricted report type in a call to the getReportDocument operation, you must pass in an RDT with the call. For more information, see [Tutorial: Get an RDT and call restricted operations](#tutorial-get-an-rdt-and-call-restricted-operations).

Here is a list of restricted report types:

-   GET_AMAZON_FULFILLED_SHIPMENTS_DATA_INVOICING

-   GET_AMAZON_FULFILLED_SHIPMENTS_DATA_TAX

-   GET_FLAT_FILE_ACTIONABLE_ORDER_DATA_SHIPPING

-   GET_FLAT_FILE_ORDER_REPORT_DATA_SHIPPING

-   GET_FLAT_FILE_ORDER_REPORT_DATA_INVOICING

-   GET_FLAT_FILE_ORDER_REPORT_DATA_TAX

-   GET_FLAT_FILE_ORDERS_RECONCILIATION_DATA_TAX

-   GET_FLAT_FILE_ORDERS_RECONCILIATION_DATA_INVOICING

-   GET_FLAT_FILE_ORDERS_RECONCILIATION_DATA_SHIPPING

-   GET_ORDER_REPORT_DATA_INVOICING

-   GET_ORDER_REPORT_DATA_TAX

-   GET_ORDER_REPORT_DATA_SHIPPING

-   GET_EASYSHIP_DOCUMENTS

-   GET_GST_MTR_B2B_CUSTOM

-   GET_VAT_TRANSACTION_DATA

-   SC_VAT_TAX_REPORT

Tutorial: Get an RDT and call restricted operations
===================================================

This tutorial shows you how to use the Tokens API to get a Restricted Data Token (RDT) and then use the RDT to call restricted operations.

**Prerequisites**

To complete this tutorial, you will need:

-   Authorization from the Selling Partner for whom you are making calls. See the [Selling Partner API Developer Guide](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md) for more information.

Step 1. Get an RDT
------------------

Call the createRestrictedDataToken operation to get an RDT.

-   Call the [createRestrictedDataToken](https://github.com/amzn/selling-partner-api-docs/blob/main/references/tokens-api/tokens_2021-03-01.md#createrestricteddatatoken) operation, passing the following parameters:

Body parameters:

<table><thead><tr class="header"><th><strong>Parameter</strong></th><th><strong>Description</strong></th><th><strong>Required</strong></th></tr></thead><tbody><tr class="odd"><td>restrictedResources</td><td><p>Model of a restricted resource. Maximum: 50</p><p>Type: <a href="#restrictedresources">restrictedResources</a></p></td><td>Yes</td></tr></tbody></table>

Request Example:
```
POST https://sellingpartnerapi-na.amazon.com/tokens/2021-03-01/restrictedDataToken
{
	"restrictedResources": [{
		"method": "GET",
		"path": "/orders/v0/orders/902-3159896-1390916/address"
	}, {
		"method": "GET",
		"path": "/orders/v0/orders/{orderId}/buyerInfo"
	}, {
		"method": "GET",
		"path": "/mfn/v0/shipments/{shipmentId}"
	}]
}
```
**Response**

A successful response includes the following:

<table><thead><tr class="header"><th><strong>Name</strong></th><th><strong>Description</strong></th></tr></thead><tbody><tr class="odd"><td>restrictedDataToken</td><td><p>A Restricted Data Token (RDT). This is a short-lived access token that authorizes you to call the restricted operations represented by the restricted resources that you specified. Pass the RDT value in the <code>x-amzn-access-token</code> header when making subsequent calls to the restricted operations.</p><p>Type: string</p></td></tr><tr class="even"><td>expiresIn</td><td><p>The lifetime of the RDT, in seconds.</p><p>Type: integer</p></td></tr></tbody></table>

Response Example:
```
{
	"payload": {
		"restrictedDataToken": "Atz.sprdt|IQEBLjAsAhRmHjNgHpi0U-Dme37rR6CuUpSR",
		"expiresIn": 3600
	}
}
```
You now have an RDT that authorizes you to call the following restricted operations:

-   **getOrderAddress.** You can call the getOrderAddress operation using the specific path from the restricted resource that you specified. For example, `/orders/v0/orders/902-3159896-1390916/address`.

-   **getOrderBuyerInfo.** You can call the getOrderBuyerInfo operation using the generic path from the restricted resource that you specified, replacing `{orderId}` with an order ID from the selling partner. For example, `/orders/v0/orders/058-1233752-8214740/buyerInfo` and `/orders/v0/orders/483-3488972-0896720/buyerInfo`. You can use the RDT for any of the selling partner's order IDs.

-   **getShipment.** You can call the getShipment operation using the generic path from the restricted resource that you specified, replacing `{shipmentId}` with a shipment ID from the selling partner. For example, `/mfn/v0/shipments/6f77095e-9f75-47eb-aaab-a42d5428fa1a`. You can use the RDT for any of the selling partner's shipment IDs.

For more information, see [Terminology](#terminology).

Step 2. Call restricted operations
----------------------------------

Call the restricted operations for which the RDT in [Step 1. Get an RDT](#step-1.-get-an-rdt) authorized you. When calling the restricted operations, include the RDT in the `x-amz-access-token` header. For more information, see [Step 3. Add headers to the URI](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md#step-3-add-headers-to-the-uri).

Request Examples:
```
GET https://sellingpartnerapi-na.amazon.com/orders/v0/orders/orders/v0/orders/902-3159896-1390916/address.

GET https://sellingpartnerapi-na.amazon.com/orders/v0/orders/902-3159896-1390916/buyerInfo

GET https://sellingpartnerapi-na.amazon.com/orders/v0/orders/483-3488972-0896720/buyerInfo

GET https://sellingpartnerapi-na.amazon.com/mfn/v0/shipments/6f77095e-9f75-47eb-aaab-a42d5428fa1a
```
Datatypes
---------

### restrictedResources

<table><thead><tr class="header"><th><strong>Parameter</strong></th><th><strong>Description</strong></th><th><strong>Required</strong></th></tr></thead><tbody><tr class="odd"><td>method</td><td><p>The HTTP method used with the restricted resource.</p><p>Type: <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/tokens-api/tokens_2021-03-01.md#method">Method</a></p></td><td>Yes</td></tr><tr class="even"><td>path</td><td><p>The path from a restricted operation. This could be:</p><ul><li><p>A specific path containing a seller's order ID, shipment ID, or report document ID, for example <code>/orders/v0/orders/902-3159896-1390916/address</code> or <code>/mfn/v0/shipments/6f77095e-9f75-47eb-aaab-a42d5428fa1a</code></p></li><li><p>A generic path that does not contain a seller's order ID or shipment ID, for example <code>/orders/v0/orders/{orderId}/address</code> or <code>/mfn/v0/shipments/{shipmentId}</code></p></li></ul><p>Type: string</p></td><td>Yes</td></tr></tbody></table>

Tutorial: Generate a Java SDK for the Tokens API
================================================

These instructions show you how to generate a Java SDK for the Tokens API using [Swagger Code Generator](https://github.com/swagger-api/swagger-codegen) on a computer running Microsoft Windows. The process is the same for users of other operating systems such as macOS or Linux, with the replacement of Windows-specific semantics (for example, C:\\). See <https://github.com/amzn/selling-partner-api-models> for the Swagger model for the Tokens API.

With this SDK you can make calls to the Tokens API with the following code already set up for you: Login with Amazon token exchange (exchange a refresh token for an access token) and authentication.

**To generate a Java SDK with LWA token exchange and authentication**

1.  Install [Java 8 or newer](https://www.oracle.com/technetwork/java/index.html), [Apache Maven 3.6. or greater](http://maven.apache.org/), and [GNU Wget](https://www.gnu.org/software/wget/wget.html) and make them available in your $PATH.

2.  Go to <https://github.com/amzn/selling-partner-api-models>.

3.  Clone the repository to make a local copy on your computer, if you haven't done so already.

4.  Open a command prompt window and go to a directory where you want to download the Swagger Code Generator.

5.  Download the latest version of the Swagger Code Generator.

    For example:
    ```
    wget https://repo1.maven.org/maven2/io/swagger/swagger-codegen-cli/2.4.13/swagger-codegen-cli-2.4.13.jar -O swagger-codegen-cli.jar
    ```
    **swagger-codegen-cli.jar** downloads to the current directory.
    
    **Note:** You can also download from maven.org by directing your browser here: <https://repo1.maven.org/maven2/io/swagger/swagger-codegen-cli/2.4.13/swagger-codegen-cli-2.4.13.jar>

6.  Copy **swagger-codegen-cli.jar** into a directory structure that makes sense for you. For this example, we'll copy it to C:\SwaggerToCL.

7.  Navigate to **tokens_2021-03-01.json** in the **selling-partner-api-models\models\tokens-api-model** folder of your local copy of the repository.

8.  Copy **tokens_2021-03-01.json** into C:\SwaggerToCL.

9.  Generate the SDK against the templates in the **selling-partner-api-models\clients\sellingpartner-api-aa-java folder** of your local copy of the repository. This folder contains an authorization and authentication library, along with customized templates for the Swagger Code Generator.

    For example:
    ```
    java -jar C:\SwaggerToCL\swagger-codegen-cli.jar generate -i C:\SwaggerToCL\tokens_2021-03-01.json -l java -t [path to selling-partner-api-models\clients\sellingpartner-api-aa-java folder]\resources\swagger-codegen\templates\ -o C:\SwaggerToCL\Tokens_JavaCL
    ```
    The SDK is copied to C:\SwaggerToCL\Tokens_JavaCL

10. Build the AA Library and add it as a dependency of the SDK:
    
    1.  Navigate to the **selling-partner-api-models\clients\sellingpartner-api-aa-java** folder of your local copy of the repository and run mvn package. This generates a folder named "target". In this folder is a JAR file named **sellingpartnerapi-aa-java-1.0-jar-with-dependencies.jar** (or something similar) and all of the required dependencies.
    
    2.  Install the JAR file in your local Maven repository.
    
        For example:
        ```
        mvn install:install-file -Dfile=[path to JAR file in "target" folder] -DgroupId=com.amazon.sellingpartnerapi -DartifactId=sellingpartnerapi-aa-java -Dversion=1.0 -Dpackaging=jar
        ```
        You can find the actual groupId, artifactId, and version values near the top of the **pom.xml** file in the **selling-partner-api-models\clients\sellingpartner-api-aa-java** folder.

11.  Add a dependency on the AA library in the **pom.xml** of the client library:
     
     For example:
     
     ```
     <dependency>
     <groupId>com.amazon.sellingpartnerapi</groupId>
     <artifactId>sellingpartnerapi-aa-java</artifactId>
     <version>1.0</version>
     </dependency>
     ```
12.  Run **mvn package** inside the generated SDK folder.

13.  Download [restricted-data-token-workflow.java](https://github.com/amzn/selling-partner-api-models/commit/63a55cee11ca54caf8242884027a863860abaaf2) and use it to build a class inside the **main/java/sampleCode/** folder of the generated client library.

You can now start testing the workflow for getting an RDT and using it to call one or more restricted operations. Use this code to guide you in building your own applications.

Tokens API Postman collection
=============================

You can use the [Tokens API Postman collection](https://github.com/amzn/selling-partner-api-models/blob/main/clients/postman-collections/tokens-api-sandbox-postman-collection.json) to test the Tokens API in the Selling Partner API sandbox environment. For more information about testing with the sandbox, see [The Selling Partner API sandbox](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md#the-selling-partner-api-sandbox) in the Developer Guide.