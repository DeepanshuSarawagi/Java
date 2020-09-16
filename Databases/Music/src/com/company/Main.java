package com.company;

import com.company.Model.Datasource;

public class Main {

    public static void main(String[] args) {
        Datasource datasource = new Datasource();
        if (!datasource.open()) {
            System.out.println("Couldn't open datasource");
            return;
        }
        datasource.close();
    }
}
