package com.company;

public class Bed {

    private String style;
    private int pillows;
    private int sheets;
    private int height;
    private int quilts;

    public Bed(String style, int pillows, int sheets, int height, int quilts) {
        this.style = style;
        this.pillows = pillows;
        this.sheets = sheets;
        this.height = height;
        this.quilts = quilts;
    }

    public String getStyle() {
        return style;
    }

    public int getPillows() {
        return pillows;
    }

    public int getSheets() {
        return sheets;
    }

    public int getHeight() {
        return height;
    }

    public int getQuilts() {
        return quilts;
    }

    public void make() {
        System.out.println("Bed -> Making");
    }
}
