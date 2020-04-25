package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Customer customer = new Customer("Deep", 3435.21);
        Customer anotherCustomer;
        anotherCustomer = customer;
        anotherCustomer.setBalance(123.45);
        System.out.println("Balance for customer " + customer.getName() + " is " + customer.getBalance());

        // the above code changes the value of original Customer class object customer. Since anotherCustomer is not a
        // new object, its just a reference to the first one in memory. That's how memory is allocated in Java.

        ArrayList<Integer> myIntValues = new ArrayList<>();
        myIntValues.add(1);
        myIntValues.add(3);
        myIntValues.add(4);

        for (int i=0; i<myIntValues.size(); i++) {
            System.out.println(i + ": " + myIntValues.get(i));
        }

        myIntValues.add(1, 2);  // this inserts the element 2 in the index position 1.

        System.out.println();

        for (int i=0; i<myIntValues.size(); i++) {
            System.out.println(i + ": " + myIntValues.get(i));
        }

        // the above code on line 26, will move the rest of the elements in the ArrayList down and then insert the
        // element 2 at index 1. Now, this is good for small number of records. Consider, if there are million of
        // records then inserting an element in ArrayList would bring performance issues in Java. This is where
        // LinkedList in Java comes into play.


    }
}
