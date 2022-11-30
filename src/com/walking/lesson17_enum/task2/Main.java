package com.walking.lesson17.task2;

public class Main {

    public static void main(String[] args) {
        
        Animal[] animals = {
            new Cat("Vasya", 5)
            , new Dog("Sharik", 6)
            , new Cat("Musya", 3)
            , new Cow("Nochka", 3)
        };
        
        for (Animal animal: animals){
            animal.printInfo();
            
            switch (animal.specie){
                case CAT:
                    ((Cat)animal).meow();
                    break;

                case DOG:
                    ((Dog)animal).woof();
                    break;

                case COW:
                    ((Cow)animal).moo();
                    break;

                default:
                    animal.talk("***");
            }
        }
    }
} 