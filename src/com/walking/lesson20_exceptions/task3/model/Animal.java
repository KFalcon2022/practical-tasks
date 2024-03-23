package com.walking.lesson20_exceptions.task3.model;

public class Animal {
    protected void sound(Animal animal) {
        if (animal instanceof Cat) {
            System.out.println("meow");
        } else if (animal instanceof Dog) {
            System.out.println("woof");
        } else if (animal instanceof Cow) {
            System.out.println("moo");
        }
    }
}
