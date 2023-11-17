package com.walking.lesson16_abstract_class_interface.task1_interface.model;

public interface Figure {
    String VERTICAL_SYMBOL = "|";
    String HORIZONTAL_SYMBOL = "-";
    String FILLING_SYMBOL = " ";
    String TRIANGLE_LEFT_SYMBOL = "/";
    String TRIANGLE_RIGHT_SYMBOL = "\\";

    String drawFigure(int width);
}
