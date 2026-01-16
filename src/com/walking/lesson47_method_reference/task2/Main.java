package com.walking.lesson47_method_reference.task2;

import com.walking.lesson47_method_reference.task2.model.*;

import java.util.List;

/**
 * Реализуйте Задачу 1, обернув метод выведения записи в консоль
 * (System.out.println()) в собственный статический метод.
 */
public class Main {
    public static void main(String[] args) {
        print(List.of(new Cat(), new Dog(), new Cow()));
    }

    private static void print(List<Animal> animals) {
        animals.forEach(System.out::println);
    }
}
