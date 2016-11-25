package me.ele.shop.sdk.interfaces.service;


import me.ele.shop.sdk.anotation.NopService;
import me.ele.shop.sdk.interfaces.entity.other.OMessage;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 消息服务
 */
@NopService(alias = "eleme.message")
public interface MessageService {
    /**
     * 获取推送未到达的消息列表，单次最多返回50条
     * @param appId
     * @return
     */
    List<OMessage> getNonReachedMessages(@NotNull int appId);
}
