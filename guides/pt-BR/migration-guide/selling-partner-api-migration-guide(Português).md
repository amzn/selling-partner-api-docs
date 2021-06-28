# Guia de migração da API do parceiro de vendas do Amazon MWS

# Visão geral
Este documento explica o que é a API do parceiro de vendas, como ela difere do Amazon Marketplace Web Service (Amazon MWS) e mostra como converter seu aplicativo do Amazon MWS em um aplicativo da API do parceiro de vendas.

# O que é a API do parceiro de vendas?
A API do parceiro de vendas é uma API baseada em REST que ajuda os parceiros de vendas da Amazon a acessar programaticamente seus dados em ofertas, pedidos, pagamentos, relatórios e muito mais. A API do parceiro de vendas é uma modernização do Amazon MWS e inclui todas as funcionalidades disponíveis anteriormente no Amazon MWS. Todo o desenvolvimento futuro estará disponível apenas para a API do parceiro de vendas.

## Recursos da API do parceiro de vendas
Para cada API do parceiro de vendas, há um modelo Swagger, uma referência de API e, em alguns casos, um Guia de casos de uso. Também estão incluídas bibliotecas de clientes para ajudar na autenticação de chamadas a APIs do parceiro de vendas.

Alguns dos novos recursos da API do parceiros de vendas incluem:
* Baseada em REST com entrada e saída formatados em JSON.
* Novos endpoints que são compatíveis em todas as regiões.
* Instruções passo a passo no Guia do desenvolvedor da API do parceiro de vendas para geração automatizada de SDK.
* Um recurso de sandbox com endpoints de sandbox separados para testes com dados simulados.
* Um plano de uso dinâmico que ajusta automaticamente os limites de taxa para cada parceiro de venda com base em uma variedade de medidas.
* Os aplicativos de APIs do parceiro de vendas são aplicáveis em todas as regiões.
* Suporte para tokens de dados restritos, que ajudam a proteger as informações de identificação pessoal (IIP) dos clientes.

APIs do parceiro de vendas novas e atualizadas:
* **API de conteúdo A+.** Permite que os parceiros de venda criem e editem conteúdo A+.
* **API de autorização.** Troca um token de autenticação existente do MWS por um código de autorização da API do parceiros de vendas.
* **API de itens de catálogo.** Fornece informações detalhadas sobre o catálogo da Amazon.
* **API de elegibilidade do programa Enviado pela Amazon.** Verifica a elegibilidade do ASIN para participação no programa Enviado pela Amazon para evitar a criação de remessas recebidas para códigos ASIN não qualificados.
* **API de inventário do programa Enviado pela Amazon** Nova e aprimorada API de inventário do programa Enviado pela Amazon com novos recursos para vendedores do programa Enviado pela Amazon.
* **API Small and Light do programa Enviado pela Amazon** Compatível com o Small and Light do Enviado pela Amazon.
* **API de mensagens.** Permite que os parceiros de venda enviem tipos de mensagens compatíveis aos clientes.
* **API de notificações.** Inclui novas notificações para alterações de conteúdo de item de marca, alterações de nome de tipo de produto, alterações de status do pedido da rede de logística do vendedor e alterações de oferta B2B.
* **API de preços.** Obtém preços de produtos e oferece informações.
* **API de taxas de produto.** Recebe tarifas estimadas para um produto.
* **API de vendas.** Gera relatórios de histórico de vendas.
* **API de serviços. ** Permite que os provedores de serviços obtenham e modifiquem seus pedidos de serviço.
* **API de envio.** Fornece acesso programático aos serviços de envio da Amazon.
* **API de solicitações.** Permite que os parceiros de vendas enviem solicitações não críticas aos clientes.
* **API de tokens.** Fornece uma maneira segura de acessar as informações de identificação pessoal (IIP) de um cliente.

## Mapeamento de APIs do Amazon MWS para a API do parceiro de vendas

