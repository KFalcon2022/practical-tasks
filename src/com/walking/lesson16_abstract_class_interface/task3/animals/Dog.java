package com.walking.lesson16_abstract_class_interface.task3.animals;

public class Dog extends Animal {
    public static final String CLASS_NAME="Dog";
    public Dog(String name) {
        super(name, "Woof",CLASS_NAME);
    }
    public String getClassName() {
        return super.getClassName();
    }

    @Override
    public void getAnimalSound() {
        System.out.println(SOUND);
    }
}
