package com.walking.lesson6_methods;

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
        System.out.println("Введите длину прямоугольника: ");
        int lines = scanner.nextInt();
        System.out.println("Введите ширину прямоугольника: ");
        int columns = scanner.nextInt();
        scanner.close();

        for (int i = 1; i <= lines; i++) {
            for (int j = 1; j <= columns; j++) {

                if (isAngle(i, j, lines, columns)) {
                    System.out.print(" ");
                } else if (i == 1 || i == lines) {
                    System.out.print("-");
                } else if (j == 1 || j == columns) {
                    System.out.print("|");
                } else {
                    System.out.print(" ");
                }
                if (j == columns) {
                    System.out.println();
                }
            }
        }
    }

    public static boolean isAngle(int line, int column, int lines, int columns) {
        return line == 1 && column == 1 || line == lines && column == 1 || line == 1 && column == columns || line == lines && column == columns;
    }
}