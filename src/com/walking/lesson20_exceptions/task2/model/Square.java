package com.walking.lesson20_exceptions.task2.model;

public class Square extends EquilateralShape {
    public static final String RECTANGLE_HORIZONTAL_ELEMENT = "-";
    public static final String RECTANGLE_VERTICAL_ELEMENT = "|";

    public Square(int length) {
        super(length);
    }

    @Override
    public String createShapeString() {
        String horizontalLine = createHorizontalLine(length);
        String verticalLines = createVerticalLines(length);

        return horizontalLine + verticalLines + horizontalLine;
    }

    private String createHorizontalLine(int length) {
        String horizontalLine = EMPTY_ELEMENT;

        for (int i = 0; i < length; i++) {
            horizontalLine += RECTANGLE_HORIZONTAL_ELEMENT;
        }

        horizontalLine += EMPTY_ELEMENT + NEW_LINE_SYMBOL;

        return horizontalLine;
    }

    private String createVerticalLines(int length) {
        String verticalLinesUnit = getVerticalLinesUnit(length);

        String verticalLines = EMPTY_STRING;

        for (int i = 0; i < length; i++) {
            verticalLines += verticalLinesUnit;
        }

        return verticalLines;
    }

    private String getVerticalLinesUnit(int length) {
        String verticalLinesUnit = RECTANGLE_VERTICAL_ELEMENT;

        for (int i = 0; i < length; i++) {
            verticalLinesUnit += EMPTY_ELEMENT;
        }

        verticalLinesUnit += RECTANGLE_VERTICAL_ELEMENT + NEW_LINE_SYMBOL;

        return verticalLinesUnit;
    }
}
