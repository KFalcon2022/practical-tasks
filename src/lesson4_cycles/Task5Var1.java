package lesson4_cycles;

import java.util.Scanner;

public class Task5Var1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.nextInt() != 1) {
            System.out.println("Не угадал!");
        }

        scanner.close();
    }
}
