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
        NumberExponentiater<Byte> byteExponentiater = new NumberExponentiater<>((byte) 2);
        NumberExponentiater<Short> shortExponentiater = new NumberExponentiater<>((short) 2);
        NumberExponentiater<Integer> integerExponentiater = new NumberExponentiater<>(2);
        NumberExponentiater<Long> longExponentiater = new NumberExponentiater<>(2L);
        NumberExponentiater<Double> doubleExponentiater = new NumberExponentiater<>(2d);
        NumberExponentiater<Float> floatExponentiater = new NumberExponentiater<>(2f);

        System.out.println(byteExponentiater.exponentiate(2));
        System.out.println(shortExponentiater.exponentiate(2));
        System.out.println(integerExponentiater.exponentiate(2));
        System.out.println(longExponentiater.exponentiate(2));
        System.out.println(doubleExponentiater.exponentiate(2));
        System.out.println(floatExponentiater.exponentiate(2));
        System.out.println("\n");

        System.out.println(getGenericObj(2).exponentiate(2));
        System.out.println(getGenericObj(2.56).exponentiate(2));
    }
    private static NumberExponentiater<? extends Number> getGenericObj (Number value){
        return new NumberExponentiater<>(value);
    }
}
