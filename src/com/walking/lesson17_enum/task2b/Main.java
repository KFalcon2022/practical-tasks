package com.walking.lesson17_enum.task2b;

public class Main {

    public static void main(String[] args) {
        
        Animal[] animals = {
            Animal.CAT,
            Animal.DOG,
            Animal.CAT,
            Animal.COW,
            Animal.CAT
        };
        
        for (Animal animal: animals){
            System.out.println(animal.talk());
        }

    }
} 