package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Player deep = new Player("Deep", 10, 15);
        System.out.println(deep.toString());
    }

    public static ArrayList<String> readValues() {
        ArrayList<String> values = new ArrayList<>();

        Scanner scanner = new Scanner((System.in));
        boolean quit = false;
        int index = 0;
        System.out.println("Choose " + "\n" +
                "1- to enter a string " + "\n" +
                "0- to quit");
        while (!quit) {
            System.out.println("Choose an action: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    System.out.println("Enter a string: ");
                    String stringInput = scanner.nextLine();
                    values.add(index, stringInput);
                    index++;
                    break;
            }
        }
        return values;
    }

    public static void saveObject(ISaveable objectToSave) {
        for (int i=0; i<objectToSave.writeData().size(); i++) {
            System.out.println("Saving object " + objectToSave.writeData().get(i) + " to storage device");

        }
    }

    public static void loadObject(ISaveable objectToLoad) {
        ArrayList<String> values = readValues();
        objectToLoad.read(values);
    }

}
