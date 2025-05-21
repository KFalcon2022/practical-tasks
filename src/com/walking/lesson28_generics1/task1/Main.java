package com.walking.lesson28_generics1.task1;

import com.walking.lesson28_generics1.task1.math.Power;

/**
 * Создать обобщенный тип, принимающий в себя любого из наследников Number.
 * Создать метод, возводящий значение параметризованного типа в степень,
 * переданную параметром в метод.
 */
public class Main {
    public static void main(String[] args) {
        Power<Byte> bytePower = new Power<>((byte) 2);
        Power<Short> shortPower = new Power<>((short) 2);
        Power<Integer> integerPower = new Power<>(2);
        Power<Long> longPower = new Power<>((long) 2);
        Power<Float> floatPower = new Power<>(2.5f);
        Power<Double> doublePower = new Power<>(2.5);

        System.out.println(doublePower.toPow(3));
    }
}