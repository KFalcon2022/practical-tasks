package com.walking.lesson14_polymorphism.task1.model;

public class Triangle extends RegularFigure {
    public static final String LEFT_SIDE_UNIT = "/";
    public static final String RIGHT_SIDE_UNIT = "\\";
    public static final String HORIZONTAL_UNIT = "--";

    public Triangle(int length) {
        super(length);
    }

    @Override
    public String getFigure() {
        return createVerticalLines() + createHorizontalLine();
    }

    protected String createHorizontalLine() {
        String horizontalLine = EMPTY_UNIT;
        for (int i = 0; i < length; i++) {
            horizontalLine += HORIZONTAL_UNIT;
        }
        return horizontalLine + NEW_LINE_UNIT;
    }

    protected String createVerticalLines() {
        String verticalLines = "";
        return createVerticalLines(length, length, verticalLines);
    }

    private String createVerticalLines(int width, int height, String verticalLines) {
        for (int l = 0; l < height; l++) {
            verticalLines += createVerticalLineUnit(width--, l);
        }
        return verticalLines;
    }

    private String createVerticalLineUnit(int width, int height) {
        String verticalLineUnit = "";
        for (int before = width; before > 0; before--) {
            verticalLineUnit += EMPTY_UNIT;
        }
        verticalLineUnit += LEFT_SIDE_UNIT;
        for (int after = height * 2; after > 0; after--) {
            verticalLineUnit += EMPTY_UNIT;
        }
        verticalLineUnit += RIGHT_SIDE_UNIT + NEW_LINE_UNIT;

        return verticalLineUnit;
    }
}
