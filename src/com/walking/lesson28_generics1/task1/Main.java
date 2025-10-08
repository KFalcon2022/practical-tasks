package com.walking.lesson28_generics1.task1;

/**
 * Создать обобщенный тип, принимающий в себя любого из наследников Number.
 * Создать метод, возводящий значение параметризованного типа в степень,
 * переданную параметром в метод.
 */
public class Main {
    public static void main(String[] args) {
        PowOfNumber<Integer> d1 = new PowOfNumber<>(4);
        Double result = d1.sqr(3.0);

        System.out.println(result);
    }
}
