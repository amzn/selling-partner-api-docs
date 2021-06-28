Kodlar API'si Kullanım Olayı Rehberi
=========================

Sürüm: 01-03-2021

Kodlar API'si nedir?
=======================

Kodlar için Satış Ortağı API'si (Kodlar API'si), müşterinin Kişisel Olarak Tanımlanabilir Bilgilerine (PII) erişmek için güvenli bir yol sağlar. Belirttiğiniz bir veya daha fazla kısıtlı kaynak için Kısıtlı Veri Kodu (RDT) almak amacıyla Kodlar API'sini çağırabilirsiniz. RDT, kısıtlı kaynakların temsil ettiği kısıtlı işlemlere ardışık çağrılar yapmanıza izin verir. Bkz. [Terminoloji](#terminoloji).

Kısıtlı bir işlemi çağırdığınızda `x-amz-access-token` başlığına bir RDT eklemiş olursunuz. Bu, `x-amz-access-token` başlığına bir LWA erişim kodu eklediğiniz diğer tüm SP-API işlemlerinden farklı olarak gerçekleştirilmektedir. Daha fazla bilgi için bkz. [Adım 3. URI'ye başlık ekleme](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md#adım-3-uri'ye-başlık-ekleme).

Terminoloji
-----------

- **Kısıtlı Veri Kodu (RDT)**. Kısıtlı işlemleri çağırmanıza izin veren kısa ömürlü bir erişim kodu.

- **Kısıtlı işlem.** Kişisel Olarak Tanımlanabilir Bilgiler (PII) gibi kısıtlı verileri geri döndüren bir işlem. Kısıtlı bir işlemi çağırmak için bir RDT'ye ihtiyacınız vardır. Bkz. [Kısıtlı işlemler](#kısıtlı-işlemler).

- **Kısıtlı kaynak.** Kısıtlı bir işlemi temsil eden bir HTTP yöntemi ve yolu.

