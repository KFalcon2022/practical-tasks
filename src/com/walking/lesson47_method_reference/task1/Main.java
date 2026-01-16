package com.walking.lesson47_method_reference.task1;

import com.walking.lesson47_method_reference.task1.model.*;

import java.util.List;

/**
 * Создайте произвольный список элементов.
 * Выведите каждый из элементов в консоль.
 * Параметр forEach() опишите как method reference.
 */
public class Main {
    public static void main(String[] args) {
        List<Animal> animals = List.of(new Cat(), new Dog(), new Cow());

        animals.forEach(System.out::println);
    }
}
