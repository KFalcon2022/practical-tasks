package com.walking.lesson2_operators_console_io;

/**
 * Введите с клавиатуры вещественные числа a и b. Выведите на экран результат выражения
 * c = b*a*(a + b)/(a2),         где a2 - a в квадрате
 * Совпадает ли результат выражения, если a и b — переменные типа int
 * (для проверки не забудьте также использовать подходящий метод Scanner)?
 */
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите первое число: ");
        double a = scanner.nextDouble();

        System.out.print("Введите первое число: ");
        double b = scanner.nextDouble();

        scanner.close();

        System.out.println("Результат c = b*a*(a + b)/(a^2): " + b * a * (a + b) / Math.pow(2, 2));

    }
}
