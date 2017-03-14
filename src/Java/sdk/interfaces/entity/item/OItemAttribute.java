package sdk.interfaces.entity.item;


import java.util.List;

/**
 * 商品属性
 */
public class OItemAttribute {

    /**
     * 属性名称|必选|"甜度"
     */
    String name;

    /**
     * 属性明细|必选|["5分甜","7分甜"]
     */
    List<String> details;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getDetails() {
        return details;
    }

    public void setDetails(List<String> details) {
        this.details = details;
    }
}
