package com.walking.lesson17_enum.task2;
/*
import com.walking.lesson17_enum.task2.model.Animal;
import com.walking.lesson17_enum.task2.model.Cat;
import com.walking.lesson17_enum.task2.model.Cow;
import com.walking.lesson17_enum.task2.model.Dog;
*/

/**
 * Используя новые знания, упростите реализацию задачи 2 из предыдущего урока:
 * <a href="https://telegra.ph/Nasledovanie-Klyuchevoe-slovo-extends-i-ispolzovanie-protected-Klyuchevoe-slovo-super-Privedenie-ssylochnyh-tipov-11-23">...</a>
 * Допустимо использовать метод sound() вместо woof(), meow() и moo().
 * Метод sound() допустимо сделать публичным.
 * <p>
 * Использовать отдельное поле для хранения выводимой строки — недопустимо:)
 */

/**
Реализуйте задачу https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson14_polymorphism/task2

        через enum. Пусть Cow, Dog и Cat будут значениями enum'а Animal.
*/
public class Main {
    public static void main(String[] args) {
        Animal1[] animals = new Animal1[]{Animal1.CAT, Animal1.DOG, Animal1.COW};

        soundAll(animals);
    }

    private static void soundAll(Animal1[] animals) {
        for (Animal1 animal : animals) {
            System.out.println(animal.getSound());
        }
    }
}
enum Animal1{
    DOG("Woof"),
    CAT("Meow"),
    COW("Moo");
    private String sound;
    Animal1(String sound){
        this.sound=sound;
    }
    public String getSound(){return sound;}
    }
