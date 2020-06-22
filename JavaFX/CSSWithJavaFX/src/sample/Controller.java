package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Controller {
    @FXML
    private Label label;

    public void initialize() {
        label.setScaleX(1.5);
        label.setScaleY(1.5);
    }

}
