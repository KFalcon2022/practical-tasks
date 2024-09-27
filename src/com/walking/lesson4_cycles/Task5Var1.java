package com.walking.lesson4_cycles;

import java.util.Scanner;

/**
 * Выводить на экран "Не угадал!" до тех пор,
 * пока с клавиатуры не будет введено число 1.
 * Запрашивать число с клавиатуры перед выводом на экран "Не угадал!"
 */
public class Task5Var1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;
        do {
            System.out.println("Введите целое загаданное число: ");
            n = scanner.nextInt();
            if (n != 1) {
                System.out.println("Не угадал");
            }
        } while (n != 1);
        scanner.close();
    }
}
