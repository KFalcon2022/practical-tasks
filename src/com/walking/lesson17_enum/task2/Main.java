package com.walking.lesson17_enum.task2;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        Animal[] a = new Animal[]{Animal.Dog, Animal.Cat, Animal.Cow, Animal.Dog, Animal.Cat};
        getVoice(a);
    }

    private static void getVoice(Animal[] a) {

        for(int i = 0; i < a.length; ++i) {
            a[i].sound();
        }

    }
}
