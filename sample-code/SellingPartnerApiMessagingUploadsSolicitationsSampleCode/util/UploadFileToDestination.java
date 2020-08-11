package io.swagger.client.util;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

import io.swagger.client.model.CreateUploadDestinationResponse;

public class UploadFileToDestination {

    private static String requestMethod = "PUT";
    private static String contentType = "Content-Type";
    private static String contentValue = "application/text";
    private static URL url;
    private static Map<String, String> headers;

    /* Upload file to destination using the response returned in
       CreateUploadDestination. Reference https://docs.aws.amazon.com/AmazonS3/latest/dev/PresignedUrlUploadObjectJavaSDK.html)
     */

    @SuppressWarnings("unchecked")
    public static void uploadFileInDestination(
            CreateUploadDestinationResponse uploadDestinationPayload)
            throws IOException {

        url = new URL(uploadDestinationPayload.getPayload().getUrl());
        headers = (Map<String, String>) uploadDestinationPayload.getPayload()
                .getHeaders();

        // Create the connection and use it to upload the new object using the
        // pre-signed URL.
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setDoOutput(true);
        connection.setRequestMethod(requestMethod);
        connection.setRequestProperty(contentType, contentValue);
        // headers that are returned in createDestination call
        for (Map.Entry<String, String> headersEntry : headers.entrySet()) {
            connection.setRequestProperty(headersEntry.getKey(),
                    headersEntry.getValue());
        }
        OutputStreamWriter out = new OutputStreamWriter(
                connection.getOutputStream());
        out.write("Text of the file");
        out.close();
        // Check the HTTP response code. To complete the upload and make the
        // object available,
        // you must interact with the connection object in some way.
        connection.getResponseCode();
        System.out.println("HTTP response code: " + connection.getResponseCode()
                + connection.getResponseMessage());
        connection.disconnect();

    }

}
