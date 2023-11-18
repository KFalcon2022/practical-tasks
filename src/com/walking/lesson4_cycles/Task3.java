package com.walking.lesson4_cycles;

/**
 * Написать программу, которая принимает длину и ширину прямоугольника (2 целых числа).
 * Нарисовать в консоли заданный прямоугольник, используя “-“ и “|”.
 * Углы прямоугольника обозначить символом “ “.
 * Каждая единица длины должна обозначаться одним символом “-“,
 * каждая единица ширины – символом “|“.
 */

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите длину прямоугольника ");
        int a = scanner.nextInt();

        System.out.print("Введите ширину прямоугольника ");
        int b = scanner.nextInt();

        scanner.close();

        for (int i = 1; i <= b; i++) {
            for (int j = 1; j <= a; j++) {
                if ((i == 1) || (i == b)) {
                    if ((j == 1) || (j == a)) {
                        System.out.print(" ");
                    } else {
                        System.out.print("-");
                    }
                } else {
                    if ((j == 1) || (j == a)) {
                        System.out.print("|");
                    } else {
                        System.out.print(" ");
                    }
                }
            }
            System.out.println();
        }
    }
}
