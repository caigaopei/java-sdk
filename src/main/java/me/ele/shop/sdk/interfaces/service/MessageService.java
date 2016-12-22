package me.ele.shop.sdk.interfaces.service;



import me.ele.shop.sdk.anotation.NopService;
import me.ele.shop.sdk.interfaces.entity.message.OMessage;
import me.ele.shop.sdk.interfaces.exception.ServiceException;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * eleme.message 消息服务
 */
@NopService(alias = "eleme.message")
public interface MessageService {

    /**
     * 获取未到达的推送消息
     *
     * @param appId int 应用ID|必选|73987374
     * @return List<OMessage> 消息列表
     * @desc 推送成功的消息系统会给以标记成功，该接口用于获取未标记成功的消息，每次返回最多10条。返回的消息在接口调用后会标记为已经推送。
     */
    List<OMessage> getNonReachedMessages(@NotNull(message = "应用ID不能为空") Integer appId) throws ServiceException;
}
