# 目次

- [出品パートナーAPIとは何ですか？](#what-is-the-selling-partner-api)
   - [出品パートナーAPIのHTTPメソッド](#selling-partner-api-http-methods)

   - [出品パートナーAPIエンドポイント](#selling-partner-api-endpoints)

   - [marketplaceId値](#marketplaceid-values)

- [グローバルアプリケーション](#global-applications)

- [開発者として登録](#registering-as-a-developer)

- [出品パートナーAPIアプリケーションの登録](#registering-your-selling-partner-api-application)

   - [ステップ1.AWSアカウントを作成する](#step-1-create-an-aws-account)

   - [ステップ2.IAMユーザーを作成する](#step-2-create-an-iam-user)

   - [ステップ3.IAMポリシーを作成する](#step-3-create-an-iam-policy)

   - [ステップ4.IAMロールを作成する](#step-4-create-an-iam-role)

   - [ステップ5.IAMユーザーにAWSセキュリティトークンサービスポリシーを追加する](#step-5-add-an-aws-security-token-service-policy-to-your-iam-user)

   - [ステップ6.アプリケーションを登録する](#step-6-register-your-application)

- [開発者情報の表示](#viewing-your-developer-information)

- [出品パートナーAPIアプリケーションの認可](#authorizing-selling-partner-api-applications)

   - [マーケットプレイスアプリストアのワークフロー](#marketplace-appstore-workflow)

      - [ステップ1.マーケットプレイスのアプリストアから認可を開始する](#step-1-the-seller-initiates-authorization-from-the-marketplace-appstore)

      - [ステップ2.出品者がアプリケーションの認可に同意する](#Step-2-The-seller-consents-to-authorize-your-application)

      - [ステップ3.出品者が開発者のウェブサイトにサインインする](#step-3-the-seller-signs-into-your-website)

      - [ステップ4.Amazonから認可情報が送信される](#step-4-amazon-sends-you-the-authorization-information)

      - [ステップ5.アプリケーションでLWA認証コードとLWAリフレッシュトークンを交換する](#step-5-your-application-exchanges-the-lwa-authorization-code-for-an-lwa-refresh-token)

   - [ウェブサイトワークフロー](#website-workflow)

      - [ステップ0.OAuth認可URIを設定する](#Step-0-Set-up-your-OAuth-authorization-URIs)

      - [ステップ1.ウェブサイトから認可を開始する](#Step-1-The-seller-initiates-authorization-from-your-website)

      - [ステップ2.出品者がアプリケーションの認可に同意する](#Step-2-The-seller-consents-to-authorize-the-application)

      - [ステップ3.Amazonから認可情報が送信される](#Step-3-Amazon-sends-you-the-authorization-information)

      - [ステップ4.アプリケーションでLWA認証コードとLWAリフレッシュトークンを交換する](#Step-4-Your-application-exchanges-the-LWA-authorization-code-for-a-LWA-refresh-token)


- [自己認可](#self-authorization-1)

- [LWAトークンの交換と認証を備えたJava SDKの生成](#generating-a-java-sdk-with-lwa-token-exchange-and-authentication)

- [生成されたJava SDKを使用した出品パートナーAPIへの接続](#connecting-to-the-selling-partner-api-using-a-generated-java-sdk)

   - [ステップ1.AWS認証情報の設定](#step-1-configure-your-aws-credentials)

   - [ステップ2.AWS認証情報プロバイダーの設定](#step-2-configure-your-aws-credentials-provider)

   - [ステップ3.LWA認証情報の設定](#step-3-configure-your-lwa-credentials)

   - [ステップ4.出品者APIのインスタンスを作成し、オペレーションを呼び出す](#step-4-create-an-instance-of-the-sellers-api-and-call-an-operation)

- [Javaクライアントライブラリの生成](#generating-a-java-client-library)

- [出品パートナーAPIへの接続](#connecting-to-the-selling-partner-api)

   - [ステップ1.Login with Amazonアクセストークンをリクエストする](#step-1-request-a-login-with-amazon-access-token)

   - [ステップ2.出品パートナーAPIのURIを構築する](#step-2-construct-a-selling-partner-api-uri)

   - [ステップ3.URIにヘッダーを追加する](#step-3-add-headers-to-the-uri)

   - [ステップ4.リクエストの作成と署名](#step-4-create-and-sign-your-request)

      - [認証情報スコープ](#credential-scope)

      - [Authorizationヘッダー](#authorization-header)

- [レスポンスのフォーマット](#response-format)

- [許可不要のオペレーション](#grantless-operations-1)

- [すべてのリクエストにUser-Agentヘッダーを含める](#include-a-user-agent-header-in-all-requests)

- [出品パートナーAPIハイブリッドアプリケーション](#hybrid-selling-partner-api-applications)

- [出品パートナーAPIサンドボックス](#the-selling-partner-api-sandbox)

- [出品パートナーAPIとAmazonマーケットプレイスWebサービスの違いは何ですか？](#how-does-the-selling-partner-api-differ-from-amazon-marketplace-web-service)

# 出品パートナーAPIとは何ですか？

出品パートナーAPIはRESETベースのAPIで、これにより出品者は出品、注文、支払い、レポートなどのデータにプログラムからアクセスすることができます。出品パートナーAPIを使用するアプリケーションは、販売効率を高め、必要な労働量を削減し、顧客への応答時間を短縮し、出品者がビジネスを成長させるのに役立ちます。出品パートナーAPIは、AmazonマーケットプレイスWebサービス（Amazon MWS）の機能に基づいて構築されており、開発者や出品者パートナーの使いやすさとセキュリティを向上させる機能を提供します。

**主な機能**

出品パートナーAPIの使用により、次のことが可能です。

- 出品者がマーケットプレイスアプリストアの詳細ページまたは開発者のウェブサイトから開始できるOAuth認可ワークフローを設定できます。

- LWAトークンの交換と認証を備えたSDKを生成します。

- 出品パートナーAPIとAmazon MWSの両方を呼び出すハイブリッドアプリケーションを作成します。

- サンドボックス環境を呼び出してアプリケーションをテストします。

## 出品パートナーAPIのHTTPメソッド

出品パートナーAPIは、これらのHTTPメソッドをサポートしています。

| **HTTPメソッド** | **説明** |
| --------------- | ------------ |
| GET | リソースデータまたはリソースのリストを取得します。 |
| POST | 指定されたリソースにエンティティを送信します。サーバーの状態に変化が生じたり副作用を引き起こすことがあります。 |
| PUT | ターゲットリソースの現在のすべての表記をリクエストペイロードに置き換えます。 |

<span id="Selling_Partner_API_endpoints" class="anchor">

## 出品パートナーAPIエンドポイント

出品パートナーAPIエンドポイントは、特定のAWSリージョンと関連付けられています。AWSリージョンは、出品パートナーAPIを呼び出すときに署名を計算するために必要な認証範囲の一部であるため、重要です。詳細については、[認証情報スコープ](#credential-scope)をご覧ください。

<table>
<thead>
<tr class="header">
<th><strong>出品リージョン</strong></th>
<th><strong>エンドポイント</strong></th>
<th><strong>AWSリージョン</strong></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>北米（カナダ、米国、メキシコ、ブラジルのマーケットプレイス）</td>
<td>https://sellingpartnerapi-na.amazon.com</td>
<td>us-east-1</td>
</tr>
<tr class="even">
<td>ヨーロッパ（スペイン、英国、フランス、オランダ、ドイツ、イタリア、トルコ、アラブ首長国連邦、インドのマーケットプレイス）</td>
<td>https://sellingpartnerapi-eu.amazon.com</td>
<td>eu-west-1</td>
</tr>
<tr class="odd">
<td>
<p>極東地域（シンガポール、オーストラリア、日本のマーケットプレイス）</p>
</td>
<td>https://sellingpartnerapi-fe.amazon.com</td>
<td>us-west-2</td>
</tr>
</tbody>
</table>

## marketplaceId値

`marketplaceId`は、リクエストに対するマーケットプレイスを識別するものです。

**北米**

| **国名** | **marketplaceId** | **国名コード** |
| ------------------------ | ----------------- | ---------------- |
| カナダ | A2EUQ1WTGCTBG2 | CA |
| アメリカ合衆国 | ATVPDKIKX0DER | 米国 |
| メキシコ | A1AM78C64UM0Y8 | MX |
| ブラジル | A2Q3Y263D00KWC | BR |

**ヨーロッパ**

| **国名** | **marketplaceId** | **国名コード** |
| -------------------- | ----------------- | ---------------- |
| スペイン | A1RKKUPIHCS9HS | ES |
| 英国 | A1F83G8C2ARO7P | GB |
| フランス | A13V1IB3VIYZZH | FR |
| オランダ | A1805IZSGTT6HS | NL |
| ドイツ | A1PA6795UKMFR9 | DE |
| イタリア | APJ6JRA9NG5V4 | IT |
| トルコ | A33AVAJ2PDY3EV | TR |
| アラブ首長国連邦 | A2VIGQ35RCS4UG | AE |
| インド | A21TJRUUN4KGV | IN |

**極東地域**

<table>
<thead>
<tr class="header">
<th>
<strong>国名</strong>
</th>
<th>
<strong>marketplaceId</strong>
</th>
<th><strong>国名コード</strong></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>シンガポール</td>
<td>A19VAU5U5O7RUS</td>
<td>SG</td>
</tr>
<tr class="even">
<td>オーストラリア</td>
<td>A39IBJ37TRP1C6</td>
<td>AU</td>
</tr>
<tr class="odd">
<td>日本</td>
<td>A1VC38T7YXB528</td>
<td>JP</td>
</tr>
</tbody>
</table>

# グローバルアプリケーション

選択したリージョンおよびマーケットプレイスで開発者として一度登録するだけで、任意のリージョンまたはマーケットプレイスから出品者が認可できる出品パートナーAPIアプリケーションを作成できるようになります。エンドポイントがアプリケーションを認可した出品者と同じリージョンのものであれば、任意の出品パートナーAPIエンドポイントを呼び出すために必要な開発者認証情報（AWSアクセスキーIDとAWS秘密キー）のセットは1つだけです。

**重要**[出品パートナーAPIハイブリッドアプリケーションを使用している場合](#hybrid-selling-partner-api-applications)、Amazonマーケットプレイスウェブサービス（Amazon MWS）エンドポイントへの呼び出しには、Amazon MWSアプリケーションと同じ制限があります。つまり、Amazon MWSエンドポイントを呼び出すときは、エンドポイントを取得したリージョンに関連付けられたAmazon MWSアクセスキーを使用する必要があります。

詳細については、[出品パートナーAPIエンドポイント](#Selling_Partner_API_endpoints)をご覧ください。

# 開発者として登録

出品パートナーAPIアプリケーションを登録する前に、出品パートナーAPI開発者として登録する必要があります。

**開発者として登録するには**

1. 開発者アカウントに関連付ける認証情報を使用して、セラーセントラルにサインインします。

2. **アプリとサービス**メニューの**アプリの開発**をクリックします。

   **デベロッパーセントラル**ページが表示されます。

3. 指示に従って開発者として登録します。

デベロッパーとして登録されたら、[出品パートナーAPIアプリケーションを登録](#registering-your-selling-partner-api-application)できます。開発者情報を表示するには、[開発者情報の表示](#viewing-your-developer-information)をご覧ください。

# 出品パートナーAPIアプリケーションの登録

以下の手順では、アプリケーションの登録時に提供するIAMロールを作成する目標として、IAMポリシーとエンティティを作成および設定する方法について説明します。このワークフローでは、出品パートナーAPIを呼び出すアクセス権限を持つIAMロールを継承するIAMユーザー（[AWS STS](https://docs.aws.amazon.com/STS/latest/APIReference/welcome.html)ポリシーがアタッチされている）を作成します。

**手順**

[ステップ1.AWSアカウントを作成する](#step-1-create-an-aws-account)

[ステップ2.IAMユーザーを作成する](#step-2-create-an-iam-user)

[ステップ3.IAMポリシーを作成する](#step-3-create-an-iam-policy)

[ステップ4.IAMロールを作成する](#step-4-create-an-iam-role)

[ステップ5.IAMユーザーにAWSセキュリティトークンサービスポリシーを追加する](#step-5-add-an-aws-security-token-service-policy-to-your-iam-user)

[ステップ6.アプリケーションを登録する](#step-6-register-your-application)

## ステップ1.AWSアカウントを作成する

出品パートナーAPIセキュリティモデルではAWS認証情報が使用されるため、AWSアカウントが必要です。AWSカスタマーでない場合は、無料のAWSアカウントを作成できます。詳しくは、[AWS無料利用枠](https://aws.amazon.com/free)をご覧ください。

## ステップ2.IAMユーザーを作成する

IAMユーザーを作成して、出品パートナーAPIへの呼び出しを認証するためのAWSキーを取得します。この目的のためだけでも新たにIAMユーザーを作成することをお勧めします。IAMユーザーを使用して、[ステップ4.IAMロールを作成する](#step-4-create-an-iam-role)で作成したIAMロールを継承します。

**IAMユーザーを作成するには**

1. まだサインインしていない場合は、AWSマネジメントコンソールにサインインし、[console.aws.amazon.com/iam](https://console.aws.amazon.com/iam)でIAMコンソールを開きます。

2. 左側のナビゲーションペインで、**ユーザー**をクリックし、**ユーザーを追加**ボタンをクリックします。

3. 新しいユーザーのユーザー名を入力します。

4. **プログラムによるアクセス**を選択し、**次のステップ： アクセス権限**ボタンをクリックします。

5. **権限の設定**ページで、デフォルトを受け入れ**次のステップ： タグをクリックします。**[IAMロールを作成する](#step-4-create-an-iam-role)ときにアクセス許可を設定します。

6. **タグの追加（オプション）**ページで、必要に応じてオプションのタグを追加し、**次のステップ： 確認**ボタンをクリックします。

7. **確認**ページで、選択した内容を確認します。**このユーザーには権限がありません**という警告は無視できます。[IAMロールを作成する](#step-4-create-an-iam-role)ときにアクセス許可を設定します。続行する準備ができたら、**ユーザーの作成**ボタンをクリックします。

   新しいIAMユーザーのAWSアクセスキーIDが表示されます。

8. **表示**をクリックすると、AWS秘密キーが表示されます。AWSアクセスキーを保存するには、**.csvのダウンロード**をクリックし、ファイルを安全な場所に保存します。

   **重要**これは、AWS秘密キーを表示またはダウンロードする唯一の機会です。この秘密キーは、出品パートナーAPIの呼び出しを認証する際に必要となります。AWSアクセスキーIDとAWS秘密キーを安全かつ安全な場所に保存します。**このステップの後でAWSアクセスキーに再度アクセスすることはできません。**AWS秘密キーを紛失した場合は、新しいキーセットを使用して新たにIAMユーザーを作成する必要があります。

9. **閉じる**をクリックします。**ユーザー名**列で新しいIAMユーザーをクリックし、ユーザーARNを書き留めます。これは[ステップ4.IAMロールを作成する](#step-4-create-an-iam-role)で作成したIAMロールを継承します。

詳しくは、AWSドキュメントの[AWSアカウントでのIAMユーザーの作成](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_users_create.html)をご覧ください。

## ステップ3.IAMポリシーを作成する

このIAMポリシーは、出品パートナーAPIを呼び出すためのアクセス権限を定義します。[ステップ4.IAMロールを作成する](#step-4-create-an-iam-role)で作成したIAMロールを継承します。

**IAMポリシーを作成するには**

1. AWS管理コンソールにサインインし、[console.aws.amazon.com/iam](https://console.aws.amazon.com/iam)でIAMコンソールを開きます。

2. 左側のナビゲーションペインで、**ポリシー**をクリックします。

   **ポリシー**を初めて選択する場合は、**管理ポリシーにようこそ**ページが表示されます。**開始する**をクリックします。

3. **ポリシーの作成**ボタンをクリックします。

4. **JSON**タブをクリックします。

5. テキストボックスに次のコードを貼り付け、既存のコードを置き換え、**ポリシーの確認**をクリックします。
```
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

6. **ポリシーの確認**ページで、作成するポリシーの**名前**と**説明**（任意）を入力します。IAMポリシーには`Selling Partner API`の名前を付けることをお勧めします。

7. ポリシーの**概要**を確認して、ポリシーによって付与された権限を確認し、**ポリシーの作成**ボタンをクリックします。

   新しいIAMポリシーがリストに表示されます。

詳しくは、AWSドキュメントの[IAMポリシーの作成](https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies_create.html)をご覧ください。

## ステップ4.IAMロールを作成する

[ステップ2.IAMユーザーを作成する](#step-4-create-an-iam-role)で作成したIAMユーザーを信頼し、出品パートナーAPIを呼び出すアクセス許可を持つIAMロールを作成します。

**IAMロールを作成するには**

1. まだサインインしていない場合は、AWSマネジメントコンソールにサインインし、[console.aws.amazon.com/iam](https://console.aws.amazon.com/iam)でIAMコンソールを開きます。

2. 左側のナビゲーションペインで、**ロール**をクリックし、**ロールを作成**ボタンをクリックします。

3. **ロールを作成**ページで、**別のAWSアカウント**をクリックします。

4. **アカウントID**ボックスに、[ステップ2.IAMユーザーを作成する](#step-4-create-an-iam-role)でIAMユーザーを作成した AWSアカウントのアカウントIDを入力し、**次のステップ： アクセス権限**ボタンをクリックします。

5. **アクセス許可ポリシーの添付**ページの**ポリシー名**で、[ステップ3.IAMポリシーを作成する](#step-2-create-an-iam-user)で作成したポリシーを選択し、**次のステップ： タグ**をクリックします。

   **ヒント：****フィルタポリシー**をクリックし、**カスタマー管理**を選択して選択を絞り込みます。

6. **タグの追加（オプション）**ページで、必要に応じてオプションのタグを追加し、**次のステップ： 確認**ボタンをクリックします。

7. **ロールを作成**ページで、**ロール名**ボックスにロール名を入力し、**ロールの説明**ボックスにオプションのロールの説明を入力し、**ロールを作成**ボタンをクリックします。

8. **ロール名**で、新しいロールの名前をクリックします。

   **概要**ページが表示されます。

9. ロールのARNを保存します。これは以下で必要となります。

   1. [アプリケーションを登録する](#step-6-register-your-application)とき。

   2. [ステップ5.アプリケーションでLWA認証コードとLWAリフレッシュトークンを交換する](#step-5-your-application-exchanges-the-lwa-authorization-code-for-an-lwa-refresh-token)

詳細については、AWSドキュメントの[IAMユーザーに権限を委任するロールの作成](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_create_for-user.html)をご覧ください。

## ステップ5.IAMユーザーにAWSセキュリティトークンサービスポリシーを追加する

[AWSセキュリティトークンサービス（AWS STS）](https://docs.aws.amazon.com/STS/latest/APIReference/welcome.html)ポリシーをIAMユーザーに追加すると、出品パートナーAPIへのリクエストの認証に使用できる一時的なAWSアクセスキーをリクエストできます。これらの認証情報は、一定期間が経過すると期限切れになり、AWSリソースへのアクセスを制御するのに役立ちます。

1. まだサインインしていない場合は、AWSマネジメントコンソールにサインインし、[console.aws.amazon.com/iam](https://console.aws.amazon.com/iam)でIAMコンソールを開きます。

2. 左側のナビゲーションペインで、**ユーザー**をクリックし、[ステップ2.IAMユーザーを作成する](#step-4-create-an-iam-role)で作成したユーザーをクリックします。

3. 左側のナビゲーションペインで、**ユーザー**をクリックし、AWS STSポリシーを追加するユーザーをクリックします。このワークフローでは、[ステップ2.IAMユーザーを作成する](#step-4-create-an-iam-role)で作成したユーザーを選択します。他のユースケースでは別のIAMユーザーを選択することもできます。

4. **アクセス許可**タブで、**インラインポリシーの追加**をクリックします。

5. **ポリシーの作成**ページで、**サービスの選択**をクリックします。

6. **STS**サービスをクリックします。

   **ヒント。**検索ボックスに**STS**と入力して、選択肢を絞り込みます。

7. **書き込み**の横にある矢印をクリックして展開します。

8. **ロールを継承**を選択します。

9. **リソース**の横にある矢印をクリックして展開し、**ARN****を追加**をクリックします。

10. **ARNを追加**ダイアログボックスで、[ステップ4.IAMロールを作成する](#step-4-create-an-iam-role)のロールARNを**ロールのARNを指定**ボックスに入力し、**追加**をクリックし、**ポリシーの確認**ボタンをクリックします。

11. **ポリシーの確認**ページで、**名前**ボックスにポリシーの名前を入力します。選択した内容を確認します。続行する準備ができたら、**ポリシーの作成**ボタンをクリックします。

## ステップ6.アプリケーションを登録する

デベロッパーセントラルでアプリケーションを登録します。

**アプリケーションを登録するには**

1. [開発者登録](#registering-as-a-developer)に使用した認証情報を使用して、セラーセントラルにサインインします。

2. **アプリとサービス**メニューの**アプリの開発**をクリックします。

   **デベロッパーセントラル**ページが表示されます。

3. 指示に従ってアプリケーションを登録します。

# 開発者情報の表示

[出品パートナーAPIアプリケーションを登録](#registering-as-a-developer)すると、デベロッパーセントラルにサインインして開発者情報を表示できます。

**開発者情報を表示するには**

1. [開発者登録](#registering-as-a-developer)に使用した認証情報を使用して、セラーセントラルにサインインします。

2. **アプリとサービス**メニューの**アプリの開発**をクリックします。

   **デベロッパーセントラル**ページが表示され、アプリケーションに関連付けられたIAM ARNが表示されます。

3. 目的のアプリケーションの**LWA認証情報**の下の**表示**をクリックします。

   そのアプリケーションのLWAクライアントIDとクライアントシークレットが表示されます。LWAアクセストークンをリクエストするには、これらの認証情報が必要です。詳細については、[ステップ1.Login with Amazonアクセストークンをリクエストする](#step-1-request-a-login-with-amazon-access-token)をご覧ください。

# 出品パートナーAPIアプリケーションの認可

出品パートナーAPIの認可モデルは、AmazonのOAuth 2.0実装である[Login with Amazon](https://developer.amazon.com/docs/login-with-amazon/documentation-overview.html)に基づくものです。このモデルでは、出品パートナーは、Amazonおよび開発者のウェブサイトで表示されるページとやり取りすることで、アプリケーションを認可します。出品パートナーのアクションによって、開発者のウェブサイトまたはAmazonのレスポンスが発生します。出品パートナーのブラウザーはユーザーエージェントとなり、出品パートナーがアクションを起こすたびに、開発者のウェブサイトとAmazonの間でパラメーターを渡します。OAuth認証を実装するには、（1）Amazonから渡されるパラメーターを受け入れて処理し、（2）出品パートナーのブラウザーをリダイレクトしてAmazonにパラメーターを渡すように、開発者のウェブサイトを設定する必要があります。

出品パートナーは、次のいずれかのワークフローを使用してアプリケーションを認可できます。

- [マーケットプレイスアプリストアのワークフロー](#marketplace-appstore-workflow)。マーケットプレイスアプリストアの詳細ページから開始されるOAuth認可ワークフロー。

- [ウェブサイトワークフロー](#website-workflow)。開発者のウェブサイトから開始されるOAuth認可ワークフロー。

## 許可不要のオペレーション

許可不要のオペレーションとは、出品パートナーからの明示的な認可なしに呼び出すことができるオペレーションです。この認可モデルでは、他の出品パートナーAPIオペレーションを呼び出す際とは異なり、LWA認証コードとリフレッシュトークンを受け取り、交換して、LWAアクセストークンを取得する必要はありません。代わりに、LWA認可サーバーの1回の呼び出しでLWAアクセストークンを取得します。

## 自己認可

自身の出品用アカウント用のアプリケーションを開発している場合は、自分で認証できます。詳細については、[自己認証](#self-authorization-1)をご覧ください。

### AmazonマーケットプレイスWebサービスからの承認の移行

また、出品パートナーの代わりに開発者がAmazonマーケットプレイスウェブサービスを呼び出すことについて出品パートナーが許可している場合は、開発者はAuthorization APIを使用して、その認可を出品パートナーAPIハイブリッドアプリケーションに移行できます。これにより、出品パートナーに再度認可をリクエストする必要がなくなります。詳しくは、Authorization API User Guideをご覧ください。

## マーケットプレイスアプリストアのワークフロー

マーケットプレイスアプリストアのワークフローは、マーケットプレイスアプリストアの詳細ページから開始されるOAuth認可ワークフローです。マーケットプレイスアプリストアで出品パートナーAPIアプリケーションを公開すると、出品者は詳細ページの**今すぐ認可**ボタンをクリックすることでそのアプリケーションを認可できます。

このトピックには、マーケットプレイスアプリストアのワークフロー手順と、ワークフローのテストに関する情報が含まれています。

**マーケットプレイスアプリストアワークフローのテスト**

実稼働のマーケットプレイスアプリストアのワークフローを作成する前に、ドラフト状態でアプリケーションを認可できるテストワークフローを作成することが重要です。テストワークフローは、最終的な実稼動ワークフローとまったく同じではありません。それでも、アプリケーションによってパラメーターをAmazonと交換し、認可情報を受け取ることができるかどうかをテストできます。

テストワークフローと実稼働ワークフローの違いは次のとおりです。

- マーケットプレイスアプリストアの詳細ページから開始する代わりに、出品者がアプリケーションのOAuth認可URIに直接移動することでも、テストワークフローを開始できます。信頼できる出品者と連携してテストすることも、自身の出品用アカウントの認証情報を使用してワークフローをテストすることもできます。OAuth認可URIには、`version=beta`パラメーターを含めることで、ワークフローがドラフト状態のアプリケーションを認可していることを示す必要があります。出品者がOAuth認可URIに移動すると、ワークフローは[ステップ2で続行されます。出品者がアプリケーションの認可に同意する](#step-2-the-seller-consents-to-authorize-your-application)

   **注意：**複数リージョンのOAuth認可URIがある場合は、出品するリージョンに対応するOAuth認可URIを出品者に提供してください。

- アプリケーションによって、[ステップ3のAmazonコールバックURIに`version=beta`パラメーターが追加されます。出品者が開発者のウェブサイトにサインインする](#step-3-the-seller-signs-into-your-website)これにより、ワークフローでアプリケーションがドラフト状態で認可されます。

ワークフローのテストが完了したら、[ステップ3のAmazonコールバックURIに`version=beta`パラメーターがこれ以上追加されないよう、ワークフローを更新します。出品者が開発者のウェブサイトにサインインする](#step-3-the-seller-signs-into-your-website)これにより、実稼動ワークフローとなります。これで、すべての出品者は、マーケットプレイスアプリストアの詳細ページから公開されたアプリケーションを認可できるようになります。

実稼動ワークフローが[ステップ1で開始します。マーケットプレイスのアプリストアから認可を開始する](#step-1-the-seller-initiates-authorization-from-the-marketplace-appstore)

**手順**

[ステップ1.マーケットプレイスのアプリストアから認可を開始する](#Step-1-The-seller-initiates-authorization-from-the-Marketplace-Appstore)

[ステップ2.出品者がアプリケーションの認可に同意する](#Step-2-The-seller-consents-to-authorize-your-application)

[ステップ3.出品者が開発者のウェブサイトにサインインする](#Step-3-The-seller-signs-into-your-website)

[ステップ4.Amazonから認可情報が送信される](#Step-4-Amazon-sends-you-the-authorization-information)

[ステップ5.アプリケーションでLWA認証コードとLWAリフレッシュトークンを交換する](#Step-5-Your-application-exchanges-the-LWA-authorization-code-for-an-LWA-refresh-token)

### ステップ1.マーケットプレイスのアプリストアから認可を開始する

1. 出品者がセラーセントラルにサインインし、マーケットプレイスアプリストアに移動します。

2. 出品者はアプリケーションの詳細ページに移動し、**今すぐ認可**ボタンをクリックします。アプリケーションの同意ページが表示されます。

### ステップ2.出品者がアプリケーションの認可に同意する

1. 同意ページが表示されたら、出品者はアプリケーションによって要求されたデータアクセスを確認して同意し、**\[アプリケーション名\]に今すぐログイン**ボタンをクリックして続行します。**キャンセル**ボタンをクリックして、認可せずに終了することもできます。

2. AmazonによってサインインURI（アプリケーション登録時に指定したURI）がブラウザーにロードされ、次のクエリパラメーターが追加されます。

| **パラメーター** | **説明** |
| ------------------------- | ------------------  |
| **amazon\_callback\_uri** | ブラウザーをAmazonにリダイレクトするためのURI。 |
| **amazon\_state** | クロスサイトリクエストフォージェリ攻撃から保護するためにAmazonによって生成される状態値。 |
| **selling\_partner\_id** | アプリケーションを認可している出品者の出品者ID。 |

**注意：**これがテストワークフローの場合（出品者が開発者のOAuth認可URIに移動して開始した場合）、`version=beta`パラメーターが含まれます。これが実稼動ワークフローの場合（出品者がマーケットプレイスアプリストアから開始した場合）、このパラメーターは含まれません。

例：
```
https://d2yzyfnnpjylxu.cloudfront.net/index.html?amazon_callback_uri=https://amazon.com/apps/authorize/confirm/amzn1.sellerapps.app.2eca283f-9f5a-4d13-b16c-474EXAMPLE57&amazon_state=amazonstateexample&selling_partner_id=A3FHEXAMPLEYWS
```
ウェブサイトのサインインページが表示されます。

### ステップ3.出品者が開発者のウェブサイトにサインインする

1. 出品者が開発者のウェブサイトにサインインします。出品者がまだアカウントを持っていない場合は、登録プロセスを完了します。

2. AmazonコールバックURI（前のステップでAmazonによって渡されるURI）がブラウザーにロードされ、次のパラメーターが追加されます。

<table>
<thead>
<tr class="header">
<th><strong>パラメーター</strong></th>
<th><strong>説明</strong></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td><strong>redirect_uri</strong></td>
<td>ブラウザーをアプリケーションにリダイレクトするためのURI。</td>
</tr>
<tr class="even">
<td><strong>amazon_state</strong></td>
<td>前のステップでAmazonから渡された<code>amazon_state</code>値。</td>
</tr>
<tr class="odd">
<td><strong>state</strong></td>
<td><p>アプリケーションによって生成された状態値。アプリケーションではこの値を使用して、このリクエストとレスポンス間の状態を維持し、クロスサイトリクエストフォージェリ攻撃から保護します。</p>
<p>重要： OAuth情報はURIクエリパラメーターを介して渡されるため、次の操作を行うことを強くお勧めします。 （1）状態トークンが短期間のみ有効でユーザーのみが検証可能であることを確認し、（2）<code>Referrer-Policy：no-referrer</code> HTTPヘッダーを設定し、ユーザーのウェブサイトがリンクする他ウェブサイトに機密情報を漏洩しないようにします。クロスサイトリクエストフォージェリと状態パラメーターの計算について詳しくは、Login with Amazonドキュメントの<a href="https://developer.amazon.com/docs/login-with-amazon/cross-site-request-forgery.html">クロスサイトリクエストフォージェリ</a>をご覧ください。</p></td>
</tr>
</tbody>
</table>

**注意：**`version=beta`パラメーターを含めると、ワークフローでドラフト状態のアプリケーションが認可されます。このパラメーターを指定しない場合、マーケットプレイスアプリストアで公開されたアプリケーションが認可されます。

例：
```
https://amazon.com/apps/authorize/confirm/amzn1.sellerapps.app.2eca283f-9f5a-4d13-b16c-474EXAMPLE57?redirect_uri=https://d2yzyfnnpjylxu.cloudfront.net/landing.html&amazon_state=amazonstateexample&state=-37131022&version=beta
```
または
```
https://amazon.com/apps/authorize/confirm/amzn1.sellerapps.app.2eca283f-9f5a-4d13-b16c-474EXAMPLE57?redirect_uri=https://d2yzyfnnpjylxu.cloudfront.net/landing.html&amazon_state=amazonstateexample&state=-37131022
```
### ステップ4.Amazonから認可情報が送信される

セラーセントラルに、出品者データへのアクセスが許可されていることを示すページが簡潔に表示されます。そのページが表示されている間に、次のアクションが実行されます。

1. AmazonによってリダイレクトURIがブラウザーにロードされ、次のクエリパラメーターが追加されます。

| **パラメーター** | **説明** |
| ------------------------ | -----------------------|
| **state** | 前の手順で渡した状態値。 |
| **selling\_partner\_id** | アプリケーションを認可している出品者の出品者ID。 |
| **mws\_auth\_token** | Amazonマーケットプレイスウェブサービスを呼び出す際のクエリ文字列を作成するときに使用する**MWSAuthToken**値。mws\_auth\_tokenパラメーターは、出品者が出品パートナーAPIハイブリッドアプリケーションを認可している場合にのみ渡されます。詳しくは、[出品パートナーAPIハイブリッドアプリケーション](#hybrid-selling-partner-api-applications)をご覧ください。 |
| **spapi\_oauth\_code** | LWAリフレッシュトークンと交換するLogin with Amazon（LWA）認証コード。詳細については、[ステップ5.](#step-5-your-application-exchanges-the-lwa-authorization-code-for-an-lwa-refresh-token)[アプリケーションでLWA認証コードとLWA](#step-5-your-application-exchanges-the-lwa-authorization-code-for-an-lwa-refresh-token)[リフレッシュトークンを交換する](#step-5-your-application-exchanges-the-lwa-authorization-code-for-an-lwa-refresh-token)をご覧ください。 |

例：
```
https://client-example.com?state=state-example&mws_auth_token=mwsauthtokenexample&selling_partner_id=sellingpartneridexample&spapi_oauth_code=spapioauthcodeexample
```
2. アプリケーションによってstate値が検証されます。

3. selling\_partner\_id、mws\_auth\_token（渡された場合）、およびspapi\_oauth\_codeの各値が保存されます。

4. ウェブサイトのランディングページが表示されます。

### ステップ5.アプリケーションでLWA認証コードとLWAリフレッシュトークンを交換する

Login with Amazon SDK for JavaScriptは、LWA認証コードとLWAリフレッシュトークンの交換に役立ちます。詳細については、「Login with Amazon」ドキュメントをご覧ください。

- [JavaScript用のLogin with Amazon SDKを追加する](https://developer.amazon.com/docs/login-with-amazon/install-sdk-javascript.html)

- [認証コードの付与](https://developer.amazon.com/docs/login-with-amazon/authorization-code-grant.html)

**LWA認証コードとLWAリフレッシュトークンを交換するには**

1. アプリケーションは、Login with Amazon（LWA）認証サーバー（`https://api.amazon.com/auth/o2/token`）を呼び出して、LWA認証コードをLWAリフレッシュトークンと交換します。呼び出しには、次のクエリパラメーターを含める必要があります。

| **パラメーター** | **説明** |
| ------------------ | --------- |
| **grant\_type** | 要求されるアクセス許可のタイプ。*authorization\_code*である必要があります。 |
| **code** | [ステップ4で受け取ったLWA認証コード。Amazonから認可情報が送信されます](#step-4-amazon-sends-you-the-authorization-information)。 |
| **redirect\_uri** | アプリケーションのリダイレクトURI。 |
| **client\_id** | LWA認証情報の一部です。この値を取得するには、[開発者情報の表示](#viewing-your-developer-information)をご覧ください。 |
| **client\_secret** | LWA認証情報の一部です。この値を取得するには、[開発者情報の表示](#viewing-your-developer-information)をご覧ください。 |

例：
```
POST /auth/o2/token HTTP/l.l
Host: api.amazon.com
Content-Type: application/x-www-form-urlencoded;charset=UTF-8
grant_type=authorization_code&code=SplxlOexamplebYS6WxSbIA&client_id=foodev&client_secret=Y76SDl2F
```
2. LWA認証サーバーは、LWA更新トークンを返します。レスポンスはJSON形式で、次の要素が含まれます。

| **パラメーター** | **説明** |
| ------------------ | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ |
| **access\_token** | 出品者に代わってアプリケーションが特定のアクションを実行することを許可するトークン。[出品パートナーAPIへの接続](#connecting-to-the-selling-partner-api)をご覧ください。 |
| **token\_type** | 返されるトークンのタイプ。ベアラーである必要があります。 |
| **expires\_in** | アクセストークンが無効になるまでの秒数。 |
| **refresh\_token** | 新しいアクセストークンと交換できる長期間有効なトークン。[出品パートナーAPIへの接続](#connecting-to-the-selling-partner-api)をご覧ください。 |
```
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
3. refresh\_token値が保存されます。

4. ブラウザーにアプリケーションを使用するための次のステップを示すページが表示されます。

LWAリフレッシュトークンは、LWAアクセストークンと交換する長期間有効なトークンです。このトークンは、出品パートナーAPIへのすべてのリクエストに含める必要があります。アクセストークンは発行から1時間有効です。有効期限が切れるまでは、複数のAPI呼び出しで同じアクセストークンを使用できます。[出品パートナーAPIへの接続](#connecting-to-the-selling-partner-api)をご覧ください。

これで、出品者の代わりに出品パートナーAPIを呼び出すことが認可されました。

### 出品パートナーAPIハイブリッドアプリケーションの場合

[ステップ4.Amazonから認可情報が送信される](#step-4-amazon-sends-you-the-authorization-information)でMWS認証トークンが返された場合、出品者のアプリケーションは、出品者に代わってAmazonマーケットプレイスWebサービスへの呼び出しも許可されます。詳しくは、[出品パートナーAPIハイブリッドアプリケーション](#hybrid-selling-partner-api-applications)をご覧ください。

## ウェブサイトワークフロー

ウェブサイトワークフローは、自分のウェブサイトから開始されるOAuth認可ワークフローです。出品者が開発者のウェブサイトにサインインし、認可を開始するために開発者が設定した「認可」ボタンをクリックします。詳細については、[ステップ0.OAuth認可URIを設定する](#step-0-set-up-your-oauth-authorization-uris)をご覧ください。

このトピックには、ウェブサイトワークフローの手順と、ワークフローのテストに関する情報が含まれています。

**ウェブサイトワークフローのテスト**

実稼働のウェブサイトのワークフローを作成する前に、アプリケーションをドラフト状態で認可できるテストワークフローを作成することが重要です。これにより、アプリケーションがAmazonとパラメーターを交換し、認可情報を受け取ることができるかどうかをテストできます。

テストワークフローと実稼働ワークフローの違いは次のとおりです。

- アプリケーションにより、`version=beta`パラメーターが[ステップ1のOAuth認可URIに追加されます。ウェブサイトから認可を開始します](#step-1-the-seller-initiates-authorization-from-your-website)。これにより、ワークフローでアプリケーションがドラフト状態で認可されます。

ワークフローのテストが完了したら、`version=beta`パラメーターが[ステップ1のOAuth認可URIに追加されないよう、ワークフローを更新します。ウェブサイトから認可を開始します](#step-1-the-seller-initiates-authorization-from-your-website)。これにより、実稼動ワークフローとなります。これで、すべての出品者が自分のウェブサイトから公開アプリケーションを認可できるようになりました。

実稼動ワークフローが[ステップ0で開始します。OAuth認可URIを設定する](#step-0-set-up-your-oauth-authorization-uris)をご覧ください。

**手順**

[ステップ0.OAuth認可URIを設定する](#Step-0-Set-up-your-OAuth-authorization-URIs)

[ステップ1.ウェブサイトから認可を開始する](#Step-1-The-seller-initiates-authorization-from-your-website)

[ステップ2.出品者がアプリケーションの認可に同意する](#Step-2-The-seller-consents-to-authorize-the-application)

[ステップ3.Amazonから認可情報が送信される](#Step-3-Amazon-sends-you-the-authorization-information)

[ステップ4.アプリケーションでLWA認証コードとLWAリフレッシュトークンを交換する](#Step-4-Your-application-exchanges-the-LWA-authorization-code-for-a-LWA-refresh-token)

### ステップ0.OAuth認可URIを設定する

出品者がクリックしてアプリケーションの認可を開始できるよう、アプリケーションウェブサイトに「認可」ボタン（または同様のボタン）を設定します。出品者がボタンをクリックすると、開発者のウェブサイトでOAuth認可URIがブラウザーに読み込まれ、セラーセントラルのサインインページにリダイレクトされます。[アプリケーションを登録する](#step-6-register-your-application)と、OAuth認可URIが取得されます。

**複数のOAuth承認URI**

複数リージョンにOAuth認可URIがある場合は、出品者が自分のリージョンのセラーセントラルサインインページにリダイレクトされるよう、「認可」ボタンを設定してください。「認可」ボタンの設定は、1回限りの作業です。

### ステップ1.ウェブサイトから認可を開始する

1. 出品者が開発者のウェブサイトにサインインします。出品者がまだアカウントを持っていない場合は、登録プロセスを完了します。

2. 開発者が[ステップ0で設定した「認可」ボタンを出品者がクリックします。OAuth認可URIを設定する](#step-0-set-up-your-oauth-authorization-uris)をご覧ください。複数リージョンで「認可」ボタンがある場合は、出品するリージョンに対応したボタンが表示されていることを確認してください。

3. OAuth認可URIがブラウザーにロードされ、次のクエリパラメーターが追加されます。

<table>
<thead>
<tr class="header">
<th><strong>パラメーター</strong></th>
<th><strong>説明</strong></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td><strong>state</strong></td>
<td><p>アプリケーションによって生成された状態値。アプリケーションではこの値を使用して、このリクエストとレスポンス間の状態を維持し、クロスサイトリクエストフォージェリ攻撃から保護します。</p>
<p>重要： OAuth情報はURLクエリパラメーターを介して渡されるため、次の操作を行うことを強くお勧めします。 （1）状態トークンが短期間のみ有効でユーザーのみが検証可能であることを確認し、（2）Referrer-Policy: no-referrer HTTPヘッダーを設定し、ユーザーのウェブサイトがリンクする他ウェブサイトに機密情報を漏洩しないようにします。クロスサイトリクエストフォージェリと状態パラメーターの計算について詳しくは、Login with Amazonドキュメントの<a href="https://developer.amazon.com/docs/login-with-amazon/cross-site-request-forgery.html">クロスサイトリクエストフォージェリ</a>をご覧ください。</p></td>
</tr>
</tbody>
</table>

**注意：**`version=beta`パラメーターを含めると、ワークフローでドラフト状態のアプリケーションが認可されます。このパラメーターを指定しない場合、マーケットプレイスアプリストアで公開されたアプリケーションが認可されます。

例：
```
https://sellercentral.amazon.com/apps/authorize/consent?application_id=appidexample&state=stateexample&version=beta
```
または
```
https://sellercentral.amazon.com/apps/authorize/consent?application_id=appidexample&state=stateexample
```
セラーセントラルのサインインページにアクセスします。

### ステップ2.出品者がアプリケーションの認可に同意する

1. 出品者がセラーセントラルにサインインします。同意ページが表示されます。

2. 同意ページが表示されたら、出品者はアプリケーションによって要求されたデータアクセスを確認し、**確認**ボタンをクリックして続行します。**キャンセル**ボタンをクリックして、認可せずに終了することもできます。

### ステップ3.Amazonから認可情報が送信される

セラーセントラルに、出品者データへのアクセスが許可されていることを示すページが簡潔に表示されます。そのページが表示されている間に、次のアクションが実行されます。

1. AmazonによってリダイレクトURIがブラウザーにロードされ、次のクエリパラメーターが追加されます。

| **パラメーター** | **説明** |
| ------------------------ | ---------------------- |
| **state** | [ステップ1からの状態値。](#step-1-the-seller-initiates-authorization-from-your-website)[ウェブサイト](#step-1-the-seller-initiates-authorization-from-your-website)から認可を開始します。 |
| **selling\_partner\_id** | アプリケーションを認可している出品者の出品者ID。 |
| **mws\_auth\_token** | Amazonマーケットプレイスウェブサービスを呼び出す際のクエリ文字列を作成するときに使用する**MWSAuthToken**値。mws\_auth\_tokenパラメーターは、出品者が出品パートナーAPIハイブリッドアプリケーションを認可している場合にのみ渡されます。詳しくは、[出品パートナーAPIハイブリッドアプリケーション](#hybrid-selling-partner-api-applications)をご覧ください。 |
| **spapi\_oauth\_code** | LWAリフレッシュトークンと交換するLogin with Amazon（LWA）認証コード。詳細については、[ステップ4.](#step-4-your-application-exchanges-the-lwa-authorization-code-for-a-lwa-refresh-token)[アプリケーションでLWA認証コードとLWA](#step-4-your-application-exchanges-the-lwa-authorization-code-for-a-lwa-refresh-token)[リフレッシュトークンを交換する](#step-4-your-application-exchanges-the-lwa-authorization-code-for-a-lwa-refresh-token)をご覧ください。 |

例：
````
https://client-example.com?state=state-example&mws_auth_token=mwsauthtokenexample&selling_partner_id=sellingpartneridexample&spapi_oauth_code=spapioauthcodeexample
````
2. アプリケーションによってstate値が検証されます。

3. selling\_partner\_id、mws\_auth\_token（渡された場合）、およびspapi\_oauth\_codeの各値が保存されます。

4. ウェブサイトのランディングページが表示されます。

### ステップ4.アプリケーションでLWA認証コードとLWAリフレッシュトークンを交換する

Login with Amazon SDK for JavaScriptは、LWA認証コードとLWAリフレッシュトークンの交換に役立ちます。詳細については、「Login with Amazon」ドキュメントをご覧ください。

- [JavaScript用のLogin with Amazon SDKを追加する](https://developer.amazon.com/docs/login-with-amazon/install-sdk-javascript.html)

- [認証コードの付与](https://developer.amazon.com/docs/login-with-amazon/authorization-code-grant.html)

**LWA認証コードとLWAリフレッシュトークンを交換するには**

1. アプリケーションは、Login with Amazon（LWA）認証サーバー（https://api.amazon.com/auth/o2/token）を呼び出して、LWA認証コードをLWAリフレッシュトークンと交換します。呼び出しには、次のクエリパラメーターを含める必要があります。

<table>
<thead>
<tr class="header">
<th><strong>パラメーター</strong>
</th>
<th><strong>説明</strong></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td><strong>grant_type</strong></td>
<td>要求されるアクセス許可のタイプ。<em>authorization_code</em>である必要があります。</td>
</tr>
<tr class="even">
<td><strong>code</strong></td>
<td><a href="#step-3-amazon-sends-you-the-authorization-information">ステップ3. Amazonから認可<a href="#step-3-amazon-sends-you-the-authorization-information">情報</a>が送信される</a>で受け取ったLWA認証コード。</td>
</tr>
<tr class="odd">
<td><strong>redirect_uri</strong></td>
<td>アプリケーションのリダイレクトURI。</td>
</tr>
<tr class="even">
<td><strong>client_id</strong></td>
<td>LWA認証情報の一部です。この値を取得するには、<a href="#viewing-your-developer-information">開発者情報の表示</a>をご覧ください。</td>
</tr>
<tr class="odd">
<td><strong>client_secret</strong></td>
<td>LWA認証情報の一部です。この値を取得するには、<a href="#viewing-your-developer-information">開発者情報の表示</a>をご覧ください。</td>
</tr>
</tbody>
</table>

例：
```
POST /auth/o2/token HTTP/l.l
Host: api.amazon.com
Content-Type: application/x-www-form-urlencoded;charset=UTF-8
grant_type=authorization_code&code=SplxlOexamplebYS6WxSbIA&client_id=foodev&client_secret=Y76SDl2F
```
2. LWA認証サーバーは、LWA更新トークンを返します。レスポンスはJSON形式で、次の要素が含まれます。

| **パラメーター** | **説明** |
| ---------------| -------- |
| **access\_token** | 出品者に代わってアプリケーションが特定のアクションを実行することを許可するトークン。[出品パートナーAPIへの接続](#connecting-to-the-selling-partner-api)をご覧ください。 |
| **token\_type** | 返されるトークンのタイプ。ベアラーである必要があります。 |
| **expires\_in** | アクセストークンが無効になるまでの秒数。 |
| **refresh\_token** | 新しいアクセストークンと交換できる長期間有効なトークン。[出品パートナーAPIへの接続](#connecting-to-the-selling-partner-api)をご覧ください。 |
```
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
3. refresh\_token値が保存されます。

4. ブラウザーにアプリケーションを使用するための次のステップを示すページが表示されます。

LWAリフレッシュトークンは、LWAアクセストークンと交換する長期間有効なトークンです。このトークンは、出品パートナーAPIへのすべてのリクエストに含める必要があります。アクセストークンは発行から1時間有効です。有効期限が切れるまでは、複数のAPI呼び出しで同じアクセストークンを使用できます。[出品パートナーAPIへの接続](#connecting-to-the-selling-partner-api)をご覧ください。

これで、出品者の代わりに出品パートナーAPIを呼び出すことが認可されました。

**出品パートナーAPIハイブリッドアプリケーションの場合**

[ステップ3.Amazonから認可情報が送信される](#step-3-amazon-sends-you-the-authorization-information)でMWS認証トークンが返された場合、出品者のアプリケーションは、出品者に代わってAmazonマーケットプレイスWebサービスへの呼び出しも許可されます。詳しくは、[出品パートナーAPIハイブリッドアプリケーション](#hybrid-selling-partner-api-applications)をご覧ください。

# 自己認可

デベロッパーセントラルでアプリケーションを自己認可できます。これを行う前に、[出品パートナーAPIアプリケーションを登録する](#registering-your-selling-partner-api-application)必要があります。

完全なOAuth認証ワークフローを実装するには、[出品パートナーAPIアプリケーションの承認](#authorizing-selling-partner-api-applications)をご覧ください。

1. **アプリケーションを自己認証するには**、[開発者登録](#registering-as-a-developer)に使用した認証情報を使用して、セラーセントラルにサインインします。

2. **アプリとサービス**メニューの**アプリの開発**をクリックします。

   **デベロッパーセントラル**ページが表示されます。

3. **編集**をクリックし、認可するアプリケーションの横にある**認可**をクリックします。

   **リフレッシュトークンを生成**ボタンを含むページが表示されます。

4. **リフレッシュトークンを生成**をクリックします。

   Login with Amazon（LWA）リフレッシュトークンが表示されます。出品用アカウントが他の地域のアカウントにリンクされている場合は、地域ごとに更新トークンが送信されます。これで、出品用アカウントへのアクセスが認可されました。

   **重要****リフレッシュトークンを生成**をクリックしてリフレッシュトークンを取得し、それを保存して出品パートナーAPIを呼び出します。**リフレッシュトークンを生成**を複数回クリックすると、毎回新しいリフレッシュトークンが取得され、以前のリフレッシュトークンが無効になります。

リフレッシュトークンは、短期間のアクセストークンと交換する長期間有効なトークンです。出品パートナーAPIへのすべてのリクエストには、アクセストークンを含める必要があります。アクセストークンは発行から1時間有効です。有効期限が切れるまでは、複数のAPI呼び出しで同じアクセストークンを使用できます。詳細については、[ステップ1.Login with Amazonアクセストークンをリクエストする](#step-1-request-a-login-with-amazon-access-token)をご覧ください。

# LWAトークンの交換と認証を備えたJava SDKの生成

**C\#開発者への注意**。また、LWAトークンの交換と認証を備えたC\# SDKを生成するためのライブラリも提供します。詳細については、https://github.com/amzn/selling-partner-api-models/tree/main/clients/sellingpartner-api-aa-csharpのREADME.mdをご覧ください。

以下の手順では、Microsoft Windowsを実行しているコンピューターで、[Swagger Code Generator](https://github.com/swagger-api/swagger-codegen)を使用して出品者API用のJava SDKを生成する方法を説明します。このプロセスは、macOSやLinuxなどの他のオペレーティングシステムのユーザーでも、Windows固有のセマンティクス（C:\\など）を置き換えることで応用できます。この手順は出品者API用ですが、出品パートナーAPIで他のAPI用のSDKを作成する手順を変更できます。各出品パートナーAPIセクションのSwaggerモデルについては、<https://github.com/amzn/selling-partner-api-models>をご覧ください。

このSDKを使用すると、すでにセットアップされている次のコードを使用して、出品者APIを呼び出すことができます。 Login with Amazonのトークン交換（リフレッシュトークンとアクセストークンの交換）と認証。

**LWAトークンの交換と認証を備えたJava SDKを生成するには**

1. <span id="Connecting_to_Selling_Partner_API_using_" class="anchor">[Java 8以降](https://www.oracle.com/technetwork/java/index.html)、[Apache Maven 3.6以降](http://maven.apache.org/)、[GNU Wget](https://www.gnu.org/software/wget/wget.html)をインストールし、`$PATH`で利用できるようにします。

2. <https://github.com/amzn/selling-partner-api-models>に進みます。

3. まだ実行していない場合は、リポジトリをクローンしてコンピュータにローカルコピーを作成します。

4. コマンドプロンプトウィンドウを開き、Swagger Code Generatorをダウンロードするディレクトリに移動します。

5. Swagger Code Generatorの最新バージョンをダウンロードします。

   例：
```
wget https://repo1.maven.org/maven2/io/swagger/swagger-codegen-cli/2.4.13/swagger-codegen-cli-2.4.13.jar -O swagger-codegen-cli.jar
```
**swagger-codegen-cli.jar**が現在のディレクトリにダウンロードされます。

**注意：**また、ブラウザに以下のURLを指示することで、maven.orgからダウンロードすることもできます：[https://repo1.maven.org/maven2/io/swagger/swagger-codegen-cli/2.4.13/swagger-codegen-cli-2.4.13.jar](https://repo1.maven.org/maven2/io/swagger/swagger-codegen-cli/2.4.13/swagger-codegen-cli-2.4.13.jar)

6. **swagger-codegen-cli.jar**をディレクトリ構造にコピーすると、わかりやすくなります。この例では、C:\\SwaggerToCLにコピーします。

7. リポジトリのローカルコピーの**selling-partner-api-models\\models\\sellers-api-model**フォルダで、**sellers.json**に移動します。

8. **sellers.json**をC:\\SwaggerToCLにコピーします。

9. リポジトリのローカルコピーの**selling-partner-api-models\\clients\\sellingpartner-api-aa-java**フォルダ内のテンプレートに対してSDKを生成します。このフォルダには、認可および認証ライブラリと、Swagger Code Generator用のカスタマイズされたテンプレートが含まれています。

   例：
```
java -jar C:\SwaggerToCL\swagger-codegen-cli.jar generate -i C:\SwaggerToCL\Sellers.json -l java -t [path to selling-partner-api-models\clients\sellingpartner-api-aa-java folder]\resources\swagger-codegen\templates\ -o C:\SwaggerToCL\Sellers_JavaCL
```
SDKが、C:\\SwaggerToCL\\Sellers\_JavaCLにコピーされます。

10. AAライブラリを構築し、SDKの依存関係として追加します。

1. リポジトリのローカルコピーの**selling-partner-api-models\\clients\\sellingpartner-api-aa-java**フォルダに移動し、mvnパッケージを実行します。これにより、「target」という名前のフォルダが生成されます。このフォルダには、**sellingpartnerapi-aa-java-1.0-jar-with-dependencies.jar**（または類似のもの）という名前のJARファイルと、必要なすべての依存関係が含まれます。

2. JARファイルをローカルのMavenリポジトリにインストールします。

   例：
```
mvn install:install-file -Dfile=[path to JAR file in "target" folder] -DgroupId=com.amazon.sellingpartnerapi -DartifactId=sellingpartnerapi-aa-java -Dversion=1.0 -Dpackaging=jar
```
実際のgroupId、artifactId、およびversion値は、**selling-partner-api-models\\clients\\sellingpartner-api-aa-java**フォルダ内の**pom.xml**ファイルの上部付近にあります。

3. クライアントライブラリの**pom.xml**にAAライブラリへの依存関係を追加します。

   例：
```
<dependency>
  <groupId>com.amazon.sellingpartnerapi</groupId>
  <artifactId>sellingpartnerapi-aa-java</artifactId>
  <version>1.0</version>
</dependency>
```

SDKを生成したら、それを使用して出品パートナーAPIを呼び出すことができます。[生成されたJava SDKを使用した出品パートナーAPIへの接続](#connecting-to-the-selling-partner-api-using-a-generated-java-sdk)をご覧ください。

# 生成されたJava SDKを使用した出品パートナーAPIへの接続

開発者のアプリケーションを出品パートナーAPIに接続するには、アプリケーションを登録し、登録したアプリケーションを出品者に認可してもらう必要があります。[出品パートナーAPIアプリケーションの登録](#registering-as-a-developer)および[出品パートナーAPIアプリケーションの承認](#authorizing-selling-partner-api-applications)をご覧ください。

ここでは、生成されたJava SDKを使用して呼び出しを行う方法について説明します。SDKは、LWAおよびAWS認証情報を設定するためのクラスを公開し、これらを使用してLWAトークンを交換し、リクエストに署名します。詳細については、[LWAトークンの交換と認証を備えたJava SDKの生成](#generating-a-java-sdk-with-lwa-token-exchange-and-authentication)をご覧ください。

**手順**

[ステップ1.AWS認証情報の設定](#step-1-configure-your-aws-credentials)

[ステップ2.AWS認証情報プロバイダーの設定](#step-2-configure-your-aws-credentials-provider)

[ステップ3.LWA認証情報の設定](#step-3-configure-your-lwa-credentials)

[ステップ4.出品者APIのインスタンスを作成し、オペレーションを呼び出す](#step-4-create-an-instance-of-the-sellers-api-and-call-an-operation)

## ステップ1.AWS認証情報の設定

次のパラメータを使用して、`AWSAuthenticationCredentials`のインスタンスを作成します。

<table>
<thead>
<tr class="header">
<th><strong>名前</strong>
</th>
<th><strong>説明</strong>
</th>
<th><strong>必須</strong>
</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td><strong>accessKeyId</strong>
</td>
<td><a href="#step-4-create-an-iam-role">ステップ2. IAM ユーザーを作成する</a>のAWSアクセスキーID。
</td>
<td>はい
</td>
</tr>
<tr class="even">
<td><strong>secretKey</strong>
</td>
<td><a href="#step-4-create-an-iam-role">ステップ2. IAM ユーザーを作成する</a>のAWSシークレットアクセスキーID。
</td>
<td>はい
</td>
</tr>
<tr class="odd">
<td><strong>region</strong></td>
<td>呼び出しを指示しているAWSリージョン。詳細については、<a href="#_Selling_Partner_API">出品パートナーAPIエンドポイント</a>をご覧ください。</td>
<td>はい</td>
</tr>
</tbody>
</table>

例：
```
import com.amazon.SellingPartnerAPIAA.AWSAuthenticationCredentials;

...

AWSAuthenticationCredentials
awsAuthenticationCredentials = AWSAuthenticationCredentials.builder()
  .accessKeyId("myAccessKeyId")
  .secretKey("mySecretId")
  .region("us-east-1")
  .build();
```
## ステップ2.LWA認証情報プロバイダーの設定

以下のパラメーターを使用して、`AWSAuthenticationCredentialsProvider`インスタンスを作成します。

<table>
<thead>
<tr class="header">
<th><strong>名前</strong></th>
<th><strong>説明</strong></th>
<th><strong>必須</strong></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td><strong>roleArn</strong></td>
<td><a href="#step-4-create-an-iam-role">ステップ4. IAM ロールを作成する</a>で作成したロールのARN。</td>
<td>はい</td>
</tr>
<tr class="even">
<td><strong>roleSessionName</strong></td>
<td>定義するセッションの識別子。<a href="https://tools.ietf.org/html/rfc4122">ユニバーサルユニークID（UUID)</a>を使用することをお勧めします。</td>
<td>はい</td>
</tr>
</tbody>
</table>

例：
```
import com.amazon.SellingPartnerAPIAA.AWSAuthenticationCredentials;

...

AWSAuthenticationCredentialsProvider awsAuthenticationCredentialsProvider =
  AWSAuthenticationCredentialsProvider.builder()
  .roleArn("myroleARN")
  .roleSessionName("myrolesessioname")
  .build();
```
## ステップ3.LWA認証情報の設定

以下のパラメーターを使用して、`LWAAuthorizationCredentials`インスタンスを作成します。

<table>
<thead>
<tr class="header">
<th><strong>名前</strong></th>
<th><strong>説明</strong></th>
<th><strong>必須</strong></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td><strong>clientId</strong></td>
<td>LWAのクライアントID。詳細については、<a href="#viewing-your-developer-information">開発者情報の</a><a href="#viewing-your-developer-information">表示</a>をご覧ください。</td>
<td>はい</td>
</tr>
<tr class="even">
<td><strong>clientSecret</strong></td>
<td>LWAのクライアントシークレット。詳細については、<a href="#viewing-your-developer-information">開発者情報の</a><a href="#viewing-your-developer-information">表示</a>をご覧ください。</td>
<td>はい</td>
</tr>
<tr class="odd">
<td><strong>refreshToken</strong></td>
<td>LWAのリフレッシュトークン。出品者がアプリケーションを認可したときにこの値を取得します。詳細については、<a href="#authorizing-selling-partner-api-applications">出品<a href="#authorizing-selling-partner-api-applications">パートナーAPIアプリケーション</a>の承認</a>をご覧ください。</td>
<td><p>いいえ。次の手順で呼び出す操作に出品者の承認が必要な場合は、refreshTokenを含めます。<a href="#grantless-operations-1">許可不要のオペレーション</a>ではないすべての操作には、出品者の承認が必要です。refreshTokenを含める場合は、withScopesを含めないでください。</p></td>
</tr>
<tr class="even">
<td><strong>withScopes</strong></td>
<td>
<p>LWA認可グラントの範囲。1つ以上のwithScopes値を指定できます。</p>
<p>有効な値：</p>
<ul>
<li>
<em>SCOPE_NOTIFICATIONS_API</em>通知APIの場合。
</li>
<li><em>SCOPE_MIGRATION_API</em>認証APIの場合。</li>
</ul>
</td>
<td>いいえ。次の手順で呼び出す操作が<a href="#grantless-operations-1">許可不要の</a><a href="#grantless-operations-1">オペレーション</a>である場合は、withScopesを含めます。withScopesを含める場合は、refreshTokenを含めないでください。</td>
</tr>
<tr class="odd">
<td><strong>endpoint</strong></td>
<td>LWA認証サーバーのURI。</td>
<td>はい</td>
</tr>
</tbody>
</table>

出品者の認証が必要なオペレーションの呼び出し例：
```
import com.amazon.SellingPartnerAPIAA.LWAAuthorizationCredentials;

...

LWAAuthorizationCredentials lwaAuthorizationCredentials =
  LWAAuthorizationCredentials.builder()
  .clientId("myClientId")
  .clientSecret("myClientSecret")
  .refreshToken("Aztr|...")
  .endpoint("https://api.amazon.com/auth/o2/token")
  .build();
```
許可不要のオペレーションを呼び出す例：
```
import com.amazon.SellingPartnerAPIAA.LWAAuthorizationCredentials;
import static
com.amazon.SellingPartnerAPIAA.ScopeConstants.SCOPE_NOTIFICATIONS_API;
import static
com.amazon.SellingPartnerAPIAA.ScopeConstants.SCOPE_MIGRATION_API;

...

LWAAuthorizationCredentials lwaAuthorizationCredentials =
  LWAAuthorizationCredentials.builder()
  .clientId("myClientId")
  .clientSecret("myClientSecret")
  .withScopes(SCOPE_NOTIFICATIONS_API, SCOPE_MIGRATION_API)
  .endpoint("https://api.amazon.com/auth/o2/token")
  .build();
```
## ステップ4.出品者APIのインスタンスを作成し、オペレーションを呼び出す

`AWSAuthenticationCredentials`、`AWSAuthenticationCredentialsProvider`、`LWAAuthorizationCredentials`の各インスタンスを設定すると、SellersApiインスタンスを作成してオペレーションを呼び出すことができます。

例：

```
SellersApi sellersApi = new SellersApi.Builder()
  .awsAuthenticationCredentials(awsAuthenticationCredentials)
  .lwaAuthorizationCredentials(lwaAuthorizationCredentials)
  .awsAuthenticationCredentialsProvider(awsAuthenticationCredentialsProvider)
  .endpoint("https://sellingpartnerapi-na.amazon.com")
  .build();
```
# Javaクライアントライブラリの生成

以下の手順では、Microsoft Windowsを実行しているコンピューターで、[Swagger Code Generator](https://github.com/swagger-api/swagger-codegen)を使用して出品者API用のJavaクライアントライブラリを生成する方法を説明します。このプロセスは、macOSやLinuxなどの他のオペレーティングシステムのユーザーでも、Windows固有のセマンティクス（C:\\など）を置き換えることで応用できます。この手順は出品者API用ですが、出品パートナーAPIで他のAPI用のクライアントライブラリを作成する手順を変更できます。各出品パートナーAPIセクションのSwaggerモデルについては、<https://github.com/amzn/selling-partner-api-models/tree/main/models>をご覧ください。

生成されたクライアントライブラリは、出品パートナーAPIを呼び出すのに有用ですが、LWAトークンの交換と認証のためのコードは含まれていません。その場合は、[ステップ1.Login with Amazonアクセストークンをリクエストする](#step-1-request-a-login-with-amazon-access-token)および[ステップ4.リクエストの作成](#step-4-create-and-sign-your-request)[と署名](#step-4-create-and-sign-your-request)をご覧ください。または、LWAトークンの交換と認証を含むSDKについては、[LWAトークンの交換と認証](#generating-a-java-sdk-with-lwa-token-exchange-and-authentication)[を備えたJava SDKの生成](#generating-a-java-sdk-with-lwa-token-exchange-and-authentication)をご覧ください。

**Javaクライアントライブラリを生成するには**

1. [Java 8以降](https://www.oracle.com/technetwork/java/index.html)、[Apache Maven 3.6以降](http://maven.apache.org/)、[GNU Wget](https://www.gnu.org/software/wget/wget.html)をインストールし、$PATHで利用できるようにします。

2. <https://github.com/amzn/selling-partner-api-models>に進みます。

3. まだ実行していない場合は、リポジトリをクローンしてコンピュータにローカルコピーを作成します。

4. コマンドプロンプトウィンドウを開き、Swagger Code Generatorをダウンロードするディレクトリに移動します。

5. Swagger Code Generatorの最新バージョンをダウンロードします。

   例：
```
wget https://repo1.maven.org/maven2/io/swagger/swagger-codegen-cli/2.4.13/swagger-codegen-cli-2.4.13.jar -O swagger-codegen-cli.jar
```
**swagger-codegen-cli.jar**が現在のディレクトリにダウンロードされます。

**注意：**また、ブラウザに以下のURLを指示することで、maven.orgからダウンロードすることもできます。<https://repo1.maven.org/maven2/io/swagger/swagger-codegen-cli/2.4.13/swagger-codegen-cli-2.4.13.jar>

6. **swagger-codegen-cli.jar**をディレクトリ構造にコピーすると、わかりやすくなります。この例では、C:\\SwaggerToCLにコピーします。

7. リポジトリのローカルコピーの**selling-partner-api-models\\models\\sellers-api-model**フォルダで、**sellers.json**に移動します。

8. **sellers.json**をC:\\SwaggerToCLにコピーします。

9. クライアントライブラリを生成します。

   例：
```
java -jar C:\SwaggerToCL\swagger-codegen-cli.jar generate -i C:\SwaggerToCL\Sellers.json -l java -o C:\SwaggerToCL\Sellers_JavaCL
```
クライアントライブラリが、C:\\SwaggerToCL\\Sellers\_JavaCLにコピーされます。

クライアントライブラリを生成したら、それを使用して出品パートナーAPIを呼び出すことができます。[出品パートナーAPIへの接続](#connecting-to-the-selling-partner-api)をご覧ください。

# 出品パートナーAPIへの接続

開発者のアプリケーションを出品パートナーAPIに接続するには、アプリケーションを登録し、登録したアプリケーションを出品者に認可してもらう必要があります。[出品パートナーAPIアプリケーションの登録](#registering-as-a-developer)および[出品パートナーAPIアプリケーションの承認](#authorizing-selling-partner-api-applications)をご覧ください。

以下では、出品パートナーAPIを呼び出す手順を説明します。出品パートナーAPI URIの作成とヘッダーの追加については、[Javaクライアントライブラリの生成](#Generating_a_Java_client_library)をご覧ください。LWAトークンの交換と認証コードを含む、より完全なソリューションについては、[LWAトークンの交換と認証](#generating-a-java-sdk-with-lwa-token-exchange-and-authentication)[を備えたJava SDKの生成](#generating-a-java-sdk-with-lwa-token-exchange-and-authentication)をご覧ください。

**手順**

[ステップ1.Login with Amazonアクセストークンをリクエストする](#step-1-request-a-login-with-amazon-access-token)

[ステップ2.出品パートナーAPIのURIを構築する](#step-2-construct-a-selling-partner-api-uri)

[ステップ3.URIにヘッダーを追加する](#step-3-add-headers-to-the-uri)

[ステップ4.リクエストの作成と署名](#step-4-create-and-sign-your-request)

## ステップ1.Login with Amazonアクセストークンをリクエストする

Login with Amazon（LWA）アクセストークンにより、開発者のアプリケーションが出品者の代わりに特定のアクションを実行することが認可されます。LWAアクセストークンは発行後1時間で失効し、また、出品パートナーAPIへのすべてのリクエストに含める必要があります。

LWAアクセストークンをリクエストするには、次のパラメーターを使用して、LWA認証サーバー（`https://api.amazon.com/auth/o2/token`）に安全なHTTP POSTを実行します。

<table>
<thead>
<tr class="header">
<th><strong>名前</strong></th>
<th><strong>説明</strong></th>
<th><strong>必須</strong></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td><strong>grant_type</strong></td>
<td><p>要求されるアクセス許可のタイプ。有効な値：</p>
<ul>
<li><p><em>refresh_token</em>出品者からの承認が必要なオペレーションを呼び出す場合に使用します。<a href="#grantless-operations-1">許可不要のオペレーション</a>ではないすべての操作には、出品者からの承認が必要です。この値を指定するときは、<em>refresh_token</em>パラメータを含めます。</p></li>
<li><p><em>client_credentials</em>これは、<a href="#grantless-operations-1">許可不要のオペレーション</a>を呼び出すために使用します。この値を指定するときは、<code>scope</code>パラメータを含めます。</p></li>
</ul></td>
<td>はい</td>
</tr>
<tr class="even">
<td><strong>refresh_token</strong></td>
<td>LWAのリフレッシュトークン。出品者がアプリケーションを認可したときにこの値を取得します。詳細については、<a href="#authorizing-selling-partner-api-applications">出品パートナーAPIアプリケーションの承認</a>をご覧ください。</td>
<td>いいえ。出品者からの承認を必要とするオペレーションを呼び出すには、refresh_tokenを含めます。refresh_tokenを含める場合は、scopeを含めないでください。</td>
</tr>
<tr class="odd">
<td><strong>scope</strong></td>
<td><p>LWA認可グラントの範囲。有効な値：</p>
<ul>
<li><p><em>sellingpartnerapi::notifications</em>通知APIの場合。</p></li>
<li><p><em>sellingpartnerapi::migration</em>認証APIの場合。</p></li>
</ul></td>
<td>いいえ。<a href="#grantless-operations-1">許可不要の</a><a href="#grantless-operations-1">オペレーション</a>を呼び出すためのscopeを含めます。scopeを含める場合は、refresh_tokenを含めないでください。</td>
</tr>
<tr class="even">
<td><strong>client_id</strong></td>
<td>アプリケーションを登録するときにこの値を取得します。<a href="#viewing-your-developer-information">開発者情報の表示</a>をご覧ください。</td>
<td>はい</td>
</tr>
<tr class="odd">
<td><strong>client_secret</strong></td>
<td>アプリケーションを登録するときにこの値を取得します。<a href="#viewing-your-developer-information">開発者情報の表示</a>をご覧ください。</td>
<td>はい</td>
</tr>
</tbody>
</table>

出品者の認証が必要なオペレーションを呼び出す例：
```
POST /auth/o2/token HTTP/l.l
Host: api.amazon.com
Content-Type: application/x-www-form-urlencoded;charset=UTF-8
grant_type=refresh_token
&refresh_token=Aztr|...
&client_id=foodev
&client_secret=Y76SDl2F
```
許可不要のオペレーションを呼び出す例：
```
POST /auth/o2/token HTTP/l.l
Host: api.amazon.com
Content-Type: application/x-www-form-urlencoded;charset=UTF-8
grant_type=client_credentials
&scope=sellingpartnerapi::notifications
&client_id=foodev
&client_secret=Y76SDl2F
```
**ヒント：**LWA認可サーバーを呼び出すときに信頼されていない認証機関（CA）エラーが発生しないようにするには、LWA認可サーバーが信頼されるよう、信頼できるストアを更新してください。

**レスポンス**

成功レスポンスには、次の値が含まれます。

| **名前** | **説明** |
| ------------------ | --- |
| **access\_token** | LWAアクセストークン最大サイズ： 2048バイト。 |
| **token\_type** | 返されるトークンのタイプ。*ベアラー*である必要があります。 |
| **expires\_in** | アクセストークンが無効になるまでの秒数。 |
| **refresh\_token** | リクエストで送信したLWAアクセストークン。最大サイズ： 2048バイト。 |
```
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
詳しくは、Login with Amazonドキュメントの[認証コードの付与](https://developer.amazon.com/docs/login-with-amazon/authorization-code-grant.html)ページをご覧ください。

## ステップ2.出品パートナーAPIのURIを構築する

以下は、出品パートナーAPI URIのコンポーネントです。

| **名前** | **説明** | **例** |
| -------------- | ---------------------- | ------------ |
| HTTPメソッド | [出品パートナーAPIのHTTPメソッド](#selling-partner-api-http-methods)の1つ。 | `GET` |
| エンドポイント | [出品パートナーAPIエンドポイント](#Selling_Partner_API_endpoints)。 | `https://sellingpartnerapi-na.amazon.com` |
| パス | 出品パートナーAPIセクション/バージョン。セクション/リソースの番号。 | `/fba/inbound/v0/shipments/{shipmentId}/preorder/confirm` |
| クエリ文字列 | クエリパラメーター。 | `?marketplace=ATVPDKIKX0DER` |
| Pathパラメータ | パスのパラメータ | `shipmentId1` |

例：
```
PUT https://sellingpartnerapi-na.amazon.com/fba/inbound/v0/shipments/shipmentId1/preorder/confirm?MarketplaceId=ATVPDKIKX0DER&NeedByDate=2020-10-10
```
## ステップ3.URIにヘッダーを追加する

[ステップ2で作成したURIにヘッダーを追加します。出品パートナーAPIのURIを作成します](#step-2-construct-a-selling-partner-api-uri)。出品パートナーAPIへのリクエストに含めるHTTPヘッダーは次のとおりです。

**リクエストヘッダー**

| **名前** | **説明** |
| ---------- | ---------------- |
| host | マーケットプレイスのエンドポイント。[出品パートナーAPIのHTTPメソッド](#selling-partner-api-http-methods)をご覧ください。 |
| x-amz-access-token | LWAアクセストークン[ステップ1.Login with Amazonアクセストークンをリクエストする](#step-1-request-a-login-with-amazon-access-token)をご覧ください。 |
| x-amz-date | リクエストの日時。 |
| user-agent | アプリケーション名とバージョン番号、プラットフォーム、プログラミング言語。これらの情報は、Amazonがサービスで発生する可能性のある問題を診断し、解決する際に役立ちます。[すべての[リクエスト](#include-a-user-agent-header-in-all-requests)にUser-Agentヘッダーを含める](#include-a-user-agent-header-in-all-requests)をご覧ください。 |

以下は、URIとヘッダーはあるが署名情報がない出品パートナーAPIへのリクエストの例です。
```
PUT /fba/inbound/v0/shipments/shipmentId1/preorder/confirm?MarketplaceId=ATVPDKIKX0DER&NeedByDate=2020-10-10 HTTP/1.1
host: sellingpartnerapi-na.amazon.com
user-agent: My Selling Tool/2.0 (Language=Java/1.8.0.221;
Platform=Windows/10)
x-amz-access-token=Atza|IQEBLjAsAhRmHjNgHpi0U-Dme37rR6CuUpSREXAMPLE
x-amz-date: 20190430T123600Z
```
出品パートナーAPIへのリクエストに署名するには、[ステップ4.リクエストの作成と署名](#step-4-create-and-sign-your-request)をご覧ください。

## ステップ4.リクエストの作成と署名

出品パートナーAPIでは、AWS[署名バージョン4署名プロセス](https://docs.aws.amazon.com/general/latest/gr/signature-version-4.html)を使用してリクエストを認証します。出品パートナーAPIにHTTPリクエストを送信するとき、Amazonがリクエストを送信したユーザーを識別できるように、リクエストに署名します。アクセスキーIDと秘密キーで構成されるAWSアクセスキーを使用して、リクエストに署名します。AWSアクセスキーの取得については、[ステップ2.IAMユーザーを作成する](#step-4-create-an-iam-role)で作成したユーザーを選択します。

**注意：**手動でHTTPリクエストを作成する場合に限り、HTTPリクエストの署名方法について学ぶ必要があります。いずれかのAWS SDKを使用して署名を計算すると、設定時に指定したAWSアクセスキーを使用して、SDKによってリクエストに自動的に署名されます。SDKを使用する場合は、自分でリクエストに署名する方法を学ぶ必要がありません。たとえば、Java開発者は署名を計算するためのモデルとして、Java用AWS SDKの[AWS4Signer.java](https://github.com/aws/aws-sdk-java/blob/master/aws-java-sdk-core/src/main/java/com/amazonaws/auth/AWS4Signer.java)を使用できます。[AWS GitHubリポジトリ](https://github.com/aws)には、他の言語用のSDKも用意されています。

リクエストを作成して署名するには、次の操作を行います。

1. 正規リクエストを作成する

   AWSドキュメントの[タスク1： 署名バージョン4の正規リクエストを作成する](https://docs.aws.amazon.com/general/latest/gr/sigv4-create-canonical-request.html)に従って、このガイダンスを使用します。

   - 正規リクエストの作成時に開始する署名なしリクエストの例については、[ステップ3.URIにヘッダーを追加する](#step-3-add-headers-to-the-uri)をご覧ください。

   - ハッシュアルゴリズムにはSHA-256を使用します。

   - クエリパラメーターには認証情報を入れないでください。これは`Authorization`ヘッダーパラメーターに含めてください。認証情報に`Authorization`ヘッダーパラメーターを使用する方法については、[Authorizationヘッダー](#authorization-header)をご覧ください。

2. 署名する文字列を作成する

   AWSドキュメントの[タスク2： 署名バージョン4の署名文字列を作成する](https://docs.aws.amazon.com/general/latest/gr/sigv4-create-string-to-sign.html)に従って、このガイダンスを使用します。

   - アルゴリズムの指定値は、`AWS4-HMAC-SHA256`です。

   - 認証情報スコープを決定するには、[認証情報スコープ](#credential-scope)をご覧ください。

3. 署名を計算する

   AWSドキュメントの[タスク3： AWS署名バージョン4の署名を計算する](https://docs.aws.amazon.com/general/latest/gr/sigv4-calculate-signature.html)に従います。

   **重要**この手順を完了するには、[認証情報スコープ](#credential-scope)をご覧ください。

4. 署名情報を追加する

   AWSドキュメントの[タスク4： HTTPリクエストに署名を追加する](https://docs.aws.amazon.com/general/latest/gr/sigv4-add-signature-to-request.html)に従って、このガイダンスを使用します。

   - クエリ文字列には署名情報を追加しないでください。これは`Authorization`ヘッダーパラメーターに追加します。

   - `Authorization`ヘッダーパラメータの作成の詳細については、[Authorizationヘッダー](#authorization-header)をご覧ください。

   次の例では、Authorizationヘッダーを使用して署名情報を追加した後で、リクエストがどのように表示されるかを示します。
```
PUT /fba/inbound/v0/shipments/shipmentId1/preorder/confirm?MarketplaceId=ATVPDKIKX0DER&NeedByDate=2020-10-10HTTP/1.1
Authorization: AWS4-HMAC-SHA25Credential=AKIDEXAMPLE/20190430/us-east1/
execute-api/aws4_request, SignedHeaders=host;user-agent;x-amz-access-token,
Signature=5d672d79c15b13162d9279b0855cfba6789a8edb4c82c400e06b5924aEXAMPLE
host: sellingpartnerapi-na.amazon.com
user-agent: My Selling Tool/2.0 (Language=Java/1.8.0.221;
Platform=Windows/10)
x-amz-access-token=Atza|IQEBLjAsAhRmHjNgHpi0U-Dme37rR6CuUpSREXAMPLE
x-amz-date: 20190430T123600Z
```
### 認証情報スコープ

認証情報スコープとは、出品パートナーAPIへのリクエストに署名する際に作成する「署名文字列」のコンポーネントです。[リクエストの作成と署名](#step-4-create-and-sign-your-request)をご覧ください。

認証情報スコープは、次の表に示すように、スラッシュで区切られたディメンション文字列で表されます。

| **ディメンション** | **説明** | **例** |
| ----------- | ---- | ------------- |
| Date | リクエストの年（YYYY）、月（MM）、日（DD）を表す8桁の文字列。 | `20190430` |
| AWS region | リクエストを送信するリージョン。[出品パートナーAPIエンドポイント](#Selling-Partner-API-endpoints)をご覧ください。 | `us-east-1` |
| Service | リクエストしているサービス。この値はエンドポイントにあります。[出品パートナーAPIエンドポイント](#Selling-Partner-API-endpoints)をご覧ください。 | `execute-api` |
| Termination string | 特別な終了文字列。AWS署名バージョン4の場合、値はaws4\_requestです。 | `aws4_request` |

例：
```
20190430/us-east-1/execute-api/aws4_request
```
**重要**認証情報スコープの一部として使用する日付は、x-amz-dateヘッダーで指定されたリクエストの日付と一致する必要があります。詳しくは、AWSドキュメントの[署名バージョン4の日付の処理](https://docs.aws.amazon.com/general/latest/gr/sigv4-date-handling.html)をご覧ください。

詳細については、[ステップ4.リクエストの作成と署名](#step-4-create-and-sign-your-request)をご覧ください。

### Authorizationヘッダー

Authorizationヘッダーには、要求に対する署名情報が含まれます。ヘッダーは「Authorization」という名前ですが、署名情報は認証に使用されるものです。

Authorizationヘッダーのコンポーネントは次のとおりです。

| **コンポーネント** | **説明** |
| ------------------------------ | ---------|
| 署名に使用されるアルゴリズム | 署名プロセス全体で使用されるハッシュアルゴリズム。出品パートナーAPIには、SHA-256が必要です。これは、[ステップ 4.リクエストの作成と署名](#step-4-create-and-sign-your-request)をご覧ください。 |
| 認証情報 | AWSアクセスキーIDと[認証情報スコープ](#credential-scope)。AWSアクセスキーIDは、[ステップ](#step-4-create-an-iam-role)[3.IAMユーザーを作成する](#step-4-create-an-iam-role)で作成したユーザーを選択します。 |
| SignedHeaders | 署名付きリクエストに含めたすべてのHTTPヘッダーのリスト。例については、[ステップ3.URIにヘッダーを追加する](#step-3-add-headers-to-the-uri)をご覧ください。 |
| Signature | [ステップ4.リクエストの作成と署名](#step-4-create-and-sign-your-request)をご覧ください。 |

例：
```
Authorization: AWS4-HMAC-SHA25 Credential=AKIDEXAMPLE/20190430/us-east1/execute-api/aws4_request, SignedHeaders=host;user-agent;x-amz-accesstoken;xamz-date, Signature=5d672d79c15b13162d9279b0855cfba6789a8edb4c82c400e06b5924aEXAMPLE
```
詳細については、[ステップ4.リクエストの作成と署名](#step-4-create-and-sign-your-request)をご覧ください。

# レスポンスのフォーマット

HTTPリクエストへの応答で、出品パートナーAPIはレスポンスヘッダーとJSONレスポンスメッセージを返します。

**レスポンスヘッダー**

| **名前** | **説明** |
| ---------------- | --------------------------------------------------------------- |
| Content-Length | 標準HTTPレスポンスヘッダー。 |
| Content-Type | 標準HTTPレスポンスヘッダー。 |
| Date | 標準HTTPレスポンスヘッダー。 |
| x-amzn-RequestId | リクエストID。サポートが必要な場合は、問い合わせ時にこの内容をお伝えください。 |

### 成功レスポンス

リクエストが成功すると、出品パートナーAPIはリクエストされたデータを返します。成功レスポンスの例を次に示します。
```
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
### エラーレスポンス

リクエストが失敗した場合、出品パートナーAPIはエラーレスポンスを返します。エラーレスポンスのレスポンスメッセージに含まれる要素は次のとおりです。

**レスポンスメッセージ**

| **要素** | **説明** | **必須** |
| ----------- | ----------------------------------- | ------------ |
| code | HTTPステータスコード。 | はい |
| message | エラー状態の説明。 | はい |
| details | 追加情報へのリンク。 | いいえ |

エラーレスポンスの例を次に示します。
```
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

# 許可不要のオペレーション

許可不要のオペレーションとは、出品パートナーからの明示的な認可なしに呼び出すことができるオペレーションです。つまり、許可不要のオペレーションを呼び出す前に[Login with Amazonアクセストークンをリクエストする](#step-1-request-a-login-with-amazon-access-token)場合、リフレッシュトークンを提供する必要はありません。代わりに、**scope**パラメーターを使用して、LWA認可グラントの範囲を指定します。生成されたJava SDK（[生成されたJava SDKを使用した出品パートナーAPIへの接続](#Connecting_to_Selling_Partner_API_using_)を参照）を使用して許可不要のオペレーションを呼び出す場合は、**withScopes**パラメーターを使用して、LWA認証情報の構成時にLWA認可グラントの範囲を1つ以上設定します。

出品パートナーAPIの許可不要のオペレーションについては、次の表をご覧ください。

**許可不要のオペレーション**

| **オペレーション名** | **HTTPメソッドとパス** |
| -------------------------- | -------------- |
| **createDestination** | POST /notifications/v1/destinations |
| **deleteDestination** | DELETE /notifications/v1/destinations/{destinationId} |
| **deleteSubscriptionById** | DELETE /notifications/v2/subscriptions/{notificationType}/{subscriptionId} |
| **getDestination** | GET /notifications/v1/destinations/{destinationId} |
| **getDestinations** | GET /notifications/v1/destinations |
| **getSubscriptionById** | GET /notifications/v1/subscriptions/{notificationType}/{subscriptionId} |
| **getAuthorizationCode** | GET /authorization/v1/authorizationCode |

# すべてのリクエストにUser-Agentヘッダーを含める

User-Agentヘッダーは、アプリケーションとそのバージョン番号、および使用しているプラットフォームとプログラミング言語を識別します。出品パートナーAPIに送信するリクエストごとに、User-Agentヘッダーを含める必要があります。

これにより、Amazonはより効率良く問題を診断して解決でき、サービスをより快適に使用いただくことにつながります。

User-Agentヘッダーを作成するには、使用しているアプリケーション名から開始し、スラッシュ、アプリケーションのバージョン、スペース、左丸括弧、言語名と値のペア、

右丸括弧の順に入力します。言語パラメーターは必須の属性ですが、セミコロンで区切ることでその他の属性を追加することができます。

次の擬似コードは、受け入れ可能な最小限度の条件を満たすUser-Agentヘッダーを説明するものです。
```
AppId/AppVersionId (Language=LanguageNameAndOptionallyVersion)
```
以下に、アプリケーションインテグレーターで使用されるUser-Agentヘッダーの例を示します。
```
My Selling Tool/2.0 (Language=Java/1.8.0.221; Platform=Windows/10)
```
自社のIT部門を通じて統合を行う大口出品者の場合は、次の例のように、Host属性を含むUser-Agentヘッダーの作成を検討してください。これにより、Amazonサポートエンジニアは問題のトラブルシューティングをより効果的に行うことができます。
```
MyCompanyName/build1611 (Language=Perl; Host=jane.desktop.example.com)
```
その他の属性を指定するには、各名前と値のペアをセミコロンで分離して、フォーマットAttributeName=Value;を使用してください。バックスラッシュ（\\）を使用したい場合は、2つつなげて（\\\\）エスケープして使用してください。アプリケーション名内のスラッシュ（\\/）、アプリケーションバージョン内の左丸括弧（\\(）、属性名内の等号（\\=）、右丸括弧（\\)）および属性値内のセミコロン（\\;）についても同様にエスケープし使用してください。

User-Agentヘッダはすべてのリクエストで送信されるので、ヘッダのサイズを制限することをお勧めします。出品パートナーAPIは、500文字を超えるUser-Agentヘッダーを拒否します。

# 出品パートナーAPIハイブリッドアプリケーション

出品パートナーAPIハイブリッドアプリケーションは、出品パートナーAPIとAmazonマーケットプレイスWebサービス（Amazon MWS）の両方を呼び出すことができるアプリケーションです。ソリューションのために両方のサービスの機能が必要な場合は、ハイブリッドアプリケーションを使用します。出品者が出品パートナーAPIハイブリッドアプリケーションを認可すると、（1）Amazon MWS開発者IDからAmazon MWSを呼び出すことが認可され、（2）アプリケーションから出品パートナーAPIを呼び出すことが認可されます。

Amazonでは、ハイブリッドアプリケーションを単一のアプリケーションと見なしています。たとえば、ハイブリッドアプリケーションをマーケットプレイスアプリストアに公開する場合、そのアプリケーションは単一のアプリケーションとして管理されます。

### 出品パートナーAPIハイブリッドアプリケーションの作成

**ハイブリッドアプリケーションを作成するには**

1. Amazon MWSアプリケーションをマーケットプレイスアプリストアに公開します。アプリケーションの公開の詳細は、Amazon MWSドキュメントの[マーケットプレイスアプリストア掲載登録ガイド](https://docs.developer.amazonservices.com/en_US/dev_guide/DG_AppListingGuide.html)をご覧ください。

2. [開発者登録](#registering-as-a-developer)に使用した認証情報を使用して、セラーセントラルにサインインします。

3. **アプリとサービス**メニューの**アプリの開発**をクリックします。

   **デベロッパーセントラル**ページが表示されます。

4. Amazon MWSアプリケーションの横にある**アプリの編集**メニューで、**アプリの編集**をクリックします。

5. 指示に従ってアプリケーションを登録します。

ハイブリッドアプリケーションを作成したら、OAuth認証ワークフローを設定およびテストできます。詳細については、[出品パートナーAPIアプリケーションの承認](#authorizing-selling-partner-api-applications)をご覧ください。

### AmazonマーケットプレイスWebサービスからの承認の移行

また、出品パートナーの代わりに開発者がAmazonマーケットプレイスウェブサービスを呼び出すことについて出品パートナーが許可している場合は、開発者はAuthorization APIを使用して、その認可を出品パートナーAPIハイブリッドアプリケーションに移行できます。これにより、出品パートナーに再度認可をリクエストする必要がなくなります。詳しくは、Authorization API User Guideをご覧ください。

# 出品パートナーAPIサンドボックス

出品パートナーAPIでは、実稼動データに影響を与えたり、実際のイベントを発生させたりすることなく、アプリケーションをテストできるサンドボックス環境が提供されます。出品パートナーAPIへのサンドボックス呼び出しは、[出品パートナーAPIサンドボックスエンドポイント](#selling-partner-api-sandbox-endpoints)への呼び出しを指示する以外は本番呼び出しを行う場合と同じです。サンドボックスエンドポイントを呼び出すと、すべての出品パートナーAPIに対して静的な模擬レスポンスが返されます。呼び出すAPIのSwaggerモデルJSONファイルで、これらの模擬レスポンスを参照できます。詳細については、[出品パートナーAPIをサンドボックスで呼び出す方法](#how-to-make-a-sandbox-call-to-the-selling-partner-api)をご覧ください。

出品パートナーAPIサンドボックスは、多くの模擬フレームワークと同じように機能し、指定されたパラメーターが存在する場合は、パターンマッチングを使用して、指定されたレスポンスを返します。開発者が、指定されたパラメーターに一致するリクエストを送信すると、x-amazon-spds-sandbox-behaviorsオブジェクトで定義されたレスポンスが返されます。x-amazon-spds-sandbox-behaviors

オブジェクトで指定されていないパラメーターがAPIで必要な場合は、リクエストが有効な限り、リクエスト内のパラメーター値に関係なく、サンドボックスからレスポンスが返されます。

**重要**サンドボックスは、拡張性のテストではなく、機能をテストするためのものです。サンドボックスエンドポイントの呼び出しには、**rate** = 1 秒あたり5リクエスト、**burst** = 15 のスロットリング制限が適用されます。調整の詳細については、出品パートナーAPIのドキュメントの「使用プランとレート制限」をご覧ください。

## 出品パートナーAPIをサンドボックスで呼び出す方法

### ステップ1.リクエストパラメーターのJSONファイルをチェックする

1. <https://github.com/amzn/selling-partner-api-models/tree/main/models>に進みます。

2. サンドボックス呼び出しを行うAPIのフォルダを開きます。

3. 使用するAPIのJSONファイルをクリックします。

   JSONコードが表示されます。

4. 「x-amazon-spds-sandbox-behaviors」のコードを検索します。

JSONファイルのx-amazon-spds-sandbox-behaviorオブジェクトには、APIのサンドボックス呼び出しのリクエストとレスポンスの例が含まれています。リクエスト例にパラメーターが含まれている場合は、次のステップで使用します。

### ステップ2.APIをサンドボックスで呼び出す

APIをサンドボックスで呼び出す方法は、実稼働で呼び出す方法と同じですが、以下の違いがあります。

1. JSONファイルのx-amazon-spds-sandbox-behaviorオブジェクト内のリクエストオブジェクトに1つ以上のパラメーターと値のペアが含まれている場合は、呼び出し時にそれらを指定します。

2. [出品パートナーAPIサンドボックスエンドポイント](#selling-partner-api-sandbox-endpoints)の1つを呼び出す指示をします。

   受信するレスポンスは、JSONファイルのx-amazon-spds-sandbox-behaviorオブジェクトに含まれるペイロードオブジェクトと一致する必要があります。

## 出品パートナーAPIサンドボックスのエンドポイント

出品パートナーAPIには、北米、ヨーロッパ、極東地域の出品リージョン向けのサンドボックスエンドポイントがあります。詳細については、[出品パートナーAPIサンドボックス](#hybrid-selling-partner-api-applications)をご覧ください。

| **出品リージョン** | **エンドポイント** | **AWSリージョン** |
| ------------- | -------------- | -------------- |
| 北米（カナダ、米国、メキシコ、ブラジルのマーケットプレイス） | `https://sandbox.sellingpartnerapi-na.amazon.com` | us-east-1 |
| ヨーロッパ（スペイン、イギリス、フランス、ドイツ、イタリア、トルコ、アラブ首長国連邦、インドのマーケットプレイス） | `https://sandbox.sellingpartnerapi-eu.amazon.com` | eu-west-1 |
| 極東地域（シンガポール、オーストラリア、日本のマーケットプレイス） | `https://sandbox.sellingpartnerapi-fe.amazon.com` | us-west-2 |

# 出品パートナーAPIとAmazonマーケットプレイスWebサービスの違いは何ですか？

出品パートナーAPIとAmazonマーケットプレイスウェブサービス（Amazon MWS）はいずれも、出品者のデータにプログラムでアクセスできるウェブサービスですが、大きな違いがあります。出品パートナーAPIとAmazon MWSの主な相違点は次のとおりです。

- 出品パートナーAPIは、RESTに適合したリソースとしてデータを処理し、標準的なHTTPメソッドを介してアクセスおよび変更できます。一方、Amazon MWSは、Amazon MWS固有のオペレーションを使用してデータを公開します。

- 出品パートナーAPI認証は、AmazonのOAuth 2.0の実装であるLWAを活用します。このモデルにより、Amazon MWSで要求される認可トークンを手動で交換する必要がなくなります。[出品パートナーAPIアプリケーションの承認](#website-workflow)をご覧ください。

- Amazon MWSでは、出品者が開発者を認可します。出品者は、出品パートナーAPIを使用してアプリケーションを承認します。開発者は、出品パートナーAPIを使用することで、出品者のデータに対して複数のアクセスレベルを要する複数のアプリケーションを作成できます。

- 出品パートナーAPIは、Amazon MWSよりも詳細なデータアクセス制御を提供します。開発者は必要なデータのみに対するアクセスをリクエストでき、出品者はAPIセクション、オペレーション、またはデータリソースレベルで権限を付与できます。

- 出品パートナーAPIでは、AWS IDとアクセス管理（IAM）を使用して、固有の認証情報を直接入手し管理できます。Amazon MWSでは、特別な登録ワークフローを使用してAmazonから提供された認証情報を受け取ります。また、Amazon MWSサポートに連絡すると、新しい認証情報が取得されます。[ステップ2.IAMユーザーを作成する](#step-4-create-an-iam-role)で作成したユーザーを選択します。

- 出品パートナーAPIでは、認証にAWS署名バージョン4を使用します。Amazon MWSでは署名バージョン2を使用しています。[ステップ4.リクエストの作成と署名](#step-4-create-and-sign-your-request)をご覧ください。
