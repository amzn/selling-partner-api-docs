# Amazon MWS'den Satış Ortağı API'sine Geçiş Kılavuzu

# Genel bakış
Bu belgede Satış Ortağı API'sinin ne olduğu, Amazon Pazaryeri Web Hizmeti'nden (Amazon MWS) farklarını ve Amazon MWS uygulamanızı Satış Ortağı API uygulamasına nasıl dönüştüreceğiniz anlatılmaktadır.

# Satış Ortağı API'si nedir?
Satış Ortağı API'si, Amazon'un satış ortaklarının liste kayıtları, siparişler, ödemeler, raporlar ve daha fazlası üzerindeki verilerine programlı olarak erişmesine yardımcı olan REST tabanlı bir API'dir. Satış Ortağı API'si, Amazon MWS'nin modernleştirilmiş bir halidir ve daha önce Amazon MWS'de kullanılabilen tüm işlevleri içerir. Gelecekteki tüm geliştirmeler yalnızca Satış Ortağı API'sinde kullanılabilecektir.

## Satış Ortağı API'sinin özellikleri
Her Satış Ortağı API'si için bir Swagger modeli, bir API başvurusu ve bazı durumlarda Kullanım Örneği Kılavuzu bulunur. Ayrıca, Satış Ortağı API'lerine yapılan çağrıların kimlik doğrulaması konusunda yardımcı olan istemci kitaplıkları da bulunmaktadır.

Satış Ortağı API'sinin yeni özelliklerinden bazıları şunlardır:
* REST tabanlı ve JSON biçimli giriş ve çıkış.
* Tüm bölgelerde desteklenen yeni uç noktalar.
* Otomatik SDK üretimi için Satış Ortağı API Geliştirici Rehberi'nde adım adım yönergeler.
* Sahte verilerle test etmek için ayrı korumalı alan uç noktalarına sahip korumalı alan özelliği.
* Çeşitli önlemlere dayalı olarak her satış ortağı için fiyat sınırlarını otomatik olarak ayarlayan dinamik bir kullanım planı.
* Satış Ortağı API'si uygulamaları tüm bölgelerde geçerlidir.
* Müşterilerin Kişisel Olarak Tanımlanabilir Bilgilerini (PII) korumaya yardımcı olan Kısıtlı Veri Kodları Desteği.

Yeni ve güncelleştirilmiş Satış Ortağı API'leri:
* **A+ İçerik API'si.** Satış ortaklarının A+ içerik oluşturmasına ve düzenlemesine olanak sağlar.
* **Yetki API'si.** Mevcut bir MWS Auth Token'ı Satış Ortağı API yetkilendirme koduyla değiştirir.
* **Katalog Öğeleri API'si.** Amazon kataloğu hakkında ayrıntılı bilgi sağlar.
* **FBA (Amazon Lojistik) Gelen Uygunluk API'si.**  Uygun olmayan ASIN'ler için gelen kargolar oluşturulmasını engellemek amacıyla ASIN'in Amazon Lojistik’e (FBA) katılım için uygunluğunu kontrol eder.
* **FBA (Amazon Lojistik) Envanter API'si.** FBA (Amazon Lojistik) satıcıları için yeni özellikler içeren yeni ve geliştirilmiş FBA envanter API'si.
* **Küçük ve Hafif FBA (Amazon Lojistik) API’si.** FBA (Amazon Lojistik) Küçük ve Hafif programını destekler.
* **Mesajlaşma API'si.** Satış ortaklarının desteklenen ileti türlerini müşterilere göndermelerini sağlar.
* **Bildirim API'si.** Markalı ürün içeriği değişiklikleri, ürün türü adı değişiklikleri, MFN (Satıcıdan Gönderim) sipariş durumu değişiklikleri ve kurumlar arası (B2B) teklif değişiklikleri için yeni bildirimler içerir.
* **Fiyatlandırma API'si.** Ürün fiyatlandırma ve teklif bilgilerini alır.
* **Ürün Ücretleri API'si.** Bir ürün için tahmini ücretlerin bilgisini alır.
* **Satış API'si.** Satış geçmişi raporları oluşturun.
* **Hizmetler API'si. ** Hizmet sağlayıcıların hizmet siparişlerini almasını ve değiştirmesini sağlar.
* **Kargo API'si** Amazon'un nakliye hizmetlerine programlı erişim sağlar.
* **İstekler API'si.** Satış ortaklarının müşterilere kritik olmayan istekler göndermesini sağlar.
* **Kodlar API'si.** Müşterinin Kişisel Olarak Tanımlanabilir Bilgilerine (PII) erişmek için güvenli bir yol sağlar.

## API'leri Amazon MWS'den Satış Ortağı API'sine eşleme

