package com.walking.lesson28_generics1.task1;

import com.walking.lesson28_generics1.task1.model.NumberToPower;

/**
 * Создать обобщенный тип, принимающий в себя любого из наследников Number.
 * Создать метод, возводящий значение параметризованного типа в степень,
 * переданную параметром в метод.
 */
public class Main {
    public static void main(String[] args) {
        NumberToPower<Double> doubleNumberToPower = new NumberToPower<>(2.0);

        System.out.println( doubleNumberToPower.Pow(5));

        NumberToPower<Integer> integerNumberToPower = new NumberToPower<>(50);

        System.out.println(integerNumberToPower.Pow(2));
    }
}
