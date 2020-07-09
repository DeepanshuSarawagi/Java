package com.company;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
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
            Files.write(dataPath, "\nLine 4".getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);

            /**
             * The first parameter in the Files.write method is to specify the path of the file.
             * Second parameter is to specify the data which needs to be written and then convert the data to getBytes
             * since this method writes the data in Bytes. Hence, we are converting the String to Bytes using getBytes
             * method and specify the Charset to UTF-8.
             * Third paramter is specify the openOption. If we do not specify this then the file will be truncated and
             * will be replaced with new content. Hence we need to specify the StandardOpenOption.APPEND constant to
             * write the data along with the existing data in the file.
             */

            List<String> lines = Files.readAllLines(dataPath);
            for (String line : lines) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("IOException " + e.getMessage());
        }

    }
}
