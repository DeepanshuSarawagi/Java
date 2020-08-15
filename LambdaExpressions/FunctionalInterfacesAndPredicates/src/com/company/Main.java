package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Employee pradeep = new Employee("Pradeep Sarawagi", 57);
        Employee sangeetha = new Employee("Sangeetha Rani", 53);
        Employee deepanshu = new Employee("Deepanshu Sarawagi", 27);
        Employee divya = new Employee("Divya Sarawagi", 27);
        Employee rajat = new Employee("Rajat Sarawagi", 25);
        Employee red = new Employee("Red RidingHood", 35);
        Employee charming = new Employee("Prince Charming", 31);

        List<Employee> employees = new ArrayList<>();
        employees.add(pradeep);
        employees.add(sangeetha);
        employees.add(deepanshu);
        employees.add(divya);
        employees.add(rajat);
        employees.add(red);
        employees.add(charming);

        employees.forEach(employee -> {
            System.out.println(employee.getName());
            System.out.println(employee.getAge());
        });

        System.out.println("Employees over 30:");
//        for(Employee employee : employees) {
//            if (employee.getAge() > 30) {
//                System.out.println(employee.getName());
//            }
//        }
        employees.forEach(employee -> {
            if (employee.getAge() > 30) {
                System.out.println(employee.getName());
            }
        });

        /*
        The forEach() method accepts the Consumer Interface objects are parameter. Consumer is a functional interface
        whose default method is accept(T t) which accepts a single input argument of any type. The method signature of
        forEach() method is as follows
                  default void forEach(Consumer<? super T> action) {
                Objects.requireNonNull(action);
                for (T t : this) {
                    action.accept(t);
                }
            }
        The employee object in the Lambda is evaluated as the consumer and passed a parameter to the accept() method.
        The accept() method of the Consumer interface then accepts the employee as an argument and then does necessary
        action which is printing out name and age. Remember that we can only implement Consumer interface for a method
        where we do not want to return anything. And in the above example, it exactly serves our purpose. We are just
        printing out the name and age of Employee objects from the employees list.
         */

        System.out.println("Employees 30 and younger: ");
        employees.forEach(employee -> {
            if (employee.getAge() <= 30) {
                System.out.println(employee.getName());
            }
        });
    }
}
