package com.walking.lesson25_nested_classes.task1.static_class.interfaces;

public interface RightShapeInterface {
    final String EMPTY_CHAR=" ";
     static final String HORIZONTAL_LINE="-";
     static final String VERTICAL_LINE="|";
     static final String SLASH_LINE_LEFT="/";
     static final String SLASH_LINE_RIGTH="\\";
    void drawShape();

    String drawHorizontalLine();

    String createShape();
}
