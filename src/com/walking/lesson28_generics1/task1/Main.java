package com.walking.lesson28_generics1.task1;

/**
 * Создать обобщенный тип, принимающий в себя любого из наследников Number.
 * Создать метод, возводящий значение параметризованного типа в степень,
 * переданную параметром в метод.
 */
public class Main {
    public static void main(String[] args) {
        Number1<Integer> number1 = new Number1<>(5);
        System.out.println(number1.getPow(2));
    }
}
