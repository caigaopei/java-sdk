package sdk.oauth;

import org.apache.log4j.Logger;
import sdk.config.Config;
import sdk.util.HttpClientUtil;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class OAuthUtil {

    Logger logger = Logger.getLogger(this.getClass());

    HttpClientUtil httpClientUtil = new HttpClientUtil();

    public String getAuthUrl(int appId, String state, String redirectUri, String scope) {
        String url = Config.getTokenRequestBaseUrl() + "/authorize";
        String responseType = "code";
        String clientId = String.valueOf(appId);
        String callback;
        try {
            callback = URLEncoder.encode(redirectUri, "utf-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        return String.format("%s?response_type=%s&client_id=%s&state=%s&redirect_uri=%s&scope=%s", url, responseType, clientId, state, callback, scope);
    }

    public String getTokenByCode(final String code, String redirectUri) {
        try {
            final String callback = URLEncoder.encode(redirectUri, "utf-8");
            Map<String, String> body = new HashMap<String, String>();
            body.put("grant_type", "authorization_code");
            body.put("code", code);
            body.put("redirect_uri", callback);
            String response = httpClientUtil.post(Config.getAccessTokenUrl(), OAuthCommon.getHeaders(), body);

            logger.info("getTokenByCode: " + response);
            return response;
        } catch (IOException e) {
            logger.error(e);
            throw new RuntimeException(e);
        }
    }

    public String getTokenByRefreshToken(String refreshToken) {
        Map<String, String> body = new HashMap<String, String>();
        body.put("grant_type", "refresh_token");
        body.put("refresh_token", refreshToken);
        String response;
        try {
            response = httpClientUtil.post(Config.getAccessTokenUrl(), OAuthCommon.getHeaders(), body);
        } catch (IOException e) {
            logger.error(e);
            throw new RuntimeException(e);
        }
        logger.info("getTokenByRefreshToken: " + response);
        return response;
    }

}
