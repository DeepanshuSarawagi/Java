package com.company;

public class ExtendedPassword extends Password{
    private int decryptPassword;

    public ExtendedPassword(int password) {
        super(password);
        this.decryptPassword = password;
    }

//    @Override
//    public void savePassword() {
//        System.out.println("Saving password as " + this.decryptPassword);
//    }

    // you cannot override this method since this is a final method declared in the super class
}
