package sdk.interfaces.service;

import sdk.annotation.Service;
import sdk.interfaces.entity.message.OMessage;
import sdk.interfaces.exception.ServiceException;
import sdk.oauth.Token;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("eleme.message")
public class MessageService extends NopService {
    public MessageService(Token token) {
        super(token, MessageService.class);
    }

    public List<OMessage> getNonReachedOMessages(Integer appId) throws ServiceException {
        Map<String, Object> params = new HashMap();
        params.put("appId", appId);
        return call(params);
    }

    public List<String> getNonReachedMessages(Integer appId) throws ServiceException {
        Map<String, Object> params = new HashMap();
        params.put("appId", appId);
        return call(params);
    }
}
