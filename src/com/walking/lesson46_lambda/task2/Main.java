package com.walking.lesson46_lambda.task2;

import com.walking.lesson46_lambda.task2.model.Animal;
import com.walking.lesson46_lambda.task2.model.Cat;
import com.walking.lesson46_lambda.task2.model.Cow;
import com.walking.lesson46_lambda.task2.model.Dog;

import java.util.List;

/**
 * Знакомимся с функциональным интерфейсом Consumer.
 * Используя реализацию Задачи 3 из урока 16 по ссылке:
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson16_abstract_class_interface/task3">...</a>
 * замените массив на список,
 * а цикл for – на вызов метода forEach(),
 * который доступен для всех наследников Iterable.
 * Он теперь будет вашим другом и надежным соратником:)
 */
public class Main {
    public static void main(String[] args) {
        List<Animal> animals = List.of(new Cat(), new Dog(), new Cow());

        soundAll(animals);
    }

    private static void soundAll(List<Animal> animals) {
        animals.forEach(Animal::sound);
    }
}
