package lesson4_cycles;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number: ");
        int number = scanner.nextInt();

        scanner.close();

        int digitSum = 0;

        while (number != 0) {
            digitSum += number % 10;
            number /= 10;
        }

        if (digitSum < 0) {
            digitSum *= -1;
        }

        System.out.println(digitSum);
    }
}
