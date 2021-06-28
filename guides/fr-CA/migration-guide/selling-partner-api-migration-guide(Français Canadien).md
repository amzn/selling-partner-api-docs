# Guide de migration de l’API Amazon MWS vers partenaire de vente

# Vue d’ensemble
Ce document explique ce qu’est l’API partenaire de vente, en quoi elle diffère d’Amazon Marketplace Web Service (Amazon MWS) et vous montre comment convertir votre application Amazon MWS en application API partenaire de vente.

# Qu’est-ce que l’API partenaire de vente?
L’API partenaire de vente est une API basée sur REST qui aide les partenaires de vente Amazon à accéder par programmation à leurs données sur les offres, les commandes, les paiements, les rapports, etc. L’API partenaire de vente est une modernisation d’Amazon MWS et inclut toutes les fonctionnalités précédemment offertes dans Amazon MWS. Tous les développements futurs ne seront disponibles que pour l’API partenaire de vente.

## Fonctionnalités de l’API partenaire de vente
Pour chaque API partenaire de vente, il existe un modèle Swagger, une référence d’API et, dans certains cas, un guide de cas d’utilisation. Sont également inclus des bibliothèques clientes pour vous aider à authentifier les appels vers les API partenaire de vente.

Voici quelques-unes des nouvelles fonctionnalités de l’API partenaire de vente :
* Interface basée sur REST avec données entrantes et sortantes au format JSON.
* Nouveaux terminaux pris en charge dans toutes les régions.
* Instructions étape par étape dans le Guide du développeur de l’API partenaire de vente pour la génération SDK automatisée.
* Fonctionnalité de bac à sable avec des terminaux distincts pour les tests à partir de données simulées.
* Plan d’utilisation dynamique qui ajuste automatiquement les limites tarifaires pour chaque partenaire de vente en fonction d’une variété de mesures.
* Les applications API partenaire de vente sont utilisables dans toutes les régions.
* Prise en charge des jetons de données restreintes, qui aident à protéger les informations d’identification personnelle (PII).

API partenaire de vente nouvelles et améliorées :
* **API de contenu A+.** Permet aux partenaires de vente de créer et de modifier du contenu A+.
* **API d’autorisation.** Échange un jeton d’authentification MWS existant avec un code d’autorisation d’API partenaire de vente.
* **API des articles de catalogue.** Fournit des informations détaillées sur le catalogue Amazon.
* **API d’admissibilité des commandes entrantes Expédié par Amazon.** Vérifie l’admissibilité des ASIN pour la participation à Expédié par Amazon afin d’éviter de créer des expéditions entrantes pour des ASIN non admissibles.
* **API de stocks Expédié par Amazon.** API de stocks Expédié par Amazon nouvelle et améliorée avec de nouvelles fonctionnalités pour les vendeurs Expédié par Amazon.
* **API Expédié par Amazon Small and Light.** Prend en charge le programme Small and Light Expédié par Amazon
* **API messagerie.** Permet aux partenaires de vente d’envoyer des messages pris en charge aux clients.
* **API notifications.** Inclut de nouvelles notifications pour les changements de contenu des articles de marque, les changements de nom de type de produit, les changements de statut de commande Expédié par le Vendeur et les changements aux offres de commerce interentreprises.
* **API tarification.** Indique le prix des produits et les informations sur les offres.
* **API frais liés aux produits.** Indique les frais estimés pour un produit.
* **API vente.** Génère les rapports d’historique des ventes.
* **API services. ** Permet aux fournisseurs de services d’obtenir et de modifier leurs commandes de service.
* **API expédition.** Fournit un accès programmatique aux services d’expédition d’Amazon.
* **API sollicitations.** Permet aux partenaires de vente d’envoyer des sollicitations non essentielles aux clients.
* **API jetons.** Fournit un moyen sécurisé d’accéder aux informations d’identification personnelle d’un client.

## Mappage des API d’Amazon MWS vers l’API partenaire de vente

