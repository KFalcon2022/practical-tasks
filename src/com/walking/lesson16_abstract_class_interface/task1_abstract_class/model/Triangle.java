package com.walking.lesson16_abstract_class_interface.task1_abstract_class.model;

public class Triangle extends CorrectFigure {
    public static final String TRIANGLE_HORIZONTAL_SIDE_ELEMENT = "--";
    public static final String TRIANGLE_LEFT_SIDE_ELEMENT = "/";
    public static final String TRIANGLE_RIGHT_SIDE_ELEMENT = "\\";

    public Triangle(int lengthOfSide) {
        super(lengthOfSide);
    }

    @Override
    public void drawFigure(int lengthOfSide) {
        String triangle = "";

        for (int i = 0; i < lengthOfSide; i++) {
            for (int j = 0; j < lengthOfSide - i; j++) {
                triangle += " ";
            }

            triangle += TRIANGLE_LEFT_SIDE_ELEMENT;

            for (int j = 0; j < i * 2; j++) {
                triangle += " ";
            }

            triangle += TRIANGLE_RIGHT_SIDE_ELEMENT + "\n";
        }

        triangle += " ";

        for (int i = 0; i < lengthOfSide; i++) {
            triangle += TRIANGLE_HORIZONTAL_SIDE_ELEMENT;
        }

        System.out.println(triangle);
    }
}

