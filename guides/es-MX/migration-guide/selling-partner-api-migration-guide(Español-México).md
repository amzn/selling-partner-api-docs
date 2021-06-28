# Guía de migración de Amazon MWS a la API del colaborador comercial

# Descripción general
En este documento, se explica qué es la API del colaborador comercial, cómo se diferencia de Amazon Marketplace Web Service (Amazon MWS) y cómo convertir tu aplicación de Amazon MWS en una aplicación de la API del colaborador comercial.

# ¿Qué es la API del colaborador comercial?
La API del colaborador comercial es una API basada en REST que ayuda a los socios de ventas de Amazon a acceder de forma programática a sus datos en listados, pedidos, pagos, informes y más. La API del colaborador comercial es una modernización de Amazon MWS e incluye todas las funcionalidades que se encontraban disponibles en Amazon MWS. Todo desarrollo futuro estará disponible únicamente para la API del colaborador comercial.

## Características de la API del colaborador comercial
Para cada API del colaborador comercial hay un modelo Swagger, una referencia de la API y, en algunos casos, una Guía de casos de uso. También se incluyen bibliotecas cliente para ayudar con la autenticación de llamadas a la API del colaborador comercial.

Algunas de las nuevas características de la API del colaborador comercial incluyen lo siguiente:
* Está basada en REST con entrada y salida con formato JSON.
* Cuenta con nuevos endpoints que se admiten en todas las regiones.
* Ofrece instrucciones paso a paso en la Guía para desarrolladores de la API del colaborador comercial para la generación automatizada de SDK.
* Tiene una función de entorno de pruebas con endpoints independientes para realizar pruebas con datos simulados.
* Brinda un plan de uso dinámico que ajusta automáticamente los límites de las tarifas de cada socio de ventas en función de distintas medidas.
* Las aplicaciones de la API del colaborador comercial pueden incluirse en todas las regiones.
* Cuenta con soporte para tokens de datos restringidos, que ayudan a proteger la información de identificación personal (PII, por sus siglas en inglés) de los clientes.

API del colaborador comercial nuevas y actualizadas:
* **API de contenido A+.** Permite que los socios de ventas creen y editen contenido A+.
* **API de autorización.** Intercambia un token de autenticación de MWS existente con un código de autorización de la API del colaborador comercial.
* **API de artículos de catálogo.** Proporciona información detallada sobre el catálogo de Amazon.
* **API de elegibilidad de envíos entrantes de Logística de Amazon.**  Verifica la elegibilidad del ASIN para participar en la Logística de Amazon a fin de evitar la creación de envíos entrantes para ASIN no aptos.
* **API del inventario de la Logística de Amazon.** Es una API nueva y mejorada del inventario de Logística de Amazon, con nuevas funciones para vendedores de Logística de Amazon.
* **API de Small and Light de la Logística de Amazon.** Admite el programa Small and Light de la Logística de Amazon.
* **API de mensajería.** Permite que los socios de ventas envíen los diferentes tipos de mensajes admitidos a los clientes.
* **API de notificaciones.** Incluye nuevas notificaciones para cambios en el contenido de los artículos de marcas, cambios en el nombre del tipo de producto, cambios en el estado del pedido de la red logística del vendedor y cambios en la oferta de B2B.
* **API de precios.** Obtiene precios de productos e información de ofertas.
* **API de tarifas de productos.** Obtiene tarifas estimadas de los productos.
* **API de ventas.** Genera informes del historial de ventas.
* **API de servicios. ** Permite a los proveedores de servicios obtener y modificar sus pedidos de servicio.
* **API de envío.** Proporciona acceso programático a los servicios de envío de Amazon.
* **API de solicitudes.** Permite a los socios de ventas enviar solicitudes no críticas a los clientes.
* **API de tokens.** Proporciona una forma segura de acceder a la información de identificación personal (PII) de un cliente.

## Asignación de API de Amazon MWS a la API del colaborador comercial

