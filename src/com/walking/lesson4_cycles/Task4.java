package com.walking.lesson4_cycles;

/**
 * Ввести с клавиатуры целое число (Число 2).
 * Для каждого из чисел от 1 до 10 выполнить:
 * <p>
 * Если число1 четное, вывести сумму двух чисел (пр.1),
 * если нет - разность(пр.2).
 * Также если числа равны - вывести надпись "числа равны!".
 * <p>
 * пр1.: "Число1 + Число2 = Сумма",
 * где число1 - значение 1го числа (от 1 до 10),
 * число2 - значение введенного с клавиатуры числа,
 * Сумма - результат сложения.
 * <p>
 * пр2.: "Число1 - Число2 = Разность",
 * где число1 - значение 1го числа (от 1 до 10),
 * число2 - значение введенного с клавиатуры числа,
 * Разность - результат вычитания.
 */

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите число: ");
        int a = scanner.nextInt();

        scanner.close();

        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                System.out.println("Число1 + Число2 = " + (i + a));
            } else {
                System.out.println("Число1 - Число2 = " + (i - a));
            }

            if (a == i) {
                System.out.println("Числа равны!");
            }
        }
    }
}