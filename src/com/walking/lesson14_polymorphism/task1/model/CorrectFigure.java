package com.walking.lesson14_polymorphism.task1.model;

public class CorrectFigure {
    public static final String HORIZONTAL_UNIT = "-";
    public static final String SPACE_UNIT = " ";
    public static final String NEW_LINE_UNIT = "\n";
    public static final String EMPTY_UNIT = "";

    private final int height;


    public CorrectFigure(int length) {
        this.height = length;
        printCorrectFigure();
    }

    public void printCorrectFigure() {
        int width = height;
        System.out.println(printCorrectFigure(height, width));
    }

    protected String printCorrectFigure(int height, int width) {
        String horizontalLine = createHorizontalLine(width);
        String verticalLines = createVerticalLines(height, width);
        return horizontalLine + verticalLines + horizontalLine;
    }

    protected String createHorizontalLine(int width) {
        String horizontalLine = SPACE_UNIT;

        for (int i = 0; i < width * 3; i++) {
            horizontalLine += HORIZONTAL_UNIT;
        }
        return horizontalLine + SPACE_UNIT + NEW_LINE_UNIT;
    }

    protected String createVerticalLines(int height, int width) {
        String verticalLines = "";

        for (int i = 0; i < height; i++) {
            verticalLines += createVerticalLineUnit(width);
        }
        return verticalLines;
    }

    protected String createVerticalLineUnit(int width) {
        String verticalLineUnit = EMPTY_UNIT;
        return verticalLineUnit + EMPTY_UNIT;
    }
}
