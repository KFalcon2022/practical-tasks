package com.walking.lesson29_generics2.task2;

import com.walking.lesson29_generics2.task2.model.NumberExponentiation;

/**
 * Используя Задачу 1 из урока Generics.
 * Часть I, реализуйте в Main метод, принимающий аргументом объект подходящего
 * для дженерика типа и возвращающий объект дженерика.
 * Допустима параметризация только с использованием wildcard.
 */
public class Main {
    public static void main(String[] args) {
        NumberExponentiation<?> genericInteger = new NumberExponentiation<Integer>(2);
        NumberExponentiation<?> genericDouble = new NumberExponentiation<Double>(4.1);

        System.out.println(genericInteger.exponentiation(2));
        System.out.println(genericDouble.exponentiation(3));
        System.out.println(createNumberExponentiation(3.3).exponentiation(4));
    }

    public static NumberExponentiation<? extends Number> createNumberExponentiation(Number number) {
        return new NumberExponentiation<>(number);
    }
}


