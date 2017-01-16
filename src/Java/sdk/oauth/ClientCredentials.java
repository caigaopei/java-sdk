package sdk.oauth;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHeaders;
import org.apache.log4j.Logger;
import sdk.config.Config;
import sdk.util.HttpClientUtil;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.util.HashMap;

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
            final String basic = "Basic " + new BASE64Encoder().encode((String.format("%s:%s", Config.getAppKey(), Config.getSecret()).getBytes()));
            String response = httpClientUtil.post(Config.getAccessTokenUrl(), new HashMap<String, String>() {{
                put(HttpHeaders.CONTENT_TYPE, "Content-Type: application/x-www-form-urlencoded; charset=utf-8");
                put(HttpHeaders.AUTHORIZATION, basic);
            }}, new HashMap<String, String>() {{
                put("grant_type", "client_credentials");
            }});

            logger.info(response);

            AccessToken accessToken = objectMapper.readValue(response, AccessToken.class);
            Token token = new Token(accessToken);
            return token;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
