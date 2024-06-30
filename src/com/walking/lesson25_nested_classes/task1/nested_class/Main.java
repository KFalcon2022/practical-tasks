package com.walking.lesson25_nested_classes.task1.nested_class;

/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson16_abstract_class_interface/task1_interface">...</a>
 * используя внутренние классы.
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Animal [] animals = new Animal[] {main.new Cat(), main.new Dog(), main.new Cow()};
        soundAll(animals);

    }

    private static void soundAll (Animal [] animals) {
        for (Animal a : animals) {
            a.sound();
        }
    }

    private class Cat extends Animal {
        @Override
        public void sound() {
            System.out.println("meow");
        }
    }

    private class Dog extends Animal {
        @Override
        public void sound() {
            System.out.println("woof");
        }
    }

    private class Cow extends Animal {
        @Override
        public void sound() {
            System.out.println("mooo");
        }
    }
}
