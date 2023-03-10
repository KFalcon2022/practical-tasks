package com.walking.lesson25_nested_classes.task2.nested_class;

import com.walking.lesson25_nested_classes.task2.nested_class.model.Animal;

/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson14_polymorphism/task2">...</a>
 * используя анонимные классы.
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Animal cat = main.new Cat();
        Animal cow = main.new Cow();
        Animal dog = main.new Dog();

        Animal[] animals = new Animal[]{cat, cow, dog};

        soundAll(animals);
    }

    private static void soundAll(Animal[] animals) {
        for (Animal animal : animals) {
            animal.sound();
        }
    }

    public class Cat extends Animal{
        @Override
        public void sound() {
            System.out.println("meow");
        }
    }

    public class Cow extends Animal{
        @Override
        public void sound() {
            System.out.println("moo");
        }
    }

    public class Dog extends Animal{
        @Override
        public void sound() {
            System.out.println("woof");
        }
    }

}
