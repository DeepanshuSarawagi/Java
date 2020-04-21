package com.company;

import java.security.UnrecoverableEntryException;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone("335 242 232");


    public static void main(String[] args) {
        boolean quit = false;
        startPhone();
        printActions();
        while (!quit) {
            System.out.println("Enter action (6: to show available actions)");
            int action = scanner.nextInt();
            scanner.nextLine();
            switch (action) {
                case 0:
                    System.out.println("Shutting down...");
                    quit = true;
                    break;
                case 1:
                    printContacts();
                    break;
            }
        }
    }

    private static void printContacts() {
        mobilePhone.printContacts();
    }

    private static void startPhone() {
        System.out.println("Starting phone....");
    }

    private static void printActions() {
        System.out.println("\nAvailable actions:\nPress");
        System.out.println(" 0 - to shut down phone");
        System.out.println(" 1 - to print contacts");
        System.out.println(" 2 - to add the new contact");
        System.out.println(" 3 - to update a contact");
        System.out.println(" 4 - to remove an existing contact");
        System.out.println(" 5 - to find a contact");
        System.out.println(" 6 - to print the list of available actions");
        System.out.println("Choose your action");
    }
}
