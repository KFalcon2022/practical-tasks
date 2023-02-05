package com.walking.lesson25_nested_classes.task1.nested_class.model;

public class Shape {

    private static final String EMPTY_ELEMENT = " ";
    private static final String EMPTY_STRING = "";
    private static final char NEW_LINE_SYMBOL = '\n';

    private int length;

    public Shape(int length) {
        this.length = length;
    }

    public class EquilateralTriangle implements EquilateralShape {
        private static final String TRIANGLE_HORIZONTAL_SIDE_ELEMENT = "--";
        private static final String TRIANGLE_LEFT_SIDE_ELEMENT = "/";
        private static final String TRIANGLE_RIGHT_SIDE_ELEMENT = "\\";

        @Override
        public String createShapeString() {
            String triangle = EMPTY_STRING;

            for (int i = 0; i < length; i++) {
                for (int j = 0; j < length - i; j++) {
                    triangle += EMPTY_ELEMENT;
                }

                triangle += TRIANGLE_LEFT_SIDE_ELEMENT;

                for (int j = 0; j < i * 2; j++) {
                    triangle += EMPTY_ELEMENT;
                }

                triangle += TRIANGLE_RIGHT_SIDE_ELEMENT + NEW_LINE_SYMBOL;
            }

            triangle += " ";

            for (int i = 0; i < length; i++) {
                triangle += TRIANGLE_HORIZONTAL_SIDE_ELEMENT;
            }

            return triangle;
        }
    }

    public class Square implements EquilateralShape {
        private static final String RECTANGLE_HORIZONTAL_ELEMENT = "-";
        private static final String RECTANGLE_VERTICAL_ELEMENT = "|";

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
}
