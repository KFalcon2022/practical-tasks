package com.walking.lesson25_nested_classes.task1.static_class;

/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson16_abstract_class_interface/task1_interface">...</a>
 * используя статические вложенные классы.
 */
public class Main {
    public static void main(String[] args) {
        soundAll(new Animal[] {new Cat(), new Dog(), new Cow()});
    }

    private static void soundAll (Animal [] animals) {
        for (Animal a : animals) {
            a.sound();
        }
    }

    private static class Cat extends Animal {
        @Override
        public void sound() {
            System.out.println("meeow");
        }
    }

    private static class Cow extends Animal {
        @Override
        public void sound() {
            System.out.println("mooo");
        }
    }

    private static class Dog extends Animal {
        @Override
        public void sound() {
            System.out.println("woof");
        }
    }
}
