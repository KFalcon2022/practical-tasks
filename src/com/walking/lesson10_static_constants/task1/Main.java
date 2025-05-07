package com.walking.lesson10_static_constants.task1;

import java.util.Scanner;

/**
 * Используя кодовую базу из задачи
 * <a href="https://github.com/KFalcon2022/practical-tasks/blob/master/src/lesson6_methods/Task3.java">...</a>
 * вынести строковые и символьные литералы в константы.
 * Попробуйте нарисовать прямоугольник, используя "==" для каждой единицы длины и
 * "||" – для каждой единицы ширины.
 * <p>
 * Также попробуйте записать в константу переменную scanner.
 * Упростится ли использование сканера внутри методов чтения с клавиатуры?
 */
public class Main {

    public static final String LENGTH_REQUIRING_MESSAGE = "Enter rectangle's length: ";
    public static final String WIDTH_REQUIRING_MESSAGE = "Enter rectangle's width: ";

    public static final Scanner SCANNER = new Scanner(System.in);

    public static final String HORIZONTAL_SYMBOL = "==";
    public static final String VERTICAL_SYMBOL = "||";
    public static final String SPACE_SYMBOL = " ";
    public static final String BREAK_LINE_SYMBOL = "\n";
    public static final String EMPTY_SYMBOL = "";

    public static void main(String[] args) {
        int length = requireInt(LENGTH_REQUIRING_MESSAGE);
        int width = requireInt(WIDTH_REQUIRING_MESSAGE);

        SCANNER.close();

        String horizontalLine = createHorizontalLine(length);
        String verticalLines = createVerticalLines(length, width);

        printRectangle(horizontalLine, verticalLines);
    }

    static int requireInt(String requiringMessage) {
        System.out.print(requiringMessage);

        return SCANNER.nextInt();
    }

    static void printRectangle(String horizontalLine, String verticalLines) {
        System.out.print(horizontalLine + verticalLines + horizontalLine);
    }

    static String createHorizontalLine(int length) {
        String horizontalLine = SPACE_SYMBOL;

        for (int i = 0; i < length; i++) {
            horizontalLine += HORIZONTAL_SYMBOL;
        }

        horizontalLine += SPACE_SYMBOL + BREAK_LINE_SYMBOL;

        return horizontalLine;
    }

    static String createVerticalLines(int length, int width) {
        String verticalLinesUnit = getVerticalLinesUnit(length);

        String verticalLines = EMPTY_SYMBOL;

        for (int i = 0; i < width; i++) {
            verticalLines += verticalLinesUnit;
        }
        return verticalLines;
    }

    static String getVerticalLinesUnit(int length) {
        String verticalLinesUnit = VERTICAL_SYMBOL;

        for (int i = 0; i < length * 2 - 1; i++) {
            verticalLinesUnit += SPACE_SYMBOL;
        }

        verticalLinesUnit += VERTICAL_SYMBOL + BREAK_LINE_SYMBOL;
        return verticalLinesUnit;
    }
}
