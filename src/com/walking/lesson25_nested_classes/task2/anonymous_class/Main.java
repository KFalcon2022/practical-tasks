package com.walking.lesson25_nested_classes.task2.anonymous_class;

import com.walking.lesson25_nested_classes.task2.anonymous_class.model.Animal;

/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson14_polymorphism/task2">...</a>
 * используя анонимные классы.
 */
public class Main {
    public static void main(String[] args) {
            Animal[] animals = new Animal[3];
            animals[0] = new Animal() {
                @Override
                public void sound() {
                    System.out.println("moo");
                }
            };
            animals[1] = new Animal() {
                @Override
                public void sound() {
                    System.out.println("meow");
                }
            };
            animals[2] = new Animal() {
                @Override
                public void sound() {
                    System.out.println("woof");
                }
            };

            soundAll(animals);
        }

        private static void soundAll(Animal[] animals) {
            for (Animal animal : animals) {
                animal.sound();
            }
        }

}
