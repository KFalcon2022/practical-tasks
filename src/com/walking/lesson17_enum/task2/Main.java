package com.walking.lesson17_enum.task2;
import src.com.walking.lesson17_enum.task2.Animal;

public class Main {
    public static void main(String[] args) {

        Animal [] animal = new Animal[]{Animal.DOG,Animal.COW,Animal.CAT};

        //статический метод ENUM, определит животное и каждое скажет за себя

        Animal.saySomething(animal);



    }
}