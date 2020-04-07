package com.company;

public class isPrime {

    public static void main(String[] args) {

        System.out.println(isPrimeNumber(20));
        System.out.println("******************");
        int count = 1;
        for (int i = 578; i < 1000; i++) {
                if (isPrimeNumber(i)) {
                    System.out.println("Prime number " +  count + " in this range is: " + i);
                    count ++;
                }
                if (count > 3) {
                    break;
                }
            }
        }

    public static boolean isPrimeNumber(int n){

        if (n == 1){
            return false;
        }

        for (int i =2; i <= n/2; i++){
            if(n % i ==0){
                return false;
            }
        }
        return true;
    }

}
