package com.walking.lesson25_nested_classes.task2.nested_class;

import com.walking.lesson25_nested_classes.task2.nested_class.model.Animal;
import com.walking.lesson25_nested_classes.task2.nested_class.model.Cat;
import com.walking.lesson25_nested_classes.task2.nested_class.model.Cow;
import com.walking.lesson25_nested_classes.task2.nested_class.model.Dog;

/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson14_polymorphism/task2">...</a>
 * используя анонимные классы.
 */
public class Main {
    public static void main(String[] args) {
        Animal[] animals = new Animal[]{new Animal(), new Animal(), new Animal()};

        soundAll(animals);
    }

    private static void soundAll(Animal[] animals) {
        for (Animal animal : animals) {
            animal.sound();
        }
    }
}