| Amazon MWS | API partenaire de vente |
| ----------------------------------------- | ----------------------------------- |
| Section API flux | API flux |
| Section API finances | API finances |
| Section API Envoyer des produits à Amazon | API expéditions entrantes |
| Section API stock expédié | API stock Expédié par Amazon |
| Section API Traitement d’expéditions sortantes | API expéditions sortantes |
| Section API Merchant Fulfillment | API Merchant Fulfillment |
| Section API commandes | API commandes |
| Section API produits – Frais liés aux produits | API frais liés aux produits |
| Section API produits – Offres de produits | API articles de catalogue |
| Section API produits – Tarification des produits | API tarification |
| Section API recommandations | *Obsolète dans l’API partenaire de vente* |
| Section API rapports | API rapports |
| Section API vendeurs | API vendeurs |
| Section API abonnements | API notifications |

# Tutoriel: Convertir une application Amazon MWS en application API partenaire de vente

Ce tutoriel vous montre comment convertir une application Amazon MWS en application API partenaire de vente.

**Prérequis**

- Vous avez inscrit votre application Amazon MWS et l’avez publiée dans l’Appstore Marketplace.

**Étapes**

## Étape 1. Demander l’accès aux données requis par votre application API partenaire de vente

1. Connectez-vous à Seller Central avec les identifiants associés à votre compte développeur Amazon MWS.

1. Dans le menu **Applications et services**, cliquez sur **Applications pour développeurs**.

   La page **Centrale des développeurs** s’affichera.

1. Sur la page **Centrale des développeurs**, cliquez sur le lien **Votre profil de développeur**.

   La page **Profil de développeur** s’affichera.

1. Dans la section **Accès aux données** du formulaire, sélectionnez les rôles que requièrent vos applications et soumettez le formulaire.

Nous ouvrirons un billet Contactez-nous pour que vous puissiez suivre cette demande. Nous vous contacterons après avoir évalué votre demande; cela peut prendre plusieurs jours.

