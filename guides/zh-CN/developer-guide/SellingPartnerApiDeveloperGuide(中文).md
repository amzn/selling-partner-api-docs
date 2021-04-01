# 目录

- [什么是销售伙伴 API？](#what-is-the-selling-partner-api)
   - [销售伙伴 API HTTP 方法](#selling-partner-api-http-methods)

   - [销售伙伴 API 端点](#selling-partner-api-endpoints)

   - [marketplaceId 值](#marketplaceid-values)

- [全球应用程序](#global-applications)

- [注册为开发者](#registering-as-a-developer)

- [注册您的销售伙伴 API 应用程序](#registering-your-selling-partner-api-application)
- [步骤 1。创建 AWS 账户](#step-1-create-an-aws-account)
   
- [步骤 2。创建 IAM 用户](#step-2-create-an-iam-user)
   
- [步骤 3。创建 IAM 策略](#step-3-create-an-iam-policy)
   
- [步骤 4。创建 IAM 职权](#step-4-create-an-iam-role)
   
- [步骤 5。向您的 IAM 用户添加 AWS 安全令牌服务策略](#step-5-add-an-aws-security-token-service-policy-to-your-iam-user)
   
- [步骤 6。注册您的应用程序](#step-6-register-your-application)
   
- [查看您的开发者信息](#viewing-your-developer-information)

- [授权销售伙伴 API 应用程序](#authorizing-selling-partner-api-applications)

   - [商城应用商店工作流程](#marketplace-appstore-workflow)

      - [步骤 1。卖家从商城应用商店启动授权](#step-1-the-seller-initiates-authorization-from-the-marketplace-appstore)

      - [步骤 2。卖家同意授权您的应用程序](#Step-2-The-seller-consents-to-authorize-your-application)

      - [步骤 3。卖家登录您的网站](#step-3-the-seller-signs-into-your-website)。

      - [步骤 4。亚马逊向您发送授权信息](#step-4-amazon-sends-you-the-authorization-information)

      - [步骤 5。您的应用程序用 LWA 授权码交换 LWA 刷新令牌](#step-5-your-application-exchanges-the-lwa-authorization-code-for-an-lwa-refresh-token)

   - [网站工作流程](#website-workflow)

      - [步骤 0。设置 OAuth 授权 URI](#Step-0-Set-up-your-OAuth-authorization-URIs)

      - [步骤 1。卖家从您的网站启动授权](#Step-1-The-seller-initiates-authorization-from-your-website)

      - [步骤 2。卖家同意授权应用程序](#Step-2-The-seller-consents-to-authorize-the-application)

      - [步骤 3。亚马逊向您发送授权信息](#Step-3-Amazon-sends-you-the-authorization-information)

      - [步骤 4。您的应用程序用 LWA 授权码交换 LWA 刷新令牌](#Step-4-Your-application-exchanges-the-LWA-authorization-code-for-a-LWA-refresh-token)


- [自行授权](#self-authorization-1)

- [通过 LWA 令牌交换和身份验证生成 Java SDK](#generating-a-java-sdk-with-lwa-token-exchange-and-authentication)

- [使用生成的 Java SDK 连接到销售伙伴 API](#connecting-to-the-selling-partner-api-using-a-generated-java-sdk)

   - [步骤 1。配置 AWS 凭证](#step-1-configure-your-aws-credentials)

   - [步骤 2。配置AWS凭证提供者](#step-2-configure-your-AWS-credentials-provider)

   - [步骤 3。配置 LWA 凭证](#step-2-configure-your-lwa-credentials)

   - [步骤 4。创建卖家 API 实例并调用操作](#step-3-create-an-instance-of-the-sellers-api-and-call-an-operation)

- [生成 Java 客户端库](#generating-a-java-client-library)

- [连接到销售伙伴 API](#connecting-to-the-selling-partner-api)

   - [步骤 1。请求“使用亚马逊账户登录”访问令牌](#step-1-request-a-login-with-amazon-access-token)

   - [步骤 2。构建销售伙伴 API URI](#step-2-construct-a-selling-partner-api-uri)

   - [步骤 3。将标头添加到 URI](#step-3-add-headers-to-the-uri)

   - [步骤 4。创建并签署您的请求](#step-4-create-and-sign-your-request)

      - [凭证范围](#credential-scope)

      - [Authorization 标头](#authorization-header)

- [响应格式](#response-format)

- [免授权操作](#grantless-operations-1)

- [在所有请求中包含 User-Agent 标头](#include-a-user-agent-header-in-all-requests)

- [混合销售伙伴 API 应用程序](#hybrid-selling-partner-api-applications)

- [销售伙伴 API 沙箱](#the-selling-partner-api-sandbox)

- [销售伙伴 API 与亚马逊商城网络服务有何不同？](#how-does-the-selling-partner-api-differ-from-amazon-marketplace-web-service)

# 什么是销售伙伴 API？

销售伙伴 API 是一个基于 REST 的 API，亚马逊卖家可以使用这些接口，以编程方式访问他们有关商品、订单、付款、报告等的数据。使用销售伙伴 API 的应用程序可以提高销售效率，减少人力需求并缩短响应客户的时间，从而帮助卖家发展业务。销售伙伴 API 基于亚马逊商城网络服务（亚马逊 MWS）的功能构建，但提供了一些功能，帮助开发者及其卖家合作伙伴提高可用性和安全性。

**主要功能**

使用销售伙伴 API，您可以：

- 设置卖家从商城应用商店详情页面或从您自己的网站启动的 OAuth 授权工作流程。

- 生成可以帮助您进行 LWA 令牌交换和身份验证的 SDK。

- 创建混合应用程序，可同时调用销售伙伴 API 和亚马逊 MWS。

- 通过调用沙箱环境来测试应用程序。

## 销售伙伴 API HTTP 方法

销售伙伴 API 支持这些 HTTP 方法。

| **HTTP 方法** | **描述** |
| --------------- | ------------ |
| GET | 检索资源数据或资源列表。 |
| POST | 将实体提交到指定的资源，通常会引发状态更改或给服务器带来连带影响。 |
| PUT | 将目标资源的所有当前表示形式替换为请求负载。 |

<span id="Selling_Partner_API_endpoints" class="anchor">

## 销售伙伴 API 端点

销售伙伴 API 端点与特定 AWS 区域相关联。AWS 区域非常重要，因为它是凭证范围的一部分，是在调用销售伙伴 API 时计算签名所必需的。有关更多信息，请参阅[凭据范围](#credential-scope)。

<table>
<thead>
<tr class="header">
<th><strong>销售区域</strong></th>
<th><strong>端点</strong></th>
<th><strong>AWS 区域</strong></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>北美（加拿大、美国、墨西哥和巴西商城）</td>
<td>https://sellingpartnerapi-na.amazon.com</td>
<td>us-east-1</td>
</tr>
<tr class="even">
<td>欧洲（西班牙、英国、法国、荷兰、德国、意大利、土耳其、阿联酋和印度商城）</td>
<td>https://sellingpartnerapi-eu.amazon.com</td>
<td>eu-west-1</td>
</tr>
<tr class="odd">
<td>
<p>远东（新加坡、澳大利亚和日本商城）</p>
</td>
<td>https://sellingpartnerapi-fe.amazon.com</td>
<td>us-west-2</td>
</tr>
</tbody>
</table>

## marketplaceId 值

`marketplaceId` 标识了请求的商城。

**北美**

| **国家/地区** | **marketplaceId** | **国家/地区代码** |
| ------------------------ | ----------------- | ---------------- |
| 加拿大 | A2EUQ1WTGCTBG2 | CA |
| 美国 | ATVPDKIKX0DER | US |
| 墨西哥 | A1AM78C64UM0Y8 | MX |
| 巴西 | A2Q3Y263D00KWC | BR |

**欧洲**

| **国家/地区** | **marketplaceId** | **国家/地区代码** |
| -------------------- | ----------------- | ---------------- |
| 西班牙 | A1RKKUPIHCS9HS | ES |
| 英国 | A1F83G8C2ARO7P | GB |
| 法国 | A13V1IB3VIYZZH | FR |
| 荷兰 | A1805IZSGTT6HS | NL |
| 德国 | A1PA6795UKMFR9 | DE |
| 意大利 | APJ6JRA9NG5V4 | IT |
| 土耳其 | A33AVAJ2PDY3EV | TR |
| 阿拉伯联合酋长国 | A2VIGQ35RCS4UG | AE |
| 印度 | A21TJRUUN4KGV | IN |

**远东**

<table>
<thead>
<tr class="header">
<th>
<strong>国家/地区</strong>
</th>
<th>
<strong>marketplaceId</strong>
</th>
<th><strong>国家/地区代码</strong></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>新加坡</td>
<td>A19VAU5U5O7RUS</td>
<td>SG</td>
</tr>
<tr class="even">
<td>澳大利亚</td>
<td>A39IBJ37TRP1C6</td>
<td>AU</td>
</tr>
<tr class="odd">
<td>日本</td>
<td>A1VC38T7YXB528</td>
<td>JP</td>
</tr>
</tbody>
</table>

# 全球应用程序

您只需在您选择的区域和商城以开发者的身份注册一次，即可创建一个销售伙伴 API 应用程序，该应用程序可由任何区域或商城的卖家授权。只要端点与授权您的应用程序的卖家来自同一区域，您只需一组开发者凭证（您的 AWS 访问密钥编码和 AWS 访问密钥）即可调用任何销售伙伴 API 端点。

**重要说明。** 如果您有[混合销售伙伴 API 应用程序](#hybrid-selling-partner-api-applications)，则您对亚马逊商城网络服务（亚马逊 MWS）端点的调用与亚马逊 MWS 应用程序具有相同的限制。也就是说，当您调用亚马逊 MWS 端点时，您必须使用与该端点来自的区域关联的亚马逊 MWS 访问密钥。

有关更多信息，请参阅[销售伙伴 API 端点](#Selling_Partner_API_endpoints)。

# 注册为开发者

您需要注册为销售伙伴 API 开发者，然后才能注册您的销售伙伴 API 应用程序。

**注册为开发者**

1. 使用您想要与您的开发者账户关联的凭据登录卖家平台。

2. 在**应用程序和服务**菜单中，单击**开发应用程序**。

   此时将显示**开发者平台**页面。

3. 按照说明注册成为开发者。

在我们将您注册为开发者后，您可以[注册您的销售伙伴 API 应用程序](#registering-your-selling-partner-api-application)。要查看您的开发者信息，请参阅[查看您的开发者信息](#viewing-your-developer-information)。

# 注册您的销售伙伴 API 应用程序

以下步骤说明了如何创建和配置 IAM 策略和实体，最终目标是创建您在注册应用程序时提供的 IAM 职权。在此工作流程中，您将创建一个 IAM 用户（附加了 [AWS STS](https://docs.aws.amazon.com/STS/latest/APIReference/welcome.html) 策略），该用户拥有的 IAM 职权具有调用销售伙伴 API 的权限。

**步骤**

[步骤 1。创建 AWS 账户](#step-1-create-an-aws-account)

[步骤 2。创建 IAM 用户](#step-2-create-an-iam-user)

[步骤 3。创建 IAM 策略](#step-3-create-an-iam-policy)

[步骤 4。创建 IAM 职权](#step-4-create-an-iam-role)

[步骤 5。向您的 IAM 用户添加 AWS 安全令牌服务策略](#step-5-add-an-aws-security-token-service-policy-to-your-iam-user)

[步骤 6。注册您的应用程序](#step-6-register-your-application)

## 步骤 1。创建 AWS 账户

您需要 AWS 账户，因为销售伙伴 API 安全模型使用 AWS 身份验证凭证。如果您还不是 AWS 客户，则可以创建一个免费的 AWS 账户。有关更多信息，请参阅 [AWS 免费套餐](https://aws.amazon.com/free)。

## 步骤 2。创建 IAM 用户

创建 IAM 用户以获取 AWS 密钥来验证对销售伙伴 API 的调用。我们建议专门为此创建一个新的 IAM 用户。使用 IAM 用户以承担您在[步骤 4：创建 IAM 职权](#step-4-create-an-iam-role)中创建的 IAM 职权。

**创建 IAM 用户**

1. 如果您尚未登录，请登录 AWS 管理控制台并通过 [console.aws.amazon.com/iam](https://console.aws.amazon.com/iam) 打开 IAM 控制台。

2. 在左侧的导航窗格中，单击**用户**，然后单击**添加用户**按钮。

3. 输入新用户的用户名。

4. 选择**编程访问**，然后单击**下一步： 权限**按钮。

5. 在**设置权限**页面上，接受默认值，然后单击**下一步： 标签。** 您将在[创建 IAM 职权](#step-4-create-an-iam-role)时设置权限。

6. 在**添加标签（可选）**页面上，添加可选标签（如果需要），然后单击**下一步： 查看**按钮。

7. 在**查看**页面上，查看您所做的选择。您可以忽略**此用户没有权限**警告。您将在[创建 IAM 职权](#step-4-create-an-iam-role)时设置权限。当您准备好继续时，请单击**创建用户**按钮。

   显示新 IAM 用户的 AWS 访问密钥编码。

8. 单击**显示**可查看 AWS 访问密钥。要保存 AWS 访问密钥，请单击**下载 .csv**，然后将文件保存到安全位置。

   **重要说明：** 这是您查看或下载 AWS 访问密钥的唯一机会，您将需要使用该密钥验证对销售伙伴 API 的调用。将 AWS 访问密钥编码和 AWS 访问密钥保存在安全可靠的位置。**在此步骤之后，您将再次无法访问 AWS 访问密钥。** 如果您丢失了 AWS 访问密钥，则需要创建一个新的 IAM 用户，为其使用自己的一组新密钥。

9. 单击**关闭**。在**用户名**列中，单击您的新 IAM 用户并记录用户 ARN。您将在[步骤 4：创建 IAM 职权](#step-4-create-an-iam-role)中需要它。

有关更多信息，请参阅 AWS 文档中的[在您的 AWS 账户中创建 IAM 用户](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_users_create.html)。

## 步骤 3。创建 IAM 策略

此 IAM 策略定义了对销售伙伴 API 进行调用的权限。您将把它附加到您在[步骤 4：创建 IAM 职权](#step-4-create-an-iam-role)中创建的 IAM 职权。

**创建 IAM 策略**

1. 登录 AWS 管理控制台并通过 [console.aws.amazon.com/iam](https://console.aws.amazon.com/iam) 打开 AWS 控制台。

2. 在左侧的导航窗格中，单击**策略**。

   如果这是您第一次选择**策略**，则会显示**欢迎使用托管策略**页面。单击**开始**。

3. 单击**创建策略**按钮。

4. 单击 **JSON** 选项卡。

5. 将以下代码粘贴到文本框中，替换现有代码，然后单击**查看策略**。
```json
{
  "Version": "2012-10-17",
  "Statement": [
    {
      "Effect": "Allow",
      "Action": "execute-api:Invoke",
      "Resource": "arn:aws:execute-api:*:*:*"
    }
  ]
}

```

6. 在**查看策略**页面上，键入要创建的策略的**名称**和**描述**（可选）。我们建议您将 IAM 策略命名为 `SellingPartnerAPI`。

7. 查看策略**摘要**以了解策略授予的权限，然后单击**创建策略**按钮。

   您的新 IAM 策略将显示在列表中。

有关更多信息，请参阅 AWS 文档中的[创建 IAM 策略](https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies_create.html)。

## 步骤 4。创建 IAM 职权

创建 IAM 职权，该职权信任您在[步骤 2：创建 IAM 用户](#step-4-create-an-iam-role)中创建的 IAM 用户并具有调用销售伙伴 API 的权限。

**创建 IAM 职权**

1. 如果您尚未登录，请登录 AWS 管理控制台并通过 [console.aws.amazon.com/iam](https://console.aws.amazon.com/iam) 打开 IAM 控制台。

2. 在左侧的导航窗格中，单击**职权，**然后单击**创建职权**按钮。

3. 在**创建职权**页面上，单击**其他 AWS 账户**。

4. 在**账户 ID** 框中，输入您在[步骤 2：创建 IAM 用户](#step-4-create-an-iam-role)中创建 IAM 用户时所使用的 AWS 账户的账户编码，然后单击**下一步： 权限**按钮。

5. 在**附加权限策略**页面上的**策略名称**下，选择您在[步骤 3：创建 IAM 策略](#step-2-create-an-iam-user)中创建的策略，然后单击**下一步： 标签。**

   **提示：** 单击**筛选策略** ，然后选择**受管客户**以缩小选择范围。

6. 在**添加标签（可选）**页面上，添加可选标签（如果需要），然后单击**下一步： 查看**按钮。

7. 在**创建职权**页面上，在**职权名称**框中输入职权名称，在**职权描述**框中输入可选职权描述，然后单击**创建职权**按钮。

8. 在**职权名称**下，单击新职权的名称。

   将显示**摘要**页面

9. 保存您的职权 ARN。您将需要它：

   1. 当您[注册您的应用程序](#step-6-register-your-application)时。

   2. 在[步骤 5 中。您的应用程序用 LWA 授权码交换 LWA 刷新令牌](#step-5-your-application-exchanges-the-lwa-authorization-code-for-an-lwa-refresh-token)。

有关更多信息，请参阅 AWS 文档中的[创建职权以向 IAM 用户委派权限](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_create_for-user.html)。

## 步骤 5。向 IAM 用户添加 AWS 安全令牌服务策略

向 IAM 用户添加 [AWS 安全令牌服务 (AWS STS)](https://docs.aws.amazon.com/STS/latest/APIReference/welcome.html) 策略后，您可以请求临时 AWS 访问密钥，您可以使用这些密钥对销售伙伴 API 的请求进行身份验证。这些证书在一段时间后过期，有助于您控制对 AWS 资源的访问。

1. 如果您尚未登录，请登录 AWS 管理控制台并通过 [console.aws.amazon.com/iam](https://console.aws.amazon.com/iam) 打开 IAM 控制台。

2. 在左侧的导航窗格中，单击**用户**，然后单击您在[步骤 2.创建 IAM 用户](#step-4-create-an-iam-role)中创建的用户。

3. 在左侧的导航窗格中，单击**用户**，然后单击要向其添加 AWS STS 策略的用户。在此工作流程中，选择您在[步骤 2：创建 IAM 用户](#step-4-create-an-iam-role)中创建的用户。您可以为其他使用案例选择不同的 IAM 用户。

4. 在**权限**选项卡上，单击**添加内嵌策略**。

5. 在**创建策略**页面上，单击**选择服务**。

6. 单击 **STS** 服务。

   **提示。** 在搜索框中键入 **STS** 以缩小选择范围。

7. 单击**写入**旁边的箭头将其展开。

8. 选择**承担职权**。

9. 单击**资源**旁边的箭头将其展开，然后单击**添加** **ARN**。

10. 在**添加 ARN** 对话框中，输入[步骤 4：创建 IAM 职权](#step-4-create-an-iam-role)中的职权 ARN（在**指定职权的 ARN** 框中输入），单击**添加**，然后单击**查看策略**按钮。

11. 在**查看策略**页面上，在**名称**框中输入策略的名称。查看您所做的选择。如果您已准备好继续，请单击**创建策略**按钮。

## 步骤 6。注册您的应用程序

在开发者平台注册您的应用程序。

**注册您的应用程序**

1. 使用您用于[注册成为开发者](#registering-as-a-developer)的凭据登录卖家平台。

2. 在**应用程序和服务**菜单中，单击**开发应用程序**。

   此时将显示**开发者平台**页面。

3. 按照说明注册您的应用程序。

# 查看您的开发者信息

[注册销售伙伴 API 应用程序](#registering-as-a-developer)后，您可以登录开发者平台以查看您的开发者信息。

**查看您的开发者信息**

1. 使用您用于[注册成为开发者](#registering-as-a-developer)的凭据登录卖家平台。

2. 在**应用程序和服务**菜单中，单击**开发应用程序**。

   此时将显示**开发者平台**页面，其中显示与您的应用程序关联的 IAM ARN。

3. 单击所需应用程序的 **LWA 凭据**下的**查看**。

   此时将显示该应用程序的 LWA 客户端编码和客户端密钥。您将需要这些凭证来请求 LWA 访问令牌。有关更多信息，请参阅[步骤 1：请求“使用亚马逊账户登录”访问令牌](#step-1-request-a-login-with-amazon-access-token)。

# 授权销售伙伴 API 应用程序

销售伙伴 API 的授权模式基于[使用亚马逊账户登录](https://developer.amazon.com/docs/login-with-amazon/documentation-overview.html)，这是亚马逊的 OAuth 2.0 实施。在此模式中，销售伙伴通过与亚马逊和您的网站显示的页面互动来授权您的应用程序。销售伙伴执行的操作会触发您的网站或亚马逊的响应。每次销售伙伴执行操作时，其浏览器会作为用户代理在您的网站和亚马逊之间传递参数。要实施 OAuth 授权，您必须将您的网站配置为：(1) 接受并处理亚马逊传递给它的参数，并且 (2) 重定向销售伙伴的浏览器并将参数传递给亚马逊。

销售伙伴可以使用下列其中一个工作流程授权您的应用程序：

- [商城应用商店工作流程](#marketplace-appstore-workflow)。从商城应用商店详情页面启动的 OAuth 授权工作流程。

- [网站工作流程](#website-workflow)。从您自己的网站启动的 OAuth 授权工作流程。

## 免授权操作

免授权操作是您可以在没有销售伙伴明确授权的情况下调用的操作。如果您调用其他销售伙伴 API 操作，必须要接收和交换 LWA 授权代码并刷新令牌才能获取 LWA 访问令牌，而使用此授权模式时不需要这样做。相反，您只需调用一次 LWA 授权服务器，即可获得 LWA 访问令牌。

## 自行授权

如果您正在为自己的销售账户开发应用程序，您可以自行授权。有关更多信息，请参阅[自行授权](#self-authorization-1)。

### 从亚马逊商城网络服务迁移授权

如果销售伙伴授权您代表他们调用亚马逊商城网络服务，您可以使用授权 API 将该授权迁移到混合销售伙伴 API 应用程序。这样，您就无需再次请求销售伙伴授权。有关更多信息，请参阅《授权 API 用户指南》。

## 商城应用商店工作流程

商城应用商店工作流程是从商城应用商店详情页面启动的 OAuth 授权工作流程。当您在商城应用商店中发布销售伙伴 API 应用程序时，卖家可以通过单击详情页面上的**立即授权**按钮来授权您的应用程序。

本主题包括商城应用商店工作流程步骤以及有关测试工作流程的信息。

**测试商城应用商店工作流程**

在创建生产商城应用商店工作流程之前，必须创建可以在草稿状态下授权应用程序的测试工作流程。您的测试工作流程与最终生产工作流程不完全相同。您仍然可以进行测试，以确保您的应用程序可以与亚马逊交换参数并接收授权信息。

以下是测试工作流程与生产工作流程的不同之处：

- 测试工作流程不是从商城应用商店详情页面开始，而是从卖家直接导航到应用程序的 OAuth 授权 URI 开始。您可以与合作的可信卖家配合进行测试，也可以使用您自己的销售账户凭证自行测试工作流程。OAuth 授权 URI 必须包含 `version=beta` 参数，指示工作流程授权处于草稿状态的应用程序。当卖家导航到 OAuth 授权 URI 时，工作流程将从 [步骤 2：卖家同意授权您的应用程序](#step-2-the-seller-consents-to-authorize-your-application)继续。

   **注意：** 如果您有多个区域 OAuth 授权 URI，请务必为卖家提供与他们的销售区域相对应的 OAuth 授权 URI。

- 您的应用程序将 `version=beta`参数添加到亚马逊回调 URI中 [步骤 3：卖家登录您的网站](#step-3-the-seller-signs-into-your-website)。这将生成可授权处于“草稿”状态的应用程序的工作流程。

完成工作流程测试后，请对其进行更新，使其不再将 `version=beta`参数添加到亚马逊回调 URI中（[步骤 3：卖家登录您的网站](#step-3-the-seller-signs-into-your-website)）。这使其成为一个生产工作流程。现在，任何卖家都可以从商城应用商店的详情页面开始授权您已发布的应用程序。

生产工作流程从[步骤 1：卖家从商城应用商店启动授权](#step-1-the-seller-initiates-authorization-from-the-marketplace-appstore)开始。

**步骤**

[步骤 1。卖家从商城应用商店启动授权](#Step-1-The-seller-initiates-authorization-from-the-Marketplace-Appstore)

[步骤 2。卖家同意授权您的应用程序](#Step-2-The-seller-consents-to-authorize-your-application)

[步骤 3。卖家登录您的网站](#Step-3-The-seller-signs-into-your-website)

[步骤 4。亚马逊向您发送授权信息](#Step-4-Amazon-sends-you-the-authorization-information)

[步骤 5。您的应用程序用 LWA 授权码交换 LWA 刷新令牌](#Step-5-Your-application-exchanges-the-LWA-authorization-code-for-an-LWA-refresh-token)

### 步骤 1。卖家从商城应用商店启动授权

1. 卖家登录卖家平台并进入商城应用商店。

2. 卖家转到应用程序的详情页面，然后单击**立即授权**按钮。此时将显示您的应用程序的同意页面。

### 步骤 2。卖家同意授权您的应用程序

1. 卖家查看同意页面，查看并接受您的应用程序所请求的数据访问，然后单击**立即登录 \[您的应用程序名称\]** 按钮继续。卖家可以单击**取消**按钮，在不授权的情况下退出。

2. 亚马逊将您的登录 URI（您在应用程序注册时提供）加载到浏览器中，并添加以下查询参数：

| **参数** | **描述** |
| ------------------------- | ------------------  |
| **amazon\_callback\_uri** | 用于将浏览器重定向到亚马逊的 URI。 |
| **amazon\_state** | 亚马逊生成的状态值，用于防范跨站点请求伪造攻击。 |
| **selling\_partner\_id** | 授权您的应用程序的卖家的卖家编号。 |

**注意：**如果这是测试工作流程（卖家通过导航到您的 OAuth 授权 URI 开始），亚马逊将包含 `version=beta` 参数。如果这是一个生产工作流程（卖家从商城应用商店开始），亚马逊不包含该参数。

例如：
```
https://d2yzyfnnpjylxu.cloudfront.net/index.html?amazon_callback_uri=https://amazon.com/apps/authorize/confirm/amzn1.sellerapps.app.2eca283f-9f5a-4d13-b16c-474EXAMPLE57&amazon_state=amazonstateexample&selling_partner_id=A3FHEXAMPLEYWS
```
将显示您网站的登录页面。

### 步骤 3。卖家登录您的网站

1. 卖家登录您的网站。如果卖家还没有账户，他们要完成注册流程。

2. 您的应用程序将亚马逊回调 URI（在上一步中由亚马逊传递）加载到浏览器中，并添加以下参数：

<table>
<thead>
<tr class="header">
<th><strong>参数</strong></th>
<th><strong>描述</strong></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td><strong>redirect_uri</strong></td>
<td>用于将浏览器重定向到您的应用程序的 URI。</td>
</tr>
<tr class="even">
<td><strong>amazon_state</strong></td>
<td>亚马逊在上一步中传递的 <code>amazon_state</code> 值。</td>
</tr>
<tr class="odd">
<td><strong>state</strong></td>
<td><p>您的应用程序生成的状态值。您的应用程序使用此值来维护此请求和响应之间的状态，从而帮助防范跨站点请求伪造攻击。</p>
<p>重要说明： 由于 OAuth 信息是通过 URI 查询参数传递的，我们强烈建议您执行以下操作： (1) 确保状态令牌对您的用户属于短期令牌，并且具有可验证的唯一性，以及 (2) 设置 <code>Referrer-Policy: no-referrer HTTP</code> 标头，防止将敏感信息泄露到您的网站链接到的网站。有关跨站点请求伪造和计算 state 参数的更多信息，请参阅“使用亚马逊账户登录”文档中的<a href="https://developer.amazon.com/docs/login-with-amazon/cross-site-request-forgery.html">跨站点请求伪造</a>。</p></td>
</tr>
</tbody>
</table>

**注意：**如果包含 `Version=beta` 参数，则工作流程将授权处于草稿状态的应用程序。如果您不包含该参数，则工作流程将授权在商城应用商店中发布的应用程序。

例如：
```
https://amazon.com/apps/authorize/confirm/amzn1.sellerapps.app.2eca283f-9f5a-4d13-b16c-474EXAMPLE57?redirect_uri=https://d2yzyfnnpjylxu.cloudfront.net/landing.html&amazon_state=amazonstateexample&state=-37131022&version=beta
```
或者
```
https://amazon.com/apps/authorize/confirm/amzn1.sellerapps.app.2eca283f-9f5a-4d13-b16c-474EXAMPLE57?redirect_uri=https://d2yzyfnnpjylxu.cloudfront.net/landing.html&amazon_state=amazonstateexample&state=-37131022
```
### 步骤 4。亚马逊向您发送授权信息

卖家平台会短时间显示一个页面，表明亚马逊正在授权您访问卖家数据。显示该页面时，将执行以下操作：

1. 亚马逊将您的重定向 URI 加载到浏览器中，并添加以下查询参数：

| **参数** | **描述** |
| ------------------------ | -----------------------|
| **state** | 您在上一步中传递的状态值。 |
| **selling\_partner\_id** | 授权您的应用程序的卖家的卖家编号。 |
| **mws\_auth\_token** | 您在为调用亚马逊商城网络服务创建查询字符串时使用的 **MWSAuthToken** 值。只有当卖家授权混合销售伙伴 API 应用程序时，才会传递 mws\_auth\_token 参数。有关更多信息，请参阅[混合销售伙伴 API 应用程序](#hybrid-selling-partner-api-applications)。 |
| **spapi\_oauth\_code** | 您用来交换 LWA 刷新令牌的“使用亚马逊账户登录”(LWA) 授权码。有关更多信息，请参阅[步骤 5：您的](#step-5-your-application-exchanges-the-lwa-authorization-code-for-an-lwa-refresh-token) [应用程序用 LWA 授权码交换 LWA](#step-5-your-application-exchanges-the-lwa-authorization-code-for-an-lwa-refresh-token) [刷新令牌](#step-5-your-application-exchanges-the-lwa-authorization-code-for-an-lwa-refresh-token)。 |

例如：
```
https://client-example.com?state=state-example&mws_auth_token=mwsauthtokenexample&selling_partner_id=sellingpartneridexample&spapi_oauth_code=spapioauthcodeexample
```
2. 您的应用程序可以验证 state 值。

3. 您的应用程序会保存 selling\_partner\_id、mws\_auth\_token（如果传递）和 spapi\_oauth\_code 值。

4. 显示网站的登录页面。

### 步骤 5。您的应用程序用 LWA 授权码交换 LWA 刷新令牌

适用于 JavaScript 的“使用亚马逊账户登录”SDK 可以帮助您用 LWA 授权码交换 LWA 刷新令牌。有关更多信息，请参阅《使用亚马逊账户登录》文档。

- [添加适用于 JavaScript 的“使用亚马逊账户登录”SDK](https://developer.amazon.com/docs/login-with-amazon/install-sdk-javascript.html)

- [授权码授权](https://developer.amazon.com/docs/login-with-amazon/authorization-code-grant.html)

**用 LWA 授权码交换 LWA 刷新令牌**

1. 您的应用程序调用“使用亚马逊账户登录 (LWA)”授权服务器 (`https://api.amazon.com/auth/o2/token`)，用 LWA 授权码交换 LWA 刷新令牌。调用必须包含以下查询参数。

| **参数** | **描述** |
| ------------------ | --------- |
| **grant\_type** | 请求的访问授权类型。必须是 *authorization\_code*。 |
| **code** | 您在[步骤 4：亚马逊向您发送授权信息](#step-4-amazon-sends-you-the-authorization-information)中收到的 LWA 授权码。 |
| **redirect\_uri** | 您的应用程序的重定向 URI。 |
| **client\_id** | 您的 LWA 凭证的一部分。要获得此值，请参阅[查看您的开发者信息](#viewing-your-developer-information)。 |
| **client\_secret** | 您的 LWA 凭证的一部分。要获得此值，请参阅[查看您的开发者信息](#viewing-your-developer-information)。 |

例如：
```http
POST /auth/o2/token HTTP/l.l
Host: api.amazon.com
Content-Type: application/x-www-form-urlencoded;charset=UTF-8
grant_type=authorization_code&code=SplxlOexamplebYS6WxSbIA&client_id=foodev&client_secret=Y76SDl2F
```
2. LWA 授权服务器返回 LWA 刷新令牌。响应采用 JSON 格式并包含以下元素。

| **参数** | **描述** |
| ------------------ | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ |
| **access\_token** | 授权您的应用程序代表卖家采取某些操作的令牌。请参阅[连接到销售伙伴 API](#connecting-to-the-selling-partner-api)。 |
| **token\_type** | 返回的令牌类型。应该是 bearer。 |
| **expires\_in** | 访问令牌失效之前的秒数。 |
| **refresh\_token** | 可以交换为新访问令牌的长期令牌。请参阅[连接到销售伙伴 API](#connecting-to-the-selling-partner-api)。 |
```http
HTTP/l.l 200 OK
Content-Type: application/json;
charset UTF-8
Cache - Control: no-store
Pragma: no-cache
{
  "access_token": "Atza|IQEBLjAsAexampleHpi0U-Dme37rR6CuUpSR",
  "token_type": "bearer",
  "expires_in": 3600,
  "refresh_token": "Atzr|IQEBLzAtAhexamplewVz2Nn6f2y-tpJX2DeX"
}
```
3. 您的应用程序保存 refresh\_token 值。

4. 浏览器向卖家显示一个页面，指示使用应用程序的后续步骤。

LWA 刷新令牌是您交换 LWA 访问令牌的长期令牌，它必须包含在销售伙伴 API 的每个请求中。发出访问令牌后，它的有效期为一小时。相同的访问令牌可用于多个 API 调用，直到它过期。请参阅[连接到销售伙伴 API](#connecting-to-the-selling-partner-api)。

您的应用程序现在已获得授权，可以代表卖家调用销售伙伴 API。

### 适用于混合销售伙伴 API 应用程序

如果在[步骤 4：亚马逊向您发送授权信息](#step-4-amazon-sends-you-the-authorization-information)中返回了 MWS 授权令牌，您的应用程序也有权代表卖家调用亚马逊商城网络服务。有关更多信息，请参阅[混合销售伙伴 API 应用程序](#hybrid-selling-partner-api-applications)。

## 网站工作流程

网站工作流是从您自己的网站启动的 OAuth 授权工作流程。卖家登录您的网站，然后单击您配置的用以启动授权的“授权”按钮。有关更多信息，请参阅[步骤 0：设置 OAuth 授权 URI](#step-0-set-up-your-oauth-authorization-uris)。

本主题包括“网站”工作流程步骤以及有关测试工作流程的信息。

**测试网站工作流程**

在创建生产网站工作流程之前，必须创建可以在草稿状态下授权应用程序的测试工作流程。这样，您就可以进行测试，以确保您的应用程序可以与亚马逊交换参数并接收授权信息。

以下是测试工作流程与生产工作流程的不同之处：

- 您的应用程序将 `version=beta` 参数添加到[步骤 1：卖家从您的网站启动授权](#step-1-the-seller-initiates-authorization-from-your-website)中的 OAuth 授权 URI。这将生成可授权处于“草稿”状态的应用程序的工作流程。

完成工作流程测试后，请更新它，使其不再将 `version=beta` 参数添加到[步骤 1：卖家从您的网站启动授权](#step-1-the-seller-initiates-authorization-from-your-website)中的 OAuth 授权 URI。这使其成为一个生产工作流程。现在，任何卖家都可以从自己的网站开始授权您已发布的应用程序。

生产工作流程从[步骤 0：设置 OAuth 授权 URI ](#step-0-set-up-your-oauth-authorization-uris)开始。

**步骤**

[步骤 0。设置 OAuth 授权 URI](#Step-0-Set-up-your-OAuth-authorization-URIs)

[步骤 1。卖家从您的网站启动授权](#Step-1-The-seller-initiates-authorization-from-your-website)

[步骤 2。卖家同意授权应用程序](#Step-2-The-seller-consents-to-authorize-the-application)

[步骤 3。亚马逊向您发送授权信息](#Step-3-Amazon-sends-you-the-authorization-information)

[步骤 4。您的应用程序用 LWA 授权码交换 LWA 刷新令牌](#Step-4-Your-application-exchanges-the-LWA-authorization-code-for-a-LWA-refresh-token)

### 步骤 0。设置 OAuth 授权 URI

在应用程序网站上设置一个“授权”按钮（或类似的内容），卖家可以单击该按钮启动应用程序的授权。当卖家单击该按钮时，您的网站将 OAuth 授权 URI 加载到浏览器中，卖家将被重定向到卖家平台登录页面。[注册您的应用程序](#step-6-register-your-application)时，您将获得 OAuth 授权 URI。

**多个 OAuth 授权 URI**

如果您拥有多个区域的 OAuth 授权 URI，请务必设置“授权”按钮，以便卖家重定向到其所在区域的卖家平台登录页面。设置“授权”按钮是一次性任务。

### 步骤 1。卖家从您的网站启动授权

1. 卖家登录您的网站。如果卖家还没有账户，他们要完成注册流程。

2. 卖家单击您在[步骤 0：设置 OAuth 授权 URI ](#step-0-set-up-your-oauth-authorization-uris)开始。如果您有多个区域“授权”按钮，请确保卖家被定向到与其所在销售区域相对应的按钮。

3. 您的应用程序将 OAuth 授权 URI 加载到浏览器中，并添加以下查询参数：

<table>
<thead>
<tr class="header">
<th><strong>参数</strong></th>
<th><strong>描述</strong></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td><strong>state</strong></td>
<td><p>您的应用程序生成的状态值。您的应用程序使用此值来维护此请求和响应之间的状态，从而帮助防范跨站点请求伪造攻击。</p>
<p>重要说明： 由于 OAuth 信息是通过 URL 查询参数传递的，我们强烈建议您执行以下操作： (1) 确保状态令牌对您的用户属于短期令牌，并且具有可验证的唯一性，以及 (2) 设置 Referrer-Policy: no-referrer HTTP 标头，防止将敏感信息泄露到您的网站链接到的网站。有关跨站点请求伪造和计算 state 参数的更多信息，请参阅“使用亚马逊账户登录”文档中的<a href="https://developer.amazon.com/docs/login-with-amazon/cross-site-request-forgery.html">跨站点请求伪造</a>。</p></td>
</tr>
</tbody>
</table>

**注意：**如果包含 `Version=beta` 参数，则工作流程将授权处于草稿状态的应用程序。如果您不包含该参数，则工作流程将授权在商城应用商店中发布的应用程序。

例如：
```
https://sellercentral.amazon.com/apps/authorize/consent?application_id=appidexample&state=stateexample&version=beta
```
或者
```
https://sellercentral.amazon.com/apps/authorize/consent?application_id=appidexample&state=stateexample
```
卖家到达卖家平台的登录页面。

### 步骤 2。卖家同意授权应用程序

1. 卖家登录卖家平台。此时将显示同意页面。

2. 卖家查看同意页面，查看您的应用程序所请求的数据访问权限，然后单击**确认**按钮继续。卖家可以单击**取消**按钮，在不授权的情况下退出。

### 步骤 3。亚马逊向您发送授权信息

卖家平台会短时间显示一个页面，表明亚马逊正在授权您访问卖家数据。显示该页面时，将执行以下操作：

1. 亚马逊将您的重定向 URI 加载到浏览器中，并添加以下查询参数：

| **参数** | **描述** |
| ------------------------ | ---------------------- |
| **state** | [步骤 1：卖家从](#step-1-the-seller-initiates-authorization-from-your-website) [您的网站启动授权](#step-1-the-seller-initiates-authorization-from-your-website)中的 state 值。 |
| **selling\_partner\_id** | 授权您的应用程序的卖家的卖家编号。 |
| **mws\_auth\_token** | 您在为调用亚马逊商城网络服务创建查询字符串时使用的 **MWSAuthToken** 值。只有当卖家授权混合销售伙伴 API 应用程序时，才会传递 mws\_auth\_token 参数。有关更多信息，请参阅[混合销售伙伴 API 应用程序](#hybrid-selling-partner-api-applications)。 |
| **spapi\_oauth\_code** | 您用来交换 LWA 刷新令牌的“使用亚马逊账户登录”(LWA) 授权码。有关更多信息，请参阅[步骤 4：您的[ ](#step-4-your-application-exchanges-the-lwa-authorization-code-for-a-lwa-refresh-token)应用程序用 LWA 授权码交换 LWA 刷新](#step-4-your-application-exchanges-the-lwa-authorization-code-for-a-lwa-refresh-token) [令牌](#step-4-your-application-exchanges-the-lwa-authorization-code-for-a-lwa-refresh-token)。 |

例如：
````
https://client-example.com?state=state-example&mws_auth_token=mwsauthtokenexample&selling_partner_id=sellingpartneridexample&spapi_oauth_code=spapioauthcodeexample
````
2. 您的应用程序可以验证 state 值。

3. 您的应用程序会保存 selling\_partner\_id、mws\_auth\_token（如果传递）和 spapi\_oauth\_code 值。

4. 显示网站的登录页面。

### 步骤 4。您的应用程序用 LWA 授权码交换 LWA 刷新令牌

适用于 JavaScript 的“使用亚马逊账户登录”SDK 可以帮助您用 LWA 授权码交换 LWA 刷新令牌。有关更多信息，请参阅《使用亚马逊账户登录》文档。

- [添加适用于 JavaScript 的“使用亚马逊账户登录”SDK](https://developer.amazon.com/docs/login-with-amazon/install-sdk-javascript.html)

- [授权码授权](https://developer.amazon.com/docs/login-with-amazon/authorization-code-grant.html)

**用 LWA 授权码交换 LWA 刷新令牌**

1. 您的应用程序调用“使用亚马逊账户登录 (LWA)”授权服务器 (https://api.amazon.com/auth/o2/token)，用 LWA 授权码交换 LWA 刷新令牌。调用必须包含以下查询参数。

<table>
<thead>
<tr class="header">
<th><strong>参数</strong>
</th>
<th><strong>描述</strong></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td><strong>grant_type</strong></td>
<td>请求的访问授权类型。必须是 <em>authorization_code</em>。</td>
</tr>
<tr class="even">
<td><strong>code</strong></td>
<td>您在<a href="#step-3-amazon-sends-you-the-authorization-information">步骤 3：亚马逊向您发送授权</a> <a href="#step-3-amazon-sends-you-the-authorization-information">信息</a>中收到的 LWA 授权码。</td>
</tr>
<tr class="odd">
<td><strong>redirect_uri</strong></td>
<td>您的应用程序的重定向 URI。</td>
</tr>
<tr class="even">
<td><strong>client_id</strong></td>
<td>您的 LWA 凭证的一部分。要获得此值，请参阅<a href="#viewing-your-developer-information">查看您的开发者信息</a>。</td>
</tr>
<tr class="odd">
<td><strong>client_secret</strong></td>
<td>您的 LWA 凭证的一部分。要获得此值，请参阅<a href="#viewing-your-developer-information">查看您的开发者信息</a>。</td>
</tr>
</tbody>
</table>

例如：
```http
POST /auth/o2/token HTTP/l.l
Host: api.amazon.com
Content-Type: application/x-www-form-urlencoded;charset=UTF-8
grant_type=authorization_code&code=SplxlOexamplebYS6WxSbIA&client_id=foodev&client_secret=Y76SDl2F
```
2. LWA 授权服务器返回 LWA 刷新令牌。响应采用 JSON 格式并包含以下元素。

| **参数** | **描述** |
| ---------------| -------- |
| **access\_token** | 授权您的应用程序代表卖家采取某些操作的令牌。请参阅[连接到销售伙伴 API](#connecting-to-the-selling-partner-api)。 |
| **token\_type** | 返回的令牌类型。应该是 bearer。 |
| **expires\_in** | 访问令牌失效之前的秒数。 |
| **refresh\_token** | 可以交换为新访问令牌的长期令牌。请参阅[连接到销售伙伴 API](#connecting-to-the-selling-partner-api)。 |
```http
HTTP/l.l 200 OK
Content-Type: application/json;
charset UTF-8
Cache-Control: no-store
Pragma: no-cache
{
  "access_token":"Atza|IQEBLjAsAexampleHpi0U-Dme37rR6CuUpSR",
  "token_type":"bearer",
  "expires_in":3600,
  "refresh_token":"Atzr|IQEBLzAtAhexamplewVz2Nn6f2y-tpJX2DeX"
}
```
3. 您的应用程序保存 refresh\_token 值。

4. 浏览器向卖家显示一个页面，指示使用应用程序的后续步骤。

LWA 刷新令牌是您交换 LWA 访问令牌的长期令牌，它必须包含在销售伙伴 API 的每个请求中。发出访问令牌后，它的有效期为一小时。相同的访问令牌可用于多个 API 调用，直到它过期。请参阅[连接到销售伙伴 API](#connecting-to-the-selling-partner-api)。

您的应用程序现在已获得授权，可以代表卖家调用销售伙伴 API。

**适用于混合销售伙伴 API 应用程序**

如果在[步骤 3：亚马逊向您发送授权信息](#step-3-amazon-sends-you-the-authorization-information)中返回了 MWS 授权令牌，您的应用程序也有权代表卖家调用亚马逊商城网络服务。有关更多信息，请参阅[混合销售伙伴 API 应用程序](#hybrid-selling-partner-api-applications)。

# 自行授权

您可以在开发者平台中自行授权您的应用程序。在这样做之前，您必须[注册您的销售伙伴 API 应用程序](#registering-your-selling-partner-api-application)。

要实施完整的 OAuth 授权工作流程，请参阅[授权销售伙伴 API 应用程序](#authorizing-selling-partner-api-applications)。

1. **要自行授权您的应用程序**，请使用您用于[注册成为开发者](#registering-as-a-developer)的凭据登录卖家平台。

2. 在**应用程序和服务**菜单中，单击**开发应用程序**。

   此时将显示**开发者平台**页面。

3. 单击要授权的应用程序旁边的**编辑** \> **授权**。

   将显示一个页面，其中包含**生成刷新令牌**按钮。

4. 单击**生成刷新令牌**。

   将显示“使用亚马逊账户登录”(LWA) 刷新令牌。如果您的销售账户与其他区域的账户关联，您将收到每个区域的单独刷新令牌。您的应用程序现已有权访问您的销售账户。

   **重要说明：** 单击**生成刷新令牌**一次以获取刷新令牌，然后将其保存以调用销售伙伴 API。如果您多次单击**生成刷新令牌**，则每次都会获得一个新的刷新令牌，从而使之前的刷新令牌失效。

刷新令牌是一种长期令牌，可用来交换短期访问令牌。对销售伙伴 API 的每个请求都必须包含访问令牌。发出访问令牌后，它的有效期为一小时。相同的访问令牌可用于多个 API 调用，直到它过期。有关更多信息，请参阅[步骤 1：请求“使用亚马逊账户登录”访问令牌](#step-1-request-a-login-with-amazon-access-token)。

# 通过 LWA 令牌交换和身份验证生成 Java SDK

**C\# 开发者备注**。我们还提供一个库，用于使用 LWA 令牌交换和身份验证生成 C\# SDK。有关更多信息，请参阅 https://github.com/amzn/selling-partner-api-models/tree/main/clients/sellingpartner-api-aa-csharp 中的 README.md。

这些说明介绍了如何在运行 Microsoft Windows 的计算机上使用 [Swagger 代码生成器](https://github.com/swagger-api/swagger-codegen)为卖家 API 生成 Java SDK。对于其他操作系统（如 macOS 或 Linux）的用户，该过程是相同的，只是替换掉 Windows 特定的语义（例如 C:\）。虽然这些说明是针对卖家 API 的，但您可以修改说明，以便在销售伙伴 API 中为其他 API 创建 SDK。有关每个销售伙伴 API 部分的 Swagger 模型，请参阅<https://github.com/amzn/selling-partner-api-models>。

使用此 SDK，您可以使用已为您设置的以下代码调用卖家 API： “使用亚马逊账户登录”令牌交换（将刷新令牌交换为访问令牌）和身份验证。

**使用 LWA 令牌交换和身份验证生成 Java SDK**

1. <span id="Connecting_to_Selling_Partner_API_using_" class="anchor">安装 [Java 8 或更新版本](https://www.oracle.com/technetwork/java/index.html)、[Apache Maven 3.6 或更高版本](http://maven.apache.org/)和 [GNU Wget](https://www.gnu.org/software/wget/wget.html)，并使它们在您的 `$PATH` 中可用。

2. 转到<https://github.com/amzn/selling-partner-api-models>。

3. 克隆存储库以在计算机上创建本地副本（如果尚未执行此操作）。

4. 打开命令提示符窗口，然后转到要下载 Swagger 代码生成器的目录。

5. 下载最新版本的 Swagger 代码生成器。

   例如：
```bash
wget https://repo1.maven.org/maven2/io/swagger/swagger-codegen-cli/2.4.13/swagger-codegen-cli-2.4.13.jar -O swagger-codegen-cli.jar
```
**swagger-codegen-cli.jar** 下载到当前目录。

**注意：** 您也可以使用浏览器访问此网址来从 maven.org 下载：[https://repo1.maven.org/maven2/io/swagger/swagger-codegen-cli/2.4.13/swagger-codegen-cli-2.4.13.jar](https://repo1.maven.org/maven2/io/swagger/swagger-codegen-cli/2.4.13/swagger-codegen-cli-2.4.13.jar)

6. 将 **swagger-codegen-cli.jar** 复制到一个对您有意义的目录结构中。在此示例中，我们将它们复制到 C:\\SwaggerToCL。

7. 导航到您的本地存储库副本的 **selling-partner-api-models\\models\\sellers-api-model** 文件夹中的 **sellers.json**。

8. 将 **sellers.json** 复制到 C:\\SwaggerToCL 中。

9. 根据本地存储库副本的 **selling-partner-api-models\\clients\\sellingpartner-api-aa-java** 文件夹中的模板生成 SDK。此文件夹包含授权和身份验证库，以及用于 Swagger 代码生成器的自定义模板。

   例如：
```bash
java -jar C:\SwaggerToCL\swagger-codegen-cli.jar generate -i C:\SwaggerToCL\Sellers.json -l java -t [path to selling-partner-api-models\clients\sellingpartner-api-aa-java folder]\resources\swagger-codegen\templates\ -o C:\SwaggerToCL\Sellers_JavaCL
```
将 SDK 复制到 C:\\SwaggerToCL\\Sellers\_JavaCL

10. 构建 AA 库并将其添加为 SDK 的依赖项：

1. 导航到本地存储库副本的 **selling-partner-api-models\\clients\\sellingpartner-api-aa-java** 文件夹并运行 mvn 软件包。这会生成一个名为“target”的文件夹。在这个文件夹中，有一个名为 **sellingpartnerapi-aa-java-1.0-jar-with-dependencies.jar** 的 JAR 文件（或类似文件）和所有必需的依赖项。

2. 在本地 Maven 存储库中安装 JAR 文件。

   例如：
```bash
mvn install:install-file -Dfile=[path to JAR file in "target" folder] -DgroupId=com.amazon.sellingpartnerapi -DartifactId=sellingpartnerapi-aa-java -Dversion=1.0 -Dpackaging=jar
```
您可以在 **selling-partner-api-models\\clients\\sellingpartner-api-aa-java** 文件夹中的 **pom.xml** 文件顶部附近找到实际的 groupId、artifactId 和 version 值。

3. 在客户端库的 **pom.xml** 中添加 AA 库的依赖项：

   例如：
```xml
<dependency>
  <groupId>com.amazon.sellingpartnerapi</groupId>
  <artifactId>sellingpartnerapi-aa-java</artifactId>
  <version>1.0</version>
</dependency>
```

生成软件 SDK 后，您可以使用它调用销售伙伴 API。请参阅[使用生成的 Java SDK 连接到销售伙伴 API](#connecting-to-the-selling-partner-api-using-a-generated-java-sdk)。

# 使用生成的 Java SDK 连接到销售伙伴 API

您必须首先注册您的应用程序，并且必须获得卖家授权，之后才能将该应用程序连接到销售伙伴 API。请参阅[注册您的销售伙伴 API 应用程序](#registering-as-a-developer)和[授权销售伙伴 API 应用程序](#authorizing-selling-partner-api-applications)。

这些说明介绍了如何使用生成的 Java SDK 进行调用。该 SDK 提供了用于配置 LWA 和 AWS 凭证的类，并使用这些类来交换 LWA 令牌以及为您签署请求。有关更多信息，请参阅[通过 LWA 令牌交换和身份验证生成 Java SDK](#generating-a-java-sdk-with-lwa-token-exchange-and-authentication)。

**步骤**

[步骤 1。配置 AWS 凭证](#step-1-configure-your-aws-credentials)

[步骤 2。配置AWS凭证提供者](#step-2-configure-your-AWS-credentials-provider)

[步骤 3。配置 LWA 凭证](#step-2-configure-your-lwa-credentials)

[步骤 4。创建卖家 API 实例并调用操作](#step-3-create-an-instance-of-the-sellers-api-and-call-an-operation)

## 步骤 1。配置 AWS 凭证

使用以下参数创建 `BasicAWSCredentials` 和 `STSAssumeRoleSessionCredentialsProvider` 的实例：

<table>
<thead>
<tr class="header">
<th><strong>名称</strong>
</th>
<th><strong>描述</strong>
</th>
<th><strong>必须项</strong>
</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td><strong>accessKeyId</strong>
</td>
<td>您的 AWS 访问密钥 ID，来自<a href="#step-4-create-an-iam-role">步骤 2：创建 IAM 用户</a>。
</td>
<td>是
</td>
</tr>
<tr class="even">
<td><strong>secretKey</strong>
</td>
<td>您的 AWS 私有访问密钥，来自<a href="#step-4-create-an-iam-role">步骤 2：创建 IAM 用户</a>。
</td>
<td>是
</td>
</tr>
<tr class="odd">
<td><strong>region</strong></td>
<td>您的调用所指向的 AWS 区域。有关更多信息，请参阅<a href="#_Selling_Partner_API">销售伙伴 API 端点</a>。</td>
<td>是</td>
</tr>
<tr class="even">
<td><strong>myRoleArn</strong></td>
<td>您在<a href="#step-4-create-an-iam-role">步骤 4：创建 IAM 职权</a>中创建的 IAM 职权的 ARN。</td>
<td>是</td>
</tr>
<tr class="odd">
<td><strong>uniqueNameForRoleSession</strong></td>
<td>您定义的会话的标识符。我们建议使用<a href="https://tools.ietf.org/html/rfc4122">通用唯一标识符</a> (UUID)。</td>
<td>是</td>
</tr>
</tbody>
</table>

示例：
```java
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.STSAssumeRoleSessionCredentialsProvider;
import com.amazonaws.services.securitytoken.AWSSecurityTokenServiceClientBuilder;

...

BasicAWSCredentials
awsCreds = new BasicAWSCredentials("myAccessKeyId", "mySecretId");

AWSCredentialsProvider
credentialsProvider = new STSAssumeRoleSessionCredentialsProvider
  .Builder("myRoleArn", "uniqueNameForRoleSession")
  .withStsClient(AWSSecurityTokenServiceClientBuilder.standard()
    .withRegion(“region”)
    .withCredentials(awsCreds)
    .build())
  .build();
```
[**STSAssumeRoleSessionCredentialsProvider**](https://docs.aws.amazon.com/AWSJavaSDK/latest/javadoc/com/amazonaws/auth/STSAssumeRoleSessionCredentialsProvider.html) 实例使用 [**AWS 安全令牌服务 (AWS STS)**](https://docs.aws.amazon.com/STS/latest/APIReference/welcome.html) 来启用您在[步骤 2：创建 IAM 用户](#step-4-create-an-iam-role)中创建的用户，以承担您在[步骤 4：创建 IAM 职权](#step-4-create-an-iam-role)中创建的 IAM 职权。AWS STS 创建临时 AWS 证书，您可以使用这些证书验证对销售伙伴 API 操作的调用。

### 在 AWS 服务上托管您的销售伙伴 API 应用程序

如果您使用 [AWS Lambda](https://aws.amazon.com/lambda/)、[亚马逊 EC2](https://aws.amazon.com/ec2/) 和[亚马逊 ECS](https://aws.amazon.com/ecs/) 等服务在 AWS 上托管您的销售伙伴 API 应用程序，则获取 AWS 凭证所需的代码比前面的示例简单一些。

**对于亚马逊 ECS 集群中的亚马逊 EC2 实例**

如果您在亚马逊 ECS 集群中包含的亚马逊 EC2 实例上运行您的销售伙伴 API 应用程序，您可以：

1. 将 AWS STS 策略附加到您用于设置亚马逊 ECS 的 IAM 用户。有关说明，请参阅[步骤 5：向 IAM 用户添加 AWS 安全令牌服务策略](#step-5-add-an-aws-security-token-service-policy-to-your-iam-user)以获取说明。

2. 附加一个策略，该策略定义了为亚马逊 EC2 实例承担的职权调用销售伙伴 API 的权限。有关说明，请参阅[步骤 3：创建 IAM 策略](#step-2-create-an-iam-user)。

   您现在应该能够获取临时 AWS 凭证，而无需创建 `BasicAWSCredentials` 的实例，如前面的示例所示。

   示例：
```java
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.STSAssumeRoleSessionCredentialsProvider;
import com.amazonaws.services.securitytoken.AWSSecurityTokenServiceClientBuilder;

...

AWSCredentialsProvider
credentialsProvider = new STSAssumeRoleSessionCredentialsProvider
  .Builder("myRoleArn", "uniqueNameForRoleSession")
  .withStsClient(AWSSecurityTokenServiceClientBuilder.standard()
    .withRegion(“region”)
    .build())
  .build();
```
**对于 Lambda 函数**

如果您使用 Lambda 函数中的代码调用销售伙伴 API，您可以：

- 附加一个策略，该策略定义了为 Lambda 函数承担的职权调用销售伙伴 API 的权限。有关说明，请参阅[步骤 3：创建 IAM 策略](#step-2-create-an-iam-user)。

您现在应该能够使用 `EnvironmentVariableCredentialsProvider` 的实例获取临时 AWS 证书。

示例：
```java
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.EnvironmentVariableCredentialsProvider;

...

AWSCredentialsProvider credentialsProvider = EnvironmentVariableCredentialsProvider.create();
```
## 步骤 2。
使用以下参数创建 `AWSAuthenticationCredentialsProvider,` 的实例：

<table>
<thead>
<tr class="header">
<th><strong>名称</strong>
</th>
<th><strong>描述</strong>
</th>
<th><strong>必须项</strong>
</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td><strong>roleArn</strong>
</td>
<td>您IAM的ARN，来自<a href="#step-4-create-an-iam-role">步骤 2：创建 IAM 用户</a>。
</td>
<td>是
</td>
</tr>
<tr class="even">
<td><strong>roleSessionName</strong>
</td>
<td>您定义的会话的标识符。我们建议使用<a href="https://tools.ietf.org/html/rfc4122">通用唯一标识符</a> (UUID)。
</td>
<td>是
</td>
</tbody>
</table>

## 步骤 3。配置 LWA 凭证

使用以下参数创建 `LWAAuthorizationCredentials` 的实例：

<table>
<thead>
<tr class="header">
<th><strong>名称</strong></th>
<th><strong>描述</strong></th>
<th><strong>必须项</strong></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td><strong>clientId</strong></td>
<td>您的 LWA 客户端标识符。有关更多信息，请参阅<a href="#viewing-your-developer-information">查看</a><a href="#viewing-your-developer-information">您的开发者信息</a>。</td>
<td>是</td>
</tr>
<tr class="even">
<td><strong>clientSecret</strong></td>
<td>您的 LWA 客户密钥。有关更多信息，请参阅<a href="#viewing-your-developer-information">查看</a><a href="#viewing-your-developer-information">您的开发者信息</a>。</td>
<td>是</td>
</tr>
<tr class="odd">
<td><strong>refreshToken</strong></td>
<td>LWA 刷新令牌。当卖家授权您的应用程序时，可以获得该值。有关更多信息，请参阅<a href="#authorizing-selling-partner-api-applications">授权销售</a><a href="#authorizing-selling-partner-api-applications">伙伴 API 应用程序</a>。</td>
<td><p>否。如果您在以下步骤中调用的操作需要卖家授权，请包括刷新令牌。所有非<a href="#grantless-operations-1">免授权操作</a>的操作都需要卖家授权。如果您包含 refreshToken，请不要包含 withScopes。</p></td>
</tr>
<tr class="even">
<td><strong>withScopes</strong></td>
<td>
<p>LWA 授权范围。您可以指定一个或多个 withScopes 值。</p>
<p>值：</p>
<ul>
<li>
<em>SCOPE_NOTIFICATIONS_API</em>。对于通知 API。
</li>
<li><em>SCOPE_MIGRATION_API</em>。对于授权 API。</li>
</ul>
</td>
<td>否。如果您在以下步骤中调用的操作是<a href="#grantless-operations-1">免授权</a><a href="#grantless-operations-1">操作</a>，则包括 withScopes。如果您包含 withScopes，请不要包含 refreshToken。</td>
</tr>
<tr class="odd">
<td><strong>endpoint</strong></td>
<td>LWA 身份验证服务器 URI。</td>
<td>是</td>
</tr>
</tbody>
</table>

调用需要卖家授权的操作的示例：
```java
import com.amazon.SellingPartnerAPIAA.LWAAuthorizationCredentials;

...

LWAAuthorizationCredentials lwaAuthorizationCredentials =
  LWAAuthorizationCredentials.builder()
  .clientId("myClientId")
  .clientSecret("myClientSecret")
  .refreshToken("Aztr|...")
  .endpoint("https://api.amazon.com/auth/o2/token")
  .build();
```
调用免授权操作的示例：
```java
import com.amazon.SellingPartnerAPIAA.LWAAuthorizationCredentials;
import static com.amazon.SellingPartnerAPIAA.ScopeConstants.SCOPE_NOTIFICATIONS_API;
import static com.amazon.SellingPartnerAPIAA.ScopeConstants.SCOPE_MIGRATION_API;

...

LWAAuthorizationCredentials lwaAuthorizationCredentials =
  LWAAuthorizationCredentials.builder()
  .clientId("myClientId")
  .clientSecret("myClientSecret")
  .withScopes(SCOPE_NOTIFICATIONS_API, SCOPE_MIGRATION_API)
  .endpoint("https://api.amazon.com/auth/o2/token")
  .build();
```
## 步骤 4。创建卖家 API 实例并调用操作

通过配置 `STSAssumeRoleSessionCredentialsProvider` 和 `LWAAuthorizationCredentials` 实例，您可以创建一个 SellersApi 实例并调用操作。

示例：

```java
SellersApi sellersApi = new SellersApi.Builder()
  .awsAuthenticationCredentialsProvider(credentialsProvider)
  .lwaAuthorizationCredentials(lwaAuthorizationCredentials)
  .endpoint("https://sellingpartnerapi-na.amazon.com")
  .build();
sellersApi.getMarketplaceParticipations();
```
# 生成 Java 客户端库

这些说明介绍了如何在运行 Microsoft Windows 的计算机上使用 [Swagger 代码生成器](https://github.com/swagger-api/swagger-codegen)为卖家 API 生成 Java 客户端库。对于其他操作系统（如 macOS 或 Linux）的用户，该过程是相同的，只是替换掉 Windows 特定的语义（例如 C:\）。虽然这些说明是针对卖家 API 的，但您可以修改说明，以便在销售伙伴 API 中为其他 API 创建客户端库。有关每个销售伙伴 API 部分的 Swagger 模型，请参阅<https://github.com/amzn/selling-partner-api-models/tree/main/models>。

虽然生成的客户端库可以帮助您调用销售伙伴 API，但它不包含用于 LWA 令牌交换和身份验证的代码。关于这一点，请参阅[步骤 1：请求“使用亚马逊账户登录”访问令牌](#step-1-request-a-login-with-amazon-access-token)和[步骤 4：创建并[ ](#step-4-create-and-sign-your-request)签署您的请求](#step-4-create-and-sign-your-request)。或者，对于包含 LWA 令牌交换和身份验证的 SDK，请参阅[通过 LWA 令牌交换](#generating-a-java-sdk-with-lwa-token-exchange-and-authentication)[和身份验证生成 Java SDK](#generating-a-java-sdk-with-lwa-token-exchange-and-authentication)。

**生成 Java 客户端库**

1. 安装 [Java 8 或更新版本](https://www.oracle.com/technetwork/java/index.html)、[Apache Maven 3.6 或更高版本](http://maven.apache.org/)和 [GNU Wget](https://www.gnu.org/software/wget/wget.html)，并使它们在您的 $PATH 中可用。

2. 转到<https://github.com/amzn/selling-partner-api-models>。

3. 克隆存储库以在计算机上创建本地副本（如果尚未执行此操作）。

4. 打开命令提示符窗口，然后导航到要下载 Swagger 代码生成器的目录。

5. 下载最新版本的 Swagger 代码生成器。

   例如：
```
wget https://repo1.maven.org/maven2/io/swagger/swagger-codegen-cli/2.4.13/swagger-codegen-cli-2.4.13.jar -O swagger-codegen-cli.jar
```
**swagger-codegen-cli.jar** 下载到当前目录。

**注意：** 您也可以通过在这里定向您的浏览器，从 maven.org 下载：<https://repo1.maven.org/maven2/io/swagger/swagger-codegen-cli/2.4.13/swagger-codegen-cli-2.4.13.jar>

6. 将 **swagger-codegen-cli.jar** 复制到一个对您有意义的目录结构中。在此示例中，我们将它们复制到 C:\\SwaggerToCL。

7. 导航到您的本地存储库副本的 **selling-partner-api-models\\models\\sellers-api-model** 文件夹中的 **sellers.json**。

8. 将 **sellers.json** 复制到 C:\\SwaggerToCL 中。

9. 生成客户端库。

   例如：
```
java -jar C:\SwaggerToCL\swagger-codegen-cli.jar generate -i C:\SwaggerToCL\Sellers.json -l java -o C:\SwaggerToCL\Sellers_JavaCL
```
客户端库被复制到 C:\\SwaggerToCL\\Sellers\_JavaCL。

生成客户端库后，您可以使用它来帮助您调用销售伙伴 API。请参阅[连接到销售伙伴 API](#connecting-to-the-selling-partner-api)。

# 连接到销售伙伴 API

您必须首先注册您的应用程序，并且必须获得卖家授权，之后才能将该应用程序连接到销售伙伴 API。请参阅[注册您的销售伙伴 API 应用程序](#registering-as-a-developer)和[授权销售伙伴 API 应用程序](#authorizing-selling-partner-api-applications)。

这些说明向您展示了调用销售伙伴 API 的步骤。有关构建销售伙伴 API URI 并向其添加标头的帮助，请参阅[生成 Java 客户端库](#Generating_a_Java_client_library)。有关更完整的解决方案（包括用于交换 LWA 令牌和身份验证的代码），请参阅[通过 LWA 令牌交换](#generating-a-java-sdk-with-lwa-token-exchange-and-authentication)[和身份验证生成 Java SDK](#generating-a-java-sdk-with-lwa-token-exchange-and-authentication)。

**步骤**

[步骤 1。请求“使用亚马逊账户登录”访问令牌](#step-1-request-a-login-with-amazon-access-token)

[步骤 2。构建销售伙伴 API URI](#step-2-construct-a-selling-partner-api-uri)

[步骤 3。将标头添加到 URI](#step-3-add-headers-to-the-uri)

[步骤 4。创建并签署您的请求](#step-4-create-and-sign-your-request)

## 步骤 1。请求“使用亚马逊账户登录”访问令牌

“使用亚马逊账户登录”(LWA) 访问令牌授权您的应用程序代表卖家执行某些操作。LWA 访问令牌在发出后一小时过期，并且必须包含在销售伙伴 API 的每个请求中。

要请求 LWA 访问令牌，请使用以下参数向 LWA 身份验证服务器 (`https://api.amazon.com/auth/o2/token`) 创建一个安全的 HTTP POST：

<table>
<thead>
<tr class="header">
<th><strong>名称</strong></th>
<th><strong>描述</strong></th>
<th><strong>必须项</strong></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td><strong>grant_type</strong></td>
<td><p>请求的访问授权类型。值：</p>
<ul>
<li><p><em>refresh_token</em>。这用于调用需要卖家授权的操作。所有非<a href="#grantless-operations-1">免授权操作</a>的操作都需要卖家授权。指定此值时，请包括 <em>refresh_token</em> 参数。</p></li>
<li><p><em>client_credentials</em>。这用于调用<a href="#grantless-operations-1">免授权操作</a>。指定此值时，请包括 <code>scope</code> 参数。</p></li>
</ul></td>
<td>是</td>
</tr>
<tr class="even">
<td><strong>refresh_token</strong></td>
<td>LWA 刷新令牌。当卖家授权您的应用程序时，可以获得该值。有关更多信息，请参阅<a href="#authorizing-selling-partner-api-applications">授权销售伙伴 API 应用程序</a>。</td>
<td>否。包括用于调用需要卖家授权的操作的 refresh_token。如果包含 refresh_token，请不要包含 scope。</td>
</tr>
<tr class="odd">
<td><strong>scope</strong></td>
<td><p>LWA 授权范围。值：</p>
<ul>
<li><p><em>sellingpartnerapi::notifications</em>。对于通知 API。</p></li>
<li><p><em>sellingpartnerapi::migration</em>。对于授权 API。</p></li>
</ul></td>
<td>否。包含 scope 以调用 <a href="#grantless-operations-1">免授权</a><a href="#grantless-operations-1">操作</a>。如果包含 scope，请不要包含 refresh_token。</td>
</tr>
<tr class="even">
<td><strong>client_id</strong></td>
<td>注册应用程序时获取该值。请参阅<a href="#viewing-your-developer-information">查看您的开发者信息</a>。</td>
<td>是</td>
</tr>
<tr class="odd">
<td><strong>client_secret</strong></td>
<td>注册应用程序时获取该值。请参阅<a href="#viewing-your-developer-information">查看您的开发者信息</a>。</td>
<td>是</td>
</tr>
</tbody>
</table>

调用需要卖家授权的操作的示例：
```http
POST /auth/o2/token HTTP/l.l
Host: api.amazon.com
Content-Type: application/x-www-form-urlencoded;charset=UTF-8
grant_type=refresh_token
&refresh_token=Aztr|...
&client_id=foodev
&client_secret=Y76SDl2F
```
调用免授权操作的示例：
```http
POST /auth/o2/token HTTP/l.l
Host: api.amazon.com
Content-Type: application/x-www-form-urlencoded;charset=UTF-8
grant_type=client_credentials
&scope=sellingpartnerapi::notifications
&client_id=foodev
&client_secret=Y76SDl2F
```
**提示：** 要避免在调用 LWA 授权服务器时出现不可信的证书颁发机构 (CA) 错误，请务必更新您的信任存储，以便您的应用程序信任 LWA 授权服务器。

**响应**

成功的响应包括以下值。

| **名称** | **描述** |
| ------------------ | --- |
| **access\_token** | LWA 访问令牌。最大大小： 2048 字节。 |
| **token\_type** | 返回的令牌类型。必须是 *bearer*。 |
| **expires\_in** | LWA 访问令牌失效之前的秒数。 |
| **refresh\_token** | 您在请求中提交的 LWA 访问令牌。最大大小： 2048 字节。 |
```http
HTTP/l.l 200 OK
Content-Type: application/json;charset UTF-8
Cache-Control: no-store
Pragma:no-cache
{
  "access_token":"Atza|IQEBLjAsAhRmHjNgHpi0U-Dme37rR6CuUpSREXAMPLE",
  "token_type":"bearer",
  "expires_in":3600,
  "refresh_token":"Atzr|IQEBLzAtAhRPpMJxdwVz2Nn6f2y-tpJX2DeXEXAMPLE"
}
```
有关更多信息，请访问《使用亚马逊账户登录》文档中的[授权代码授权](https://developer.amazon.com/docs/login-with-amazon/authorization-code-grant.html)页面。

## 步骤 2。构建销售伙伴 API URI

以下是销售伙伴 API URI 的组件。

| **名称** | **描述** | **示例** |
| -------------- | ---------------------- | ------------ |
| HTTP 方法 | [销售伙伴 API HTTP 方法](#selling-partner-api-http-methods)之一。 | `GET` |
| 端点 | [销售伙伴 API 端点](#Selling_Partner_API_endpoints)。 | `https://sellingpartnerapi-na.amazon.com` |
| 路径 | 销售伙伴 API 部分/该部分的版本号/资源。 | `/fba/inbound/v0/shipments/{shipmentId}/preorder/confirm` |
| 查询字符串 | 查询参数。 | `?marketplace=ATVPDKIKX0DER` |
| 路径参数 | 路径参数 | `shipmentId1` |

例如：
```http
PUT https://sellingpartnerapi-na.amazon.com/fba/inbound/v0/shipments/shipmentId1/preorder/confirm?MarketplaceId=ATVPDKIKX0DER&NeedByDate=2020-10-10
```
## 步骤 3。将标头添加到 URI

将标头添加到您在[步骤 2：构建销售伙伴 API URI](#step-2-construct-a-selling-partner-api-uri) 中构建的 URI。以下是您在销售伙伴 API 的请求中包含的 HTTP 标头：

**请求标头**

| **名称** | **描述** |
| ---------- | ---------------- |
| host | 商城端点。请参阅[销售伙伴 API HTTP 方法](#selling-partner-api-http-methods)。 |
| x-amz-access-token | LWA 访问令牌。请参阅[步骤 1：请求“使用亚马逊账户登录”访问令牌](#step-1-request-a-login-with-amazon-access-token)。 |
| x-amz-date | 请求的日期和时间。 |
| user-agent | 您的应用程序名称和版本号、平台和编程语言。这些内容可帮助亚马逊诊断和修复您可能遇到的服务问题。请参阅[在所有请求中](#include-a-user-agent-header-in-all-requests)[包含 User-Agent 标头](#include-a-user-agent-header-in-all-requests)。 |

以下是销售伙伴 API 的请求示例，其中包含 URI 和标头，但没有签名信息：
```http
PUT /fba/inbound/v0/shipments/shipmentId1/preorder/confirm?MarketplaceId=ATVPDKIKX0DER&NeedByDate=2020-10-10 HTTP/1.1
host: sellingpartnerapi-na.amazon.com
user-agent： My Selling Tool/2.0 (Language=Java/1.8.0.221;
Platform=Windows/10)
x-amz-access-token=Atza|IQEBLjAsAhRmHjNgHpi0U-Dme37rR6CuUpSREXAMPLE
x-amz-date: 20190430T123600Z
```
要签署销售伙伴 API 的请求，请参阅[步骤 4：创建并签署您的请求](#step-4-create-and-sign-your-request)。

## 步骤 4。创建并签署您的请求

销售伙伴 API 使用 AWS [签名版本 4 签名流程](https://docs.aws.amazon.com/general/latest/gr/signature-version-4.html)对请求进行身份验证。当您向销售伙伴 API 发送 HTTP 请求时，您需要对请求进行签名，以便亚马逊能够识别谁发送了这些请求。您可以使用 AWS 访问密钥签署请求，该密钥包括访问密钥 ID 和访问密钥。有关获取 AWS 访问密钥的信息，请参阅[步骤 2：创建 IAM 用户](#step-4-create-an-iam-role)中创建的用户。

**注意：** 您需要了解如何在手动创建 HTTP 请求时对其进行签名。当您使用其中一个 AWS SDK 为您计算签名时，SDK 会自动使用您在配置它时指定的 AWS 访问密钥对请求进行签名。您使用 SDK 时，无需了解如何自己签署请求。例如，Java 开发者可以使用适用于 Java 的 AWS SDK 中的 [AWS4Signer.java](https://github.com/aws/aws-sdk-java/blob/master/aws-java-sdk-core/src/main/java/com/amazonaws/auth/AWS4Signer.java) 作为计算签名的模型。您可以在 [AWS GitHub 代码库](https://github.com/aws)中找到其他语言的 SDK。

要创建并签署您的请求，请完成以下操作：

1. 创建规范请求

   按照 AWS 文档的[任务 1： 创建签名版本 4 的规范请求](https://docs.aws.amazon.com/general/latest/gr/sigv4-create-canonical-request.html)中的说明操作，使用该指南：

   - 请参阅[步骤 3：有关创建规范请求时开始的未签名请求示例，请将标头添加到 URI](#step-3-add-headers-to-the-uri)。

   - 使用 SHA-256 作为哈希算法。

   - 请勿将身份验证信息放在查询参数中。将其放在 `Authorization` 标头参数中。有关使用 `Authorization` 标头参数作为身份验证信息的信息，请参阅[授权标头](#authorization-header)。

2. 创建要签名的字符串

   按照 AWS 文档的[任务 2： 为签名版本 4 创建要签名的字符串](https://docs.aws.amazon.com/general/latest/gr/sigv4-create-string-to-sign.html)中的说明操作，使用该指南：

   - 算法指定值为 `AWS4-HMAC-SHA256`

   - 要确定凭证范围，请参阅[Credential scope](#credential-scope)。

3. 计算签名

   按照 AWS 文档的[任务 3： 计算 AWS 签名版本 4 的签名](https://docs.aws.amazon.com/general/latest/gr/sigv4-calculate-signature.html)中的说明操作。

   **重要说明：** 请参阅[凭证范围](#credential-scope)以帮助您完成此步骤。

4. 添加签名信息

   按照 AWS 文档的[任务 4： 将签名添加到 HTTP 请求](https://docs.aws.amazon.com/general/latest/gr/sigv4-add-signature-to-request.html)中的说明操作，使用该指南：

   - 请勿将签名信息添加到查询字符串。将其添加到 `Authorization` 标头参数。

   - 有关创建 `Authorization` 标头参数的详细信息，请参阅[授权标头](#authorization-header)。

   以下示例显示了在您使用 Authorization 标头向其添加签名信息后的类似请求。
```http
PUT /fba/inbound/v0/shipments/shipmentId1/preorder/confirm?MarketplaceId=ATVPDKIKX0DER&NeedByDate=2020-10-10HTTP/1.1
Authorization: AWS4-HMAC-SHA25Credential=AKIDEXAMPLE/20190430/us-east1/
execute-api/aws4_request, SignedHeaders=host;user-agent;x-amz-access-token,
Signature=5d672d79c15b13162d9279b0855cfba6789a8edb4c82c400e06b5924aEXAMPLE
host: sellingpartnerapi-na.amazon.com
user-agent: My Selling Tool/2.0 (Language=Java/1.8.0.221;
Platform=Windows/10)
x-amz-access-token=Atza|IQEBLjAsAhRmHjNgHpi0U-Dme37rR6CuUpSREXAMPLE
x-amz-date: 20190430T123600Z
```
### 凭证范围

凭证范围是您在签署销售伙伴 API 的请求时创建的“要签名的字符串”的组成部分。请参阅[创建并签署您的请求](#step-4-create-and-sign-your-request)。

凭证范围由斜杠分隔的各组成部分的字符串表示，如下表所示：

| **组成部分** | **描述** | **示例** |
| ----------- | ---- | ------------- |
| 日期 | 一个八位数的字符串，表示请求的年份 (YYYY)、月份 (MM) 和日期 (DD)。 | `20190430` |
| AWS 区域 | 您要向其发送请求的区域。请参阅[销售伙伴 API 端点](#Selling-Partner-API-endpoints)。 | `us-east-1` |
| 服务 | 您请求的服务。您可以在端点中找到该值。请参阅[销售伙伴 API 端点](#Selling-Partner-API-endpoints)。 | `execute-api` |
| 终止字符串 | 一个特殊的终止字符串。对于 AWS 签名版本 4，值为 aws4\_request | `aws4_request` |

例如：
```
20190430/us-east-1/execute-api/aws4_request
```
**重要说明：** 作为凭证范围一部分使用的日期必须与您的请求日期匹配，如 x-amz-date 标头中指定的那样。有关更多信息，请参阅 AWS 文档中的[处理签名版本 4 中的日期](https://docs.aws.amazon.com/general/latest/gr/sigv4-date-handling.html)。

有关更多信息，请参阅[步骤 4：创建并签署您的请求](#step-4-create-and-sign-your-request)。

### Authorization 标头

Authorization 标头包含请求的签名信息。尽管标头命名为“Authorization”，但签名信息可用于身份验证。

下面列出了 Authorization 标头的组成部分：

| **组成部分** | **描述** |
| ------------------------------ | ---------|
| 用于签名的算法 | 整个签名过程中使用的哈希算法。销售伙伴 API 需要 SHA-256。您可以在[步骤 4：创建并签署您的请求](#step-4-create-and-sign-your-request)中指定此项。 |
| Credential | 您的 AWS 访问密钥编码加上[凭证范围](#credential-scope)。您可以在[步骤](#step-4-create-an-iam-role) [3：创建 IAM 用户](#step-4-create-an-iam-role)中获取 AWS 访问密钥编码。 |
| SignedHeaders | 签名请求中包含的所有 HTTP 标头的列表。有关示例，请参阅[步骤 3：将标头添加到 URI](#step-3-add-headers-to-the-uri)。 |
| Signature | 在[步骤 4：创建并签署您的请求](#step-4-create-and-sign-your-request)中计算的签名。 |

例如：
```
Authorization: AWS4-HMAC-SHA25 Credential=AKIDEXAMPLE/20190430/us-east1/execute-api/aws4_request, SignedHeaders=host;user-agent;x-amz-accesstoken;xamz-date, Signature=5d672d79c15b13162d9279b0855cfba6789a8edb4c82c400e06b5924aEXAMPLE
```
有关更多信息，请参阅[步骤 4：创建并签署您的请求](#step-4-create-and-sign-your-request)。

# 响应格式

在响应 HTTP 请求时，销售伙伴 API 会返回若干响应标头和一条 JSON 响应消息。

**响应标头**

| **名称** | **描述** |
| ---------------- | --------------------------------------------------------------- |
| Content-Length | 标准 HTTP 响应标头。 |
| Content-Type | 标准 HTTP 响应标头。 |
| 日期 | 标准 HTTP 响应标头。 |
| x-amzn-RequestId | 请求编码。如果您与我们联系是为了获得支持，请添加此标头。 |

### 成功响应

如果您的请求成功，销售伙伴 API 将返回请求的数据。以下是一个成功响应的例子：
```http
HTTP/1.1 200 OK
Content-Length: 368
Content-Type: application/json
Date: Thu, 01 Jun 2020 22:23:31 GMT
x-amzn-RequestId: 6875f61f-6aa1-11e8-98c6-9bExample
{
  "payload": {
    "ConfirmedNeedByDate": "2020-04-23",
    "ConfirmedFulfillableDate": "2020-04-23"
  }
}
```
### 错误响应

如果您的请求不成功，销售伙伴 API 将返回错误响应。以下是错误响应中的响应消息的元素：

**响应消息**

| **元素** | **描述** | **必须项** |
| ----------- | ----------------------------------- | ------------ |
| code | HTTP 状态代码。 | 是 |
| message | 错误条件的说明。 | 是 |
| details | 其他信息的链接。 | 否 |

以下是错误响应的示例：
```http
HTTP/1.1 400 Bad Request
Content-Length: 117
Content-Type: application/json
Date: Fri, 01 Jun 2020 21:48:02 GMT
x-amzn-ErrorType: ValidationException
x-amzn-RequestId: a8c8d99a-6ab5-11e8-b0f8-19363980175b
{
  "errors": [
    {
      "message": "Access to requested resource is denied.",
      "code": "Unauthorized",
      "details": "Access token is missing in the request header."
    }
  ]
}
```

# 免授权操作

免授权操作是您可以在没有销售伙伴明确授权的情况下调用的操作。这意味着，当您在调用免授权操作之前[请求“使用亚马逊账户登录”访问令牌](#step-1-request-a-login-with-amazon-access-token)时，您无需提供刷新令牌。相反，您可以使用 **scope** 参数来提供 LWA 授权的范围。如果您使用生成的 Java SDK（请参阅[使用生成的 Java SDK 连接到销售伙伴 API](#Connecting_to_Selling_Partner_API_using_)）调用免授权操作，请在配置 LWA 凭证时使用 **withScopes** 参数为 LWA 授权设置一个或多个范围。

有关销售伙伴 API 中的免授权操作，请参阅下表。

**免授权操作**

| **操作名称** | **HTTP 方法和路径** |
| -------------------------- | -------------- |
| **createDestination** | POST /notifications/v1/destinations |
| **deleteDestination** | DELETE /notifications/v1/destinations/{destinationId} |
| **deleteSubscriptionById** | DELETE /notifications/v2/subscriptions/{notificationType}/{subscriptionId} |
| **getDestination** | GET /notifications/v1/destinations/{destinationId} |
| **getDestinations** | GET /notifications/v1/destinations |
| **getSubscriptionById** | GET /notifications/v1/subscriptions/{notificationType}/{subscriptionId} |
| **getAuthorizationCode** | GET /authorization/v1/authorizationCode |

# 在所有请求中包含 User-Agent 标头

User-Agent 标头可标识您的应用程序、其版本号以及您正在使用的平台和编程语言。您必须在提交给销售伙伴 API 的每个请求中包含一个 User-Agent 标头。

这样可帮助亚马逊更有效地判断和解决问题，也有助于您更好地使用该服务。

要创建 User-Agent 标头，请以应用程序名称开头，然后依次是正斜杠、应用程序版本、空格、左括号、Language 名称值对，以及

右括号。Language 参数是必需的属性，但您还可以添加其他属性，并以分号隔开。

以下伪代码展示了在最低限度上可接受的 User-Agent 标头：
```
AppId/AppVersionId (Language=LanguageNameAndOptionallyVersion)
```
以下是应用程序集成商可能使用的 User-Agent 标头示例：
```
My Selling Tool/2.0 (Language=Java/1.8.0.221; Platform=Windows/10)
```
如果您是通过自己的 IT 部门进行集成的大卖家，请考虑创建包含 Host 属性的 User-Agent 标头，如以下示例所示。这可以帮助亚马逊支持工程师为您更有效地解决问题。
```
MyCompanyName/build1611 (Language=Perl; Host=jane.desktop.example.com)
```
要指定其他属性，请使用以下格式：AttributeName=Value;，将每个名称值对用分号隔开。如果您需要使用反斜杠 (\\)，请用另一个反斜杠 (\\\\) 引用它。以同样的方式引用应用程序名称中的正斜杠 (\\/)、应用程序版本中的左括号 (\\()、属性名称中的等号 (\\=)、属性值中的右括号 (\\)) 和分号 (\\;)。

由于 User-Agent 标头要包含在每个请求中进行传送，因此建议您限制标头的长度。如果 User-Agent 标头长度超过 500 个字符，销售伙伴 API 就会拒绝该标头。

# 混合销售伙伴 API 应用程序

混合销售伙伴 API 应用程序是一种可以调用销售伙伴 API 和亚马逊商城网络服务（亚马逊 MWS）的应用程序。当您的解决方案需要两种服务的功能时，请使用混合应用程序。当卖家授权您的混合销售伙伴 API 应用程序时，他们将 (1) 授权您的亚马逊 MWS 开发者编号代表他们调用亚马逊 MWS，以及 (2) 授权应用程序代表他们调用销售伙伴 API。

亚马逊将混合应用程序视为单个应用程序。例如，当您将混合应用程序发布到商城应用商店时，您可以将其作为单个应用程序进行管理。

### 创建混合销售伙伴 API 应用程序

**创建混合应用程序**

1. 将您的亚马逊 MWS 应用程序发布到商城应用商店。有关发布您的应用程序的信息，请参阅亚马逊 MWS 文档中的[商城应用商店发布指南](https://docs.developer.amazonservices.com/en_US/dev_guide/DG_AppListingGuide.html)。

2. 使用您用于[注册成为开发者](#registering-as-a-developer)的凭据登录卖家平台。

3. 在**应用程序和服务**菜单中，单击**开发应用程序**。

   此时将显示**开发者平台**页面。

4. 在您的亚马逊 MWS 应用程序旁边的**编辑应用程序**菜单上，单击**编辑应用程序**。

5. 按照说明注册您的应用程序。

创建混合应用程序后，您可以设置和测试 OAuth 授权工作流程。有关更多信息，请参阅[授权销售伙伴 API 应用程序](#authorizing-selling-partner-api-applications)。

### 从亚马逊商城网络服务迁移授权

如果销售伙伴授权您代表他们调用亚马逊商城网络服务，您可以使用授权 API 将该授权迁移到混合销售伙伴 API 应用程序。这样，您就无需再次请求销售伙伴授权。有关更多信息，请参阅《授权 API 用户指南》。

# 销售伙伴 API 沙箱

销售伙伴 API 提供了一个沙箱环境，允许您在不影响生产数据或触发真实情况下测试应用程序。对销售伙伴 API 进行沙箱调用与进行生产调用相同，不同之处在于您要将调用指向[销售伙伴 API 沙箱端点](#selling-partner-api-sandbox-endpoints)。调用沙箱端点会返回所有销售伙伴 API 的静态模拟响应。您可以在 Swagger 模型 JSON 文件中为要调用的 API 引用这些模拟响应。有关更多信息，请参阅[如何对销售伙伴 API 进行沙箱调用](#how-to-make-a-sandbox-call-to-the-selling-partner-api)。

销售伙伴 API 沙箱的工作原理与许多模拟框架相同，因为它采用模式匹配，在指定参数存在时返回指定的响应。开发者在发送与指定参数匹配的请求时会收到在 x- amazon-spds-sandbox-behaviors 对象中定义的响应。如果 API 需要未在 x-amazon-spds-sandbox-behaviors 对象中指定的任何参数，则只要请求有效，沙箱都会提供响应，而不考虑请求中的参数值。

**重要说明：** 沙箱用于测试功能，而非测试可扩展性。对沙箱端点的调用受以下限制的约束：**速率** = 每秒 5 个请求；**突增** = 15。有关限制的更多信息，请参阅销售伙伴 API 文档中的“使用计划和速率限制”。

## 如何对销售伙伴 API 进行沙箱调用

### 步骤 1。检查 JSON 文件中的请求参数

1. 转到<https://github.com/amzn/selling-partner-api-models/tree/main/models>。

2. 打开要对其进行沙箱调用的 API 的文件夹。

3. 单击所需 API 的 JSON 文件。

   此时将显示 JSON 代码。

4. 搜索“x-amazon-spds-sandbox-behaviors”的代码。

JSON 文件的 x-amazon-spds-sandbox-behaviors 对象包含对 API 的沙箱调用的请求和响应示例。如果请求示例包含参数，请在以下步骤中使用它们。

### 步骤 2。对 API 进行沙箱调用

按照与执行生产调用时相同的方式对 API 进行沙箱调用，但有以下不同之处：

1. 如果 JSON 文件的 x-amazon-spds-sandbox-behaviors 对象中的请求对象包含一个或多个参数/值对，请在调用中指定这些对象。

2. 将您的调用指向[销售伙伴 API 沙箱端点](#selling-partner-api-sandbox-endpoints)之一。

   您应收到一个响应，该响应与 JSON 文件的 x-amazon-spds-sandbox-behaviors 对象中包含的有效负载对象匹配。

## 销售伙伴 API 沙箱端点

销售伙伴 API 具有针对北美、欧洲和远东销售区域的沙箱端点。有关更多信息，请参阅[销售伙伴 API 沙箱](#hybrid-selling-partner-api-applications)。

| **销售区域** | **端点** | **AWS 区域** |
| ------------- | -------------- | -------------- |
| 北美（加拿大、美国、墨西哥和巴西商城） | `https://sandbox.sellingpartnerapi-na.amazon.com` | us-east-1 |
| 欧洲（西班牙、英国、法国、德国、意大利、土耳其、阿联酋和印度商城） | `https://sandbox.sellingpartnerapi-eu.amazon.com` | eu-west-1 |
| 远东（新加坡、澳大利亚和日本商城） | `https://sandbox.sellingpartnerapi-fe.amazon.com` | us-west-2 |

# 销售伙伴 API 与亚马逊商城网络服务有何不同？

尽管销售伙伴 API 和亚马逊商城网络服务（亚马逊 MWS）都是支持以编程方式访问卖家数据的 Web 服务，但存在着显著差异。以下是销售伙伴 API 和亚马逊 MWS 之间的一些主要区别：

- 销售伙伴 API 将数据视为符合 REST 的资源，可以通过标准 HTTP 方法访问和修改。与之不同的是，亚马逊 MWS 使用特定于亚马逊 MWS 的操作提供数据。

- 销售伙伴 API 授权利用 LWA，即亚马逊对 OAuth 2.0 的实施。使用此模型，您无需按照亚马逊 MWS 的要求手动交换身份验证令牌。请参阅[授权您的销售伙伴 API 应用程序](#website-workflow)。

- 通过亚马逊 MWS，卖家授权开发者。通过销售伙伴 API，卖家授权应用程序。使用销售伙伴 API，开发者可以创建多个需要不同级别的卖家数据访问权限的应用程序。

- 销售伙伴 API 提供比亚马逊 MWS 更精细的数据访问控制。开发者只能请求访问他们所需的数据，卖家可以授予 API 部分、操作或数据资源级别的权限。

- 销售伙伴 API 允许您使用 AWS Identity and Access Management (IAM) 直接获取和管理自己的身份验证凭证。借助亚马逊 MWS，您可使用专用注册工作流程接收亚马逊提供的身份验证凭证，并通过与亚马逊 MWS 支持部门联系来获得新凭证。请参阅[步骤 2：创建 IAM 用户](#step-4-create-an-iam-role)。

- 销售伙伴 API 使用 AWS 签名版本 4 进行身份验证。亚马逊 MWS 使用签名版本 2。请参阅[步骤 4：创建并签署您的请求](#step-4-create-and-sign-your-request)。
