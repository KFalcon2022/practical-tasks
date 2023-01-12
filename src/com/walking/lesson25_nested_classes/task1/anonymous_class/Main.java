package com.walking.lesson25_nested_classes.task1.anonymous_class;

import com.walking.lesson25_nested_classes.task1.anonymous_class.model.Animal;

/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson16_abstract_class_interface/task1_interface">...</a>
 * используя анонимные классы.
 */
public class Main {
    public static void main(String[] args) {
        Animal[] animals = new Animal[]{
            new Animal() {
            @Override
            public void sound() {
                System.out.println("woof");;
            }
        }, new Animal() {
            @Override
            public void sound() {
                System.out.println("meow");
            }
        }, new Animal() {
            @Override
            public void sound() {
                System.out.println("moo");
            }
        }};

        soundAll(animals);
    }

    private static void soundAll(Animal[] animals) {
        for (Animal animal : animals) {
            animal.sound();
        }
    }
}
