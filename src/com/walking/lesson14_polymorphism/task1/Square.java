package com.walking.lesson14_polymorphism.task1;

public class Square extends RightFigure {
    public static final String NAME = "квадрат";

    private final String HORIZONTAL = "-";
    private final String VERTICAL = "|";
    private final String SPACE = " ";

    public Square(int length) {
        super(length);
    }

    @Override
    public void getTheFigure() {
        getHorizontalSide();
        getVerticalSide();
        getHorizontalSide();
    }

    private void getHorizontalSide() {
        System.out.println(SPACE + HORIZONTAL.repeat(length - 2) + SPACE);
    }

    private void getVerticalSide() {
        for(int i = 0; i < length - 2; i++) {
            System.out.println(VERTICAL + SPACE.repeat(length - 2) + VERTICAL);
        }
    }
}
