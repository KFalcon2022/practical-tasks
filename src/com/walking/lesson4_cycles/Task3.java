package com.walking.lesson4_cycles;

import java.util.Scanner;

/**
 * Написать программу, которая принимает длину и ширину прямоугольника (2 целых числа).
 * Нарисовать в консоли заданный прямоугольник, используя “-“ и “|”.
 * Углы прямоугольника обозначить символом “ “.
 * Каждая единица длины должна обозначаться одним символом “-“,
 * каждая единица ширины – символом “|“.
 */
public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите длину прямоугольника: ");
        int length = scanner.nextInt();
        System.out.print("Введите ширину прямоугольника: ");
        int width = scanner.nextInt();
        String horizontal = " ";
        for (int i = 0; i < length; i++) {
            horizontal += "-";
        }
        String vertical = "\n";
        for (int i = 0; i < width; i++) {
            vertical += "|";
            for (int j = 0; j < length; j++) {
                vertical += " ";
            }
            vertical += "|\n";
        }
        scanner.close();
        System.out.println(horizontal + vertical + horizontal);
    }
}
