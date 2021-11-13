# Selling Partner API Developer Guide

# Contents

- [About this guide](#about-this-guide)

  - [Terminology](#terminology)

- [What is the Selling Partner API?](#what-is-the-selling-partner-api)

  - [Key features](#key-features)

  - [Global applications](#global-applications)

- [Selling Partner API endpoints](#selling-partner-api-endpoints)

- [marketplaceId values](#marketplaceid-values)

- [Registering as a developer](#registering-as-a-developer)

  - [Checking the status of your request to register as a developer](#checking-the-status-of-your-request-to-register-as-a-developer)

- [Creating and configuring IAM policies and entities](#creating-and-configuring-iam-policies-and-entities)
  - [Step 1. Create an AWS account](#step-1-create-an-aws-account)
  
  - [Step 2. Create an IAM user](#step-2-create-an-iam-user)
  
  - [Step 3. Create an IAM policy](#step-3-create-an-iam-policy)
  
  - [Step 4. Create an IAM role](#step-4-create-an-iam-role)
  
  - [Step 5. Add an AWS Security Token Service policy to your IAM user](#step-5-add-an-aws-security-token-service-policy-to-your-iam-user)
  
- [Registering your application](#registering-your-application)

- [Updating your application information](#updating-your-application-information)

- [Viewing your application information and credentials](#viewing-your-application-information-and-credentials)

- [Authorizing Selling Partner API applications](#authorizing-selling-partner-api-applications)

  - [How is my application authorized?](#how-is-my-application-authorized)

  - [Constructing an OAuth authorization URI](#constructing-an-oauth-authorization-uri)

  - [Migrating authorization from Amazon Marketplace Web Service](#migrating-authorization-from-amazon-marketplace-web-service)

- [Amazon Seller Central Partner Network authorization workflow](#amazon-seller-central-partner-network-authorization-workflow)
  
  - [Step 1. The selling partner initiates authorization from the Amazon Seller Central Partner Network](#step-1-the-selling-partner-initiates-authorization-from-the-amazon-seller-central-partner-network)
  
  - [Step 2. The selling partner consents to authorize your application](#step-2-the-selling-partner-consents-to-authorize-your-application)
  
  - [Step 3. The selling partner signs into your website](#step-3-the-selling-partner-signs-into-your-website)
  
  - [Step 4. Amazon sends you the authorization information](#step-4-amazon-sends-you-the-authorization-information)
  
  - [Step 5. Your application exchanges the LWA authorization code for an LWA refresh token](#step-5-your-application-exchanges-the-lwa-authorization-code-for-an-lwa-refresh-token)
  
- [Website authorization workflow](#website-authorization-workflow)
  
  - [Step 0. Set up an "Authorize" button](#step-0-set-up-an-"authorize"-button)
  
  - [Step 1. The selling partner initiates authorization from your website](#step-1-the-selling-partner-initiates-authorization-from-your-website)
  
  - [Step 2. The selling partner consents to authorize the application](#step-2-the-selling-partner-consents-to-authorize-the-application)
  
  - [Step 3. Amazon sends you the authorization information](#step-3-amazon-sends-you-the-authorization-information)
  
  - [Step 4. Your application exchanges the LWA authorization code for a LWA refresh token](#step-4-your-application-exchanges-the-lwa-authorization-code-for-a-lwa-refresh-token)


- [Self authorization](#self-authorization)

- [Authorization with the Restricted Data Token](#authorization-with-the-restricted-data-token)

- [Generating a Java SDK with LWA token exchange and authentication](#generating-a-java-sdk-with-lwa-token-exchange-and-authentication)

- [Connecting to the Selling Partner API using a generated Java SDK](#connecting-to-the-selling-partner-api-using-a-generated-java-sdk)

  - [Step 1. Configure your AWS credentials](#step-1-configure-your-aws-credentials)

  - [Step 2. Configure your AWS credentials provider](#step-2-configure-your-aws-credentials-provider)

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

- [Grantless operations](#grantless-operations)

- [Include a User-Agent header in all requests](#include-a-user-agent-header-in-all-requests)

- [Hybrid Selling Partner API applications](#hybrid-selling-partner-api-applications)

  - [Creating a hybrid Selling Partner API application](#creating-a-hybrid-selling-partner-api-application)

- [The Selling Partner API sandbox](#the-selling-partner-api-sandbox)

  - [How to make a sandbox call to the Selling Partner API](#how-to-make-a-sandbox-call-to-the-selling-partner-api)

  - [Selling Partner API sandbox endpoints](#selling-partner-api-sandbox-endpoints)

- [How does the Selling Partner API differ from Amazon Marketplace Web Service?](#how-does-the-selling-partner-api-differ-from-amazon-marketplace-web-service)

- [About vendor groups](#about-vendor-groups)

  - [Using a single vendor group](#using-a-single-vendor-group)

  - [Using multiple vendor groups](#using-multiple-vendor-groups)

- [Vendor Central URLs](#vendor-central-urls)

- [Seller Central URLs](#seller-central-urls)

# About this guide

This guide is for developers who want to create applications for selling partners. That is, applications for sellers, vendors, or both. Sections in this guide that apply only to applications for sellers are marked, **For seller applications only**. Sections that apply only to applications for vendors are  marked, **For vendor applications only**. All other sections apply to all selling partner applications.

## Terminology

- **Selling partner.** A selling partner can be a seller or a vendor.

- **Seller.** A seller lists and sells their own goods on Amazon's retail website. After an item is sold, it is either (1) directly fulfilled by the seller using inventory managed by the seller, or (2) fulfilled through the Fulfillment by Amazon (FBA) program, using the seller's FBA inventory. 

- **Vendor.** A vendor supplies the inventory that is sold by Amazon on Amazon's retail website. There are two main types of vendors: Retail procurement vendors and Direct fulfillment vendors.

- **Retail procurement vendor.** A retail procurement vendor sells inventory to Amazon and ships it to Amazon's fulfillment centers. Amazon then sells and ships the inventory to customers who make purchases on Amazon's retail website. A retail procurement vendor can be a brand owner or a distributor. In some cases they manage the listings of the products that they supply to Amazon.

 - **Direct fulfillment vendors.** A direct fulfillment vendor ships orders to customers on Amazon's behalf. After a customer makes a purchase from Amazon on Amazon's retail website, the direct fulfillment vendor ships the order directly to the customer.

 - **Public application.** An application that is publicly available and is authorized by a selling partner.

 - **Private application.** An application that is available only to your organization and is self-authorized.

# What is the Selling Partner API?

The Selling Partner API is a REST-based API that helps Amazon selling partners programmatically access their data on orders, shipments, payments, and much more. Applications using the Selling Partner API can increase selling efficiency, reduce labor requirements, and improve response time to customers, helping selling partners grow their businesses.

## Key features

With the Selling Partner API, you can:

  - Set up an OAuth authorization workflow that selling partners initiate from the Amazon Seller Central Partner Network detail page or from your own website.

  - Generate an SDK that can help you with LWA token exchange and authentication.


  - Test your applications by making calls to a sandbox environment.

## Global applications

You only need to register as a developer once, in the region and marketplace of your choice, to be able to create a Selling Partner API application that can be authorized by a selling partner from any region or marketplace. You need only one set of developer credentials (your AWS access key ID and AWS secret access key) to make calls to any Selling Partner API endpoint, as long as the endpoint is for the same region as the selling partner who authorized your application.

**For seller applications only.** If you have a [hybrid Selling Partner API applications](#hybrid-selling-partner-api-applications), your calls to Amazon Marketplace Web Service (Amazon MWS) endpoints have the same restrictions as an Amazon MWS application. That is, when you call an Amazon MWS endpoint, you must use Amazon MWS Access Keys associated with the region that the endpoint comes from.

For more information, see [Selling Partner API endpoints](#Selling-Partner-API-endpoints).

# Selling Partner API endpoints

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
<td>Europe (Spain, UK, France, Netherlands, Germany, Italy, Sweden, Poland, Egypt, Turkey, United Arab Emirates, and India marketplaces)</td>
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

# marketplaceId values

The `marketplaceId` identifies the marketplace in a request.

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
| Egypt                | ARBP9OOSHTCHU     | EG               |
| Turkey               | A33AVAJ2PDY3EV    | TR               |
| Saudi Arabia         | A17E79C6D8DWNP    | SA               |
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



# Registering as a developer

You must register as a Selling Partner API developer before you can [register your Selling Partner API application](#Registering-your-application). The way you register as a developer varies slightly depending on the type of application that you create. For the purposes of registering as a developer, applications are grouped into three types: 

- **All public applications.** Applications that are publicly available and are authorized by a seller or by a vendor.

- **Private seller applications.** Applications for sellers that are available only to your organization, and are self-authorized. 

- **Private vendor applications.** Applications for vendors that are available only to your organization, and are self-authorized.

For more information, see [Terminology](#Terminology).

The following procedures show you how to register as a developer, depending on the type of application you want to create.

**To register as a developer (for all public applications)**

1.  Sign into Seller Central using the credentials that you want to associate with your developer account.

2.  In the **Partner Network** menu, click **Develop Apps**.

    The **Developer Central** page appears.

3. If you have not yet completed a developer profile for this selling account, click the **Proceed to Developer Profile** button. Otherwise click the **Your Developer Profile** link.

4. Complete the form. In the **Data Access** section, in the dropdown box, select **My organization builds and offers publicly available applications**.

**To register as a developer (for private seller applications)**

1.  Sign into Seller Central using the credentials that you want to associate with your developer account.

2.  In the **Partner Network** menu, click **Develop Apps**.

    The **Developer Central** page appears.

3. If you have not yet completed a developer profile for this selling account, click the **Proceed to Developer Profile** button. Otherwise click the **Your Developer Profile** link.

4. Complete the form. In the **Data Access** section, in the dropdown box, select **My organization sells on Amazon, and I only want to integrate to manage my own business only**.

**To register as a developer (for private vendor applications)**

1.  Go to Vendor Central for your marketplace. See [Vendor Central URLs](#vendor-central-urls) for a list of URLs by marketplace.

2.  Sign in using the credentials for the Vendor Central account with the vendor group that you want your application to access.

    For more information about vendor groups, see [About vendor groups](#About-vendor-groups).

3. In the **Integration** menu, click **API Integration**.

   The **Developer Central** page appears. 

3. If you have not yet completed a developer profile for this vendor account, click the **Proceed to Developer Profile** button. Otherwise click the **Your Developer Profile** link.

4. Complete the form. In the **Data Access** section, in the dropdown box, select **My organization sells on Amazon, and I only want to integrate to manage my own business only**.

For more information, see [Terminology](#Terminology).

## Checking the status of your request to register as a developer

After you have submitted your request to register as a developer, Amazon evaluates the information provided and approves or denies your request. If denied, you can address the reason for the denial and then resubmit your Developer Profile. The way you check the status of your request varies slightly depending on the type of the application. For the purposes of checking the status of your request to register as a developer, applications are grouped into two types:

- **All public applications and private seller applications.** These are: (1) Applications that are publicly available and are authorized by a seller or by a vendor,  and (2) seller applications that are available only to your organization, and are self-authorized.

- **Private vendor applications.** Vendor applications that are available only to your organization, and are self-authorized.

For more information, see [Terminology](#Terminology).

The following procedures show you how to check the status of your request to register as a developer, depending on the type of application you want to create.

**To check the status of your request (for all public applications and private seller applications)**

1. Sign into Seller Central with the credentials that you used when you [registered as a developer](#registering-as-a-developer).

2.  In the **Partner Network** menu, click **Develop Apps**.

    The **Developer Central** page appears.

3. Follow the instructions in the **Your developer registration is under review** banner. The banner will change to reflect the status of your application.

**To check the status of your request (for private vendor applications)**

1. Sign into Vendor Central with the credentials that you used when you [registered as a developer](#registering-as-a-developer).

2. In the **Integration** menu, click **API Integration**.

   The **Developer Central** page appears. 

3. Follow the instructions in the **Your developer registration is under review** banner. The banner will change to reflect the status of your application.

After we have registered you as a developer, you can [Create and configuring IAM policies and entities](#Creating-and-configuring-IAM-policies-and-entities). To view your developer information, see [Viewing your application information and credentials](#viewing-your-application-information-and-credentials).

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

9.  Click **Close**.

10. In the **User name** column, click your new IAM user and make a note of the User ARN. You will need it in [Step 4. Create an IAM role](#step-4-create-an-iam-role).

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

Before you register your application, [create and configure your IAM policies and entities](#Creating-and-configuring-IAM-policies-and-entities). The way you register your application varies slightly depending on the application type. For the purposes of registering your application, applications are grouped into two types:

- **All public applications and private seller applications.** These are: (1) Applications that are publicly available and are authorized by a seller or by a vendor,  and (2) seller applications that are available only to your organization, and are self-authorized.

- **Private vendor applications.** Vendor applications that are available only to your organization, and are self-authorized.

For more information, see [Terminology](#Terminology).

The following procedures show you how to register your application, depending on the application type.

**To register your application (for all public applications and private seller applications)**

1.  Sign into Seller Central using the credentials that you used to [register as a developer](#registering-as-a-developer).

2.  In the **Partner Network** menu, click **Develop Apps**.

    The **Developer Central** page appears.

3.  Click the **Add new app client** button.

    The **App registration** page appears. 

4. Complete the form.

    **Note.** If you are registering a public application, a **Sellers** check box and a **Vendors** check box appear after you choose the API type. Select **Sellers**, **Vendors**, or both, depending on the type of selling partner your application is for. The list of roles for which you can apply vary depending on your selection.

**To register your application (for private vendor applications)**

1. Sign into Vendor Central with the credentials that you used to [register as a developer](#registering-as-a-developer).

2. In the **Integration** menu, click **API Integration**.

   The **Developer Central** page appears. 

3.  Click the **Add new app client** button.

    The **App registration** page appears. 

4. Complete the form.

**Important.** When registering your application, the IAM ARN that you provide must be for the IAM entity to which you attached the IAM policy from  [Step 3. Create an IAM policy](#Step-3-Create-an-IAM-policy). In this workflow, that IAM entity is the IAM role from [Step 4. Create an IAM role](#Step-4-Create-an-IAM-role). If you register your application using your IAM user, be sure that the IAM policy is attached to it. Otherwise your calls to the Selling Partner API will fail. We recommend registering your application using an IAM role, as shown in this workflow, to help you better control access to your AWS resources.

# Updating your application information

After you [register your application](#registering-your-application), you might find that you later want to update your application information. For example, you might want to change the IAM ARN associated with your application or add another OAuth redirect URI. 

**Note.** When you update the IAM ARN for your application, both the old IAM ARN and the new IAM ARN are in effect for 14 days. This gives you time to update your authorization workflow for the new IAM ARN. After 14 days, the old IAM ARN expires.

The way you update your application information varies slightly depending on the application type. For the purposes of updating your application information, applications are grouped into two types:

- **All public applications and private seller applications.** These are: (1) Applications that are publicly available and are authorized by a seller or by a vendor,  and (2) seller applications that are available only to your organization, and are self-authorized.

- **Private vendor applications.** Vendor applications that are available only to your organization, and are self-authorized.

For more information, see [Terminology](#terminology).

**To update your application information (for all public applications and private seller applications)**

1.  Sign into Seller Central using the credentials that you used to [register as a developer](#registering-as-a-developer).

2.  In the **Partner Network** menu, click **Develop Apps**.

    The **Developer Central** page appears.

3. Click the **Edit app** button next to the application that you want to update the information for.

    The **App registration** page appears.

4. Edit the values on the page that you want to update, and then click **Save and exit**.

**To update your application information (for private vendor applications)**

1. Sign into Vendor Central with the credentials that you used to [register as a developer](#registering-as-a-developer).

2. In the **Integration** menu, click **API Integration**.

   The **Developer Central** page appears. 

3. Click the **Edit app** button next to the application that you want to update the information for.

    The **App registration** page appears.

4. Edit the values on the page that you want to update, and then click **Save and exit**.

# Viewing your application information and credentials

After you [register your application](#registering-your-application) you can view information about your application, as well as your Login with Amazon (LWA) credentials. The way you view this information varies slightly depending on the application type. For the purposes of viewing your application information and credentials, applications are grouped into two types:

- **All public applications and private seller applications.** These are: (1) Applications that are publicly available and are authorized by a seller or by a vendor,  and (2) seller applications that are available only to your organization, and are self-authorized.

- **Private vendor applications.** Vendor applications that are available only to your organization, and are self-authorized.

For more information, see [Terminology](#Terminology).

The following procedures show you how to view your application information and credentials, depending on the application type.

**To view your application information and credentials (for private seller applications and for public applications for any type of selling partner)**

1.  Sign into Seller Central using the credentials that you used to [register as a developer](#registering-as-a-developer).

2.  In the **Partner Network** menu, click **Develop Apps**.

    The **Developer Central** page displays information about your application(s), including the IAM ARN associated with them.

3.  Click **View** under **LWA credentials** for the application you want.

    Your LWA client identifier and client secret for that application appear. You will need these credentials to request an LWA access token. For more information, see [Step 1. Request a Login with Amazon access token](#step-1-request-a-login-with-amazon-access-token).

**To view your application information and credentials (for private vendor applications)**

1. Sign into Vendor Central with the credentials that you used when you [registered as a developer](#registering-as-a-developer).

2. In the **Integration** menu, click **API Integration**.

    The **Developer Central** page displays information about your application(s), including the IAM ARN associated with them.

3.  Click **View** under **LWA credentials** for the application you want.

    Your LWA client identifier and client secret for that application appear. You will need these credentials to request an LWA access token. For more information, see [Step 1. Request a Login with Amazon access token](#step-1-request-a-login-with-amazon-access-token).

# Authorizing Selling Partner API applications

The authorization model for the Selling Partner API is based on [Login with Amazon](https://developer.amazon.com/docs/login-with-amazon/documentation-overview.html), Amazon's implementation of OAuth 2.0. In this model the selling partner authorizes your application by interacting with pages displayed by Amazon and by your website. Actions taken by the selling partner trigger responses by your website or by Amazon. The selling partner's browser is the user-agent that passes parameters between your website and Amazon at each selling partner action. To implement OAuth authorization you must configure your website to (1) accept and process the parameters that Amazon passes to it, and (2) redirect the selling partner’s browser and pass parameters to Amazon.

## How is my application authorized?

The way your applications are authorized depends on the application type. Here are applications types grouped by how they are authorized:

- **Public applications for sellers.** Applications that are publicly available and are authorized by sellers. These applications can be authorized using the following methods:
  - [Amazon Seller Central Partner Network authorization workflow.](#amazon-seller-central-partner-network-authorization-workflow) An OAuth authorization workflow initiated from the Amazon Seller Central Partner Network detail page.
  - [Website authorization workflow.](#Website-authorization-workflow) An OAuth authorization workflow initiated from your own website.

- **Public applications for vendors.** Applications that are publicly available and are authorized by vendors. These applications can be authorized using the following method:
  - [Website authorization workflow.](#Website-authorization-workflow) An OAuth authorization workflow initiated from your own website.

- **Private applications for sellers or vendors.** Applications that are available only to your organization. These can be seller or vendor applications. These applications can be authorized using the following method:
  - [Self authorization.](#Self-authorization) A self-authorization procedure.

**Note.** You can call [Grantless operations](#grantless-operations) without explicit authorization from a selling partner.

For more information, see [Terminology](#Terminology).

## Constructing an OAuth authorization URI

An OAuth authorization URI is a key component for creating and testing Selling Partner API authorization workflows. The OAuth authorization URI redirects a browser to an Amazon consent page, where a selling partner can give your application consent to make calls to the Selling Partner API on their behalf. If the selling partner is not signed into Seller Central (for sellers) or Vendor Central (for vendors), a sign-in page appears first. 

If a selling partner authorizes your application starting from your own website (the [Website authorization workflow](#website-authorization-workflow)) your website uses an OAuth authorization URI to redirect the selling partner to the Amazon consent page. Even if a selling partner authorizes your application starting from the Amazon Seller Central Partner Network (the [Amazon Seller Central Partner Network authorization workflow](#amazon-seller-central-partner-network-authorization-workflow)), you still need an OAuth authorization URI to test your authorization workflow in draft status before creating a live listing in the Amazon Seller Central Partner Network.

For the purposes of constructing an OAuth authorization URI, applications are grouped into two types:

- **All public applications and private seller applications.** This can be: (1) Applications that are publicly available and are authorized by a seller or by a vendor,  and (2) Seller applications that are available only to your organization, and are self-authorized.

- **Private vendor applications.** Vendor applications that are available only to your organization, and are self-authorized.

For more information, see [Terminology](#Terminology).

The following procedures show you how to construct an OAuth authorization URI, depending on the application type:

**To construct an OAuth authorization URI (for all public applications and private seller applications)**

1.  Get the Seller Central URL for the marketplace where you want selling partners to authorize your application. See [Seller Central URLs](#seller-central-urls) for a list of URLs by marketplace. Example: `https://sellercentral.amazon.com`

2.  Combine the Seller Central URL with `/apps/authorize/consent?application_id={your application ID}`.

    Example: `https://sellercentral.amazon.com/apps/authorize/consent?application_id=amzn1.sellerapps.app.0bf296b5-36a6-4942-a13e-EXAMPLEfcd28`

**To construct an OAuth authorization URI (for private vendor applications)**

1.  Get the Vendor Central URL for the marketplace where you want selling partners to authorize your application. See [Vendor Central URLs](#vendor-central-urls) for a list of URLs by marketplace. Example: `https://vendorcentral.amazon.com`

2.  Combine the Vendor Central URL with `/apps/authorize/consent?{your application ID}`.

    Example: `https://vendorcentral.amazon.com/apps/authorize/consent?application_id=amzn1.sellerapps.app.0bf296b5-36a6-4942-a13e-EXAMPLEfcd28`

You need to construct OAuth authorization URIs for the marketplaces in which selling partners will authorize your application. For example, if a seller has a Seller Central account for Mexico, they will need an OAuth authorization URI for Mexico (example: `https://sellercentral.amazon.com.mx/apps/authorize/consent?application_id=amzn1.sellerapps.app.0bf296b5-36a6-4942-a13e-EXAMPLEfcd28`) to initiate authorization of your application. Authorizations are regional, so when the authorization is complete your application will have access to the seller's account in any marketplace in the North America region. The same concepts apply to vendors using Vendor Central.

If you are creating an OAuth authorization URI for testing your authorization workflow, add the version=beta parameter. This indicates that the authorization workflow is for an application in draft status. Example: `https://sellercentral-europe.amazon.com/apps/authorize/consent?application_id=amzn1.sellerapps.app.0bf296b5-36a6-4942-a13e-EXAMPLEfcd28&version=beta`

For information about creating and testing an authorization workflow, see [Amazon Seller Central Partner Network authorization workflow](#amazon-seller-central-partner-network-authorization-workflow) and [Website authorization workflow](#website-authorization-workflow).

## Migrating authorization from Amazon Marketplace Web Service

**For seller applications only.**

If a seller has authorized you to make calls to Amazon Marketplace Web Service on their behalf, you can use the Authorization API to migrate that authorization to a [hybrid Selling Partner API application](#Hybrid-Selling-Partner-API-applications). This eliminates the need to request authorization from this seller for your hybrid SP-API application.

**Note.** Authorizations of a hybrid SP-API application expire after one year. Be sure to have your selling partners reauthorize your SP-API hybrid application yearly before their authorizations expire. 

For more information, see the [Authorization API Use Case Guide](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/use-case-guides/authorization-api-use-case-guide/authorization-api-use-case-guide-v1.md).

# Amazon Seller Central Partner Network authorization workflow

**For seller applications only**

The Amazon Seller Central Partner Network (Amazon SCPN) authorization workflow is an OAuth authorization workflow that the selling partner initiates from the Amazon SCPN detail page. When you list a Selling Partner API application on the Amazon SCPN, selling partners can authorize your application by clicking an **Authorize Now** button on the detail page.

**Testing your authorization workflow**

Before listing your application on the Amazon SCPN, you should test your authorization workflow while your application is in draft status. Your test workflow won’t be exactly the same as the final production workflow, but you'll be able to ensure that your application can exchange parameters with Amazon and receive authorization information.

**To set up a test authorization workflow**

1.  Make sure that your application in draft status.

2.  Construct one or more OAuth authorization URIs for testing purposes. Include the `version=beta` parameter in the OAuth URI(s) to indicate that the workflow is for authorizing an application in draft status. For more information, see [Constructing an OAuth authorization URI](#constructing-an-oauth-authorization-uri).

3.  At [Step 3. The selling partner signs into your website](#Step-3-The-selling-partner-signs-into-your-website), be sure that your workflow adds the `version=beta` parameter to the Amazon callback URI to indicate that the workflow is for authorizing an application in draft status.

You are now ready to test your authorization workflow with a trusted selling partner who works with you. Alternatively, you can test the workflow yourself, using your own selling account credentials. Instead of starting at [Step 1. The selling partner initiates authorization from the Amazon Seller Central Partner Network](#step-1-the-selling-partner-initiates-authorization-from-the-amazon-seller-central-partner-network), the selling partner starts the test workflow by navigating to an OAuth authorization URI that you constructed previously.

**Note:** If you have more than one regional OAuth authorization URI, be sure give the selling partner the OAuth authorization URI that corresponds to the region that they operate in.

When you have finished testing the authorization workflow you can convert it to a production workflow.

**To convert your test authorization workflow to a productions workflow**

1.  List your application in the Amazon SCPN. This changes your application from draft status to published status.

2.  Update your workflow so that it no longer adds the `version=beta` parameter to the Amazon callback URI in [Step 3. The selling partner signs into your website](#Step-3-The-selling-partner-signs-into-your-website).

    Now any selling partner can authorize your published application starting at [Step 1. The selling partner initiates authorization from the Amazon Seller Central Partner Network](#step-1-the-selling-partner-initiates-authorization-from-the-amazon-seller-central-partner-network).

**Steps**

[Step 1. The selling partner initiates authorization from the Amazon Seller Central Partner Network](#step-1-the-selling-partner-initiates-authorization-from-the-amazon-seller-central-partner-network)

[Step 2. The selling partner consents to authorize your application](#step-2-the-selling-partner-consents-to-authorize-your-application)

[Step 3. The selling partner signs into your website](#step-3-the-selling-partner-signs-into-your-website)

[Step 4. Amazon sends you the authorization information](#step-4-amazon-sends-you-the-authorization-information)

[Step 5. Your application exchanges the LWA authorization code for an LWA refresh token](#step-5-your-application-exchanges-the-lwa-authorization-code-for-an-lwa-refresh-token)

## Step 1. The selling partner initiates authorization from the Amazon Seller Central Partner Network

1.  The selling partner signs into Seller Central and goes to the Amazon Seller Central Partner Network (Amazon SCPN).

2.  The selling partner goes to the detail page for your application and clicks the **Authorize Now** button. The consent page for your application appears.

## Step 2. The selling partner consents to authorize your application

1.  The selling partner views the consent page, reviews and accepts the data access requested by your application, and then clicks the **Login to \[your application name\] now** button to continue. The selling partner can click the **Cancel** button to exit without authorizing.

2.  Amazon loads your Login URI (which you provided at application registration) into the browser, adding the following query parameters:

| **Parameter**             | **Description**     |
| ------------------------- | ------------------  |
| **amazon_callback_uri** | A URI for redirecting the browser to Amazon.   |
| **amazon_state**         | A state value generated by Amazon to guard against cross-site request forgery attacks.    |
| **selling_partner_id**  | The identifier of the selling partner who is authorizing your application.     |

**Note:** If this a test workflow (the selling partner started by navigating to your OAuth authorization URI) Amazon includes the `version=beta` parameter. If this is a production workflow (the selling partner started from the Amazon SCPN), Amazon does not include the parameter.

For example:
```
https://d2yzyfnnpjylxu.cloudfront.net/index.html?amazon_callback_uri=https://amazon.com/apps/authorize/confirm/amzn1.sellerapps.app.2eca283f-9f5a-4d13-b16c-474EXAMPLE57&amazon_state=amazonstateexample&selling_partner_id=A3FHEXAMPLEYWS
```
Your website's sign-in page appears.

## Step 3. The selling partner signs into your website

1.  The selling partner signs into your website. If the selling partner does not yet have an account, they complete your registration process.

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
<td>A URI for redirecting the browser to your application. This must an OAuth Redirect URI that you specified when you <a href="#registering-your-application">registered your application</a>. If you do not include the <strong>redirect_uri</strong> parameter, the default is the first OAuth Redirect URI that you specified when you registered your application.<p>Optional</p></td>
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

**Note:** If you include the `version=beta` parameter, the workflow authorizes an application in Draft state. If you do not include the parameter, the workflow authorizes an application published on the Amazon Seller Central Partner Network.

For example:
```
https://amazon.com/apps/authorize/confirm/amzn1.sellerapps.app.2eca283f-9f5a-4d13-b16c-474EXAMPLE57?redirect_uri=https://d2yzyfnnpjylxu.cloudfront.net/landing.html&amazon_state=amazonstateexample&state=-37131022&version=beta
```
OR
```
https://amazon.com/apps/authorize/confirm/amzn1.sellerapps.app.2eca283f-9f5a-4d13-b16c-474EXAMPLE57?redirect_uri=https://d2yzyfnnpjylxu.cloudfront.net/landing.html&amazon_state=amazonstateexample&state=-37131022
```
## Step 4. Amazon sends you the authorization information

Seller Central briefly displays a page indicating that Amazon is authorizing you to access the selling partner's data. While this page is displayed, the following actions take place:

1.  Amazon loads your OAuth Redirect URI into the browser (the first one you specified when you [registered you application](#Registering-your-application)), adding the following query parameters:

| **Parameter**| **Description**|
| ------------------------ | -----------------------|
| **state**  | The state value that you passed in the previous step.  |
| **selling_partner_id** | The identifier of the selling partner who is authorizing your application. |
| **mws_auth_token**  |  The **MWSAuthToken** value that you use when you create a query string for a call to Amazon Marketplace Web Service. The mws\_auth\_token parameter is only passed when the selling partner is authorizing a hybrid Selling Partner API (SP-API) application. Note that if you are the selling partner authorizing the hybrid SP-API application and the application owner (meaning you self-authorized your own Amazon MWS application) you will not receive the MWSAuthToken. For more information, see [Hybrid Selling Partner API applications](#hybrid-selling-partner-api-applications).|
| **spapi_oauth_code**   | The Login with Amazon (LWA) authorization code that you exchange for an LWA refresh token. For more information, see [Step 5. Your application exchanges the LWA authorization code for an LWA refresh token](#step-5-your-application-exchanges-the-lwa-authorization-code-for-an-lwa-refresh-token).<br/>**Note:** An LWA authorization code expires after five minutes. Be sure to exchange it for an LWA refresh token before it expires.|

   For example:
```
https://client-example.com?state=state-example&mws_auth_token=mwsauthtokenexample&selling_partner_id=sellingpartneridexample&spapi_oauth_code=spapioauthcodeexample
```
2.  Your application validates the state value.

3.  Your application saves the `selling_partner_id`, `mws_auth_token` (if passed), and `spapi_oauth_code` values.

4.  Your website's landing page displays.

## Step 5. Your application exchanges the LWA authorization code for an LWA refresh token

The Login with Amazon SDK for JavaScript can help you with the exchange of an LWA authorization code for an LWA refresh token.

**Note:** An LWA authorization code expires after five minutes. Be sure to exchange it for an LWA refresh token before it expires.

For more information, see the Login with Amazon documentation:

  - [Add the Login with Amazon SDK for JavaScript](https://developer.amazon.com/docs/login-with-amazon/install-sdk-javascript.html)

  - [Authorization Code Grant](https://developer.amazon.com/docs/login-with-amazon/authorization-code-grant.html)

**To exchange an LWA authorization code for an LWA refresh token**

1.  Your application calls the Login with Amazon (LWA) authorization server (`https://api.amazon.com/auth/o2/token`) to exchange the LWA authorization code for an LWA refresh token. The call must include the following query parameters:

| **Parameter**      | **Description**   |
| ------------------ | --------- |
| **grant_type**    | The type of access grant requested. Must be *authorization_code*. |
| **code**    | The LWA authorization code that you received in [Step 4. Amazon sends you the authorization information](#step-4-amazon-sends-you-the-authorization-information). |
| **redirect_uri**  | The redirect URI for your application.  |
| **client_id**     | Part of your LWA credentials. To get this value, see [Viewing your application information and credentials](#viewing-your-application-information-and-credentials).  |
| **client_secret** | Part of your LWA credentials. To get this value, see [Viewing your application information and credentials](#viewing-your-application-information-and-credentials).  |

For example:
```plain
POST /auth/o2/token HTTP/l.l
Host: api.amazon.com
Content-Type: application/x-www-form-urlencoded;charset=UTF-8
grant_type=authorization_code&code=SplxlOexamplebYS6WxSbIA&client_id=foodev&client_secret=Y76SDl2F
```
2.  The LWA Authorization Server returns the LWA refresh token. The response is in JSON and includes the following elements.

| **Parameter**      | **Description**                                                                                                                                                                      |
| ------------------ | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ |
| **access_token**  | A token that authorizes your application to take certain actions on behalf of a selling partner. See [Connecting to the Selling Partner API](#connecting-to-the-selling-partner-api).         |
| **token_type**    | The type of token returned. Should be bearer.   |
| **expires_in**    | The number of seconds before the access token becomes invalid.  |
| **refresh_token** | A long-lived token that can be exchanged for a new access token. See [Connecting to the Selling Partner API](#connecting-to-the-selling-partner-api). |
```plain
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
3.  Your application saves the `refresh_token` value.

4.  The browser displays a page to the selling partner that indicates next steps for using your application.

An LWA refresh token is a long-lived token that you exchange for an LWA access token. An access token obtained through this token exchange must be included with calls to all Selling Partner API operations except [restricted operations](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/use-case-guides/tokens-api-use-case-guide/tokens-API-use-case-guide-2021-03-01.md#restricted-operations) and [grantless operations](#grantless-operations), which use somewhat different authorization models. After an access token is issued it is valid for one hour. The same access token can be used for multiple API calls, until it expires.

To exchange a refresh token for an access token using a generated SDK, see [Connecting to the Selling Partner API using a generated Java SDK](#connecting-to-the-selling-partner-api-using-a-generated-java-sdk). To manually exchange a refresh token for an access token, see [Connecting to the Selling Partner API](#connecting-to-the-selling-partner-api).

## For hybrid Selling Partner API applications

If an MWS auth token was returned in [Step 4. Amazon sends you the authorization information](#step-4-amazon-sends-you-the-authorization-information), your application is also authorized to make calls to Amazon Marketplace Web Service on the selling partner's behalf. For more information, see [Hybrid Selling Partner API applications](#hybrid-selling-partner-api-applications).

# Website authorization workflow

The Website authorization workflow is an OAuth authorization workflow that is initiated from your own website. Selling partners sign into your website and click an “Authorize” button that you configure to initiate authorization. For more information, see [Step 0. Set up an "Authorize" button](#step-0.-set-up-an-authorize-button).

**Note.** The examples in the following steps are for a seller application, using an OAuth authorization URI based on a [Seller Central URL](#Seller-Central-URLs). For vendor applications, you can replace the Seller Central URL with a [Vendor Central URL](#Vendor-Central-URLs). For more information, see [Constructing an OAuth authorization URI](#Constructing-an-OAuth-authorization-URI).

**Testing your authorization workflow**

Before creating a production Website authorization workflow, you should test your authorization workflow while your application is in draft status. By testing you can ensure that your application can exchange parameters with Amazon and receive authorization information.

**To set up a test authorization workflow**

1.  Make sure that your application is in draft status.

2.  At [Step 0. Set up an "Authorize" button](#step-0.-set-up-an-authorize-button), when you construct one or more OAuth authorization URIs, add the `version=beta` parameter to the OAuth URI(s) to indicate that the workflow is for authorizing an application in draft status.

You are now ready to test your authorization workflow with a trusted selling partner who works with you. Alternatively, you can test the workflow yourself, using your own selling account credentials. Start at [Step 1. The selling partner initiates authorization from your website](#Step-1-The-selling-partner-initiates-authorization-from-your-website).

When you have finished testing the authorization workflow you can convert it to a production workflow.

**To convert your test authorization workflow to a productions workflow**

1.  List your application in the Amazon Seller Central Partner Network. This changes your application from draft status to published status.

    **Important.** Your application must be in published status for the Webstore authorization workflow to work.

2.  Remove the `version=beta` parameter from the OAuth authorization URI(s) that you constructed in [Step 0. Set up an "Authorize" button](#step-0.-set-up-an-authorize-button).

    Now any selling partner can authorize your published application starting at [Step 1. The selling partner initiates authorization from your website](#Step-1-The-selling-partner-initiates-authorization-from-your-website).

**Steps**

[Step 0. Set up an "Authorize" button](#step-0-set-up-an-"authorize"-button)

[Step 1. The selling partner initiates authorization from your website](#Step-1-The-selling-partner-initiates-authorization-from-your-website)

[Step 2. The selling partner consents to authorize the application](#Step-2-The-selling-partner-consents-to-authorize-the-application)

[Step 3. Amazon sends you the authorization information](#Step-3-Amazon-sends-you-the-authorization-information)

[Step 4. Your application exchanges the LWA authorization code for a LWA refresh token](#Step-4-Your-application-exchanges-the-LWA-authorization-code-for-a-LWA-refresh-token)

## Step 0. Set up an "Authorize" button

Set up an “Authorize” button (or something similar) on your application website that the selling partner can click to initiate authorization of your application. When the selling partner clicks the button, your website loads an OAuth authorization URI into the browser and the selling partner is redirected to an Amazon sign-in page. After sign-in, a consent page appears, where a selling partner can give your application consent to make calls to the Selling Partner API on their behalf. For information about constructing an OAuth authorization URI, see [Constructing an OAuth authorization URI](#constructing-an-oauth-authorization-uri).

**Note.** If you have OAuth authorization URIs for more than one region, be sure to set up your “Authorize” buttons so that selling partners are redirected to the Seller Central (for sellers) or Vendor Central (for vendors) sign-in page for their own region.

Setting up your “Authorize” button(s) is a one-time task.

## Step 1. The selling partner initiates authorization from your website

1.  The selling partner signs into your website. If the selling partner does not yet have an account, they complete your registration process.

2.  The selling partner clicks the "Authorize" button that you set up in [Step 0. Set up an "Authorize" button](#step-0.-set-up-an-authorize-button). If you have more than one regional "Authorize" button, be sure that the selling partner is directed to the button that corresponds to the region that they sell in.

3.  Your application loads the OAuth authorization URI into the browser, adding the following query parameters:

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
<td>A URI for redirecting the browser to your application. This must an OAuth Redirect URI that you specified when you <a href="#registering-your-application">registered your application</a>. If you do not include the <strong>redirect_uri</strong> parameter, the default is the first OAuth Redirect URI that you specified when you registered your application.<p>Optional</p></td>
</tr>
<tr class="even">
<td><strong>state</strong></td>
<td><p>A state value generated by your application. Your application uses this value to maintain state between this request and the response, helping to guard against cross-site request forgery attacks.</p>
<p><strong>Important:</strong> Because OAuth information is passed via URL query parameters, we highly recommended that you do the following: 1) Ensure that the state token is short-lived and verifiably unique to your user, and 2) Set the Referrer-Policy: no-referrer HTTP header, which prevents leaking sensitive information to websites that your website links to. For more information about cross-site request forgery and calculating a state parameter, see <a href="https://developer.amazon.com/docs/login-with-amazon/cross-site-request-forgery.html">Cross-site Request Forgery</a> in the Login with Amazon documentation.</p></td>
</tr>
</tbody>
</table>

**Note:** If you include the `version=beta` parameter, the workflow authorizes an application in Draft state. If you do not include the parameter, the workflow authorizes an application published on the Amazon Seller Central Partner Network.

For example:
```
https://sellercentral.amazon.com/apps/authorize/consent?application_id=appidexample&state=stateexample&version=beta
```
OR
```
https://sellercentral.amazon.com/apps/authorize/consent?application_id=appidexample&state=stateexample
```
The selling partner arrives at the sign-in page of Seller Central (for sellers) or Vendor Central (for vendors).

## Step 2. The selling partner consents to authorize the application

1.  The selling partner signs into Seller Central or Vendor Central, depending on the type of OAuth Authorization URI you constructed. The consent page appears. For more information, see [Constructing an OAuth Authorization URI](#Constructing-an-OAuth-Authorization-URI).

2.  The selling partner views the consent page, reviews the data access requested by your application, and then clicks the **Confirm** button to continue. The selling partner can click the **Cancel** button to exit without authorizing.

## Step 3. Amazon sends you the authorization information

Amazon briefly displays a page indicating that we are authorizing you to access the selling partner's data. While that page is displayed, the following actions take place:

1.  Amazon loads your OAuth Redirect URI into the browser (the first one you specified when you [registered you application](#Registering-your-application)), adding the following query parameters:

| **Parameter**| **Description**|
| ------------------------ | ---------------------- |
| **state** | The state value from [Step 1. The seller initiates authorization from](#step-1-the-seller-initiates-authorization-from-your-website) [your website](#step-1-the-seller-initiates-authorization-from-your-website). |
| **selling_partner_id** | The identifier of the selling partner who is authorizing your application.    |
| **mws_auth_token**  | The **MWSAuthToken** value that you use when you create a query string for a call to Amazon Marketplace Web Service. The mws\_auth\_token parameter is only passed when the selling partner is authorizing a hybrid Selling Partner API (SP-API) application. Note that if you are the selling partner authorizing the hybrid SP-API application and the application owner (meaning you self-authorized your own Amazon MWS application) you will not receive the MWSAuthToken. For more information, see [Hybrid Selling Partner API applications](#hybrid-selling-partner-api-applications). **For seller applications only.**|
| **spapi_oauth_code**   | The Login with Amazon (LWA) authorization code that you exchange for an LWA refresh token. For more information, see [Step 4. Your application exchanges the LWA authorization code for a LWA refresh token](#step-4-your-application-exchanges-the-lwa-authorization-code-for-a-lwa-refresh-token).<br/>**Note:** An LWA authorization code expires after five minutes. Be sure to exchange it for an LWA refresh token before it expires.|

For example:
````
https://client-example.com?state=state-example&mws_auth_token=mwsauthtokenexample&selling_partner_id=sellingpartneridexample&spapi_oauth_code=spapioauthcodeexample
````
2.  Your application validates the state value.

3.  Your application saves the `selling_partner_id`, `mws_auth_token` (if passed), and `spapi_oauth_code` values.

4.  Your website's landing page displays.

## Step 4. Your application exchanges the LWA authorization code for a LWA refresh token

The Login with Amazon SDK for JavaScript can help you with the exchange of an LWA authorization code for an LWA refresh token.

**Note:** An LWA authorization code expires after five minutes. Be sure to exchange it for an LWA refresh token before it expires.

For more information, see the Login with Amazon documentation:

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
```plain
POST /auth/o2/token HTTP/l.l
Host: api.amazon.com
Content-Type: application/x-www-form-urlencoded;charset=UTF-8
grant_type=authorization_code&code=SplxlOexamplebYS6WxSbIA&client_id=foodev&client_secret=Y76SDl2F
```
2.  The LWA Authorization Server returns the LWA refresh token. The response is in JSON and includes the following elements.

| **Parameter**    | **Description**   |
| ---------------| -------- |
| **access_token**  | A token that authorizes your application to take certain actions on behalf of a selling partner. See [Connecting to the Selling Partner API](#connecting-to-the-selling-partner-api).         |
| **token_type**    | The type of token returned. Should be bearer.      |
| **expires_in**    | The number of seconds before the access token becomes invalid.   |
| **refresh_token** | A long-lived token that can be exchanged for a new access token. See [Connecting to the Selling Partner API](#connecting-to-the-selling-partner-api). |
```plain
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

4.  The browser displays a page to the selling partner that indicates next steps for using your application.

An LWA refresh token is a long-lived token that you exchange for an LWA access token. An access token obtained through this token exchange must be included with calls to all Selling Partner API operations except [restricted operations](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/use-case-guides/tokens-api-use-case-guide/tokens-API-use-case-guide-2021-03-01.md#restricted-operations) and [grantless operations](#grantless-operations), which use somewhat different authorization models. After an access token is issued it is valid for one hour. The same access token can be used for multiple API calls, until it expires.

To exchange a refresh token for an access token using a generated SDK, see [Connecting to the Selling Partner API using a generated Java SDK](#connecting-to-the-selling-partner-api-using-a-generated-java-sdk). To manually exchange a refresh token for an access token, see [Connecting to the Selling Partner API](#connecting-to-the-selling-partner-api).

**For hybrid Selling Partner API applications**

If an MWS auth token was returned in [Step 3. Amazon sends you the authorization information](#step-3-amazon-sends-you-the-authorization-information), your application is also authorized to make calls to Amazon Marketplace Web Service on the selling partner's behalf. For more information, see [Hybrid Selling Partner API applications](#hybrid-selling-partner-api-applications).

# Self authorization

When you create a private application for your own organization you can self authorize it to access your account information. Before doing this you must [register as a developer](#registering-as-a-developer) and [register your application](#registering-your-application). You can self authorize your application in draft status; there is no reason to publish a private application.

**Note.** If you are creating a public application to be authorized by selling partners, go to [Authorizing Selling Partner API applications](#authorizing-selling-partner-api-applications).

The self authorization procedure varies depending on if you have a seller application or a vendor application.

**To self-authorize your application (seller application)**
1. Sign into Seller Central using the credentials that you used to [register as a developer](#registering-as-a-developer).

2.  In the **Partner Network** menu, click **Develop Apps**.

    The **Developer Central** page appears.

3.  For the application that you want to authorize, click the arrow next to the **Edit App** button, and then click **Authorize**.

    The **Authorize application** page appears.
    
    **Note.** If your selling partner account is merged with accounts in other regions, you will see an **Authorize app** button for each of your merged accounts.

4. Click the **Authorize app** button for each selling partner account that you want your application to access. The **Marketplaces** column indicates the marketplaces in which an account is active.

    A Login with Amazon (LWA) refresh token appears with every **Authorize app** button that you click. 
    
    **Note.** If you click an **Authorize app** button multiple times, a new refresh token is generated each time. Generating a new refresh token does not invalidate previous refresh tokens.

5. Save a refresh token for each selling partner account that you authorized your application to access. Later you can exchange these refresh tokens for access tokens. When you call a Selling Partner API to access a selling partner account, include the access token that corresponds to that account.

6.  To authorize your application to access a different selling partner account, click **sign in to that account** at the bottom of the page.

    A Seller Central sign-in page appears.

7. Sign in using the credentials for the selling partner account that you want your application to access.

    The **Authorize application** page appears.

8. Click the **Authorize app** button to get a refresh token.    

**To self-authorize your application (vendor application)**
1.  Sign into Vendor Central using the credentials that you used to [register as a developer](#registering-as-a-developer).

2.  In the **Integration** menu, click **API Integration**.

    The **Developer Central** page appears.

3.  For the application that you want to authorize, click the arrow next to the **Edit App** button, and then click **Authorize**.

    The **Authorize application** page appears.

4.  Click the **Generate refresh token** button.

    Your Login with Amazon (LWA) refresh token appears. If you click the **Generate refresh token** button again a new refresh token is generated. Generating a new refresh token does not invalidate previous refresh tokens.     

    **Note.**  If your selling account is merged with accounts from other regions, you will receive a separate refresh token for each region. Your application is now authorized to access your selling account(s).      
    

An LWA refresh token is a long-lived token that you exchange for an LWA access token. An access token obtained through this token exchange must be included with calls to all Selling Partner API operations except [restricted operations](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/use-case-guides/tokens-api-use-case-guide/tokens-API-use-case-guide-2021-03-01.md#restricted-operations) and [grantless operations](#grantless-operations), which use somewhat different authorization models. After an access token is issued it is valid for one hour. The same access token can be used for multiple API calls, until it expires.

To exchange a refresh token for an access token using a generated SDK, see [Connecting to the Selling Partner API using a generated Java SDK](#connecting-to-the-selling-partner-api-using-a-generated-java-sdk). To manually exchange a refresh token for an access token, see [Connecting to the Selling Partner API](#connecting-to-the-selling-partner-api).

# Authorization with the Restricted Data Token

Operations that return restricted data (such as Personally Identifiable information, or PII) are considered restricted operations, and require special authorization in the form of a Restricted Data Token (RDT). An RDT provides authorization to get the PII required to perform functions such as shipping, tax invoicing, or tax remittance services. You authorize calls to restricted operations by passing an RDT in the `x-amz-access-token` header when calling a restricted operation. This is in contrast to passing the LWA access token in the header, as you do with other SP-API operations. For more information, see [Step 3. Add headers to the URI](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/developer-guide/SellingPartnerApiDeveloperGuide.md#step-3-add-headers-to-the-uri) in the Selling Partner API Developer Guide.

## How do I get an RDT?

Unless you have a delegatee application (see [Terminology](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/use-case-guides/tokens-api-use-case-guide/tokens-API-use-case-guide-2021-03-01.md#terminology) in the Tokens Use Case Guide), you get an RDT by calling the [createRestrictedDataToken](https://github.com/amzn/selling-partner-api-docs/blob/main/references/tokens-api/tokens_2021-03-01.md#createrestricteddatatoken) operation of the Tokens API. If you have a delegatee application, you get an RDT from the delegator application that your application is integrated with. For more information about authorizing calls using the RDT, including delegating authorization, see the [Tokens API Use Case Guide](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/use-case-guides/tokens-api-use-case-guide/tokens-API-use-case-guide-2021-03-01.md).

# Generating a Java SDK with LWA token exchange and authentication

**Note to C\# developers.** We also provide a library for generating a C\# SDK with LWA token exchange and authentication. For more information, see README.md in https://github.com/amzn/selling-partner-api-models/tree/main/clients/sellingpartner-api-aa-csharp.

These instructions show you how to generate a Java SDK for the Sellers API using [Swagger Code Generator](https://github.com/swagger-api/swagger-codegen) on a computer running Microsoft Windows. The process is the same for users of other operating systems such as macOS or Linux, with the replacement of Windows-specific semantics (for example, C:\\). Although these instructions are for the Sellers API, you can modify the instructions to generate SDKs for any other Selling Partner API. See <https://github.com/amzn/selling-partner-api-models> for Swagger models for each Selling Partner API section.

With this SDK you can make requests to the Selling Partner API with the following code already set up for you: Login with Amazon token exchange (exchange a refresh token for an access token) and authentication.

**To generate a Java SDK with LWA token exchange and authentication**

1.  Install [Java 8 or newer](https://www.oracle.com/technetwork/java/index.html), [Apache Maven 3.6. or greater](http://maven.apache.org/), and [GNU Wget](https://www.gnu.org/software/wget/wget.html) and make them available in your `$PATH`.

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
    
    1.  Navigate to the **selling-partner-api-models\\clients\\sellingpartner-api-aa-java** folder of your local copy of the repository and run `mvn package`. This generates a folder named "target". In this folder is a JAR file named **sellingpartnerapi-aa-java-1.0-jar-with-dependencies.jar** (or something similar) and all of the required dependencies.
    
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

Before your application can connect to the Selling Partner API, you must register it and it must be authorized by a selling partner. See [Registering your application](#registering-your-application) and [Authorizing Selling Partner API applications](#authorizing-selling-partner-api-applications).

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
import com.amazon.SellingPartnerAPIAA.AWSAuthenticationCredentialsProvider;

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
<td>The LWA refresh token. Get this value when the selling partner authorizes your application. For more information, see <a href="#authorizing-selling-partner-api-applications">Authorizing Selling</a> <a href="#authorizing-selling-partner-api-applications">Partner API applications</a>.</td>
<td><p>No. Include refreshToken if the operation that you call in the following step requires selling partner authorization. All operations that are not <a href="#grantless-operations">grantless operations</a> require selling partner authorization. If you include refreshToken, do not include withScopes.</p></td>
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

Example for calling operations that require selling partner authorization:
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

Before your application can connect to the Selling Partner API, you must register it and it must be authorized by a selling partner. See [Registering your application](#registering-your-application) and [Authorizing Selling Partner API applications](#authorizing-selling-partner-api-applications).

These instructions show you the steps for making a call to the Selling Partner API. For help with constructing a Selling Partner API URI and adding headers to it, see [Generating a Java client library](#Generating-a-Java-client-library). For a more complete solution that includes code for exchanging LWA tokens and authentication, see [Generating a Java SDK with LWA token exchange](#generating-a-java-sdk-with-lwa-token-exchange-and-authentication) [and authentication](#generating-a-java-sdk-with-lwa-token-exchange-and-authentication).

**Steps**

[Step 1. Request a Login with Amazon access token](#step-1-request-a-login-with-amazon-access-token)

[Step 2. Construct a Selling Partner API URI](#step-2-construct-a-selling-partner-api-uri)

[Step 3. Add headers to the URI](#step-3-add-headers-to-the-uri)

[Step 4. Create and sign your request](#step-4-create-and-sign-your-request)

## Step 1. Request a Login with Amazon access token

A Login with Amazon (LWA) access token authorizes your application to take certain actions on behalf of a selling partner. An LWA access token expires one hour after it is issued.

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
<li><p><em>refresh_token</em>. Use this for calling operations that require authorization from a selling partner. All operations that are not   <a href="#grantless-operations">grantless operations</a> require authorization from a selling partner. When specifying this value, include the <em>refresh_token</em> parameter.</p></li>
<li><p><em>client_credentials</em>. Use this for calling <a href="#grantless-operations">grantless operations</a>. When specifying this value, include the <code>scope</code> parameter.</p></li>
</ul></td>
<td>Yes</td>
</tr>
<tr class="even">
<td><strong>refresh_token</strong></td>
<td>The LWA refresh token. Get this value when the selling partner authorizes your application. For more information, see <a href="#authorizing-selling-partner-api-applications">Authorizing Selling Partner API applications</a>.</td>
<td>No. Include refresh_token for calling operations that require authorization from a selling partner. If you include refresh_token, do not include scope.</td>
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

Example for calling an operation that requires selling partner authorization:
```plain
POST /auth/o2/token HTTP/l.l
Host: api.amazon.com
Content-Type: application/x-www-form-urlencoded;charset=UTF-8
grant_type=refresh_token
&refresh_token=Aztr|...
&client_id=foodev
&client_secret=Y76SDl2F
```
Example for calling a grantless operation:
```plain
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
| **refresh_token** | The LWA refresh token that you submitted in the request. Maximum size: 2048 bytes. |
```plain
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
| HTTP method    | The HTTP method. | `GET` |
| Endpoint | A [Selling Partner API endpoint](#Selling-Partner-API-endpoints). | `https://sellingpartnerapi-na.amazon.com` |
| Path   | The Selling Partner API section/version. number of the section/resource. | `/fba/inbound/v0/shipments/{shipmentId}/preorder/confirm` |
| Query string   | The query parameters.  | `?marketplace=ATVPDKIKX0DER`   |
| Path parameter | The path parameters.  | `shipmentId1`  |

For example:
```plain
PUT https://sellingpartnerapi-na.amazon.com/fba/inbound/v0/shipments/shipmentId1/preorder/confirm?MarketplaceId=ATVPDKIKX0DER&NeedByDate=2020-10-10
```
## Step 3. Add headers to the URI

Add headers to the URI that you constructed in [Step 2. Construct a Selling Partner API URI](#step-2-construct-a-selling-partner-api-uri). Here are the HTTP headers that you include in requests to the Selling Partner API:

**Request headers**

| **Name**     | **Description**  |
| ---------- | ---------------- |
| host  | The marketplace endpoint. See [Selling Partner API endpoints](#selling-partner-api-endpoints).   |
| x-amz-access-token | The LWA access token. See [Step 1. Request a Login with Amazon access token](#step-1-request-a-login-with-amazon-access-token).<br>**Note about restricted operations.** If you are calling a restricted operation, pass in a Restricted Data Token (RDT) here instead of an LWA access token. For information about getting RDTs and calling restricted operations, see the [Tokens API Use Case Guide](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/use-case-guides/tokens-api-use-case-guide/tokens-API-use-case-guide-2021-03-01.md) in the Tokens API Use Case Guide. |
| x-amz-date   | The date and time of your request.    |
| user-agent    | Your application name and version number, platform, and programming language. These help Amazon diagnose and fix problems you might encounter with the service. See [Include a User-Agent header in all](#include-a-user-agent-header-in-all-requests) [requests](#include-a-user-agent-header-in-all-requests). |

Here is an example of a request to the Selling Partner API with URI and headers but no signing information:
```plain
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
```plain
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
```plain
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
```plain
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

**For seller applications only.**

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

A User-Agent header identifies your application, its version number, and the platform and programming language that you are using. You must include a User-Agent header with every request that you submit to the Selling Partner API. Doing this helps Amazon more effectively diagnose and fix problems, helping to improve your experience using the service.

To create a User-Agent header, begin with the name of your application, followed by a forward slash, followed by the version of the application, followed by a space, an opening parenthesis, the Language name/value pair, and a closing parenthesis. The Language parameter is a required attribute, but you can add additional attributes separated by semicolons.

The following pseudocode illustrates a minimally acceptable User-Agent header:
```
AppId/AppVersionId (Language=LanguageNameAndOptionallyVersion)
```
The following is an example of a User-Agent header that might be used by an application developer:
```
My Selling Tool/2.0 (Language=Java/1.8.0.221; Platform=Windows/10)
```
If you are a large selling partner who is integrating through your own IT department, consider creating a User-Agent header that contains the Host attribute, as in the following example. This can help an Amazon support engineer troubleshoot problems for you more effectively.
```
MyCompanyName/build1611 (Language=Perl; Host=jane.desktop.example.com)
```
To specify additional attributes, use the format AttributeName=Value;, separating each name/value pair with a semicolon. If you need to use a backslash (\\), quote it with another backslash (\\\\). Similarly, quote a forward slash in the application name (\\/), an opening parenthesis in the application version (\\(), an equal sign in the attribute name (\\=), and both a closing parenthesis (\\)), and a semicolon (\\;) in attribute values.

Because the User-Agent header is transmitted in every request, it is a good practice to limit the size of the header. The Selling Partner API will reject a User-Agent header if it is longer than 500 characters.

# Hybrid Selling Partner API applications

**For seller applications only**

A hybrid Selling Partner API application is an application that can make calls both to the Selling Partner API and to Amazon Marketplace Web Service (Amazon MWS). Use a hybrid application when your solution requires functionality from both services. When a selling partner authorizes your hybrid Selling Partner API application, they are (1) authorizing your Amazon MWS developer ID to make calls to Amazon MWS on their behalf, and (2) authorizing the application to make calls to the Selling Partner API on their behalf.

Amazon considers a hybrid application to be a single application. For example, when you publish a hybrid application to the Amazon Seller Central Partner Network, you manage it as a single application.

## Creating a hybrid Selling Partner API application

**To create a hybrid application**

1.  Publish your Amazon MWS application to the Amazon Seller Central Partner Network. For information about publishing your application, see [Amazon Seller Central Partner Network Listing Guide](https://docs.developer.amazonservices.com/en_US/dev_guide/DG_AppListingGuide.html) in the Amazon MWS documentation.

2.  Sign into Seller Central using the credentials that you used to [register as a developer](#registering-as-a-developer).

3.  In the **Partner Network** menu, click **Develop Apps**.

    The **Developer Central** page appears.

4.  Next to your Amazon MWS application, click the **Edit app** button.

5.  Follow the instructions to register your application.

After creating a hybrid application you can:
1.  Set up and test an OAuth authorization workflow. For more information, see [Authorizing Selling Partner API applications](#authorizing-selling-partner-api-applications).

2.  Migrate existing Amazon MWS authorizations to your hybrid Selling Partner API application. For more information, see the [Authorization API use case guide](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/use-case-guides/authorization-api-use-case-guide/authorization-api-use-case-guide-v1.md).


# The Selling Partner API sandbox

The Selling Partner API provides a sandbox environment that allows you to test your applications without affecting production data or triggering real-world events. Making sandbox calls to the Selling Partner API is identical to making production calls except you direct the calls to the [Selling Partner API sandbox endpoints](#selling-partner-api-sandbox-endpoints). Calling the sandbox endpoints returns static, mocked responses for all Selling Partner APIs. You can refer to these mocked responses in the Swagger model JSON file for the API that you want to call. For more information, see [How to make a sandbox call to the Selling Partner API](#how-to-make-a-sandbox-call-to-the-selling-partner-api).

The Selling Partner API sandbox works like many mocking frameworks, in that it uses pattern matching to return a specified response when the specified parameters are present. A developer receives a response defined in the following object when they send a request that includes the specified parameters: 

### Static sandbox JSON object

<pre><code>
"x-amzn-api-sandbox":
{
  "static": [
    {
      "request":
      {
        "parameters": 
        {
          &mldr;
        }
      },
      "response":
      {
        &mldr;
      }
    }
  ]
}
</code>
</pre>

Note that while these objects will contain the parameters that are needed to match a mock response, they do not necessarily contain all of the parameters that are required for a successful response. To get a successful response, be sure that your request is valid and includes **all required parameters** as defined in the corresponding Swagger model.

**Important:** The sandbox is for testing functionality, not scalability testing. Calls to sandbox endpoints are subject to these throttling limits: **rate** = five requests per second; **burst** = 15. For more information about throttling see "Usage Plans and Rate Limits" in the Selling Partner API documentation.

## How to make a sandbox call to the Selling Partner API

### Step 1. Check the JSON file for request parameters

1.  Go to <https://github.com/amzn/selling-partner-api-models/tree/main/models>.

2.  Open the folder for the API for which you want to make a sandbox call.

3.  Click the Swagger model JSON file for the API that you want.

    The JSON code displays.

4.  Search the code for `x-amzn-api-sandbox` objects that contain a `"static"` array.

The [static sandbox JSON object](#static-sandbox-json-object) will contain request and response examples for static sandbox calls to the API operation in which they appear. If the request example contains parameters, use them in the following step.

### Step 2. Make a sandbox call to an API

Make a sandbox call to an API in the same way you would make a production call, with these differences:

1. Include the parameters from [Step 1. Check the JSON file for request parameters](#step-1-check-the-json-file-for-request-parameters) in your call. If the API requires parameters in addition to those, be sure to also include those required parameters in your call.

2.  Direct your call to one of the [Selling Partner API sandbox endpoints](#selling-partner-api-sandbox-endpoints).

    You should receive a response that matches the payload object contained in the static sandbox JSON object from Step 1.

## Selling Partner API sandbox endpoints

The Selling Partner API has sandbox endpoints for the North America, Europe, and Far East selling regions.

| **Selling region**                                           | **Endpoint**                                      | **AWS Region** |
| ------------------------------------------------------------ | ------------------------------------------------- | -------------- |
| North America (Canada, US, Mexico, and Brazil marketplaces)  | `https://sandbox.sellingpartnerapi-na.amazon.com` | us-east-1      |
| Europe (Spain, UK, France, Netherlands, Germany, Italy, Sweden, Poland, Egypt, Turkey, United Arab Emirates, and India marketplaces) | `https://sandbox.sellingpartnerapi-eu.amazon.com` | eu-west-1      |
| Far East (Singapore, Australia, and Japan marketplaces)      | `https://sandbox.sellingpartnerapi-fe.amazon.com` | us-west-2      |

# How does the Selling Partner API differ from Amazon Marketplace Web Service?

Although the Selling Partner API and Amazon Marketplace Web Service (Amazon MWS) are both web services that enable programmatic access to customer data, there are significant differences. Here are some key differences between the Selling Partner API and Amazon MWS:

  - With the Selling Partner API you can developer applications for both sellers and vendors.
  
  - The Selling Partner API treats data as REST-compliant resources that can be accessed and modified via standard HTTP methods. By contrast, Amazon MWS exposes data using operations that are specific to Amazon MWS.

  - The Selling Partner API authorization leverages LWA, Amazon's implementation of OAuth 2.0. This model eliminates the need for the manual exchange of auth tokens, as required by Amazon MWS. See [Authorizing Selling Partner API applications](#Authorizing-Selling-Partner-API-applications).

  - With Amazon MWS, selling partners authorize developers. With the Selling Partner API, selling partners authorize applications. Using the Selling Partner API, developers can create multiple applications that require varying levels of access to selling partner data.

  - The Selling Partner API provides finer grain data access control than Amazon MWS. Developers can request access to only the data they need, and selling partners can grant permissions at the API section, operation, or data resource level.

  - The Selling Partner API lets you directly procure and manage your own authentication credentials using AWS Identity and Access Management (IAM). With Amazon MWS, you receive authentication credentials provided by Amazon using a special registration workflow, and you get new credentials by opening a contact with Amazon MWS support. See [Step 2. Create an IAM user](#step-2-create-an-iam-user).

  - The Selling Partner API uses AWS Signature Version 4 for authentication. Amazon MWS uses Signature Version 2. See [ Step 4. Create and sign your request](#step-4-create-and-sign-your-request).

# About vendor groups

**For vendor applications only**

When you authorize your Selling Partner API application to access your data, you are granting access to the vendor group that is associated with the sign-in credentials for your Vendor Central account. By extension, you are granting access to all of the vendor codes present in the vendor group. Therefore it's important to use the right Vendor Central credentials and vendor group for your Selling Partner API integration.

## Using a single vendor group

If you use a single vendor group to manage all of your vendor codes, you can authorize an application to access the data in that vendor group. To do this, [register as a developer](#registering-as-a-developer) using the credentials for the Vendor Central account associated with the vendor group.

To be sure that your vendor group contains all of the vendor codes that you want your application to access, check the vendor codes in your vendor group. If you need to, you can add or remove vendor codes from your vendor group at any time.

**To check the vendor codes in your vendor group**

1.  Go to Vendor Central for your marketplace. See [Vendor Central URLs](#vendor-central-urls) for a list of URLs by marketplace.

2.  Sign in using the credentials for the Vendor Central account with the vendor group that you want your application to access.

3.  On the **Settings** menu, click **Contacts**.

4.  Review the **Contacts** page to determine if the vendor codes that you want your application to access are present.

**To add or remove vendor codes from your vendor group**

1.  Go to Vendor Central for your marketplace. See [Vendor Central URLs](#vendor-central-urls) for a list of URLs by marketplace.

2.  Sign in using the credentials for the Vendor Central account with the vendor group for which you want to add or remove vendor codes.

3.  Click the **Support** link at the top of the page.

4.  On the **Support** page, click the **Contact Us** button.

5.  On the **Contact Amazon support** page, click **Settings and Account Management**, then choose **Account Settings**.

6.  In the **Settings and Account Management** box, at the bottom, click **Still need help?**.

7.  Follow the instructions to contact Amazon support.

## Using multiple vendor groups

Perhaps you use multiple vendor groups to manage your vendor codes. If so, for Selling Partner API integrations we recommend that you either 1) Create a new vendor group containing all of the vendor codes you need, or 2) Choose an existing vendor group and add the vendor codes that you need. You can add or remove vendor codes in a vendor group at any time. However once you have [registered as a developer](#registering-as-a-developer), you cannot change the vendor group associated with that developer. If you want to maintain separate API integrations for different businesses, you can. To do this, register as a developer separately for each vendor group that you want to access. Then you can develop separate API integrations with each registered developer.

**To create a new vendor group**

1.  Go to Vendor Central for your marketplace. See [Vendor Central URLs](#vendor-central-urls) for a list of URLs by marketplace.

2.  Sign in using the credentials for the Vendor Central account with the vendor group that you want your application to access.

3.  Click the **Support** link at the top of the page.

4.  On the **Support** page, click the **Contact Us** button.

5.  On the **Contact Amazon support** page, click **Settings and Account Management**, then choose **Account Settings**.

6.  In the **Settings and Account Management** box, at the bottom, click **Still need help?**.

7.  Follow the instructions to contact Amazon support.

# Vendor Central URLs

**For vendor applications only**

Here are the Vendor Central URLs by marketplace.

**North America**

| **Marketplace** | **Vendor Central URL**                |
| --------------- | ------------------------------------- |
| Canada          | <https://vendorcentral.amazon.ca>     |
| US              | <https://vendorcentral.amazon.com>    |
| Mexico          | <https://vendorcentral.amazon.com.mx> |
| Brazil          | <https://vendorcentral.amazon.com.br> |

**Europe**

| **Marketplace** | **Vendor Central URL**                |
| --------------- | ------------------------------------- |
| Spain           | <https://vendorcentral.amazon.es>     |
| UK              | <https://vendorcentral.amazon.co.uk>  |
| France          | <https://vendorcentral.amazon.fr>     |
| Netherlands     | <https://vendorcentral.amazon.nl>     |
| Germany         | <https://vendorcentral.amazon.de>     |
| Italy           | <https://vendorcentral.amazon.it>     |
| Sweden          | <https://vendorcentral.amazon.se>     |
| Poland          | <https://vendorcentral.amazon.pl>     |
| Egypt           | <https://vendorcentral.amazon.me>     |
| Turkey          | <https://vendorcentral.amazon.com.tr> |
| U.A.E.          | <https://vendorcentral.amazon.me>     |
| India           | <https://vendorcentral.amazon.in>     |

**Far East**

| **Marketplace** | **Vendor Central URL**                |
| --------------- | ------------------------------------- |
| Singapore       | <https://vendorcentral.amazon.com.sg> |
| Australia       | <https://vendorcentral.amazon.com.au> |
| Japan           | <https://vendorcentral.amazon.co.jp>  |

# Seller Central URLs

**For seller applications only**

Here are the Seller Central URLs by marketplace.

**North America**

| **Marketplace** | **Seller Central URL**                    |
| --------------- | ----------------------------------------- |
| Canada          | <https://sellercentral.amazon.ca>         |
| US              | <https://sellercentral.amazon.com>        |
| Mexico          | <https://sellercentral.amazon.com.mx>     |
| Brazil          | <https://sellercentral.amazon.com.br>     |

**Europe**

| **Marketplace** | **Seller Central URL**                    |
| --------------- | ----------------------------------------- |
| Spain           | <https://sellercentral-europe.amazon.com> |
| UK              | <https://sellercentral-europe.amazon.com> |
| France          | <https://sellercentral-europe.amazon.com> |
| Netherlands     | <https://sellercentral.amazon.nl>         |
| Germany         | <https://sellercentral-europe.amazon.com> |
| Italy           | <https://sellercentral-europe.amazon.com> |
| Sweden          | <https://sellercentral.amazon.se>         |
| Poland          | <https://sellercentral.amazon.pl>         |
| Turkey          | <https://sellercentral.amazon.com.tr>     |
| U.A.E.          | <https://sellercentral.amazon.ae>         |
| India           | <https://sellercentral.amazon.in>            |

**Far East**

| **Marketplace** | **Seller Central URL**                    |
| --------------- | ----------------------------------------- |
| Singapore       | <https://sellercentral.amazon.sg>     |
| Australia       | <https://sellercentral.amazon.com.au>     |
| Japan           | <https://sellercentral.amazon.co.jp>      |
