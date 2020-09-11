package com.company;

public class Utilities {

    // Returns a char array containing every nth char. When sourceArray.length < n, return sourceArray
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

    // Remove pairs of the same character that are next to each other
    // For e.g; "ABBCDEEF" -> "ABCDEF"
    public String removePairs(String source) {
        // If length is < 2, there wont be any pairs.
        if (source.length() < 2) {
            return source;
        }

        StringBuilder sb = new StringBuilder();
        char[] string = source.toCharArray();
        for (int i =0; i<string.length; i++) {
            if (string[i] != string[i++]) {
                sb.append(string[i]);
            }
        }
        return sb.toString();
    }
}
