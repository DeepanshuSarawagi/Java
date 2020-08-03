package sample;

import javafx.collections.ObservableList;
import javafx.concurrent.Service;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class Controller {

    @FXML
    private ListView<String> listView;

    private Service<ObservableList<String>> service;

    public void initialize() {
        service = new ServiceExample();
        listView.itemsProperty().bind(service.valueProperty());
    }

    @FXML
    public void buttonPressed() {
        service.start();
    }
}
