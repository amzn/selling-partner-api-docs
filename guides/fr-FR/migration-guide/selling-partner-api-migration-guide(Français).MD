# Guide de migration d'Amazon MWS vers l'API partenaire de vente

# Présentation
Ce document explique ce qu'est l'API partenaire de vente, en quoi elle diffère d'Amazon Marketplace Web Service (Amazon MWS) et comment convertir votre application Amazon MWS en application API partenaire de vente.

# Qu'est-ce que l'API partenaire de vente ?
L'API partenaire de vente est une API REST qui aide les partenaires de vente Amazon à accéder à leurs données sur les offres, les commandes, les paiements, les rapports et plus encore par programmation. L'API partenaire de vente est une modernisation d'Amazon MWS et inclut toutes les fonctionnalités précédemment disponibles sur Amazon MWS. Les prochains développements ne seront disponibles que pour l'API partenaire de vente.

## Fonctionnalités de l'API partenaire de vente
Pour chaque API partenaire de vente, il existe un modèle de spécification Swagger, une référence de l'API et, dans certains cas, un guide de cas d'utilisation. Des bibliothèques client sont également incluses pour vous aider à authentifier les appels à destination des API partenaire de vente.

Voici quelques-unes des nouvelles fonctionnalités de l'API partenaire de vente :
* Une API REST avec entrée et sortie au format JSON.
* De nouveaux points de terminaison pris en charge dans toutes les régions.
* Des instructions détaillées dans le Guide du développeur d'API partenaire de vente pour la génération automatisée du SDK.
* Une fonction d'environnement de test avec des points de terminaison d'environnement différents pour effectuer des tests avec des données fictives.
* Un plan d'utilisation dynamique qui ajuste automatiquement les taux limites pour chaque partenaire de vente en fonction de différentes mesures.
* Les applications API partenaire de vente sont applicables dans toutes les régions.
* Prise en charge des jetons de données restreintes, qui aident à protéger les informations personnelles identifiables (PII) des clients.

Nouvelles API partenaire de vente mises à jour :
* **API Contenu A+.** Permet aux partenaires de vente de créer et de modifier du contenu A+.
* **API Autorisation.** Échange un jeton d'authentification MWS existant contre un code d'autorisation API partenaire de vente.
* **API Articles du catalogue.** Fournit des informations détaillées sur le catalogue Amazon.
* **API Éligibilité des entrants Expédié par Amazon.** Vérifie l'éligibilité de l'ASIN pour la participation au service Expédié par Amazon pour éviter de créer des expéditions entrantes pour les ASIN non éligibles.
* **API Stock Expédié par Amazon.** Nouvelle API de stock Expédié par Amazon améliorée avec de nouvelles fonctionnalités pour les vendeurs Expédié par Amazon.
* **API Produits petits et légers Expédié par Amazon.** Prend en charge le programme Produits petits et légers Expédié par Amazon.
* **API Messagerie.** Permet aux partenaires de vente d'envoyer des types de messages pris en charge aux clients.
* **API Notifications.** Inclut de nouvelles notifications pour les changements de contenu d'article de marque, de nom de type de produit, de statut des commandes Expédié par le Vendeur et d'offre B2B.
* **API Tarification.** Fournit la tarification des produits et des informations sur l'offre.
* **API Frais de produit.** Fournit les frais estimés pour un produit.
* **API Ventes.** Génère des rapports d'historique des ventes
* **API de services. ** Permet aux fournisseurs de services d'obtenir et de modifier leurs commandes de service.
* **API Expédition.** Fournit un accès programmatique aux services d'expédition d'Amazon.
* **API Sollicitations.** Permet aux partenaires de vente d'envoyer des sollicitations non essentielles aux clients.
* **API Jetons.** Fournit un moyen sécurisé d'accéder aux informations personnelles identifiables (IPI) d'un client.

## Mappage des API d'Amazon MWS vers l'API partenaire de vente

