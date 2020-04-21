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
                    mobilePhone.printContacts();
                    break;
                case 2:
                    addNewContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    queryContact();
                    break;
                case 6:
                    printActions();
                    break;
            }
        }
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

    private static void addNewContact() {
        System.out.println("Enter the name of the new contact: ");
        String name = scanner.nextLine();
        System.out.println("Enter the phone number: ");
        String phoneNumber = scanner.nextLine();
        Contacts newContact = Contacts.createContact(name, phoneNumber);
        if(mobilePhone.addNewContact(newContact)) {
            System.out.println("New contact added: name = " + name + " phone = " + phoneNumber);
        } else{
            System.out.println("Cannot add " + name + ", already in contacts.");
        }
    }

    private static void updateContact() {
        System.out.println("Enter existing contact name: ");
        String name = scanner.nextLine();
        Contacts existingContactRecord = mobilePhone.queryContact(name);
        if (existingContactRecord == null) {
            System.out.println("Contact not found");
            return;
        }
        System.out.print("Enter new contact name");
        String newName = scanner.nextLine();
        System.out.println("Enter contact new phone number");
        String newPhoneNumber = scanner.nextLine();
        Contacts newContact = Contacts.createContact(newName, newPhoneNumber);
        if (mobilePhone.updateContact(existingContactRecord, newContact)) {
            System.out.println("Contact successfully updated");
        } else {
            System.out.println("Error updating contact");
        }
    }

    private static void removeContact() {
        System.out.println("Enter existing contact name: ");
        String name = scanner.nextLine();
        Contacts existingContactRecord = mobilePhone.queryContact(name);
        if (existingContactRecord == null) {
            System.out.println("Contact not found");
            return;
        }
        if (mobilePhone.removeContact(existingContactRecord)) {
            System.out.println("Contact successfully deleted");
        } else {
            System.out.println("Error deleting contact");
        }
    }

    private static void queryContact() {
        System.out.println("Enter existing contact name: ");
        String name = scanner.nextLine();
        Contacts existingContactRecord = mobilePhone.queryContact(name);
        if (existingContactRecord == null) {
            System.out.println("Contact not found");
            return;
        }
        System.out.println("Contact found. " + " Contact name is " + existingContactRecord.getName() +
                " contact phone number is " + existingContactRecord.getPhoneNumber());
    }

}
