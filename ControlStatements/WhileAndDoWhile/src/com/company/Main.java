package com.company;

public class Main {

    public static void main(String[] args) {
	    int count = 0;
	    while (count != 6){
            System.out.println("Count is now: " + count);
            count++;
        }

	    // Alternative way to define a while loop

        count = 1; //set the counter back to 1 after above code is executed
        while (true) {
            if(count == 6){
                break;
            }
                System.out.println("Count is now: " + count);
                count++;
            }

        // Alternative way of defining while loop using do while. In this case code will execute at least once.
        count = 1; // resetting the counter back to 1
        System.out.println("************************");
        do {
            System.out.println("Count is now: " + count);
            count ++;
        }while (count != 6);
        }
    }
