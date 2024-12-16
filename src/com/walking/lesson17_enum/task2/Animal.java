package com.walking.lesson17_enum.task2;

public enum Animal {
    CAT() {
        @Override
        void sound() {
            System.out.println("meow");
        }
    },
    DOG() {
        @Override
        void sound() {
            System.out.println("woof");
        }
    },
    COW() {
        @Override
        void sound() {
            System.out.println("moo");
        }
    };

    void sound() {
        System.out.println("Undefined");
    }
}