- **Kısıtlı rapor türü.** PII içeren bir rapor türü. Bkz. [Kısıtlı rapor türleri](#kısıtlı-rapor-türleri)

- **Belirli yol.** Belirli bir sipariş kimliği veya kargo kimliği içeren kısıtlı bir kaynaktaki yol. Örneğin, `orders/v0/orders/902-3159896-1390916/address`

- **Genel yol.** Belirli bir sipariş kimliği veya kargo kimliği içermeyen kısıtlı bir kaynaktaki yol. Bunun yerine, `{orderId}` veya `{shipmentId}` dizesini içerir. Örneğin, `orders/v0/orders/{orderId}/address`

Kısıtlı işlemler
=====================

Kısıtlı işlemler müşterilerin Kişisel Olarak Tanımlanabilir Bilgilerini (PII) geri döndürür. Kısıtlı işlemleri arama hakkında daha fazla bilgi için bkz. [Öğretici: RDT alma ve kısıtlı işlemleri çağırma](#rdt-alma-ve-kısıtlı-işlemleri-çağırma-öğreticisi).

API'ye göre gruplandırılmış kısıtlı işlemlerin listesi aşağıdadır:

Siparişler API'si:

- ```getOrderBuyerInfo```

- ```getOrderAddress```

- ```getOrderItemsBuyerInfo```

Kargo API'si:

- ```getShipment```

Satıcıdan Gönderim API'si:

- ```getShipment```

- ```cancelShipment```

- ```cancelShipmentOld```

- ```createShipment```

Raporlar API'si:

- ```getReportDocument```

   **Notlar:**

   - getReportDocument işlemi, yalnızca kısıtlı bir rapor belirtildiğinde kısıtlı bir işlem olarak kabul edilir. Aşağıdaki kısıtlı rapor türlerinin listesine göz atın.

   - getReportDocument işlemi için bir RDT almak amacıyla createRestrictedDataToken işlemini çağırırken, belirtilen kısıtlı kaynak, genel bir yol değil, yalnızca belirli bir yol içerebilir. Daha fazla bilgi için bkz. [Öğretici: RDT alma ve kısıtlı işlemleri çağırma](#öğretici-rdt-alma-ve-kısıtlı-işlemleri-çağırma) ve [Terminoloji](#terminoloji)

Kısıtlı rapor türleri
-----------------------

Kısıtlı rapor türleri PII içerir. getReportDocument işlemine yapılan bir çağrıda kısıtlı bir rapor türü belirtirken, çağrıyla birlikte bir RDT iletmeniz gerekir. Daha fazla bilgi için bkz. [Öğretici: RDT alma ve kısıtlı işlemleri çağırma](#öğretici-rdt-alma-ve-kısıtlı-işlemleri-çağırma).

Kısıtlı rapor türlerinin listesi aşağıda verilmiştir:

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

Öğretici: RDT alma ve kısıtlı işlemleri çağırma
===================================================

Bu öğretici, Kısıtlı Veri Kodu (RDT) almak için Kodlar API'sini ve kısıtlı işlemleri çağırmak için RDT'yi nasıl kullanacağınızı gösterir.

**Ön koşullar**

Bu öğreticiyi tamamlamak için şunlara ihtiyacınız olacak:

- Adına çağrı yaptığınız Satış Ortağından yetkilendirme. Daha fazla bilgi için bkz. [Satış Ortağı API'si Geliştirici Rehberi](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md).

Adım 1. RDT alma
------------------

Bir RDT almak için createRestrictedDataToken işlemini çağırın.

- Aşağıdaki parametreleri ileterek [createRestrictedDataToken](https://github.com/amzn/selling-partner-api-docs/blob/main/references/tokens-api/tokens_2021-03-01.md#createrestricteddatatoken) işlemini çağırın:

Gövde parametreleri:

| Parametre | Açıklama | Tür | Gerekli |
|-----------|-------------|------|----------|
| restrictedResources | Kısıtlı bir kaynağın modeli.</br> Maksimum: 50 | <a href="#restrictedresources">restrictedResources</a> | Evet |

Talep Örneği:
```
POST https://sellingpartnerapi-na.amazon.com/tokens/2021-03-01/restrictedDataToken
{
	"restrictedResources": [{
		"method": "GET",
		"path": "/orders/v0/orders/902-3159896-1390916/adres"
	}, {
		"method": "GET",
		"path": "/orders/v0/orders/ {orderId} /buyerInfo"
	}, {
		"method": "GET",
		"path": "/mfn/v0/shipments/ {shipmentId}"
	}]
}
```
**Yanıt**

Başarılı bir yanıt aşağıdakileri içerir:

| Ad | Başlık 2 | Tür |
|----------|----------|------|
| restrictedDataToken | Bir Kısıtlı Veri Kodu (RDT). Bu, belirttiğiniz kısıtlı kaynaklarla temsil edilen kısıtlı işlemleri çağırmanıza izin veren kısa ömürlü bir erişim kodudur. Kısıtlı işlemlere ardışık çağrılar yaparken <code>x-amzn-access-token</code> başlığındaki RDT değerini iletin. | string |
| expiresIn | RDT'nin saniyelerle belirtilen ömrü. | integer |

Yanıt Örneği:
```
{
	"payload": {
		"restrictedDataToken": "Atz.sprdt|IQEBLjAsAhRmHjNgHpi0U-Dme37rR6CuUpSR",
		"expiresIn": 3600
	}
}
```
Artık aşağıdaki kısıtlı işlemleri çağırmak için size yetki veren bir RDT'niz var:

- **getOrderAddress.** Belirttiğiniz kısıtlı kaynaktaki belirli yolu kullanarak getOrderAddress işlemini çağırabilirsiniz. Örneğin, `/orders/v0/orders/902-3159896-1390916/address`.

- **getOrderBuyerInfo.** Belirttiğiniz kısıtlı kaynaktaki genel yolu kullanarak getOrderBuyerInfo işlemini çağırabilir ve `{orderId}` ile satış ortağından aldığınız sipariş kimliğini değiştirebilirsiniz. Örneğin, `/orders/v0/orders/058-1233752-8214740/buyerInfo` ve `/orders/v0/orders/483-3488972-0896720/buyerInfo`. RDT'yi satış ortağının sipariş kimliklerinden biri için kullanabilirsiniz.

- **getShipment.** Belirttiğiniz kısıtlı kaynaktan genel yolu kullanarak getShipment işlemini çağırabilir ve `{shipmentId}` ile satış ortağından gelen bir kargo kimliğini değiştirebilirsiniz. Örneğin, `/mfn/v0/shipments/6f77095e-9f75-47eb-aaab-a42d5428fa1a`. RDT'yi, satış ortağının kargo kimliklerinden biri için kullanabilirsiniz.

Daha fazla bilgi için bkz. [Terminoloji](#terminoloji).

Adım 2. Kısıtlı işlemleri çağırma
----------------------------------

[Adım 1. RDT alma](#adım-1-rdt-alma) aşamasında RDT'nin sizi yetkilendirdiği kısıtlı işlemleri çağırın. Kısıtlı işlemleri çağırırken, RDT'yi `x-amz-access-token` başlığına dahil edin. Daha fazla bilgi için bkz. [Adım 3. URI'ye başlık ekleme](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md#adım-3-uri'ye-başlık-ekleme).

Talep Örnekleri:
```
GET https://sellingpartnerapi-na.amazon.com/orders/v0/orders/orders/v0/orders/902-3159896-1390916/address.

GET https://sellingpartnerapi-na.amazon.com/orders/v0/orders/902-3159896-1390916/buyerInfo

GET https://sellingpartnerapi-na.amazon.com/orders/v0/orders/483-3488972-0896720/buyerInfo

GET https://sellingpartnerapi-na.amazon.com/mfn/v0/shipments/6f77095e-9f75-47eb-aaab-a42d5428fa1a
```
Datatype'lar
---------

### restrictedResources

<table><thead><tr class="header"><th><strong>Parametre</strong></th><th><strong>Açıklama</strong></th><th><strong>Gerekli</strong></th></tr></thead><tbody><tr class="odd"><td>method</td><td><p>Kısıtlı kaynakla kullanılan HTTP yöntemi.</p><p>Tür: <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/tokens-api/tokens_2021-03-01.md#method">Method</a></p></td><td>Evet</td></tr><tr class="even"><td>yol</td><td><p>Kısıtlı bir işlemden gelen yol. Şunlar olabilir:</p><ul><li><p>Bir satıcının sipariş kimliği, kargo kimliği veya rapor doküman kimliğini içeren özel bir yol, örneğin <code>/orders/v0/orders/902-3159896-1390916/address</code> veya <code>/mfn/v0/shipments/6f77095e-9f75-47eb-aaab-a42d5428fa1a</code></p></li><li><p>Bir satıcının sipariş kimliği veya kargo kimliğini içermeyen genel bir yol, örneğin <code>/orders/v0/orders/{orderId}/address</code> veya <code>/mfn/v0/shipments/{shipmentId}</code></p></li></ul><p>Tür: string</p></td><td>Yes</td></tr></tbody></table>

Öğretici: Kodlar API'si için Java SDK oluşturma
================================================

Bu talimatlar, Microsoft Windows kullanılan bir bilgisayarda [Swagger Code Generator](https://github.com/swagger-api/swagger-codegen) kullanılarak Kodlar API'si için Java SDK'sı oluşturmayı gösterir. İşlem, macOS veya Linux gibi diğer işletim sistemlerinin kullanıcıları için Windows'a özgü semantiğin (örneğin, C:\\) değiştirilmesiyle aynıdır. Kodlar API'si Swagger modeli için bkz. <https://github.com/amzn/selling-partner-api-models>.

Bu SDK ile, sizin için önceden ayarlanmış olan aşağıdaki kodla Kodlar API'sine çağrı yapabilirsiniz: Amazon kod değişimi ile giriş yapma (erişim kodu karşılığında yenileme kodu) ve kimlik doğrulama.

**LWA kodu değişimi ve kimlik doğrulaması içeren bir Java SDK'sı oluşturmak için**

1. [Java 8 veya daha üst sürümünü](https://www.oracle.com/technetwork/java/index.html), [Apache Maven 3.6. veya üstünü](http://maven.apache.org/) ve [GNU Wget'i](https://www.gnu.org/software/wget/wget.html) yükleyin ve bunları $PATH içinde kullanılabilir hale getirin.

2. Şu adrese gidin: <https://github.com/amzn/selling-partner-api-models>.

3. Daha önce yapmadıysanız bilgisayarınızda yerel bir kopya oluşturmak için depoyu klonlayın.

4. Bir komut istemi penceresi açın ve Swagger Code Generator'ı indirmek istediğiniz dizine gidin.

5. Swagger Code Generator'ın en son sürümünü indirin.

   Örneğin:
   ```
   wget https://repo1.maven.org/maven2/io/swagger/swagger-codegen-cli/2.4.13/swagger-codegen-cli-2.4.13.jar -O swagger-codegen-cli.jar
   ```
   **swagger-codegen-cli.jar** geçerli dizine indirilir.

   **Not:** Ayrıca tarayıcınızı şuradan yönlendirerek maven.org'dan da indirebilirsiniz: <https://repo1.maven.org/maven2/io/swagger/swagger-codegen-cli/2.4.13/swagger-codegen-cli-2.4.13.jar>

6. **swagger-codegen-cli.jar** dosyasını size göre mantıklı olan bir dizin yapısına kopyalayın. Bu örnekte, C:\SwaggerToCL. konumuna kopyalayacağız

7. Depodaki yerel kopyanızın **selling-partner-api-models\models\tokens-api-model** klasöründeki **tokens_2021-03-01.json** konumuna gidin.

8. **tokens_2021-03-01.json** dosyasını C:\SwaggerToCL. içine kopyalayın

9. Depodaki yerel kopyanızda **selling-partner-api-models\clients\sellingpartner-api-aa-java klasöründeki** şablonlara karşılık gelen SDK'yı oluşturun. Bu klasör, Swagger Code Generator için özelleştirilmiş şablonlarla birlikte yetkilendirme ve kimlik doğrulama kitaplığı içerir.

   Örneğin:
   ```
   java -jar C:\SwaggerToCL\swagger-codegen-cli.jar generate -i C:\SwaggerToCL\tokens_2021-03-01.json -l java -t [path to selling-partner-api-models\clients\sellingpartner-api-aa-java folder]\resources\swagger-codegen\templates\ -o C:\SwaggerToCL\Tokens_JavaCL
   ```
   SDK C:\SwaggerToCL\Tokens_JavaCL konumuna kopyalanır

10. AA Kitaplığını oluşturun ve SDK'ya destek dosyası olarak ekleyin:

1. Deponun yerel kopyasının **selling-partner-api-models\clients\sellingpartner-api-aa-java** klasörüne gidin ve mvn paketini çalıştırın. Bu, "target" adlı bir klasör oluşturur. Bu klasörde **sellingpartnerapi-aa-java-1.0-jar-with-dependencies.jar** (veya benzeri) adlı bir JAR dosyası ve tüm gerekli destek dosyaları bulunur.

2. JAR dosyasını yerel Maven deposuna yükleyin.

   Örneğin:
   ```
   mvn install:install-file -Dfile=["target" klasöründeki JAR dosyasına giden yol] -DgroupId=com.amazon.sellingpartnerapi -DartifactId=sellingpartnerapi-aa-java -Dversion=1.0 -Dpackaging=jar
   ```
   **selling-partner-api-models\clients\sellingpartner-api-aa-java** klasöründe **pom.xml** dosyasının üst kısmına yakın yerde asıl grup, artifactid ve sürüm değerlerini bulabilirsiniz.

11. İstemci kitaplığının **pom.xml** dosyasındaki AA kitaplığına destek dosyası ekleyin:

Örneğin:

```
<dependency>
<groupId>com.amazon.sellingpartnerapi</groupId>
<artifactId>sellingpartnerapi-aa-java</artifactId>
<version>1.0</version>
</dependency>
```
12. Oluşturulan SDK klasörünün içinde **mvn paketini** çalıştırın.

13. [restricted-data-token-workflow.java](https://github.com/amzn/selling-partner-api-models/commit/63a55cee11ca54caf8242884027a863860abaaf2) dosyasını indirin ve oluşturulan istemci kütüphanesinin **main/java/sampleCode/** klasöründe bir sınıf oluşturmak için kullanın.

Artık bir RDT almak için iş akışını test etmeye ve bir veya daha fazla kısıtlı işlemi çağırmak için kullanmaya başlayabilirsiniz. Kendi uygulamalarınızı oluştururken size rehberlik etmesi için bu kodu kullanın.

Kodlar API'si Postman koleksiyonu
=============================

Satış Ortağı API'si korumalı alanındaki Kodlar API'sini test etmek için [Kodlar API'si Postman koleksiyonunu](https://github.com/amzn/selling-partner-api-models/blob/main/clients/postman-collections/tokens-api-sandbox-postman-collection.json) kullanabilirsiniz. Korumalı alan ile test etme hakkında daha fazla bilgi için Geliştirici Rehberinde [Satış Ortağı API'si korumalı alanı](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md#satış-ortağı-api'si-korumalı-alanı) bölümüne göz atın.