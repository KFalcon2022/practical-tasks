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
        System.out.println("Введите ширину");
        int width = scanner.nextInt();
        System.out.println("Введите высоту");
        int height = scanner.nextInt();
        scanner.close();

        String topAndDownLine = "";
        String middleLine = "";

        for (int i = 0; i < width; i++) {
            if (i == 0 || i == width - 1) {
                topAndDownLine += " ";
                middleLine += "|";
            } else {
                topAndDownLine += "-";
                middleLine += " ";
            }
        }

        for (int i = 0; i < height; i++) {
            if (i == 0 || i == height - 1) {
                System.out.println(topAndDownLine);
            } else {
                System.out.println(middleLine);
            }
        }
    }
}
