package com.company;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        List<String> someBingoNumbers = Arrays.asList("N40", "N36",
                "G53", "G71", "G11", "g64",
                "I26", "I70",
                "B5", "B29", "B16");

        for (String string : someBingoNumbers) {
            if (string.contains("G")) {
                System.out.println(string);
            }
        }

        // We can do the same thing using forEach and Lambda Expression
        System.out.println();
        someBingoNumbers.forEach(number -> {
            if (number.startsWith("G")) {
                System.out.print(number + "\t");
            }
        });

        // Create a new ArrayList
        List<String> gNumbers = new ArrayList<>();

        someBingoNumbers.forEach(number -> {
            if (number.toUpperCase().startsWith("G")) {
                gNumbers.add(number);
            }
        });
        System.out.println();

        gNumbers.sort((String o1, String o2) -> o1.compareTo(o2));
        gNumbers.forEach(s -> System.out.println(s));

        /*
        Now we are going to use Streams to achieve the same result as above in a single line of code
        A Stream is a sequence of elements supporting sequential and parallel operations.
        In the below examples, we have applied the Stream method to the source Collections object. And then we have
        asked the stream to convert all the objects in the collections to UpperCase, followed by a filter to filter the
        objects whose string starts with G and then calling the sorted() method to sort the items which are filtered and
        finally we print each element using the forEach() method.
        Note that, the original Collections someBingoNumbers is not manipulated. Every set of operation is independent.
        No changes will be made to the original list.
         */
        System.out.println();

        someBingoNumbers.stream()
                .map(String::toUpperCase)
                .filter(s -> s.startsWith("G"))
                .sorted()  // intermediate operation
                .forEach(System.out::println);  // terminal sequence

        // Building stream from the scratch

        Stream<String> ioInputStream = Stream.of("I17", "I29", "I26", "O71");
        Stream<String> inInputStream = Stream.of("N40", "N56", "I17", "I29", "I26", "O71");

        // We will concat two Streams together
        Stream<String> concatStream = Stream.concat(ioInputStream, inInputStream);

        // Print the number of items in the Stream
        System.out.println();
//        System.out.println("There are " + concatStream.count() + " items in the Stream");

        // Print the no. of distinct items in the Stream
        System.out.println("There are " + concatStream
                .distinct()
                .peek(System.out::println)   // We use the peek method of class Stream to print the items in the Stream
                                             // instead of using forEach() method. forEach() method is the terminal
                                             // operation and will end the Stream since it returns void, however, peek()
                                             // is the intermediate operation just like the rest of the methods which
                                             // which returns the resulting Stream
                .count() + " distinct items in the Stream");

        System.out.println("-----------------------------");

        Employee deep = new Employee("Deepanshu Sarawagi", 28);
        Employee divya = new Employee("Divya Sarawagi", 28);
        Employee rajat = new Employee("Rajat Sarawagi", 25);
        Employee deepak = new Employee("Deepak Jain", 28);

        Department hr = new Department("Human Resources");
        hr.addEmployees(deep);
        hr.addEmployees(divya);
        hr.addEmployees(rajat);

        Department accounting = new Department("Accounting");
        accounting.addEmployees(deepak);

        List<Department> departments = new ArrayList<>();
        departments.add(hr);
        departments.add(accounting);

        departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .forEach(System.out::println);

        for (Department department : departments) {
            System.out.println(department.getEmployees());
        }

        departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .sorted().peek(System.out::println);

        // We will be using the collect() method in the Stream to store the stream of objects in a list

        List<String> sortedGNumbers = someBingoNumbers
                .stream()
                .map(String::toUpperCase)
                .filter(s -> s.startsWith("G"))
                .sorted()
                .collect(Collectors.toList());  // This is a terminal operation

        for (String s : sortedGNumbers) {
            System.out.println(s);
        }

        // instead of using the Collectors.toList() as argument in the .collect() method, we can also specify the
        // list to be an ArrayList
        System.out.println("**************************");
        List<String> sortedGNumbers1 = someBingoNumbers
                .stream()
                .map(String::toUpperCase)
                .filter(s -> s.startsWith("G"))
                .sorted()
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);  // Here, we are creating a new ArrayList
        // which is a Supplier, then adding each element to the ArrayList which acts as accumulator and then combining
        // all the elements together which acts as Combiner

        sortedGNumbers1.forEach(System.out::println);

        // We will use the groupingBy() method to group the employees by age

        Map<Integer, List<Employee>> groupedByAge = departments
                .stream()
                .flatMap(department -> department.getEmployees().stream())
                .collect(Collectors.groupingBy(Employee::getAge));  //groupingByAge

        for (int i : groupedByAge.keySet()) {
            System.out.println(i);
        }

        for (List<Employee> employees : groupedByAge.values()) {
            employees.forEach(System.out::println);
        }

        // We will use the reduce() method which accepts BiFunction as parameter to get the youngest employee
        // in the company
        System.out.println();
        departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .reduce((employee, employee2) -> employee.getAge() < employee2.getAge() ? employee : employee2)
                .ifPresent(System.out::println);
    }
}
