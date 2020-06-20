package com.deepanshu.todolist;

import com.deepanshu.todolist.datamodel.TodoData;
import com.deepanshu.todolist.datamodel.TodoItem;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.util.Callback;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

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
    @FXML
    private ContextMenu listContextMenu;
    @FXML
    private ToggleButton filterToggleButton;
    private FilteredList<TodoItem> filteredList;


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

        listContextMenu = new ContextMenu();
        MenuItem deleteMenuItem = new MenuItem("Delete");
        deleteMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                TodoItem item = todoListView.getSelectionModel().getSelectedItem();
                deleteItem(item);
            }
        });

        listContextMenu.getItems().addAll(deleteMenuItem);

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
        filteredList = new FilteredList<>(TodoData.getInstance().getTodoItems(), new Predicate<TodoItem>() {
            @Override
            public boolean test(TodoItem todoItem) {
                return true;
            }
        });

        SortedList<TodoItem> sortedList = new SortedList<>(filteredList, new Comparator<TodoItem>() {
            @Override
            public int compare(TodoItem o1, TodoItem o2) {
                return (o1.getDeadLine().compareTo(o2.getDeadLine()));
            }
        });

//        todoListView.setItems(TodoData.getInstance().getTodoItems()); // We will display the sorted list in the ListView
        todoListView.setItems(sortedList);
        todoListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        todoListView.getSelectionModel().selectFirst();

        // Setting the cell factory and creating an Anonymous class implementing the Callback Interface so that we can
        // format cells based on the deadline of the todoItems

        todoListView.setCellFactory(new Callback<ListView<TodoItem>, ListCell<TodoItem>>() {
            @Override
            public ListCell<TodoItem> call(ListView<TodoItem> todoItemListView) {
                ListCell<TodoItem> cell = new ListCell<>() {
                    @Override
                    protected void updateItem(TodoItem todoItem, boolean b) {
                        super.updateItem(todoItem, b);
                        if (b) {
                            setText(null);
                        } else {
                            setText(todoItem.getShortDescription());
                            if (todoItem.getDeadLine().isBefore(LocalDate.now().plusDays(1))) {
                                setTextFill(Color.DARKRED);
                            } else if (todoItem.getDeadLine().equals(LocalDate.now().plusDays(1))) {
                                setTextFill(Color.ORANGERED);
                            }
                        }

                    }
                };

                cell.emptyProperty().addListener(
                        (obs, wasEmpty, isNowEmpty) -> {
                            if (isNowEmpty) {
                                cell.setContextMenu(null);
                            } else {
                                cell.setContextMenu(listContextMenu);
                            }
                        }
                );
                return cell;
            }
        });

    }

    @FXML
    public void showNewItemDialog() {
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainBorderPane.getScene().getWindow());
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("todoItemDialog.fxml"));
        try{
            dialog.getDialogPane().setContent(fxmlLoader.load());
        } catch (IOException e) {
            System.out.println("Couldn't load the Dialog Box");
            e.printStackTrace();
            return;
        }

        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        Optional<ButtonType> result = dialog.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            DialogController controller = fxmlLoader.getController();
            TodoItem item = controller.processResults();
//            todoListView.getItems().setAll(TodoData.getInstance().getTodoItems());  handled by data-binding
            todoListView.getSelectionModel().select(item);
            System.out.println("Okay button pressed");
        } else {
            System.out.println("Cancel button pressed");
        }
    }

    @FXML
    public void handleKeyPressed(KeyEvent keyEvent) {
        TodoItem selectedItem = todoListView.getSelectionModel().getSelectedItem();
        if (selectedItem != null ) {
            if (keyEvent.getCode().equals(KeyCode.DELETE)) {
                deleteItem(selectedItem);
            }
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

    public void deleteItem(TodoItem Item) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete Todo Item");
        alert.setHeaderText("Delete item: " + Item.getShortDescription());
        alert.setContentText("Are you sure? Press OK to delete or Cancel to back out.");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && (result.get() == ButtonType.OK)) {
            TodoData.getInstance().deleteTodoItem(Item);
        }
    }

    public void handleFilterButton() {
        if (filterToggleButton.isSelected()) {
            filteredList.setPredicate(new Predicate<TodoItem>() {
                @Override
                public boolean test(TodoItem todoItem) {
                    return todoItem.getDeadLine().equals(LocalDate.now());
                }
            });
        } else{
            filteredList.setPredicate(new Predicate<TodoItem>() {
                @Override
                public boolean test(TodoItem todoItem) {
                    return true;
                }
            });
        }
    }
}
