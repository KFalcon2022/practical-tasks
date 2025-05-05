package com.walking.lesson29_generics2.task2;


/**
 * Используя Задачу 1 из урока Generics.
 * Часть I, реализуйте в Main метод, принимающий аргументом объект подходящего
 * для дженерика типа и возвращающий объект дженерика.
 * Допустима параметризация только с использованием wildcard.
 */
public class Main {
    public static void main(String[] args) {
        Number1<?> number1 = createNumber(5);
        System.out.println(number1.getPow(2));

    }

    private static Number1<? extends Number> createNumber(Number number1) {
        return new Number1<>(number1);
    }
}
