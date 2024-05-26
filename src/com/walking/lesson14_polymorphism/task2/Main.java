package com.walking.lesson14_polymorphism.task2;

import com.walking.lesson14_polymorphism.task2.animal.Animal;
import com.walking.lesson14_polymorphism.task2.animal.Cat;
import com.walking.lesson14_polymorphism.task2.animal.Cow;
import com.walking.lesson14_polymorphism.task2.animal.Dog;

public class Main {
    public static void main(String[] args) {
        Animal[] animals = new Animal[]{new Cat(), new Dog(), new Cow()};
        System.out.println(roar(animals));
    }

    protected static String roar(Animal[] animals) {
        String say = "";
        for (Animal x : animals) {
            say += x.sound() + '\n';
        }
        return say;
    }
}
