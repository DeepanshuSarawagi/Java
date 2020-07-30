package com.company;

public class Main {
    /**
     * A LiveLock is similar to a DeadLock except that it is waiting for other blocked threads to finish executing.
     * These threads are dependent on other threads to complete their tasks so that they can finish executing.
     *
     *
     */
    public static void main(String[] args) {
        Worker worker1 = new Worker("Worker 1", true);
        Worker worker2 = new Worker("Worker 2", true);

        SharedResource sharedResource = new SharedResource(worker1);
        new Thread(new Runnable() {
            @Override
            public void run() {
                worker1.work(sharedResource, worker2);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                worker2.work(sharedResource, worker1);
            }
        }).start();
    }
}
