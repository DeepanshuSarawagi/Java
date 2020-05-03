package com.company;

public class DoWhile {
    public static void main(String[] args) throws java.io.IOException {
            char choice;
            do {
                System.out.println("Help on: ");
                System.out.println("\t\t1. if");
                System.out.println("\t\t2. switch");
                System.out.println("\t\t3. while");
                System.out.println("\t\t4. do-while");
                System.out.println("\t\t5. for\n");
                System.out.println("Choose one: ");
                choice = (char) System.in.read();
            } while (choice < '1' || choice > '5');
        System.out.println("\n");
        switch (choice) {
            case '1':
                System.out.println("The if\n");
                System.out.println("if(condition) statement");
                System.out.println("else statement");
                break;
            case '2':
                System.out.println("The switch statement");
                System.out.println("switch(expression)");
                System.out.println("case constant");
                System.out.println("Statement execution");
                System.out.println("break");
                System.out.println();
                break;
            case '3':
                System.out.println(" The while statement");
                System.out.println("while(condition) statement");
            case '4':
                System.out.println("The do-while statement");
                System.out.println("do {");
                System.out.println("   statement execution");
                System.out.println("} while(condition)");
                System.out.println();
                break;
            case '5':
                System.out.println("The for statement");
                System.out.println("for(init condition interation) { ");
                System.out.println("   statement execution }");
                System.out.println();
                break;
        }
    }
}
