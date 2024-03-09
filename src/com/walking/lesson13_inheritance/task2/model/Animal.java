package com.walking.lesson13_inheritance.task2.model;

public class Animal {
    private final String className;

    public Animal(String className) {
        this.className = className;
    }

    public String getClassName() {
        return className;
    }

    protected void sound() {
        switch (className) {
            case "Cat" -> System.out.println("meow");
            case "Dog" -> System.out.println("woof");
            case "Cow" -> System.out.println("moo");
        }
    }
}
