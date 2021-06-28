# Guida alla migrazione da Amazon MWS all'API per i partner di vendita

# Panoramica
Questo documento spiega cos'è l'API per i partner di vendita, come si differenzia da Amazon Marketplace Web Service (Amazon MWS) e mostra come convertire la tua applicazione Amazon MWS in un'applicazione dell'API per i partner di vendita.

# Che cos'è l'API per i partner di vendita?
L'API per i partner di vendita è un'API basata su REST che consente ai partner di vendita Amazon di accedere a livello di programmazione ai propri dati relativi a offerte, ordini, pagamenti, report e altro ancora. L'API per i partner di vendita è un'evoluzione di Amazon MWS e include tutte le funzionalità precedentemente disponibili in Amazon MWS. Tutti i miglioramenti futuri saranno disponibili solo per l'API per i partner di vendita.

## Funzionalità dell'API per i partner di vendita
Per ogni API per i partner di vendita è disponibile un modello Swagger, un riferimento API e, in alcuni casi, una guida al caso d'uso. Sono incluse anche le librerie client che consentono di autenticare le chiamate alle API per i partner di vendita.

Alcune delle nuove funzionalità dell'API per i partner di vendita includono:
* API basata su REST con input e output in formato JSON.
* Nuovi endpoint supportati in tutte le aree geografiche.
* Istruzioni dettagliate nella Guida per gli sviluppatori di API per i partner di vendita per la generazione automatica di SDK.
* Una funzionalità sandbox con endpoint sandbox separati per effettuare test con dati fittizi.
* Un piano di utilizzo dinamico che regola automaticamente i limiti delle tariffe per ciascun partner di vendita in base a diversi parametri.
* Le applicazioni dell'API per i partner di vendita sono applicabili in tutte le aree geografiche.
* Supporto per i token di dati soggetti a restrizioni, che aiutano a proteggere i dati personali identificabili (PII) dei clienti.

API per i partner di vendita nuove e aggiornate:
* **API Contenuto A+.** Consente ai partner venditori di creare e modificare contenuti A+.
* **API Autorizzazione.** Scambia un token di autenticazione MWS esistente con un codice di autorizzazione dell'API per i partner di vendita.
* **API Articoli in catalogo.** Fornisce informazioni dettagliate sul catalogo Amazon.
* **API Idoneità spedizione in entrata di Logistica di Amazon.** Controlla l'idoneità dell'ASIN per la partecipazione a Logistica di Amazon per evitare di creare spedizioni in entrata per ASIN non idonei.
* **API Inventario Logistica di Amazon.** Nuova e migliorata API Inventario Logistica di Amazon con nuove funzionalità per i venditori di Logistica di Amazon.
* **API Prodotti piccoli e leggeri di Logistica di Amazon.** Supporta il programma Prodotti piccoli e leggeri di Logistica di Amazon.
* **API Messaggistica.** Consente ai partner di vendita di inviare i tipi di messaggi supportati ai clienti.
* **API Notifiche.** Include nuove notifiche per le modifiche ai contenuti degli articoli con marchio, le modifiche al nome del tipo di prodotto, le modifiche dello stato degli ordini della Rete logistica del venditore e le modifiche delle offerte B2B.
* **API Assegnazione del prezzo.** Ottiene informazioni sull'assegnazione dei prezzi e sulle offerte dei prodotti.
* **API Commissioni sui prodotti.** Ottiene le commissioni stimate per un prodotto.
* **API Vendite.** Genera report sulla cronologia delle vendite.
* **API Servizi.** Consente ai fornitori di servizi di ottenere e modificare i propri ordini di assistenza.
* **API Spedizione.** Fornisce accesso programmatico ai servizi di spedizione di Amazon.
* **API Sollecitazioni.** Consente ai partner di vendita di inviare richieste non critiche ai clienti.
* **API Token.** Fornisce un modo sicuro per accedere ai dati personali identificabili (PII) di un cliente.

## Mappatura delle API da Amazon MWS all'API per i partner di vendita

