package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
//        new Thread(new CodeToRun()).start();

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Printing from the Runnable");
//            }
//        }).start();

        // Commented out above code to use Lambda Expressions in below example
        new Thread(()-> System.out.println("Printing from the Runnable")).start();
        /*
        Every Lambda Expression consists of three parts.
            1. Argument list - ()
            2. Error Token - ->
            3. Body  - System.out.println("Printing from the Runnable")

        How does the Lambda Expression evaluate the above code? In this case, the Lambda Expressions checks for the
        parameter which is accepted by the Thread class constructor which is the Runnable interface. And this
        Runnable interface implements just one method which is run() and it has no parameters. Hence, the empty
        Argument List is evaluated against the Runnable Interface.
        Since the Lambda Expressions looks out for methods, it can only be replaced against the interface with just one
        method, also referred to as Functional Interfaces.
         */

        // Learn how to execute multiple statements in Lambda Expression

        new Thread(()-> {
            System.out.println("Printing from the Runnable");
            System.out.println("This is Line2");
            System.out.println("Printing another line using Lambda Expression");
        }).start();

        Employee deep = new Employee("Deepanshu Sarawagi", 28);
        Employee rajat = new Employee("Rajat Sarawagi", 26);
        Employee divya = new Employee("Divya Sarawagi", 28);
        Employee sangeetha = new Employee("Sangeetha Rani", 53);
        Employee pradeep = new Employee("Pradeep Sarawagi", 57);

        List<Employee> employees = new ArrayList<>();
        employees.add(deep);
        employees.add(rajat);
        employees.add(divya);
        employees.add(sangeetha);
        employees.add(pradeep);

        Collections.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        for (Employee employee: employees) {
            System.out.println(employee.getName());
        }
    }
}

//class CodeToRun implements Runnable {
//    @Override
//    public void run() {
//        System.out.println("Printing from the runnable");
//    }
//}

class Employee {
    private String Name;
    private int Age;

    public Employee(String name, int age) {
        Name = name;
        Age = age;
    }

    public String getName() {
        return Name;
    }

    public int getAge() {
        return Age;
    }
}