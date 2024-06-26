package com.walking.lesson14_polymorphism.task2;

import com.walking.lesson14_polymorphism.task2.model.Animal;
import com.walking.lesson14_polymorphism.task2.model.Cat;
import com.walking.lesson14_polymorphism.task2.model.Cow;
import com.walking.lesson14_polymorphism.task2.model.Dog;

/**
 * Используя новые знания, упростите реализацию задачи 2 из предыдущего урока:
 * <a href="https://telegra.ph/Nasledovanie-Klyuchevoe-slovo-extends-i-ispolzovanie-protected-Klyuchevoe-slovo-super-Privedenie-ssylochnyh-tipov-11-23">...</a>
 * Допустимо использовать метод sound() вместо woof(), meow() и moo().
 * Метод sound() допустимо сделать публичным.
 * <p>
 * Использовать отдельное поле для хранения выводимой строки — недопустимо:)
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
            x.sound();
        }
    }
}
