package com.company;

public class MultiDimensionalArrays {

    public static void main(String[] args) {
        twoDimensionalArray();
        TwoDAgain.twoDAgainUnequal();
        Matrix.MatrixArray();
        ThreeDimensionalArray.ThreeDArray();
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

// Initialize a two dimensional array

class Matrix {

    public static void MatrixArray() {

        double[][] m = {
                {0 * 0, 1 * 0, 2 * 0, 3 * 0},
                {0 * 1, 1 * 1, 2 * 1, 3 * 1},
                {0 * 2, 1 * 2, 2 * 2, 3 * 2},
                {0 * 3, 1 * 3, 2 * 3, 3 * 3}
        };
        int i, j = 0;

        for (i = 0; i < 4; i++) {
            for (j =0; j<4; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}

class ThreeDimensionalArray {
    public static void ThreeDArray() {

        int i, j, k = 0;

        int[][][] threeD = new int[3][4][5];

        for (i = 0; i < 3; i++) {
            for (j = 0; j < 4; j++) {
                for (k = 0; k < 5; k++){
                    threeD[i][j][k] = i * j * k;
                }
            }
        }

        for (i = 0; i < 3; i++) {
            System.out.println("When i is " + i);
            for (j = 0; j < 4; j++) {
                for (k = 0; k < 5; k++) {
                    System.out.print(threeD[i][j][k] + " ");
                }
                System.out.println();
            }
        }

    }
}