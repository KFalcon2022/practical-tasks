package com.walking.lesson17_enum.task2;

public enum Animal {
    Cat() {
        public void sound() {
            System.out.println("meow");
        }
    },
    Dog() {
        public void sound() {
            System.out.println("woof");
        }
    },
    Cow() {
        public void sound() {
            System.out.println("moo");
        }
    };
    Animal() {
    }

    protected abstract void sound();
}