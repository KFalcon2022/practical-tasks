package com.walking.lesson16_abstract_class_interface.task2.model;

public class Square implements CorrectShape {
    public static final String RECTANGLE_HORIZONTAL_ELEMENT = "-";
    public static final String RECTANGLE_VERTICAL_ELEMENT = "|";

    @Override
    public void draw(int sideLength) {
        String horizontalLine = createHorizontalLine(sideLength);
        String verticalLines = createVerticalLines(sideLength);

        System.out.println(horizontalLine + verticalLines + horizontalLine);
    }

    private String createHorizontalLine(int length) {
        String horizontalLine = " ";

        for (int i = 0; i < length; i++) {
            horizontalLine += RECTANGLE_HORIZONTAL_ELEMENT;
        }

        horizontalLine += " " + "\n";

        return horizontalLine;
    }

    private String createVerticalLines(int length) {
        String verticalLinesUnit = getVerticalLinesUnit(length);

        String verticalLines = "";

        for (int i = 0; i < length; i++) {
            verticalLines += verticalLinesUnit;
        }

        return verticalLines;
    }

    private String getVerticalLinesUnit(int length) {
        String verticalLinesUnit = RECTANGLE_VERTICAL_ELEMENT;

        for (int i = 0; i < length; i++) {
            verticalLinesUnit += " ";
        }

        verticalLinesUnit += RECTANGLE_VERTICAL_ELEMENT + "\n";

        return verticalLinesUnit;
    }
}
