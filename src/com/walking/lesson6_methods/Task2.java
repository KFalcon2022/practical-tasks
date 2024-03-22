package com.walking.lesson6_methods;

import java.util.Scanner;

/**
 * Декомпозировать задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/blob/master/src/lesson3/Task4.java">...</a>
 * Вынести в отдельный метод логику, которая отрабатывает,
 * когда первое число кратно и двум, и трем.
 */
public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число 1");
        int num1 = scanner.nextInt();
        System.out.println("Введите число 2");
        int num2 = scanner.nextInt();
        scanner.close();

        if (num1 % 2 == 0 || num2 % 3 == 0) {
            System.out.println(num1 == num2);
        }
        calculatePow(num1, num2);
    }

    static void calculatePow(int num1, int num2) {
        if (num1 % 2 == 0 && num1 % 3 == 0) {
            double result = Math.pow(num1, num2);
            if (result < Integer.MIN_VALUE || result > Integer.MAX_VALUE) {
                System.out.println("Результат выражения слишком большой");
            } else {
                System.out.println((int) result);
            }
        }
    }
}
