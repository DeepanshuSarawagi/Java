package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello from the main thread!");

        // Create instance of AnotherThread class and invoke its run method

        Thread anotherThread = new AnotherThread();
        anotherThread.start();  // invoke the run method by calling the start() method of Thread instance
        System.out.println("Hello again from main thread");
    }
}
