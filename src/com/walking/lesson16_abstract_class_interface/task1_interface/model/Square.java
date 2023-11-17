package com.walking.lesson16_abstract_class_interface.task1_interface.model;

public class Square implements Figure{

    @Override
    public String drawFigure(int width) {

        StringBuilder wholeFigure = new StringBuilder();
        String symbol;
        for (byte y = 0; y < width; y++) {
            if (y == 0 || y == width-1) symbol = HORIZONTAL_SYMBOL;
            else symbol = FILLING_SYMBOL;

            for (int x = 0; x < width; x++) {
                if (x == 0 || x == width-1) {
                    wholeFigure.append(VERTICAL_SYMBOL);
                } else {
                    wholeFigure.append(symbol);
                }
            }
            wholeFigure.append("\n");
        }
        return wholeFigure.toString();
    }
}
