package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {
	    try(Connection conn = DriverManager.getConnection("jdbc:sqlite:/Users/deepanshusarawagi/Desktop/Learning/Java/Databases/src/testJava.db");
            Statement statement = conn.createStatement()) {
            statement.execute("CREATE TABLE contacts (name TEXT, phone INTEGER, email TEXT)");
        } catch (SQLException e) {
            System.out.println("Something went wrong! " + e.getMessage());
        }
    }
}
