package com.deepanshu.ContactList;

import com.deepanshu.ContactList.dataModel.Contact;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;
import java.util.List;

public class Controller {
//    private List<Contact> contacts;

    private ObservableList<Contact> contacts = getCon

    private TableView<Contact> tableView = new TableView<>();


    @FXML
    private TableColumn firstNameColumn;


    public TableView<Contact> getTableView() {
        return tableView;
    }

    public void initialize() {
        Contact contact1 = new Contact("Deepanshu", "Sarawagi", "123456",
                "contact1@example.com");
        Contact contact2 = new Contact("Divya", "Sarawagi", "123456",
                "contact1@example.com");

        contacts.add(contact1);
        contacts.add(contact2);

//        tableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Contact>() {
//            @Override
//            public void changed(ObservableValue<? extends Contact> observableValue, Contact contact, Contact t1) {
//                if (t1!=null) {
//                    firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("Deepanshu"));
//                    tableView.getColumns().setAll(firstNameColumn);
//                }
//            }
//        });
        tableView.setItems();
        firstNameColumn.setCellValueFactory(new PropertyValueFactory(contact1.firstNameProperty().toString()));
        tableView.getColumns().setAll(firstNameColumn);
    }
}
