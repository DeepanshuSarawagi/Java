package com.company;
// Learn how to access members or methods of super class in sub class using super keyword
public class SuperClass {
    int i;

}
class SubClass extends SuperClass{
    private int i; // this i hides the i in SuperClass

    public SubClass(int a, int b) {
        super.i = a;
        this.i = b;
    }

    public void show() {
        System.out.println("i in super class is " + super.i);
        System.out.println("i in sub class is " + this.i);
    }
}

class UseSuper{
    public static void main(String[] args) {
        SubClass subClassObj = new SubClass(2, 5);
        subClassObj.show();
    }
}