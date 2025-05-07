package com.walking.lesson4_cycles;

import java.util.Scanner;

/**
 * Ввести с клавиатуры целое число.
 * Вывести в консоль его факториал.
 */
public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите неотрицательное целое число: ");
        int n = scanner.nextInt();
        scanner.close();

        int factorial = 1;
        if (n > 0) {
            for (int i = 1; i <= n; i++) {
                factorial *= i;
            }
        }

        if (n >= 0) {
            System.out.printf("Факториал числа %d равен %d", n, factorial);
        } else {
            System.out.println("Число не должно быть отрицательным");
        }
    }
}
