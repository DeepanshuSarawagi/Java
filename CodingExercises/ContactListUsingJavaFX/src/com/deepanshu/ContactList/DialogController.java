package com.deepanshu.ContactList;

import com.deepanshu.ContactList.dataModel.Contact;
import com.deepanshu.ContactList.dataModel.ContactData;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class DialogController {

    @FXML
    private TextField firstName;

    @FXML
    private TextField lastName;

    @FXML
    private TextField phoneNumber;

    @FXML
    private TextField email;

    public Contact createNewContact() {
        String contactFirstName = firstName.getText().trim();
        String contactLastName = lastName.getText().trim();
        String contactPhoneNumber = phoneNumber.getText().trim();
        String contactEmail = email.getText().trim();
        Contact newContact = new Contact(contactFirstName, contactLastName, contactPhoneNumber, contactEmail);
        ContactData.getInstance().addContact(newContact);
        return newContact;
    }

}
