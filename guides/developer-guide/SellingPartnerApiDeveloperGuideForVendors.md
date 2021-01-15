# Selling Partner API Developer Guide for Vendors

### Contents

- [What is the Selling Partner API?](#what-is-the-selling-partner-api)

  - [Selling Partner API endpoints](#selling-partner-api-endpoints)

- [About vendor groups](#about-vendor-groups)

  - [Using a single vendor group](#using-a-single-vendor-group)

  - [Using multiple vendor groups](#using-multiple-vendor-groups)

- [Registering as a developer](#registering-as-a-developer)

- [Registering your Selling Partner API application](#registering-your-selling-partner-api-application)
- [Step 1. Create an AWS account](#step-1-create-an-aws-account)
  
- [Step 2. Create an IAM user](#step-2-create-an-iam-user)
  
- [Step 3. Create an IAM policy](#step-3-create-an-iam-policy)
  
- [Step 4. Create an IAM role](#step-4-create-an-iam-role)
  
- [Step 5. Add an AWS Security Token Service policy to your IAM user](#step-5-add-an-aws-security-token-service-policy-to-your-iam-user)
  
- [Step 6. Register your application](#step-6-register-your-application)
  
- [Viewing your application information](#viewing-your-application-information)

- [Authorizing your application](#authorizing-your-application)

- [Generating a Java SDK with LWA token exchange and authentication](#generating-a-java-sdk-with-lwa-token-exchange-and-authentication)

- [Connecting to the Selling Partner API using a generated Java SDK](#connecting-to-the-selling-partner-api-using-a-generated-java-sdk)

  - [Step 1. Configure your AWS credentials](#step-1-configure-your-aws-credentials)

  - [Step 2. Configure your AWS credentials provider](#step-2-configure-your-aws-credentials-provider)

  - [Step 3. Configure your LWA credentials](#step-3-configure-your-lwa-credentials)

  - [Step 4. Create an instance of the Vendor Orders API and call an operation](#step-4-create-an-instance-of-the-vendor-orders-api-and-call-an-operation)

- [Generating a Java client library](#generating-a-java-client-library)

- [Connecting to the Selling Partner API](#connecting-to-the-selling-partner-api)

  - [Step 1. Request a Login with Amazon access token](#step-1-request-a-login-with-amazon-access-token)

  - [Step 2. Construct a Selling Partner API URI](#step-2-construct-a-selling-partner-api-uri)

  - [Step 3. Add headers to the URI](#step-3-add-headers-to-the-uri)

  - [Step 4. Create and sign your request](#step-4-create-and-sign-your-request)

    - [Credential scope](#credential-scope)

    - [Authorization header](#authorization-header)

- [Response format](#response-format)

- [Include a User-Agent header in all requests](#include-a-user-agent-header-in-all-requests)

- [The Selling Partner API sandbox](#the-selling-partner-api-sandbox)

  - [How to make a sandbox call to the Selling Partner API](#how-to-make-a-sandbox-call-to-the-selling-partner-api)

    - [Step 1. Check the JSON file for request parameters](#step-1-check-the-json-file-for-request-parameters)

    - [Step 2. Make a sandbox call to an API](#step-2-make-a-sandbox-call-to-an-api)

  - [Selling Partner API sandbox endpoints](#selling-partner-api-sandbox-endpoints)

- [Vendor Central URLs](#vendor-central-urls)

# What is the Selling Partner API?

The Selling Partner API is a REST-based API that helps vendors programmatically access their data to automate their business by increasing efficiency, reducing labor requirements, and improving response time to customers.

## Selling Partner API endpoints

Selling Partner API endpoints are associated with a particular AWS Region. The AWS Region is important because it is part of the credential scope, which is required for calculating a signature when making a request to the Selling Partner API. See [Credential scope](#credential-scope).

**Selling Partner API endpoints**

| **Geographic region**                                                            | **Endpoint**                            | **AWS Region** |
| -------------------------------------------------------------------------------- | --------------------------------------- | -------------- |
| North America (Canada, US, Mexico, and Brazil marketplaces)                      | https://sellingpartnerapi-na.amazon.com | us-east-1      |
| Europe (Spain, UK, France, Germany, Italy, Turkey, U.A.E and India marketplaces) | https://sellingpartnerapi-eu.amazon.com | eu-west-1      |
| Far East (Singapore, Australia, and Japan marketplaces)                          | https://sellingpartnerapi-fe.amazon.com | us-west-2      |

# About vendor groups

When you authorize your Selling Partner API application to access your data, you are granting access to the vendor group that is associated with the sign-in credentials for your Vendor Central account. By extension, you are granting access to all of the vendor codes present in the vendor group. Therefore it's important to use the right Vendor Central credentials and vendor group for your Selling Partner API integration.

# Using a single vendor group

If you use a single vendor group to manage all of your vendor codes, you can authorize an application to access the data in that vendor group. To do this, [register as a developer](#registering-as-a-developer) using the credentials for the Vendor Central account associated with the vendor group.

To be sure that your vendor group contains all of the vendor codes that you want your application to access, [check the vendor codes in your vendor group](#to-check-the-vendor-codes-in-your-vendor-group). If you need to, you can [add or remove vendor codes from your vendor group](#to-add-or-remove-vendor-codes-from-your-vendor-group) at any time.

## To check the vendor codes in your vendor group

1.  Go to [Vendor Central](https://vendorcentral.amazon.com) for your marketplace. See [Vendor Central URLs](#vendor-central-urls) for a list of URLs by marketplace.

2.  Sign in using the credentials for the Vendor Central account with the vendor group that you want your application to access.

3.  On the **Settings** menu, click **Contacts**.

4.  Review the **Contacts** page to determine if the vendor codes that you want your application to access are present.

## To add or remove vendor codes from your vendor group

1.  Go to [Vendor Central](https://vendorcentral.amazon.com) for your marketplace. See [Vendor Central URLs](#vendor-central-urls) for a list of URLs by marketplace.

2.  Sign in using the credentials for the Vendor Central account with the vendor group for which you want to add or remove vendor codes.

3.  Click the **Support** link at the top of the page.

4.  On the **Support** page, click the **Contact Us** button.

5.  On the **Contact Amazon support** page, click **Settings and Account Management**, then choose **Account Settings**.

6.  In the **Settings and Account Management** box, at the bottom, click **Still need help?**.

7.  Follow the instructions to contact Amazon support.

# Using multiple vendor groups

Perhaps you use multiple vendor groups to manage your vendor codes. If so, for Selling Partner API integrations we recommend that you either 1) [Create a new vendor group](#to-create-a-new-vendor-group) containing all of the vendor codes you need, or 2) Choose an existing vendor group and add the vendor codes that you need. You can add or remove vendor codes in a vendor group at any time. However once you have registered as a developer, you cannot change the vendor group associated with that developer. If you want to maintain separate API integrations for different businesses, you can. To do this, register as a developer separately for each vendor group that you want to access. Then you can develop separate API integrations with each registered developer.

## To create a new vendor group

1.  Go to [Vendor Central](https://vendorcentral.amazon.com) for your marketplace. See [Vendor Central URLs](#vendor-central-urls) for a list of URLs by marketplace.

2.  Sign in using the credentials for the Vendor Central account with the vendor group that you want your application to access.

3.  Click the **Support** link at the top of the page.

4.  On the **Support** page, click the **Contact Us** button.

5.  On the **Contact Amazon support** page, click **Settings and Account Management**, then choose **Account Settings**.

6.  In the **Settings and Account Management** box, at the bottom, click **Still need help?**.

7.  Follow the instructions to contact Amazon support.

# Registering as a developer

You must register as a Selling Partner API developer before you can register your Selling Partner API application.

**To register as a developer**

1.  Sign into [Vendor Central](https://vendorcentral.amazon.com) for your marketplace with the credentials that you want to associate with your developer account. See [Vendor Central URLs](#vendor-central-urls) for a list of URLs by marketplace. 

2.  In the **Integration** menu, click **API Integration**.

   The **Developer Central** page appears.

3. Click **Proceed to Developer Profile**.

   The **Developer Profile** page appears.

4. Follow the instructions to register as a developer.

-Or-

1. Go directly to the Developer Profile page for your marketplace and sign in. For example, https://vendorcentral.amazon.com/developer/register for the US marketplace.

   The **Developer Profile** page appears.

   **Note**: The link to the developer profile page above is for the US marketplace. To create a URL for another region, start with the base URL for Vendor Central for that marketplace, and then append `/developer/register`. See [Vendor Central URLs](#vendor-central-urls) for a list of URLs by marketplace. 

   For example, the base URL for Vendor Central for the UK marketplace is `https://vendorcentral.amazon.co.uk`, so the URL for the developer profile page is `https://vendorcentral.amazon.co.uk/developer/register`.

2. Follow the instructions to register as a developer.

**To check the status of your Developer Profile application**

Once you have submitted your developer profile application, Amazon evaluates the information provided and approves or denies your request. If denied, you can address the reason for the denial and then  resubmit your profile. To check the status of your developer profile application while it is under review:

1. Sign into Vendor Central with the credentials that you used when you created your developer profile.

2. In the **Integration** menu, click **API Integration**.

   The **Developer Central** page appears. 

3. Follow the instructions in the **Your developer registration is under review** banner. The banner will change to reflect the status of your application.

After we have registered you as a developer, you can [register your Selling Partner API application](#registering-your-selling-partner-api-application). To view your application information, see [Viewing your application information](#viewing-your-application-information).

# Registering your Selling Partner API application

The following steps explain how to create and configure IAM (AWS Identity and Access Management) policies and entities with the end goal of creating an IAM role that you provide when you register your application. In this workflow you create an IAM user (with an AWS STS policy attached) that assumes an IAM role that has permissions to call the Selling Partner API.

Here are the steps to register as a developer and register an application for the Selling Partner API.

[Step 1. Create an AWS account](#step-1-create-an-aws-account)

[Step 2. Create an IAM user](#step-2-create-an-iam-user)

[Step 3. Create an IAM policy](#step-3-create-an-iam-policy)

[Step 4. Create an IAM role](#step-4-create-an-iam-role)

[Step 5. Add an AWS Security Token Service policy to your IAM user](#step-5-add-an-aws-security-token-service-policy-to-your-iam-user)

[Step 6. Register your application](#step-6-register-your-application)

## Step 1. Create an AWS account

You need an AWS account because the Selling Partner API security model uses AWS authentication credentials. If you’re not already an AWS customer, you can create a free AWS account. For more information, see [AWS Free Tier](https://aws.amazon.com/free/). Note that IAM is the only AWS feature required to use the vendor APIs, and is offered at no additional charge to your AWS account.

## Step 2. Create an IAM user

Create an IAM user to get AWS keys to authenticate calls to the Selling Partner API. We recommend creating a new IAM user exclusively for this purpose. Use the IAM user to assume the IAM role that you create in [Step 4. Create an IAM role](#step-4-create-an-iam-role).

We associate your IAM user with your Selling Partner API application during registration.

**To create an IAM user**

1. If you are not already signed in, sign into the AWS Management Console and open the IAM console at <https://console.aws.amazon.com/iam>.

2. In the navigation pane at left, click **Users** and then click **Add user**.

3. Type the user name for the new user. This is the sign-in name for AWS.

4. Select **Programmatic access** and then click **Next: Permissions**.

5. On the **Set Permissions** page, accept the defaults and click the **Next: Tags**. You will set permissions when you [create an IAM role](#step-4-create-an-iam-role).

6. On the **Add tags (optional)** page, add optional tags if you want them and then click **Next: Review**.

7. On the **Review** page, review the choices you have made. You can ignore the **This user has no permissions** warning. You will set permissions when you [create an IAM role](#step-4-create-an-iam-role). When you are ready to proceed, click the **Create user** button.

   The AWS access key ID for your new IAM user is displayed.

8. Click **Show** to view the AWS secret access key. To save the AWS access key, click **Download .csv** and then save the file to a safe location.

   **Important**: This is your only opportunity to view or download your AWS secret access key, which you will need to authenticate your calls to the Selling Partner API. Save the AWS access key ID and AWS secret access key in a safe and secure place. **You will not have access to the AWS access key again after this step**. If you lose your AWS secret access key you will need to create a new IAM user with its own new set of keys.

9. Click **Close**.

10. In the **User name** column, click your new IAM user and make a note of the User ARN. You will need it in [Step 4. Create an IAM role](#step-4-create-an-iam-role).

For more information, see [Creating an IAM User in Your AWS Account](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_users_create.html) in the AWS documentation.

## Step 3. Create an IAM policy

This IAM policy defines permissions to make calls to the Selling Partner API. You will attach it to the IAM role that you create in [Step 4. Create an IAM role](#step-4-create-an-iam-role).

**To create an IAM policy**

1.  Sign into the AWS Management Console and open the IAM console at [console.aws.amazon.com/iam](https://console.aws.amazon.com/iam).

2.  In the navigation pane at left, click **Policies**.

    If this is your first time choosing **Policies**, the **Welcome to Managed Policies** page appears. Click **Get Started**.

3.  Click the **Create policy** button.

4.  Click the **JSON** tab.

5.  Paste the following code into the text box, replacing the existing code, and then click **Review policy**.

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

6.  On the **Review policy** page, type a **Name** and a **Description** (optional) for the policy that you are creating. We recommend naming your IAM policy, <code>SellingPartnerAPI</code>.

7.  Review the policy **Summary** to see the permissions that are granted by your policy, then click the **Create policy** button.

Your new IAM policy appears in the list.

For more information, see [Creating IAM Policies](https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies_create.html) in the AWS documentation.

## Step 4. Create an IAM role

Create an IAM role that trusts the IAM user that you created in [Step 2. Create an IAM user](#step-2-create-an-iam-user) and has permissions to call the Selling Partner API.

**To create an IAM role**

1.  If you are not already signed in, sign into the AWS Management Console and open the IAM console at [console.aws.amazon.com/iam](https://console.aws.amazon.com/iam).

2.  In the navigation pane at left, click **Roles** and then click **Create role** button.

3.  On the **Create role** page, click **Another AWS account**.

4.  In the **Account ID** box, enter the account identifier for the AWS account in which you created your IAM user in [Step 2. Create an IAM user](#step-2-create-an-iam-user), and then click the **Next: Permissions** button.

5.  On the **Attach permissions policies** page, under **Policy name**, select the policy that you created in [Step 3. Create an IAM policy](#step-3-create-an-iam-policy), and then click **Next: Tags.**

    **Tip:** Click **Filter policies** and then select **Customer managed** to narrow your choices.

6.  On the **Add tags (optional)** page, add optional tags if you want them and then click the **Next: Review** button.

7.  On the **Create role** page, enter a role name in the **Role name** box, an optional role description in the **Role description** box, and then click the **Create role** button.

8.  Under **Role name**, click the name of your new role.

    The **Summary** page appears

9.  Save your role ARN. You will need it:

    1.  When you [register your application](#step-6-register-your-application).

    2.  In [Step 5. Add an AWS Security Token Service policy to your IAM user](#step-5-add-an-aws-security-token-service-policy-to-your-iam-user).

For more information, see [Creating a Role to Delegate Permissions to an IAM User](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_create_for-user.html) in the AWS documentation.

## Step 5. Add an AWS Security Token Service policy to your IAM user

Adding an [AWS Security Token Service (AWS STS)](https://docs.aws.amazon.com/STS/latest/APIReference/welcome.html) policy to your IAM user enables you to request temporary AWS access keys that you can use to authenticate your requests to the Selling Partner API. These credentials expire after a set period of time, helping you to control access to your AWS resources.

1.  If you are not already signed in, sign into the AWS Management Console and open the IAM console at [console.aws.amazon.com/iam](https://console.aws.amazon.com/iam).

2.  In the navigation pane at left, click **Users** and then click the user that that you want to add the AWS STS policy to. In this workflow, choose the user you created in [Step 2. Create an IAM user](#step-2-create-an-iam-user). You might choose a different IAM user for other use cases.

3.  On the **Permissions** tab, click **Add inline policy**.

4.  On the **Create policy** page, click **Choose a service**.

5.  Click the **STS** service.

    **Tip.** Type **STS** in the search box to narrow your choices.

6.  Click the arrow next to **Write** to expand it.

7.  Select **AssumeRole**.

8.  Click the arrow next to **Resources** to expand it, and then click **Add** **ARN**.

9.  In the **Add ARN(s)** dialog box, enter the role ARN from [Step 4. Create an IAM role](#step-4-create-an-iam-role) in the **Specify ARN for role** box, click **Add**, and then click the **Review policy** button.

10. On the **Review policy** page, enter a name for your policy in the **Name** box. Review the choices you have made. If you are ready to proceed, click the **Create policy** button.

## Step 6. Register your application

Register your application in Developer Central.

**To register your application**

1.  Sign in to Vendor Central using the credentials that you used to [register as a developer](#registering-as-a-developer).

2. In the **Integration** menu, click **API Integration**.

   The **Developer Central** page appears.

3. Follow the instructions to register your application.

   **Note**: If you have not already filled out the Developer Registration Application Form (DRAF), you will be instructed to complete this form before you can register your application. You will be able to register your application once you have been granted a role. Check your DRAF Case ID to track the status of your submission.
   
   **Important**: When registering your application, the IAM ARN that you provide must be for the IAM entity to which you attached the IAM policy from  [Step 3. Create an IAM policy](#Step-3-Create-an-IAM-policy). In this workflow, that IAM entity is the IAM role from [Step 4. Create an IAM role](#Step-4-Create-an-IAM-role). If you register your application using your IAM user, be sure that the IAM policy is attached to it. Otherwise your calls to the Selling Partner API will fail. We recommend registering your application using an IAM role, as shown in this workflow, to help you better control access to your AWS resources.

# Viewing your application information

After [registering your Selling Partner API application](#registering-your-selling-partner-api-application) you can view your application information on the Developer Central page in Vendor Central.

**To view your application information**

1. Go to Vendor Central for your marketplace. See [Vendor Central URLs](#vendor-central-urls) for a list of URLs by marketplace.

2. Sign in using the credentials for the vendor account that identifies you as a Selling Partner API developer. For more information, see [Registering as a developer](#registering-as-a-developer).

3. In the **Integration** menu, click **API Integration**.

   The **Developer Central** page appears, displaying the application name and the IAM user ARN for each of your registered applications.

4. Click the **View** link for the application for which you want to view Login with Amazon (LWA) credentials.

   The **LWA credentials** box appears, displaying the LWA client identifier for the application authorization.

5. Click the arrow next to **Client secret** to see the LWA client secret for the application authorization.

You will need these LWA credentials to request an LWA access token before making a call to the Selling Partner API. For more information, see [Step 1. Request a Login with Amazon access token](#step-1-request-a-login-with-amazon-access-token).

# Authorizing your application

The authorization model for the Selling Partner API is based on [<u>Login with Amazon</u>](https://developer.amazon.com/docs/login-with-amazon/documentation-overview.html) (LWA), Amazon’s implementation of OAuth 2.0. After [registering as a developer](#registering-as-a-developer) and [registering your Selling Partner API application](#registering-your-selling-partner-api-application), you can authorize your application to call the Selling Partner API to access your vendor account information. For more information about accessing vendor account information, see [About vendor groups](#about-vendor-groups).

**To authorize an application**

1.  Go to Vendor Central for your marketplace. See [Vendor Central URLs](#vendor-central-urls) for a list of URLs by marketplace.

2. Sign in using the credentials for the vendor account that identifies you as a Selling Partner API developer. For more information, see [Registering as a developer](#registering-as-a-developer).

3. In the **Integration** menu, click **API Integration**.

   The **Developer Central** page appears, displaying the application name and the IAM user ARN for each of your registered applications. 

4.  In the **Action** column, next to the application that you want to authorize, click the down arrow next to **Edit App** and then **Authorize**.

5. On the **Authorize application** page, click the **Generate refresh token** button.

The refresh token displays in the **Refresh token** box. 

**Note**: You should save the refresh token. It is not visible again after you leave the page. 

The refresh token is a long-lived token that you exchange for a short-lived access token. An access token must be included with every request to the Selling Partner API. Once an access token is issued it is valid for one hour. The same access token can be used for multiple API calls, until it expires. See [Step 1. Request a Login with Amazon access token](#step-1-request-a-login-with-amazon-access-token).

# Generating a Java SDK with LWA token exchange and authentication

A generated Java SDK makes it easy to call Selling Partner API operations. The SDK handles authorization by exchanging a Login with Amazon (LWA) refresh token for an access token, and authentication by signing requests using AWS Signature Version 4.

These instructions show you how to generate a Java SDK for the Vendor Orders API using [Swagger Code Generator](https://github.com/swagger-api/swagger-codegen) on a computer running Microsoft Windows. The process is the same for users of other operating systems such as macOS or Linux, with the replacement of Windows-specific semantics (for example, <code>C:\\</code>). Although the following procedure is specific to the Vendor Orders operation, you can modify it to generate an SDK for any operation in the Selling Partner API. To do this, copy the swagger file of your choice (rather than vendorOrders.json) into the directory structure. Then modify the code examples, replacing "vendorOrders.json" with the file name of the swagger file that you are using.

**Prerequisites**

To complete this procedure you will need:

- **vendorOrders.json**. This is the Swagger file that you will use to generate the SDK.

- The **sellingpartner-api-aa-java** folder. This folder contains an authorization and authentication library, along with customized templates for the Swagger Code Generator.

These files were included (along with this developer guide) in the SDK that we provided to you.

**To generate a Java SDK with LWA token exchange and authentication**

1.  Install [Java 8 or newer](https://www.oracle.com/technetwork/java/index.html), [Apache Maven 3.6 or newer](http://maven.apache.org/), and [GNU Wget](https://www.gnu.org/software/wget/wget.html) and make them available in your <code>\$PATH</code>.

2.  Open a command prompt window and go to a directory where you want to download the Swagger Code Generator.

3.  Download the latest version of the Swagger Code Generator for Swagger 2.

    For example:

    ```bash
    wget https://repo1.maven.org/maven2/io/swagger/swagger-codegen-cli/2.4.13/swagger-codegen-cli-2.4.13.jar -O swagger-codegen-cli.jar
    ```

    **swagger-codegen-cli.jar** downloads to the current directory.

    **Note:** You can also download from maven.org by directing your browser here: [https://repo1.maven.org/maven2/io/swagger/swagger-codegen-cli/2.4.13/swagger-codegen-cli-2.4.13.jar](https://repo1.maven.org/maven2/io/swagger/swagger-codegen-cli/2.4.13/swagger-codegen-cli-2.4.13.jar)

4.  Copy **vendorOrders.json** and **swagger-codegen-cli.jar** into a directory structure that makes sense for you. For this example, we'll copy them to <code>C:\\SwaggerToCL</code>.

5.  Generate the SDK against the templates in the **sellingpartner-api-aa-java** folder.

    For example:

    ```bash
    java -jar C:\\SwaggerToCL\\swagger-codegen-cli.jar generate -i C:\\SwaggerToCL\\vendorOrders.json -l java -t \[path to clients\\sellingpartner-api-aa-java directory\]/resources/swagger-codegen/templates/ -o C:\\SwaggerToCL\\vendorOrders_JavaCL
    ```

    The SDK is copied to C:\\SwaggerToCL\\vendorOrders_JavaCL

6.  Build the AA (Authorization and Authentication) library and add it as a dependency of the SDK: - Navigate to the **sellingpartner-api-aa-java** folder and run <code>mvn package</code>. This generates a JAR file in a directory containing all of the required dependencies. The folder should be named **sellingpartnerapi-aa-java-1.0-jar-with-dependencies** or something similar.

        - Install the JAR file in your local Maven repository. For example:
        ```bash
        mvn install:install-file -Dfile=\[path to JAR file in "target" folder\] -DgroupId=com.amazon.sellingpartnerapi  > -DartifactId=sellingpartnerapi-aa-java -Dversion=1.0 -Dpackaging=jar
        ```
        For the <code>groupId</code>, <code>artifactId</code>, and <code>version</code> values in the previous example, use the <code>groupId</code>, <code>artifactId</code>, and <code>version</code> values near the top of the **pom.xml** file in the **sellingpartner-api-aa-java** folder.
        
        - Add a dependency on the AA library in the pom.xml of the client library:
        ```xml
        <dependency>
        <groupId>com.amazon.sellingpartnerapi</groupId>
        <artifactId>sellingpartnerapi-aa-java</artifactId>
        <version>1.0</version>
        </dependency>
        ```

    After you have generated your SDK you can use it to make calls to the Selling Partner API. See [Connecting to the Selling Partner API using a generated Java SDK](#connecting-to-the-selling-partner-api-using-a-generated-java-sdk).

# Connecting to the Selling Partner API using a generated Java SDK

These instructions show you how to use a generated Java SDK to make calls to the Selling Partner API. The SDK exposes classes for configuring your AWS and LWA credentials and uses these to exchange LWA tokens and sign requests for you.

For more information, see [Generating a Java SDK with LWA token exchange and authentication](#generating-a-java-sdk-with-lwa-token-exchange-and-authentication).

## Step 1. Configure your AWS credentials

Create an instance of <code>AWSAuthenticationCredentials</code>, using the following parameters:

| **Name**        | **Description**                                                                                                                                 | **Required** |
| --------------- | ----------------------------------------------------------------------------------------------------------------------------------------------- | ------------ |
| **accessKeyId** | Your AWS access key Id. For more information, see [Step 2. Create an IAM user](#step-2-create-an-iam-user).                                     | Yes          |
| **secretKey**   | Your AWS secret access key. For more information, see [Step 2. Create an IAM user](#step-2-create-an-iam-user).                                 | Yes          |
| **region**      | The AWS region to which you are directing your call. For more information, see [Selling Partner API endpoints](#selling-partner-api-endpoints). | Yes          |

Example:

```java
import com.amazon.SellingPartnerAPIAA.AWSAuthenticationCredentials;
AWSAuthenticationCredentials awsAuthenticationCredentials=AWSAuthenticationCredentials.builder()
  .accessKeyId("myAccessKeyId")
  .secretKey("mySecretId")
  .region("us-east-1")
  .build();
```

## Step 2. Configure your AWS credentials provider

Create an instance of <code>AWSAuthenticationCredentialsProvider</code>, using the following parameters:

| **Name**            | **Description**                                                                                           | **Required** |
| ------------------- | --------------------------------------------------------------------------------------------------------- | ------------ |
| **roleArn**         | The ARN of the IAM role that you created in [Step 4. Create an IAM role](#step-4-create-an-iam-role).     | Yes          |
| **roleSessionName** | An identifier for the session that you define. We recommend using a Universally Unique Identifier (UUID). | Yes          |

Example:

```java
import com.amazon.SellingPartnerAPIAA.AWSAuthenticationCredentials;

AWSAuthenticationCredentialsProvider awsAuthenticationCredentialsProvider=AWSAuthenticationCredentialsProvider.builder()
  .roleArn("myroleARN")
  .roleSessionName("myrolesessioname")
  .build();
```

## Step 3. Configure your LWA credentials

Create an instance of <code>LWAAuthorizationCredentials</code>, using the following parameters:

| **Name**         | **Description**                                                                                                                                                             | **Required** |
| ---------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ------------ |
| **clientId**     | Your LWA client identifier. For more information, see [Viewing your application information](#viewing-your-application-information).                                                                   | Yes          |
| **clientSecret** | Your LWA client secret. For more information, see [Viewing your application information](#viewing-your-application-information).                                                                       | Yes          |
| **refreshToken** | The LWA refresh token. Get this value when the vendor authorizes your application. For more information, see [Authorizing your application](#authorizing-your-application). | Yes          |
| **endpoint**     | The LWA authentication server URI.                                                                                                                                          | Yes          |

For example:

```java
import com.amazon.SellingPartnerAPIAA.LWAAuthorizationCredentials;
...
LWAAuthorizationCredentials lwaAuthorizationCredentials = LWAAuthorizationCredentials.builder()
  .clientId("myClientId")
  .clientSecret("myClientSecret")
  .refreshToken("Aztr|...")
  .endpoint("https://api.amazon.com/auth/o2/token")
  .build();
```

## Step 4. Create an instance of the Vendor Orders API and call an operation

With your <code>AWSAuthenticationCredentials</code> and <code>LWAAuthorizationCredentials</code> instances configured you can create an instance of <code>vendorOrdersApi</code> and call an operation.

**Note:** This example is for using an SDK for the Vendor Orders API, generated in [Generating a Java SDK with LWA token exchange and authentication](#generating-a-java-sdk-with-lwa-token-exchange-and-authentication). If you generated an SDK for a different API, replace <code>vendorOrdersApi</code> in the following example with text that matches your API. For example, use <code>vendorShippingAPI</code> for an SDK generated for the Vendor Shipping API.

For example:

```java
vendorOrdersApi vendorOrdersApi = new vendorOrdersApi.Builder()
  .awsAuthenticationCredentials(awsAuthenticationCredentials)
  .lwaAuthorizationCredentials(lwaAuthorizationCredentials)
  .endpoint("https://sellingpartnerapi-na.amazon.com")
  .build();
vendorOrdersApi.getMarketplaceParticipations();
```

# Generating a Java client library

A generated Java client library can help you construct a URI and add headers for making requests. A Java Client library does not help with authorizing and authenticating your request, however. You still need to write code to [request a Login with Amazon access token](#step-1-request-a-login-with-amazon-access-token) and [create and sign your request](#step-4-create-and-sign-your-request).

**Note:** For most Java developers, the easiest way to connect to the Selling Partner API is to use a generated Java SDK that includes authentication and authorization. For more information, see [Generating a Java SDK with LWA token exchange and authentication](#generating-a-java-sdk-with-lwa-token-exchange-and-authentication)**.**

These instructions show you how to generate a Java client library for the Vendor Orders API using [Swagger Code Generator](https://github.com/swagger-api/swagger-codegen) on a computer running Microsoft Windows. The process is the same for users of other operating systems such as macOS or Linux, with the replacement of Windows-specific semantics (for example, C:\\). Although the following procedure is specific to the Vendor Orders operation, you can modify it to generate client libraries for any operation in the Selling Partner API. To do this, copy the swagger file of your choice (rather than vendorOrders.json) into the directory structure. Then modify the code examples, replacing "vendorOrders.json" with the file name of the swagger file that you are using.

**Prerequisites**

To complete this procedure you will need:

- **vendorOrders.json**. This is the Swagger file that you use to generate the SDK.

**To generate a Java client library**

1.  Install [Java 8 or newer](http://java.oracle.com/), [Apache Maven 3.6 or newer](http://maven.apache.org/) and [wget](http://gnuwin32.sourceforge.net/packages/wget.htm) and make them available in your \$PATH.

2.  Go to <https://github.com/amzn/selling-partner-api-models>.

3.  Clone the repository to make a local copy on your computer, if you haven't done so already.

4.  Open a command prompt window and go to a directory where you want to download the Swagger Code Generator.

5.  Download the latest version of the Swagger Code Generator for Swagger 2.

    For example:

    ```bash
    wget http://central.maven.org/maven2/io/swagger/swagger-codegen-cli/2.4.7/swagger-codegen-cli-2.4.7.jar -O swagger-codegencli.jar
    ```

    **swagger-codegen-cli.jar** downloads to the current directory.

    **Note** You can also download from maven.org by directing your browser here: <http://central.maven.org/maven2/io/swagger/swagger-codegen-cli/2.4.7/swagger-codegen-cli-2.4.7.jar>.

6.  Copy **vendorOrders.json** and **swagger-codegen-cli.jar** into a directory structure that makes sense for you. For this example, we’ll copy them to C:\\SwaggerToCL.

7.  Generate the client library.

    For example:

    ```bash
    java -jar C:\\SwaggerToCL\\swagger-codegen-cli.jar generate -i C:\\SwaggerToCL\\vendorOrders.json -l java -o C:\\SwaggerToCL\\vendorOrders.json_JavaCL
    ```

    The client library is copied to C:\\SwaggerToCL\\vendorOrders_JavaCL.

# Connecting to the Selling Partner API

These instructions show the steps for making a call to the Selling Partner API. The instructions are primarily for developers coding in languages other than Java. For developers coding in Java, we recommend using a generated Java SDK, which helps you create the request and makes authorization and authentication much easier. For more information, see [Generating a Java SDK with LWA token exchange and authentication](#generating-a-java-sdk-with-lwa-token-exchange-and-authentication).

Before your application can connect to the Selling Partner API, you must register it and it must be authorized by a selling partner. See [Registering your Selling Partner API application](#registering-your-selling-partner-api-application) and [Authorizing your application](#authorizing-your-application).

## Step 1. Request a Login with Amazon access token

A Login with Amazon (LWA) access token authorizes your application to take certain actions on behalf of a selling partner. An access token expires one hour after it is issued, and must be included with every request to the Selling Partner API.

To request an access token, make a secure HTTP POST to the LWA authentication server (https://api.amazon.com/auth/o2/token) with the following parameters:

| **Name**          | **Description**                                                                                                                      | **Required** |
| ----------------- | ------------------------------------------------------------------------------------------------------------------------------------ | ------------ |
| **grant_type**    | The type of access grant requested. Must be refresh_token.                                                                           | Yes          |
| **refresh_token** | Get this value when you authorize your application to access your selling account. See [Authorizing your application](#authorizing-your-application). | Yes          |
| **client_id**     | Get this value when you register your application. See [Viewing your application information](#viewing-your-application-information).                           | Yes          |
| **client_secret** | Get this value when you register your application. See [Viewing your application information](#viewing-your-application-information).                           | Yes          |

For example:

```http
POST /auth/o2/token HTTP/l.l
Host: api.amazon.com
Content-Type: application/x-www-form-urlencoded;charset=UTF-8 grant_type=refresh_token&refresh_token=Atzr\|IQEBLzAtAhRPpMJxdwVz2Nn6f2y-tpJX2DeX...&client_id=foodev&client_secret=Y76SDl2F
```

**Tip:** To avoid getting an untrusted certificate authority (CA) error when calling the LWA authorization server, be sure to update your trust store so that your application trusts the LWA server.

**cURL**

If you prefer, you can use cURL to request the access token instead. For example:

```bash
curl -k -X POST -H 'Content-Type: application/x-www-form-urlencoded' -d 'grant_type=refresh_token& refresh_token=Atzr\|IQEBLzAtAhRPpMJxdwVz2Nn6f2y-tpJX2DeX...&client_id=foodev&client_secret=Y76SDl2F https://api.amazon.com/auth/O2/token
```

**Response**

A successful response includes the following values:

| **Name**          | **Description**                                                                |
| ----------------- | ------------------------------------------------------------------------------ |
| **access_token**  | The access token. Maximum size: 2048 bytes.                                    |
| **token_type**    | The type of token returned. Must be bearer.                                    |
| **expires_in**    | The number of seconds before the access token becomes invalid.                 |
| **refresh_token** | The refresh token that you submitted in the request. Maximum size: 2048 bytes. |

For example:

```http
HTTP/l.l 200 OK
Content-Type: application/json;charset UTF-8
Cache-Control: no-store
Pragma: no-cache
{
  "access_token":"Atza|IQEBLjAsAhRmHjNgHpi0U-Dme37rR6CuUpSREXAMPLE",
  "token_type":"bearer",
  "expires_in":3600,
  "refresh_token":"Atzr|IQEBLzAtAhRPpMJxdwVz2Nn6f2y-tpJX2DeXEXAMPLE"
}
```

For more information, see [Authorization Code Grant](https://developer.amazon.com/docs/login-with-amazon/authorization-code-grant.html) in the Login with Amazon documentation.

## Step 2. Construct a Selling Partner API URI

Here are the components of a Selling Partner API URI:

<table><tbody><tr class="odd"><td><b>Name</b></td><td><b>Description</b></td><td><b>Example</b></td></tr><tr class="even"><td><b>HTTP method</b></td><td>The HTTP method</a>.</td><td>GET</td></tr><tr class="odd"><td><b>Endpoint</b></td><td>A <a href="#selling-partner-api-endpoints">Selling Partner API endpoint</a>.</td><td>https://sellingpartnerapi-eu.amazon.com</td></tr><tr class="even"><td><b>Path</b></td><td>Selling Partner API section/version number of the section/resource.</td><td><code>vendor/orders/v1/purchaseOrders</code></td></tr><tr class="odd"><td><b>Query string</b></td><td>The query parameters.</td><td><code>?limit={example}&amp;createdAfter={example}&amp;createdBefore={example}&amp;sortOrder={example}&amp;nextToken={example}&amp;includeDetails={example}</code></td></tr></tbody></table>

For example:

```http
GET https://sellingpartnerapi-eu.amazon.com/vendor/orders/v1/purchaseOrders?limit={example}&createdAfter={example}&createdBefore={example}&sortOrder={example}&nextToken={example}&includeDetails={example}
```

<span id="_bookmark20" class="anchor"></span>**Note:** If you are creating an application using Java, you can use a generated Java client library to help you construct a URI. For more information, see [Generating a Java client library](#generating-a-java-client-library).

## Step 3. Add headers to the URI

Add headers to the URI that you constructed in [Step 2. Construct a Selling Partner API URI](#step-2-construct-a-selling-partner-api-uri).

Here are the HTTP headers that you include in requests to the Selling Partner API:

**Request headers**

<table>
<tbody>
<tr class="odd"><td><b>Name</b></td><td><p><b>Description</b></p></td><td><p><b>Required</b></p></td></tr>
<tr class="even"><td>host</td><td><p>The Selling Partner endpoint. See <a href="#selling-partner-api-endpoints">Selling Partner API endpoints</a>.</p></td><td><p>Yes</p></td></tr>
<tr class="odd"><td>x-amz-access-token</td><td><p>The Login with Amazon access token. See <a href="#step-1-request-a-login-with-amazon-access-token">Step 1. Request a Login with Amazon access token</a>.</p></td><td><p>Yes</p></td></tr>
<tr class="even"><td>x-amz-date</td><td><p>The date and time of your request</p></td><td><p>Yes</p></td></tr><tr class="odd"><td>user-agent</td><td><p>Your application name and version number, platform, and programming language. These help us diagnose and fix problems you might encounter with the service. See <a href="#include-a-user-agent-header-in-all-requests">Include a User-Agent header in all requests</a>.</p></td><td><p>Yes</p></td></tr>
</tbody>
</table>

Here is an example of a Selling Partner API request with URI and headers but no signing information:

```http
GET https://sellingpartnerapi-eu.amazon.com/vendor/orders/v1/purchaseOrders?limit={example}&createdAfter={example}&createdBefore={example}&sortOrder={example}&nextToken={example}&includeDetails={example} HTTP/1.1
host: https://sellingpartnerapi-eu.amazon.com
user-agent: My Selling Tool/2.0 (Language=Java/1.8.0.221; Platform=Windows/10)
x-amz-access-token=Atza|IQEBLjAsAhRmHjNgHpi0U-Dme37rR6CuUpSREXAMPLE
x-amz-date: 20190430T123600Z
```

**Note:** If you are creating an application using Java, you can use a generated Java client library to help you add headers to the URI. For more information, see [Generating a Java client library](#generating-a-java-client-library).

To sign a request, see [Step 4. Create and sign your request](#step-4-create-and-sign-your-request).

## Step 4. Create and sign your request

The Selling Partner API uses [Signature Version 4 Signing Process](https://docs.aws.amazon.com/general/latest/gr/signature-version-4.html) for authenticating requests. When you send HTTP requests to the Selling Partner API, you sign the requests so that we can identify who sent them. You sign requests using your AWS access key, which consists of an access key ID and a secret access key. For information about getting your AWS access key, see [Step 3. Create an IAM user](#step-4-provide-your-application-registration-information).

**Note** You need to learn how to sign HTTP requests only when you manually create them. When you use the one of the AWS SDKs to calculate signatures for you, the SDK automatically signs the requests with the access key that you specify when you configure it. When you use an SDK you don't need to learn how to sign requests yourself. Java developers, for example, can use [AWS4Signer.java](https://github.com/aws/aws-sdk-java/blob/master/aws-java-sdk-core/src/main/java/com/amazonaws/auth/AWS4Signer.java) from the AWS SDK for Java as a model for calculating a signature. You can find SDKs for other languages in the [AWS GitHub repository](https://github.com/aws).

To create and sign your request, complete the following:

1.  Create a canonical request

    Follow the instructions in [Task 1: Create a Canonical Request for Signature Version 4](https://docs.aws.amazon.com/general/latest/gr/sigv4-create-canonical-request.html) in the AWS documentation, using this guidance:

    - See [Step 3. Add headers to the URI](#step-3-add-headers-to-the-uri) for an example of an unsigned request to start with when you create your canonical request.
    - Use SHA-256 for the hash algorithm.
    - Do not put authentication information in the query parameters. Put it in the [Authorization header](#authorization-header).

2.  Create a string to sign

    Follow the instructions in [Task 2: Create a String to Sign for Signature Version 4](https://docs.aws.amazon.com/general/latest/gr/sigv4-create-string-to-sign.html) in the AWS documentation, using this guidance:

    - The algorithm designation value is <code>AWS4-HMAC-SHA256</code>
    - To determine the credential scope, see [Credential scope](#credential-scope).

3.  Calculate the signature

    Follow the instructions in [Task 3: Calculate the Signature for AWS Signature Version 4](https://docs.aws.amazon.com/general/latest/gr/sigv4-calculate-signature.html) in the AWS documentation.

4.  Add the signing information

    Follow the instructions in [Task 4: Add the Signature to the HTTP Request](https://docs.aws.amazon.com/general/latest/gr/sigv4-add-signature-to-request.html) in the AWS documentation, using this guidance:

    - Do not add signing information to the query string. Add it to the Authorization header.
    - See [Authorization header](#authorization-header) for details about creating an Authorization header.

The following example shows what a request might look like after you've added the signing information to it using the Authorization header.

```http
GET https://sellingpartnerapi-eu.amazon.com/vendor/orders/v1/purchaseOrders?limit={example}&createdAfter={example}&createdBefore={example}&sortOrder={example}&nextToken={example}&includeDetails={example} HTTP/1.1
Authorization: AWS4-HMAC-SHA256 Credential=AKIDEXAMPLE/20190430/us-east- 1/execute-api/aws4_request, SignedHeaders=host;user-agent;x-amz-access-token, Signature=5d672d79c15b13162d9279b0855cfba6789a8edb4c82c400e06b5924aEXAMPLE
host: https://sellingpartnerapi-eu.amazon.com
user-agent: My Selling Tool/2.0 (Language=Java/1.8.0.221; Platform=Windows/10)
x-amz-access-token=Atza|IQEBLjAsAhRmHjNgHpi0U-Dme37rR6CuUpSREXAMPLE
x-amz-date: 20190430T123600Z
```

### Credential scope

The credential scope is a component of the "string to sign" that you create when you sign a request to the Selling Partner API. See [Step 4. Create and sign your request](#step-4-create-and-sign-your-request).

Credential scope is represented by a slash-separated string of dimensions, as shown in the following table:

<table><tbody><tr class="odd"><td><b>Dimension</b></td><td><b>Description</b></td><td><b>Example</b></td></tr><tr class="even"><td>Date</td><td>An eight-digit string representing the year (YYYY), month (MM), and day (DD) of the request.</td><td>20190430</td></tr><tr class="odd"><td>AWS region</td><td>The region you are sending the request to. See <a href="#selling-partner-api-endpoints">Selling Partner API endpoints</a>.</td><td>us-east-1</td></tr><tr class="even"><td>Service</td><td>The service you are requesting. You can find this value in the endpoint. See [Selling Partner API endpoints](#selling-partner-api-endpoints).</a></td><td>execute-api</td></tr><tr class="odd"><td>Termination string</td><td>A special termination string. For AWS Signature Version 4, the value is aws4_request.</td><td>aws4_request</td></tr></tbody></table>

For example:

```http
20190430/us-east-1/execute-api/aws4_request
```

**Important** The date that you use as part of your credential scope must match the date of your request, as specified in the **x-amz-date** header. For details, see [Handling Dates in Signature Version 4](https://docs.aws.amazon.com/general/latest/gr/sigv4-date-handling.html) in the AWS documentation.

For more information, see [Step 4. Create and sign your request](#step-4-create-and-sign-your-request).

### Authorization header

The Authorization header contains the signing information for a request. Although the header is named "Authorization", the signing information is used for authentication.

Here are the components of an Authorization header:

<table><tbody><tr class="odd"><td><b>Header component</b></td><td><b>Description</b></td></tr><tr class="even"><td>The algorithm used for signing</td><td>The hash algorithm used throughout the signing process. The Selling Partner API requires SHA-256. You specify this in <a href="#step-4-create-and-sign-your-request">Step 4. Create and sign your request</a>.</td></tr><tr class="odd"><td>Credential</td><td>Your AWS access key ID plus the <a href="#credential-scope">Credential scope</a>. You get your AWS access key ID in see <a href="#step-4-provide-your-application-registration-information">Step 3. Create an IAM user</a>.</td></tr><tr class="even"><td>SignedHeaders</td><td>A list of all the HTTP headers that you included with the signed request. For an example, see <a href="#step-3-add-headers-to-the-uri">Step 3. Add headers to the URI</a>.</td></tr><tr class="odd"><td>Signature</td><td>The signature calculated in <a href="#step-4-create-and-sign-your-request">Step 4. Create and sign your request</a>.</td></tr></tbody></table>

For example:

```http
Authorization: AWS4-HMAC-SHA256 Credential=AKIDEXAMPLE/20190430/us-east- 1/execute-api/aws4_request, SignedHeaders=host;user-agent;x-amz-access- token;x-amz-date, Signature=5d672d79c15b13162d9279b0855cfba6789a8edb4c82c400e06b5924aEXAMPLE
```

For more information, see [Step 4. Create and sign your request](#step-4-create-and-sign-your-request).

# Response format

In response to an HTTP request, the Selling Partner API returns response headers and a JSON response message.

**Response headers**

<table><tbody><tr class="odd"><td><b>Name</b></td><td><b>Description</b></td></tr><tr class="even"><td>Content-Length</td><td>Standard HTTP response header.</td></tr><tr class="odd"><td>Content-Type</td><td>Standard HTTP response header.</td></tr><tr class="even"><td>Date</td><td>Standard HTTP response header.</td></tr><tr class="odd"><td>x-amzn-ErrorType</td><td>Error type.</td></tr><tr class="even"><td>x-amzn-RequestId</td><td>Request identifier. Include this if you contact us for support.</td></tr></tbody></table>

**Success response**

If your request is successful, the Selling Partner API returns the data requested. Here is an example of a successful response to a call to the getOrders API.

```http
HTTP/1.1 200 OK
Content-Length: 368
Content-Type: application/json Date: Thu, 07 Jun 2019 22:23:31 GMT
x-amzn-RequestId: 6875f61f-6aa1-11e8-98c6-9b9a3a7283a4

{
  "pagination": {
    "nextToken": "2YgYW55IGNhcm5hbCBwbGVhc3VyZS4"
  },
  "orders": [
    {
      "order": {
        "purchaseOrderNumber": " L8266355",
        "orderDetails": {
          "purchaseOrderDate": "2019-07-16T19:17:34.304Z",
          "purchaseOrderType": "RegularOrder",
          "paymentMethod": "Invoice",
          "buyingParty": {
            "partyId": "NAG1"
          },
          "sellingParty": {
            "partyId": "999US"
          },
          "shipToParty": {
            "partyId": "NAG1"
          },
          "billToParty": {
            "partyId": "NAG1"
          },
          "items": [
            {
              "itemSequenceNumber": "00001",
              "amazonProductIdentifier": " ABC123434",
              "vendorProductIdentifier": "028877454078",
              "title": "Baby Dove Baby Wipes Rich Moisture (50 Pieces)",
              "orderedQuantity": {
                "amount": "10",
                "unitOfMeasure": "Cases",
                "unitSize": "5"
              },
              "isBackOrderAllowed": "N",
              "netCost": {
                "amount": "10.2",
                "currencyCode": "USD"
              }
            }
          ]
        }
      }
    }
  ]
}
```

**Error response**

If your request is unsuccessful, the Selling Partner API returns an error response. Here are the elements of the response message in an error response:

**Response message**

<table><tbody><tr class="odd"><td><b>Element</b></td><td><p><b>Description</b></p></td><td><p><b>Required</b></p></td></tr><tr class="even"><td>code</td><td><p>HTTP status code.</p></td><td><p>Yes</p></td></tr><tr class="odd"><td>message</td><td><p>Explanation of the error condition.</p></td><td><p>Yes</p></td></tr><tr class="even"><td>details</td><td><p>Link to additional information.</p></td><td><p>No</p></td></tr></tbody></table>

Here is an example of an error response:

```http
HTTP/1.1 400 Bad Request
Content-Length: 117
Content-Type: application/json
Date: Fri, 08 Jun 2019 00:48:28 GMT
x-amzn-ErrorType: ValidationException
x-amzn-RequestId: a8c8d99a-6ab5-11e8-b0f8-19363980175b

{
  "code": "400",
  "message": "The request could not be understood by the server due to malformed syntax."
}
```

# Include a User-Agent header in all requests

A User-Agent header identifies your application, its version number, and the platform and programming language that you are using. You must include a User-Agent header with every request that you submit to the Selling Partner API. Doing this helps us to more effectively diagnose and fix problems, helping to improve your experience using the Selling Partner API.

To create a User-Agent header, begin with the name of your application, followed by a forward slash, followed by the version of the application, followed by a space, an opening parenthesis, the Language name value pair, and a closing parenthesis. The Language parameter is a required attribute, but you can add additional attributes separated by semicolons.

The following pseudocode illustrates a minimally acceptable User-Agent header:

<code>AppId/AppVersionId (Language=LanguageNameAndOptionallyVersion)</code>

Here is an example of a User-Agent header that might be used by an external application integrator:

<code>My Selling Tool/2.0 (Language=Java/1.8.0.221; Platform=Windows/10)</code>

If you are a large vendor who is integrating through your own IT department, you might want create a User-Agent header like the following, so the Selling Partner API could help you troubleshoot using the Host attribute:

<code>MyCompanyName/build1611 (Language=Perl; Host=jane.desktop.example.com)</code>

To specify additional attributes, use the format AttributeName=Value;, separating each name value pair with a semicolon. If you need to use a backslash (\\), quote it with another backslash (\\\\). Similarly, quote a forward slash in the application name (\\/), an opening parenthesis in the application version (\\(), an equal sign in the attribute name (\\=), and both a closing parenthesis (\\)), and a semicolon (\\;) in attribute values.

Because the User-Agent header is transmitted in every request, it is a good practice to limit the size of the header. The Selling Partner API will reject a User-Agent header if it is longer than 500 characters.

# The Selling Partner API sandbox

The Selling Partner API provides a sandbox environment that allows you to test your applications without affecting production data or triggering real-world events. Making sandbox calls to the Selling Partner API is identical to making production calls except you direct the calls to the [Selling Partner API sandbox endpoints](#selling-partner-api-sandbox-endpoints). The authorization and authentications models are the same for sandbox calls and production calls. Calling the sandbox endpoints returns static, mocked responses for all Selling Partner APIs. You can refer to these mocked responses in the Swagger model JSON file for the API that you want to call. For more information, see [How to make a sandbox call to the Selling Partner API](#how-to-make-a-sandbox-call-to-the-selling-partner-api).

The Selling Partner API sandbox works like many mocking frameworks, in that it uses pattern matching to return a specified response when the specified parameters are present. A developer receives a response defined in the x-amazon-spds-sandbox-behaviors object when they send a request that matches the specified parameters. 

If the request sent to the sandbox endpoint does not match the parameter values in the x-amazon-spds-sandbox-behaviors object, you will receive a "500 Internal Server Error" in the response. You must be sure to send the request with the exact values specified in the model.

If the API requires any parameters that are not specified in the x-amazon-spds-sandbox-behaviors object, the sandbox provides the response regardless of the parameter values in the request, as long as the request is valid. 

**Important:** The sandbox is for testing functionality, not scalability testing. Calls to sandbox endpoints are subject to these throttling limits: **rate** = 5 requests per second; **burst** = 15.

## How to make a sandbox call to the Selling Partner API

**Prerequisites**

To complete this procedure you will need a Swagger model JSON file (for example, vendorOrders.json).

Swagger model JSON files were included (along with this developer guide) in the SDK that we provided to you.

### Step 1. Check the JSON file for request parameters

1.  Open the JSON file for the API that you want to call.

2.  Search for <code>"x-amazon-spds-sandbox-behaviors"</code>.

The x-amazon-spds-sandbox-behaviors object of the JSON file contains request and response examples for sandbox calls to the API. If the request example contains parameters, use them in the following step.

### Step 2. Make a sandbox call to an API

Make a sandbox call to an API in the same way you would make a production call, with these differences:

1.  If the request object in the <code>x-amazon-spds-sandbox-behaviors</code> object of the JSON file contains one or more parameter/value pairs, specify these in your call.

2.  Direct your call to one of the [Selling Partner API sandbox endpoints](#selling-partner-api-sandbox-endpoints).

You should receive a response that matches the payload object contained in the <code>x-amazon-spds-sandbox-behaviors</code> object of the JSON file.

## Selling Partner API sandbox endpoints

The Selling Partner API has sandbox endpoints for the North America, Europe, and Far East selling regions. For more information, see [The Selling Partner API sandbox](#the-selling-partner-api-sandbox).

<table><tbody><tr class="odd"><td><b>Selling region</b></td><td><b>Endpoint</b></td><td><p><b>AWS Region</b></p></td></tr><tr class="even"><td>North America (Canada, US, Mexico, and Brazil marketplaces)</td><td><a href="https://sandbox.sellingpartnerapi-na.amazon.com">https://sandbox.sellingpartnerapi-na.amazon.com</a></td><td><p>us-east-1</p></td></tr><tr class="odd"><td>Europe (Spain, UK, France, Germany, Italy, Turkey, U.A.E, and India marketplaces)</td><td><a href="https://sandbox.sellingpartnerapi-eu.amazon.com">https://sandbox.sellingpartnerapi-eu.amazon.com</a></td><td><p>eu-west-1</p></td></tr><tr class="even"><td>Far East (Singapore, Australia, and Japan marketplaces)</td><td><a href="https://sandbox.sellingpartnerapi-fe.amazon.com">https://sandbox.sellingpartnerapi-fe.amazon.com</a></td><td><p>us-west-2</p></td></tr></tbody></table>

# Vendor Central URLs

Here are the Vendor Central URLs by marketplace.

**North America**

| **Marketplace** | **Vendor Central URL**                |
| --------------- | ------------------------------------- |
| Canada          | <https://vendorcentral.amazon.ca>     |
| US              | <https://vendorcentral.amazon.com>    |
| Mexico          | <https://vendorcentral.amazon.com.mx> |

**Europe**

| **Marketplace** | **Vendor Central URL**                |
| --------------- | ------------------------------------- |
| Spain           | <https://vendorcentral.amazon.es>     |
| UK              | <https://vendorcentral.amazon.co.uk>  |
| France          | <https://vendorcentral.amazon.fr>     |
| Germany         | <https://vendorcentral.amazon.de>     |
| Italy           | <https://vendorcentral.amazon.it>     |
| India           | <https://www.vendorcentral.in>        |
| Turkey          | <https://vendorcentral.amazon.com.tr> |
| Netherlands     | <https://vendorcentral.amazon.nl>     |
| U.A.E.          | <https://vendorcentral.amazon.ae>     |

**Far East**

| **Marketplace** | **Vendor Central URL**                |
| --------------- | ------------------------------------- |
| Australia       | <https://vendorcentral.amazon.com.au> |
| Japan           | <https://vendorcentral.amazon.co.jp>  |
| Singapore       | <https://vendorcentral.amazon.com.sg> |

**South America**

| **Marketplace** | **Vendor Central URL**                |
| --------------- | ------------------------------------- |
| Brazil          | <https://vendorcentral.amazon.com.br> |