package com.walking.lesson20_exceptions.task2.model;

public class Square extends Figure {
    private final String VERTICAL_LINE = "|";
    private final String HORISONT_LINE = "--";

    public Square(int sideLength) {
        super(sideLength);
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
