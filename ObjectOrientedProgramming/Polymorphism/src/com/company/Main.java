package com.company;

class Movie {
    private String name;

    public Movie(String name) {
        this.name = name;
    }

    public String plot() {
        return "No plot";
    }
}

class Jaws extends Movie {
    public Jaws() {
        super("Jaws");
    }

}
public class Main {

    public static void main(String[] args) {
	// write your code here
    }
}
