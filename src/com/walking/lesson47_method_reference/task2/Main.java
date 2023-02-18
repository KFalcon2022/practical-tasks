package com.walking.lesson47_method_reference.task2;

import java.util.List;

/**
 * Реализуйте Задачу 1, обернув метод выведения записи в консоль
 * (System.out.println()) в собственный статический метод.
 */
public class Main {
    public static void main(String[] args) {
        List.of(1, 2, 3, 4, 5, 10)
                .forEach(Main::print);
    }

    private static void print(Object o) {
        System.out.println(o);
    }
}
