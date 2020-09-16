# 出品パートナーAPIの役割

# 概要

## 役割とは

役割とは、開発者またはアプリケーションがオペレーションやリソースのアクセス権を持つかどうかを判断するために、出品パートナーAPIで使用されるメカニズムのことです。開発者は、特定の役割をリクエストして取得する必要があります。役割を持っていないと、その役割の管理下にあるオペレーションやリソースのグループにアクセスできません。役割は、個人識別情報（PII）やその他の機密データへのアクセスを保護するとともに、開発者がアプリケーションに必要なデータのみにアクセスできるようにデータへのアクセスを制限します。役割を利用することで、Amazon、および出品パートナーAPIを使用する出品パートナーサービス事業者が、購入者から信頼を得られるようになります。

# 役割の定義

次の表で、*制限あり*は役割に機密情報の取り扱いが必要なことを示しています。機密情報には、個人識別情報（PII）が含まれる場合があります。データの用途とセキュリティ管理に関して追加情報を入力するように求められます。

各役割の説明に記載されたオペレーションは、例にすぎません。最終的なリストでも包括的なリストでもありません。

<table>
<thead>
<tr class="header">
<th><strong>役割</strong></th>
<th><strong>説明</strong></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td><strong>商品の出品</strong></td>
<td>商品の出品情報を作成および管理します。
通常、商品カタログ関連のレポートとフィード、およびオペレーションに使用されます。
この役割の割り当てを必要とするオペレーションの例を次に示します。
<ul>
<li>カタログ商品向け出品パートナーAPIの<strong>getCatalogItem</strong>オペレーション。指定された商品とそのアトリビュートに関する情報を返します。</li>
<li>レポート向け出品パートナーAPIの<strong>createReport</strong>オペレーション。<strong>GET_MERCHANT_LISTINGS_INACTIVE_DATA</strong>レポートのリクエストに使用されます。このレポートは、停止中の出品情報の詳細を返します。</li>
<li>商品手数料向け出品パートナーAPIの<strong>getMyFeesEstimateForSKU</strong>オペレーション。指定された商品の手数料の見積もりを返します。</li>
</ul></td>
</tr>
<tr class="even">
<td><strong>価格設定</strong></td>
<td>定価を決定し、商品価格設定を自動化します。
通常、価格設定関連のレポートとフィード、およびオペレーションに使用されます。
この役割の割り当てを必要とするオペレーションの例を次に示します。
<ul>
<li>フィード向け出品パートナーAPIの<strong>createFeed</strong>オペレーション。<strong>RFQ_UPLOAD_FEED</strong>フィードの送信に使用されます。これにより、法人・個人事業主のお客様からのリクエストに応じて数量割引をアップロードできます。</li>
<li>価格設定向け出品パートナーAPIの<strong>getPricing</strong>オペレーション。出品者の出品情報に関する価格設定情報を返します。</li>
<li>レポート向け出品パートナーAPIの<strong>createReport</strong>オペレーション。<strong>GET_MERCHANT_CANCELLED_LISTINGS_DATA</strong>レポートのリクエストに使用されます。このレポートは、キャンセルされた出品情報を返します。</li>
</ul></td>
</tr>
<tr class="odd">
<td><strong>在庫および注文管理</strong></td>
<td>在庫を分析して管理します。
通常、FBA売上レポート、注文トラッキングレポート、および注文、ベンダー注文、販売注文指標、在庫管理に関連するオペレーションに使用されます。この役割を必要とするオペレーションでは、注文出荷に必要なPIIを使用しません。むしろ、在庫/製造/購入を管理するために注文出荷を追跡するアプリケーションにこの役割は必要です。
この役割の割り当てを必要とするオペレーションの例を次に示します。
<ul>
<li>レポート向け出品パートナーAPIの<strong>createReport</strong>オペレーション。<strong>GET_MERCHANT_LISTINGS_DATA</strong>レポートのリクエストに使用されます。このレポートは出品中の出品詳細を返します。</li>
<li>フィード向け出品パートナーAPIの<strong>createFeed</strong>オペレーション。<strong>POST_FLAT_FILE_FULFILLMENT_DATA</strong>フィードの送信に使用されます。これにより、注文フルフィルメント情報をAmazonに送信できます。</li>
<li>出品パートナーAPIの<strong>GetOrderMetrics</strong>オペレーション。集計された注文指標を返します。</li>
</ul></td>
</tr>
<tr class="even">
<td><strong>Amazonから発送</strong></td>
<td>Amazonに発送し、Amazonが購入者に直接出荷します（フルフィルメントby Amazon（FBA）、Amazonフルフィルメントネットワーク（AFN））。
通常、FBA売上レポート、注文トラッキングレポート、および注文の出荷に関連するオペレーションに使用されます。
この役割の割り当てを必要とするオペレーションの例を次に示します。
<ul>
<li>レポート向け出品パートナーAPIの<strong>createReport</strong>オペレーション。<strong>GET_FBA_ESTIMATED_FBA_FEES_TXT_DATA</strong>レポートのリクエストに使用されます。このレポートには、Amazonの出品手数料およびFBA手数料の見積もりが含まれています。</li>
<li>通知向け出品パートナーAPIの<strong>getSubscription</strong>オペレーション。<strong>FBA_OUTBOUND_SHIPMENT_STATUS</strong>通知の登録に使用されます。これらの通知は、出品者のFBA出荷を作成またはキャンセルするたびに送信されます。</li>
<li>フルフィルメント納品向け出品パートナーAPIの<strong>getLabels</strong>オペレーション。パッケージ/パレットのラベルを返します。</li>
<li>フィード向け出品パートナーAPIの<strong>createFeed</strong>オペレーション。<strong>POST_FBA_INBOUND_CARTON_CONTENTS</strong>フィードの送信に使用されます。これにより、Amazonフルフィルメントネットワークに在庫を発送する際にカートン内容の情報を送信できます。</li>
</ul></td>
</tr>
<tr class="odd">
<td><strong>購入者とのコミュニケーション</strong></td>
<td>Amazonの購入者との間のメッセージングを管理します。
通常、メッセージング向け出品パートナーAPIを使用してAmazonの購入者とのメッセージングに使用されます。
この役割の割り当てを必要とするオペレーションの例を次に示します。
<ul>
<li>メッセージング向け出品パートナーAPIの<strong>getMessagingActionsForOrder</strong>オペレーション。指定された注文に使用可能なメッセージタイプのリストを返します。</li>
<li>メッセージング向け出品パートナーAPIの<strong>createConfirmOrderDetails</strong>オペレーション。出荷前にメッセージを送信して、注文に関して購入者に質問します。</li>
<li>メッセージング向け出品パートナーAPIの<strong>createConfirmDeliveryDetails</strong>オペレーション。配送を手配するため、または配送用の連絡先情報を確認するために購入者にメッセージを送信します。</li>
</ul></td>
</tr>
<tr class="even">
<td><strong>購入者への要請</strong></td>
<td>Amazonの購入者にフィードバックを要請します。
通常、要請向け出品パートナーAPIを使用して、Amazonの購入者にフィードバックを要請するために使用されます。
この役割の割り当てを必要とするオペレーションの例を次に示します。
<ul>
<li>要請向け出品パートナーAPIの<strong>getSolicitationActionsForOrder</strong>オペレーション。注文に使用可能な要請タイプのリストを返します。</li>
<li><strong>createProductReviewAndSellerFeedbackSolicitation</strong>オペレーション。注文に関するフィードバックと商品レビューを依頼する要請を購入者に送信します。</li>
</ul></td>
</tr>
<tr class="odd">
<td><strong>財務・会計</strong></td>
<td>会計および財務諸表を作成します。
通常、会計および財務諸表の作成に使用されます。
この役割の割り当てを必要とするオペレーションの例を次に示します。
<ul>
<li>レポート向け出品パートナーAPIの<strong>getReports</strong>オペレーション。作成済み<strong>GET_V2_SETTLEMENT_REPORT_DATA_FLAT_FILE</strong>レポートのリストを返すために使用されます。</li>
<li>通知向け出品パートナーAPIの<strong>getSubscription</strong>オペレーション。<strong>FEE_PROMOTION</strong>通知タイプの登録に関する情報を返すために使用されます。</li>
</ul></td>
</tr>
<tr class="even">
<td><strong>出品パートナーインサイト</strong></td>
<td>Amazon出品パートナーのアカウントとパフォーマンスに関する情報を表示します。
通常、出品者のインサイトを返すためのレポートやオペレーションに使用されます。
この役割の割り当てを必要とするオペレーションの例を次に示します。
<ul>
<li>レポート向け出品パートナーAPIの<strong>createReport</strong>オペレーション。<strong>GET_V1_SELLER_PERFORMANCE_REPORT</strong>レポートのリクエストに使用されます。このレポートには、セラーセントラルのダッシュボードの各パフォーマンス指標が記載されています。</li>
<li>出品者向け出品パートナーAPIの<strong>GetMarketplaceParticipations</strong>オペレーション。出品者が販売できるマーケットプレイスのリストと、それらのマーケットプレイスへの出品者の参加に関する情報を返します。</li>
</ul></td>
</tr>
<tr class="odd">
<td><strong>購入者への直送</strong>（<em>制限あり</em>）</td>
<td>Amazonを含む、選択した配送業者を使用して購入者に直接注文を出荷します。この役割を必要とするオペレーションでは、出荷を有効にするためにPIIを使用します。
通常、注文レポート、注文トラッキングレポート、EasyShip、およびAmazonでの注文の出荷に関連するオペレーションに使用されます。
この役割の割り当てを必要とするオペレーションの例を次に示します。
<ul>
<li>出品者出荷向け出品パートナーAPIの<strong>getShipment</strong>オペレーション。指定された出荷に関する出荷情報を返します。</li>
<li>注文向け出品パートナーAPIの<strong>getOrders</strong>オペレーション。指定された条件に基づいて注文のリストと注文情報を返します。</li>
<li>レポート向け出品パートナーAPIの<strong>createReport</strong>オペレーション。<strong>GET_FLAT_FILE_ ORDER_REPORT_DATA_SHIPPING</strong>レポートのリクエストに使用されます。</li>
<li>フィード向け出品パートナーAPIの<strong>createFeed</strong>オペレーション。<strong>POST_ORDER_FULFILLMENT_DATA</strong>フィードの送信に使用されます。このフィードを使用すると、Amazonのシステムで注文出荷情報を更新できます。</li>
</ul></td>
</tr>
<tr class="even">
<td><strong>税金請求</strong>（<em>制限あり</em>）</td>
<td>税法に準拠した税金の請求書を作成します。この役割を必要とするオペレーションでは、税金の請求書を作成するためにPIIが必要です。
通常、税金レポート、注文レポート、および注文に関する情報を返すオペレーションに使用されます。
この役割の割り当てを必要とするオペレーションの例を次に示します。
<ul>
<li>レポート向け出品パートナーAPIの<strong>createReport</strong>オペレーション。<strong>GET_AMAZON_FULFILLED_SHIPMENTS_INVOICING</strong>レポートのリクエストに使用されます。このレポートは、注文/出荷/商品の詳細情報を返します。</li>
<li>注文向け出品パートナーAPIの<strong>getOrderAddress</strong>オペレーション。注文の配送先住所を返します。</li>
<li>注文向け出品パートナーAPIの<strong>getOrderBuyerInfo</strong>オペレーション。注文の購入者情報を返します。</li>
<li>レポート向け出品パートナーAPIの<strong>createReport</strong>オペレーション。<strong>GET_EASYSHIP_DOCUMENTS</strong>レポートのリクエストに使用されます。このレポートには、Easy Ship注文の請求書、配送ラベル、保証書が含まれます。</li>
</ul></td>
</tr>
<tr class="odd">
<td><strong>税金送金</strong>（<em>制限あり</em>）</td>
<td>売上税を計算し、送金します。この役割を必要とするオペレーションでは、売上税の計算にPIIを使用する場合があります。
通常、FBA売上レポート、注文レポート、および注文に関する情報を返すオペレーションに使用されます。
この役割の割り当てを必要とするオペレーションの例を次に示します。
<ul>
<li>レポート向け出品パートナーAPIの<strong>createReport</strong>オペレーション。<strong>GET_AMAZON_FULFILLED_SHIPMENTS_REMITTANCE</strong>レポートのリクエストに使用されます。このレポートは、注文/出荷/商品の詳細情報を返します。</li>
<li>注文向け出品パートナーAPIの<strong>getOrderItems</strong>オペレーション。注文の詳細な注文商品情報を返します。</li>
<li>注文向け出品パートナーAPIの<strong>getOrders</strong>オペレーション。期間と条件の範囲に関する注文商品情報のリストを返します。</li>
</ul></td>
</tr>
</tbody>
</table>

