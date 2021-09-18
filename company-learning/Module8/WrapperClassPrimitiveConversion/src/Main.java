public class Main {
    public static void main(String[] args) {
        /*
        Boxing example
         */
        Float f = Float.valueOf(1414.5f);
        System.out.println(f);

        int d = 100;
        Integer I = Integer.valueOf(d);
        System.out.println(I);

        /*
        Unboxing example
         */
        int i1 = I.intValue();
        System.out.println(i1);

        /*
        Primitive type conversion below
         */
        String s = "87.44";
        double d1 = Double.parseDouble(s);
        System.out.println(d1);
        Double s2 = Double.valueOf(s);
        System.out.println(s2);
    }
}
