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

        /*
         Create instance of AnotherThread class and invoke its run method.
         Remember that we should not directly invoke the run() method of the thread. Instead, we should call the
         start method of the thread and the jvm will then call the run() method of the thread for us. Calling the run()
          method directly, will not run the application/code from the new thread instead it will run on the same thread
          from the same thread where its c.
         */

        Thread anotherThread = new AnotherThread();
        anotherThread.setName("== Another Thread ==");
        anotherThread.start();  // invoke the run method by calling the start() method of Thread instance
//        anotherThread.run();  // we should not do this.

        /*
        When we use the anonymous class, we need to start the thread immediately. Refer to below code for example.
         */

        new Thread() {
            public void  run() {
                System.out.println(ANSI_GREEN + "Hello from anonymous class thread");
            }
        }.start();

        Thread myRunnableThread = new Thread(new MyRunnable(){
            @Override
            public void run() {
                System.out.println(ANSI_CYAN + "Hello from anonymous class's implementation of run()");
                try {
                    anotherThread.join(2000);
                    System.out.println(ANSI_CYAN + "AnotherThread interrupted or timed out, so I'm running again.");
                } catch (InterruptedException e) {
                    System.out.println(ANSI_CYAN + "I couldn't wait after all. I was interrupted.");
                }
            }
        });
        myRunnableThread.start();
//        anotherThread.interrupt();   //  This is done to interrupt a thread

        System.out.println(ANSI_RED + "Hello again from main thread");

        /*
        Note that we are not allowed to start the same instance of anotherThread class more than once.
         */

//        anotherThread.start();  // This will throw java.lang.IllegalThreadStateException since we are not allowed to
//        start the same instance of anotherThread more than once.


    }
}
