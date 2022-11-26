package com.walking.lesson14_polymorphism.task1;
public class RegularRectangle extends RegularFigure{
    private static final String NODE_ELEMENT = "*";
    private static final String VERTICAL_LINE_ELEMENT = "|";
    private static final String SPACE_ELEMENT = "   ";
    private static final String HORIZONTAL_LINE_ELEMENT = "___";

    @Override
    public void draw(int sideLength){
        if (sideLength < MINIMAL_DIMENSION){
            System.out.println("Too small dimension");
            return;
        }

        // верх
        drawHorizontalLine(sideLength);

        //середина
        for (int i = 1; i < sideLength - 1; i++){
            System.out.print(VERTICAL_LINE_ELEMENT);

            for (int j = 1; j < sideLength - 1; j++){
                System.out.print(SPACE_ELEMENT);
            }

            System.out.println(VERTICAL_LINE_ELEMENT);
        }

        // низ
        drawHorizontalLine(sideLength);
    }
    private void drawHorizontalLine(int length){
        if (length < MINIMAL_DIMENSION){
            System.out.println("Too small dimension");
            return;
        }

        System.out.print(NODE_ELEMENT);

        for (int i = 1; i < length - 1; i++){
            System.out.print(HORIZONTAL_LINE_ELEMENT);
        }

        System.out.println(NODE_ELEMENT);
    }
}
