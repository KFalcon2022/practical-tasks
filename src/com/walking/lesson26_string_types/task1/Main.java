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
        System.out.println("Введите длину прямоугольника: ");
        int length = scanner.nextInt();
        System.out.println("Введите ширину прямоугольника: ");
        int width = scanner.nextInt();
        scanner.close();

        StringBuilder firstAndLastLine = drawFirstAndLastLines(length);
        StringBuilder middleLine = drawMiddleLines(length);

        System.out.print(firstAndLastLine);
        for (int i = 1; i <= width - 2; i++) {
            System.out.print(middleLine);
        }
        System.out.print(firstAndLastLine);
    }

    public static StringBuilder drawFirstAndLastLines(int length) {
        StringBuilder line = new StringBuilder();
        line.append(" ");
        line.append("-".repeat(length - 2));
        line.append(" \n");
        return line;
    }

    public static StringBuilder drawMiddleLines(int length) {
        StringBuilder line = new StringBuilder();
        line.append("|");
        line.append(" ".repeat(length - 2));
        line.append("|\n");
        return line;
    }
}
