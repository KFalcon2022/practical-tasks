package com.walking.lesson26_string_types.task1;

import java.util.Scanner;

/**
В задаче использован StringBuilder, вместо StringBuffer, так как у нас 1 стек/поток, и нам не нужна потокобезопасность. Нам нужна скорость
 также экономим память, не делая кучу обьектов String, а работая с добавлением строковых элементов.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int length = requireInt(scanner, "Enter rectangle's length: ");
        int width = requireInt(scanner, "Enter rectangle's width: ");

        scanner.close();

        StringBuilder horizontalLine = createHorizontalLine(length);
        StringBuilder verticalLines = createVerticalLines(length, width);

        printRectangle(horizontalLine, verticalLines);
    }

    static int requireInt(Scanner scanner, String requiringMessage) {
        System.out.print(requiringMessage);

        return scanner.nextInt();
    }

    static void printRectangle(StringBuilder horizontalLine, StringBuilder verticalLines) {
        System.out.print(horizontalLine);
        System.out.print(verticalLines);
        System.out.print(horizontalLine);
    }

    static StringBuilder createHorizontalLine(int length) {
        //  String horizontalLine = " ";
        StringBuilder horizontalLine = new StringBuilder(" ");

        for (int i = 0; i < length; i++) {
            horizontalLine.append("-");
        }

        horizontalLine.append(" \n");

        return horizontalLine;
    }

    static StringBuilder createVerticalLines(int length, int width) {
        StringBuilder verticalLinesUnit = getVerticalLinesUnit(length);

        StringBuilder verticalLines = new StringBuilder();

        for (int i = 0; i < width; i++) {
            verticalLines.append(verticalLinesUnit);
        }

        return verticalLines;
    }

    static StringBuilder getVerticalLinesUnit(int length) {
        StringBuilder verticalLinesUnit = new StringBuilder("|");

        for (int i = 0; i < length; i++) {
            verticalLinesUnit.append(" ");
        }

        verticalLinesUnit.append("|\n");

        return verticalLinesUnit;
    }
}