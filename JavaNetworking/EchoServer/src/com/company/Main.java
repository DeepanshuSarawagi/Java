package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {
        try(ServerSocket serverSocket = new ServerSocket(5000)) {
            Socket socket = serverSocket.accept();  // We block the ServerSocket until we have the server to listen to
            // the clients on the port we have assigned. Hence, we use the ServerSocket.accept() method which returns
            // the Socket instance. This will be the socket used to communicate with the client. The accept() method is
            // going to block until the client connects to the server
            System.out.println("Client connected");

            // We use Input and Output Stream to send input to the client and receive data from the client. It is a
            // common practice to wrap the input stream inside BufferedInputReader and output stream in PrintWriter.

            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true); // the second argument "true"
            // is used to specify if we want to autoFlush the stream
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
