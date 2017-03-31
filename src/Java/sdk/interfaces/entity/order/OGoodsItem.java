package sdk.interfaces.entity.order;

import java.util.List;

/**
 * 篮子商品
 */
public class OGoodsItem {

    /**
     * 篮子商品Id（根据篮子商品的类型取不同的值）||27970000058
     *
     * @desc | 值 | 值含义 |
     * | --- | --- |
     * | 商品Id | 等价于OItem中的Id |
     * | -10 | 配送费 |
     * | -70000 | 餐盒费 |
     * | -90000 | 限时抢购 |
     */
    private long id;

    /**
     * 商品规格Id(与规格中的specId相同)||1234567890
     */
    private Long skuId;

    /**
     * 商品名称||"奶茶"
     */
    private String name = "";

    /**
     * 订单中商品项的标识(注意，此处不是商品分类Id)||1
     *
     * @desc | 值 | 值含义 |
     * | --- | --- |
     * | 11 | 美食活动 |
     * | 12 | 餐厅活动 |
     * | 13 | 红包 |
     * | 2 | 配送费 |
     * | 102 | 餐盒费 |
     * |  1 | 商品 |
     */
    private long categoryId = 0;

    /**
     * 商品单价||9.0
     */
    private double price = 0.0;

    /**
     * 商品数量||2
     */
    private int quantity = 0;

    /**
     * 总价||18.0
     */
    private double total = 0.0;

    /**
     * List<OGroupItemSpec> 多规格||[{"name":"杯型": "value":"大杯"},{"name":"是否加糖", "value": "加糖"}]
     */
    private List<OGroupItemSpec> newSpecs;

    /**
     * List<OGroupItemAttribute> 多属性||[{"name":"辣度", "value":"微辣"},{"name":"加冰", "value": "少冰"}]
     */
    private List<OGroupItemAttribute> attributes;

    /**
     * String 商品扩展码||"12345678"
     */
    private String extendCode;

    /**
     * String 商品条形码||"12345678"
     */
    private String barCode;

    /**
     * Double 商品重量(单位克)||500
     */
    private Double weight;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public List<OGroupItemSpec> getNewSpecs() {
        return newSpecs;
    }

    public void setNewSpecs(List<OGroupItemSpec> newSpecs) {
        this.newSpecs = newSpecs;
    }

    public List<OGroupItemAttribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<OGroupItemAttribute> attributes) {
        this.attributes = attributes;
    }

    public String getExtendCode() {
        return extendCode;
    }

    public void setExtendCode(String extendCode) {
        this.extendCode = extendCode;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }
}
