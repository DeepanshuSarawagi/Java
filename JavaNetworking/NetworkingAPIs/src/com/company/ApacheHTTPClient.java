package com.company;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class ApacheHTTPClient {
    public static void main(String[] args) {
        CloseableHttpClient httpClient = HttpClients.createDefault();  // Create a default HTTP client
        HttpGet request = new HttpGet("http://example.org");  // Create a HTTP Get request
        request.addHeader("User-Agent", "Chrome");  // Add the header

        CloseableHttpResponse response = null;

        try {
            response = httpClient.execute(request);
            System.out.println("response code = " + response.getCode());

            BufferedReader inputReader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            String line;

            while ((line = inputReader.readLine()) != null) {
                System.out.println(line);
            }
            inputReader.close();
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        } finally {
            try {
                response.close();
            } catch (IOException e) {
                System.out.println("IOException: " + e.getMessage());
            }
        }
    }
}