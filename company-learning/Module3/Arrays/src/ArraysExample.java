public class ArraysExample {
    public static void main(String[] args) {
        float[] theVals = new float[3];
        theVals[0] = 12.1f;
        theVals[1] = 3.14f;
        theVals[2] = 1.414f;
        float sum = 0f;

        for(int i =0; i<theVals.length; i++) {
            sum += theVals[i];
        }
        System.out.println(sum);
    }
}
