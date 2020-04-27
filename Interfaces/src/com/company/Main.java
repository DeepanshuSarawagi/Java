package com.company;

public class Main {

    public static void main(String[] args) {
        ITelephone deepsPhone;
        deepsPhone = new DeskPhone(89456357);
        deepsPhone.callPhone(89456357);
        System.out.println(deepsPhone.isRinging());
        deepsPhone.answer();
        deepsPhone.dial(3243553);
        System.out.println(deepsPhone.isRinging());
    }
}
