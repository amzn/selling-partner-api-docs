package io.swagger.client.samples;

import com.amazon.SellingPartnerAPIAA.AWSAuthenticationCredentials;
import com.amazon.SellingPartnerAPIAA.LWAAuthorizationCredentials;

public class SellingPartnerCredentialsConfig {

	/** The client application id */
	private static final String clientId = "xxxx";

	/** The client secret */
	private static final String clientSecret = "xxxx";

	/** The Refresh token */
	private static final String refreshToken = "xxxx";

	/** The Refresh token */
	private static final String lwaEndPoint = "xxxx";

	/** AWS access key ID */
	private static final String accessKey = "xxx";

	/** AWS secret key. */
	private static final String secretKey = "xxx";

	/** region */
	private static final String region = "xxxxx";

	private static LWAAuthorizationCredentials lwaAuthorizationCredentials = null;

	private static AWSAuthenticationCredentials awsAuthenticationCredentials = null;

	public static LWAAuthorizationCredentials lwaAuthorizationCredentials() {
		if (lwaAuthorizationCredentials == null) {
			lwaAuthorizationCredentials = LWAAuthorizationCredentials.builder().clientId(clientId)
					.clientSecret(clientSecret).refreshToken(refreshToken).endpoint(lwaEndPoint).build();
		}
		return lwaAuthorizationCredentials;
	}

	public static AWSAuthenticationCredentials awsAuthenticationCredentials() {
		if (awsAuthenticationCredentials == null) {
			AWSAuthenticationCredentials.builder().accessKeyId(accessKey).secretKey(secretKey).region(region).build();
		}
		return awsAuthenticationCredentials;
	}

}
