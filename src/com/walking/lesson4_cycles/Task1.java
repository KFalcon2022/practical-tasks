package com.walking.lesson4_cycles;

/**
 * Ввести с клавиатуры целое число.
 * Вывести в консоль его факториал.
 */

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите число: ");
        int a = scanner.nextInt();

        scanner.close();

        int factorial = 1;
        for (int i = 1; i <= a; i++) {
            factorial *= i;
        }
        System.out.printf("Факториал числа %d: %d", a, factorial);
    }
}
