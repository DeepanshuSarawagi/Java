package sample.Model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringPropertyBase;

public class Artist {
    private SimpleIntegerProperty id;  // Change the field type from int to SimpleIntegerProperty for data binding in future
    private SimpleStringProperty name;  // Change the field type from int to SimpleStringProperty for data binding in future

    public int getId() {
        return id.get();
    }

    public void setId(SimpleIntegerProperty id) {
        this.id = id;
    }

    public String getName() {
        return name.get();
    }

    public void setName(SimpleStringProperty name) {
        this.name = name;
    }
}
