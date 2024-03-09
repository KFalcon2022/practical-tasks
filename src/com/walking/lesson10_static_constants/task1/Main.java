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
    public static final String SPACE = " ";
    public static final String HORIZONTAL_SYMBOL = "-";
    public static final String VERTICAL_SYMBOL = "|";
    public static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        int length = inputRectangleLength(SCANNER);
        int width = inputRectangleHeight(SCANNER);
        SCANNER.close();

        String firstAndLastLine = drawFirstAndLastLines(length);
        String intermediateLine = drawMiddleLines(length);

        System.out.println(firstAndLastLine);
        for (int i = 1; i <= width - 2; i++) {
            System.out.println(intermediateLine);
        }
        System.out.println(firstAndLastLine);
    }

    public static String drawFirstAndLastLines(int length) {
        String line = "";
        line += SPACE;
        for (int i = 0; i < length - 2; i++) {
            line += HORIZONTAL_SYMBOL;
        }
        line += SPACE;
        return line;
    }

    public static String drawMiddleLines(int length) {
        String line = "";
        line += VERTICAL_SYMBOL;
        for (int i = 0; i < length - 2; i++) {
            line += SPACE;
        }
        line += VERTICAL_SYMBOL;
        return line;
    }

    public static int inputRectangleLength(Scanner scanner) {
        System.out.println("Введите длину прямоугольника: ");
        return scanner.nextInt();
    }

    public static int inputRectangleHeight(Scanner scanner) {
        System.out.println("Введите ширину прямоугольника: ");
        return scanner.nextInt();
    }
}
