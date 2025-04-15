package com.walking.lesson25_nested_classes.task1.inner_class.figure;

public interface RegularFigure {
    // как я поняла, у интерфейса внутренние классы статик по умолчанию, поэтому тут заменила интерфейс на класс

    String SPACE = " ";
    String NEXT_LINE_SYMBOL = "\n";
    String HORIZONTAL = "-";
    String VERTICAL = "|";
    String RIGHT_SIDE = "\\";
    String LEFT_SIDE = "/";
    String BOTTOM_SIDE = "_";

    String getFigure();
}
