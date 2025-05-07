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
        int a = readUserInput(scanner, "Enter first number: ");
        int b = readUserInput(scanner, "Enter second number: ");
        scanner.close();

        if (a % 2 == 0 || b % 3 == 0) {
            System.out.println(a == b);
        }

        if (a % 2 == 0 && a % 3 == 0) {
            multipleTwoAndThree(a, b);
        }
    }

    public static int readUserInput(Scanner scanner, String messageForUser){
        System.out.println(messageForUser);
        return scanner.nextInt();
    }

    public static void multipleTwoAndThree(int a, int b) {
        double result = Math.pow(a, b);

        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            System.out.println("Результат выражения слишком большой!");
        } else {
            System.out.println((int) result);
        }
    }
}


