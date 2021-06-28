دليل حالة استخدام واجهة برمجة التطبيقات (API) الخاصة بالرموز
=========================

الإصدار: ‎2021-03-01

ما واجهة برمجة التطبيقات (API) الخاصة بالرموز؟
=======================

تتيح واجهة برمجة التطبيقات (API) لشركاء البيع الخاصة بالرموز (واجهة برمجة التطبيقات (API) الخاصة بالرموز) الوصول الآمن إلى معلومات التعريف الشخصية للعميل (PII). يمكنك استدعاء واجهة برمجة التطبيقات (API) الخاصة بالرموز للحصول على رمز بيانات مقيد (RDT) لمورد أو أكثر من الموارد المقيدة التي تحددها. يسمح لك رمز البيانات المقيد (RDT) بإجراء استدعاءات متتالية للعمليات المقيدة التي تمثلها الموارد المقيدة. راجع المصطلحات.

عند استدعاء عملية مقيدة، تقوم بتضمين رمز بيانات مقيد (RDT) في` العنوان الرئيسي `x-amz-access-token. ويكون هذا على النقيض من جميع عمليات SP-API الأخرى، حيث تقوم بتضمين رمز وصول LWA في` العنوان الرئيسي `x-amz-access-token. للاطلاع على مزيد من المعلومات، راجع [الخطوة 3. إضافة عناوين رئيسية إلى URI](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md#step-3-add-headers-to-the-uri).

المصطلحات
-----------

- **رمز البيانات المقيد (RDT)**. رمز وصول قصير الأجل يسمح لك باستدعاء عمليات مقيدة

- **العملية المقيدة.** عملية تقوم بإرجاع بيانات مقيدة، مثل معلومات التعريف الشخصية (PII). تحتاج إلى رمز بيانات مقيد (RDT) لاستدعاء عملية مقيدة. راجع [العمليات المقيدة](#العمليات-المقيدة).

- **المورد المقيد.** أسلوب HTTP والمسار اللذان يمثلان عملية مقيدة.

- **نوع التقرير المقيد.** نوع التقرير الذي يحتوي على معلومات التعريف الشخصية (PII). راجع أنواع-التقارير-الم

- **المسار المحدد.** مسار في مورد مقيد يحتوي على معرف طلب أو معرف شحنة محدد. على سبيل المثال، `orders/v0/orders/902-3159896-1390916/address`

- **المسار العام.** مسار في مورد مقيد لا يحتوي على معرف طلب أو معرف شحنة محدد. وبدلاً من ذلك، فإنه يحتوي على السلسلة `{orderId}` أو `{shipmentId}`. على سبيل المثال، `orders/v0/orders/{orderId}/address`

العمليات المقيدة
=====================

عمليات مقيدة تقوم بإرجاع معلومات التعريف الشخصية (PII) الخاصة بالعملاء. للاطلاع على مزيد من المعلومات حول استدعاء العمليات المقيدة، راجع [البرنامج التعليمي: الحصول على رمز بيانات مقيد (RDT) واستدعاء ع.

فيما يأتي قائمة بالعمليات المقيدة، تم تجميعها حسب واجهة برمجة التطبيقات (API):

واجهة برمجة التطبيقات (API) الخاصة بالطلبات:

- ```getOrderBuyerInfo```

- ```getOrderAddress```

- ```getOrderItemsBuyerInfo```

واجهة برمجة التطبيقات (API) الخاصة بالشحنة:

- ```getShipment```

واجهة برمجة التطبيقات (API) للشحن من التاجر:

- ```getShipment```

- ```cancelShipment```

- ```cancelShipmentOld```

- ```createShipment```

واجهة برمجة التطبيقات (API) الخاصة بالتقارير:

- ```getReportDocument```

   **ملحوظات:**

   - تعد عملية GetReportDocument عملية مقيدة فقط عند تحديد تقرير مقيد. راجع قائمة أنواع التقارير المقيدة الواردة أدناه.

   - عند استدعاء عملية createRestrictedDataToken للحصول على رمز بيانات مقيد (RDT) لعملية getReportDocument، قد يحتوي المورد المقيد المحدد على مسار محدد فقط، وليس مسارًا عامًا. للاطلاع على مزيد من المعلومات، راجع البرنامج التعليمي: الحصول على رمز بيانات مقيد (RDT) واستدعاء ا و[المصطلحات](#المصطلحات).

أنواع التقارير المقيدة
-----------------------

تحتوي أنواع التقارير المقيدة على معلومات التعريف الشخصية (PII). عند تحديد نوع تقرير مقيد ضمن عملية استدعاء لعملية getReportDocument، يجب تمرير رمز بيانات مقيد (RDT) ضمن الاستدعاء. للاطلاع على مزيد من المعلومات، راجع [البرنامج التعليمي: الحصول على رمز بيانات مقيد (RDT) واستدعاء.

فيما يأتي قائمة بأنواع التقارير المقيدة:

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

البرنامج التعليمي: الحصول على رمز بيانات مقيد (RDT) واستدعاء العمليات المقيدة
===================================================

يوضح لك هذا البرنامج التعليمي كيفية استخدام واجهة برمجة التطبيقات (API) الخاصة بالرموز للحصول على رمز بيانات مقيد (RDT) ثم استخدام رمز البيانات المقيد (RDT) لاستدعاء عمليات مقيدة.

**المتطلبات الأساسية**

لإكمال هذا البرنامج التعليمي، ستحتاج إلى:

- إذن من شريك البيع الذي تقوم بإجراء مكالمات بالنيابة عنه. راجع [دليل مطوّر واجهة برمجة التطبيقات (API) لشركاء البيع](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md) لمزيد من المعلومات.

الخطوة 1. الحصول على رمز بيانات مقيد (RDT)
------------------

استدعاء عملية createRestrictedDataToken للحصول على رمز بيانات مقيد (RDT).

- استدعاء عملية [createRestrictedDataToken](https://github.com/amzn/selling-partner-api-docs/blob/main/references/tokens-api/tokens_2021-03-01.md#createrestricteddatatoken) مع تمرير المعلمات الآتية:

معلمات المحتوى:

| المعلمة | الوصف | النوع | مطلوب |
|-----------|-------------|------|----------|
| restrictedResources | نموذج مورد مقيد.</br> الحد الأقصى: 50 | <a href="#restrictedresources">restrictedResources</a> | نعم |

مثال على الطلب:
```
POST https://sellingpartnerapi-na.amazon.com/tokens/2021-03-01/restrictedDataToken
{
	«restrictedResources»: [{
		«الأسلوب»: «الحصول على»،
		«المسار»: "/orders/v0/orders/902-3159896-1390916/address"
	}، {
		«الأسلوب»: «الحصول على»،
		«المسار»: "/orders/v0/orders/{orderId}/buyerInfo"
	}، {
		«الأسلوب»: «الحصول على»،
		«المسار»: "/mfn/v0/shipments/{shipmentId}"
	}]
}
```
**الاستجابة**

تتضمن الاستجابة الناجحة ما يأتي:

| الاسم | العنوان 2 | النوع |
|----------|----------|------|
| restrictedDataToken | رمز بيانات مقيد (RDT). هو رمز وصول قصير الأجل يسمح لك باستدعاء العمليات المقيدة التي تمثلها الموارد المقيدة التي حددتها. قم بتمرير قيمة رمز البيانات المقيد (RDT) في العنوان <code>x-amzn-access-token</code> عند إجراء استدعاءات متتالية للعمليات المقيدة. | السلسلة |
| expiresIn | مدة استخدام رمز البيانات المقيد (RDT)، بالثواني. | العدد الصحيح |

مثال على الاستجابة:
```
{
	«الحمولة»: {
		«restrictedDataToken»: «Atz.sprdt|IQEBLjAsAhRmHjNgHpi0U-Dme37rR6CuUpSR»،
		"expiresIn": 3600
	}
}
```
لديك الآن رمز بيانات مقيد (RDT) الذي يسمح لك باستدعاء العمليات المقيدة الآتية:

- **getOrderAddress.** يمكنك استدعاء عملية getOrderAddress باستخدام المسار المحدد من المورد المقيد الذي حددته. على سبيل المثال، `/orders/v0/orders/902-3159896-1390916/address`.

- **getOrderBuyerInfo.** يمكنك استدعاء عملية getOrderBuyerInfo باستخدام المسار العام من المورد المقيد الذي حددته، مع استبدال `{orderId}` بمعرف طلب من شريك البيع. على سبيل المثال، `/orders/v0/orders/058-1233752-8214740/buyerInfo` and `/orders/v0/orders/483-3488972-0896720/buyerInfo`. يمكنك استخدام رمز البيانات المقيد (RDT) لأي من معرفات طلب شريك البيع.

- **getShipment.** يمكنك استدعاء عملية getShipment باستخدام المسار العام من المورد المقيد الذي حددته، مع استبدال `{shipmentId}` بمعرف شحنة من شريك البيع. على سبيل المثال، `/mfn/v0/shipments/6f77095e-9f75-47eb-aaab-a42d5428fa1a`. يمكنك استخدام رمز البيانات المقيد (RDT) لأي من معرفات شحنة شريك البيع.

للاطلاع على مزيد من المعلومات، راجع المصطلحات.

الخطوة 2. استدعاء العمليات المقيدة
----------------------------------

استدعاء العمليات المقيدة التي ورد رمز البيانات المقيد (RDT) الخاص بها في الخطوة 1. الحصول على رمز بيانات مقيد (RDT)(#ا مسموح لك باستخدامه. عند استدعاء العمليات المقيدة، قم بتضمين رمز البيانات المقيد (RDT) في العنوان `x-amz-access-token`. للاطلاع على مزيد من المعلومات، راجع [الخطوة 3. إضافة عناوين رئيسية إلى URI](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md#step-3-add-headers-to-the-uri).

أمثلة على الطلب:
```
GET https://sellingpartnerapi-na.amazon.com/orders/v0/orders/orders/v0/orders/902-3159896-1390916/address.

GET https://sellingpartnerapi-na.amazon.com/orders/v0/orders/902-3159896-1390916/buyerInfo

GET https://sellingpartnerapi-na.amazon.com/orders/v0/orders/483-3488972-0896720/buyerInfo

GET https://sellingpartnerapi-na.amazon.com/mfn/v0/shipments/6f77095e-9f75-47eb-aaab-a42d5428fa1a
```
Datatypes
---------

### restrictedResources

<table><thead><tr class="header"><th><strong>الوصف</strong></th><th><strong>المعلمة</strong></th><th><strong>المطلوب</strong></th></tr></thead><tbody><tr class="odd"><td>الأسلوب</td><td><p>يُستخدم أسلوب HTTP مع الموارد المقيدة.</p><p>النوع: <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/tokens-api/tokens_2021-03-01.md#method">الأسلوب</a></p></td><td>نعم</td></tr><tr class="even"><td>المسار</td><td><p>المسار الوارد من العملية المقيدة. قد يكون هذا:</p><ul><li><p>مسارًا محددًا يحتوي على معرف طلب البائع، أو معرف الشحنة، أو مستند التقرير، على سبيل المثال <code>/orders/v0/orders/902-3159896-1390916/address</code> or <code>/mfn/v0/shipments/6f77095e-9f75-47eb-aaab-a42d5428fa1a</code></p></li><li><p>مسارًا عامًا لا يحتوي على معرف طلب البائع، أو معرف الشحنة، على سبيل المثال <code>/orders/v0/orders/{orderId}/address</code> or <code>/mfn/v0/shipments/{shipmentId}</code></p></li></ul><p>النوع: سلسلة</p></td><td>نعم</td></tr></tbody></table>

البرنامج التعليمي: إنشاء Java SDK لواجهة برمجة التطبيقات (API) الخاصة بالرموز
================================================

توضح لك هذه التعليمات كيفية إنشاء Java SDK لواجهة برمجة التطبيقات (API) الخاصة بالرموز باستخدام [منشئ رمز Swagger](https://github.com/swagger-api/swagger-codegen) على جهاز كمبيوتر يعمل بنظام التشغيل Microsoft Windows. العملية هي نفسها لمستخدمي أنظمة التشغيل الأخرى مثل macOS أو Linux، مع استبدال دلالات Windows الخاصة (على سبيل المثال، C:\\‎). راجع <https://github.com/amzn/selling-partner-api-models> نموذج Swagger لواجهة برمجة التطبيقات (API) الخاصة بالرموز.

باستخدام SDK هذا، يمكنك إجراء استدعاءات لواجهة برمجة التطبيقات (API) الخاصة بالرموز باستخدام الرمز التالي الذي تم إعداده لك بالفعل: تبادل الرمز Login with Amazon (تبادل رمز محدث مقابل رمز وصول) والمصادقة.

**لإنشاء Java SDK مع تبادل الرمز LWA والمصادقة**

1. قم بتثبيت [Java إصدار 8 أو الأحدث](https://www.oracle.com/technetwork/java/index.html)، و[Apache Maven إصدار3.6 أو الأحدث](http://maven.apache.org/)، و[GNU Wget](https://www.gnu.org/software/wget/wget.html) وجعلها متاحة في ‎$PATH الخاص بك.

2. انتقل إلى <https://github.com/amzn/selling-partner-api-models>.

3. انسخ المستودع لعمل نسخة محلية على جهاز الكمبيوتر الخاص بك، إذا لم تكن قد فعلت ذلك بالفعل.

4. افتح نافذة موجه الأوامر وانتقل إلى دليل حيث ترغب في تنزيل منشئ رمز Swagger.

5. قم بتنزيل أحدث إصدار من منشئ رمز Swagger.

   على سبيل المثال:
   ```
   wget https://repo1.maven.org/maven2/io/swagger/swagger-codegen-cli/2.4.13/swagger-codegen-cli-2.4.13.jar -O swagger-codegen-cli.jar
   ```
   **swagger-codegen-cli.jar** يقوم بالتنزيل إلى الدليل الحالي.

   **ملحوظة:** يمكنك أيضًا التنزيل من maven.org من خلال توجيه المتصفح الخاص بك هنا: <https://repo1.maven.org/maven2/io/swagger/swagger-codegen-cli/2.4.13/swagger-codegen-cli-2.4.13.jar>

6. انسخ **swagger-codegen-cli.jar** إلى بنية الدليل المنطقي بالنسبة إليك. بالنسبة إلى هذا المثال، سننسخه إلى C:\SwaggerToCL.

7. انتقل إلى **tokens_2021-03-01.json** في المجلد **selling-partner-api-models\models\tokens-api-model** من النسخة المحلية من المستودع الخاص بك.

8. انسخ **tokens_2021-03-01.json** إلى C:\SwaggerToCL.

9. قم بإنشاء SDK على القوالب الموجودة في المجلد **selling-partner-api-models\clients\sellingpartner-api-aa-java folder** من النسخة المحلية من المستودع الخاص بك. يحتوي هذا المجلد على مكتبة الترخيص والمصادقة، بالإضافة إلى قوالب مخصصة لمنشئ رمز Swagger.

   على سبيل المثال:
   ```
   java -jar C:\SwaggerToCL\swagger-codegen-cli.jar generate -i C:\SwaggerToCL\tokens_2021-03-01.json -l java -t [path to selling-partner-api-models\clients\sellingpartner-api-aa-java folder]\resources\swagger-codegen\templates\ -o C:\SwaggerToCL\Tokens_JavaCL
   ```
   تم نسخ SDK إلى C:\SwaggerToCL\Tokens_JavaCL

10. قم بإنشاء مكتبة الترخيص والمصادقة وإضافتها كتبعية لـ SDK:

1. انتقل إلى المجلد **selling-partner-api-models\clients\sellingpartner-api-aa-java** من النسخة المحلية من المستودع الخاص بك وقم بتشغيل حزمة mvn. يقوم هذا بإنشاء مجلد يحمل اسم «الهدف». يوجد في هذا المجلد ملف بتنسيق JAR اسمه **sellingpartnerapi-aa-java-1.0-jar-with-dependencies.jar** (أو شيء مشابه) وكل التبعيات المطلوبة.

2. قم بتثبيت ملف JAR في مستودع Maven المحلي الخاص بك.

   على سبيل المثال:
   ```
   mvn install:install-file -Dfile=[path to JAR file in "target" folder] -DgroupId=com.amazon.sellingpartnerapi -DartifactId=sellingpartnerapi-aa-java -Dversion=1.0 -Dpackaging=jar
   ```
   يمكنك العثور على groupId وartifactId وقيم الإصدار الفعلية، بالقرب من قمة الملف **pom.xml** في المجلد **selling-partner-api-models\clients\sellingpartner-api-aa-java**.

11. أضف تبعية إلى مكتبة الترخيص والمصادقة في مكتبة العميل **pom.xml**:

على سبيل المثال:

```
<dependency>
<groupId>com.amazon.sellingpartnerapi</groupId>
<artifactId>sellingpartnerapi-aa-java</artifactId>
<version>1.0</version>
</dependency>
```
12. قم بتشغيل **حزمة mvn** داخل مجلد SDK الذي تم إنشاؤه.

13. قم بتنزيل [restricted-data-token-workflow.java](https://github.com/amzn/selling-partner-api-models/commit/63a55cee11ca54caf8242884027a863860abaaf2) واستخدمه لإنشاء فئة داخل المجلد **main/java/sampleCode/** من مكتبة العميل التي تم إنشاؤها.

يمكنك الآن بدء اختبار سير العمل للحصول على رمز بيانات مقيد (RDT) واستخدامه لاستدعاء عملية أو أكثر من العمليات المقيدة. استخدم هذا الرمز لإرشادك في إنشاء تطبيقاتك الخاصة.

مجموعة واجهة برمجة التطبيقات (API) الخاصة بالرموز لساعي البريد
=============================

يمكنك استخدام [مجموعة واجهة برمجة التطبيقات (API) الخاصة بالرموز لساعي البريد](https://github.com/amzn/selling-partner-api-models/blob/main/clients/postman-collections/tokens-api-sandbox-postman-collection.json) لاختبار واجهة برمجة التطبيقات (API) في بيئة وضع الحماية لواجهة برمجة التطبيقات (API) لشركاء البيع. للاطلاع على مزيد من المعلومات حول الاختبار باستخدام وضع الحماية، راجع [وضع الحماية لواجهة برمجة التطبيقات (API) لشركاء البيع](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md#the-selling-partner-api-sandbox) في دليل المطوِّر.