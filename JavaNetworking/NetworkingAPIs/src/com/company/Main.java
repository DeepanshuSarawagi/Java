package com.company;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class Main {

    /**
     * In this lesson, we are going to learn about URI and URL and how they can be used in Java Networking.
     * URI consists of following segments
     * 1. Scheme
     * 2. Scheme-Sepcific Part
     * 3. Authority
     * 4. User-info
     * 5. Host
     * 6. Port
     * 7. Path
     * 8. Query
     * 9. Fragment
     */

    public static void main(String[] args) {
        try {
            URI uri = new URI("db://username:password@myserver.com:5000/catalogue/phones?os=android#samsung");
            System.out.println("Scheme = " + uri.getScheme());
            System.out.println("Scheme Specific-part = " + uri.getSchemeSpecificPart());
            System.out.println("Authority = " + uri.getAuthority());
            System.out.println("User-Info " + uri.getUserInfo());
            System.out.println("Host = " + uri.getHost());
            System.out.println("Port = " + uri.getPort());
            System.out.println("Path = " + uri.getPath());
            System.out.println("Query = " + uri.getQuery());
            System.out.println("Fragment = " + uri.getFragment());

            URI baseURI = new URI("http://username:password@myserver.com:5000");
            uri = new URI("/catalogue/phones?os=android#samsung");
            URI resolvedURI = baseURI.resolve(uri);
            URL url = resolvedURI.toURL();
            System.out.println("URL = " + url);

        } catch (URISyntaxException e) {
            System.out.println("Bad URI syntax: " + e.getMessage());
        } catch (MalformedURLException e) {
            System.out.println("URL Malformed: " + e.getMessage());
        }
    }
}
