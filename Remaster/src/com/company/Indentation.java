package com.company;

public class Indentation {
    protected void indentationExample() {
        int salary = 60;
        if (salary > 50) {
            System.out.println("You are rich!");
        }

        int score = 5500;

        if ((score <= 5000) && (score > 1000)) {
            System.out.println("Your score is less than 5000 but greater than 1000");
        } else if (score <= 1000){
            System.out.println("You have got score less than or equal to 1000");
        } else {
            System.out.println("You have got high score!");
        }
    }
}
