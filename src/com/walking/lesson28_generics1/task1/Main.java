package com.walking.lesson28_generics1.task1;

import com.walking.lesson28_generics1.task1.model.NumberExponentiater;

/**
 * Создать обобщенный тип, принимающий в себя любого из наследников Number.
 * Создать метод, возводящий значение параметризованного типа в степень,
 * переданную параметром в метод.
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
    }
}
