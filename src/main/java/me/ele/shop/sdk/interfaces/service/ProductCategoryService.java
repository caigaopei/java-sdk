package me.ele.shop.sdk.interfaces.service;


import me.ele.shop.sdk.anotation.NopService;
import me.ele.shop.sdk.interfaces.entity.category.OCategory;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 商品分类服务
 */
@NopService(alias = "eleme.product.category")
public interface ProductCategoryService {

    List<OCategory> getShopCategories(@NotNull int shopId);

    OCategory getCategory(@NotNull long categoryId);

    OCategory createCategory(@NotNull int shopId, @NotNull String name, @NotNull String description);

    OCategory updateCategory(@NotNull long categoryId, @NotNull String name, @NotNull String description);

    void removeCategory(@NotNull long categoryId);
}
