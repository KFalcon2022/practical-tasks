package com.walking.lesson29_generics2.task2;

import com.walking.lesson29_generics2.task2.model.GenericClass;

/**
 * Используя Задачу 1 из урока Generics.
 * Часть I, реализуйте в Main метод, принимающий аргументом объект подходящего
 * для дженерика типа и возвращающий объект дженерика.
 * Допустима параметризация только с использованием wildcard.
 */
public class Main {
    public static void main(String[] args) {
        GenericClass<?> genericClass = createGeneric(12);
        System.out.println(genericClass.getNumber());
    }

    private static GenericClass<? extends Number> createGeneric(Number number) {
        return new GenericClass<>(number);
    }
}
