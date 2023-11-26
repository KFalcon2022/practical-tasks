package com.walking.lesson26_string_types.task1;

import java.util.Scanner;

/**
 * Написать программу, которая принимает длину и ширину прямоугольника (2 целых числа).
 * Нарисовать в консоли заданный прямоугольник, используя “-“ и “|”.
 * Углы прямоугольника обозначить символом “ “.
 * Каждая единица длины должна обозначаться одним символом “-“,
 * каждая единица ширины – символом “|“.
 * <p>
 * Произвести декомпозицию по своему усмотрению. Рекомендую скинуть на проверку. Контакт ниже.
 */
public class Task3 {
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
        StringBuilder figure=new StringBuilder(horizontalLine);
        figure.append(verticalLines);
        figure.append(horizontalLine);
        System.out.print(figure);

    }

    static StringBuilder createHorizontalLine(int length) {
        StringBuilder horizontalLine = new StringBuilder(" ");

        for (int i = 0; i < length; i++) {
            horizontalLine.append( "-");
        }

        horizontalLine.append( " \n");

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
        StringBuilder verticalLinesUnit = new StringBuilder( "|");

        for (int i = 0; i < length; i++) {
            verticalLinesUnit.append(" ");
        }

        verticalLinesUnit.append( "|\n");
        return verticalLinesUnit;
    }
}
