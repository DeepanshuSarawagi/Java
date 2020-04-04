public class Main {

    public static void main(String[] args) {

        boolean result = TeenNumberChecker.hasTeen(12, 13, 45);
        boolean result2 = TeenNumberChecker.isTeen(13);
        System.out.println(result);
        System.out.println(result2);
        System.out.println();

        result = TeenNumberChecker.hasTeen(56, 43, 45);
        result2 = TeenNumberChecker.isTeen(3);
        System.out.println(result);
        System.out.println(result2);

        result = TeenNumberChecker.hasTeen(19, 12, 4);
        System.out.println(result);

        result = TeenNumberChecker.hasTeen(12, 20, 5);
        System.out.println(result);
    }
}
