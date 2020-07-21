package com.company;

public class Main {

    public static void main(String[] args) {

    }
}

class Countdown{
    public void doCountdown() {
        String color;

        switch (Thread.currentThread().getName()) {
            case "Thread 1":
                color = ThreadColor.ANSI_CYAN;
                break;
            case "thread 2":
                color = ThreadColor.ANSI_PURPLE;
                break;
            default:
                color = ThreadColor.ANSI_GREEN;
        }

        for (int i=10; i>0; i--) {
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
