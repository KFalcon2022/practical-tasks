package com.walking.lesson25_nested_classes.task2.static_class.model;

public class Animal {

    public Animal() {
    }

    public void sound() {
        throw new RuntimeException("Unknown animal");
    }

    public static class Cat extends Animal {
        @Override
        public void sound() {
            System.out.println("meow");
        }
    }

    public static class Dog extends Animal {
        @Override
        public void sound() {
            System.out.println("woof");
        }
    }

    public static class Cow extends Animal {
        @Override
        public void sound() {
            System.out.println("moo");
        }
    }
}