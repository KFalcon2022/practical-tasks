package com.walking.lesson25_nested_classes.task2.static_class;

import com.walking.lesson25_nested_classes.task2.static_class.model.Animal;
import com.walking.lesson25_nested_classes.task2.static_class.model.Animal.Pet;

/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson14_polymorphism/task2">...</a>
 * используя статические вложенные классы.
 */
public class Main {
    public static void main(String[] args) {
    Animal[] animals=new Animal[6];
    animals[0]=new Animal(Pet.Cat);
    animals[1]=new Animal(Pet.Cow);
    animals[2]=new Animal(Pet.Cow);
    animals[3]=new Animal(Pet.Dog);
    animals[4]=new Animal(Pet.Dog);
    animals[5]=new Animal(Pet.Cat);
    checkAnimals(animals);
    }

    public static void checkAnimals(Animal[] animals){
        for (Animal x:animals){
            x.sound();
        }
    }
}
