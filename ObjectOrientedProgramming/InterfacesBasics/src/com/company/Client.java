package com.company;

public class Client implements Callback {

    @Override
    public void callBack(int param) {
        System.out.println("Callback called with " + param);
    }
    public void tryAccessingMe() {
        System.out.println("Congratulations! you have worked out to access me.");
    }
}
