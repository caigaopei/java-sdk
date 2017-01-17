package sdk.oauth;

import sdk.config.Config;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.UUID;

public class OAuthUtil {

    public String getAuthUrl(int appId, String redirectUri) throws IOException {
        String url = Config.getTokenRequestBaseUrl() + "/authorize";
        String responseType = "code";
        String clientId = String.valueOf(appId);
        String state = UUID.randomUUID().toString();
        String callback = URLEncoder.encode(redirectUri, "utf-8");
        return String.format("%s?response_type=%s&client_id=%s&state=%s&redirect_uri=%s", url, responseType, clientId, state, callback);
    }

    public String getTokenByCode(String code, String redirectUri) {
        return "";
    }

    public String getTokenByRefreshToken(String refreshToken) {
        return "";
    }

}
