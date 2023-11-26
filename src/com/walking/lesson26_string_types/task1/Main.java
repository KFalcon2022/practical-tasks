package Lesson26.Task1;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
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
        System.out.print(horizontalLine.append(verticalLines.append(horizontalLine)));
    }

    static StringBuilder createHorizontalLine(int length) {
        StringBuilder horizontalLine = new StringBuilder(" ");

        for (int i = 0; i < length; i++) {
            horizontalLine.append("-");
        }

        horizontalLine.append(" \n");

        return horizontalLine;
    }

    static StringBuilder createVerticalLines(int length, int width) {
        StringBuilder verticalLinesUnit = getVerticalLinesUnit(length);

        StringBuilder verticalLines = new StringBuilder("");

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