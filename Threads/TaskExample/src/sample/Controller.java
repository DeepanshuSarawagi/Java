package sample;


import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;

public class Controller {

    private Task<ObservableList<String>> task;

    @FXML
    private ListView<String> listView;

    @FXML
    private ProgressBar progressBar;

    @FXML
    private Label label;

    public void initialize() {
        task = new Task<ObservableList<String>>() {
            @Override
            protected ObservableList<String> call() throws Exception {
                String[] names = {"Deepanshu Sarawagi",
                        "Divya Sarawagi",
                        "Rajat Sarawagi",
                        "Pradeep Sarawagi",
                        "Sangeetha Rani"};

                ObservableList<String> employees = FXCollections.observableArrayList();
                for (int i=0; i<names.length; i++) {
                    employees.add(names[i]);
                    updateProgress(i+1, names.length);
                    updateMessage("Added " + names[i] + " to the list.");
                    Thread.sleep(200);
                }

//                Platform.runLater(new Runnable() {
//                    @Override
//                    public void run() {
//                        listView.setItems(employees);
//                    }
//                });

                return employees;    // We are returning the list of data from the task since we are updating the
                // listView from the task, we need not return it from Platform.runLater() in the UI. This is certainly
                // not the recommended way to tie a task to the UI in this way. If we change the UI, then we will have
                // to change the task as well. In general, the UI code and the code that processes data should be kept
                // separate.
                // Instead of using the above method, we should use the data binding to bind the ItemsProperty of
                // listView with ValueProperty of task. Whenever there is a change in the values of task, the items of
                // listView will get updated automatically.

            }
        };

        listView.itemsProperty().bind(task.valueProperty());   // This is how data-binding is done.
        progressBar.progressProperty().bind(task.progressProperty());
        label.textProperty().bind(task.messageProperty());
    }

    @FXML
    public void ButtonPressed() {
        new Thread(task).start();
    }
}
