package com.walking.lesson47_method_reference.task1;

import java.util.ArrayList;
import java.util.Random;

/**
 * Создайте произвольный список элементов.
 * Выведите каждый из элементов в консоль.
 * Параметр forEach() опишите как method reference.
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> digits = new ArrayList<>();
        Random random = new Random();
        for (int i=0;i<10;i++){
            digits.add(random.nextInt(1000));
        }

        digits.forEach(System.out::println);
    }
}
