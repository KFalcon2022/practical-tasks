package com.walking.lesson2_operators_console_io;

import java.util.Scanner;

/**
 * Введите с клавиатуры целые числа a и b.
 * Выведите на экран результат сравнения:
 * a3 > b2,       где a3 - a в кубе, b2 - b  в квадрате
 */
public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите а:");
        int a = scanner.nextInt();
        System.out.println("Введите b:");
        int b = scanner.nextInt();
        scanner.close();
        int a3 = a * a * a;
        int b2 = b * b;
        System.out.println(a3 > b2);

    }
}
