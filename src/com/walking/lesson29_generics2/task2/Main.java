package com.walking.lesson29_generics2.task2;

import com.walking.lesson29_generics2.task2.model.NumberExponentiater;

/**
 * Используя Задачу 1 из урока Generics. Часть I,
 * реализуйте в Main метод, принимающий аргументом объект подходящего
 * для дженерика типа и возвращающий объект дженерика.
 * Допустима параметризация только с использованием wildcard.
 */
public class Main {
    public static void main(String[] args) {
        NumberExponentiater<?> integerExponentiater = createNumberExponentiater(1);
        System.out.println(integerExponentiater.getNumber());
    }

    public static <T extends Number> NumberExponentiater<T> createNumberExponentiater(T number) {
    return new NumberExponentiater<T>(number);
    }
}
