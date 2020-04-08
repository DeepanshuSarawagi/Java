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
        System.out.println("************************");
        System.out.println(isEvenNumber(24));

        System.out.println();

        int number = 4;
        int finishNumber = 20;

        while (number <= finishNumber) {
            number++;
            if (!isEvenNumber(number)) {
                continue;  // This will bypass the print statement if the number is not an event number
            }
            System.out.println("Even number now is: " + number);
        }

        }

        public static boolean isEvenNumber (int number) {
            return number % 2 == 0;
        }
    }
