# Gids voor migratie van Amazon MWS naar de API Verkooppartner

# Overzicht
In dit document wordt uitgelegd wat de API Verkooppartner is, hoe deze verschilt van Amazon Marketplace Web Service (Amazon MWS), en hoe je je Amazon MWS-applicatie kunt converteren naar een API Verkooppartner-applicatie.

# Wat is de API Verkooppartner?
De API Verkooppartner is een op REST gebaseerde API die Amazon-verkooppartners helpt om programmatische toegang te krijgen tot de gegevens van hun productvermeldingen, bestellingen, betalingen, rapporten, enz. De API Verkooppartner is een modernisering van Amazon MWS en bevat alle functies die eerder beschikbaar waren via Amazon MWS. Toekomstige ontwikkeling zal alleen nog zijn gericht op de API Verkooppartner.

## Functies van de API Verkooppartner
Voor elke API-sectie van de API Verkooppartner is een Swagger-model beschikbaar, een API-referentie, en in sommige gevallen ook een gids voor gebruiksscenario‘s. Ook inbegrepen zijn clientbibliotheken om je te helpen bij authenticatie van oproepen naar de API Verkooppartner-secties.

Enkele van de nieuwe functies van de API Verkooppartner zijn:
* Op REST gebaseerd, met invoer en uitvoer in JSON-indeling.
* Nieuwe eindpunten die in alle regio's worden ondersteund.
* Stapsgewijze instructies in de Ontwikkelaarsgids voor API Verkooppartner voor het automatisch genereren van een SDK.
* Een testomgevingsfunctie met speciale eindpunten voor het testen met mock-gegevens.
* Een dynamisch gebruiksplan dat automatisch gebruikslimieten voor verkooppartners aanpast op basis van verschillende factoren.
* API Verkooppartner-applicaties zijn toepasbaar in alle regio‘s.
* Ondersteuning voor Restricted Data Tokens (RTD), die de Persoonlijk Identificeerbare Informatie (PII) van klanten helpt beschermen.

Nieuwe en bijgewerkte API Verkooppartner-secties:
* **API voor A+-content.** Hiermee kunnen verkooppartners A+-content maken en bewerken.
* **Autorisatie-API.** Wisselt een bestaand MWS-authenticatietoken uit voor een API Verkooppartner-autorisatiecode.
* **API voor catalogusitems.** Biedt gedetailleerde informatie over de Amazon-catalogus.
* **API voor controle van binnenkomende FBA-zendingen.** Controleert of ASIN‘s in aanmerking komen voor Fulfillment by Amazon (FBA) om te voorkomen dat binnenkomende zendingen worden gemaakt voor niet in aanmerking komende ASIN's.
* **API voor FBA-voorraad.** Nieuwe en verbeterde API voor FBA-voorraad met nieuwe functies voor FBA-verkopers.
* **API voor FBA Klein en licht.** Ondersteunt het FBA Klein en licht-programma.
* **Berichten-API.** Hiermee kunnen verkooppartners ondersteunde berichttypen naar klanten verzenden.
* **Meldingen-API.** Bevat nieuwe meldingen voor wijzigingen in de inhoud van merkartikelen, wijzigingen in producttype, wijzigingen in de status van MFN-bestellingen en wijzigingen in B2B-aanbiedingen.
* **Prijzen-API.** Haalt productprijzen en informatie over aanbiedingen op.
* **Productkosten-API.** Haalt de geschatte kosten voor een product op.
* **Verkoop-API.** Genereert rapporten met de verkoopgeschiedenis.
* **Services-API. ** Hiermee kunnen serviceaanbieders hun service-orders ophalen en wijzigen.
* **API voor verzending.** Biedt programmatische toegang tot de verzendservices van Amazon.
* **API voor beoordelingsaanvragen.** Stelt verkooppartners in staat om niet-essentiële beoordelingsaanvragen naar klanten te sturen.
* **Tokens-API.** Biedt een veilige manier om toegang te krijgen tot de Persoonlijk Identificeerbare Informatie (PII) van een klant.

## API's van Amazon MWS toewijzen aan de API Verkooppartner

