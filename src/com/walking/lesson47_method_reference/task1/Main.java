package com.walking.lesson47_method_reference.task1;

import java.util.ArrayList;
import java.util.List;

/**
 * Создайте произвольный список элементов.
 * Выведите каждый из элементов в консоль.
 * Параметр forEach() опишите как method reference.
 */
public class Main {
    public static void main(String[] args) {
        List<String> months = new ArrayList<>();

        months.add(new String("January"));
        months.add(new String("February"));
        months.add(new String("March"));
        months.add(new String("April"));
        months.add(new String("May"));
        months.add(new String("June"));
        months.add(new String("July"));
        months.add(new String("August"));
        months.add(new String("September"));
        months.add(new String("October"));
        months.add(new String("November"));
        months.add(new String("December"));

        months.forEach(System.out::println);
    }
}
