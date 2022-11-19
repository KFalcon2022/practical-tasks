package lesson4_cycles;

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the 2nd number: ");
        int number = scanner.nextInt();

        scanner.close();

        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                int result = i + number;
                System.out.printf("%d + %d = %d\n", i, number, result);
            } else {
                int result = i - number;
                System.out.printf("%d - %d = %d\n", i, number, result);
            }

            if (i == number) {
                System.out.println("Числа равны!");
            }
        }
    }
}
