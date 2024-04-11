package com.walking.lesson7_varargs_overloading;

import java.util.Scanner;

/**
 * Вычислите факториал введенного с клавиатуры целого числа, используя рекурсивный алгоритм.
 */
public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите целое число");
        int number = scanner.nextInt();
        scanner.close();
        System.out.println(calculateFactorial(number));
    }

    static int calculateFactorial(int number) {
        if (number == 1) {
            return 1;
        }
        return number * calculateFactorial(number - 1);
    }
}

