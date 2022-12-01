package com.walking.lesson16_abstract_class_interface.task1_interface.model;

public interface EquilateralShape {
    String EMPTY_ELEMENT = " ";
    String EMPTY_STRING = "";
    char NEW_LINE_SYMBOL = '\n';

//    int length;

/*
    protected EquilateralShape(int length) {
        this.length = length;
    }
*/

/*
    public int getLength() {
        return length;
    }
*/

    String createShapeString();
}
