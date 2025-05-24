package com.walking.lesson25_nested_classes.task2.inner_class;

import com.walking.lesson25_nested_classes.task2.inner_class.model.Animal;

/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson14_polymorphism/task2">...</a>
 * используя внутренние классы.
 */
public class Main {
    public static void main(String[] args) {

        Main main = new Main();
        Animal[] animals = new Animal[]{main.new Cat(), main.new Cow(), main.new Dog()};

        soundAll(animals);
    }

    private static void soundAll(Animal[] animals) {
        for (Animal x : animals) {
            x.sound();
        }
    }


    private class Cat extends Animal{
        @Override
        public void sound() {
            System.out.println("Meow");
        }
    }

    private class Dog extends Animal {
        @Override
        public void sound() {
            System.out.println("Woof");
        }
    }

    private class Cow extends Animal {
        @Override
        public void sound() {
            System.out.println("Moo");
        }
    }
}
