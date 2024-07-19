package com.walking.lesson25_nested_classes.task2.anonymous_class;

import com.walking.lesson25_nested_classes.task2.anonymous_class.model.Animal;
import com.walking.lesson25_nested_classes.task2.anonymous_class.model.Voiceable;

/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson14_polymorphism/task2">...</a>
 * используя анонимные классы.
 */
public class Main {
    public static void main(String[] args) {
        Animal cat = new Animal(new Voiceable() {
            @Override
            public String sound() {
                return "meow";
            }
        });

        Animal dog = new Animal(new Voiceable() {
            @Override
            public String sound() {
                return "woof";
            }
        });

        Animal cow = new Animal(new Voiceable() {
            @Override
            public String sound() {
                return "moo";
            }
        });

        Animal[] animals = new Animal[]{cat, dog, cow};

        for (Animal animal : animals) {
            System.out.println(" I'm speak " + animal.getVoiceable().sound() + ".");
        }
    }
}
