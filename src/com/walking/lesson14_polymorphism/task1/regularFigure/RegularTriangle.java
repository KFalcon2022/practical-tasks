package com.walking.lesson14.task1.regularFigure;

public class RegularTriangle extends RegularFigure {
    final String RIGHT_SIDE_TRIANGLE = "\\";
    final String LEFT_SIDE_TRIANGLE = "/";
    public static final String NAME_TRIANGLE = "triangle";

    public RegularTriangle(int size) {
        super(size);
    }

    public void printFigure() {
        String horizontalLine = createHorizontalLine();
        String verticalLines = createVerticalLines();

        System.out.println(verticalLines + horizontalLine);
    }

    @Override
    String createHorizontalLine() {
        String horizontalLine = EMPTY_STRING;

        for (int i = 0; i < size; i++) {
            horizontalLine += HORIZONTAL_ELEMENT;
        }

        horizontalLine += EMPTY_ELEMENT + NEW_LINE_SYMBOL;

        return horizontalLine;
    }

    String createVerticalLines() {
        String verticalLines = EMPTY_STRING;

        for (int i = 0; i < size; i++) {
            verticalLines += getVerticalLines(i);
        }
        return verticalLines;
    }

    String getVerticalLines(int numLines) {
        String verticalLinesUnit = EMPTY_STRING;

        for (int i = 0; i < size; i++) {
            if (i == size - numLines - 1) {
                verticalLinesUnit += LEFT_SIDE_TRIANGLE;
                continue;
            }
            verticalLinesUnit += EMPTY_ELEMENT;
        }

        for (int i = 0; i < size; i++) {
            if (i == numLines) {
                verticalLinesUnit += RIGHT_SIDE_TRIANGLE ;
                continue;
            }
            verticalLinesUnit += EMPTY_ELEMENT;
        }

        verticalLinesUnit += NEW_LINE_SYMBOL;
        return verticalLinesUnit;
    }
}
