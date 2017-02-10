package sdk.interfaces.service;

import sdk.annotation.Service;
import sdk.interfaces.entity.shop.OShop;
import sdk.interfaces.entity.shop.OSimpleShop;
import sdk.interfaces.enumeration.shop.OShopProperty;
import sdk.interfaces.exception.ServiceException;
import sdk.oauth.Token;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("eleme.shop")
public class ShopService extends NopService {

    public ShopService(Token token) {
        super(token, ShopService.class);
    }

    public OShop getShop(Long shopId) throws ServiceException {
        Map<String, Object> params = new HashMap();
        params.put("shopId", shopId);
        return call(params);
    }

    public OShop updateShop(Long shopId, Map<OShopProperty, Object> properties) throws ServiceException {
        Map<String, Object> params = new HashMap();
        params.put("shopId", shopId);
        params.put("properties", properties);
        return call(params);
    }

    public Map<Long, OSimpleShop> mgetShopStatus(List<Long> shopIds) throws ServiceException {
        Map<String, Object> params = new HashMap();
        params.put("shopIds", shopIds);
        return call(params);
    }
}
