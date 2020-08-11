package io.swagger.client.samples;

import java.util.ArrayList;
import java.util.List;
import io.swagger.client.api.MessagingApi;
import io.swagger.client.model.Attachment;
import io.swagger.client.model.CreateAmazonMotorsRequest;
import io.swagger.client.model.CreateAmazonMotorsResponse;
import io.swagger.client.model.CreateUploadDestinationResponse;

public class MessagingSample {
    private static List<String> marketplaceId = new ArrayList<String>();
    private static String marketplaceValue = "xxxx";
    private static String orderId = "xxx";
    private static UploadsSample uploadSample;
    private static String endpointUrl = "https://sellingpartnerapi-na.amazon.com";
    private static String fileName = "xxx";

    public static void main(String[] args) {
        uploadSample = new UploadsSample();
        marketplaceId.add(marketplaceValue);

        MessagingApi messagingClient = new MessagingApi.Builder()
                .awsAuthenticationCredentials(SellingPartnerCredentialsConfig.awsAuthenticationCredentials())
                .lwaAuthorizationCredentials(SellingPartnerCredentialsConfig.lwaAuthorizationCredentials())
                .endpoint(endpointUrl).build();

        /** Sample call for GetMessagingActionsForOrder. */
        /*
           try { GetMessagingActionsForOrderResponse messagingActionsForOrderRepsonse =
           messagingClient.getMessagingActionsForOrder(orderId, marketplaceId);
           System.out.println(messagingActionsForOrderRepsonse.toString());
           }catch(Exception e) { 
           System.out.println(e.toString()); }
         */

        /** Sample call for CreateConfirmDeliveryDetails. */
        /*
           try { CreateConfirmDeliveryDetailsRequest requestBody = new
           CreateConfirmDeliveryDetailsRequest(); 
           requestBody.setText("xxxx");
           CreateConfirmDeliveryDetailsResponse deliveryResponse =
           messagingClient.createConfirmDeliveryDetails(orderId, marketplaceId,
           requestBody); 
           System.out.println(deliveryResponse.toString());
           }catch(Exception e) {
            System.out.println(e.getMessage()); }
         */

        /** Sample call for CreateConfirmServiceDetails. */
        /*
           try { CreateConfirmServiceDetailsRequest requestBody = new
           CreateConfirmServiceDetailsRequest();
           requestBody.setText("Confirm Service");
           CreateConfirmServiceDetailsResponse serviceDetialsResponse =
           messagingClient.createConfirmServiceDetails(orderId, marketplaceId, requestBody); 
           System.out.println("serviceDetialsResponse" +
           serviceDetialsResponse.toString()); 
           }catch(Exception e) {
           System.out.println(e.getMessage()); }
         */

        /** Sample call for CreateAmazonMotors, uses an attachment file uploaded
          to a destination that was created by the createUploadDestination
         */
        try {
            CreateAmazonMotorsRequest motorsRequest = new CreateAmazonMotorsRequest();
            // Get upload details from Uploads API.
            CreateUploadDestinationResponse uploadDestinationResponse = uploadSample
                    .uploadDestination();

            if (uploadDestinationResponse != null) {
                String uploadDestinationId = uploadDestinationResponse
                        .getPayload().getUploadDestinationId();
                Attachment attachment = new Attachment();
                attachment.setFileName(fileName);
                attachment.setUploadDestinationId(uploadDestinationId);
                List<Attachment> list = new ArrayList<Attachment>();
                list.add(attachment);
                motorsRequest.setAttachments(list);
                CreateAmazonMotorsResponse motorsResponse = messagingClient
                        .createAmazonMotors(orderId, marketplaceId,
                                motorsRequest);
                System.out.println(
                        "motorsResponse: " + motorsResponse.toString());
            } else {
                System.out.println("uploadDestinationResponse is null");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
