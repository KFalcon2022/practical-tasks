package com.walking.lesson16_abstract_class_interface.task1_abstract_class.model;

public abstract class Figure {
    protected final String EMPTY_ELEMENT = " ";
    protected final String EMPTY_STRING = "";
    protected final String NEXT_LINE = "\n";

    protected final int sideLength;

    public Figure(int sideLength) {
        this.sideLength = sideLength;
    }

    public abstract String printFigure();
}
