package com.company;

public class Main {

    public static void main(String[] args) {
        Countdown countdown1 = new Countdown();
        Countdown countdown2 = new Countdown();

        CountdownThread t1 = new CountdownThread(countdown1);
        t1.setName("Thread 1");
        CountdownThread t2 = new CountdownThread(countdown2);
        t2.setName("Thread 2");

        t1.start();
        t2.start();

    }
}

class Countdown{
    /**
     * Here we are going to understand more about multiple threads. As we can see that we have created an instance
     * variable or field in this class and we are using this field in the for loop. In the Main method of the main class,
     * we have created two instances of class CountdownThread extending Thread class. These two threads use the same
     * countdown object.
     * A thread has its own thread stack which will consist of a copy of its local variables. But multiples threads
     * share the heap allocated to the java program. All the threads will share the heap allocated to run the code.
     * Heap memory also consists of all the instance fields/variables. Hence, multiple threads created will share this
     * variable in the heap rather than having its own copy in the thread stack.
     * Due to this, when the program is run, we will that both the threads will not print the value of i from 10 to 1.
     * Instead it will share this instance field "i". So initially both the threads run and have the value of i to be 10.
     * When they are suspended, the Thread 1 when run again would change the value of i, hence, when thread 2 is run, it
     * will pick up the value of i last changed by thread 1 and will decrement it.
     * If you see threads printing the value of i in un-orderly fashion then its because Thread can get suspended at
     * many exit points. For e.g. Thread 1 may decrement the value of 1 but would get suspended before it prints it.
     * Hence, Thread 2 may continue printing the value of i and when Thread 1 resumes it would start at printing the
     * println statement. This behaviour of Threads getting suspended is really unpredictable, hence, you may see
     * varying results each time you run the code.
     *
     * When multiple threads are accessing the same resources and they update it then this process is called as Thread
     * Interference in Java.
     */

    /**
     * A simple way to avoid to Thread Interference is to create two different objects of Countdown class and pass it to
     * the Threads. This way both the Threads has its own copy of the objects in the heap and both the Threads will
     * access its own copy of variable "i". As learned earlier, Thread 11s stack will not be accessed by Thread 2 and
     * vice versa.
     */

    private int i;
    public void doCountdown() {
        String color;

        switch (Thread.currentThread().getName()) {
            case "Thread 1":
                color = ThreadColor.ANSI_CYAN;
                break;
            case "Thread 2":
                color = ThreadColor.ANSI_PURPLE;
                break;
            default:
                color = ThreadColor.ANSI_GREEN;
        }

        for (i=10; i>0; i--) {
            System.out.println(color + Thread.currentThread().getName() + ": i =" + i);
        }
    }
}

class CountdownThread extends Thread {
    private Countdown threadCountdown;

    public CountdownThread(Countdown countdown) {
        this.threadCountdown = countdown;
    }

    @Override
    public void run() {
        threadCountdown.doCountdown();
    }
}
