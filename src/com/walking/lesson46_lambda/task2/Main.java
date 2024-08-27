package com.walking.lesson46_lambda.task2;

import java.util.LinkedList;
import java.util.function.Consumer;

import com.walking.lesson46_lambda.task2.model.Animal;
import com.walking.lesson46_lambda.task2.model.Cat;
import com.walking.lesson46_lambda.task2.model.Cow;
import com.walking.lesson46_lambda.task2.model.Dog;

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
        LinkedList<Animal> animals=new LinkedList<>();
        animals.add(new Cat());
        animals.add(new Dog());
        animals.add(new Cow());

        Consumer<Animal> soundAll=x->x.sound();

        for (Animal animal : animals) {
            soundAll.accept(animal);
        }
    }
}
