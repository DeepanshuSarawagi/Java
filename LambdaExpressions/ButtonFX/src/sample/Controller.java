package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Controller {

    @FXML
    private Button clickMeButton;

//    public void initialize() {
//        clickMeButton.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent actionEvent) {
//                System.out.println("You clicked me!!");
//            }
//        });
//    }

    // Commented out above code to see the example of Lambda Expression and how it simplifies above code

    public void initialize() {
        clickMeButton.setOnAction(actionEvent -> System.out.println("You clicked me!!"));
    }

}
