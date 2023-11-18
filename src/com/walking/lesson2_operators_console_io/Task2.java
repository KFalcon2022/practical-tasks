package src.com.walking.lesson2_operators_console_io;

/**
 * Введите с клавиатуры целые числа a и b.
 * Выведите на экран результат сравнения:
 * a3 > b2,       где a3 - a в кубе, b2 - b  в квадрате
 */
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите первое число: ");
        int a = scanner.nextInt();

        System.out.print("Введите первое число: ");
        int b = scanner.nextInt();

        scanner.close();

        System.out.println("Результат сравнения a3 > b2, где a3 - a в кубе, b2 - b  в квадрате: " + (Math.pow(a, 3) > Math.pow(b, 2)));
    }
}