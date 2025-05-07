package com.walking.lesson20_exceptions.task2.model;

public interface Figure {
    String VERTICAL_SYMBOL = "|";
    String HORIZONTAL_SYMBOL = "-";
    String FILLING_SYMBOL = " ";

    String buildFigure(int width);
}
