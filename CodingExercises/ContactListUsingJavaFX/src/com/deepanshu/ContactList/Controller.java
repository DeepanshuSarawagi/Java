package com.deepanshu.ContactList;

import com.deepanshu.ContactList.dataModel.Contact;
import com.deepanshu.ContactList.dataModel.ContactData;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.util.Callback;

import java.io.IOException;
import java.util.*;
import java.util.function.Predicate;

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

    @FXML
    private GridPane mainWindowPane;

    @FXML
    private TextField searchContact;

    private FilteredList<Contact> filteredList;


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

        filteredList = new FilteredList<>(contacts, new Predicate<Contact>() {
            @Override
            public boolean test(Contact contact) {
                return true;
            }
        });

        SortedList<Contact> sortedList = new SortedList<>(filteredList, new Comparator<Contact>() {
            @Override
            public int compare(Contact o1, Contact o2) {
                return o1.firstNameProperty().toString().compareTo(o2.firstNameProperty().toString());
            }
        });


        tableView.setItems(sortedList);
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

    @FXML
    public void showNewContactDialog() {
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainWindowPane.getScene().getWindow());
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("NewContactDialog.fxml"));

        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        } catch (IOException e) {
            System.out.println("Couldn`t load the dialog box");
            e.printStackTrace();
            return;
        }

        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        Optional<ButtonType> result = dialog.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            DialogController controller = fxmlLoader.getController();
            Contact contact = controller.createNewContact();
            tableView.getSelectionModel().select(contact);
        } else {
            System.out.println("Cancel button was pressed");
        }
    }

    @FXML
    public void deleteContact() {
        Contact contact = tableView.getSelectionModel().getSelectedItem();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete Contact");
        alert.setHeaderText("Delete contact: " + contact.getFirstName());
        alert.setContentText("Are you sure you want to delete the selected contact? Press OK to confirm. Or CANCEL to " +
                            " back out.");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get()==ButtonType.OK) {
            ContactData.getInstance().deleteContact(contact);
        } else {
            System.out.println("Contact " + contact.getFirstName() + " not deleted.");
        }
    }

    @FXML
    public void editSelectedContact() {
        Contact contact = tableView.getSelectionModel().getSelectedItem();
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainWindowPane.getScene().getWindow());
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("editContactDialog.fxml"));

        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        Optional<ButtonType> result = dialog.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            EditContactDialog controller = fxmlLoader.getController();
            controller.editContact(contact);
            tableView.getSelectionModel().select(contact);
        } else {
            System.out.println("Cancel button was pressed");
        }
    }

    @FXML
    public void searchContact() {
        searchContact.setOnKeyReleased(keyEvent -> {
            filteredList.setPredicate(contact ->
                    contact.getFirstName().toLowerCase().contains(searchContact.getText().toLowerCase().trim()));
        });
    }

    @FXML
    public void handleMouseClick() {
        searchContact.clear();
        filteredList.setPredicate(null);
        mainWindowPane.requestFocus();
    }

}
