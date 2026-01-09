package com.walking.lesson47_method_reference.task1;

import java.util.List;

/**
 * Создайте произвольный список элементов.
 * Выведите каждый из элементов в консоль.
 * Параметр forEach() опишите как method reference.
 */
public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(7, 6, 23, 45, 32, 8, 7, 94, 5, 17);
        numbers.forEach(System.out::println);
    }
}
