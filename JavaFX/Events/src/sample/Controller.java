package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
    @FXML                               // Annotate nameField as FXML to associate it with TextField in FXML
    private TextField nameField;
    @FXML
    private Button helloButton;
    @FXML
    private Button byeButton;
    @FXML
    private CheckBox ourCheckBox;
    @FXML
    private Label ourLabel;
    @FXML
    private TextField outputField;

    @FXML
    public void initialize() {
        helloButton.setDisable(true);
        byeButton.setDisable(true);
    }

    @FXML
    public void onButtonClicked(ActionEvent e) {
        if (e.getSource().equals(helloButton)) {
//            System.out.println("Hello, " + nameField.getText());
            String text = nameField.getText();
            outputField.setText("Hello " + text);
        } else if (e.getSource().equals(byeButton)) {
//            System.out.println("Bye, " + nameField.getText());
            String text = nameField.getText();
            outputField.setText("Bye " + text);
        }

        Runnable task = new Runnable() {
            @Override
            public void run() {
                try {
                    String s = Platform.isFxApplicationThread() ? "UI Thread " : "Background Thread ";
                    System.out.println("I'm going to sleep " + s);
                    Thread.sleep(10000);
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            String s = Platform.isFxApplicationThread() ? "UI Thread " : "Background Thread ";
                            System.out.println("I'm updating: " + s);
                            ourLabel.setText("We did something!");
                        }
                    });
                } catch (InterruptedException event) {
                    // We dont need to worry about this now
                }
            }
        };

        new Thread(task).start();

        if (ourCheckBox.isSelected()) {
            nameField.clear();
            helloButton.setDisable(true);
            byeButton.setDisable(true);
        }
    }

    @FXML
    public void handleKeyReleased() {
        String text = nameField.getText();
        boolean disableButtons = text.isEmpty() || text.trim().isEmpty();
        helloButton.setDisable(disableButtons);
        byeButton.setDisable(disableButtons);
    }

    @FXML
    public void handleChange() {
        System.out.println("Checkbox is " + (ourCheckBox.isSelected() ? "checked." : "not checked." ));
    }
}
