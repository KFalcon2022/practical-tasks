package com.walking.lesson28_generics1.task1;

/**
 * Создать обобщенный тип, принимающий в себя любого из наследников Number.
 * Создать метод, возводящий значение параметризованного типа в степень,
 * переданную параметром в метод.
 */
import com.walking.lesson28_generics1.task1.model.GenNumber;
public class Main {
    public static void main(String[] args) {

        GenNumber<Integer> integer = new GenNumber<>(10);
        System.out.println(integer.calcPower(5));

        GenNumber<Double> doubleNumber = new GenNumber<>(10d);
        System.out.println(doubleNumber.calcPower(5));

    }
}
