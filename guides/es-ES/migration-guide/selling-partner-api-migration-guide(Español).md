# Guía de migración de Amazon MWS a la API del colaborador comercial

# Descripción general
En este documento se explica qué es la API del colaborador comercial, cómo se diferencia de Amazon Marketplace Web Service (Amazon MWS) y muestra cómo convertir tu aplicación de Amazon MWS en una aplicación API del colaborador comercial.

# ¿Qué es la API del colaborador comercial?
La API del colaborador comercial es una API basada en REST que ayuda a los colaboradores comerciales de Amazon a acceder de forma programada a sus datos sobre listings, pedidos, pagos, informes y mucho más. La API del colaborador comercial es el resultado de la modernización de Amazon MWS e incluye todas las funcionalidades hasta ahora disponibles en Amazon MWS. En el futuro, sólo se podrá acceder a la API del colaborador comercial.

## Funciones de la API del colaborador comercial
Para cada API del colaborador comercial hay un modelo tipo swagger, una referencia de la API y, en algunos casos, una guía de casos prácticos. También se incluyen bibliotecas cliente para ayudar con la autenticación de llamadas a las API del colaborador comercial.

Algunas de las nuevas funciones de la API del colaborador comercial incluyen:
* Sistema basado en REST con entrada y salida en formato JSON.
* Nuevos endpoints compatibles con todas las regiones.
* Instrucciones paso a paso en la guía para desarrolladores de la API del colaborador comercial para la generación automatizada de SDK.
* Una función de espacio aislado con endpoints de espacio aislado separados que permiten realizar pruebas con datos simulados.
* Un plan de uso dinámico que ajusta automáticamente los límites de las tarifas para cada colaborador comercial en función de una serie de medidas.
* Las aplicaciones API del colaborador comercial están disponibles en todas las regiones.
* Compatibilidad con tokens de datos restringidos, que ayudan a proteger la información de identificación personal (IIP) de los clientes.

API del colaborador comercial nuevas y actualizadas:
* **API de contenido A+.** Permite a los colaboradores comerciales crear y editar contenido A+.
* **API de autorización.** Intercambia un token de autenticación de MWS existente con un código de autorización de la API del colaborador comercial.
* **API de productos de catálogo.** Proporciona información detallada sobre el catálogo de Amazon.
* **API de elegibilidad de envíos de Logística de Amazon.** Comprueba la elegibilidad del ASIN para participar en Logística de Amazon con el fin de evitar crear envíos para ASIN no aptos.
* **API de inventario de Logística de Amazon.** API de inventario de Logística de Amazon nueva y mejorada con nuevas funciones para los vendedores de Logística de Amazon.
* **API de productos pequeños y ligeros de Logística de Amazon.** Compatible con el programa Productos pequeños y ligeros de Logística de Amazon.
* **API de mensajería.** Permite a los colaboradores comerciales enviar a los clientes los tipos de mensajes admitidos.
* **API de notificaciones.** Incluye notificaciones nuevas para cambios en el contenido de productos de marca, cambios en el nombre del tipo de producto, cambios en el estado de los pedidos de Red logística del vendedor y cambios en la oferta B2B.
* **API de precios.** Obtiene precios de productos e información sobre ofertas.
* **API de tarifas de producto.** Obtiene tarifas estimadas para un producto.
* **API de ventas.** Genera informes de historial de ventas.
* ** API de servicios. ** Permite a los proveedores de servicios obtener y modificar sus pedidos de servicio.
* **API de envío.** Proporciona acceso programático a los servicios de envío de Amazon.
* **API de solicitudes.** Permite a los colaboradores comerciales enviar solicitudes no críticas a los clientes.
* **API de tokens.** Permite acceder de forma segura a la información de identificación personal (PII) del cliente.

## Asignación de las API de Amazon MWS a la API del colaborador comercial

