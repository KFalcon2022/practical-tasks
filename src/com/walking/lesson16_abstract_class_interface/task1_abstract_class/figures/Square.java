package com.walking.lesson16_abstract_class_interface.task1_abstract_class.figures;

public class Square extends RegularFigure {
    public static final String NAME = "квадрат";

    private final String HORIZONTAL = "-";
    private final String VERTICAL = "|";

    public Square(int length) {
        super(length);
    }

    @Override
    public String getFigure() {
        String square = getHorizontalSide();
        for (int i = 0; i < length - 2; i++) {
            square += getVerticalSide();
        }
        return square + getHorizontalSide();
    }

    private String getHorizontalSide() {
        return SPACE + HORIZONTAL.repeat(length - 2) + SPACE + NEXT_LINE_SYMBOL;
    }

    private String getVerticalSide() {
        return VERTICAL + SPACE.repeat(length - 2) + VERTICAL + NEXT_LINE_SYMBOL;
    }
}
