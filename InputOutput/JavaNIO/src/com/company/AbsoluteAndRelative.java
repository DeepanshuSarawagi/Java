package com.company;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class AbsoluteAndRelative {
    public static void main(String[] args) {
        try(FileOutputStream binFile = new FileOutputStream("data1.dat");
            FileChannel binChannel = binFile.getChannel()) {
            byte[] outputBytes = "Hello World!".getBytes();
            ByteBuffer buffer = ByteBuffer.allocate(100);
            buffer.put(outputBytes);
            buffer.putInt(245);
            buffer.putInt(-91465);
            outputBytes = "Nice to meet you!".getBytes();
            buffer.put(outputBytes);
            buffer.putInt(1000);

            // We need to do a flip here since we are switching from writing to a buffer to reading from a buffer

            buffer.flip();
            binChannel.write(buffer);

        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
    }
}
