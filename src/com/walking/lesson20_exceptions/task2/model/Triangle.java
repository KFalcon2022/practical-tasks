package com.walking.lesson20_exceptions.task2.model;

public class Triangle implements Figure{
    private static final String LEFT_TRIANGLE_SYMBOL = "/";
    private static final String RIGHT_TRIANGLE_SYMBOL = "\\";

    @Override
    public String buildFigure(int width) {
        StringBuilder returnString = new StringBuilder();
        int sideSpaces = (width / 2) - 1;
        int innerSpaces = 0;

        for (int y = 0; y <= width / 2 - 1; y++) {
            returnString.append(FILLING_SYMBOL.repeat(sideSpaces));
            returnString.append(LEFT_TRIANGLE_SYMBOL);
            returnString.append(FILLING_SYMBOL.repeat(innerSpaces));
            returnString.append(RIGHT_TRIANGLE_SYMBOL);
            returnString.append(FILLING_SYMBOL.repeat(sideSpaces));
            returnString.append("\n");
            sideSpaces--;
            innerSpaces += 2;
        }

        returnString.append(HORIZONTAL_SYMBOL.repeat(width / 2 * 2));
        returnString.append("\n");

        return returnString.toString();
    }
}
