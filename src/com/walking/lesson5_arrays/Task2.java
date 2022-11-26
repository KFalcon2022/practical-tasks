package com.walking.lesson5_arrays;

import java.util.Scanner;

/**
 * Создать массив int’ов из 5 элементов.
 * Заполнить его значениями, введенными с клавиатуры.
 * Вывести на экран сумму каждого значения с предыдущим.
 * Предыдущим значением для 0го элемента считать последнее значение массива.
 */
public class Task2 {
    public static void main(String[] args) {
        int[] array = new int[5];

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }

        scanner.close();

        for (int i = 0; i < array.length; i++) {
            int result;

            if (i == 0) {
//                Складываем 0й элемент с последним
                result = array[i] + array[array.length - 1];
            } else {
//                Складываем текущий элемент с предыдущим
                result = array[i] + array[i - 1];
            }

            System.out.println(result);
        }
    }
}
