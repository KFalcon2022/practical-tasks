package com.walking.lesson25_nested_classes.task2.anonymous_class;


import com.walking.lesson25_nested_classes.task2.anonymous_class.model.Animal;

/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson14_polymorphism/task2">...</a>
 * используя анонимные классы.
 */
public class Main {
    public static void main(String[] args) {
        Animal[] animals = {cat(), dog(), cow()};
        soundAll(animals);
    }

    private static void soundAll(Animal[] animals) {
        for (Animal animal : animals) {
            animal.sound();
        }
    }

    private static Animal cat() {
        return new Animal() {
            @Override
            public void sound() {
                System.out.println("мяу");
            }
        };
    }

    private static Animal dog() {
        return new Animal() {
            @Override
            public void sound() {
                System.out.println("гав");
            }
        };
    }

    private static Animal cow() {
        return new Animal() {
            @Override
            public void sound() {
                System.out.println("муу");
            }
        };
    }
}
