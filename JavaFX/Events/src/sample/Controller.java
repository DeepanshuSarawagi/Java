package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Controller {
    @FXML                               // Annotate nameField as FXML to associate it with TextField in FXML
    private TextField nameField;
    public void onButtonClicked() {
        System.out.println("Hello!! " + nameField.getText());
    }
}
