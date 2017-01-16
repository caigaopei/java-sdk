package sdk.oauth;

import sdk.config.Config;
import sun.misc.BASE64Encoder;

import java.util.UUID;

public class ClientOAuth {
    
    public String getAuthUrl(int appId, String redirectUri) {
        String url = Config.getTokenRequestBaseUrl() + "/authorize";
        String responseType = "code";
        String clientId = String.valueOf(appId);
        String state = UUID.randomUUID().toString();
        String callback = new BASE64Encoder().encode(redirectUri.getBytes());
        return String.format("%s?response_type=%s&client_id=%s&state=%s&redirect_uri=%s", url, responseType, clientId, state, callback);
    }

    public String getTokenByCode(String code, String redirectUri) {
        return "";
    }

    public String getTokenByRefreshToken(String refreshToken) {
        return "";
    }

}
