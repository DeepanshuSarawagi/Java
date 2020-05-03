package com.company;

public class switchCase {
    public static void main(String[] args) {
        for (int i = 0; i < 6; i++) {
            switch (i) {
                case 0:
                    System.out.println("i is zero");
                    break;
                case 1:
                    System.out.println("i is one");
                    break;
                case 2:
                    System.out.println("i is two");
                    break;
                case 3:
                    System.out.println("i is three");
                    break;
                default:
                    System.out.println("i is greater than three");
                    break;
            }
        }
        // It is best practice to use break statements after each case to terminate the sequence and then the code
        // execution moves to the first line of switch block. This is called as "jumping" out of sequence

        // However, is some case, it may be required that multiple cases fall under single break. That is, you can omit
        // break statement after each case. Look for below example

        for (int i =0; i<=12; i++) {
            switch (i) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                    System.out.println("i is less than 5");
                    break;
                case 5:
                case 6:
                case 7:
                case 8:
                    case 9:
                        System.out.println("i is less than 10");
                        break;
                default:
                    System.out.println("i is 10 or greater");
                    break;
            }
        }
    }
}
