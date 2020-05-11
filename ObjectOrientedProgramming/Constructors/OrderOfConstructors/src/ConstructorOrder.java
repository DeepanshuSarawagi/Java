public class ConstructorOrder {
    public static void main(String[] args) {
        C cObj = new C();

        // Once you execute this program, you will learn that constructor of super Class initializes first since super
        // has no idea if it has a sub-class
    }
}

class A {
    public A() {
        System.out.println("Inside A`s constructor");
    }
}

class B extends A{
    public B() {
        System.out.println("Inside B`s constructor");
    }
}

class C extends B{
    public C() {
        System.out.println("Inside C`s constructor");
    }
}