Guía de casos de uso de la API de tokens
=========================

Versión: 01/03/2021

¿Qué es la API de tokens?
=======================

La API del colaborador comercial para tokens (API de tokens) brinda una manera segura de acceder a la información de identificación personal (PII, por sus siglas en inglés) del cliente. Puedes llamar a la API de tokens para obtener un token de datos restringidos (RDT, por sus siglas en inglés) para uno o más recursos restringidos que especifiques. El RDT te autoriza a hacer llamadas posteriores a las operaciones restringidas que representan los recursos restringidos. Consulta [Terminología](#terminología).

Cuando llamas una operación restringida, incluyes un RDT en el encabezado `x-amz-access-token`. Este proceso es diferente a todas las otras operaciones SP-API, en las que incluyes un token de acceso LWA en el encabezado `x-amz-access-token`. Para obtener más información, consulta el [Paso 3. Agrega encabezados al URI](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md#step-3-add-headers-to-the-uri).

Terminología
-----------

- **Token de datos restringidos (RDT)**. Es un token de acceso de corta duración que te autoriza a llamar operaciones restringidas.

- **Operación restringida.** Es una operación que muestra datos restringidos, como información de identificación personal (PII). Necesitas un RDT para llamar una operación restringida. Consulta [Operaciones restringidas](#operaciones-restringidas).

- **Recurso restringido.** Es un método de HTTP y una ruta que representan una operación restringida.

- **Tipo de informe restringido.** Es un tipo de informe que contiene PII. Consulta [Tipos de informes restringidos](#tipos-de-informes-restringidos).

- **Ruta específica.** Es una ruta en un recurso restringido que contiene un ID de pedido o un ID de envío en específico. Por ejemplo, `orders/v0/orders/902-3159896-1390916/address`

- **Ruta genérica.** Es una ruta en un recurso restringido que no contiene un ID de pedido o un ID de envío en específico. En cambio, contiene la string `{orderId}` o `{shipmentId}`. Por ejemplo, `orders/v0/orders/{orderId}/address`.

Operaciones restringidas
=====================

Son operaciones restringidas que muestran información de identificación personal (PII) de los clientes. Para obtener más información sobre cómo llamar operaciones restringidas, consulta el [Instructivo: Cómo obtener un RDT y llamar operaciones restringidas](#instructivo-cómo-obtener-un-rdt-y-llamar-operaciones-restringidas).

A continuación, se muestra una lista de operaciones restringidas, agrupadas por API:

API de pedidos:

- ```getOrderBuyerInfo```

- ```getOrderAddress```

- ```getOrderItemsBuyerInfo```

API de envío:

- ```getShipment```

API de gestión del vendedor:

- ```getShipment```

- ```cancelShipment```

- ```cancelShipmentOld```

- ```createShipment```

API de informes:

- ```getReportDocument```

   **Notas:**

   - La operación getReportDocument se considera una operación restringida solo cuando se especifica un informe restringido. Consulta la lista de tipos de informes restringidos a continuación.

   - Cuando llamas a la operación createRestrictedDataToken a fin de obtener un RDT para la operación getReportDocument, el recurso restringido específico puede contener solo una ruta específica, no una ruta genérica. Para obtener más información, consulta el [Instructivo: Cómo obtener un RDT y llamar operaciones restringidas ](#instructivo-cómo-obtener-un-rdt-y-llamar-operaciones-restringidas) y la [Terminología](#terminología).

Tipos de informes restringidos
-----------------------

Los tipos de informes restringidos contienen PII. Cuando especificas un tipo de informe restringido en una llamada a la operación getReportDocument, debes transmitir un RDT con la llamada. Para obtener más información, consulta el [Instructivo: Cómo obtener un RDT y llamar operaciones restringidas](#instructivo-cómo-obtener-un-rdt-y-llamar-operaciones-restringidas).

A continuación, se muestra una lista de tipos de informes restringidos:

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

Instructivo: Cómo obtener un RDT y llamar operaciones restringidas
===================================================

En este instructivo, se muestra cómo usar la API de tokens para obtener un token de datos restringidos (RDT) y usarlo para llamar operaciones restringidas.

**Requisitos**

Para completar este instructivo, necesitarás lo siguiente:

- una autorización del colaborador comercial para quien realizas las llamadas. Consulta la [Guía para desarrolladores de la API del colaborador comercial](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md) para obtener más información.

Paso 1. Obtener un RDT
------------------

Llama a la operación createRestrictedDataToken para obtener un RDT.

- Llama a la operación [createRestrictedDataToken](https://github.com/amzn/selling-partner-api-docs/blob/main/references/tokens-api/tokens_2021-03-01.md#createrestricteddatatoken) y proporciona los siguientes parámetros:

Parámetros del cuerpo:

| Parámetro | Descripción | Tipo | Requerido |
|-----------|-------------|------|----------|
| restrictedResources | Modelo de un recurso restringido.</br> Máximo: 50 | <a href="#restrictedresources">restrictedResources</a> | Sí |

Ejemplo de solicitud:
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
**Respuesta**

Una respuesta exitosa incluye lo siguiente:

| Nombre | Encabezado 2 | Tipo |
|----------|----------|------|
| restrictedDataToken | Un token de datos restringidos (RDT). Es un token de acceso de corta duración que te autoriza a llamar a las operaciones restringidas representadas por los recursos restringidos que especificaste. Proporciona el valor del RDT en el encabezado <code>x-amzn-access-token</code> cuando hagas las llamadas posteriores a las operaciones restringidas. | string |
| expiresIn | La duración del RDT, en segundos. | integer |

Ejemplo de respuesta:
```
{
	"payload": {
		"restrictedDataToken": "Atz.sprdt|IQEBLjAsAhRmHjNgHpi0U-Dme37rR6CuUpSR",
		"expiresIn": 3600
	}
}
```
Ya tienes un RDT que te autoriza a llamar a las siguientes operaciones restringidas:

- **getOrderAddress.** Puedes llamar a la operación getOrderAddress con la ruta específica del recurso restringido que detallaste. Por ejemplo, `/orders/v0/orders/902-3159896-1390916/address`.

- **getOrderBuyerInfo.** Puedes llamar a la operación getOrderBuyerInfo con la ruta genérica del recurso restringido que especificaste si reemplazas `{orderId}` por el ID de pedido del colaborador comercial. Por ejemplo, `/orders/v0/orders/058-1233752-8214740/buyerInfo` y `/orders/v0/orders/483-3488972-0896720/buyerInfo`. Puedes usar el RDT para cualquier ID de pedido del colaborador comercial.

- **getShipment.** Puedes llamar a la operación getShipment con la ruta genérica del recurso restringido que especificaste si reemplazas `{shipmentId}` por un ID de envío del colaborador comercial. Por ejemplo, `/mfn/v0/shipments/6f77095e-9f75-47eb-aaab-a42d5428fa1a`. Puedes usar el RDT para cualquier ID de envío del colaborador comercial.

Para obtener más información, consulta [Terminología](#terminología).

Paso 2. Llamar operaciones restringidas
----------------------------------

Llama a las operaciones restringidas para el RDT en el Paso 1. Obtén un RDT que te autorice. Para llamar operaciones restringidas, incluye el RDT en el encabezado `x-amz-access-token`. Para obtener más información, consulta el [Paso 3. Agrega encabezados al URI](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md#step-3-add-headers-to-the-uri).

Ejemplos de solicitud:
```
GET https://sellingpartnerapi-na.amazon.com/orders/v0/orders/orders/v0/orders/902-3159896-1390916/address.

GET https://sellingpartnerapi-na.amazon.com/orders/v0/orders/902-3159896-1390916/buyerInfo

GET https://sellingpartnerapi-na.amazon.com/orders/v0/orders/483-3488972-0896720/buyerInfo

GET https://sellingpartnerapi-na.amazon.com/mfn/v0/shipments/6f77095e-9f75-47eb-aaab-a42d5428fa1a
```
Datatypes
---------

### restrictedResources

<table><thead><tr class="header"><th><strong>Parámetro</strong></th><th><strong>Descripción</strong></th><th><strong>Requerido</strong></th></tr></thead><tbody><tr class="odd"><td>método</td><td><p>El método HTTP utilizado con el recurso restringido.</p><p>Tipo: <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/tokens-api/tokens_2021-03-01.md#method">Método</a></p></td><td>Sí</td></tr><tr class="even"><td>ruta</td><td><p>La ruta de una operación restringida. Esto podría ser:</p><ul><li><p>Una ruta específica que contiene el ID de pedido, el ID de envío o el ID del documento de informe de un vendedor, por ejemplo, <code>/orders/v0/orders/902-3159896-1390916/address</code> o <code>/mfn/v0/shipments/6f77095e-9f75-47eb-aaab-a42d5428fa1a</code></p></li><li><p>Una ruta genérica que no contiene el ID de pedido o el ID de envío de un vendedor, por ejemplo, <code>/orders/v0/orders/{orderId}/address</code> o <code>/mfn/v0/shipments/{shipmentId}</code></p></li></ul><p>Tipo: string</p></td><td>Sí</td></tr></tbody></table>

Instructivo: Generar un SDK de Java para la API de tokens
================================================

En estas instrucciones, se muestra cómo generar un SDK de Java para la API de tokens mediante el [Generador de códigos Swagger](https://github.com/swagger-api/swagger-codegen) en una computadora con Microsoft Windows. El proceso es el mismo para los usuarios de otros sistemas operativos, como macOS o Linux, solo que deben reemplazar la semántica específica de Windows (por ejemplo, C:\\). Consulta <https://github.com/amzn/selling-partner-api-models> para ver el modelo Swagger de la API de tokens.

Con este SDK podrás realizar llamadas a la API de tokens con el siguiente código ya configurado para ti: Inicia sesión con Amazon, con el intercambio de tokens (intercambia un token actualizado por un token de acceso) y la autenticación.

**Para generar un SDK de Java con autenticación e intercambio de tokens LWA, haz lo siguiente:**

1. Instala [Java 8 o una versión superior](https://www.oracle.com/technetwork/java/index.html), [Apache Maven 3.6. o una versión superior](http://maven.apache.org/) y [GNU Wget](https://www.gnu.org/software/wget/wget.html), y permite que estén disponibles en tu $PATH.

2. Ve a <https://github.com/amzn/selling-partner-api-models>.

3. Clona el repositorio para crear una copia local en tu computadora, si todavía no lo has hecho.

4. Abre una ventana de solicitud de comando y ve a un directorio en el que quieras descargar el generador de códigos Swagger.

5. Descarga la última versión del generador de códigos Swagger.

   Por ejemplo:
   ```
   wget https://repo1.maven.org/maven2/io/swagger/swagger-codegen-cli/2.4.13/swagger-codegen-cli-2.4.13.jar -O swagger-codegen-cli.jar
   ```
   **swagger-codegen-cli.jar** se descarga en el directorio actual.

   **Nota:** también puedes descargarlo desde maven.org si escribes la siguiente dirección en el explorador: <https://repo1.maven.org/maven2/io/swagger/swagger-codegen-cli/2.4.13/swagger-codegen-cli-2.4.13.jar>

6. Copia **swagger-codegen-cli.jar** en una estructura de directorios adecuada para ti. Para este ejemplo, lo copiaremos en C:\SwaggerToCL.

7. Navega a **tokens_2021-03-01.json** en la carpeta **selling-partner-api-models\models\tokens-api-model** de tu copia local del repositorio.

8. Copia **tokens_2021-03-01.json** en C:\SwaggerToCL.

9. Genera el SDK según las plantillas en la carpeta **selling-partner-api-models\clients\sellingpartner-api-aa-java** de tu copia local del repositorio. Esta carpeta contiene una biblioteca de autorización y autenticación, además de plantillas personalizadas para el generador de códigos Swagger.

   Por ejemplo:
   ```
   java -jar C:\SwaggerToCL\swagger-codegen-cli.jar generate -i C:\SwaggerToCL\tokens_2021-03-01.json -l java -t [path to selling-partner-api-models\clients\sellingpartner-api-aa-java folder]\resources\swagger-codegen\templates\ -o C:\SwaggerToCL\Tokens_JavaCL
   ```
   El SDK se copia en C:\SwaggerToCL\Tokens_JavaCL

10. Crea la Biblioteca AA y agrégala como una dependencia del SDK:

1. Accede a la carpeta **selling-partner-api-models\clients\sellingpartner-api-aa-java** de tu copia local del repositorio y ejecuta el paquete mvn. Esta acción genera una carpeta denominada “target” (destino). En esta carpeta, hay un archivo JAR llamado **sellingpartnerapi-aa-java-1.0-jar-with-dependencies.jar** (o similar) y se incluyen todas las dependencias requeridas.

2. Instala el archivo JAR en tu repositorio local de Maven.

   Por ejemplo:
   ```
   mvn install:install-file -Dfile=[path to JAR file in "target" folder] -DgroupId=com.amazon.sellingpartnerapi -DartifactId=sellingpartnerapi-aa-java -Dversion=1.0 -Dpackaging=jar
   ```
   Puedes encontrar el groupId, el artifactId y los valores de versión reales cerca de la parte superior del archivo **pom.xml** en la carpeta **selling-partner-api-models\clients\sellingpartner-api-aa-java**.

11. Agrega una dependencia a la biblioteca AA en el **pom.xml** de la biblioteca cliente.

Por ejemplo:

```
<dependency>
<groupId>com.amazon.sellingpartnerapi</groupId>
<artifactId>sellingpartnerapi-aa-java</artifactId>
<version>1.0</version>
</dependency>
```
12. Ejecuta el **paquete mvn** dentro de la carpeta de SDK generada.

13. Descarga [restricted-data-token-workflow.java](https://github.com/amzn/selling-partner-api-models/commit/63a55cee11ca54caf8242884027a863860abaaf2) y utilízalo para crear una clase dentro de la carpeta **main/java/sampleCode/** de la biblioteca cliente generada.

Ahora puedes comenzar a probar el proceso para obtener un RDT y usarlo para llamar a una o más operaciones restringidas. Utiliza este código como guía para la creación de tus propias aplicaciones.

Colección Postman de la API de tokens
=============================

Puedes utilizar la [colección Postman de la API de tokens](https://github.com/amzn/selling-partner-api-models/blob/main/clients/postman-collections/tokens-api-sandbox-postman-collection.json) para probar la API de tokens en el entorno de pruebas de la API del colaborador comercial. Para obtener más información sobre las pruebas con este entorno, consulta [El entorno de pruebas de la API del colaborador comercial](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md#the-selling-partner-api-sandbox) en la Guía para desarrolladores.