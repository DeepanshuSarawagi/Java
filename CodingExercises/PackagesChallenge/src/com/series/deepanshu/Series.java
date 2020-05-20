package com.series.deepanshu;

public class Series {
    protected static void nSum(int n) {
        int sum = 0;
        for (int i=0; i<=n; i++) {
            sum += i;
            System.out.print(sum + " ");
        }
    }
}
