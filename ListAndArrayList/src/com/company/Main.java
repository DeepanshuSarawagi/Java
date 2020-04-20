package com.company;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static GroceryList groceryList = new GroceryList();

    public static void main(String[] args) {
        boolean quit = false;
        int choice = 0;
        printInstructions();

        while (!quit) {
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    printInstructions();
                    break;
                case 1:
                    groceryList.printGroceryList();
                    break;
                case 2:
                    addItem();
                    break;
                case 3:
                    modifyItem();
                    break;
                case 4:
                    removeItem();
                    break;
                case 5:
                    searchItem();
                    break;
                case 6:
                    quit = true;
                    break;

            }
        }
    }

    public static void printInstructions() {
        System.out.println("\nPress Enter");
        System.out.println("\t 0 - To print choice items");
        System.out.println("\t 1 - To print the list of grocery list items");
        System.out.println("\t 2 - To add an item to the grocery list");
        System.out.println("\t 3 - To modify an item to the grocery list");
        System.out.println("\t 4 - To remove an item to the grocery list");
        System.out.println("\t 5 - To search an item to the grocery list");
        System.out.println("\t 6 - To quit the application");
    }

    public static void addItem(){
        System.out.print("Enter the item you want to add to the list: ");
        String item = scanner.next();
        groceryList.addGroceryItem(item);
    }

    public static void modifyItem() {
        System.out.print("Enter the item number");
        int itemNumber = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter replacement item");
        String newItem = scanner.nextLine();
        groceryList.modifyGroceryItem(itemNumber-1, newItem);
    }

    public static void removeItem() {
        System.out.print("Enter the item number");
        int itemNumber = scanner.nextInt();
        scanner.nextLine();
        groceryList.removeGroceryItem(itemNumber-1);
    }

    public static void searchItem() {
        System.out.print("Item to search for: ");
        String searchItem = scanner.nextLine();
        if (groceryList.findItem(searchItem) != null) {
            System.out.println("Found " + searchItem + " in the grocery list");
        } else {
            System.out.println(searchItem + " not found in the grocery list");
        }
    }
}
