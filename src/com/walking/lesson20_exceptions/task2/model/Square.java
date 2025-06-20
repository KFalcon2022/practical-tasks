package com.walking.lesson20_exceptions.task2.model;

public class Square extends EquilateralShape {
    public static final String RECTANGLE_HORIZONTAL_ELEMENT = "-";
    public static final String RECTANGLE_VERTICAL_ELEMENT = "-";

    public Square(int length) {
        super(length);
    }

    @Override
    public String createShapeString() {
        String horizontalLine = createHorizontalLine();
        String verticalLines = createVerticalLines();

        return horizontalLine + verticalLines + horizontalLine;
    }

    private String createHorizontalLine() {
        String horizontalLine = EMPTY_ELEMENT;

        for (int i = 0; i < length; i++) {
            horizontalLine += RECTANGLE_HORIZONTAL_ELEMENT;
        }

        horizontalLine += EMPTY_ELEMENT + NEW_LINE_SYMBOL;

        return horizontalLine;
    }

    private String createVerticalLines() {
        String verticalLinesUnit = getVerticalLinesUnit();

        String vertcalLines = EMPTY_STRING;

        for (int i = 0; i < length; i++) {
            vertcalLines += verticalLinesUnit;
        }

        return vertcalLines;
    }

    private String getVerticalLinesUnit() {
        String verticalLineUnit = RECTANGLE_VERTICAL_ELEMENT;

        for (int i = 0; i < length; i++) {
            verticalLineUnit += EMPTY_ELEMENT;
        }

        verticalLineUnit += RECTANGLE_VERTICAL_ELEMENT + NEW_LINE_SYMBOL;

        return verticalLineUnit;
    }
}
