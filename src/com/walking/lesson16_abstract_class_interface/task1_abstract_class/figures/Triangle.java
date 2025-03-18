package com.walking.lesson16_abstract_class_interface.task1_abstract_class.figures;

public class Triangle extends RegularFigure {
    public static final String NAME = "треугольник";

    private final String RIGHT_SIDE = "\\";
    private final String LEFT_SIDE = "/";
    private final String BOTTOM_SIDE = "_";


    public Triangle(int length) {
        super(length);
    }

    @Override
    public String getFigure() {
        return getTriangle() + getBottomSide();
    }

    private String getBottomSide() {
        return LEFT_SIDE + BOTTOM_SIDE.repeat(length) + RIGHT_SIDE;
    }

    private String getTriangle() {
        int k = length / 2;
        int j = length % 2;

        String triangle = "";
        for (int i = 0; i < length / 2; i++) {
            triangle += SPACE.repeat(k) + LEFT_SIDE + SPACE.repeat(j) + RIGHT_SIDE + NEXT_LINE_SYMBOL;
            k--;
            j += 2;
        }

        return triangle;
    }
}
