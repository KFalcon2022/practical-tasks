package com.walking.lesson28_generics1.task1;

import com.walking.lesson28_generics1.task1.service.GenericNum;

/**
 * Создать обобщенный тип, принимающий в себя любого из наследников Number.
 * Создать метод, возводящий значение параметризованного типа в степень,
 * переданную параметром в метод.
 */
public class Main {
    public static void main(String[] args) {
        GenericNum<Integer> intNum = new GenericNum<>();
        intNum.setNum(11);
        System.out.println(intNum.getResult(3));

        GenericNum<Long> longNum = new GenericNum<>();
        longNum.setNum(654L);
        System.out.println(longNum.getResult(2));
    }
}
