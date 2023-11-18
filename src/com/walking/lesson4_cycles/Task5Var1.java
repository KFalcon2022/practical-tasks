package com.walking.lesson4_cycles;

/**
 * Выводить на экран "Не угадал!" до тех пор,
 * пока с клавиатуры не будет введено число 1.
 * Запрашивать число с клавиатуры перед выводом на экран "Не угадал!"
 */

import java.util.Scanner;

public class Task5Var1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = 0;
        while (a != 1) {
            a = scanner.nextInt();
            System.out.println("Не угадал!");
        }

        scanner.close();
    }
}
