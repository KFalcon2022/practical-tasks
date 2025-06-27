package com.walking.lesson29_generics2.task2;

import com.walking.lesson29_generics2.task2.model.NumberExponentiater;

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
        NumberExponentiater<?> numberExponentiater = new NumberExponentiater<Byte>((byte) 2);
        //здесь и далее при инициализации объекта ИДЕА показывает
        //конкретное обозначение Типа объекта (<Byte>) избыточно.
        // А со стороны "Правописания" кода будет ли верно, если я не буду конкретно указывать Этот тип?
        // Ибо если я оставляю только Алмазный оператор, ничего не меняется при выполенении кода.
        System.out.println(toExponent(numberExponentiater));

        numberExponentiater = new NumberExponentiater<Short>((short) 2);
        System.out.println(toExponent(numberExponentiater));

        numberExponentiater = new NumberExponentiater<Integer>(2);
        System.out.println(toExponent(numberExponentiater));

        numberExponentiater = new NumberExponentiater<Long>(2L);
        System.out.println(toExponent(numberExponentiater));

        numberExponentiater = new NumberExponentiater<Double>(2d);
        System.out.println(toExponent(numberExponentiater));

        numberExponentiater = new NumberExponentiater<Float>(2f);
        System.out.println(toExponent(numberExponentiater));

    }

    private static NumberExponentiater<? extends Number> toExponent(NumberExponentiater<? extends Number> generic) {
        return new NumberExponentiater<>(generic.exponentiate(2));
    }
}
