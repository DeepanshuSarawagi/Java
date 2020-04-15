package com.company;

public class MultiDimensionalArrays {

    public static void main(String[] args) {
        twoDimensionalArray();
        TwoDAgain.twoDAgainUnequal();
    }

    public static void twoDimensionalArray() {

        int[][] twoD = new int[4][5];
        int i, j, k = 0;
        for(i = 0; i < 4; i++) {
            for (j = 0; j<5; j++) {
                twoD[i][j] = k;
                k++;
            }
        }

        for (i = 0; i < 4; i++) {
            for (j =0; j < 5; j++) {
                System.out.print(twoD[i][j] + " ");
            }
            System.out.println();
        }

    }
}

class TwoDAgain {
    // When you allocate memory for a multidimensional array, you need only specify the leftmost dimension. you can
    // allocate the remaining dimensions separately. Following program creates a multidimensional array with the size
    // second dimension being unequal.

    public static void twoDAgainUnequal() {
        int[][] twoD = new int[4][];
        twoD[0] = new int[1];
        twoD[1] = new int[2];
        twoD[2] = new int[3];
        twoD[3] = new int[4];

        int i, j, k = 0;

        for (i =0; i<4; i++) {
            for (j =0; j<i+1; j++) {
                twoD[i][j] = k;
                k++;
            }
            }
        for (i =0; i<4; i++) {
            for (j =0; j<i+1; j++) {
                System.out.print(twoD[i][j] + " ");
            }
            System.out.println();
        }
    }
}
