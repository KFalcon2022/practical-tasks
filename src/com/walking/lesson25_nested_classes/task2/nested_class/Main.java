package com.walking.lesson25_nested_classes.task2.nested_class;

import com.walking.lesson25_nested_classes.task2.nested_class.model.Animal;
import com.walking.lesson25_nested_classes.task2.nested_class.model.Voiceable;
/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson14_polymorphism/task2">...</a>
 * используя внутренние классы.
 */
public class Main {
    public static void main(String[] args) {
        Animal animal = new Animal();

        Voiceable[] voiceables = new Voiceable[]{animal.new Cat(), animal.new Dog(), animal.new Cow()};

        for (Voiceable voiceable : voiceables) {
            System.out.println(voiceable.sound());
        }
    }
}
