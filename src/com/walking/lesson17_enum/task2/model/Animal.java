package com.walking.lesson17_enum.task2.model;

public enum Animal {
    CAT {
        @Override
        public void sound() {
            System.out.println("meow");
        }
    },
    DOG {
        @Override
        public void sound() {
            System.out.println("woof");
        }
    },
    COW {
        @Override
        public void sound() {
            System.out.println("moo");
        }
    };

    public abstract void sound();
}
