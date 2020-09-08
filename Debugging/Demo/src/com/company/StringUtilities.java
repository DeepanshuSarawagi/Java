package com.company;

public class StringUtilities {
    private StringBuilder sBuilder = new StringBuilder();
    private int charsAdded = 0;
    public void addChar(StringBuilder sBuilder, char c) {
        sBuilder.append(c);
        charsAdded++;   // When we run the debugger we will see that this variable is a watch point which helps us to
        // test the code
    }
}
