package com.walking.lesson25_nested_classes.task1.static_class;

/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson16_abstract_class_interface/task1_interface">...</a>
 * используя статические вложенные классы.
 */
public class Main {
    public static void main(String[] args) {
        Animal[] animals = new Animal[]{new Cat(), new Dog(), new Cow()};
        soundAll(animals);
    }

    private static void soundAll(Animal[] animals) {
        for (Animal animal : animals) {
            animal.sound();
        }
    }

    public static abstract class Animal {
        public abstract void sound();
    }

    public static class Dog extends Animal {
        public void sound() {
            System.out.println("woof");
        }
    }

    public static class Cat extends Animal {
        public void sound() {
            System.out.println("meow");
        }
    }

    public static class Cow extends Animal {
        public void sound() {
            System.out.println("moo");
        }
    }
}
