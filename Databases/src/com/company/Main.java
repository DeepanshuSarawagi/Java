package com.company;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
	    try{
            Connection conn = DriverManager.getConnection("jdbc:sqlite:/Users/deepanshusarawagi/Desktop/Learning/Java/Databases/src/testJava.db");
//            conn.setAutoCommit(false);  // By default the JDBC connection will commit all the changes we make to the DB
//            // using the SQL statement. If we have this setting set to false, any changes made to DB will be Rolled Back
//            // and we need to manually commit the changes to DB.

            Statement statement = conn.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS contacts (name TEXT, phone INTEGER, email TEXT)");
//            statement.execute("INSERT INTO contacts (name, phone, email) " +
//                    "VALUES ('Deepanshu', 654890, 'deepanshu@email.com')");
//            statement.execute("INSERT INTO contacts (name, phone, email) " +
//                    "VALUES ('Divya', 865132, 'divya@email.com')");
//            statement.execute("INSERT INTO contacts (name, phone, email) " +
//                    "VALUES ('Rajat', 798041, 'rajat@email.com')");
//            statement.execute("UPDATE contacts SET phone=5560981 WHERE name='Deepanshu'");
//            statement.execute("DELETE FROM contacts WHERE name='Divya'");

            statement.execute("SELECT * FROM contacts");
            ResultSet results = statement.getResultSet();
            while (results.next()) {
                System.out.println(results.getString("name") + " " + results.getInt("phone") +
                        " " + results.getString("email"));
            }

            statement.close();
            conn.close();

            // Order of closing the Statement objects is important. It is important that first we close the Statement
            // Followed by Connection objects else we will get the SQLException: DB not found.

        } catch (SQLException e) {
            System.out.println("Something went wrong! " + e.getMessage());
        }
    }
}
