package com.walking.lesson28_generics1.task1;

/**
 * Создать обобщенный тип, принимающий в себя любого из наследников Number.
 * Создать метод, возводящий значение параметризованного типа в степень,
 * переданную параметром в метод.
 */
public class Main {
    public static void main(String[] args) {
        NumDegree<Integer> n1 = new NumDegree<>(2);
        NumDegree<Short> n2 = new NumDegree<>((short)2);
        NumDegree<Double> n3 = new NumDegree<>(2.0);

        System.out.println(n1.doThis(3));
        System.out.println(n2.doThis(3));
        System.out.println(n3.doThis(4));
    }
}