| Amazon MWS | API partenaire de vente |
| ----------------------------------------- | ----------------------------------- |
| Section API Flux | API Flux |
| Section API Paiements | API Paiements |
| Section API Traitement d'expéditions entrantes | API Traitement des entrants |
| Section API Stock expédié | API Stock Expédié par Amazon |
| Section API Traitement d'expéditions sortantes | API Traitement des sortants |
| Section API Merchant Fulfillment | API Merchant Fulfillment |
| Section API Commandes | API Commandes |
| Section API Produits - Frais de produit | API Frais de produit |
| Section API Produits - Offres de produits | API Articles du catalogue. |
| Section API Produits - Tarification des produits | API Tarification |
| Section API Recommandations | *Rendue obsolète dans l'API partenaire de vente* |
| Section API Rapports | API Rapports |
| Section API Vendeurs | API Vendeurs |
| Section API d’abonnement | API Notifications |

# Tutoriel : convertir une application Amazon MWS en application API partenaire de vente

Ce tutoriel vous explique comment convertir une application Amazon MWS en application API partenaire de vente.

**Conditions préalables**

- Vous avez enregistré votre application Amazon MWS et l'avez publiée dans l'App-Shop Marketplace.

**Étapes**

## Étape 1. Demandez l'accès aux données requises par votre application API partenaire de vente

1. Connectez-vous à Seller Central avec les informations d'identification associées à votre compte de développeur Amazon MWS.

1. Dans le menu **Applications et services**, cliquez sur **Développer des applications**.

   La page **Developer Central** s'affiche.

1. Sur la page **Developer Central**, cliquez sur le lien **Votre profil de développeur**.

   La page **Profil de développeur** s'affiche.

1. Dans la section **Accès aux données** du formulaire, sélectionnez les rôles dont vos applications ont besoin et envoyez le formulaire.

Nous ouvrirons un ticket Contactez-nous pour vous permettre de suivre cette demande. Nous vous contacterons après avoir évalué votre demande ; cela peut prendre plusieurs jours.

