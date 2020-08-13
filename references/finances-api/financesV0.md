# Selling Partner API for Finances


<a name="overview"></a>
## Overview
The Selling Partner API for Finances helps you obtain financial information relevant to a seller's business. You can obtain financial events for a given order, financial event group, or date range without having to wait until a statement period closes. You can also obtain financial event groups for a given date range.


### Version information
*Version* : v0


### Contact information
*Contact* : Selling Partner API Developer Support  
*Contact URL* : https://sellercentral.amazon.com/gp/mws/contactus.html  


### License information
*License* : Apache License 2.0  
*License URL* : http://www.apache.org/licenses/LICENSE-2.0  


### URI scheme
*Host* : sellingpartnerapi-na.amazon.com  
*Schemes* : HTTPS


### Consumes

* `application/json`


### Produces

* `application/json`


### Operations
[listFinancialEventGroups](#listfinancialeventgroups)<br>[listFinancialEventsByGroupId](#listfinancialeventsbygroupid)<br>[listFinancialEventsByOrderId](#listfinancialeventsbyorderid)<br>[listFinancialEvents](#listfinancialevents)<br>
<a name="paths"></a>
## Paths

<a name="listfinancialeventgroups"></a>
### GET /finances/v0/financialEventGroups
**Operation: listFinancialEventGroups**

#### Description
Returns financial event groups for a given date range.

**Usage Plan:**

| Rate (requests per second) | Burst |
| ---- | ---- |
| 0.5 | 30 |

For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|Default|
|---|---|---|---|---|
|**Query**|**MaxResultsPerPage**  <br>*optional*|The maximum number of results to return per page.<br>**Minimum** : 1<br>**Maximum** : 100|integer (int32)|`100`|
|**Query**|**FinancialEventGroupStartedBefore**  <br>*optional*|A date used for selecting financial event groups that opened before (but not at) a specified date and time, in ISO 8601 format. The date-time  must be later than FinancialEventGroupStartedAfter and no later than two minutes before the request was submitted. If FinancialEventGroupStartedAfter and FinancialEventGroupStartedBefore are more than 180 days apart, no financial event groups are returned.|string (date-time)|-|
|**Query**|**FinancialEventGroupStartedAfter**  <br>*optional*|A date used for selecting financial event groups that opened after (or at) a specified date and time, in ISO 8601 format. The date-time must be no later than two minutes before the request was submitted.|string (date-time)|-|
|**Query**|**NextToken**  <br>*optional*|A string token returned in the response of your previous request.|string|-|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Success.|[ListFinancialEventGroupsResponse](#listfinancialeventgroupsresponse)|
|**400**|Request has missing or invalid parameters and cannot be parsed.|[ListFinancialEventGroupsResponse](#listfinancialeventgroupsresponse)|
|**403**|Indicates that access to the resource is forbidden. Possible reasons include Access Denied, Unauthorized, Expired Token, or Invalid Signature.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[ListFinancialEventGroupsResponse](#listfinancialeventgroupsresponse)|
|**404**|The resource specified does not exist.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[ListFinancialEventGroupsResponse](#listfinancialeventgroupsresponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[ListFinancialEventGroupsResponse](#listfinancialeventgroupsresponse)|
|**500**|An unexpected condition occurred that prevented the server from fulfilling the request.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[ListFinancialEventGroupsResponse](#listfinancialeventgroupsresponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[ListFinancialEventGroupsResponse](#listfinancialeventgroupsresponse)|


<a name="listfinancialeventsbygroupid"></a>
### GET /finances/v0/financialEventGroups/{eventGroupId}/financialEvents
**Operation: listFinancialEventsByGroupId**

#### Description
Returns all financial events for the specified financial event group.

**Usage Plan:**

| Rate (requests per second) | Burst |
| ---- | ---- |
| 0.5 | 30 |

For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|Default|
|---|---|---|---|---|
|**Query**|**MaxResultsPerPage**  <br>*optional*|The maximum number of results to return per page.<br>**Minimum** : 1<br>**Maximum** : 100|integer (int32)|`100`|
|**Path**|**eventGroupId**  <br>*required*|The identifier of the financial event group to which the events belong.|string|-|
|**Query**|**NextToken**  <br>*optional*|A string token returned in the response of your previous request.|string|-|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Success.|[ListFinancialEventsResponse](#listfinancialeventsresponse)|
|**400**|Request has missing or invalid parameters and cannot be parsed.|[ListFinancialEventsResponse](#listfinancialeventsresponse)|
|**403**|Indicates that access to the resource is forbidden. Possible reasons include Access Denied, Unauthorized, Expired Token, or Invalid Signature.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[ListFinancialEventsResponse](#listfinancialeventsresponse)|
|**404**|The resource specified does not exist.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[ListFinancialEventsResponse](#listfinancialeventsresponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[ListFinancialEventsResponse](#listfinancialeventsresponse)|
|**500**|An unexpected condition occurred that prevented the server from fulfilling the request.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[ListFinancialEventsResponse](#listfinancialeventsresponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[ListFinancialEventsResponse](#listfinancialeventsresponse)|


<a name="listfinancialeventsbyorderid"></a>
### GET /finances/v0/orders/{orderId}/financialEvents
**Operation: listFinancialEventsByOrderId**

#### Description
Returns all financial events for the specified order.

**Usage Plan:**

| Rate (requests per second) | Burst |
| ---- | ---- |
| 0.5 | 30 |

For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|Default|
|---|---|---|---|---|
|**Path**|**orderId**  <br>*required*|An Amazon-defined order identifier, in 3-7-7 format.|string|-|
|**Query**|**MaxResultsPerPage**  <br>*optional*|The maximum number of results to return per page.<br>**Minimum** : 1<br>**Maximum** : 100|integer (int32)|`100`|
|**Query**|**NextToken**  <br>*optional*|A string token returned in the response of your previous request.|string|-|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Financial Events successfully retrieved.|[ListFinancialEventsResponse](#listfinancialeventsresponse)|
|**400**|Request has missing or invalid parameters and cannot be parsed.|[ListFinancialEventsResponse](#listfinancialeventsresponse)|
|**403**|Indicates that access to the resource is forbidden. Possible reasons include Access Denied, Unauthorized, Expired Token, or Invalid Signature.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[ListFinancialEventsResponse](#listfinancialeventsresponse)|
|**404**|The resource specified does not exist.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[ListFinancialEventsResponse](#listfinancialeventsresponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[ListFinancialEventsResponse](#listfinancialeventsresponse)|
|**500**|An unexpected condition occurred that prevented the server from fulfilling the request.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[ListFinancialEventsResponse](#listfinancialeventsresponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[ListFinancialEventsResponse](#listfinancialeventsresponse)|


<a name="listfinancialevents"></a>
### GET /finances/v0/financialEvents
**Operation: listFinancialEvents**

#### Description
Returns financial events for the specified data range.

**Usage Plan:**

| Rate (requests per second) | Burst |
| ---- | ---- |
| 0.5 | 30 |

For more information, see "Usage Plans and Rate Limits" in the Selling Partner API documentation.


#### Parameters

|Type|Name|Description|Schema|Default|
|---|---|---|---|---|
|**Query**|**MaxResultsPerPage**  <br>*optional*|The maximum number of results to return per page.<br>**Minimum** : 1<br>**Maximum** : 100|integer (int32)|`100`|
|**Query**|**PostedAfter**  <br>*optional*|A date used for selecting financial events posted after (or at) a specified time. The date-time must be no later than two minutes before the request was submitted, in ISO 8601 date time format.|string (date-time)|-|
|**Query**|**PostedBefore**  <br>*optional*|A date used for selecting financial events posted before (but not at) a specified time. The date-time must be later than PostedAfter and no later than two minutes before the request was submitted, in ISO 8601 date time format. If PostedAfter and PostedBefore are more than 180 days apart, no financial events are returned. You must specify the PostedAfter parameter if you specify the PostedBefore parameter. Default: Now minus two minutes.|string (date-time)|-|
|**Query**|**NextToken**  <br>*optional*|A string token returned in the response of your previous request.|string|-|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Success.|[ListFinancialEventsResponse](#listfinancialeventsresponse)|
|**400**|Request has missing or invalid parameters and cannot be parsed.|[ListFinancialEventsResponse](#listfinancialeventsresponse)|
|**403**|Indicates that access to the resource is forbidden. Possible reasons include Access Denied, Unauthorized, Expired Token, or Invalid Signature.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[ListFinancialEventsResponse](#listfinancialeventsresponse)|
|**404**|The resource specified does not exist.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[ListFinancialEventsResponse](#listfinancialeventsresponse)|
|**429**|The frequency of requests was greater than allowed.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[ListFinancialEventsResponse](#listfinancialeventsresponse)|
|**500**|An unexpected condition occurred that prevented the server from fulfilling the request.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[ListFinancialEventsResponse](#listfinancialeventsresponse)|
|**503**|Temporary overloading or maintenance of the server.  <br>**Headers** :   <br>`x-amzn-RequestId` (string) : Unique request reference identifier.|[ListFinancialEventsResponse](#listfinancialeventsresponse)|


<a name="definitions"></a>
## Definitions

<a name="adjustmentevent"></a>
### AdjustmentEvent
An adjustment to the seller's account.


|Name|Description|Schema|
|---|---|---|
|**AdjustmentType**  <br>*optional*|The type of adjustment.<br><br>Possible values:<br><br><li> FBAInventoryReimbursement - An FBA inventory reimbursement to a seller's account. This occurs if a seller's inventory is damaged.</li><br><li> ReserveEvent - A reserve event that is generated at the time of a settlement period closing. This occurs when some money from a seller's account is held back.</li><br><li> PostageBilling - The amount paid by a seller for shipping labels.</li><br><li> PostageRefund - The reimbursement of shipping labels purchased for orders that were canceled or refunded.</li><br><li> LostOrDamagedReimbursement - An Amazon Easy Ship reimbursement to a seller's account for a package that we lost or damaged.</li><br><li> CanceledButPickedUpReimbursement - An Amazon Easy Ship reimbursement to a seller's account. This occurs when a package is picked up and the order is subsequently canceled. This value is used only in the India marketplace.</li><br><li> ReimbursementClawback - An Amazon Easy Ship reimbursement clawback from a seller's account. This occurs when a prior reimbursement is reversed. This value is used only in the India marketplace.</li><br><li> SellerRewards - An award credited to a seller's account for their participation in an offer in the Seller Rewards program. Applies only to the India marketplace.</li>|string|
|**PostedDate**  <br>*optional*|The date and time when the financial event was posted.|[Date](#date)|
|**AdjustmentAmount**  <br>*optional*|The amount adjusted as part of this event.|[Currency](#currency)|
|**AdjustmentItemList**  <br>*optional*|A list of information about adjustments to an account.|[AdjustmentItemList](#adjustmentitemlist)|


<a name="adjustmenteventlist"></a>
### AdjustmentEventList
A list of adjustment event information for the seller's account.

*Type* : < [AdjustmentEvent](#adjustmentevent) > array


<a name="adjustmentitem"></a>
### AdjustmentItem
An item in an adjustment to the seller's account.


|Name|Description|Schema|
|---|---|---|
|**Quantity**  <br>*optional*|Represents the number of units in the seller's inventory when the AdustmentType is FBAInventoryReimbursement.|string|
|**PerUnitAmount**  <br>*optional*|The per unit value of the item.|[Currency](#currency)|
|**TotalAmount**  <br>*optional*|The total value of the item.|[Currency](#currency)|
|**SellerSKU**  <br>*optional*|The seller SKU of the item. The seller SKU is qualified by the seller's seller ID, which is included with every call to the Selling Partner API.|string|
|**FnSKU**  <br>*optional*|A unique identifier assigned to products stored in and fulfilled from a fulfillment center.|string|
|**ProductDescription**  <br>*optional*|A short description of the item.|string|
|**ASIN**  <br>*optional*|The Amazon Standard Identification Number (ASIN) of the item.|string|


<a name="adjustmentitemlist"></a>
### AdjustmentItemList
A list of information about items in an adjustment to the seller's account.

*Type* : < [AdjustmentItem](#adjustmentitem) > array


<a name="affordabilityexpenseevent"></a>
### AffordabilityExpenseEvent
An expense related to an affordability promotion.


|Name|Description|Schema|
|---|---|---|
|**AmazonOrderId**  <br>*optional*|An Amazon-defined identifier for an order.|string|
|**PostedDate**  <br>*optional*|The date and time when the financial event was created.|[Date](#date)|
|**MarketplaceId**  <br>*optional*|An encrypted, Amazon-defined marketplace identifier.|string|
|**TransactionType**  <br>*optional*|Indicates the type of transaction. <br><br>Possible values:<br><br><li> Charge - For an affordability promotion expense.</li><br><li> Refund - For an affordability promotion expense reversal.</li>|string|
|**BaseExpense**  <br>*optional*|The amount charged for clicks incurred under the Sponsored Products program.|[Currency](#currency)|
|**TaxTypeCGST**  <br>*required*|Central Goods and Service Tax, charged and collected by the central government.|[Currency](#currency)|
|**TaxTypeSGST**  <br>*required*|State Goods and Service Tax, charged and collected by the state government.|[Currency](#currency)|
|**TaxTypeIGST**  <br>*required*|Integrated Goods and Service Tax, charged and collected by the central government.|[Currency](#currency)|
|**TotalExpense**  <br>*optional*|The total amount charged to the seller. TotalExpense = BaseExpense + TaxTypeIGST + TaxTypeCGST + TaxTypeSGST.|[Currency](#currency)|


<a name="affordabilityexpenseeventlist"></a>
### AffordabilityExpenseEventList
A list of expense information related to an affordability promotion.

*Type* : < [AffordabilityExpenseEvent](#affordabilityexpenseevent) > array


<a name="bigdecimal"></a>
### BigDecimal
*Type* : number


<a name="chargecomponent"></a>
### ChargeComponent
A charge on the seller's account.

Possible values:

* Principal - The selling price of the order item, equal to the selling price of the item multiplied by the quantity ordered.

* Tax - The tax collected by the seller on the Principal.

* MarketplaceFacilitatorTax-Principal - The tax withheld on the Principal.

* MarketplaceFacilitatorTax-Shipping - The tax withheld on the ShippingCharge.

* MarketplaceFacilitatorTax-Giftwrap - The tax withheld on the Giftwrap charge.

* MarketplaceFacilitatorTax-Other - The tax withheld on other miscellaneous charges.

* Discount - The promotional discount for an order item.

* TaxDiscount - The tax amount deducted for promotional rebates.

* CODItemCharge - The COD charge for an order item.

* CODItemTaxCharge - The tax collected by the seller on a CODItemCharge.

* CODOrderCharge - The COD charge for an order.

* CODOrderTaxCharge - The tax collected by the seller on a CODOrderCharge.

* CODShippingCharge - Shipping charges for a COD order.

* CODShippingTaxCharge - The tax collected by the seller on a CODShippingCharge.

* ShippingCharge - The shipping charge.

* ShippingTax - The tax collected by the seller on a ShippingCharge.

* Goodwill - The amount given to a buyer as a gesture of goodwill or to compensate for pain and suffering in the buying experience.

* Giftwrap - The gift wrap charge.

* GiftwrapTax - The tax collected by the seller on a Giftwrap charge.

* RestockingFee - The charge applied to the buyer when returning a product in certain categories.

* ReturnShipping - The amount given to the buyer to compensate for shipping the item back in the event we are at fault.

* PointsFee - The value of Amazon Points deducted from the refund if the buyer does not have enough Amazon Points to cover the deduction.

* GenericDeduction - A generic bad debt deduction.

* FreeReplacementReturnShipping - The compensation for return shipping when a buyer receives the wrong item, requests a free replacement, and returns the incorrect item.

* PaymentMethodFee - The fee collected for certain payment methods in certain marketplaces.

* ExportCharge - The export duty that is charged when an item is shipped to an international destination as part of the Amazon Global program.

* SAFE-TReimbursement - The SAFE-T claim amount for the item.

* TCS-CGST - Tax Collected at Source (TCS) for Central Goods and Services Tax (CGST).

* TCS-SGST - Tax Collected at Source for State Goods and Services Tax (SGST).

* TCS-IGST - Tax Collected at Source for Integrated Goods and Services Tax (IGST).

* TCS-UTGST - Tax Collected at Source for Union Territories Goods and Services Tax (UTGST).


|Name|Description|Schema|
|---|---|---|
|**ChargeType**  <br>*optional*|The type of charge.|string|
|**ChargeAmount**  <br>*optional*|The amount of the charge.|[Currency](#currency)|


<a name="chargecomponentlist"></a>
### ChargeComponentList
A list of charge information on the seller's account.

*Type* : < [ChargeComponent](#chargecomponent) > array


<a name="chargeinstrument"></a>
### ChargeInstrument
A payment instrument.


|Name|Description|Schema|
|---|---|---|
|**Description**  <br>*optional*|A short description of the charge instrument.|string|
|**Tail**  <br>*optional*|The account tail (trailing digits) of the charge instrument.|string|
|**Amount**  <br>*optional*|The amount charged to this charge instrument.|[Currency](#currency)|


<a name="chargeinstrumentlist"></a>
### ChargeInstrumentList
A list of payment instruments.

*Type* : < [ChargeInstrument](#chargeinstrument) > array


<a name="couponpaymentevent"></a>
### CouponPaymentEvent
An event related to coupon payments.


|Name|Description|Schema|
|---|---|---|
|**PostedDate**  <br>*optional*|The date and time when the financial event was posted.|[Date](#date)|
|**CouponId**  <br>*optional*|A coupon identifier.|string|
|**SellerCouponDescription**  <br>*optional*|The description provided by the seller when they created the coupon.|string|
|**ClipOrRedemptionCount**  <br>*optional*|The number of coupon clips or redemptions.|integer (int64)|
|**PaymentEventId**  <br>*optional*|A payment event identifier.|string|
|**FeeComponent**  <br>*optional*|A fee associated with the event.|[FeeComponent](#feecomponent)|
|**ChargeComponent**  <br>*optional*|A charge on the seller's account.<br><br>Possible values:<br><br><li> Principal - The selling price of the order item, equal to the selling price of the item multiplied by the quantity ordered.</li><br><li> Tax - The tax collected by the seller on the Principal.</li><br><li> MarketplaceFacilitatorTax-Principal - The tax withheld on the Principal.</li><br><li> MarketplaceFacilitatorTax-Shipping - The tax withheld on the ShippingCharge.</li><br><li> MarketplaceFacilitatorTax-Giftwrap - The tax withheld on the Giftwrap charge.</li><br><li> MarketplaceFacilitatorTax-Other - The tax withheld on other miscellaneous charges.</li><br><li> Discount - The promotional discount for an order item.</li><br><li> TaxDiscount - The tax amount deducted for promotional rebates.</li><br><li> CODItemCharge - The COD charge for an order item.</li><br><li> CODItemTaxCharge - The tax collected by the seller on a CODItemCharge.</li><br><li> CODOrderCharge - The COD charge for an order.</li><br><li> CODOrderTaxCharge - The tax collected by the seller on a CODOrderCharge.</li><br><li> CODShippingCharge - Shipping charges for a COD order.</li><br><li> CODShippingTaxCharge - The tax collected by the seller on a CODShippingCharge.</li><br><li> ShippingCharge - The shipping charge.</li><br><li> ShippingTax - The tax collected by the seller on a ShippingCharge.</li><br><li> Goodwill - The amount given to a buyer as a gesture of goodwill or to compensate for pain and suffering in the buying experience.</li><br><li> Giftwrap - The gift wrap charge.</li><br><li> GiftwrapTax - The tax collected by the seller on a Giftwrap charge.</li><br><li> RestockingFee - The charge applied to the buyer when returning a product in certain categories.</li><br><li> ReturnShipping - The amount given to the buyer to compensate for shipping the item back in the event we are at fault.</li><br><li> PointsFee - The value of Amazon Points deducted from the refund if the buyer does not have enough Amazon Points to cover the deduction.</li><br><li> GenericDeduction - A generic bad debt deduction.</li><br><li> FreeReplacementReturnShipping - The compensation for return shipping when a buyer receives the wrong item, requests a free replacement, and returns the incorrect item.</li><br><li> PaymentMethodFee - The fee collected for certain payment methods in certain marketplaces.</li><br><li> ExportCharge - The export duty that is charged when an item is shipped to an international destination as part of the Amazon Global program.</li><br><li> SAFE-TReimbursement - The SAFE-T claim amount for the item.</li><br><li> TCS-CGST - Tax Collected at Source (TCS) for Central Goods and Services Tax (CGST).</li><br><li> TCS-SGST - Tax Collected at Source for State Goods and Services Tax (SGST).</li><br><li> TCS-IGST - Tax Collected at Source for Integrated Goods and Services Tax (IGST).</li><br><li> TCS-UTGST - Tax Collected at Source for Union Territories Goods and Services Tax (UTGST).</li>|[ChargeComponent](#chargecomponent)|
|**TotalAmount**  <br>*optional*|The FeeComponent value plus the ChargeComponent value.|[Currency](#currency)|


<a name="couponpaymenteventlist"></a>
### CouponPaymentEventList
A list of coupon payment event information.

*Type* : < [CouponPaymentEvent](#couponpaymentevent) > array


<a name="currency"></a>
### Currency
A currency type and amount.


|Name|Description|Schema|
|---|---|---|
|**CurrencyCode**  <br>*optional*|The three-digit currency code in ISO 4217 format.|string|
|**CurrencyAmount**  <br>*optional*|The monetary value.|[BigDecimal](#bigdecimal)|


<a name="date"></a>
### Date
*Type* : string (date-time)


<a name="debtrecoveryevent"></a>
### DebtRecoveryEvent
A debt payment or debt adjustment.


|Name|Description|Schema|
|---|---|---|
|**DebtRecoveryType**  <br>*optional*|The debt recovery type.<br><br>Possible values:<br><br><li> DebtPayment</li><br><li> DebtPaymentFailure</li><br><li>DebtAdjustment</li>|string|
|**RecoveryAmount**  <br>*optional*|The amount applied for recovery.|[Currency](#currency)|
|**OverPaymentCredit**  <br>*optional*|The amount returned for overpayment.|[Currency](#currency)|
|**DebtRecoveryItemList**  <br>*optional*|A list of debt recovery item information.|[DebtRecoveryItemList](#debtrecoveryitemlist)|
|**ChargeInstrumentList**  <br>*optional*|A list of payment instruments.|[ChargeInstrumentList](#chargeinstrumentlist)|


<a name="debtrecoveryeventlist"></a>
### DebtRecoveryEventList
A list of debt recovery event information.

*Type* : < [DebtRecoveryEvent](#debtrecoveryevent) > array


<a name="debtrecoveryitem"></a>
### DebtRecoveryItem
An item of a debt payment or debt adjustment.


|Name|Description|Schema|
|---|---|---|
|**RecoveryAmount**  <br>*optional*|The amount applied for the recovery item.|[Currency](#currency)|
|**OriginalAmount**  <br>*optional*|The original debt amount.|[Currency](#currency)|
|**GroupBeginDate**  <br>*optional*|The beginning date and time of the financial event group that contains the debt. In ISO 8601 date time format.|[Date](#date)|
|**GroupEndDate**  <br>*optional*|The ending date and time of the financial event group that contains the debt. In ISO 8601 date time format.|[Date](#date)|


<a name="debtrecoveryitemlist"></a>
### DebtRecoveryItemList
A list of debt recovery item information.

*Type* : < [DebtRecoveryItem](#debtrecoveryitem) > array


<a name="directpayment"></a>
### DirectPayment
A payment made directly to a seller.


|Name|Description|Schema|
|---|---|---|
|**DirectPaymentType**  <br>*optional*|The type of payment.<br><br>Possible values:<br><br><li> StoredValueCardRevenue - The amount that is deducted from the seller's account because the seller received money through a stored value card.</li><br><li> StoredValueCardRefund - The amount that Amazon returns to the seller if the order that is bought using a stored value card is refunded.</li><br><li> PrivateLabelCreditCardRevenue - The amount that is deducted from the seller's account because the seller received money through a private label credit card offered by Amazon.</li><br><li> PrivateLabelCreditCardRefund - The amount that Amazon returns to the seller if the order that is bought using a private label credit card offered by Amazon is refunded.</li><br><li> CollectOnDeliveryRevenue - The COD amount that the seller collected directly from the buyer.</li><br><li> CollectOnDeliveryRefund - The amount that Amazon refunds to the buyer if an order paid for by COD is refunded.</li>|string|
|**DirectPaymentAmount**  <br>*optional*|The amount of the direct payment.|[Currency](#currency)|


<a name="directpaymentlist"></a>
### DirectPaymentList
A list of direct payment information.

*Type* : < [DirectPayment](#directpayment) > array


<a name="fbaliquidationevent"></a>
### FBALiquidationEvent
A payment event for Fulfillment by Amazon (FBA) inventory liquidation. This event is used only in the US marketplace.


|Name|Description|Schema|
|---|---|---|
|**PostedDate**  <br>*optional*|The date and time when the financial event was posted.|[Date](#date)|
|**OriginalRemovalOrderId**  <br>*optional*|The identifier for the original removal order.|string|
|**LiquidationProceedsAmount**  <br>*optional*|The amount paid by the liquidator for the seller's inventory. The seller receives this amount minus LiquidationFeeAmount.|[Currency](#currency)|
|**LiquidationFeeAmount**  <br>*optional*|The fee charged to the seller by Amazon for liquidating the seller's FBA inventory.|[Currency](#currency)|


<a name="fbaliquidationeventlist"></a>
### FBALiquidationEventList
A list of FBA inventory liquidation payment events.

*Type* : < [FBALiquidationEvent](#fbaliquidationevent) > array


<a name="feecomponent"></a>
### FeeComponent
A fee associated with the event.


|Name|Description|Schema|
|---|---|---|
|**FeeType**  <br>*optional*|The type of fee. For more information about Selling on Amazon fees, see [Selling on Amazon Fee Schedule](https://sellercentral.amazon.com/gp/help/200336920) on Seller Central. For more information about Fulfillment by Amazon fees, see [FBA features, services and fees](https://sellercentral.amazon.com/gp/help/201074400) on Seller Central.|string|
|**FeeAmount**  <br>*optional*|The amount of the fee.|[Currency](#currency)|


<a name="feecomponentlist"></a>
### FeeComponentList
A list of fee component information.

*Type* : < [FeeComponent](#feecomponent) > array


<a name="financialeventgroup"></a>
### FinancialEventGroup
Information related to a financial event group.


|Name|Description|Schema|
|---|---|---|
|**FinancialEventGroupId**  <br>*optional*|A unique identifier for the financial event group.|string|
|**ProcessingStatus**  <br>*optional*|The processing status of the financial event group indicates whether the balance of the financial event group is settled.<br><br>Possible values:<br><br><li> Open</li><br><li> Closed</li>|string|
|**FundTransferStatus**  <br>*optional*|The status of the fund transfer.|string|
|**OriginalTotal**  <br>*optional*|The total amount in the currency of the marketplace in which the transactions occurred.|[Currency](#currency)|
|**ConvertedTotal**  <br>*optional*|The total amount in the currency of the marketplace in which the funds were disbursed.|[Currency](#currency)|
|**FundTransferDate**  <br>*optional*|The date and time when the disbursement or charge was initiated. Only present for closed settlements. In ISO 8601 date time format.|[Date](#date)|
|**TraceId**  <br>*optional*|The trace identifier used by sellers to look up transactions externally.|string|
|**AccountTail**  <br>*optional*|The account tail of the payment instrument.|string|
|**BeginningBalance**  <br>*optional*|The balance at the beginning of the settlement period.|[Currency](#currency)|
|**FinancialEventGroupStart**  <br>*optional*|The date and time at which the financial event group is opened. In ISO 8601 date time format.|[Date](#date)|
|**FinancialEventGroupEnd**  <br>*optional*|The date and time at which the financial event group is closed. In ISO 8601 date time format.|[Date](#date)|


<a name="financialeventgrouplist"></a>
### FinancialEventGroupList
A list of financial event group information.

*Type* : < [FinancialEventGroup](#financialeventgroup) > array


<a name="financialevents"></a>
### FinancialEvents
Contains all information related to a financial event.


|Name|Description|Schema|
|---|---|---|
|**ShipmentEventList**  <br>*optional*|A list of shipment events.|[ShipmentEventList](#shipmenteventlist)|
|**RefundEventList**  <br>*optional*|A list of refund events.|[ShipmentEventList](#shipmenteventlist)|
|**GuaranteeClaimEventList**  <br>*optional*|A list of guarantee claim events.|[ShipmentEventList](#shipmenteventlist)|
|**ChargebackEventList**  <br>*optional*|A list of chargeback events.|[ShipmentEventList](#shipmenteventlist)|
|**PayWithAmazonEventList**  <br>*optional*|A list of events related to the seller's Pay with Amazon account.|[PayWithAmazonEventList](#paywithamazoneventlist)|
|**ServiceProviderCreditEventList**  <br>*optional*|-|[SolutionProviderCreditEventList](#solutionprovidercrediteventlist)|
|**RetrochargeEventList**  <br>*optional*|-|[RetrochargeEventList](#retrochargeeventlist)|
|**RentalTransactionEventList**  <br>*optional*|-|[RentalTransactionEventList](#rentaltransactioneventlist)|
|**ProductAdsPaymentEventList**  <br>*optional*|A list of sponsored products payment events.|[ProductAdsPaymentEventList](#productadspaymenteventlist)|
|**ServiceFeeEventList**  <br>*optional*|-|[ServiceFeeEventList](#servicefeeeventlist)|
|**SellerDealPaymentEventList**  <br>*optional*|-|[SellerDealPaymentEventList](#sellerdealpaymenteventlist)|
|**DebtRecoveryEventList**  <br>*optional*|A list of debt recovery event information.|[DebtRecoveryEventList](#debtrecoveryeventlist)|
|**LoanServicingEventList**  <br>*optional*|A list of loan servicing events.|[LoanServicingEventList](#loanservicingeventlist)|
|**AdjustmentEventList**  <br>*optional*|A list of adjustment event information for the seller's account.|[AdjustmentEventList](#adjustmenteventlist)|
|**SAFETReimbursementEventList**  <br>*optional*|-|[SAFETReimbursementEventList](#safetreimbursementeventlist)|
|**SellerReviewEnrollmentPaymentEventList**  <br>*optional*|-|[SellerReviewEnrollmentPaymentEventList](#sellerreviewenrollmentpaymenteventlist)|
|**FBALiquidationEventList**  <br>*optional*|A list of FBA inventory liquidation payment events.|[FBALiquidationEventList](#fbaliquidationeventlist)|
|**CouponPaymentEventList**  <br>*optional*|A list of coupon payment event information.|[CouponPaymentEventList](#couponpaymenteventlist)|
|**ImagingServicesFeeEventList**  <br>*optional*|A list of fee events related to Amazon Imaging services.|[ImagingServicesFeeEventList](#imagingservicesfeeeventlist)|
|**NetworkComminglingTransactionEventList**  <br>*optional*|A list of network commingling transaction events.|[NetworkComminglingTransactionEventList](#networkcomminglingtransactioneventlist)|
|**AffordabilityExpenseEventList**  <br>*optional*|A list of expense information related to an affordability promotion.|[AffordabilityExpenseEventList](#affordabilityexpenseeventlist)|
|**AffordabilityExpenseReversalEventList**  <br>*optional*|A list of expense information related to an affordability promotion.|[AffordabilityExpenseEventList](#affordabilityexpenseeventlist)|
|**TrialShipmentEventList**  <br>*optional*|-|[TrialShipmentEventList](#trialshipmenteventlist)|
|**ShipmentSettleEventList**  <br>*optional*|-|[ShipmentSettleEventList](#shipmentsettleeventlist)|


<a name="imagingservicesfeeevent"></a>
### ImagingServicesFeeEvent
A fee event related to Amazon Imaging services.


|Name|Description|Schema|
|---|---|---|
|**ImagingRequestBillingItemID**  <br>*optional*|The identifier for the imaging services request.|string|
|**ASIN**  <br>*optional*|The Amazon Standard Identification Number (ASIN) of the item for which the imaging service was requested.|string|
|**PostedDate**  <br>*optional*|The date and time when the financial event was posted.|[Date](#date)|
|**FeeList**  <br>*optional*|A list of fees associated with the event.|[FeeComponentList](#feecomponentlist)|


<a name="imagingservicesfeeeventlist"></a>
### ImagingServicesFeeEventList
A list of fee events related to Amazon Imaging services.

*Type* : < [ImagingServicesFeeEvent](#imagingservicesfeeevent) > array


<a name="listfinancialeventgroupspayload"></a>
### ListFinancialEventGroupsPayload
The payload for the listFinancialEventGroups operation.


|Name|Description|Schema|
|---|---|---|
|**NextToken**  <br>*optional*|When present and not empty, pass this string token in the next request to return the next response page.|string|
|**FinancialEventGroupList**  <br>*optional*|A list of financial event group information.|[FinancialEventGroupList](#financialeventgrouplist)|


<a name="listfinancialeventgroupsresponse"></a>
### ListFinancialEventGroupsResponse
The response schema for the listFinancialEventGroups operation.


|Name|Description|Schema|
|---|---|---|
|**payload**  <br>*optional*|The payload for the listFinancialEventGroups operation.|[ListFinancialEventGroupsPayload](#listfinancialeventgroupspayload)|
|**errors**  <br>*optional*|One or more unexpected errors occurred during the listFinancialEventGroups operation.|[ErrorList](#errorlist)|


<a name="listfinancialeventspayload"></a>
### ListFinancialEventsPayload
The payload for the listFinancialEvents operation.


|Name|Description|Schema|
|---|---|---|
|**NextToken**  <br>*optional*|When present and not empty, pass this string token in the next request to return the next response page.|string|
|**FinancialEvents**  <br>*optional*|Contains all information related to a financial event.|[FinancialEvents](#financialevents)|


<a name="listfinancialeventsresponse"></a>
### ListFinancialEventsResponse
The response schema for the listFinancialEvents operation.


|Name|Description|Schema|
|---|---|---|
|**payload**  <br>*optional*|The payload for the listFinancialEvents operation.|[ListFinancialEventsPayload](#listfinancialeventspayload)|
|**errors**  <br>*optional*|One or more unexpected errors occurred during the listFinancialEvents operation.|[ErrorList](#errorlist)|


<a name="loanservicingevent"></a>
### LoanServicingEvent
A loan advance, loan payment, or loan refund.


|Name|Description|Schema|
|---|---|---|
|**LoanAmount**  <br>*optional*|The amount of the loan.|[Currency](#currency)|
|**SourceBusinessEventType**  <br>*optional*|The type of event.<br><br>Possible values:<br><br><li> LoanAdvance</li><br><li> LoanPayment</li><br><li> LoanRefund</li>|string|


<a name="loanservicingeventlist"></a>
### LoanServicingEventList
A list of loan servicing events.

*Type* : < [LoanServicingEvent](#loanservicingevent) > array


<a name="networkcomminglingtransactionevent"></a>
### NetworkComminglingTransactionEvent
A network commingling transaction event.


|Name|Description|Schema|
|---|---|---|
|**TransactionType**  <br>*optional*|The type of network item swap.<br><br>Possible values:<br><br><li> NetCo - A Fulfillment by Amazon inventory pooling transaction. Available only in the India marketplace.</li><br><li> ComminglingVAT - A commingling VAT transaction. Available only in the UK, Spain, France, Germany, and Italy marketplaces.</li>|string|
|**PostedDate**  <br>*optional*|The date and time when the financial event was posted.|[Date](#date)|
|**NetCoTransactionID**  <br>*optional*|The identifier for the network item swap.|string|
|**SwapReason**  <br>*optional*|The reason for the network item swap.|string|
|**ASIN**  <br>*optional*|The Amazon Standard Identification Number (ASIN) of the swapped item.|string|
|**MarketplaceId**  <br>*optional*|The marketplace in which the event took place.|string|
|**TaxExclusiveAmount**  <br>*optional*|The price of the swapped item minus TaxAmount.|[Currency](#currency)|
|**TaxAmount**  <br>*optional*|The tax on the network item swap paid by the seller.|[Currency](#currency)|


<a name="networkcomminglingtransactioneventlist"></a>
### NetworkComminglingTransactionEventList
A list of network commingling transaction events.

*Type* : < [NetworkComminglingTransactionEvent](#networkcomminglingtransactionevent) > array


<a name="paywithamazonevent"></a>
### PayWithAmazonEvent
An event related to the seller's Pay with Amazon account.


|Name|Description|Schema|
|---|---|---|
|**SellerOrderId**  <br>*optional*|An order identifier that is specified by the seller.|string|
|**TransactionPostedDate**  <br>*optional*|The date and time when the payment transaction is posted. In ISO 8601 date time format.|[Date](#date)|
|**BusinessObjectType**  <br>*optional*|The type of business object.|string|
|**SalesChannel**  <br>*optional*|The sales channel for the transaction.|string|
|**Charge**  <br>*optional*|The charge associated with the event.|[ChargeComponent](#chargecomponent)|
|**FeeList**  <br>*optional*|A list of fees associated with the event.|[FeeComponentList](#feecomponentlist)|
|**PaymentAmountType**  <br>*optional*|The type of payment.<br><br>Possible values:<br><br><li> Sales</li>|string|
|**AmountDescription**  <br>*optional*|A short description of this payment event.|string|
|**FulfillmentChannel**  <br>*optional*|The fulfillment channel.<br><br>Possible values:<br><br><li> AFN - Amazon Fulfillment Network (Fulfillment by Amazon)</li><br><li> MFN - Merchant Fulfillment Network (self-fulfilled)</li>|string|
|**StoreName**  <br>*optional*|The store name where the event occurred.|string|


<a name="paywithamazoneventlist"></a>
### PayWithAmazonEventList
A list of events related to the seller's Pay with Amazon account.

*Type* : < [PayWithAmazonEvent](#paywithamazonevent) > array


<a name="productadspaymentevent"></a>
### ProductAdsPaymentEvent
A Sponsored Products payment event.


|Name|Description|Schema|
|---|---|---|
|**postedDate**  <br>*optional*|The date and time when the financial event was posted.|[Date](#date)|
|**transactionType**  <br>*optional*|Indicates if the transaction is for a charge or a refund.<br><br>Possible values:<br><br><li> charge - Charge</li><br><li> refund - Refund</li>|string|
|**invoiceId**  <br>*optional*|Identifier for the invoice that the transaction appears in.|string|
|**baseValue**  <br>*optional*|Base amount of the transaction, before tax.|[Currency](#currency)|
|**taxValue**  <br>*optional*|Tax amount of the transaction.|[Currency](#currency)|
|**transactionValue**  <br>*optional*|The total amount of the transaction. Equal to baseValue + taxValue.|[Currency](#currency)|


<a name="productadspaymenteventlist"></a>
### ProductAdsPaymentEventList
A list of sponsored products payment events.

*Type* : < [ProductAdsPaymentEvent](#productadspaymentevent) > array


<a name="promotion"></a>
### Promotion
A promotion applied to an item.


|Name|Description|Schema|
|---|---|---|
|**PromotionType**  <br>*optional*|The type of promotion.|string|
|**PromotionId**  <br>*optional*|The seller-specified identifier for the promotion.|string|
|**PromotionAmount**  <br>*optional*|The amount of promotional discount applied to the item.|[Currency](#currency)|


<a name="promotionlist"></a>
### PromotionList
A list of promotions.

*Type* : < [Promotion](#promotion) > array


<a name="removalshipmentevent"></a>
### RemovalShipmentEvent
A removal shipment event for a removal order.


|Name|Description|Schema|
|---|---|---|
|**PostedDate**  <br>*optional*|The date and time when the financial event was posted.|[Date](#date)|
|**MerchantOrderId**  <br>*optional*|The merchant removal orderId.|string|
|**OrderId**  <br>*optional*|The orderId for shipping inventory.|string|
|**TransactionType**  <br>*optional*|The type of removal order.<br><br>Possible values:<br><br><li> WHOLESALE_LIQUIDATION</li>|string|
|**RemovalShipmentItemList**  <br>*optional*|A list of removal shipment items.|[RemovalShipmentItemList](#removalshipmentitemlist)|


<a name="removalshipmenteventlist"></a>
### RemovalShipmentEventList
A list of removal shipment event information.

*Type* : < [RemovalShipmentEvent](#removalshipmentevent) > array


<a name="removalshipmentitem"></a>
### RemovalShipmentItem
Item-level information for a removal shipment.


|Name|Description|Schema|
|---|---|---|
|**RemovalShipmentItemId**  <br>*optional*|An identifier for an item in a removal shipment.|string|
|**TaxCollectionModel**  <br>*optional*|The tax collection model applied to the item.<br><br>Possible values:<br><br><li> MarketplaceFacilitator - Tax is withheld and remitted to the taxing authority by Amazon on behalf of the seller.</li><br><li> Standard - Tax is paid to the seller and not remitted to the taxing authority by Amazon.</li>|string|
|**FulfillmentNetworkSKU**  <br>*optional*|The Amazon fulfillment network SKU for the item.|string|
|**Quantity**  <br>*optional*|The quantity of the item.|integer (int32)|
|**Revenue**  <br>*optional*|The total amount paid to the seller for the removed item.|[Currency](#currency)|
|**FeeAmount**  <br>*optional*|The fee that Amazon charged to the seller for the removal of the item. The amount is a negative number.|[Currency](#currency)|
|**TaxAmount**  <br>*optional*|Tax collected on the revenue.|[Currency](#currency)|
|**TaxWithheld**  <br>*optional*|The tax withheld and remitted to the taxing authority by Amazon on behalf of the seller. If TaxCollectionModel=MarketplaceFacilitator, then TaxWithheld=TaxAmount (except the TaxWithheld amount is a negative number). Otherwise TaxWithheld=0.|[Currency](#currency)|


<a name="removalshipmentitemlist"></a>
### RemovalShipmentItemList
A list of information about removal shipment items.

*Type* : < [RemovalShipmentItem](#removalshipmentitem) > array


<a name="removalshipmentadjustmentevent"></a>
### RemovalShipmentAdjustmentEvent
A financial adjustment event for FBA liquidated inventory.

Possible adjustment:

* Positive values - Buyer needs to pay more amount to Amazon. E.g. charge was wrongly calculated 0$ instead of 100$ due to system error. 

* Negative Values - Buyer get refund. E.g. Buyer receives less items or damaged items and as part of their adjustment buyer gets refund.


|Name|Description|Schema|
|---|---|---|
|**PostedDate**  <br>*optional*|The date when the financial event was posted.|[Date](#date)|
|**AdjustmentEventId**  <br>*optional*|The unique identifier for the adjustment event.|string|
|**MerchantOrderId**  <br>*optional*|The merchant removal orderId.|string|
|**OrderId**  <br>*optional*|The orderId for shipping inventory.|string|
|**TransactionType**  <br>*optional*|The type of removal order.<br><br>Possible values:<br><br><li> WHOLESALE_LIQUIDATION.</li>|string|
|**RemovalShipmentItemAdjustmentList**  <br>*optional*|A comma-delimited list of Removal shipmentItemAdjustment details for FBA inventory.|< [RemovalShipmentItemAdjustment](#removalshipmentitemadjustment) > array|


<a name="removalshipmentadjustmenteventlist"></a>
### RemovalShipmentAdjustmentEventList
A comma-delimited list of Removal shipmentAdjustment details for FBA inventory.

*Type* : < [RemovalShipmentAdjustmentEvent](#removalshipmentadjustmentevent) > array


<a name="removalshipmentitemadjustment"></a>
### RemovalShipmentItemAdjustment
Item-level information for a removal shipment item adjustment.


|Name|Description|Schema|
|---|---|---|
|**RemovalShipmentItemId**  <br>*optional*|An identifier for an item in a removal shipment.|string|
|**TaxCollectionModel**  <br>*optional*|The tax collection model applied to the item.<br><br>Possible values:<br><br><li> MarketplaceFacilitator - Tax is withheld and remitted to the taxing authority by Amazon on behalf of the seller.</li><br><li> Standard - Tax is paid to the seller and not remitted to the taxing authority by Amazon.</li>|string|
|**FulfillmentNetworkSKU**  <br>*optional*|The Amazon fulfillment network SKU for the item.|string|
|**AdjustedQuantity**  <br>*optional*|Adjusted quantity of removal shipmentItemAdjustment items.|integer (int32)|
|**RevenueAdjustment**  <br>*optional*|The total amount adjusted for disputed items.|[Currency](#currency)|
|**TaxAmountAdjustment**  <br>*optional*|Adjustment on the Tax collected amount on the adjusted revenue.|[Currency](#currency)|
|**TaxWithheldAdjustment**  <br>*optional*|Adjustment the tax withheld and remitted to the taxing authority by Amazon on behalf of the seller. If TaxCollectionModel=MarketplaceFacilitator, then TaxWithheld=TaxAmount (except the TaxWithheld amount is a negative number). Otherwise TaxWithheld=0.|[Currency](#currency)|

