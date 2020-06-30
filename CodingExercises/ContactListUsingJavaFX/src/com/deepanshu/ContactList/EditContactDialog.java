package com.deepanshu.ContactList;

import com.deepanshu.ContactList.dataModel.Contact;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class EditContactDialog {
    @FXML
    private TextField firstName;

    @FXML
    private TextField lastName;

    @FXML
    private TextField phoneNumber;

    @FXML
    private TextField email;

    public void editContact(Contact contact) {
        String updatedFirstName = firstName.getText().trim();
        String updatedLastName = lastName.getText().trim();
        String updatedPhoneNumber = phoneNumber.getText().trim();
        String updatedEmail = email.getText().trim();

        if (firstName.getText().length() > 0) {
            contact.setFirstName(updatedFirstName);
        }

        if (updatedLastName.length()>0) {
            contact.setLastName(updatedLastName);
        }

        if (updatedPhoneNumber.length()>0) {
            contact.setPhoneNumber(updatedPhoneNumber);
        }

        if (updatedEmail.length()>0) {
            contact.setEmail(updatedEmail);
        }
    }
}
