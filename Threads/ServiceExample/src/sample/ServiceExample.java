package sample;

import javafx.collections.ObservableList;
import javafx.concurrent.Service;
import javafx.concurrent.Task;

public class ServiceExample extends Service<ObservableList<String>> {
    @Override
    protected Task<ObservableList<String>> createTask() {
        return null;
    }
}
