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
    public static final String CONSTANT_WIDTH = "="; //вынос знака в константу
    public static final String CONSTANT_HEIGHT = "||";//вынос знака в константу
    public static final String CONSTANT_SPACE = " ";//вынос знака в константу
    public static final String CONSTANT_SIGN = "";//вынос знака в константу
    
    public static void main(String[] args) {
        
    Scanner scanner = new Scanner(System.in);

        int length = requireInt(scanner, "Enter rectangle's length: ");
        int width = requireInt(scanner, "Enter rectangle's width: ");

        scanner.close();

        String horizontalLine = createHorizontalLine(length);
        String verticalLines = createVerticalLines(length, width);

        printRectangle(horizontalLine, verticalLines);
    }

    static int requireInt(Scanner scanner, String requiringMessage) {
        System.out.print(requiringMessage);

        return scanner.nextInt();
    }

    static void printRectangle(String horizontalLine, String verticalLines) {
        System.out.print(horizontalLine + verticalLines + horizontalLine);
    }

    static String createHorizontalLine(int length) {
        String horizontalLine = CONSTANT_SPACE; //приравниваем переменную константе пробела

        for (int i = 0; i < length; i++) {
            horizontalLine += CONSTANT_WIDTH;//приравниваем переменную константе, отвечающую за отрисовку ширины
        }

        horizontalLine += CONSTANT_SPACE +"\n";//приравниваем переменную константе пробела и переводим на строку

        return horizontalLine;
    }

    static String createVerticalLines(int length, int width) {
        String verticalLinesUnit = getVerticalLinesUnit(length);

        String verticalLines = CONSTANT_SIGN;//приравниваем переменную константе, отвечающую за построение угла

        for (int i = 0; i < width; i++) {
            verticalLines += verticalLinesUnit;
        }
        return verticalLines;
    }

    static String getVerticalLinesUnit(int length) {
        String verticalLinesUnit = CONSTANT_HEIGHT;//приравниваем переменную константе, отвечающую за отрисовку высоты

        for (int i = 0; i < length; i++) {
            verticalLinesUnit += CONSTANT_SPACE;//приравниваем переменную константе пробела
        }

        verticalLinesUnit += CONSTANT_HEIGHT+ "\n";//приравниваем переменную константе, отвечающую за отрисовку угла
        return verticalLinesUnit;
    }
}
