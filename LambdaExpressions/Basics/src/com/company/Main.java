package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

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

//        Collections.sort(employees, new Comparator<Employee>() {
//            @Override
//            public int compare(Employee o1, Employee o2) {
//                return o1.getName().compareTo(o2.getName());
//            }
//        });

        // replace the above with Lambda Expression

//        Collections.sort(employees, (Employee employee1, Employee employee2) ->
//                    employee1.getName().compareTo(employee2.getName()));

        // We can further simplify the Lambda Expression by removing the object types. We are removing the Employee
        // object word from the Lambda Expression.

        Collections.sort(employees, ( employee1,  employee2) ->
                employee1.getName().compareTo(employee2.getName()));

        for (Employee employee: employees) {
            System.out.println(employee.getName());
        }

        String sillyString = doStringStuff(new UpperConcat() {
            @Override
            public String upperAndConcat(String s1, String s2) {
                return s1.toUpperCase() + s2.toUpperCase();
            }
        }, employees.get(0).getName(), employees.get(1).getName());

        System.out.println(sillyString);

        UpperConcat uc = (String s1, String s2) -> s1.toUpperCase() + s2.toUpperCase();
        String sillyString2 = doStringStuff(uc, employees.get(2).getName(), employees.get(3).getName());
        System.out.println(sillyString2);

        // We can also directly pass the Lambda Expression as a parameter in the doStringStuff() method rather than
        // saving the return value to a variable
        sillyString2 = doStringStuff((s1, s2) -> s1.toUpperCase() + s2.toUpperCase(), employees.get(2).getName(),
                employees.get(4).getName());
        System.out.println(sillyString2);

        // If we use multiple statements in the Lambda expression then we need to return the value. Refer to below
        // example

        uc = (s1, s2) -> {
            String result = s1.toUpperCase() + s2.toUpperCase();
            return result;
        };

        sillyString2 = doStringStuff(uc, employees.get(2).getName(), employees.get(4).getName());
        System.out.println(sillyString2);

        AnotherClass anotherClass = new AnotherClass();
        String s = anotherClass.doSomething();
        System.out.println(s);
        System.out.println();
        s = anotherClass.doAnotherString();
        System.out.println(s);
        /*
        When you run the code, line 114 will print the Class' name of Lambda Expression which shows that it is picking up
        AnotherClass's class name. It is because Lambda is not treated as another class instead it is yet another nested
        block of code.
        */
        System.out.println();
        s = anotherClass.nestedBlock();
        System.out.println(s);
        System.out.println();

        s = anotherClass.localVariableInLambda();
        System.out.println(s);

        anotherClass.printValue();
    }

    public static String doStringStuff(UpperConcat uc, String s1, String s2) {
        return uc.upperAndConcat(s1, s2);
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

interface UpperConcat {
    String upperAndConcat(String s1, String s2);
}

class AnotherClass{
    public String doSomething() {
        System.out.println("AnotherClass class's name is: " + getClass().getSimpleName());
        return Main.doStringStuff(new UpperConcat() {
            @Override
            public String upperAndConcat(String s1, String s2) {
                System.out.println("Anonymous class's name is: " + getClass().getSimpleName());
                return s1.toUpperCase() + s2.toUpperCase();
            }
        }, "String1", "String2");
    }

    UpperConcat uc = ((s1, s2) -> {
        System.out.println("Lambda Expression class's name is: " + getClass().getSimpleName());
        String result = s1.toUpperCase() + s2.toUpperCase();
        return result;
    });
    public String doAnotherString() {
        System.out.println("AnotherClass class's name is: " + getClass().getSimpleName());
        return Main.doStringStuff(uc, "String1", "String2");
    }

    public String nestedBlock() {
        final int i=0;
        {
            UpperConcat uc = new UpperConcat() {
                @Override
                public String upperAndConcat(String s1, String s2) {
                    System.out.println("i (within anonymous class) = " + i);  // to access the local variable from the
                    // inner anonymous class we need to make the variable declared as final.
                    return s1.toUpperCase() + s2.toUpperCase();
                }
            };

            System.out.println("The AnotherClass class's name is: " + getClass().getSimpleName());
//            i++;
            System.out.println("i = " + i);  // code within the nested block can use the local variable
            return Main.doStringStuff(uc, "String1", "String2");
        }
    }

    public String localVariableInLambda() {
        AtomicInteger i = new AtomicInteger();
        // We need to use AtomicInteger since we will be changing the value of i within the Lambda Expression
        UpperConcat uc = ((s1, s2) -> {
            i.getAndIncrement();
            System.out.println("The value of i within Lambda is: " + i);
            System.out.println("The Lambda expression class's name is: " + getClass().getSimpleName());
            return s1.toUpperCase() + s2.toUpperCase();
        });
        return Main.doStringStuff(uc, "String1", "String2");
    }

    public void printValue() {
        int number = 25;
        Runnable r = () -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("The value of number is " + number);
            /*
            In this code we are using the Lambda code for Runnable. When the code runs, the thread will sleep for
            5 seconds and the print the value of number. When the thread is sleeping, the printValue method will continue
            to run and exit. By the time, the thread gets around to print the value of number, the local variable will
            no longer exist. So what will the thread print the value of number variable? Well, the Java Runtime knows
            that the value of number is not changed and it is effectively final, hence the lambda will print the value
            of number to be 25.
            In this example, we also learn that Lambdas are not immediately executed, hence any variables used within
            the lambda from outside them should be effectively final.
             */
        };

        new Thread(r).start();
    }
}