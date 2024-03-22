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
        int[] primeNumbers = new int[10];
        int number = 2; //текущее число, проверяемое на простоту
        int i = 0; // текущий индекс массива

        while (i < 10) {
            if (number == 2) {
                primeNumbers[i] = 2;
                i++;
                number++;
                continue;
            }
            if (number == 3) {
                primeNumbers[i] = 3;
                i++;
                number++;
                continue;
            }
            for (int j = 2; j < number; j++) {
                if (number % j == 0) {
                    break;
                } else if (j == number - 1) {
                    primeNumbers[i] = number;
                    i++;
                }
            }
            if (i >= 10) {
                break;
            }
            number++;
        }
        int result = 0;
        for (int primeNumber : primeNumbers) {
            result += primeNumber;
            System.out.println(result);
        }
    }
}
