package me.ele.shop.sdk.interfaces.enumeration.order;

/**
 * Enums
 */
public enum TOrderStatus {
    RISK_REJECT(-6),
    NOT_PAID(-5),
    PAYMENT_FAIL(-4),
    PAYING(-3),
    PENDING(-2),
    INVALID(-1),
    UNPROCESSED(0),
    PROCESSING(1),
    PROCESSED_AND_VALID(2),
    REFUNDING(3),
    SETTLED(9);

    private final int value;

    private TOrderStatus(int value) {
        this.value = value;
    }

    /**
     * Find a the enum type by its integer value, as defined in the Thrift IDL.
     *
     * @return null if the value is not found.
     */
    public static TOrderStatus findByValue(int value) {

        for (TOrderStatus status : values()) {
            if (status.getValue() == value) {
                return status;
            }
        }

        return null;
    }

    /**
     * Get the integer value of this enum value, as defined in the Thrift IDL.
     */
    public int getValue() {
        return value;
    }
}