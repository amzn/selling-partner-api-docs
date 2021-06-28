# Leitfaden für die Migration von Amazon MWS zur Verkaufspartner-API

# Übersicht
In diesem Dokument wird erläutert, was die Verkaufspartner-API ist und wie sie sich von Amazon Marketplace Web Service (MWS) unterscheidet. Außerdem wird erläutert, wie Sie eine Amazon MWS-Anwendung in eine Verkaufspartner-API-Anwendung konvertieren.

# Was ist die Verkaufspartner-API?
Die Verkaufspartner-API ist eine REST-basierte API, mit der Verkaufspartner bei Amazon programmgesteuert auf ihre Daten zu Angeboten, Bestellungen, Zahlungen, Berichten und mehr zugreifen können. Die Verkaufspartner-API ist eine Modernisierung von Amazon MWS und umfasst alle Funktionen, die zuvor bei Amazon MWS verfügbar waren. Alle zukünftigen Entwicklungen sind nur für die Verkaufspartner-API verfügbar.

## Verkaufspartner-API – Funktionen
Für jede Verkaufspartner-API gibt es ein Swagger-Modell, eine API-Referenz und in einigen Fällen einen Use-Case-Leitfaden. Ebenfalls enthalten sind Client-Bibliotheken, die zur Authentifizierung von Aufrufen an Verkaufspartner-APIs beitragen.

Einige der neuen Funktionen der Verkaufspartner-API umfassen:
* REST-basiert mit JSON-formatierter Eingabe und Ausgabe.
* Neue Endpunkte, die in allen Regionen unterstützt werden.
* Schritt-für-Schritt-Anleitung im Verkaufspartner-API Entwicklerhandbuch zur automatisierten SDK-Generierung.
* Eine Sandbox-Funktion mit separaten Sandbox-Endpunkten zum Testen mit Mock-Daten.
* Ein dynamischer Nutzungsplan, der die Zinsgrenzen für jeden Vertriebspartner automatisch anhand einer Vielzahl von Maßnahmen anpasst.
* Anwendungen der Verkaufspartner-API sind in allen Regionen anwendbar.
* Unterstützung für eingeschränkte Datentokens, die zum Schutz von personenbezogenen Daten der Kunden beitragen.

Neue und aktualisierte Verkaufspartner-APIs:
* **A+ Content-API.** Ermöglicht es Vertriebspartnern, A+-Inhalte zu erstellen und zu bearbeiten.
* **Autorisierungs-API.** Tauscht einen bestehenden MWS-Auth Token mit einem Autorisierungscode der Verkaufspartner-API aus.
* **API für Katalogelemente.** Bietet detaillierte Informationen über den Amazon-Katalog.
* **API für eingehende Berechtigung für Versand durch Amazon.** Überprüft die Berechtigung von ASINs auf Teilnahme bei Versand durch Amazon. So wird vermieden, dass eingehende Sendungen für nicht berechtigte ASINs erstellt werden.
* **API für Lagerbestand mit Versand durch Amazon.** Neue und verbesserte API für Lagerbestand mit Versand durch Amazon mit neuen Funktionen für "Versand durch Amazon"-Verkäufer.
* **API für Small and Light mit Versand durch Amazon.** Unterstützt das Programm Small and Light mit Versand durch Amazon.
* **Messaging-API.** Ermöglicht es Verkaufspartnern unterstützte Nachrichtentypen an Kunden zu senden.
* **Benachrichtigungs-API.** Enthält neue Benachrichtigungen für Änderungen des Markenartikelinhalts, Änderungen des Produkttypnamens, Änderungen des Bestellstatus bei Versand durch Händler und Änderungen des B2B-Angebots.
* **Preisgestaltungs-API.**Ruft Produktpreise und Angebotsinformationen ab.
* **Produktgebühren-API.** Ruft geschätzte Gebühren für ein Produkt ab.
* **Vertriebs-API.** Erstellen Sie Berichte zur Verkaufshistorie.
* ** Services-API. ** Ermöglicht es Dienstleistern, ihre Serviceaufträge abzurufen und zu ändern.
* **Versand-API.** Bietet programmatischen Zugang zu den Versandservices von Amazon.
* **Anforderungs-API.** Ermöglicht es Verkaufspartnern, unkritische Anforderungen an Kunden zu senden.
* **Token-API.** Bietet eine sichere Möglichkeit, auf die personenbezogenen Daten eines Kunden zuzugreifen.

## APIs von Amazon MWS der Verkaufspartner-API zuordnen

