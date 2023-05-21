package com.walking.lesson4_cycles;

import java.util.Scanner;

/**
 * Ввести с клавиатуры целое число.
 * Вывести в консоль его факториал.
 */
public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число: ");
        int number = scanner.nextInt();
        scanner.close();
        if (number < 0) {
            System.out.println("Число должно быть больше либо равное нулю!");
        } else if (number == 0) {
            System.out.println(1);
        } else {
            int result = 1;
            for (int i = 1; i <= number; i++) {
                result *= i;
            }
            System.out.println(result);
        }
    }
}
