package com.company;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class URLConnectionExample {
    /**
     * We can use the URLConnection class to read the contents of a Webpage.
     */
    public static void main(String[] args) {
        try{
            URL url = new URL("http://example.org");
            URLConnection urlConnection = url.openConnection();
            urlConnection.connect();  // We call the URLConnection.connect() method to connect to the URL thats because
            // the openConnection() call doesnt connect to the URL
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
    }
}
