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
        System.out.println("Введите целое число - длину прямоугольника: ");
        int len = scanner.nextInt();
        System.out.println("Введите целое число - ширину прямоугольника: ");
        int wid = scanner.nextInt();
        scanner.close();

        String firstLastString = " " + "-".repeat(len) + " ";
        String middleString = "|" + " ".repeat(wid) + "|";

        System.out.println(firstLastString);
        for (int i = 0; i < wid; i++) {
            System.out.println(middleString);
        }
        System.out.println(firstLastString);
    }
}
