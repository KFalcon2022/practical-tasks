package com.walking.lesson14_polymorphism.task1;

public class RegularRectangle extends RegularFigure {
    private static final String NODE_ELEMENT = "*";
    private static final String VERTICAL_LINE_ELEMENT = "|";
    private static final String SPACE_ELEMENT = "   ";
    private static final String HORIZONTAL_LINE_ELEMENT = "___";

    @Override
    public String draw(int sideLength) {
        if (sideLength < MINIMAL_DIMENSION) {
            System.out.println("Too small dimension");
            return null;
        }

        // верх
        String result = new String(makeHorizontalLine(sideLength));

        //середина
        for (int i = 1; i < sideLength - 1; i++) {
            result += VERTICAL_LINE_ELEMENT;

            for (int j = 1; j < sideLength - 1; j++) {
                result += SPACE_ELEMENT;
            }
            result += VERTICAL_LINE_ELEMENT;
            result += '\n';
        }

        // низ
        result += makeHorizontalLine(sideLength);

        return result;
    }

    private String makeHorizontalLine(int length) {
        if (length < MINIMAL_DIMENSION) {
            System.out.println("Too small dimension");
            return null;
        }
        String result = new String(NODE_ELEMENT);

        for (int i = 1; i < length - 1; i++) {
            result += HORIZONTAL_LINE_ELEMENT;
        }
        result += NODE_ELEMENT + '\n';
        return result;
    }
}
