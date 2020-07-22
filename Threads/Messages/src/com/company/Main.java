package com.company;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Message message = new Message();
        (new Thread(new Writer(message))).start();
        (new Thread(new Reader(message))).start();
    }
}

class Message{
    private String message;
    private boolean empty = true;

    /*
        When we run the main method in Main class we will see that program runs forever. It is because the thread which
        runs to read the message is then deadlocked. This is because we have synchronized both read() and write()
        methods and only one synchronized method can run at a time. If one thread is looping it is holding the message
        object in its lock and the other thread is waiting for the thread to release the Message object. This scenario
        is called as DeadLocks.

        To overcome this situation, wait(), notify() and notifyall() method comes into play. While a thread calls the
        wait() method, it suspends all the operation and release all the locks its holding on the thread until a
        thread notifies that something important is happening.
    */

    public synchronized String read() {
        while (empty) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.getMessage();
            }
        }
        empty = true;
        notifyAll();
        return message;
    }

    public synchronized void write(String message) {
        while (!empty) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.getMessage();
            }
        }
        empty = false;
        this.message = message;
        notifyAll();
    }
}

class Writer implements Runnable{
    private Message message;

    public Writer(Message message) {
        this.message = message;
    }

    public void run() {
        String[] messages = {"Humpty Dumpty sat on the wall",
                             "Humpty Dumpty had a great fall",
                             "All the king`s horses and king`s men",
                             "Couldn't put Humpty together again"};
        Random random = new Random();

        for (int i=0; i<messages.length; i++) {
            message.write(messages[i]);
            try {
                Thread.sleep(random.nextInt(2000));
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        message.write("Finished");
    }
}

class Reader implements Runnable {
    private Message message;

    public Reader(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        Random random = new Random();
        for (String latestMessage = message.read(); !latestMessage.equals("Finished");
             latestMessage = message.read()) {
            System.out.println(latestMessage);
            try {
                Thread.sleep(random.nextInt(2000));
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
