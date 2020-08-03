package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Service;
import javafx.concurrent.Task;

public class ServiceExample extends Service<ObservableList<String>> {
    @Override
    protected Task<ObservableList<String>> createTask() {
        return new Task<ObservableList<String>>() {
            @Override
            protected ObservableList<String> call() throws Exception {
                String[] names = {"Pradeep Sarawagi",
                                  "Sangeetha Rani",
                                  "Deepanshu Sarawagi",
                                  "Divya Sarawagi",
                                  "Rajat Sarawagi"};
                ObservableList<String> employees = FXCollections.observableArrayList();
                for (String name : names) {
                    employees.add(name);
                    updateMessage("Added " + name + " to the list");
                    updateProgress(1, names.length);
                    Thread.sleep(200);
                }
                return employees;
            }
        };
    }
}
