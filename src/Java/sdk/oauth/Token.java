package sdk.oauth;

import java.util.Date;

public class Token {
    private AccessToken accessToken;
    long lastTime;

    public Token(AccessToken accessToken) {
        this.accessToken = accessToken;
        Date now = new Date();
        lastTime = now.getTime() + accessToken.getExpires();
    }

    public AccessToken getAccessToken() {
        return accessToken;
    }

    public long getLastTime() {
        return lastTime;
    }
}
