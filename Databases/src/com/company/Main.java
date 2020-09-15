package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {
	    try{
            Connection conn = DriverManager.getConnection("jdbc:sqlite:/Users/deepanshusarawagi/Desktop/Learning/Java/Databases/src/testJava.db");
            Statement statement = conn.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS contacts (name TEXT, phone INTEGER, email TEXT)");

            statement.close();
            conn.close();

            // Order of closing the Statement objects is important. It is important that first we close the Statement
            // Followed by Connection objects else we will get the SQLException: DB not found.

        } catch (SQLException e) {
            System.out.println("Something went wrong! " + e.getMessage());
        }
    }
}
