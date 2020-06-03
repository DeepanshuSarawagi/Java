package com.company;

import java.util.HashMap;
import java.util.Map;

public class StockList {
    private final Map<String, StockItem> list;

    public StockList() {
        this.list = new HashMap<>();
    }

    public int addStock(StockItem item) {
        if (item != null) {
            // check if we already have quantities of this item
            StockItem inStock = list.getOrDefault(item.getName(), item);  // this is going to get the item if it exists
                                                                          // in the list or it will get the item which
                                                                          // we passed as a parameter.
            System.out.println(inStock);
            // if there are already stocks on this item, adjust the stock
            if (inStock != item) {      // to check if the item which inStock has is same as what we passed as parameter.
                                        // If its not same, then adjust the quantity of stock of the item since its
                                        // already there in the list
                item.adjustStock(inStock.getQuantityStock());
            }
            list.put(item.getName(), item);
            return item.getQuantityStock();
        }
        return 0;
    }
}
