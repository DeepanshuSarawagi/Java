package com.company;

import java.io.IOException;
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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
