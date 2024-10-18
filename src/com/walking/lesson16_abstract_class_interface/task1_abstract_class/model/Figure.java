package com.walking.lesson16_abstract_class_interface.task1_abstract_class.model;

public abstract class Figure {
    protected static final String VERTICAL_SYMBOL = "|";
    protected static final String HORIZONTAL_SYMBOL = "-";
    protected static final String FILLING_SYMBOL = " ";
    protected static final String TRIANGLE_LEFT_SYMBOL = "/";
    protected static final String TRIANGLE_RIGHT_SYMBOL = "\\";

    protected int width;

    Figure(int width){
        this.width = width;
    }

    public abstract String builtFigure();
}
