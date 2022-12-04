package com.walking.lesson16_abstract_class_interface.task1.var1.model;

public interface EquilateralShape {
    String EMPTY_ELEMENT = " ";
    String EMPTY_STRING = "";
    char NEW_LINE_SYMBOL = '\n';

    static String unknownShape() {
        return "Unknown shape";
    }

    String createShapeString();

    int getLength();

}

