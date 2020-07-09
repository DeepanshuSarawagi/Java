package com.company;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // we will be creating channel to read and write file. We can create channel using FileInputStream,
        // FileOutputStream and RandomAccessFile

        try {
//            FileInputStream file = new FileInputStream("data.txt");
//            FileChannel channel = file.getChannel();  // Getting the channel of the file using FileInputStream instance
//                                                      // and method getChannel. We only need one channel for reading and
//                                                      // writing

            Path dataPath = FileSystems.getDefault().getPath("data.txt");
            List<String> lines = Files.readAllLines(dataPath);
            for (String line : lines) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("IOException " + e.getMessage());
        }

    }
}
