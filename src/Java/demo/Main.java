package demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import sdk.interfaces.entity.order.OOrder;
import sdk.interfaces.exception.ServiceException;
import sdk.interfaces.service.OrderService;
import sdk.oauth.OAuthClient;
import sdk.oauth.Token;

public class Main {

    public static void main(String[] args) throws ServiceException, JsonProcessingException {
        OAuthClient oAuthClient = new OAuthClient();
        // your state
        String state = "";
        String scope = "all";

        String authUrl = oAuthClient.getAuthUrl(state, scope);

        // get code at authUrl
        String code = "";

        // get token and save
        Token token = oAuthClient.getTokenByCode(code);

        // refresh token
        Token freshToken = oAuthClient.getTokenByRefreshToken(token.getRefreshToken(), scope);

        OrderService orderService = new OrderService(freshToken);
        OOrder oOrder = orderService.getOrder("101926455156368216");
    }
}
