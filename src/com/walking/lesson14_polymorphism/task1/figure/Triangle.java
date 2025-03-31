package com.walking.lesson14_polymorphism.task1.figure;

public class Triangle extends RegularFigure {
    public static final String NAME = "треугольник";

    private final String RIGHT_SIDE = "\\";
    private final String LEFT_SIDE = "/";
    private final String BOTTOM_SIDE = "_";
    private final String SPACE = " ";

    public Triangle(int length) {
        super(length);
    }

    @Override
    public String getFigure() {
        return getTriangle() + getBottomSide();
    }

    private String getBottomSide() {
        return LEFT_SIDE + BOTTOM_SIDE.repeat(getLength()) + RIGHT_SIDE;
    }

    private String getTriangle() {
        int k = getLength() / 2;
        int j = getLength() % 2;

        String triangle = "";
        for (int i = 0; i < getLength() / 2; i++) {
            triangle += SPACE.repeat(k) + LEFT_SIDE + SPACE.repeat(j) + RIGHT_SIDE + "\n";
            k--;
            j += 2;
        }

        return triangle;
    }

}
