package com.walking.lesson25_nested_classes.task1.nested_class.model;

interface EquilateralShape {
    String EMPTY_ELEMENT = " ";
    String EMPTY_STRING = "";
    char NEW_LINE_SYMBOL = '\n';

    void setLength(int length) ;

    int getLength();

    String createShapeString() ;
}