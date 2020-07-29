package com.company;

import java.util.concurrent.locks.ReentrantLock;

public class SayHello {
    public static void main(String[] args) {
        ReentrantLock bufferLock = new ReentrantLock();
        PolitePerson jane = new PolitePerson("Jane", bufferLock);
        PolitePerson john = new PolitePerson("John", bufferLock);

//        jane.SayHello(john);
//        john.SayHello(jane);

        new Thread(new Runnable() {
            @Override
            public void run() {
                jane.SayHello(john);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                john.SayHello(jane);
            }
        }).start();
    }

    private static class PolitePerson{
        private final String name;
        private ReentrantLock bufferLock;

        public PolitePerson(String name, ReentrantLock bufferLock) {
            this.name = name;
            this.bufferLock = bufferLock;
        }

        public String getName() {
            return name;
        }

        public void SayHello(PolitePerson person) {
            bufferLock.lock();
            try {
                System.out.format("%s: %s has said Hello to me%n", this.name, person.getName());
                person.SayHelloBack(this);
            } finally {
                bufferLock.unlock();
            }

        }

        public void SayHelloBack(PolitePerson person) {
            bufferLock.lock();
            try {
                System.out.format("%s: %s has said Hello back to me%n", this.name, person.getName());
            } finally {
                bufferLock.unlock();
            }

        }
    }
}
