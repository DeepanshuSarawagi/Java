package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.company.Main.EOF;

/**
 * Why do we need to synchronize methods in class MyProducer and MyConsumer? Again, the reason is very simple.
 * We have created two threads in class Main, one for Producer and two for consumers. When Producer puts a
 * message/string in the ArrayList, the thread suspends, then Consumer1 thread runs and checks if List is empty and
 * returns false and gets suspended. Following that, Consumer 2 thread runs and checks if list is empty and it returns
 * false, following that it removes the element from the list. When consumer1 thread runs again, it resumes to remove
 * the element from the list and the result will be ArrayIndexOutOfBoundsException because the element has already been
 * removed by thread Consumer2.
 *
 * As we learned in the lecture, in the Collections framework, ArrayList is not Thread safe or Thread synchronized. And
 * since we are sharing the same ArrayList among three threads, we would run into many problems like this. To avoid this
 * problem, we need to synchronize the methods/statement in both MyProducer and MyConsumer classes.
 */

public class Main {

    public static final String EOF = "EOF";

    public static void main(String[] args) {
        List<String> buffer = new ArrayList<>();
//        List<String> synchronizedList = Collections.synchronizedList(buffer);
        MyProducer producer = new MyProducer(buffer, ThreadColor.ANSI_BLUE);
        MyConsumer consumer1 = new MyConsumer(buffer, ThreadColor.ANSI_GREEN);
        MyConsumer consumer2 = new MyConsumer(buffer, ThreadColor.ANSI_CYAN);

        new Thread(producer).start();
        new Thread(consumer1).start();
        new Thread(consumer2).start();
    }
}

class MyProducer implements Runnable {

    private List<String> buffer;
    private String color;

    public MyProducer(List<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    public void run() {
        Random random = new Random();
        String[] nums = {"1", "2", "3", "4", "5"};

        for (String num : nums) {
            try {
                System.out.println(color + "Adding.. " + num);
                synchronized (buffer) {
                    buffer.add(num);
                }

                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(color + "Adding EOF and exiting...");
        synchronized (buffer) {
            buffer.add("EOF");
        }
    }
}

class MyConsumer implements Runnable {
    private List<String> buffer;
    private String color;

    public MyConsumer(List<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    public void run() {
        while (true) {
            synchronized (buffer) {

                if (buffer.isEmpty()) {
                    continue;
                }
                if (buffer.get(0).equals(EOF)) {
                    System.out.println(color + "Exiting");
                    break;
                } else {
                    System.out.println(color + "removed " + buffer.remove(0));
                }
            }
        }
    }
}