package com.walking.lesson14_polymorphism.task1.model;

public class Square extends CorrectFigure {

    public static final String VERTICAL_UNIT = "|";


    public Square(int length) {
        super(length);

    }

    @Override
    public void printCorrectFigure() {
        super.printCorrectFigure();
    }

    @Override
    protected String printCorrectFigure(int height, int width) {
        return super.printCorrectFigure(height, width);
    }

    @Override
    protected String createHorizontalLine(int width) {
        return super.createHorizontalLine(width);
    }

    @Override
    protected String createVerticalLines(int height, int width) {
        return super.createVerticalLines(height, width);
    }

    @Override
    protected String createVerticalLineUnit(int width) {
        String verticalLineUnit = VERTICAL_UNIT;

        for (int i = 0; i < width * 3; i++) {
            verticalLineUnit += SPACE_UNIT;
        }
        return verticalLineUnit + VERTICAL_UNIT + NEW_LINE_UNIT;
    }
}
