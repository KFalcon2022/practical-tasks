package com.walking.lesson28_generics1.task1;

import com.walking.lesson28_generics1.task1.model.CustomNumber;

/**
 * Создать обобщенный тип, принимающий в себя любого из наследников Number.
 * Создать метод, возводящий значение параметризованного типа в степень,
 * переданную параметром в метод.
 */
public class Main {
    public static void main(String[] args) {
        CustomNumber<Byte> byteCustomNumber = new CustomNumber<>((byte) 2);
        CustomNumber<Short> shortCustomNumber = new CustomNumber<>((short) 2);
        CustomNumber<Integer> integerCustomNumber = new CustomNumber<>(2);
        CustomNumber<Long> longCustomNumber = new CustomNumber<>(2L);
        CustomNumber<Double> doubleCustomNumber = new CustomNumber<>(2.0);
        CustomNumber<Float> floatCustomNumber = new CustomNumber<>(2.0f);

        System.out.println(byteCustomNumber.pow(2));
        System.out.println(shortCustomNumber.pow(2));
        System.out.println(integerCustomNumber.pow(2));
        System.out.println(longCustomNumber.pow(2));
        System.out.println(doubleCustomNumber.pow(2));
        System.out.println(floatCustomNumber.pow(2));
    }
}
