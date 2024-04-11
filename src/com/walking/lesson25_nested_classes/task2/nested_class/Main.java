package com.walking.lesson25_nested_classes.task2.nested_class;


/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson14_polymorphism/task2">...</a>
 * используя внутренние классы.
 */
public class Main {
    public static void main(String[] args) {
        Animal[] animals = new Animal[10];
        initAnimalsArray(animals);
        animalSound(animals);
    }

    private static void initAnimalsArray(Animal[] animals) {
        Main main = new Main();
        for (int i = 0; i < animals.length; i++) {
            if (i % 2 == 0) {
                animals[i] = main.new Cat();
            } else if (i % 3 == 0) {
                animals[i] = main.new Dog();
            } else {
                animals[i] = main.new Cow();
            }
        }
    }

    private static void animalSound(Animal[] animals) {
        for (Animal animal : animals) {
            animal.sound();
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
            System.out.println("moo");
        }
    }
}
