# Authorization API User Guide

-   [What is the Authorization API?](#What-is-the-Authorization-API)
-   [Tutorial: Migrate an Amazon MWS authorization to a Selling Partner API application](#Tutorial-Migrate-an-Amazon-MWS-authorization-to-a-Selling-Partner-API-application)

## What is the Authorization API?

The Authorization API lets you migrate an Amazon Marketplace Web Service \(Amazon MWS\) authorization that a seller has granted you to a hybrid Selling Partner API application. This eliminates the need to request authorization from the seller again.

When would you need to use the Authorization API? Suppose you have published an Amazon MWS application on the Marketplace Appstore. A number of sellers have authorized you as an Amazon MWS developer so they can use your application. You later convert your Amazon MWS application into a hybrid Selling Partner API application that makes calls to both Amazon MWS and Selling Partner API. Now you want your application to make calls to Selling Partner API on behalf of these sellers without requesting authorization again. The Authorization API lets you do this.

## Tutorial: Migrate an Amazon MWS authorization to a Selling Partner API application

This tutorial shows you how to use the Authorization API to get authorization to call Selling Partner API operations on behalf of a seller who previously authorized you as an Amazon MWS developer.

### Prerequisites

This tutorial assumes that you have a hybrid Selling Partner API application published on the Marketplace Appstore. Further, it assumes that you published your application following these steps:

1.  You published an Amazon MWS application on the Marketplace Appstore.
2.  One or more sellers authorized you as an Amazon MWS developer so they could use your application.
3.  You converted your Amazon MWS application to a draft hybrid Selling Partner API application.
4.  You published your hybrid Selling Partner API application to the Marketplace Appstore.

For more information, see **Hybrid Selling Partner API applications** in the Amazon Selling Partner API Developer Guide.

### Step 1. Get an LWA authorization code

An LWA authorization code represents authorization to make calls to Selling Partner API on behalf of a seller who authorized you as an Amazon MWS developer.

****To get an LWA authorization code****

1.  Get the seller ID of the seller that previously authorized you as an Amazon MWS developer.
2.  Get the MWS auth token that the seller gave you when they authorized you.
3.  Call the `GET/authorization/v1/authorizationCode` operation of the Authorization API, specifying the seller ID, the MWS auth token, and your developer ID\(s\).

    **Important:** The developer ID that you specify must be the same developer ID that you provided when you registered your application for listing in the Marketplace Appstore. Otherwise the service returns an error.

    The operation returns an LWA authorization code.


**Note:** While the `GET/authorization/v1/authorizationCode` operation gets you authorization to make calls to Selling Partner API on behalf of a seller, calling the operation itself does not require authorization from any seller. In this respect, the `GET/authorization/v1/authorizationCode` operation is a "grantless" operation and has a different authorization model from other Selling Partner API operations. For information about calling the `GET/authorization/v1/authorizationCode` operation, see **Grantless operations** in the Amazon Selling Partner API Developer Guide.

### Step 2. Exchange the LWA authorization code for an LWA refresh token

Call the LWA authorization server to exchange the LWA authorization code for an LWA refresh token. Upon receiving the refresh token, your application is authorized to make calls to Selling Partner API operations on the seller's behalf.

For details about exchanging the LWA authorization code for an LWA refresh token, see **Step 4. Your application exchanges the LWA authorization code for a LWA refresh token** in the Selling Partner API Developer Guide.

