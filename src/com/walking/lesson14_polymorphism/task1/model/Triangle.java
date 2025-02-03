package com.walking.lesson14_polymorphism.task1.model;

public class Triangle extends CorrectFigure {
    public static final String TRIANGLE_LEFT_SIDE_UNIT = "/";
    public static final String TRIANGLE_RIGHT_SIDE_UNIT = "\\";

    public Triangle(int length) {
        super(length);
    }

    @Override
    public void printCorrectFigure() {
        super.printCorrectFigure();
    }

    @Override
    protected String printCorrectFigure(int height, int width) {
        String horizontalLine = createHorizontalLine(width);
        String verticalLines = createVerticalLines(height, width);
        return verticalLines + horizontalLine;
    }

    @Override
    protected String createHorizontalLine(int width) {
        String horizontalLine = SPACE_UNIT;

        for (int i = 0; i < width * 2; i++) {
            horizontalLine += HORIZONTAL_UNIT;
        }
        return horizontalLine + NEW_LINE_UNIT;
    }

    @Override
    protected String createVerticalLines(int height, int width) {
        String verticalLines = EMPTY_UNIT;
        int addingValue = 0;

        verticalLines += createVerticalLines(height, width, addingValue, verticalLines);
        return verticalLines;
    }

    protected String createVerticalLines(int height, int width, int addingValue, String verticalLines) {
        if (height == 0) {
            return verticalLines;
        }
        for (int w = width; w > 0; w--) {
            verticalLines += SPACE_UNIT;
        }
        verticalLines += TRIANGLE_LEFT_SIDE_UNIT;

        for (int a = addingValue; a > 0; a--) {
            verticalLines += SPACE_UNIT;
        }
        verticalLines += TRIANGLE_RIGHT_SIDE_UNIT + NEW_LINE_UNIT;
        width--;
        height--;
        addingValue += 2;
        return createVerticalLines(height, width, addingValue, verticalLines);
    }
}