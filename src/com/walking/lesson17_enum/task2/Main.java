package com.walking.lesson17_enum.task2;

/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson14_polymorphism/task2">...</a>
 * через enum. Пусть Cow, Dog и Cat будут значениями enum'а Animal.
 */
public class Main {
    public static void main(String[] args) {
        Animal[] animal = new Animal[]{Animal.CAT, Animal.COW, Animal.DOG, Animal.CAT};

        soundAll(animal);
    }

    private static void soundAll(Animal[] animals) {
        for (Animal animal : animals) {
            System.out.println(animal.sound());
        }
    }

    enum Animal{
        COW("moo"),CAT("meow"),DOG("woof");
        String voice;
        Animal(String voice){
            this.voice = voice;
        };

        public String sound(){
            return this.voice;
        }
    }
}