| Amazon MWS | API do parceiro de vendas |
| ----------------------------------------- | ----------------------------------- |
| Seção de API de feeds | API de feeds |
| Seção de API de finanças | API de finanças |
| Seção de API de remessa de entrada | API de remessa de entrada |
| Seção de API de inventário de logística | API de inventário do programa Enviado pela Amazon |
| Seção de API de remessa de saída de logística | API de remessa de saída |
| Seção de API com envio pelo vendedor | API com envio pelo vendedor |
| Seção de API de pedidos | API de pedidos |
| Seção de API de produtos – Taxas de produtos | API de taxas de produto |
| Seção de API de produtos – Ofertas de produtos | API de itens de catálogo |
| Seção de API de produtos – Preços de produtos | API de preços |
| Seção de API de recomendações | *Defasado na API do parceiro de vendas* |
| Seção de API de relatórios | API de relatórios |
| Seção de API de vendedores | API de vendedores |
| Seção de API de assinaturas | API de notificações |

# Tutorial: Converter um aplicativo do Amazon MWS em um aplicativo da API do parceiro de vendas

Este tutorial mostra como converter um aplicativo do Amazon MWS em um aplicativo de API do parceiro de vendas.

**Pré-requisitos**

- Você registrou seu aplicativo do Amazon MWS e o publicou na Marketplace Appstore.

**Etapas**

## Etapa 1. Solicitar o acesso aos dados que o aplicativo da API do parceiro de vendas requer

1. Faça login no Seller Central com as credenciais associadas à sua conta de desenvolvedor do Amazon MWS.

1. No menu **Aplicativos e serviços**, clique em **Desenvolver aplicativos**.

   A página **Central do desenvolvedor** será exibida.

1. Na página **Central do desenvolvedor**, clique no link **Perfil do desenvolvedor**.

   A **página Perfil do desenvolvedor** é exibida.

1. Na seção**Acesso aos dados** do formulário, selecione as funções que seus aplicativos exigem e envie o formulário.

Abriremos um tíquete do Fale conosco para você rastrear este pedido. Entraremos em contato com você depois de termos avaliado seu pedido. Isso pode levar alguns dias.