| AMAZON MWS | Satış Ortağı API'si |
| ----------------------------------------- | ----------------------------------- |
| Akışlar API'si bölümü | Akışlar API'si |
| Mali Durum API'si bölümü | Mali Durum API'si |
| Lojistik Gelen Kargo API'si bölümü | Lojistik Gelen API'si |
| Lojistik Envanter API'si bölümü | FBA (Amazon Lojistik) Envanter API'si |
| Lojistik Giden Kargo API'si bölümü | Lojistik Giden API'si |
| Satıcıdan Gönderim API'si bölümü | Satıcıdan Gönderim API'si |
| Sipariş API'si bölümü | Sipariş API'si |
| Ürünler API'si bölümü - Ürün Ücretleri | Ürün Ücretleri API'si |
| Ürünler API bölümü - Ürün Liste Kayıtları | Katalog Öğeleri API'si |
| Ürünler API'si bölümü - Ürün Fiyatlandırması | Fiyatlandırma API'si |
| Öneriler API'si bölümü | *Satış Ortağı API'sinde Kullanımdan Kaldırılan* |
| Raporlar API'si bölümü | Raporlar API'si |
| Satıcı API'si bölümü | Satıcılar API'si |
| Abonelikler API'si bölümü | Bildirimler API'si |

# Öğretici: Bir Amazon MWS uygulamasını Satış Ortağı API uygulamasına dönüştürün

Bu öğretici, bir Amazon MWS uygulamasını bir Satış Ortağı API uygulamasına nasıl dönüştüreceğinizi gösterir.

**Ön koşullar**

- Amazon MWS başvurunuzu kaydettiniz ve Marketplace Uygulama Mağazası'nda yayınladınız.

**Adımlar**

## 1. Adım: Satış Ortağı API uygulamanızın gerektirdiği veri erişimini isteyin

1. Amazon MWS geliştirici hesabınızla ilişkili kimlik bilgilerini kullanarak Seller Central'da oturum açın.

1. **Uygulamalar ve Hizmetler** menüsünde, **Uygulama Geliştir** öğesine tıklayın.

   **Geliştirici Merkezi** sayfası görüntülenir.

1. **Geliştirici Merkezi** sayfasında, **Geliştirici Profiliniz** bağlantısına tıklayın.

   **Geliştirici Profili sayfası** görüntülenir.

1. Formun **Veri Erişimi** bölümünde, uygulamalarınızın gerektirdiği rolleri seçin ve ardından formu gönderin.

Bu talebi takip etmeniz için bir Bize İletişime Geçin bileti açacağız. Talebinizi değerlendirdikten sonra sizinle iletişime geçeceğiz. Bu birkaç gün sürebilir.

## 2. Adım: IAM ARN'si oluşturun ve yapılandırın
Aşağıdaki adımda kullanmak üzere IAM ARN oluşturmak ve yapılandırmak için Satış Ortağı API Geliştirici Rehberi'nde bulunan [IAM politikaları ve varlıkları oluşturma](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md#IAM-politikaları-ve-varlıkları-oluşturma)

## 3. Adım: Amazon MWS uygulamanızı karma bir Satış Ortağı API uygulamasına dönüştürün

1. Geliştirici olarak kaydolmak için kullandığınız kimlik bilgilerini kullanarak Seller Central'da oturum açın.

1. **Uygulamalar ve Hizmetler** menüsünde, **Uygulama Geliştir** öğesine tıklayın.

   **Geliştirici Merkezi** sayfası görüntülenir.

1. Amazon MWS uygulamanızın yanındaki **Uygulamayı Düzenle** menüsünde bulunan **Uygulamayı Düzenle** öğesine tıklayın.

