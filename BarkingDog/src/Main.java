public class Main {

    public static void main(String[] args) {

       boolean result =  BarkingDog.shouldWakeUp(true, 4);
        System.out.println(result);

        result =  BarkingDog.shouldWakeUp(false, 4);
        System.out.println(result);

        result =  BarkingDog.shouldWakeUp(true, 8);
        System.out.println(result);

        result =  BarkingDog.shouldWakeUp(true, -1);
        System.out.println(result);

        result =  BarkingDog.shouldWakeUp(true, 0);
        System.out.println(result);
    }
}
