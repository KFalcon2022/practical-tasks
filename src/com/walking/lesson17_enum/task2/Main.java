package com.walking.lesson17_enum.task2;

public class Main {
    public static void main(String[] args) {

        Animal[] animals = new Animal[] {Animal.CAT, Animal.COW, Animal.DOG, Animal.CAT};
        for (Animal animal : animals) {
            System.out.println(animal.sound());
        }
    }
}
