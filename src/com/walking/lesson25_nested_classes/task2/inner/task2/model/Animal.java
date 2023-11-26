package com.walking.lesson25_nested_classes.task2.inner.task2.model;

public class Animal {

    public Animal() {}

    public void sound() {
        System.out.println("Unknown animal!");
    }
    public class Cat extends Animal {
        @Override
        public void sound() {
            System.out.println("meow");
        }
    }
    public class Cow extends Animal {
        @Override
        public void sound() {
            System.out.println("moo");
        }
    }
    public class Dog extends Animal {
        @Override
        public void sound() {
            System.out.println("woof");
        }
    }

}
