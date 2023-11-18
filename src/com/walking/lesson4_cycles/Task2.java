package com.walking.lesson4_cycles;

/**
 * Ввести с клавиатуры целое число.
 * Вывести в консоль сумму цифр введенного числа.
 */

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите число: ");
        int a = scanner.nextInt();

        scanner.close();

        int digitsQuantity = 0;
        int b = a;
        do {
            digitsQuantity++;
            b /= 10;
        } while (b > 0);

        int digitsSumm = 0;
        for (int i = 1; i <= digitsQuantity; i++) {
            digitsSumm += a % 10;
            a /= 10;
        }

        System.out.println("Сумма цифр в числе: " + digitsSumm);
    }
}
