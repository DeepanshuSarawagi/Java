package com.company;

public class Main {

    public static void main(String[] args) {
	    String privateVar = "This is private to main() method";
	    ScopeCheck scopeInstance = new ScopeCheck();
        System.out.println("scopeInstance privateVar is " + scopeInstance.getPrivateVar());
        System.out.println(privateVar);

        scopeInstance.timesTwo();
    }
}
