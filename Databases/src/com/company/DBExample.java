package com.company;

import java.sql.*;

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
            insert_contacts(statement, "Deepanshu", 809756, "deepanshu@email.com");
            insert_contacts(statement, "Divya", 790413, "divya@email.com");
            insert_contacts(statement, "Rajat", 7688901, "rajat@email.com");
            insert_contacts(statement, "Deepak", 901752, "deepak@email.com");

            statement.execute("UPDATE " + TABLE_CONTACTS + " SET " + COLUMN_PHONE + "=998147 WHERE "
                    + COLUMN_NAME + "= 'Deepak'");

            statement.execute("DELETE FROM " + TABLE_CONTACTS +
                            " WHERE " + COLUMN_NAME + " ='Deepak'");

            ResultSet results = statement.executeQuery("SELECT * FROM " + TABLE_CONTACTS);
            while (results.next()) {
                System.out.println(results.getString(COLUMN_NAME) + " "
                                    + results.getString(COLUMN_PHONE) + " "
                                    + results.getString(COLUMN_EMAIL));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    private static void insert_contacts(Statement statement, String name, int phone, String email) throws SQLException{
        statement.execute("INSERT INTO " + TABLE_CONTACTS +
                "( " + COLUMN_NAME + ", "
                + COLUMN_PHONE + ", "
                + COLUMN_EMAIL + " )" +
                " VALUES ('" + name + "', " + phone + ", '" + email + "')");
    }
}
