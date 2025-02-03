package com.walking.lesson18_instanceof_getClass.task1_getClass.model;

public abstract class Animal {

    protected abstract void sound();

    public static void sound(Animal animal) { //первоначально метод был в мейне
        if (animal.getClass().equals(Cat.class)) {
//            ((Cat) animal).sound(); //и в мейне были такое преобразование
            // почему - я как то еще не додумался. Если сможешь - объясни, пожалуйста)
            animal.sound();
        } else if (animal.getClass().equals(Dog.class)) {
//            ((Dog) animal).sound();
            animal.sound();
        } else if (animal.getClass().equals(Cow.class)) {
//            ((Cow) animal).sound();
            animal.sound();
        } else
            System.out.println("Undefined animal");
    }
}
