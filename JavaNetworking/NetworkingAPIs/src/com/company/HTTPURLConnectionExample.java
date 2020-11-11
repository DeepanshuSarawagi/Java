package com.company;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class HTTPURLConnectionExample {
    public static void main(String[] args) {
        try{
            URL url = new URL("http://example.org");
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");  // Setting the RequestMethod to GET method

            // Setting one of the HTTP Header Fields
            urlConnection.setRequestProperty("User-Agent", "Chrome");

            // Getting the response code from the HttpURLConnection
            int responseCode = urlConnection.getResponseCode();
            System.out.println("Response code: " + responseCode);
            urlConnection.setReadTimeout(15000);

        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
    }
}
