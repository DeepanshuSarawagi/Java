package com.company;

import java.io.BufferedReader;
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
            urlConnection.setReadTimeout(15000);

            // Getting the response code from the HttpURLConnection
            int responseCode = urlConnection.getResponseCode();
            System.out.println("Response code: " + responseCode);

            if (responseCode != 200) {
                System.out.println("Error reading web page");
                return;
            }

        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
    }
}
