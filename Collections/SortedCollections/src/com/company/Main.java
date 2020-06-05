package com.company;

import java.util.Map;

public class Main {
    private static StockList stockList = new StockList();
    public static void main(String[] args) {
        StockItem temp = new StockItem("bread", 40, 100);
        stockList.addStock(temp);

        temp = new StockItem("cake", 100, 20);
        stockList.addStock(temp);

        temp = new StockItem("car", 50.5, 2);
        stockList.addStock(temp);

        temp = new StockItem("chair", 1000.98, 20);
        stockList.addStock(temp);

        temp = new StockItem("cup", 65.0, 200);
        stockList.addStock(temp);
        temp = new StockItem("cup", 65.0, 7);
        stockList.addStock(temp);

        temp = new StockItem("door", 72.95, 4);
        stockList.addStock(temp);

        temp = new StockItem("juice", 55.5, 36);
        stockList.addStock(temp);

        temp = new StockItem("phone", 10500.59, 35);
        stockList.addStock(temp);

        temp = new StockItem("towel", 99.99, 80);
        stockList.addStock(temp);

        temp = new StockItem("vase", 87.6, 40);
        stockList.addStock(temp);

        System.out.println(stockList);

        System.out.println("==================================");
        for (String s : stockList.Items().keySet()) {
            System.out.println(s);
        }

        Basket deepsBasket = new Basket("Deep");
        sellItem(deepsBasket, "car", 1);
        System.out.println(deepsBasket);

        sellItem(deepsBasket, "car", 1);
        System.out.println(deepsBasket);

        sellItem(deepsBasket, "car", 1);
        System.out.println(deepsBasket);

        sellItem(deepsBasket, "juice", 5);
        sellItem(deepsBasket, "cup", 10);
        sellItem(deepsBasket, "bread", 2);
        System.out.println(deepsBasket);
        System.out.println("Updated Stock list");
        System.out.println(stockList);

    }

    public static int sellItem(Basket basket, String item, int quantity) {
        StockItem stockItem = stockList.get(item);
        if (stockItem == null) {
            System.out.println("We dont sell this item here " + item + ".");
            return 0;
        }

        if (stockList.reserveStock(item, quantity) != 0) {
            return basket.addToBasket(stockItem, quantity);
        }
        return 0;
    }

    public static int removeItem(Basket basket, String item, int quantity) {
        StockItem stockItem = stockList.get(item);
        if (stockItem == null) {
            System.out.println("We dont sell this item here " + item + ".");
            return 0;
        }

        if (basket.removeFromBasket(stockItem, quantity) == quantity) {
            return stockList.unreserveStock(item, quantity);
        }
        return 0;
    }

    public static void checkOut(Basket basket) {
        for (Map.Entry<StockItem, Integer> item: basket.Items().entrySet()) {
            stockList.sellStock(item.getKey().getName(), item.getValue());
        }
        basket.clearBasket();
    }
}
