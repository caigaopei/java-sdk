package demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import sdk.interfaces.entity.order.OOrder;
import sdk.interfaces.exception.ServiceException;
import sdk.interfaces.service.OrderService;
import sdk.oauth.ClientCredentials;
import sdk.oauth.Token;

public class Main {

    public static void main(String[] args) throws ServiceException, JsonProcessingException {
        ClientCredentials clientCredentials = new ClientCredentials();
        Token token = clientCredentials.getAccessToken();
        OrderService orderService = new OrderService(token);
        OOrder oOrder = orderService.getOrder("101926455156368216");
    }
}
