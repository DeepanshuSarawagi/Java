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

    public void modifyGroceryItem(String CurrentItem, String newItem) {
        int position = findItem(CurrentItem);
        if(position >= 0) {
            modifyGroceryItem(position, newItem);
        }
    }

    private void modifyGroceryItem(int position, String item) {
        groceryList.set(position, item);
        System.out.println("Grocery item " + (position + 1) + " was modified to " + groceryList.get(position));
    }

    public void removeGroceryItem(String item) {
        int position = findItem(item);
        if(position >= 0) {
            removeGroceryItem(position);
        }
    }

    private void removeGroceryItem(int position) {
        groceryList.remove(position);
    }

    private int findItem(String searchItem) {
        return groceryList.indexOf(searchItem);
    }

    public boolean onFile(String searchItem) {
        int position = findItem(searchItem);
        return position >= 0;
    }
}
