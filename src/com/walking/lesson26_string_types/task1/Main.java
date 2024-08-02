package com.walking.lesson26_string_types.task1;

import java.util.Scanner;

/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/blob/master/src/com/walking/lesson6_methods/Task3.java">...</a>
 * используя StringBuilder или StringBuffer. Объясните свой выбор.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the length of the rectangle: ");
        int length = scanner.nextInt();

        if(length <= 0) {
            throw new RuntimeException("The length of the rectangle should be greater than 0");
        }

        System.out.println("Enter the width of the rectangle: ");
        int width = scanner.nextInt();

        if(width <= 0) {
            throw new RuntimeException("The width of the rectangle should be greater than 0");
        }

        printRectangle(length, width);
    }

    static void printRectangle(int length, int width) {
            StringBuilder lengthElement = new StringBuilder(getLengthLine(length));
            StringBuilder widthElement = new StringBuilder(getWidthLine(width, length));

            System.out.println(lengthElement.append(widthElement.append(lengthElement)));
    }

    static StringBuilder getLengthLine(int length) {
        return new StringBuilder(Symbol.SPACE_SYMBOL.getSymbol())
                .append(Symbol.LENGTH_SYMBOL.getSymbol().repeat(length))
                .append(Symbol.SPACE_SYMBOL.getSymbol())
                .append(Symbol.NEX_LINE.getSymbol());
    }

    static StringBuilder getWidthLine(int width, int length) {

        return new StringBuilder()
                .append(getWidthUnit(length).toString().repeat(width));
    }

    static StringBuilder getWidthUnit(int length) {

        return new StringBuilder(Symbol.WIDTH_SYMBOL.getSymbol())
                .append(Symbol.SPACE_SYMBOL.getSymbol().repeat(length))
                .append(Symbol.WIDTH_SYMBOL.getSymbol())
                .append(Symbol.NEX_LINE.getSymbol());
    }
}
