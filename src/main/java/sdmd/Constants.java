package sdmd;

import com.google.api.server.spi.Constant;

/**
 * Contains the client IDs and scopes for allowed clients consuming the
 * Timelogger API.
 */
public final class Constants {
	public static final String WEB_CLIENT_ID = "326835170277-80i2e03uhag9eqvonq01aigrk6uml3l1.apps.googleusercontent.com";
	public static final String WEB_CLIENT_SECRET = "iLGrYJGTnW7_QjQ07_3v5ry9";
	
	public static final String ANDROID_CLIENT_ID = "replace this with your Android client ID";
	public static final String IOS_CLIENT_ID = "replace this with your iOS client ID";
	public static final String ANDROID_AUDIENCE = WEB_CLIENT_ID;

	public static final String EMAIL_SCOPE = "https://www.googleapis.com/auth/userinfo.email";

	public static final String API_EXPLORER_CLIENT_ID = Constant.API_EXPLORER_CLIENT_ID;

	private Constants() {
	}
}
