package com.walking.lesson14_polymorphism.task1.regularFigure;

import java.util.Scanner;

public class RegularFigure {
    final String EMPTY_STRING = "";
    final String HORIZONTAL_ELEMENT = "--";
    final String NEW_LINE_SYMBOL = "\n";
    final String EMPTY_ELEMENT = " ";
    final int size;


    public RegularFigure(int size) {
        this.size = size;
    }

    public void printFigure() {
        System.out.println("Unknown figure");
    }

    String createHorizontalLine() {
        String horizontalLine = EMPTY_ELEMENT;

        for (int i = 0; i < size; i++) {
            horizontalLine += HORIZONTAL_ELEMENT;
        }

        horizontalLine += EMPTY_ELEMENT + NEW_LINE_SYMBOL;

        return horizontalLine;
    }
}
