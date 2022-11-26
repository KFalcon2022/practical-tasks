package com.walking.lesson4_cycles;

import java.util.Scanner;

/**
 * Ввести с клавиатуры целое число.
 * Вывести в консоль его факториал.
 */
public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number: ");
        int number = scanner.nextInt();

        scanner.close();

        if (number < 0) { //Факториал отрицательного числа не существует
            System.out.println("The number must be at least 0");
        } else if (number == 0) {
//            0! == 1
            System.out.println(1);
        } else {
            int result = 1;

            for (int i = 1; i <= number; i++) {
                result *= i;
            }

            System.out.println(result);
        }
    }
}
