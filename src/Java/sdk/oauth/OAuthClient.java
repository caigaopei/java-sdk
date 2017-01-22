package sdk.oauth;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHeaders;
import org.apache.log4j.Logger;
import sdk.config.Config;
import sdk.util.HttpClientUtil;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class OAuthClient {

    HttpClientUtil httpClientUtil = new HttpClientUtil();

    Logger logger = Logger.getLogger(this.getClass());

    private String callbackUrl;

    private static ObjectMapper objectMapper = new ObjectMapper();

    static {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL, true);
    }

    public Token getAccessToken() {
        try {
            Map<String, String> body = new HashMap<String, String>();
            body.put("grant_type", "client_credentials");

            String response = httpClientUtil.post(Config.getAccessTokenUrl(), getHeaders(), body);
            logger.info("getAccessToken: " + response);

            AccessToken accessToken = objectMapper.readValue(response, AccessToken.class);
            Token token = new Token(accessToken);
            return token;
        } catch (IOException e) {
            logger.error(e);
            throw new RuntimeException(e);
        }
    }


    public String getAuthUrl(String state, String scope) {
        String url = Config.getAuthorizeUrl();
        String responseType = "code";
        String clientId = Config.getAppKey();
        String callback;
        try {
            callback = URLEncoder.encode(Config.getCallbackUrl(), "utf-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        return String.format("%s?response_type=%s&client_id=%s&state=%s&redirect_uri=%s&scope=%s", url, responseType, clientId, state, callback, scope);
    }

    public String getTokenByCode(final String code) {
        try {
            final String callback = Config.getCallbackUrl();
            Map<String, String> body = new HashMap<String, String>();
            body.put("grant_type", "authorization_code");
            body.put("code", code);
            body.put("redirect_uri", callback);
            body.put("client_id", Config.getAppKey());

            String response = httpClientUtil.post(Config.getAccessTokenUrl(), getHeaders(), body);

            logger.info("getTokenByCode: " + response);
            return response;
        } catch (IOException e) {
            logger.error(e);
            throw new RuntimeException(e);
        }
    }

    public String getTokenByRefreshToken(String refreshToken, String scope) {
        Map<String, String> body = new HashMap<String, String>();
        body.put("grant_type", "refresh_token");
        body.put("refresh_token", refreshToken);
        body.put("scope", scope);
        String response;
        try {
            response = httpClientUtil.post(Config.getAccessTokenUrl(), getHeaders(), body);
        } catch (IOException e) {
            logger.error(e);
            throw new RuntimeException(e);
        }
        logger.info("getTokenByRefreshToken: " + response);
        return response;
    }

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
