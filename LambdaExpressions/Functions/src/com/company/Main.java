package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.IntUnaryOperator;

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
        /*
        Function<T, V> accepts two types while creating the interface. First is the argument type on which the Function
        Interface will be applied and the second is the return type which will return the value.
        In our case, the argument type will be an object of type Employee and second is String because we will return
        String (Last Name)
        After creating the Function Interface, we need to call the apply method which accepts the Employee object to
        get the last name of the employee.
         */

        Function<Employee, String> getLastName = (employee -> {
            return employee.getName().substring(employee.getName().indexOf(" ") + 1);
        });

        Function<Employee, String> getFirstName = employee -> {
            return employee.getName().substring(0, employee.getName().indexOf(" "));
        };


        String lastName = getLastName.apply(employees.get(1));
        String firstName = getFirstName.apply(employees.get(1));
        System.out.println(lastName);
        System.out.println(firstName);

        System.out.println("\n");
        System.out.println("********************");
        Random random = new Random();
        for (Employee employee : employees) {
            if (random.nextBoolean()) {
                System.out.println(getAName(getFirstName, employee));
            } else {
                System.out.println(getAName(getLastName, employee));
            }
        }

        /*
        In the below example, we will see how to chain functions. We will create two functions and then chain them
        together by calling the andThen() method.
        In our example, first we created a Function to convert the employee name to Upper Case. Then we created another
        Function to get the First Name alone in the Upper Case by calling the substring() method.
        Once we have written the function to retrieve the FirstName in UpperCase we created another Function to chain
        both the functions. we call the andThen() method on the upperCase Function and the result of that is passed as
        an argument to the second function.
         */
        System.out.println("\n");
        System.out.println("*********************");

        Function<Employee, String> upperCase = employee -> employee.getName().toUpperCase();
        Function<String, String> firstNameInUpperCase = name -> name.substring(0, name.indexOf(" "));
        Function  chainedFunction = upperCase.andThen(firstNameInUpperCase);
        System.out.println(chainedFunction.apply(employees.get(2)));


        employees.forEach(employee -> {
            System.out.println(chainedFunction.apply(employee));
        });

        /*
        In the below example we will learn about the BiFunction interface which accepts two arguments.
        Using the BiFunction interface we will print the employee name in upper case as well as concatenate the
        name with the age.
        Since BiFunction accepts two parameters, it cannot be changed.
         */
        BiFunction<String, Employee, String> concatAge = (name, employee) -> {
            return name.concat(" " + employee.getAge());
        };

        String name = upperCase.apply(employees.get(1));
        System.out.println(concatAge.apply(name, employees.get(1)));

        /*
        UnaryOperatorFunction interface accepts one argument and returns the value of same type.
        For example, we will know about IntUnaryOperator
         */

        IntUnaryOperator incBy5 = i -> i + 5;
        System.out.println(incBy5.applyAsInt(10));

        /*
        When we want to use the Lambda Expression to test the value and returns if it is true or false, we can use
        Predicates. And if want to use the Lambda Expressions in place of a method which accepts the arguments and returns
        the value of type T then  we can use the Function Interface. The interfaces doesnt dictate what the lambda
        expressions must do.
         */
    }

    private static String getAName(Function<Employee, String> getName, Employee employee) {
        return getName.apply(employee);
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
