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

        int length = requireInt(scanner, "Enter rectangle's length: ");
        int width = requireInt(scanner, "Enter rectangle's width: ");

        scanner.close();

//        StringBuffer имел бы смысл только если бы к переменным обращались
//        несколько потоков одновременно
        StringBuilder rectangle = createRectangle(length, width);
        System.out.println(rectangle);
    }

    private static int requireInt(Scanner scanner, String requiringMessage) {
        System.out.print(requiringMessage);

        return scanner.nextInt();
    }

    private static StringBuilder createRectangle(int length, int width) {
        StringBuilder horizontalLine = createHorizontalLine(length);
        StringBuilder verticalLines = createVerticalLines(length, width);

        return new StringBuilder()
                .append(horizontalLine)
                .append(verticalLines)
                .append(horizontalLine);
    }

    private static StringBuilder createHorizontalLine(int length) {
        StringBuilder horizontalLine = new StringBuilder(" ");

//        Также допустим вариант с использованием repeat() у String
        for (int i = 0; i < length; i++) {
            horizontalLine.append("-");
        }

        horizontalLine.append(" \n");

        return horizontalLine;
    }

    private static StringBuilder createVerticalLines(int length, int width) {
        StringBuilder verticalLinesUnit = getVerticalLinesUnit(length);

        StringBuilder verticalLines = new StringBuilder();

        for (int i = 0; i < width; i++) {
            verticalLines.append(verticalLinesUnit);
        }

        return verticalLines;
    }

    private static StringBuilder getVerticalLinesUnit(int length) {
        StringBuilder verticalLinesUnit = new StringBuilder("|");

        for (int i = 0; i < length; i++) {
            verticalLinesUnit.append(" ");
        }

        verticalLinesUnit.append("|\n");
        return verticalLinesUnit;
    }
}
