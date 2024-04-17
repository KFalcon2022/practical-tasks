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
        System.out.print("Введите длину прямоугольника целым числом: ");
        int rectWidth = scanner.nextInt();
        System.out.print("Введите высоту прямоугольника целым числом: ");
        int rectHeight = scanner.nextInt();
        scanner.close();

        drawHorizontLines(rectWidth);
        drawVerticalLines(rectWidth, rectHeight);
        drawHorizontLines(rectWidth);
    }

    public static void drawVerticalLines(int rectWidth, int rectHeight) {
        String heightChar = "|";

        for (int i = 0; i < rectHeight; i++ ) {
            System.out.print(heightChar);
            for (int j = 0; j < rectWidth; j++) {
                System.out.print(" ");
            }
            System.out.println(heightChar);
        }
    }

    public static void drawHorizontLines(int rectWidth) {
        String widthChar = "-";
        String cornerChar = " ";

        // j < rectWidth + 2 -- +2 т.к. 2 угла. в условии сказано: Углы прямоугольника обозначить символом “ “.
        for (int j = 0; j < rectWidth + 2; j++) {
            if (j == 0 || j == rectWidth + 1) {
                System.out.print(cornerChar);
            } else {
                System.out.print(widthChar);
            }
        }
        System.out.println("");
    }
}
