package sample;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;

public class Controller {

    private Task<ObservableList<String>> task;

    public void initialize() {
        task = new Task<ObservableList<String>>() {
            @Override
            protected ObservableList<String> call() throws Exception {
                Thread.sleep(1000);
                return FXCollections.observableArrayList(
                        "Deepanshu Sarawagi",
                             "Divya Sarawagi",
                             "Rajat Sarawagi",
                             "Pradeep Sarawagi",
                             "Sangeetha Rani"
                );
            }
        };
    }

    @FXML
    public void ButtonPressed() {
        new Thread(task).start();
    }
}
