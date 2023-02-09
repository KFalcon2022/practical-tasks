package com.walking.lesson4_cycles;

import java.util.Scanner;

/**
 * Ввести с клавиатуры целое число.
 * Вывести в консоль сумму цифр введенного числа.
 */
public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите целое число: ");
        int n = Math.abs(scanner.nextInt());
        scanner.close();

        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n = n / 10;
        }
        System.out.printf("Сумма цифр числа %d равна %d", n, sum);
    }
}
