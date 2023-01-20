package com.walking.lesson16_abstract_class_interface.task1_interface.model;

public interface Shapeble {
    static final String EMPTY_ELEMENT = " ";
    static final String EMPTY_STRING = "";
    static final char NEW_LINE_SYMBOL = '\n';

    int getLength();

    String preRender();
}