package lesson4_cycles;

import java.util.Scanner;

public class Task5Var2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Не угадал!");
        } while (scanner.nextInt() != 1);

        scanner.close();
    }
}
