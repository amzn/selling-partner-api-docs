Przewodnik dotyczący korzystania z API Tokenów
=========================

Wersja: 2021-03-01

Czym jest API Tokenów?
=======================

Interfejs API partnerów sprzedaży dla Tokenów (API Tokenów) zapewnia bezpieczny sposób dostępu do danych osobowych klienta. Możesz wywołać interfejs API Tokenów, aby uzyskać Token zastrzeżonych danych (RDT) dla jednego lub kilku określonych zasobów zastrzeżonych. RDT upoważnia Cię do wykonywania kolejnych wywołań zastrzeżonych operacji reprezentowanych przez zasoby zastrzeżone. Zapoznaj się z [Terminologią](#terminologia).

Po wywołaniu operacji zastrzeżonej należy uwzględnić RDT w nagłówku `x-amz-access-token`. Różni się to od wszystkich innych operacji SP-API, które zawierają token dostępu LWA w nagłówku `x-amz-access-token`. Aby uzyskać więcej informacji, zapoznaj się z [Krokiem 3. Dodaj nagłówki do URI](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md#step-3-add-headers-to-the-uri).

Terminologia
-----------

- **Token zastrzeżonych danych (RDT)**. Token krótkotrwałego dostępu, który upoważnia Cię do wywoływania operacji zastrzeżonych.

- **Operacja zastrzeżona** Operacja zwracająca zastrzeżone dane, takie jak dane osobowe. Aby wywołać zastrzeżoną operację, potrzebujesz RTD. Zobacz sekcję [Operacje zastrzeżone](#operacje-zastrzeżone).

- **Zastrzeżone zasoby** Metoda HTTP i ścieżka reprezentujące zastrzeżoną operację.

- **Zastrzeżony typ raportu.** Typ raportu, który zawiera dane osobowe. Zobacz sekcję [Zastrzeżone typy raportów](#typy-zastrzeżonych-raportów)

- **Określona ścieżka.** Ścieżka w zastrzeżonym zasobie zawierająca określony identyfikator zamówienia lub wysyłki. Na przykład: `orders/v0/orders/902-3159896-1390916/address`

- **Ogólna ścieżka.** Ścieżka w zastrzeżonym zasobie, która nie zawiera określonego identyfikatora zamówienia ani przesyłki. Zamiast tego zawiera ciąg `{orderId}` lub `{shipmentId}`. Na przykład: `orders/v0/orders/{orderId}/address`

Operacje zastrzeżone
=====================

Operacje zastrzeżone zwracają dane osobowe klientów. Aby uzyskać więcej informacji na temat wywoływania operacji zastrzeżonych, przeczytaj sekcję [Samouczek: uzyskiwanie RDT i wywoływanie zastrzeżonych operacji](#samouczek-uzyskiwanie-rdt-i-wywoływanie-zastrzeżonych-operacji).

Poniżej znajdziesz listę zastrzeżonych operacji, pogrupowanych według API:

API zamówień:

- ```getOrderBuyerInfo```

- ```getOrderAddress```

- ```getOrderItemsBuyerInfo```

API wysyłki:

- ```getShipment```

API realizacji przez sprzedawcę:

- ```getShipment```

- ```cancelShipment```

- ```cancelShipmentOld```

- ```createShipment```

API raportów:

- ```getReportDocument```

   **Uwagi:**

   - Operacja getReportDocument jest uważana za operację zastrzeżoną tylko wtedy, gdy zastrzeżona operacja jest określona. Poniżej znajduje się lista zastrzeżonych typów raportów.

   - Podczas wywoływania operacji createRestrictedDataToken w celu uzyskania RDT dla operacji getReportDocument określony zastrzeżony zasób może zawierać tylko określoną ścieżkę, a nie ścieżkę ogólną. Aby uzyskać więcej informacji, przeczytaj [Samouczek: uzyskiwanie RDT i wywołanie zastrzeżonych operacji](#samouczek-uzyskiwanie-rdt-i-wywoływanie-zastrzeżonych-operacji) oraz [Terminologia](#terminologia).

Typy zastrzeżonych raportów
-----------------------

Zastrzeżone raporty zawierają dane osobowe. Podczas określania zastrzeżonego raportu w wywołaniu operacji getReportDocument musisz podać RDT przy wywoływaniu. Aby uzyskać więcej informacji, przeczytaj [Samouczek: uzyskiwanie RDT i wywoływanie zastrzeżonych operacji](#samouczek-uzyskiwanie-rdt-i-wywoływanie-zastrzeżonych-operacji).

Poniżej znajdziesz listę typów zastrzeżonych raportów:

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

Samouczek: Uzyskiwanie RDT i wywoływanie zastrzeżonych operacji
===================================================

Ten samouczek informuje, jak korzystać z API Tokenów, aby uzyskać Token danych zastrzeżonych (RDT) i wykorzystać go do wywołania zastrzeżonych operacji.

**Wymagania wstępne**

Do ukończenia tego samouczka potrzebujesz:

- autoryzacji od partnera sprzedaży, dla którego dokonujesz wywołania. Więcej informacji znajdziesz w [Przewodniku dla deweloperów dotyczącym API partnera sprzedaży](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md).

Krok 1. Uzyskaj RDT
------------------

Wywołaj operację createRestrictedDataToken, aby uzyskać RDT.

- Wywołaj operację [createRestrictedDataToken](https://github.com/amzn/selling-partner-api-docs/blob/main/references/tokens-api/tokens_2021-03-01.md#createrestricteddatatoken), przekazując następujące parametry:

Parametry treści:

| Parametr | Opis | Typ | Wymagany |
|-----------|-------------|------|----------|
| restrictedResources | Model zastrzeżonego zasobu.</br> Maksymalnie: 50 | <a href="#restrictedresources">restrictedResources</a> | Tak |

Przykład żądania:
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
**Odpowiedź**

Pomyślna odpowiedź obejmuje następujące elementy:

| Nazwa | Nagłówek 2 | Typ |
|----------|----------|------|
| restrictedDataToken | Token zastrzeżonych danych (RDT). Jest to krótkotrwały token dostępu, który upoważnia użytkownika do wywołania zastrzeżonych operacji reprezentowanych przez określone zasoby zastrzeżone. Przekaż wartość RDT w nagłówku <code>x-amzn-access-token</code> podczas wywoływania kolejnych zastrzeżonych operacji. | string |
| expiresIn | Okres ważności RDT, w sekundach. | integer |

Przykład odpowiedzi:
```
{
	"payload": {
		"restrictedDataToken": "Atz.sprdt|IQEBLjAsAhRmHjNgHpi0U-Dme37rR6CuUpSR",
		"expiresIn": 3600
	}
}
```
Masz teraz RDT, który upoważnia Cię do wywoływania następujących operacji zastrzeżonych:

- **getOrderAddress.** Operację getOrderAddress można wywołać przy użyciu określonej ścieżki z określonego zasobu zastrzeżonego. Na przykład: `/orders/v0/orders/902-3159896-1390916/address`.

- **getOrderBuyerInfo.** Operację getOrderBuyerInfo można wywołać przy użyciu ścieżki ogólnej z określonego zasobu zastrzeżonego, zastępując `{orderId}` identyfikatorem zamówienia od partnera sprzedaży. Na przykład: `/orders/v0/orders/058-1233752-8214740/buyerInfo` i `/orders/v0/orders/483-3488972-0896720/buyerInfo`. Możesz użyć RDT w przypadku dowolnego identyfikatora zamówienia partnera sprzedaży.

- **getShipment.** Operację getShipment można wywołać przy użyciu ścieżki ogólnej z określonego zasobu zastrzeżonego, zastępując `{shipmentId}` identyfikatorem przesyłki od partnera sprzedaży. Na przykład: `/mfn/v0/shipments/6f77095e-9f75-47eb-aaab-a42d5428fa1a`. Możesz użyć RDT w przypadku dowolnego identyfikatora wysyłki partnera sprzedaży.

Aby uzyskać więcej informacji, zapoznaj się z sekcją [Terminologia](#terminologia).

Krok 2. Wywołaj zastrzeżone operacje
----------------------------------

Wywołaj zastrzeżone operacje z użyciem RDT opisanego w [Kroku 1. Uzyskaj autoryzację RDT](#krok-1-uzyskaj-rdt). Podczas wywoływania operacji zastrzeżonych, zawrzyj RDT w nagłówku `x-amz-access-token`. Aby uzyskać więcej informacji, zapoznaj się z [Krokiem 3. Dodaj nagłówki do URI](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md#step-3-add-headers-to-the-uri).

Przykłady zapytania:
```
GET https://sellingpartnerapi-na.amazon.com/orders/v0/orders/orders/v0/orders/902-3159896-1390916/address.

GET https://sellingpartnerapi-na.amazon.com/orders/v0/orders/902-3159896-1390916/buyerInfo

GET https://sellingpartnerapi-na.amazon.com/orders/v0/orders/483-3488972-0896720/buyerInfo

GET https://sellingpartnerapi-na.amazon.com/mfn/v0/shipments/6f77095e-9f75-47eb-aaab-a42d5428fa1a
```
Typy danych
---------

### restrictedResources

<table><thead><tr class="header"><th><strong>Parametr</strong></th><th><strong>Opis</strong></th><th><strong>Wymagany</strong></th></tr></thead><tbody><tr class="odd"><td>method</td><td><p>Metoda HTTP z zastrzeżonym zasobem.</p><p>Typ: <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/tokens-api/tokens_2021-03-01.md#method">Metoda</a></p></td><td>Tak</td></tr><tr class="even"><td>path</td><td><p>Ścieżka z zastrzeżonej operacji. Może to być:</p><ul><li><p>Konkretna ścieżka zawierająca identyfikator sprzedawcy, przesyłki lub raportu, na przykład <code>/orders/v0/orders/902-3159896-1390916/address</code> or <code>/mfn/v0/shipments/6f77095e-9f75-47eb-aaab-a42d5428fa1a</code></p></li><li><p>Ogólna ścieżka niezawierająca identyfikatora sprzedawcy ani przesyłki, na przykład <code>/orders/v0/orders/{orderId}/address</code> lub <code>/mfn/v0/shipments/{shipmentId}</code></p></li></ul><p>Typ: string</p></td><td>Tak</td></tr></tbody></table>

Samouczek: Generowanie pakietu Java SDK dla API Tokenów
================================================

Te instrukcje informują, jak wygenerować pakiet Java SDK dla API Tokenów przy użyciu [Generatora kodu Swagger](https://github.com/swagger-api/swagger-codegen) na komputerze z systemem Microsoft Windows. Proces ten jest taki sam dla użytkowników innych systemów operacyjnych, takich jak macOS lub Linux. Zmienia się jedynie semantyka typowa dla systemu Windows (np. C:\\). Aby dowiedzieć się więcej o modelu Swagger dla API Tokenów, zapoznaj się z: <https://github.com/amzn/selling-partner-api-models>.

Za pomocą tego pakietu SDK możesz wywołać API Tokenów z tym kodem skonfigurowanym dla Ciebie: Token wymiany Login with Amazon (wymień nowy token na token dostępu) i weryfikacja.

**Aby wygenerować pakiet Java SDK z tokenem wymiany LWA i weryfikacją**

1. Zainstaluj [Javę 8 lub nowszą](https://www.oracle.com/technetwork/java/index.html), [Apache Maven w wersji 3.6. lub nowszej](http://maven.apache.org/) i [GNU Wget](https://www.gnu.org/software/wget/wget.html) i udostępnij je w $PATH.

2. Przejdź do: <https://github.com/amzn/selling-partner-api-models>.

3. Sklonuj repozytorium, aby zapisać kopię na komputerze, jeśli jeszcze jej nie masz.

4. Otwórz okno wiersza polecenia i przejdź do lokalizacji, do której chcesz pobrać Generator kodu Swagger.

5. Pobierz najnowszą wersję generatora kodu Swagger.

   Na przykład:
   ```
   wget https://repo1.maven.org/maven2/io/swagger/swagger-codegen-cli/2.4.13/swagger-codegen-cli-2.4.13.jar -O swagger-codegen-cli.jar
   ```
   **swagger-codegen-cli.jar** pobiera do bieżącego katalogu.

   **Uwaga:** możesz też pobrać go ze strony maven.org, przekierowując przeglądarkę do tego miejsca: <https://repo1.maven.org/maven2/io/swagger/swagger-codegen-cli/2.4.13/swagger-codegen-cli-2.4.13.jar>

6. Skopiuj **swagger-codegen-cli.jar** do wybranej przez Ciebie struktury katalogów. W tym przykładzie skopiujemy go do katalogu C:\SwaggerToCL.

7. Przejdź do **tokens_2021-03-01.json** w folderze folderze **selling-partner-api-models\models\tokens-api-model** lokalnej kopii repozytorium.

8. Skopiuj **tokens_2021-03-01.json** do C:\SwaggerToCL.

9. Wygeneruj pakiet SDK zgodnie z szablonami w **selling-partner-api-models\clients\sellingpartner-api-aa-java folder** lokalnej kopii repozytorium. Ten folder zawiera bibliotekę autoryzacji i uwierzytelnienia, wraz z dostosowanymi szablonami Generatora kodu Swagger.

   Na przykład:
   ```
   java -jar C:\SwaggerToCL\swagger-codegen-cli.jar generate -i C:\SwaggerToCL\tokens_2021-03-01.json -l java -t [path to selling-partner-api-models\clients\sellingpartner-api-aa-java folder]\resources\swagger-codegen\templates\ -o C:\SwaggerToCL\Tokens_JavaCL
   ```
   Kopia pakietu SDK znajduje się w C:\SwaggerToCL\Tokens_JavaCL

10. Zbuduj bibliotekę AA i dodaj ją jako zależność pakietu SDK:

1. Przejdź do folderu **selling-partner-api-models\clients\sellingpartner-api-aa-java** lokalnej kopii repozytorium i uruchom pakiet mvn. Spowoduje to wygenerowanie folderu o nazwie „target”. W tym folderze znajduje się plik JAR o nazwie **sellingpartnerapi-aa-java-1.0-jar-with-dependencies.jar** (lub podobnej) i wszystkie wymagane zależności.

2. Zainstaluj plik JAR w lokalnym repozytorium Maven.

   Na przykład:
   ```
   mvn install:install-file -Dfile=[path to JAR file in "target" folder] -DgroupId=com.amazon.sellingpartnerapi -DartifactId=sellingpartnerapi-aa-java -Dversion=1.0 -Dpackaging=jar
   ```
   Aktualne wartości groupId, artifactId i wartości wersji znajdują się w górnej części pliku **pom.xml** w folderze **selling-partner-api-models\clients\sellingpartner-api-aa-java**.

11. Dodaj zależność od biblioteki AA w pliku **pom.xml** biblioteki klienta:

Na przykład:

```
<dependency>
<groupId>com.amazon.sellingpartnerapi</groupId>
<artifactId>sellingpartnerapi-aa-java</artifactId>
<version>1.0</version>
</dependency>
```
12. Uruchom **pakiet mvn** wewnątrz wygenerowanego folderu SDK.

13. Pobierz [restricted-data-token-workflow.java](https://github.com/amzn/selling-partner-api-models/commit/63a55cee11ca54caf8242884027a863860abaaf2) i użyj go do zbudowania klasy w folderze **main/java/sampleCode/** wygenerowanej biliboteki klienta.

Teraz można rozpocząć testowanie procedury uzyskiwania RDT i wykorzystania go do wywołania co najmniej jednej operacji zastrzeżonej. Użyj tego kodu przy tworzeniu własnych aplikacji.

Kolekcja API Postman Tokenów
=============================

Możesz wykorzystać [kolekcję API Postman Tokenów](https://github.com/amzn/selling-partner-api-models/blob/main/clients/postman-collections/tokens-api-sandbox-postman-collection.json), aby przetestować API Tokenów w środowisku piaskownicy partnera sprzedaży. Aby uzyskać więcej informacji na temat testowania w środowisku piaskownicy, zapoznaj się z sekcją [Środowisko piaskownicy API partnera sprzedaży](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md#the-selling-partner-api-sandbox) w Przewodniku dla deweloperów.