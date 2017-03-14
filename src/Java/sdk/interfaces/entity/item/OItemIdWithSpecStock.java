package sdk.interfaces.entity.item;

import java.util.Map;

/**
 * 商品以及商品库存
 */
public class OItemIdWithSpecStock {

    /**
     * 商品Id|必选|27970000058
     */
    private long itemId;

    /**
     * 商品规格Id以及对应的库存|必选|[{"100277543419":1000},{"100277543420":500}]
     */
    private Map<Long, Integer> stockMap;

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public Map<Long, Integer> getStockMap() {
        return stockMap;
    }

    public void setStockMap(Map<Long, Integer> stockMap) {
        this.stockMap = stockMap;
    }
}
