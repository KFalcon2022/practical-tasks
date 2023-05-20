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
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество простых чисел: ");

        int amount = scanner.nextInt();

        PrimeNumberSearcher primeNumberSearcher = new PrimeNumberSearcher();
        int[] primeNumbers = primeNumberSearcher.findPrimeNumbers(amount);

        System.out.println("Сумма простых чисел: " + primeNumberSearcher.sum(primeNumbers));
    }
}
