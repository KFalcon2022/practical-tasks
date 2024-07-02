package com.walking.lesson28_generics1.task1;

import com.walking.lesson28_generics1.task1.model.Power;

/**
 * Создать обобщенный тип, принимающий в себя любого из наследников Number.
 * Создать метод, возводящий значение параметризованного типа в степень,
 * переданную параметром в метод.
 */
public class Main {
    public static void main(String[] args) {
        Power<Short> power=new Power<>((short)20);
        System.out.println(power.getPower(3));
    }
}
