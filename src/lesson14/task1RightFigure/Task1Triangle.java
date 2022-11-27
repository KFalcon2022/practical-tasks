package com.walking.lesson14_polymorphism.task1.model;

public class Triangle extends RightFigure{
    //удваеваем символ для горизонтальной линии, чтобы выглядело нормально
    final String horizontalSymbol = "--";
    //альтернативный вариант
    final String horizontalAltSymbol = "__";
    final String leftVerticalSymbol = "/";
    final String rightVerticalSymbol = "\\";
    final String insideSpaceSymbol = " ";
    final String cornersSymbol = "*";

    public Triangle(int length) {
        super(length, 3);
    }

    @Override
    public void draw() {
        //drawTopUp();
        drawTopDown();
    }

    public void drawTopDown() {
        String figurePrint = "";
        String topHorizontalLine = getTopHorizontalLine();

        figurePrint += topHorizontalLine + "\n";
        for (int i = length-1; i >= 0; i--) {
            figurePrint += getMiddleHorizontalAltLine(i) + "\n";
        }

        System.out.println(figurePrint);
    }

    public void drawTopUp() {
        String figurePrint = "";
        String bottomHorizontalLine = getBottomHorizontalLine();

        for (int i = 0; i < length; i++) {
            figurePrint += getMiddleHorizontalLine(i) + "\n";
        }
        figurePrint += bottomHorizontalLine;

        System.out.println(figurePrint);
    }

    private String getBottomHorizontalLine() {
        String horizontalLine = "";
        horizontalLine += cornersSymbol;
        horizontalLine += horizontalSymbol.repeat(length);
        horizontalLine += cornersSymbol;
        return horizontalLine;
    }

    private String getMiddleHorizontalLine(int offsetFromMiddle) {
        String horizontalLine = "";
        int emptySpaces = length - offsetFromMiddle;

        //left side
        horizontalLine += insideSpaceSymbol.repeat(emptySpaces);
        horizontalLine += leftVerticalSymbol;
        horizontalLine += insideSpaceSymbol.repeat(offsetFromMiddle);

        //right side
        horizontalLine += insideSpaceSymbol.repeat(offsetFromMiddle);
        horizontalLine += rightVerticalSymbol;
        horizontalLine += insideSpaceSymbol.repeat(emptySpaces);

        return horizontalLine;
    }

    private String getTopHorizontalLine() {
        String horizontalLine = "";
        horizontalLine += cornersSymbol;
        //horizontalAltSymbol
        horizontalLine += horizontalSymbol.repeat(length);
        horizontalLine += cornersSymbol;
        return horizontalLine;
    }

    private String getMiddleHorizontalAltLine(int offsetFromMiddle) {
        String horizontalLine = "";
        int emptySpaces = length - offsetFromMiddle;

        //left side
        horizontalLine += insideSpaceSymbol.repeat(emptySpaces);
        horizontalLine += rightVerticalSymbol;
        horizontalLine += insideSpaceSymbol.repeat(offsetFromMiddle);

        //right side
        horizontalLine += insideSpaceSymbol.repeat(offsetFromMiddle);
        horizontalLine += leftVerticalSymbol;
        horizontalLine += insideSpaceSymbol.repeat(emptySpaces);

        return horizontalLine;
    }
}
