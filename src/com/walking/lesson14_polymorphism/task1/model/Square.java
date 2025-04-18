package com.walking.lesson14_polymorphism.task1.model;

public class Square extends com.walking.lesson14_polymorphism.task1.model.CorrectFigure {
    public static final String VERTICAL_LINE_UNIT = "|";
    public static final String HORIZONTAL_UNIT = "---";

    public Square(int width) {
        super(width);
    }

    @Override
    public void printFigure() {
        String horizontalLine = createHorizontalLine();
        String vertcalLines = createVerticalLines();
        System.out.println(horizontalLine + vertcalLines + horizontalLine);
    }

    @Override
    protected String createHorizontalLine() {
        String horizontalLine = EMPTY_UNIT;
        for (int i = 0; i < width; i++) {
            horizontalLine += HORIZONTAL_UNIT;
        }
        horizontalLine += EMPTY_UNIT + NEW_LINE_UNIT;
        return horizontalLine;
    }

    @Override
    protected String createVerticalLines() {
        String verticalLineUnit = createVerticalLineUnit();
        String verticalLines = "";
        for (int i = 0; i < width; i++) {
            verticalLines += verticalLineUnit;
        }
        return verticalLines;
    }

    private String createVerticalLineUnit() {
        String verticalLineUnit = VERTICAL_LINE_UNIT;
        for (int i = 0; i < width * 3; i++) {
            verticalLineUnit += EMPTY_UNIT;
        }
        verticalLineUnit += VERTICAL_LINE_UNIT + NEW_LINE_UNIT;
        return verticalLineUnit;
    }
}
