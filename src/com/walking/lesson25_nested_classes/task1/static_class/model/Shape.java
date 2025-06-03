package com.walking.lesson25_nested_classes.task1.static_class.model;

public interface Shape {
    String SPACE_SYMBOL = " ";
    String NEXT_LINE = "\n";
    String EMPTY_STRING = "";

    int getSideLength();

    String createShapeString();
}
