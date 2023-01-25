package com.walking.lesson17_enum.task2.model;

public enum Animal {
    DOG() {
        public String sound() {
            return "Woof";
        }
    },
    CAT() {
        public String sound() {
            return "Meow";
        }
    },
    COW() {
        public String sound() {
            return "moo";
        }
    };

    public abstract String sound();
}
