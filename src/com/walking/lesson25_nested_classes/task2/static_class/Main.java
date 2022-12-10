package com.walking.lesson25_nested_classes.task2.static_class;

/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson14_polymorphism/task2">...</a>
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

    private static class Cat extends Animal {
        @Override
        public void sound() {
            System.out.println("meow");
        }
    }

    private static class Dog extends Animal {
        @Override
        public void sound() {
            System.out.println("woof");
        }
    }

    private static class Cow extends Animal {
        @Override
        public void sound() {
            System.out.println("moo");
        }
    }
}
