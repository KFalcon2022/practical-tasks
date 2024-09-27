package com.walking.lesson17_enum.task3.model;

public enum EquilateralShape {
    EQUILATERALTRIANGLE,
    SQUARE;

    public String createShapeString(int length) {
        if (this.equals(EQUILATERALTRIANGLE)) {
            return this.createTriangleString(length);
        } else if (this.equals(SQUARE)) {
            return this.createSquareString(length);
        }
        return null;
    }

    private String createTriangleString(int length) {
        String triangle = DrawElements.EMPTY_STRING;

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - i; j++) {
                triangle += DrawElements.EMPTY_ELEMENT;
            }

            triangle += DrawElements.TRIANGLE_LEFT_SIDE_ELEMENT;

            for (int j = 0; j < i * 2; j++) {
                triangle += DrawElements.EMPTY_ELEMENT;
            }

            triangle += DrawElements.TRIANGLE_RIGHT_SIDE_ELEMENT + DrawElements.NEW_LINE_SYMBOL;
        }

        triangle += " ";

        for (int i = 0; i < length; i++) {
            triangle += DrawElements.TRIANGLE_HORIZONTAL_SIDE_ELEMENT;
        }

        return triangle;
    }

    private String createSquareString(int length) {
        String horizontalLine = createHorizontalLine(length);
        String verticalLines = createVerticalLines(length);

        return horizontalLine + verticalLines + horizontalLine;
    }

    private String createHorizontalLine(int length) {
        String horizontalLine = DrawElements.EMPTY_ELEMENT;

        for (int i = 0; i < length; i++) {
            horizontalLine += DrawElements.RECTANGLE_HORIZONTAL_ELEMENT;
        }

        horizontalLine += DrawElements.EMPTY_ELEMENT + DrawElements.NEW_LINE_SYMBOL;

        return horizontalLine;
    }

    private String createVerticalLines(int length) {
        String verticalLinesUnit = getVerticalLinesUnit(length);

        String verticalLines = DrawElements.EMPTY_STRING;

        for (int i = 0; i < length; i++) {
            verticalLines += verticalLinesUnit;
        }

        return verticalLines;
    }

    private String getVerticalLinesUnit(int length) {
        String verticalLinesUnit = DrawElements.RECTANGLE_VERTICAL_ELEMENT;

        for (int i = 0; i < length; i++) {
            verticalLinesUnit += DrawElements.EMPTY_ELEMENT;
        }

        verticalLinesUnit += DrawElements.RECTANGLE_VERTICAL_ELEMENT + DrawElements.NEW_LINE_SYMBOL;

        return verticalLinesUnit;
    }
}
