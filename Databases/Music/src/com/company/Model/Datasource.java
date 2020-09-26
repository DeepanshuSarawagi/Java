package com.company.Model;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Datasource {
    public static final String DB_NAME = "music.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:/Users/deepanshusarawagi/Desktop/Learning/Java/Databases/Music/" + DB_NAME;

    public static final String TABLE_ALBUMS = "albums";
    public static final String COLUMN_ALBUM_ID = "_id";
    public static final String COLUMN_ALBUM_NAME = "name";
    public static final String COLUMN_ALBUM_ARTIST = "artist";
    public static final int INDEX_ALBUM_ID = 1;
    public static final int INDEX_ALBUM_NAME = 2;
    public static final int INDEX_ALBUM_ARTIST = 3;

    public static final String TABLE_ARTISTS = "artists";
    public static final String COLUMN_ARTISTS_ID = "_id";
    public static final String COLUMN_ARTISTS_NAME = "name";
    public static final int INDEX_ARTISTS_ID = 1;
    public static final int INDEX_ARTISTS_NAME = 2;

    public static final String TABLE_SONGS = "songs";
    public static final String COLUMN_SONG_TRACK = "track";
    public static final String COLUMN_SONG_TITLE = "title";
    public static final String COLUMN_SONG_ALBUM = "album";
    public static final String COLUMN_SONG_ID = "_id";
    public static final int INDEX_SONG_ID = 1;
    public static final int INDEX_SONG_TRACK =2;
    public static final int INDEX_SONG_TITLE =3;
    public static final int INDEX_SONG_ALBUM =4;
    public static final int ORDER_BY_NONE =1;
    public static final int ORDER_BY_ASC =2;
    public static final int ORDER_BY_DESC =3;

    public static final String QUERY_ALBUMS_ARTIST_START = "SELECT " + TABLE_ALBUMS + "." + COLUMN_ALBUM_NAME +
            " FROM " + TABLE_ALBUMS + " INNER JOIN " + TABLE_ARTISTS + " ON " + TABLE_ALBUMS + "." + COLUMN_ALBUM_ARTIST
            + " = " + TABLE_ARTISTS + "." + COLUMN_ARTISTS_ID + " WHERE " + TABLE_ARTISTS + "." + COLUMN_ARTISTS_NAME +
            " = \"";
    public static final String QUERY_ALBUMS_BY_ARTIST_SORT = " ORDER BY " + TABLE_ALBUMS + "." + COLUMN_ALBUM_NAME +
            " COLLATE NOCASE ";

    public static final String QUERY_ARTIST_FOR_SONG_START =
            "SELECT " + TABLE_ARTISTS + "." + COLUMN_ARTISTS_NAME + ", " + TABLE_ALBUMS + "." + COLUMN_ALBUM_NAME +
                    ", " + TABLE_SONGS + "." + COLUMN_SONG_TRACK + " FROM " + TABLE_SONGS + " INNER JOIN " + TABLE_ALBUMS
            + " ON " + TABLE_SONGS + "." + COLUMN_SONG_ALBUM + " = " + TABLE_ALBUMS + "." + COLUMN_ALBUM_ID + " INNER JOIN "
            + TABLE_ARTISTS + " ON " + TABLE_ALBUMS + "." + COLUMN_ALBUM_ARTIST + " = " + TABLE_ARTISTS + "." + COLUMN_ARTISTS_ID
            + " WHERE " + TABLE_SONGS + "." + COLUMN_SONG_TITLE + " = \"";

    public static final String QUERY_ARTIST_FOR_SONG_SORT =
            " ORDER BY " + TABLE_ARTISTS + "." + COLUMN_ARTISTS_NAME + ", " + TABLE_ALBUMS + "." + COLUMN_ALBUM_NAME +
            ", " + TABLE_SONGS + "." + COLUMN_SONG_TRACK + " COLLATE NOCASE ";

    public static final String TABLE_ARTIST_SONG_VIEW = "artist_list";
    public static final String CREATE_ARTIST_SONG_VIEW = "CREATE VIEW IF NOT EXISTS " + TABLE_ARTIST_SONG_VIEW +
            " AS SELECT " + TABLE_ARTISTS + "." + COLUMN_ARTISTS_NAME + " AS artist_name"  + ", " + TABLE_ALBUMS + "." + COLUMN_ALBUM_NAME + " AS album_name" + ", "
            + TABLE_SONGS + "." + COLUMN_SONG_TRACK + " AS songs_track" + ", " + TABLE_SONGS + "." + COLUMN_SONG_TITLE + " AS songs_title " + " FROM " + TABLE_SONGS
            + " INNER JOIN " + TABLE_ALBUMS + " ON " + TABLE_SONGS + "." + COLUMN_SONG_ALBUM + " = "  + TABLE_ALBUMS + "."
            + COLUMN_ALBUM_ID + " INNER JOIN " + TABLE_ARTISTS + " ON " + TABLE_ALBUMS + "." + COLUMN_ALBUM_ARTIST + " = "
            + TABLE_ARTISTS + "." + COLUMN_ARTISTS_ID + " ORDER BY " + TABLE_ARTISTS + "." + COLUMN_ARTISTS_NAME + ", " +
            TABLE_ALBUMS + "." + COLUMN_ALBUM_NAME + ", " + TABLE_SONGS + "." + COLUMN_SONG_TRACK + " COLLATE NOCASE ASC";

    public static final String QUERY_VIEW_SONG_INFO = "SELECT artist_name, album_name, songs_track" + " FROM " +
            TABLE_ARTIST_SONG_VIEW + " WHERE songs_title"  + " = \"";

    public static final String QUERY_VIEW_SONG_INFO_PREP = "SELECT artist_name, album_name, songs_track" + " FROM " + TABLE_ARTIST_SONG_VIEW
            + " WHERE songs_title " + " = ?";

    // When using PreparedStatement we can use Place Holders in place of getting user input which will accept just one
    // value. Doing this will avoid SQL Injection attacks since user/hacker will not be able to concatenate strings
    // when prompted.
    // Also for better performance benefits, we just create one single instance of PreparedStatement class

    public static final String INSERT_ARTIST = "INSERT INTO " + TABLE_ARTISTS + '(' + COLUMN_ARTISTS_NAME + ") VALUES(?)";
    public static final String INSERT_ALBUMS = "INSERT INTO " + TABLE_ALBUMS + '(' + COLUMN_ALBUM_NAME + ", " + COLUMN_ALBUM_ARTIST + ") VALUES(?, ?)";
    public static final String INSERT_SONG = "INSERT INTO " + TABLE_SONGS + '(' + COLUMN_SONG_TRACK + ", " + COLUMN_SONG_TITLE
            + ", " + COLUMN_SONG_ALBUM + ") VALUES(?, ?, ?)";

    public static final String QUERY_ARTIST = "SELECT " + COLUMN_ARTISTS_ID + " FROM " + TABLE_ARTISTS + " WHERE " +
            COLUMN_ARTISTS_NAME + " = ?";
    public static final String QUERY_ALBUM = "SELECT " + COLUMN_ALBUM_ID + " FROM " + TABLE_ALBUMS + " WHERRE " +
            COLUMN_ALBUM_NAME + " = ?";

    private Connection conn;

    private PreparedStatement querySongInfoView;

    private PreparedStatement insertIntoArtists;
    private PreparedStatement insertIntoAlbums;
    private PreparedStatement insertIntoSongs;

    private PreparedStatement queryArtist;
    private PreparedStatement queryAlbum;



    public boolean open() {
        try {
            conn = DriverManager.getConnection(CONNECTION_STRING);
            querySongInfoView = conn.prepareStatement(QUERY_VIEW_SONG_INFO_PREP);
            insertIntoArtists = conn.prepareStatement(INSERT_ARTIST, Statement.RETURN_GENERATED_KEYS);
            insertIntoAlbums = conn.prepareStatement(INSERT_ALBUMS, Statement.RETURN_GENERATED_KEYS);  // We will use the retrieved IDs in the next INSERT statement
            insertIntoSongs = conn.prepareStatement(INSERT_SONG);
            queryArtist = conn.prepareStatement(QUERY_ARTIST);
            queryAlbum = conn.prepareStatement(QUERY_ALBUM);

            return true;
        } catch (SQLException e) {
            System.out.println("Couldn't get connection to DB: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public void close() {
        try {

            if (querySongInfoView != null) {
                querySongInfoView.close();
            }
            if (insertIntoArtists != null) {
                insertIntoArtists.close();
            }
            if (insertIntoAlbums != null) {
                insertIntoAlbums.close();
            }
            if (insertIntoSongs != null) {
                insertIntoSongs.close();
            }
            if (queryArtist != null) {
                queryArtist.close();
            }
            if (queryAlbum != null) {
                queryAlbum.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println("Couldn't close the connection: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public List<Artist> queryArtist(int sortOrder) {

        StringBuilder sb = new StringBuilder("SELECT * FROM ");
        sb.append(TABLE_ARTISTS);
        if (sortOrder != ORDER_BY_NONE) {
            sb.append(" ORDER BY ");
            sb.append(COLUMN_ARTISTS_NAME);
            sb.append(" COLLATE NOCASE ");
            if (sortOrder == ORDER_BY_DESC) {
                sb.append("DESC");
            } else {
                sb.append("ASC");
            }
        }

        try(Statement statement = conn.createStatement();
            ResultSet results = statement.executeQuery(sb.toString())) {
            List<Artist> artists = new ArrayList<>();
            while (results.next()) {
                Artist artist = new Artist();
                artist.setId(results.getInt(INDEX_ARTISTS_ID));
                artist.setName(results.getString(INDEX_ARTISTS_NAME));
                artists.add(artist);
            }
            return artists;

        } catch (SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public List<String> queryAlbumsForArtists(String artistName, int sortOrder) {
        // SELECT albums.name FROM albums INNER JOIN artists ON albums.artist = artists._id WHERE
        // artists.name = "Pink Floyd" ORDER BY albums.name COLLATE NOCASE ASC;
        StringBuilder sb = new StringBuilder(QUERY_ALBUMS_ARTIST_START);
        sb.append(artistName);
        sb.append("\"");

        if (sortOrder != ORDER_BY_NONE) {
            sb.append(QUERY_ALBUMS_BY_ARTIST_SORT);
            if (sortOrder == ORDER_BY_DESC) {
                sb.append("DESC");
            } else {
                sb.append("ASC");
            }
        }

        System.out.println("SQL Statement = " + sb.toString());

        try(Statement statement = conn.createStatement();
        ResultSet results = statement.executeQuery(sb.toString())) {

            List<String> albums = new ArrayList<>();
            while (results.next()) {
                albums.add(results.getString(COLUMN_ALBUM_NAME));
            }
            return albums;
        } catch (SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public List<SongArtist> queryArtistsForSong(String songName, int sortOrder) {
        StringBuilder sb = new StringBuilder(QUERY_ARTIST_FOR_SONG_START);
        sb.append(songName);
        sb.append("\"");

        if (sortOrder != ORDER_BY_NONE) {
            sb.append(QUERY_ARTIST_FOR_SONG_SORT);
            if (sortOrder == ORDER_BY_DESC) {
                sb.append("DESC");
            } else {
                sb.append("ASC");
            }
        }
        System.out.println(sb.toString());

        try(Statement statement = conn.createStatement();
        ResultSet results = statement.executeQuery(sb.toString())) {
            List<SongArtist> songArtists = new ArrayList<>();
            while (results.next()) {
                SongArtist songArtist = new SongArtist();
                songArtist.setArtistName(results.getString(1));
                songArtist.setAlbumName(results.getString(2));
                songArtist.setTrack(results.getInt(3));
                songArtists.add(songArtist);
            }

            return songArtists;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Below is the procedure to get the Metadata for the particular table. Since there is no JDBC API for query schema
    // for SQLITE databases, we use the ResultSetMetadata instance to get the metadata about the tables in a DB.

    public void querySongMetadata() {

        try(Statement statement = conn.createStatement();
            ResultSet results = statement.executeQuery("SELECT * FROM songs")) {

            ResultSetMetaData resultsMetaData = results.getMetaData();
            int metadataColumns = resultsMetaData.getColumnCount();

            for (int i=1; i<=metadataColumns; i++) {
                System.out.printf("Column %d in the songs table is named as %s\n", i, resultsMetaData.getColumnName(i));
            }

        } catch (SQLException e) {
            System.out.println("Error getting MEtadata: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void queryAlbumMetadata() {
        try (Statement statement = conn.createStatement();
            ResultSet results = statement.executeQuery("SELECT * FROM albums")){

            ResultSetMetaData meta = results.getMetaData();
            int metadataColumns = meta.getColumnCount();
            for (int i=1; i<=metadataColumns; i++) {
                System.out.printf("Column %d in table albums is named as %s\n", i, meta.getColumnName(i) );
            }
        } catch (SQLException e) {
            System.out.println("Error getting Metadata for table albums: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void queryArtistMetadata() {
        try(Statement statement = conn.createStatement();
            ResultSet results = statement.executeQuery("SELECT * FROM artists")) {

            ResultSetMetaData meta = results.getMetaData();
            int metadataColumns = meta.getColumnCount();

            for (int i=1; i<=metadataColumns; i++) {
                System.out.printf("Column %d in table artists is named as %s\n", i, meta.getColumnName(i));
            }
        } catch (SQLException e) {
            System.out.println("Error getting metadata for table artists: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // We can also query function() in SQL query

    public int getCount(String table) {
        try(Statement statement = conn.createStatement();
            ResultSet results = statement.executeQuery("SELECT COUNT(*) AS count, MIN(_id) AS min_id FROM " + table)) {
            int count = results.getInt("count");
            int min = results.getInt("min_id");
            System.out.printf("No. of records in " + table + " is %d, and minimum _id value is %d\n", count, min);
            return results.getInt(1);
        } catch (SQLException e) {
            System.out.println("Query execution failed: " + e.getMessage());
            e.printStackTrace();
            return -1;
        }
    }

    public boolean createViewForArtists() {
        try(Statement statement = conn.createStatement()) {
            statement.execute(CREATE_ARTIST_SONG_VIEW);
            return true;
        } catch (SQLException e) {
            System.out.println("Executing query for creating VIEW failed: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public List<SongArtist> querySongInfoView(String title) {
//        StringBuilder sb = new StringBuilder(QUERY_VIEW_SONG_INFO_PREP);
//        sb.append(title);
//        sb.append("\"");
//
//        System.out.println(sb.toString());

//        try(Statement statement = conn.createStatement();
//            ResultSet results = statement.executeQuery(sb.toString())) {
//
//            List<SongArtist> songArtists = new ArrayList<>();
//            while (results.next()) {
//                SongArtist artist = new SongArtist();
//                artist.setArtistName(results.getString(1));
//                artist.setAlbumName(results.getString(2));
//                artist.setTrack(results.getInt(3));
//                songArtists.add(artist);
//            }
//            return songArtists;
//        } catch (SQLException e) {
//            System.out.println("Query execution for VIEW artist_list failed: " + e.getMessage());
//            e.printStackTrace();
//            return null;
//        }

        // Commented out above code to use PreparedStatement

        try {
            querySongInfoView.setString(1, title);
            ResultSet results = querySongInfoView.executeQuery();  // Since we have already Prepared a statement using
            // the prepared statement class, we just need to call the executeQuery() method without passing any parameters

            List<SongArtist> songArtists = new ArrayList<>();
            while (results.next()) {
                SongArtist songArtist = new SongArtist();
                songArtist.setArtistName(results.getString(1));
                songArtist.setAlbumName(results.getString(2));
                songArtist.setTrack(results.getInt(3));
                songArtists.add(songArtist);
            }
            return songArtists;
        } catch (SQLException e) {
            System.out.println("Couldn't execute query: " + e.getMessage());
            e.printStackTrace();
            return null;
        }

        // There can be only one active ResultSet associated with the Statement
        // Order of closing the JDBC resources is very important. We cant close a connection first since we would need
        // an open connection to close the statements. Basically we close the resources in reverse order its created

    }
}
