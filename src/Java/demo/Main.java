package demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import sdk.interfaces.entity.order.OOrder;
import sdk.interfaces.exception.ServiceException;
import sdk.interfaces.service.OrderService;
import sdk.oauth.Credentials;
import sdk.oauth.Token;

public class Main {

    public static void main(String[] args) throws ServiceException, JsonProcessingException {
        Credentials credentials = new Credentials();
        Token token = credentials.getAccessToken();
        OrderService orderService = new OrderService(token);
        OOrder oOrder = orderService.getOrder("101926455156368216");
    }
}
