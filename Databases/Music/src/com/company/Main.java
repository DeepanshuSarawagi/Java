package com.company;

import com.company.Model.Artist;
import com.company.Model.Datasource;
import java.sql.Statement;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Datasource datasource = new Datasource();
        if (!datasource.open()) {
            System.out.println("Couldn't open datasource");
            return;
        }

        List<Artist> artists = datasource.queryArtist();
        for (Artist artist : artists) {
            System.out.println("Id= " + artist.getId() + " " + "Name= " + artist.getName());
        }
        datasource.close();
    }
}
