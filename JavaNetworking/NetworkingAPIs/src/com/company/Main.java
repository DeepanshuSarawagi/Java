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

            URI baseURI = new URI("http://username:password@mynewserver.com:5000");
            URI uri1 = new URI("/catalogue/phones?os=android#samsung");
            URI uri2 = new URI("/catalogue/tvs?manufacturer=samsung");
            URI uri3 = new URI("/stores/locations?zip=12345");

            URI resolvedURI1 = baseURI.resolve(uri1);
            URL url1 = resolvedURI1.toURL();
            System.out.println("URL = " + url1);

            URI resolvedURI2 = baseURI.resolve(uri2);
            URL url2 = resolvedURI2.toURL();
            System.out.println("URL = " + url2);

            URI resolvedURI3 = baseURI.resolve(uri3);
            URL url3 = resolvedURI3.toURL();
            System.out.println("URL = " + url3);

        } catch (URISyntaxException e) {
            System.out.println("Bad URI syntax: " + e.getMessage());
        } catch (MalformedURLException e) {
            System.out.println("URL Malformed: " + e.getMessage());
        }
    }
}
