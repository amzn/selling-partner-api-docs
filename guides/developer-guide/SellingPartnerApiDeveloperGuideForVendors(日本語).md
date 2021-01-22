# ベンダー向け出品パートナーAPI開発者ガイド

### 目次

- [出品パートナーAPIとは何ですか？](#出品パートナーapiとは何ですか？)

   - [出品パートナーAPIエンドポイント](#出品パートナーapiエンドポイント)

- [ベンダーグループについて](#ベンダーグループについて)

   - [単独ベンダーグループの使用](#単独ベンダーグループの使用)

   - [複数ベンダーグループの使用](#複数ベンダーグループの使用)

- [開発者として登録](#開発者として登録)

- [出品パートナーAPIアプリケーションの登録](#出品パートナーapiアプリケーションの登録)
- [ステップ1.AWSアカウントを作成する](#ステップ1awsアカウントを作成する)

- [ステップ2.IAMユーザーを作成する](#ステップ2iamユーザーを作成する)

- [ステップ3.IAMポリシーを作成する](#ステップ3iamポリシーを作成する)

- [ステップ4.IAMロールを作成する](#ステップ4iamロールを作成する)

- [ステップ5.IAMユーザーにAWSセキュリティトークンサービスポリシーを追加する](#ステップ5iamユーザーにawsセキュリティトークンサービスポリシーを追加する)

- [ステップ6.アプリケーションを登録する](#ステップ6アプリケーションを登録する)

- [アプリケーション情報の表示](#アプリケーション情報の表示)

- [アプリケーションの認可](#アプリケーションの認可)

- [LWAトークンの交換と認証を備えたJava SDKの生成](#lwaトークンの交換と認証を備えたjava-sdkの生成)

- [生成されたJava SDKを使用した出品パートナーAPIへの接続](#生成されたjava-sdkを使用した出品パートナーapiへの接続)

   - [ステップ1.AWS認証情報の設定](#ステップ1aws認証情報の設定)

   - [ステップ2.AWS認証情報プロバイダーの設定](#ステップ2aws認証情報プロバイダーの設定)

   - [ステップ3.LWA認証情報の設定](#ステップ3lwa認証情報の設定)

   - [ステップ4.ベンダー注文APIのインスタンスの作成とオペレーションの呼び出し](#ステップ4ベンダー注文apiのインスタンスの作成と、オペレーションの呼び出し)

- [Javaクライアントライブラリの生成](#javaクライアントライブラリの生成)

- [出品パートナーAPIへの接続](#出品パートナーapiへの接続)

   - [ステップ1.Login with Amazonアクセストークンをリクエストする](#ステップ1login-with-amazonアクセストークンをリクエストする)

   - [ステップ2.出品パートナーAPIのURIを構築する](#ステップ2出品パートナーapiのuriを構築する)

   - [ステップ3.URIにヘッダーを追加する](#ステップ3uriにヘッダーを追加する)

   - [ステップ4.リクエストの作成と署名](#ステップ4リクエストの作成と署名)

      - [認証情報スコープ](#認証情報スコープ)

      - [Authorizationヘッダー](#authorizationヘッダー)

- [レスポンスのフォーマット](#レスポンスのフォーマット)

- [すべてのリクエストにUser-Agentヘッダーを含める](#すべてのリクエストにuser-agentヘッダーを含める)

- [出品パートナーAPIサンドボックス](#出品パートナーapiサンドボックス)

   - [出品パートナーAPIをサンドボックスで呼び出す方法](#出品パートナーapiをサンドボックスで呼び出す方法)

      - [ステップ1.リクエストパラメーターのJSONファイルをチェックする](#ステップ1リクエストパラメーターのjsonファイルをチェックする)

      - [ステップ2.APIをサンドボックスで呼び出す](#ステップ2apiをサンドボックスで呼び出す)

   - [出品パートナーAPIサンドボックスのエンドポイント](#出品パートナーapiサンドボックスのエンドポイント)

- [ベンダーセントラルのURL](#ベンダーセントラルのurl)

# 出品パートナーAPIとは何ですか？

出品パートナーAPIは、RESTベースのAPIです。ベンダーはプログラムでデータにアクセスしやすくなり、効率性を高め、必要労働量を削減し、顧客への応答時間を短縮することで、ビジネスの自動化に役立ちます。

## 出品パートナーAPIエンドポイント

出品パートナーAPIエンドポイントは、特定のAWSリージョンと関連付けられています。AWSリージョンは、出品パートナーAPIをリクエストするときに署名の計算に必要な認証情報スコープの一部であるため、重要です。[認証情報スコープ](#認証情報スコープ)を参照してください。

**出品パートナーAPIエンドポイント**

| **地理的リージョン** | **エンドポイント** | **AWSリージョン** |
| -------------------------------------------------------------------------------- | --------------------------------------- | -------------- |
| 北米（カナダ、米国、メキシコ、ブラジルのマーケットプレイス） | https://sellingpartnerapi-na.amazon.com | us-east-1 |
| ヨーロッパ（スペイン、イギリス、フランス、ドイツ、イタリア、トルコ、アラブ首長国連邦、インドのマーケットプレイス） | https://sellingpartnerapi-eu.amazon.com | eu-west-1 |
| 極東地域（シンガポール、オーストラリア、日本のマーケットプレイス） | https://sellingpartnerapi-fe.amazon.com | us-west-2 |

# ベンダーグループについて

出品パートナーAPIアプリケーションにデータへのアクセスを許可すると、ベンダーセントラルアカウントのサインイン認証情報に関連付けられたベンダーグループに、アクセス権を与えることになります。これはさらに、そのベンダーグループ内のすべてのベンダーコードにアクセス権を与えることになります。したがって、出品パートナーAPIの統合には、ベンダーセントラルの適切な資格情報とベンダーグループを使用することが重要です。

# 単独ベンダーグループの使用

単独のベンダーグループを使用してベンダーコードをすべて管理すると、アプリケーションにそのベンダーグループのデータへのアクセスを許可できます。そのためには、そのベンダーグループに関連付けられたベンダーセントラルアカウントの認証情報を使用して、[開発者として登録](#開発者として登録)します。

ベンダーグループに、アプリケーションがアクセスするすべてのベンダーコードが含まれるように、[ベンダーグループのベンダーコードを確認](#ベンダーグループのベンダーコードを確認)します。必要な場合、[ベンダーグループのベンダーコードの追加や削除](#ベンダーグループのベンダーコードを追加または削除)は、いつでも可能です。

## ベンダーグループのベンダーコードを確認

1. ご利用マーケットプレイスの[ベンダーセントラル](https://vendorcentral.amazon.co.jp)にアクセスします。マーケットプレイス別のURL一覧については、[ベンダーセントラルのURL](#ベンダーセントラルのurl)を参照してください。

2. アプリケーションがアクセスするベンダーグループで、ベンダーセントラルアカウントの認証情報を使用してサインインします。

3. **設定**メニューの**連絡先**をクリックします。

4. **連絡先**ページを確認して、アプリケーションがアクセスするベンダーコードが存在するかどうかを判断します。

## ベンダーグループのベンダーコードを追加または削除

1. ご利用マーケットプレイスの[ベンダーセントラル](https://vendorcentral.amazon.co.jp)にアクセスします。マーケットプレイス別のURL一覧については、[ベンダーセントラルのURL](#ベンダーセントラルのurl)を参照してください。

2. ベンダーコードを追加または削除するベンダーグループで、ベンダーセントラルアカウントの認証情報を使用してサインインします。

3. ページの上部にある**サポート**リンクをクリックします。

4. **サポート**ページで、**お問い合わせ**ボタンをクリックします。

5. **Amazonサポートへのお問い合わせ**ページで、**設定とアカウント管理**をクリックし、**アカウント設定**を選択します。

6. **設定とアカウント管理**ボックスの下部にある**さらにサポートが必要な場合**をクリックします。

7. 指示に従って、Amazonサポートにお問い合わせください。

# 複数ベンダーグループの使用

複数のベンダーグループを使用してベンダーコードを管理する場合があります。その場合、出品パートナーAPIの統合には、1) 必要なすべてのベンダーコードを含む[新しいベンダーグループを作成する](#新しいベンダーグループを作成する)か、2) 既存のベンダーグループを選択して必要なベンダーコードを追加することをお勧めします。ベンダーグループのベンダーコードは、いつでも追加または削除できます。ただし、開発者として登録すると、その開発者に関連付けられたベンダーグループを変更することはできません。ビジネスごとに異なるAPI統合を維持することはできます。そのためには、アクセスするベンダーグループごとに開発者として個別に登録します。その後、登録した各開発者との個別のAPI統合を開発できます。

## 新しいベンダーグループを作成する

1. ご利用マーケットプレイスの[ベンダーセントラル](https://vendorcentral.amazon.co.jp)にアクセスします。マーケットプレイス別のURL一覧については、[ベンダーセントラルのURL](#ベンダーセントラルのurl)を参照してください。

2. アプリケーションがアクセスするベンダーグループで、ベンダーセントラルアカウントの認証情報を使用してサインインします。

3. ページの上部にある**サポート**リンクをクリックします。

4. **サポート**ページで、**お問い合わせ**ボタンをクリックします。

5. **Amazonサポートへのお問い合わせ**ページで、**設定とアカウント管理**をクリックし、**アカウント設定**を選択します。

6. **設定とアカウント管理**ボックスの下部にある**さらにサポートが必要な場合**をクリックします。

7. 指示に従って、Amazonサポートにお問い合わせください。

# 開発者として登録

出品パートナーAPIアプリケーションを登録する前に、出品パートナーAPI開発者として登録する必要があります。

**開発者として登録するには**

1. 開発者アカウントに関連付ける認証情報を使用して、ご利用マーケットプレイスの[ベンダーセントラル](https://vendorcentral.amazon.co.jp)にサインインします。マーケットプレイス別のURL一覧については、[ベンダーセントラルのURL](#ベンダーセントラルのurl)を参照してください。

2. **統合**メニューの**API統合**をクリックします。

**デベロッパーセントラル**ページが表示されます。

3. **開発者プロファイルに進む**をクリックします。

   **開発者プロファイル**ページが表示されます。

4. 指示に従って開発者として登録します。

または

1. ご利用マーケットプレイスの開発者プロファイルページに直接アクセスして、サインインします。たとえば、日本のマーケットプレイスの場合はhttps://vendorcentral.amazon.co.jp/developer/register にアクセスします。

   **開発者プロファイル**ページが表示されます。

   **注**： 上記の開発者プロファイルページへのリンクは、日本のマーケットプレイス用です。他の地域のURLは、そのマーケットプレイスのベンダーセントラルのベースURLに、`/developer/register`を付けます。マーケットプレイス別のURL一覧については、[ベンダーセントラルのURL](#ベンダーセントラルのurl)を参照してください。

   たとえば、イギリスのマーケットプレイスの場合、ベンダーセントラルのベースURLは`https://vendorcentral.amazon.co.uk`なので、開発者プロファイルページのURLは`https://vendorcentral.amazon.co.uk/developer/register`となります。

2. 指示に従って開発者として登録します。

**開発者プロファイル申請のステータスを確認するには**

開発者プロファイル申請を送信すると、Amazonは提供された情報を評価し、その申請を承認または拒否します。却下された場合は、却下理由に対処した後、プロファイルを再送信できます。審査中の開発者プロファイル申請のステータスを確認するには

1. 開発者プロファイルの作成時に使用した認証情報を使用して、ベンダーセントラルにサインインします。

2. **統合**メニューの**API統合**をクリックします。

   **デベロッパーセントラル**ページが表示されます。

3. **開発者登録は審査中です**バナーの手順に従います。このバナーは、申請のステータスを反映して変わります。

開発者として登録されると、[出品パートナーAPIアプリケーションを登録](#出品パートナーapiアプリケーションの登録)できます。アプリケーション情報を表示するには、[アプリケーション情報の表示](#アプリケーション情報の表示)を参照してください。

# 出品パートナーAPIアプリケーションの登録

以下の手順では、アプリケーションの登録時に提供するIAMロールの作成を最終目的として、IAMポリシーとエンティティを作成して設定する方法について説明します。このワークフローでは、出品パートナーAPIを呼び出すアクセス権限のあるIAMロールを担うIAMユーザー（AWS STSポリシーがアタッチされている）を作成します。

開発者として登録し、出品パートナーAPIのアプリケーションを登録する手順を以下に示します。

[ステップ1.AWSアカウントを作成する](#ステップ1awsアカウントを作成する)

[ステップ2.IAMユーザーを作成する](#ステップ2iamユーザーを作成する)

[ステップ3.IAMポリシーを作成する](#ステップ3iamポリシーを作成する)

[ステップ4.IAMロールを作成する](#ステップ4iamロールを作成する)

[ステップ5.IAMユーザーにAWSセキュリティトークンサービスポリシーを追加する](#ステップ5iamユーザーにawsセキュリティトークンサービスポリシーを追加する)

[ステップ6.アプリケーションを登録する](#ステップ6アプリケーションを登録する)

## ステップ1.AWSアカウントを作成する

出品パートナーAPIセキュリティモデルではAWS認証情報が使用されるため、AWSアカウントが必要です。まだAWSのお客様ではない場合は、無料のAWSアカウントを作成できます。詳細については、[AWS無料利用枠](https://aws.amazon.com/free/)を参照してください。IAMはベンダーAPIを使用するために必要な唯一のAWS機能で、お客様のAWSアカウントへの追加料金なしで提供されます。

## ステップ2.IAMユーザーを作成する

IAMユーザーを作成して、出品パートナーAPIへの呼び出しを認証するためのAWSキーを取得します。この目的のためだけでも新たにIAMユーザーを作成することをお勧めします。IAMユーザーを使用して、[ステップ4.IAMロールを作成する](#ステップ4iamロールを作成する)で作成したIAMロールを継承します。

登録時に、IAMユーザーが出品パートナーAPIアプリケーションに関連付けられます。

**IAMユーザーを作成するには**

1. まだサインインしていない場合は、AWS管理コンソールにサインインし、<https://console.aws.amazon.com/iam>でIAMコンソールを開きます。

2. 左側のナビゲーションペインで、**ユーザー**をクリックし、**ユーザーを追加**をクリックします。

3. 新しいユーザーのユーザー名を入力します。これはAWSのサインイン名となります。

4. **プログラムによるアクセス**を選択し、**次のステップ： アクセス許可**をクリックします。

5. **権限の設定**ページで、デフォルトを受け入れ**次のステップ： タグ**をクリックします。[IAMロールを作成する](#ステップ4iamロールを作成する)ときにアクセス許可を設定します。

6. **タグの追加（オプション）**ページでオプションのタグを追加し、**次のステップ： 確認**をクリックします。

7. **確認**ページで、選択した内容を確認します。**このユーザーには権限がありません**という警告は無視できます。[IAMロールを作成する](#ステップ4iamロールを作成する)ときにアクセス許可を設定します。続行する準備ができたら、**ユーザーの作成**ボタンをクリックします。

   新しいIAMユーザーのAWSアクセスキーIDが表示されます。

8. **表示**をクリックすると、AWS秘密キーが表示されます。AWSアクセスキーを保存するには、**.csvのダウンロード**をクリックし、ファイルを安全な場所に保存します。

   **重要**： これは、AWS秘密アクセスキーを表示またはダウンロードする唯一の機会です。このキーは、出品パートナーAPIの呼び出しを認証する際に必要となります。AWSアクセスキーIDとAWS秘密キーを安全かつ安全な場所に保存します。**このステップの後でAWSアクセスキーに再度アクセスすることはできません。**AWS秘密アクセスキーを紛失した場合は、新しいキーセットを使用して新たにIAMユーザーを作成する必要があります。

9. **閉じる**をクリックします。

10. **ユーザー名**列で新しいIAMユーザーをクリックし、ユーザーARNを書き留めます。これは[ステップ4.IAMロールを作成する](#ステップ4iamロールを作成する)で必要となります。

詳細については、AWSドキュメントの[AWSアカウントでのIAMユーザーの作成](https://docs.aws.amazon.com/ja_jp/IAM/latest/UserGuide/id_users_create.html)を参照してください。

## ステップ3.IAMポリシーを作成する

このIAMポリシーは、出品パートナーAPIを呼び出すためのアクセス権限を定義します。[ステップ4.IAMロールを作成する](#ステップ4iamロールを作成する)で作成したIAMロールに適用します。

**IAMポリシーを作成するには**

1. AWS管理コンソールにサインインし、[console.aws.amazon.com/iam](https://console.aws.amazon.com/iam)でIAMコンソールを開きます。

2. 左側のナビゲーションペインで、**ポリシー**をクリックします。

   **ポリシー**を初めて選択する場合は、**管理ポリシーにようこそ**ページが表示されます。**開始する**をクリックします。

3. **ポリシーの作成**ボタンをクリックします。

4. **JSON**タブをクリックします。

5. テキストボックスに次のコードを貼り付け、既存のコードを置き換えて、**ポリシーの確認**をクリックします。

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

6. **ポリシーの確認**ページで、作成するポリシーの**名前**と**説明**（オプション）を入力します。IAMポリシーには<code>SellingPartnerAPI</code>という名前を付けることをお勧めします。

7. ポリシーの**概要**を確認して、ポリシーによって付与された権限を確認し、**ポリシーの作成**ボタンをクリックします。

新しいIAMポリシーがリストに表示されます。

詳細については、AWSドキュメントの[IAMポリシーの作成](https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies_create.html)を参照してください。

## ステップ4.IAMロールを作成する

[ステップ2.IAMユーザーを作成する](#ステップ2iamユーザーを作成する)で作成したIAMユーザーを信頼し、出品パートナーAPIを呼び出す権限のあるIAMロールを作成します。

**IAMロールを作成するには**

1. まだサインインしていない場合は、AWS管理コンソールにサインインし、[console.aws.amazon.com/iam](https://console.aws.amazon.com/iam)でIAMコンソールを開きます。

2. 左側のナビゲーションペインで、**ロール**をクリックし、**ロールを作成**ボタンをクリックします。

3. **ロールを作成**ページで、**別のAWSアカウント**をクリックします。

4. **アカウントID**ボックスに、[ステップ2.IAMユーザーを作成する](#ステップ2iamユーザーを作成する)でIAMユーザーを作成したAWSアカウントのアカウントIDを入力し、**次のステップ： アクセス許可**ボタンをクリックします。

5. **アクセス許可ポリシーの添付**ページの**ポリシー名**で、[ステップ3.IAMポリシーを作成する](#ステップ3iamポリシーを作成する)で作成したポリシーを選択し、**次のステップ： タグ**をクリックします。

   **ヒント：****フィルタポリシー**をクリックし、**カスタマー管理**を選択して選択を絞り込みます。

6. **タグの追加（オプション）**ページで、必要に応じてオプションのタグを追加し、**次のステップ： 確認**ボタンをクリックします。

7. **ロールを作成**ページで、**ロール名**ボックスにロール名を入力し、**ロールの説明**ボックスにオプションのロールの説明を入力し、**ロールを作成**ボタンをクリックします。

8. **ロール名**で、新しいロールの名前をクリックします。

   **概要**ページが表示されます。

9. ロールのARNを保存します。これは以下で必要となります。

   1. [ステップ5.IAMユーザーにAWSセキュリティトークンサービスポリシーを追加する](#ステップ5iamユーザーにawsセキュリティトークンサービスポリシーを追加する)とき

   2. [ステップ6.アプリケーションを登録する](#ステップ6アプリケーションを登録する)とき

詳細については、AWSドキュメントの[IAMユーザーに権限を委任するロールの作成](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_create_for-user.html)を参照してください。

## ステップ5.IAMユーザーにAWSセキュリティトークンサービスポリシーを追加する

[AWSセキュリティトークンサービス（AWS STS）](https://docs.aws.amazon.com/STS/latest/APIReference/welcome.html)ポリシーをIAMユーザーに追加すると、出品パートナーAPIへのリクエストの認証に使用できる一時的なAWSアクセスキーをリクエストできます。これらの認証情報は、一定期間が経過すると期限切れになり、AWSリソースへのアクセスを制御するのに役立ちます。

1. まだサインインしていない場合は、AWS管理コンソールにサインインし、[console.aws.amazon.com/iam](https://console.aws.amazon.com/iam)でIAMコンソールを開きます。

2. 左側のナビゲーションペインで、**ユーザー**をクリックし、AWS STSポリシーを追加するユーザーをクリックします。このワークフローでは、[ステップ2.IAMユーザーを作成する](#ステップ2iamユーザーを作成する)で作成したユーザーを選択します。他のユースケースでは別のIAMユーザーを選択することもできます。

3. **アクセス許可**タブで、**インラインポリシーの追加**をクリックします。

4. **ポリシーの作成**ページで、**サービスの選択**をクリックします。

5. **STS**サービスをクリックします。

   **ヒント。**検索ボックスに**STS**と入力して、選択肢を絞り込みます。

6. **書き込み**の横にある矢印をクリックして展開します。

7. **AssumeRole**を選択します。

8. **リソース**の横にある矢印をクリックして展開し、**ARN****を追加**をクリックします。

9. **ARNを追加**ダイアログボックスで、[ステップ4.IAMロールを作成する](#ステップ4iamロールを作成する)のロールARNを**ロールのARNを指定**ボックスに入力し、**追加**をクリックし、**ポリシーの確認**ボタンをクリックします。

10. **ポリシーの確認**ページで、**名前**ボックスにポリシーの名前を入力します。選択した内容を確認します。続行する準備ができたら、**ポリシーの作成**ボタンをクリックします。

## ステップ6.アプリケーションを登録する

デベロッパーセントラルでアプリケーションを登録します。

**アプリケーションを登録するには**

1. [開発者として登録](#開発者として登録)に使用した認証情報を使用して、ベンダーセントラルにサインインします。

2. **統合**メニューの**API統合**をクリックします。

   **デベロッパーセントラル**ページが表示されます。

3. 指示に従ってアプリケーションを登録します。

   **注**： 開発者登録申請書（DRAF）にまだ入力していない場合は、申請を登録する前に、このフォームに入力するよう指示されます。ロールが付与されると、アプリケーションを登録できます。DRAFのケースIDを確認して、提出のステータスを追跡します。

   **重要**： アプリケーションを登録する際、提供するIAM ARNは、[ステップ3.IAMポリシーを作成する](#ステップ3iamポリシーを作成する)でIAMポリシーをアタッチしたIAMエンティティ用のものである必要があります。このワークフローで、そのIAMエンティティは[ステップ4.IAMロールを作成する](#ステップ4iamロールを作成する)のIAMロールです。IAMユーザーを使用してアプリケーションを登録する場合は、IAMポリシーがアタッチされていることを確認してください。そうしないと、出品パートナーAPIへの呼び出しが失敗します。AWSリソースへのアクセスを適切に制御するために、このワークフローに示すようにIAMロールを使用してアプリケーションを登録することをお勧めします。

# アプリケーション情報の表示

[出品パートナーAPIアプリケーションを登録](#出品パートナーapiアプリケーションの登録)すると、ベンダーセントラルのデベロッパーセントラルページでアプリケーション情報を表示できます。

**アプリケーション情報を表示するには**

1. ご利用マーケットプレイスのベンダーセントラルにアクセスします。マーケットプレイス別のURL一覧については、[ベンダーセントラルのURL](#ベンダーセントラルのurl)を参照してください。

2. 出品パートナーAPI開発者であることを識別するベンダーアカウントの認証情報を使用して、サインインします。詳細については、[開発者としての登録](#開発者として登録)を参照してください。

3. **統合**メニューの**API統合**をクリックします。

   **デベロッパーセントラル**ページが表示され、登録した各アプリケーションのアプリケーション名とIAMユーザーARNが表示されます。

4. Login with Amazon（LWA）の認証情報を表示するアプリケーションの**表示**リンクをクリックします。

   **LWA認証情報**ボックスが表示され、アプリケーション認証用のLWAクライアント識別子が表示されます。

5. **クライアントシークレット**の横にある矢印をクリックして、アプリケーション認証用のLWAクライアントシークレットを表示します。

出品パートナーAPIを呼び出す前に、LWAアクセストークンをリクエストするには、このLWA認証情報が必要になります。詳細については、[ステップ1.Login with Amazonアクセストークンをリクエストする](#ステップ1login-with-amazonアクセストークンをリクエストする)をご覧ください。

# アプリケーションの認可

出品パートナーAPIの認可モデルは、AmazonのOAuth 2.0実装である[<u>Login with Amazon</u>](https://developer.amazon.com/docs/login-with-amazon/documentation-overview.html)（LWA）に基づくものです。[開発者として登録](#開発者として登録)し、[出品パートナーAPIアプリケーションを登録](#出品パートナーapiアプリケーションの登録)すると、アプリケーションが出品パートナーAPIを呼び出すことを許可して、ベンダーアカウント情報にアクセスできるようになります。ベンダーアカウント情報へのアクセスの詳細については、[ベンダーグループについて](#ベンダーグループについて)を参照してください。

**アプリケーションを認可するには**

1. ご利用マーケットプレイスのベンダーセントラルにアクセスします。マーケットプレイス別のURL一覧については、[ベンダーセントラルのURL](#ベンダーセントラルのurl)を参照してください。

2. 出品パートナーAPI開発者であることを識別するベンダーアカウントの認証情報を使用して、サインインします。詳細については、[開発者としての登録](#開発者として登録)を参照してください。

3. **統合**メニューの**API統合**をクリックします。

   **デベロッパーセントラル**ページが表示され、登録した各アプリケーションのアプリケーション名とIAMユーザーARNが表示されます。

4. 認可するアプリケーションの横にある**アクション**列で、**アプリの編集**の横にある下向き矢印をクリックしてから、**認可**をクリックします。

5. **アプリケーションの認可**ページで、**リフレッシュトークンを生成**ボタンをクリックします。

リフレッシュトークンが**リフレッシュトークン**ボックスに表示されます。

**注**： そのリフレッシュトークンは保存する必要があります。ページを離れると、再び表示することはできません。

リフレッシュトークンは、短期間のアクセストークンと交換する長期間有効なトークンです。出品パートナーAPIへのすべてのリクエストには、アクセストークンを含める必要があります。アクセストークンは発行から1時間有効です。有効期限が切れるまでは、複数のAPI呼び出しで同じアクセストークンを使用できます。[ステップ1.Login with Amazonアクセストークンをリクエストする](#ステップ1login-with-amazonアクセストークンをリクエストする)をご覧ください。

# LWAトークンの交換と認証を備えたJava SDKの生成

生成されるJava SDKで、出品パートナーAPIオペレーションを簡単に呼び出すことができます。このSDKは、アクセストークンのLogin with Amazon（LWA）リフレッシュトークンを交換することで認可を処理し、AWS署名バージョン4を使用してリクエストに署名することで認証を処理します。

以下の手順では、Microsoft Windowsを実行しているコンピューターで、[Swagger Code Generator](https://github.com/swagger-api/swagger-codegen)を使用してベンダー注文APIのJava SDKを生成する方法を説明します。このプロセスは、macOSやLinuxなどの他のオペレーティングシステムのユーザーも、Windows固有のセマンティクス（<code>C:\\</code>など）を置き換えることで応用できます。以下の手順はベンダー注文オペレーションに固有ですが、出品パートナーAPIの任意のオペレーションに対してSDKを生成するようにこの手順を変更できます。そのためには、（vendorOrders.jsonではなく）任意のSwaggerファイルをディレクトリ構造にコピーします。次に、コード例を変更して、「vendrOrders.json」を、使用しているSwaggerファイルのファイル名に置き換えます。

**前提条件**

この手順を完了するには、以下が必要です。

- **vendorOrders.json**これは、SDKの生成に使用するSwaggerファイルです。

- **sellingpartner-api-aa-java**フォルダこのフォルダには、認可および認証ライブラリと、Swagger Code Generator用のカスタマイズされたテンプレートが含まれています。

これらのファイルは、当社が提供したSDKに（この開発者ガイドとともに）含まれています。

**LWAトークンの交換と認証を備えたJava SDKを生成するには**

1. [Java 8以降](https://www.oracle.com/technetwork/java/index.html)、[Apache Maven 3.6以降](http://maven.apache.org/)、[GNU Wget](https://www.gnu.org/software/wget/wget.html)をインストールし、<code>$PATH</code>で利用できるようにします。

2. コマンドプロンプトウィンドウを開き、Swagger Code Generatorをダウンロードするディレクトリに移動します。

3. Swagger 2用Swagger Code Generatorの最新バージョンをダウンロードします。

   例：

   ```bash
   wget https://repo1.maven.org/maven2/io/swagger/swagger-codegen-cli/2.4.13/swagger-codegen-cli-2.4.13.jar -O swagger-codegen-cli.jar
   ```

   **swagger-codegen-cli.jar**が現在のディレクトリにダウンロードされます。

   **注意：**また、ブラウザに以下のURLを指示することで、maven.orgからダウンロードすることもできます：[https://repo1.maven.org/maven2/io/swagger/swagger-codegen-cli/2.4.13/swagger-codegen-cli-2.4.13.jar](https://repo1.maven.org/maven2/io/swagger/swagger-codegen-cli/2.4.13/swagger-codegen-cli-2.4.13.jar)

4. **vendorOrders.json**と**swagger-codegen-cli.jar**をディレクトリ構造にコピーすると、わかりやすくなります。この例では、<code>C:\\SwaggerToCL</code>にコピーします。

5. **sellingpartner-api-aa-java**フォルダ内のテンプレートに対してSDKを生成します。

   例：

   ```bash
   java -jar C:\\SwaggerToCL\\swagger-codegen-cli.jar generate -i C:\\SwaggerToCL\\vendorOrders.json -l java -t \[path to clients\\sellingpartner-api-aa-java directory\]/resources/swagger-codegen/templates/ -o C:\\SwaggerToCL\\vendorOrders_JavaCL
   ```

   このSDKは、C:\\SwaggerToCL\\vendorOrders_JavaCLにコピーされます。

6. AA（認可と認証）ライブラリを構築し、SDKの依存関係として追加します：**sellingpartner-api-aa-java**フォルダに移動し、<code>mvnパッケージ</code>を実行します。これにより、必要な依存関係をすべて含むディレクトリにJARファイルが生成されます。このフォルダーは、**sellingpartnerapi-aa-java-1.0-jar-with-dependencies**のような名前にする必要があります。

       - JARファイルをローカルのMavenリポジトリにインストールします。例：
       ```bash
       mvn install:install-file -Dfile=\[path to JAR file in "target" folder\] -DgroupId=com.amazon.sellingpartnerapi -DartifactId=sellingpartnerapi-aa-java -Dversion=1.0 -Dpackaging=jar
       ```
       上記の例で<code>groupId</code>、<code>artifactId</code>、<code>version</code>の値は、**sellingpartner-api-aa-java**フォルダーの**pom.xml**ファイルの上部近くで使用します。
       
       - クライアントライブラリのpom.xmlに、AAライブラリへの依存関係を追加します。
       ```xml
       <dependency>
       <groupId>com.amazon.sellingpartnerapi</groupId>
       <artifactId>sellingpartnerapi-aa-java</artifactId>
       <version>1.0</version>
       </dependency>
       ```

   SDKを生成したら、それを使用して出品パートナーAPIを呼び出すことができます。[生成されたJava SDKを使用した出品パートナーAPIへの接続](#生成されたjava-sdkを使用した出品パートナーapiへの接続)をご覧ください。

# 生成されたJava SDKを使用した出品パートナーAPIへの接続

以下の手順では、生成されたJava SDKを使用して出品パートナーAPIを呼び出す方法について説明します。SDKは、AWSとLWAの認証情報を設定するためのクラスを公開し、それを使用してLWAトークンを交換し、リクエストに署名します。

詳細については,「LWAトークンの交換と認証を備えたJava SDKの生成」(#lwaトークンの交換と認証を備えたjava-sdkの生成)を参照してください。

## ステップ1.AWS認証情報の設定

以下のパラメーターを使用して、<code>AWSAuthenticationCredentials</code>インスタンスを作成します。

| **名前** | **説明** | **必須** |
| --------------- | ----------------------------------------------------------------------------------------------------------------------------------------------- | ------------ |
| **accessKeyId** | AWSのアクセスキーID。詳細については、[ステップ2.IAMユーザーを作成する](#ステップ2iamユーザーを作成する)を参照してください。 | はい |
| **secretKey** | AWSの秘密アクセスキー。詳細については、[ステップ2.IAMユーザーを作成する](#ステップ2iamユーザーを作成する)を参照してください。 | はい |
| **region** | 呼び出しを指示しているAWSリージョン。詳細については、[出品パートナーAPIエンドポイント](#出品パートナーapiへの接続)を参照してください。 | はい |

例：

```java
import com.amazon.SellingPartnerAPIAA.AWSAuthenticationCredentials;
AWSAuthenticationCredentials awsAuthenticationCredentials=AWSAuthenticationCredentials.builder()
  .accessKeyId("myAccessKeyId")
  .secretKey("mySecretId")
  .region("us-west-2")
  .build();
```

## ステップ2.AWS認証情報プロバイダーの設定

以下のパラメーターを使用して、<code>AWSAuthenticationCredentialsProvider</code>インスタンスを作成します。

| **名前** | **説明** | **必須** |
| ------------------- | --------------------------------------------------------------------------------------------------------- | ------------ |
| **roleArn** | [ステップ4.IAMロールを作成する](#ステップ4iamロールを作成する)で作成したIAMロールのARN。 | はい |
| **roleSessionName** | 定義するセッションの識別子。ユニバーサルユニークID（UUID）を使用することをお勧めします。 | はい |

例：

```java
import com.amazon.SellingPartnerAPIAA.AWSAuthenticationCredentials;

AWSAuthenticationCredentialsProvider awsAuthenticationCredentialsProvider=AWSAuthenticationCredentialsProvider.builder()
  .roleArn("myroleARN")
  .roleSessionName("myrolesessioname")
  .build();
```

## ステップ3.LWA認証情報の設定

以下のパラメーターを使用して、<code>LWAAuthorizationCredentials</code>インスタンスを作成します。

| **名前** | **説明** | **必須** |
| ---------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ------------ |
| **clientId** | LWAのクライアントID。詳細については、[アプリケーション情報の表示](#アプリケーション情報の表示)を参照してください。 | はい |
| **clientSecret** | LWAのクライアントシークレット。詳細については、[アプリケーション情報の表示](#アプリケーション情報の表示)を参照してください。 | はい |
| **refreshToken** | LWAのリフレッシュトークン。ベンダーがアプリケーションを認可したときにこの値を取得します。詳細については、[アプリケーションの認可](#アプリケーションの認可)を参照してください。 | はい |
| **endpoint** | LWA認証サーバーのURI。 | はい |

例：

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

## ステップ4.ベンダー注文APIのインスタンスの作成と、オペレーションの呼び出し

<code>AWSAuthenticationCredentials</code>インスタンスと<code>LWAAuthorizationCredentials</code>インスタンスを設定すると、<code>vendorOrdersApi</code>インスタンスを作成してオペレーションを呼び出すことができます。

**注意：**これは、[LWAトークンの交換と認証を備えたJava SDKの生成](#lwaトークンの交換と認証を備えたjava-sdkの生成)で生成された、ベンダー注文APIのSDKを使用する例です。別のAPIのSDKを生成した場合は、以下の例の<code>vendorOrdersApi</code>をそのAPIに一致するテキストに置き換えます。たとえば、ベンダー出荷APIに生成されたSDKには、<code>vendorShippingAPI</code>を使用します。

例：

```java
vendorOrdersApi vendorOrdersApi = new vendorOrdersApi.Builder()
  .awsAuthenticationCredentials(awsAuthenticationCredentials)
  .lwaAuthorizationCredentials(lwaAuthorizationCredentials)
  .endpoint("https://sellingpartnerapi-na.amazon.com")
  .build();
vendorOrdersApi.getMarketplaceParticipations();
```

# Javaクライアントライブラリの生成

生成されたJavaクライアントライブラリは、URIを構築してリクエストを行うためのヘッダーを追加するのに役立ちますが、リクエストの認可と認証には役立ちません。それでも、[ステップ1.Login with Amazonアクセストークンをリクエスト](#ステップ1login-with-amazonアクセストークンをリクエストする)して、[ステップ4.リクエストの作成と署名](#ステップ4リクエストの作成と署名)を行う必要があります。

**注意：**ほとんどのJava開発者にとって、出品パートナーAPIに接続する最も簡単な方法は、生成された、認証と認可が含まれるJava SDKを使用することです。詳細については、[LWAトークンの交換と認証を備えたJava SDKの生成](#lwaトークンの交換と認証を備えたjava-sdkの生成)**を参照してください。**

以下の手順では、Microsoft Windowsを実行しているコンピューターで、[Swagger Code Generator](https://github.com/swagger-api/swagger-codegen)を使用してベンダー注文APIのJavaクライアントライブラリを生成する方法を説明します。このプロセスは、macOSやLinuxなどの他のオペレーティングシステムのユーザーでも、Windows固有のセマンティクス（C:\\など）を置き換えることで応用できます。以下の手順はベンダー注文オペレーションに固有ですが、これを変更して、出品パートナーAPIの任意のオペレーションにクライアントライブラリを生成できます。そのためには、（vendorOrders.jsonではなく）任意のSwaggerファイルをディレクトリ構造にコピーします。次に、コード例を変更して、「vendrOrders.json」を、使用しているSwaggerファイルのファイル名に置き換えます。

**前提条件**

この手順を完了するには、以下が必要です。

- **vendorOrders.json**これは、SDKの生成に使用するSwaggerファイルです。

**Javaクライアントライブラリを生成するには**

1. [Java 8以降](http://java.oracle.com/)、[Apache Maven 3.6以降](http://maven.apache.org/)、[wget](http://gnuwin32.sourceforge.net/packages/wget.htm)をインストールし、\$PATHで利用できるようにします。

2. <https://github.com/amzn/selling-partner-api-models>に進みます。

3. まだ実行していない場合は、リポジトリをクローンしてコンピュータにローカルコピーを作成します。

4. コマンドプロンプトウィンドウを開き、Swagger Code Generatorをダウンロードするディレクトリに移動します。

5. Swagger 2用Swagger Code Generatorの最新バージョンをダウンロードします。

   例：

   ```bash
   wget http://central.maven.org/maven2/io/swagger/swagger-codegen-cli/2.4.7/swagger-codegen-cli-2.4.7.jar -O swagger-codegencli.jar
   ```

   **swagger-codegen-cli.jar**が現在のディレクトリにダウンロードされます。

   **注**また、ブラウザに以下のURLを指定することで、maven.orgからダウンロードすることもできます。<http://central.maven.org/maven2/io/swagger/swagger-codegen-cli/2.4.7/swagger-codegen-cli-2.4.7.jar>

6. **vendorOrders.json**と**swagger-codegen-cli.jar**をディレクトリ構造にコピーすると、わかりやすくなります。この例では、C:\\SwaggerToCLにコピーします。

7. クライアントライブラリを生成します。

   例：

   ```bash
   java -jar C:\\SwaggerToCL\\swagger-codegen-cli.jar generate -i C:\\SwaggerToCL\\vendorOrders.json -l java -o C:\\SwaggerToCL\\vendorOrders.json_JavaCL
   ```

   クライアントライブラリが、C:\\SwaggerToCL\\vendorOrders_JavaCLにコピーされます。

# 出品パートナーAPIへの接続

以下で、出品パートナーAPIを呼び出す手順を説明します。この手順は、主にJava以外の言語でコーディングする開発者向けです。Javaでコーディングする開発者には、生成されたJava SDKを使用することをお勧めします。リクエストの作成に役立ち、認可と認証がはるかに簡単になります。詳細については、[LWAトークンの交換と認証を備えたJava SDKの生成](#lwaトークンの交換と認証を備えたjava-sdkの生成)をご覧ください。

開発者のアプリケーションを出品パートナーAPIに接続するには、アプリケーションを登録し、登録したアプリケーションを出品パートナーに認可してもらう必要があります。[出品パートナーAPIアプリケーションの登録](#出品パートナーapiアプリケーションの登録)と[アプリケーションの認可](#アプリケーションの認可)を参照してください。

## ステップ1.Login with Amazonアクセストークンをリクエストする

Login with Amazon（LWA）アクセストークンにより、開発者のアプリケーションが出品パートナーの代わりに特定のアクションを実行することが認可されます。アクセストークンは発行後1時間で失効します。また、出品パートナーAPIへのすべてのリクエストに含める必要があります。

アクセストークンをリクエストするには、以下のパラメーターを使用して、LWA認証サーバー（https://api.amazon.com/auth/o2/token） に安全なHTTP POSTを実行します。

| **名前** | **説明** | **必須** |
| ----------------- | ------------------------------------------------------------------------------------------------------------------------------------ | ------------ |
| **grant_type** | 要求されるアクセス許可のタイプ。refresh_tokenである必要があります。 | はい |
| **refresh_token** | アプリケーションの出品用アカウントへのアクセスを認可するには、この値を取得します。[アプリケーションの認可](#アプリケーションの認可)を参照してください。 | はい |
| **client_id** | アプリケーションを登録するときにこの値を取得します。[アプリケーション情報の表示](#アプリケーション情報の表示)を参照してください。 | はい |
| **client_secret** | アプリケーションを登録するときにこの値を取得します。[アプリケーション情報の表示](#アプリケーション情報の表示)を参照してください。 | はい |

例：

```http
POST /auth/o2/token HTTP/l.l
Host: api.amazon.com
Content-Type: application/x-www-form-urlencoded;charset=UTF-8 grant_type=refresh_token&refresh_token=Atzr\|IQEBLzAtAhRPpMJxdwVz2Nn6f2y-tpJX2DeX...&client_id=foodev&client_secret=Y76SDl2F
```

**ヒント：**LWA認可サーバーを呼び出すときに信頼されていない認証機関（CA）エラーが発生しないようにするには、アプリケーションがLWAサーバーを信頼するよう、トラストストアを必ず更新してください。

**cURL**

必要に応じて、cURLを使用してアクセストークンをリクエストすることもできます。例：

```bash
curl -k -X POST -H 'Content-Type: application/x-www-form-urlencoded' -d 'grant_type=refresh_token& refresh_token=Atzr\|IQEBLzAtAhRPpMJxdwVz2Nn6f2y-tpJX2DeX...&client_id=foodev&client_secret=Y76SDl2F https://api.amazon.com/auth/O2/token
```

**Response**

成功レスポンスには、以下の値が含まれます。

| **名前** | **説明** |
| ----------------- | ------------------------------------------------------------------------------ |
| **access_token** | アクセストークン。最大サイズ： 2048バイト。 |
| **token_type** | 返されるトークンのタイプ。ベアラーである必要があります。 |
| **expires_in** | アクセストークンが無効になるまでの秒数。 |
| **refresh_token** | リクエストで送信したリフレッシュトークン。最大サイズ： 2048バイト。 |

例：

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

詳細については、Login with Amazonドキュメントの[認証コードの付与](https://developer.amazon.com/docs/login-with-amazon/authorization-code-grant.html)ページを参照してください。

## ステップ2.出品パートナーAPIのURIを構築する

以下は、出品パートナーAPI URIのコンポーネントです。

| **名前** | **説明** | **例** |
| ----------------- | ------------------------------------------------------------------------------------------ | ------------ |
| **HTTPメソッド** | HTTPメソッド。 | GET |
| **エンドポイント** | [出品パートナーAPIエンドポイント](#出品パートナーapiエンドポイント)。 | <https://sellingpartnerapi-fe.amazon.com> |
| **パス** | 出品パートナーAPIセクション/リソースのセクション/バージョン番号。 | <code>vendor/orders/v1/purchaseOrders</code> |
| **クエリ文字列** | クエリパラメーター | <code>?limit={example}&amp;createdAfter={example}&amp;createdBefore={example}&amp;sortOrder={example}&amp;nextToken={example}&amp;includeDetails={example}</code> |


例：

```http
GET https://sellingpartnerapi-fe.amazon.com/vendor/orders/v1/purchaseOrders?limit={example}&createdAfter={example}&createdBefore={example}&sortOrder={example}&nextToken={example}&includeDetails={example}
```

**注意：**Javaを使用してアプリケーションを作成する場合は、生成されたJavaクライアントライブラリを使用してURIを構築できます。詳細については、[Javaクライアントライブラリの生成](#javaクライアントライブラリの生成)を参照してください 。

## ステップ3.URIにヘッダーを追加する

ステップ2で作成したURIにヘッダーを追加します。

出品パートナーAPIへのリクエストに含めるHTTPヘッダーは次のとおりです。

**リクエストヘッダー**

| **名前** | **説明** | **必須** |
| ----------------- | ------------------------------------------------------------------------------------------------------------------------------------ | ------------ |
| **host** | 出品パートナーのエンドポイント。[出品パートナーAPIエンドポイント](#出品パートナーapiエンドポイント)を参照してください。 | はい |
| **x-amz-access-token** | Login with Amazonアクセストークン。[ステップ1.Login with Amazonアクセストークンをリクエストする](#ステップ1login-with-amazonアクセストークンをリクエストする)をご覧ください。 | はい |
| **x-amz-date** | リクエストの日時。 | はい |
| **user-agent** | アプリケーション名とバージョン番号、プラットフォーム、プログラミング言語。これらの情報は、サービスで発生する可能性のある問題を診断して解決する際に役立ちます。[すべてのリクエストにUser-Agentヘッダーを含める](#すべてのリクエストにuser-agentヘッダーを含める)を参照してください。 | はい |

以下に、URIとヘッダーはあるが署名情報がない出品パートナーAPIリクエストの例を示します。

```http
GET https://sellingpartnerapi-fe.amazon.com/vendor/orders/v1/purchaseOrders?limit={example}&createdAfter={example}&createdBefore={example}&sortOrder={example}&nextToken={example}&includeDetails={example} HTTP/1.1
host: https://sellingpartnerapi-fe.amazon.com
user-agent: My Selling Tool/2.0 (Language=Java/1.8.0.221; Platform=Windows/10)
x-amz-access-token=Atza|IQEBLjAsAhRmHjNgHpi0U-Dme37rR6CuUpSREXAMPLE
x-amz-date: 20190430T123600Z
```

**注意：**Javaを使用してアプリケーションを作成する場合は、生成されたJavaクライアントライブラリを使用して、URIにヘッダーを追加できます。詳細については、[Javaクライアントライブラリの生成](#javaクライアントライブラリの生成)を参照してください 。

リクエストに署名するには、[ステップ4.リクエストの作成と署名](#ステップ4リクエストの作成と署名)をご覧ください。

## ステップ4.リクエストの作成と署名

出品パートナーAPIでは、[署名バージョン4署名プロセス](https://docs.aws.amazon.com/general/latest/gr/signature-version-4.html)を使用してリクエストを認証します。出品パートナーAPIにHTTPリクエストを送信する際に、リクエストを送信したユーザーが識別されるよう、リクエストに署名します。アクセスキーIDと秘密キーで構成されるAWSアクセスキーを使用して、リクエストに署名します。AWSアクセスキーの取得については、[ステップ2.IAMユーザーを作成する](#ステップ2iamユーザーを作成する)を参照してください。

**注**手動でHTTPリクエストを作成する場合に限り、HTTPリクエストの署名方法について学ぶ必要があります。いずれかのAWS SDKを使用して署名を計算すると、設定時に指定したアクセスキーを使用して、SDKによってリクエストに自動的に署名されます。SDKを使用する場合は、自分でリクエストに署名する方法を学ぶ必要がありません。たとえばJava開発者は、署名を計算するためのモデルとして、Java用AWS SDKの[AWS4Signer.java](https://github.com/aws/aws-sdk-java/blob/master/aws-java-sdk-core/src/main/java/com/amazonaws/auth/AWS4Signer.java)を使用できます。[AWS GitHubリポジトリ](https://github.com/aws)には、他の言語用のSDKも用意されています。

リクエストを作成して署名するには、次の操作を行います。

1. 正規リクエストを作成する

   AWSドキュメントの[タスク1： 署名バージョン4の正規リクエストを作成する](https://docs.aws.amazon.com/general/latest/gr/sigv4-create-canonical-request.html)に従って、このガイダンスを使用します。

   - [ステップ3.URIにヘッダーを追加する](#ステップ3uriにヘッダーを追加する)をご覧ください。
   - ハッシュアルゴリズムにはSHA-256を使用します。
   - クエリパラメーターには認証情報を入れないでください。これは[Authorizationヘッダー](#authorizationヘッダー)パラメーターに含めてください。

2. 署名する文字列を作成する

   AWSドキュメントの[タスク2： 署名バージョン4の署名文字列を作成する](https://docs.aws.amazon.com/general/latest/gr/sigv4-create-string-to-sign.html)に従って、このガイダンスを使用します。

   - アルゴリズムの指定値は、<code>AWS4-HMAC-SHA256</code>です。
   - 認証情報スコープを決定するには、[認証情報スコープ](#認証情報スコープ)をご覧ください。

3. 署名を計算する

   AWSドキュメントの[タスク3： AWS署名バージョン4の署名を計算する](https://docs.aws.amazon.com/general/latest/gr/sigv4-calculate-signature.html)に従います。

4. 署名情報を追加する

   AWSドキュメントの[タスク4： HTTPリクエストに署名を追加する](https://docs.aws.amazon.com/general/latest/gr/sigv4-add-signature-to-request.html)に従って、このガイダンスを使用します。

   - クエリ文字列には署名情報を追加しないでください。これはAuthorizationヘッダーに追加します。
   - Authorizationヘッダー作成の詳細については、[Authorizationヘッダー](#authorizationヘッダー)を参照してください。

次の例では、Authorizationヘッダーを使用して署名情報を追加した後で、リクエストがどのように表示されるかを示します。

```http
GET https://sellingpartnerapi-fe.amazon.com/vendor/orders/v1/purchaseOrders?limit={example}&createdAfter={example}&createdBefore={example}&sortOrder={example}&nextToken={example}&includeDetails={example} HTTP/1.1
Authorization: AWS4-HMAC-SHA256 Credential=AKIDEXAMPLE/20190430/us-east- 1/execute-api/aws4_request, SignedHeaders=host;user-agent;x-amz-access-token, Signature=5d672d79c15b13162d9279b0855cfba6789a8edb4c82c400e06b5924aEXAMPLE
host: https://sellingpartnerapi-fe.amazon.com
user-agent: My Selling Tool/2.0 (Language=Java/1.8.0.221; Platform=Windows/10)
x-amz-access-token=Atza|IQEBLjAsAhRmHjNgHpi0U-Dme37rR6CuUpSREXAMPLE
x-amz-date: 20190430T123600Z
```

### 認証情報スコープ

認証情報スコープとは、出品パートナーAPIへのリクエストに署名する際に作成する「署名文字列」のコンポーネントです。[ステップ4.リクエストの作成と署名](#ステップ4リクエストの作成と署名)をご覧ください。

認証情報スコープは、次の表に示すように、スラッシュで区切られたディメンション文字列で表されます。

| **ディメンション** | **説明** | **例** |
| ----------------- | ------------------------------------------------------------------------------------------ | ------------ |
| Date | リクエストの年（YYYY）、月（MM）、日（DD）を表す8桁の文字列。 | 20190430 |
| AWS region | リクエストを送信するリージョン。[出品パートナーAPIエンドポイント](#出品パートナーapiエンドポイント)を参照してください。 | us-west-2 |
| Service | リクエストしているサービス。この値はエンドポイントにあります。[出品パートナーAPIエンドポイント](#出品パートナーapiエンドポイント)を参照してください。 | execute-api |
| Termination string | 特別な終了文字列。AWS署名バージョン4の場合、値はaws4\_requestです。 | aws4_request |

例：

```http
20190430/us-west-2/execute-api/aws4_request
```

**重要**認証情報スコープの一部として使用する日付は、**x-amz-date**ヘッダーで指定されたリクエストの日付と一致する必要があります。詳しくは、AWSドキュメントの[署名バージョン4の日付の処理](https://docs.aws.amazon.com/general/latest/gr/sigv4-date-handling.html)を参照してください。

詳細については、[ステップ4.リクエストの作成と署名](#ステップ4リクエストの作成と署名)をご覧ください。

### Authorizationヘッダー

Authorizationヘッダーには、要求に対する署名情報が含まれます。ヘッダーは「Authorization」という名前ですが、署名情報は認証に使用されるものです。

Authorizationヘッダーのコンポーネントは次のとおりです。

| **ヘッダーコンポーネント** | **説明** |
| ---------------| -----------|
| 署名に使用されるアルゴリズム | 署名プロセス全体で使用されるハッシュアルゴリズム。出品パートナーAPIには、SHA-256が必要です。これは、[ステップ4.リクエストの作成と署名](#ステップ4リクエストの作成と署名)を指定します |
| 認証情報 | AWSアクセスキーIDは、[ステップ2.IAMユーザーを作成する](#ステップ2iamユーザーを作成する)を参照してください。 |
| 署名付きヘッダー | 署名付きリクエストに含めたすべてのHTTPヘッダーのリスト。例については、[ステップ3.URIにヘッダーを追加する](#ステップ3uriにヘッダーを追加する)をご覧ください。 |
| Signature | [ステップ4.リクエストの作成と署名](#ステップ4リクエストの作成と署名)をご覧ください。 |


例：

```http
Authorization: AWS4-HMAC-SHA256 Credential=AKIDEXAMPLE/20190430/us-east- 1/execute-api/aws4_request, SignedHeaders=host;user-agent;x-amz-access- token;x-amz-date, Signature=5d672d79c15b13162d9279b0855cfba6789a8edb4c82c400e06b5924aEXAMPLE
```

詳細については、[ステップ4.リクエストの作成と署名](#ステップ4リクエストの作成と署名)をご覧ください。

# レスポンスのフォーマット

HTTPリクエストへの応答で、出品パートナーAPIはレスポンスヘッダーとJSONレスポンスメッセージを返します。

**レスポンスヘッダー**

| **名前** | **説明** |
| ---------| -----------------|
| Content-Length | 標準HTTPレスポンスヘッダー。 |
| Content-Type | 標準HTTPレスポンスヘッダー。 |
| Date | 標準HTTPレスポンスヘッダー。 |
| x-amzn-ErrorType | エラータイプ。 |
| x-amzn-RequestId | リクエストID。サポートが必要な場合は、問い合わせ時にこの内容をお伝えください。 |

**成功レスポンス**

リクエストが成功すると、出品パートナーAPIはリクエストされたデータを返します。以下に、getOrders APIの呼び出しに対する成功レスポンスの例を示します。

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

**エラーレスポンス**

リクエストが失敗した場合、出品パートナーAPIはエラーレスポンスを返します。エラーレスポンスのレスポンスメッセージに含まれる要素は次のとおりです。

**レスポンスメッセージ**

| **要素** | **説明** | **必須** |
| ----------- | ------------- | ------------- |
| code | HTTPステータスコード。 | はい |
| message | エラー状態の説明。 | はい |
| details | 追加情報へのリンク。 | いいえ |

エラーレスポンスの例を次に示します。

```http
HTTP/1.1 400 Bad Request
Content-Length: 117
Content-Type: application/json
Date: Fri, 08 Jun 2019 00:48:28 GMT
x-amzn-ErrorType: ValidationException
x-amzn-RequestId: a8c8d99a-6ab5-11e8-b0f8-19363980175b

{
  "code": "400",
  "message": "The request could not be understood by the server due to malformed syntax（構文が正しくないため、リクエストをサーバーが理解できませんでした）"
}
```

# すべてのリクエストにUser-Agentヘッダーを含める

User-Agentヘッダーは、アプリケーションとそのバージョン番号、および使用しているプラットフォームとプログラミング言語を識別します。出品パートナーAPIに送信するリクエストごとに、User-Agentヘッダーを含める必要があります。これにより、効率良く問題を診断して解決できるため、出品パートナーAPIをより快適に使用いただくことにつながります。

User-Agentヘッダーを作成するには、アプリケーション名から開始し、スラッシュ、アプリケーションのバージョン、スペース、左丸括弧、言語名の値ペア、右丸括弧の順に入力します。言語パラメーターは必須の属性ですが、セミコロンで区切ることでその他の属性を追加することができます。

次の擬似コードは、受け入れ可能な最小限度の条件を満たすUser-Agentヘッダーを説明するものです。

<code>AppId/AppVersionId (Language=LanguageNameAndOptionallyVersion)</code>

以下に、外部アプリケーションインテグレーターで使用されるUser-Agentヘッダーの例を示します。

<code>My Selling Tool/2.0 (Language=Java/1.8.0.221; Platform=Windows/10)</code>

自社のIT部門を通じてインテグレーションを行っている大規模なベンダーである場合は、User-Agentヘッダーを以下のように使用できます。これにより、出品パートナーAPIがHost属性を使用して問題解決をサポートします。

<code>MyCompanyName/build1611 (Language=Perl; Host=jane.desktop.example.com)</code>

その他の属性を指定するには、AttributeName=Value;のフォーマット（名前と値のペアをセミコロンで区切る）を使用します。バックスラッシュ（\\）を使用したい場合は、2つつなげて（\\\\）エスケープして使用してください。アプリケーション名内のスラッシュ（\\/）、アプリケーションバージョン内の左丸括弧（\\(）、属性名内の等号（\\=）、右丸括弧（\\)）および属性値内のセミコロン（\\;）についても同様にエスケープし使用してください。

User-Agentヘッダはすべてのリクエストで送信されるので、ヘッダのサイズを制限することをお勧めします。出品パートナーAPIは、500文字を超えるUser-Agentヘッダーを拒否します。

# 出品パートナーAPIサンドボックス

出品パートナーAPIでは、実稼動データに影響を与えたり、実際のイベントを発生させたりすることなく、アプリケーションをテストできるサンドボックス環境が提供されます。出品パートナーAPIへのサンドボックス呼び出しは、[出品パートナーAPIサンドボックスエンドポイント](#出品パートナーapiサンドボックスのエンドポイント)への呼び出しを指示する以外は、実稼働呼び出しを行う場合と同じです。認可モデルと認証モデルは、サンドボックス呼び出しと実稼働呼び出しで同じです。サンドボックスエンドポイントを呼び出すと、すべての出品パートナーAPIに対して静的な模擬レスポンスが返されます。呼び出すAPIのSwaggerモデルJSONファイルで、これらの模擬レスポンスを参照できます。詳細については、[出品パートナーAPIをサンドボックスで呼び出す方法](#出品パートナーapiをサンドボックスで呼び出す方法)をご覧ください。

出品パートナーAPIサンドボックスは、多くの模擬フレームワークと同じように機能し、指定されたパラメーターが存在する場合は、パターンマッチングを使用して、指定されたレスポンスを返します。開発者が、指定されたパラメーターに一致するリクエストを送信すると、x-amazon-spds-sandbox-behaviorsオブジェクトで定義されたレスポンスが返されます。

サンドボックスエンドポイントに送信されたリクエストが、x-amazon-spds-sandbox-behaviorsオブジェクトのパラメーター値と一致しない場合、レスポンスで「500 内部サーバーエラー」を受け取ります。モデルで指定されている正確な値でリクエストを送信する必要があります。

x-amazon-spds-sandbox-behaviorsオブジェクトで指定されていないパラメーターがAPIで必要な場合は、リクエストが有効な限り、リクエスト内のパラメーター値に関係なく、サンドボックスからレスポンスが返されます。

**重要**サンドボックスは、拡張性のテストではなく、機能をテストするためのものです。サンドボックスエンドポイントの呼び出しには、**rate** = 1秒あたり5リクエスト、**burst** = 15のスロットリング制限が適用されます。

## 出品パートナーAPIをサンドボックスで呼び出す方法

**前提条件**

この手順を完了するには、SwaggerモデルのJSONファイル（vendorOrders.jsonなど）が必要です。

SwaggerモデルのJSONファイルは、当社が提供したSDKに（この開発者ガイドとともに）含まれています。

### ステップ1.リクエストパラメーターのJSONファイルをチェックする

1. 呼び出すAPIのJSONファイルを開きます。

2. <code>"x-amazon-spds-sandbox-behaviors"</code>を検索します。

JSONファイルのx-amazon-spds-sandbox-behaviorsオブジェクトには、APIのサンドボックス呼び出しのリクエストとレスポンスの例が含まれています。リクエスト例にパラメーターが含まれている場合は、次のステップで使用します。

### ステップ2.APIをサンドボックスで呼び出す

APIをサンドボックスで呼び出す方法は、実稼働で呼び出す方法と同じですが、以下の違いがあります。

1. JSONファイルの<code>x-amazon-spds-sandbox-behaviors</code>オブジェクト内のリクエストオブジェクトに、1つまたは複数のパラメーターと値のペアが含まれている場合は、呼び出し時にそれを指定します。

2. [出品パートナーAPIサンドボックスエンドポイント](#出品パートナーapiサンドボックスのエンドポイント)の1つを呼び出す指示をします。

受信するレスポンスは、JSONファイルの<code>x-amazon-spds-sandbox-behaviors</code>オブジェクトに含まれるペイロードオブジェクトと一致する必要があります。

## 出品パートナーAPIサンドボックスのエンドポイント

出品パートナーAPIには、北米、ヨーロッパ、極東地域の出品リージョン向けのサンドボックスエンドポイントがあります。詳細については、[出品パートナーAPIサンドボックス](#出品パートナーapiサンドボックス)を参照してください。

| **出品リージョン** | **エンドポイント** | **AWSリージョン** |
| --------------- | ------------ | ----------- |
| 北米（カナダ、米国、メキシコ、ブラジルのマーケットプレイス） | [https://sandbox.sellingpartnerapi-na.amazon.com](https://sandbox.sellingpartnerapi-na.amazon.com) | us-east-1 |
| ヨーロッパ（スペイン、イギリス、フランス、ドイツ、イタリア、トルコ、アラブ首長国連邦、インドのマーケットプレイス） | [https://sandbox.sellingpartnerapi-eu.amazon.com](https://sandbox.sellingpartnerapi-eu.amazon.com) | eu-west-1 |
| 極東地域（シンガポール、オーストラリア、日本のマーケットプレイス） | [https://sandbox.sellingpartnerapi-fe.amazon.com](https://sandbox.sellingpartnerapi-fe.amazon.com) | us-west-2 |

# ベンダーセントラルのURL

以下に、マーケットプレイス別のベンダーセントラルのURLを示します。

**北米**

| **マーケットプレイス** | **ベンダーセントラルのURL** |
| --------------- | ------------------------------------- |
| カナダ | <https://vendorcentral.amazon.ca> |
| 米国 | <https://vendorcentral.amazon.com> |
| メキシコ | <https://vendorcentral.amazon.com.mx> |

**ヨーロッパ**

| **マーケットプレイス** | **ベンダーセントラルのURL** |
| --------------- | ------------------------------------- |
| スペイン | <https://vendorcentral.amazon.es> |
| 英国 | <https://vendorcentral.amazon.co.uk> |
| フランス | <https://vendorcentral.amazon.fr> |
| ドイツ | <https://vendorcentral.amazon.de> |
| イタリア | <https://vendorcentral.amazon.it> |
| インド | <https://www.vendorcentral.in> |
| トルコ | <https://vendorcentral.amazon.com.tr> |
| オランダ | <https://vendorcentral.amazon.nl> |
| アラブ首長国連邦 | <https://vendorcentral.amazon.ae> |

**極東地域**

| **マーケットプレイス** | **ベンダーセントラルのURL** |
| --------------- | ------------------------------------- |
| オーストラリア | <https://vendorcentral.amazon.com.au> |
| 日本 | <https://vendorcentral.amazon.co.jp> |
| シンガポール | <https://vendorcentral.amazon.com.sg> |

**南アメリカ**

| **マーケットプレイス** | **ベンダーセントラルのURL** |
| --------------- | ------------------------------------- |
| ブラジル | <https://vendorcentral.amazon.com.br> |