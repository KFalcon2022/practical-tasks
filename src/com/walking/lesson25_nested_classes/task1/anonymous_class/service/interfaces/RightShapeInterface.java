package com.walking.lesson25_nested_classes.task1.anonymous_class.service.interfaces;

public interface RightShapeInterface {
    final String EMPTY_CHAR=" ";
     static final String HORIZONTAL_LINE="-";
     static final String VERTICAL_LINE="|";
     static final String SLASH_LINE_LEFT="/";
     static final String SLASH_LINE_RIGTH="\\";
    void drawShape();

    String drawHorizontalLine(int sideSize, String horizontalLine);

    String createShape(int sideSize);
    String drawVerticalLine();
    String drawLine(int index, int sideSize);
}
