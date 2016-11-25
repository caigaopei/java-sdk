package me.ele.shop.sdk.util;

import me.ele.shop.sdk.Config;
import me.ele.shop.sdk.interfaces.entity.other.OMessage;

/**
 * 回调签名校验工具类
 */
public class CallbackValidationUtil {
    /**
     * 通过哈希一个摘要，校验消息是否合法或者被篡改
     *
     * @param message
     * @return
     */
    public static boolean isValidMessage(OMessage message) {
        if (message == null) {
            return false;
        }
        if (message.getSignature() == null) {
            return false;
        }
        String str = String.format("%s%s%s%s%s", message.getType(), message.getMessage(), message.getRequest_id(), message.getShop_id(), message.getTimestamp(), Config.getSecret());
        String signature = SignatureUtil.md5(str);
        return signature.toUpperCase().equals(message.getSignature().toUpperCase());
    }
}
