public class UseStatic {
    static int a = 3;
    static int b;

    static void meth(int x) {
        System.out.println("x is: " + x);
        System.out.println("a is: " + a);
        System.out.println("b is: " + b);
    }

    static {
        b = a* 4;
    }

    public static void main(String[] args) {
        meth(42);
    }
}

class staticDemo {
    static int a = 42;
    static int b = 99;

    static void callMe() {
        System.out.println("a is " + a);
    }
}

class StaticByName {
    public static void main(String[] args) {
        staticDemo.callMe();  // as we can see, we have not created any instance of class staticDemo yet we are able to
        // access the callMe() method in the main method of this call.
        // Therefore, when a member of a class is made static, it can be accessed even before an object of its class is
        // created. You can declare both members and variables to be static.
        System.out.println("b is " + staticDemo.b);
    }
}
