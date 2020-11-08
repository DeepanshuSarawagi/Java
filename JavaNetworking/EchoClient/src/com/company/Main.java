package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // For a client program, we are going to create a Socket instead of ServerSocket
        try(Socket socket = new Socket("localhost", 5000)) {
            socket.setSoTimeout(5000);
            BufferedReader echoes = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter stringToEcho = new PrintWriter(socket.getOutputStream(), true);

            Scanner scanner = new Scanner(System.in);
            String echoString;
            String response;

            do {
                System.out.println("Enter the string to be echoed: ");
                echoString = scanner.nextLine();

                stringToEcho.println(echoString);
                if (!echoString.equals("exit")) {
                    response = echoes.readLine();
                    System.out.println(response);
                }
            } while (!echoString.equals("exit"));

        } catch (SocketTimeoutException e) {
            System.out.println("Socket timedout: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Socket Exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
