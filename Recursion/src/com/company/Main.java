package com.company;

public class Main {

    public static void main(String[] args) {
	    factorial f = new factorial();
        System.out.println("Factorial of 5 is " + f.fact(5));

        RecTest r = new RecTest(10);
        for (int i=0; i<10; i++) {
            r.values[i] = i;
        }

        r.printArray(10);

    }
}

class factorial{
    int fact(int n) {
        int result;
        if (n==1) {
            return 1;
        } else {
            result = fact(n-1) * n;
        }
        return result;
    }

}

class RecTest {
    int[] values;

    RecTest(int i) {
        values = new int[i];
    }

    // display array using recursion
    void printArray(int n) {
        if (n==0) {
            return;
        } else {
            printArray(n-1);
            System.out.println("[" + (n-1) +"] " + values[n-1]);
        }
    }
}