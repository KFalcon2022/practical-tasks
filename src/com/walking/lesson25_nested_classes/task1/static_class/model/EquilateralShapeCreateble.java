package com.walking.lesson25_nested_classes.task1.static_class.model;

public class EquilateralShapeCreateble {
    static final String EMPTY_ELEMENT = " ";
    static final String EMPTY_STRING = "";
    static final char NEW_LINE_SYMBOL = '\n';


    public static class EquilateralTriangle {
        //    За единицу у основания принято "--" для минимально удобоваримой визуализации
        public static final String TRIANGLE_HORIZONTAL_SIDE_ELEMENT = "--";
        public static final String TRIANGLE_LEFT_SIDE_ELEMENT = "/";
        public static final String TRIANGLE_RIGHT_SIDE_ELEMENT = "\\";

        protected final int length;

        public EquilateralTriangle(int length) {
            this.length = length;
        }


        //    Предлагаю особо не углубляться в способ отрисовки, он не критичен - задача направлена на
//    овладевание переопределением, а не псевдографикой
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

        public int getLength() {
            return length;
        }

    }

    public static class Square {
        public static final String RECTANGLE_HORIZONTAL_ELEMENT = "-";
        public static final String RECTANGLE_VERTICAL_ELEMENT = "|";

        protected final int length;

        public Square(int length) {
            this.length = length;
        }

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

        public int getLength() {
            return length;
        }
    }
}

