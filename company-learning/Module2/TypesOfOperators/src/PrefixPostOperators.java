public class PrefixPostOperators {
    public static void main(String[] args) {
        int a = 5;
        System.out.println("Prefix operation" + (++a));
        System.out.println("Value of a is now " + a);
        System.out.println("Postfix operation " + (a++));
        System.out.println("Value of a is now " + a);

    }
}
class CompoundOperators{

    public static void main(String[] args) {
        compOperators();
    }

    private static void compOperators() {
        int a = 5;
        int b = 10;
        int c = 100;
        int result = 10;
        result += a + 5;
        System.out.println("Result is now: " + result);
        result += c / a + b;
        System.out.println("Result is now: " + result);
    }
}