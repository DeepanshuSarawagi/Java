public class TypeConversionExample {
    public static void main(String[] args) {
        int iVal = 50;
        short SVal = 60;
        long lval = (long) SVal;
        System.out.println(lval);
        short result1 = (short) lval;
        System.out.println(result1);

        float floatVal = 3.14f;
        double doubleVal = 4.07d;
        byte byteVal = 7;
        short shortVal = 7;
        long longVal = 1;

        short result2 = (short) longVal;
        result2 = (short) byteVal;
        System.out.println(result2);

        short result3 = (short) (byteVal - longVal);
        System.out.println(result3);

        float result4 = longVal - floatVal;
        System.out.println(result4);

        float result5 =  (float) (longVal - doubleVal);
        System.out.println(result5);
    }
}
