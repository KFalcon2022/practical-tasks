package com.walking.lesson10_static_constants.task1;

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
public class Main {
    public static final String RECTANGLE_LENGTH_UNIT = "||";
    public static final String RECTANGLE_WIDTH_UNIT = "==";
    public static final String RECTANGLE_SPACE_UNIT = "  ";
    public static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        int length = requireInt("Enter rectangle's length: ");
        int width = requireInt("Enter rectangle's width: ");

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
        String horizontalLine = RECTANGLE_SPACE_UNIT;

        for (int i = 0; i < length; i++) {
            horizontalLine += RECTANGLE_WIDTH_UNIT;
        }

        horizontalLine += RECTANGLE_SPACE_UNIT + " \n";

        return horizontalLine;
    }

    static String createVerticalLines(int length, int width) {
        String verticalLinesUnit = getVerticalLinesUnit(length);

        String verticalLines = "";

        for (int i = 0; i < width; i++) {
            verticalLines += verticalLinesUnit;
        }
        return verticalLines;
    }

    static String getVerticalLinesUnit(int length) {
        String verticalLinesUnit = RECTANGLE_LENGTH_UNIT;

        for (int i = 0; i < length; i++) {
            verticalLinesUnit += RECTANGLE_SPACE_UNIT;
        }

        verticalLinesUnit += RECTANGLE_LENGTH_UNIT + "\n";
        return verticalLinesUnit;
    }
}