package com.walking.lesson46.Task2;

import com.walking.lesson16_abstract_class_interface.task3.Animal;
import com.walking.lesson16_abstract_class_interface.task3.Cat;
import com.walking.lesson16_abstract_class_interface.task3.Cow;
import com.walking.lesson16_abstract_class_interface.task3.Dog;

import java.util.List;


public class Main {
    public static void main(String[] args) {
        List<Animal> animals = List.of(
            new Cat("Васька", 5),
            new Dog("Жучка", 8),
            new Cow("Ночка", 10),
            new Dog("Полкан", 12)
        );

        animals.forEach(a -> System.out.println(a.talk()));
    }
}