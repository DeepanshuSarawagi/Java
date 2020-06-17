package com.deepanshu.todolist;

import com.deepanshu.todolist.datamodel.TodoData;
import com.deepanshu.todolist.datamodel.TodoItem;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    private List<TodoItem> todoItems;
    @FXML
    private ListView<TodoItem> todoListView;
    @FXML
    private TextArea itemDetailsTextArea;
    @FXML
    private Label deadlineLabel;
    @FXML
    private BorderPane mainBorderPane;

    public void initialize() {
//        TodoItem item1 = new TodoItem("Mail Birthday Card", "Buy a 28th birthday card for a friend",
//                LocalDate.of(2020, Month.DECEMBER, 20));
//        TodoItem item2 = new TodoItem("Doctor`s appointment", "Meet Dr. Verma this month",
//                LocalDate.of(2020, Month.JUNE, 12));
//        TodoItem item3 = new TodoItem("Finish desing proposal for client",
//                "Promised Mike to get the proposal delivered", LocalDate.of(2020, Month.APRIL, 22));
//        TodoItem item4 = new TodoItem("Pick up friend at Station", "Pick up friend. Coming by train",
//                LocalDate.of(2020, Month.MARCH, 18));
//        TodoItem item5 = new TodoItem("Pick up dry cleaning", "Pick up dry cleaning from the store",
//                LocalDate.of(2020, Month.JUNE, 27));
//
//        todoItems = new ArrayList<>();
//
//        todoItems.add(item1);
//        todoItems.add(item2);
//        todoItems.add(item3);
//        todoItems.add(item4);
//        todoItems.add(item5);

//        TodoData.getInstance().setTodoItems(todoItems);

        todoListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TodoItem>() {
            @Override
            public void changed(ObservableValue<? extends TodoItem> observableValue, TodoItem todoItem, TodoItem t1) {
                if (t1 != null) {
                    TodoItem item = todoListView.getSelectionModel().getSelectedItem();
                    itemDetailsTextArea.setText(item.getDetails());
                    DateTimeFormatter df = DateTimeFormatter.ofPattern("MMM d, yyyy");
                    deadlineLabel.setText(df.format(item.getDeadLine()));
                }
            }
        });
        todoListView.getItems().setAll(TodoData.getInstance().getTodoItems());
        todoListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        todoListView.getSelectionModel().selectFirst();

    }

    @FXML
    public void showNewItemDialog() {
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainBorderPane.getScene().getWindow());
        try{

        }
    }

    @FXML
    public void handleTodoListView() {
        TodoItem item = todoListView.getSelectionModel().getSelectedItem();
        itemDetailsTextArea.setText(item.getDetails());
        deadlineLabel.setText(item.getDeadLine().toString());
//        System.out.println("The selected item is " + item);
//        StringBuilder sb = new StringBuilder(item.getDetails());
//        sb.append("\n\n\n\n\n\n\n\n");
//        sb.append("Due: ");
//        sb.append(item.getDeadLine());
//        itemDetailsTextArea.setText(sb.toString());

    }
}
