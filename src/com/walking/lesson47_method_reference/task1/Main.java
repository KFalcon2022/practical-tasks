package com.walking.lesson47_method_reference.task1;

import java.util.List;

/**
 * Создайте произвольный список элементов.
 * Выведите каждый из элементов в консоль.
 * Параметр forEach() опишите как method reference.
 */
public class Main {
    public static void main(String[] args) {
        List<String> strings = List.of("1", "2", "3", "4", "5");

        strings.forEach(System.out::println);
    }
}
