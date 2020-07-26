package com.company;

import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

import static com.company.Main.EOF;

public class Main {

    public static final String EOF = "EOF";
    public static void main(String[] args) {

    }
}

class MyProducer implements Runnable {
    private List<String> buffer;
    private String color;
    private ReentrantLock bufferLock;

    public MyProducer(List<String> buffer, String color, ReentrantLock bufferLock) {
        this.buffer = buffer;
        this.color = color;
        this.bufferLock = bufferLock;
    }

    @Override
    public void run() {
        Random random = new Random();
        String[] nums = {"1", "2", "3", "4", "5"};

        try {
            for (String num : nums) {
                System.out.println(color + "Adding.. " + num);
                bufferLock.lock();
                try {
                    buffer.add(num);
                } finally {
                    bufferLock.unlock();
                }
                Thread.sleep(random.nextInt(1000));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(color + "Adding EOF and exiting..");
        bufferLock.lock();
        try {
            buffer.add("EOF");
        } finally {
            bufferLock.unlock();
        }
    }
}

class MyConsumer implements Runnable {
    private String color;
    private List<String> buffer;
    private ReentrantLock bufferLock;

    public MyConsumer(List<String> buffer, String color, ReentrantLock bufferLock) {
        this.color = color;
        this.buffer = buffer;
        this.bufferLock = bufferLock;
    }

    @Override
    public void run() {
        while (true) {
            bufferLock.lock();
            try {
                if (buffer.isEmpty()) {
                    bufferLock.unlock();
                    continue;
                }
                if (buffer.get(0).equals(EOF)) {
                    System.out.println("Reached EOF and exiting");
                    bufferLock.unlock();
                    break;
                } else {
                    System.out.println(color + "removing " + buffer.remove(0));
                }
            } finally {
                bufferLock.unlock();
            }
        }
    }
}