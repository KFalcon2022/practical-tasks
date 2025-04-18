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
        Animal[] animals = new Animal[]{new Cat(), new Cow(), new Dog()};

        soundAll(animals);
    }

    private static void soundAll(Animal[] animals) {
        for (Animal x : animals) {
            if ("meow".equals(x.sound()))
                System.out.println(new Cat().sound());
            else if ("moo".equals(x.sound()))
                System.out.println(new Cow().sound());
            else if ("woof".equals(x.sound()))
                System.out.println(new Dog().sound());
            else
                System.out.println("Unknown animal!");
        }
    }
}
