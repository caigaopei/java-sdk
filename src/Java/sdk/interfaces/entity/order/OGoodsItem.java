package sdk.interfaces.entity.order;

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
}
