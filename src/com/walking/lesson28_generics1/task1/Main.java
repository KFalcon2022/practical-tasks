package com.walking.lesson28_generics1.task1;

import com.walking.lesson28_generics1.task1.service.GenericNumber;

/**
 * Создать обобщенный тип, принимающий в себя любого из наследников Number.
 * Создать метод, возводящий значение параметризованного типа в степень,
 * переданную параметром в метод.
 */
public class Main {
    public static void main(String[] args) {
        GenericNumber<Integer> intNum = new GenericNumber<>();
        intNum.setNum(11);
        System.out.println(intNum.getPow(3));

        GenericNumber<Long> longNum = new GenericNumber<>();
        longNum.setNum(654L);
        System.out.println(longNum.getPow(2));
    }
}
