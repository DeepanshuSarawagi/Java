package com.company;

public class StringUtilities {
    private StringBuilder sBuilder = new StringBuilder();
    private int charsAdded = 0;
    public void addChar(StringBuilder sBuilder, char c) {
        sBuilder.append(c);
        charsAdded++;   // When we run the debugger we will see that this variable is a watch point which helps us to
        // test the code

        // When we run the debugger, we can expand the variable and add it to watch points to watch the change in
        // values when we perform a stepover in the debugger.
    }

    public String PrefixAndUpper(String str) {
        return "Prefix_" + str.toUpperCase();
    }

    public String SuffixAndLower(String str) {
        return "__Suffix " + str;
    }
}
