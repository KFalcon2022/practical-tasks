package com.walking.lesson14_polymorphism.task1.model;

public class Square extends RegularFigure {
    public static final String VERTICAL_LINE_UNIT = "|";
    public static final String HORIZONTAL_UNIT = "---";

    public Square(int length) {
        super(length);
    }

    @Override
    public String getFigure() {
        return createHorizontalLine() + createVerticalLines() + createHorizontalLine();

    }

    protected String createHorizontalLine() {
        String horizontalLine = EMPTY_UNIT;
        for (int i = 0; i < length; i++) {
            horizontalLine += HORIZONTAL_UNIT;
        }
        horizontalLine += EMPTY_UNIT + NEW_LINE_UNIT;
        return horizontalLine;
    }

    protected String createVerticalLines() {
        String verticalLineUnit = createVerticalLineUnit();
        String verticalLines = "";
        for (int i = 0; i < length; i++) {
            verticalLines += verticalLineUnit;
        }
        return verticalLines;
    }

    private String createVerticalLineUnit() {
        String verticalLineUnit = VERTICAL_LINE_UNIT;
        for (int i = 0; i < length * 3; i++) {
            verticalLineUnit += EMPTY_UNIT;
        }
        verticalLineUnit += VERTICAL_LINE_UNIT + NEW_LINE_UNIT;
        return verticalLineUnit;
    }
}
