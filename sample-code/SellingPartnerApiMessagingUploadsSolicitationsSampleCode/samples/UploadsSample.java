package io.swagger.client.samples;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import com.amazon.SellingPartnerAPIAA.AWSAuthenticationCredentials;
import com.amazon.SellingPartnerAPIAA.LWAAuthorizationCredentials;
import io.swagger.client.ApiException;
import io.swagger.client.api.MessagingApi;
import io.swagger.client.api.UploadsApi;
import io.swagger.client.model.CreateUploadDestinationResponse;
import io.swagger.client.util.CreateMD5;
import io.swagger.client.util.UploadFileToDestination;

public class UploadsSample {
    private static List<String> marketplaceId = new ArrayList<String>();
    private static String contentMD5;
    private static File file = new File("fileLocation");
    private static String marketplaceValue = "xxxx";
    private static String endpointUrl = "https://sellingpartnerapi-na.amazon.com";

    public CreateUploadDestinationResponse uploadDestination()
            throws NoSuchAlgorithmException, FileNotFoundException,
            IOException {

        UploadsApi uploadsClient = new UploadsApi.Builder()
                .awsAuthenticationCredentials(SellingPartnerCredentialsConfig.awsAuthenticationCredentials())
                .lwaAuthorizationCredentials(SellingPartnerCredentialsConfig.lwaAuthorizationCredentials())
                .endpoint(endpointUrl).build();

        contentMD5 = CreateMD5
                .computeContentMD5Value(new FileInputStream(file));
        marketplaceId.add(marketplaceValue);

        /** Sample for CreateUploadDestination */

        try {
            CreateUploadDestinationResponse uploadDestinationPayload = uploadsClient
                    .createUploadDestination(marketplaceId, contentMD5);
            if (uploadDestinationPayload != null) {
                UploadFileToDestination
                        .uploadFileInDestination(uploadDestinationPayload);
            }
            return uploadDestinationPayload;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
