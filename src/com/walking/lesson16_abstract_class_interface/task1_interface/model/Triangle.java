package com.walking.lesson16_abstract_class_interface.task1_interface.model;

public class Triangle implements Painting {
    public static final String TRIANGLE_HORIZONTAL_SIDE_ELEMENT = "--";
    public static final String TRIANGLE_LEFT_SIDE_ELEMENT = "/";
    public static final String TRIANGLE_RIGHT_SIDE_ELEMENT = "\\";

    @Override
    public void draw(int sideLength) {
        String triangle = "";

        for (int i = 0; i < sideLength; i++) {
            for (int j = 0; j < sideLength - i; j++) {
                triangle += " ";
            }

            triangle += TRIANGLE_LEFT_SIDE_ELEMENT;

            for (int j = 0; j < i * 2; j++) {
                triangle += " ";
            }

            triangle += TRIANGLE_RIGHT_SIDE_ELEMENT + "\n";
        }

        triangle += " ";

        for (int i = 0; i < sideLength; i++) {
            triangle += TRIANGLE_HORIZONTAL_SIDE_ELEMENT;
        }

        System.out.println(triangle);
    }
}
