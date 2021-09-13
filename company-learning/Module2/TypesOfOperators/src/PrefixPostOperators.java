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

class OperatorPrecedence{
    public static void main(String[] args) {
        operatorPrecedence();
    }

    private static void operatorPrecedence() {
        int valA = 21;
        int valB = 6;
        int valC = 3;
        int valD = 1;

        int result = valA - valB / valC;
        int result2 = (valA - valB) / valC;

        System.out.println("Result1 is " + result);
        System.out.println("Result2 is " + result2);
    }
}