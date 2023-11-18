package com.walking.lesson4_cycles;

import java.util.Scanner;

/**
 * Выводить на экран "Не угадал!" до тех пор,
 * пока с клавиатуры не будет введено число 1.
 * Запрашивать число с клавиатуры после выводом на экран "Не угадал!"
 */
public class Task5Var2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите целое загаданное число: ");
        int n = scanner.nextInt();
        while (n != 1) {
            System.out.println("Не угадал");
            System.out.println("Вводи еще раз: ");
            n = scanner.nextInt();
        }
        scanner.close();
    }
}
