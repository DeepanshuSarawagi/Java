package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Employee pradeep = new Employee("Pradeep Sarawagi", 57);
        Employee sangeetha = new Employee("Sangeetha Rani", 53);
        Employee deepanshu = new Employee("Deepashu Sarawagi", 27);
        Employee divya = new Employee("Divya Mittal", 27);
        Employee rajat = new Employee("Rajat Sarawagi", 25);

        List<Employee> employees = new ArrayList<>();
        employees.add(pradeep);
        employees.add(sangeetha);
        employees.add(deepanshu);
        employees.add(divya);
        employees.add(rajat);

//        Collections.sort(employees, (employee1, employee2) -> employee1.getName().compareTo(employee2.getName()));

        for (Employee employee : employees) {
            System.out.println(employee.getName());
            new Thread(() -> System.out.println(employee.getAge())).start();
            /*
            Now we may be wondering here, since the value of employee is getting changed shouldn't it be final and how is
            it working inside Lambda. Well, technically, for each iteration of for loop, a new local variable is created
            and that is effectively final. Hence, this variable is working inside Lambda. We can confirm the same by
            using the old style for loop below.
             */
        }

        System.out.println("********************");
        for (int i=0; i<employees.size(); i++) {
            Employee employee = employees.get(i);
            System.out.println(employee.getName());
            new Thread(() -> System.out.println(employee.getAge())).start();
        }

        /*
        In this example we can see that Lambda is not evaluated immediately and variable should be effectively final
         */

//        new Thread(() -> {
//            for (Employee employee : employees) {
//                System.out.println("Employee name is " + employee.getName());
//                System.out.println("Employee age is " + employee.getAge());
//            }
//        }).start();
        System.out.println();

    }
}

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