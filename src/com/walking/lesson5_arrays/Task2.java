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
        int[] nums = new int[5];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < nums.length; i++) {
            System.out.println("Введите " + i + " элемент массива");
            nums[i] = scanner.nextInt();
        }
        scanner.close();
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                System.out.println(nums[i] - nums[nums.length - 1]);
            } else {
                System.out.println(nums[i] - nums[i - 1]);
            }
        }
    }
}
