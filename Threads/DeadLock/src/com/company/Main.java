package com.company;

public class Main {

    /**
     * A Deadlock occurs when two or more threads are blocked on Locks. Every blocked thread is holding the lock
     * which another blocked thread wants. A common scenario is that Thread-1 is holding the lock1 and waiting to
     * acquire lock2 and Thread-2 is holding the lock2 and waiting to acquire lock1. None of the locks are waiting and
     * and they continue to wait until the lock is released by either of the thread and finally fails to run.
     *
     */

    public static Object lock1 = new Object();
    public static Object lock2 = new Object();

    public static void main(String[] args) {
        new Thread1().start();
        new Thread2().start();
    }

    private static class Thread1 extends Thread {
        public void run()  {
            synchronized (lock1) {
                System.out.println("Thread 1: Has lock1");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("Thread 1: waiting for lock2");
                synchronized (lock2) {
                    System.out.println("Thread 1: Has lock1 and lock2");
                }
                System.out.println("Thread 1: Released lock2");
            }
            System.out.println("Thread 1: Released lock1. Exiting...");
        }
    }

    private static class Thread2 extends Thread {
        public void run() {
            synchronized (lock1) {
                System.out.println("Thread 2: Has lock1");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("Thread 2: Waiting for lock2");
                synchronized (lock2) {
                    System.out.println("Thread 2: Has lock1 and lock2");
                }
                System.out.println("Thread 2: Released lock2");
            }
            System.out.println("Thread 2: Released lock1. Exiting...");
        }
    }
}
