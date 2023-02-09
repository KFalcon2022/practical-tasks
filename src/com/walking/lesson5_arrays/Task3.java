package com.walking.lesson5_arrays;

import java.lang.reflect.Array;

/**
 * Вычислить из записать в массив первые 10 простых чисел.
 * Простое число – положительное целое число,
 * которое делится без остатка лишь на себя и на 1.
 * 1 не является простым числом.
 * Вывести в консоль сумму всех элементов полученного массива.
 */
public class Task3 {
    public static void main(String[] args) {
        int[] array = new int[10];
        int number = 2;
        for (int i = 0; i < array.length; i++) {
            boolean isEasy = true;

            for (int j = 2; j < number; j++) {
                if (number % j == 0) {
                    isEasy = false;
                }
            }
            if (isEasy && array[i] == 0) {
                array[i] = number;
                number++;
            } else {
                i-=1;
                number++;
            }
        }
        int sum = 0;
        for (int element : array){
            sum = sum + element;
        }
        System.out.println("Сумма элементов массива равна " + sum);
    }
}

