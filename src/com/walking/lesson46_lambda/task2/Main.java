package com.walking.lesson46_lambda.task2;

import com.walking.lesson46_lambda.task2.Model.Animal;
import com.walking.lesson46_lambda.task2.Model.Cat;
import com.walking.lesson46_lambda.task2.Model.Cow;
import com.walking.lesson46_lambda.task2.Model.Dog;

import java.util.ArrayList;
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
        List<Animal> animals = new ArrayList<>();

        animals.add(new Cat());
        animals.add(new Dog());
        animals.add(new Cow());

        soundAll(animals);
    }

    private static void soundAll(List<Animal> animals) {
        animals.forEach(Animal::sound);
    }
}
