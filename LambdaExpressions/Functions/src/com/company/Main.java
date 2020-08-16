package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Main {

    public static void main(String[] args) {
	    Employee pradeep = new Employee("Pradeep Sarawagi", 57);
        Employee sangeetha = new Employee("Sangeetha Rani", 53);
        Employee deepanshu = new Employee("Deepanshu Sarawagi", 27);
        Employee divya = new Employee("Divya Mittal", 27);
        Employee rajat = new Employee("Rajat Sarawagi", 25);

        List<Employee> employees = new ArrayList<>();

        employees.add(pradeep);
        employees.add(sangeetha);
        employees.add(deepanshu);
        employees.add(divya);
        employees.add(rajat);

        employees.forEach(employee -> {
//            String[] firstLastName = employee.getName().split(" ");
//            System.out.println("First name is " + firstLastName[0] + " Last name is " + firstLastName[1]);
            String lastName = employee.getName().substring(employee.getName().indexOf(" ") + 1);
            System.out.println("Last name is: " + lastName);
        });

        // Create a function interface to print the last name of the employee

        Function<Employee, String> getLastName = (employee -> {
            return employee.getName().substring(employee.getName().indexOf(" ") + 1);
        });

        String lastName = getLastName.apply(employees.get(1));
        System.out.println(lastName);

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
