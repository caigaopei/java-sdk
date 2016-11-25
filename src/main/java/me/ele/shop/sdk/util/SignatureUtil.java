package me.ele.shop.sdk.util;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.TreeMap;

public class SignatureUtil {
    private static ObjectMapper objectMapper = new ObjectMapper();

    public static String generateSignature(String appKey, String secret, long timestamp, String action, String token, Map<String, Object> parameters) {
        final Map<String, Object> sorted = new TreeMap<>();
        parameters.forEach((key, value) -> sorted.put(key, value));
        sorted.put("app_key", appKey);
        sorted.put("timestamp", timestamp);

        StringBuffer string = new StringBuffer();
        sorted.forEach((key, value) -> {
            try {
                string.append(key + "=" + objectMapper.writeValueAsString(value));
            } catch (JsonProcessingException ignore) {
                ignore.printStackTrace();
            }
        });

        String splice = String.format("%s%s%s%s", action, token, string, secret);
        String calculatedSignature = md5(splice);
        return calculatedSignature.toUpperCase();
    }

    public static String md5(String str) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException ignore) {
        }
        md.update(str.getBytes());

        byte byteData[] = md.digest();
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < byteData.length; i++)
            buffer.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));

        return buffer.toString();
    }
}
