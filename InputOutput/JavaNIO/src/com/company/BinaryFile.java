package com.company;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class BinaryFile {
    public static void main(String[] args) {
        /**
         * In this lesson we are going to learn about writing Binary files using Java NIO.
         */

        try {
            FileOutputStream binFile = new FileOutputStream("data.dat");
            FileChannel binChannel = binFile.getChannel();
            byte[] outputByte = "Hello World".getBytes();   // We are calling this create the byte array and convert the
                                                            // string to byte using getByte() method.
            ByteBuffer buffer = ByteBuffer.wrap(outputByte);
            binChannel.write(buffer);

            // Next we call the static method ByteBuffer.wrap() method to wrap the byte array into Buffer. Modifications
            // to the buffer will change the array and modifications to the array will change the buffer. When we create
            // the, it sets the position to 0. When we do the read/write operation in the buffer, its start position
            // will be at zero. Also, it sets the buffer capacity based on the byte array length and the buffer mark will
            // be undefined.

        } catch (IOException e) {
            System.out.println("IoException " + e.getMessage());
        }

    }
}
