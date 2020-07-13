package com.company;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;

public class Pipes {

    /**
     * Pipes are used to transfer data from one file to another using threads.
     * Pipes got two channels, sinkChannel and sourceChannel. We use pipes to write from sink channel and read from
     * source channel.
     */

    public static void main(String[] args) {
        try {
            Pipe pipe = Pipe.open();
            Runnable writer = new Runnable() {
                @Override
                public void run() {
                    try {
                        Pipe.SinkChannel sinkChannel = pipe.sink();  // Using pipe to create a sink channel to write
                        // the data to the file
                        ByteBuffer buffer = ByteBuffer.allocate(56);

                        for (int i=0; i<10; i++) {
                            String currentTime = "The time is " + System.currentTimeMillis();
                            buffer.put(currentTime.getBytes());   // We are writing 10 Strings of current time in
                            // milliseconds.
                            buffer.flip();  // We need to flip the buffer after each write operation on buffer

                            while (buffer.hasRemaining()) {
                                sinkChannel.write(buffer);   // We are now reading from the buffer to write data in the
                                // channel.
                            }
                            buffer.flip();   // Once the data is written in channel from buffer, we are flipping it
                            // again for next iteration of the loop.

                            Thread.sleep(100);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };

            Runnable reader = new Runnable() {
                @Override
                public void run() {
                    try {
                        Pipe.SourceChannel sourceChannel = pipe.source();
                        ByteBuffer buffer = ByteBuffer.allocate(56);

                        for (int i=0; i<10; i++) {
                            int bytesRead = sourceChannel.read(buffer);
                            byte[] timeString = new byte[bytesRead];
                            buffer.flip();
                            buffer.get(timeString);
                            System.out.println("Reader thread: " + new String(timeString));
                            buffer.flip();
                            Thread.sleep(100);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
