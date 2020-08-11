package io.swagger.client.samples;

import java.util.ArrayList;
import java.util.List;

import com.amazon.SellingPartnerAPIAA.AWSAuthenticationCredentials;
import com.amazon.SellingPartnerAPIAA.LWAAuthorizationCredentials;

import io.swagger.client.ApiException;
import io.swagger.client.api.SolicitationsApi;
import io.swagger.client.model.CreateProductReviewAndSellerFeedbackSolicitationResponse;
import io.swagger.client.model.GetSolicitationActionsForOrderResponse;

public class SolicitationsSample {

    private static List<String> marketplaceId = new ArrayList<String>();
    private static String marketplaceValue = "xxxx";
    private static String orderId = "xxx";
    private static String endpointUrl = "https://sellingpartnerapi-na.amazon.com";

    public static void main(String[] args) {

        marketplaceId.add(marketplaceValue);

        SolicitationsApi apiClient = new SolicitationsApi.Builder()
                .awsAuthenticationCredentials(SellingPartnerCredentialsConfig.awsAuthenticationCredentials())
                .lwaAuthorizationCredentials(SellingPartnerCredentialsConfig.lwaAuthorizationCredentials())
                .endpoint(endpointUrl).build();

        /** Sample for GetSolicitationActionsForOrder */
        /*
           try { GetSolicitationActionsForOrderResponse eligibleResponse =
           apiClient.getSolicitationActionsForOrder(orderId, marketplaceId);
           System.out.println("actionResponse" + eligibleResponse);
           }catch(ApiException e) { System.out.println(e.getResponseBody()); }
         */

        /** Sample for CreateProductReviewAndSellerFeedbackSolicitation */
        try {
            System.out.println("createSolicit");
            CreateProductReviewAndSellerFeedbackSolicitationResponse createSolicit = apiClient
                    .createProductReviewAndSellerFeedbackSolicitation(orderId,
                            marketplaceId);
            System.out.println("createSolicit" + createSolicit);
        } catch (ApiException e) {
            System.out.println(e.getResponseBody());
        }
    }
}
