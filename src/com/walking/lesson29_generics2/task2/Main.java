package com.walking.lesson29_generics2.task2;

import com.walking.lesson28_generics1.task1.model.Power;

/**
 * Используя Задачу 1 из урока Generics.
 * Часть I, реализуйте в Main метод, принимающий аргументом объект подходящего
 * для дженерика типа и возвращающий объект дженерика.
 * Допустима параметризация только с использованием wildcard.
 */
/**
 * Создать обобщенный тип, принимающий в себя любого из наследников Number.
 * Создать метод, возводящий значение параметризованного типа в степень,
 * переданную параметром в метод.
 */
public class Main {
    public static void main(String[] args) {
        Power<?> power=getGeneric((short)20);
        System.out.println(power.getPower(3));
    }

    private static <T extends Number>Power<?> getGeneric(T value){
        return new Power<T>(value);
    }
}
