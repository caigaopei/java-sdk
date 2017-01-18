package sdk.interfaces.service;

import sdk.annotation.Service;
import sdk.interfaces.entity.user.OUser;
import sdk.interfaces.exception.ServiceException;
import sdk.oauth.Token;

import java.util.HashMap;
import java.util.Map;

@Service("eleme.user")
public class UserService extends NopService {

    public UserService(Token token) {
        super(token, UserService.class);
    }

    public OUser getUser() throws ServiceException {
        Map<String, Object> params = new HashMap();
        return call(params);
    }
}
