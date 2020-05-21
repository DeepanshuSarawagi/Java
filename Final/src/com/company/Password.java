package com.company;

public class Password {
    private static final int Key = 349812;
    private final int encryptedPassword;

    public Password(int password) {
        this.encryptedPassword = EncryptPassword(password);
    }

    private int EncryptPassword(int password) {
        return password ^ Key;
    }

    public void savePassword() {
        System.out.println("Saving password as " + this.encryptedPassword);
    }

    public boolean letMeIn(int password) {
        if (EncryptPassword(password) == this.encryptedPassword) {
            System.out.println("Welcome!! You are in.");
            return true;
        } else {
            System.out.println("Nope! You are an intruder.");
            return false;
        }
    }
}
