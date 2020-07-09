package com.company;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class Main {

    public static void main(String[] args) {
        // we will be creating channel to read and write file. We can create channel using FileInputStream,
        // FileOutputStream and RandomAccessFile

        try {
            FileInputStream file = new FileInputStream("data.txt");
            FileChannel channel = file.getChannel();  // Getting the channel of the file using FileInputStream instance
                                                      // and method getChannel

        } catch (IOException e) {
            System.out.println("IOException " + e.getMessage());
        }

    }
}
