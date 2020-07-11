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

        try (FileOutputStream binFile = new FileOutputStream("data.dat");
            FileChannel binChannel = binFile.getChannel()) {
            byte[] outputByte = "Hello World!".getBytes();   // We are calling this create the byte array and convert the
                                                            // string to byte using getByte() method.

            // Next we call the static method ByteBuffer.wrap() method to wrap the byte array into Buffer. Modifications
            // to the buffer will change the array and modifications to the array will change the buffer. When we create
            // the, it sets the position to 0. When we do the read/write operation in the buffer, its start position
            // will be at zero. Also, it sets the buffer capacity based on the byte array length and the buffer mark will
            // be undefined.

            ByteBuffer buffer = ByteBuffer.wrap(outputByte);
            int bytes = binChannel.write(buffer);
            System.out.println("Number of bytes written " + bytes);

            // Now we are going to write the integer to the dat file

            ByteBuffer intBuffer = ByteBuffer.allocate(Integer.BYTES);
            intBuffer.putInt(245);
            intBuffer.flip();
            bytes = binChannel.write(intBuffer);
            System.out.println("Number of bytes written are " + bytes);

            // After printing the above line, you will notice that no. of bytes written is zero. That's because, when we
            // created the buffer, we created it at position zero. Hence, we put the integer in the buffer using the
            // putInt() method, it changed the buffer position. And when we wrote the buffer in the channel, it will
            // start reading the bytes from the buffer's position. So we have to explicitly reset the position of the
            // buffer to start reading it from the beginning. To reset the buffer, we need to call the buffer.flip()
            // method which resets the buffer position to zero and discards any marks left behind. We didn't have to
            // reset the position of the buffer when we used the wrap method, that's because it automatically resets the
            // buffer's position to zero.

            // write a large negative integer to the channel

            // Now if we run the main method, the program will crash with java.nio.BufferOverflowException. Reason
            // behind this is, we allocated the max Integer Bytes which 4 (One Integer has 4 Bytes). So, the buffer
            // position will be at 4. And if we do not reset the buffer to put a new Integer, it will throw
            // ByteOverflowException. Hence, we need to reset the buffer position to zero and then again reset it to
            // zero before writing the buffer to the channel.

            intBuffer.flip();
            intBuffer.putInt(-9813449);
            intBuffer.flip();
            bytes = binChannel.write(intBuffer);
            System.out.println("Number of bytes written are " + bytes);

        } catch (IOException e) {
            System.out.println("IoException " + e.getMessage());
        }

    }
}
