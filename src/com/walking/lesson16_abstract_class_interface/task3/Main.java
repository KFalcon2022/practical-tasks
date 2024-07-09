package com.walking.lesson16_abstract_class_interface.task3;

import com.walking.lesson16_abstract_class_interface.task3.model.Cat;
import com.walking.lesson16_abstract_class_interface.task3.model.Cow;
import com.walking.lesson16_abstract_class_interface.task3.model.Dog;
import com.walking.lesson16_abstract_class_interface.task3.model.ISpeaker;

/**
 * Реализуйте любую задачу из уроков о наследовании или полиморфизме с использованием новых знаний.
 * Выбирайте инструмент с умом.
 * <p>
 * В качестве задачи выбрана
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson14_polymorphism/task2">...</a>
 */
public class Main {
    public static void main(String[] args) {
    ISpeaker[] animals=new ISpeaker[6];
    animals[0]=new Cat();
    animals[1]=new Cow();
    animals[2]=new Cow();
    animals[3]=new Dog();
    animals[4]=new Dog();
    animals[5]=new Cat();
    checkAnimals(animals);
    }

    public static void checkAnimals(ISpeaker[] animals){
        for (ISpeaker x:animals){
            System.out.println(x.sound());
        }
    }
}
