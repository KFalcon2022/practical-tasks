package com.walking.lesson47_method_reference.task2;

import java.util.ArrayList;
import java.util.Random;

/**
 * Реализуйте Задачу 1, обернув метод выведения записи в консоль
 * (System.out.println()) в собственный статический метод.
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> digits = new ArrayList<>();
        Random random = new Random();
        for (int i=0;i<10;i++){
            digits.add(random.nextInt(1000));
        }
        digits.forEach(Main::print);
    }
    private static void print(Integer digit){
        System.out.println(digit);
    }
}
