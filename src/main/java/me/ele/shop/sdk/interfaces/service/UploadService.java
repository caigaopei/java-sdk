package me.ele.shop.sdk.interfaces.service;


import me.ele.shop.sdk.anotation.NopService;

import javax.validation.constraints.NotNull;

/**
 * 图片服务
 */
@NopService(alias = "eleme.file")
public interface UploadService {
    /**
     * 上传图片
     *
     * @param image 将图片数据base64编码后得到的字符串
     * @return 图片上传后，得到一个字符串格式的图片标识，根据此标识可以获取图片的访问URL
     */
    String uploadImage(@NotNull String image);

    /**
     * 通过远程URL上传图片
     *
     * @param url 图片地址
     * @return
     */
    String uploadImageWithRemoteUrl(@NotNull String url);

    /**
     * 获取上传文件的访问URL
     *
     * @param hash 调用上传图片接口得到的返回值
     * @return
     */
    String getUploadedUrl(@NotNull String hash);
}
