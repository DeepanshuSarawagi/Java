package com.company;

public class Utilities {

    public char[] everyNthChar(char[] sourceArray, int n) {
        if (sourceArray == null || sourceArray.length < n) {
            return sourceArray;
        }

        int returnedLength = sourceArray.length / n;
        char[] result = new char[returnedLength];
        int index = 0;
        for (int i = n-1; i < sourceArray.length; i +=n) {
            result[index++] = sourceArray[i];
        }
        return result;
    }


}
