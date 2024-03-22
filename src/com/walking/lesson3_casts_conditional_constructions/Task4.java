package com.walking.lesson3_casts_conditional_constructions;

import java.util.Scanner;

/**
 * Ввести с клавиатуры два целых числа.
 * Если первое – четное ИЛИ второе – кратно трем,
 * вывести в консоль результат сравнения этих чисел.
 * <p>
 * Если первое число кратно и двум, и трем – вывести на экран число один,
 * возведенное в степень N, где N – второе число.
 * Для возведения в степень можно использовать Math.pow().
 * В случае, если результат выражения выходит за пределы типа int
 * (допустимые значения - [-2147483648; 2147483647]) –
 * вывести сообщение «Результат выражения слишком большой!»
 * <p>
 * Также максимальное и минимальное значение int содержится в константах
 * Integer.MIN_VALUE и Integer.MAX_VALUE соответственно.
 */
public class Task4 {
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
