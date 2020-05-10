package com.company;

public class Stack {
    private int[] stack;
    private int tos;

    Stack(int size) {
        stack = new int[size];
        tos = -1;
    }

    // push an item in stack

    void push(int item) {
        if (tos == stack.length-1) {
            System.out.println("Stack is full");
        }
        else {
            stack[++tos] = item;
        }
    }

    int pop() {
        if (tos < 0) {
            System.out.println("Stack is underflow");
            return 0;
        } else {
            return stack[tos--];
        }
    }

    public static void main(String[] args) {
        Stack stack1 = new Stack(10);

        for (int i=0; i<10; i++) {
            stack1.push(i);
        }

        System.out.println("Items in my stack are: ");
        for (int i=0; i<10; i++) {
            System.out.println(stack1.pop());
        }
    }
}
