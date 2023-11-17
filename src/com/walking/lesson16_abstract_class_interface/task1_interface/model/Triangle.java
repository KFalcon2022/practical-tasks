package com.walking.lesson16_abstract_class_interface.task1_interface.model;

public class Triangle implements Figure{

    @Override
    public String drawFigure(int width) {
        StringBuilder wholeFigure = new StringBuilder();
        StringBuilder sideSpaces = new StringBuilder();
        StringBuilder innerSpaces = new StringBuilder();
        byte spaceCount = (byte) ((width-2) / 2);
        byte innerSpaceCount = 0;

        for (byte y = spaceCount; y >= 0; y--) {
            for (byte x = 0; x <= y; x++) {
                sideSpaces.append(FILLING_SYMBOL);
            }

            for (byte x = 0; x < innerSpaceCount; x++) {
                if (y != 0) innerSpaces.append(FILLING_SYMBOL);
                else innerSpaces.append(HORIZONTAL_SYMBOL);
            }

            wholeFigure.append(sideSpaces).append(TRIANGLE_LEFT_SYMBOL).append(innerSpaces).append(TRIANGLE_RIGHT_SYMBOL).append(sideSpaces).append("\n");
            sideSpaces = new StringBuilder();
            innerSpaces = new StringBuilder();
            innerSpaceCount += 2;
        }

        return wholeFigure.toString();
    }
}
