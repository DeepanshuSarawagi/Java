package com.company;

import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] args) {

    }
}

class MyProducer implements Runnable{
    private String color;
    private List<String> buffer;
    private ReentrantLock bufferLock;

    public MyProducer(String color, List<String> buffer, ReentrantLock bufferLock) {
        this.color = color;
        this.buffer = buffer;
        this.bufferLock = bufferLock;
    }

    @Override
    public void run() {
        Random random = new Random();
        String[] nums = {"1", "2", "3", "4", "5"};
        try {
            for (String num : nums) {
                System.out.println(color + "Adding " + num);
                bufferLock.lock();
                try {
                    buffer.add(num);
                } finally {
                    bufferLock.unlock();
                }
            }
            Thread.sleep(random.nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Adding EOF");
        bufferLock.lock();
        try {
            buffer.add("EOF");
        } finally {
            bufferLock.unlock();
        }
    }
}


