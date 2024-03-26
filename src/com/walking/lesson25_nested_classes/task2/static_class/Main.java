package com.walking.lesson25_nested_classes.task2.static_class;

import com.walking.lesson25_nested_classes.task2.static_class.model.Animal;
import com.walking.lesson25_nested_classes.task2.static_class.model.Voiceable;

/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson14_polymorphism/task2">...</a>
 * используя статические вложенные классы.
 */
public class Main {
    public static void main(String[] args) {
        Voiceable[] voiceables = new Voiceable[]{new Animal.Cat(), new Animal.Dog(), new Animal.Cow()};

        for (Voiceable voiceable : voiceables) {
            System.out.println(voiceable.sound());
        }
    }
}
