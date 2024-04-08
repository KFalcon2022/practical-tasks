package com.walking.lesson28_generics1.task1;

import com.walking.lesson28_generics1.task1.model.Generic;

/**
 * Создать обобщенный тип, принимающий в себя любого из наследников Number.
 * Создать метод, возводящий значение параметризованного типа в степень,
 * переданную параметром в метод.
 */
public class Main {
    public static void main(String[] args) {
        Generic<Integer> generic1= new Generic<>(10);
        System.out.println(generic1.pow(5));
    }
}
