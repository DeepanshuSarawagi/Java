package com.deepanshu.contacts;

import com.deepanshu.contacts.dataModel.Contact;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;

public class Controller {

    @FXML
    private TableView<Contact> contactsTable;

    @FXML
    private BorderPane mainPanel;

    @FXML
    public void showAddContactDialog() {

    }
}
