package sdk.interfaces.enumeration.item;

/**
 * 更新商品属性
 */
public enum OItemUpdateProperty {

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
     * List<OSpec> 规格|必选|[{"maxStock":100,"name":"大份","onShelf":1,"packingFee":1.0,"price":19.9,"stock":0},{"maxStock":100,"name":"中分","onShelf":1,"packingFee":1.0,"price":19.9,"stock":0}]
     *
     * @desc ##### 请注意以下事项
     * ###### 1. 规格的属性请填写完整
     * 如果某商品有规格[A]，传入的规格[A]中，价格没有填写
     * 那么更新后的规格[A]的价格会变成默认值0
     * ###### 2. 不填写原有的规格视为删除操作
     * 如果某商品有规格[A,B,C]，传入的规格为[B,C]
     * 那么更新后的结果为[B,C]
     * ###### 3. ID不填视为新建
     * 如果某商品有规格[A]，传入的规格[A']中，其中A的ID填写为0或者不填写，其他A属性一致
     * 那么更新后，商品规格为[A']，原来的A由被删除，A'为新建的规格
     * ###### 4. 填写不存在的规格，视为无效的输入
     * 如果原有商品[A,B]，传入的规格为[A,B],其中A与原来的ID一致。B与原来的ID不一致，且不为0
     * 那么操作会抛出异常。
     */
    specs("规格"),

    sellingTime("售卖时间"),

    attributes("属性");

    private String value;

    private OItemUpdateProperty(String value) {
        this.value = value;
    }
}
