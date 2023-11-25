package src.com.walking.lesson4_cycles;

import java.util.Scanner;

/**
 * Выводить на экран "Не угадал!" до тех пор,
 * пока с клавиатуры не будет введено число 1.
 * Запрашивать число с клавиатуры после выводом на экран "Не угадал!"
 */
public class Task5Var2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a;

        do {
            System.out.println("Не угадал!");
            a = scanner.nextInt();
        }
        while (a != 1);

        scanner.close();
    }
}
