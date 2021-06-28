Guia de casos de uso da API Tokens
=========================

Versão: 01/03/2021

O que é a API Tokens?
=======================

A API do parceiro de vendas para tokens (API Tokens) fornece uma maneira segura de acessar as informações de identificação pessoal (IIP) de um cliente. Você pode fazer uma chamada à API Tokens para obter um token de dados restritos (RDT) para um ou mais recursos restritos que você especificar. O RDT autoriza você a fazer chamadas subsequentes às operações restritas que os recursos restritos representam. Consulte [Terminologia](#terminologia).

Quando você faz uma chamada a uma operação restrita, você inclui um RDT no cabeçalho `x-amz-access-token`. Isso contrasta com todas as outras operações da SP-API, em que você inclui um token de acesso LWA no cabeçalho `x-amz-access-token`. Consulte mais informações na [Etapa 3. Adicionar cabeçalhos ao URI](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md#step-3-add-headers-to-the-uri).

Terminologia
-----------

- **Token de dados restritos (RDT)**. Um token de acesso de curta duração que autoriza você a fazer chamadas a operações restritas.

- **Operação restrita.** Uma operação que retorna dados restritos, como informações de identificação pessoal (IIP). Você precisa de um RDT para fazer chamadas a uma operação restrita. Consulte [Operações restritas](#operações-restritas).

- **Recurso restrito.** Um método HTTP e um caminho que representam uma operação restrita.

- **Tipo de relatório restrito.** Um tipo de relatório que contém IIP. Consulte [Tipos de relatórios restritos](#tipos-de-relatório-restritos)

- **Caminho específico.** Um caminho em um recurso restrito que contém um ID de pedido ou ID de envio específico. Por exemplo, `orders/v0/orders/902-3159896-1390916/address`

- **Caminho genérico.** Um caminho em um recurso restrito que não contém um ID de pedido ou ID de envio específico. Em vez disso, ele contém a string `{orderId}` ou `{shipmentId}`. Por exemplo, `orders/v0/orders/{orderId}/address`

Operações restritas
=====================

As operações restritas retornam informações de identificação pessoal (IIP) dos clientes. Para obter mais informações sobre como fazer chamadas a operações restritas, consulte [Tutorial: Obtenção de um RDT e chamadas a operações restritas](#tutorial-obtenção-de-um-rdt-e-chamadas-a-operações-restritas).

Aqui está a lista de operações restritas, agrupadas por API:

API de pedidos:

- ```getOrderBuyerInfo```

- ```getOrderAddress```

- ```getOrderItemsBuyerInfo```

API de envio:

- ```getShipment```

API com Envio pelo vendedor:

- ```getShipment```

- ```cancelShipment```

- ```cancelShipmentOld```

- ```createShipment```

API de relatórios:

- ```getReportDocument```

   **Observações:**

   - A operação getReportDocument é considerada uma operação restrita somente quando um relatório restrito é especificado. Veja a lista de tipos de relatório restritos abaixo.

   - Ao chamar a operação createRestrictedDataToken para obter um RDT para a operação getReportDocument, o recurso restrito especificado pode conter apenas um caminho específico, não um caminho genérico. Para obter mais informações, consulte [Tutorial: Obtenção de um RDT e chamadas a operações restritas](#tutorial-obtenção-de-um-rdt-e-chamadas-a-operações-restritas) e [Terminologia](#terminologia).

Tipos de relatório restritos
-----------------------

Os tipos de relatório restritos contêm IIP. Ao especificar um tipo de relatório restrito em uma chamada para a operação getReportDocument, você deve passar um RDT com a chamada. Para obter mais informações, consulte [Tutorial: Obtenção de um RDT e chamadas a operações restritas](#tutorial-obtenção-de-um-rdt-e-chamadas-a-operações-restritas).

Aqui está uma lista de tipos de relatório restritos:

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

Tutorial: Obtenção de um RDT e chamadas a operações restritas
===================================================

Este tutorial mostra como usar a API Tokens para obter um tokens de dados restritos (RDT) e, em seguida, usar o RDT para fazer chamadas a operações restritas.

**Pré-requisitos**

Para concluir este tutorial, você precisará de:

- Autorização do parceiro de vendas para quem você está fazendo chamadas. Consulte o [Guia do desenvolvedor da API do parceiro de vendas](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md) para obter mais informações.

Etapa 1. Obter um RDT
------------------

Chame a operação createRestrictedDataToken para obter um RDT.

- Chame a operação [createRestrictedDataToken](https://github.com/amzn/selling-partner-api-docs/blob/main/references/tokens-api/tokens_2021-03-01.md#createrestricteddatatoken), passando os seguintes parâmetros:

Parâmetros do corpo:

| Parâmetro | Descrição | Tipo | Obrigatório |
|-----------|-------------|------|----------|
| restrictedResources | Modelo de um recurso restrito.</br> Máximo: 50 | <a href="#restrictedresources">restrictedResources</a> | Sim |

Exemplo de solicitação:
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
**Resposta**

Uma resposta bem-sucedida inclui o seguinte:

| Nome | Cabeçalho 2 | Tipo |
|----------|----------|------|
| restrictedDataToken | Um token de dados restritos (RDT). Este é um token de acesso de curta duração que autoriza você a chamar as operações restritas representadas pelos recursos restritos que você especificou. Passe o valor RDT no cabeçalho <code>x-amzn-access-token</code> ao fazer chamadas subsequentes às operações restritas. | string |
| expiresIn | A vida útil do RDT, em segundos. | integer |

Exemplo de resposta:
```
{
	"payload": {
		"restrictedDataToken": "Atz.sprdt|IQEBLjAsAhRmHjNgHpi0U-Dme37rR6CuUpSR",
		"expiresIn": 3600
	}
}
```
Agora você tem um RDT que autoriza você a chamar as seguintes operações restritas:

- **getOrderAddress.** Você pode chamar a operação getOrderAddress usando o caminho específico do recurso restrito que você especificou. Por exemplo, `/orders/v0/orders/902-3159896-1390916/address`.

- **getOrderBuyerInfo.** Você pode chamar a operação getOrderBuyerInfo usando o caminho genérico do recurso restrito que você especificou, substituindo `{orderId}` por um ID de pedido do parceiro de vendas. Por exemplo, `/orders/v0/orders/058-1233752-8214740/buyerInfo` e `/orders/v0/orders/483-3488972-0896720/buyerInfo`. Você pode usar o RDT para qualquer um dos IDs de pedidos do parceiro de vendas.

- **getShipment.** Você pode chamar a operação getShipment usando o caminho genérico a partir do recurso restrito que você especificou, substituindo `{shipmentId}` por um ID de envio do parceiro de vendas. Por exemplo, `/mfn/v0/shipments/6f77095e-9f75-47eb-aaab-a42d5428fa1a`. Você pode usar o RDT para qualquer um dos IDs de envio do parceiro de vendas.

Para obter mais informações, consulte [Terminologia](#terminologia).

Etapa 2. Fazer chamadas a operações restritas
----------------------------------

Chame as operações restritas para as quais o RDT na [Etapa 1. Obter um RDT](#etapa-1-obter-um-rdt) deu autorização. Ao chamar as operações restritas, inclua o RDT no cabeçalho `x-amz-access-token`. Consulte mais informações na [Etapa 3. Adicionar cabeçalhos ao URI](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md#step-3-add-headers-to-the-uri).

Exemplos de solicitação:
```
GET https://sellingpartnerapi-na.amazon.com/orders/v0/orders/orders/v0/orders/902-3159896-1390916/address.

GET https://sellingpartnerapi-na.amazon.com/orders/v0/orders/902-3159896-1390916/buyerInfo

GET https://sellingpartnerapi-na.amazon.com/orders/v0/orders/483-3488972-0896720/buyerInfo

GET https://sellingpartnerapi-na.amazon.com/mfn/v0/shipments/6f77095e-9f75-47eb-aaab-a42d5428fa1a
```
Tipos de dados
---------

### restrictedResources

<table><thead><tr class="header"><th><strong>Parâmetro</strong></th><th><strong>Descrição</strong></th><th><strong>Método</strong></th></tr></thead><tbody><tr class="odd"><td>necessário</td><td><p>O método HTTP usado com o recurso restrito.</p><p>Tipo: <a href="https://github.com/amzn/selling-partner-api-docs/blob/main/references/tokens-api/tokens_2021-03-01.md#method">Método</a></p></td><td>Sim</td></tr><tr class="even"><td>path</td><td><p>O caminho de uma operação restrita. Isso pode ser:</p><ul><li><p>Um caminho específico contendo o ID do pedido, o ID de envio ou o ID do documento do relatório de um vendedor, por exemplo, <code>/orders/v0/orders/902-3159896-1390916/address</code> ou <code>/mfn/v0/shipments/6f77095e-9f75-47eb-aaab-a42d5428fa1a</code></p></li><li><p>Um caminho genérico que não contém o ID do pedido ou ID de envio de um vendedor, por exemplo, <code>/orders/v0/orders/{orderId}/address</code> ou <code>/mfn/v0/shipments/{shipmentId}</code></p></li></ul><p>Tipo: string</p></td><td>Yes</td></tr></tbody></table>

Tutorial: Geração de um SDK de Java para a API Tokens
================================================

Estas instruções mostram como gerar um SDK de Java para a API Tokens usando o [Swagger Code Generator](https://github.com/swagger-api/swagger-codegen) em um computador com o Microsoft Windows. O processo é o mesmo para usuários de outros sistemas operacionais, como macOS ou Linux, com a substituição de semânticas específicas do Windows (por exemplo, C:\\). Consulte <https://github.com/amzn/selling-partner-api-models> para obter o modelo do Swagger para a API Tokens.

Com esse SDK, você pode fazer chamadas à API Tokens com o seguinte código já configurado para você: Login com a Amazon com substituição e autenticação de token (substitua um token de atualização por um token de acesso).

**Para gerar um SDK de Java com substituição e autenticação de token de LWA**

1. Instale o [Java 8 ou mais recente](https://www.oracle.com/technetwork/java/index.html), o [Apache Maven 3.6. ou superior](http://maven.apache.org/) e o [GNU Wget](https://www.gnu.org/software/wget/wget.html) e disponibilize-os no seu $PATH.

2. Vá para <https://github.com/amzn/selling-partner-api-models>.

3. Clone o repositório para fazer uma cópia local no computador, caso ainda não tenha feito isso.

4. Abra uma janela de prompt de comando e vá para o diretório no qual você deseja baixar o Swagger Code Generator.

5. Baixe a versão mais recente do Swagger Code Generator.

   Por exemplo:
   ```
   wget https://repo1.maven.org/maven2/io/swagger/swagger-codegen-cli/2.4.13/swagger-codegen-cli-2.4.13.jar -O swagger-codegen-cli.jar
   ```
   **swagger-codegen-cli.jar** será baixado para o diretório atual.

   **Observação:** Você também pode baixar do maven.org direcionando seu navegador para: <https://repo1.maven.org/maven2/io/swagger/swagger-codegen-cli/2.4.13/swagger-codegen-cli-2.4.13.jar>

6. Copie **swagger-codegen-cli.jar** em uma estrutura de diretórios que faça sentido para você. Para este exemplo, vamos copiá-lo em C:\SwaggerToCL.

7. Navegue até **tokens_2021-03-01.jso** na pasta **selling-partner-api-models\models\tokens-api-model** da sua cópia local do repositório.

8. Copie **tokens_2021-03-01.json** em C:\SwaggerToCL.

9. Gere o SDK de acordo com os modelos na pasta **selling-partner-api-models\clients\sellingpartner-api-aa-java** da sua cópia local do repositório. Essa pasta contém uma biblioteca de autorização e autenticação, juntamente com modelos personalizados do Swagger Code Generator.

   Por exemplo:
   ```
   java -jar C:\SwaggerToCL\swagger-codegen-cli.jar generate -i C:\SwaggerToCL\tokens_2021-03-01.json -l java -t [caminho para selling-partner-api-models\clients\sellingpartner-api-aa-java folder]\resources\swagger-codegen\templates\ -o C:\SwaggerToCL\Tokens_JavaCL
   ```
   O SDK é copiado para C:\SwaggerToCL\Tokens_JavaCL

10. Crie a Biblioteca AA e adicione-a como uma dependência do SDK:

1. Navegue até a pasta **selling-partner-api-models\clients\sellingpartner-api-aa-java** da sua cópia local do repositório e execute o pacote mvn. Isso gera uma pasta chamada “target”. Essa pasta contém um arquivo JAR chamado **sellingpartnerapi-aa-java-1.0-jar-with-dependencies.jar** (ou algo semelhante) e todas as dependências necessárias.

2. Instale o arquivo JAR no repositório local do Maven.

   Por exemplo:
   ```
   mvn install:install-file -Dfile=[caminho para arquivo JAR na pasta "target"] -DgroupId=com.amazon.sellingpartnerapi -DartifactId=sellingpartnerapi-aa-java -Dversion=1.0 -Dpackaging=jar
   ```
   Os valores reais de groupID, artifactID e version estão localizados próximos à parte superior do arquivo **pom.xml** na pasta **selling-partner-api-models\clients\sellingpartner-api-aa-java**.

11. Adicione uma dependência na biblioteca AA no **pom.xml** da biblioteca de clientes:

Por exemplo:

```
<dependency>
<groupId>com.amazon.sellingpartnerapi</groupId>
<artifactId>sellingpartnerapi-aa-java</artifactId>
<version>1.0</version>
</dependency>
```
12. Execute o **pacote mvn** dentro da pasta SDK gerada.

13. Baixe [restricted-data-token-workflow.java](https://github.com/amzn/selling-partner-api-models/commit/63a55cee11ca54caf8242884027a863860abaaf2) e use-o para criar uma classe dentro da pasta **main/java/sampleCode/** da biblioteca de clientes gerada.

Agora você pode começar a testar o fluxo de trabalho para obter um RDT e usá-lo para chamar uma ou mais operações restritas. Use este código para orientá-lo na criação de seus próprios aplicativos.

Coleção do Postman da API Tokens
=============================

Você pode usar a [coleção do Postman da API Tokens](https://github.com/amzn/selling-partner-api-models/blob/main/clients/postman-collections/tokens-api-sandbox-postman-collection.json) para testar a API Tokens no ambiente de sandbox da API do parceiro de vendas. Para obter mais informações sobre testes com a sandbox, consulte a [sandbox da API do parceiro de vendas](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md#the-selling-partner-api-sandbox) no Guia do desenvolvedor.