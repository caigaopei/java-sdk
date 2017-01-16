package sdk.interfaces.service;

import sdk.annotation.Service;
import sdk.interfaces.entity.order.OOrder;
import sdk.interfaces.enumeration.order.OInvalidateType;
import sdk.interfaces.exception.ServiceException;
import sdk.oauth.Token;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("eleme.order")
public class OrderService extends NopService {

    public OrderService(Token token) {
        super(token, OrderService.class);
    }

    public OOrder getOrder(String orderId) throws ServiceException {
        Map<String, Object> params = new HashMap();
        params.put("orderId", orderId);
        return call(params);
    }

    public Map<String, OOrder> mgetOrders(List<String> orderIds) throws ServiceException {
        Map<String, Object> params = new HashMap();
        params.put("orderIds", orderIds);
        return call(params);
    }

    public OOrder confirmOrder(String orderId) throws ServiceException {
        Map<String, Object> params = new HashMap();
        params.put("orderId", orderId);
        return call(params);
    }

    public OOrder cancelOrder(String orderId, OInvalidateType type, String remark) throws ServiceException {
        Map<String, Object> params = new HashMap();
        params.put("orderId", orderId);
        params.put("type", type);
        params.put("remark", remark);
        return call(params);
    }

    public OOrder agreeRefund(String orderId) throws ServiceException {
        Map<String, Object> params = new HashMap();
        params.put("orderId", orderId);
        return call(params);
    }

    public OOrder disagreeRefund(String orderId, String reason) throws ServiceException {
        Map<String, Object> params = new HashMap();
        params.put("orderId", orderId);
        params.put("reason", reason);
        return call(params);
    }

    public List<String> getShopOrderIds(Integer size, Integer offset, Integer shopId, String beginDate, String endDate) throws ServiceException {
        Map<String, Object> params = new HashMap();
        params.put("size", size);
        params.put("offset", offset);
        params.put("shopId", shopId);
        params.put("beginDate", beginDate);
        params.put("endDate", endDate);
        return call(params);
    }
}
