package com.deepanshu.todolist.datamodel;

import java.time.format.DateTimeFormatter;
import java.util.List;

public class TodoData {
    private static TodoData instance = new TodoData();
    private static String fileName = "TodoListItems.txt";

    private List<TodoItem> todoItems;
    private DateTimeFormatter formatter;

    public static TodoData getInstance() {
        return instance;
    }

    private TodoData() {
        formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    }

    public List<TodoItem> getTodoItems() {
        return todoItems;
    }

    public void setTodoItems(List<TodoItem> todoItems) {
        this.todoItems = todoItems;
    }
}
