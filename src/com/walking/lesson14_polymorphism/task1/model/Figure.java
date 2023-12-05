package com.walking.lesson14_polymorphism.task1.model;

public class Figure {
    protected final String EMPTY_ELEMENT = " ";
    protected final String EMPTY_STRING = "";
    protected final String NEXT_LINE = "\n";

    protected final int sideLength;

    public Figure(int sideLength) {
        this.sideLength = sideLength;
    }

    public String printFigure() {
        return "Print figure";
    }
}