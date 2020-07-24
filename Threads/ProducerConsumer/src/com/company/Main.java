package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static com.company.Main.EOF;

public class Main {

    public static final String EOF = "EOF";

    public static void main(String[] args) {
        List<String> buffer = new ArrayList<>();
        List<String> synchronizedList = Collections.synchronizedList(buffer);
        MyProducer producer = new MyProducer(synchronizedList, ThreadColor.ANSI_BLUE);
        MyConsumer consumer1 = new MyConsumer(synchronizedList, ThreadColor.ANSI_GREEN);
        MyConsumer consumer2 = new MyConsumer(synchronizedList, ThreadColor.ANSI_CYAN);

        new Thread(producer).start();
        new Thread(consumer1).start();
        new Thread(consumer2).start();
    }
}

class MyProducer implements Runnable{

    private List<String> buffer;
    private String color;

    public MyProducer(List<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    @Override
    public void run() {
        Random random = new Random();
        String[] nums = {"1", "2", "3", "4", "5"};

        for (String num:nums) {
            try {
                System.out.println(color + "Adding.. " + num);
                buffer.add(num);

                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(color + "Adding EOF and exiting...");
        buffer.add("EOF");
    }
}

class MyConsumer implements Runnable{
    private List<String> buffer;
    private String color;

    public MyConsumer(List<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    @Override
    public void run() {
        while (true) {
            if (buffer.isEmpty()) {
                continue;
            }
            if (buffer.get(0).equals(EOF)) {
                System.out.println(color + "Exiting");
                break;
            } else {
                System.out.println(color + "removed " + buffer.get(0));
            }
        }
    }
}
