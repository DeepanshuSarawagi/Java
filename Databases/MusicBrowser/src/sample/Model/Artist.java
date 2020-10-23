package sample.Model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Artist {
    private SimpleIntegerProperty id;  // Change the field type from int to SimpleIntegerProperty for data binding in future
    private SimpleStringProperty name;  // Change the field type from int to SimpleStringProperty for data binding in future

    public SimpleIntegerProperty getId() {
        return id;
    }

    public void setId(SimpleIntegerProperty id) {
        this.id = id;
    }

    public SimpleStringProperty getName() {
        return name;
    }

    public void setName(SimpleStringProperty name) {
        this.name = name;
    }
}
