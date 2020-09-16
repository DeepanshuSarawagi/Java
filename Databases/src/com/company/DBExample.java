package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBExample {
    public static final String DB_NAME = "testJava.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:/Users/deepanshusarawagi/Desktop/Learning/Java/Databases/src/" + DB_NAME;

    public static final String TABLE_CONTACTS = "contacts";

    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_PHONE = "phone";
    public static final String COLUMN_EMAIL = "email";

    public static void main(String[] args) {

        try {
            Connection conn = DriverManager.getConnection(CONNECTION_STRING);
            Statement statement = conn.createStatement();

            statement.execute("DROP TABLE IF EXISTS " + TABLE_CONTACTS);
            statement.execute("CREATE TABLE IF NOT EXISTS " + TABLE_CONTACTS +
                                "( " + COLUMN_NAME + " text, " +
                                COLUMN_PHONE + " integer, " +
                                COLUMN_EMAIL + " text" + ")");
            statement.execute("INSERT INTO " + TABLE_CONTACTS +
                            "( " + COLUMN_NAME + ", "
                            + COLUMN_PHONE + ", "
                            + COLUMN_EMAIL + " )" +
                            " VALUES ('Deepanshu', 894162, 'deepanshu@email.com')");

            statement.execute("INSERT INTO " + TABLE_CONTACTS +
                    "( " + COLUMN_NAME + ", "
                    + COLUMN_PHONE + ", "
                    + COLUMN_EMAIL + " )" +
                    " VALUES ('Divya', 984730, 'divya@email.com')");

            statement.execute("INSERT INTO " + TABLE_CONTACTS +
                    "( " + COLUMN_NAME + ", "
                    + COLUMN_PHONE + ", "
                    + COLUMN_EMAIL + " )" +
                    " VALUES ('Rajat', 703156, 'rajat@email.com')");



        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}