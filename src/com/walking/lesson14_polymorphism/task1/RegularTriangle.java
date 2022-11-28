package com.walking.lesson14_polymorphism.task1;

public class RegularTriangle extends RegularFigure {

    // строки а не символы, чтобы рисовать чем угодно
    private static final String NODE_ELEMENT = "*";
    private static final String LEFT_LINE_ELEMENT = "/";
    private static final String RIGHT_LINE_ELEMENT = "\\";
    private static final String BASE_LINE_ELEMENT = "__";
    private static final String SPACE_ELEMENT = " ";

    @Override
    public String draw(int sideLength) {
        if (sideLength < MINIMAL_DIMENSION) {
            System.out.println("Too small dimension");
            return null;
        }
        String result = new String();

        //верхняя точка
        for (int i = 0; i < sideLength - 1; i++) {
            result += SPACE_ELEMENT;
        }

        result += NODE_ELEMENT + '\n';

        //средняя часть
        for (int i = 0; i < sideLength - 2; i++) {
            for (int j = 1; j < sideLength - i - 1; j++) {
                result += SPACE_ELEMENT;
            }

            result += LEFT_LINE_ELEMENT;

            for (int j = sideLength - i - 1; j < sideLength + i; j++) {
                result += SPACE_ELEMENT;
            }

            result += RIGHT_LINE_ELEMENT + '\n';
        }

        // основание
        result += NODE_ELEMENT + "_"; // лишнее подчеркивание для ровного попадания линий

        for (int i = 0; i < sideLength - 2; i++) {
            result += BASE_LINE_ELEMENT;
        }

        result += NODE_ELEMENT + '\n';

        return result;
    }
}
