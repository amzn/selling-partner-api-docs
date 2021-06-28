Guía de casos de uso de la API de tokens
=========================

Versión: 01-03-2021

¿Qué es la API de tokens?
=======================

La API del colaborador comercial para tokens (API de tokens) permite acceder de forma segura a la información de identificación personal (IIP) del cliente. Puedes ejecutar la API de tokens para conseguir un token de datos restringidos (RDT) para uno o más recursos restringidos que especifiques. El RDT te permite ejecutar posteriores operaciones restringidas que los recursos restringidos representan. Consulta [Terminología](#terminología).

Cuando ejecutas una operación restringida, incluyes un RDT en el encabezado `x-amz-access-token`. Esto se contrapone a todas las demás operaciones SP-API, en las que se incluye un token de acceso LWA en el encabezado`x-amz-access-token`. Para obtener más información, consulta el [Paso 3. Añadir encabezados al URI](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md#paso-3-añadir-encabezados-al-uri).

Terminología
-----------

- **Token de datos restringidos (RDT)**. Un token de acceso de corta duración que te permite ejecutar operaciones restringidas.

- **Operación restringida.** Operación que devuelve datos restringidos, como información de identificación personal (IIP). Necesitas un RDT para ejecutar una operación restringida. Consulta [Operaciones restringidas](#operaciones-restringidas).

- **Recurso restringido.** Una ruta y un método HTTP que representan una operación restringida.

- **Tipo de informe restringido.** Un tipo de informe que contiene IIP. Consulta [Tipos de informes restringidos](#tipos-de-informes-restringidos)

- **Ruta específica.** Una ruta en un recurso restringido que contiene un número de pedido o de envío específico. Por ejemplo, `orders/v0/orders/902-3159896-1390916/address`

- **Ruta genérica.** Una ruta en un recurso restringido que no contiene un número de pedido o de envío específico. En su lugar, contiene la cadena `{orderId}` o `{shipmentId}`. Por ejemplo, `orders/v0/orders/{orderId}/address`

Operaciones restringidas
=====================

Las operaciones restringidas devuelven la información de identificación personal (IIP) de los clientes. Para obtener más información sobre cómo ejecutar las operaciones restringidas, consulta [Tutorial: Obtén un RDT y ejecuta operaciones restringidas](#tutorial-obtener-un-rdt-y-ejecutar-operaciones-restringidas).

A continuación se muestra una lista de operaciones restringidas agrupadas por API:

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

- ```GetReportDocument```

   **Notas:**

   - La operación getReportDocument se considera una operación restringida sólo cuando se especifica un informe restringido. Consulta la siguiente lista de tipos de informes restringidos.

   - Al ejecutar la operación createRestrictedDataToken para obtener un RDT para la operación getReportDocument, el recurso restringido específico sólo puede contener una ruta específica y no una genérica. Para obtener más información, consulta [Tutorial: Obtén un RDT y ejecuta operaciones restringidas](#tutorial-obtener-un-rdt-y-ejecutar-operaciones-restringidas) y [Terminología](#terminología).

Tipos de informes restringidos
-----------------------

Los tipos de informes restringidos contienen IIP. Si se especifica un tipo de informe restringido al ejecutar una operación getReportDocument, debes introducir un RDT en la ejecución. Para obtener más información, consulta [Tutorial: Obtén un RDT y ejecuta operaciones restringidas](#tutorial-obtener-un-rdt-y-ejecutar-operaciones-restringidas).

A continuación se muestra una lista de tipos de informes restringidos:

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

Tutorial: Obtener un RDT y ejecutar operaciones restringidas
===================================================

Este tutorial enseña cómo utilizar la API de tokens para conseguir un token de datos restringidos (RDT) y cómo usar el RDT para ejecutar operaciones restringidas.

**Requisitos previos**

Para completar este tutorial, necesitarás:

- Autorización del colaborador comercial para el que ejecutas acciones. Consulta la [Guía para desarrolladores de la API del colaborador comercial](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md) para obtener más información.

Paso 1. Obtén un RDT
------------------

Ejecuta la operación createRestrictedDataToken para obtener un RDT.

- Ejecuta la operación [createRestrictedDataToken](https://github.com/amzn/selling-partner-api-docs/blob/main/references/tokens-api/tokens_2021-03-01.md#createrestricteddatatoken) introduciendo los siguientes parámetros:

Parámetros del cuerpo:

| Parámetro | Descripción | Tipo | Necesario |
|-----------|-------------|------|----------|
| restrictedResources | Modelo de recurso restringido.</br>Máximo: 50. | <a href="#restrictedresources">restrictedResources</a> | Sí |

Ejemplo de solicitud:
```
POST https://sellingpartnerapi-na.amazon.com/tokens/2021-03-01/restrictedDataToken
{
  "restrictedResources": [
    {
      "method": "GET",
      "path": "/orders/v0/orders/902-3159896-1390916/address"
    }, {
      "method": "GET",
      "path": "/orders/v0/orders/{orderId}/buyerInfo"
    }, {
      "method": "GET",
      "path": "/mfn/v0/shipments/{shipmentId}"
    }
  ]
}
```
**Respuesta**

Una respuesta correcta incluye lo siguiente:

| Nombre | Encabezado 2 | Tipo |
|----------|----------|------|
| restrictedDataToken | Un token de datos restringidos (RDT). Se trata de un token de acceso de corta duración que te permite ejecutar las operaciones restringidas representadas por los recursos restringidos que has especificado. Introduce el valor RDT en el encabezado <code>x-amzn-access-token</code> cuando ejecutes posteriores operaciones restringidas. | cadena |
| expiresIn | La vida útil del RDT, en segundos. | íntegro |

Respuesta de ejemplo:
```
{
	"payload": {
		"restrictedDataToken": "Atz.sprdt|IQEBLjAsAhRmHjNgHpi0U-Dme37rR6CuUpSR",
		"expiresIn": 3600
	}
}
```
Ahora tienes un RDT que te permite realizar las siguientes operaciones restringidas:

- **getOrderAddress.**Puedes ejecutar la operación getOrderAddress con la ruta específica del recurso restringido que has especificado. Por ejemplo, `/orders/v0/orders/902-3159896-1390916/address`.

- **getOrderBuyerInfo**Puedes ejecutar la operación getOrderBuyerInfo con la ruta genérica del recurso restringido que has especificado reemplazando `{orderId}` con un número de pedido del colaborador comercial. Por ejemplo, `/orders/v0/orders/058-1233752-8214740/buyerInfo` y `/orders/v0/orders/483-3488972-0896720/buyerInfo`. Puedes utilizar el RDT para cualquier número de pedido del colaborador comercial.

- **getShipment**Puedes ejecutar la operación getShipment con la ruta genérica del recurso restringido que has especificado reemplazando el`{shipmentId}` con un número de envío del colaborador comercial. Por ejemplo, `/mfn/v0/shipments/6f77095e-9f75-47eb-aaab-a42d5428fa1a`. Puedes utilizar el RDT para cualquier número de envío del colaborador comercial.

Para obtener más información, consulta [Terminología](#terminología).

Paso 2. Ejecutar operaciones restringidas
----------------------------------

Ejecuta las operaciones restringidas para el RDT del [Paso 1. Obtén un RDT ](#paso-1.-obtén-un-rdt) que te autorice. Al ejecutar las operaciones restringidas, incluye el RDT en el encabezado `x-amz-access-token`. Para obtener más información, consulta el [Paso 3. Añadir encabezados al URI](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md#paso-3-añadir-encabezados-al-uri).

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

<table><thead><tr class="header"><th><strong>Parámetro</strong></th><th><strong>Descripción</strong></th><th><strong>Método</strong></th></tr></thead><tbody><tr class="odd"><td>necesario</td><td><p>El método HTTP utilizado con el recurso restringido</p><p>Tipo: <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/tokens-api/tokens_2021-03-01.md#method">Método</a></p></td><td>Sí</td></tr><tr class="even"><td>ruta</td><td><p>La ruta de una operación restringida. Esto podría ser:</p><ul><li><p>Una ruta específica que contiene el número de pedido de un vendedor, un envío o un informe, por ejemplo <code>/orders/v0/orders/902-3159896-1390916/address</code> o<code>/mfn/v0/shipments/6f77095e-9f75-47eb-aaab-a42d5428fa1a</code></p></li><li><p>Una ruta genérica que no contiene el número de pedido o de envío de un vendedor, por ejemplo <code>/orders/v0/orders/{orderId}/address</code> o <code>/mfn/v0/shipments/{shipmentId}</code></p></li></ul><p>Tipo: cadena</p></td><td>Sí</td></tr></tbody></table>

Tutorial: Generar un SDK de Java para la API de tokens
================================================

Estas instrucciones te enseñan cómo generar un SDK de Java para la API de tokens con [Swagger Code Generator](https://github.com/swagger-api/swagger-codegen) en un ordenador con Microsoft Windows. El proceso es el mismo para los usuarios de otros sistemas operativos como macOS o Linux, con la sustitución de la semántica específica de Windows (por ejemplo, C:\\). Consulta <https://github.com/amzn/selling-partner-api-models> para ver el modelo Swagger para la API de tokens.

Con este SDK, puedes ejecutar acciones en la API de tokens con el siguiente código ya configurado. Autenticación e intercambio de tokens Login with Amazon (intercambio de un token de actualización por uno de acceso).

**Para generar un SDK de Java con autenticación e intercambio de tokens Login with Amazon (LWA)**

1. Instala [Java 8 o posterior](https://www.oracle.com/technetwork/java/index.html), [Apache Maven 3.6 o superior](http://maven.apache.org/) y [GNU Wget](https://www.gnu.org/software/wget/wget.html) para que estén disponibles en tu $PATH.

2. Ve a <https://github.com/amzn/selling-partner-api-models>.

3. Clona el repositorio para hacer una copia local en tu ordenador si aún no lo has hecho.

4. Abre una ventana del símbolo del sistema y ve al directorio en el que deseas descargar Swagger Code Generator.

5. Descarga la última versión de Swagger Code Generator.

   Por ejemplo:
   ```
   wget https://repo1.maven.org/maven2/io/swagger/swagger-codegen-cli/2.4.13/swagger-codegen-cli-2.4.13.jar -O swagger-codegen-cli.jar
   ```
   **swagger-codegen-cli.jar** se descarga en el director actual.

   **Nota:**También puede descargarse desde maven.org redirigiendo tu navegador aquí: <https://repo1.maven.org/maven2/io/swagger/swagger-codegen-cli/2.4.13/swagger-codegen-cli-2.4.13.jar>

6. Copia **swagger-codegen-cli.jar** en una estructura de directorios que te resulte útil. En este caso, lo copiaremos a C:\SwaggerToCL.

7. Dirígete a **tokens_2021-03-01.json** en la carpeta **selling-partner-api-models\ models\ tokens-api-model** de tu copia local del repositorio.

8. Copia **tokens_2021-03-01.json** en C:\SwaggerToCL.

9. Genera el SDK con las plantillas de la carpeta**selling-partner-api-models\clients\sellingpartner-api-aa-java folder** de tu copia local del repositorio. Esta carpeta contiene una biblioteca de autorización y autenticación, además de plantillas personalizadas para Swagger Code Generator.

   Por ejemplo:
   ```
   java -jar C:\SwaggerToCL\swagger-codegen-cli.jar generate -i C:\SwaggerToCL\tokens_2021-03-01.json -l java -t [path to selling-partner-api-models\clients\sellingpartner-api-aa-java folder]\resources\swagger-codegen\templates\ -o C:\SwaggerToCL\Tokens_JavaCL
   ```
   El SDK se copia en C:\SwaggerToCL\Tokens_JavaCL

10. Crea la biblioteca AA y añádelo como una dependencia del SDK:

1. Ve a la carpeta **selling-partner-api-models\clients\sellingpartner-api-aa-java** de tu copia local del repositorio y ejecuta el paquete mvn. Esto genera una carpeta llamada "target". En esta carpeta se encuentra un archivo llamado JAR **sellingpartnerapi-aa-java-1.0-jar-with-dependencies.jar** (o algo similar) y todas las dependecias necesarias.

2. Instala el archivo JAR en tu repositorio local de Maven.

   Por ejemplo:
   ```
   mvn install:install-file -Dfile=[path to JAR file in "target" folder] -DgroupId=com.amazon.sellingpartnerapi -DartifactId=sellingpartnerapi-aa-java -Dversion=1.0 -Dpackaging=jar
   ```
   Puedes encontrar los valores actuales de groupId, artifactId y la versión cerca de la parte superior del archivo **pom.xml** en la carpeta **selling-partner-api-models\clients\sellingpartner-api-aa-java**.

11. Añade una dependencia en la biblioteca AA en el **pom.xml** de la biblioteca cliente:

Por ejemplo:

```
<dependency>
<groupId>com.amazon.sellingpartnerapi</groupId>
<artifactId>sellingpartnerapi-aa-java</artifactId>
<version>1.0</version>
</dependency>
```
12. Ejecuta el **paquete mvn** en la carpeta SDK generada.

13. Descarga [restricted-data-token-workflow.java](https://github.com/amzn/selling-partner-api-models/commit/63a55cee11ca54caf8242884027a863860abaaf2) y utilízalo para crear una clase dentro de la carpeta **main/java/sampleCode/** de la biblioteca cliente generada.

Ya puedes comenzar a probar el proceso para obtener un RDT y utilizarlo para ejecutar una o más operaciones restringidas. Utiliza este código para orientarte en la creación de tus propias aplicaciones.

Colección Postman de la API de tokens
=============================

Puedes utilizar la [colección Postman de la API de tokens](https://github.com/amzn/selling-partner-api-models/blob/main/clients/postman-collections/tokens-api-sandbox-postman-collection.json) para probar la API de tokens en el espacio aislado de la API del colaborador comercial. Para obtener más información acerca de las pruebas con el espacio aislado, consulta [El espacio aislado de la API del colaborador comercial](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md#el-espacio-aislado-de-la-api-del-colaborador-comercial) en la guía para desarrolladores.