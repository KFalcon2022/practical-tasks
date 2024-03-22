package com.walking.lesson4_cycles;

import java.util.Scanner;

/**
 * Ввести с клавиатуры целое число.
 * Вывести в консоль его факториал.
 */
public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число");
        int num = scanner.nextInt();
        scanner.close();

        int result = 1;
        for (int i = 1; i <= num; i++) {
            result *= i;
        }
        System.out.println(result);
    }
}
