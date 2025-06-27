package com.walking.lesson20_exceptions.task2.model;

public class Square implements Figure{

    @Override
    public String buildFigure(int width) {
        StringBuilder returnString = new StringBuilder();

        returnString.append(HORIZONTAL_SYMBOL.repeat(width));
        returnString.append("\n");

        for (int y = 1; y < width-1; y++) {
            returnString.append(VERTICAL_SYMBOL);
            returnString.append(FILLING_SYMBOL.repeat(width - 2));
            returnString.append(VERTICAL_SYMBOL + "\n");
        }
        returnString.append(HORIZONTAL_SYMBOL.repeat(width));
        returnString.append("\n");

        return returnString.toString();
    }
}
