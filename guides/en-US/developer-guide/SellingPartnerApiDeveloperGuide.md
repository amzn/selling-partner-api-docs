# Selling Partner API Developer Guide

# Contents

- [What is the Selling Partner API?](#what-is-the-selling-partner-api)
  - [Selling Partner API HTTP methods](#selling-partner-api-http-methods)

  - [Selling Partner API endpoints](#selling-partner-api-endpoints)

  - [marketplaceId values](#marketplaceid-values)

- [Global applications](#global-applications)

- [Registering as a developer](#registering-as-a-developer)

- [Creating and configuring IAM policies and entities](#Creating-and-configuring-IAM-policies-and-entities)
  - [Step 1. Create an AWS account](#step-1-create-an-aws-account)
  
  - [Step 2. Create an IAM user](#step-2-create-an-iam-user)
  
  - [Step 3. Create an IAM policy](#step-3-create-an-iam-policy)
  
  - [Step 4. Create an IAM role](#step-4-create-an-iam-role)
  
  - [Step 5. Add an AWS Security Token Service policy to your IAM user](#step-5-add-an-aws-security-token-service-policy-to-your-iam-user)
  
- [Registering your application](#registering-your-application)
  
- [Viewing your developer information](#viewing-your-developer-information)

- [Authorizing Selling Partner API applications](#authorizing-selling-partner-api-applications)
- [Marketplace Appstore workflow](#marketplace-appstore-workflow)
  
  - [Step 1. The seller initiates authorization from the Marketplace Appstore](#step-1-the-seller-initiates-authorization-from-the-marketplace-appstore)
  
  - [Step 2. The seller consents to authorize your application](#Step-2-The-seller-consents-to-authorize-your-application)
  
  - [Step 3. The seller signs into your website](#step-3-the-seller-signs-into-your-website)
  
  - [Step 4. Amazon sends you the authorization information](#step-4-amazon-sends-you-the-authorization-information)
  
  - [Step 5. Your application exchanges the LWA authorization code for an LWA refresh token](#step-5-your-application-exchanges-the-lwa-authorization-code-for-an-lwa-refresh-token)
  
- [Website workflow](#website-workflow)
  
  - [Step 0. Set up an "Authorize" button](#step-0-set-up-an-"authorize"-button)
  
  - [Step 1. The seller initiates authorization from your website](#Step-1-The-seller-initiates-authorization-from-your-website)
  
  - [Step 2. The seller consents to authorize the application](#Step-2-The-seller-consents-to-authorize-the-application)
  
  - [Step 3. Amazon sends you the authorization information](#Step-3-Amazon-sends-you-the-authorization-information)
  
  - [Step 4. Your application exchanges the LWA authorization code for a LWA refresh token](#Step-4-Your-application-exchanges-the-LWA-authorization-code-for-a-LWA-refresh-token)


- [Self authorization](#self-authorization)

- [Authorization with the Restricted Data Token](#Authorization-with-the-Restricted-Data-Token)

- [Generating a Java SDK with LWA token exchange and authentication](#generating-a-java-sdk-with-lwa-token-exchange-and-authentication)

- [Connecting to the Selling Partner API using a generated Java SDK](#connecting-to-the-selling-partner-api-using-a-generated-java-sdk)

  - [Step 1. Configure your AWS credentials](#step-1-configure-your-aws-credentials)

  - [Step 2. Configure your AWS credentials provider](#step-2-Configure-your-AWS-credentials-provider)

  - [Step 3. Configure your LWA credentials](#step-3-configure-your-lwa-credentials)

  - [Step 4. Create an instance of the Sellers API and call an operation](#step-4-create-an-instance-of-the-sellers-api-and-call-an-operation)

- [Generating a Java client library](#generating-a-java-client-library)

- [Connecting to the Selling Partner API](#connecting-to-the-selling-partner-api)

  - [Step 1. Request a Login with Amazon access token](#step-1-request-a-login-with-amazon-access-token)
    
  - [Step 2. Construct a Selling Partner API URI](#step-2-construct-a-selling-partner-api-uri)
    
  - [Step 3. Add headers to the URI](#step-3-add-headers-to-the-uri)
    
  - [Step 4. Create and sign your request](#step-4-create-and-sign-your-request)
    
    - [Credential scope](#credential-scope)
    
    - [Authorization header](#authorization-header)

- [Response format](#response-format)

- [Grantless operations](#grantless-operations-1)

- [Include a User-Agent header in all requests](#include-a-user-agent-header-in-all-requests)

- [Hybrid Selling Partner API applications](#hybrid-selling-partner-api-applications)

- [The Selling Partner API sandbox](#the-selling-partner-api-sandbox)

- [How does the Selling Partner API differ from Amazon Marketplace Web Service?](#how-does-the-selling-partner-api-differ-from-amazon-marketplace-web-service)

# What is the Selling Partner API?

The Selling Partner API is a REST-based API that helps Amazon sellers programmatically access their data on listings, orders, payments, reports, and more. Applications using the Selling Partner API can increase selling efficiency, reduce labor requirements, and improve response time to customers, helping sellers grow their businesses. The Selling Partner API builds on the functionality of Amazon Marketplace Web Service (Amazon MWS), but provides features to improve usability and security for developers and the seller partners they work with.

**Key features**

With the Selling Partner API, you can:

  - Set up an OAuth authorization workflow that sellers initiate from the Marketplace Appstore detail page or from your own website.

  - Generate an SDK that can help you with LWA token exchange and authentication.

  - Create hybrid applications that make calls both to the Selling Partner API and to Amazon MWS.

  - Test your applications by making calls to a sandbox environment.

## Selling Partner API HTTP methods

The Selling Partner API supports these HTTP methods.

| **HTTP method** | **Description**    |
| --------------- | ------------ |
| GET | Retrieves resource data or a list of resources.  |
| POST | Submits an entity to the specified resource, often causing a change in state or side effects on the server. |
| PUT  | Replaces all current representations of the target resource with the request payload.                       |

<span id="Selling_Partner_API_endpoints" class="anchor">

## Selling Partner API endpoints

Selling Partner API endpoints are associated with a particular AWS Region. The AWS Region is important because it is part of the credential scope, which is required for calculating a signature when calling the Selling Partner API. For more information, see [Credential scope](#credential-scope).

<table>
<thead>
<tr class="header">
<th><strong>Selling region</strong></th>
<th><strong>Endpoint</strong></th>
<th><strong>AWS Region</strong></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>North America (Canada, US, Mexico, and Brazil marketplaces)</td>
<td>https://sellingpartnerapi-na.amazon.com</td>
<td>us-east-1</td>
</tr>
<tr class="even">
<td>Europe (Spain, UK, France, Netherlands, Germany, Italy, Sweden, Poland, Turkey, U.A.E, and India marketplaces)</td>
<td>https://sellingpartnerapi-eu.amazon.com</td>
<td>eu-west-1</td>
</tr>
<tr class="odd">
<td>
<p>Far East (Singapore, Australia, and Japan marketplaces)</p>
</td>
<td>https://sellingpartnerapi-fe.amazon.com</td>
<td>us-west-2</td>
</tr>
</tbody>
</table>

## marketplaceId values

The `marketplaceId` identifies the marketplace for a request.

**North America**

| **Country**              | **marketplaceId** | **Country code** |
| ------------------------ | ----------------- | ---------------- |
| Canada                   | A2EUQ1WTGCTBG2    | CA               |
| United States of America | ATVPDKIKX0DER     | US               |
| Mexico                   | A1AM78C64UM0Y8    | MX               |
| Brazil                   | A2Q3Y263D00KWC    | BR               |

**Europe**

| **Country**          | **marketplaceId** | **Country code** |
| -------------------- | ----------------- | ---------------- |
| Spain                | A1RKKUPIHCS9HS    | ES               |
| United Kingdom       | A1F83G8C2ARO7P    | GB               |
| France               | A13V1IB3VIYZZH    | FR               |
| Netherlands          | A1805IZSGTT6HS    | NL               |
| Germany              | A1PA6795UKMFR9    | DE               |
| Italy                | APJ6JRA9NG5V4     | IT               |
| Sweden               | A2NODRKZP88ZB9    | SE               |
| Poland               | A1C3SOZRARQ6R3    | PL               |
| Turkey               | A33AVAJ2PDY3EV    | TR               |
| United Arab Emirates | A2VIGQ35RCS4UG    | AE               |
| India                | A21TJRUUN4KGV     | IN               |

**Far East**

<table>
<thead>
<tr class="header">
<th>
<strong>Country</strong>
</th>
<th>
<strong>marketplaceId</strong>
</th>
<th><strong>Country code</strong></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>Singapore</td>
<td>A19VAU5U5O7RUS</td>
<td>SG</td>
</tr>
<tr class="even">
<td>Australia</td>
<td>A39IBJ37TRP1C6</td>
<td>AU</td>
</tr>
<tr class="odd">
<td>Japan</td>
<td>A1VC38T7YXB528</td>
<td>JP</td>
</tr>
</tbody>
</table>

# Global applications

You only need to register as a developer once, in the region and marketplace of your choice, to be able to create a Selling Partner API application that can be authorized by a seller from any region or marketplace. You need only one set of developer credentials (your AWS access key ID and AWS secret access key) to make calls to any Selling Partner API endpoint, as long as the endpoint is from the same region as the seller who authorized your application.

**Important.** If you have a [hybrid Selling Partner API applications](#hybrid-selling-partner-api-applications), your calls to Amazon Marketplace Web Service (Amazon MWS) endpoints have the same restrictions as an Amazon MWS application. That is, when you call an Amazon MWS endpoint, you must use Amazon MWS Access Keys associated with the region that the endpoint comes from.

For more information, see [Selling Partner API endpoints](#Selling-Partner-API-endpoints).

# Registering as a developer

You need to register as a Selling Partner API developer before you can register your Selling Partner API application.

**To register as a developer**

1.  Sign into Seller Central with the credentials that you want to associate with your developer account.

2.  In the **Apps & Services** menu, click **Develop Apps**.

    The **Developer Central** page appears.

3.  Follow the instructions to register as a developer.

After we have registered you as a developer, you can [Create and configuring IAM policies and entities](#Creating-and-configuring-IAM-policies-and-entities). To view your developer information, see [Viewing your developer information](#viewing-your-developer-information).

# Creating and configuring IAM policies and entities

The following steps explain how to create and configure IAM policies and entities with the end goal of creating an IAM role that you provide when you register your application. In this workflow you create an IAM user (with an [AWS STS](https://docs.aws.amazon.com/STS/latest/APIReference/welcome.html) policy attached) that assumes an IAM role that has permissions to call Selling Partner API.

**Steps**

[Step 1. Create an AWS account](#step-1-create-an-aws-account)

[Step 2. Create an IAM user](#step-2-create-an-iam-user)

[Step 3. Create an IAM policy](#step-3-create-an-iam-policy)

[Step 4. Create an IAM role](#step-4-create-an-iam-role)

[Step 5. Add an AWS Security Token Service policy to your IAM user](#step-5-add-an-aws-security-token-service-policy-to-your-iam-user)

## Step 1. Create an AWS account

You need an AWS account because the Selling Partner API security model uses AWS authentication credentials. If you're not already an AWS customer, you can create a free AWS account. For more information, see [AWS Free Tier](https://aws.amazon.com/free).

## Step 2. Create an IAM user

Create an IAM user to get AWS keys to authenticate calls to the Selling Partner API. We recommend creating a new IAM user exclusively for this purpose. Use the IAM user to assume the IAM role that you create in [Step 4. Create an IAM role](#step-4-create-an-iam-role).

**To create an IAM user**

1.  If you are not already signed in, sign into the AWS Management Console and open the IAM console at [console.aws.amazon.com/iam](https://console.aws.amazon.com/iam).

2.  In the navigation pane at left, click **Users** and then click **Add user** button.

3.  Enter a user name for the new user.

4.  Select **Programmatic access** and then click the **Next: Permissions** button.

5.  On the **Set Permissions** page, accept the defaults and click the **Next: Tags.** You will set permissions when you [create an IAM role](#step-4-create-an-iam-role).

6.  On the **Add tags (optional)** page, add optional tags if you want them and then click the **Next: Review** button.

7.  On the **Review** page, review the choices you have made. You can ignore the **This user has no permissions** warning. You will set permissions when you [create an IAM role](#step-4-create-an-iam-role). When you are ready to proceed, click the **Create user** button.

    The AWS access key ID for your new IAM user is displayed.

8.  Click **Show** to view the AWS secret access key. To save the AWS access key, click **Download .csv** and then save the file to a safe location.

    **Important:** This is your only opportunity to view or download your AWS secret access key, which you will need to authenticate your calls to the Selling Partner API. Save the AWS access key ID and AWS secret access key in a safe and secure place. **You will not have access to the AWS access key again after this step.** If you lose your AWS secret access key you will need to create a new IAM user with its own new set of keys.

9.  Click **Close**. In the **User name** column, click your new IAM user and make a note of the User ARN. You will need it in [Step 4. Create an IAM role](#step-4-create-an-iam-role).

For more information, see [Creating an IAM User in Your AWS Account](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_users_create.html) in the AWS documentation.

## Step 3. Create an IAM policy

This IAM policy defines permissions to make calls to the Selling Partner API. You will attach it to the IAM role that you create in [Step 4. Create an IAM role](#step-4-create-an-iam-role).

**To create an IAM policy**

1.  Sign into the AWS Management Console and open the IAM console at [console.aws.amazon.com/iam](https://console.aws.amazon.com/iam).

2.  In the navigation pane at left, click **Policies**.

    If this is your first time choosing **Policies**, the **Welcome to Managed Policies** page appears. Click **Get Started**.

3.  Click the **Create policy** button.

4.  Click the **JSON** tab.

5.  Paste the following code into the text box, replacing the existing code, and then click **Review policy**.
```json
{
  "Version": "2012-10-17",
  "Statement": [
    {
      "Effect": "Allow",
      "Action": "execute-api:Invoke",
      "Resource": "arn:aws:execute-api:*:*:*"
    }
  ]
}

```

6.  On the **Review policy** page, type a **Name** and a **Description** (optional) for the policy that you are creating. We recommend naming your IAM policy, `SellingPartnerAPI`.

7.  Review the policy **Summary** to see the permissions that are granted by your policy, then click the **Create policy** button.

    Your new IAM policy appears in the list.

For more information, see [Creating IAM Policies](https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies_create.html) in the AWS documentation.

## Step 4. Create an IAM role

Create an IAM role that trusts the IAM user that you created in [Step 2. Create an IAM user](#Step-2-Create-an-IAM-user) and has permissions to call the Selling Partner API.

**To create an IAM role**

1.  If you are not already signed in, sign into the AWS Management Console and open the IAM console at [console.aws.amazon.com/iam](https://console.aws.amazon.com/iam).

2.  In the navigation pane at left, click **Roles** and then click **Create role** button.

3.  On the **Create role** page, click **Another AWS account**.

4.  In the **Account ID** box, enter the account identifier for the AWS account in which you created your IAM user in [Step 2. Create an IAM user](#Step-2-Create-an-IAM-user), and then click the **Next: Permissions** button.

5.  On the **Attach permissions policies** page, under **Policy name**, select the policy that you created in [Step 3. Create an IAM policy](#Step-3-Create-an-IAM-policy), and then click **Next: Tags.**

    **Tip:** Click **Filter policies** and then select **Customer managed** to narrow your choices.

6.  On the **Add tags (optional)** page, add optional tags if you want them and then click the **Next: Review** button.

7.  On the **Create role** page, enter a role name in the **Role name** box, an optional role description in the **Role description** box, and then click the **Create role** button.

8.  Under **Role name**, click the name of your new role.

    The **Summary** page appears

9.  Save your role ARN. You will need it:
    
    1.  When you [register your application](#Registering-your-application).
    
    2.  In [Step 5. Add an AWS Security Token Service policy to your IAM user](#step-5-Add-an-AWS-Security-Token-Service-policy-to-your-IAM-user).

For more information, see [Creating a Role to Delegate Permissions to an IAM User](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_create_for-user.html) in the AWS documentation.

## Step 5. Add an AWS Security Token Service policy to your IAM user

Adding an [AWS Security Token Service (AWS STS)](https://docs.aws.amazon.com/STS/latest/APIReference/welcome.html) policy to your IAM user enables you to request temporary AWS access keys that you can use to authenticate your requests to the Selling Partner API. These credentials expire after a set period of time, helping you to control access to your AWS resources.

1.  If you are not already signed in, sign into the AWS Management Console and open the IAM console at [console.aws.amazon.com/iam](https://console.aws.amazon.com/iam).

3.  In the navigation pane at left, click **Users** and then click the user that you want to add the AWS STS policy to. In this workflow, choose the user you created in [Step 2. Create an IAM user](#Step-2-Create-an-IAM-user). You might choose a different IAM user for other use cases.

4.  On the **Permissions** tab, click **Add inline policy**.

5.  On the **Create policy** page, click **Choose a service**.

6.  Click the **STS** service.

    **Tip.** Type **STS** in the search box to narrow your choices.

7.  Click the arrow next to **Write** to expand it.

8.  Select **AssumeRole**.

9.  Click the arrow next to **Resources** to expand it, and then click **Add** **ARN**.

10. In the **Add ARN(s)** dialog box, enter the role ARN from [Step 4. Create an IAM role](#step-4-create-an-iam-role) in the **Specify ARN for role** box, click **Add**, and then click the **Review policy** button.

11. On the **Review policy** page, enter a name for your policy in the **Name** box. Review the choices you have made. If you are ready to proceed, click the **Create policy** button.

# Registering your application

Before you register your application, [create and configure your IAM policies and entities](#Creating-and-configuring-IAM-policies-and-entities).

**To register your application**

1.  Sign into Seller Central using the credentials that you used to [register as a developer](#registering-as-a-developer).

2.  In the **Apps & Services** menu, click **Develop Apps**.

    The **Developer Central** page appears.

3.  Follow the instructions to register your application.

**Important.** When registering your application, the IAM ARN that you provide must be for the IAM entity to which you attached the IAM policy from  [Step 3. Create an IAM policy](#Step-3-Create-an-IAM-policy). In this workflow, that IAM entity is the IAM role from [Step 4. Create an IAM role](#Step-4-Create-an-IAM-role). If you register your application using your IAM user, be sure that the IAM policy is attached to it. Otherwise your calls to the Selling Partner API will fail. We recommend registering your application using an IAM role, as shown in this workflow, to help you better control access to your AWS resources.

# Viewing your developer information

After you [register your application](#registering-your-application) you can sign into Developer Central to view your developer information.

**To view your developer information**

1.  Sign into Seller Central using the credentials that you used to [register as a developer](#registering-as-a-developer).

2.  In the **Apps & Services** menu, click **Develop Apps**.

    The **Developer Central** page appears, displaying the IAM ARN associated with your application(s).

3.  Click **View** under **LWA credentials** for the application you want.

    Your LWA client identifier and client secret for that application appear. You will need these credentials to request an LWA access token. For more information, see [Step 1. Request a Login with Amazon access token](#step-1-request-a-login-with-amazon-access-token).

# Authorizing Selling Partner API applications

The authorization model for the Selling Partner API is based on [Login with Amazon](https://developer.amazon.com/docs/login-with-amazon/documentation-overview.html), Amazon's implementation of OAuth 2.0. In this model the selling partner authorizes your application by interacting with pages displayed by Amazon and by your website. Actions taken by the selling partner trigger responses by your website or by Amazon. The selling partner's browser is the user-agent that passes parameters between your website and Amazon at each selling partner action. To implement OAuth authorization you must configure your website to (1) accept and process the parameters that Amazon passes to it, and (2) redirect the selling partner’s browser and pass parameters to Amazon.

Selling partners can authorize your applications using one of these workflows:

  - [Marketplace Appstore workflow](#marketplace-appstore-workflow). An OAuth authorization workflow initiated from the Marketplace Appstore detail page.
  - [Website workflow](#website-workflow). An OAuth authorization workflow initiated from your own website.

If you are developing an application for your own selling account, you can authorize it yourself. For more information, see [Self authorization](#self-authorization).

## OAuth authorization URIs

An OAuth authorization URI is a key component for creating and testing Selling Partner API authorization workflows. The OAuth authorization URI redirects a browser to a Seller Central sign-in page. After sign-in, a consent page appears, where a seller can give your application consent to make calls to the Selling Partner API on their behalf.

If a seller authorizes your application starting from your own website (the [Website workflow](#website-workflow)) your website uses an OAuth authorization URI to redirect the seller to the Seller Central consent page. Even if a seller authorizes your application starting from the Marketplace Appstore (the [Marketplace Appstore workflow](#marketplace-appstore-workflow)), you still need an OAuth authorization URI to test your authorization workflow in draft status before creating a live listing in the Marketplace Appstore.

**To construct an OAuth authorization URI**

1.  Get the Seller Central URL for the marketplace where you want sellers to authorize your applications. Example: `https://sellercentral.amazon.com`

2.  Combine the Seller Central URL with `/apps/authorize/consent?{your application ID}`.

    Example: `https://sellercentral.amazon.com/apps/authorize/consent?application_id=amzn1.sellerapps.app.0bf296b5-36a6-4942-a13e-EXAMPLEfcd28`

You will need an OAuth authorization URI for every marketplace where you want sellers to authorize your application. Simply use the appropriate Seller Central URL in each OAuth authorization URI that you need.

**Note.** For sellers who sell in the Spain, UK, France, Germany, and Italy marketplaces, you can use the Seller Central URL for Europe when creating an OAuth authorization URI. Example: `https://sellercentral-europe.amazon.com/apps/authorize/consent?application_id=amzn1.sellerapps.app.0bf296b5-36a6-4942-a13e-EXAMPLEfcd28`

If you are creating an OAuth authorization URI for testing your authorization workflow, add the version=beta parameter. This indicates that the authorization workflow is for an application in draft status. Example: `https://sellercentral-europe.amazon.com/apps/authorize/consent?application_id=amzn1.sellerapps.app.0bf296b5-36a6-4942-a13e-EXAMPLEfcd28&version=beta`

For information about creating and testing an authorization workflow, see [Marketplace Appstore workflow](#marketplace-appstore-workflow) and [Website workflow](#website-workflow).

## Grantless operations

A grantless operation is an operation that you can call without explicit authorization from a selling partner. This authorization model doesn't require you to receive and exchange LWA authorization codes and refresh tokens to get an LWA access token, as you must when calling other Selling Partner API operations. Instead you get your LWA access token with a single call to the LWA authorization server.

## Migrating authorization from Amazon Marketplace Web Service

If a selling partner has authorized you to make calls to Amazon Marketplace Web Service on their behalf, you can use the Authorization API to migrate that authorization to a hybrid Selling Partner API application. This eliminates the need to request authorization from the selling partner again. For more information, see the [Authorization API Use Case Guide](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/use-case-guides/authorization-api-use-case-guide.md).

## Marketplace Appstore workflow

The Marketplace Appstore workflow is an OAuth authorization workflow that the seller initiates from the Marketplace Appstore detail page. When you list a Selling Partner API application on the Marketplace Appstore, sellers can authorize your application by clicking an **Authorize Now** button on the detail page.

**Testing your authorization workflow**

Before listing your application on the Marketplace Appstore, you should test your authorization workflow while your application is in draft status. Your test workflow won’t be exactly the same as the final production workflow, but you'll be able to ensure that your application can exchange parameters with Amazon and receive authorization information.

**To set up a test authorization workflow**

1.  Make sure that your application in draft status.

2.  Construct one or more OAuth authorization URIs for testing purposes. Include the version=beta parameter in the OAuth URI(s) to indicate that the workflow is for authorizing an application in draft status. For more information, see [OAuth authorization URIs](#oauth-authorization-uris).

3.  At [Step 3. The seller signs into your website](#step-3.-the-seller-signs-into-your-website), be sure that your workflow adds the `version=beta` parameter to the Amazon callback URI to indicate that the workflow is for authorizing an application in draft status.

You are now ready to test your authorization workflow with a trusted seller who works with you. Alternatively, you can test the workflow yourself, using your own selling account credentials. Instead of starting at [Step 1. The seller initiates authorization from the Marketplace Appstore](#step-1.-the-seller-initiates-authorization-from-the-marketplace-appstore), the seller starts the test workflow by navigating to an OAuth authorization URI that you constructed previously.

**Note:** If you have more than one regional OAuth authorization URI, be sure give the seller the OAuth authorization URI that corresponds to the region that they sell in.

When you have finished testing the authorization workflow you can convert it to a production workflow.

**To convert your test authorization workflow to a productions workflow**

1.  List your application in the Marketplace Appstore. This changes your application from draft status to published status.

2.  Update your workflow so that it no longer adds the `version=beta` parameter to the Amazon callback URI in [Step 3. The seller signs into your website](#Step-3-The-seller-signs-into-your-website).

    Now any seller can authorize your published application starting at [Step 1. The seller initiates authorization from the Marketplace Appstore](#Step-1-The-seller-initiates-authorization-from-the-Marketplace-Appstore).

**Steps**

[Step 1. The seller initiates authorization from the Marketplace Appstore](#Step-1-The-seller-initiates-authorization-from-the-Marketplace-Appstore)

[Step 2. The seller consents to authorize your application](#Step-2-The-seller-consents-to-authorize-your-application)

[Step 3. The seller signs into your website](#Step-3-The-seller-signs-into-your-website)

[Step 4. Amazon sends you the authorization information](#Step-4-Amazon-sends-you-the-authorization-information)

[Step 5. Your application exchanges the LWA authorization code for an LWA refresh token](#Step-5-Your-application-exchanges-the-LWA-authorization-code-for-an-LWA-refresh-token)

### Step 1. The seller initiates authorization from the Marketplace Appstore

1.  The seller signs into Seller Central and goes to the Marketplace Appstore.

2.  The seller goes to the detail page for your application and clicks the **Authorize Now** button. The consent page for your application appears.

### Step 2. The seller consents to authorize your application

1.  The seller views the consent page, reviews and accepts the data access requested by your application, and then clicks the **Login to \[your application name\] now** button to continue. The seller can click the **Cancel** button to exit without authorizing.

2.  Amazon loads your Login URI (which you provided at application registration) into the browser, adding the following query parameters:

| **Parameter**             | **Description**     |
| ------------------------- | ------------------  |
| **amazon_callback_uri** | A URI for redirecting the browser to Amazon.   |
| **amazon_state**         | A state value generated by Amazon to guard against cross-site request forgery attacks.    |
| **selling_partner_id**  | The seller ID of the seller who is authorizing your application.     |

**Note:** If this a test workflow (the seller started by navigating to your OAuth authorization URI) Amazon includes the `version=beta` parameter. If this is a production workflow (the seller started from the Marketplace Appstore), Amazon does not include the parameter.

For example:
```
https://d2yzyfnnpjylxu.cloudfront.net/index.html?amazon_callback_uri=https://amazon.com/apps/authorize/confirm/amzn1.sellerapps.app.2eca283f-9f5a-4d13-b16c-474EXAMPLE57&amazon_state=amazonstateexample&selling_partner_id=A3FHEXAMPLEYWS
```
Your website's sign-in page appears.

### Step 3. The seller signs into your website

1.  The seller signs into your website. If the seller does not yet have an account, they complete your registration process.

2.  Your application loads the Amazon callback URI (passed by Amazon in the previous step) into the browser, adding the following parameters:

<table>
<thead>
<tr class="header">
<th><strong>Parameter</strong></th>
<th><strong>Description</strong></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td><strong>redirect_uri</strong></td>
<td>A URI for redirecting the browser to your application. This must an OAuth Redirect URI that you specified when you <a href="#step-6-register-your-application">registered your application</a>. If you do not include the <strong>redirect_uri</strong> parameter, the default is the first OAuth Redirect URI that you specified when you registered your application.</td>
</tr>
<tr class="even">
<td><strong>amazon_state</strong></td>
<td>The <code>amazon_state</code> value passed by Amazon in the previous step.</td>
</tr>
<tr class="odd">
<td><strong>state</strong></td>
<td><p>A state value generated by your application. Your application uses this value to maintain state between this request and the response, helping to guard against cross-site request forgery attacks.</p>
<p><strong>Important:</strong> Because OAuth information is passed via URI query parameters, we highly recommended that you do the following: (1) Ensure that the state token is short-lived and verifiably unique to your user, and (2) Set the <code>Referrer-Policy: no-referrer HTTP</code> header, which prevents leaking sensitive information to websites that your website links to. For more information about cross- site request forgery and calculating a state parameter, see <a href="https://developer.amazon.com/docs/login-with-amazon/cross-site-request-forgery.html">Cross-site Request Forgery</a> in the Login with Amazon documentation.</p></td>
</tr>
</tbody>
</table>

**Note:** If you include the `version=beta` parameter, the workflow authorizes an application in Draft state. If you do not include the parameter, the workflow authorizes an application published on the Marketplace Appstore.

For example:
```
https://amazon.com/apps/authorize/confirm/amzn1.sellerapps.app.2eca283f-9f5a-4d13-b16c-474EXAMPLE57?redirect_uri=https://d2yzyfnnpjylxu.cloudfront.net/landing.html&amazon_state=amazonstateexample&state=-37131022&version=beta
```
OR
```
https://amazon.com/apps/authorize/confirm/amzn1.sellerapps.app.2eca283f-9f5a-4d13-b16c-474EXAMPLE57?redirect_uri=https://d2yzyfnnpjylxu.cloudfront.net/landing.html&amazon_state=amazonstateexample&state=-37131022
```
### Step 4. Amazon sends you the authorization information

Seller Central briefly displays a page indicating that Amazon is authorizing you to access the seller's data. While this page is displayed, the following actions take place:

1.  Amazon loads your OAuth Redirect URI into the browser (the first one you specified when you [registered you application](#Step-6-Register-your-application)), adding the following query parameters:

| **Parameter**| **Description**|
| ------------------------ | -----------------------|
| **state**  | The state value that you passed in the previous step.  |
| **selling\_partner\_id** | The seller ID of the seller who is authorizing your application. |
| **mws\_auth\_token**  |  The **MWSAuthToken** value that you use when you create a query string for a call to Amazon Marketplace Web Service. The mws\_auth\_token parameter is only passed when the seller is authorizing a hybrid Selling Partner API (SP-API) application. Note that if you are the seller authorizing the hybrid SP-API application and the application owner (meaning you self-authorized your own Amazon MWS application) you will not receive the MWSAuthToken. For more information, see [Hybrid Selling Partner API applications](#hybrid-selling-partner-api-applications).|
| **spapi\_oauth\_code**   | The Login with Amazon (LWA) authorization code that you exchange for an LWA refresh token. For more information, see [Step 5. Your](#step-5-your-application-exchanges-the-lwa-authorization-code-for-an-lwa-refresh-token) [application exchanges the LWA authorization code for an LWA](#step-5-your-application-exchanges-the-lwa-authorization-code-for-an-lwa-refresh-token) [refresh token](#step-5-your-application-exchanges-the-lwa-authorization-code-for-an-lwa-refresh-token). |

   For example:
```
https://client-example.com?state=state-example&mws_auth_token=mwsauthtokenexample&selling_partner_id=sellingpartneridexample&spapi_oauth_code=spapioauthcodeexample
```
2.  Your application validates the state value.

3.  Your application saves the selling_partner_id, mws_auth_token (if passed), and spapi_oauth_code values.

4.  Your website's landing page displays.

### Step 5. Your application exchanges the LWA authorization code for an LWA refresh token

The Login with Amazon SDK for JavaScript can help you with the exchange of an LWA authorization code for an LWA refresh token. For more information, see the Login with Amazon documentation:

  - [Add the Login with Amazon SDK for JavaScript](https://developer.amazon.com/docs/login-with-amazon/install-sdk-javascript.html)

  - [Authorization Code Grant](https://developer.amazon.com/docs/login-with-amazon/authorization-code-grant.html)

**To exchange an LWA authorization code for an LWA refresh token**

1.  Your application calls the Login with Amazon (LWA) authorization server (`https://api.amazon.com/auth/o2/token`) to exchange the LWA authorization code for an LWA refresh token. The call must include the following query parameters.

| **Parameter**      | **Description**   |
| ------------------ | --------- |
| **grant_type**    | The type of access grant requested. Must be *authorization_code*. |
| **code**    | The LWA authorization code that you received in [Step 4. Amazon sends you the authorization information](#step-4-amazon-sends-you-the-authorization-information). |
| **redirect_uri**  | The redirect URI for your application.  |
| **client_id**     | Part of your LWA credentials. To get this value, see [Viewing your developer information](#viewing-your-developer-information).  |
| **client_secret** | Part of your LWA credentials. To get this value, see [Viewing your developer information](#viewing-your-developer-information).  |

For example:
```http
POST /auth/o2/token HTTP/l.l
Host: api.amazon.com
Content-Type: application/x-www-form-urlencoded;charset=UTF-8
grant_type=authorization_code&code=SplxlOexamplebYS6WxSbIA&client_id=foodev&client_secret=Y76SDl2F
```
2.  The LWA Authorization Server returns the LWA refresh token. The response is in JSON and includes the following elements.

| **Parameter**      | **Description**                                                                                                                                                                      |
| ------------------ | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ |
| **access_token**  | A token that authorizes your application to take certain actions on behalf of a seller. See [Connecting to the Selling Partner API](#connecting-to-the-selling-partner-api).         |
| **token_type**    | The type of token returned. Should be bearer.   |
| **expires_in**    | The number of seconds before the access token becomes invalid.  |
| **refresh_token** | A long-lived token that can be exchanged for a new access token. See [Connecting to the Selling Partner API](#connecting-to-the-selling-partner-api). |
```http
HTTP/l.l 200 OK
Content-Type: application/json;
charset UTF-8
Cache - Control: no-store
Pragma: no-cache
{
  "access_token": "Atza|IQEBLjAsAexampleHpi0U-Dme37rR6CuUpSR",
  "token_type": "bearer",
  "expires_in": 3600,
  "refresh_token": "Atzr|IQEBLzAtAhexamplewVz2Nn6f2y-tpJX2DeX"
}
```
3.  Your application saves the refresh_token value.

4.  The browser displays a page to the seller that indicates next steps for using your application.

An LWA refresh token is a long-lived token that you exchange for an LWA access token, which must be included in every request to the Selling Partner API. Once an access token is issued it is valid for one hour. The same access token can be used for multiple API calls, until it expires. See [Connecting to the Selling Partner API](#connecting-to-the-selling-partner-api).

Your application is now authorized to make calls to the Selling Partner API on the seller's behalf.

### For hybrid Selling Partner API applications

If an MWS auth token was returned in [Step 4. Amazon sends you the authorization information](#step-4-amazon-sends-you-the-authorization-information), your application is also authorized to make calls to Amazon Marketplace Web Service on the seller's behalf. For more information, see [Hybrid Selling Partner API applications](#hybrid-selling-partner-api-applications).

## Website workflow

The Website workflow is an OAuth authorization workflow that is initiated from your own website. Sellers sign into your website and click an “Authorize” button that you configure to initiate authorization. For more information, see [Step 0. Set up an "Authorize" button](#step-0.-set-up-an-authorize-button).

**Testing your authorization workflow**

Before creating a production Website workflow, you should test your authorization workflow while your application is in draft status. By testing you can ensure that your application can exchange parameters with Amazon and receive authorization information.

**To set up a test authorization workflow**

1.  Make sure that your application is in draft status.

2.  At [Step 0. Set up an "Authorize" button](#step-0.-set-up-an-authorize-button), when you construct one or more OAuth authorization URIs, add the version=beta parameter to the OAuth URI(s) to indicate that the workflow is for authorizing an application in draft status.

You are now ready to test your authorization workflow with a trusted seller who works with you. Alternatively, you can test the workflow yourself, using your own selling account credentials. Start at [Step 1. The seller initiates authorization from your website](#step-1.-the-seller-initiates-authorization-from-your-website).

When you have finished testing the authorization workflow you can convert it to a production workflow.

**To convert your test authorization workflow to a productions workflow**

1.  List your application in the Marketplace Appstore. This changes your application from draft status to published status.

    **Important.** Your application must be in published status for the Webstore authorization workflow to work.

2.  Remove the version=beta parameter from the OAuth authorization URI(s) that you constructed in [Step 0. Set up an "Authorize" button](#step-0.-set-up-an-authorize-button).

    Now any seller can authorize your published application starting at [Step 1. The seller initiates authorization from your website](#step-1.-the-seller-initiates-authorization-from-your-website).

**Steps**

[Step 0. Set up an "Authorize" button](#step-0-set-up-an-"authorize"-button)

[Step 1. The seller initiates authorization from your website](#Step-1-The-seller-initiates-authorization-from-your-website)

[Step 2. The seller consents to authorize the application](#Step-2-The-seller-consents-to-authorize-the-application)

[Step 3. Amazon sends you the authorization information](#Step-3-Amazon-sends-you-the-authorization-information)

[Step 4. Your application exchanges the LWA authorization code for a LWA refresh token](#Step-4-Your-application-exchanges-the-LWA-authorization-code-for-a-LWA-refresh-token)

### Step 0. Set up an "Authorize" button

Set up an “Authorize” button (or something similar) on your application website that the seller can click to initiate authorization of your application. When the seller clicks the button, your website loads an OAuth authorization URI into the browser and the seller is redirected to a Seller Central sign-in page. After sign-in, a consent page appears, where a seller can give your application consent to make calls to the Selling Partner API on their behalf. For information about constructing an OAuth authorization URI, see [OAuth authorization URIs](#oauth-authorization-uris).

**Note.** If you have OAuth authorization URIs for more than one region, be sure to set up your “Authorize” buttons so that sellers are redirected to the Seller Central sign-in page for their own region.

Setting up your “Authorize” button(s) is a one-time task.

### Step 1. The seller initiates authorization from your website

1.  The seller signs into your website. If the seller does not yet have an account, they complete your registration process.

2.  The seller clicks the "Authorize" button that you set up in [Step 0. Set up an "Authorize" button](#step-0.-set-up-an-authorize-button). If you have more than one regional "Authorize" button, be sure that the seller is directed to the button that corresponds to the region that they sell in.

3.  Your application loads the OAuth authorization URI into the browser, adding the following query parameter:

<table>
<thead>
<tr class="header">
<th><strong>Parameter</strong></th>
<th><strong>Description</strong></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td><strong>state</strong></td>
<td><p>A state value generated by your application. Your application uses this value to maintain state between this request and the response, helping to guard against cross-site request forgery attacks.</p>
<p><strong>Important:</strong> Because OAuth information is passed via URL query parameters, we highly recommended that you do the following: (1) Ensure that the state token is short-lived and verifiably unique to your user, and (2) Set the Referrer-Policy: no-referrer HTTP header, which prevents leaking sensitive information to websites that your website links to. For more information about cross-site request forgery and calculating a state parameter, see <a href="https://developer.amazon.com/docs/login-with-amazon/cross-site-request-forgery.html">Cross-site Request Forgery</a> in the Login with Amazon documentation.</p></td>
</tr>
</tbody>
</table>

**Note:** If you include the `version=beta` parameter, the workflow authorizes an application in Draft state. If you do not include the parameter, the workflow authorizes an application published on the Marketplace Appstore.

For example:
```
https://sellercentral.amazon.com/apps/authorize/consent?application_id=appidexample&state=stateexample&version=beta
```
OR
```
https://sellercentral.amazon.com/apps/authorize/consent?application_id=appidexample&state=stateexample
```
The seller arrives at the sign-in page of Seller Central.

### Step 2. The seller consents to authorize the application

1.  The seller signs into Seller Central. The consent page appears.

2.  The seller views the consent page, reviews the data access requested by your application, and then clicks the **Confirm** button to continue. The seller can click the **Cancel** button to exit without authorizing.

### Step 3. Amazon sends you the authorization information

Seller Central briefly displays a page indicating that Amazon is authorizing you to access the seller's data. While that page is displayed, the following actions take place:

1.  Amazon loads your OAuth Redirect URI into the browser (the first one you specified when you [registered you application](#Step-6-Register-your-application)), adding the following query parameters:

| **Parameter**| **Description**|
| ------------------------ | ---------------------- |
| **state** | The state value from [Step 1. The seller initiates authorization from](#step-1-the-seller-initiates-authorization-from-your-website) [your website](#step-1-the-seller-initiates-authorization-from-your-website). |
| **selling\_partner\_id** | The seller ID of the seller who is authorizing your application.    |
| **mws\_auth\_token**  | The **MWSAuthToken** value that you use when you create a query string for a call to Amazon Marketplace Web Service. The mws\_auth\_token parameter is only passed when the seller is authorizing a hybrid Selling Partner API (SP-API) application. Note that if you are the seller authorizing the hybrid SP-API application and the application owner (meaning you self-authorized your own Amazon MWS application) you will not receive the MWSAuthToken. For more information, see [Hybrid Selling Partner API applications](#hybrid-selling-partner-api-applications).|
| **spapi\_oauth\_code**   | The Login with Amazon (LWA) authorization code that you exchange for an LWA refresh token. For more information, see [Step 4. Your](#step-4-your-application-exchanges-the-lwa-authorization-code-for-a-lwa-refresh-token) [application exchanges the LWA authorization code for a LWA refresh](#step-4-your-application-exchanges-the-lwa-authorization-code-for-a-lwa-refresh-token) [token](#step-4-your-application-exchanges-the-lwa-authorization-code-for-a-lwa-refresh-token). |

For example:
````
https://client-example.com?state=state-example&mws_auth_token=mwsauthtokenexample&selling_partner_id=sellingpartneridexample&spapi_oauth_code=spapioauthcodeexample
````
2.  Your application validates the state value.

3.  Your application saves the selling_partner_id, mws_auth_token (if passed), and spapi_oauth_code values.

4.  Your website's landing page displays.

### Step 4. Your application exchanges the LWA authorization code for a LWA refresh token

The Login with Amazon SDK for JavaScript can help you with the exchange of an LWA authorization code for an LWA refresh token. For more information, see the Login with Amazon documentation.

  - [Add the Login with Amazon SDK for JavaScript](https://developer.amazon.com/docs/login-with-amazon/install-sdk-javascript.html)

  - [Authorization Code Grant](https://developer.amazon.com/docs/login-with-amazon/authorization-code-grant.html)

**To exchange an LWA authorization code for an LWA refresh token**

1.  Your application calls the Login with Amazon (LWA) authorization server (`https://api.amazon.com/auth/o2/token`) to exchange the LWA authorization code for an LWA refresh token. The call must include the following query parameters:

<table>
<thead>
<tr class="header">
<th><strong>Parameter</strong>
</th>
<th><strong>Description</strong></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td><strong>grant_type</strong></td>
<td>The type of access grant requested. Must be <em>authorization_code</em>.</td>
</tr>
<tr class="even">
<td><strong>code</strong></td>
<td>The LWA authorization code that you received in <a href="#step-3-amazon-sends-you-the-authorization-information">Step 3. Amazon sends you the authorization</a> <a href="#step-3-amazon-sends-you-the-authorization-information">information</a>.</td>
</tr>
<tr class="odd">
<td><strong>redirect_uri</strong></td>
<td>The redirect URI for your application.</td>
</tr>
<tr class="even">
<td><strong>client_id</strong></td>
<td>Part of your LWA credentials. To get this value, see <a href="#viewing-your-developer-information">Viewing your developer information</a>.</td>
</tr>
<tr class="odd">
<td><strong>client_secret</strong></td>
<td>Part of your LWA credentials. To get this value, see <a href="#viewing-your-developer-information">Viewing your developer information</a>.</td>
</tr>
</tbody>
</table>

For example:
```http
POST /auth/o2/token HTTP/l.l
Host: api.amazon.com
Content-Type: application/x-www-form-urlencoded;charset=UTF-8
grant_type=authorization_code&code=SplxlOexamplebYS6WxSbIA&client_id=foodev&client_secret=Y76SDl2F
```
2.  The LWA Authorization Server returns the LWA refresh token. The response is in JSON and includes the following elements.

| **Parameter**    | **Description**   |
| ---------------| -------- |
| **access_token**  | A token that authorizes your application to take certain actions on behalf of a seller. See [Connecting to the Selling Partner API](#connecting-to-the-selling-partner-api).         |
| **token_type**    | The type of token returned. Should be bearer.      |
| **expires_in**    | The number of seconds before the access token becomes invalid.   |
| **refresh_token** | A long-lived token that can be exchanged for a new access token. See [Connecting to the Selling Partner API](#connecting-to-the-selling-partner-api). |
```http
HTTP/l.l 200 OK
Content-Type: application/json;
charset UTF-8
Cache-Control: no-store
Pragma: no-cache
{
  "access_token":"Atza|IQEBLjAsAexampleHpi0U-Dme37rR6CuUpSR",
  "token_type":"bearer",
  "expires_in":3600,
  "refresh_token":"Atzr|IQEBLzAtAhexamplewVz2Nn6f2y-tpJX2DeX"
}
```
3.  Your application saves the refresh_token value.

4.  The browser displays a page to the seller that indicates next steps for using your application.

An LWA refresh token is a long-lived token that you exchange for an LWA access token, which must be included in every request to the Selling Partner API. Once an access token is issued it is valid for one hour. The same access token can be used for multiple API calls, until it expires. See [Connecting to the Selling Partner API](#connecting-to-the-selling-partner-api).

Your application is now authorized to make calls to the Selling Partner API on the seller's behalf.

**For hybrid Selling Partner API applications**

If an MWS auth token was returned in [Step 3. Amazon sends you the authorization information](#step-3-amazon-sends-you-the-authorization-information), your application is also authorized to make calls to Amazon Marketplace Web Service on the seller's behalf. For more information, see [Hybrid Selling Partner API applications](#hybrid-selling-partner-api-applications).

# Self authorization

You can self-authorize your application in Developer Central. Before doing this you must [register your application](#registering-your-application). You can self authorize your application in draft state; there is no reason to publish your self-authorized application to the Marketplace Appstore.

To implement the full OAuth authorization workflow, see [Authorizing Selling Partner API applications](#authorizing-selling-partner-api-applications).

**To self-authorize your application**
1. Sign into Seller Central using the credentials that you used to [register as a developer](#registering-as-a-developer).

2.  In the **Apps & Services** menu, click **Develop Apps**.

    The **Developer Central** page appears.

3.  Click **Edit** \> **Authorize** next to the application that you want to authorize.

    A page appears that contains a **Generate refresh token** button.

4.  Click **Generate refresh token**.

    The Login with Amazon (LWA) refresh token appears. If your selling account is linked to accounts from other regions, you will receive a separate refresh token for each region. Your application is now authorized to access your selling account(s).

    **Important:** Click **Generate refresh token** to get your refresh token. Generating a new refresh token does not invalidate previous refresh tokens.

The refresh token is a long-lived token that you exchange for a short-lived access token. An access token must be included with every request to the Selling Partner API. Once an access token is issued it is valid for one hour. The same access token can be used for multiple API calls, until it expires. For more information, see [Step 1. Request a Login with Amazon access token](#step-1-request-a-login-with-amazon-access-token)).

# Authorization with the Restricted Data Token

Operations that return restricted data (such as Personally Identifiable information, or PII) are considered restricted operations, and require special authorization in the form of a Restricted Data Token (RDT). You pass an RDT in the x-amz-access-token header when calling a restricted operation. This is in contrast to passing the LWA access token in the header, as you do with all other SP-API operations. For more information, see [Step 3. Add headers to the URI](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md#step-3-add-headers-to-the-uri) in the Developer Guide.

You can get an RDT by calling the [createRestrictedDataToken](https://github.com/amzn/selling-partner-api-docs/blob/main/references/tokens-api/tokens_2021-03-01.md#createrestricteddatatoken) operation of the Tokens API. See [Restricted operations](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/use-case-guides/tokens-api-use-case-guide/tokens-API-use-case-guide-2021-03-01.md#restricted-operations) of the Tokens API Use Case Guide for a list of restricted operations. The guide also contains instructions for getting an RDT and using it to authorize a call to a restricted operation.

# Generating a Java SDK with LWA token exchange and authentication

**Note to C\# developers**. We also provide a library for generating a C\# SDK with LWA token exchange and authentication. For more information, see README.md in https://github.com/amzn/selling-partner-api-models/tree/main/clients/sellingpartner-api-aa-csharp.

These instructions show you how to generate a Java SDK for the Sellers API using [Swagger Code Generator](https://github.com/swagger-api/swagger-codegen) on a computer running Microsoft Windows. The process is the same for users of other operating systems such as macOS or Linux, with the replacement of Windows-specific semantics (for example, C:\\). Although these instructions are for the Sellers API, you can modify the instructions to make SDKs for other APIs in the Selling Partner API. See <https://github.com/amzn/selling-partner-api-models> for Swagger models for each Selling Partner API section.

With this SDK you can make calls to the Sellers API with the following code already set up for you: Login with Amazon token exchange (exchange a refresh token for an access token) and authentication.

**To generate a Java SDK with LWA token exchange and authentication**

1.  <span id="Connecting_to_Selling_Partner_API_using_" class="anchor">Install [Java 8 or newer](https://www.oracle.com/technetwork/java/index.html), [Apache Maven 3.6. or greater](http://maven.apache.org/), and [GNU Wget](https://www.gnu.org/software/wget/wget.html) and make them available in your `$PATH`.

2.  Go to <https://github.com/amzn/selling-partner-api-models>.

3.  Clone the repository to make a local copy on your computer, if you haven't done so already.

4.  Open a command prompt window and go to a directory where you want to download the Swagger Code Generator.

5.  Download the latest version of the Swagger Code Generator.

    For example:
```bash
wget https://repo1.maven.org/maven2/io/swagger/swagger-codegen-cli/2.4.13/swagger-codegen-cli-2.4.13.jar -O swagger-codegen-cli.jar
```
**swagger-codegen-cli.jar** downloads to the current directory.

**Note:** You can also download from maven.org by directing your browser here: [https://repo1.maven.org/maven2/io/swagger/swagger-codegen-cli/2.4.13/swagger-codegen-cli-2.4.13.jar](https://repo1.maven.org/maven2/io/swagger/swagger-codegen-cli/2.4.13/swagger-codegen-cli-2.4.13.jar)

6.  Copy **swagger-codegen-cli.jar** into a directory structure that makes sense for you. For this example, we'll copy it to C:\\SwaggerToCL.

7.  Navigate to **sellers.json** in the **selling-partner-api-models\\models\\sellers-api-model** folder of your local copy of the repository.

8.  Copy **sellers.json** into C:\\SwaggerToCL.

9.  Generate the SDK against the templates in the **selling-partner-api-models\\clients\\sellingpartner-api-aa-java** folder of your local copy of the repository. This folder contains an authorization and authentication library, along with customized templates for the Swagger Code Generator.

    For example:
```bash
java -jar C:\SwaggerToCL\swagger-codegen-cli.jar generate -i C:\SwaggerToCL\Sellers.json -l java -t [path to selling-partner-api-models\clients\sellingpartner-api-aa-java folder]\resources\swagger-codegen\templates\ -o C:\SwaggerToCL\Sellers_JavaCL
```
The SDK is copied to C:\\SwaggerToCL\\Sellers_JavaCL

10. Build the AA Library and add it as a dependency of the SDK:
    
    1.  Navigate to the **selling-partner-api-models\\clients\\sellingpartner-api-aa-java** folder of your local copy of the repository and run mvn package. This generates a folder named "target". In this folder is a JAR file named **sellingpartnerapi-aa-java-1.0-jar-with-dependencies.jar** (or something similar) and all of the required dependencies.
    
    2.  Install the JAR file in your local Maven repository.

        For example:
```bash
mvn install:install-file -Dfile=[path to JAR file in "target" folder] -DgroupId=com.amazon.sellingpartnerapi -DartifactId=sellingpartnerapi-aa-java -Dversion=1.0 -Dpackaging=jar
```
You can find the actual groupId, artifactId, and version values near the top of the **pom.xml** file in the **selling-partner-api-models\\clients\\sellingpartner-api-aa-java** folder.

11.  Add a dependency on the AA library in the **pom.xml** of the client library:

    For example:
```xml
<dependency>
  <groupId>com.amazon.sellingpartnerapi</groupId>
  <artifactId>sellingpartnerapi-aa-java</artifactId>
  <version>1.0</version>
</dependency>
```

After you have generated your SDK you can use it to make calls to the Selling Partner API. See [Connecting to the Selling Partner API using a generated Java SDK](#connecting-to-the-selling-partner-api-using-a-generated-java-sdk).

# Connecting to the Selling Partner API using a generated Java SDK

Before your application can connect to the Selling Partner API, you must register it and it must be authorized by a seller. See [Registering your application](#registering-your-application) and [Authorizing Selling Partner API applications](#authorizing-selling-partner-api-applications).

These instructions show you how to use a generated Java SDK to make calls. The SDK exposes classes for configuring your LWA and AWS credentials and uses these to exchange LWA tokens and sign requests for you. For more information, see [Generating a Java SDK with LWA token exchange and authentication](#generating-a-java-sdk-with-lwa-token-exchange-and-authentication).

**Steps**

[Step 1. Configure your AWS credentials](#step-1-configure-your-aws-credentials)

[Step 2. Configure your AWS credentials provider](#step-2-Configure-your-AWS-credentials-provider)

[Step 3. Configure your LWA credentials](#step-3-configure-your-lwa-credentials)

[Step 4. Create an instance of the Sellers API and call an operation](#step-4-create-an-instance-of-the-sellers-api-and-call-an-operation)

## Step 1. Configure your AWS credentials

Create an instance of `AWSAuthenticationCredentials`, using the following parameters:

<table>
<thead>
<tr class="header">
<th><strong>Name</strong>
</th>
<th><strong>Description</strong>
</th>
<th><strong>Required</strong>
</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td><strong>accessKeyId</strong>
</td>
<td>Your AWS access key Id, from <a href="#step-2-create-an-iam-user">Step 2. Create an IAM user</a>.
</td>
<td>Yes
</td>
</tr>
<tr class="even">
<td><strong>secretKey</strong>
</td>
<td>Your AWS secret access key, from <a href="#step-2-create-an-iam-user">Step 2. Create an IAM user</a>.
</td>
<td>Yes
</td>
</tr>
<tr class="odd">
<td><strong>region</strong></td>
<td>The AWS region to which you are directing your call. For more information, see <a href="#selling-partner-api-endpoints">Selling Partner API endpoints</a>.</td>
<td>Yes</td>
</tr>
</tbody>
</table>

Example:
```
import com.amazon.SellingPartnerAPIAA.AWSAuthenticationCredentials;

AWSAuthenticationCredentials awsAuthenticationCredentials=AWSAuthenticationCredentials.builder()
  .accessKeyId("myAccessKeyId")
  .secretKey("mySecretId")
  .region("us-east-1")
  .build();
```

## Step 2. Configure your AWS credentials provider

Create an instance of `AWSAuthenticationCredentialsProvider`, using the following parameters:

<table>
<thead>
<tr class="header">
<th><strong>Name</strong>
</th>
<th><strong>Description</strong>
</th>
<th><strong>Required</strong>
</th>
</tr>
</thead>
<tbody>
<tr class="even">
<td><strong>roleArn</strong></td>
<td>The ARN of the IAM role that you created in <a href="#step-4-create-an-iam-role">Step 4. Create an IAM role</a>.</td>
<td>Yes</td>
</tr>
<tr class="odd">
<td><strong>roleSessionName</strong></td>
<td>An identifier for the session that you define. We recommend using a <a href="https://tools.ietf.org/html/rfc4122">Universally Unique Identifier</a> (UUID).</td>
<td>Yes</td>
</tr>
</tbody>
</table>

Example:
```
import com.amazon.SellingPartnerAPIAA.AWSAuthenticationCredentials;

AWSAuthenticationCredentialsProvider awsAuthenticationCredentialsProvider=AWSAuthenticationCredentialsProvider.builder()
  .roleArn("myroleARN")
  .roleSessionName("myrolesessioname")
  .build();
```

## Step 3. Configure your LWA credentials

Create an instance of `LWAAuthorizationCredentials`, using the following parameters:

<table>
<thead>
<tr class="header">
<th><strong>Name</strong></th>
<th><strong>Description</strong></th>
<th><strong>Required</strong></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td><strong>clientId</strong></td>
<td>Your LWA client identifier. For more information, see <a href="#viewing-your-developer-information">Viewing</a> <a href="#viewing-your-developer-information">your developer information</a>.</td>
<td>Yes</td>
</tr>
<tr class="even">
<td><strong>clientSecret</strong></td>
<td>Your LWA client secret. For more information, see <a href="#viewing-your-developer-information">Viewing your</a> <a href="#viewing-your-developer-information">developer information</a>.</td>
<td>Yes</td>
</tr>
<tr class="odd">
<td><strong>refreshToken</strong></td>
<td>The LWA refresh token. Get this value when the seller authorizes your application. For more information, see <a href="#authorizing-selling-partner-api-applications">Authorizing Selling</a> <a href="#authorizing-selling-partner-api-applications">Partner API applications</a>.</td>
<td><p>No. Include refreshToken if the operation that you call in the following step requires seller authorization. All operations that are not <a href="#grantless-operations">grantless operations</a> require seller authorization. If you include refreshToken, do not include withScopes.</p></td>
</tr>
<tr class="even">
<td><strong>withScopes</strong></td>
<td>
<p>The scope of the LWA authorization grant. You can specify one or more withScopes values.</p>
<p>Values:</p>
<ul>
<li>
<em>SCOPE_NOTIFICATIONS_API</em>. For the Notifications API.
</li>
<li><em>SCOPE_MIGRATION_API</em>. For the Authorization API.</li>
</ul>
</td>
<td>No. Include withScopes if the operation that you call in the following step is a <a href="#grantless-operations">grantless</a> <a href="#grantless-operations-1">operation</a>. If you include withScopes, do not include refreshToken.</td>
</tr>
<tr class="odd">
<td><strong>endpoint</strong></td>
<td>The LWA authentication server URI.</td>
<td>Yes</td>
</tr>
</tbody>
</table>

Example for calling operations that require seller authorization:
```
import com.amazon.SellingPartnerAPIAA.LWAAuthorizationCredentials;

LWAAuthorizationCredentials lwaAuthorizationCredentials = LWAAuthorizationCredentials.builder()
  .clientId("myClientId")
  .clientSecret("myClientSecret")
  .refreshToken("Aztr|...")
  .endpoint("https://api.amazon.com/auth/o2/token")
  .build();
```
Example for calling grantless operations:
```
import com.amazon.SellingPartnerAPIAA.LWAAuthorizationCredentials;
import static com.amazon.SellingPartnerAPIAA.ScopeConstants.SCOPE_NOTIFICATIONS_API;
import static com.amazon.SellingPartnerAPIAA.ScopeConstants.SCOPE_MIGRATION_API;

LWAAuthorizationCredentials lwaAuthorizationCredentials =
  LWAAuthorizationCredentials.builder()
  .clientId("myClientId")
  .clientSecret("myClientSecret")
  .withScopes(SCOPE_NOTIFICATIONS_API, SCOPE_MIGRATION_API)
  .endpoint("https://api.amazon.com/auth/o2/token")
  .build();
```
## Step 4. Create an instance of the Sellers API and call an operation

With your `AWSAuthenticationCredentials`, `AWSAuthenticationCredentialsProvider`, and `LWAAuthorizationCredentials` instances configured you can create an instance of SellersApi and call an operation.

Example:

```
SellersApi sellersApi = new SellersApi.Builder()
  .awsAuthenticationCredentials(awsAuthenticationCredentials)
  .lwaAuthorizationCredentials(lwaAuthorizationCredentials)
  .awsAuthenticationCredentialsProvider(awsAuthenticationCredentialsProvider)
  .endpoint("https://sellingpartnerapi-na.amazon.com")
  .build();
```

# Generating a Java client library

These instructions show you how to generate a Java client library for the Sellers API using [Swagger Code Generator](https://github.com/swagger-api/swagger-codegen) on a computer running Microsoft Windows. The process is the same for users of other operating systems such as macOS or Linux, with the replacement of Windows-specific semantics (for example, C:\\). Although these instructions are for the Sellers API, you can modify the instructions to make client libraries for other APIs in the Selling Partner API. See <https://github.com/amzn/selling-partner-api-models/tree/main/models> for Swagger models for each Selling Partner API section.

While a generated client library can help you make calls to the Selling Partner API, it does not contain code for LWA token exchange and authentication. For that, see [Step 1. Request a Login with Amazon access token](#step-1-request-a-login-with-amazon-access-token) and [Step 4. Create and](#step-4-create-and-sign-your-request) [sign your request](#step-4-create-and-sign-your-request). Or, for an SDK that includes LWA token exchange and authentication, see [Generating a Java SDK](#generating-a-java-sdk-with-lwa-token-exchange-and-authentication) [with LWA token exchange and authentication](#generating-a-java-sdk-with-lwa-token-exchange-and-authentication).

**To generate a Java client library**

1.  Install [Java 8 or newer](https://www.oracle.com/technetwork/java/index.html), [Apache Maven 3.6. or greater](http://maven.apache.org/), and [GNU Wget](https://www.gnu.org/software/wget/wget.html) and make them available in your $PATH.

    test

2.  Go to <https://github.com/amzn/selling-partner-api-models>.

3.  Clone the repository to make a local copy on your computer, if you haven't done so already.

4.  Open a command prompt window and navigate to a directory where you want to download the Swagger Code Generator.

5.  Download the latest version of the Swagger Code Generator.

    For example:
```
wget https://repo1.maven.org/maven2/io/swagger/swagger-codegen-cli/2.4.13/swagger-codegen-cli-2.4.13.jar -O swagger-codegen-cli.jar
```
**swagger-codegen-cli.jar** downloads to the current directory.

**Note:** You can also download from maven.org by directing your browser here: <https://repo1.maven.org/maven2/io/swagger/swagger-codegen-cli/2.4.13/swagger-codegen-cli-2.4.13.jar>

6.  Copy **swagger-codegen-cli.jar** into a directory structure that makes sense for you. For this example, we'll copy it to C:\\SwaggerToCL.

7.  Navigate to **sellers.json** in the **selling-partner-api-models\\models\\sellers-api-model** folder of your local copy of the repository.

8.  Copy **sellers.json** into C:\\SwaggerToCL.

9.  Generate the client Library.

    For example:
```
java -jar C:\SwaggerToCL\swagger-codegen-cli.jar generate -i C:\SwaggerToCL\Sellers.json -l java -o C:\SwaggerToCL\Sellers_JavaCL
```
The client library is copied to C:\\SwaggerToCL\\Sellers_JavaCL.

After you have generated your client library you can use it to help you make calls to the Selling Partner API. See [Connecting to Selling Partner API](#connecting-to-the-selling-partner-api).

# Connecting to the Selling Partner API

Before your application can connect to the Selling Partner API, you must register it and it must be authorized by a seller. See [Registering your application](#registering-your-application) and [Authorizing Selling Partner API applications](#authorizing-selling-partner-api-applications).

These instructions show you the steps for making a call to the Selling Partner API. For help with constructing a Selling Partner API URI and adding headers to it, see [Generating a Java client library](#Generating-a-Java-client-library). For a more complete solution that includes code for exchanging LWA tokens and authentication, see [Generating a Java SDK with LWA token exchange](#generating-a-java-sdk-with-lwa-token-exchange-and-authentication) [and authentication](#generating-a-java-sdk-with-lwa-token-exchange-and-authentication).

**Steps**

[Step 1. Request a Login with Amazon access token](#step-1-request-a-login-with-amazon-access-token)

[Step 2. Construct a Selling Partner API URI](#step-2-construct-a-selling-partner-api-uri)

[Step 3. Add headers to the URI](#step-3-add-headers-to-the-uri)

[Step 4. Create and sign your request](#step-4-create-and-sign-your-request)

## Step 1. Request a Login with Amazon access token

A Login with Amazon (LWA) access token authorizes your application to take certain actions on behalf of a seller. An LWA access token expires one hour after it is issued.

**Note about restricted operations.** An LWA access token must be included in calls to all operations *except* restricted operations, which return Personally Identifiable Information (PII). When calling restricted operations, instead of including an LWA access token, you include a Restricted Access Token (RDT). For information about getting RDTs and calling restricted operations, see [Tutorial: Get an RDT and call restricted operations](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/use-case-guides/tokens-api-use-case-guide/tokens-API-use-case-guide-2021-03-01.md#tutorial-get-an-rdt-and-call-restricted-operations) the Tokens API Use Case Guide.

To request an LWA access token, make a secure HTTP POST to the LWA authentication server (`https://api.amazon.com/auth/o2/token`) with the following parameters:

<table>
<thead>
<tr class="header">
<th><strong>Name</strong></th>
<th><strong>Description</strong></th>
<th><strong>Required</strong></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td><strong>grant_type</strong></td>
<td><p>The type of access grant requested. Values:</p>
<ul>
<li><p><em>refresh_token</em>. Use this for calling operations that require authorization from a seller. All operations that are not   <a href="#grantless-operations">grantless operations</a> require authorization from a seller. When specifying this value, include the <em>refresh_token</em> parameter.</p></li>
<li><p><em>client_credentials</em>. Use this for calling <a href="#grantless-operations">grantless operations</a>. When specifying this value, include the <code>scope</code> parameter.</p></li>
</ul></td>
<td>Yes</td>
</tr>
<tr class="even">
<td><strong>refresh_token</strong></td>
<td>The LWA refresh token. Get this value when the seller authorizes your application. For more information, see <a href="#authorizing-selling-partner-api-applications">Authorizing Selling Partner API applications</a>.</td>
<td>No. Include refresh_token for calling operations that require authorization from a seller. If you include refresh_token, do not include scope.</td>
</tr>
<tr class="odd">
<td><strong>scope</strong></td>
<td><p>The scope of the LWA authorization grant. Values:</p>
<ul>
<li><p><em>sellingpartnerapi::notifications</em>. For the Notifications API.</p></li>
<li><p><em>sellingpartnerapi::migration</em>. For the Authorization API.</p></li>
</ul></td>
<td>No. Include scope for calling a <a href="#grantless-operations">grantless operation</a>. If you include scope, do not include refresh_token.</td>
</tr>
<tr class="even">
<td><strong>client_id</strong></td>
<td>Get this value when you register your application. See <a href="#viewing-your-developer-information">Viewing your developer information</a>.</td>
<td>Yes</td>
</tr>
<tr class="odd">
<td><strong>client_secret</strong></td>
<td>Get this value when you register your application. See <a href="#viewing-your-developer-information">Viewing your developer information</a>.</td>
<td>Yes</td>
</tr>
</tbody>
</table>

Example for calling an operation that requires seller authorization:
```http
POST /auth/o2/token HTTP/l.l
Host: api.amazon.com
Content-Type: application/x-www-form-urlencoded;charset=UTF-8
grant_type=refresh_token
&refresh_token=Aztr|...
&client_id=foodev
&client_secret=Y76SDl2F
```
Example for calling a grantless operation:
```http
POST /auth/o2/token HTTP/l.l
Host: api.amazon.com
Content-Type: application/x-www-form-urlencoded;charset=UTF-8
grant_type=client_credentials
&scope=sellingpartnerapi::notifications
&client_id=foodev
&client_secret=Y76SDl2F
```
**Tip:** To avoid getting an untrusted certificate authority (CA) error when calling the LWA authorization server, be sure to update your trust store so that your application trusts the LWA authorization server.

**Response**

A successful response includes the following values.

| **Name**      | **Description**  |
| ------------------ | --- |
| **access_token**  | The LWA access token. Maximum size: 2048 bytes.   |
| **token_type**    | The type of token returned. Must be *bearer*. |
| **expires_in**    | The number of seconds before the LWA access token becomes invalid.  |
| **refresh_token** | The LWA access token that you submitted in the request. Maximum size: 2048 bytes. |
```http
HTTP/l.l 200 OK
Content-Type: application/json;charset UTF-8
Cache-Control: no-store
Pragma:no-cache
{
  "access_token":"Atza|IQEBLjAsAhRmHjNgHpi0U-Dme37rR6CuUpSREXAMPLE",
  "token_type":"bearer",
  "expires_in":3600,
  "refresh_token":"Atzr|IQEBLzAtAhRPpMJxdwVz2Nn6f2y-tpJX2DeXEXAMPLE"
}
```
For more information, visit the [Authorization Code Grant](https://developer.amazon.com/docs/login-with-amazon/authorization-code-grant.html) page in the Login with Amazon documentation.

## Step 2. Construct a Selling Partner API URI

Here are the components of a Selling Partner API URI.

| **Name**       | **Description**    | **Example**   |
| -------------- | ---------------------- | ------------ |
| HTTP method    | One of the [Selling Partner API HTTP methods](#selling-partner-api-http-methods). | `GET` |
| Endpoint | A [Selling Partner API endpoint](#Selling-Partner-API-endpoints). | `https://sellingpartnerapi-na.amazon.com` |
| Path   | The Selling Partner API section/version. number of the section/resource. | `/fba/inbound/v0/shipments/{shipmentId}/preorder/confirm` |
| Query string   | The query parameters.  | `?marketplace=ATVPDKIKX0DER`   |
| Path parameter | The path parameters  | `shipmentId1`  |

For example:
```http
PUT https://sellingpartnerapi-na.amazon.com/fba/inbound/v0/shipments/shipmentId1/preorder/confirm?MarketplaceId=ATVPDKIKX0DER&NeedByDate=2020-10-10
```
## Step 3. Add headers to the URI

Add headers to the URI that you constructed in [Step 2. Construct a Selling Partner API URI](#step-2-construct-a-selling-partner-api-uri). Here are the HTTP headers that you include in requests to the Selling Partner API:

**Request headers**

| **Name**     | **Description**  |
| ---------- | ---------------- |
| host  | The marketplace endpoint. See [Selling Partner API HTTP methods](#selling-partner-api-http-methods).   |
| x-amz-access-token | The LWA access token. See [Step 1. Request a Login with Amazon access token](#step-1-request-a-login-with-amazon-access-token).<br>**Note about restricted operations.** If you are calling a restricted operation, pass in a Restricted Data Token (RDT) here instead of an LWA access token. For information about getting RDTs and calling restricted operations, see the [Tutorial: Get an RDT and call restricted operations](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/use-case-guides/tokens-api-use-case-guide/tokens-API-use-case-guide-2021-03-01.md#tutorial-get-an-rdt-and-call-restricted-operations) in the Tokens API Use Case Guide. |
| x-amz-date   | The date and time of your request.    |
| user-agent    | Your application name and version number, platform, and programming language. These help Amazon diagnose and fix problems you might encounter with the service. See [Include a User-Agent header in all](#include-a-user-agent-header-in-all-requests) [requests](#include-a-user-agent-header-in-all-requests). |

Here is an example of a request to the Selling Partner API with URI and headers but no signing information:
```http
PUT /fba/inbound/v0/shipments/shipmentId1/preorder/confirm?MarketplaceId=ATVPDKIKX0DER&NeedByDate=2020-10-10 HTTP/1.1
host: sellingpartnerapi-na.amazon.com
user-agent: My Selling Tool/2.0 (Language=Java/1.8.0.221;
Platform=Windows/10)
x-amz-access-token=Atza|IQEBLjAsAhRmHjNgHpi0U-Dme37rR6CuUpSREXAMPLE
x-amz-date: 20190430T123600Z
```
To sign a request to the Selling Partner API, see [Step 4. Create and sign your request](#step-4-create-and-sign-your-request).

## Step 4. Create and sign your request

The Selling Partner API uses the AWS [Signature Version 4 Signing Process](https://docs.aws.amazon.com/general/latest/gr/signature-version-4.html) for authenticating requests. When you send HTTP requests to the Selling Partner API, you sign the requests so that Amazon can identify who sent them. You sign requests using your AWS access keys, which consists of an access key ID and a secret access key. Amazon recommends using the [AWS Security Token Service (AWS STS)](https://docs.aws.amazon.com/STS/latest/APIReference/welcome.html) to request temporary AWS access keys to sign your requests. See [Creating and configuring IAM policies and entities](#Creating-and-configuring-IAM-policies-and-entities) to create an IAM user (with an AWS STS policy attached) that assumes an IAM role. You then register your application using the IAM role. For more information about using AWS STS and the AWS SDKs that can help with your implementation, see [Requesting temporary security credentials](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_credentials_temp_request.html) in the AWS documentation.

**Note:** You need to learn how to sign HTTP requests only when you manually create them. When you use the one of the AWS SDKs to calculate signatures for you, the SDK automatically signs the requests with the AWS access key that you specify when you configure it. When you use an SDK you don't need to learn how to sign requests yourself. Java developers, for example, can use [AWS4Signer.java](https://github.com/aws/aws-sdk-java/blob/master/aws-java-sdk-core/src/main/java/com/amazonaws/auth/AWS4Signer.java) from the AWS SDK for Java as a model for calculating a signature. You can find SDKs for other languages in the [AWS GitHub repository](https://github.com/aws).

To create and sign your request, complete the following:

1.  Create a canonical request

    Follow the instructions in [Task 1: Create a Canonical Request for Signature Version 4](https://docs.aws.amazon.com/general/latest/gr/sigv4-create-canonical-request.html) in the AWS documentation, using this guidance:

      - See [Step 3. Add headers to the URI](#step-3-add-headers-to-the-uri) for an example of an unsigned request to start with when you create your canonical request.

      - Use SHA-256 for the hash algorithm.

      - Do not put authentication information in the query parameters. Put it in the `Authorization` header parameter. For information about using the `Authorization` header parameter for the authentication information, see [ Authorization header](#authorization-header).

2.  Create a string to sign

    Follow the instructions in [Task 2: Create a String to Sign for Signature Version 4](https://docs.aws.amazon.com/general/latest/gr/sigv4-create-string-to-sign.html) in the AWS documentation, using this guidance:

      - The algorithm designation value is `AWS4-HMAC-SHA256`

      - To determine the credential scope, see [Credential scope](#credential-scope).

3.  Calculate the signature

    Follow the instructions in [Task 3: Calculate the Signature for AWS Signature Version 4](https://docs.aws.amazon.com/general/latest/gr/sigv4-calculate-signature.html) in the AWS documentation.

    **Important:** See [Credential scope](#credential-scope) to help you complete this step.

4.  Add the signing information

    Follow the instructions in [Task 4: Add the Signature to the HTTP Request](https://docs.aws.amazon.com/general/latest/gr/sigv4-add-signature-to-request.html) in the AWS documentation, using this guidance:

      - Do not add signing information to the query string. Add it to the `Authorization` header parameter.

      - See [Authorization header](#authorization-header) for details about creating an `Authorization` header parameter.

    The following example shows what a request might look like after you've added the signing information to it using the Authorization header.
```http
PUT /fba/inbound/v0/shipments/shipmentId1/preorder/confirm?MarketplaceId=ATVPDKIKX0DER&NeedByDate=2020-10-10HTTP/1.1
Authorization: AWS4-HMAC-SHA256 Credential=AKIAIHV6HIXXXXXXX/20201022/us-east-1/execute-api/aws4_request, SignedHeaders=host;user-agent;x-amz-access-token,
Signature=5d672d79c15b13162d9279b0855cfba6789a8edb4c82c400e06b5924aEXAMPLE
host: sellingpartnerapi-na.amazon.com
user-agent: My Selling Tool/2.0 (Language=Java/1.8.0.221;
Platform=Windows/10)
x-amz-access-token=Atza|IQEBLjAsAhRmHjNgHpi0U-Dme37rR6CuUpSREXAMPLE
x-amz-date: 20190430T123600Z
```
### Credential scope

The credential scope is a component of the "string to sign" that you create when you sign a request to the Selling Partner API. See [Create and sign your request](#step-4-create-and-sign-your-request).

Credential scope is represented by a slash-separated string of dimensions, as shown in the following table:

| **Dimension**   | **Description**   | **Example**   |
| ----------- | ---- | ------------- |
| Date  | An eight-digit string representing the year (YYYY), month (MM), and day (DD) of the request.  | `20190430` |
| AWS region  | The region you are sending the request to. See [Selling Partner API endpoints](#Selling-Partner-API-endpoints). | `us-east-1` |
| Service  | The service you are requesting. You can find this value in the endpoint. See [Selling Partner API endpoints](#Selling-Partner-API-endpoints). | `execute-api` |
| Termination string | A special termination string. For AWS Signature Version 4, the value is aws4_request | `aws4_request` |

For example:
```
20190430/us-east-1/execute-api/aws4_request
```
**Important:** The date that you use as part of your credential scope must match the date of your request, as specified in the x-amz-date header. For more information, see [Handling Dates in Signature Version 4](https://docs.aws.amazon.com/general/latest/gr/sigv4-date-handling.html) in the AWS documentation.

For more information, see [Step 4. Create and sign your request](#step-4-create-and-sign-your-request).

### Authorization header

The Authorization header contains the signing information for a request. Although the header is named "Authorization", the signing information is used for authentication.

Here are the components of an Authorization header:

| **Component**                  | **Description**                                              |
| ------------------------------ | ------------------------------------------------------------ |
| The algorithm used for signing | The hash algorithm used throughout the signing process. The Selling Partner API requires SHA-256. You specify this in [Step 4. Create and sign your request](#step-4-create-and-sign-your-request). |
| Credential                     | Your AWS access key ID plus the [Credential scope](#credential-scope). You get your AWS access key ID in [Step 2. Create an IAM user](#step-2-create-an-iam-user). |
| SignedHeaders                  | A list of all the HTTP headers that you included with the signed request. For an example, see [Step 3. Add headers to the URI](#step-3-add-headers-to-the-uri). |
| Signature                      | The signature calculated in [Step 4. Create and sign your request](#step-4-create-and-sign-your-request). |

For example:

```
Authorization: AWS4-HMAC-SHA256 Credential=AKIAIHV6HIXXXXXXX/20201022/us-east-1/execute-api/aws4_request, SignedHeaders=host;user-agent;x-amz-access-token;x-amz-date, Signature=5d672d79c15b13162d9279b0855cfba6789a8edb4c82c400e06b5924aEXAMPLE
```
For more information, see [Step 4. Create and sign your request](#step-4-create-and-sign-your-request).

# Response format

In response to an HTTP request, the Selling Partner API returns response headers and a JSON response message.

**Response headers**

| **Name**         | **Description**                                                 |
| ---------------- | --------------------------------------------------------------- |
| Content-Length   | Standard HTTP response header.                                  |
| Content-Type     | Standard HTTP response header.                                  |
| Date             | Standard HTTP response header.                                  |
| x-amzn-RequestId | Request identifier. Include this if you contact us for support. |

### Success Response

If your request is successful, the Selling Partner API returns the data requested. Here is an example of a successful response:
```http
HTTP/1.1 200 OK
Content-Length: 368
Content-Type: application/json
Date: Thu, 01 Jun 2020 22:23:31 GMT
x-amzn-RequestId: 6875f61f-6aa1-11e8-98c6-9bExample
{
  "payload": {
    "ConfirmedNeedByDate": "2020-04-23",
    "ConfirmedFulfillableDate": "2020-04-23"
  }
}
```
### Error response

If your request is unsuccessful, the Selling Partner API returns an error response. Here are the elements of the response message in an error response:

**Response message**

| **Element** | **Description**                     | **Required** |
| ----------- | ----------------------------------- | ------------ |
| code        | HTTP status code.                   | Yes          |
| message     | Explanation of the error condition. | Yes          |
| details     | Link to additional information.     | No           |

Here is an example of an error response:
```http
HTTP/1.1 400 Bad Request
Content-Length: 117
Content-Type: application/json
Date: Fri, 01 Jun 2020 21:48:02 GMT
x-amzn-ErrorType: ValidationException
x-amzn-RequestId: a8c8d99a-6ab5-11e8-b0f8-19363980175b
{
  "errors": [
    {
      "message": "Access to requested resource is denied.",
      "code": "Unauthorized",
      "details": "Access token is missing in the request header."
    }
  ]
}
```

# Grantless operations

A grantless operation is an operation that you can call without explicit authorization from a selling partner. This means that when you [request a Login with Amazon access token](#step-1-request-a-login-with-amazon-access-token) prior to calling a grantless operation, you don't need to provide a refresh token. Instead, you use the **scope** parameter to provide the scope of the LWA authorization grant. If you use a generated Java SDK (see [Connecting to the Selling Partner API using a generated Java SDK](#Connecting-to-the-Selling-Partner-API-using-a-generated-Java-SDK)) to call grantless operations, use the **withScopes** parameter to set one or more scopes for the LWA authorization grant when you configure your LWA credentials.

See the following table for the grantless operations in the Selling Partner API.

**Grantless operations**

| **Operation name**   | **HTTP method and path**  |
| -------------------------- | -------------- |
| **createDestination**  | POST /notifications/v1/destinations |
| **deleteDestination**      | DELETE /notifications/v1/destinations/{destinationId}  |
| **deleteSubscriptionById** | DELETE /notifications/v2/subscriptions/{notificationType}/{subscriptionId} |
| **getDestination** | GET /notifications/v1/destinations/{destinationId}|
| **getDestinations** | GET /notifications/v1/destinations   |
| **getSubscriptionById** | GET /notifications/v1/subscriptions/{notificationType}/{subscriptionId} |
| **getAuthorizationCode** | GET /authorization/v1/authorizationCode  |

# Include a User-Agent header in all requests

A User-Agent header identifies your application, its version number, and the platform and programming language that you are using. You must include a User-Agent header with every request that you submit to the Selling Partner API.

Doing this helps Amazon to more effectively diagnose and fix problems, helping to improve your experience using the service.

To create a User-Agent header, begin with the name of your application, followed by a forward slash, followed by the version of the application, followed by a space, an opening parenthesis, the Language name/value pair, and a

closing parenthesis. The Language parameter is a required attribute, but you can add additional attributes separated by semicolons.

The following pseudocode illustrates a minimally acceptable User-Agent header:
```
AppId/AppVersionId (Language=LanguageNameAndOptionallyVersion)
```
The following is an example of a User-Agent header that might be used by an application integrator:
```
My Selling Tool/2.0 (Language=Java/1.8.0.221; Platform=Windows/10)
```
If you are a large seller who is integrating through your own IT department, consider creating a User-Agent header that contains the Host attribute, as in the following example. This can help an Amazon support engineer troubleshoot problems for you more effectively.
```
MyCompanyName/build1611 (Language=Perl; Host=jane.desktop.example.com)
```
To specify additional attributes, use the format AttributeName=Value;, separating each name/value pair with a semicolon. If you need to use a backslash (\\), quote it with another backslash (\\\\). Similarly, quote a forward slash in the application name (\\/), an opening parenthesis in the application version (\\(), an equal sign in the attribute name (\\=), and both a closing parenthesis (\\)), and a semicolon (\\;) in attribute values.

Because the User-Agent header is transmitted in every request, it is a good practice to limit the size of the header. The Selling Partner API will reject a User-Agent header if it is longer than 500 characters.

# Hybrid Selling Partner API applications

A hybrid Selling Partner API application is an application that can make calls both to the Selling Partner API and to Amazon Marketplace Web Service (Amazon MWS). Use a hybrid application when your solution requires functionality from both services. When a seller authorizes your hybrid Selling Partner API application, they are (1) authorizing your Amazon MWS developer ID to make calls to Amazon MWS on their behalf, and (2) authorizing the application to make calls to the Selling Partner API on their behalf.

Amazon considers a hybrid application to be a single application. For example, when you publish a hybrid application to the Marketplace Appstore, you manage it as a single application.

### Creating a hybrid Selling Partner API application

**To create a hybrid application**

1.  Publish your Amazon MWS application to the Marketplace Appstore. For information about publishing your application, see [Marketplace Appstore Listing Guide](https://docs.developer.amazonservices.com/en_US/dev_guide/DG_AppListingGuide.html) in the Amazon MWS documentation.

2.  Sign into Seller Central using the credentials that you used to [register as a developer](#registering-as-a-developer).

3.  In the **Apps & Services** menu, click **Develop Apps**.

    The **Developer Central** page appears.

4.  Next to your Amazon MWS application, on the **Edit app** menu, click **Edit app**.

5.  Follow the instructions to register your application.

After creating a hybrid application you can set up and test an OAuth authorization workflow. For more information, see [Authorizing Selling Partner API applications](#authorizing-selling-partner-api-applications).

### Migrating authorization from Amazon Marketplace Web Service

If a selling partner has authorized you to make calls to Amazon Marketplace Web Service on their behalf, you can use the Authorization API to migrate that authorization to a hybrid Selling Partner API application. This eliminates the need to request authorization from the selling partner again. For more information, see the Authorization API User Guide.

# The Selling Partner API sandbox

The Selling Partner API provides a sandbox environment that allows you to test your applications without affecting production data or triggering real-world events. Making sandbox calls to the Selling Partner API is identical to making production calls except you direct the calls to the [Selling Partner API sandbox endpoints](#selling-partner-api-sandbox-endpoints). Calling the sandbox endpoints returns static, mocked responses for all Selling Partner APIs. You can refer to these mocked responses in the Swagger model JSON file for the API that you want to call. For more information, see [How to make a sandbox call to the Selling Partner API](#how-to-make-a-sandbox-call-to-the-selling-partner-api).

The Selling Partner API sandbox works like many mocking frameworks, in that it uses pattern matching to return a specified response when the specified parameters are present. A developer receives a response defined in the `x-amazon-spds-sandbox-behaviors` object when they send a request that includes the specified parameters. Note that while the `x-amazon-spds-sandbox-behaviors` section contains the parameters that are needed to match a mock response, it does not necessarily contain all of the parameters that are required for a successful response. To get a successful response, be sure to that your request is valid and includes all required parameters as defined in the corresponding Swagger model.

**Important:** The sandbox is for testing functionality, not scalability testing. Calls to sandbox endpoints are subject to these throttling limits: **rate** = five requests per second; **burst** = 15. For more information about throttling see "Usage Plans and Rate Limits" in the Selling Partner API documentation.

## How to make a sandbox call to the Selling Partner API

### Step 1. Check the JSON file for request parameters

1.  Go to <https://github.com/amzn/selling-partner-api-models/tree/main/models>.

2.  Open the folder for the API for which you want to make a sandbox call.

3.  Click the Swagger model JSON file for the API that you want.

    The JSON code displays.

4.  Search the code for `x-amazon-spds-sandbox-behaviors`.

The `x-amazon-spds-sandbox-behaviors` objects of the JSON file contain request and response examples for sandbox calls to the API. If the request example contains parameters, use them in the following step.

### Step 2. Make a sandbox call to an API

Make a sandbox call to an API in the same way you would make a production call, with these differences:

1.  If the `x-amazon-spds-sandbox-behaviors` object of the Swagger model JSON file contains one or more parameters, include these in your call. If the API requires parameters in addition to those contained in the `x-amazon-spds-sandbox-behaviors` object, be sure to also include those required parameters in your call.

2.  Direct your call to one of the [selling Partner API sandbox endpoints](#selling-partner-api-sandbox-endpoints).

    You should receive a response that matches the payload object contained in the `x-amazon-spds-sandbox-behaviors` object of the JSON file.

## Selling Partner API sandbox endpoints

The Selling Partner API has sandbox endpoints for the North America, Europe, and Far East selling regions.

| **Selling region**                                           | **Endpoint**                                      | **AWS Region** |
| ------------------------------------------------------------ | ------------------------------------------------- | -------------- |
| North America (Canada, US, Mexico, and Brazil marketplaces)  | `https://sandbox.sellingpartnerapi-na.amazon.com` | us-east-1      |
| Europe (Spain, UK, France, Germany, Italy, Turkey, U.A.E, and India marketplaces) | `https://sandbox.sellingpartnerapi-eu.amazon.com` | eu-west-1      |
| Far East (Singapore, Australia, and Japan marketplaces)      | `https://sandbox.sellingpartnerapi-fe.amazon.com` | us-west-2      |

# How does the Selling Partner API differ from Amazon Marketplace Web Service?

Although the Selling Partner API and Amazon Marketplace Web Service (Amazon MWS) are both web services that enable programmatic access to seller data, there are significant differences. Here are some key differences between the Selling Partner API and Amazon MWS:

  - The Selling Partner API treats data as REST-compliant resources that can be accessed and modified via standard HTTP methods. By contrast, Amazon MWS exposes data using operations that are specific to Amazon MWS.

  - The Selling Partner API authorization leverages LWA, Amazon's implementation of OAuth 2.0. This model eliminates the need for the manual exchange of auth tokens, as required by Amazon MWS. See [Authorizing Selling Partner API applications](#Authorizing-Selling-Partner-API-applications).

  - With Amazon MWS, sellers authorize developers. With the Selling Partner API, sellers authorize applications. Using the Selling Partner API, developers can create multiple applications that require varying levels of access to seller data.

  - The Selling Partner API provides finer grain data access control than Amazon MWS. Developers can request access to only the data they need, and sellers can grant permissions at the API section, operation, or data resource level.

  - The Selling Partner API lets you directly procure and manage your own authentication credentials using AWS Identity and Access Management (IAM). With Amazon MWS, you receive authentication credentials provided by Amazon using a special registration workflow, and you get new credentials by opening a contact with Amazon MWS support. See [Step 2. Create an IAM user](#step-2-create-an-iam-user).

  - The Selling Partner API uses AWS Signature Version 4 for authentication. Amazon MWS uses Signature Version 2. See [ Step 4. Create and sign your request](#step-4-create-and-sign-your-request).
