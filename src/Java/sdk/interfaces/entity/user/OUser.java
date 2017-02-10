package sdk.interfaces.entity.user;

import java.util.List;

public class OUser {
    private String userId;
    private String userName;
    private List<OAuthorizedShop> authorizedShops;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<OAuthorizedShop> getAuthorizedShops() {
        return authorizedShops;
    }

    public void setAuthorizedShops(List<OAuthorizedShop> authorizedShops) {
        this.authorizedShops = authorizedShops;
    }
}
