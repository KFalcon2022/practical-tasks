package com.walking.lesson14_polymorphism.task1.regularFigure;

public class Square extends RegularFigure{
    final String VERTICAL_ELEMENT = "|";
    public static final String NAME_SQUARE = "square";

    public Square(int size) {
        super(size);
    }

    public void printFigure() {
        String horizontalLine = createHorizontalLine();
        String verticalLines = createVerticalLines();

        System.out.println(horizontalLine + verticalLines + horizontalLine);
    }

    String createVerticalLines() {
        String verticalLinesUnit = getVerticalLinesUnit();

        String verticalLines = EMPTY_STRING;

        for (int i = 0; i < size; i++) {
            verticalLines += verticalLinesUnit;
        }
        return verticalLines;
    }

    String getVerticalLinesUnit() {
        String verticalLinesUnit = VERTICAL_ELEMENT;

        for (int i = 0; i < size; i++) {
            verticalLinesUnit += (EMPTY_ELEMENT + EMPTY_ELEMENT);
        }

        verticalLinesUnit += VERTICAL_ELEMENT + NEW_LINE_SYMBOL;
        return verticalLinesUnit;
    }
}
