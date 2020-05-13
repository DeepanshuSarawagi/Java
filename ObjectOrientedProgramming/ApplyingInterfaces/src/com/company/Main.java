package com.company;

public class Main {

    public static void main(String[] args) {
	    // Create new FixedStack objects
        FixedStack fixedStack1 = new FixedStack(10);

        // push items into stack
        for (int i=0; i<10; i++) {
            fixedStack1.push(i);
        }

        // pop item from the stack
        System.out.println("Pop items from the stack");
        for (int i=0; i<10; i++) {
            System.out.println(fixedStack1.pop());
        }

        System.out.println("Dynamic stack..");
        DynamicStack dynamicStack = new DynamicStack(5);
        for (int i=0; i<10; i++) {
            dynamicStack.push(i);
        }

        for (int i=0; i<10; i++) {
            System.out.println(dynamicStack.pop());
        }
    }
}