| Amazon MWS | API per i partner di vendita |
| ----------------------------------------- | ----------------------------------- |
| Sezione API Feed | API Feed |
| Sezione API Pagamenti | API Pagamenti |
| Sezione API Spedizione in entrata di gestione logistica | API Spedizione in entrata di gestione logistica |
| Sezione API Inventario di gestione logistica | API inventario di Logistica di Amazon |
| Sezione API Spedizione in uscita di gestione logistica | API Spedizione in uscita di gestione logistica |
| Sezione API Gestito dal venditore | API Gestito dal venditore |
| Sezione API Ordini | API Ordini |
| Sezione API Prodotti - Commissioni prodotti | API Commissioni prodotti |
| Sezione API Prodotti - Offerte dei prodotti | API Articoli in catalogo |
| Sezione API Prodotti - Assegnazione prezzo dei prodotti | API Assegnazione del prezzo |
| Sezione API Raccomandazioni | *Obsoleto nell'API per i partner di vendita* |
| Sezione API Report | API Report |
| Sezione API Venditori | API Venditori |
| Sezione API Sottoscrizioni | API Notifiche |

# Tutorial: Converti un'applicazione Amazon MWS in un'applicazione API per i partner di vendita

Questo tutorial mostra come convertire un'applicazione Amazon MWS in un'applicazione API per i partner di vendita.

**Prerequisiti**

- Hai registrato la tua applicazione Amazon MWS e l'hai pubblicata nell'Appstore del Marketplace.

**Fasi**

## Fase 1. Richiedi l'accesso ai dati richiesto dalla tua applicazione API per i Partner di vendita

1. Accedi a Seller Central con le credenziali associate al tuo account sviluppatore Amazon MWS.

1. Nel menu **App e servizi**, clicca su **Sviluppa app**.

   Visualizzerai la pagina **Developer Central**.

1. Nella pagina **Developer Central**, clicca sul collegamento **Il tuo profilo sviluppatore**.

   Visualizzerai la **pagina del Profilo dello sviluppatore**.

1. Nella sezione **Accesso ai dati** del modulo, seleziona i ruoli richiesti dalle applicazioni e invia il modulo.

Apriremo un ticket di contatto per tenere traccia di questa richiesta. Ti contatteremo dopo aver valutato la tua richiesta e ciò potrebbe richiedere diversi giorni.

