package sdk.config;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

public class Config {
    private static boolean sandbox;
    private static String appKey;
    private static String secret;
    private static String apiServerRequestUrl;
    private static String tokenRequestBaseUrl;

    static {
        Properties properties = new Properties();
        InputStream in = null;
        try {
            in = Thread.currentThread().getContextClassLoader().getResourceAsStream("config.properties");
            properties.load(in);
            in.close();

            sandbox = properties.get("sandbox").equals("true") ? true : false;
            appKey = (String) properties.get("appKey");
            secret = (String) properties.get("secret");
            apiServerRequestUrl = (String) properties.get("apiServerRequestUrl");
            tokenRequestBaseUrl = (String) properties.get("tokenRequestBaseUrl");

            Map<String, String> envs = System.getenv();
            //System.out.println(envs);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (appKey == null || secret == null) {
            throw new RuntimeException("fix config.properties first.");
        }
    }

    public static String getAppKey() {
        return appKey.trim();
    }

    public static String getSecret() {
        return secret.trim();
    }

    public static String getAccessTokenUrl() {
        return getTokenRequestBaseUrl() + "/token";
    }

    public static String getTokenRequestBaseUrl() {
        if (tokenRequestBaseUrl == null) {
            return sandbox ? "https://open-api-sandbox.shop.ele.me" : "https://open-api.shop.ele.me";
        }
        return tokenRequestBaseUrl;
    }


    public static String getAPIServerUrl() {
        if (apiServerRequestUrl == null) {
            return sandbox ? "https://open-api-sandbox.shop.ele.me/api/v1/" : "https://open-api.shop.ele.me/api/v1/";
        }
        return apiServerRequestUrl;
    }


}
