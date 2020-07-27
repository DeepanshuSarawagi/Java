package com.company;

import javax.swing.plaf.TableHeaderUI;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static com.company.Main.EOF;

public class Main {

    /**
     * We will use the ArrayBlockingQueue interface which is a thread safe and perfect for producer-consumer type
     * applications. All the queue classes implements the blocking queue interface. It processes the elements in the
     * FIFO order which is exactly what we want here.
     * <p>
     * The add() and remove() method will throw an exception if the operation cannot be performed immediately because
     * the another thread has got the queue locked. The put() and take() will block when the queue is locked. Hence, we
     * are going to use the put() and take() method to add or remove element from the queue.
     */

    public static final String EOF = "EOF";

    public static void main(String[] args) {
        ArrayBlockingQueue<String> buffer = new ArrayBlockingQueue<>(6);

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        MyProducer producer = new MyProducer(buffer, ThreadColor.ANSI_BLUE);
        MyConsumer consumer1 = new MyConsumer(buffer, ThreadColor.ANSI_YELLOW);
        MyConsumer consumer2 = new MyConsumer(buffer, ThreadColor.ANSI_GREEN);

        executorService.execute(producer);
        executorService.execute(consumer1);
        executorService.execute(consumer2);

        executorService.shutdown();

    }
}

class MyProducer implements Runnable {
    private ArrayBlockingQueue<String> buffer;
    private String color;

    public MyProducer(ArrayBlockingQueue<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    @Override
    public void run() {
        Random random = new Random();
        String[] nums = {"1", "2", "3", "4", "5"};

        try {
            for (String num : nums) {
                System.out.println(color + "Adding " + num);
                buffer.put(num);
            }
            Thread.sleep(random.nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(color + "Adding EOF and exiting");
        try {
            buffer.put("EOF");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyConsumer implements Runnable {
    private ArrayBlockingQueue<String> buffer;
    private String color;

    public MyConsumer(ArrayBlockingQueue<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    @Override
    public void run() {
        while (true) {
            try {
                if (buffer.isEmpty()) {
                    continue;
                }
                if (buffer.peek().equals(EOF)) {
                    System.out.println(color + "Reached EOF and exiting");
                    break;
                } else {
                    System.out.println(color + "Removed " + buffer.take());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