## Fase 2. Crea e configura un ARN IAM
Segui i passaggi descritti in [Creazione e configurazione di criteri ed entità IAM](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md#Creazione-e-configurazione-di-criteri-ed-entità-IAM) nella Guida per gli sviluppatori di API per i partner di vendita per creare e configurare un ARN IAM da utilizzare nel passaggio seguente.

## Fase 3. Converti la tua applicazione Amazon MWS in un'applicazione ibrida API per i partner di vendita

1. Accedi a Seller Central utilizzando le credenziali utilizzate per registrarti come sviluppatore.

1. Nel menu **App e servizi**, clicca su **Sviluppa app**.

   Visualizzerai la pagina **Developer Central**.

1. Accanto all'applicazione Amazon MWS, nel menu **Modifica app** clicca su **Modifica app**.

1. Segui le istruzioni per registrare la tua applicazione. Nella casella **ARN IAM**, utilizza l'ARN IAM dalla [Fase 2. Crea e configura un ARN IAM](#fase-2-crea-e-configura-un-arn-iam).

Una volta completato il modulo, avrai un'applicazione ibrida API per i partner di vendita in stato di Bozza. Ora puoi impostare e testare un flusso di lavoro di autorizzazione nella fase seguente.

## Fase 4. Implementa un workflow di autorizzazione

Configura e testa un flusso di lavoro di autorizzazione per l'applicazione ibrida API dei partner di vendita. Per ulteriori informazioni, consulta [Autorizzare le applicazioni API per i partner di vendita](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md#autorizzare-le-applicazioni-api-per-i-partner-di-vendita) nella Guida per gli sviluppatori di API per i partner di vendita. Una volta terminato il test del flusso di lavoro di autorizzazione, assicurati di convertire il flusso di lavoro di autorizzazione di test in un flusso di lavoro di autorizzazione di produzione.

## Fase 5. Connettiti all'API per i partner di vendita

Imposta un flusso di lavoro per le operazioni di chiamata nell'API per i partner di vendita. Ciò include lo scambio di token LWA, la costruzione di URI, l'aggiunta di intestazioni e la creazione e la firma di richieste. Il modo più semplice per farlo è generare e utilizzare un SDK che include lo scambio di token LWA e l'autenticazione. Per ulteriori informazioni, consulta [Generazione di un SDK Java con scambio e autenticazione di token LWA](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md#generazione-di-un-sdk-java-con-scambio-e-autenticazione-di-token-lwa) e [Connessione all'API dei partner di vendita utilizzando un SDK Java generato](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md#connessione-all-api-dei-partner-di-vendita-utilizzando-un-sdk-java-generato) nella Guida per gli sviluppatori di API per i partner di vendita.

Per informazioni sulla connessione alla sandbox dell'API per i partner di vendita, consulta [La sandbox dell'API per i partner di vendita](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md#la-sandbox-dell-api-per-i-partner-di-vendita) nella Guida per gli sviluppatori di API per i partner di vendita.

## Fase 6. Pubblica la tua applicazione ibrida per partner di vendita nell'Appstore del Marketplace

1. Accedi a Seller Central utilizzando le credenziali utilizzate per registrarti come sviluppatore.

1. Nel menu **App e servizi**, clicca su **Sviluppa app**.

   Visualizzerai la pagina **Developer Central**.

1. Accanto alla tua applicazione, nel menu **Modifica app**, clicca sulla freccia e quindi su **Modifica offerta**.

1. Procedi con tutto il flusso di lavoro.

Dopo aver completato la schermata finale, l'applicazione ibrida del partner di vendita verrà pubblicata nell'Appstore del Marketplace. Questo processo può richiedere da 5 a 10 giorni lavorativi.

## Fase 7. Esegui la migrazione delle autorizzazioni di Amazon MWS alle autorizzazioni dell'API per i partner di vendita

Esegui la migrazione delle autorizzazioni Amazon MWS esistenti alle autorizzazioni dell'API per i partner di vendita. Per ulteriori informazioni, consulta la [Guida ai casi d'uso dell'API Autorizzazione](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-us/use-case-guides/authorization-api-use-case-guide/authorization-api-use-case-guide-v1.md).

## Fase 8. Esegui la migrazione delle chiamate Amazon MWS alle chiamate dell'API per i partner di vendita

La fase finale consiste nell'aggiornare la tua applicazione in modo che le azioni che in precedenza attivavano le chiamate alle operazioni di Amazon MWS attivino ora le chiamate alle operazioni corrispondenti dell'API per i partner di vendita. Consulta la [Mappatura delle API da Amazon MWS all'API per i partner di vendita](#mappatura-delle-api-da-amazon-mws-allapi-per-i-partner-di-vendita) per vedere quali operazioni dell'API per i partner di vendita corrispondono alle operazioni di Amazon MWS chiamate dalla tua applicazione.

# Ruoli dell'API per i partner di vendita

Un ruolo è il meccanismo utilizzato dall'API per i partner di vendita per determinare se uno sviluppatore o un'applicazione ha accesso a un'operazione o a una risorsa. In qualità di sviluppatore, devi richiedere e qualificarti per un ruolo particolare altrimenti non ti sarà possibile accedere alle operazioni e alle risorse contenute in tale ruolo.

I ruoli dell'API per i partner di vendita sono più specifici rispetto ai ruoli di Amazon MWS. Mentre Amazon MWS aveva tre ruoli, l'API per i partner di vendita ne ha 11. Consulta i [Ruoli dell'API per i partner di vendita](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/roles/Roles-in-the-Selling-Partner-API.md) per una spiegazione dettagliata dei ruoli dell'API per i partner di vendita e un elenco dei ruoli con le relative definizioni.

# Il token di dati soggetti a restrizioni

L'API per i partner di vendita protegge i dati personali identificabili (PII) dei clienti richiedendo un token di dati soggetti a restrizioni (RDT) con chiamate a operazioni soggette a restrizioni (operazioni che restituiscono dati soggetti a restrizioni). Per informazioni su come ottenere e utilizzare RDT per chiamare le operazioni soggette a restrizioni, consulta la [Guida al caso d'uso dell'API Token](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/use-case-guides/tokens-api-use-case-guide/tokens-API-use-case-guide-2021-03-01.md)

# La sandbox dell'API per i partner di vendita
L'API per i partner di vendita fornisce un ambiente sandbox che consente di testare le applicazioni senza influire sui dati di produzione o attivare eventi reali. Per ulteriori informazioni, consulta [Sandbox API per i partner di vendita](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md#sandbox-api-per-i-partner-di-vendita) nella Guida per gli sviluppatori di API per i partner di vendita.

# Risorse aggiuntive.
* [Problemi di GitHub](https://github.com/amzn/selling-partner-api-docs/issues)
* Contatta il supporto aprendo un [caso](https://sellercentral.amazon.com/cu/case-lobby?ref=xx_caseLog_xxxx_helphub&) in Seller Central
* [Guida per gli sviluppatori di API per i partner di vendita](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md)
