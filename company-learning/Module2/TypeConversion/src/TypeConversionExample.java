public class TypeConversionExample {
    public static void main(String[] args) {
        int iVal = 50;
        short SVal = 60;
        long lval = (long) SVal;
        System.out.println(lval);
        short result = (short) lval;
        System.out.println(result);
    }
}
