package me.ele.shop.sdk.interfaces.enumeration.order;

public enum TOrderRefundStatus {
    NO_REFUND(0),
    EARLY_REFUND_SUCCESS(1),
    LATER_REFUND_REQUEST(2),
    LATER_REFUND_RESPONSE(3),
    LATER_REFUND_ARBITRATING(4),
    LATER_REFUND_FAIL(5),
    LATER_REFUND_SUCCESS(6),
    REFUND_MARK(99);

    private final int value;

    private TOrderRefundStatus(int value) {
        this.value = value;
    }

    /**
     * Find a the enum type by its integer value, as defined in the Thrift IDL.
     *
     * @return null if the value is not found.
     */
    public static TOrderRefundStatus findByValue(int value) {
        switch (value) {
            case 0:
                return NO_REFUND;
            case 1:
                return EARLY_REFUND_SUCCESS;
            case 2:
                return LATER_REFUND_REQUEST;
            case 3:
                return LATER_REFUND_RESPONSE;
            case 4:
                return LATER_REFUND_ARBITRATING;
            case 5:
                return LATER_REFUND_FAIL;
            case 6:
                return LATER_REFUND_SUCCESS;
            case 99:
                return REFUND_MARK;
            default:
                return null;
        }
    }

    /**
     * Get the integer value of this enum value, as defined in the Thrift IDL.
     */
    public int getValue() {
        return value;
    }
}
