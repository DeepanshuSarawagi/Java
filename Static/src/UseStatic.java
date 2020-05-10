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

