package com.walking.lesson4_cycles;

import java.util.Scanner;

/**
 * Ввести с клавиатуры целое число.
 * Вывести в консоль сумму цифр введенного числа.
 */
public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number: ");
        int number = scanner.nextInt();

        scanner.close();

        int digitSum = 0;

        while (number != 0) {
//            Последняя цифра числа == остаток от его деления на 10
            digitSum += number % 10;
//            Исключаем цифру, которую уже учли в сумме
            number /= 10;
        }

//        сумма цифр даже отрицательного числа должна быть положительна
        if (digitSum < 0) {
            digitSum *= -1;
        }

        System.out.println(digitSum);
    }
}
