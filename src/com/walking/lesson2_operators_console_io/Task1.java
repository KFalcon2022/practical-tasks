package com.walking.lesson2_operators_console_io;

import java.util.Scanner;

/**
 * Введите с клавиатуры вещественные числа a и b. Выведите на экран результат выражения
 * c = b*a*(a + b)/(a2),         где a2 - a в квадрате
 * Совпадает ли результат выражения, если a и b — переменные типа int
 * (для проверки не забудьте также использовать подходящий метод Scanner)?
 */
public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите два вещественных числа по порядку: ");
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c =  b*a*(a + b)/(a*a);
        System.out.printf("Результат вычисления равен %f \n", c);

        System.out.println("Введите два целых числа по порядку: ");
        int aa = scanner.nextInt();
        int bb = scanner.nextInt();
        int cc =  bb*aa*(aa + bb)/(aa*aa);
        System.out.printf("Результат вычисления равен %d", cc);
        scanner.close();
    }
}
