package com.company;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * This is a small document about seekable byte channel interface
 * read(ByteBuffer) - reads bytes at the channel`s current position and after the read updates the position accordingly
 *                    Note that now we are talking about the channel`s current position and not the buffer`s position.
 *                    Of course the bytes will be placed into the buffer based on the buffer`s current position.
 * write(ByteBuffer) - The same as read, except it writes. There's one exception.
 *                     If the datasource is opened in the APPEND mode, then the first write will take place starting at
 *                     the end of the datasource, rather than at position 0. After the write, the position will be
 *                     updated accordingly.
 * position() - returns the channel`s current position
 * position(long) - sets the channel`s position to the passed value
 * truncate(long) - truncates the size of the datasource based on the passed value
 * size() - returns the size of the attached datasource
 */

public class SeekableByteChannel {
    public static void main(String[] args) {
        try (FileOutputStream binFile = new FileOutputStream("data2.dat");
             FileChannel binChannel = binFile.getChannel()){
            ByteBuffer buffer = ByteBuffer.allocate(100);
            byte[] outputByes = "Hello World!".getBytes();
            buffer.put(outputByes);
            buffer.putInt(245);
            buffer.putInt(-91465);
            byte[] outputBytes2 = "Nice to meet you!".getBytes();
            buffer.put(outputBytes2);
            buffer.putInt(1000);

            buffer.flip();
            binChannel.write(buffer);
        } catch (IOException e) {
            System.out.println("IOException " + e.getMessage());
        }
    }
}
