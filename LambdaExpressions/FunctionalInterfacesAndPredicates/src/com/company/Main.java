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

        List<Employee> employees = new ArrayList<>();
        employees.add(pradeep);
        employees.add(sangeetha);
        employees.add(deepanshu);
        employees.add(divya);
        employees.add(rajat);

    }
}
