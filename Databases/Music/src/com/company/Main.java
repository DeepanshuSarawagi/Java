package com.company;

import com.company.Model.Artist;
import com.company.Model.Datasource;
import com.company.Model.Song;
import com.company.Model.SongArtist;

import java.util.List;
import java.util.Scanner;

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

        List<String> albumsForArtist = datasource.queryAlbumsForArtists("Carole King", Datasource.ORDER_BY_ASC);
        for (String album : albumsForArtist) {
            System.out.println(album);
        }

        List<SongArtist> songArtists = datasource.queryArtistsForSong("Go Your Own Way", Datasource.ORDER_BY_ASC);
        if (songArtists == null) {
            System.out.println("Couldn't find artist for the song");
            return;
        }

        System.out.println();

        for (SongArtist artist: songArtists) {
            System.out.println("Artist Name = " + artist.getArtistName() + ", Album name = " + artist.getAlbumName()
            + ", Song track = " + artist.getTrack());
        }

        datasource.querySongMetadata();

        datasource.queryAlbumMetadata();

        datasource.queryArtistMetadata();

        int count = datasource.getCount("songs");
        System.out.println("No. of records in songs table is " + count);

        if (datasource.createViewForArtists()) {
            System.out.println("VIEW successfully created.");
        } else {
            System.out.println("Creating VIEW failed. Check the error stack trace");
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a song name: ");
        String title = scanner.nextLine();

        songArtists = datasource.querySongInfoView(title);

        if(songArtists.isEmpty()) {
            System.out.println("Couldn't find the song");
            return;
        }

        for (SongArtist artist : songArtists) {
            System.out.println("FROM VIEW - " + " Artist Name = " + artist.getArtistName() +
                    " Album Name " + artist.getAlbumName() + " Song Track = " + artist.getTrack());
        }

        datasource.close();
    }
}
