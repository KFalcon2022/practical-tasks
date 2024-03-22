package com.walking.lesson16_abstract_class_interface.task1_abstract_class.model;

public abstract class CorrectFigure {
    private int lengthOfSide;

    protected CorrectFigure(int lengthOfSide) {
        this.lengthOfSide = lengthOfSide;
    }

    protected int getLengthOfSide() {
        return lengthOfSide;
    }

    public abstract void drawFigure(int lengthOfSide);
}
