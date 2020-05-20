package com.company;

public class ScopeCheck {
    public int publicVar = 0;
    private int VarOne = 1;

    public ScopeCheck() {
        System.out.println("PublicVar = " + publicVar + " privateVar = " + VarOne);
    }

    public int getVarOne() {
        return VarOne;
    }
    public void timesTwo() {
        int VarTwo = 2;
        for (int i=1; i<=10; i++) {
            System.out.println(i + " times two = " + i*VarTwo);
        }
    }

    public void useInner() {
        InnerClass innerClass = new InnerClass();
        System.out.println("VarThree from outer class is accessed here: " + innerClass.VarThree);
    }

    public class InnerClass {
        private int VarThree = 3;

        public InnerClass() {
            System.out.println("InnerClass called and VarOne is " + VarOne + " and VarThree is " + VarThree);
        }

        public void timesTwo() {
            System.out.println("VarOne is still available here and value is " + VarOne);
            for (int i=1; i<=10; i++) {
                System.out.println(i + " times two = " + i * VarThree);
            }
        }
    }
}
