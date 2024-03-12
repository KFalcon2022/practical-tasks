package com.walking.lesson16_abstract_class_interface.task1_abstract_class.model;

public class Square extends CorrectFigure{
    public static final String RECTANGLE_HORIZONTAL_ELEMENT = "-";
    public static final String RECTANGLE_VERTICAL_ELEMENT = "|";

    public Square(int lengthOfSide) {
        super(lengthOfSide);
    }

    @Override
    public void drawFigure(int lengthOfSide) {
        String horizontalLine = createHorizontalLine(lengthOfSide);
        String verticalLines = createVerticalLines(lengthOfSide);

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
