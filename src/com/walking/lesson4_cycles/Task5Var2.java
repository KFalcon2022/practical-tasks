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

//        Сначала выведем фразу в первый раз, а лишь потом начнем запрашивать число
        do {
            System.out.println("Не угадал!");
        } while (scanner.nextInt() != 1);

        scanner.close();
    }
}
