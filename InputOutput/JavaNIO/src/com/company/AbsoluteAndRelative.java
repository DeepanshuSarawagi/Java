package com.company;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class AbsoluteAndRelative {
    public static void main(String[] args) {
        try(FileOutputStream binFile = new FileOutputStream("data1.dat");
            FileChannel binChannel = binFile.getChannel()) {
//            byte[] outputBytes = "Hello World!".getBytes();
//            ByteBuffer buffer = ByteBuffer.allocate(100);
//            buffer.put(outputBytes);
//            buffer.putInt(245);
//            buffer.putInt(-91465);
//            byte[] outputBytes2 = "Nice to meet you!".getBytes();
//            buffer.put(outputBytes2);
//            buffer.putInt(1000);

            // Demonstration of chained puts in buffer

            byte[] outputBytes = "Hello World!".getBytes();
            byte[] outputBytes2 = "Nice to meet you!".getBytes();
            ByteBuffer buffer = ByteBuffer.allocate(100);
            buffer.put(outputBytes).putInt(245).putInt(-91465).put(outputBytes2).putInt(1000);

            // We need to do a flip here since we are switching from writing to a buffer to reading from a buffer

            buffer.flip();
            binChannel.write(buffer);

            // Let's read the contents of the file

            RandomAccessFile ra = new RandomAccessFile("data1.dat", "rwd");
            FileChannel channel = ra.getChannel();
            ByteBuffer readBuffer = ByteBuffer.allocate(100);
            channel.read(readBuffer);
            readBuffer.flip();
            byte[] inputString = new byte[outputBytes.length];
            readBuffer.get(inputString);
            System.out.println("String 1 = " + new String(outputBytes));
            System.out.println("int1 = " + readBuffer.getInt());
            System.out.println("int2 = " + readBuffer.getInt());
            byte[] inputString2 = new byte[outputBytes2.length];
            readBuffer.get(inputString2);
            System.out.println("String 2 = " + new String(outputBytes2));
            System.out.println("int3 = " + readBuffer.getInt());

        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
    }
}
