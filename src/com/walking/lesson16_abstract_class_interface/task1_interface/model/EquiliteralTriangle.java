package com.walking.lesson16_abstract_class_interface.task1_interface.model;

public class EquiliteralTriangle implements EquiliteralShape {
    public static final String TRIANGLE_HORIZONTAL_SIDE_ELEMENT = "--";
    public static final String TRIANGLE_LEFT_SIDE_ELEMENT = "/";
    public static final String TRIANGLE_RIGHT_SIDE_ELEMENT = "\\";

    private final int length;

    public EquiliteralTriangle(int length) {
        this.length = length;
    }

    @Override
    public String createShapeString() {
        String triangle = EMPTY_STRING;

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - i; j++) {
                triangle += EMPTY_ELEMENT;
            }
            triangle += TRIANGLE_LEFT_SIDE_ELEMENT;

            for (int j = 0; j < i * 2; j++) {
                triangle += EMPTY_ELEMENT;
            }
            triangle += TRIANGLE_RIGHT_SIDE_ELEMENT + NEW_LINE_SYMBOL;
        }
        triangle += EMPTY_ELEMENT;

        for (int i = 0; i < length; i++) {
            triangle += TRIANGLE_HORIZONTAL_SIDE_ELEMENT;
        }

        return triangle;
    }
}