| Amazon MWS | Verkaufspartner-API |
| ----------------------------------------- | ----------------------------------- |
| API-Abschnitt "Feeds" | Feeds-API |
| API-Abschnitt "Finanzen" | Finanz-API |
| API-Abschnitt "Sendungen an Amazon" | API für den Versandeingang |
| API-Abschnitt "Lagerbestand in Logistikzentren" | API für Lagerbestand mit Versand durch Amazon |
| API-Abschnitt "Sendungen an Käufer" | API für ausgehende Sendungen |
| API-Abschnitt "Versand durch Händler" | "Versand durch Händler"-API |
| API-Abschnitt "Bestellungen" | Bestellungs-API |
| API-Abschnitt "Produkte" – Produktgebühren | Produktgebühren-API |
| API-Abschnitt "Produkte" – Produktangebotserstellung | Katalogartikel-API |
| API-Abschnitt "Produkte" – Produktpreise | Preisgestaltungs-API |
| API-Abschnitt "Empfehlungen" | *Veraltete Funktionen der Verkaufspartner-API* |
| API-Abschnitt "Berichte" | Berichte-API |
| API-Abschnitt "Verkäufer" | Verkäufer-API |
| API-Abschnitt "Benachrichtigungen" | Benachrichtigungs-API |

# Anleitung: Amazon MWS-Anwendung in eine Verkaufspartner-API-Anwendung konvertieren

Dieses Tutorial zeigt Ihnen, wie Sie eine Amazon MWS-Anwendung in eine Verkaufspartner-API-Anwendung konvertieren.

**Voraussetzungen**

- Sie haben Ihre Amazon MWS-Anwendung registriert und im Marketplace-Appstore veröffentlicht.

**Schritte**

## Schritt 1: Fordern Sie den Datenzugriff an, den Ihre Verkaufspartner-API-Anwendung benötigt

1. Melden Sie sich bei Seller Central mit den Zugangsdaten an, die Ihrem Amazon MWS-Entwicklerkonto zugeordnet sind.

1. Klicken Sie im Menü **Apps & Services** auf **Apps entwickeln**.

   Die Seite **Developer Central** wird angezeigt.

1. Klicken Sie auf der Seite **Developer Central** auf den Link zu **Ihrem Entwicklerprofil**.

   Die Seite **Entwicklerprofil** wird angezeigt.

1. Wählen Sie im Abschnitt **Datenzugriff** des Formulars die Rollen aus, die Ihre Anwendungen benötigen, und senden Sie das Formular ab.

Wir öffnen ein "Kontaktieren Sie uns"-Ticket, mit dem Sie diese Anfrage verfolgen können. Wir werden uns mit Ihnen in Verbindung setzen, nachdem wir Ihre Anfrage bearbeitet haben. Dies kann einige Tage dauern.

