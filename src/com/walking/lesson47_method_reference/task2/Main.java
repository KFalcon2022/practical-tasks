package com.walking.lesson47_method_reference.task2;

import java.util.List;

/**
 * Реализуйте Задачу 1, обернув метод выведения записи в консоль
 * (System.out.println()) в собственный статический метод.
 */
public class Main {
    public static void main(String[] args) {
        List.of(2, 34, 5, 7, 13, 18, 9, 27)
                .forEach(Main::printer);
    }

    public static void printer(Object o) {
        System.out.println(o);
    }
}
