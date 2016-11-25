package me.ele.shop.sdk.protocol;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.Inject;
import me.ele.shop.sdk.Config;
import me.ele.shop.sdk.util.HttpClientUtil;
import org.apache.http.HttpHeaders;

import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;

public class ClientCredentials {
    @Inject
    HttpClientUtil httpClientUtil;
    @Inject
    private static ObjectMapper objectMapper = new ObjectMapper();

    static {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL, true);
    }

    public Token getAccessToken() {
        try {
            String basic = "Basic " + Base64.getEncoder().encodeToString(String.format("%s:%s", Config.getAppKey(), Config.getSecret()).getBytes()).toString();
            String response = httpClientUtil.post(Config.getAccessTokenUrl(), new HashMap<String, String>() {{
                put(HttpHeaders.CONTENT_TYPE, "Content-Type: application/x-www-form-urlencoded; charset=utf-8");
                put(HttpHeaders.AUTHORIZATION, basic);
            }}, new HashMap<String, String>() {{
                put("grant_type", "client_credentials");
            }});

            return objectMapper.readValue(response, Token.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
