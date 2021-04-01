# 销售伙伴 API 中的职权

# 概述

## 什么是职权？

职权是销售伙伴 API 用于确定开发者或应用程序是否有权访问操作或资源的一种机制。如果是开发者，您必须请求特定职权并获取相应资格，否则您将无法访问该职权下分组的操作和资源。职权可以保护对个人身份信息 (PII) 和其他敏感数据的访问，还能限制数据访问，确保开发者仅访问应用程序所需的数据。这有助于确保买家信任亚马逊以及那些采用销售伙伴 API 的销售伙伴服务企业。

# 职权定义

在下表中，*受限*是指职权需要可能包含个人身份信息 (PII) 的敏感信息。在这种情况下，您需要提供有关数据使用情况和安全控制的更多信息。

每个职权描述中提供的操作示例仅用作举例，并不是确切无疑或详尽的清单。

<table>
<thead>
<tr class="header">
<th><strong>职权</strong></th>
<th><strong>描述</strong></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td><strong>商品信息</strong></td>
<td>创建和管理商品信息。
通常用于和商品目录相关的报告、上传数据和操作。
需要分配此职权的操作示例：
<ul>
<li>销售伙伴 API 中涉及目录商品的 <strong>getCatalogItem</strong> 操作，此操作可返回有关指定商品及其属性的信息。</li>
<li>销售伙伴 API 中涉及报告的 <strong>createReport</strong> 操作，此操作用于请求 <strong>GET_MERCHANT_LISTINGS_INACTIVE_DATA</strong> report 报告。此报告返回详细的非在售商品信息。</li>
<li>销售伙伴 API 中涉及商品费用的 <strong>getMyFeesEstimateForSKU</strong> 操作，此操作可返回指定商品的预计费用。</li>
</ul></td>
</tr>
<tr class="even">
<td><strong>定价</strong></td>
<td>确定市场价并自动确定商品价格。
通常用于和定价相关的报告、上传数据和操作。
需要分配此职权的操作示例：
<ul>
<li>销售伙伴 API 中涉及上传数据的 <strong>createFeed</strong> 操作，此操作用于提交 <strong>RFQ_UPLOAD_FEED</strong> 上传数据。这样，您就可以根据企业客户的请求上传数量折扣。</li>
<li>销售伙伴 API 中涉及定价的 <strong>getPricing</strong> 操作，此操作可返回卖家商品的定价信息。</li>
<li>销售伙伴 API 中涉及报告的 <strong>createReport</strong> 操作，此操作用于请求 <strong>GET_MERCHANT_CANCELLED_LISTINGS_DATA</strong> 报告。此报告返回已取消的商品信息。</li>
</ul></td>
</tr>
<tr class="odd">
<td><strong>库存和订单管理</strong></td>
<td>分析和管理库存。
通常用于亚马逊物流销售报告、订单追踪报告以及与订单、供应商订单、销售订单指标和库存管理相关的操作。需要此职权的操作不使用配送订单所需的 PII。而追踪订单配送以管理库存/制造/采购的应用程序需要此职权。
需要分配此职权的操作示例：
<ul>
<li>销售伙伴 API 中涉及报告的 <strong>createReport</strong> 操作，此操作用于请求 <strong>GET_MERCHANT_LISTINGS_DATA</strong> 报告。此报告返回详细的在售商品信息。</li>
<li>销售伙伴 API 中涉及上传数据的 <strong>createFeed</strong> 操作，此操作用于提交 <strong>POST_FLAT_FILE_FULFILLMENT_DATA</strong> 上传数据。这样，您就可以向亚马逊提交订单配送信息。</li>
<li>销售伙伴 API 中涉及销售的 <strong>getOrderMetrics</strong> 操作，此操作可返回汇总订单指标。</li>
</ul></td>
</tr>
<tr class="even">
<td><strong>亚马逊物流</strong></td>
<td>商品配送至亚马逊，然后由亚马逊直接将商品配送给买家（亚马逊物流 (Fulfillment by Amazon, FBA)、亚马逊物流 (Amazon Fulfillment Network, AFN)）。
通常用于亚马逊物流销售报告、订单追踪报告以及与订单配送相关的操作。
需要分配此职权的操作示例：
<ul>
<li>销售伙伴 API 中涉及报告的 <strong>createReport</strong> 操作，此操作用于请求 <strong>GET_FBA_ESTIMATED_FBA_FEES_TXT_DATA</strong> 报告。此报告包含预计的亚马逊销售和配送费用。</li>
<li>销售伙伴 API 中涉及通知的 <strong>getSubscription</strong> 操作，此操作用于订阅 <strong>FBA_OUTBOUND_SHIPMENT_STATUS</strong> 通知。每当我们为卖家创建或取消亚马逊物流货件时，都会发送这些通知。</li>
<li>销售伙伴 API 中涉及亚马逊物流入库货件的 <strong>getLabels</strong> 操作，此操作可返回包裹/托拍标签。</li>
<li>销售伙伴 API 中涉及上传数据的 <strong>createFeed</strong> 操作，此操作用于提交 <strong>POST_FBA_INBOUND_CARTON_CONTENTS</strong> 上传数据。这样，您就可以在将库存配送至亚马逊物流时提交纸箱内物品的相关信息。</li>
</ul></td>
</tr>
<tr class="odd">
<td><strong>买家沟通</strong></td>
<td>管理与亚马逊买家之间往来的消息。
通常用于使用销售伙伴 API 的消息服务向亚马逊买家发送消息。
需要分配此职权的操作示例：
<ul>
<li>销售伙伴 API 中涉及消息服务的 <strong>getMessagingActionsForOrder</strong> 操作，此操作可返回指定订单适用的消息类型列表。</li>
<li>销售伙伴 API 中涉及消息服务的 <strong>createConfirmOrderDetails</strong> 操作，此操作会在商品配送前向买家发送说明订单相关问题的消息。</li>
<li>销售伙伴 API 中涉及消息服务的 <strong>createConfirmDeliveryDetails</strong> 操作，此操作会向买家发送有关安排配送事宜或确认配送联系信息的消息。</li>
</ul></td>
</tr>
<tr class="even">
<td><strong>买家反馈征求</strong></td>
<td>征求亚马逊买家的反馈。
通常用于使用销售伙伴 API 的征求服务征求亚马逊买家的反馈。
需要分配此职权的操作示例：
<ul>
<li>销售伙伴 API 中涉及征求服务的 <strong>getSolicitationActionsForOrder</strong> 操作，此操作可返回适合订单的征求类型列表。</li>
<li><strong>createProductReviewAndSellerFeedbackSolicitation</strong> 操作，此操作向买家发送邀请对方提供订单反馈和商品评论的请求。</li>
</ul></td>
</tr>
<tr class="odd">
<td><strong>财务与会计核算</strong></td>
<td>编制会计核算与财务报表。
通常用于编制会计核算与财务报表。
需要分配此职权的操作示例：
<ul>
<li>销售伙伴 API 中涉及报告的 <strong>getReports</strong> 操作，此操作用于返回已创建 <strong>GET_V2_SETTLEMENT_REPORT_DATA_FLAT_FILE</strong> 报告的列表。</li>
<li>销售伙伴 API 的 <strong>getSubscription</strong> 操作，此操作用于返回有关订阅 <strong>FEE_PROMOTION</strong> 通知类型的信息。</li>
</ul></td>
</tr>
<tr class="even">
<td><strong>销售伙伴见解</strong></td>
<td>查看有关亚马逊销售伙伴帐户和绩效的信息。
通常用于可返回卖家见解的报告和操作。
需要分配此职权的操作示例：
<ul>
<li>销售伙伴 API 中涉及报告的 <strong>createReport</strong> 操作，此操作用于请求 <strong>GET_V1_SELLER_PERFORMANCE_REPORT</strong> 报告。此报告包含卖家平台控制面板中的各个绩效指标。</li>
<li>销售伙伴 API 中涉及卖家的<strong>getMarketplaceParticipations</strong> 操作，此操作可返回卖家可以销售商品的商城列表以及关于卖家加入这些商城的信息。</li>
</ul></td>
</tr>
<tr class="odd">
<td><strong>直接配送至买家</strong>（<em>受限</em>）</td>
<td>使用买家选择的承运人（包括亚马逊）直接将订单配送给买家。需要此职权的操作需使用 PII 才能启用配送。
通常用于订单报告、订单追踪报告、EasyShip 以及与配送亚马逊订单相关的操作。
需要分配此职权的操作示例：
<ul>
<li>销售伙伴 API 中涉及卖家配送的 <strong>getShipment</strong> 操作，此操作可返回指定货件的配送信息。</li>
<li>销售伙伴 API 中涉及订单的 <strong>getOrders</strong> 操作，此操作可根据指定的标准返回订单列表和订单资讯。</li>
<li>销售伙伴 API 中涉及报告的 <strong>createReport</strong> 操作，此操作用于请求 <strong>GET_FLAT_FILE_ ORDER_REPORT_DATA_SHIPPING</strong> 报告。</li>
<li>销售伙伴 API 中涉及上传数据的 <strong>createFeed</strong> 操作，此操作用于提交 <strong>POST_ORDER_FULFILLMENT_DATA</strong> 上传数据。通过这些上传数据，您的系统可以使用订单配送信息更新亚马逊系统。</li>
</ul></td>
</tr>
<tr class="even">
<td><strong>税务发票</strong>（<em>受限</em>）</td>
<td>生成税务发票以遵守税务法规。需要此职权的操作需 PII 才能启用税务发票生成。
通常用于税务报告、订单报告以及可返回订单相关信息的操作。
需要分配此职权的操作示例：
<ul>
<li>销售伙伴 API 中涉及报告的 <strong>createReport</strong> 操作，用于请求 <strong>GET_AMAZON_FULFILLED_SHIPMENTS_INVOICING</strong> 报告。此报告可返回详细的订单/配送/商品信息。</li>
<li>销售伙伴 API 中涉及订单 <strong>getOrderAddress</strong> 操作，此操作可返回订单的配送地址。</li>
<li>销售伙伴 API 中涉及订单 <strong>getOrderBuyerInfo</strong> 操作，该操作可返回订单的买家信息。</li>
<li>销售伙伴 API 中涉及报告的 <strong>createReport</strong> 操作，用于请求 <strong>GET_EASYSHIP_DOCUMENTS</strong> 报告。此报告包含 Easy Ship 订单的发票、货件标签和保修文件。</li>
</ul></td>
</tr>
<tr class="odd">
<td><strong>缴税</strong>（<em>受限</em>）</td>
<td>计算和缴纳销售税。需要此职权的操作可能会使用 PII 计算销售税。
通常用于亚马逊物流销售报告、订单报告以及可返回订单相关信息的操作。
需要分配此职权的操作示例：
<ul>
<li>销售伙伴 API 中涉及报告的 <strong>createReport</strong> 操作，用于请求 <strong>GET_AMAZON_FULFILLED_SHIPMENTS_REMITTANCE</strong> 报告。此报告可返回详细的订单/配送/商品信息。</li>
<li>销售伙伴 API 中涉及订单 <strong>getOrderItems</strong> 操作，此操作可返回订单的详细订单商品信息。</li>
<li>销售伙伴 API 中涉及订单的 <strong>getOrders</strong> 操作，该操作可返回一定时间范围和标准范围内的订单商品信息。</li>
</ul></td>
</tr>
</tbody>
</table>

# 常见问题

## 如何请求某职权并获取相应资格？

要请求销售伙伴 API 职权并获取相应资格，您需要填写开发者资料（如果可用）。请求的具体信息取决于您是否已成为亚马逊商城网络服务 (MWS) 开发者，以及您之前是否已注册过 MWS 开发者。

您提交个人资料后，亚马逊将评估您提供的信息，并批准或拒绝您的请求。如果您的请求被拒绝，您可以针对拒绝原因进行相应处理，然后重新提交您的个人资料。

## 如何为我的应用程序选择职权？

当您在应用程序客户端创建页面上创建销售伙伴 API 应用程序时，您可以从您的开发者资料中请求和批准的职权中进行选择。如果没有您所需的职权，您必须更新开发者资料中的职权以包含您所需的职权，然后将您的个人资料重新提交给亚马逊评估。一旦您的请求获批，您就可以为应用程序选择添加的职权。

## 如何确定要请求的职权？

查看本文档中的职权描述以了解每个职权的用途，并参考每个职权对应的资源和操作示例。

## 如果我在没有所需职权的情况下调用操作，会发生什么情况？

对此类请求响应后，响应正文中会出现 403 HTTP 状态代码和错误信息。
