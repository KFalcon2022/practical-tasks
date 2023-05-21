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
        for (int i = 0; i < primeNumbers.length; i++) {
            if (i == 0) {
                primeNumbers[i] = 2;
            } else {
                int addingValue = i == 1 ? 1 : 2;
                int number = primeNumbers[i - 1] + addingValue;
                while (primeNumbers[i] == 0) {
                    int j = 0;
                    boolean isPrime = true;
                    while (isPrime && j < i && number / primeNumbers[j] > 1) {
                        if (number % primeNumbers[j] == 0) {
                            isPrime = false;
                        } else {
                            j++;
                        }
                    }
                    if (isPrime) {
                        primeNumbers[i] = number;
                    } else {
                        number += 2;
                    }
                }
            }
        }
        int result = 0;
        for (int i : primeNumbers) {
            result += i;
        }
        System.out.println(result);
    }
}
