package com.walking.lesson25_nested_classes.task1.anonymous_class;

/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson16_abstract_class_interface/task1_interface">...</a>
 * используя анонимные классы.
 */
public class Main {
    public static void main(String[] args) {
        Animal cat = new Animal() {
            @Override
            public void sound() {
                System.out.println("meow");
            }
        };

        Animal dog = new Animal() {
            @Override
            public void sound() {
                System.out.println("woof");
            }
        };

        Animal cow = new Animal() {
            @Override
            public void sound() {
                System.out.println("mooo");
            }
        };

        Animal [] animals = new Animal[] {cow, cat, dog};
        soundAll(animals);
    }

    private static void soundAll (Animal[] animals) {
        for (Animal a : animals) {
            a.sound();
        }
    }
}
