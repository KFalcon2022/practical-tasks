package com.walking.lesson18_instanceof_getClass.task1_getClass;

import com.walking.lesson18_instanceof_getClass.model.Animal;
import com.walking.lesson18_instanceof_getClass.model.Cat;
import com.walking.lesson18_instanceof_getClass.model.Cow;
import com.walking.lesson18_instanceof_getClass.model.Dog;

/**
 * Реализовать задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson13_inheritance/task2">...</a>
 * используя getClass().
 */
public class Main {
    public static void main(String[] args) {
        Animal[] animals=new Animal[6];
        animals[0]=new Cat();
        animals[1]=new Cow();
        animals[2]=new Cow();
        animals[3]=new Dog();
        animals[4]=new Dog();
        animals[5]=new Cat();
        checkAnimals(animals);
    }
    public static void checkAnimals(Animal[] animals){
        for (Animal x:animals){
            if (x.getClass().equals(Cat.class)) ((Cat)x).Meow();
            if (x.getClass().equals(Dog.class)) ((Dog)x).Woof();
            if (x.getClass().equals(Cow.class)) ((Cow)x).Moo();
        }
    }
}
