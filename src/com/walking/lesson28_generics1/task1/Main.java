package com.walking.lesson28_generics1.task1;

/**
 * Создать обобщенный тип, принимающий в себя любого из наследников Number.
 * Создать метод, возводящий значение параметризованного типа в степень,
 * переданную параметром в метод.
 */
public class Main {
    public static void main(String[] args) {

        CheckNumber<Integer> m1 = new CheckNumber<>(2);
        System.out.println(m1.doExtent(3));

        CheckNumber<Double> m2 = new CheckNumber<>(2d);
        System.out.println(m2.doExtent(3));

        CheckNumber<Long> m3 = new CheckNumber<>(2l);
        System.out.println(m3.doExtent(3));

        CheckNumber<Float> m4 = new CheckNumber<>(2f);
        System.out.println(m4.doExtent(3));

    }
}
