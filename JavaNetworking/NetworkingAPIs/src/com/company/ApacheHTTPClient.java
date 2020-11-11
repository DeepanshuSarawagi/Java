package com.company;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;

public class ApacheHTTPClient {
    public static void main(String[] args) {
        CloseableHttpClient httpClient = HttpClients.createDefault();  // Create a default HTTP client
        HttpGet request = new HttpGet("http://example.org");  // Create a HTTP Get request
        request.addHeader("User-Agent", "Chrome");  // Add the header


    }
}