1. Başvurunuzu kaydetmek için yönergeleri izleyin. **IAMARN** kutusunda, [2. Adımdaki IAM ARN'sini kullanın. Bir IAM ARN'si oluşturun ve yapılandırın](#2.-Adım-Bir-IAM-ARN'si-oluşturun-ve-yapılandırın).

Formu doldurduğunuzda, Taslak statüsünde ve karma bir Satış Ortağı API uygulamanız olacaktır. Bir yetkilendirme iş akışını aşağıdaki adımda kurmaya ve test etmeye hazırsınız.

## 4. Adım: Bir yetkilendirme iş akışı uygulayın

Karma Satış Ortağı API uygulamanız için bir yetkilendirme iş akışı kurun ve test edin. Daha fazla bilgi için Satış Ortağı API Geliştirici Rehberi'ndeki [Satış Ortağı API uygulamaları için yetkilendirme](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md#satış-ortağı-api-uygulamaları-için-yetkilendirme)

## 5. Adım: Satış Ortağı API'sine bağlanın

Satış Ortağı API'sinde arama işlemleri için bir iş akışı oluşturun. Bu işlemler LWA kodlarının değiştirilmesini, URI'ların oluşturulmasını, üst bilgi eklenmesini, ve taleplerin oluşturulmasını ve imzalanmasını içerir. Bunu yapmanın en kolay yolu, LWA kod değişimi ve kimlik doğrulaması içeren bir SDK oluşturmak ve kullanmaktır. Daha fazla bilgi için Satış Ortağı API Geliştirici Rehberi'ndeki [LWA kod değişimi ve kimlik doğrulaması içeren bir Java SDK'sı oluşturma](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md#lwa-kod-değişimi-ve-kimlik-doğrulaması-içeren-bir-java-sdk'sı-oluşturma) ve [Oluşturulan Java SDK'sını kullanarak Satış Ortağı API'sine bağlanma](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md#oluşturulan-java-sdk'sını-kullanarak-satış-ortağı-api'sine-bağlanma) bölümlerine bakın.

Satış Ortağı API'si korumalı alanına bağlanma konusunda bilgileri Satış Ortağı API Geliştirici Rehberi'ndeki [Satış Ortağı API'si korumalı alanı](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md#satış-ortağı-api'si-korumalı-alanı) bölümünde bulabilirsiniz.

## 6. Adım: Karma Satış Ortağı uygulamanızı Marketplace Uygulama Mağazası'nda yayınlayın

1. Geliştirici olarak kaydolmak için kullandığınız kimlik bilgilerini kullanarak Seller Central'da oturum açın.

1. **Uygulamalar ve Hizmetler** menüsünde, **Uygulama Geliştir** öğesine tıklayın.

   **Geliştirici Merkezi** sayfası görüntülenir.

1. Uygulamanızın yanında, Uygulamayı **Düzenle** menüsünde oku tıklayın ve ardından **Liste Kaydını Düzenle** öğesine tıklayın.

1. İş akışından devam edin.

Son ekranı tamamladıktan sonra, karma Satış Ortağı uygulamanız Marketplace Uygulama Mağazası'nda yayınlanacaktır. Bu işlem 5 ila 10 iş günü sürebilir.

## 7. Adım: Amazon MWS yetkilendirmelerini Satış Ortağı API yetkilendirmelerine taşıyın

Mevcut Amazon MWS yetkilendirmelerinizi Satış Ortağı API yetkilendirmelerine taşıyın. Daha fazla bilgi için, [Yetkilendirme API'si Kullanım Örneği Kılavuzu'na](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/use-case-guides/authorization-api-use-case-guide/authorization-api-use-case-guide-v1.md) bakın.

## 8. Adım: Amazon MWS çağrılarınızı Satış Ortağı API çağrılarına taşıyın

Son adım, daha önce Amazon MWS operasyonlarına yapılan çağrıları tetikleyen eylemlerin şimdi ilgili Satış Ortağı API operasyonlarına yapılacak çağrıları tetikleyeceği şekilde uygulamanızı güncellemektir. Hangi Satış Ortağı API operasyonlarının uygulamanızın çağırdığı Amazon MWS operasyonlarına karşılık geldiğini görmek için [API'leri Amazon MWS'den Satış Ortağı API'sine Eşleme](#API'leri-Amazon-MWS'den-Satış-Ortağı-API'sine-Eşleme) başlıklı içeriğe bakın.

# Satış Ortağı API'sindeki Roller

Rol, bir geliştirici veya uygulamanın bir işlem veya kaynağa erişimi olup olmadığını belirlemek için Satış Ortağı API'si tarafından kullanılan mekanizmadır. Bir geliştirici olarak, belirli bir rol için istekte bulunmalı ve hak kazanmalısınız. Aksi takdirde söz konusu rol altında gruplandırılmış işlemlere ve kaynaklara erişemezsiniz.

Satış Ortağı API'sindeki roller, Amazon MWS'deki rollere göre daha detaylıdır. Amazon MWS'de üç adet rol varken, Satış Ortağı API'sinde 11 rol vardır. Satış Ortağı API'sindeki rollerin ayrıntılı açıklaması ve rollerin ve rol tanımlarının bir listesi için [Satış Ortağı API'sindeki Rollere](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/roles/Roles-in-the-Selling-Partner-API.md) bakın.

# Kısıtlı Veri Kodu

Satış Ortağı API'si, kısıtlı işlemlere (kısıtlı verileri getiren işlemler) çağrılar için Kısıtlı Veri Kodu (RDT) gerekli kılmak suretiyle müşterilerin Kişisel Olarak Tanımlanabilir Bilgilerini (PII) korur. Kısıtlı operasyonları çağırma amaçlı RDT alma ve kullanma hakkında bilgi için [Kod API'si için Kullanım Örneği Kılavuzuna](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/use-case-guides/tokens-api-use-case-guide/tokens-API-use-case-guide-2021-03-01.md) bakın.

# Satış Ortağı API’si korumalı alanı
Satış Ortağı API'si, üretim verilerini etkilemeden ve gerçek dünyada herhangi bir olay tetiklemeden uygulamalarınızı test etmenize olanak tanıyan izole bir korumalı alan sağlar. Daha fazla bilgi için Satış Ortağı API Geliştirici Rehberindeki[Satış Ortağı API'si Korumalı Alanı ](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md#satış-ortağı-api'si-korumalı-alanı) bölümüne bakın.

# Ek kaynaklar
* [GitHub Sorunları](https://github.com/amzn/selling-partner-api-docs/issues)
* Seller Central'da bir [talep](https://sellercentral.amazon.com/cu/case-lobby?ref=xx_caseLog_xxxx_helphub&) açarak destek birimiyle irtibata geçebilirsiniz
* [Satış İş Ortağı API'si Geliştirici Rehberi](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md)
