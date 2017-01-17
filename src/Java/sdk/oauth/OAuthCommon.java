package sdk.oauth;

import org.apache.http.HttpHeaders;
import sdk.config.Config;
import sun.misc.BASE64Encoder;

import java.util.HashMap;

class OAuthCommon {
    private static String getBasic() {
        return "Basic " + new BASE64Encoder().encode((String.format("%s:%s", Config.getAppKey(), Config.getSecret()).getBytes()));
    }

    static HashMap<String, String> getHeaders() {
        return new HashMap<String, String>() {{
            put(HttpHeaders.CONTENT_TYPE, "Content-Type: application/x-www-form-urlencoded; charset=utf-8");
            put(HttpHeaders.AUTHORIZATION, getBasic());
        }};
    }
}