## Schritt 2: Erstellen und konfigurieren Sie eine IAM-ARN
Befolgen Sie die Schritte unter [IAM-Richtlinien und Entitäten erstellen und konfigurieren](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md#IAM-Richtlinien-und-Entitäten-erstellen-und-konfigurieren) im Verkaufspartner-API Entwicklerhandbuch, um eine IAM-ARN zur Verwendung im folgenden Schritt zu erstellen und zu konfigurieren.

## Schritt 3: Konvertieren Sie Ihre Amazon MWS-Anwendung in eine hybride Verkaufspartner-API-Anwendung

1. Melden Sie sich bei Seller Central mit den Zugangsdaten an, die Sie zur Registrierung als Entwickler verwendet haben.

1. Klicken Sie im Menü **Apps & Services** auf **Apps entwickeln**.

   Die Seite **Developer Central** wird angezeigt.

1. Klicken Sie neben Ihrer Amazon MWS-App im Menü **App bearbeiten** auf **App bearbeiten**.

1. Folgen Sie den Anweisungen, um Ihre App zu registrieren. Verwenden Sie im Feld **IAM-ARN** die IAM-ARN aus [Schritt 2. Erstellen und konfigurieren Sie eine IAM-ARN](#Step-2-Create-and-configure-an-IAM-ARN).

Wenn Sie das Formular ausfüllen, haben Sie eine hybride Verkaufspartner-API-Anwendung im Entwurfstatus. Sie sind jetzt bereit, im folgenden Schritt einen Autorisierungs-Workflow einzurichten und zu testen.

## Schritt 4: Implementieren Sie einen Autorisierungs-Workflow

Richten Sie einen Autorisierungs-Workflow für Ihre hybride Verkaufspartner-API-Anwendung ein und testen Sie diesen. Weitere Informationen finden Sie unter [Verkaufspartner-API-App autorisieren](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md#Verkaufspartner-API-App-autorisieren) im Verkaufspartner-API Entwicklerhandbuch. Wenn Sie mit dem Testen Ihres Autorisierungs-Workflows fertig sind, stellen Sie sicher, dass Sie Ihren Testautorisierungs-Workflow in einen Workflow für die Produktionsautorisierung konvertieren.

## Schritt 5: Stellen Sie eine Verbindung zur Verkaufspartner-API her

Richten Sie einen Workflow für Aufrufvorgänge in der Verkaufspartner-API ein. Dies umfasst den Austausch von LWA-Token, das Erstellen von URIs, das Hinzufügen von Headern und das Erstellen und Signieren von Anfragen. Am einfachsten ist es, ein SDK zu generieren und zu verwenden, das den Austausch und die Authentifizierung von LWA-Token umfasst. Weitere Informationen finden Sie unter [Java-SDK mit LWA-Token-Austausch und Authentifizierung generieren](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md#Java-SDK-mit-LWA-Token-Austausch-und-Authentifizierung-generieren) und [Eine Verbindung mit der Verkaufspartner-API mithilfe eines generierten Java-SDK herstellen](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md#Eine-Verbindung-mit-der-Verkaufspartner-API-mithilfe-eines-generierten-Java-SDK-herstellen) im Verkaufspartner-API Entwicklerhandbuch.

Informationen zum Herstellen einer Verbindung mit der Verkaufspartner-API-Sandbox finden Sie in [Die Verkaufspartner-API-Sandbox](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md#Die-Verkaufspartner-API-Sandbox) im Verkaufspartner-API Entwicklerhandbuch.

## Schritt 6. Veröffentlichen Sie Ihre hybride Verkaufspartner-Anwendung im Marketplace Appstore

1. Melden Sie sich bei Seller Central mit den Zugangsdaten an, die Sie zur Registrierung als Entwickler verwendet haben.

1. Klicken Sie im Menü **Apps & Services** auf **Apps entwickeln**.

   Die Seite **Developer Central** wird angezeigt.

1. Klicken Sie neben Ihrer Anwendung im Menü **App bearbeiten** auf den Pfeil und dann auf **Angebot bearbeiten**.

1. Fahren Sie mit dem Workflow fort.

Nach Abschluss des letzten Bildschirms wird Ihre hybride Verkaufspartner-Anwendung im Marketplace Appstore veröffentlicht. Dieser Prozess kann zwischen 5 und 10 Werktage in Anspruch nehmen.

## Schritt 7: Migrieren Sie Amazon MWS-Autorisierungen zu Verkaufspartner-API-Autorisierungen

Migrieren Sie Ihre bestehenden Amazon MWS-Autorisierungen zu Verkaufspartner-API-Autorisierungen Weitere Informationen finden Sie im [Use-Case-Leitfaden zur Autorisierungs-API](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/use-case-guides/authorization-api-use-case-guide/authorization-api-use-case-guide-v1.md).

## Schritt 8: Migrieren Sie Ihre Amazon MWS-Aufrufe zu Verkaufspartner-API-Aufrufen

Der letzte Schritt besteht darin, Ihre Anwendung so zu aktualisieren, dass Aktionen, die zuvor Aufrufe von Amazon MWS-Vorgängen ausgelöst haben, nun Aufrufe der entsprechenden Verkaufspartner-API-Vorgänge auslösen. Unter [APIs von Amazon MWS der Verkaufspartner-API zuordnen](#APIs-von-Amazon-MWS-der-Verkaufspartner-API-zuordnen), finden Sie Informationen dazu, welche Verkaufspartner-API-Vorgänge den Amazon MWS-Vorgängen entsprechen, die Ihre Anwendung aufgerufen hat.

# Rollen in der Verkaufspartner-API

Eine Rolle ist der Mechanismus, der von der Verkaufspartner-API verwendet wird, um zu bestimmen, ob ein Entwickler oder eine Anwendung Zugriff auf einen Vorgang oder eine Ressource hat. Als Entwickler müssen Sie eine bestimmte Rolle beantragen und sich dafür qualifizieren, sonst können Sie nicht auf die unter dieser Rolle gruppierten Vorgänge und Ressourcen zugreifen.

Die Rollen in der Verkaufspartner-API sind differenzierter als die Rollen in Amazon MWS. Während Amazon MWS drei Rollen hatte, hat die Verkaufspartner-API 11. Unter [Rollen in der Verkaufspartner-API](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/roles/Roles-in-the-Selling-Partner-API.md) finden Sie eine ausführliche Erklärung der Rollen in der Vertriebspartner-API sowie eine Liste der Rollen und ihrer Definitionen.

# Der eingeschränkte Datentoken

Die Verkaufspartner-API schützt die personenbezogenen Daten der Kunden, indem sie bei Aufrufen von eingeschränkten Vorgängen (Vorgänge, die eingeschränkte Daten zurückgeben) einen eingeschränkten Datentoken verlangt. Weitere Informationen zum Abrufen und Verwenden von RDTs zum Aufrufen eingeschränkter Vorgänge finden Sie im [Use-Case-Leitfaden zur Token-API](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/use-case-guides/tokens-api-use-case-guide/tokens-API-use-case-guide-2021-03-01.md)

# Die Verkaufspartner-API-Sandbox
Die Verkaufspartner-API bietet eine Sandbox-Umgebung, mit der Sie Ihre Apps testen können, ohne die Produktionsdaten zu beeinträchtigen oder reale Ereignisse auszulösen. Weitere Informationen finden Sie unter [Die Verkaufspartner-API-Sandbox](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md#Die-Verkaufspartner-API-Sandbox) im Verkaufspartner-API Entwicklerhandbuch.

# Weitere Ressourcen
* [GitHub-Probleme](https://github.com/amzn/selling-partner-api-docs/issues)
* Kontaktieren Sie den Support, indem Sie einen [Fall](https://sellercentral.amazon.com/cu/case-lobby?ref=xx_caseLog_xxxx_helphub&) in Seller Central öffnen
* [Verkaufspartner-API Entwicklerhandbuch](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md)
