package com.walking.lesson16_abstract_class_interface.task1_interface.model;

public class Square implements Figure {
    private final String VERTICAL_LINE = "|";
    private final String HORISONT_LINE = "--";

    private final int sideLength;

    public Square(int sideLength) {
        this.sideLength = sideLength;
    }

    @Override
    public int getLength() {
        return sideLength;
    }

    @Override
    public String printFigure() {
        String result = EMPTY_STRING;

        result += printHorisontLine();
        result += printVerticalLine();
        result += printHorisontLine();

        return result;
    }

    private String printHorisontLine() {
        String result = EMPTY_STRING;

        for (int i = 0; i < sideLength; i++) {
            result += HORISONT_LINE;
        }
        result += NEXT_LINE;

        return result;
    }

    private String printVerticalLine() {
        String result = EMPTY_STRING;

        for (int i = 0; i < sideLength; i++) {
            for (int j = 0; j < sideLength; j++) {
                if (j == 0) {
                    result += VERTICAL_LINE;
                } else if (j == sideLength - 1) {
                    result += VERTICAL_LINE + NEXT_LINE;
                } else {
                    result += EMPTY_ELEMENT;
                }
            }
        }

        return result;
    }
}
