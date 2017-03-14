package sdk.interfaces.enumeration.item;

public enum OItemWeekEnum {

    /**
     * 周一
     */
    MONDAY("monday"),

    /**
     * 周二
     */
    TUESDAY("tuesday"),

    /**
     * 周三
     */
    WEDNESDAY("wednesday"),

    /**
     * 周四
     */
    THURSDAY("thurday"),

    /**
     * 周五
     */
    FRIDAY("friday"),

    /**
     * 周六
     */
    SATURDAY("saturday"),

    /**
     * 周日
     */
    SUNDAY("sunday");

    private String description;

    public int getValue() {
        return this.ordinal() + 1;
    }

    OItemWeekEnum(String description) {
        this.description = description;
    }

    public static OItemWeekEnum getWeekByNumber(int week) {
        switch (week) {
            case 1:
                return MONDAY;
            case 2:
                return TUESDAY;
            case 3:
                return WEDNESDAY;
            case 4:
                return THURSDAY;
            case 5:
                return FRIDAY;
            case 6:
                return SATURDAY;
            case 7:
                return SUNDAY;
            default:
                return MONDAY;
        }
    }

    public static int getNumberByWeek(OItemWeekEnum weekEnum) {
        if (weekEnum == MONDAY) {
            return 1;
        } else if (weekEnum == TUESDAY) {
            return 2;
        } else if (weekEnum == WEDNESDAY) {
            return 3;
        } else if (weekEnum == THURSDAY) {
            return 4;
        } else if (weekEnum == FRIDAY) {
            return 5;
        } else if (weekEnum == SATURDAY) {
            return 6;
        } else if (weekEnum == SUNDAY) {
            return 7;
        } else {
            return 0;
        }
    }
}
