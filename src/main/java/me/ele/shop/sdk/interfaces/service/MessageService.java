package me.ele.shop.sdk.interfaces.service;


import me.ele.shop.sdk.anotation.NopService;

import javax.sql.rowset.serial.SerialException;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * eleme.message 消息服务
 */
@NopService(alias = "eleme.message")
public interface MessageService {

    /**
     * 获取推动未到达的消息
     *
     * @param appId int 应用ID|必选|73987374
     * @return List<String>
     */
    List<String> getNonReachedMessages(@NotNull(message = "应用ID不能为空") int appId) throws SerialException;
}