| Amazon MWS | API del colaborador comercial |
| ----------------------------------------- | ----------------------------------- |
| Sección de la API de ficheros | API de ficheros |
| Sección de la API de finanzas | API de finanzas |
| Sección de la API de envío a Amazon | API de envío a Amazon |
| Sección de la API de inventario de gestión logística | API de inventario de Logística de Amazon |
| Sección de la API de envío saliente de gestión logística | API saliente de gestión logística |
| Sección de la API de gestión del vendedor | API de gestión del vendedor |
| Sección de la API de pedidos | API de pedidos |
| Sección de la API de productos: tarifas de productos | API de tarifas de producto |
| Sección de la API de productos: listings de producto | API de productos de catálogo |
| Sección de la API de productos: precios de productos | API de precios |
| Sección de la API de recomendaciones | *Obsoleta en la API del colaborador comercial* |
| Sección de la API de informes | API de informes |
| Sección de la API de vendedores | API de vendedores |
| Sección de la API de suscripciones | API de notificaciones |

# Tutorial: Convertir una aplicación de Amazon MWS en una aplicación API del colaborador comercial

En este tutorial se muestra cómo convertir una aplicación de Amazon MWS en una aplicación API del colaborador comercial.

**Requisitos previos**

- Tienes que registrar tu aplicación Amazon MWS y publicarla en la tienda de aplicaciones del sitio web de Amazon.

**Pasos**

## Paso 1. Solicita el acceso a los datos que requiere tu aplicación API del colaborador comercial.

1. Inicia sesión en Seller Central con las credenciales asociadas a tu cuenta de desarrollador de Amazon MWS.

1. En el menú **Aplicaciones y servicios**, haz clic en **Desarrollar aplicaciones**.

   Aparecerá la página **Developer Central**.

1. En la página **Developer Central**, haz clic en el enlace de**tu perfil de desarrollador**.

   Aparecerá la página **Perfil de desarrollador**.

1. En la sección **Acceso a datos** del formulario, selecciona los roles que requieren las aplicaciones y envía el formulario.

Abriremos una solicitud de Contacto para que puedas realizar un seguimiento de dicha solicitud. Nos pondremos en contacto contigo después de haber evaluado tu solicitud; esto podría tardar varios días.

