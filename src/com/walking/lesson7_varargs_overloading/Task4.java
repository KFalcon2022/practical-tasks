package com.walking.lesson7_varargs_overloading;

import java.util.Scanner;

/**
 * Вычислите результат выражения, используя рекурсивный алгоритм.
 * n — число, введенное с клавиатуры.
 * Для N < 1 — вывести соответствующее сообщение в консоль и завершить выполнение программы.
 * <p>
 * Выражение: √(1 + √(2 + ... + √n)))
 */
public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите вещественное число");
        double number = scanner.nextDouble();
        scanner.close();
        int step = (int) number;

        if (number < 1) {
            System.out.println("Число меньше 1");
            return;
        }

        System.out.println(calculateExpression(number, step));
    }

    static double calculateExpression(double number, int step) {
        step--;

        if (step == 1) {
            return Math.sqrt(1 + Math.sqrt(number));
        }

        return calculateExpression(step + Math.sqrt(number), step);
    }
}