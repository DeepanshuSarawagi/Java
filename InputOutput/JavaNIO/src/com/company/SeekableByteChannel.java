package com.company;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
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
 * FileChannel implements the SeekableByteChannel interface
 */

public class SeekableByteChannel {
    public static void main(String[] args) {
        try (FileOutputStream binFile = new FileOutputStream("data2.dat");
             FileChannel binChannel = binFile.getChannel()){
            ByteBuffer buffer = ByteBuffer.allocate(100);
            byte[] outputByes = "Hello World!".getBytes();
            buffer.put(outputByes);
            long int1pos = outputByes.length;
            buffer.putInt(245);
            long int2pos = int1pos + Integer.BYTES;
            buffer.putInt(-91465);
            byte[] outputBytes2 = "Nice to meet you!".getBytes();
            buffer.put(outputBytes2);
            long int3pos = int2pos + Integer.BYTES + outputBytes2.length;
            buffer.putInt(1000);

            buffer.flip();
            binChannel.write(buffer);

            // reading data using nio and seekable byte channel

            RandomAccessFile ra = new RandomAccessFile("data2.dat", "rwd");
            FileChannel channel = ra.getChannel();
            buffer.flip();
            channel.position(int3pos);
            channel.read(buffer);
            buffer.flip();
            System.out.println("int3 = " + buffer.getInt());

            buffer.flip();
            channel.position(int2pos);
            channel.read(buffer);
            buffer.flip();
            System.out.println("int2 = " + buffer.getInt());

            buffer.flip();
            channel.position(int1pos);
            channel.read(buffer);
            buffer.flip();
            System.out.println("int1 " + buffer.getInt());

            /*
            Here we are going to write data in the random fashion.
             */

            byte[] outputString = "Hello, World!".getBytes();
            long str1Pos = 0;
            long newInt1Pos = outputString.length;
            long newInt2Pos = newInt1Pos + Integer.BYTES;
            byte[] outputString2 = "Nice to meet you".getBytes();
            long str2Pos = newInt2Pos + outputString2.length;
            long newInt3Pos = str2Pos + outputString2.length;

            ByteBuffer intBuffer = ByteBuffer.allocate(Integer.BYTES);
            intBuffer.putInt(245);
            intBuffer.flip();
            binChannel.position(newInt1Pos);
            binChannel.write(intBuffer);

            intBuffer.flip();
            intBuffer.putInt(-91465);
            intBuffer.flip();
            binChannel.position(newInt2Pos);
            binChannel.write(intBuffer);

            intBuffer.flip();
            intBuffer.putInt(1000);
            intBuffer.flip();
            binChannel.position(newInt3Pos);
            binChannel.write(intBuffer);

            binChannel.position(str1Pos);
            binChannel.write(ByteBuffer.wrap(outputString));
            binChannel.position(str2Pos);
            binChannel.write(ByteBuffer.wrap(outputString2));

            /*
            We will now use the fileChannel to copy from one file to another. We will be copying from data2.dat to
            data2copy.dat using the method called transferFrom. Important point to take away here is that we need a
            readable byte channel to copy the data from.

            transferFrom() accepts three arguments.
            1. Source channel
            2. Source Channel Position
            3. Source Channel Size.
            Hence, the method with arguments looks like this transferFrom(ReadableByteChannel src, long Position,
            long ChannelSize)
             */

            RandomAccessFile copyFile = new RandomAccessFile("data2copy.dat", "rw");
            FileChannel copyChannel = copyFile.getChannel();
            channel.position(0);    // resetting the channel position to zero
            long numsTransferred = copyChannel.transferFrom(channel, 0, channel.size());
            System.out.println("Number of bytes transferred is " + numsTransferred);

        } catch (IOException e) {
            System.out.println("IOException " + e.getMessage());
        }
    }
}
