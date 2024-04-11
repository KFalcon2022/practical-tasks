package com.walking.lesson20_exceptions.task2.model;

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
