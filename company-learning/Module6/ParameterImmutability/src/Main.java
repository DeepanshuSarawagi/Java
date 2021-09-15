public class Main {
    public static void main(String[] args) {
        int val1 = 10;
        int val2 = 20;
        System.out.println("val1 is " + val1);
        System.out.println("val2 is " + val2);
        System.out.println();

        System.out.println("Value of variables are changed and it is only visible inside the method which is called");
        swap(val1, val2);

        System.out.println("val1 is " + val1);
        System.out.println("val2 is " + val2);
        System.out.println("Value of variables val1 and val2 is same. Since the changes to the variables passed as " +
                "parameters in the above method is not changed outside of it. This is called as Parameter Immutability.");
    }
    protected static void swap (int i, int j) {
        int k = i;
        i = j;
        j = k;
        System.out.println("val1 is " + i);
        System.out.println("val2 is " + j);
        System.out.println();
    }
}
