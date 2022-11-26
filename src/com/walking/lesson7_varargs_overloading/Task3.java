package com.walking.lesson7_varargs_overloading;

import java.util.Scanner;

/**
 * Вычислите факториал введенного с клавиатуры целого числа, используя рекурсивный алгоритм.
 */
public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number: ");
        int number = scanner.nextInt();

        scanner.close();

        if (number < 0) {
            System.out.println("The number must be at least 0");
            return;
        }

        System.out.println(calculateFactorial(number));
    }

    static long calculateFactorial(int number) {
        if (number == 0) {
            return 1;
        }

        if (number == 1) {
            return 1;
        }

        return number * calculateFactorial(number - 1);
    }
}
