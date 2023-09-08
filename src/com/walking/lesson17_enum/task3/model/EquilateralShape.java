package com.walking.lesson17_enum.task3.model;

public enum EquilateralShape {

    SQUARE(4) {
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
    },

    EQUILATERAL_TRIANGLE(5) {
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
    };

    protected final String EMPTY_ELEMENT = " ";
    protected final String EMPTY_STRING = "";
    protected final String NEXT_LINE = "\n";
    protected final String VERTICAL_LINE = "|";
    protected final String HORISONT_LINE = "--";
    protected final String LEFT_SIDE = "/";
    protected final String RIGHT_SIDE = "\\";
    protected final String BOTTOM_LINE = "--";

    protected final int sideLength;

    EquilateralShape(int sideLength) {
        this.sideLength = sideLength;
    }

    public abstract String printFigure();
}
