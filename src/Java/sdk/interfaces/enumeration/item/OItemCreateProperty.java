package sdk.interfaces.enumeration.item;

/**
 * 创建商品属性
 */
public enum OItemCreateProperty {

    /**
     * String 商品名称|必选|"白切鸡"
     */
    name("商品名称"),

    /**
     * String 商品描述|可选|"香脆可口，外焦里嫩"
     */
    description("商品描述"),

    /**
     * String 图片imageHash|可选|"3077080f760e7bf0fc985e23dd3e36e2"
     */
    imageHash("图片imageHash"),

    /**
     * OLabel 标签属性集合|可选|{"isFeatured":0,"isGum":0,"isNew":1,"isSpicy":1}
     */
    labels("标签属性集合"),

    /**
     * List<OSpec> 规格|必选|[{"maxStock":100,"name":"大份","onShelf":1,"packingFee":1.0,"price":19.9, "stock":0},{"maxStock":100,"name":"中分","onShelf":1,"packingFee":1.0,"price":19.9,"stock":0}]
     *
     * @desc 此处创建的时候，specId不需要填写，如果填写0，也可以正常创建
     */
    specs("规格"),

    sellingTime("售卖时间"),

    attributes("属性");

    private String value;

    private OItemCreateProperty(String value) {
        this.value = value;
    }
}
