package com.walking.lesson20_exceptions.task3;

import com.walking.lesson20_exceptions.task2.InputValidationException;
import com.walking.lesson20_exceptions.task3.model.*;;

/**
 * Реализовать задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson13_inheritance/task2">...</a>
 * используя instanceof.
 */
public class Main {
    public static void main(String[] args) {
        Animal[] animals = new Animal[]{new Cat(), new Dog(), new Cow(), null};
        soundAll(animals);
    }

    private static void soundAll(Animal[] animals) {
        for(int i = 0; i < animals.length; i++){
            if(animals[i] == null)
            {
                throw new ArrayValidationException("Array has null element. Element`s index: ",i);
            }
            sound(animals[i]);
        }
    }

    private static void sound(Animal animal) {
        if (animal instanceof Cat cat) {
            cat.meow();
        } else if (animal instanceof Dog dog) {
            dog.woof();
        } else if (animal instanceof Cow cow) {
            cow.moo();
        } else {
            throw new InputValidationException("Unknown animal");
        }

    }

}
