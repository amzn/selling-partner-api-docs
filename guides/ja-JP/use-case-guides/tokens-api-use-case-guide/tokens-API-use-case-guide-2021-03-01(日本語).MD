トークンAPIユースケースガイド
=========================

バージョン： 2021年3月1日

トークンAPIとは
=======================

トークンの出品パートナーAPI（トークンAPI）は、顧客の個人識別情報（PII）に安全にアクセスするための手段を提供します。トークンAPIを呼び出して、指定した1つ以上の制限付きリソースについて制限付きデータトークン（RDT）を取得できます。RDTにより、制限付きリソースが表す制限付きオペレーションの後続の呼び出しが許可されます。[用語](#用語)を参照してください。

制限付きオペレーションを呼び出すときは、`x-amz-access-token`ヘッダーにRDTを含めます。この点は、`x-amz-access-token`ヘッダーにLWAアクセストークンを含める他のすべてのSP-APIオペレーションと異なります。詳細については、[ステップ3.URIにヘッダーを追加する](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md#step-3-add-headers-to-the-uri)をご覧ください。

用語
-----------

- **制限付きデータトークン（RDT）**。制限付きオペレーションの呼び出しを許可する、有効期間が短いアクセストークン。

- **制限付きオペレーション。**個人識別情報（PII）などの制限付きデータを返すオペレーション。制限付きオペレーションを呼び出すにはRDTが必要です。[制限付きオペレーション](#制限付きオペレーション)を参照してください。

- **制限付きリソース。**制限付きオペレーションを表すHTTPメソッドとパス。

- **制限付きレポートタイプ。**PIIを含むレポートタイプ。[制限付きレポートタイプ](#制限付きレポートタイプ)を参照してください

- **特定のパス。**特定の注文IDまたは出荷IDを含む制限付きリソース内のパス。例：`orders/v0/orders/902-3159896-1390916/address`

- **汎用パス。**特定の注文IDも出荷IDも含まない制限付きリソース内のパス。代わりに、`{orderId}`または`{shipmentID}`という文字列が含まれています。例：`orders/v0/orders/{orderId}/address`

制限付きオペレーション
=====================

制限付きオペレーションは、顧客の個人識別情報（PII）を返します。制限付きオペレーションの呼び出しについて詳しくは、チュートリアル： RDTを取得し、制限付きオペレーションを呼び出す を参照してください。

次のリストに、制限付きオペレーションをAPI別に示します。

注文API：

- ```getOrderBuyerInfo```

- ```getOrderAddress```

- ```getOrderItemsBuyerInfo```

配送API：

- ```getShipment```

出品者出荷API：

- ```getShipment```

- ```cancelShipment```

- ```cancelShipmentOld```

- ```createShipment```

レポートAPI：

- ```getReportDocument```

   **注意：**

   - getReportDocumentオペレーションは、制限付きレポートが指定されている場合のみ制限付きオペレーションとみなされます。以下の制限付きレポートタイプのリストを参照してください。

   - createRestrictedDataTokenオペレーションを呼び出してgetReportDocumentオペレーションのためのRDTを取得するときに指定する制限付きリソースには、汎用パスではなく、特定のパスのみを含めることができます。詳細については、チュートリアル： RDTを取得し、制限付きオペレーションを呼び出す と[用語](#用語)を参照してください。

制限付きレポートタイプ
-----------------------

制限付きレポートタイプにはPIIが含まれています。getReportDocumentオペレーションの呼び出しで制限付きレポートタイプを指定する場合は、呼び出しでRDTを渡す必要があります。詳細については、チュートリアル： RDTを取得し、制限付きオペレーションを呼び出す を参照してください。

次のリストに、制限付きレポートタイプを示します。

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

チュートリアル： RDTを取得し、制限付きオペレーションを呼び出す
===================================================

このチュートリアルでは、トークンAPIを使用して制限付きデータトークン（RDT）を取得し、このRDTを使用して制限付きオペレーションを呼び出す方法について説明します。

**前提条件**

このチュートリアルを実行するには、以下が必要です。

- 呼び出しを行う出品パートナーの承認。詳しくは、[出品パートナーAPI開発者ガイド](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md)を参照してください。

ステップ1.RDTを取得する
------------------

RDTを取得するにはcreateRestrictedDataTokenオペレーションを呼び出します。

- 以下のパラメーターを渡して、[createRestrictedDataToken](https://github.com/amzn/selling-partner-api-docs/blob/main/references/tokens-api/tokens_2021-03-01.md#createrestricteddatatoken)オペレーションを呼び出します。

ボディのパラメーター：

| パラメーター | 説明 | タイプ： | 必須 |
|-----------|-------------|------|----------|
| restrictedResources | 制限付きリソースのモデル。</br>最大： 50 | <a href="#restrictedresources">restrictedResources</a> | はい |

リクエストの例：
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
**レスポンス**

成功レスポンスには、以下が含まれます。

| 名前 | ヘッダー2 | タイプ： |
|----------|----------|------|
| restrictedDataToken | 制限付きデータトークン（RDT）。これは、指定した制限付きリソースが表す制限付きオペレーションの呼び出しを許可する、有効期間が短いアクセストークンです。制限付きオペレーションへの後続の呼び出しを行うときに、<code>x-amzn-access-token</code>ヘッダーでRDT値を渡します。 | 文字列 |
| expiresIn | RDTの有効期間（秒単位）。 | 整数 |

レスポンスの例：
```
{
	"payload": {
		"restrictedDataToken": "Atz.sprdt|IQEBLjAsAhRmHjNgHpi0U-Dme37rR6CuUpSR",
		"expiresIn": 3600
	}
}
```
これで、以下の制限付きオペレーションの呼び出しを許可するRDTを取得できました。

- **getOrderAddress。**getOrderAddressオペレーションは、指定した制限付きリソースからの特定のパスを使用して呼び出すことができます。例：`/orders/v0/orders/902-3159896-1390916/address`。

- **getOrderBuyerInfo。**getOrderBuyerInfoオペレーションは、指定した制限付きリソースからの汎用パスを使用して呼び出すことができます。`{orderId}`は出品パートナーの注文IDで置き換えます。例：`/orders/v0/orders/058-1233752-8214740/buyerInfo`および`/orders/v0/orders/483-3488972-0896720/buyerInfo`。RDTは、出品パートナーの任意の注文IDに使用できます。

- **getShipment。**getShipmentオペレーションは、指定した制限付きリソースからの汎用パスを使用して呼び出すことができます。`{shipmentID}`は出品パートナーの出荷IDで置き換えます。例：`/mfn/v0/shipments/6f77095e-9f75-47eb-aaab-a42d5428fa1a`。RDTは、出品パートナーの任意の出荷IDに使用できます。

詳細については、[用語](#用語)を参照してください。

ステップ2.制限付きオペレーションを呼び出す
----------------------------------

ステップ1.RDTを取得する のRDTで許可された制限付きオペレーションを呼び出します。制限付きオペレーションを呼び出すときは、`x-amz-access-token`ヘッダーにRDTを含めます。詳細については、[ステップ3.URIにヘッダーを追加する](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md#step-3-add-headers-to-the-uri)をご覧ください。

リクエストの例：
```
GET https://sellingpartnerapi-na.amazon.com/orders/v0/orders/orders/v0/orders/902-3159896-1390916/address.

GET https://sellingpartnerapi-na.amazon.com/orders/v0/orders/902-3159896-1390916/buyerInfo

GET https://sellingpartnerapi-na.amazon.com/orders/v0/orders/483-3488972-0896720/buyerInfo

GET https://sellingpartnerapi-na.amazon.com/mfn/v0/shipments/6f77095e-9f75-47eb-aaab-a42d5428fa1a
```
データタイプ
---------

### restrictedResources

<table><thead><tr class="header"><th><strong>パラメーター</strong></th><th><strong>説明</strong></th><th><strong>必須</strong></th></tr></thead><tbody><tr class="odd"><td>メソッド</td><td><p>制限付きリソースで使用されるHTTPメソッド。</p><p>タイプ：<a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/tokens-api/tokens_2021-03-01.md#method">メソッド</a></p></td><td>はい</td></tr><tr class="even"><td>パス</td><td><p>制限付きオペレーションからのパス。これは、以下のいずれかになります。</p><ul><li><p>出品者の注文ID、出荷ID、またはレポートドキュメントIDを含む特定のパス。例：<code>/orders/v0/orders/902-3159896-1390916/address</code>または<code>/mfn/v0/shipments/6f77095e-9f75-47eb-aaab-a42d5428fa1a</code></p></li><li><p>出品者の注文IDも出荷IDも含まない汎用パス。例：<code>/orders/v0/orders/{orderId}/address</code>または<code>/mfn/v0/shipments/{shipmentId}</code></p></li></ul><p>タイプ：文字列</p></td><td>はい</td></tr></tbody></table>

チュートリアル： トークンAPI用のJava SDKを生成する
================================================

以下の手順では、Microsoft Windowsを実行しているコンピューターで、[Swagger Code Generator](https://github.com/swagger-api/swagger-codegen)を使用してトークンAPI用のJava SDKを生成する方法を説明します。このプロセスは、macOSやLinuxなどの他のオペレーティングシステムのユーザーでも、Windows固有のセマンティクス（C:\\など）を置き換えることで応用できます。トークンAPIのSwaggerモデルについては、<https://github.com/amzn/selling-partner-api-models>を参照してください。

このSDKを使用すると、すでにセットアップされている次のコードを使用して、トークンAPIを呼び出すことができます。 Login with Amazonのトークン交換（リフレッシュトークンとアクセストークンの交換）と認証。

**LWAトークンの交換と認証を備えたJava SDKを生成するには**

1. [Java 8以降](https://www.oracle.com/technetwork/java/index.html)、[Apache Maven 3.6以降](http://maven.apache.org/)、[GNU Wget](https://www.gnu.org/software/wget/wget.html)をインストールし、$PATHで利用できるようにします。

2. <https://github.com/amzn/selling-partner-api-models>に進みます。

3. まだ実行していない場合は、リポジトリをクローンしてコンピュータにローカルコピーを作成します。

4. コマンドプロンプトウィンドウを開き、Swagger Code Generatorをダウンロードするディレクトリに移動します。

5. Swagger Code Generatorの最新バージョンをダウンロードします。

   例：
   ```
   wget https://repo1.maven.org/maven2/io/swagger/swagger-codegen-cli/2.4.13/swagger-codegen-cli-2.4.13.jar -O swagger-codegen-cli.jar
   ```
   **swagger-codegen-cli.jar**が現在のディレクトリにダウンロードされます。

   **注意：**また、ブラウザに以下のURLを指示することで、maven.orgからダウンロードすることもできます。<https://repo1.maven.org/maven2/io/swagger/swagger-codegen-cli/2.4.13/swagger-codegen-cli-2.4.13.jar>

6. **swagger-codegen-cli.jar**をディレクトリ構造にコピーすると、わかりやすくなります。この例では、C:\SwaggerToCLにコピーします。

7. リポジトリのローカルコピーの**selling-partner-api-models\models\tokens-api-model**フォルダで、**tokens_2021-03-01.json**に移動します。

8. **tokens_2021-03-01.json**をC:\SwaggerToCLにコピーします。

9. リポジトリのローカルコピーの**selling-partner-api-models\clients\sellingpartner-api-aa-java**フォルダ内のテンプレートに対してSDKを生成します。このフォルダには、認可および認証ライブラリと、Swagger Code Generator用のカスタマイズされたテンプレートが含まれています。

   例：
   ```
   java -jar C:\SwaggerToCL\swagger-codegen-cli.jar generate -i C:\SwaggerToCL\tokens_2021-03-01.json -l java -t [path to selling-partner-api-models\clients\sellingpartner-api-aa-java folder]\resources\swagger-codegen\templates\ -o C:\SwaggerToCL\Tokens_JavaCL
   ```
   SDKが、C:\SwaggerToCL\Tokens\_JavaCLにコピーされます。

10. AAライブラリを構築し、SDKの依存関係として追加します。

1. リポジトリのローカルコピーの**selling-partner-api-models\clients\sellingpartner-api-aa-java**フォルダに移動し、mvnパッケージを実行します。これにより、「target」という名前のフォルダが生成されます。このフォルダには、**sellingpartnerapi-aa-java-1.0-jar-with-dependencies.jar**（または類似のもの）という名前のJARファイルと、必要なすべての依存関係が含まれます。

2. JARファイルをローカルのMavenリポジトリにインストールします。

   例：
   ```
   mvn install:install-file -Dfile=[path to JAR file in "target" folder] -DgroupId=com.amazon.sellingpartnerapi -DartifactId=sellingpartnerapi-aa-java -Dversion=1.0 -Dpackaging=jar
   ```
   実際のgroupId、artifactId、およびversion値は、**selling-partner-api-models\clients\sellingpartner-api-aa-java**フォルダ内の**pom.xml**ファイルの上部付近にあります。

11. クライアントライブラリの**pom.xml**にAAライブラリへの依存関係を追加します。

例：

```
<dependency>
<groupId>com.amazon.sellingpartnerapi</groupId>
<artifactId>sellingpartnerapi-aa-java</artifactId>
<version>1.0</version>
</dependency>
```
12. 生成されたSDKフォルダ内で**mvnパッケージ**を実行します。

13. [restricted-data-token-workflow.java](https://github.com/amzn/selling-partner-api-models/commit/63a55cee11ca54caf8242884027a863860abaaf2)をダウンロードし、これを使用して、生成されたクライアントライブラリの**main/java/sampleCode/**フォルダ内にクラスを構築します。

これで、RDTを取得するためのワークフローをテストし、それを使用して1つまたは複数の制限付きオペレーションを呼び出すことができるようになりました。このコードを参考に、ご自身のアプリケーションを構築してください。

トークンAPIのPostmanコレクション
=============================

[トークンAPIのPostmanコレクション](https://github.com/amzn/selling-partner-api-models/blob/main/clients/postman-collections/tokens-api-sandbox-postman-collection.json)を使用して、出品パートナーAPIのサンドボックス環境でトークンAPIをテストできます。サンドボックスを使用したテストの詳細については、開発者ガイドの[出品パートナーAPIサンドボックス](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md#the-selling-partner-api-sandbox)を参照してください。