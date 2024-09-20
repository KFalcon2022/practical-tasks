package com.walking.lesson20_exceptions.task2.model;

public class Triangle extends Figure {
    private final String LEFT_SIDE = "/";
    private final String RIGHT_SIDE = "\\";
    private final String BOTTOM_LINE = "--";

    public Triangle(int sideLength) {
        super(sideLength);
    }

    @Override
    public String printFigure() {
        String result = EMPTY_STRING;
        result += printSideSides();
        result += printBottomLine();
        return result;
    }

    private String printSideSides() {
        String result = EMPTY_STRING;

        for (int i = 0; i < sideLength; i++) {
            for (int j = 0; j < sideLength * 2; j++) {
                if (j == sideLength - i - 1) {
                    result += LEFT_SIDE;
                } else if (j == sideLength + i) {
                    result += RIGHT_SIDE;
                } else {
                    result += EMPTY_ELEMENT;
                }
            }

            result += NEXT_LINE;

        }

        return result;
    }

    private String printBottomLine() {
        String result = EMPTY_STRING;

        for (int i = 0; i < sideLength; i++) {
            result += BOTTOM_LINE;
        }
        result += NEXT_LINE;

        return result;
    }
}
