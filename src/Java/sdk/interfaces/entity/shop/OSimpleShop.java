package sdk.interfaces.entity.shop;

/**
 * 店铺简要
 */
public class OSimpleShop {

    /**
     * 店铺Id||988887
     */
    private int id;

    /**
     * 是否开店||1
     */
    private int isOpen;

    /**
     * 是否有效||1
     */
    private int isValid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIsOpen() {
        return isOpen;
    }

    public void setIsOpen(int isOpen) {
        this.isOpen = isOpen;
    }

    public int getIsValid() {
        return isValid;
    }

    public void setIsValid(int isValid) {
        this.isValid = isValid;
    }
}
