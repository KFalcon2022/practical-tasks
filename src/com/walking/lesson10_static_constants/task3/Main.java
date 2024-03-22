package com.walking.lesson10_static_constants.task3;

import java.util.Scanner;

/**
 * Используя задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/blob/master/src/lesson7_varargs_overloading/Task5.java">...</a>
 * (можете сделать на основе своего решения,
 * но для наглядности удобства новых возможностей рекомендую взять за основу решение по ссылке):
 * <p>
 * 1. Вынесите поиск простых чисел в отдельный класс.
 * <p>
 * 2. Реализуйте возможность вывода на экран суммы N первых простых чисел,
 * где N – число, введенное пользователем с клавиатуры;
 * <p>
 * 3. Вынесите нужные вам переменные в поля класса.
 * Если необходимо – сделайте их константами уровня класса или объекта.
 * Помните, константа ссылочного типа гарантирует неизменность ссылки, а не содержимого объекта.
 * Массив – ссылочный тип.
 */
public class Main {
    public static final Scanner SCANNER = new Scanner(System.in);
    static final int[] PRIME_NUMBERS = new int[inputNumber(SCANNER)];

    public static void main(String[] args) {
        SCANNER.close();
        FinderPrimeNumbers finder = new FinderPrimeNumbers();

        for (int i = 0; i < PRIME_NUMBERS.length; i++) {
            if (i == 0) {
                PRIME_NUMBERS[i] = 2;
            } else {
                int addingValue = i == 1 ? 1 : 2;
                int number = PRIME_NUMBERS[i - 1] + addingValue;
                PRIME_NUMBERS[i] = finder.findNextPrimeNumber(number, PRIME_NUMBERS, i);
            }
        }

        System.out.println(sum(PRIME_NUMBERS));
    }

    static int sum(int[] numbers) {
        return sum(numbers, 0);
    }

    static int sum(int[] numbers, int i) {
        if (i == numbers.length - 1) {
            return numbers[i];
        }

        return numbers[i] + sum(numbers, i + 1);
    }

    static int inputNumber(Scanner scanner) {
        System.out.println("Введите число");
        return scanner.nextInt();
    }
}
