package com.walking.lesson17_enum.task3.model;

public enum EquiliteralShape implements DataRequire {
    EQUILITERAL_TRIANGLE {
        final String TRIANGLE_HORIZONTAL_SIDE_ELEMENT = "--";
        final String TRIANGLE_LEFT_SIDE_ELEMENT = "/";
        final String TRIANGLE_RIGHT_SIDE_ELEMENT = "\\";

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
            triangle += EMPTY_ELEMENT;

            for (int i = 0; i < length; i++) {
                triangle += TRIANGLE_HORIZONTAL_SIDE_ELEMENT;
            }

            return triangle;
        }
    },
    SQUARE {
        final String RECTANGLE_HORIZONTAL_ELEMENT = "-";
        final String RECTANGLE_VERTICAL_ELEMENT = "-";

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

            String verticalLines = EMPTY_STRING;

            for (int i = 0; i < length; i++) {
                verticalLines += verticalLinesUnit;
            }

            return verticalLines;
        }

        private String getVerticalLinesUnit() {
            String verticalLinesUnit = RECTANGLE_VERTICAL_ELEMENT;

            for (int i = 0; i < length; i++) {
                verticalLinesUnit += EMPTY_ELEMENT;
            }

            verticalLinesUnit += RECTANGLE_VERTICAL_ELEMENT + NEW_LINE_SYMBOL;

            return verticalLinesUnit;
        }
    };

    public static final String EMPTY_ELEMENT = " ";
    public static final String EMPTY_STRING = "";
    public static final char NEW_LINE_SYMBOL = '\n';

    final int length = DataRequire.requireInt();

    public int getLength() {
        return length;
    }

    public abstract String createShapeString();
}
