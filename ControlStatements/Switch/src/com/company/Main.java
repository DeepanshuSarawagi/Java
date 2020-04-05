package com.company;

public class Main {

    public static void main(String[] args) {

        // code using if statement

        int value = 3;
        if (value == 1){
            System.out.println("Value was 1");
        } else if (value ==2){
            System.out.println("Value was 2");
        }
        else {
            System.out.println("Value was not 1 or 2");
        }
        System.out.println("************************");
        // Equivalent code using switch statement

        int switchValue = 3;

        switch(switchValue){
            case 1:
                System.out.println("Value was 1");
                break;
            case 2:
                System.out.println("Value was 2");
                break;
            case 3: case 4: case 5:
                System.out.println("Was a 3 or a 4 or 5");
                System.out.println("Well, it was actually a " + switchValue);
                break;
            default:
                System.out.println("Value was not 1 or 2");
                break;

        }
    }
}
