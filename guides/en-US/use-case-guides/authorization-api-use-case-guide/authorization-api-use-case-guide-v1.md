# Authorization API Use Case Guide

Version: v1

# Contents

-   [What is the Authorization API?](#What-is-the-Authorization-API)
-   [Tutorial: Migrate an Amazon MWS authorization to a Selling Partner API application](#Tutorial-Migrate-an-Amazon-MWS-authorization-to-a-Selling-Partner-API-application)

# What is the Authorization API?

The Authorization API lets you migrate an Amazon Marketplace Web Service \(Amazon MWS\) authorization, that a seller previously granted you, to a hybrid Selling Partner API (SP-API) application. This eliminates the need to request authorization from this seller for your hybrid SP-API application.

**Note.** Authorizations of a hybrid SP-API application expire after one year. Be sure to have your selling partners reauthorize your SP-API hybrid application yearly before their authorizations expire. 

When would you need to use the Authorization API? Suppose you have published an Amazon MWS application on the Amazon Seller Central Partner Network. A number of sellers have authorized you as an Amazon MWS developer so they can use your application. You later convert your Amazon MWS application into a hybrid SP-API application that makes calls to both Amazon MWS and the SP-API. Now you want your application to make calls to the SP-API on behalf of these sellers. The Authorization API lets you do this without your selling partners needing to authorize your hybrid SP-API application.

# Tutorial: Migrate an Amazon MWS authorization to a Selling Partner API application

This tutorial shows you how to use the Authorization API to get authorization to call Selling Partner API operations on behalf of a seller who previously authorized you as an Amazon MWS developer.

**Prerequisites**

This tutorial assumes that you have a hybrid Selling Partner API application published on the Amazon Seller Central Partner Network (Amazon SCPN). Further, it assumes that you published your application following these steps:

1.  You published an Amazon MWS application on the Amazon SCPN.
2.  One or more sellers have authorized your developer ID to make calls to Amazon MWS on your behalf.
3.  You converted your Amazon MWS application to a draft hybrid Selling Partner API application.
4.  You published your hybrid Selling Partner API application to the Amazon SCPN.

For more information, see [Hybrid Selling Partner API applications](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md#hybrid-selling-partner-api-applications) in the Amazon Selling Partner API Developer Guide.

**Steps**

[Step 1. Get an LWA authorization code](#Step-1-Get-an-LWA-authorization-code)

[Step 2. Exchange the LWA authorization code for an LWA refresh token](#Step-2-Exchange-the-LWA-authorization-code-for-an-LWA-refresh-token)

## Step 1. Get an LWA authorization code

An LWA authorization code represents authorization to make calls to Selling Partner API on behalf of a seller who authorized you as an Amazon MWS developer.

**Note:** An LWA authorization code expires after five minutes. Be sure to [exchange it for an LWA refresh token](#step-2-exchange-the-lwa-authorization-code-for-an-lwa-refresh-token) before it expires.

**To get an LWA authorization code**

1. Get the seller ID of the seller that previously authorized you as an Amazon MWS developer.

2. Get the MWS auth token that the seller gave you when they authorized you.

3.  Call the [getAuthorizationCode](https://github.com/amzn/selling-partner-api-docs/blob/main/references/authorization-api/authorization.md#getauthorizationcode) operation of the Authorization API, passing the following parameters:

| Name             | Description                                                  | Required |
| ---------------- | ------------------------------------------------------------ | -------- |
| sellingPartnerId | The seller ID of the seller for whom you are requesting Selling Partner API authorization. This must be the seller ID of the seller who authorized your application on the Amazon Seller Central Partner Network (Amazon SCPN).<br>Type: string | Yes      |
| developerId      | Your developer ID. This must be one of the developer ID values that you provided when you registered your hybrid application in Developer Central. This must also be the developer id that the seller authorized for you to make calls to Amazon MWS on their behalf.<br>Type: string | Yes      |
| mwsAuthToken     | The MWS Auth Token that was generated when the seller authorized your application on the Amazon SCPN.<br>Type: string | Yes      |

Request example:

    GET https://sellingpartnerapi-na.amazon.com/authorization/v1/authorizationCode

**Important:** The developer ID that you specify must be the same developer ID that you provided when you registered your application for listing in the Amazon SCPN. Otherwise the service returns an error.

The operation returns an LWA authorization code.
    
**Response**

A successful response includes the following:
    
| Name                         | Description                                 | Required |
| ---------------------------- | ------------------------------------------- | -------- |
| getAuthorizationCodeResponse | The response schema for the GetAuthorizationCode operation.<br>Type: [GetAuthorizationCodeResponse](https://github.com/amzn/selling-partner-api-docs/blob/main/references/authorization-api/authorization.md#getauthorizationcoderesponse) | Yes      |

Response example:

    {
      "payload": {
        "authorizationCode": "authcodeexample"
      }
    }

**Note:** While the getAuthorizationCode operation gets you authorization to make calls to Selling Partner API on behalf of a seller, calling the operation itself does not require authorization from any seller. In this respect, the getAuthorizationCode operation is a "grantless" operation and has a different authorization model from other Selling Partner API operations. For information about calling the getAuthorizationCode operation, see [Grantless operations](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md#grantless-operations-1) in the Amazon Selling Partner API Developer Guide.

## Step 2. Exchange the LWA authorization code for an LWA refresh token

Call the LWA authorization server to exchange the LWA authorization code for an LWA refresh token. Upon receiving the refresh token, your application is authorized to make calls to Selling Partner API operations on the seller's behalf.

For more information, see [Authorizing Selling Partner API applications](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md#authorizing-selling-partner-api-applications) in the Selling Partner API Developer Guide.

