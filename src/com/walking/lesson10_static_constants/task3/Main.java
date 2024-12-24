package com.walking.lesson10_static_constants.task3;

import java.util.Scanner;

/**
 * Используя задачу </p>
 * (можете сделать на основе своего решения,
 * </p>но для наглядности удобства новых возможностей
 * </p>рекомендую взять за основу решение по ссылке):
 * <p>
 * Вынесите поиск простых чисел в отдельный класс.</p>
 * Реализуйте возможность вывода на экран суммы N первых простых чисел, где
 * </p>N – число, введенное пользователем с клавиатуры;
 * </p>
 * Вынесите нужные вам переменные в поля класса.<p>
 * Если необходимо – сделайте их константами уровня класса или объекта.
 * </p>Помните, константа ссылочного типа гарантирует
 * </p>неизменность ссылки, а не содержимого объекта.
 * </p>Массив – ссылочный тип.
 * </p>
 * Примечание: это одна задача, а не различные варианты:)
 */
public class Main {
    public static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
//        int[] array = new int[requireInt()];
        PrimeNumbersFinder primeNumbersFinder = new PrimeNumbersFinder(requireInt());
        primeNumbersFinder.setArrayValue();
        primeNumbersFinder.show();

        primeNumbersFinder.getArraySum();
    }

    private static int requireInt() {
        System.out.print("Enter a num: ");
        return SCANNER.nextInt();
    }
}
