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

        System.out.print("Enter number: ");
        int number = scanner.nextInt();

        scanner.close();

        if (number <= 0) {
            System.out.println("The number must be at least 1");
            return;
        }

        System.out.println(calculateExpression(number));
    }

    //    Делаем удобный для использования метод с одним параметром
    static double calculateExpression(int number) {
        return calculateExpression(1, number);
    }

    //    Реализуем рекурсивный метод, второй параметр которого необходим,
//    но всегда известен для первого вызова
    static double calculateExpression(int number, int maxNumber) {
        if (number == maxNumber) {
            return Math.sqrt(number);
        }

        return Math.sqrt(number + calculateExpression(number + 1, maxNumber));
    }
}
