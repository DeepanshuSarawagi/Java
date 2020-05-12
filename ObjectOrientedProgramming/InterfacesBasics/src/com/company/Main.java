package com.company;

public class Main {

    public static void main(String[] args) {
	    Callback c = new Client();  // variable C is declared to be of Interface type Callback, yet it was assigned an
                                    // instance of Client. You can access the methods which are defined in Callback
                                    // interface but you cannot access other members of the class which implements the
                                    // interface. An interface reference variable has knowledge only of the methods
                                    // declared by its interface declaration.
	    c.callBack(45);

        ((Client) c).tryAccessingMe();
        // To access other methods/members of class Client, we need to cast a qualifier to do so.
    }
}
