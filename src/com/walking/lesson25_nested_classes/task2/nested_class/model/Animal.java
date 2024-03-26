package com.walking.lesson25_nested_classes.task2.nested_class.model;

public class Animal implements Voiceable {
    @Override
    public String sound() {
        throw new RuntimeException("unknown animal");
    }

    public class Cat implements Voiceable {
        public final static String CAT_SOUND_MESSAGE = "meow";

        @Override
        public String sound() {
            return CAT_SOUND_MESSAGE;
        }
    }

    public class Dog implements Voiceable {
        public final static String DOG_SOUND_MESSAGE = "woof";

        @Override
        public String sound() {
            return DOG_SOUND_MESSAGE;
        }
    }

    public class Cow implements Voiceable {
        public final static String COW_SOUND_MESSAGE = "moo";

        @Override
        public String sound() {
            return COW_SOUND_MESSAGE;
        }
    }
}
