package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.scene.layout.BorderPane;
import sample.Model.Artist;
import sample.Model.Datasource;

public class Controller {


}

class GetAllArtistsTask extends Task {
    @Override
    public ObservableList<Artist> call() throws Exception {
        // Here, queryList(int sortorder) method returns the list of Artist objects. We are then using the
        // FXCollections.observableArrayList to convert the list into ObservableArrayList. This helps us to separate the
        // Java code from JavaFX code.

        return FXCollections.observableArrayList(Datasource.getInstance().queryArtist(Datasource.ORDER_BY_ASC));
    }
}
