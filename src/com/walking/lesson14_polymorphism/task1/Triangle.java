package com.walking.lesson14_polymorphism.task1;

public class Triangle extends RightFigure {
    public static final String NAME = "треугольник";

    private final String RIGHT_SIDE = "\\";
    private final String LEFT_SIDE = "/";
    private final String BOTTOM_SIDE = "_";
    private final String SPACE = " ";

    public Triangle(int length) {
        super(length);
    }

    @Override
    public void getTheFigure() {
        getTriangle();
        getBottomSide();
    }

    private void getBottomSide() {
        System.out.println(LEFT_SIDE + BOTTOM_SIDE.repeat(length) + RIGHT_SIDE);
    }

    private void getTriangle() {
        int k = length / 2;
        int j;
        if (length % 2 == 0) {
            j = 0;
        } else {
            j = 1;
        }

        for (int i = 0; i < length / 2; i++) {
            System.out.println(SPACE.repeat(k) + LEFT_SIDE + SPACE.repeat(j) + RIGHT_SIDE);
            k--;
            j += 2;
        }
    }

}