| Amazon MWS | API Verkooppartner |
| ----------------------------------------- | ----------------------------------- |
| API-sectie Feeds | Feeds-API |
| API-sectie Financiën | Financiën-API |
| API-sectie Fulfillment binnenkomende zendingen | API voor fulfillment binnenkomende zendingen |
| API-sectie Fulfillment-voorraad | API voor FBA-voorraad |
| API-sectie Fulfillment uitgaande zendingen | API voor uitgaande zendingen |
| API-sectie Fulfillment door verkoper | API voor fulfillment door verkoper |
| API-sectie Bestellingen | API voor bestellingen |
| API-sectie Producten: productkosten | API voor productkosten |
| API-sectie Producten: productvermeldingen | API voor catalogusitems |
| API-sectie Producten: productprijzen | Prijzen-API |
| API-sectie Aanbevelingen | *Afgeschafte API Verkooppartner-secties* |
| API-sectie Rapporten | Rapporten-API |
| API-sectie Verkopers | Verkopers-API |
| API-sectie Abonnementen | Meldingen-API |

# Tutorial: Een Amazon MWS-applicatie converteren naar een API Verkooppartner-applicatie

Deze tutorial laat zien hoe je een Amazon MWS-applicatie kunt converteren naar een API Verkooppartner-applicatie.

**Vereisten**

- Je hebt je Amazon MWS-applicatie geregistreerd en gepubliceerd in de Marketplace Appstore.

**Stappen**

## Stap 1. Vraag de gegevenstoegang aan die voor je API Verkooppartner-applicatie vereist is.

1. Meld je aan bij Seller Central met de aanmeldgegevens die zijn gekoppeld aan je Amazon MWS-ontwikkelaarsaccount.

1. Klik in het menu **Apps en services** op **Apps ontwikkelen**.

   De pagina **Developer Central** verschijnt.

1. Klik op de pagina **Developer Central** op de link **Je ontwikkelaarsprofiel**.

   De **pagina Ontwikkelaarsprofiel** wordt weergegeven.

1. Selecteer in het gedeelte **Gegevenstoegang** van het formulier de rollen die voor je applicatie vereist zijn en dien het formulier in.

We openen een Contact-ticket voor je zodat je je aanvraag kunt volgen. We nemen vervolgens contact met je op nadat we je aanvraag hebben beoordeeld; dit kan enkele dagen duren.

