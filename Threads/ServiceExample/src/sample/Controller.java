package sample;

import javafx.collections.ObservableList;
import javafx.concurrent.Service;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;

public class Controller {

    @FXML
    private ListView<String> listView;

    @FXML
    private ProgressBar progressBar;

    private Service<ObservableList<String>> service;

    public void initialize() {
        service = new ServiceExample();
        listView.itemsProperty().bind(service.valueProperty());
        progressBar.progressProperty().bind(service.progressProperty());
    }

    @FXML
    public void buttonPressed() {
        service.start();
    }
}
