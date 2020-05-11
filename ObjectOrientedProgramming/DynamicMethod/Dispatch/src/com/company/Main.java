package com.company;

public class Main {

    public static void main(String[] args) {
    	/*
    	Dynamic method dispatch is a mechanism by which a call to an overridden method is resolved at the run time
    	rather than the compile time. Dynamic method dispatch is important because this forms the basis for Java`s
    	runtime Polymorphism.

    	Let`s demonstrate this by using a simple example. A superclass reference variable can refer to the object of a
    	subclass. Java uses the fact to resolve calls to overridden methods at run time. Here is how. When an overridden
    	method is called through a superclass reference, Java determines which version of that method to execute based
    	upon of the type of being used at the time the call occurs. Thus, this determination is made at the run time.
    	when different types of objects are referred to, different version of overridden methods will be called.
    	 */
	    A a = new A();
	    B b = new B();
	    C c = new C();

	    A r;
	    r = a;
	    r.callMe();

	    r = b;
	    r.callMe();

	    r = c;
	    r.callMe();
    }
}
