package com.walking.lesson16_abstract_class_interface.task1_interface.model;

public class Square implements Figure{

    @Override
    public String drawFigure(int width) {

        StringBuilder wholeFigure = new StringBuilder();
        String symbolToFill;
        for (byte y = 0; y < width; y++) {
            if (y == 0 || y == width-1) symbolToFill = HORIZONTAL_SYMBOL;
            else symbolToFill = FILLING_SYMBOL;

            for (int x = 0; x < width; x++) {
                if (x == 0 || x == width-1) {
                    wholeFigure.append(VERTICAL_SYMBOL);
                } else {
                    wholeFigure.append(symbolToFill);
                }
            }
            wholeFigure.append("\n");
        }
        return wholeFigure.toString();
    }
}
