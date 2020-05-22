package com.company;

public class Main {

    public static void main(String[] args) {
        SomeClass one = new SomeClass("One");
        SomeClass two = new SomeClass("Two");
        SomeClass three = new SomeClass("Three");

        System.out.println(one.getInstanceNumber());
        System.out.println(two.getInstanceNumber());
        System.out.println(three.getInstanceNumber());

//        one.InstanceNumber = 4;  // This will throw an error because its a final variable and we cannot change the
//                                    value
        int pw = 51024;
        Password password = new Password(pw);
        password.savePassword();
        password.letMeIn(1);
        password.letMeIn(2323);
        password.letMeIn(125341);
        password.letMeIn(-24234);
        password.letMeIn(51024);
        System.out.println();

        ExtendedPassword extendedPassword = new ExtendedPassword(61432);
        extendedPassword.savePassword();
        extendedPassword.letMeIn(14533);
        extendedPassword.letMeIn(67362);
        extendedPassword.letMeIn(905141);
        extendedPassword.letMeIn(31346);
        extendedPassword.letMeIn(61432);


    }
}
