package com.walking.lesson5_arrays;

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
        int i = 0;
        while (i < array.length) {
            boolean isPrimeNumber = true;

            int j = 2;
            while (isPrimeNumber && j < number){
                if (number % j == 0) {
                    isPrimeNumber = false;
                    }
                j++;
            }

            if (isPrimeNumber && array[i] == 0) {
                array[i] = number;
                i++;
            }
            number++;
        }
        int sum = 0;
        for (int element : array) {
            sum += element;
        }

        System.out.println("Сумма элементов массива равна " + sum);
    }
}

