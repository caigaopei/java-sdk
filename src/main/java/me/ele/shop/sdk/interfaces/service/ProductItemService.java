package me.ele.shop.sdk.interfaces.service;



import me.ele.shop.sdk.anotation.NopService;
import me.ele.shop.sdk.interfaces.entity.item.OItem;
import me.ele.shop.sdk.interfaces.entity.item.OItemIdWithSpecIds;
import me.ele.shop.sdk.interfaces.enumeration.item.OItemCreateProperty;
import me.ele.shop.sdk.interfaces.enumeration.item.OItemUpdateProperty;
import me.ele.shop.sdk.interfaces.exception.ServiceException;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

/**
 * eleme.product.item 商品服务
 */
@NopService(alias = "eleme.product.item")
public interface ProductItemService {

    /**
     * 获取一个分类下的所有商品
     *
     * @param categoryId long 商品分类Id|必选|26940000135
     * @return Map<Long,OItem> 商品列表
     */
    Map<Long, OItem> getItemsByCategoryId(@NotNull(message = "商品分类Id不能为空") long categoryId) throws ServiceException;

    /**
     * 查询商品详情
     *
     * @param itemId long 商品分类Id|必选|27980000010
     * @return OItem 商品
     */
    OItem getItem(@NotNull(message = "商品分类Id不能为空") long itemId) throws ServiceException;


    /**
     * 批量查询商品详情
     *
     * @param itemIds List<Long> 商品分类Id的列表|必选|"[27980000010,27980000020]"
     * @return Map<Long,OItem> 商品列表
     */
    Map<Long, OItem> batchGetItems(@NotNull(message = "商品分类Id的列表不能为空") List<Long> itemIds) throws ServiceException;

    /**
     * 添加商品
     *
     * @param categoryId long 商品分类Id|必选|26940000135
     * @param properties Map<OItemCreateProperty,Object> 商品属性|必选|"{"description":"美味的食物","imageHash":"3077080f760e7bf0fc985e23dd3e36e2","labels":"{\"isFeatured\":0,\"isGum\":0,\"isNew\":1,\"isSpicy\":1}","name":"牛排","specs":"[{\"specId\":0,\"name\":\"大份\",\"price\":19.9,\"stock\":0,\"maxStock\":100,\"packingFee\":1.0,\"onShelf\":1},{\"specId\":0,\"name\":\"中分\",\"price\":19.9,\"stock\":0,\"maxStock\":100,\"packingFee\":1.0,\"onShelf\":1}]"}"
     * @return OItem 商品
     */
    OItem createItem(@NotNull(message = "商品分类Id不能为空") long categoryId, @NotNull(message = "商品属性不能为空") Map<OItemCreateProperty, Object> properties) throws ServiceException;

    /**
     * 批量添加商品
     *
     * @param categoryId long 商品分类Id|必选|26940000135
     * @param items      List<Map<OItemCreateProperty,Object>> 商品属性的列表|必选|"[{"description":"美味的食物","imageHash":"3077080f760e7bf0fc985e23dd3e36e2","labels":"{\"isFeatured\":0,\"isGum\":0,\"isNew\":1,\"isSpicy\":1}","name":"牛排","specs":"[{\"specId\":0,\"name\":\"大份\",\"price\":19.9,\"stock\":0,\"maxStock\":100,\"packingFee\":1.0,\"onShelf\":1},{\"specId\":0,\"name\":\"中分\",\"price\":19.9,\"stock\":0,\"maxStock\":100,\"packingFee\":1.0,\"onShelf\":1}]"}
     *                   ]"
     * @return Map<Long,OItem> 商品列表
     */
    Map<Long, OItem> batchCreateItems(@NotNull(message = "商品分类Id不能为空") long categoryId, @NotNull(message = "商品属性的列表不能为空") List<Map<OItemCreateProperty, Object>> items) throws ServiceException;

    /**
     * 更新商品
     *
     * @param itemId     long 商品Id|必选|27980000010
     * @param categoryId long 商品分类Id|必选|26940000135
     * @param properties Map<OItemUpdateProperty,Object> 商品属性|必选|"{"description":"美味的食物","imageHash":"3077080f760e7bf0fc985e23dd3e36e2","labels":"{\"isFeatured\":0,\"isGum\":0,\"isNew\":1,\"isSpicy\":1}","name":"牛排","specs":"[{\"specId\":0,\"name\":\"大份\",\"price\":19.9,\"stock\":0,\"maxStock\":100,\"packingFee\":1.0,\"onShelf\":1},{\"specId\":0,\"name\":\"中分\",\"price\":19.9,\"stock\":0,\"maxStock\":100,\"packingFee\":1.0,\"onShelf\":1}]"}"
     * @return OItem 商品列表
     */
    OItem updateItem(@NotNull(message = "商品Id不能为空") long itemId, @NotNull(message = "商品分类Id不能为空") long categoryId, @NotNull(message = "商品属性不能为空") Map<OItemUpdateProperty, Object> properties) throws ServiceException;

    /**
     * 批量置满库存
     *
     * @param specIds List<OItemIdWithSpecIds> 商品及商品规格的列表|必选|"[{"itemId":500029021,"itemSpecIds":[500033026,500033027]},{"itemId":500029020,"itemSpecIds":[500033024,500033025]}]"
     * @return
     */
    void batchFillStock(@NotNull(message = "商品及商品规格的列表不能为空") List<OItemIdWithSpecIds> specIds) throws ServiceException;

    /**
     * 批量沽清库存
     *
     * @param specIds List<OItemIdWithSpecIds> 商品及商品规格的列表|必选|"[{"itemId":500029021,"itemSpecIds":[500033026,500033027]},{"itemId":500029020,"itemSpecIds":[500033024,500033025]}]"
     * @return
     */
    void batchClearStock(@NotNull(message = "商品及商品规格的列表不能为空") List<OItemIdWithSpecIds> specIds) throws ServiceException;

    /**
     * 批量上架商品
     *
     * @param specIds List<OItemIdWithSpecIds> 商品及商品规格的列表|必选|"[{"itemId":500029021,"itemSpecIds":[500033026,500033027]},{"itemId":500029020,"itemSpecIds":[500033024,500033025]}]"
     * @return
     */
    void batchOnShelf(@NotNull(message = "商品及商品规格的列表不能为空") List<OItemIdWithSpecIds> specIds) throws ServiceException;

    /**
     * 批量下架商品
     *
     * @param specIds List<OItemIdWithSpecIds> 商品及商品规格的列表|必选|"[{"itemId":500029021,"itemSpecIds":[500033026,500033027]},{"itemId":500029020,"itemSpecIds":[500033024,500033025]}]"
     * @return
     */
    void batchOffShelf(@NotNull(message = "商品及商品规格的列表不能为空") List<OItemIdWithSpecIds> specIds) throws ServiceException;

    /**
     * 删除商品
     *
     * @param itemId long 商品Id|必选|27980000010
     * @return OItem 商品
     */
    OItem removeItem(@NotNull(message = "商品Id不能为空") long itemId) throws ServiceException;

    /**
     * 批量删除商品
     *
     * @param itemIds List<Long> 商品Id的列表|必选|"[27980000010,27980000020]"
     * @return Map<Long,OItem> 被删除的商品列表
     */
    Map<Long, OItem> batchRemoveItems(@NotNull(message = "商品Id的列表不能为空") List<Long> itemIds) throws ServiceException;
}
