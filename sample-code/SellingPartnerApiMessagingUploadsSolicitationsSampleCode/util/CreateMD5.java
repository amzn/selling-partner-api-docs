package io.swagger.client.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CreateMD5 {

    /** Calculate content MD5 hash values for feeds stored on disk.
     */
    public static String computeContentMD5Value(FileInputStream fis)
            throws IOException, NoSuchAlgorithmException {

        DigestInputStream dis = new DigestInputStream(fis,
                MessageDigest.getInstance("MD5"));

        byte[] buffer = new byte[8192];
        while (dis.read(buffer) > 0);

        String md5Content = new String(org.apache.commons.codec.binary.Base64
                .encodeBase64(dis.getMessageDigest().digest()));

        // Effectively resets the stream to be beginning of the file
        // via a FileChannel.
        fis.getChannel().position(0);

        return md5Content;
    }
}
