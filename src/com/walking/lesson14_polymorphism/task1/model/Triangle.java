package com.walking.lesson14_polymorphism.task1.model;

public class Triangle extends com.walking.lesson14_polymorphism.task1.model.CorrectFigure {
    public static final String LEFT_SIDE_UNIT = "/";
    public static final String RIGHT_SIDE_UNIT = "\\";
    public static final String HORIZONTAL_UNIT = "--";

    public Triangle(int width) {
        super(width);
    }

    @Override
    public void printFigure() {
        System.out.println(createVerticalLines() + createHorizontalLine());
    }

    @Override
    protected String createHorizontalLine() {
        String horizontalLine = EMPTY_UNIT;
        for (int i = 0; i < width; i++) {
            horizontalLine += HORIZONTAL_UNIT;
        }
        return horizontalLine + NEW_LINE_UNIT;
    }

    @Override
    protected String createVerticalLines() {
        String verticalLines = "";
        return createVerticalLines(width, width, verticalLines);
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
