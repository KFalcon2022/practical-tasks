package com.walking.lesson29_generics2.task2;

import com.walking.lesson29_generics2.task2.model.NumberExponentiater;

/**
 * Используя Задачу 1 из урока Generics.
 * Часть I, реализуйте в Main метод, принимающий аргументом объект подходящего
 * для дженерика типа и возвращающий объект дженерика.
 * Допустима параметризация только с использованием wildcard.
 */

public class Main {
    public static void main(String[] args) {
        NumberExponentiater<?> numberExponentiater = createNumberExponentiater(4);
        System.out.println(numberExponentiater.getNumber());
    }

    private static NumberExponentiater<? extends Number> createNumberExponentiater(Number number) {
        return new NumberExponentiater<>(number);
    }
}
