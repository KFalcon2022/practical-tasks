package com.walking.lesson14_polymorphism.task1.model;

public class CorrectFigure {
    public static final String EMPTY_UNIT =" ";
    public static final String NEW_LINE_UNIT = "\n";

    public final int width;

    public CorrectFigure(int width) {
        this.width = width;
    }
    public void printFigure() {
        String figure = createHorizontalLine() + createVerticalLines();
    }

    protected String createHorizontalLine() {
        return EMPTY_UNIT;
    }

    protected String createVerticalLines() {
        return EMPTY_UNIT;
    }
}
