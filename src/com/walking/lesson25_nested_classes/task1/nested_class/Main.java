package com.walking.lesson25_nested_classes.task1.nested_class;

/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson16_abstract_class_interface/task1_interface">...</a>
 * используя внутренние классы.
 */
public class Main {
    public static void main(String[] args) {
        Main externalClass = new Main();
        Animal[] animals = new Animal[]{externalClass.new Cat(), externalClass.new Dog(), externalClass.new Cow()};
        soundAll(animals);
    }

    private static void soundAll(Animal[] animals) {
        for (Animal animal : animals) {
            animal.sound();
        }
    }

    private abstract class Animal {
        public abstract void sound();
    }

    public class Dog extends Animal {
        public void sound() {
            System.out.println("woof");
        };
    }
    public class Cat extends Animal {
        public void sound() {
            System.out.println("meow");
        };
    }
    public class Cow extends Animal {
        public void sound() {
            System.out.println("moo");
        };
    }
}
