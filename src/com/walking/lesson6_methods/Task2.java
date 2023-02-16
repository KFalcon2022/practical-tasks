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
        System.out.println("Enter first number: ");
        int a = scanner.nextInt();
        System.out.println("Enter second number: ");
        int b = scanner.nextInt();
        scanner.close();

        checkIfMultipleTwoOrThree(a, b);
        checkIfMultipleTwoAndThree(a, b);
    }

    public static void checkIfMultipleTwoOrThree(int a, int b){
        if (a % 2 == 0 || b % 3 == 0) {
            System.out.println(a == b);
        }
    }

    public static void checkIfMultipleTwoAndThree(int a, int b) {
        if (a % 2 == 0 && a % 3 == 0) {
            double result = Math.pow(a, b);

            if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
                System.out.println("Результат выражения слишком большой!");
            } else {
                System.out.println((int) result);
            }
        }
    }
}

