package com.walking.lesson28_generics1.task1;

import com.walking.lesson28_generics1.task1.model.NumberExponentiation;

/**
 * Создать обобщенный тип, принимающий в себя любого из наследников Number.
 * Создать метод, возводящий значение параметризованного типа в степень,
 * переданную параметром в метод.
 */
public class Main {
    public static void main(String[] args) {
        NumberExponentiation<Integer> expInteger = new NumberExponentiation<>(5);
        NumberExponentiation<Byte> expByte = new NumberExponentiation<>((byte) 3);
        NumberExponentiation<Short> expShort = new NumberExponentiation<>((short) 14);

        System.out.println(expInteger.exponentiation(5));
        System.out.println(expByte.exponentiation(2));
        System.out.println(expShort.exponentiation(4));
    }
}
