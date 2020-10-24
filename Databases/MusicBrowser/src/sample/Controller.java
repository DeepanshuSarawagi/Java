package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import sample.Model.Album;
import sample.Model.Artist;
import sample.Model.Datasource;

public class Controller {

    @FXML
    private TableView<Artist> artistTable;

    public void listArtists() {
        Task<ObservableList<Artist>> task = new GetAllArtistsTask();
        artistTable.itemsProperty().bind(task.valueProperty());

        new Thread(task).start();  // Kick of the Task to load the Artist objects in TableColumn
    }

    @FXML
    public void ListAlbumsForArtist() {
        final Artist artist = (Artist) artistTable.getSelectionModel().getSelectedItem();
        if (artist == null) {
            System.out.println("No Artist selected");
            return;
        }

        Task<ObservableList<Album>> task = new Task<ObservableList<Album>>() {
            @Override
            protected ObservableList<Album> call() throws Exception {
                return FXCollections.observableArrayList(Datasource.getInstance().queryAlbumForArtistId(artist.getId()));
            }
        };
        artistTable.itemsProperty().bind(task.valueProperty());
        new Thread(task).start();
    }

}

class GetAllArtistsTask extends Task {
    @Override
    public ObservableList<Artist> call() throws Exception {
        // Here, queryList(int sortOrder) method returns the list of Artist objects. We are then using the
        // FXCollections.observableArrayList to convert the list into ObservableArrayList. This helps us to separate the
        // Java code from JavaFX code.

        return FXCollections.observableArrayList(Datasource.getInstance().queryArtist(Datasource.ORDER_BY_ASC));
    }
}
