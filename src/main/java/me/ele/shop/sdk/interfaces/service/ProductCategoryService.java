package me.ele.shop.sdk.interfaces.service;


import me.ele.shop.sdk.anotation.NopService;
import me.ele.shop.sdk.interfaces.entity.category.OCategory;
import me.ele.shop.sdk.interfaces.exception.ServiceException;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * eleme.product.category 商品分类服务
 */
@NopService(alias = "eleme.product.category")
public interface ProductCategoryService {

    /**
     * 查询店铺商品分类
     *
     * @param shopId int 店铺Id|必选|987777
     * @return List<OCategory>
     */
    List<OCategory> getShopCategories(@NotNull(message = "店铺Id不能为空") int shopId) throws ServiceException;


    /**
     * 查询商品分类详情
     *
     * @param categoryId long 商品分类Id|必选|26940000135
     * @return OCategory
     */
    OCategory getCategory(@NotNull(message = "商品分类Id不能为空") long categoryId) throws ServiceException;

    /**
     * 添加商品分类
     *
     * @param shopId      int 店铺Id|必选|987777
     * @param name        String 商品分类名称|必选|蛋炒饭
     * @param description String 商品分类描述|必选|一道美味的炒饭
     * @return OCategory
     */
    OCategory createCategory(@NotNull(message = "店铺Id不能为空") int shopId, @NotNull(message = "商品分类名称不能为空") String name, @NotNull(message = "商品分类描述不能为空") String description) throws ServiceException;

    /**
     * 更新商品分类
     *
     * @param categoryId  long 商品分类Id|必选|26940000135
     * @param name        String 商品分类名称|必选|蛋炒饭
     * @param description String 商品分类描述|必选|一道美味的炒饭
     * @return OCategory
     */
    OCategory updateCategory(@NotNull(message = "商品分类Id不能为空") long categoryId, @NotNull(message = "商品分类名称不能为空") String name, @NotNull(message = "商品分类描述不能为空") String description) throws ServiceException;

    /**
     * 删除商品分类
     *
     * @param categoryId long 商品分类Id|必选|26940000135
     */
    void removeCategory(@NotNull(message = "商品分类Id不能为空") long categoryId) throws ServiceException;
}
