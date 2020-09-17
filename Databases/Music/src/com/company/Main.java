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

        List<Artist> artists = datasource.queryArtist(Datasource.ORDER_BY_DESC);
        for (Artist artist : artists) {
            System.out.println("ID = " + artist.getId() + ", " + "Name = " + artist.getName());
        }

        List<String> albumsForArtist = datasource.queryAlbumsForArtists("Pink Floyd", Datasource.ORDER_BY_ASC);
        for (String album : albumsForArtist) {
            System.out.println(album);
        }

        datasource.close();
    }
}