| Amazon MWS | API del colaborador comercial |
| ----------------------------------------- | ----------------------------------- |
| Sección de la API de ficheros | API de ficheros |
| Sección de la API de finanzas | API de finanzas |
| Sección de la API de envíos a Amazon | API de gestión logística de envíos a Amazon |
| Sección de la API del inventario de gestión logística | API del inventario de Logística de Amazon |
| Sección de la API de envíos salientes | API de gestión logística de envíos salientes |
| Sección de la API de gestión del vendedor | API de gestión del vendedor |
| Sección de la API de pedidos | API de pedidos |
| Sección de la API de productos: Tarifas de productos | API de tarifas de productos |
| Sección de la API de productos: Listados de productos | API de artículos del catálogo |
| Sección de la API de productos: Precios de productos | API de precios |
| Sección de la API de recomendaciones | *En desuso en la API del colaborador comercial* |
| Sección de la API de informes | API de informes |
| Sección de la API de vendedores | API de vendedores |
| Sección de la API de suscripciones | API de notificaciones |

# Instructivo: Transformación de una aplicación de Amazon MWS en una aplicación de la API del colaborador comercial

Este instructivo indica cómo transformar una aplicación de Amazon MWS en una aplicación de la API del colaborador comercial.

**Requisitos**

- Tienes que haber registrado y publicado tu aplicación de Amazon MWS en la tienda de aplicaciones de Marketplace.

**Pasos**

## Paso 1. Solicitar el acceso a datos que requiere tu aplicación de la API del colaborador comercial

1. Inicia sesión en Seller Central con las credenciales asociadas a tu cuenta de desarrollador de Amazon MWS.

1. En el menú **Aplicaciones y servicios**, haz clic en **Desarrollar aplicaciones**.

   Aparece la página **Central de desarrolladores**.

1. En la página **Central de desarrolladores**, haz clic en el enlace **Tu perfil de desarrollador**.

   Aparece la **página Perfil de desarrollador**.

1. En la sección **Acceso a los datos** del formulario, selecciona los roles que requieren tus aplicaciones y envía el formulario.

Abriremos un ticket de Contáctenos para realizar un seguimiento de esta solicitud. Nos pondremos en contacto contigo después de haber evaluado tu solicitud. Esto podría tardar varios días.

