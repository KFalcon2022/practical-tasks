package com.walking.lesson25_nested_classes.task2.anonymous_class;

import com.walking.lesson25_nested_classes.task2.anonymous_class.model.Animal;

/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson14_polymorphism/task2">...</a>
 * используя анонимные классы.
 */
public class Main {
    public static void main(String[] args) {
        Animal cat = new Animal(){
            @Override
            public void sound(){
                System.out.println("meow");
            }
        };

        Animal cow = new Animal(){
            @Override
            public void sound(){
                System.out.println("moo");
            }
        };

        Animal dog = new Animal(){
            @Override
            public void sound(){
                System.out.println("woof");
            }
        };

        Animal[] animals = new Animal[]{cat, dog, cow};

        soundAll(animals);
    }

    private static void soundAll(Animal[] animals) {
        for (Animal animal : animals) {
            animal.sound();
        }
    }
}