## Stap 2. Maak en configureer een IAM ARN
Volg de stappen in [IAM-beleidsregels en -entiteiten maken en configureren](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md#Creating-and-configuring-IAM-policies-and-entities) in de Ontwikkelaarsgids voor API Verkooppartner om een IAM ARN te maken en te configureren. Deze heb je nodig in de volgende stap.

## Stap 3. Converteer je Amazon MWS-applicatie naar een hybride API Verkooppartner-applicatie

1. Meld je aan bij Seller Central met de aanmeldgegevens die je hebt gebruikt om je als ontwikkelaar te registreren.

1. Klik in het menu **Apps en services** op **Apps ontwikkelen**.

   De pagina **Developer Central** verschijnt.

1. Klik naast je Amazon MWS-applicatie in het menu **App bewerken** op **App bewerken**.

1. Volg de instructies om je aanvraag te registreren. Gebruik in het veld **IAM ARN** de IAM ARN uit [Stap 2. Maak en configureer een IAM ARN](#Stap-2.-Maak-en-configureer-een-IAM-ARN).

Na het invullen van het formulier, heeft je hybride API Verkooppartner-applicatie de status Concept. Je bent nu klaar om in de volgende stap een autorisatieworkflow in te stellen en te testen.

## Stap 4. Implementeer een autorisatieworkflow

Stel een autorisatieworkflow in en test deze voor je hybride API Verkooppartner-applicatie. Zie voor meer informatie het onderwerp [API Verkooppartner-applicaties autoriseren](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md##authorizing-selling-partner-api-applications) in de Ontwikkelaarsgids voor API Verkooppartner. Wanneer je klaar bent met het testen van je autorisatieworkflow, moet je je test-autorisatieworkflow converteren naar een productie-autorisatieworkflow.

## Stap 5. Maak verbinding met de API Verkooppartner

Stel een workflow in voor oproepbewerkingen in de API Verkooppartner. Dit omvat het uitwisselen van LWA-tokens, het maken van URL‘s, het toevoegen van kopteksten en het maken en ondertekenen van aanvraagbewerkingen. De eenvoudigste manier om dit te doen is door een SDK te genereren en te gebruiken die LWA-tokenuitwisseling en -authenticatie bevat. Zie voor meer informatie [Een Java-SDK genereren met LWA-tokenuitwisseling en -authenticatie](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md##generating-a-java-sdk-with-lwa-token-exchange-and-authentication) en [Verbinding maken met de API Verkooppartner met behulp van een gegenereerde Java-SDK](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md##connecting-to-the-selling-partner-api-using-a-generated-java-sdk) in de Ontwikkelaarsgids voor API Verkoper.

Zie voor meer informatie over verbinding maken met de API Verkooppartner-testomgeving [De API Verkooppartner-testomgeving](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md#the-selling-partner-api-sandbox) in de Ontwikkelaarsgids voor API Verkoper.

## Stap 6. Publiceer je hybride Verkooppartner-applicatie in de Marketplace Appstore.

1. Meld je aan bij Seller Central met de aanmeldgegevens die je hebt gebruikt om je als ontwikkelaar te registreren.

1. Klik in het menu **Apps en services** op **Apps ontwikkelen**.

   De pagina **Developer Central** verschijnt.

1. Klik naast je applicatie in het menu **App bewerken** op de pijl en klik vervolgens op **Productvermelding bewerken**.

1. Volg de workflow.

Nadat je het laatste scherm hebt voltooid, wordt je hybride Verkooppartner-applicatie gepubliceerd in de Marketplace Appstore. Dit proces kan 5 tot 10 werkdagen in beslag nemen.

## Stap 7. Je Amazon MWS-autorisaties migreren naar API Verkooppartner-autorisaties

Migreer je bestaande Amazon MWS-autorisaties naar API Verkooppartner-autorisaties. Zie voor meer informatie de [Gids voor gebruiksscenario‘s van de Autorisatie-API](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/use-case-guides/authorization-api-use-case-guide/authorization-api-use-case-guide-v1.md).

## Stap 8. Je Amazon MWS-oproepen migreren naar API Verkooppartner-oproepen

De laatste stap is het bijwerken van je applicatie zodat acties die eerder oproepen naar Amazon MWS-bewerkingen activeerden, nu oproepen naar de bijbehorende API Verkooppartner-bewerkingen in gang zetten. Zie [API‘s van Amazon MWS toewijzen aan de API Verkooppartner](#API's-van-Amazon-MWS-toewijzen-aan-de-API-Verkooppartner) om te zien welke API Verkooppartner-bewerkingen overeenkomen met de huidige Amazon MWS-bewerkingen in je applicatie.

# Rollen in de API Verkooppartner

Een rol is het mechanisme dat door de API Verkooppartner wordt gebruikt om te bepalen of een ontwikkelaar of applicatie toegang heeft tot een bewerking of bron. Als ontwikkelaar moet je een bepaalde rol aanvragen en hiervoor in aanmerking komen, anders heb je geen toegang tot de bewerkingen en bronnen die onder die rol zijn gegroepeerd.

De rollen in de API Verkooppartner zijn specifieker dan de rollen in Amazon MWS. Waar Amazon MWS drie rollen had, heeft de API Verkooppartner er 11. Zie [Rollen in de API Verkooppartner](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/roles/Roles-in-the-Selling-Partner-API.md) voor een gedetailleerde uitleg van rollen in de API Verkooppartner, en een lijst met rollen met de bijbehorende definities.

# Het Restricted Data Token (RDT)

De API Verkooppartner beschermt de Persoonlijk Identificeerbare Informatie (PII) van klanten door een Restricted Data Token (RDT) te vereisen bij oproepen voor bewerkingen waarvoor toegangsbeperkingen gelden (bewerkingen die gegevens retourneren waarvoor toegangsbeperkingen gelden). Zie voor meer informatie over het verkrijgen en gebruiken van RDT‘s de [Gids voor gebruiksscenario‘s van de Tokens-API](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/use-case-guides/tokens-api-use-case-guide/tokens-API-use-case-guide-2021-03-01.md)

# De API Verkooppartner-testomgeving
De API Verkooppartner biedt een testomgeving waarmee je je applicaties kunt testen zonder dat dit van invloed is op de productiegegevens, of gebeurtenissen in het echt worden geactiveerd. Zie voor meer informatie over de [API Verkooppartner-testomgeving](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md#the-selling-partner-api-sandbox) de Ontwikkelaarsgids voor API Verkooppartner.

# Aanvullende bronnen:
* [GitHub-problemen](https://github.com/amzn/selling-partner-api-docs/issues)
* Neem contact op met de ondersteuning voor ontwikkelaars door een [case](https://sellercentral.amazon.com/cu/case-lobby?ref=xx_caseLog_xxxx_helphub&) te openen in Seller Central
* [Ontwikkelaarsgids voor API Verkooppartner](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md)
