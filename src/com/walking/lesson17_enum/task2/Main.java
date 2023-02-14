package com.walking.lesson17_enum.task2;

import com.walking.lesson16_abstract_class_interface.task3.model.Cat;

import java.util.Arrays;

/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson14_polymorphism/task2">...</a>
 * через enum. Пусть Cow, Dog и Cat будут значениями enum'а Animal.
 */
public class Main {
    public static void main(String[] args) {
        Animals[] animals = new Animals[]{Animals.CAT,Animals.DOG,Animals.CAT,Animals.COW,Animals.DOG};
        System.out.println(PrintSounds(animals));

    }
    private static String PrintSounds(Animals[] animals){
        String sounds = "";
        for (int i = 0; i < animals.length; i++){
            sounds += animals[i].getSound() + "\n";
        }
        return sounds;

    }
}
