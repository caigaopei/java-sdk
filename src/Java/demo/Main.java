package demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import sdk.interfaces.entity.order.OOrder;
import sdk.interfaces.exception.ServiceException;
import sdk.interfaces.service.OrderService;
import sdk.oauth.OAuthClient;
import sdk.oauth.Token;

public class Main {
    public static void main(String[] args) throws ServiceException, JsonProcessingException {

    }

    public static void enterprise() throws ServiceException {
        OAuthClient oAuthClient = new OAuthClient();

        // init data
        String state = "";
        String scope = "all";
        String authUrl = oAuthClient.getAuthUrl(state, scope);

        // get code at authUrl
        String code = "";

        // get token and save
        Token token = oAuthClient.getTokenByCode(code);

        // call service
        OrderService orderService = new OrderService(token);
        OOrder oOrder = orderService.getOrder("101926455156368216");

        // refresh token when token expired
        Token freshToken = oAuthClient.getTokenByRefreshToken(token.getRefreshToken(), scope);
    }

    public static void clientCredentials() throws ServiceException {
        OAuthClient oAuthClient = new OAuthClient();
        // get token and save
        Token token = oAuthClient.getTokenInClientCredentials();

        // call service
        OrderService orderService = new OrderService(token);
        OOrder oOrder = orderService.getOrder("101926455156368216");
    }
}
