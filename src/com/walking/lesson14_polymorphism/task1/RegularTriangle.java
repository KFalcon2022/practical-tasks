package com.walking.lesson14_polymorphism.task1;
public class RegularTriangle extends RegularFigure{

    // строки а не символы, чтобы рисовать чем угодно
    private static final String NODE_ELEMENT = "*";
    private static final String LEFT_LINE_ELEMENT = "/";
    private static final String RIGHT_LINE_ELEMENT = "\\";
    private static final String BASE_LINE_ELEMENT = "__";
    private static final String SPACE_ELEMENT = " ";
    
    @Override
    public void draw(int sideLength) {
        if(sideLength < MINIMAL_DIMENSION) {
            System.out.println("Too small dimension");
            return;
        }

        //верхняя точка
        for(int i = 0; i < sideLength - 1; i++){
            System.out.print(SPACE_ELEMENT);
        }

        System.out.println(NODE_ELEMENT);

        //средняя часть
        for(int i = 0; i < sideLength - 2; i++){
            for(int j = 1; j < sideLength - i - 1; j++){
                System.out.print(SPACE_ELEMENT);
            }

            System.out.print(LEFT_LINE_ELEMENT);

            for(int j = sideLength - i - 1; j < sideLength + i; j++){
                System.out.print(SPACE_ELEMENT);
            }

            System.out.println(RIGHT_LINE_ELEMENT);
        }

        // основание
        System.out.print(NODE_ELEMENT + "_"); // лишнее подчеркивание для ровного попадания линий
        for(int i = 0; i < sideLength - 2; i++){
            System.out.print(BASE_LINE_ELEMENT);
        }

        System.out.print(NODE_ELEMENT);
    }

}
