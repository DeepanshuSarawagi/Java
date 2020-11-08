package com.company;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Main {

    public static void main(String[] args) {
        /*
        We use the User Datagram Protocol if we want to rely on the speed at which the request and response takes place.
        UDP doesn't guarantee if the message would reach the destination host instead focuses on the speed at which the
        message is delivered. Hence, there is no two way communication guarantee. Common applications which uses the UDP
        us VoIP, Skype, Video Streaming platforms since it keep delivering the data in form of packets to ensure speed
        is maintained
        We require 4 parameters to construct a Packet.
        1. Byte Array
        2. Byte Array length
        3. Host address
        4. Port
         */
        try {
            DatagramSocket socket = new DatagramSocket(5000);

            while (true) {
                byte[] buffer = new byte[50];
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);  // It is important to note that DatagramSocket.receive() method doesn't create
                // end-to-end communication between server and client.
                System.out.println("Text received is: " + new String(buffer, 0, packet.getLength()));

                String returnString = "Message from server: " + new String(buffer, 0, packet.getLength());
                byte[] buffer2 = returnString.getBytes();
                InetAddress address = packet.getAddress();
                int port = packet.getPort();
                packet = new DatagramPacket(buffer2, buffer2.length, address, port);
                socket.send(packet);

            }

        } catch (SocketException e) {
            System.out.println("Socket Exception: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
    }
}
