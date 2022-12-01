package com.walking.lesson16_abstract_class_interface.task3;

public class Main {

    public static void main(String[] args) {
        Animal[] a = new Animal[]{new Dog("Dog"), new Cat("Cat"), new Cow("Cow"), new Dog("Dog"), new Cat("Cat")};
        getVoice(a);
    }

    private static void getVoice(Animal[] a) {

        for(Animal animal : a) animal.voice();

    }
}
