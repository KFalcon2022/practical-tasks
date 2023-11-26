package com.walking.lesson17_enum.task3;

public enum EquilateralShape {
    EQUILATERAL_TRIANGLE{
        public String createShape(int sideLength){
            final String TRIANGLE_HORIZONTAL_SIDE_ELEMENT = "--";
            final String TRIANGLE_LEFT_SIDE_ELEMENT = "/";
            final String TRIANGLE_RIGHT_SIDE_ELEMENT = "\\";
            final String EMPTY_ELEMENT = " ";
            final char NEW_LINE_SYMBOL = '\n';
            String triangle = "";

            for (int i = 0; i < sideLength; i++) {
                for (int j = 0; j < sideLength - i; j++) {
                    triangle += EMPTY_ELEMENT;
                }

                triangle += TRIANGLE_LEFT_SIDE_ELEMENT;

                for (int j = 0; j < i * 2; j++) {
                    triangle += EMPTY_ELEMENT;
                }

                triangle += TRIANGLE_RIGHT_SIDE_ELEMENT + NEW_LINE_SYMBOL;
            }

            triangle += " ";

            for (int i = 0; i < sideLength; i++) {
                triangle += TRIANGLE_HORIZONTAL_SIDE_ELEMENT;
            }
            return triangle;
        }
    },

    SQUARE(){
        String createShape(int sideLength){
            final String EMPTY_ELEMENT = " ";
            final String HORIZONTAL_LINE = "-";
            final String VERTICAL_LINE = "|";
            final char NEW_LINE_SYMBOL = '\n';
            String square = "";
            //Печать верхней стороны
            square = EMPTY_ELEMENT;
            for (int i = 0; i < sideLength; i++) {
                square += HORIZONTAL_LINE + HORIZONTAL_LINE + HORIZONTAL_LINE;
            }
            square += NEW_LINE_SYMBOL;
            //Печать боковых сторон
            for (int i = 0; i < sideLength; i++) {
                square += VERTICAL_LINE;
                for (int j = 0; j < sideLength * 3; j++) {
                    square += EMPTY_ELEMENT;
                }
                square += VERTICAL_LINE + NEW_LINE_SYMBOL;
            }
            square += EMPTY_ELEMENT;
            //Печать нижней стороны
            for (int i = 0; i < sideLength; i++) {
                square += HORIZONTAL_LINE + HORIZONTAL_LINE + HORIZONTAL_LINE;
            }
            square += (EMPTY_ELEMENT);
            return square;
        }
    };

    String createShape(int sideLength){
        return "";
    }
}
