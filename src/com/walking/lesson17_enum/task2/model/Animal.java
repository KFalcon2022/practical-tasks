package com.walking.lesson17_enum.task2.model;

public enum Animal {
    CAT {
        public void sound() {
            System.out.println("meow");
        }
    },
    DOG {
        public void sound() {
            System.out.println("woof");
        }
    },
    COW {
        public void sound() {
            System.out.println("moo");
        }
    };

    public abstract void sound();
}