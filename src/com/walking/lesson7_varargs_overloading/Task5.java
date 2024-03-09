package com.walking.lesson7_varargs_overloading;

/**
 * Вычислить из записать в массив первые 10 простых чисел.
 * <p>
 * Простое число – положительное целое число,
 * которое делится без остатка лишь на себя и на 1.
 * 1 не является простым числом.
 * <p>
 * Вывести в консоль сумму всех элементов полученного массива.
 * <p>
 * Нахождение простых чисел и вычисление суммы реализовать, используя рекурсивные методы.
 */
public class Task5 {
    static int denominator = 2; // делитель

    public static void main(String[] args) {
        int[] primeNumbers = new int[10];
        int i = 0; // текущий индекс массива
        int number = 2; //текущее проверяемое число
        while (i < 10) {
            if (searchPrimeNumber(number) == 0) {
                number++;
                continue;
            }
            primeNumbers[i] = searchPrimeNumber(number);
            i++;
            number++;
            denominator = 2;
        }
        System.out.println(sumArray(primeNumbers, 0));
    }

    static int searchPrimeNumber(int number) {
        if (number == 2) {
            return 2;
        }
        if (number == 3) {
            return 3;
        }
        if (number > denominator) {
            if (number % denominator != 0) {
                if (number - 1 == denominator) {
                    return number;
                }
                denominator++;
            } else if (number % denominator == 0) {
                number++;
                denominator = 2;
            }
            searchPrimeNumber(number);
        }
        return 0;
    }

    static int sumArray(int[] array, int index) {
        if (index == 9) {
            return array[index];
        }

        return array[index] + sumArray(array, index + 1);
    }
}
