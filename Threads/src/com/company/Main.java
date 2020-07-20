package com.company;

import static com.company.ThreadColor.*;

public class Main {

    /**
     * Every Java application has a process attached to it. And every process may contain one or more threads.
     * The process will at least have the main thread which leads to the execution of the Java program.
     * It is entirely up to the system and underlying on when the threads gets executed. A process when executed has its
     * own memory called HEAP. And every thread has its own thread stack.
     * Concurrency is nothing but running multiple threads parallel with each other.
     * We can set the execution priority of a particular thread but that being said, we can never assume, threads will
     * run in a particular order.
     */

    public static void main(String[] args) {
        System.out.println(ANSI_PURPLE + "Hello from the main thread!");

        // Create instance of AnotherThread class and invoke its run method

        Thread anotherThread = new AnotherThread();
        anotherThread.start();  // invoke the run method by calling the start() method of Thread instance

        /*
        When we use the anonymous class, we need to start the thread immediately. Refer to below code for example.
         */

        new Thread() {
            public void  run() {
                System.out.println(ANSI_GREEN + "Hello from anonymous class thread");
            }
        }.start();

        Thread myRunnableThread = new Thread(new MyRunnable());
        myRunnableThread.start();

        System.out.println(ANSI_RED + "Hello again from main thread");

        /*
        Note that we are not allowed to start the same instance of anotherThread class more than once.
         */

//        anotherThread.start();  // This will throw java.lang.IllegalThreadStateException since we are not allowed to
//        start the same instance of anotherThread more than once.


    }
}
