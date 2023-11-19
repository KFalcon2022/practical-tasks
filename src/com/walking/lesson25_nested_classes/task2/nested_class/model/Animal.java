package com.walking.lesson25_nested_classes.task2.nested_class.model;

public class Animal {

    public Animal() {
    }

    public void sound() {
        throw new RuntimeException("Unknown animal");
    }

    public class Cat extends Animal {
        @Override
        public void sound() {
            System.out.println("meow");
        }
    }

    public class Dog extends Animal {
        @Override
        public void sound() {
            System.out.println("woof");
        }
    }

    public class Cow extends Animal {
        @Override
        public void sound() {
            System.out.println("moo");
        }
    }
}