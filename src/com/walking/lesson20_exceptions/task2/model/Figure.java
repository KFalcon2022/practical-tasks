package com.walking.lesson20_exceptions.task2.model;

public abstract class Figure {
    protected final String EMPTY_ELEMENT = "  ";
    protected final String EMPTY_STRING = "";
    protected final String NEXT_LINE = "\n";

    protected final int sideLength;

    public Figure(int sideLength) {
        this.sideLength = sideLength;
    }

    public abstract String printFigure();
}
