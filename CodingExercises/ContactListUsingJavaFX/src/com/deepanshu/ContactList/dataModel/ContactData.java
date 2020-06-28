package com.deepanshu.ContactList.dataModel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;

public class ContactData {
    private ObservableList<Contact> contactsList;
    private static ContactData instance = new ContactData();
    private static String filename = "contacts.txt";

    public static ContactData getInstance() {
        return instance;
    }

    public ObservableList<Contact> getContactList() {
        return contactsList;
    }

    public void loadData() throws IOException {
        contactsList = FXCollections.observableArrayList();
        Path path = Paths.get(filename);

        try (BufferedReader br = Files.newBufferedReader(path)) {
            String input;
            while ((input = br.readLine()) != null) {
                String[] strings = input.split("\t");
                String FirstName = strings[0];
                String LastName = strings[1];
                String PhoneNumber = strings[2];
                String Email = strings[3];

                Contact contact = new Contact(FirstName, LastName, PhoneNumber, Email);
                contactsList.add(contact);
            }
        }
    }

    public void saveData() throws IOException {
        Path path = Paths.get(filename);
        try (BufferedWriter bw = Files.newBufferedWriter(path)) {
            Iterator<Contact> iterator = contactsList.iterator();
            while (iterator.hasNext()) {
                Contact contact = iterator.next();
                bw.write(String.format("%s\t%s\t%s\t%s",
                        contact.getFirstName(),
                        contact.getLastName(),
                        contact.getPhoneNumber(),
                        contact.getEmail()));
                bw.newLine();
            }
        }
    }
}
