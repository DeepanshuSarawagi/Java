package com.company;

public class Main {

    public static void main(String[] args) {
	    String VarFour = "This is private to main() method";
	    ScopeCheck scopeInstance = new ScopeCheck();
        System.out.println("scopeInstance VarOne is " + scopeInstance.getVarOne());
        System.out.println(VarFour);
        scopeInstance.useInner();

        scopeInstance.timesTwo();
        System.out.println("*****************************");
        ScopeCheck.InnerClass innerClass = scopeInstance.new InnerClass();
        innerClass.timesTwo();
    }
}
