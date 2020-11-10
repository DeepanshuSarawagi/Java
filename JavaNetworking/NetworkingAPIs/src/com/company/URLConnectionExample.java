package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class URLConnectionExample {
    /**
     * We can use the URLConnection class to read the contents of a Webpage.
     */
    public static void main(String[] args) {
        try{
            URL url = new URL("http://example.org");
            URLConnection urlConnection = url.openConnection();
            urlConnection.setDoOutput(true);
            urlConnection.connect();  // We call the URLConnection.connect() method to connect to the URL thats because
            // the openConnection() call doesnt connect to the URL

            BufferedReader inputStream = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line = "";
            while (line != null) {
                line = inputStream.readLine();
                System.out.println(line);
            }

            // We are going to print just the HeaderFields of the WebPage
            System.out.println();

            Map<String, List<String>> headerFields = urlConnection.getHeaderFields();
            for (Map.Entry<String, List<String>> entry: headerFields.entrySet()) {
                String key = entry.getKey();
                System.out.println("---------Key: " + key);
                List<String> values = entry.getValue();
                for (String string: values) {
                    System.out.println(string);
                }
            }
            inputStream.close();
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
    }
}