## Paso 2. Crear y configurar un ARN de IAM
Sigue los pasos de [Creación y configuración de políticas y entidades de IAM](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md#Creating-and-configuring-IAM-policies-and-entities) en la Guía para desarrolladores de la API del colaborador comercial a fin de crear y configurar un ARN de IAM para su uso en el siguiente paso.

## Paso 3. Transformar tu aplicación de Amazon MWS en una aplicación híbrida de la API del colaborador comercial

1. Inicia sesión en Seller Central con las credenciales que utilizaste para registrarte como desarrollador.

1. En el menú **Aplicaciones y servicios**, haz clic en **Desarrollar aplicaciones**.

   Aparece la página **Central de desarrolladores**.

1. Junto a tu aplicación de Amazon MWS, en el menú **Editar aplicación**, haz clic en **Editar aplicación**.

1. Sigue las instrucciones para registrar tu aplicación. En el cuadro del **ARN de IAM**, utiliza el ARN de IAM del [Paso 2. Crea y configura un ARN de IAM](#Paso-2.-Crea-y-configura-un-ARN-de-IAM).

Cuando completes el formulario, tendrás una aplicación híbrida de la API del colaborador comercial en estado Borrador. Puedes avanzar a la configuración y prueba de un proceso de autorización en el siguiente paso.

## Paso 4. Implementar un proceso de autorización

Configura y prueba un proceso de autorización para tu aplicación híbrida de la API del colaborador comercial. Para obtener más información, consulta [Autorización de aplicaciones de la API del colaborador comercial](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md#authorizing-selling-partner-api-applications) en la Guía para desarrolladores de la API del colaborador comercial. Cuando hayas terminado de probar tu proceso de autorización, asegúrate de transformar tu proceso de autorización de prueba en un proceso de autorización de producción.

## Paso 5. Conectarse a la API del colaborador comercial

Configura un proceso para las operaciones de llamadas en la API del colaborador comercial. Esto incluye el intercambio de tokens LWA, la creación de URI, la incorporación de encabezados y la creación y firma de solicitudes. La forma más fácil de hacer esto es generar y usar un SDK que incluya autenticación e intercambio de tokens LWA. Para obtener más información, consulta [Generar un SDK de Java con autenticación e intercambio de tokens LWA](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md#generating-a-java-sdk-with-lwa-token-exchange-and-authentication) y [Conectarse a la API del colaborador comercial mediante un SDK de Java generado](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md#connecting-to-the-selling-partner-api-using-a-generated-java-sdk) en la Guía para desarrolladores de la API del colaborador comercial.

Para obtener información sobre cómo conectarte al entorno de pruebas de la API del colaborador comercial, consulta [El entorno de pruebas de la API del colaborador comercial](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md#the-selling-partner-api-sandbox) en la Guía para desarrolladores de la API del colaborador comercial.

## Paso 6. Publicar tu aplicación híbrida del colaborador comercial en la tienda de aplicaciones de Marketplace

1. Inicia sesión en Seller Central con las credenciales que utilizaste para registrarte como desarrollador.

1. En el menú **Aplicaciones y servicios**, haz clic en **Desarrollar aplicaciones**.

   Aparece la página **Central de desarrolladores**.

1. Junto a tu aplicación, en el menú **Editar aplicación**, haz clic en la flecha y, a continuación, haz clic en **Editar listado**.

1. Continúa con el proceso.

Después de completar la pantalla final, se publicará tu aplicación híbrida del colaborador comercial en la tienda de aplicaciones de Marketplace. Este proceso puede tomar de 5 a 10 días hábiles.

## Paso 7. Migrar autorizaciones de Amazon MWS a autorizaciones de la API del colaborador comercial

Migra tus autorizaciones existentes de Amazon MWS a las autorizaciones de la API del colaborador comercial. Para obtener más información, consulta la [Guía de casos de uso de la API de autorización](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/use-case-guides/authorization-api-use-case-guide/authorization-api-use-case-guide-v1.md).

## Paso 8. Migrar tus llamadas de Amazon MWS a llamadas a la API del colaborador comercial

El paso final es actualizar tu aplicación para que las acciones que antes activaban llamadas a operaciones de Amazon MWS ahora activen llamadas a las operaciones correspondientes de la API del colaborador comercial. Consulta [Asignación de API de Amazon MWS a la API del colaborador comercial](#Asignación-de-API-de-Amazon-MWS-a-la-API-del-colaborador-comercial) para ver qué operaciones de la API del colaborador comercial corresponden a las operaciones de Amazon MWS a las que ha estado llamando tu aplicación.

# Roles en la API del colaborador comercial

Un rol es el mecanismo utilizado por la API del colaborador comercial para determinar si un desarrollador o una aplicación tienen acceso a una operación o un recurso. Como desarrollador, tienes que solicitar un rol en particular y estar calificado para él, o no podrás acceder a las operaciones y los recursos que se encuentran agrupados bajo ese rol.

Los roles en la API del colaborador comercial son más específicos que los roles en Amazon MWS. Donde Amazon MWS tenía tres roles, la API del colaborador comercial tiene 11. Consulta [Roles en la API del colaborador comercial](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/roles/Roles-in-the-Selling-Partner-API.md) para obtener una explicación detallada de los roles en la API del colaborador comercial, así como una lista de roles y sus definiciones.

# El token de datos restringidos

La API del colaborador comercial protege la Información de identificación personal (PII) de los clientes mediante la solicitud de un token de datos restringidos (RDT, por sus siglas en inglés) con llamadas a operaciones restringidas (operaciones que muestran datos restringidos). Para obtener información sobre cómo obtener y usar RDT para llamar operaciones restringidas, consulta la [Guía de casos de uso de la API de tokens](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/use-case-guides/tokens-api-use-case-guide/tokens-API-use-case-guide-2021-03-01.md)

# El entorno de pruebas de la API del colaborador comercial
La API del colaborador comercial proporciona un entorno de pruebas que te permite probar tus aplicaciones sin afectar los datos de producción ni desencadenar eventos en el mundo real. Para obtener más información, consulta [Entorno de pruebas de la API del colaborador comercial](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md#the-selling-partner-api-sandbox) en la Guía para desarrolladores de la API del colaborador comercial.

# Recursos adicionales
* [Problemas de GitHub](https://github.com/amzn/selling-partner-api-docs/issues)
* Abre un [caso](https://sellercentral.amazon.com/cu/case-lobby?ref=xx_caseLog_xxxx_helphub&) en Seller Central para obtener asistencia
* [Guía para desarrolladores de la API del colaborador comercial](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md)
