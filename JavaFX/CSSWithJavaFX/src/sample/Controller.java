package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Controller {
    @FXML
    private Label label;

    public void initialize() {

    }

    @FXML
    public void handleMouseEnter() {
        label.setScaleX(1.5);
        label.setScaleY(1.5);
    }

    @FXML
    public void handleMouseExit() {
        label.setScaleX(1.0);
        label.setScaleY(1.0);
    }

}
