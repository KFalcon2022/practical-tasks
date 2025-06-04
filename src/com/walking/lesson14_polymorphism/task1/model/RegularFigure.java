package com.walking.lesson14_polymorphism.task1.model;

public class RegularFigure {
    public static final String EMPTY_UNIT = " ";
    public static final String NEW_LINE_UNIT = "\n";

    public final int length;

    public RegularFigure(int length) {
        this.length = length;
    }

    public String getFigure() {
        String figure = EMPTY_UNIT + NEW_LINE_UNIT;
        return figure;
    }
}
