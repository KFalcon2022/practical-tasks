package com.walking.lesson10_static_constants.task1;

import java.util.Scanner;

public class Main {

    public static final String RECTANGLE_LENGTH_REQUIRE_MESSAGE = "Enter rectangle's length: ";
    public static final String RECTANGLE_WIDTH_REQUIRE_MESSAGE = "Enter rectangle's width: ";

    public static final String С_EMPTY = "  ";
    public static final String C_HORIZONTAL = "==";
    public static final String C_VERTICAL = "||";
    public static final String EMPTY_STRING = "";
    public static final char NEW_LINE_SYMBOL = '\n';

    public static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        int length = requireInt(RECTANGLE_LENGTH_REQUIRE_MESSAGE);
        int width = requireInt(RECTANGLE_WIDTH_REQUIRE_MESSAGE);
        SCANNER.close(); // Насколько хорошо вот так закрывать сканер? 
                         // Если в main где-то еще понадобится входной поток, его получится переоткрыть?
                         // А если это был не main?

        String horizontalLine = createLine(length, С_EMPTY, C_HORIZONTAL);
        String verticalLine = createLine(length, C_VERTICAL, С_EMPTY);

        printRectangle(horizontalLine, verticalLine, width);
    }

    static int requireInt(String requiringMessage) {
        System.out.print(requiringMessage);

        return SCANNER.nextInt();
    }

    static void printRectangle(String horizontalLine, String verticalLine, int width) {
        System.out.print(horizontalLine);
        for (int i=0; i<width; i++) {
            System.out.print(verticalLine);
        }
        System.out.print(horizontalLine);
    }

    static String createLine(int length, String borderUnit, String middleUnit) {
        String line = borderUnit;

        for (int i = 0; i < length; i++) {
            line += middleUnit;
        }

        line += borderUnit + NEW_LINE_SYMBOL;

        return line;
    }

}
