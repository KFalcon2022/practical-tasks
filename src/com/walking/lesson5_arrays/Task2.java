package src.com.walking.lesson5_arrays;

/**
 * Создать массив int’ов из 5 элементов.
 * Заполнить его значениями, введенными с клавиатуры.
 * Вывести на экран сумму каждого значения с предыдущим.
 * Предыдущим значением для 0го элемента считать последнее значение массива.
 */

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[5];

        for (int i = 0; i < numbers.length; i++) {
            System.out.printf("Введите %d-е число: ", (i + 1));
            numbers[i] = scanner.nextInt();
        }

        scanner.close();

        for (int i = 0; i < numbers.length; i++) {
            if (i == 0) {
                System.out.printf("Сумма %d-го числа и предыдущего: %d\n", (i + 1), numbers[0] + numbers[numbers.length - 1]);
            } else {
                System.out.printf("Сумма %d-го числа и предыдущего: %d\n", (i + 1), numbers[i] + numbers[i - 1]);
            }
        }
    }
}
