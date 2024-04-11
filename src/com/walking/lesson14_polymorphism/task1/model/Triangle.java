package com.walking.lesson14_polymorphism.task1.model;

public class Triangle extends CorrectFigure {
    public static final String TRIANGLE_HORIZONTAL_SIDE_ELEMENT = "--";
    public static final String TRIANGLE_LEFT_SIDE_ELEMENT = "/";
    public static final String TRIANGLE_RIGHT_SIDE_ELEMENT = "\\";

    @Override
    public void drawFigure(int length) {
        String triangle = "";

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - i; j++) {
                triangle += " ";
            }

            triangle += TRIANGLE_LEFT_SIDE_ELEMENT;

            for (int j = 0; j < i * 2; j++) {
                triangle += " ";
            }

            triangle += TRIANGLE_RIGHT_SIDE_ELEMENT + "\n";
        }

        triangle += " ";

        for (int i = 0; i < length; i++) {
            triangle += TRIANGLE_HORIZONTAL_SIDE_ELEMENT;
        }

        System.out.println(triangle);
    }
}

