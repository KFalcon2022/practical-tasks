package com.walking.lesson17_enum.task3;

public enum EquilateralShapeType {
    TRIANGLE {
        public static final String TRIANGLE_HORIZONTAL_SIDE_ELEMENT = "--";
        public static final String TRIANGLE_LEFT_SIDE_ELEMENT = "/";
        public static final String TRIANGLE_RIGHT_SIDE_ELEMENT = "\\";

        @Override
        public String createShapeString(int length) {
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
    public static final String EMPTY_ELEMENT = " ";
    public static final String EMPTY_STRING = "";
    public static final char NEW_LINE_SYMBOL = '\n';

    public abstract String createShapeString(int length);
    }