## Paso 2. Crea y configura un ARN de IAM
Sigue los pasos descritos en [Creación y configuración de directivas y entidades de IAM](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md#Creación-y-configuración-de-directivas-y-entidades-de-IAM) en la guía para desarrolladores de la API del colaborador comercial para crear y configurar un ARN de IAM y poder utilizarlo en el siguiente paso.

## Paso 3. Convierte tu aplicación de Amazon MWS en una aplicación API del colaborador comercial híbrida

1. Inicia sesión en Seller Central con las credenciales que utilizaste para registrarte como desarrollador.

1. En el menú **Aplicaciones y servicios**, haz clic en **Desarrollar aplicaciones**.

   Aparecerá la página **Developer Central**.

1. Junto a tu aplicación Amazon MWS, en el menú **Editar aplicación**, haz clic en **Editar aplicación**.

1. Sigue las instrucciones para registrar tu solicitud. En el cuadro **ARN de IAM**, utiliza el ARN de IAM del [Paso 2. Crea y configura un ARN de IAM](#paso-2-crea-y-configura-un-arn-de-iam).

Cuando completes el formulario, recibirás un borrador de la solicitud de la API del colaborador comercial híbrida. Ahora estás preparado para configurar y probar un proceso de autorización en el siguiente paso.

## Paso 4. Implementa un proceso de autorización

Configura y prueba un proceso de autorización para la aplicación de la API del colaborador comercial híbrida. Para obtener más información, consulta [Autorización de aplicaciones de la API del colaborador comercial](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md#autorización-de-aplicaciones-de-la-api-del-colaborador-comercial) en la guía para desarrolladores de la API del colaborador comercial. Cuando hayas terminado de probar el proceso de autorización, asegúrate de convertir el proceso de autorización de prueba en un proceso de autorización de producción.

## Paso 5. Conéctate a la API del colaborador comercial

Configura un proceso para las operaciones de llamada de la API del colaborador comercial. Esto incluye el intercambio de tokens de LWA, desarrollo de identificadores de recursos uniformes (URI), adición de encabezados y creación y firma de solicitudes. La forma más fácil de llevarlo a cabo es generar y utilizar un SDK que incluya el intercambio de tokens de LWA y la autenticación. Para obtener más información, consulta [Generación de un SDK de Java con intercambio y autenticación de tokens de LWA](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md#generación-de-un-sdk-de-java-con-intercambio-y-autorización-de-tokens-de-lwa) y [Conexión a la API del colaborador comercial mediante un SDK de Java generado](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md#conexión-a-la-api-del-colaborador-comercial-mediante-un-sdk-de-java-generado) en la guía para desarrolladores de la API del colaborador comercial.

Para obtener información acerca de cómo conectarse al espacio aislado de la API del colaborador comercial, consulta [Espacio aislado de la API del colaborador comercial](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md#espacio-aislado-de-la-api-del-colaborador-comercial) en la guía para desarrolladores de la API del colaborador comercial.

## Paso 6. Publica tu aplicación del colaborador comercial híbrida en la tienda de aplicaciones del sitio web de Amazon

1. Inicia sesión en Seller Central con las credenciales que utilizaste para registrarte como desarrollador.

1. En el menú **Aplicaciones y servicios**, haz clic en **Desarrollar aplicaciones**.

   Aparecerá la página **Developer Central**.

1. Junto a la aplicación, en el menú **Editar aplicación**, haz clic en la flecha y, a continuación, haz clic en **Editar listing**.

1. Procede con el proceso.

Tras completar la última pantalla, tu aplicación del colaborador comercial híbrida se publicará en la tienda de aplicaciones del sitio web de Amazon. Este proceso puede tardar de 5 a 10 días hábiles.

## Paso 7. Migra las autorizaciones de Amazon MWS a las autorizaciones de la API del colaborador comercial

Migra las autorizaciones existentes de Amazon MWS a las autorizaciones de la API del colaborador comercial Para obtener más información, consulta la [Guía de casos prácticos de la API de autorización](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/use-case-guides/authorization-api-use-case-guide/authorization-api-use-case-guide-v1.md).

## Paso 8. Migra tus llamadas de Amazon MWS a llamadas de la API del colaborador comercial

El último paso consiste en actualizar tu aplicación para que las acciones que antes desencadenaban llamadas a las operaciones de Amazon MWS ahora desencadenen llamadas a las correspondientes operaciones de la API del colaborador comercial. Consulta [Asignación de las API de Amazon MWS a la API del colaborador comercial](#asignación-de-las-api-de-amazon-mws-a-la-api-del-colaborador-comercial) para ver qué operaciones de la API del colaborador comercial se corresponden con las operaciones de Amazon MWS a las que tu aplicación ha estado llamando.

# Roles de la API del colaborador comercial

Un rol es el mecanismo utilizado por la API del colaborador comercial para determinar si un desarrollador o una aplicación tiene acceso a una operación o recurso. Como desarrollador, debes solicitar y reunir los requisitos para un rol determinado, de lo contrario no podrás acceder a las operaciones y recursos agrupados en dicho rol.

Los roles de la API del colaborador comercial son más precisos que los de Amazon MWS. Donde Amazon MWS tenía tres roles, la API del colaborador comercial tiene 11. Consulta [Roles de la API del colaborador comercial](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/roles/Roles-in-the-Selling-Partner-API.md) para obtener una explicación detallada de los roles de la API del colaborador comercial, así como una lista de roles y sus definiciones.

# Token de datos restringidos

La API del colaborador comercial protege la información de identificación personal (IIP) de los clientes exigiendo un token de datos restringidos (RDT) con llamadas a operaciones restringidas (operaciones que devuelven datos restringidos). Para obtener información sobre cómo obtener y usar RDT para llamar a operaciones restringidas, consulta la [Guía de casos prácticos de la API de tokens](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/use-case-guides/tokens-api-use-case-guide/tokens-API-use-case-guide-2021-03-01.md)

# Espacio aislado de la API del colaborador comercial
La API del colaborador comercial proporciona un entorno aislado que te permite probar tus aplicaciones sin afectar a los datos de producción ni desencadenar eventos reales. Para obtener más información, consulta la sección [Entorno aislado de la API del colaborador comercial](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md#entorno-aislado-de-la-api-del-colaborador-comercial) en la guía para desarrolladores de la API del colaborador comercial.

# Recursos adicionales
* [Problemas de GitHub](https://github.com/amzn/selling-partner-api-docs/issues)
* Ponte en contacto con el servicio de atención al cliente abriendo un [caso](https://sellercentral.amazon.com/cu/case-lobby?ref=xx_caseLog_xxxx_helphub&) en Seller Central
* [Guía para desarrolladores de API del colaborador comercial](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md)
