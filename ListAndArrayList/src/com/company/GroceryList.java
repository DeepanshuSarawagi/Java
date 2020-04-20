package com.company;

import java.util.ArrayList;

public class GroceryList {
    private ArrayList<String> groceryList = new ArrayList<>();  // define an ArrayList

    public void addGroceryItem(String item) {
        groceryList.add(item);  // use the ArrayList.add() method to add an item in the ArrayList
    }
    public void printGroceryList() {
        System.out.println("You have " + groceryList.size() + " items in the grocery list");
        for (int i = 0; i < groceryList.size(); i++) {
            System.out.println((i+1) + ". " + groceryList.get(i));
        }
    }

    public void modifyGroceryItem(int position, String item) {
        groceryList.set(position, item);
        System.out.println("Grocery item " + (position + 1) + " was modified to " + groceryList.get(position));
    }

    public void removeGroceryItem(int position) {
        String item = groceryList.get(position);
        groceryList.remove(item);
    }

    public String findItem(String searchItem) {
        int position = groceryList.indexOf(searchItem);
        if (position >= 0) {
            return groceryList.get(position);
        }
        return null;
    }
}
