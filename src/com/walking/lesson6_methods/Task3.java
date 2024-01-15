package com.walking.lesson6_methods;

import java.util.Scanner;

public class Task3 {
    /*
    Написать программу, которая принимает длину и ширину прямоугольника (2 целых числа). Нарисовать в консоли заданный
    прямоугольник, используя “-“ и “|”. Углы прямоугольника обозначить символом “ “. Каждая единица длины должна
    обозначаться одним символом “-“, каждая единица ширины – символом “|“.
    Произвести декомпозицию по своему усмотрению. Рекомендую скинуть на проверку. Контакт ниже.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите длину прямоугольника: ");
        int length = scanner.nextInt();
        System.out.println("Введите ширину прямоугольника: ");
        int width = scanner.nextInt();
        scanner.close();
        StringBuilder string = new StringBuilder();

        drawFirstAndLastLines(length, string);
        for (int i = 1; i <= width - 2; i++) {
            drawIntermediateLines(length, string);
        }
        drawFirstAndLastLines(length, string);
        System.out.println(string);
    }

    public static void drawFirstAndLastLines(int length, StringBuilder string) {
        string.append(" ");
        for (int i = 0; i < length - 1; i++) {
            string.append("-");
        }
        string.append(" \n");
    }

    public static void drawIntermediateLines(int length, StringBuilder string) {
        string.append("|");
        for (int i = 0; i < length - 1; i++) {
            string.append(" ");
        }
        string.append("|\n");
    }
}