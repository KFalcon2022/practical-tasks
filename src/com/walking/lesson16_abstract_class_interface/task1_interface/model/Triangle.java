package com.walking.lesson16_abstract_class_interface.task1_interface.model;

public class Triangle implements Figure {
    private final String LEFT_SIDE = "/";
    private final String RIGHT_SIDE = "\\";
    private final String BOTTOM_LINE = "--";

    private final int sideLength;

    public Triangle(int sideLength) {
        this.sideLength = sideLength;
    }

    @Override
    public int getLength() {
        return sideLength;
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
