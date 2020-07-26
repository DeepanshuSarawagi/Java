package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

import static com.company.Main.EOF;

/**
 * Why do we need to synchronize methods in class MyProducer and MyConsumer? Again, the reason is very simple.
 * We have created two threads in class Main, one for Producer and two for consumers. When Producer puts a
 * message/string in the ArrayList, the thread suspends, then Consumer1 thread runs and checks if List is empty and
 * returns false and gets suspended. Following that, Consumer 2 thread runs and checks if list is empty and it returns
 * false, following that it removes the element from the list. When consumer1 thread runs again, it resumes to remove
 * the element from the list and the result will be ArrayIndexOutOfBoundsException because the element has already been
 * removed by thread Consumer2.
 * <p>
 * As we learned in the lecture, in the Collections framework, ArrayList is not Thread safe or Thread synchronized. And
 * since we are sharing the same ArrayList among three threads, we would run into many problems like this. To avoid this
 * problem, we need to synchronize the methods/statement in both MyProducer and MyConsumer classes.
 * <p>
 * The reason we have synchronized all the blocks of code in the run() method of MyConsumer class is because we do not
 * want other Consumer thread or Producer thread to make any changes to the arrayList when a consumer thread has checked
 * if the buffer is empty. In other words, if a thread has checked whether the ArrayList is empty, then we want thread
 * to execute other statements based on the result rather than getting suspended. This way we ensure an action has been
 * taken when the thread checks of the empty list and the remaining threads cannot modify/change the list.
 */

/**
 * Few drawbacks of Synchronizing methods:
 *          1) Threads that are blocked waiting to execute synchronized code can't be interrupted, once they are blocked
 *          they are stuck there waiting to get lock of the object the code is synchronizing on.
 *          2) Synchronizing block must be within the same methods. In other words, we can't start the synchronizing
 *          block in one method and end in other method.
 *          3) We can't test the code to see if an object's intrinsic lock is available or find out any other
 *          information about that lock.
 *          4) Also, if multiple threads are waiting to get the lock on the object the code is synchronizing on,
 *          then its on first come first served basis. It is the JVM and the underlying operating system which decides
 *          which thread should get the lock.
 */

/**
 * To overcome the drawbacks of Synchronizing code, we will use the ReEntrantLock interface to lock and unlock objects
 * the code is synchronizing on. It will be our responsibility to lock and unlock the block of code.
 * When a thread has obtained the lock for the object, it will continue executing. Other threads which are waiting to
 * get the lock will remain blocked until the thread which obtained the lock finished executing and releases the lock.
 * If we do not release the lock manually then the threads will remain blocked waiting to get the lock of the Objects
 * and the thread which has the lock will throw a Runtime Exception as follows, Exception in thread "Thread-1"
 * java.lang.Error: Maximum lock count exceeded. Hence, it is very important that we manually release the lock of the
 * object the code is synchronizing on.
 */

public class Main {

    public static final String EOF = "EOF";

    public static void main(String[] args) {
        List<String> buffer = new ArrayList<>();
//        List<String> synchronizedList = Collections.synchronizedList(buffer);
        ReentrantLock bufferLock = new ReentrantLock();
        MyProducer producer = new MyProducer(buffer, ThreadColor.ANSI_BLUE, bufferLock);
        MyConsumer consumer1 = new MyConsumer(buffer, ThreadColor.ANSI_GREEN, bufferLock);
        MyConsumer consumer2 = new MyConsumer(buffer, ThreadColor.ANSI_CYAN, bufferLock);

        new Thread(producer).start();
        new Thread(consumer1).start();
        new Thread(consumer2).start();
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

    public void run() {
        Random random = new Random();
        String[] nums = {"1", "2", "3", "4", "5"};

        for (String num : nums) {
            try {
                System.out.println(color + "Adding.. " + num);
                bufferLock.lock();
                buffer.add(num);
                bufferLock.unlock();

                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(color + "Adding EOF and exiting...");
        bufferLock.lock();
        buffer.add("EOF");
        bufferLock.unlock();
    }
}

class MyConsumer implements Runnable {
    private List<String> buffer;
    private String color;
    private ReentrantLock bufferLock;

    public MyConsumer(List<String> buffer, String color, ReentrantLock bufferLock) {
        this.buffer = buffer;
        this.color = color;
        this.bufferLock = bufferLock;
    }

    public void run() {
        while (true) {
            bufferLock.lock();
            if (buffer.isEmpty()) {
                bufferLock.unlock();  // If we do not release the lock here, then the object buffer is locked forever
                // by the consumer thread and the Producer Thread will still frozen since it wont be able to add any
                // more data to the buffer object.
                continue;
            }
            if (buffer.get(0).equals(EOF)) {
                System.out.println(color + "Exiting");
                bufferLock.unlock();  // If we have the EOF element in the list, then it is necessary to release the lock
                // so that buffer object is released and the other consumer thread can obtain lock on it.
                break;
            } else {
                System.out.println(color + "removed " + buffer.remove(0));
            }
            bufferLock.unlock();
        }
    }
}