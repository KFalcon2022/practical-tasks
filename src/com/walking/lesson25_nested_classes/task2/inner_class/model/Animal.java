package com.walking.lesson25_nested_classes.task2.inner_class.model;

public class Animal {

    public class Cat implements AnimalSound {
        public static final String CAT_SOUND = "Meow";

        @Override
        public String getSound() {
            return CAT_SOUND;
        }

        @Override
        public void sound() {
            System.out.println(CAT_SOUND);
        }
    }

    public class Dog implements AnimalSound {
        public static final String DOG_SOUND = "Woof";

        @Override
        public String getSound() {
            return DOG_SOUND;
        }

        @Override
        public void sound() {
            System.out.println(DOG_SOUND);
        }
    }

    public class Cow implements AnimalSound {
        public static final String COW_SOUND = "Moo";

        @Override
        public String getSound() {
            return COW_SOUND;
        }

        @Override
        public void sound() {
            System.out.println(COW_SOUND);
        }
    }
}
