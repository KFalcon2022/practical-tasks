package com.walking.lesson17_enum.Task2;

import com.walking.lesson17_enum.Task2.model.*;

public class Main2 {
        public static void main(String[] args) {
           Animal[] animal = new Animal[]{Animal.CAT, Animal.COW, Animal.DOG} ;

            soundAll(animal);
            System.out.println(animal.getClass());
        }

        private static void soundAll(Animal[] animals) {
            for (Animal animal : animals) {
                System.out.println(animal.getSound());
            }
        }

}

