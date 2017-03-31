package sdk.interfaces.entity.order;

public class OGroupItemSpec {
    /**
     * String 规格名称||"杯型"
     */
    private String name;
    /**
     * String 规格值||"大杯"
     */
    private String value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