## Etapa 2. Criar e configurar um ARN do IAM
Siga as etapas em [Criação e configuração de políticas e entidades do IAM](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md#Creating-and-configuring-IAM-policies-and-entities) no Guia do desenvolvedor da API do parceiro de vendas para criar e configurar um ARN do IAM para uso na etapa a seguir.

## Etapa 3. Converter seu aplicativo do Amazon MWS em um aplicativo híbrido da API do parceiro de vendas

1. Faça login no Seller Central usando as credenciais que você usou para se registrar como desenvolvedor.

1. No menu **Aplicativos e serviços**, clique em **Desenvolver aplicativos**.

   A página **Central do desenvolvedor** será exibida.

1. Ao lado do aplicativo do Amazon MWS, no menu **Editar aplicativo**, clique em **Editar aplicativo**.

1. Siga as instruções para registrar seu aplicativo. Na caixa** ARN do IAM**, use o ARN do IAM da [Etapa 2. Criar e configurar um ARN do IAM](#Etapa-2-Criar-e-configurar-um-ARN-do-IAM).

Ao preencher o formulário, haverá um aplicativo híbrido da API do parceiro de vendas no status Rascunho. Agora você está pronto para configurar e testar um fluxo de trabalho de autorização no passo a seguir.

## Etapa 4. Implementar um fluxo de trabalho de autorização

Configure e teste um fluxo de trabalho de autorização para o aplicativo híbrido da API do parceiro de vendas. Para obter mais informações, consulte [Autorização de aplicativos da API do parceiro de vendas](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md#authorizing-selling-partner-api-applications) no Guia do desenvolvedor da API do parceiro de vendas. Ao terminar de testar seu fluxo de trabalho de autorização, certifique-se de converter o fluxo de trabalho de autorização de teste em um fluxo de trabalho de autorização de produção.

## Passo 5. Conectar-se à API do parceiro de vendas

Configure um fluxo de trabalho para chamadas de operações na API do parceiro de vendas. Isso inclui trocar tokens LWA, construir URIs, adicionar cabeçalhos e criar e assinar solicitações. A maneira mais fácil de fazer isso é gerar e usar um SDK que inclua troca de token LWA e autenticação. Para obter mais informações, consulte [Gerar um SDK de Java com troca e autenticação de token LWA](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md#generating-a-java-sdk-with-lwa-token-exchange-and-authentication) e [Conectar-se à API do parceiro de vendas usando um SDK de Java gerado](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md#connecting-to-the-selling-partner-api-using-a-generated-java-sdk) no Guia do desenvolvedor da API do parceiro de vendas.

Para obter informações sobre como se conectar à sandbox da API do parceiro de vendas, consulte [Sandbox da API do parceiro de vendas](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md#the-selling-partner-api-sandbox) no Guia do desenvolvedor da API do parceiro de vendas.

## Etapa 6. Publicar seu aplicativo híbrido de parceiro de vendas na Marketplace Appstore

1. Faça login no Seller Central usando as credenciais que você usou para se registrar como desenvolvedor.

1. No menu **Aplicativos e serviços**, clique em **Desenvolver aplicativos**.

   A página **Central do desenvolvedor** será exibida.

1. Ao lado do aplicativo, no menu **Editar aplicativo**, clique na seta e, em seguida, em **Editar oferta**.

1. Prossiga pelo fluxo de trabalho.

Depois de concluir a tela final, seu aplicativo de parceiro de venda híbrido será publicado na Marketplace Appstore. Este processo pode levar de 5 a 10 dias úteis.

## Etapa 7. Migrar autorizações do Amazon MWS para autorizações da API do parceiro de vendas

Migre suas autorizações existentes do Amazon MWS para autorizações da API do parceiro de vendas. Consulte mais informações no [Guia de uso da API de autorização](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/use-case-guides/authorization-api-use-case-guide/authorization-api-use-case-guide-v1.md).

## Etapa 8. Migre suas chamadas do Amazon MWS para chamadas à API do parceiro de vendas

A etapa final é atualizar seu aplicativo para que as ações que antes acionavam chamadas a operações do Amazon MWS agora acionem chamadas às operações de API do parceiro de vendas correspondentes. Consulte [Mapeamento de APIs do Amazon MWS para a API do parceiro de vendas](#Mapeamento-de-APIs-do-Amazon-MWS-para-a-API-do-parceiro-de-vendas) para ver quais operações da API do parceiro de vendas correspondem às operações do Amazon MWS que seu aplicativo está chamando.

# Funções na API do parceiro de vendas

Uma função é o mecanismo usado pela API do parceiro de vendas para determinar se um desenvolvedor ou aplicativo tem acesso a uma operação ou recurso. Como desenvolvedor, você deve solicitar e se qualificar para uma função específica ou não poderá acessar as operações e os recursos agrupados nessa função.

As funções na API do parceiro de vendas são mais refinadas do que as funções no Amazon MWS. Onde o Amazon MWS tinha três funções, a API do parceiro de vendas tem onze. Consulte [Funções na API do parceiro de vendas](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/roles/Roles-in-the-Selling-Partner-API.md) para obter uma explicação detalhada das funções na API do parceiro de vendas, bem como uma lista de funções e suas definições.

# Token de dados restritos

A API do parceiro de vendas protege as informações de identificação pessoal (IIP) dos clientes ao exigir um token de dados restritos (RDT) com chamadas para operações restritas (operações que retornam dados restritos). Para obter informações sobre como obter e usar RDTs para chamar operações restritas, consulte o [Guia de caso de uso da API de Tokens](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/use-case-guides/tokens-api-use-case-guide/tokens-API-use-case-guide-2021-03-01.md)

# Sandbox da API do parceiro de vendas
A API do parceiro de vendas fornece um ambiente de sandbox que permite testar seus aplicativos sem afetar os dados de produção nem acionar eventos reais. Para obter mais informações, consulte [Sandbox da API do parceiro de vendas](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md#the-selling-partner-api-sandbox) no Guia do desenvolvedor da API do parceiro de vendas.

# Recursos adicionais
* [Problemas do GitHub](https://github.com/amzn/selling-partner-api-docs/issues)
* Entre em contato com o suporte abrindo um [caso](https://sellercentral.amazon.com/cu/case-lobby?ref=xx_caseLog_xxxx_helphub&) no Seller Central
* [Guia do desenvolvedor da API do parceiro de vendas](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md)
