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

        StringBuilder rectangle = printRectangle(length, width);
        System.out.println("StringBuilder выбран по причине отсутствия многопоточности");
        System.out.println(rectangle);
    }

    private static int requireInt(Scanner scanner, String requiringMessage) {
        System.out.print(requiringMessage);

        return scanner.nextInt();
    }

    private static StringBuilder printRectangle(int length, int width) {
        return createHorizontalLine(length)
                .append(createVerticalLines(length, width))
                .append(createHorizontalLine(length));
    }

    private static StringBuilder createHorizontalLine(int length) {
        String horizontalLine = " ";

        for (int i = 0; i < length; i++) {
            horizontalLine += "-";
        }

        horizontalLine += " \n";

        return new StringBuilder(horizontalLine);
    }

    private static StringBuilder createVerticalLines(int length, int width) {
        String verticalLinesUnit = getVerticalLinesUnit(length);

        String verticalLines = "";

        for (int i = 0; i < width; i++) {
            verticalLines += verticalLinesUnit;
        }
        return new StringBuilder(verticalLines);
    }

    static String getVerticalLinesUnit(int length) {
        String verticalLinesUnit = "|";

        for (int i = 0; i < length; i++) {
            verticalLinesUnit += " ";
        }

        verticalLinesUnit += "|\n";
        return verticalLinesUnit;
    }
}
