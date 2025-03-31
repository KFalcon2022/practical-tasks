package com.walking.lesson14_polymorphism.task1.figure;

public class Square extends RegularFigure {
    public static final String NAME = "квадрат";

    private final String HORIZONTAL = "-";
    private final String VERTICAL = "|";
    private final String SPACE = " ";

    public Square(int length) {
        super(length);
    }

    @Override
    public String getFigure() {
        String square = getHorizontalSide();
        for (int i = 0; i < getLength() - 2; i++) {
            square += getVerticalSide();
        }
        return square + getHorizontalSide();
    }

    private String getHorizontalSide() {
        return SPACE + HORIZONTAL.repeat(getLength() - 2) + SPACE + "\n";
    }

    private String getVerticalSide() {
        return VERTICAL + SPACE.repeat(getLength() - 2) + VERTICAL + "\n";
    }
}
