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

        StringBuffer rectangle = new StringBuffer(printRectangle(length, width));
        System.out.println("StringBuffer выбран по причине отсутствия многопоточности");
        System.out.println(rectangle);
    }

    static int requireInt(Scanner scanner, String requiringMessage) {
        System.out.print(requiringMessage);

        return scanner.nextInt();
    }

    static StringBuffer printRectangle(int length, int width) {
        StringBuffer rectangle = createHorizontalLine(length);

        rectangle.append(createVerticalLines(length, width));
        rectangle.append(createHorizontalLine(length));

        return rectangle;
    }

    static StringBuffer createHorizontalLine(int length) {
        String horizontalLine = " ";

        for (int i = 0; i < length; i++) {
            horizontalLine += "-";
        }

        horizontalLine += " \n";

        return new StringBuffer(horizontalLine);
    }

    static StringBuffer createVerticalLines(int length, int width) {
        String verticalLinesUnit = getVerticalLinesUnit(length);

        String verticalLines = "";

        for (int i = 0; i < width; i++) {
            verticalLines += verticalLinesUnit;
        }
        return new StringBuffer(verticalLines);
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
