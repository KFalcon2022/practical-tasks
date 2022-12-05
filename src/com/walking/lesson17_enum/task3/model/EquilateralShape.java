package com.walking.lesson17_enum.task3.model;

public enum EquilateralShape {
    TRIANGLE {
        final String TRIANGLE_HORIZONTAL_SIDE_ELEMENT = "--";
        final String TRIANGLE_LEFT_SIDE_ELEMENT = "/";
        final String TRIANGLE_RIGHT_SIDE_ELEMENT = "\\";

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
    },
    SQUARE{
        final String RECTANGLE_HORIZONTAL_ELEMENT = "-";
        final String RECTANGLE_VERTICAL_ELEMENT = "|";


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

    };
    int length;
    final String EMPTY_ELEMENT = " ";
    final String EMPTY_STRING = "";
    final char NEW_LINE_SYMBOL = '\n';

    public EquilateralShape createShape(int length){
        this.length = length;
        return this;
    }
    public abstract String createShapeString();
}