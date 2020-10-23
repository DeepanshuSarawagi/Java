module MusicBrowser {
    requires javafx.fxml;
    requires javafx.controls;
    requires java.desktop;
    requires java.sql;

    opens sample;
    opens sample.Model;  // Fix the IllegalAccessIssue
}