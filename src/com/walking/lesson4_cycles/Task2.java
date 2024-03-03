package com.walking.lesson4_cycles;

import java.util.Scanner;

/**
 * Ввести с клавиатуры целое число.
 * Вывести в консоль сумму цифр введенного числа.
 */
public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число");
        int num = scanner.nextInt();
        scanner.close();

        int result = 0;
        while (num > 0) {
            result += num % 10;
            num /= 10;
        }
        System.out.println(result);
    }
}
