package com.walking.lesson29_generics2.task2;


import com.walking.lesson29_generics2.task2.service.GenericNum;

/**
 * Используя Задачу 1 из урока Generics.
 * Часть I, реализуйте в Main метод, принимающий аргументом объект подходящего
 * для дженерика типа и возвращающий объект дженерика.
 * Допустима параметризация только с использованием wildcard.
 */
public class Main {
    public static void main(String[] args) {
        GenericNum<?> num = getGeneric(7);
        System.out.println(num.getResult(3));

        num = getGeneric(654L);
        System.out.println(num.getResult(2));
    }

    public static GenericNum<? extends Number> getGeneric(Number num) {
        return new GenericNum<>(num);
    }
}
