package com.company;

public class Stack {
    int[] stck = new int[10];
    int tos;

    public Stack() {
        tos = -1;
    }

    void push(int item) {
        if (tos == 9) {
            System.out.println("Stack is full");
        } else {
            stck[++tos] = item;
        }
    }

    int pop() {

        if (tos < 0) {
            System.out.println("Stack underflow");
            return 0;
        }
        return stck[tos--];
    }
}

class TestStack {
    public static void main(String[] args) {
        Stack stack1 = new Stack();
        Stack stack2 = new Stack();

        // Push some item in stack

        for (int i =0; i<10;i++) {
            stack1.push(i);
        }
        for (int i=10; i<20; i++) {
            stack2.push(i);
        }

        // pop these items from the stack
        System.out.println("Items in stack1 are: ");
        for (int i=0; i<stack1.stck.length; i++) {
            System.out.println(stack1.pop());
        }
        System.out.println("Items in stack2 are: ");
        for (int i=0; i<stack2.stck.length; i++) {
            System.out.println(stack2.pop());
        }
    }
}
