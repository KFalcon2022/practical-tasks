package com.walking.lesson28_generics1.task1;

import com.walking.lesson28_generics1.task1.model.NumClass;

/**
 * Создать обобщенный тип, принимающий в себя любого из наследников Number.
 * Создать метод, возводящий значение параметризованного типа в степень,
 * переданную параметром в метод.
 */
public class Main {
    public static void main(String[] args) {
        NumClass<Double> numClass = new NumClass<>(3.3);
        System.out.println(numClass.toPow(3));
    }
}
