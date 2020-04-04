public class Main {

    public static void main(String[] args) {

        boolean result = DecimalComparator.areEqualByThreeDecimalPlaces(-3.1567, -3.156);
        System.out.println(result);
        result = DecimalComparator.areEqualByThreeDecimalPlaces(-3.154, -3.156);
        System.out.println(result);
        result = DecimalComparator.areEqualByThreeDecimalPlaces(3.1567, -3.156);
        System.out.println(result);
        result = DecimalComparator.areEqualByThreeDecimalPlaces(3.0, 3.0);
        System.out.println(result);

    }
}
