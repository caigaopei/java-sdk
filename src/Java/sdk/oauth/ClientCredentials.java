package sdk.oauth;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import sdk.config.Config;
import sdk.util.HttpClientUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ClientCredentials {

    HttpClientUtil httpClientUtil = new HttpClientUtil();

    Logger logger = Logger.getLogger(this.getClass());

    private static ObjectMapper objectMapper = new ObjectMapper();

    static {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL, true);
    }

    public Token getAccessToken() {
        try {
            Map<String, String> body = new HashMap<String, String>();
            body.put("grant_type", "client_credentials");

            String response = httpClientUtil.post(Config.getAccessTokenUrl(), OAuthCommon.getHeaders(), body);
            logger.info("getAccessToken: " + response);

            AccessToken accessToken = objectMapper.readValue(response, AccessToken.class);
            Token token = new Token(accessToken);
            return token;
        } catch (IOException e) {
            logger.error(e);
            throw new RuntimeException(e);
        }
    }
}
