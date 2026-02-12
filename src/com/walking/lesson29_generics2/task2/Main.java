package com.walking.lesson29_generics2.task2;


import com.walking.lesson29_generics2.task2.service.PowOfNumber;

/**
 * Используя Задачу 1 из урока Generics.
 * Часть I, реализуйте в Main метод, принимающий аргументом объект подходящего
 * для дженерика типа и возвращающий объект дженерика.
 * Допустима параметризация только с использованием wildcard.
 */
public class Main {
    public static void main(String[] args) {
        PowOfNumber<?> d1 = getPowOfNumber(4);
        Double result = d1.sqr(3.0);

        System.out.println(result);
    }

    public static PowOfNumber<? extends Number> getPowOfNumber(Number number) {
        return new PowOfNumber<>(number);
    }
}
