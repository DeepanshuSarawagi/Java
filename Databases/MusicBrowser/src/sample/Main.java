package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.Model.Datasource;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
        primaryStage.setTitle("Music Database Browser");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }

    @Override
    public void init() throws Exception {
        if (!Datasource.getInstance().open()) {
            System.out.println("FATAL ERROR!");
            Platform.exit();
        }
    }

    @Override
    public void stop() throws Exception {
        Datasource.getInstance().close();
    }

    public static void main(String[] args) {
        launch(args);
    }
}