# よくあるご質問

## 役割をリクエストして取得するにはどうすればよいですか？

出品パートナーAPIの役割をリクエストし、取得するには、開発者プロフィールに入力します（利用可能な場合）。すでにAmazonマーケットプレイスWebサービス（MWS）の開発者であるかどうか、および登録済みかどうかによって、要求される情報が異なります。

プロフィールの送信後に、Amazonは提供された情報を評価し、リクエストを承認または却下します。却下された場合は、却下理由に対処し、プロフィールを再送信できます。

## アプリケーションの役割を選択するにはどうすればよいですか？

アプリケーションクライアント作成のページで出品パートナーAPIアプリケーションを作成する場合、開発者プロフィールで、リクエスト済み、承認済みの役割の中から役割を選択できます。必要な役割がない場合は、開発者プロフィールで役割を追加して更新し、プロフィールを再送信してAmazonの評価を依頼する必要があります。承認後に、追加された役割をアプリケーションに対して選択できます。

## どの役割をリクエストするかを決定するにはどうすればよいですか？

このドキュメントに記載された役割の説明を確認して、各役割の目的を理解し、各役割の対象となるリソースとオペレーションの例を参照してください。

## 必要となる役割を持っていない場合にオペレーションを呼び出すとどうなりますか？

リクエストに対する応答で、応答の本文にHTTPステータスコード403とエラー情報が記載されます。
