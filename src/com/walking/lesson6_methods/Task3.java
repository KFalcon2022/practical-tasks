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
        System.out.println("Введите целое число - длину прямоугольника: ");
        int len = scanner.nextInt();
        System.out.println("Введите целое число - ширину прямоугольника: ");
        int wid = scanner.nextInt();
        scanner.close();

        drawRectangle(len, wid);
    }

    public static void drawRectangle(int len, int wid) {
        String g = "-";
        String v = "|";
        String s = " ";
        String firstLastString = String.format("%s%s%s", s, g.repeat(len), s);
        String middleString = String.format("%s%s%s", v, s.repeat(wid), v);

        System.out.println(firstLastString);
        for (int i = 0; i < wid; i++) {
            System.out.println(middleString);
        }
        System.out.println(firstLastString);
    }
}
