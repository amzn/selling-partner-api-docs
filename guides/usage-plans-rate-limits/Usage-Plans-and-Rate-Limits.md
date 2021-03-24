# Usage Plans and Rate Limits in the Selling Partner API

API reliability depends on sizing your capacity and resources to meet the changing needs of applications over time. This means attempting to understand and forecast usage, and then managing the frequency of requests to protect against overwhelming the service at peak usage times.

In the Selling Partner API, requests are rate limited using the [token bucket algorithm](https://en.wikipedia.org/wiki/Token_bucket). The algorithm is based on the analogy of a bucket that contains tokens, where each token can be exchanged to make a request. Tokens are automatically added to the bucket using a set rate-per-second until the maximum size of the bucket is reached. The maximum size is also called the burst rate. Each request subtracts a token from the bucket. Throttling occurs when a request is made for which no token is available because the bucket is empty. A throttled request results in an error response.

## Usage Plans

Selling Partner API operations have associated usage plans that specify the rate limits. You can find these in the API Reference documentation. The usage plan definitions are:

- Rate - The number of requests per second that are added to the token bucket, and thus can be used to submit requests without experiencing throttling. If you are making calls continuously over a long period of time, staying below this rate will help you avoid throttled requests.

- Burst – The maximum size that the token bucket can reach. This also represents the maximum number of requests that you can build up over time and then submit simultaneously assuming the token bucket is full.

## Dynamic Usage Plans

This new feature automatically adjusts rate-limits to right-size them based on the needs of the business over time.

A dynamic usage plan is one that is automatically adjusted to each selling partner based on the current and historical business needs for that business. A variety of measures are employed as rules to drive dynamic rate limit adjustments. This means you can expect rate limits to change for any Selling Partner API operation that employs dynamic usage plans. The default rates published in the API Reference documentation can be used as a basis to plan your application. However, because the purpose of dynamic usage plans is to right-size those limits over time, the rates will change. When you submit a request to a Selling Partner API operation, the current rate limits for that operation are returned in the `x-amzn-RateLimit-Limit` response header, when possible.

## The `x-amzn-RateLimit-Limit` response header

The `x-amzn-RateLimit-Limit` response header returns your current rate limit (requests per second) for a valid request, on a best-effort basis. In some instances, our attempt to request, retrieve and provide the rate limit can itself fail. This could be due to random network error, our request attempt being throttled, or other hard-to-predict issues. When that happens, we will not fail an otherwise valid request to a Selling Partner API operation. We will instead return the response without the header.

This means you must not depend on the presence of the `x-amzn-RateLimit-Limit` header in a response. Instead, check for the presence of the header before attempting to use the rate limit value.

The `x-amzn-RateLimit-Limit` should never be expected in the response to a throttled, unauthorized, or unauthenticated request. 

## Comparison to Amazon Marketplace Web Service (Amazon MWS)

Dynamic usage plans are designed to reduce throttling when compared to Amazon MWS. In Amazon MWS today, rate limits are applied uniformly without considering business size or changing business needs over time. With dynamic usage plans in the Selling Partner API, you can move from a one-size-fits all design to an approach that emphasizes right-sizing the rate limits for each selling partner based on business context and changing needs over time.

The key design improvements are:

- Dynamic usage plans adjust rate limits according to changing business needs. Rate limits are set for each selling partner.

- Dynamic usage plans automatically right-size rates to improve traffic performance.

## Frequently Asked Questions

### General

#### How should my application handle a 429 response?

A 429 is a retry-able status code. Feel free to try again, but repeated throttled requests require a back off strategy. Please refer to the `x-amzn-RateLimit-Limit` response header, when available, to see if the rate limits differ from your expectations.

#### How can I test my application with respect to its usage plans?

You can test 429 error handling using the Selling Partner API sandbox. However, you cannot test rate limits with the sandbox. This is because while operations in production can have various rates, all sandbox operations share the same rate. You can see your assigned usage rates in the `x-amzn-RateLimit-Limit` response header for each operation, when available.

#### Can my application completely avoid getting throttled?

No. Any number of factors outside your control could result in a small number of transient 429s. This is expected and should be accounted for in your application code.

#### What should I do if my application is consistently throttled?

If your application is consistently throttled, it might mean that your call patterns could be further optimized. For example:

1. Call less frequently aligned with your rate limits.

2. Rely on push notifications over polling mechanisms.

3. Use batch APIs where available or otherwise try to do more with fewer calls. For example, with the [Feeds](https://github.com/amzn/selling-partner-api-docs/blob/main/references/feeds-api/feeds_2020-09-04.md) and [Reports](https://github.com/amzn/selling-partner-api-docs/blob/main/references/reports-api/reports_2020-09-04.md) APIs you can send or retrieve a lot of information (i.e. batches of information) using a relatively small number of calls. Generally, examine your call patterns against the operations in an API to see if you can get the same work done in fewer calls.

#### The rate limits for one operation are too low for my use case. Can the limit be increased?

We aim for right-sized limits, with the goal that efficient call patterns should, ideally, never be throttled. If you believe that you have a use case that we have not properly accounted for, please let us know by opening a support ticket.

#### Will my application be throttled more often as I obtain more authorizations?

No. All usage plans are specific to application-Selling Partner pairs, so that your throughput grows naturally with your clients.

#### Will rate limits change?

We could raise rate limits at any time. If we ever lower the rate limits posted in the API reference documentation, we will communicate the change in advance to give you time to update and test your applications before the change goes live.

Rate limits for dynamic usage plans (discussed below) auto adjust higher or lower depending on business context.

### Dynamic Usage Plans

#### What is the overall goal of dynamic usage plans?

Historically, we have observed that homogeneous usage plans are over-sized for some situations and, worse, under-sized for others. The goal of dynamic usage plans is to leverage the known context of a given call to put the right limits in place for any situation.

#### What factors influence dynamic usage plans?

In general, rate limits are shaped by the type, size, and behavior of the selling partner business.

#### How often will the limits associated with a given usage plan change?

We aim to prevent frequent, disruptive changes to limits. Generally, limits will be changed as soon as the need is observed.

#### How should I code my application to respect dynamic limits?

Here are a few suggestions for good application behavior with respect to dynamic rate limits.

1. Read the `x-amzn-RateLimit-Limit` header, when available.

2. Do not hardcode timers.

3. Code naturally against events rather than running on a loop. If you do this you won’t need a timer at all. In the example of a re-pricer, update prices in response to price notifications rather than every n-seconds.

#### Which Selling Partner API sections use dynamic usage plans?

The Selling Partner API for Orders.

#### Why don’t all operations support dynamic usage plans?

We are working on it\!
