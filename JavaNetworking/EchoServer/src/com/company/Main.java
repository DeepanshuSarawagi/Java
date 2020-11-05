package com.company;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {
        try(ServerSocket serverSocket = new ServerSocket(5000)) {
            Socket socket = serverSocket.accept();  // We block the ServerSocket until we have the server to listen to
            // the clients on the port we have assigned. Hence, we use the ServerSocket.accept() method which returns
            // the Socket instance. This will be the socket used to communicate with the client.
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
