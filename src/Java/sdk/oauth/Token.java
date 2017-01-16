package sdk.oauth;

import java.util.Date;

public class Token {
    private OAuthToken oAuthToken;
    long lastTime;

    public Token(OAuthToken oAuthToken) {
        this.oAuthToken = oAuthToken;
        Date now = new Date();
        lastTime = now.getTime() + oAuthToken.getExpires();
    }

    public OAuthToken getoAuthToken() {
        return oAuthToken;
    }

    public long getLastTime() {
        return lastTime;
    }
}
