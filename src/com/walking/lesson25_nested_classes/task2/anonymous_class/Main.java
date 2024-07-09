package com.walking.lesson25_nested_classes.task2.anonymous_class;

import com.walking.lesson25_nested_classes.task2.anonymous_class.model.Animal;

/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson14_polymorphism/task2">...</a>
 * используя анонимные классы.
 */
public class Main {
    public static void main(String[] args) {
    Animal[] animals=new Animal[6];
    animals[0]=new Animal(){public void sound() {System.out.println("Meow");};};
    animals[1]=new Animal(){public void sound() {System.out.println("Moo");};};
    animals[2]=new Animal(){public void sound() {System.out.println("Moo");};};
    animals[3]=new Animal(){public void sound() {System.out.println("Woof");};};
    animals[4]=new Animal(){public void sound() {System.out.println("Woof");};};
    animals[5]=new Animal(){public void sound() {System.out.println("Meow");};};
    checkAnimals(animals);
    }

    public static void checkAnimals(Animal[] animals){
        for (Animal x:animals){
            x.sound();
        }
    }
}
