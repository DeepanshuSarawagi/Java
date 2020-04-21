package com.company;

import java.util.ArrayList;

public class MobilePhone {
    private String myNumber;
    private ArrayList<Contacts> myContacts;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<Contacts>();
    }

    public boolean addNewContact(Contacts contacts) {
        if(findContact(contacts.getName()) >= 0) {
            System.out.println("Contact is already on file");
            return false;
        }
        myContacts.add(contacts);
        return true;
    }

    public boolean updateContact(Contacts oldContact, Contacts newContact) {
        int findPosition = findContact(oldContact);
        if (findPosition < 0) {
            System.out.println(oldContact.getName() + ", was not found in the contact list.");
            return false;
        }
        this.myContacts.set(findPosition, newContact);
        System.out.println(oldContact.getName() + ", was replaced with new contact " + newContact.getName());
        return true;
    }

    public boolean removeContact(Contacts contacts) {
        int findPosition = findContact(contacts);
        if (findPosition < 0) {
            System.out.println(contacts.getName() + ", was not found in the contact list.");
            return false;
        }
        this.myContacts.remove(findPosition);
        System.out.println(contacts.getName() + ", was removed from the contact list.");
        return true;
    }

    private int findContact(Contacts contacts) {
        return this.myContacts.indexOf(contacts);
    }

    private int findContact(String contactName) {
        for (int i =0; i < this.myContacts.size(); i++) {
            Contacts contacts = this.myContacts.get(i);
            if(contacts.getName().equals(contactName)) {
                return i;
            }
        }
        return -1;
    }

    public String queryContact(Contacts contacts) {
        if (findContact(contacts) > 0 ) {
            return contacts.getName();
        }
        return null;
    }

    public Contacts queryContact(String name) {
        int position = findContact(name);
        if (position >= 0) {
            return this.myContacts.get(position);
        }
        return null;
    }

    public void printContacts() {
        System.out.println("Printing contacts");
        for (int i= 0; i < this.myContacts.size(); i++) {
            System.out.println((i + 1) + ". " + this.myContacts.get(i).getName() + " --> " +
                    this.myContacts.get(i).getPhoneNumber());
        }
    }
}
