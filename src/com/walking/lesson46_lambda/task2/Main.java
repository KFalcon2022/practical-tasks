package com.walking.lesson46_lambda.task2;

import com.walking.lesson16_abstract_class_interface.task3.animals.Animal;
import com.walking.lesson16_abstract_class_interface.task3.animals.Cat;
import com.walking.lesson16_abstract_class_interface.task3.animals.Cow;
import com.walking.lesson16_abstract_class_interface.task3.animals.Dog;

import java.util.ArrayList;
import java.util.function.Consumer;

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
        Cat cat1 = new Cat("Barsik");
        //cat1.meow();

        Dog dog1 = new Dog("Sharik");
        //dog1.woof();

        Cow cow1 = new Cow("Burenka");
        Dog dog2=new Dog("Amur");

        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(cat1);
        animals.add(dog1);
        animals.add(cow1);
        animals.add(dog2);
        soundAll(animals);
    }
    private static void soundAll(ArrayList<Animal> animals){
        animals.forEach(t->t.getAnimalSound());
        System.out.println("\n");
        animals.forEach(s-> System.out.println("Name: "+s.getNAME()));
    }

}
