package me.ele.shop.sdk.protocol;

import lombok.Getter;

import java.util.Date;

public class Token {
    @Getter
    private OAuthToken oAuthToken;
    @Getter
    long lastTime;

    public Token(OAuthToken oAuthToken) {
        this.oAuthToken = oAuthToken;
        Date now = new Date();
        lastTime = now.getTime() + oAuthToken.getExpires();
    }
}
