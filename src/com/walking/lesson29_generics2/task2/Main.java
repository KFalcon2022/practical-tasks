package com.walking.lesson29_generics2.task2;

import com.walking.lesson29_generics2.task2.model.NumberToPower;

/**
 * Используя Задачу 1 из урока Generics.
 * Часть I, реализуйте в Main метод, принимающий аргументом объект подходящего
 * для дженерика типа и возвращающий объект дженерика.
 * Допустима параметризация только с использованием wildcard.
 */
public class Main {
    public static void main(String[] args) {
        NumberToPower<?> numberToPower;

        numberToPower = method(123);
        System.out.println(numberToPower.getValue());

        numberToPower = method(1.0);
        System.out.println(numberToPower.getValue());
    }

    public static NumberToPower<? extends Number> method (Number param) {
        return new NumberToPower<>(param);
    }

}
