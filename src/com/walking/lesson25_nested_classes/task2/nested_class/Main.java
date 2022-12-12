package com.walking.lesson25_nested_classes.task2.nested_class;

import com.walking.lesson25_nested_classes.task2.nested_class.model.Animal;


/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson14_polymorphism/task2">...</a>
 * используя анонимные классы.
 */
public class Main {
    public static void main(String[] args) {
            Animal[] animals = new Animal[]{new Animal().new Cat(), new Animal().new Dog(), new Animal().new Cow()};

            soundAll(animals);
        }

        private static void soundAll(Animal[] animals) {
            for (Animal animal : animals) {
                animal.sound();
            }
        }

}
