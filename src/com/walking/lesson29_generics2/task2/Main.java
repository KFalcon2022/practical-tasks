package com.walking.lesson29_generics2.task2;

import com.walking.lesson29_generics2.task2.model.CustomNumber;

/**
 * Используя Задачу 1 из урока Generics.
 * Часть I, реализуйте в Main метод, принимающий аргументом объект подходящего
 * для дженерика типа и возвращающий объект дженерика.
 * Допустима параметризация только с использованием wildcard.
 */
public class Main {
    public static void main(String[] args) {
        CustomNumber<?> customNumber = getCustomNumber(666);
        System.out.println(customNumber);
    }

    public static CustomNumber<? extends Number> getCustomNumber(Number value) {
        return new CustomNumber<>(value);
    }
}
