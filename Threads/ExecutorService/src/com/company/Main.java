package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

import static com.company.Main.EOF;

public class Main {

    /**
     * In this lesson, we are going to learn about ExecutorService implementation. Using this interface, we need not
     * worry about Thread Scheduling, execution, termination. It allows us to focus on executing the code than managing
     * the threads along with code. It uses the concept of Thread Pools in Java. In typical scenario, developer tests
     * the application multiple times to check how many threads are needed to run the application without any hassle.
     *
     * Instead of starting the threads manually, we can just call the execute() method of this interface.
     *
     */

    public static final String EOF = "EOF";

    public static void main(String[] args) {

        List<String> buffer = new ArrayList<>();
        ReentrantLock bufferLock = new ReentrantLock(true);

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        MyProducer producer = new MyProducer(ThreadColor.ANSI_BLUE, buffer, bufferLock);
        MyConsumer consumer1 = new MyConsumer(ThreadColor.ANSI_CYAN, buffer, bufferLock);
        MyConsumer consumer2 = new MyConsumer(ThreadColor.ANSI_PURPLE, buffer, bufferLock);

//        new Thread(producer).start();
//        new Thread(consumer1).start();
//        new Thread(consumer2).start();

        // We are going to use the ExecutorService to run the execution of threads.

        executorService.execute(producer);
        executorService.execute(consumer1);
        executorService.execute(consumer2);

        /*
        If we want to use the value of the thread which runs in the background, then we can use the submit method which
        accepts the callable object which is similar to runnable object except that it can return a value of object of
        type future.
         */

        Future<String> future = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println(ThreadColor.ANSI_WHITE + "I'm being printed from the callable class.");
                return "This is the callable result";
            }
        });

        try {
            System.out.println(future.get());
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
    }
}

class MyProducer implements Runnable {
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

        System.out.println(color + "Adding EOF");
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

    public MyConsumer(String color, List<String> buffer, ReentrantLock bufferLock) {
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
                    continue;
                }
                if (buffer.get(0).equals(EOF)) {
                    System.out.println(color + "Reached EOF and exiting");
                    break;
                } else {
                    System.out.println(color + "Removed " + buffer.remove(0));
                }
            } finally {
                bufferLock.unlock();
            }
        }
    }
}