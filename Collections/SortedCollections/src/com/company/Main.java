package com.company;

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
    }
}
