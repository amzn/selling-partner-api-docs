令牌 API 用例指南
=========================

版本： 2021-03-01

什么是令牌 API？
=======================

令牌的销售伙伴 API（令牌 API）提供访问客户的个人身份信息 (PII) 的安全方法。您可以调用令牌 API 以获取指定的一个或多个受限资源的受限数据令牌 (RDT)。RDT 授权您对受限资源表示的受限操作进行后续调用。请参阅[术语](#术语)。

当您调用受限操作时，需要在 `x-amz-access-token` 标头中包含一个 RDT。这与所有其他 SP-API 操作形成鲜明对比，对于这些操作，您需要在 `x-amz-access-token` 标头中包含一个 LWA 访问令牌。有关更多信息，请参阅[步骤 3：将标头添加到 URI](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md#step-3-add-headers-to-the-uri)。

术语
-----------

- **受限数据令牌 (RDT)**。一种短期访问令牌，可授权您调用受限操作。

- **受限操作。**返回受限数据（例如个人身份信息 (PII)）的操作。您需要通过 RDT 才能调用受限操作。请参阅[受限操作](#受限操作)。

- **受限资源。**表示受限操作的 HTTP 方法和路径。

- **受限的报告类型。**包含 PII 的报告类型。请参阅[受限的报告类型](#受限的报告类型)

- **具体路径。**受限资源中包含特定订单编号或货件编号的路径。例如，`orders/v0/orders/902-3159896-1390916/address`

- **通用路径。**受限资源中未包含特定订单编号或货件编号的路径。相反，它会包含字符串 `{orderId}` 或 `{shipmentId}`。例如，`orders/v0/orders/{orderId}/address`

受限操作
=====================

受限操作返回客户的个人身份信息 (PII)。有关调用受限操作的详细信息，请参阅[教程： 获取 RDT 并调用受限操作](#教程-获取-rdt-并调用受限操作)。

以下是按 API 分组的受限操作列表：

订单 API：

- ```getOrderBuyerInfo```

- ```getOrderAddress```

- ```getOrderItemsBuyerInfo```

配送 API：

- ```getShipment```

卖家配送 API：

- ```getShipment```

- ```cancelShipment```

- ```cancelShipmentOld```

- ```createShipment```

报告 API：

- ```getReportDocument```

   **备注：**

   - 仅当指定了受限报告时，getReportDocument 操作才被视为受限操作。请参阅下面的受限的报告类型列表。

   - 调用 createRestrictedDataToken 操作为 getReportDocument 操作获取 RDT 时，指定的受限资源只能包含特定路径，而不能包含通用路径。有关更多信息，请参阅[教程： 获取 RDT 并呼叫受限操作](#教程-获取-rdt-并调用受限操作)以及[术语](#术语)。

受限的报告类型
-----------------------

受限的报告类型包含 PII。在对 getReportDocument 操作的调用中指定受限的报告类型时，必须在调用中传入 RDT。有关更多信息，请参阅[教程： 获取 RDT 并调用受限操作](#教程-获取-rdt-并调用受限操作)。

以下是受限的报告类型列表：

- ```GET_AMAZON_FULFILLED_SHIPMENTS_DATA_INVOICING```

- ```GET_AMAZON_FULFILLED_SHIPMENTS_DATA_TAX```

- ```GET_FLAT_FILE_ACTIONABLE_ORDER_DATA_SHIPPING```

- ```GET_FLAT_FILE_ORDER_REPORT_DATA_SHIPPING```

- ```GET_FLAT_FILE_ORDER_REPORT_DATA_INVOICING```

- ```GET_FLAT_FILE_ORDER_REPORT_DATA_TAX```

- ```GET_FLAT_FILE_ORDERS_RECONCILIATION_DATA_TAX```

- ```GET_FLAT_FILE_ORDERS_RECONCILIATION_DATA_INVOICING```

- ```GET_FLAT_FILE_ORDERS_RECONCILIATION_DATA_SHIPPING```

- ```GET_ORDER_REPORT_DATA_INVOICING```

- ```GET_ORDER_REPORT_DATA_TAX```

- ```GET_ORDER_REPORT_DATA_SHIPPING```

- ```GET_EASYSHIP_DOCUMENTS```

- ```GET_GST_MTR_B2B_CUSTOM```

- ```GET_VAT_TRANSACTION_DATA```

- ```SC_VAT_TAX_REPORT```

教程： 获取 RDT 并调用受限操作
===================================================

本教程向您展示如何使用令牌 API 获取受限数据令牌 (RDT)，然后使用 RDT 调用受限操作。

**先决条件**

要完成本教程，您需要：

- 获得您正在向其请求调用的销售伙伴的授权。如需了解更多信息，请参阅 [销售伙伴 API 开发者指南](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md)。

步骤 1.获取 RDT
------------------

调用 createRestrictedDataToken 操作以获取 RDT。

- 调用 [createRestrictedDataToken](https://github.com/amzn/selling-partner-api-docs/blob/main/references/tokens-api/tokens_2021-03-01.md#createrestricteddatatoken) 操作，传递以下参数：

主体参数：

| 参数 | 描述 | 类型 | 必需 |
|-----------|-------------|------|----------|
| restrictedResources | 受限资源的模型。</br> 最大值： 50 | <a href="#restrictedresources">restrictedResources</a> | 是 |

请求示例：
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
**响应**

成功的响应包括以下内容：

| 名称 | 标题 2 | 类型 |
|----------|----------|------|
| restrictedDataToken | 受限数据令牌 (RDT)。这是一种短期访问令牌，可授权您调用由您指定的受限资源表示的受限操作。对受限操作执行后续调用时，在 <code>x-amzn-access-token</code> 标头中传递 RDT 值。 | 字符串 |
| expiresIn | RDT 的生命周期，以秒为单位。 | 整数 |

响应示例：
```
{
	"payload": {
		"restrictedDataToken": "Atz.sprdt|IQEBLjAsAhRmHjNgHpi0U-Dme37rR6CuUpSR",
		"expiresIn": 3600
	}
}
```
您现在有一个 RDT，可授权您调用以下受限操作：

- **getOrderAddress.**您可以使用您指定的受限资源中的特定路径调用 getOrderAddress 操作。例如，`/orders/v0/orders/902-3159896-1390916/address`。

- **getOrderBuyerInfo.**您可以使用您指定的受限资源中的通用路径调用 getOrderBuyerInfo 操作，将 `{orderId}` 替换为销售伙伴的订单编号。例如，`/orders/v0/orders/058-1233752-8214740/buyerInfo` 和 `/orders/v0/orders/483-3488972-0896720/buyerInfo`。您可以将 RDT 用于销售伙伴的任何订单编号。

- **getShipment.**您可以使用您指定的受限资源中的通用路径调用 getShipment 操作，将 `{shipmentId}` 替换为销售伙伴的货件编号。例如，`/mfn/v0/shipments/6f77095e-9f75-47eb-aaab-a42d5428fa1a`。您可以将 RDT 用于销售伙伴的任何货件编号。

有关详细信息，请参阅[术语](#术语)。

步骤 2.调用受限操作
----------------------------------

调用[步骤 1.获取 RDT](#步骤-1获取-rdt) 中的 RDT 授权您执行的受限操作。当您调用受限操作时，在 `x-amz-access-token` 标头中包含该 RDT。有关更多信息，请参阅[步骤 3：将标头添加到 URI](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md#step-3-add-headers-to-the-uri)。

请求示例：
```
GET https://sellingpartnerapi-na.amazon.com/orders/v0/orders/orders/v0/orders/902-3159896-1390916/address.

GET https://sellingpartnerapi-na.amazon.com/orders/v0/orders/902-3159896-1390916/buyerInfo

GET https://sellingpartnerapi-na.amazon.com/orders/v0/orders/483-3488972-0896720/buyerInfo

GET https://sellingpartnerapi-na.amazon.com/mfn/v0/shipments/6f77095e-9f75-47eb-aaab-a42d5428fa1a
```
数据类型
---------

### restrictedResources

<table><thead><tr class="header"><th><strong>参数</strong></th><th><strong>说明</strong></th><th><strong>必填</strong></th></tr></thead><tbody><tr class="odd"><td>方法</td><td><p>与受限资源一起使用的 HTTP 方法。</p><p>类型：<a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/tokens-api/tokens_2021-03-01.md#method">Method</a></p></td><td>Yes</td></tr><tr class="even"><td>path</td><td><p>受限操作的路径。这可能是：</p><ul><li><p>包含卖家订单编号、货件编号或报告文件编号的特定路径，例如 <code>/orders/v0/orders/902-3159896-1390916/address</code> or <code>/mfn/v0/shipments/6f77095e-9f75-47eb-aaab-a42d5428fa1a</code></p></li><li><p>不包含卖家订单编号或货件编号的通用路径，例如<code>/orders/v0/orders/{orderId}/address</code> or <code>/mfn/v0/shipments/{shipmentId}</code></p></li></ul><p>类型：字符串</p></td><td>Yes</td></tr></tbody></table>

教程： 为令牌 API 生成 Java SDK
================================================

这些说明介绍了如何在运行 Microsoft Windows 的计算机上使用 [Swagger 代码生成器](https://github.com/swagger-api/swagger-codegen)为令牌 API 生成 Java SDK。对于其他操作系统（如 macOS 或 Linux）的用户，该过程是相同的，只是替换掉 Windows 特定的语义（例如 C:\）。有关令牌 API 的 Swagger 模型的信息，请参阅<https://github.com/amzn/selling-partner-api-models>。

使用此 SDK，您可以使用已为您设置的以下代码调用令牌 API： “使用亚马逊账户登录”令牌交换（将刷新令牌交换为访问令牌）和身份验证。

**使用 LWA 令牌交换和身份验证生成 Java SDK**

1. 安装 [Java 8 或更新版本](https://www.oracle.com/technetwork/java/index.html)、[Apache Maven 3.6 或更高版本](http://maven.apache.org/)和 [GNU Wget](https://www.gnu.org/software/wget/wget.html)，并使它们在您的 $PATH 中可用。

2. 转到<https://github.com/amzn/selling-partner-api-models>。

3. 克隆存储库以在计算机上创建本地副本（如果尚未执行此操作）。

4. 打开命令提示符窗口，然后转到要下载 Swagger 代码生成器的目录。

5. 下载最新版本的 Swagger 代码生成器。

   例如：
   ```
   wget https://repo1.maven.org/maven2/io/swagger/swagger-codegen-cli/2.4.13/swagger-codegen-cli-2.4.13.jar -O swagger-codegen-cli.jar
   ```
   **swagger-codegen-cli.jar** 下载到当前目录。

   **注意：** 您也可以通过在这里定向您的浏览器，从 maven.org 下载：<https://repo1.maven.org/maven2/io/swagger/swagger-codegen-cli/2.4.13/swagger-codegen-cli-2.4.13.jar>

6. 将 **swagger-codegen-cli.jar** 复制到一个对您有意义的目录结构中。在此示例中，我们将它们复制到 C:\SwaggerToCL。

7. 导航到您的本地存储库副本的 **selling-partner-api-models\models\tokens-api-model** 文件夹中的 **tokens_2021-03-01.json**。

8. 将 **tokens_2021-03-01.json** 复制到 C:\SwaggerToCL。

9. 根据本地存储库副本的 **selling-partner-api-models\\clients\\sellingpartner-api-aa-java** 文件夹中的模板生成 SDK。此文件夹包含授权和身份验证库，以及用于 Swagger 代码生成器的自定义模板。

   例如：
   ```
   java -jar C:\SwaggerToCL\swagger-codegen-cli.jar generate -i C:\SwaggerToCL\tokens_2021-03-01.json -l java -t [path to selling-partner-api-models\clients\sellingpartner-api-aa-java folder]\resources\swagger-codegen\templates\ -o C:\SwaggerToCL\Tokens_JavaCL
   ```
   将 SDK 复制到 C:\SwaggerToCL\Tokens_JavaCL

10. 构建 AA 库并将其添加为 SDK 的依赖项：

1. 导航到本地存储库副本的 **selling-partner-api-models\clients\sellingpartner-api-aa-java** 文件夹并运行 mvn 软件包。这会生成一个名为“target”的文件夹。在这个文件夹中，有一个名为 **sellingpartnerapi-aa-java-1.0-jar-with-dependencies.jar** 的 JAR 文件（或类似文件）和所有必需的依赖项。

2. 在本地 Maven 存储库中安装 JAR 文件。

   例如：
   ```
   mvn install:install-file -Dfile=[path to JAR file in "target" folder] -DgroupId=com.amazon.sellingpartnerapi -DartifactId=sellingpartnerapi-aa-java -Dversion=1.0 -Dpackaging=jar
   ```
   您可以在 **selling-partner-api-models\clients\sellingpartner-api-aa-java** 文件夹中的 **pom.xml** 文件顶部附近找到实际的 groupId、artifactId 和 version 值。

11. 在客户端库的 **pom.xml** 中添加 AA 库的依赖项：

例如：

```
<dependency>
<groupId>com.amazon.sellingpartnerapi</groupId>
<artifactId>sellingpartnerapi-aa-java</artifactId>
<version>1.0</version>
</dependency>
```
12. 在生成的 SDK 文件夹内运行 **mvn 包**。

13. 下载 [restricted-data-token-workflow.java](https://github.com/amzn/selling-partner-api-models/commit/63a55cee11ca54caf8242884027a863860abaaf2)，并使用它在生成的客户端库的 **main/java/sampleCode/** 文件夹内构建一个类。

您现在可以开始测试获取 RDT 的工作流程，然后使用它来调用一项或多项受限操作。使用此代码指导您构建自己的应用程序。

令牌 API Postman 集合
=============================

您可以使用[令牌 API Postman 集合](https://github.com/amzn/selling-partner-api-models/blob/main/clients/postman-collections/tokens-api-sandbox-postman-collection.json)在销售伙伴 API 沙箱环境中测试令牌 API。有关使用沙箱进行测试的更多信息，请参阅开发者指南中的[销售伙伴 API 沙箱](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md#the-selling-partner-api-sandbox)。