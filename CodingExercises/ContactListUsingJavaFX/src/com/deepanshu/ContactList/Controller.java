package com.deepanshu.ContactList;

import com.deepanshu.ContactList.dataModel.Contact;
import com.deepanshu.ContactList.dataModel.ContactData;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

import java.util.ArrayList;
import java.util.List;

public class Controller {
//    private List<Contact> contacts;

    private ObservableList<Contact> contacts = ContactData.getInstance().getContactList();

    @FXML
    private TableView<Contact> tableView;


    @FXML
    private TableColumn<Contact, String> firstNameColumn;

    @FXML
    private TableColumn<Contact, String> lastNameColumn;

    @FXML
    private TableColumn<Contact, String> phoneNumberColumn;

    @FXML
    private TableColumn<Contact, String> emailColumn;


//    public TableView<Contact> getTableView() {
//        return tableView;
//    }

    public void initialize() {
//        Contact contact1 = new Contact("Deepanshu", "Sarawagi", "123456",
//                "contact1@example.com");
//        Contact contact2 = new Contact("Divya", "Sarawagi", "123456",
//                "contact1@example.com");
//
//        contacts.add(contact1);
//        contacts.add(contact2);
//
        tableView.setItems(contacts);
        tableView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        tableView.getSelectionModel().selectFirst();
        firstNameColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Contact, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Contact, String> contactStringCellDataFeatures) {
                return contactStringCellDataFeatures.getValue().firstNameProperty();
            }
        });
        lastNameColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Contact, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Contact, String> contactStringCellDataFeatures) {
                return contactStringCellDataFeatures.getValue().lastNameProperty();
            }
        });

        phoneNumberColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Contact, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Contact, String> contactStringCellDataFeatures) {
                return contactStringCellDataFeatures.getValue().phoneNumberProperty();
            }
        });

        emailColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Contact, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Contact, String> contactStringCellDataFeatures) {
                return contactStringCellDataFeatures.getValue().emailProperty();
            }
        });

        tableView.getColumns().setAll(firstNameColumn, lastNameColumn, phoneNumberColumn, emailColumn);
    }

    public void showNewContactDialog() {

    }

}
