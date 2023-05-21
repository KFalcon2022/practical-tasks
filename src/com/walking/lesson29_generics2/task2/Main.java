package com.walking.lesson29_generics2.task2;

import com.walking.lesson29_generics2.task2.model.GenNumber;

/**
 * Используя Задачу 1 из урока Generics.
 * Часть I, реализуйте в Main метод, принимающий аргументом объект подходящего
 * для дженерика типа и возвращающий объект дженерика.
 * Допустима параметризация только с использованием wildcard.
 */
public class Main {
    public static void main(String[] args) {
        GenNumber<?> genDouble = getGeneric(34d);
        System.out.println(genDouble.getNumber());

        GenNumber<?> genInt = getGeneric(34);
        System.out.println(genInt.getNumber());

    }

    private static GenNumber<? extends Number> getGeneric(Number number){
        return new GenNumber<>(number);
    }
}
