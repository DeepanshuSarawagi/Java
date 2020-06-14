package com.deepanshu.todolist;

import com.deepanshu.todolist.datamodel.TodoItem;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    private List<TodoItem> todoItems;
    @FXML
    private ListView todoListView;

    public void initialize() {
        TodoItem item1 = new TodoItem("Mail Birthday Card", "Buy a 28th birthday card for a friend",
                LocalDate.of(2020, Month.DECEMBER, 20));
        TodoItem item2 = new TodoItem("Doctor`s appointment", "Meet Dr. Verma this month",
                LocalDate.of(2020, Month.JUNE, 12));
        TodoItem item3 = new TodoItem("Finish desing proposal for client",
                "Promised Mike to get the proposal delivered", LocalDate.of(2020, Month.APRIL, 22));
        TodoItem item4 = new TodoItem("Pick up friend at Station", "Pick up friend. Coming by train",
                LocalDate.of(2020, Month.MARCH, 18));
        TodoItem item5 = new TodoItem("Pick up dry cleaning", "Pick up dry cleaning from the store",
                LocalDate.of(2020, Month.JUNE, 27));

        todoItems = new ArrayList<>();

        todoItems.add(item1);
        todoItems.add(item2);
        todoItems.add(item3);
        todoItems.add(item4);
        todoItems.add(item5);

        todoListView.getItems().setAll(todoItems);
        todoListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

    }
}
