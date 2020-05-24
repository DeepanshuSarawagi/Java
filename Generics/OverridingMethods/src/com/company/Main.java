package com.company;

public class Main {

    public static void main(String[] args) {
	    Gen<Integer> iOb = new Gen<>(100);
	    Gen<String> strOb = new Gen<>("Deepanshu");
	    Gen2<String> strOb2 = new Gen2<>("Sarawagi");
        System.out.println(iOb.getOb());
        System.out.println(strOb.getOb());
        System.out.println(strOb2.getOb());
    }
}
