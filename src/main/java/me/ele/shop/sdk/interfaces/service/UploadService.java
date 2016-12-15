package me.ele.shop.sdk.interfaces.service;


import me.ele.shop.sdk.anotation.NopService;
import me.ele.shop.sdk.interfaces.exception.ServiceException;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * eleme.file 图片服务
 */
@NopService(alias = "eleme.file")
public interface UploadService {

    /**
     * 上传图片，返回图片的hash值
     *
     * @param image String 文件内容base64编码值|必选|（文件流编码）
     * @return String
     * @error UNKNOWN_IMAGE_TYPE 未知的图片类型
     */
    String uploadImage(@NotNull(message = "图片内容不能为空") @Size(min = 10, message = "图片内容过短") String image) throws ServiceException;

    /**
     * 通过远程URL上传图片，返回图片的hash值
     *
     * @param url String 远程Url地址|必选|"http://pic.ele.me/123455.jpg"
     * @return String
     * @error NETWORK_EXCEPTION 网络异常
     */
    String uploadImageWithRemoteUrl(@NotNull(message = "url不能为空") @Size(min = 10, message = "url长度过短") String url) throws ServiceException;

    /**
     * 获取上传文件的访问URL，返回文件的Url地址
     *
     * @param hash String 图片hash值|必选|"3077080f760e7bf0fc985e23dd3e36e2png"
     * @return String 文件的Url地址
     */
    String getUploadedUrl(@NotNull(message = "hash不能为空") @Size(min = 10, message = "hash长度过短") String hash) throws ServiceException;
}
