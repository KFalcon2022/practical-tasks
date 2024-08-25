package com.walking.lesson29_generics2.task2;

import com.walking.lesson29_generics2.task1.Generic;

/**
 * Используя Задачу 1 из урока Generics.
 * Часть I, реализуйте в Main метод, принимающий аргументом объект подходящего
 * для дженерика типа и возвращающий объект дженерика.
 * Допустима параметризация только с использованием wildcard.
 */
public class Main {
    public static void main(String[] args) {
    }

    public static Generic<? extends Number> method(Number number) {
        return new Generic<>(number);
    }
}