## Étape 2. Créer et configurer un ARN IAM
Suivez les étapes décrites dans la section [Création et configuration de politiques et d’entités IAM](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md#Creating-and-configuring-IAM-policies-and-entities) du Guide du développeur de l’API partenaire de vente pour créer et configurer un ARN IAM à utiliser à l’étape suivante.

## Étape 3. Convertir votre application Amazon MWS en une application API partenaire de vente hybride

1. Connectez-vous à Seller Central en utilisant les identifiants que vous avez utilisées pour vous inscrire en tant que développeur.

1. Dans le menu **Applications et services**, cliquez sur **Applications pour développeurs**.

   La page **Centrale des développeurs** s’affichera.

1. À côté de votre application Amazon MWS, dans le menu **Modifier l’application**, cliquez sur **Modifier l’application**.

1. Suivez les instructions pour enregistrer votre application. Dans la zone**ARN IAM**, utilisez l’ARN IAM de [l’étape 2. Créer et configurer un ARN IAM](#Step-2-Create-and-configure-an-IAM-ARN).

Lorsque vous remplirez le formulaire, vous verrez une application API partenaire de vente hybride avec le statut Brouillon. Vous êtes maintenant prêt à configurer et à tester le processus d’autorisation à l’étape suivante.

## Étape 4. Mettre en œuvre un processus d’autorisation

Configurez et testez un processus d’autorisation pour votre application API partenaire de vente hybride. Pour plus d’informations, consultez la section [Autoriser des applications API partenaire de vente](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md#authorizing-selling-partner-api-applications) du Guide du développeur API partenaire de vente. Lorsque vous avez terminé de tester votre processus d’autorisation, assurez-vous de le convertir en processus d’autorisation de production.

## Étape 5. Se connecter à l’API partenaire de vente

Configurez un processus pour les opérations d’appel dans l’API partenaire de vente. Cela inclut l’échange de jetons Connectez-vous avec Amazon, l’élaboration d’URI, l’ajout d’en-têtes et la création et la signature de demandes. La façon la plus simple de le faire est de générer et d’utiliser un SDK qui inclut l’échange et l’authentification de jetons Connectez-vous avec Amazon. Pour plus d’informations, consultez la section [Génération d’un SDK Java avec échange et authentification de jetons Connectez-vous avec Amazon](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md#generating-a-java-sdk-with-lwa-token-exchange-and-authentication) et [Connexion à l’API partenaire de vente à partir d’un SDK Java généré](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md#connecting-to-the-selling-partner-api-using-a-generated-java-sdk) du Guide du développeur API partenaire de vente.

Pour plus d’informations sur la connexion au bac à sable API partenaire de vente, consultez la section[Bac à sable API partenaire de vente](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md#the-selling-partner-api-sandbox) du guide du développeur API partenaire de vente.

## Étape 6. Publier votre application de partenaire de vente hybride dans l’Appstore Marketplace

1. Connectez-vous à Seller Central en utilisant les identifiants que vous avez utilisées pour vous inscrire en tant que développeur.

1. Dans le menu **Applications et services**, cliquez sur **Applications pour développeurs**.

   La page **Centrale des développeurs** s’affichera.

1. À côté de votre application, dans le menu **Modifier l’application**, cliquez sur la flèche, puis sur **Modifier la liste**.

1. Suivez le processus.

Après avoir terminé l’écran final, votre application de partenaire de vente hybride sera publiée sur l’Appstore Marketplace. Ce processus peut prendre de 5 à 10 jours ouvrables.

## Étape 7. Migrer les autorisations Amazon MWS vers les autorisations API partenaire de vente

Migrez vos autorisations Amazon MWS existantes vers les autorisations API partenaire de vente. Pour plus d’informations, consultez le [Guide des cas d’utilisation de l’API autorisation](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/use-case-guides/authorization-api-use-case-guide/authorization-api-use-case-guide-v1.md).

## Étape 8. Migrer vos appels Amazon MWS vers les appels API partenaire de vente

La dernière étape consiste à mettre à jour votre application de sorte que les actions qui ont précédemment déclenché des appels vers les opérations Amazon MWS déclenchent désormais des appels vers les opérations correspondantes de l’API partenaire de vente. Consultez la section [Mappage des API d’Amazon MWS vers l’API partenaire de vente](#Mapping-APIs-from-Amazon-MWS-to-the-Selling-Partner-API) pour voir quelles opérations de l’API partenaire de vente correspondent aux opérations Amazon MWS appelées par votre application.

# Rôles dans l’API partenaire de vente

Un rôle est le mécanisme utilisé par l’API partenaire de vente pour déterminer si un développeur ou une application a accès à une opération ou à une ressource. En tant que développeur, vous devez demander un rôle particulier et y être qualifié, sinon vous ne serez pas en mesure d’accéder aux opérations et aux ressources regroupées sous ce rôle.

Les rôles de l’API partenaire de vente sont plus précis que les rôles d’Amazon MWS. Là où Amazon MWS avait trois rôles, l’API partenaire de vente en a 11. Consultez la section [Rôles de l’API partenaire de vente](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/roles/Roles-in-the-Selling-Partner-API.md) pour une explication détaillée des rôles dans l’API partenaire de vente, ainsi qu’une liste des rôles et de leurs définitions.

# Le jeton de données restreintes

L’API partenaire de vente protège les informations d’identification personnelle des clients en exigeant un jeton de données restreintes (RDT) et des appels à des opérations restreintes (opérations qui renvoient des données restreintes). Pour plus d’informations sur l’obtention et l’utilisation des RDT pour appeler des opérations restreintes, consultez le [Guide des cas d’utilisation de l’API jetons](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/use-case-guides/tokens-api-use-case-guide/tokens-API-use-case-guide-2021-03-01.md)

# Le bac à sable de l’API partenaire de vente
L’API partenaire de vente fournit un environnement de bac à sable qui vous permet de tester vos applications sans affecter les données de production ou déclencher des événements réels. Pour plus d’informations, consultez la section [Bac à sable de l’API partenaire de vente](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md#the-selling-partner-api-sandbox) du Guide du développeur API partenaire de vente.

# Ressources supplémentaires
* [Problèmes GitHub](https://github.com/amzn/selling-partner-api-docs/issues)
* Contactez le service de soutien en ouvrant un [dossier](https://sellercentral.amazon.com/cu/case-lobby?ref=xx_caseLog_xxxx_helphub&) dans Seller Central
* [Guide du développeur de l’API partenaire de vente](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md)