## Étape 2. Créez et configurez un ARN IAM
Suivez les étapes de la section [Création et configuration de politiques et d'entités IAM](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md#Creating-and-configuring-IAM-policies-and-entities) du Guide du développeur d'API partenaire de vente pour créer et configurer un ARN IAM à utiliser à l'étape suivante.

## Étape 3. Convertissez votre application Amazon MWS en application API partenaire de vente hybride

1. Connectez-vous à Seller Central à l'aide des informations d'identification que vous avez utilisées pour vous inscrire en tant que développeur.

1. Dans le menu **Applications et services**, cliquez sur **Développer des applications**.

   La page **Developer Central** s'affiche.

1. Cliquez sur **Modifier l'application** à côté de votre application Amazon MWS, dans le menu **Modifier l'application**,

1. Suivez les instructions pour enregistrer votre application. Dans la zone **ARN IAM**, utilisez l'ARN IAM de l'[étape 2. Créez et configurez un ARN IAM](#Étape-2-Créez-et-configurez-un-ARN-IAM).

Lorsque vous remplissez le formulaire, une application API partenaire de vente hybride est générée avec le statut Brouillon. Vous êtes maintenant prêt à configurer et tester un processus d'autorisation à l'étape suivante.

## Étape 4. Mettez en place un processus d'autorisation

Configurez et testez un processus d'autorisation pour votre application API partenaire de vente hybride. Pour plus d'informations, consultez la section [Autorisation des applications API partenaire de vente](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md#authorizing-selling-partner-api-applications) dans le Guide du développeur d'API partenaire de vente. Lorsque vous avez terminé de tester votre processus, assurez-vous de convertir votre processus d'autorisation de test en processus d'autorisation de production.

## Étape 5. Connectez-vous à l'API partenaire de vente

Configurez un processus pour appeler les opérations dans l'API partenaire de vente. Cela inclut l'échange de jetons LWA, la construction d'URI, l'ajout d'en-têtes ainsi que la création et la signature de demandes. La façon la plus simple de le faire est de générer et d'utiliser un SDK qui inclut l'échange de jetons LWA et l'authentification. Pour plus d'informations, consultez les sections [Génératione d'un SDK Java avec échange de jetons LWA et authentification](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md#generating-a-java-sdk-with-lwa-token-exchange-and-authentication) et [Connexion à l'API partenaire de vente à l'aide d'un SDK Java généré](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md#connecting-to-the-selling-partner-api-using-a-generated-java-sdk) dans le Guide du développeur d'API partenaire de vente.

Pour plus d'informations sur la connexion à l'environnement de test API partenaire de vente, consultez la section [Environnement de test de l'API partenaire de vente](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md#the-selling-partner-api-sandbox) dans le Guide du développeur d'API partenaire de vente.

## Étape 6. Publiez votre application partenaire de vente hybride dans l'App-Shop Marketplace

1. Connectez-vous à Seller Central à l'aide des informations d'identification que vous avez utilisées pour vous inscrire en tant que développeur.

1. Dans le menu **Applications et services**, cliquez sur **Développer des applications**.

   La page **Developer Central** s'affiche.

1. Cliquez sur la flèche à côté de votre application, dans le menu **Modifier l'application**, puis sur **Modifier l'offre**.

1. Suivez le processus.

Après avoir atteint l'écran final, votre application partenaire de vente hybride sera publiée sur l'App-Shop Marketplace. Ce processus peut prendre 5 à 10 jours ouvrables.

## Étape 7. Migrez les autorisations Amazon MWS vers les autorisations API partenaire de vente

Migrez vos autorisations Amazon MWS existantes vers les autorisations API partenaire de vente Pour plus d'informations, consultez le [Guide de cas d'utilisation de l'API Autorisation](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/use-case-guides/authorization-api-use-case-guide/authorization-api-use-case-guide-v1.md).

## Étape 8. Migrez vos appels Amazon MWS vers les appels API partenaire de vente

La dernière étape consiste à mettre à jour votre application afin que les actions qui déclenchaient précédemment des appels à destination des opérations Amazon MWS déclenchent désormais les appels à destination des opérations d'API partenaire de vente correspondantes. Reportez-vous à la section [Mappage des API d'Amazon MWS vers l'API partenaire de vente](#Mappage-des-API-d'Amazon-MWS-vers-l'API-partenaire-de-vente) pour savoir quelles opérations d'API partenaire de vente correspondent aux opérations Amazon MWS que votre application a appelées.

# Rôles dans l'API partenaire de vente

Un rôle est le mécanisme utilisé par l'API partenaire de vente pour déterminer si un développeur ou une application a accès à une opération ou à une ressource. En tant que développeur, vous devez faire la demande et être qualifié pour un rôle particulier, ou vous ne pourrez pas accéder aux opérations et aux ressources regroupées sous ce rôle.

Les rôles dans l'API partenaire de vente sont plus précis que les rôles dans Amazon MWS. Amazon MWS disposait de trois rôles, tandis que l'API partenaire de vente en a 11. Pour obtenir une explication détaillée des rôles dans l'API partenaire de vente, ainsi qu'une liste de ces derniers et leurs définitions, consultez la section [Rôles dans l'API partenaire de vente](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/roles/Roles-in-the-Selling-Partner-API.md).

# Le jeton de données restreintes

L'API partenaire de vente protège les informations personnelles identifiables (PII) des clients en exigeant un jeton de données restreintes (RDT) avec des appels à destination des opérations restreintes (opérations qui renvoient des données restreintes). Pour plus d'informations sur l'obtention et l'utilisation des RDT afin d'appeler des opérations restreintes, consultez le [Guide des cas d'utilisation de l'API Jetons](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/use-case-guides/tokens-api-use-case-guide/tokens-API-use-case-guide-2021-03-01.md)

# L'environnement de test de l'API partenaire de vente
L'API partenaire de vente fournit un environnement de test qui vous permet de tester vos applications sans affecter les données de production ni déclencher des événements réels. Pour plus d'informations, consultez la section [Environnement de test d'API partenaire de vente](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md#the-selling-partner-api-sandbox) dans le Guide du développeur d'API partenaire de vente.

# Ressources supplémentaires
* [Problèmes GitHub](https://github.com/amzn/selling-partner-api-docs/issues)
* Contactez l'assistance en ouvrant un [dossier](https://sellercentral.amazon.com/cu/case-lobby?ref=xx_caseLog_xxxx_helphub&) dans Seller Central
* [Guide du développeur d'API partenaire de vente](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md)
