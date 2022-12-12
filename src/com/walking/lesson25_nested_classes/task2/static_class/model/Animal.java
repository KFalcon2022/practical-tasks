package com.walking.lesson25_nested_classes.task2.static_class.model;

public class Animal {
    public void sound() {
        System.out.println("Unknown animal");
    }

    public static class Cat extends Animal {
        @Override
        public void sound() {
            System.out.println("meow");
        }
    }

    public static class Cow extends Animal {
        @Override
        public void sound() {
            System.out.println("moo");
        }
    }

    public static class Dog extends Animal {
        @Override
        public void sound() {
            System.out.println("woof");
        }
    }
}
