package com.company;

public class ScopeCheck {
    public int publicVar = 0;
    private int privateVar = 1;

    public ScopeCheck() {
        System.out.println("PublicVar = " + publicVar + " privateVar = " + privateVar );
    }

    public int getPrivateVar() {
        return privateVar;
    }
    public void timesTwo() {
        int privateVar = 2;
        for (int i=1; i<=10; i++) {
            System.out.println(i + " times two = " + i*privateVar);
        }
    }

    public class InnerClass {
        private int privateVar = 3;

        public InnerClass() {
            System.out.println("InnerClass called and privateVar value is " + privateVar);
        }

        public void timesTwo() {
            int privateVar = 2;
            for (int i=1; i<=10; i++) {
                System.out.println(i + " times two = " + i*privateVar);
            }
        }
    }
}
